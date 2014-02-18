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
package com.ait.ext4j.client.core.config;

import com.ait.ext4j.client.core.ExtElement;
import com.ait.ext4j.client.core.JsoHelper;

public class CallbackConfig extends BaseConfig {

    public void setStopEvent(boolean stopEvent) {
        JsoHelper.setAttribute(jsObj, "stopEvent", stopEvent);
    }

    public void setPreventDefault(boolean preventDefault) {
        JsoHelper.setAttribute(jsObj, "preventDefault", preventDefault);
    }

    public void setStopPropagation(boolean stopPropagation) {
        JsoHelper.setAttribute(jsObj, "stopPropagation", stopPropagation);
    }

    public void setDelay(int delay) {
        JsoHelper.setAttribute(jsObj, "delay", delay);
    }

    public void setSingle(boolean single) {
        JsoHelper.setAttribute(jsObj, "single", single);
    }

    public void setBuffer(int buffer) {
        JsoHelper.setAttribute(jsObj, "buffer", buffer);
    }

    public void setCapture(boolean buffer) {
        JsoHelper.setAttribute(jsObj, "capture", buffer);
    }

    public void setNormalized(boolean buffer) {
        JsoHelper.setAttribute(jsObj, "normalized", buffer);
    }

    public void setTarget(ExtElement el) {
        JsoHelper.setAttribute(jsObj, "target", el.getJsObj());
    }

}
