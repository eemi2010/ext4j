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
package com.ati.ext4j.client.core;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Provides useful information about the current browser.
 * 
 * @author alainekambi
 * 
 */
public class Browser extends JsObject {

    Browser(JavaScriptObject obj) {
        super(obj);
    }

    public native boolean is(String value) /*-{
		var peer = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		return peer.is(value);
    }-*/;

    public boolean isIE() {
        return is("IE");
    }

    public boolean isFireFox() {
        return is("Firefox");
    }

    public boolean isSafari() {
        return is("Safari");
    }

    public boolean isChrome() {
        return is("Chrome");
    }

    public boolean isOpera() {
        return is("Opera");
    }

    public boolean isWebKit() {
        return is("Webkit");
    }

    public boolean isGecko() {
        return is("Gecko");
    }

    public boolean isPresto() {
        return is("Presto");
    }

    public boolean isTrident() {
        return is("Trident");
    }

    public boolean isWebView() {
        return is("WebView");
    }

    public boolean isOther() {
        return is("Other");
    }
}
