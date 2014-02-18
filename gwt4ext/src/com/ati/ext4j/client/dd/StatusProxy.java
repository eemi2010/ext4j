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
package com.ati.ext4j.client.dd;

import com.ati.ext4j.client.core.ExtElement;
import com.ati.ext4j.client.core.JsObject;
import com.ati.ext4j.client.ui.Layer;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * 

 */
public class StatusProxy extends JsObject {

    public StatusProxy(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public StatusProxy() {
        jsObj = create(null);
    }

    protected native JavaScriptObject create(JavaScriptObject config)/*-{
		return new $wnd.Ext.dd.StatusProxy(config);
    }-*/;

    private static StatusProxy instance(JavaScriptObject jsObj) {
        return new StatusProxy(jsObj);
    }

    /**
     * Returns the underlying proxy {@link Layer}.
     * 
     * @return the underlying proxy Layer
     */
    public native Layer getEl() /*-{
		var proxy = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		var layer = proxy.getEl();
		return @com.ati.ext4j.client.ui.Layer::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(layer);
    }-*/;

    /**
     * Returns the ghost element.
     * 
     * @return the ghost element
     */
    public native ExtElement getGhost() /*-{
		var proxy = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		var ghost = proxy.getGhost();
		return @com.ati.ext4j.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(ghost);
    }-*/;

    public native void hide() /*-{
		var proxy = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		proxy.hide();
    }-*/;

    public native void hide(boolean clear) /*-{
		var proxy = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		proxy.hide(clear);
    }-*/;

    public native void reset() /*-{
		var proxy = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		proxy.reset();
    }-*/;

    public native void reset(boolean clearGhost) /*-{
		var proxy = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		proxy.reset(clearGhost);
    }-*/;

    public native void setStatus(String cssClass) /*-{
		var proxy = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		proxy.setStatus(cssClass);
    }-*/;

    public native void show() /*-{
		var proxy = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		proxy.show();
    }-*/;

    public native void stop() /*-{
		var proxy = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		proxy.stop();
    }-*/;

    public native void sync() /*-{
		var proxy = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		proxy.sync();
    }-*/;

    public native void update(String html) /*-{
		var proxy = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		proxy.update(html);
    }-*/;
}
