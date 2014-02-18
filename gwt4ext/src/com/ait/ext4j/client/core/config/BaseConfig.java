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
package com.ait.ext4j.client.core.config;

import com.ait.ext4j.client.core.JsObject;
import com.ait.ext4j.client.core.JsoHelper;

/**
 * Base configutation class.
 */
public class BaseConfig extends JsObject {

    public BaseConfig() {
        jsObj = JsoHelper.createObject();
    }

    public void set(Attribute property, Object value) {
        JsoHelper.setAttribute(jsObj, property.getValue(), value);
    }

    public void set(String property, Object value) {
        JsoHelper.setAttribute(jsObj, property, value);
    }

    public String get(String property) {
        return JsoHelper.getAttribute(jsObj, property);
    }

    public void set(String property, double value) {
        JsoHelper.setAttribute(jsObj, property, value);
    }

    public void set(Attribute property, double value) {
        JsoHelper.setAttribute(jsObj, property.getValue(), value);
    }

    public void set(String property, int value) {
        JsoHelper.setAttribute(jsObj, property, value);
    }

    public int getAsInt(String property) {
        return JsoHelper.getAttributeAsInt(jsObj, property);
    }

    public void set(String property, boolean value) {
        JsoHelper.setAttribute(jsObj, property, value);
    }

    public void set(Attribute property, boolean value) {
        JsoHelper.setAttribute(jsObj, property.getValue(), value);
    }

    public void set(String property, int[] value) {
        JsoHelper.setAttribute(jsObj, property, value);
    }

    public int[] getAsIntArray(String property) {
        return JsoHelper.getAttributeAsIntArray(jsObj, property);
    }

    public void set(String property, String[] value) {
        JsoHelper.setAttribute(jsObj, property, value);
    }

    public String[] getAsStringArray(String property) {
        return JsoHelper.getAttributeAsStringArray(jsObj, property);
    }

    public void set(String property, BaseConfig value) {
        JsoHelper.setAttribute(jsObj, property, value.getJsObj());
    }

    public Object getAsObject(String property) {
        return JsoHelper.getAttributeAsObject(jsObj, property);
    }
}
