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
import com.google.gwt.event.dom.client.DomEvent.Type;

public class BeforeItemRemoveEvent extends EventObject {

    public static String EVENT_NAME = Event.BEFORE_ITEM_REMOVE;

    private NodeInterface node;
    private NodeInterface nodeToRemove;
    private boolean move;

    /**
     * UiBinder implementations
     */
    private static Type<BeforeItemRemoveHandler> TYPE = new Type<BeforeItemRemoveHandler>(EVENT_NAME, null);

    public static Type<BeforeItemRemoveHandler> getType() {
        return TYPE;
    }

    public static Type<BeforeItemRemoveHandler> getAssociatedType() {
        return TYPE;
    }

    public BeforeItemRemoveEvent(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public BeforeItemRemoveEvent(NodeInterface node, NodeInterface nodeToRemove, boolean move,
                    JavaScriptObject nativeEvent) {
        super(nativeEvent);
        this.node = node;
        this.nodeToRemove = nodeToRemove;
        this.move = move;
    }

    /**
     * @return the node
     */
    public NodeInterface getNode() {
        return node;
    }

    /**
     * @return the nodeToRemove
     */
    public NodeInterface getNodeToRemove() {
        return nodeToRemove;
    }

    /**
     * @return the move
     */
    public boolean isMove() {
        return move;
    }

}
