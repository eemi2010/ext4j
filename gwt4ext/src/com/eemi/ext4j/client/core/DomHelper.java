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

import com.eemi.ext4j.client.core.config.StyleConfig;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.dom.client.Element;

/**
 * The DomHelper class provides a layer of abstraction from DOM and
 * transparently supports creating elements via DOM or using HTML fragments. It
 * also has the ability to create HTML fragment templates from your DOM building
 * code.
 */
public class DomHelper {

	private DomHelper() {

	}

	/**
	 * DomHelper will transparently create HTML fragments when it can. Using
	 * HTML fragments instead of DOM can significantly boost performance.
	 * <p>
	 * Element creation specification parameters may also be strings. If useDom
	 * is false, then the string is used as innerHTML. If useDom is true, a
	 * string specification results in the creation of a text node. Usage:
	 * 
	 * @param value
	 */
	public static native void setUseDom(boolean value)/*-{
		$wnd.Ext.DomHelper.useDom = value;
	}-*/;

	/**
	 * Creates new Dom element(s) and appends them to the parent element.
	 * 
	 * @param parentId
	 *            the parent element id
	 * @param rawHtml
	 *            raw html blob
	 * @return the new node
	 */
	public static native ExtElement append(String parentId, String rawHtml)/*-{
		var obj = $wnd.Ext.DomHelper.append(parentId, rawHtml, true);
		return @com.eemi.ext4j.client.core.ExtElement::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
	}-*/;

	/**
	 * Creates new Dom element(s) and appends them to the parent element.
	 * 
	 * @param parentId
	 *            the parent element id
	 * @param config
	 *            child dom config
	 * @return the new node
	 */
	public static native ExtElement append(String parentId, DomConfig config)/*-{
		var configJS = config.@com.eemi.ext4j.client.core.DomConfig::getJsObject()();
		var obj = $wnd.Ext.DomHelper.append(parentId, configJS, true);
		return @com.eemi.ext4j.client.core.ExtElement::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
	}-*/;

	/**
	 * Creates new Dom element(s) and appends them to the parent element.
	 * 
	 * @param parent
	 *            the parent element
	 * @param rawHtml
	 *            raw html blob
	 * @return the new node
	 */
	public static native ExtElement append(Element parent, String rawHtml)/*-{
		var obj = $wnd.Ext.DomHelper.append(parent, rawHtml, true);
		return @com.eemi.ext4j.client.core.ExtElement::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
	}-*/;

	/**
	 * Creates new Dom element(s) and appends them to the parent element.
	 * 
	 * @param parent
	 *            the parent element
	 * @param config
	 *            child dom config
	 * @return the new node
	 */
	public static native ExtElement append(Element parent, DomConfig config)/*-{
		var configJS = config.@com.eemi.ext4j.client.core.DomConfig::getJsObject()();
		var obj = $wnd.Ext.DomHelper.append(parent, configJS, true);
		return @com.eemi.ext4j.client.core.ExtElement::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
	}-*/;

	// ///

	/**
	 * Creates new Dom element(s) and appends them to the parent element.
	 * 
	 * @param parent
	 *            the parent element
	 * @param rawHtml
	 *            raw html blob
	 * @return the new node
	 */
	public static native ExtElement append(ExtElement parent, String rawHtml)/*-{
		var obj = $wnd.Ext.DomHelper.append(
				parent.@com.eemi.ext4j.client.core.JsObject::getJsObj()(),
				rawHtml, true);
		return @com.eemi.ext4j.client.core.ExtElement::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
	}-*/;

	/**
	 * Creates new Dom element(s) and appends them to the parent element.
	 * 
	 * @param parent
	 *            the parent element
	 * @param config
	 *            child dom config
	 * @return the new node
	 */
	public static native ExtElement append(ExtElement parent, DomConfig config)/*-{
		var configJS = config.@com.eemi.ext4j.client.core.DomConfig::getJsObject()();
		var obj = $wnd.Ext.DomHelper.append(
				parent.@com.eemi.ext4j.client.core.JsObject::getJsObj()(),
				configJS, true);
		return @com.eemi.ext4j.client.core.ExtElement::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
	}-*/;

