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
package com.eemi.ext4j.client.events.tab;

import com.eemi.ext4j.client.core.Component;
import com.eemi.ext4j.client.core.EventObject;
import com.eemi.ext4j.client.events.Event;
import com.eemi.ext4j.client.ui.TabPanel;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class BeforeTabChangeEvent extends EventObject {

    public static String EVENT_NAME = Event.BEFORE_TAB_CHANGE;

    private TabPanel source;
    private Component oldCard;
    private Component newCard;

    /**
     * UiBinder implementations
     */
    private static Type<BeforeTabChangeHandler> TYPE = new Type<BeforeTabChangeHandler>(EVENT_NAME, null);

    public static Type<BeforeTabChangeHandler> getType() {
        return TYPE;
    }

    public static Type<BeforeTabChangeHandler> getAssociatedType() {
        return TYPE;
    }

    public BeforeTabChangeEvent(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public BeforeTabChangeEvent(TabPanel source, Component oldCard, Component newCard, JavaScriptObject nativeEvent) {
        super(nativeEvent);
        this.source = source;
        this.oldCard = oldCard;
        this.newCard = newCard;
    }

    /**
     * @return the source
     */
    public TabPanel getSource() {
        return source;
    }

    /**
     * @return the oldValue
     */
    public Component getOldCard() {
        return oldCard;
    }

    /**
     * @return the newValue
     */
    public Component getNewCard() {
        return newCard;
    }

}
