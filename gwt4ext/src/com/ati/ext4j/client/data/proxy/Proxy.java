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

import com.ati.ext4j.client.core.JsObject;
import com.ati.ext4j.client.core.JsoHelper;
import com.ati.ext4j.client.data.BaseModel;
import com.ati.ext4j.client.data.Operation;
import com.ati.ext4j.client.data.reader.Reader;
import com.ati.ext4j.client.data.writer.Writer;

/**
 * Proxies are used by Stores to handle the loading and saving of DataModel data.
 * Usually developers will not need to create or interact with proxies directly.
 */
public abstract class Proxy extends JsObject {

    public void setType(String value) {
        JsoHelper.setAttribute(jsObj, "type", value);
    }

    public native void create(Operation operation, ActionCallback callback)/*-{
		var proxy = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		proxy
				.create(
						operation.@com.ati.ext4j.client.core.JsObject::getJsObj()(),
						$entry(function(op) {
							var operation = @com.ati.ext4j.client.data.Operation::new(Lcom/google/gwt/core/client/JavaScriptObject;)(op);
							callback.@com.ati.ext4j.client.data.proxy.ActionCallback::onAction(Lcom/ati/ext4j/client/data/Operation;)(operation);
						}));
    }-*/;

    public native void destroy(Operation operation, ActionCallback callback)/*-{
		var proxy = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		proxy
				.destroy(
						operation.@com.ati.ext4j.client.core.JsObject::getJsObj()(),
						$entry(function(op) {
							var operation = @com.ati.ext4j.client.data.Operation::new(Lcom/google/gwt/core/client/JavaScriptObject;)(op);
							callback.@com.ati.ext4j.client.data.proxy.ActionCallback::onAction(Lcom/ati/ext4j/client/data/Operation;)(operation);
						}));
    }-*/;

    public native BaseModel getModel()/*-{
		var proxy = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		var obj = proxy.getModel();
		return @com.ati.ext4j.client.data.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
    }-*/;

    public native Reader getReader()/*-{
		var proxy = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		var obj = proxy.getReader();
		return @com.ati.ext4j.client.data.reader.Reader::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
    }-*/;

    public native Writer getWriter()/*-{
		var proxy = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		var obj = proxy.getReader();
		return @com.ati.ext4j.client.data.writer.Writer::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
    }-*/;

    public native void read(Operation operation, ActionCallback callback)/*-{
		var proxy = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		proxy
				.read(
						operation.@com.ati.ext4j.client.core.JsObject::getJsObj()(),
						$entry(function(op) {
							var operation = @com.ati.ext4j.client.data.Operation::new(Lcom/google/gwt/core/client/JavaScriptObject;)(op);
							callback.@com.ati.ext4j.client.data.proxy.ActionCallback::onAction(Lcom/ati/ext4j/client/data/Operation;)(operation);
						}));
    }-*/;

    public native void read(Operation operation)/*-{
		var proxy = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		proxy.read(
				operation.@com.ati.ext4j.client.core.JsObject::getJsObj()(),
				$entry(function() {

				}));
    }-*/;

    public native void update(Operation operation, ActionCallback callback)/*-{
		var proxy = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		proxy
				.update(
						operation.@com.ati.ext4j.client.core.JsObject::getJsObj()(),
						$entry(function(op) {
							var operation = @com.ati.ext4j.client.data.Operation::new(Lcom/google/gwt/core/client/JavaScriptObject;)(op);
							callback.@com.ati.ext4j.client.data.proxy.ActionCallback::onAction(Lcom/ati/ext4j/client/data/Operation;)(operation);
						}));
    }-*/;

    public native void setModel(BaseModel model, boolean setOnStore)/*-{
		var proxy = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		proxy.setModel(
				model.@com.ati.ext4j.client.core.JsObject::getJsObj()(),
				setOnStore);
    }-*/;

    public native void setModel(String model, boolean setOnStore)/*-{
		var proxy = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		proxy.setModel(model, setOnStore);
    }-*/;

    public native void setReader(Reader reader)/*-{
		var proxy = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		proxy
				.setReader(reader.@com.ati.ext4j.client.core.JsObject::getJsObj()());
    }-*/;

    public native void setWriter(Writer writer)/*-{
		var proxy = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		proxy
				.setReader(writer.@com.ati.ext4j.client.core.JsObject::getJsObj()());
    }-*/;

    public native String getMethod()/*-{
		var proxy = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		return proxy.getMethod();
    }-*/;

    // TODO MetaChancge Event

}
