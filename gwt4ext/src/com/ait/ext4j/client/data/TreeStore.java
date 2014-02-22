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
package com.ait.ext4j.client.data;

import java.util.List;

import com.ait.ext4j.client.core.JsoHelper;
import com.ait.ext4j.client.data.proxy.ProxyConfig;
import com.ait.ext4j.client.util.SorterConfig;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * This class is used as a container for a series of nodes. The nodes themselves
 * maintain the relationship between parent/child. The tree itself acts as a
 * manager. It gives functionality to retrieve a node by its identifier:
 * getNodeById.
 * <p>
 * The tree also relays events from any of it's child nodes, allowing them to be
 * handled in a centralized fashion. In general this class is not used directly,
 * rather used internally by other parts of the framework.
 */
public class TreeStore extends Store {

    public TreeStore() {
        create();
    }

    public TreeStore(List<? extends TableItem> data) {
        JavaScriptObject[] storeData = new JavaScriptObject[data.size()];
        for (int i = 0; i < data.size(); i++) {
            storeData[i] = data.get(i).getJsObj();
        }
        create(JsoHelper.arrayConvert(storeData), false);
    }

    public TreeStore(List<? extends TableItem> data, SorterConfig... sorters) {
        JavaScriptObject[] storeData = new JavaScriptObject[data.size()];
        for (int i = 0; i < data.size(); i++) {
            storeData[i] = data.get(i).getJsObj();
        }
        create(JsoHelper.arrayConvert(storeData), false, JsoHelper.arrayConvert(sorters));
    }

    public TreeStore(List<? extends TableItem> data, boolean expanded) {
        JavaScriptObject[] storeData = new JavaScriptObject[data.size()];
        for (int i = 0; i < data.size(); i++) {
            storeData[i] = data.get(i).getJsObj();
        }
        create(JsoHelper.arrayConvert(storeData), expanded);
    }

    public TreeStore(List<? extends TableItem> data, boolean expanded, SorterConfig... sorters) {
        JavaScriptObject[] storeData = new JavaScriptObject[data.size()];
        for (int i = 0; i < data.size(); i++) {
            storeData[i] = data.get(i).getJsObj();
        }
        create(JsoHelper.arrayConvert(storeData), expanded, JsoHelper.arrayConvert(sorters));
    }

    public TreeStore(ProxyConfig proxy, String root) {
        create(proxy, root, false);
    }

    public TreeStore(ProxyConfig proxy, String root, SorterConfig... sorterConfigs) {
        create(proxy, root, false, JsoHelper.arrayConvert(sorterConfigs));
    }

    public TreeStore(ProxyConfig proxy, TableItem root) {
        create(proxy, root);
    }

    public TreeStore(ProxyConfig proxy, String root, boolean expanded, SorterConfig... sorterConfigs) {
        create(proxy, root, expanded, JsoHelper.arrayConvert(sorterConfigs));
    }

    public TreeStore(JavaScriptObject obj) {
        super(obj);
    }

    public void setRootNode(TableItem model) {
        setRootNode(model.getJsObj());
    }

    private native void create()/*-{
		this.@com.ait.ext4j.client.core.JsObject::jsObj = new $wnd.Ext.data.TreeStore();
    }-*/;

    private native void create(JavaScriptObject values, boolean isExpanded)/*-{
		this.@com.ait.ext4j.client.core.JsObject::jsObj = new $wnd.Ext.data.TreeStore(
				{
					root : {
						expanded : isExpanded,
						children : values
					}
				});

    }-*/;

    private native void create(JavaScriptObject values, boolean isExpanded, JavaScriptObject sortersConfig)/*-{
		this.@com.ait.ext4j.client.core.JsObject::jsObj = new $wnd.Ext.data.TreeStore(
				{
					root : {
						expanded : isExpanded,
						children : values,
						sorters : sortersConfig
					}
				});

    }-*/;

    private native void create(ProxyConfig storeProxyConfig, String rootText, boolean rootExpanded)/*-{
		var peer = storeProxyConfig.@com.ait.ext4j.client.core.JsObject::getJsObj()();
		this.@com.ait.ext4j.client.core.JsObject::jsObj = new $wnd.Ext.data.TreeStore(
				{
					proxy : peer,
					root : {
						text : rootText,
						expanded : rootExpanded
					},
					sorters : [ {
						property : 'text',
						direction : 'ASC' //for descending change to 'DESC'
					} ]
				});
    }-*/;

    private native void create(ProxyConfig storeProxyConfig, String rootText, boolean rootExpanded,
                    JavaScriptObject storeSorters)/*-{
		var peer = storeProxyConfig.@com.ait.ext4j.client.core.JsObject::getJsObj()();
		this.@com.ait.ext4j.client.core.JsObject::jsObj = new $wnd.Ext.data.TreeStore(
				{
					proxy : peer,
					root : {
						text : rootText,
						expanded : rootExpanded
					},
					sorters : storeSorters
				});
    }-*/;

    private native void create(ProxyConfig storeProxyConfig, TableItem root)/*-{
		var peer = storeProxyConfig.@com.ait.ext4j.client.core.JsObject::getJsObj()();
		var rootPeer = root.@com.ait.ext4j.client.core.JsObject::getJsObj()();
		this.@com.ait.ext4j.client.core.JsObject::jsObj = new $wnd.Ext.data.TreeStore(
				{
					proxy : peer,
					root : rootPeer
				});
    }-*/;

    private native void create(ProxyConfig storeProxyConfig, TableItem root, JavaScriptObject storeSorters)/*-{
		var peer = storeProxyConfig.@com.ait.ext4j.client.core.JsObject::getJsObj()();
		var rootPeer = root.@com.ait.ext4j.client.core.JsObject::getJsObj()();
		this.@com.ait.ext4j.client.core.JsObject::jsObj = new $wnd.Ext.data.TreeStore(
				{
					proxy : peer,
					root : rootPeer,
					sorters : storeSorters
				});
    }-*/;

    private native void setRootNode(JavaScriptObject node)/*-{
		var jso = this.@com.ait.ext4j.client.core.JsObject::jsObj;
		jso.setRootNode(node);
    }-*/;

}
