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
package com.ait.ext4j.client.events.selection;

import com.ait.ext4j.client.core.EventObject;
import com.ait.ext4j.client.data.BaseModel;
import com.ait.ext4j.client.events.Event;
import com.ait.ext4j.client.selection.SelectionModel;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class BeforeDeselectEvent extends EventObject {

    public static String EVENT_NAME = Event.BEFORE_DESELECT;

    private SelectionModel source;
    private BaseModel record;
    private int index;

    /**
     * UiBinder implementations
     */
    private static Type<BeforeDeselectHandler> TYPE = new Type<BeforeDeselectHandler>(EVENT_NAME, null);

    public static Type<BeforeDeselectHandler> getType() {
        return TYPE;
    }

    public static Type<BeforeDeselectHandler> getAssociatedType() {
        return TYPE;
    }

    public BeforeDeselectEvent(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public BeforeDeselectEvent(SelectionModel source, BaseModel record, int row, JavaScriptObject nativeEvent) {
        super(nativeEvent);
        this.source = source;
        this.record = record;
        this.index = row;
    }

    /**
     * @return the source
     */
    public SelectionModel getSource() {
        return source;
    }

    /**
     * @return the record
     */
    public BaseModel getRecord() {
        return record;
    }

    /**
     * @return the index
     */
    public int getIndex() {
        return index;
    }

}
