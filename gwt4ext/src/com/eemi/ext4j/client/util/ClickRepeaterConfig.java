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
package com.eemi.ext4j.client.util;

import com.eemi.ext4j.client.core.JsoHelper;
import com.eemi.ext4j.client.core.config.BaseConfig;
import com.google.gwt.dom.client.Element;

/**
 * ClickRepeater configuration class.
 * 
 */
public class ClickRepeaterConfig extends BaseConfig {

    /**
     * True if autorepeating should start slowly and accelerate. "interval" and
     * "delay" are ignored. "immediate" is honored.
     * 
     * @param accelerate
     *            true to start slowly and accelerate
     */
    public void setAccelerate(boolean accelerate) {
        JsoHelper.setAttribute(jsObj, "accelerate", accelerate);
    }

    /**
     * The initial delay before the repeating event begins firing. Similar to an
     * autorepeat key delay.
     * 
     * @param delay
     *            delay in milliseconds. Default is 250
     */
    public void setDelay(int delay) {
        JsoHelper.setAttribute(jsObj, "delay", delay);
    }

    /**
     * The element to act as a button.
     * 
     * @param element
     *            the element
     */
    public void setElement(Element element) {
        JsoHelper.setAttribute(jsObj, "el", element);
    }

    /**
     * The element to act as a button.
     * 
     * @param elementID
     *            the element ID
     */
    public void setElement(String elementID) {
        JsoHelper.setAttribute(jsObj, "el", elementID);
    }

    /**
     * The interval between firings of the "click" event. Default is 10
     * milliseconds.
     * 
     * @param interval
     *            the firing interval
     */
    public void setInterval(int interval) {
        JsoHelper.setAttribute(jsObj, "interval", interval);
    }

    /**
     * A CSS class name to be applied to the element while pressed.
     * 
     * @param pressClass
     *            the press CSS class
     */
    public void setPressClass(String pressClass) {
        JsoHelper.setAttribute(jsObj, "pressClass", pressClass);
    }

    /**
     * True to prevent the default click event. Default is true.
     * 
     * @param preventDefault
     *            true to prevent default click
     */
    public void setPreventDefault(boolean preventDefault) {
        JsoHelper.setAttribute(jsObj, "preventDefault", preventDefault);
    }

    /**
     * True to stop the default click event. Default is false.
     * 
     * @param stopDefault
     *            true to stop default click event
     */
    public void setStopDefault(boolean stopDefault) {
        JsoHelper.setAttribute(jsObj, "stopDefault", stopDefault);
    }
}
