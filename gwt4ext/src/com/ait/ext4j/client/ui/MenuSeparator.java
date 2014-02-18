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
import com.google.gwt.core.client.JavaScriptObject;

/**
 * Adds a separator bar to a menu, used to divide logical groups of menu items.
 * Generally you will add one of these by using "-" in your call to add() or in
 * your items config rather than creating one directly.
 * 
 * @author alainekambi
 * 
 */
public class MenuSeparator extends MenuItem {

    private static JavaScriptObject configPrototype;

    private native void init()/*-{
		var c = new $wnd.Ext.menu.Item();
		@com.ait.ext4j.client.ui.MenuSeparator::configPrototype = c.initialConfig;
    }-*/;

    protected JavaScriptObject getConfigPrototype() {
        return configPrototype;
    }

    public String getXType() {
        return XType.MENU_SEPARATOR.getValue();
    }

    /**
     * Create a new NotificationContainer.
     */
    public MenuSeparator() {
        // init();
    }

    public MenuSeparator(JavaScriptObject obj) {
        super(obj);
    }

    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.menu.Separator(config);
    }-*/;

    /**
     * Creates a new MenuSeparator from the given component
     * 
     * @param component
     *            , the component to cast from
     * @return, a new MenuSeparator from the component
     * 
     */
    public static MenuSeparator cast(Component component) {
        return new MenuSeparator(component.getOrCreateJsObj());
    }
}