	/**
	 * Creates new Dom element(s) and appends them to the parent element.
	 * 
	 * @param parent
	 *            the parent element
	 * @param child
	 *            child element
	 * @return the new node
	 */
	public static native ExtElement append(ExtElement parent, ExtElement child)/*-{
		var obj = $wnd.Ext.DomHelper.append(
				parent.@com.eemi.ext4j.client.core.JsObject::getJsObj()(),
				child.@com.eemi.ext4j.client.core.JsObject::getJsObj()(), true);
		return @com.eemi.ext4j.client.core.ExtElement::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
	}-*/;

	/**
	 * Creates new Dom element(s) and appends them to the parent element.
	 * 
	 * @param parent
	 *            the parent element
	 * @param child
	 *            child element
	 * @return the new node
	 */
	public static native ExtElement append(Element parent, Element child)/*-{
		var obj = $wnd.Ext.DomHelper.append(parent, child, true);
		return @com.eemi.ext4j.client.core.ExtElement::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
	}-*/;

	/**
	 * Applies a style specification to an element.
	 * 
	 * @param element
	 *            the element to apply styles to
	 * @param styles
	 *            a style specification string eg "width:100px"
	 */
	public static native void applyStyles(Element element, String styles)/*-{
		return $wnd.Ext.DomHelper.applyStyles(element, styles);
	}-*/;

	/**
	 * Creates a new Template from the Dom config spec.
	 * 
	 * @param config
	 *            the dom config
	 * @return the new Template
	 */
	public static native Template createTemplate(DomConfig config) /*-{
		var configJS = config.@com.eemi.ext4j.client.core.DomConfig::getJsObject()();
		var tpl = $wnd.Ext.DomHelper.createTemplate(configJS);
		return @com.eemi.ext4j.client.core.Template::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(tpl);
	}-*/;

	/**
	 * Creates new DOM element(s) without inserting them to the document.
	 */
	public static native Element createDom(DomConfig config) /*-{
		var configJS = config.@com.eemi.ext4j.client.core.DomConfig::getJsObject()();
		return $wnd.Ext.DomHelper.createDom(configJS);
	}-*/;

	/**
	 * Creates new DOM element(s) without inserting them to the document.
	 */
	public static native Element createDom(String rawHtml) /*-{
		$wnd.Ext.DomHelper.createDom(rawHtml);
	}-*/;

	/**
	 * Alias for markup.
	 */
	public static native String createHtml(DomConfig config) /*-{
		var configJS = config.@com.eemi.ext4j.client.core.DomConfig::getJsObject()();
		return $wnd.Ext.DomHelper.createHtml(configJS);
	}-*/;

	/**
	 * Converts the styles from the given object to text. The styles are CSS
	 * style names with their associated value.
	 */
	public static native String generateStyle(StyleConfig config) /*-{
		var configJS = config.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		return $wnd.Ext.DomHelper.generateStyle(configJS);
	}-*/;

	/**
	 * Converts the styles from the given object to text. The styles are CSS
	 * style names with their associated value.
	 */
	public static native JsArrayString generateStyleAsArray(StyleConfig config,
			JsArrayString buffer) /*-{
		var configJS = config.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		return $wnd.Ext.DomHelper.generateStyle(configJS, buffer);
	}-*/;

	/**
	 * Creates new Dom element(s) and inserts them after the specified element.
	 * 
	 * @param id
	 *            the element id
	 * @param rawHtml
	 *            raw html blob
	 * @return the new node
	 */
	public static native Element insertAfter(String id, String rawHtml)/*-{
		return $wnd.Ext.DomHelper.insertAfter(id, rawHtml);
	}-*/;

	/**
	 * Creates new Dom element(s) and inserts them after the specified element.
	 * 
	 * @param id
	 *            the element id
	 * @param config
	 *            the element dom config spec
	 * @return the new node
	 */
	public static native Element insertAfter(String id, DomConfig config)/*-{
		var configJS = config.@com.eemi.ext4j.client.core.DomConfig::getJsObject()();
		return $wnd.Ext.DomHelper.insertAfter(id, configJS);
	}-*/;

