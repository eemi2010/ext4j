/**
 Ext4j UI Library
 Copyright 2014, Alain Ekambi, and individual contributors as indicated
 by the @authors tag. See the copyright.txt in the distribution for a
 full listing of individual contributors.

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */
package com.ait.ext4j.client.data;

import com.ait.ext4j.client.core.JsoHelper;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * Field that represents String data.
 */
public class StringFieldDefinition extends FieldDefinition {

    /**
     * Construct a new StringFieldDefinition.
     * 
     * @param name
     *            the name of field
     */
    public StringFieldDefinition(String name) {
        this(name, null, null);
    }

    /**
     * Construct a new StringFieldDefinition.
     * 
     * @param name
     *            the name of field
     * @param mapping
     *            the field mapping. Depending on the Reader used, mapping could
     *            be the array index position or an XPath expression when
     *            reading from XML
     */
    public StringFieldDefinition(String name, String mapping) {
        this(name, mapping, null);
    }

    /**
     * Construct a new StringFieldDefinition.
     * 
     * @param name
     *            the name of field
     * @param mapping
     *            the field mapping. Depending on the Reader used, mapping could
     *            be the array index position or an XPath expression when
     *            reading from XML
     */
    public StringFieldDefinition(String name, int mapping) {
        this(name, mapping, null);
    }

    /**
     * Construct a new StringFieldDefinition.
     * 
     * @param name
     *            the field name
     * @param mapping
     *            the field mapping. Depending on the Reader used, mapping could
     *            be the array index position or an XPath expression when
     *            readinf from XML
     * @param converter
     *            format the incoming data before processing it
     */
    public StringFieldDefinition(String name, String mapping, Converter converter) {
        jsObj = create(name, mapping, converter);
    }

    /**
     * Construct a new StringFieldDefinition.
     * 
     * @param name
     *            the field name
     * @param mapping
     *            the field mapping. Depending on the Reader used, mapping could
     *            be the array index position or an XPath expression when
     *            reading from XML
     * @param converter
     *            format the incoming data before processing it
     */
    public StringFieldDefinition(String name, int mapping, Converter converter) {
        this(name, String.valueOf(mapping), converter);
    }

    private static JavaScriptObject create(String name, String mapping, Converter converter) {
        JavaScriptObject jsObj = JsoHelper.createObject();
        JsoHelper.setAttribute(jsObj, "name", name);
        JsoHelper.setAttribute(jsObj, "type", "string");
        if (mapping != null)
            JsoHelper.setAttribute(jsObj, "mapping", mapping);
        if (converter != null)
            setConverter(jsObj, converter);
        return jsObj;
    }
}
