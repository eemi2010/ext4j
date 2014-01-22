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
import com.eemi.ext4j.client.core.config.Position;
import com.eemi.ext4j.client.core.config.XType;
import com.eemi.ext4j.client.events.HandlerRegistration;
import com.eemi.ext4j.client.events.tab.BeforeTabChangeHandler;
import com.eemi.ext4j.client.events.tab.TabPanelBeforeTabChangeHandler;
import com.eemi.ext4j.client.tab.TabBar;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;

/**
 * A basic tab container. TabPanels can be used exactly like a standard
 * {@link Panel} for layout purposes, but also have special support for
 * containing child Components (items) that are managed using a CardLayout
 * layout manager, and displayed as separate tabs.
 * <p>
 * Note: By default, a tab's close tool destroys the child tab Component and all
 * its descendants. This makes the child tab Component, and all its descendants
 * unusable. To enable re-use of a tab, configure the TabPanel with autoDestroy:
 * false.
 */
public class TabPanel extends Panel {

    private static JavaScriptObject configPrototype;

    // private static int panelId = 0;

    private native void init()/*-{
		var c = new $wnd.Ext.tab.Panel();
		@com.eemi.ext4j.client.ui.TabPanel::configPrototype = c.initialConfig;
    }-*/;

    protected JavaScriptObject getConfigPrototype() {
        return configPrototype;
    }

    public String getXType() {
        return XType.TABPANEL.getValue();
    }

    /**
     * Create a new NotificationContainer.
     */
    public TabPanel() {
        // id = "ext-" + this.getXType() + "-" + ++panelId;
        // JsoHelper.setAttribute(config, "id", id);
    }

    public TabPanel(Position position) {
        this();
        setTabPosition(position);
    }

    protected TabPanel(JavaScriptObject jsObj) {
        super(jsObj);
    }

