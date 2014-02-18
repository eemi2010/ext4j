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
package com.ati.ext4j.client.ui;

import com.ati.ext4j.client.core.Component;
import com.ati.ext4j.client.core.ExtElement;
import com.ati.ext4j.client.core.config.XType;
import com.ati.ext4j.client.events.HandlerRegistration;
import com.ati.ext4j.client.events.menu.ClickHandler;
import com.ati.ext4j.client.events.menu.MouseEnterHandler;
import com.ati.ext4j.client.events.menu.MouseLeaveHandler;
import com.ati.ext4j.client.events.menu.MouseOverHandler;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * A menu object.
 * <p>
 * This is the container to which you may add menu items.
 * <p>
 * Menus may contain either menu items, or general Components. Menus may also
 * contain docked items because it extends Ext.panel.Panel.
 * <p>
 * To make a contained general Component line up with other menu items, specify
 * plain: true. This reserves a space for an icon, and indents the Component in
 * line with the other menu items.
 * <p>
 * By default, Menus are absolutely positioned, floating Components. By
 * configuring a Menu with floating: false, a Menu may be used as a child of a
 * Container.
 * 
 */
public class Menu extends Panel {

    private static JavaScriptObject configPrototype;

    private native void init()/*-{
		var c = new $wnd.Ext.menu.Menu();
		@com.ati.ext4j.client.ui.Menu::configPrototype = c.initialConfig;
    }-*/;

    protected JavaScriptObject getConfigPrototype() {
        return configPrototype;
    }

    public String getXType() {
        return XType.MENU.getValue();
    }

    public Menu() {

    }

    public Menu(JavaScriptObject obj) {
        super(obj);

    }

