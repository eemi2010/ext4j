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
package com.eemi.ext4j.client.events.panel;

import com.eemi.ext4j.client.core.EventObject;
import com.eemi.ext4j.client.events.Event;
import com.eemi.ext4j.client.ui.Panel;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class IconClsChangeEvent extends EventObject {

    public static String EVENT_NAME = Event.ICON_CLS_CHANGE;

    private Panel source;
    private String newIconCls;
    private String oldIconCls;

    /**
     * UiBinder implementations
     */
    private static Type<IconClsChangeHandler> TYPE = new Type<IconClsChangeHandler>(EVENT_NAME, null);

    public static Type<IconClsChangeHandler> getType() {
        return TYPE;
    }

    public static Type<IconClsChangeHandler> getAssociatedType() {
        return TYPE;
    }

    public IconClsChangeEvent(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public IconClsChangeEvent(Panel source, String newIconCls, String oldIconCls, JavaScriptObject nativeEvent) {
        super(nativeEvent);
        this.source = source;
        this.newIconCls = newIconCls;
        this.oldIconCls = oldIconCls;
    }

    /**
     * @return the source
     */
    public Panel getSource() {
        return source;
    }

    /**
     * @return the newIconCls
     */
    public String getNewIconCls() {
        return newIconCls;
    }

    /**
     * @return the oldIcon Cls
     */
    public String getOldIconCls() {
        return oldIconCls;
    }

}
