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
import com.ait.ext4j.client.core.config.XType;
import com.ait.ext4j.client.events.HandlerRegistration;
import com.ait.ext4j.client.events.menu.DateSelectHandler;
import com.google.gwt.core.client.JavaScriptObject;

public class MenuDatePicker extends Menu {

    private static JavaScriptObject configPrototype;

    private native void init()/*-{
		var c = new $wnd.Ext.menu.DatePicker();
		@com.ait.ext4j.client.ui.MenuDatePicker::configPrototype = c.initialConfig;
    }-*/;

    protected JavaScriptObject getConfigPrototype() {
        return configPrototype;
    }

    public String getXType() {
        return XType.DATE_MENU.getValue();
    }

    /**
     * Create a new NotificationContainer.
     */
    public MenuDatePicker() {
        // init();
    }

    public MenuDatePicker(JavaScriptObject obj) {
        super(obj);
    }

    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.menu.DatePicker(config);
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
     * The {@link DatePicker} instance for this ColorMenu
     */
    public native DatePicker getPicker() /*-{
		var component = this.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()();
		var obj = component.picker;
		return @com.ait.ext4j.client.ui.DatePicker::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
    }-*/;

    /**
     * Fires when a date is selected
     * 
     * @param handler
     *            , the handler that will handle the event
     */
    public native HandlerRegistration addDateSelectHandler(DateSelectHandler handler)/*-{
		var component = this.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(m, date, e) {
			var menu = @com.ait.ext4j.client.ui.Menu::new(Lcom/google/gwt/core/client/JavaScriptObject;)(m);
			var event = @com.ait.ext4j.client.events.menu.DateSelectEvent::new(Lcom/ait/ext4j/client/ui/Menu;Lcom/google/gwt/core/client/JsDate;Lcom/google/gwt/core/client/JavaScriptObject;)(menu,date,e);
			handler.@com.ait.ext4j.client.events.menu.DateSelectHandler::onDateSelect(Lcom/ait/ext4j/client/events/menu/DateSelectEvent;)(event);
		};
		var eventName = @com.ait.ext4j.client.events.menu.DateSelectEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.ext4j.client.events.HandlerRegistration::new(Lcom/ait/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
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
    public static MenuDatePicker cast(Component component) {
        return new MenuDatePicker(component.getOrCreateJsObj());
    }

}
