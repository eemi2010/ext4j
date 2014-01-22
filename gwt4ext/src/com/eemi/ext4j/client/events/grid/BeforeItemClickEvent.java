/**
 * Ext4j UI Library Copyright 2014, Alain Ekambi, and individual contributors as
 * indicated by the @authors tag. See the copyright.txt in the distribution for
 * a full listing of individual contributors.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.eemi.ext4j.client.events.grid;

import com.eemi.ext4j.client.core.EventObject;
import com.eemi.ext4j.client.data.BaseModel;
import com.eemi.ext4j.client.events.Event;
import com.eemi.ext4j.client.ui.DataView;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class BeforeItemClickEvent extends EventObject {

    public static String EVENT_NAME = Event.BEFORE_ITEM_CLICK;

    private DataView source;
    private BaseModel record;
    private Element item;
    private int index;

    /**
     * UiBinder implementations
     */
    private static Type<BeforeItemClickHandler> TYPE = new Type<BeforeItemClickHandler>(EVENT_NAME, null);

    public static Type<BeforeItemClickHandler> getType() {
        return TYPE;
    }

    public static Type<BeforeItemClickHandler> getAssociatedType() {
        return TYPE;
    }

    public BeforeItemClickEvent(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public BeforeItemClickEvent(DataView source, BaseModel record, Element item, int index, JavaScriptObject nativeEvent) {
        super(nativeEvent);
        this.source = source;
        this.record = record;
        this.item = item;
        this.index = index;

    }

    /**
     * @return the source
     */
    public DataView getSource() {
        return source;
    }

    /**
     * @return the record
     */
    public BaseModel getRecord() {
        return record;
    }

    /**
     * @return the item
     */
    public Element getItem() {
        return item;
    }

    /**
     * @return the index
     */
    public int getIndex() {
        return index;
    }

}