    @Override
    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.menu.Menu(config);
    }-*/;

    /**
     * True to allow multiple menus to be displayed at the same time.
     * 
     * Defaults to: false
     */
    public void setAllowOtherMenus(boolean value) {
        setAttribute("allowOtherMenus", value, true);
    }

    /**
     * The default Ext.Element#getAlignToXY anchor position value for this menu
     * relative to its element of origin.
     * 
     * Defaults to: "tl-bl?"
     */
    public void setDefaultAlign(boolean value) {
        setAttribute("defaultAlign", value, true);
    }

    /**
     * True to enable keyboard navigation for controlling the menu. This option
     * should generally be disabled when form fields are being used inside the
     * menu.
     * 
     * Defaults to: true
     */
    public void setEnableKeyNav(boolean value) {
        setAttribute("enableKeyNav", value, true);
    }

    /**
     * True to ignore clicks on any item in this menu that is a parent item
     * (displays a submenu) so that the submenu is not dismissed when clicking
     * the parent item.
     * 
     * Defaults to: false
     */
    public void setIgnoreParentClick(boolean value) {
        setAttribute("ignoreParentClick", value, true);
    }

    /**
     * True to remove the incised line down the left side of the menu and to not
     * indent general Component items.
     * <p>
     * Defaults to: false
     */
    public void setPlain(boolean value) {
        setAttribute("plain", value, true);
    }

    /**
     * True to show the icon separator.
     * 
     * Defaults to: true
     */
    public void setShowSeparator(boolean value) {
        setAttribute("showSeparator", value, true);
    }

    /**
     * The parent Menu of this Menu.
     */
    public native Menu getParentMenu() /*-{
		var menu = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var obj = component.parentMenu;
		return @com.ati.ext4j.client.ui.Menu::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
    }-*/;

    /**
     * Shows the floating menu by the specified Component
     * 
     * @param component
     */
    public native void showBy(Component component) /*-{
		var menu = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var target = component.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		menu.showBy(target);
    }-*/;

    /**
     * Shows the floating menu by the specified Component
     * 
     * @param compoment
     * @param position
     */
    public native void showBy(Component component, String position) /*-{
		var menu = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var target = component.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		menu.showBy(target, position);
    }-*/;

    /**
     * Moves this floating Component into a constrain region.
     * <p>
     * By default, this Component is constrained to be within the container it
     * was added to, or the element it was rendered to.
     * <p>
     * An alternative constraint may be passed.
     */
    public native void doConstrain() /*-{
		var menu = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		menu.doConstrain();
    }-*/;

    /**
     * Moves this floating Component into a constrain region.
     * <p>
     * By default, this Component is constrained to be within the container it
     * was added to, or the element it was rendered to.
     * <p>
     * An alternative constraint may be passed.
     */
    public native void doConstrain(String element) /*-{
		var menu = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		menu.doConstrain(element);
    }-*/;

    /**
     * Moves this floating Component into a constrain region.
     * <p>
     * By default, this Component is constrained to be within the container it
     * was added to, or the element it was rendered to.
     * <p>
     * An alternative constraint may be passed.
     */
    public native void doConstrain(ExtElement element) /*-{
		var menu = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		menu
				.doConstrain(element.@com.ati.ext4j.client.core.JsObject::getJsObj()());
    }-*/;

    /**
     * Moves this floating Component into a constrain region.
     * <p>
     * By default, this Component is constrained to be within the container it
     * was added to, or the element it was rendered to.
     * <p>
     * An alternative constraint may be passed.
     */
    public native void doConstrain(Component element) /*-{
		var menu = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		menu
				.doConstrain(element.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()());
    }-*/;

    /**
     * Add a menu item to this menu
     * 
     * @param item
     *            , the item to add
     */
    public void addItem(MenuItem item) {
        add(item);
    }

    public void removeItem(MenuItem item) {
        remove(item);
    }

    /**
     * Fires when this menu is clicked
     * 
     * @param handler
     *            , the handler that will handle the event
     */
    public native HandlerRegistration AddClickHandler(ClickHandler handler)/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(m, c, e) {
			var menu = @com.ati.ext4j.client.ui.Menu::new(Lcom/google/gwt/core/client/JavaScriptObject;)(m);
			var comp = @com.ati.ext4j.client.core.Component::createComponent(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var event = @com.ati.ext4j.client.events.menu.ClickEvent::new(Lcom/ati/ext4j/client/ui/Menu;Lcom/ati/ext4j/client/core/Component;Lcom/google/gwt/core/client/JavaScriptObject;)(menu,comp,e);
			handler.@com.ati.ext4j.client.events.menu.ClickHandler::onClick(Lcom/ati/ext4j/client/events/menu/ClickEvent;)(event);
		};
		var eventName = @com.ati.ext4j.client.events.menu.ClickEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ati.ext4j.client.events.HandlerRegistration::new(Lcom/ati/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * Fires when the mouse leaves this menu
     * 
     * @param handler
     *            , the handler that will handle the event
     */
    public native HandlerRegistration addMouseleaveHandler(MouseLeaveHandler handler)/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(m, e) {
			var menu = @com.ati.ext4j.client.ui.Menu::new(Lcom/google/gwt/core/client/JavaScriptObject;)(m);
			var event = @com.ati.ext4j.client.events.menu.MouseLeaveEvent::new(Lcom/ati/ext4j/client/ui/Menu;Lcom/google/gwt/core/client/JavaScriptObject;)(menu,e);
			handler.@com.ati.ext4j.client.events.menu.MouseLeaveHandler::onMouseLeave(Lcom/ati/ext4j/client/events/menu/MouseLeaveEvent;)(event);
		};
		var eventName = @com.ati.ext4j.client.events.menu.MouseLeaveEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ati.ext4j.client.events.HandlerRegistration::new(Lcom/ati/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * Fires when the mouse enter this menu
     * 
     * @param handler
     *            , the handler that will handle the event
     */
    public native HandlerRegistration addMouseEnterHandler(MouseEnterHandler handler)/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(m, e) {
			var menu = @com.ati.ext4j.client.ui.Menu::new(Lcom/google/gwt/core/client/JavaScriptObject;)(m);
			var event = @com.ati.ext4j.client.events.menu.MouseEnterEvent::new(Lcom/ati/ext4j/client/ui/Menu;Lcom/google/gwt/core/client/JavaScriptObject;)(menu,e);
			handler.@com.ati.ext4j.client.events.menu.MouseEnterHandler::onMouseEnter(Lcom/ati/ext4j/client/events/menu/MouseEnterEvent;)(event);
		};
		var eventName = @com.ati.ext4j.client.events.menu.MouseEnterEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ati.ext4j.client.events.HandlerRegistration::new(Lcom/ati/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * Fires when the mouse is hovering over this menu
     * 
     * @param handler
     *            , the handler that will handle the event
     */
    public native HandlerRegistration addMouseOverHandler(MouseOverHandler handler)/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(m, c, e) {
			var menu = @com.ati.ext4j.client.ui.Menu::new(Lcom/google/gwt/core/client/JavaScriptObject;)(m);
			var comp = @com.ati.ext4j.client.core.Component::createComponent(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var event = @com.ati.ext4j.client.events.menu.MouseOverEvent::new(Lcom/ati/ext4j/client/ui/Menu;Lcom/ati/ext4j/client/core/Component;Lcom/google/gwt/core/client/JavaScriptObject;)(menu,comp,e);
			handler.@com.ati.ext4j.client.events.menu.MouseOverHandler::onMouseOver(Lcom/ati/ext4j/client/events/menu/MouseOverEvent;)(event);
		};
		var eventName = @com.ati.ext4j.client.events.menu.MouseOverEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ati.ext4j.client.events.HandlerRegistration::new(Lcom/ati/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * Creates a new Menu from the given component
     * 
     * @param component
     *            , the component to cast from
     * @return, a new Menu from the component
     * 
     */
    public static Menu cast(Component component) {
        return new Menu(component.getOrCreateJsObj());
    }

}
