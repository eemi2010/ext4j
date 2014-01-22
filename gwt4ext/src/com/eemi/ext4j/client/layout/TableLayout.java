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
 * This layout allows you to easily render content into an HTML table. The total
 * number of columns can be specified, and rowspan and colspan can be used to
 * create complex layouts within the table. This class is intended to be
 * extended or created via the layout: {type: 'table'}
 * Ext.container.Container.layout config, and should generally not need to be
 * created directly via the new keyword.
 * 
 * The basic concept of building up a TableLayout is conceptually very similar
 * to building up a standard HTML table. You simply add each panel (or "cell")
 * that you want to include along with any span attributes specified as the
 * special config properties of rowspan and colspan which work exactly like
 * their HTML counterparts. Rather than explicitly creating and nesting rows and
 * columns as you would in HTML, you simply specify the total column count in
 * the layout config and start adding panels in their natural order from left to
 * right, top to bottom. The layout will automatically figure out, based on the
 * column count, rowspans and colspans, how to position each panel within the
 * table. Just like with HTML tables, your rowspans and colspans must add up
 * correctly in your overall layout or you'll end up with missing and/or extra
 * cells!
 */
public class TableLayout extends ContainerLayout {

    public TableLayout() {
    }

    public TableLayout(int columns) {
        this();
        setColumns(columns);
    }

    protected TableLayout(JavaScriptObject obj) {
        jsObj = obj;
    }

    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		var jso = {
			type : 'table'
		};
		this.@com.eemi.ext4j.client.layout.ContainerLayout::jsObj = jso;
		return this.@com.eemi.ext4j.client.layout.ContainerLayout::jsObj;
    }-*/;

    /**
     * The total number of columns to create in the table for this layout. If
     * not specified, all Components added to this layout will be rendered into
     * a single row using one column per Component.
     */
    public void setColumns(int cols) {
        JsoHelper.setAttribute(jsObj, "columns", cols);
    }

    public static TableLayout cast(ContainerLayout layout) {
        return new TableLayout(layout.getJsObj());
    }

    @Override
    protected native void create() /*-{
		var jso = {
			type : 'table'
		};
		this.@com.eemi.ext4j.client.layout.ContainerLayout::jsObj = jso;
    }-*/;

}
