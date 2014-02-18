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
import com.ait.ext4j.client.events.menu.ItemActivateHandler;
import com.ait.ext4j.client.events.menu.ItemClickHandler;
import com.ait.ext4j.client.events.menu.ItemDeactivateHandler;
import com.ait.ext4j.client.events.menu.ItemIconChangeHandler;
import com.ait.ext4j.client.events.menu.ItemTextChangeHandler;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.Image;

/**
 * A base class for all menu items that require menu-related functionality such
 * as click handling, sub-menus, icons, etc.
 * 
 */
public class MenuItem extends Component {

    private static JavaScriptObject configPrototype;
    private Image iconImage = new Image();

    private native void init()/*-{
		var c = new $wnd.Ext.menu.Item();
		@com.ait.ext4j.client.ui.MenuItem::configPrototype = c.initialConfig;
    }-*/;

    protected JavaScriptObject getConfigPrototype() {
        return configPrototype;
    }

    public String getXType() {
        return XType.MENU_ITEM.getValue();
    }

    /**
     * Create a new NotificationContainer.
     */
    public MenuItem() {
        // init();
    }

    public MenuItem(JavaScriptObject obj) {
        super(obj);
    }

    public MenuItem(String text) {
        this();
        setText(text);
    }

    public MenuItem(String text, String icon) {
        this();
        setText(text);
        setIcon(icon);
    }

    public MenuItem(String text, ImageResource icon) {
        this();
        setText(text);
        setIcon(icon);
    }

    public MenuItem(String text, Image icon) {
        this();
        setText(text);
        setIcon(icon);
    }

    public MenuItem(String text, ItemClickHandler clickHandler) {
        this(text);
        addItemClickHandler(clickHandler);
    }

    public MenuItem(String text, String icon, ItemClickHandler clickHandler) {
        this(text, icon);
        addItemClickHandler(clickHandler);
    }

    public MenuItem(String text, ImageResource icon, ItemClickHandler clickHandler) {
        this(text, icon);
        addItemClickHandler(clickHandler);
    }

