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
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class IconChangeEvent extends EventObject {

    public static String EVENT_NAME = Event.ICON_CHANGE;

    private Button source;
    private String oldIcon;
    private String newIcon;

    /**
     * UiBinder implementations
     */
    private static Type<IconChangeHandler> TYPE = new Type<IconChangeHandler>(EVENT_NAME, null);

    public static Type<IconChangeHandler> getType() {
        return TYPE;
    }

    public static Type<IconChangeHandler> getAssociatedType() {
        return TYPE;
    }

    public IconChangeEvent(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public IconChangeEvent(Button source, String oldIcon, String newIcon, JavaScriptObject nativeEvent) {
        super(nativeEvent);
        this.source = source;
        this.oldIcon = oldIcon;
        this.newIcon = newIcon;

    }

    /**
     * @return the source
     */
    public Button getSource() {
        return source;
    }

    /**
     * @return the oldIcon
     */
    public String getOldIcon() {
        return oldIcon;
    }

    /**
     * @return the newIcon
     */
    public String getNewIcon() {
        return newIcon;
    }

}
