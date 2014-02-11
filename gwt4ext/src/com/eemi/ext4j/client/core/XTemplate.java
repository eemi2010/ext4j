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
package com.eemi.ext4j.client.core;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * A template class that supports advanced functionality like:
 * 
 * Autofilling arrays using templates and sub-templates Conditional processing
 * with basic comparison operators Basic math function support Execute arbitrary
 * inline code with special built-in template variables Custom member functions
 * Many special tags and built-in operators that aren't defined as part of the
 * API, but are supported in the templates that can be created
 * 
 */
public class XTemplate extends Template {

    private String html;

    /**
     * Create a new Template.
     * 
     * @param html
     *            the HTML fragment
     */
    public XTemplate(String html) {
        this(html, false);
    }

    /**
     * Create a new Template.
     * 
     * @param html
     *            the HTML fragment
     */
    public XTemplate(String html, boolean replaceSingleQuote) {
        if (replaceSingleQuote) {
            jsObj = create(html.replaceAll("'", "\""));
        } else {
            jsObj = create(html);
        }

        this.html = html;
    }

    protected XTemplate(JavaScriptObject jsObj) {
        super(jsObj);
    }

    /**
     * Create a new Template.
     * 
     * @param htmlfrags
     *            the HTML fragments
     */

    public XTemplate(String... htmlfrags) {
        this(false, htmlfrags);
    }

    /**
     * Create a new Template.
     * 
     * @param htmlfrags
     *            the HTML fragments
     */

    public XTemplate(boolean replaceSingleQuote, String... htmlfrags) {
        String htmlfrag = "";
        for (int i = 0; i < htmlfrags.length; i++) {
            htmlfrag += htmlfrags[i];
        }
        if (replaceSingleQuote) {
            html = htmlfrag.replaceAll("'", "\"");
        } else {
            html = htmlfrag;
        }

        jsObj = create(html);
    }

    public String getHtml() {
        return html;
    }

    private static XTemplate instance(JavaScriptObject jsObj) {
        return new XTemplate(jsObj);
    }

    private native JavaScriptObject create(String html) /*-{
		return new $wnd.Ext.XTemplate(html);
    }-*/;

    public native JavaScriptObject create(JavaScriptObject htmlfrags) /*-{
		return new $wnd.Ext.XTemplate.apply($wnd.Ext.XTemplate.create,
				htmlfrags);
    }-*/;

}
