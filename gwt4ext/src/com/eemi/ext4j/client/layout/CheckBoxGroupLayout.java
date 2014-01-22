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
package com.eemi.ext4j.client.layout;

import com.eemi.ext4j.client.core.JsoHelper;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * This layout implements the column arrangement for Ext.form.CheckboxGroup and
 * Ext.form.RadioGroup. It groups the component's sub-items into columns based
 * on the component's columns and Ext.form.CheckboxGroup.vertical config
 * properties.
 */
public class CheckBoxGroupLayout extends ContainerLayout {

    public CheckBoxGroupLayout() {
    }

    protected CheckBoxGroupLayout(JavaScriptObject obj) {
        jsObj = obj;
    }

    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return {
			type : 'checkboxgroup'
		};
    }-*/;

    @Override
    protected native void create() /*-{
		var jso = {
			type : 'checkboxgroup'
		};
		this.@com.eemi.ext4j.client.layout.ContainerLayout::jsObj = jso;
    }-*/;

    /**
     * By default, CheckboxGroup allocates all available space to the configured
     * columns meaning that column are evenly spaced across the container.
     * 
     * To have each column only be wide enough to fit the container Checkboxes
     * (or Radios), set autoFlex to false
     * 
     * Defaults to: true
     * 
     * @param value
     */
    public void setAutoFlex(boolean value) {
        JsoHelper.setAttribute(this.getJsObj(), "autoFlex", value);
    }

    public static CheckBoxGroupLayout cast(ContainerLayout layout) {
        return new CheckBoxGroupLayout(layout.getJsObj());
    }

}
