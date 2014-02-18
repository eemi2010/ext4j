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
package com.ati.ext4j.client.grid;

import com.ati.ext4j.client.core.Component;
import com.ati.ext4j.client.core.config.XType;
import com.ati.ext4j.client.grid.column.GridColumn;
import com.ati.ext4j.client.ui.Container;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * Container which holds headers and is docked at the top or bottom of a
 * TablePanel. The HeaderContainer drives resizing/moving/hiding of columns
 * within the TableView. As headers are hidden, moved or resized the
 * headercontainer is responsible for triggering changes within the view.
 */
public class HeaderContainer extends Container {

    private static JavaScriptObject configPrototype;

    protected JavaScriptObject getConfigPrototype() {
        return configPrototype;
    }

    public String getXType() {
        return XType.HEADER_CONTAINER.getValue();
    }

    protected HeaderContainer() {
    }

    protected HeaderContainer(JavaScriptObject obj) {
        super(obj);
    }

    /**
     * True if this HeaderContainer is in fact a group header which contains sub
     * headers.
     */
    public boolean isGroupHeader() {
        return getAttributeAsBoolean("isGroupHeader");
    }

    /**
     * Returns the number of grid columns descended from this HeaderContainer.
     * Group Columns are HeaderContainers. All grid columns are returned,
     * including hidden ones.
     */
    public native int getColumnCount()/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		return component.getColumnCount();
    }-*/;

    /**
     * Returns the number of grid columns descended from this HeaderContainer.
     * Group Columns are HeaderContainers. All grid columns are returned,
     * including hidden ones.
     */
    public native void add(GridColumn col)/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		component.add(col.@com.ati.ext4j.client.core.JsObject::getJsObj()());
    }-*/;

    public static HeaderContainer cast(Component c) {
        return new HeaderContainer(c.getOrCreateJsObj());
    }

}
