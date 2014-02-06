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
package com.eemi.ext4j.client.data;

import java.util.ArrayList;
import java.util.List;

import com.eemi.ext4j.client.core.JsoHelper;
import com.eemi.ext4j.client.data.handlers.BubbleHandler;
import com.eemi.ext4j.client.data.handlers.NodeQueryHandler;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

/**
 * This class is used as a set of methods that are applied to the prototype of a
 * DataModel to decorate it with a Node API. This means that models used in
 * conjunction with a tree will have all of the tree related methods available
 * on the model. In general this class will not be used directly by the
 * developer. This class also creates extra fields on the model if they do not
 * exist, to help maintain the tree state and UI. These fields are documented as
 * config options.
 * 
 * @Since Ext4
 * 
 */
public class NodeInterface extends BaseModel {

    protected NodeInterface() {
        jsObj = JsoHelper.createObject();
    }

    protected NodeInterface(JavaScriptObject obj) {
        super(obj);
    }

    public native void expand()/*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::jsObj;
		jso.expand();
    }-*/;

    /**
     * Bubbles up the tree from this node, calling the specified function with
     * each node. The arguments to the function will be the args provided or the
     * current node. If the function returns false at any point, the bubble is
     * stopped.
     * 
     * @Since Ext4
     * 
     * @param handler
     *            , the handler to be called when traversing each node
     */
    public native void bubble(BubbleHandler handler)/*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::jsObj;
		if (jso) {
			jso
					.bubble($entry(function(node) {
						var nodeObject = @com.eemi.ext4j.client.data.NodeInterface::new(Lcom/google/gwt/core/client/JavaScriptObject;)(node);
						handler.@com.eemi.ext4j.client.data.handlers.BubbleHandler::onNodeTraverse(Lcom/eemi/ext4j/client/data/NodeInterface;)(nodeObject);
					}));
		}

    }-*/;

    public native NodeInterface findChildBy(NodeQueryHandler handler)/*-{
		var me = this;
		var jso = this.@com.eemi.ext4j.client.core.JsObject::jsObj;
		var obj = jso
				.findChildBy(
						$entry(function(node) {
							//$wnd.console.log(node);
							var nodeObject = @com.eemi.ext4j.client.data.TableItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(node);
							return handler.@com.eemi.ext4j.client.data.handlers.NodeQueryHandler::onNodeTraversal(Lcom/eemi/ext4j/client/data/TableItem;)(nodeObject);
						}), this, true);
		return @com.eemi.ext4j.client.data.NodeInterface::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
    }-*/;

    public native NodeInterface findChildBy(NodeQueryHandler handler, boolean deep)/*-{
		var me = this;
		var jso = this.@com.eemi.ext4j.client.core.JsObject::jsObj;
		var obj = jso
				.findChildBy(
						$entry(function(node) {
							var nodeObject = @com.eemi.ext4j.client.data.TableItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(node);
							return handler.@com.eemi.ext4j.client.data.handlers.NodeQueryHandler::onNodeTraversal(Lcom/eemi/ext4j/client/data/TableItem;)(nodeObject);
						}), me, deep);
		return @com.eemi.ext4j.client.data.NodeInterface::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
    }-*/;

    public native NodeInterface findChild(String attribute, String value)/*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::jsObj;
		var obj = jso.findChild(attribute, value);
		return @com.eemi.ext4j.client.data.NodeInterface::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
    }-*/;

    public native NodeInterface findChild(String attribute, String value, boolean deep)/*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::jsObj;
		var obj = jso.findChild(attribute, value, deep);
		return @com.eemi.ext4j.client.data.NodeInterface::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
    }-*/;

    static JsArray<JavaScriptObject> fromListOfNode(List<NodeInterface> models) {
        JsArray<JavaScriptObject> values = JsArray.createArray().cast();
        for (NodeInterface model : models) {
            values.push(model.getJsObj());
        }
        return values;
    }

    public static List<NodeInterface> fromJavaScriptArray(JavaScriptObject array) {
        List<NodeInterface> toReturn = new ArrayList<NodeInterface>();
        int size = JsoHelper.getArrayLength(array);
        for (int i = 0; i < size; i++) {
            JavaScriptObject peer = JsoHelper.getValueFromJavaScriptObjectArray(array, i);
            toReturn.add(new NodeInterface(peer));
        }
        return toReturn;
    }

}
