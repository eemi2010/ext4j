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
package com.eemi.ext4j.client.events.slider;

import com.eemi.ext4j.client.core.EventObject;
import com.eemi.ext4j.client.events.Event;
import com.eemi.ext4j.client.slider.Thumb;
import com.eemi.ext4j.client.ui.MultiSlider;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class ChangeCompleteEvent extends EventObject {

    public static String EVENT_NAME = Event.CHANGE_COMPLETE;

    private MultiSlider source;
    private double newValue;
    private Thumb thumb;

    /**
     * UiBinder implementations
     */
    private static Type<ChangeCompleteHandler> TYPE = new Type<ChangeCompleteHandler>(EVENT_NAME, null);

    public static Type<ChangeCompleteHandler> getType() {
        return TYPE;
    }

    public static Type<ChangeCompleteHandler> getAssociatedType() {
        return TYPE;
    }

    public ChangeCompleteEvent(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public ChangeCompleteEvent(MultiSlider source, double newValue, Thumb thumb, JavaScriptObject nativeEvent) {
        super(nativeEvent);
        this.source = source;
        this.thumb = thumb;
        this.newValue = newValue;
    }

    /**
     * @return the source
     */
    public MultiSlider getSource() {
        return source;
    }

    /**
     * @return the thumb
     */
    public Thumb getThumb() {
        return thumb;
    }

    /**
     * @return the newValue
     */
    public double getNewValue() {
        return newValue;
    }

}
