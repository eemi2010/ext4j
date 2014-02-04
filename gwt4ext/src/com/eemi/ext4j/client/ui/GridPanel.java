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

import java.util.Arrays;
import java.util.List;

import com.eemi.ext4j.client.core.Component;
import com.eemi.ext4j.client.core.config.XType;
import com.eemi.ext4j.client.data.Store;
import com.eemi.ext4j.client.grid.column.GridColumn;
import com.eemi.ext4j.client.grid.plugin.AbstractViewPlugin;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

/**
 * Grids are an excellent way of showing large amounts of tabular data on the
 * client side. Essentially a supercharged table , GridPanel makes it easy to
 * fetch, sort and filter large amounts of data.
 * 
 * Grids are composed of two main pieces - a Store full of data and a set of
 * columns to render.
 * 
 */
public class GridPanel extends TablePanel {

    private static JavaScriptObject configPrototype;
    private static int gridId = 0;
    private AbstractViewPlugin dd;

    private native void init()/*-{
		var c = new $wnd.Ext.grid.Panel();
		@com.eemi.ext4j.client.ui.GridPanel::configPrototype = c.initialConfig;
    }-*/;

    protected JavaScriptObject getConfigPrototype() {
        return configPrototype;
    }

    public String getXType() {
        return XType.GRID_PANEL.getValue();
    }

    protected GridPanel() {

    }

    private GridPanel(AbstractViewPlugin dd) {
        this.dd = dd;
    }

    protected GridPanel(JavaScriptObject obj) {
        super(obj);
    }

    public GridPanel(String title, Store store, List<GridColumn> columns) {
        this();
        setTitle(title);
        setStore(store);
        setColumns(columns);
    }

    public GridPanel(String title, Store store) {
        this();
        setTitle(title);
        setStore(store);
    }

    public GridPanel(Store store) {
        this();
        setStore(store);
    }

    public GridPanel(Store store, List<GridColumn> columns) {
        this();
        setStore(store);
        setColumns(columns);
    }

    public GridPanel(Store store, GridColumn... columns) {
        this();
        setStore(store);
        setColumns(Arrays.asList(columns));
    }

    public GridPanel(String title, Store store, GridColumn... columns) {
        this();
        setTitle(title);
        setStore(store);
        setColumns(Arrays.asList(columns));
    }

    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.grid.Panel(config);
    }-*/;

    /**
     * Reconfigures the grid with a new store/columns. Either the store or the
     * columns can be omitted if you don't wish to change them.
     */
    public void reconfigure(Store store, List<GridColumn> columns) {
        _reconfigure(store.getJsObj(), GridColumn.fromList(columns));
    }

    /**
     * Reconfigures the grid with a new store/columns. Either the store or the
     * columns can be omitted if you don't wish to change them.
     */
    public void reconfigure(Store store, GridColumn... columns) {
        _reconfigure(store.getJsObj(), GridColumn.fromList(Arrays.asList(columns)));
    }

    /**
     * Render the internal column collection
     */
    @Override
    public void renderColumns() {
        JsArray<JavaScriptObject> jsos = JsArray.createArray().cast();
        for (GridColumn cols : this.columns) {
            jsos.push(cols.getJsObj());
        }
        setAttribute("columns", jsos, true, true);
    }

    /**
     * Creates a new GridPanel from the given component
     * 
     * @param component
     *            , the component to cast from
     * @return, a new GridPanel from the component
     * 
     */
    public static GridPanel cast(Component component) {
        return new GridPanel(component.getOrCreateJsObj());
    }

    private native void _reconfigure(JavaScriptObject store, JavaScriptObject cols)/*-{
		var grid = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		grid.reconfigure(store, cols);
    }-*/;

    // TODO
    // Reconfigure events

}
