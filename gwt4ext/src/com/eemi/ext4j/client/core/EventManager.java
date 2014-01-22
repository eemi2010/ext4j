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
package com.eemi.ext4j.client.core;

import com.eemi.ext4j.client.core.config.CallbackConfig;
import com.eemi.ext4j.client.core.handlers.EventCallback;
import com.google.gwt.core.client.JsArrayNumber;
import com.google.gwt.dom.client.Element;

/**
 * Registers event handlers that want to receive a normalized EventObject
 * instead of the standard browser event and provides several useful events
 * directly.
 */
public class EventManager {

    private EventManager() {

    }

    /**
     * Appends an event handler to an element. The shorthand version on is
     * equivalent. Typically you will use Ext.Element.addListener directly on an
     * Element in favor of calling this version.
     * 
     * @param element
     * @param event
     * @param cb
     * @param config
     */
    public static native void addListener(Element element, String event, EventCallback cb, CallbackConfig config)/*-{
		$wnd.Ext.EventMananger
				.addListener(
						element,
						event,

						function(event) {
							var e = (event === undefined || event == null) ? null
									: @com.eemi.ext4j.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
							cb.@com.eemi.ext4j.client.core.handlers.EventCallback::execute(Lcom/eemi/ext4j/client/core/EventObject;)(e);
						},
						null,
						config.@com.eemi.ext4j.client.core.JsObject::getJsObj()());
    }-*/;

    public static native void addListener(String element, String event, EventCallback cb, CallbackConfig config)/*-{
		$wnd.Ext.EventMananger
				.addListener(
						element,
						event,
						function(event) {
							var e = (event === undefined || event == null) ? null
									: @com.eemi.ext4j.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
							cb.@com.eemi.ext4j.client.core.handlers.EventCallback::execute(Lcom/eemi/ext4j/client/core/EventObject;)(e);
						},
						null,
						config.@com.eemi.ext4j.client.core.JsObject::getJsObj()());
    }-*/;

    public static native void addListener(ExtElement element, String event, EventCallback cb, CallbackConfig config)/*-{
		$wnd.Ext.EventMananger
				.addListener(
						element.@com.eemi.ext4j.client.core.JsObject::getJsObj()(),
						event,
						function(event) {
							var e = (event === undefined || event == null) ? null
									: @com.eemi.ext4j.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
							cb.@com.eemi.ext4j.client.core.handlers.EventCallback::execute(Lcom/eemi/ext4j/client/core/EventObject;)(e);
						},
						null,
						config.@com.eemi.ext4j.client.core.JsObject::getJsObj()());
    }-*/;

    /**
     * Get the id of the element. If one has not been assigned, automatically
     * assign it.
     */
    public static native String getId(Element el)/*-{
		return $wnd.Ext.EventMananger.getId(el);
    }-*/;

    /**
     * Get the id of the element. If one has not been assigned, automatically
     * assign it.
     */
    public static native String getId(ExtElement el)/*-{
		return $wnd.Ext.EventMananger
				.getId(el.@com.eemi.ext4j.client.core.JsObject::getJsObj()());
    }-*/;

    /**
     * Indicates which event to use for getting key presses.
     */
    public static native String getKeyEvent()/*-{
		return $wnd.Ext.EventMananger.getKeyEvent();
    }-*/;

    /**
     * Gets the x coordinate from the event
     */
    public static native double getPageX(EventObject e)/*-{
		return $wnd.Ext.EventMananger
				.getPageX(e.@com.eemi.ext4j.client.core.JsObject::getJsObj()());
    }-*/;

    /**
     * Gets the x & y coordinate from the event
     */
    public static native JsArrayNumber getPageXY(EventObject e)/*-{
		return $wnd.Ext.EventMananger
				.getPageXY(e.el.@com.eemi.ext4j.client.core.JsObject::getJsObj()());
    }-*/;

    /**
     * Gets the x coordinate from the event
     */
    public static native double getPageY(EventObject e)/*-{
		return $wnd.Ext.EventMananger
				.getPageY(e.@com.eemi.ext4j.client.core.JsObject::getJsObj()());
    }-*/;

