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
import com.ati.ext4j.client.data.NodeInterface;
import com.ati.ext4j.client.events.Event;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class ItemAppendEvent extends EventObject {

    public static String EVENT_NAME = Event.ITEM_APPEND;

    private NodeInterface node;
    private NodeInterface newNode;
    private int index;

    /**
     * UiBinder implementations
     */
    private static Type<ItemAppendHandler> TYPE = new Type<ItemAppendHandler>(EVENT_NAME, null);

    public static Type<ItemAppendHandler> getType() {
        return TYPE;
    }

    public static Type<ItemAppendHandler> getAssociatedType() {
        return TYPE;
    }

    public ItemAppendEvent(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public ItemAppendEvent(NodeInterface node, NodeInterface nodeToAppend, int index, JavaScriptObject nativeEvent) {
        super(nativeEvent);
        this.node = node;
        this.newNode = nodeToAppend;
        this.index = index;
    }

    /**
     * @return the node
     */
    public NodeInterface getNode() {
        return node;
    }

    /**
     * @return the nodeToAppend
     */
    public NodeInterface getNodeToAppend() {
        return newNode;
    }

    /**
     * @return the index
     */
    public int getIndex() {
        return index;
    }

}