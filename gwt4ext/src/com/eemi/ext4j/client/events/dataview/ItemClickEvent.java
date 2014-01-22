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
package com.eemi.ext4j.client.events.dataview;

import com.eemi.ext4j.client.core.EventObject;
import com.eemi.ext4j.client.data.BaseModel;
import com.eemi.ext4j.client.ui.DataView;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.DomEvent.Type;

/**
 * Events that s fired when an item is clicked on a {@link DataView}
 * 
 * @author alainekambi
 * 
 */
public class ItemClickEvent extends EventObject {

    public static String EVENT_NAME = "itemclick";

    private DataView source;
    private BaseModel data;
    private Element element;
    private int index;

    private static Type<ItemClickHandler> TYPE = new Type<ItemClickHandler>(EVENT_NAME, null);

    public static Type<ItemClickHandler> getType() {
        return TYPE;
    }

    public static Type<ItemClickHandler> getAssociatedType() {
        return TYPE;
    }

    public ItemClickEvent(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public ItemClickEvent(DataView source, BaseModel data, Element element, int index, JavaScriptObject nativeEvent) {
        super(nativeEvent);
        this.source = source;
        this.data = data;
        this.element = element;
        this.index = index;
    }

    /**
     * @return the source
     */
    public DataView getSource() {
        return source;
    }

    /**
     * @return the data
     */
    public BaseModel getData() {
        return data;
    }

    /**
     * @return the element
     */
    public Element getElement() {
        return element;
    }

    /**
     * @return the index
     */
    public int getIndex() {
        return index;
    }

}
