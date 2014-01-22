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
package com.eemi.ext4j.client.ui;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * A field container which has a specialized layout for arranging
 * Ext.form.field.Radio controls into columns, and provides convenience
 * Ext.form.field.Field methods for getting, setting, and validating the group
 * of radio buttons as a whole.
 */
public class RadioGroup extends CheckboxGroup {

    private static JavaScriptObject configPrototype;

    private static native void doInit()/*-{
		var c = new $wnd.Ext.form.RadioGroup();
		@com.eemi.ext4j.client.ui.RadioGroup::configPrototype = c.initialConfig;
    }-*/;

    protected JavaScriptObject getConfigPrototype() {
        return configPrototype;
    }

    public String getXType() {
        return "radiogroup";
    }

    /**
     * Create a new FieldContainer.
     */
    public RadioGroup() {
    }

    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.form.RadioGroup(config);
    }-*/;

}
