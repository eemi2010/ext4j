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
package com.ati.ext4j.client.events.selection;

import com.ati.ext4j.client.core.EventObject;
import com.ati.ext4j.client.data.TableItem;
import com.ati.ext4j.client.events.Event;
import com.ati.ext4j.client.selection.SelectionModel;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class FocusChangeEvent extends EventObject {

    public static String EVENT_NAME = Event.FOCUS_CHANGE;

    private SelectionModel source;
    private TableItem oldFocused;
    private TableItem newFocused;

    /**
     * UiBinder implementations
     */
    private static Type<FocusChangeHandler> TYPE = new Type<FocusChangeHandler>(EVENT_NAME, null);

    public static Type<FocusChangeHandler> getType() {
        return TYPE;
    }

    public static Type<FocusChangeHandler> getAssociatedType() {
        return TYPE;
    }

    public FocusChangeEvent(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public FocusChangeEvent(SelectionModel source, TableItem oldFocused, TableItem newFocused,
                    JavaScriptObject nativeEvent) {
        super(nativeEvent);
        this.source = source;
        this.newFocused = newFocused;
        this.oldFocused = oldFocused;
    }

    /**
     * @return the source
     */
    public SelectionModel getSource() {
        return source;
    }

    /**
     * @return the oldFocused
     */
    public TableItem getOldFocused() {
        return oldFocused;
    }

    /**
     * @return the newFocused
     */
    public TableItem getNewFocused() {
        return newFocused;
    }

}
