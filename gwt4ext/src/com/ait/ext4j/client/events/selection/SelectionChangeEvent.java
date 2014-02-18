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

import java.util.List;

import com.ait.ext4j.client.core.EventObject;
import com.ait.ext4j.client.data.TableItem;
import com.ait.ext4j.client.events.Event;
import com.ait.ext4j.client.selection.SelectionModel;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class SelectionChangeEvent extends EventObject {

    public static String EVENT_NAME = Event.SELECTION_CHANGE;

    private SelectionModel source;
    private List<TableItem> selection;

    /**
     * UiBinder implementations
     */
    private static Type<SelectionChangeHandler> TYPE = new Type<SelectionChangeHandler>(EVENT_NAME, null);

    public static Type<SelectionChangeHandler> getType() {
        return TYPE;
    }

    public static Type<SelectionChangeHandler> getAssociatedType() {
        return TYPE;
    }

    public SelectionChangeEvent(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public SelectionChangeEvent(SelectionModel source, List<TableItem> selection, JavaScriptObject nativeEvent) {
        super(nativeEvent);
        this.source = source;
        this.selection = selection;
    }

    /**
     * @return the source
     */
    public SelectionModel getSource() {
        return source;
    }

    /**
     * @return the selection
     */
    public List<TableItem> getSelection() {
        return selection;
    }

}
