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
package com.eemi.ext4j.client.data;

import com.eemi.ext4j.client.core.JsoHelper;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * Field that represents boolean data.
 */
public class BooleanFieldDefinition extends FieldDefinition {

    /**
     * Construct a new BooleanFieldDefinition.
     * 
     * @param name
     *            the name of field
     */
    public BooleanFieldDefinition(String name) {
        this(name, null, null);
    }

    public BooleanFieldDefinition(String name, String mapping) {
        this(name, mapping, null);
    }

    public BooleanFieldDefinition(String name, int mapping) {
        this(name, mapping, null);
    }

    public BooleanFieldDefinition(String name, int mapping, Converter converter) {
        this(name, String.valueOf(mapping), converter);
    }

    public BooleanFieldDefinition(String name, String mapping, Converter converter) {
        jsObj = create(name, mapping, converter);
    }

    private static JavaScriptObject create(String name, String mapping, Converter converter) {
        JavaScriptObject jsObj = JsoHelper.createObject();
        JsoHelper.setAttribute(jsObj, "name", name);
        JsoHelper.setAttribute(jsObj, "type", "bool");
        if (mapping != null)
            JsoHelper.setAttribute(jsObj, "mapping", mapping);
        if (converter != null)
            setConverter(jsObj, converter);
        return jsObj;
    }
}
