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
package com.ati.ext4j.client.events.grid;

import com.ati.ext4j.client.core.EventObject;
import com.ati.ext4j.client.data.BaseModel;
import com.ati.ext4j.client.events.Event;
import com.ati.ext4j.client.ui.TableView;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class CellDoubleClickEvent extends EventObject {

    public static String EVENT_NAME = Event.CELL_DOUBLE_CLICK;
    private Element td;
    private int cellIndex;
    private BaseModel record;
    private Element tr;
    private int rowIndex;

    private TableView source;

    /**
     * UiBinder implementations
     */
    private static Type<CellDoubleClickHandler> TYPE = new Type<CellDoubleClickHandler>(EVENT_NAME, null);

    public static Type<CellDoubleClickHandler> getType() {
        return TYPE;
    }

    public static Type<CellDoubleClickHandler> getAssociatedType() {
        return TYPE;
    }

    public CellDoubleClickEvent(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public CellDoubleClickEvent(TableView source, Element td, int cellIndex, BaseModel record, Element tr,
                    int rowIndex, JavaScriptObject nativeEvent) {
        super(nativeEvent);
        this.source = source;
        this.td = td;
        this.cellIndex = cellIndex;
        this.record = record;
        this.rowIndex = rowIndex;
        this.tr = tr;
    }

    /**
     * @return the source
     */
    public TableView getSource() {
        return source;
    }

    /**
     * @return the td
     */
    public Element getTd() {
        return td;
    }

    /**
     * @return the cellIndex
     */
    public int getCellIndex() {
        return cellIndex;
    }

    /**
     * @return the record
     */
    public BaseModel getRecord() {
        return record;
    }

    /**
     * @return the tr
     */
    public Element getTr() {
        return tr;
    }

    /**
     * @return the rowIndex
     */
    public int getRowIndex() {
        return rowIndex;
    }

}
