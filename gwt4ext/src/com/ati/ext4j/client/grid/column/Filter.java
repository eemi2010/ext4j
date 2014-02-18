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
package com.ati.ext4j.client.grid.column;

import com.ati.ext4j.client.core.JsoHelper;
import com.ati.ext4j.client.core.config.BaseConfig;
import com.ati.ext4j.client.ui.Menu;

public abstract class Filter extends BaseConfig {

    public void setType(String value) {
        JsoHelper.setAttribute(jsObj, "type", value);
    }

    /**
     * The Ext.data.Store dataIndex of the field this filter represents. The
     * dataIndex does not actually have to exist in the store.
     * <p>
     * Defaults to: null
     */
    public void setDataIndex(String value) {
        JsoHelper.setAttribute(jsObj, "dataIndex", value);
    }

    /**
     * Number of milliseconds to wait after user interaction to fire an update.
     * Only supported by filters: 'list', 'numeric', and 'string'. Defaults to
     * 500.
     * <p>
     * Defaults to: 500
     */
    public void setUpdateBuffer(String value) {
        JsoHelper.setAttribute(jsObj, "updateBuffer", value);
    }

    /**
     * Indicates the initial status of the filter (defaults to false).
     * <p>
     * Defaults to: false
     */
    public void setActive(boolean value) {
        JsoHelper.setAttribute(jsObj, "active", value);
    }

    /**
     * 
     * The filter configuration menu that will be installed into the filter
     * submenu of a column menu.
     * <p>
     * Defaults to: null
     */
    public native Menu getMenu()/*-{
		var peer = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		var menu = peer.menu;
		return @com.ati.ext4j.client.ui.Menu::new(Lcom/google/gwt/core/client/JavaScriptObject;)(menu);
    }-*/;

    /**
     * 
     True if this filter is active. Use setActive() to alter after
     * configuration.
     */
    public native boolean isActive()/*-{
		var peer = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		return peer.active;
    }-*/;

}
