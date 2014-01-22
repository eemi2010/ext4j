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

public class NodeDragOverEvent extends EventObject {

    public static String EVENT_NAME = Event.NODE_DRAG_OVER;

    private NodeInterface target;
    private String position;
    private JavaScriptObject dragData;

    /**
     * UiBinder implementations
     */
    private static Type<NodeDragOverHandler> TYPE = new Type<NodeDragOverHandler>(EVENT_NAME, null);

    public static Type<NodeDragOverHandler> getType() {
        return TYPE;
    }

    public static Type<NodeDragOverHandler> getAssociatedType() {
        return TYPE;
    }

    public NodeDragOverEvent(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public NodeDragOverEvent(NodeInterface node, String position, JavaScriptObject dragData,
                    JavaScriptObject nativeEvent) {
        super(nativeEvent);
        this.target = node;
        this.position = position;
        this.dragData = dragData;
    }

    /**
     * @return the target
     */
    public NodeInterface getSource() {
        return target;
    }

    /**
     * @return the position
     */
    public String getPosition() {
        return position;
    }

    /**
     * @return the dragData
     */
    public JavaScriptObject getDragData() {
        return dragData;
    }

}
