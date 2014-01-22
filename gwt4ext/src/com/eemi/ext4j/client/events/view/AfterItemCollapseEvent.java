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
package com.eemi.ext4j.client.events.view;

import com.eemi.ext4j.client.core.EventObject;
import com.eemi.ext4j.client.data.NodeInterface;
import com.eemi.ext4j.client.events.Event;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class AfterItemCollapseEvent extends EventObject {

    public static String EVENT_NAME = Event.AFTER_ITEM_COLLAPSE;

    private NodeInterface node;
    private int index;
    private Element htmlElement;

    /**
     * UiBinder implementations
     */
    private static Type<AfterItemCollapseHandler> TYPE = new Type<AfterItemCollapseHandler>(EVENT_NAME, null);

    public static Type<AfterItemCollapseHandler> getType() {
        return TYPE;
    }

    public static Type<AfterItemCollapseHandler> getAssociatedType() {
        return TYPE;
    }

    public AfterItemCollapseEvent(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public AfterItemCollapseEvent(NodeInterface node, int index, Element htmlElement, JavaScriptObject nativeEvent) {
        super(nativeEvent);
        this.node = node;
        this.index = index;
        this.htmlElement = htmlElement;
    }

    /**
     * @return the node
     */
    public NodeInterface getNode() {
        return node;
    }

    /**
     * @return the index
     */
    public int getIndex() {
        return index;
    }

    /**
     * @return the htmlElement
     */
    public Element getHtmlElement() {
        return htmlElement;
    }

}