	/**
	 * Creates new Dom element(s) and inserts them after the specified element.
	 * 
	 * @param elem
	 *            the element
	 * @param rawHtml
	 *            the raw html blob
	 * @return the new node
	 */
	public static native Element insertAfter(Element elem, String rawHtml)/*-{
		return $wnd.Ext.DomHelper.insertAfter(parent, rawHtml);
	}-*/;

	/**
	 * Creates new Dom element(s) and inserts them after the specified element.
	 * 
	 * @param elem
	 *            the element
	 * @param config
	 *            the element dom config spec
	 * @return the new node
	 */
	public static native Element insertAfter(Element elem, DomConfig config)/*-{
		var configJS = config.@com.eemi.ext4j.client.core.DomConfig::getJsObject()();
		return $wnd.Ext.DomHelper.insertAfter(parent, configJS);
	}-*/;

	/**
	 * Creates new Dom element and inserts them after the specified element.
	 * 
	 * @param elem
	 *            the element
	 * @param sibling
	 *            the sibling element
	 * @return the new node
	 */
	public static native Element insertAfter(Element elem, Element sibling)/*-{
		return $wnd.Ext.DomHelper.insertAfter(elem, sibling);
	}-*/;

	/**
	 * Creates new Dom element and inserts them before the specified element.
	 * 
	 * @param id
	 *            the element id
	 * @param rawHtml
	 *            the raw html blob
	 * @return the new node
	 */
	public static native Element insertBefore(String id, String rawHtml)/*-{
		return $wnd.Ext.DomHelper.insertBefore(id, rawHtml);
	}-*/;

	/**
	 * Creates new Dom element and inserts them before the specified element.
	 * 
	 * @param id
	 *            the element id
	 * @param config
	 *            the dom config object
	 * @return the new node
	 */
	public static native Element insertBefore(String id, DomConfig config)/*-{
		var configJS = config.@com.eemi.ext4j.client.core.DomConfig::getJsObject()();
		return $wnd.Ext.DomHelper.insertBefore(id, configJS);
	}-*/;

	/**
	 * Creates new Dom element and inserts them before the specified element.
	 * 
	 * @param elem
	 *            the element
	 * @param rawHtml
	 *            the raw html blob
	 * @return the new node
	 */
	public static native Element insertBefore(Element elem, String rawHtml)/*-{
		return $wnd.Ext.DomHelper.insertBefore(parent, rawHtml);
	}-*/;

	/**
	 * Creates new Dom element and inserts them before the specified element.
	 * 
	 * @param elem
	 *            the element
	 * @param config
	 *            the dom config object
	 * @return the new node
	 */
	public static native Element insertBefore(Element elem, DomConfig config)/*-{
		var configJS = config.@com.eemi.ext4j.client.core.DomConfig::getJsObject()();
		return $wnd.Ext.DomHelper.insertBefore(parent, configJS);
	}-*/;

	/**
	 * Creates new Dom element and inserts them before the specified element.
	 * 
	 * @param elem
	 *            the element
	 * @param sibling
	 *            the sibling element
	 * @return the new node
	 */
	public static native Element insertBefore(Element elem, Element sibling)/*-{
		return $wnd.Ext.DomHelper.insertBefore(elem, sibling);
	}-*/;

	/**
	 * Creates new Dom element(s) and inserts them as the first child of the
	 * parent element.
	 * 
	 * @param parentId
	 *            the parent element id
	 * @param rawHtml
	 *            raw html blob
	 * @return the new node
	 */
	public static native Element insertFirst(String parentId, String rawHtml)/*-{
		return $wnd.Ext.DomHelper.insertFirst(parentId, rawHtml);
	}-*/;

	/**
	 * Creates new Dom element(s) and inserts them as the first child of the
	 * parent element.
	 * 
	 * @param parentId
	 *            the parent element id
	 * @param config
	 *            the child dom config object
	 * @return the new node
	 */
	public static native Element insertFirst(String parentId, DomConfig config)/*-{
		var configJS = config.@com.eemi.ext4j.client.core.DomConfig::getJsObject()();
		return $wnd.Ext.DomHelper.insertFirst(parentId, configJS);
	}-*/;

