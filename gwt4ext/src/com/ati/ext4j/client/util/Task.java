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
package com.ati.ext4j.client.util;

import com.ati.ext4j.client.core.Function;
import com.ati.ext4j.client.core.JsObject;
import com.ati.ext4j.client.core.JsoHelper;

public class Task extends JsObject {

    public Task() {
        jsObj = JsoHelper.createObject();
    }

    /**
     * The function to execute each time the task is invoked
     */
    public native void setRunner(Function taskRunner)/*-{
		var peer = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		peer.run = function() {
			taskRunner.@com.ati.ext4j.client.core.Function::execute()();
		};
    }-*/;

    /**
     * The frequency in milliseconds with which the task should be invoked.
     */
    public native void setInterval(int value)/*-{
		var peer = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		peer.interval = value;
    }-*/;

    /**
     * The length of time in milliseconds to invoke the task before stopping
     * automatically (defaults to indefinite).
     */
    public native void setDuration(int value)/*-{
		var peer = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		peer.duration = value;
    }-*/;

    /**
     * The number of times to invoke the task before stopping automatically
     * (defaults to indefinite).
     */
    public native void setRepeat(int value)/*-{
		var peer = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		peer.repeat = value;
    }-*/;

}
