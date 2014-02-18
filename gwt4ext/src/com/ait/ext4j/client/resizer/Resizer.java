/**
 * Ext4j UI Library Copyright 2014, Alain Ekambi, and individual contributors as
 * indicated by the @authors tag. See the copyright.txt in the distribution for
 * a full listing of individual contributors.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.ait.ext4j.client.resizer;

import com.ait.ext4j.client.core.Component;
import com.ait.ext4j.client.core.ExtElement;
import com.ait.ext4j.client.core.ObservableJso;
import com.ait.ext4j.client.events.resizer.BeforeResizeHandler;
import com.ait.ext4j.client.events.resizer.ResizeHandler;
import com.google.gwt.core.client.JavaScriptObject;

public class Resizer extends ObservableJso {

    private Resizer(ResizerConfig config) {
        jsObj = createNativePeer(config.getJsObj());
    }

    public static Resizer create(ResizerConfig config) {
        return new Resizer(config);
    }

    protected Resizer(JavaScriptObject obj) {
        jsObj = obj;
    }

    /**
     * Returns the element that was configured with the el or target config
     * property. If a component was configured with the target property then
     * this will return the element of this component.
     * <p>
     * Textarea and img elements will be wrapped with an additional div because
     * these elements do not support child nodes. The original element can be
     * accessed through the originalTarget property.
     */
    public native ExtElement getEl()/*-{
		var obj = this.@com.ait.ext4j.client.core.JsObject::getJsObj()();
		var peer = obj.getEl();
		return @com.ait.ext4j.client.core.ExtElement::new(Lcom/google/gwt/core/client/JavaScriptObject;)(peer);
    }-*/;

    /**
     * Returns the element or component that was configured with the target
     * config property.
     * <p>
     * Textarea and img elements will be wrapped with an additional div because
     * these elements do not support child nodes. The original element can be
     * accessed through the originalTarget property.
     */
    public native ExtElement getTargetElement()/*-{
		var obj = this.@com.ait.ext4j.client.core.JsObject::getJsObj()();
		var peer = obj.getTarget();
		return @com.ait.ext4j.client.core.ExtElement::new(Lcom/google/gwt/core/client/JavaScriptObject;)(peer);
    }-*/;

    /**
     * Returns the element or component that was configured with the target
     * config property.
     * <p>
     * Textarea and img elements will be wrapped with an additional div because
     * these elements do not support child nodes. The original element can be
     * accessed through the originalTarget property.
     */
    public native Component getTarget()/*-{
		var obj = this.@com.ait.ext4j.client.core.JsObject::getJsObj()();
		var peer = obj.getTarget();
		return @com.ait.ext4j.client.core.Component::createComponent(Lcom/google/gwt/core/client/JavaScriptObject;)(peer);
    }-*/;

    /**
     * Perform a manual resize and fires the 'resize' event.
     */
    public native void resizeTo(double width, double height)/*-{
		var obj = this.@com.ait.ext4j.client.core.JsObject::getJsObj()();
		obj.resizeTo(width, height);
    }-*/;

    /**
     * Use this handler to listen to the resize and resize drag event
     */
    public native void addHandler(String event, ResizeHandler handler)/*-{
		var obj = this.@com.ait.ext4j.client.core.JsObject::getJsObj()();
		obj
				.addListener(
						event,
						$entry(function(r, w, h, e) {
							var resizer = @com.ait.ext4j.client.resizer.Resizer::new(Lcom/google/gwt/core/client/JavaScriptObject;)(r);
							var event = @com.ait.ext4j.client.core.EventObject::new(Lcom/google/gwt/core/client/JavaScriptObject;)(e);
							handler.@com.ait.ext4j.client.events.resizer.ResizeHandler::onEvent(Lcom/ait/ext4j/client/resizer/Resizer;DDLcom/ait/ext4j/client/core/EventObject;)(resizer,w,h,event);
						}));
    }-*/;

    /**
     * Fired before resize is allowed. Return false to cancel resize.
     */
    public native void addBeforeResizeHandler(BeforeResizeHandler handler)/*-{
		var obj = this.@com.ait.ext4j.client.core.JsObject::getJsObj()();
		obj
				.addListener(
						@com.ait.ext4j.client.events.Event::BEFORE_RESIZE,
						$entry(function(r, w, h, e) {
							var resizer = @com.ait.ext4j.client.resizer.Resizer::new(Lcom/google/gwt/core/client/JavaScriptObject;)(r);
							var event = @com.ait.ext4j.client.core.EventObject::new(Lcom/google/gwt/core/client/JavaScriptObject;)(e);
							return handler.@com.ait.ext4j.client.events.resizer.BeforeResizeHandler::onEvent(Lcom/ait/ext4j/client/resizer/Resizer;DDLcom/ait/ext4j/client/core/EventObject;)(resizer,w,h,event);
						}));
    }-*/;

    private static native JavaScriptObject createNativePeer(JavaScriptObject config)/*-{
		return new $wnd.Ext.resizer.Resizer(config);
    }-*/;

}
