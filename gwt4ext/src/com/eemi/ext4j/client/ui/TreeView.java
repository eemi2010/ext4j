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
package com.eemi.ext4j.client.ui;

import com.eemi.ext4j.client.core.Component;
import com.eemi.ext4j.client.core.config.XType;
import com.eemi.ext4j.client.events.HandlerRegistration;
import com.eemi.ext4j.client.events.view.AfterItemCollapseHandler;
import com.eemi.ext4j.client.events.view.AfterItemExpandHandler;
import com.eemi.ext4j.client.events.view.NodeDragOverHandler;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * Used as a view by {@link TreePanel} .
 */
public class TreeView extends TableView {

    private static JavaScriptObject configPrototype;

    private native void init()/*-{
		var c = new $wnd.Ext.tree.View();
		@com.eemi.ext4j.client.ui.TreeView::configPrototype = c.initialConfig;
    }-*/;

    protected JavaScriptObject getConfigPrototype() {
        return configPrototype;
    }

    public String getXType() {
        return XType.TREE_VIEW.getValue();
    }

    /**
     * Create a new NotificationContainer.
     */
    public TreeView() {
        init();
    }

    protected TreeView(JavaScriptObject jsObj) {
        super(jsObj);
    }

    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.tree.View(config);
    }-*/;

    /**
     * Fires after an item has been visually collapsed and is no longer visible
     * in the tree.
     * 
     * @param handler
     *            , the handler that will handle the event
     */

    public native HandlerRegistration addAfterItemCollpaseHandler(AfterItemCollapseHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(n, index, item, e) {
			var node = @com.eemi.ext4j.client.data.NodeInterface::new(Lcom/google/gwt/core/client/JavaScriptObject;)(n);
			var event = @com.eemi.ext4j.client.events.view.AfterItemCollapseEvent::new(Lcom/eemi/ext4j/client/data/NodeInterface;ILcom/google/gwt/dom/client/Element;Lcom/google/gwt/core/client/JavaScriptObject;)(node,index,item,e);
			handler.@com.eemi.ext4j.client.events.view.AfterItemCollapseHandler::onAfterItemCollapse(Lcom/eemi/ext4j/client/events/view/AfterItemCollapseEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.view.AfterItemCollapseEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * Fires after an item has been visually expanded and is visible in the
     * tree.
     * 
     * @param handler
     *            , the handler that will handle the event
     */

    public native HandlerRegistration addAfterItemExpandHandler(AfterItemExpandHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(n, index, item, e) {
			var node = @com.eemi.ext4j.client.data.NodeInterface::new(Lcom/google/gwt/core/client/JavaScriptObject;)(n);
			var event = @com.eemi.ext4j.client.events.view.AfterItemExpandEvent::new(Lcom/eemi/ext4j/client/data/NodeInterface;ILcom/google/gwt/dom/client/Element;Lcom/google/gwt/core/client/JavaScriptObject;)(node,index,item,e);
			handler.@com.eemi.ext4j.client.events.view.AfterItemExpandHandler::onAfterItemExpand(Lcom/eemi/ext4j/client/events/view/AfterItemExpandEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.view.AfterItemExpandEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    public native HandlerRegistration addNodeDragOverHandler(NodeDragOverHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(n, position, data, e) {
			var node = @com.eemi.ext4j.client.data.NodeInterface::new(Lcom/google/gwt/core/client/JavaScriptObject;)(n);
			var event = @com.eemi.ext4j.client.events.view.NodeDragOverEvent::new(Lcom/eemi/ext4j/client/data/NodeInterface;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/core/client/JavaScriptObject;)(node, position,data,e);
			handler.@com.eemi.ext4j.client.events.view.NodeDragOverHandler::onNodeDragOver(Lcom/eemi/ext4j/client/events/view/NodeDragOverEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.view.NodeDragOverEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * Creates a new TableView from the given component
     * 
     * @param component
     *            , the component to cast from
     * @return, a new TableView from the component
     * 
     */
    public static TreeView cast(Component component) {
        return new TreeView(component.getOrCreateJsObj());
    }

}
