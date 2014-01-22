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
import com.eemi.ext4j.client.events.HandlerRegistration;
import com.eemi.ext4j.client.events.menu.SelectHandler;
import com.google.gwt.core.client.JavaScriptObject;

public class MenuColorPicker extends Menu {

    private static JavaScriptObject configPrototype;

    private native void init()/*-{
		var c = new $wnd.Ext.menu.ColorPicker();
		@com.eemi.ext4j.client.ui.MenuColorPicker::configPrototype = c.initialConfig;
    }-*/;

    protected JavaScriptObject getConfigPrototype() {
        return configPrototype;
    }

    public String getXType() {
        return XType.COLOR_MENU.getValue();
    }

    /**
     * Create a new NotificationContainer.
     */
    public MenuColorPicker() {
        // init();
    }

    public MenuColorPicker(JavaScriptObject obj) {
        super(obj);
    }

    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.menu.ColorPicker(config);
    }-*/;

    /**
     * True to prevent the checked item from being toggled. Any submenu will
     * still be accessible.
     * 
     * Defaults to: false
     * 
     * @return
     */
    public void setHideOnClick(boolean value) {
        setAttribute("hideOnClick", value, true);
    }

    /**
     * An id to assign to the underlying color picker.
     * 
     * Defaults to: null
     * 
     * @return
     */
    public void setPickerId(String value) {
        setAttribute("pickerId", value, true);
    }

    /**
     * The {@link ColorPicker} instance for this ColorMenu
     */
    public native ColorPicker getPicker() /*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var obj = component.picker;
		return @com.eemi.ext4j.client.ui.ColorPicker::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
    }-*/;

    /**
     * Fires when a color is selected
     * 
     * @param handler
     *            , the handler that will handle the event
     */
    public native HandlerRegistration addSelectHandler(SelectHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(m, c, e) {
			var menu = @com.eemi.ext4j.client.ui.Menu::new(Lcom/google/gwt/core/client/JavaScriptObject;)(m);
			var event = @com.eemi.ext4j.client.events.menu.SelectEvent::new(Lcom/eemi/ext4j/client/ui/Menu;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(menu,color,e);
			handler.@com.eemi.ext4j.client.events.menu.SelectHandler::onSelect(Lcom/eemi/ext4j/client/events/menu/SelectEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.menu.SelectEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * Creates a new MenuColorPicker from the given component
     * 
     * @param component
     *            , the component to cast from
     * @return, a new MenuColorPicker from the component
     * 
     */
    public static MenuColorPicker cast(Component component) {
        return new MenuColorPicker(component.getOrCreateJsObj());
    }

}
