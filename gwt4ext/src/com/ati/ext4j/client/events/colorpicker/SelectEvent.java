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
package com.ati.ext4j.client.events.colorpicker;

import com.ati.ext4j.client.core.EventObject;
import com.ati.ext4j.client.events.Event;
import com.ati.ext4j.client.ui.ColorPicker;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class SelectEvent extends EventObject {

    public static String EVENT_NAME = Event.SELECT;

    private ColorPicker source;
    private String color;

    /**
     * UiBinder implementations
     */
    private static Type<SelectHandler> TYPE = new Type<SelectHandler>(EVENT_NAME, null);

    public static Type<SelectHandler> getType() {
        return TYPE;
    }

    public static Type<SelectHandler> getAssociatedType() {
        return TYPE;
    }

    public SelectEvent(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public SelectEvent(ColorPicker source, String color, JavaScriptObject nativeEvent) {
        super(nativeEvent);
        this.source = source;
        this.color = color;
    }

    /**
     * @return the source
     */
    public ColorPicker getSource() {
        return source;
    }

    /**
     * @return the date
     */
    public String getColor() {
        return color;
    }

}
