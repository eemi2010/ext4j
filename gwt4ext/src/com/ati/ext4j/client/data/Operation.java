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
package com.ati.ext4j.client.data;

import java.util.List;

import com.ati.ext4j.client.core.JsObject;
import com.ati.ext4j.client.data.proxy.Proxy;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * Represents a single read or write operation performed by a {@link Proxy}.
 * Operation objects are used to enable communication between Stores and
 * Proxies. Application developers should rarely need to interact with Operation
 * objects directly.
 * <p>
 * Several Operations can be batched together in a batch.
 * 
 */
public class Operation extends JsObject {

    public Operation() {
        jsObj = create();
    }

    public Operation(JavaScriptObject peer) {
        jsObj = peer;
    }

    public Operation(OperationConfig config) {
        jsObj = create(config.getJsObj());
    }

    public native boolean allowWrite()/*-{
		var obj = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		return obj.allowWrite();
    }-*/;

    public native boolean commitRecords(List<BaseModel> records)/*-{
		var obj = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		var data = @com.ati.ext4j.client.data.BaseModel::fromList(Ljava/util/List;)(records);
		return obj.commitRecords(data);
    }-*/;

    public native String getError()/*-{
		var obj = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		return obj.getError();
    }-*/;

    public native JavaScriptObject getErrorAsObject()/*-{
		var obj = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		return obj.getError();
    }-*/;

    public native List<BaseModel> getRecords()/*-{
		var obj = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		var data = obj.getRecords();
		return @com.ati.ext4j.client.data.BaseModel::fromJsArray(Lcom/google/gwt/core/client/JavaScriptObject;)(data);
    }-*/;

    public native ResutSet getResultSet()/*-{
		var obj = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		var r = obj.getResultSet();
		return @com.ati.ext4j.client.data.ResutSet::new(Lcom/google/gwt/core/client/JavaScriptObject;)(r);
    }-*/;

    public native boolean isComplete()/*-{
		var obj = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		return obj.isComplete();
    }-*/;

    public native boolean isRunning()/*-{
		var obj = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		return obj.isRunning();
    }-*/;

    public native boolean isStarted()/*-{
		var obj = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		return obj.isStarted();
    }-*/;

    public native void setCompleted()/*-{
		var obj = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		obj.setCompleted();
    }-*/;

    public native void setException()/*-{
		var obj = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		obj.setException();
    }-*/;

    public native void setException(String error)/*-{
		var obj = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		obj.setException(error);
    }-*/;

    public native void setException(JavaScriptObject error)/*-{
		var obj = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		obj.setException(error);
    }-*/;

    public native void setStarted()/*-{
		var obj = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		obj.setStarted();
    }-*/;

    public native void setSuccessful()/*-{
		var obj = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		obj.setSuccessful();
    }-*/;

    public native void wasSuccessful()/*-{
		var obj = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		obj.wasSuccessful();
    }-*/;

    private native JavaScriptObject create(JavaScriptObject config)/*-{
		return new $wnd.Ext.data.Operation(config);
    }-*/;

    private native JavaScriptObject create()/*-{
		return new $wnd.Ext.data.Operation();
    }-*/;

}
