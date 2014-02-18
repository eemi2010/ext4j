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
package com.ait.ext4j.client.events.grid;

import java.util.List;

import com.ait.ext4j.client.core.EventObject;
import com.ait.ext4j.client.data.Store;
import com.ait.ext4j.client.events.Event;
import com.ait.ext4j.client.util.Filter;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class FilterChangeEvent extends EventObject {

    public static String EVENT_NAME = Event.FILTER_CHANGE;
    private Store store;
    private List<Filter> filters;

    /**
     * UiBinder implementations
     */
    private static Type<FilterChangeHandler> TYPE = new Type<FilterChangeHandler>(EVENT_NAME, null);

    public static Type<FilterChangeHandler> getType() {
        return TYPE;
    }

    public static Type<FilterChangeHandler> getAssociatedType() {
        return TYPE;
    }

    public FilterChangeEvent(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public FilterChangeEvent(Store store, List<Filter> filters, JavaScriptObject nativeEvent) {
        super(nativeEvent);
        this.store = store;
        this.filters = filters;
    }

    /**
     * @return the store
     */
    public Store getStore() {
        return store;
    }

    /**
     * @return the filters
     */
    public List<Filter> getFilters() {
        return filters;
    }

}
