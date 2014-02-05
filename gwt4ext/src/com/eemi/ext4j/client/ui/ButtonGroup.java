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
package com.eemi.ext4j.client.ui;

import com.eemi.ext4j.client.core.Component;
import com.eemi.ext4j.client.core.config.XType;
import com.eemi.ext4j.client.layout.ContainerLayout;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;

/**
 * Provides a container for arranging a group of related Buttons in a tabular
 * manner
 */
public class ButtonGroup extends Panel {

    private static JavaScriptObject configPrototype;

    private native void init()/*-{
		var c = new $wnd.Ext.container.ButtonGroup();
		@com.eemi.ext4j.client.ui.ButtonGroup::configPrototype = c.initialConfig;
    }-*/;

    protected JavaScriptObject getConfigPrototype() {
        return configPrototype;
    }

    public String getXType() {
        return XType.BUTTON_GROUP.getValue();
    }

    /**
     * Create a new NotificationContainer.
     */
    public ButtonGroup() {

    }

    public ButtonGroup(ContainerLayout layout) {
        setLayout(layout);
    }

    /**
     * Construct a new ButtonGroup with the given title.
     * 
     * @param title
     *            the title
     */
    public ButtonGroup(String title) {
        setTitle(title);
    }

    /**
     * Construct a new ButtonGroup with the given title and layout
     * 
     * @param title
     *            the title
     * @param layout
     *            the layout
     */
    public ButtonGroup(String title, ContainerLayout layout) {
        this(title);
        setLayout(layout);
    }

    public ButtonGroup(String title, String html) {
        setTitle(title);
        setHtml(html);
    }

    public ButtonGroup(String title, int width, int height) {
        setTitle(title);
        setWidth(width);
        setHeight(height);
    }

    protected ButtonGroup(JavaScriptObject jsObj) {
        super(jsObj);
    }

    /**
     * Applys the NotificationContainer to an existing element.
     * 
     * @param element
     *            the element
     */
    public ButtonGroup(Element element) {
        super(element);
    }

    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.container.ButtonGroup(config);
    }-*/;

    /**
     * The columns configuration property passed to the configured layout
     * manager.
     * 
     * @param value
     *            , the column value
     */
    public void setColumns(int value) {
        setAttribute("columns", value, true);
    }

    /**
     * Creates a new ButtonGroup from the given component
     * 
     * @param component
     *            , the component to cast from
     * @return, a new buttonGroup from the component
     * 
     */
    public static ButtonGroup cast(Component component) {
        return new ButtonGroup(component.getOrCreateJsObj());
    }

}
