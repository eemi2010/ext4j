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

import java.util.List;

import com.ati.ext4j.client.core.EventObject;
import com.ati.ext4j.client.data.BaseModel;
import com.ati.ext4j.client.data.NodeInterface;
import com.ati.ext4j.client.data.TreeStore;
import com.ati.ext4j.client.events.Event;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class LoadEvent extends EventObject {

    public static String EVENT_NAME = Event.LOAD;

    private TreeStore store;
    private NodeInterface node;
    private List<BaseModel> records;
    private boolean successful;

    /**
     * UiBinder implementations
     */
    private static Type<LoadHandler> TYPE = new Type<LoadHandler>(EVENT_NAME, null);

    public static Type<LoadHandler> getType() {
        return TYPE;
    }

    public static Type<LoadHandler> getAssociatedType() {
        return TYPE;
    }

    public LoadEvent(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public LoadEvent(TreeStore store, NodeInterface node, List<BaseModel> records, boolean successful,
                    JavaScriptObject nativeEvent) {
        super(nativeEvent);
        this.store = store;
        this.node = node;
        this.records = records;
        this.successful = successful;

    }

    /**
     * @return the store
     */
    public TreeStore getStore() {
        return store;
    }

    /**
     * @return the node
     */
    public NodeInterface getNode() {
        return node;
    }

    /**
     * @return the records
     */
    public List<BaseModel> getRecords() {
        return records;
    }

    /**
     * @return the successful
     */
    public boolean isSuccessful() {
        return successful;
    }

}
