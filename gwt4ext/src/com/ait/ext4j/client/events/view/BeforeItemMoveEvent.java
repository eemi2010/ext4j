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
package com.ait.ext4j.client.events.view;

import com.ait.ext4j.client.core.EventObject;
import com.ait.ext4j.client.data.NodeInterface;
import com.ait.ext4j.client.events.Event;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class BeforeItemMoveEvent extends EventObject {

    public static String EVENT_NAME = Event.BEFORE_ITEM_MOVE;

    private NodeInterface node;
    private NodeInterface oldParent;
    private NodeInterface newParent;
    private int index;

    /**
     * UiBinder implementations
     */
    private static Type<BeforeItemMoveHandler> TYPE = new Type<BeforeItemMoveHandler>(EVENT_NAME, null);

    public static Type<BeforeItemMoveHandler> getType() {
        return TYPE;
    }

    public static Type<BeforeItemMoveHandler> getAssociatedType() {
        return TYPE;
    }

    public BeforeItemMoveEvent(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public BeforeItemMoveEvent(NodeInterface node, NodeInterface oldParent, NodeInterface newParent, int index,
                    JavaScriptObject nativeEvent) {
        super(nativeEvent);
        this.node = node;
        this.oldParent = oldParent;
        this.newParent = newParent;
        this.index = index;
    }

    /**
     * @return the node
     */
    public NodeInterface getNode() {
        return node;
    }

    /**
     * @return the oldParent
     */
    public NodeInterface getOldParent() {
        return oldParent;
    }

    /**
     * @return the newParent
     */
    public NodeInterface getNewParent() {
        return newParent;
    }

    /**
     * @return the index
     */
    public int getIndex() {
        return index;
    }

}
