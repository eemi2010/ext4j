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
package com.ati.ext4j.client.events.form;

import com.ati.ext4j.client.core.EventObject;
import com.ati.ext4j.client.events.Event;
import com.ati.ext4j.client.ui.Picker;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class PickerCollapseEvent extends EventObject {

    public static String EVENT_NAME = Event.COLLAPSE;

    private Picker source;

    /**
     * UiBinder implementations
     */
    private static Type<PickerCollapseHandler> TYPE = new Type<PickerCollapseHandler>(EVENT_NAME, null);

    public static Type<PickerCollapseHandler> getType() {
        return TYPE;
    }

    public static Type<PickerCollapseHandler> getAssociatedType() {
        return TYPE;
    }

    public PickerCollapseEvent(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public PickerCollapseEvent(Picker source, JavaScriptObject nativeEvent) {
        super(nativeEvent);
        this.source = source;
    }

    /**
     * @return the source
     */
    public Picker getSource() {
        return source;
    }

}
