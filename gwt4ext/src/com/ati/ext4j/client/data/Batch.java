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

import java.util.ArrayList;
import java.util.List;

import com.ati.ext4j.client.core.JsObject;
import com.ati.ext4j.client.core.JsoHelper;
import com.ati.ext4j.client.data.handlers.BatchCallback;
import com.ati.ext4j.client.data.proxy.Proxy;
import com.ati.ext4j.client.events.Event;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * Provides a mechanism to run one or more operations in a given order. Fires
 * the 'operationcomplete' event after the completion of each Operation, and the
 * 'complete' event when all Operations have been successfully executed. Fires
 * an 'exception' event if any of the Operations encounter an exception.
 * <p>
 * Usually these are only used internally by {@link Proxy} classes
 * 
 */
public class Batch extends JsObject {

    public Batch() {
        jsObj = create();
    }

    public Batch(JavaScriptObject peer) {
        jsObj = peer;
    }

    public Batch(boolean autoStart, boolean pauseOnException) {
        jsObj = create(autoStart, pauseOnException);
    }

    private native JavaScriptObject create()/*-{
		return new $wnd.data.Batch();
    }-*/;

    public int getCurrent() {
        return JsoHelper.getAttributeAsInt(jsObj, "current");
    }

    public void setCurrent(int value) {
        JsoHelper.setAttribute(jsObj, "current", value);
    }

    public boolean hasException() {
        return JsoHelper.getAttributeAsBoolean(jsObj, "hasException");
    }

    public List<Operation> getExeptions() {
        List<Operation> toReturn = new ArrayList<Operation>();
        JavaScriptObject peers = JsoHelper.getAttributeAsJavaScriptObject(jsObj, "exceptions");
        int size = JsoHelper.arrayLength(peers);
        for (int i = 0; i < size; i++) {
            toReturn.add(new Operation(JsoHelper.getValueFromJavaScriptObjectArray(peers, i)));
        }
        return toReturn;
    }

    public boolean isComplete() {
        return JsoHelper.getAttributeAsBoolean(jsObj, "isComplete");
    }

    public boolean isRunning() {
        return JsoHelper.getAttributeAsBoolean(jsObj, "isRunning");
    }

    public List<Operation> getOperations() {
        List<Operation> toReturn = new ArrayList<Operation>();
        JavaScriptObject peers = JsoHelper.getAttributeAsJavaScriptObject(jsObj, "operations");
        int size = JsoHelper.arrayLength(peers);
        for (int i = 0; i < size; i++) {
            toReturn.add(new Operation(JsoHelper.getValueFromJavaScriptObjectArray(peers, i)));
        }
        return toReturn;
    }

    public double getTotal() {
        return JsoHelper.getAttributeAsFloat(jsObj, "total");
    }

    public native Batch add(Operation opertion)/*-{
		var batch = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		batch.add(opertion.@com.ati.ext4j.client.core.JsObject::getJsObj()());
		return this;
    }-*/;

    public native Batch pause()/*-{
		var batch = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		batch.pause();
		return this;
    }-*/;

    public native Batch retry()/*-{
		var batch = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		batch.retry();
		return this;
    }-*/;

    public native Batch runOperation(int index)/*-{
		var batch = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		batch.runOperation(index);
		return this;
    }-*/;

    public native Batch start(int index)/*-{
		var batch = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		batch.start(index);
		return this;
    }-*/;

    public void addCompleteHandler(BatchCallback callback) {
        addCallback(Event.COMPLETE, callback);
    }

    public void addExceptionHandler(BatchCallback callback) {
        addCallback(Event.EXCEPTION, callback);
    }

    public void addOperationComplete(BatchCallback callback) {
        addCallback(Event.OPERATION_COMPLETE, callback);
    }

    private native void addCallback(String event, BatchCallback cb)/*-{
		var batch = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		batch
				.addEventListener(
						event,
						$entry(function(b, op) {
							var batch = @com.ati.ext4j.client.data.Batch::new(Lcom/google/gwt/core/client/JavaScriptObject;)(b);
							var operation = @com.ati.ext4j.client.data.Operation::new(Lcom/google/gwt/core/client/JavaScriptObject;)(op);
							cb.@com.ati.ext4j.client.data.handlers.BatchCallback::onEvent(Lcom/ati/ext4j/client/data/Batch;Lcom/ati/ext4j/client/data/Operation;)(batch,operation);
						}));
    }-*/;

    private native JavaScriptObject create(boolean autoStart, boolean pauseOnException)/*-{
		return new $wnd.data.Batch({
			autoStart : autoStart,
			pauseOnException : pauseOnException
		});
    }-*/;

}
