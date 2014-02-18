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
package com.ait.ext4j.client.core;

import java.util.Date;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * A generic class used a various places that represents a name / value pair.
 */
public class NameValuePair extends JsObject {

    public static final int STRING = 0;
    public static final int BOOLEAN = 1;
    public static final int FLOAT = 2;
    public static final int INT = 3;
    public static final int DATE = 4;

    private int type = STRING;
    private static final String NAME = "name";
    private static final String VALUE = "value";

    public NameValuePair(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public NameValuePair(String name, String value) {
        jsObj = JsoHelper.createObject();
        JsoHelper.setAttribute(jsObj, NAME, name);
        JsoHelper.setAttribute(jsObj, VALUE, value);
        type = STRING;
    }

    public NameValuePair(String name, Boolean value) {
        this(name, value.booleanValue());
    }

    public NameValuePair(String name, boolean value) {
        jsObj = JsoHelper.createObject();
        JsoHelper.setAttribute(jsObj, NAME, name);
        JsoHelper.setAttribute(jsObj, VALUE, value);
        type = BOOLEAN;
    }

    public NameValuePair(String name, Float value) {
        this(name, value.floatValue());

    }

    public NameValuePair(String name, float value) {
        jsObj = JsoHelper.createObject();
        JsoHelper.setAttribute(jsObj, NAME, name);
        JsoHelper.setAttribute(jsObj, VALUE, value);
        type = FLOAT;
    }

    public NameValuePair(String name, Integer value) {
        this(name, value.intValue());
    }

    public NameValuePair(String name, int value) {
        jsObj = JsoHelper.createObject();
        JsoHelper.setAttribute(jsObj, NAME, name);
        JsoHelper.setAttribute(jsObj, VALUE, value);
        type = INT;
    }

    public NameValuePair(String name, Date value) {
        jsObj = JsoHelper.createObject();
        JsoHelper.setAttribute(jsObj, NAME, name);
        JsoHelper.setAttribute(jsObj, VALUE, value);
        type = DATE;
    }

    public static NameValuePair instance(String name, String value) {
        return new NameValuePair(name, value);
    }

    public String getName() {
        return JsoHelper.getAttribute(jsObj, NAME);
    }

    public String getValue() {
        return JsoHelper.getAttribute(jsObj, VALUE);
    }

    public boolean getValueAsBoolean() {
        return JsoHelper.getAttributeAsBoolean(jsObj, VALUE);
    }

    public float getValueAsFloat() {
        return JsoHelper.getAttributeAsFloat(jsObj, VALUE);
    }

    public int getValueAsInt() {
        return JsoHelper.getAttributeAsInt(jsObj, VALUE);
    }

    public Date getValueAsDate() {
        return JsoHelper.getAttributeAsDate(jsObj, VALUE);
    }

    public int getType() {
        return type;
    }

    public static JavaScriptObject getJsObj(NameValuePair[] nameValuePairs) {
        JavaScriptObject paramObj = JsoHelper.createObject();
        if (nameValuePairs == null)
            return paramObj;

        for (int i = 0; i < nameValuePairs.length; i++) {
            NameValuePair param = nameValuePairs[i];
            switch (param.getType()) {
            case STRING: {
                JsoHelper.setAttribute(paramObj, param.getName(), param.getValue());
                break;
            }
            case BOOLEAN: {
                JsoHelper.setAttribute(paramObj, param.getName(), param.getValueAsBoolean());
                break;
            }
            case FLOAT: {
                JsoHelper.setAttribute(paramObj, param.getName(), param.getValueAsFloat());
                break;
            }
            case INT: {
                JsoHelper.setAttribute(paramObj, param.getName(), param.getValueAsInt());
                break;
            }
            case DATE: {
                JsoHelper.setAttribute(paramObj, param.getName(), param.getValueAsDate());
                break;
            }
            default: {
                JsoHelper.setAttribute(paramObj, param.getName(), param.getValue());
            }
            }
        }
        return paramObj;
    }
}
