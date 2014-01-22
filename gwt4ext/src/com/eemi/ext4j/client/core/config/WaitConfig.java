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
package com.eemi.ext4j.client.core.config;

import com.eemi.ext4j.client.core.Function;
import com.eemi.ext4j.client.core.JsoHelper;
import com.google.gwt.core.client.JavaScriptObject;

public class WaitConfig extends BaseConfig {

    public WaitConfig() {

    }

    public void setDuration(int value) {
        JsoHelper.setAttribute(jsObj, "duration", value);
    }

    public void setInterval(int value) {
        JsoHelper.setAttribute(jsObj, "interval", value);
    }

    public void setIncrement(int value) {
        JsoHelper.setAttribute(jsObj, "increment", value);
    }

    public void setText(String value) {
        JsoHelper.setAttribute(jsObj, "text", value);
    }

    public void setCallback(Function fn) {
        JsoHelper.setAttribute(jsObj, "fn", getFn(fn));
    }

    private final native JavaScriptObject getFn(Function fn)/*-{
		return function() {
			fn.@com.eemi.ext4j.client.core.Function::execute()();
		};
    }-*/;

}
