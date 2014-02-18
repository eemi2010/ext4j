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
package com.ait.ext4j.client.util;

import com.ait.ext4j.client.core.JsObject;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;

/**
 * Provides a convenient wrapper for normalized keyboard navigation. KeyNav
 * allows you to bind navigation keys to function calls that will get called
 * when the keys are pressed, providing an easy way to implement custom
 * navigation schemes for any UI component.
 * <p/>
 * The following are all of the possible keys that can be implemented: enter,
 * left, right, up, down, tab, esc, pageUp, pageDown, del, home, end.
 * 
 */
public class KeyNav extends JsObject {

    public KeyNav(JavaScriptObject jsObj) {
        super(jsObj);
    }

    /**
     * Creates a new KeyNav isntance.
     * 
     * @param id
     *            the element ID
     * @param config
     *            the keynav configuration
     */
    public KeyNav(String id, KeyNavConfig config) {
        jsObj = create(id, config.getJsObj());
    }

    /**
     * Creates a new KeyNav isntance.
     * 
     * @param el
     *            the element
     * @param config
     *            the keynav configuration
     */
    public KeyNav(Element el, KeyNavConfig config) {
        jsObj = create(el, config.getJsObj());
    }

    private static native JavaScriptObject create(Element el, JavaScriptObject config) /*-{
		return new $wnd.Ext.KeyNav(el, config);
    }-*/;

    private static native JavaScriptObject create(String id, JavaScriptObject config) /*-{
		return new $wnd.Ext.KeyNav(id, config);
    }-*/;

    /**
     * Disable the KeyNav.
     */
    public native void disable() /*-{
		var kn = this.@com.ait.ext4j.client.core.JsObject::getJsObj()();
		kn.disable();
    }-*/;

    /**
     * Enable the KeyNav.
     */
    public native void enable() /*-{
		var kn = this.@com.ait.ext4j.client.core.JsObject::getJsObj()();
		kn.enable();
    }-*/;
}