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
package com.eemi.ext4j.client.tab;

import com.eemi.ext4j.client.core.Component;
import com.eemi.ext4j.client.core.config.XType;
import com.eemi.ext4j.client.ui.Button;
import com.eemi.ext4j.client.ui.TabPanel;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * Represents a single Tab in a TabPanel. A Tab is simply a slightly customized
 * Button, styled to look like a tab. Tabs are optionally closable, and can also
 * be disabled. 99% of the time you will not need to create Tabs manually as the
 * framework does so automatically when you use a {@link TabPanel}
 * 
 */
// TODO Events
public class Tab extends Button {

    private static JavaScriptObject configPrototype;

    protected JavaScriptObject getConfigPrototype() {
        return configPrototype;
    }

    public String getXType() {
        return XType.TAB.getValue();
    }

    /**
     * Create a new NotificationContainer.
     */
    protected Tab() {
    }

    protected Tab(JavaScriptObject obj) {
        super(obj);
    }

    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.tab.Tab(config);
    }-*/;

    /**
     * The CSS class to be applied to a Tab when it is active. Providing your
     * own CSS for this class enables you to customize the active state.
     * <p>
     * Defaults to: "active"
     * 
     * @param value
     */
    public void setActiveCls(String value) {
        setAttribute("activeCls", value, true);
    }

    /**
     * True to make the Tab start closable (the close icon will be visible).
     * <p>
     * Defaults to: true
     * 
     * @param value
     */
    public void setClosable(boolean value) {
        setAttribute("closable", value, true);
    }

    /**
     * The CSS class which is added to the tab when it is closable
     * <p>
     * Defaults to: "closable"
     */
    public void setClosableCls(String value) {
        setAttribute("closableCls", value, true);
    }

    /**
     * The accessible text label for the close button link; only used when
     * closable = true.
     * <p>
     * Defaults to: "Close Tab"
     */
    public void setCloseText(String value) {
        setAttribute("closeText", value, true);
    }

    /**
     * The accessible text label for the close button link; only used when
     * closable = true.
     * <p>
     * Defaults to: "Close Tab"
     */
    public void setDisabledCls(String value) {
        setAttribute("disabledCls", value, true);
    }

    /**
     * Sets this tab's attached card. Usually this is handled automatically by
     * the Ext.tab.Panel that this Tab belongs to and would not need to be done
     * by the developer
     * 
     * @param card
     */
    public native void setCard(Component card) /*-{
		var tab = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		tab
				.setCard(card.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()());
    }-*/;

    /**
     * Creates a new Tab from the given component
     * 
     * @param component
     *            , the component to cast from
     * @return, a new Tab from the component
     * 
     */
    public static Tab cast(Component component) {
        return new Tab(component.getOrCreateJsObj());
    }

}