	/**
	 * Creates new Dom element(s) and inserts them as the first child of the
	 * parent element.
	 * 
	 * @param parent
	 *            the parent element
	 * @param rawHtml
	 *            raw html blob
	 * @return the new node
	 */
	public static native Element insertFirst(Element parent, String rawHtml)/*-{
		return $wnd.Ext.DomHelper.insertFirst(parent, rawHtml);
	}-*/;

	/**
	 * Creates new Dom element(s) and inserts them as the first child of the
	 * parent element.
	 * 
	 * @param parent
	 *            the parent element
	 * @param config
	 *            the child dom config object
	 * @return the new node
	 */
	public static native Element insertFirst(Element parent, DomConfig config)/*-{
		var configJS = config.@com.eemi.ext4j.client.core.DomConfig::getJsObject()();
		return $wnd.Ext.DomHelper.insertFirst(parent, configJS);
	}-*/;

	/**
	 * Creates new Dom element(s) and inserts them as the first child of the
	 * parent element.
	 * 
	 * @param parent
	 *            the parent element
	 * @param child
	 *            the child element
	 * @return the new node
	 */
	public static native Element insertFirst(Element parent, Element child)/*-{
		return $wnd.Ext.DomHelper.insertFirst(parent, child);
	}-*/;

	/**
	 * Returns the markup for the passed Element config.
	 * 
	 * @param config
	 *            the element config
	 * @return markup
	 */
	public static native String markup(DomConfig config)/*-{
		var configJS = config.@com.eemi.ext4j.client.core.DomConfig::getJsObject()();
		return $wnd.Ext.DomHelper.markup(elem);
	}-*/;

	/**
	 * Creates new Dom element(s) and overwrites the contents of the old element
	 * with them.
	 * 
	 * @param oldId
	 *            the old element id
	 * @param newRawHtml
	 *            raw html blob
	 * @return the new node
	 */
	public static native Element overwrite(String oldId, String newRawHtml)/*-{
		return $wnd.Ext.DomHelper.overwrite(oldId, newRawHtml);
	}-*/;

	/**
	 * Creates new Dom element(s) and overwrites the contents of the old element
	 * with them.
	 * 
	 * @param oldId
	 *            the old element id
	 * @param config
	 *            the dom config object
	 * @return the new node
	 */
	public static native Element overwrite(String oldId, DomConfig config)/*-{
		var configJS = config.@com.eemi.ext4j.client.core.DomConfig::getJsObject()();
		return $wnd.Ext.DomHelper.overwrite(oldId, configJS);
	}-*/;

	/**
	 * Creates new Dom element(s) and overwrites the contents of the old element
	 * with them.
	 * 
	 * @param oldElem
	 *            the old element
	 * @param newRawHtml
	 *            raw html blob
	 * @return the new node
	 */
	public static native Element overwrite(Element oldElem, String newRawHtml)/*-{
		return $wnd.Ext.DomHelper.overwrite(oldElem, newRawHtml);
	}-*/;

	/**
	 * Creates new Dom element(s) and overwrites the contents of the old element
	 * with them.
	 * 
	 * @param oldElem
	 *            the old element
	 * @param config
	 *            the dom config object
	 * @return the new node
	 */
	public static native Element overwrite(Element oldElem, DomConfig config)/*-{
		var configJS = config.@com.eemi.ext4j.client.core.DomConfig::getJsObject()();
		return $wnd.Ext.DomHelper.overwrite(oldElem, configJS);
	}-*/;

	/**
	 * Creates new Dom element(s) and overwrites the contents of the old element
	 * with them.
	 * 
	 * @param oldElem
	 *            the old element
	 * @param newElem
	 *            the new element
	 * @return the new node
	 */
	public static native Element overwrite(Element oldElem, Element newElem)/*-{
		return $wnd.Ext.DomHelper.overwrite(oldElem, newElem);
	}-*/;

	/**
	 * Inserts an HTML fragment into the DOM.
	 */
	public static native String insertHtml(String where, Element el, String html) /*-{
		return $wnd.Ext.DomHelper.insertHtml(where, el, html);
	}-*/;

}
