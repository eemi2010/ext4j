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
package com.ait.ext4j.client.ui;

import com.ait.ext4j.client.core.Component;
import com.ait.ext4j.client.core.config.XType;
import com.ait.ext4j.client.data.BaseModel;
import com.ait.ext4j.client.grid.plugin.AbstractViewPlugin;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * Grids are an excellent way of showing large amounts of tabular data on the
 * client side. Essentially a supercharged table , GridPanel makes it easy to
 * fetch, sort and filter large amounts of data.
 * 
 * Grids are composed of two main pieces - a Store full of data and a set of
 * columns to render.
 * 
 */
public class PropertyGridPanel extends GridPanel {

    private static JavaScriptObject configPrototype;
    private static int gridId = 0;
    private AbstractViewPlugin dd;
    private BaseModel source;

    private native void init()/*-{
		var c = new $wnd.Ext.property.Grid();
		@com.ait.ext4j.client.ui.PropertyGridPanel::configPrototype = c.initialConfig;
    }-*/;

    protected JavaScriptObject getConfigPrototype() {
        return configPrototype;
    }

    public String getXType() {
        return XType.PROPERTY_GRID.getValue();
    }

    public PropertyGridPanel() {

    }

    public PropertyGridPanel(String title) {
        this();
        setTitle(title);
    }

    public PropertyGridPanel(BaseModel source) {
        this();
        setSource(source);
    }

    public PropertyGridPanel(String title, BaseModel source) {
        this(title);
        setSource(source);
    }

    protected PropertyGridPanel(JavaScriptObject obj) {
        super(obj);
    }

    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		var dd = this.@com.ait.ext4j.client.ui.GridPanel::dd;
		if (dd) {
			var peer = dd.@com.ait.ext4j.client.core.JsObject::getJsObj()();
			var vc = config.ViewConfig;
			if (vc) {
				vc.plugins = peer;
			} else {
				config.viewConfig = {
					plugins : peer
				};
			}
		}
		config.source = {

		}
		return new $wnd.Ext.grid.property.Grid(config);
    }-*/;

    /**
     * Creates a new PropertyGridPanel from the given component
     * 
     * @param component
     *            , the component to cast from
     * @return, a new PropertyGridPanel from the component
     * 
     */
    public static PropertyGridPanel cast(Component component) {
        return new PropertyGridPanel(component.getOrCreateJsObj());
    }

    /**
     * Gets the source data object containing the property data. The data object
     * can contain one or more name/value pairs representing all of the
     * properties of an object to display in the grid, and this data will
     * automatically be loaded into the grid's store. The values should be
     * supplied in the proper data type if needed, otherwise string type will be
     * assumed. If the grid already contains data, this method will replace any
     * existing data.
     */
    public void setSource(BaseModel source) {
        this.source = source;
        _setSource(source);
    }

    /**
     * Specify the width for the name column. The value column will take any
     * remaining space.
     * <p>
     * Defaults to: 115
     * 
     * @param value
     */
    public void setNameColumnWidth(String value) {
        setAttribute("nameColumnWidth", value, true);
    }

    /**
     * The name of the field from the property store to use as the property
     * field name. This may be useful if you do not configure the property Grid
     * from an object, but use your own store configuration.
     * <p>
     * Defaults to: "name"
     */
    public void setNameField(String value) {
        setAttribute("nameField", value, true);
    }

    /**
     * The name of the field from the property store to use as the value field
     * name. This may be useful if you do not configure the property Grid from
     * an object, but use your own store configuration.
     * 
     * Defaults to: "value"
     */
    public void setValueField(String value) {
        setAttribute("valueField", value, true);
    }

    private native void _setSource(BaseModel source)/*-{
		var jso = this.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()();
		jso
				.setSource(source.@com.ait.ext4j.client.core.JsObject::getJsObj()());
    }-*/;

    public BaseModel getSource() {
        return this.source;
    }

    public void updateSource() {
        this.setSource(this.source);
    }

    // TODO Add Listeners

}