    public MenuItem(String text, Image icon, ItemClickHandler clickHandler) {
        this(text, icon);
        addItemClickHandler(clickHandler);
    }

    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.menu.Item(config);
    }-*/;

    /**
     * The CSS class added to the menu item when the item is activated
     * (focused/mouseover).
     * 
     * Defaults to: "x-menu-item-active"
     * 
     * @param value
     */
    public void setActiveCls(String value) {
        setAttribute("activeCls", value, true);
    }

    /**
     * Whether or not this menu item can be activated when focused/mouseovered.
     * 
     * Defaults to: true
     * 
     * @param value
     */
    public void setCanActivate(boolean value) {
        setAttribute("canActivate", value, true);
    }

    /**
     * The delay in milliseconds to wait before hiding the menu after clicking
     * the menu item. This only has an effect when hideOnClick: true.
     * 
     * Defaults to: 1
     * 
     * @param value
     */
    public void setClickHideDelay(int value) {
        setAttribute("clickHideDelay", value, true);
    }

    /**
     * The delay in milliseconds to wait before hiding the menu after clicking
     * the menu item. This only has an effect when hideOnClick: true.
     * 
     * Defaults to: 1
     * 
     * @param value
     */
    public void setDisableCls(int value) {
        setAttribute("disableCls", value, true);
    }

    /**
     * Whether or not to destroy any associated sub-menu when this item is
     * destroyed.
     * 
     * Defaults to: true
     * 
     * @param value
     */
    public void setDestroyMenu(boolean value) {
        setAttribute("destroyMenu", value, true);
    }

    /**
     * Whether to not to hide the owning menu when this item is clicked.
     * 
     * Defaults to: true
     * 
     * @param value
     */
    public void setHideOnClick(boolean value) {
        setAttribute("hideOnClick", value, true);
    }

    /**
     * The href attribute to use for the underlying anchor link.
     * 
     * Defaults to: "#"
     * 
     * @param value
     */
    public void setHref(String value) {
        setAttribute("href", value, true);
    }

    /**
     * The target attribute to use for the underlying anchor link.
     * 
     * @param value
     */
    public void setHrefTarget(String value) {
        setAttribute("hrefTarget", value, true);
    }

    /**
     * The path to an icon to display in this item.
     * 
     * Defaults to Ext.BLANK_IMAGE_URL.
     * 
     * @param value
     */
    public void setIcon(String value) {
        setAttribute("icon", value, true);
    }

    /**
     * The path to an icon to display in this item.
     * 
     * Defaults to Ext.BLANK_IMAGE_URL.
     * 
     * @param value
     */
    public void setIcon(ImageResource imageResource) {
        iconImage.setResource(imageResource);
        setAttribute("icon", iconImage.getUrl(), true);
    }

    /**
     * The path to an icon to display in this item.
     * 
     * Defaults to Ext.BLANK_IMAGE_URL.
     * 
     * @param value
     */
    public void setIcon(Image image) {
        iconImage = image;
        setAttribute("icon", iconImage.getUrl(), true);
    }

    /**
     * A CSS class that specifies a background-image to use as the icon for this
     * item.
     * 
     * @param value
     */
    public void setIconCls(String value) {
        setAttribute("iconCls", value, true);
    }

    /**
     * Either an instance of Ext.menu.Menu or a config object for an
     * Ext.menu.Menu which will act as a sub-menu to this item.
     * 
     * @param value
     */
    public void setMenu(Menu value) {
        setAttribute("menu", value.getOrCreateJsObj(), true);
    }

    /**
     * The default Ext.Element.getAlignToXY anchor position value for this
     * item's sub-menu relative to this item's position.
     * 
     * Defaults to: "tl-tr?"
     * 
     * @param value
     */
    public void setMenuAlign(String value) {
        setAttribute("menuAlign", value, true);
    }

    /**
     * The delay in milliseconds before this item's sub-menu expands after this
     * item is moused over.
     * 
     * Defaults to: 200
     * 
     * @param value
     */
    public void setMenuExpandDelay(int value) {
        setAttribute("menuExpandDelay", value, true);
    }

    /**
     * Whether or not this item is plain text/html with no icon or visual
     * activation.
     * 
     * @param value
     */
    public void setPlain(boolean value) {
        setAttribute("plain", value, true);
    }

    /**
     * The text/html to display in this item.
     * 
     * @param text
     */
    public void setText(String text) {
        if (hasSetText()) {
            setTextRendered(text);
        } else {
            setAttribute("text", text, true);
        }

    }

    private native boolean hasSetText() /*-{
		var component = this.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()();
		if (component.setText) {
			return true;
		}
		return false;
    }-*/;

    private native void setTextRendered(String title) /*-{
		var component = this.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()();
		component.setText(title);
    }-*/;

    /**
     * The tooltip for the menu item
     * 
     * @param value
     */
    public void setTooltip(String value) {
        setAttribute("tooltip", value, true);
    }

    /**
     * The tooltip for the item
     * 
     * @param value
     */
    public void setTooltip(ToolTip value) {
        setAttribute("tooltip", value.getOrCreateJsObj(), true);
    }

    /**
     * The tooltip for the item
     * 
     * @param value
     */
    public void setTooltipType(String value) {
        setAttribute("tooltipType", value, true);
    }

    /**
     * gets the text of this menu item
     * 
     * @return
     */
    public String getText() {
        return getAttribute("text");
    }

    /**
     * Whether or not this item is currently activated
     * 
     * @return
     */
    public native boolean isActivated() /*-{
		var component = this.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()();
		return component.activated;
    }-*/;

    /**
     * The sub-menu associated with this item, if one was configured.
     * 
     * @return
     */
    public native Menu getMenu() /*-{
		var component = this.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()();
		var obj = component.menu;
		return @com.ait.ext4j.client.ui.Menu::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
    }-*/;

    /**
     * The parent Menu of this item.
     * 
     * @return
     */
    public native Menu getParentMenu() /*-{
		var component = this.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()();
		var obj = component.parentMenu;
		return @com.ait.ext4j.client.ui.Menu::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
    }-*/;

    /**
     * Fires when this item is activated
     * 
     * @param handler
     *            , the handler that will handle the event
     */
    public native HandlerRegistration addItemActivateHandler(ItemActivateHandler handler)/*-{
		var component = this.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(m, e) {
			var menu = @com.ait.ext4j.client.ui.Menu::new(Lcom/google/gwt/core/client/JavaScriptObject;)(m);
			var event = @com.ait.ext4j.client.events.menu.ItemActivateEvent::new(Lcom/ait/ext4j/client/ui/MenuItem;Lcom/google/gwt/core/client/JavaScriptObject;)(menu,e);
			handler.@com.ait.ext4j.client.events.menu.ItemActivateHandler::onItemActivate(Lcom/ait/ext4j/client/events/menu/ItemActivateEvent;)(event);
		};
		var eventName = @com.ait.ext4j.client.events.menu.ItemActivateEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.ext4j.client.events.HandlerRegistration::new(Lcom/ait/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * Fires when this item is deactivated
     * 
     * @param handler
     *            , the handler that will handle the event
     */
    public native HandlerRegistration addItemDeactivateHandler(ItemDeactivateHandler handler)/*-{
		var component = this.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(m, e) {
			var menu = @com.ait.ext4j.client.ui.Menu::new(Lcom/google/gwt/core/client/JavaScriptObject;)(m);
			var event = @com.ait.ext4j.client.events.menu.ItemDeactivateEvent::new(Lcom/ait/ext4j/client/ui/MenuItem;Lcom/google/gwt/core/client/JavaScriptObject;)(menu,e);
			handler.@com.ait.ext4j.client.events.menu.ItemDeactivateHandler::onItemDeactivate(Lcom/ait/ext4j/client/events/menu/ItemDeactivateEvent;)(event);
		};
		var eventName = @com.ait.ext4j.client.events.menu.ItemDeactivateEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.ext4j.client.events.HandlerRegistration::new(Lcom/ait/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * Fires when this item is clicked
     * 
     * @param handler
     *            , the handler that will handle the event
     */
    public native HandlerRegistration addItemClickHandler(ItemClickHandler handler)/*-{
		var component = this.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(m, e) {
			var menu = @com.ait.ext4j.client.ui.MenuItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(m);
			var event = @com.ait.ext4j.client.events.menu.ItemClickEvent::new(Lcom/ait/ext4j/client/ui/MenuItem;Lcom/google/gwt/core/client/JavaScriptObject;)(menu,e);
			handler.@com.ait.ext4j.client.events.menu.ItemClickHandler::onItemClick(Lcom/ait/ext4j/client/events/menu/ItemClickEvent;)(event);
		};
		var eventName = @com.ait.ext4j.client.events.menu.ItemClickEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.ext4j.client.events.HandlerRegistration::new(Lcom/ait/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    public native HandlerRegistration addItemIconChangeHandler(ItemIconChangeHandler handler)/*-{
		var component = this.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(m, oldIcon, newIcon, e) {
			var menu = @com.ait.ext4j.client.ui.MenuItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(m);
			var event = @com.ait.ext4j.client.events.menu.ItemIconChangeEvent::new(Lcom/ait/ext4j/client/ui/MenuItem;Ljava/lang/String;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(menu,oldIcon,newIcon,e);
			handler.@com.ait.ext4j.client.events.menu.ItemIconChangeHandler::onItemIconChange(Lcom/ait/ext4j/client/events/menu/ItemIconChangeEvent;)(event);
		};
		var eventName = @com.ait.ext4j.client.events.menu.ItemIconChangeEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.ext4j.client.events.HandlerRegistration::new(Lcom/ait/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    public native HandlerRegistration addItemTextChangeHandler(ItemTextChangeHandler handler)/*-{
		var component = this.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(m, oldText, newText, e) {
			var menu = @com.ait.ext4j.client.ui.MenuItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(m);
			var event = @com.ait.ext4j.client.events.menu.ItemTextChangeEvent::new(Lcom/ait/ext4j/client/ui/MenuItem;Ljava/lang/String;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(menu,oldText,newText,e);
			handler.@com.ait.ext4j.client.events.menu.ItemTextChangeHandler::onItemTextChange(Lcom/ait/ext4j/client/events/menu/ItemTextChangeEvent;)(event);
		};
		var eventName = @com.ait.ext4j.client.events.menu.ItemTextChangeEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.ext4j.client.events.HandlerRegistration::new(Lcom/ait/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * Creates a new MenuItem from the given component
     * 
     * @param component
     *            , the component to cast from
     * @return, a new MenuItem from the component
     * 
     */
    public static MenuItem cast(Component component) {
        return new MenuItem(component.getOrCreateJsObj());
    }

}
