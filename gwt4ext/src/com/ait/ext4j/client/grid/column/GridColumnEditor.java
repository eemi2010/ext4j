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
package com.ait.ext4j.client.grid.column;

import com.ait.ext4j.client.core.JsoHelper;
import com.ait.ext4j.client.core.config.Attribute;
import com.ait.ext4j.client.core.config.BaseConfig;
import com.ait.ext4j.client.core.config.XType;
import com.ait.ext4j.client.ui.VTypes;
import com.google.gwt.core.client.JavaScriptObject;

public class GridColumnEditor extends BaseConfig {

    protected GridColumnEditor(JavaScriptObject obj) {
        jsObj = obj;
    }

    public GridColumnEditor() {
        jsObj = JsoHelper.createObject();
    }

    public GridColumnEditor(XType xtype) {
        this();
        setXType(xtype);
    }

    public GridColumnEditor(boolean allowBlank) {
        this();
        setAllowBlank(allowBlank);
    }

    /**
     * The type of the filter
     * 
     * @param value
     */
    public void setXType(XType value) {
        JsoHelper.setAttribute(jsObj, Attribute.XTYPE.getValue(), value.getValue());
    }

    public void setAllowBlank(boolean value) {
        JsoHelper.setAttribute(jsObj, "allowBlank", value);
    }

    public void setVType(String value) {
        JsoHelper.setAttribute(jsObj, "vType", value);
    }

    public void setVType(VTypes value) {
        JsoHelper.setAttribute(jsObj, "vType", value.getVType());
    }

}
