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
package com.ati.ext4j.client.fx.anim;

import com.ati.ext4j.client.core.Function;
import com.ati.ext4j.client.core.JsoHelper;
import com.ati.ext4j.client.core.config.BaseConfig;
import com.ati.ext4j.client.fx.easing.Easing;

public class Animation extends BaseConfig {

    public Animation() {

    }

    public Animation(int duration) {
        this();
        setDuration(duration);
    }

    public Animation(int duration, Easing easing) {
        this(duration);
        setEasing(easing);
    }

    public void setDuration(int value) {
        JsoHelper.setAttribute(jsObj, "duration", value);
    }

    public void setEasing(Easing easing) {
        setEasing(easing.getValue());
    }

    private void setEasing(String value) {
        JsoHelper.setAttribute(jsObj, "easing", value);
    }

    public native Animation setCallback(Function callback)/*-{
		var obj = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		obj.callback = $entry(function() {
			callback.@com.ati.ext4j.client.core.Function::execute()();
		});
		return this;
    }-*/;

}
