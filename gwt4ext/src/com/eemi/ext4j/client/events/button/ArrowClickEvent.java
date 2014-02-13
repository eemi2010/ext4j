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
package com.eemi.ext4j.client.events.button;

import com.eemi.ext4j.client.core.EventObject;
import com.eemi.ext4j.client.events.Event;
import com.eemi.ext4j.client.ui.SplitButton;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class ArrowClickEvent extends EventObject {

    public static String EVENT_NAME = Event.ARROW_CLICK;

    private SplitButton source;

    /**
     * UiBinder implementations
     */
    private static Type<ArrowClickHandler> TYPE = new Type<ArrowClickHandler>(EVENT_NAME, null);

    public static Type<ArrowClickHandler> getType() {
        return TYPE;
    }

    public static Type<ArrowClickHandler> getAssociatedType() {
        return TYPE;
    }

    public ArrowClickEvent(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public ArrowClickEvent(SplitButton source, JavaScriptObject nativeEvent) {
        super(nativeEvent);
        this.source = source;
    }

    /**
     * @return the source
     */
    public SplitButton getSource() {
        return source;
    }

}