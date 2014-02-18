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
package com.ati.ext4j.client.data.proxy;

import com.ati.ext4j.client.core.JsoHelper;
import com.ati.ext4j.client.data.Operation;
import com.ati.ext4j.client.data.reader.Reader;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * AjaxProxy is one of the most widely-used ways of getting data into your
 * application. It uses AJAX requests to load data from the server, usually to
 * be placed into a Store.
 * 
 */
public class AjaxProxy extends Proxy {

    public AjaxProxy() {
    }

    public AjaxProxy(String url) {
        JavaScriptObject obj = JsoHelper.createObject();
        JsoHelper.setAttribute(obj, "url", url);
        jsObj = create(obj);

    }

    public AjaxProxy(String url, Reader reader) {
        JavaScriptObject obj = JsoHelper.createObject();
        JsoHelper.setAttribute(obj, "url", url);
        JsoHelper.setAttribute(obj, "reader", reader.getJsObj());
        jsObj = create(obj);
    }

    public AjaxProxy(ProxyConfig config) {
        jsObj = create(config.getJsObj());
    }

    public native void doRequest(Operation operation, ActionCallback callback)/*-{
		var proxy = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		proxy
				.doRequest(
						operation.@com.ati.ext4j.client.core.JsObject::getJsObj()(),
						$entry(function(op) {
							var operation = @com.ati.ext4j.client.data.Operation::new(Lcom/google/gwt/core/client/JavaScriptObject;)(op);
							callback.@com.ati.ext4j.client.data.proxy.ActionCallback::onAction(Lcom/ati/ext4j/client/data/Operation;)(operation);
						}));
    }-*/;

    public native String getMethod()/*-{
		var proxy = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		return proxy.getMethod();
    }-*/;

    private native JavaScriptObject create(JavaScriptObject config)/*-{
		return new $wnd.Ext.data.proxy.Ajax(config);
    }-*/;

}
