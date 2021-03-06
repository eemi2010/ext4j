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
package com.ait.ext4j.client.events.grid;

import com.ait.ext4j.client.core.EventObject;
import com.ait.ext4j.client.events.Event;
import com.ait.ext4j.client.grid.HeaderContainer;
import com.ait.ext4j.client.grid.column.GridColumn;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class ColumnHideEvent extends EventObject {

    public static String EVENT_NAME = Event.COLUMN_HIDE;

    private HeaderContainer source;
    private GridColumn column;

    /**
     * UiBinder implementations
     */
    private static Type<ColumnHideHandler> TYPE = new Type<ColumnHideHandler>(EVENT_NAME, null);

    public static Type<ColumnHideHandler> getType() {
        return TYPE;
    }

    public static Type<ColumnHideHandler> getAssociatedType() {
        return TYPE;
    }

    public ColumnHideEvent(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public ColumnHideEvent(HeaderContainer source, GridColumn column, JavaScriptObject nativeEvent) {
        super(nativeEvent);
        this.source = source;
        this.column = column;

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

}
