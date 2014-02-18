/**
 * Ext4j UI Library Copyright 2014, Alain Ekambi, and individual contributors as
 * indicated by the @authors tag. See the copyright.txt in the distribution for
 * a full listing of individual contributors.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.ati.ext4j.rebind;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;

import com.ati.ext4j.client.template.Template;
import com.ati.ext4j.client.template.TemplateResource;
import com.google.gwt.core.ext.Generator;
import com.google.gwt.core.ext.GeneratorContext;
import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.core.ext.TreeLogger.Type;
import com.google.gwt.core.ext.UnableToCompleteException;
import com.google.gwt.core.ext.typeinfo.JClassType;
import com.google.gwt.core.ext.typeinfo.NotFoundException;
import com.google.gwt.core.ext.typeinfo.TypeOracle;
import com.google.gwt.dev.resource.Resource;
import com.google.gwt.dev.util.Name;
import com.google.gwt.dev.util.Util;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.user.rebind.ClassSourceFileComposerFactory;
import com.google.gwt.user.rebind.SourceWriter;

/**
 * Generator class for Templates
 */
public class TemplateGenerator extends Generator {

    private static final String TEMPLATE_SUFFIX = ".html";
    private JClassType templatesInterface;

    /**
     * Given a TemplateResource interface, return the path to its .html file,
     * suitable for any classloader to find it as a resource. If the .html does
     * not exist or is empty see if the template was declared inline. If no
     * content is found we throw an exception.
     */
    private String getTemplateContent(GeneratorContext context, TreeLogger logger, JClassType interfaceType)
                    throws UnableToCompleteException {
        String templateHtmlFile = null;

        TemplateResource annotation = interfaceType.getAnnotation(TemplateResource.class);
        if (annotation == null) {
            // if the interface is defined as a nested class, use the name of
            // the
            // enclosing type
            if (interfaceType.getEnclosingType() != null) {
                interfaceType = interfaceType.getEnclosingType();
            }
            templateHtmlFile = slashify(interfaceType.getQualifiedBinaryName()) + TEMPLATE_SUFFIX;
            logger.log(TreeLogger.INFO, "Template : " + templateHtmlFile);

            InputStream stream = getTemplateResource(context, logger, templateHtmlFile);
            if (stream == null) {
                logger.log(Type.ERROR,
                                "No data could be loaded - no data at path " + interfaceType.getQualifiedBinaryName()
                                                + TEMPLATE_SUFFIX);
                throw new UnableToCompleteException();
            }
            return sanitize(Util.readStreamAsString(stream));

        } else {
            // first we look at the HTML File
            templateHtmlFile = annotation.source();

            if (templateHtmlFile.length() > 0) {

                if (!templateHtmlFile.endsWith(TEMPLATE_SUFFIX)) {
                    logger.log(TreeLogger.ERROR, "Template file name must end with " + TEMPLATE_SUFFIX);
                    throw new UnableToCompleteException();
                }

                if (annotation.value().length() != 0) {
                    logger.log(Type.WARN, "Found both source file and inline template, using source file");
                }

                templateHtmlFile = slashify(interfaceType.getPackage().getName()) + "/" + templateHtmlFile;
                InputStream stream = getTemplateResource(context, logger, templateHtmlFile);
                return sanitize(Util.readStreamAsString(stream));

            } else if (annotation.value().length() > 0) {
                return annotation.value();
            } else {
                logger.log(Type.ERROR,
                                "Template annotation found with no contents, cannot generate method , this may cause other failures.");
            }

        }
        return null;
    }

    private static String slashify(String s) {
        return s.replace(".", "/").replace("$", ".");
    }

    private static String sanitize(String input) {
        return input.replace("\n", "").replace("'", "\\'").replace("\"", "\\\"");
    }

    @Override
    public String generate(TreeLogger logger, GeneratorContext context, String typeName)
                    throws UnableToCompleteException {
        TypeOracle oracle = context.getTypeOracle();
        this.templatesInterface = oracle.findType(Name.getSourceNameForClass(Template.class));

        JClassType interfaceType;
        try {
            interfaceType = oracle.getType(typeName);
        } catch (NotFoundException e) {
            throw new RuntimeException(e);
        }

        if (interfaceType.isInterface() == null) {
            logger.log(TreeLogger.ERROR, typeName + " is not an interface type");
            throw new UnableToCompleteException();
        }
        if (!interfaceType.isAssignableTo(templatesInterface)) {
            logger.log(Type.ERROR, "This isn't a Template subtype...");
            throw new UnableToCompleteException();
        }

        String content = getTemplateContent(context, logger, interfaceType);
        String packageName = interfaceType.getPackage().getName();
        String className = "Template_For_" + interfaceType.getQualifiedSourceName().replace(".", "_");

        ClassSourceFileComposerFactory composer = new ClassSourceFileComposerFactory(packageName, className);
        composer.addImport(SafeHtml.class.getName());
        composer.addImport(SafeHtmlUtils.class.getName());
        composer.addImplementedInterface(Template.class.getName());

        PrintWriter pw = context.tryCreate(logger, packageName, className);
        SourceWriter sw = composer.createSourceWriter(context, pw);

        sw.println("  public SafeHtml getContent(){");
        sw.println("      return SafeHtmlUtils.fromSafeConstant(\"" + content + "\");");
        sw.println("  }");
        sw.println("");
        sw.println("");
        sw.println("  public SafeHtml getSafeContent(){");
        sw.println("      return SafeHtmlUtils.fromString(\"" + content + "\");");
        sw.println("  }");

        sw.commit(logger);
        return composer.getCreatedClassName();

    }

    protected InputStream getTemplateResource(GeneratorContext context, TreeLogger l, String markerPath)
                    throws UnableToCompleteException {
        // look for a local file first
        String path = slashify(markerPath);
        l.log(Type.INFO, "Current resource path : " + markerPath);
        Resource res = context.getResourcesOracle().getResourceMap().get(path);
        // if not a local path, try an absolute one
        if (res == null) {
            l.log(Type.INFO, "Resource is Null trying with URL ");
            URL url = Thread.currentThread().getContextClassLoader().getResource(markerPath);
            if (url == null) {
                l.log(Type.INFO, "URL seems to be null here ... hmmmmss");
                return null;
            }
            try {
                return url.openStream();
            } catch (IOException e) {
                l.log(Type.ERROR, "IO Exception occured", e);
                throw new UnableToCompleteException();
            }
        }
        try {
            return res.openContents();
        } catch (Exception e) {
            l.log(Type.ERROR, "Exception occured reading " + path, e);
            throw new UnableToCompleteException();
        }
    }

}
