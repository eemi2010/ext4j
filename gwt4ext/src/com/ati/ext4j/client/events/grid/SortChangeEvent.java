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
package com.ati.ext4j.client.events.grid;

import com.ati.ext4j.client.core.EventObject;
import com.ati.ext4j.client.events.Event;
import com.ati.ext4j.client.grid.HeaderContainer;
import com.ati.ext4j.client.grid.column.GridColumn;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class SortChangeEvent extends EventObject {

    public static String EVENT_NAME = Event.SORT_CHANGE;

    private HeaderContainer source;
    private GridColumn column;
    private String direction;

    /**
     * UiBinder implementations
     */
    private static Type<SortChangeHandler> TYPE = new Type<SortChangeHandler>(EVENT_NAME, null);

    public static Type<SortChangeHandler> getType() {
        return TYPE;
    }

    public static Type<SortChangeHandler> getAssociatedType() {
        return TYPE;
    }

    public SortChangeEvent(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public SortChangeEvent(HeaderContainer source, GridColumn column, String direction, JavaScriptObject nativeEvent) {
        super(nativeEvent);
        this.source = source;
        this.column = column;
        this.direction = direction;

    }

    /**
     * @return the source
     */
    public HeaderContainer getHeaderContainer() {
        return source;
    }

    /**
     * @return the column
     */
    public GridColumn getColumn() {
        return column;
    }

    /**
     * @return the direction
     */
    public String getDirection() {
        return direction;
    }

}
