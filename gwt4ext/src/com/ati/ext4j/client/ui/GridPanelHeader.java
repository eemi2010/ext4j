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
package com.ati.ext4j.client.ui;

import com.ati.ext4j.client.core.Component;
import com.ati.ext4j.client.core.config.XType;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * Simple header class which is used for on {@link NotificationContainer} and {@link Window}
 * 
 * @author alainekambi
 * 
 */
public class GridPanelHeader extends Container {

    private static JavaScriptObject configPrototype;

    protected JavaScriptObject getConfigPrototype() {
        return configPrototype;
    }

    public String getXType() {
        return XType.HEADER_CONTAINER.getValue();
    }

    /**
     * Create a new NotificationContainer.
     */
    protected GridPanelHeader() {
    }

    protected GridPanelHeader(JavaScriptObject obj) {
        super(obj);
    }

    public GridPanelHeader(String type) {
        this();
    }

    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.panel.Header(config);
    }-*/;

    /**
     * Add a tool to the header
     */
    public native void addTool(Tool value)/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		component
				.addTool(value.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()());

    }-*/;

    /**
     * Sets the CSS class that provides the icon image for this header. This
     * method will replace any existing icon class if one has already been set.
     * 
     * @param value
     *            , the new CSS class name
     */
    public native void setIcon(String value)/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		component.setIcon(value);
    }-*/;

    /**
     * Sets the title of the header.
     * 
     * @param title
     *            , the title to be set
     */
    public native void setTitle(String title)/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		component.seTitle(title);
    }-*/;

    /**
     * Creates a new Tool from the given component
     * 
     * @param component
     *            , the component to cast from
     * @return, a new tool from the component
     * 
     */
    public static GridPanelHeader cast(Component component) {
        return new GridPanelHeader(component.getOrCreateJsObj());
    }

}
