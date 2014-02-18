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
package com.ati.ext4j.client.events.view;

import com.ati.ext4j.client.core.EventObject;
import com.ati.ext4j.client.core.ExtElement;
import com.ati.ext4j.client.events.Event;
import com.ati.ext4j.client.ui.DataView;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class HighlightItemEvent extends EventObject {

    public static String EVENT_NAME = Event.HIGHLIGHT_ITEM;

    private DataView view;
    private ExtElement element;

    /**
     * UiBinder implementations
     */
    private static Type<HighlightItemHandler> TYPE = new Type<HighlightItemHandler>(EVENT_NAME, null);

    public static Type<HighlightItemHandler> getType() {
        return TYPE;
    }

    public static Type<HighlightItemHandler> getAssociatedType() {
        return TYPE;
    }

    public HighlightItemEvent(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public HighlightItemEvent(DataView view, ExtElement element, JavaScriptObject nativeEvent) {
        super(nativeEvent);
        this.view = view;
        this.element = element;

    }

    /**
     * @return the view
     */
    public DataView getView() {
        return view;
    }

    /**
     * @return the element
     */
    public ExtElement getElement() {
        return element;
    }

}