    /**
     * Gets the related target from the event.
     */
    public static native Element getRelatedTarget(EventObject e)/*-{
		return $wnd.Ext.EventMananger
				.getRelatedTarget(e.el.@com.eemi.ext4j.client.core.JsObject::getJsObj()());
    }-*/;

    /**
     * Gets the target from the event.
     */
    public static native Element getTarget(EventObject e)/*-{
		return $wnd.Ext.EventMananger
				.getTarget(e.el.@com.eemi.ext4j.client.core.JsObject::getJsObj()());
    }-*/;

    /**
     * Adds a listener to be notified when the document is ready (before onload
     * and before images are loaded).
     */
    public static native void onDocumentReady(EventCallback cb, CallbackConfig config)/*-{
		$wnd.Ext.EventMananger
				.onDocumentReady(
						function(event) {
							var e = (event === undefined || event == null) ? null
									: @com.eemi.ext4j.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
							cb.@com.eemi.ext4j.client.core.handlers.EventCallback::execute(Lcom/eemi/ext4j/client/core/EventObject;)(e);
						},
						null,
						config.@com.eemi.ext4j.client.core.JsObject::getJsObj()());
    }-*/;

    /**
     * Adds a listener to be notified when the document is ready (before onload
     * and before images are loaded).
     */
    public static native void onWindowResize(EventCallback cb, CallbackConfig config)/*-{
		$wnd.Ext.EventMananger
				.onWindowResize(
						function(event) {
							var e = (event === undefined || event == null) ? null
									: @com.eemi.ext4j.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
							cb.@com.eemi.ext4j.client.core.handlers.EventCallback::execute(Lcom/eemi/ext4j/client/core/EventObject;)(e);
						},
						null,
						config.@com.eemi.ext4j.client.core.JsObject::getJsObj()());
    }-*/;

    /**
     * Prevents the browsers default handling of the event.
     */
    public static native void preventDefault(EventObject event)/*-{
		$wnd.Ext.EventMananger
				.preventDefault(event.@com.eemi.ext4j.client.core.JsObject::getJsObj()());
    }-*/;

    /**
     * Recursively removes all previous added listeners from an element and its
     * children.
     */
    public static native void purgeElemet(ExtElement el)/*-{
		$wnd.Ext.EventMananger
				.purgeElemet(el.@com.eemi.ext4j.client.core.JsObject::getJsObj()());
    }-*/;

    /**
     * Recursively removes all previous added listeners from an element and its
     * children.
     */
    public static native void purgeElemet(ExtElement el, String eventName)/*-{
		$wnd.Ext.EventMananger.purgeElemet(
				el.@com.eemi.ext4j.client.core.JsObject::getJsObj()(),
				eventName);
    }-*/;

    /**
     * Recursively removes all previous added listeners from an element and its
     * children.
     */
    public static native void purgeElemet(Element el)/*-{
		$wnd.Ext.EventMananger.purgeElemet(el);
    }-*/;

    /**
     * Recursively removes all previous added listeners from an element and its
     * children.
     */
    public static native void purgeElemet(Element el, String eventName)/*-{
		$wnd.Ext.EventMananger.purgeElemet(el, eventName);
    }-*/;

    /**
     * Recursively removes all previous added listeners from an element and its
     * children.
     */
    public static native void purgeElemet(String el)/*-{
		$wnd.Ext.EventMananger.purgeElemet(el);
    }-*/;

    /**
     * Recursively removes all previous added listeners from an element and its
     * children.
     */
    public static native void purgeElemet(String el, String eventName)/*-{
		$wnd.Ext.EventMananger.purgeElemet(el, eventName);
    }-*/;

    /**
     * Cancels bubbling of the event.
     */
    public static native void stopPropagation(EventObject event)/*-{
		$wnd.Ext.EventMananger
				.stopPropagation(event.@com.eemi.ext4j.client.core.JsObject::getJsObj()());
    }-*/;

}
