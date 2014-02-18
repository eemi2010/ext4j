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
package com.ati.ext4j.client.ui;

import com.ati.ext4j.client.core.Component;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * A simple class that renders text directly into a toolbar.
 */
public class ToolBarText extends Component {

    private static JavaScriptObject configPrototype;

    private native void init()/*-{
		var c = new $wnd.Ext.toolbar.TextItem();
		@com.ati.ext4j.client.ui.ToolBarText::configPrototype = c.initialConfig;
    }-*/;

    protected JavaScriptObject getConfigPrototype() {
        return configPrototype;
    }

    public ToolBarText() {
    }

    public ToolBarText(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public ToolBarText(String text) {
        this();
        this.setText(text);
    }

    public String getXType() {
        return "tbtext";
    }

    @Override
    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.toolbar.TextItem(config);
    }-*/;

    /**
     * Updates this item's text, setting the text to be used as innerHTML.
     */
    public native void setText(String value)/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		component.setText(value);
    }-*/;

    public static ToolBarText cast(Component component) {
        return new ToolBarText(component.getOrCreateJsObj());
    }

}
