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
package com.ati.ext4j.client.events.button;

import com.ati.ext4j.client.core.EventObject;
import com.ati.ext4j.client.events.Event;
import com.ati.ext4j.client.ui.Button;
import com.ati.ext4j.client.ui.Menu;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class MenuTriggerOverEvent extends EventObject {

    public static String EVENT_NAME = Event.MENU_TRIGGER_OVER;

    private Button source;
    private Menu menu;

    /**
     * UiBinder implementations
     */
    private static Type<MenuTriggerOverHandler> TYPE = new Type<MenuTriggerOverHandler>(EVENT_NAME, null);

    public static Type<MenuTriggerOverHandler> getType() {
        return TYPE;
    }

    public static Type<MenuTriggerOverHandler> getAssociatedType() {
        return TYPE;
    }

    public MenuTriggerOverEvent(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public MenuTriggerOverEvent(Button source, Menu menu, JavaScriptObject nativeEvent) {
        super(nativeEvent);
        this.source = source;
        this.menu = menu;
    }

    /**
     * @return the source
     */
    public Button getSource() {
        return source;
    }

    /**
     * @return the menu
     */
    public Menu getMenu() {
        return menu;
    }

}
