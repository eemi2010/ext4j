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
package com.ait.ext4j.client.ui;

import com.ait.ext4j.client.core.Component;
import com.ait.ext4j.client.core.config.Dock;
import com.ait.ext4j.client.core.config.XType;
import com.ait.ext4j.client.layout.ContainerLayout;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;

/**
 * Basic Toolbar class. Although the defaultType for Toolbar is button, Toolbar
 * elements (child items for the Toolbar container) may be virtually any type of
 * Component. Toolbar elements can be created explicitly via their constructors,
 * or implicitly via their xtypes, and can be added dynamically.
 */
// TODO add Events
public class ToolBar extends Container {

    private static JavaScriptObject configPrototype;

    private native void init()/*-{
		var c = new $wnd.Ext.toolbar.Toolbar();
		@com.ait.ext4j.client.ui.ToolBar::configPrototype = c.initialConfig;
    }-*/;

    protected JavaScriptObject getConfigPrototype() {
        return configPrototype;
    }

    public String getXType() {
        return XType.TOOLBAR.getValue();
    }

    /**
     * Create a new NotificationContainer.
     */
    public ToolBar() {
        // init();
        setDocked(Dock.TOP);
    }

    public ToolBar(ContainerLayout layout) {
        setLayout(layout);
    }

    public ToolBar(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public ToolBar(Dock dock) {
        this();
        setDocked(dock);
    }

    public void setVertical(boolean value) {
        setAttribute("vertial", value, true);
    }

    /**
     * Applys the NotificationContainer to an existing element.
     * 
     * @param element
     *            the element
     */
    public ToolBar(Element element) {
        super(element);
    }

    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.toolbar.Toolbar(config);
    }-*/;

    public static ToolBar cast(Component component) {
        return new ToolBar(component.getOrCreateJsObj());
    }

}
