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

import com.ati.ext4j.client.core.config.BaseConfig;
import com.ati.ext4j.client.core.handlers.EventCallback;

/**
 * KeyNav configuration class.
 */
public class KeyNavConfig extends BaseConfig {

    /**
     * Register handler for the Enter key.
     * 
     * @param cb
     *            the key handler
     */
    public void onEnter(EventCallback cb) {
        _addCallback("enter", cb);
    }

    /**
     * Register handler for the Left arrow key.
     * 
     * @param cb
     *            the key handler
     */
    public void onLeft(EventCallback cb) {
        _addCallback("left", cb);
    }

    /**
     * Register handler for the Right arrow key.
     * 
     * @param cb
     *            the key handler
     */
    public void onRight(EventCallback cb) {
        _addCallback("right", cb);
    }

    /**
     * Register handler for the Up arrow key.
     * 
     * @param cb
     *            the key handler
     */
    public void onUp(EventCallback cb) {
        _addCallback("up", cb);
    }

    /**
     * Register handler for the Down arrow key.
     * 
     * @param cb
     *            the key handler
     */
    public void onDown(EventCallback cb) {
        _addCallback("down", cb);
    }

    /**
     * Register handler for the Tab key.
     * 
     * @param cb
     *            the key handler
     */
    public void onTab(EventCallback cb) {
        _addCallback("tab", cb);
    }

    /**
     * Register handler for the Esc key.
     * 
     * @param cb
     *            the key handler
     */
    public void onEsc(EventCallback cb) {
        _addCallback("esc", cb);
    }

    /**
     * Register handler for the PageUp key.
     * 
     * @param cb
     *            the key handler
     */
    public void onPageUp(EventCallback cb) {
        _addCallback("pageUp", cb);
    }

    /**
     * Register handler for the PageDown key.
     * 
     * @param cb
     *            the key handler
     */
    public void onPageDown(EventCallback cb) {
        _addCallback("pageDown", cb);
    }

    /**
     * Register handler for the Del key.
     * 
     * @param cb
     *            the key handler
     */
    public void onDel(EventCallback cb) {
        _addCallback("del", cb);
    }

    /**
     * Register handler for the Home key.
     * 
     * @param cb
     *            the key handler
     */
    public void onHome(EventCallback cb) {
        _addCallback("home", cb);
    }

    /**
     * Register handler for the End key.
     * 
     * @param cb
     *            the key handler
     */
    public void onEnd(EventCallback cb) {
        _addCallback("end", cb);
    }

    private native void _addCallback(String event, EventCallback cb) /*-{
		var config = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		config[event] = function(e) {
			var eJ = @com.ati.ext4j.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(e);
			cb.@com.ati.ext4j.client.core.handlers.EventCallback::execute(Lcom/ati/ext4j/client/core/EventObject;)(e);
		};
    }-*/;
}