    /**
     * Applys the NotificationContainer to an existing element.
     * 
     * @param element
     *            the element
     */
    public TabPanel(Element element) {
        super(element);
    }

    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.tab.Panel(config);
    }-*/;

    /**
     * The tab to activate initially.
     * 
     * @param panel
     */
    public void setActiveTab(Panel panel) {
        setActivateTab(panel.getOrCreateJsObj());
    }

    /**
     * Returns the {@link TabBar} currently used in this TabPanel
     */
    public native TabBar getTabBar() /*-{
		var tabPanel = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var tab = tabPanel.getTabBar();
		if (!tab) {
			return null;
		}
		return @com.eemi.ext4j.client.tab.TabBar::new(Lcom/google/gwt/core/client/JavaScriptObject;)(tab);

    }-*/;

    private native void setActivateTab(JavaScriptObject tab) /*-{
		var tabPanel = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		tabPanel.setActiveTab(tab);
    }-*/;

    /**
     * The tab to activate initially.
     * 
     * @param tab
     */
    public native void setActiveTab(int tab) /*-{
		var tabPanel = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		tabPanel.setActiveTab(tab);
    }-*/;

    /**
     * True by default to defer the rendering of child items to the browsers DOM
     * until a tab is activated. False will render all contained items as soon
     * as the layout is rendered. If there is a significant amount of content or
     * a lot of heavy controls being rendered into panels that are not displayed
     * by default, setting this to true might improve performance.
     * 
     * <p>
     * <b>Note: </b> leaving deferredRender as true means that the content
     * within an unactivated tab will not be available
     * 
     */
    public void setDeferredRender(boolean value) {
        setAttribute("deferredRender", value, true);
    }

    /**
     * The class added to each child item of this TabPanel.
     * <p>
     * Defaults to: "x-tabpanel-child"
     * 
     * @param value
     */
    public void setItemCls(String value) {
        setAttribute("itemCls", value, true);
    }

    /**
     * The maximum width for each tab.
     * 
     * @param value
     */
    public void setMaxTabWidth(int value) {
        setAttribute("maxTabWidth", value, true);
    }

    /**
     * The minimum width for each tab.
     * 
     * @param value
     */
    public void setMinTabWidth(int value) {
        setAttribute("minTabWidth", value, true);
    }

    /**
     * True to not show the full background on the TabBar.
     * <p>
     * Defaults to: false
     * 
     * @param value
     */
    public void setPlain(boolean value) {
        setAttribute("plain", value, true);
    }

    /**
     * True to instruct each NotificationContainer added to the TabContainer to
     * not render its header element. This is to ensure that the title of the
     * panel does not appear twice.
     * <p>
     * Defaults to: true
     */
    public void setRemovePanelHeader(boolean value) {
        setAttribute("removePanelHeader", value, true);
    }

    /**
     * The position where the tab strip should be rendered. Can be top or
     * bottom.
     * <p>
     * Defaults to: "top"
     * 
     * @param position
     */
    public void setTabPosition(String position) {
        setAttribute("tabPosition", position, true);
    }

    public void setTabPosition(Position position) {
        setAttribute("tabPosition", position.getValue(), true);
    }

    /**
     * Fires when a new tab has been activated (activated by setActiveTab).
     */

    public native HandlerRegistration addTabChangeHandler(com.eemi.ext4j.client.events.tab.TabChangeHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(tp, oc, nc, e) {
			var panel = @com.eemi.ext4j.client.ui.TabPanel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(tp);
			var oldCard = @com.eemi.ext4j.client.core.SimpleComponent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(oc);
			var newCard = @com.eemi.ext4j.client.core.SimpleComponent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(nc);
			var event = @com.eemi.ext4j.client.events.tab.TabChangeEvent::new(Lcom/eemi/ext4j/client/ui/TabPanel;Lcom/eemi/ext4j/client/core/Component;Lcom/eemi/ext4j/client/core/Component;Lcom/google/gwt/core/client/JavaScriptObject;)(panel,oldCard,newCard,e);
			handler.@com.eemi.ext4j.client.events.tab.TabChangeHandler::onTabChange(Lcom/eemi/ext4j/client/events/tab/TabChangeEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.tab.TabChangeEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * Fires before a tab change (activated by setActiveTab). Return false in
     * any listener to cancel the tabchange
     * 
     * @param handler
     */
    public native void addBeforeTabChangeHandler(TabPanelBeforeTabChangeHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		if (component) {
			component
					.addListener(
							@com.eemi.ext4j.client.events.Event::TAB_CHANGE,
							$entry(function(p, newCard, oldCard) {
								var oldComp = null;
								var tabPanel = @com.eemi.ext4j.client.ui.TabPanel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(p);
								var newComp = @com.eemi.ext4j.client.core.Component::createComponent(Lcom/google/gwt/core/client/JavaScriptObject;)(newCard);
								if (oldCard) {
									oldComp = @com.eemi.ext4j.client.core.Component::createComponent(Lcom/google/gwt/core/client/JavaScriptObject;)(oldCard);
								}
								return handler.@com.eemi.ext4j.client.events.tab.TabPanelBeforeTabChangeHandler::onEvent(Lcom/eemi/ext4j/client/ui/TabPanel;Lcom/eemi/ext4j/client/core/Component;Lcom/eemi/ext4j/client/core/Component;)(tabPanel,newComp,oldComp);
							}));
		}

    }-*/;

    /**
     * Fires before a tab change (activated by setActiveTab).
     */
    public native HandlerRegistration addBeforeTabChangeHandler(BeforeTabChangeHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(tp, oc, nc, e) {
			var panel = @com.eemi.ext4j.client.ui.TabPanel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(tp);
			var oldCard = @com.eemi.ext4j.client.core.SimpleComponent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(oc);
			var newCard = @com.eemi.ext4j.client.core.SimpleComponent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(nc);
			var event = @com.eemi.ext4j.client.events.tab.BeforeTabChangeEvent::new(Lcom/eemi/ext4j/client/ui/TabPanel;Lcom/eemi/ext4j/client/core/Component;Lcom/eemi/ext4j/client/core/Component;Lcom/google/gwt/core/client/JavaScriptObject;)(panel,oldCard,newCard,e);
			handler.@com.eemi.ext4j.client.events.tab.BeforeTabChangeHandler::onBeforeTabChange(Lcom/eemi/ext4j/client/events/tab/BeforeTabChangeEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.tab.BeforeTabChangeEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * Creates a new TabPanel from the given component
     * 
     * @param component
     *            , the component to cast from
     * @return, a new TabPanel from the component
     * 
     */
    public static TabPanel cast(Component component) {
        return new TabPanel(component.getOrCreateJsObj());
    }
}
