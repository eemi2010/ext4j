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
package com.eemi.ext4j.client.tab;

import com.eemi.ext4j.client.core.Component;
import com.eemi.ext4j.client.core.config.XType;
import com.eemi.ext4j.client.events.HandlerRegistration;
import com.eemi.ext4j.client.grid.HeaderContainer;
import com.eemi.ext4j.client.ui.PanelHeader;
import com.eemi.ext4j.client.ui.TabPanel;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * TabBar is used internally by a {@link TabPanel} and typically should not need
 * to be created manually. The tab bar automatically removes the default title
 * provided by {@link PanelHeader}
 */

public class TabBar extends HeaderContainer {

    private static JavaScriptObject configPrototype;

    protected JavaScriptObject getConfigPrototype() {
        return configPrototype;
    }

    public String getXType() {
        return XType.TAB_BAR.getValue();
    }

    /**
     * Create a new NotificationContainer.
     */
    protected TabBar() {
    }

    protected TabBar(JavaScriptObject obj) {
        super(obj);
    }

    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.tab.Bar(config);
    }-*/;

    /**
     * True to not show the full background on the tabbar
     * <p>
     * Defaults to: false
     * 
     * @param value
     */
    public void setPlain(boolean value) {
        setAttribute("plain", value, true);
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
     * Creates a new TabBar from the given component
     * 
     * @param component
     *            , the component to cast from
     * @return, a new TabBar from the component
     * 
     */
    public static TabBar cast(Component component) {
        return new TabBar(component.getOrCreateJsObj());
    }

}
