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
package com.ati.ext4j.client.core;

import java.util.List;

import com.ati.ext4j.client.core.config.StyleConfig;
import com.ati.ext4j.client.events.ElementHandlerRegistration;
import com.ati.ext4j.client.events.element.EventHandler;
import com.ati.ext4j.client.fx.anim.Animation;
import com.ati.ext4j.client.fx.anim.FadeIn;
import com.ati.ext4j.client.fx.anim.FadeOut;
import com.ati.ext4j.client.fx.anim.HighLight;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayNumber;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.dom.client.Element;

/**
 * Encapsulates a DOM element, adding simple DOM manipulation facilities,
 * normalizing for browser differences.
 * 
 * All instances of this class inherit the methods of Ext.fx.Anim making visual
 * effects easily available to all DOM elements.
 * 
 * Note that the events documented in this class are not Ext events, they
 * encapsulate browser events. Some older browsers may not support the full
 * range of events. Which events are supported is beyond the control of Ext JS.
 * 
 */
public class ExtElement extends DomElement {

    public static final int VISIBILITY = 1;
    public static final int DISPLAY = 2;
    public static final int OFFSETS = 3;
    public static final int ASCLASS = 4;

    protected ExtElement() {
    }

    /**
     * Create an ExtElement using an existing native element.
     * 
     * @param jsObj
     *            native Element object
     */
    public ExtElement(JavaScriptObject jsObj) {
        super(jsObj);
    }

    /**
     * Create an ExtElement wrapper around en existing DOM Element.
     * 
     * @param elem
     *            the DOM Element
     */
    public ExtElement(Element elem) {
        this(elem, false);
    }

    /**
     * Create an ExtElement wrapper around an existing DOM Element.
     * 
     * @param elem
     *            the DOM Element
     * @param forceNew
     *            by default the constructor checks to see if there is already
     *            an instance of this element in the cache and if there is it
     *            returns the same instance. Passing <code>true</code> will skip
     *            that check (useful for extending this class)
     */
    public ExtElement(Element elem, boolean forceNew) {
        jsObj = create(elem, forceNew);
    }

    /**
     * Gets the globally shared flyweight Element, with the passed node as the
     * active element. Do not store a reference to this element - the dom node
     * can be overwritten by other code.
     * 
     * @param id
     *            the Element id
     * @return the shared ExtElement object
     */

    public static native ExtElement fly(String id)/*-{
		var elem = $wnd.Ext.fly(id);
		return elem == null || elem === undefined ? null
				: @com.ati.ext4j.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(elem);
    }-*/;

    /**
     * Gets the globally shared flyweight ExtElement, with the passed node as
     * the active element. Do not store a reference to this element - the dom
     * node can be overwritten by other code.
     * 
     * @param id
     *            the Element id
     * @param named
     *            allows for creation of named reusable flyweights to prevent
     *            conflicts (e.g. internally Ext uses "_internal")
     * @return the shared ExtElement object
     */
    public static native ExtElement fly(String id, String named)/*-{
		var elem = $wnd.Ext.fly(id, named);
		return elem == null || elem === undefined ? null
				: @com.ati.ext4j.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(elem);
    }-*/;

    /**
     * Static method to retrieve ExtElement objects. Uses simple caching to
     * consistently return the same object. Automatically fixes if an object was
     * recreated with the same id via AJAX or DOM.
     * 
     * @param id
     *            the id of Element
     * @return the ExtElement object
     */
    public static native ExtElement get(String id)/*-{
		var elem = $wnd.Ext.get(id);
		return elem == null || elem === undefined ? null
				: @com.ati.ext4j.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(elem);
    }-*/;

    /**
     * The DOM element ID
     * 
     * @return this
     */
    public native String getId() /*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		return elem.id;
    }-*/;

    /**
     * The DOM element ID
     * 
     * @return this
     */
    public native void setId(String id) /*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		elem.id = id;
    }-*/;

    /**
     * Adds one classe to the element. Duplicate classes are automatically
     * filtered out.
     * 
     * @return this
     */
    public native ExtElement addCls(String value) /*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		elem.addCls(value);
		return this;
    }-*/;

    /**
     * Adds one or more CSS classes to the element. Duplicate classes are
     * automatically filtered out. filtered out.
     * 
     * @return this
     */
    public ExtElement addCls(List<String> values) {
        JsArrayString classes = JsArrayString.createArray().cast();
        for (String string : values) {
            classes.push(string);
        }
        return _addCls(classes);
    }

    /**
     * Adds one or more CSS classes to the element. Duplicate classes are
     * automatically filtered out. filtered out.
     * 
     * @return this
     */
    public ExtElement addCls(String... values) {
        JsArrayString classes = JsArrayString.createArray().cast();
        for (String string : values) {
            classes.push(string);
        }
        return _addCls(classes);
    }

    /**
     * Sets up event handlers to add and remove a css class when the mouse is
     * down and then up on this element (a click effect)
     * 
     * @return this
     */
    public native ExtElement addClsOnClick(String value) /*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		elem.addClsOnClick(value);
		return this;
    }-*/;

    /**
     * * Sets up event handlers to add and remove a css class when this element
     * has the focus
     * 
     * 
     * 
     * @return this
     */
    public native ExtElement addClsOnFocus(String value) /*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		elem.addClsOnFocus(value);
		return this;
    }-*/;

    /**
     * Sets up event handlers to add and remove a css class when the mouse is
     * over this element
     * 
     * @return this
     */
    public native ExtElement addClsOnOver(String value) /*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		elem.addClsOnOver(value);
		return this;
    }-*/;

    /**
     * Convenience method for constructing a KeyMap
     * 
     * @param key
     * @param callback
     */
    public native void addKeyListener(String key, Function callback)/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		elem.addKeyListener(key, $entry(function() {
			callback.@com.ati.ext4j.client.core.Function::execute()();
		}));
    }-*/;

    /**
     * Convenience method for constructing a KeyMap
     * 
     * @param key
     * @param callback
     */
    public native void addKeyListener(int key, Function callback)/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		elem.addKeyListener(key, $entry(function() {
			callback.@com.ati.ext4j.client.core.Function::execute()();
		}));
    }-*/;

    /**
     * Aligns this element with another element relative to the specified anchor
     * points. If the other element is the document it aligns it to the
     * viewport.
     * 
     * @param element
     */
    public native ExtElement alignTo(String element)/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		elem.alignTo(element);
		return this;
    }-*/;

    /**
     * Aligns this element with another element relative to the specified anchor
     * points. If the other element is the document it aligns it to the
     * viewport.
     * 
     * @param element
     */
    public native ExtElement alignTo(String element, String position)/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		elem.alignTo(element, position);
		return this;
    }-*/;

    /**
     * Aligns this element with another element relative to the specified anchor
     * points. If the other element is the document it aligns it to the
     * viewport.
     * 
     * @param element
     */

    public ExtElement alignTo(String element, String position, double[] offsets) {
        JsArrayNumber numbers = JsArray.createArray().cast();
        for (double d : offsets) {
            numbers.push(d);
        }
        return _alignTo(element, position, numbers);
    }

    private native ExtElement _alignTo(String element, String position, JsArrayNumber offsets)/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		elem.alignTo(element, position, offsets);
		return this;
    }-*/;

    /**
     * Aligns this element with another element relative to the specified anchor
     * points. If the other element is the document it aligns it to the
     * viewport.
     * 
     * @param element
     */

    public ExtElement alignTo(String element, String position, double[] offsets, boolean animate) {
        JsArrayNumber numbers = JsArray.createArray().cast();
        for (double d : offsets) {
            numbers.push(d);
        }
        return _alignTo(element, position, numbers, animate);
    }

    private native ExtElement _alignTo(String element, String position, JsArrayNumber offsets, boolean animate)/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		elem.alignTo(element, position, offsets, animate);
		return this;
    }-*/;

    /**
     * Aligns this element with another element relative to the specified anchor
     * points. If the other element is the document it aligns it to the
     * viewport.
     * 
     * @param element
     */
    public native ExtElement alignTo(ExtElement element)/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		elem
				.alignTo(element.@com.ati.ext4j.client.core.JsObject::getJsObj()());
		return this;
    }-*/;

    /**
     * Aligns this element with another element relative to the specified anchor
     * points. If the other element is the document it aligns it to the
     * viewport.
     * 
     * @param element
     */
    public native ExtElement alignTo(ExtElement element, String position)/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		elem.alignTo(
				element.@com.ati.ext4j.client.core.JsObject::getJsObj()(),
				position);
		return this;
    }-*/;

    /**
     * Aligns this element with another element relative to the specified anchor
     * points. If the other element is the document it aligns it to the
     * viewport.
     * 
     * @param element
     */

    public ExtElement alignTo(ExtElement element, String position, double[] offsets) {
        JsArrayNumber numbers = JsArray.createArray().cast();
        for (double d : offsets) {
            numbers.push(d);
        }
        return _alignTo(element, position, numbers);
    }

    private native ExtElement _alignTo(ExtElement element, String position, JsArrayNumber offsets)/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		elem.alignTo(
				element.@com.ati.ext4j.client.core.JsObject::getJsObj()(),
				position, offsets);
		return this;
    }-*/;

    /**
     * Aligns this element with another element relative to the specified anchor
     * points. If the other element is the document it aligns it to the
     * viewport.
     * 
     * @param element
     */

    public ExtElement alignTo(ExtElement element, String position, double[] offsets, boolean animate) {
        JsArrayNumber numbers = JsArray.createArray().cast();
        for (double d : offsets) {
            numbers.push(d);
        }
        return _alignTo(element, position, numbers, animate);
    }

    private native ExtElement _alignTo(ExtElement element, String position, JsArrayNumber offsets, boolean animate)/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		elem.alignTo(
				element.@com.ati.ext4j.client.core.JsObject::getJsObj()(),
				position, offsets, animate);
		return this;
    }-*/;

    /**
     * Aligns this element with another element relative to the specified anchor
     * points. If the other element is the document it aligns it to the
     * viewport.
     * 
     * @param element
     */
    public native ExtElement anchorTo(String element)/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		elem.anchorTo(element);
		return this;
    }-*/;

    /**
     * Aligns this element with another element relative to the specified anchor
     * points. If the other element is the document it aligns it to the
     * viewport.
     * 
     * @param element
     */
    public native ExtElement anchorTo(String element, String position)/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		elem.anchorTo(element, position);
		return this;
    }-*/;

    /**
     * Aligns this element with another element relative to the specified anchor
     * points. If the other element is the document it aligns it to the
     * viewport.
     * 
     * @param element
     */

    public ExtElement anchorTo(String element, String position, double[] offsets) {
        JsArrayNumber numbers = JsArray.createArray().cast();
        for (double d : offsets) {
            numbers.push(d);
        }
        return _anchorTo(element, position, numbers);
    }

    private native ExtElement _anchorTo(String element, String position, JsArrayNumber offsets)/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		elem.anchorTo(element, position, offsets);
		return this;
    }-*/;

    /**
     * Aligns this element with another element relative to the specified anchor
     * points. If the other element is the document it aligns it to the
     * viewport.
     * 
     * @param element
     */

    public ExtElement anchorTo(String element, String position, double[] offsets, boolean animate) {
        JsArrayNumber numbers = JsArray.createArray().cast();
        for (double d : offsets) {
            numbers.push(d);
        }
        return _anchorTo(element, position, numbers, animate);
    }

    private native ExtElement _anchorTo(String element, String position, JsArrayNumber offsets, boolean animate)/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		elem.anchorTo(element, position, offsets, animate);
		return this;
    }-*/;

    /**
     * Aligns this element with another element relative to the specified anchor
     * points. If the other element is the document it aligns it to the
     * viewport.
     * 
     * @param element
     */
    public native ExtElement anchorTo(ExtElement element)/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		elem
				.anchorTo(element.@com.ati.ext4j.client.core.JsObject::getJsObj()());
		return this;
    }-*/;

    /**
     * Aligns this element with another element relative to the specified anchor
     * points. If the other element is the document it aligns it to the
     * viewport.
     * 
     * @param element
     */
    public native ExtElement anchorTo(ExtElement element, String position)/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		elem.anchorTo(
				element.@com.ati.ext4j.client.core.JsObject::getJsObj()(),
				position);
		return this;
    }-*/;

    /**
     * Aligns this element with another element relative to the specified anchor
     * points. If the other element is the document it aligns it to the
     * viewport.
     * 
     * @param element
     */

    public ExtElement anchorTo(ExtElement element, String position, double[] offsets) {
        JsArrayNumber numbers = JsArray.createArray().cast();
        for (double d : offsets) {
            numbers.push(d);
        }
        return _anchorTo(element, position, numbers);
    }

    public ExtElement anchorTo(ExtElement element, String position, double offsetX, double offsetY) {
        JsArrayNumber numbers = JsArray.createArray().cast();
        numbers.push(offsetX);
        numbers.push(offsetY);
        return _anchorTo(element, position, numbers);
    }

    public ExtElement anchorTo(ExtElement element, String position, double offset) {
        return anchorTo(element, position, offset, offset);
    }

    private native ExtElement _anchorTo(ExtElement element, String position, JsArrayNumber offsets)/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		elem.anchorTo(
				element.@com.ati.ext4j.client.core.JsObject::getJsObj()(),
				position, offsets);
		return this;
    }-*/;

    /**
     * Aligns this element with another element relative to the specified anchor
     * points. If the other element is the document it aligns it to the
     * viewport.
     * 
     * @param element
     */

    public ExtElement anchorTo(ExtElement element, String position, double[] offsets, boolean animate) {
        JsArrayNumber numbers = JsArray.createArray().cast();
        for (double d : offsets) {
            numbers.push(d);
        }
        return _anchorTo(element, position, numbers, animate);
    }

    public ExtElement anchorTo(ExtElement element, String position, double offsetX, double offsetY, boolean animate) {
        JsArrayNumber numbers = JsArray.createArray().cast();
        numbers.push(offsetX);
        numbers.push(offsetY);
        return _anchorTo(element, position, numbers, animate);
    }

    public ExtElement anchorTo(ExtElement element, String position, double offset, boolean animate) {
        return anchorTo(element, position, offset, offset, animate);
    }

    private native ExtElement _anchorTo(ExtElement element, String position, JsArrayNumber offsets, boolean animate)/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		elem.anchorTo(
				element.@com.ati.ext4j.client.core.JsObject::getJsObj()(),
				position, offsets, animate);
		return this;
    }-*/;

    /**
     * Creates a KeyMap for this element
     * 
     * @param value
     * @return
     */
    public native JavaScriptObject addKeyMap(Object value)/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		return elem.addKeyMap(value);
    }-*/;

    /**
     * Appends the passed element to this element.
     * 
     * @param child
     *            the child element
     * @return this
     */
    public native ExtElement appendChild(String child) /*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		elem.appendChild(child);
		return this;
    }-*/;

    /**
     * Appends the passed element to this element.
     * 
     * @param child
     *            the child element
     * @return this
     */
    public native ExtElement appendChild(Element child) /*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		elem.appendChild(child);
		return this;
    }-*/;

    public native ExtElement appendChild(ExtElement child) /*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		elem
				.appendChild(child.@com.ati.ext4j.client.core.JsObject::getJsObj()());
		return this;
    }-*/;

    /**
     * Appends this element to the passed element.
     * 
     * @param el
     *            the new parent element
     * @return this
     */
    public native ExtElement appendTo(Element el) /*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		elem.appendTo(el);
		return this;
    }-*/;

    /**
     * Tries to blur the element. Any exceptions are caught and ignored.
     * 
     * @return this
     */
    public native ExtElement blur() /*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		elem.blur();
		return this;
    }-*/;

    /**
     * Wraps the specified element with a special markup/CSS block that renders
     * by default as a gray container with a gradient background, rounded
     * corners and a 4-way shadow.
     * 
     * @return this
     */
    public native ExtElement boxWrap() /*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		var wrap = elem.boxWrap();
		return @com.ati.ext4j.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(wrap);
    }-*/;

    /**
     * Wraps the specified element with a special markup/CSS block that renders
     * by default as a gray container with a gradient background, rounded
     * corners and a 4-way shadow.
     * 
     * @param boxClass
     *            A base CSS class to apply to the containing wrapper element
     *            (defaults to 'x-box'). Note that there are a number of CSS
     *            rules that are dependent on this name to make the overall
     *            effect work, so if you supply an alternate base class, make
     *            sure you also supply all of the necessary rules.
     * @return this
     */
    public native ExtElement boxWrap(String boxClass) /*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		var wrap = elem.boxWrap(boxClass);
		return @com.ati.ext4j.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(wrap);
    }-*/;

    /**
     * Centers the Element in the viewport.
     * 
     * @return this
     */
    public native ExtElement center() /*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		elem.center();
		return this;
    }-*/;

    /**
     * Centers the Element in another Element.
     * 
     * @param centerIn
     *            the element in which to center the element.
     * @return this
     */
    public native ExtElement center(Element centerIn) /*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		elem.center(centerIn);
		return this;
    }-*/;

    /**
     * Selects a single child at any depth below this element based on the
     * passed CSS selector (the selector should not contain an id).
     * 
     * @param selector
     *            the CSS selector
     * @return child element
     */
    public native Element child(String selector) /*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		var e = elem.child(selector, true);
		return e == null || e === undefined ? null : e;
    }-*/;

    /**
     * Removes Empty, or whitespace filled text nodes. Combines adjacent text
     * nodes.
     */
    public native void clean() /*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		elem.clean();
    }-*/;

    /**
     * Removes Empty, or whitespace filled text nodes. Combines adjacent text
     * nodes. By default the element keeps track if it has been cleaned already
     * so you can call this over and over. However, if you update the element
     * and need to force a reclean, you can pass true.
     */
    public native void clean(boolean forceReclean) /*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		elem.clean(forceReclean);
    }-*/;

    /**
     * Removes all previous added listeners from this element
     */
    public native ExtElement clearListeners() /*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		elem.clearListeners();
		return this;
    }-*/;

    /**
     * Removes all previous added listeners from this element
     */
    public native ExtElement clearOpacitiy() /*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		elem.clearOpacitiy();
		return this;
    }-*/;

    /**
     * Clear positioning back to the default when the document was loaded
     */
    public native ExtElement clearPositioning() /*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		elem.clearPositioning();
		return this;
    }-*/;

    /**
     * Clear positioning back to the default when the document was loaded
     */
    public native ExtElement clearPositioning(String value) /*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		elem.clearPositioning(value);
		return this;
    }-*/;

    /**
     * Store the current overflow setting and clip overflow on the element - use
     * unclip to remove
     */
    public native ExtElement clip() /*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		elem.clip();
		return this;
    }-*/;

    /**
     * Whether this element is an ancestor of the passed element.
     * 
     * @param el
     *            the element to check
     * @return true if this element is an ancestor of the passed element
     */
    public native boolean contains(Element el) /*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		return elem.contains(el);
    }-*/;

    /**
     * Creates the passed DomHelper config and appends it to this element
     * 
     * @param config
     *            DomHelper element config object. If no tag is specified (e.g.,
     *            {tag:'input'}) then a div will be automatically generated with
     *            the specified attributes.
     * @return the new child element
     */
    public native ExtElement createChild(DomConfig config) /*-{
		var configJS = config.@com.ati.ext4j.client.core.DomConfig::getJsObject()();
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		var childJS = elem.createChild(configJS);
		var childJ = @com.ati.ext4j.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(elem);
		return childJ;
    }-*/;

    /**
     * Creates the passed DomHelper config and appends inserts it before the
     * passed child element.
     * 
     * @param config
     *            DomHelper element config object. If no tag is specified (e.g.,
     *            {tag:'input'}) then a div will be automatically generated with
     *            the specified attributes.
     * @param insertBefore
     *            a child element of this element
     * @return the new child element
     */
    public native ExtElement createChild(DomConfig config, Element insertBefore) /*-{
		var configJS = config.@com.ati.ext4j.client.core.DomConfig::getJsObject()();
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		var childJS = elem.createChild(configJS, insertBefore);
		var childJ = @com.ati.ext4j.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(elem);
		return childJ;
    }-*/;

    /**
     * Creates a proxy element of this element.
     * 
     * @param config
     *            DomHelper config object
     * @return the new proxy element
     */
    public native ExtElement createProxy(DomConfig config) /*-{
		var configJS = config.@com.ati.ext4j.client.core.DomConfig::getJsObject()();
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		var proxy = elem.createProxy(configJS);
		var proxyJ = @com.ati.ext4j.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(proxy);
		return proxyJ;
    }-*/;

    /**
     * Creates a proxy element of this element.
     * 
     * @param config
     *            DomHelper config object
     * @param renderTo
     *            The element render the proxy to
     * @param matchBox
     *            true to align and size the proxy to this element now (defaults
     *            to false)
     * @return the new proxy element
     */
    public native ExtElement createProxy(DomConfig config, Element renderTo, boolean matchBox) /*-{
		var configJS = config.@com.ati.ext4j.client.core.DomConfig::getJsObject()();
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		var proxy = elem.createProxy(configJS, renderTo, matchBox);
		var proxyJ = @com.ati.ext4j.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(proxy);
		return proxyJ;
    }-*/;

    /**
     * Creates a proxy element of this element.
     * 
     * @param cls
     *            the class name of the proxy element
     * @return the new proxy element
     */
    public native ExtElement createProxy(String cls) /*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		var obj = elem.createProxy(cls);
		var toReturn = @com.ati.ext4j.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
		return toReturn;
    }-*/;

    /**
     * Creates a proxy element of this element.
     * 
     * @param cls
     *            the class name of the proxy element
     * @param renderTo
     *            The element render the proxy to
     * @param matchBox
     *            true to align and size the proxy to this element now (defaults
     *            to false)
     * @return the new proxy element
     */
    public native ExtElement createProxy(String cls, Element renderTo, boolean matchBox) /*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		elem.createProxy(cls, renderTo, matchBox);
		return this;
    }-*/;

    /**
     * Selects a single *direct* child based on the passed CSS selector (the
     * selector should not contain an id).
     * 
     * @param selector
     *            the CSS selector
     * @return the child element
     */
    public native Element down(String selector) /*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		var obj = elem.down(selector, true);
		var toReturn = @com.ati.ext4j.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
		return toReturn;
    }-*/;

    /**
     * Fade an element in (from transparent to opaque). The ending opacity can
     * be specified using the fadein config option.
     */
    public native Element fadeIn(FadeIn config) /*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		elem.fadeIn(config.@com.ati.ext4j.client.core.JsObject::getJsObj()());
		return this;
    }-*/;

    /**
     * Fade an element out (from opaque to transparent). The ending opacity can
     * be specified using the fadein config option.
     */
    public native Element fadeOut(FadeOut config) /*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		elem.fadeOut(config.@com.ati.ext4j.client.core.JsObject::getJsObj()());
		return this;
    }-*/;

    /**
     * Looks at this node and then at parent nodes for a match of the passed
     * simple selector (e.g. div.some-class or span:first-child)
     * 
     * @param selector
     *            the simple selector to test
     * @return the matching element of null if no node found
     */
    public native Element findParent(String selector) /*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		var obj = elem.findParent(selector);
		var toReturn = @com.ati.ext4j.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
		return toReturn;
    }-*/;

    /**
     * Looks at this node and then at parent nodes for a match of the passed
     * simple selector (e.g. div.some-class or span:first-child)
     * 
     * @param selector
     *            the simple selector to test
     * @param container
     *            search until container element is reached
     * @return the matching element of null if no node found
     */
    public native Element findParent(String selector, Element container) /*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		var obj = elem.findParent(selector, container);
		var toReturn = @com.ati.ext4j.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
		return toReturn;
    }-*/;

    /**
     * Looks at this node and then at parent nodes for a match of the passed
     * simple selector (e.g. div.some-class or span:first-child)
     * 
     * @param selector
     *            the simple selector to test
     * @param maxDepth
     *            the max depth to search as a number (defaults to 10)
     * @return the matching element of null if no node found
     */
    public native Element findParent(String selector, int maxDepth) /*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		var obj = elem.findParent(selector, maxDepth);
		var toReturn = @com.ati.ext4j.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
		return toReturn;
    }-*/;

    /**
     * Looks at parent nodes for a match of the passed simple selector (e.g.
     * div.some-class or span:first-child)
     * 
     * @param selector
     *            the simple selector to test
     * @param container
     *            search until container element is reached
     * @return the matching element of null if no node found
     */
    public native Element findParentNode(String selector, Element container) /*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		var obj = elem.findParentNode(selector, container);
		var toReturn = @com.ati.ext4j.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
		return toReturn;
    }-*/;

    /**
     * Looks at parent nodes for a match of the passed simple selector (e.g.
     * div.some-class or span:first-child)
     * 
     * @param selector
     *            the simple selector to test
     * @param maxDepth
     *            the max depth to search as a number (defaults to 10)
     * @return the matching element of null if no node found
     */
    public native Element findParentNode(String selector, int maxDepth) /*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		var obj = elem.findParentNode(selector, maxDepth);
		var toReturn = @com.ati.ext4j.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
		return toReturn;
    }-*/;

    public native ExtElement first() /*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		var obj = elem.first();
		var toReturn = @com.ati.ext4j.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
		return toReturn;
    }-*/;

    public native ExtElement first(String selector) /*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		var obj = elem.first(selector);
		var toReturn = @com.ati.ext4j.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
		return toReturn;
    }-*/;

    public native ExtElement last() /*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		var obj = elem.last();
		var toReturn = @com.ati.ext4j.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
		return toReturn;
    }-*/;

    public native ExtElement last(String selector) /*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		var obj = elem.last(selector);
		var toReturn = @com.ati.ext4j.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
		return toReturn;
    }-*/;

    /**
     * Tries to focus the element. Any exceptions are caught and ignored.
     * 
     * @return this
     */
    public native ExtElement focus() /*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		elem.focus();
		return this;
    }-*/;

    /**
     * Checks whether this element can be focused.
     * 
     * @return this
     */
    public native boolean isFocusable() /*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		return elem.focusable();
    }-*/;

    /**
     * Shows a ripple of exploding, attenuating borders to draw attention to an
     * Element.
     * 
     * @return this
     */
    public native ExtElement frame() /*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		elem.frame();
		return this;
    }-*/;

    /**
     * Shows a ripple of exploding, attenuating borders to draw attention to an
     * Element.
     * 
     * @return this
     */
    public native ExtElement frame(String color) /*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		elem.frame(color);
		return this;
    }-*/;

    /**
     * Shows a ripple of exploding, attenuating borders to draw attention to an
     * Element.
     * 
     * @return this
     */
    public native ExtElement frame(String color, int count) /*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		elem.frame(color, count);
		return this;
    }-*/;

    /**
     * Shows a ripple of exploding, attenuating borders to draw attention to an
     * Element.
     * 
     * @return this
     */
    public native ExtElement frame(String color, int count, Animation animation) /*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		elem.frame(color, count, animation);
		return this;
    }-*/;

    /**
     * Gets the x,y coordinates to align this element with another element.
     * 
     * @param element
     *            The element to align to
     * @param anchorPosition
     *            the element's anchor point
     * @return an array containing the element's x and y coordinates
     */
    public native int[] getAlignToXY(Element element, String anchorPosition) /*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		var arrJS = elem.getAlignToXY(element, anchorPosition);
		return @com.ati.ext4j.client.core.JsoHelper::convertToJavaIntArray(Lcom/google/gwt/core/client/JavaScriptObject;)(arrJS);
    }-*/;

    /**
     * Gets the x,y coordinates to align this element with another element.
     * 
     * @param element
     *            The element to align to.
     * @param anchorPosition
     *            the element's anchor point
     * @param offesets
     *            offset the positioning by [x, y]
     * @return an array containing the element's x and y coordinates
     */
    public native int[] getAlignToXY(Element element, String anchorPosition, int[] offesets) /*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		var offsetsJS = @com.ati.ext4j.client.core.JsoHelper::convertToJavaScriptArray([I)(offesets);
		var arrJS = elem.getAlignToXY(element, anchorPosition, offsetsJS);
		return @com.ati.ext4j.client.core.JsoHelper::convertToJavaIntArray(Lcom/google/gwt/core/client/JavaScriptObject;)(arrJS);
    }-*/;

    /**
     * Gets the x,y coordinates specified by the anchor position on the element.
     * 
     * @return an array containing the element's x and y coordinates
     */
    public native int[] getAnchorXY() /*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		var arrJS = elem.getAnchorXY();
		return @com.ati.ext4j.client.core.JsoHelper::convertToJavaIntArray(Lcom/google/gwt/core/client/JavaScriptObject;)(arrJS);
    }-*/;

    /**
     * Gets the x,y coordinates specified by the anchor position on the element.
     * 
     * @param anchorPosition
     *            the specified anchor position.
     * @param local
     *            true to get the local (element top/left-relative) anchor
     *            position instead of page coordinates
     * @param width
     *            width to use for calculating anchor position
     * @param height
     *            height to use for calculating anchor position
     * @return an array containing the element's x and y coordinates
     */
    public native int[] getAnchorXY(String anchorPosition, boolean local, int width, int height) /*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		var arrJS = elem.getAnchorXY(anchorPosition, local, {
			width : width,
			height : height
		});
		return @com.ati.ext4j.client.core.JsoHelper::convertToJavaIntArray(Lcom/google/gwt/core/client/JavaScriptObject;)(arrJS);
    }-*/;

    /**
     * Returns the value of a namespaced attribute from the element's underlying
     * DOM node.
     * 
     * @param namespace
     *            the namespace in which to look for the attribute
     * @param name
     *            the attribute name
     * @return the attribute value
     */
    public native String getAttributeNS(String namespace, String name)/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		return elem.getAttributeNS(namespace, name);
    }-*/;

    /**
     * Gets the width of the border for the specified side.
     * 
     * @param side
     *            the side
     * @return width of the side
     */
    public native int getBorderWidth(Side side)/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		var sideJS = side.@com.ati.ext4j.client.core.Side::getSide()();
		return elem.getBorderWidth(sideJS);
    }-*/;

    /**
     * Gets the bottom Y coordinate of the element (element Y position + element
     * height)
     * 
     * @param local
     *            true to get the local css position instead of page coordinate
     * @return the bottom Y coordinate
     */
    public native int getBottom(boolean local)/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		return elem.getBottom(local);
    }-*/;

    /**
     * Return a Box that can be used to set another elements size/location to
     * match this element.
     * 
     * @return the box object
     */
    public native Box getBox()/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		var boxJS = elem.getBox();
		return @com.ati.ext4j.client.core.Box::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(boxJS);
    }-*/;

    /**
     * Return a Box that can be used to set another elements size/location to
     * match this element.
     * 
     * @param contentBox
     *            if true a box for the content of the element is returned.
     * @param local
     *            if true the element's left and top are returned instead of
     *            page x/y
     * @return the box object
     */
    public native Box getBox(boolean contentBox, boolean local)/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		var boxJS = elem.getBox(contentBox, local);
		return @com.ati.ext4j.client.core.Box::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(boxJS);
    }-*/;

    /**
     * Calculates the x, y to center this element on the screen
     * 
     * @return the x, y values [
     */
    public native int[] getCenterXY() /*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		var arrJS = elem.getCenterXY();
		return @com.ati.ext4j.client.core.JsoHelper::convertToJavaIntArray(Lcom/google/gwt/core/client/JavaScriptObject;)(arrJS);
    }-*/;

    /**
     * Return the CSS color for the specified CSS attribute. rgb, 3 digit (like
     * #fff) and valid values are convert to standard 6 digit hex color.
     * 
     * @param attr
     *            the css attribute
     * @param defaultValue
     *            the default value to use when a valid color isn't found
     * @return the css color
     */
    public native String getColor(String attr, String defaultValue)/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		return elem.getColor(attr, defaultValue);
    }-*/;

    /**
     * Return the CSS color for the specified CSS attribute. rgb, 3 digit (like
     * #fff) and valid values are convert to standard 6 digit hex color.
     * 
     * @param attr
     *            the css attribute
     * @param defaultValue
     *            the default value to use when a valid color isn't found
     * @param prefix
     *            defaults to #. Use an empty string when working with YUI color
     *            anims.
     * @return the css color
     */
    public native String getColor(String attr, String defaultValue, String prefix)/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		return elem.getColor(attr, defaultValue, prefix);
    }-*/;

    /**
     * Returns either the offsetHeight or the height of this element based on
     * CSS height adjusted by padding or borders when needed to simulate
     * offsetHeight when offsets aren't available. This may not work on
     * display:none elements if a height has not been set using CSS.
     * 
     * @return the computed height
     */
    public native int getComputedHeight()/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		return elem.getComputedHeight();
    }-*/;

    /**
     * Returns either the offsetWidth or the width of this element based on CSS
     * width adjusted by padding or borders when needed to simulate offsetWidth
     * when offsets aren't available. This may not work on display:none elements
     * if a width has not been set using CSS.
     * 
     * @return the computed width
     */
    public native int getComputedWidth()/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		return elem.getComputedWidth();
    }-*/;

    /**
     * Returns the underlying DOM Element.
     * 
     * @return the DOM element
     */
    public native Element getDom()/*-{
		var element = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		var dom = element.dom;
		return dom === undefined ? null : dom;
    }-*/;

    /**
     * Returns the sum width of the padding and borders for the passed side.
     * 
     * @param side
     *            the side
     * @return sum of padding and border for the side
     */
    public native int getFrameWidth(Side side)/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		var sideJS = side.@com.ati.ext4j.client.core.Side::getSide()();
		return elem.getFrameWidth(sideJS);
    }-*/;

    /**
     * Returns the offset height of the element.
     * 
     * @return the element's height
     */
    public native int getHeight()/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		return elem.getHeight();
    }-*/;

    /**
     * Returns the offset height of the element.
     * 
     * @param contentHeight
     *            true to get the height minus borders and padding
     * @return the element's height
     */
    public native int getHeight(boolean contentHeight)/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		return elem.getHeight(contentHeight);
    }-*/;

    /**
     * Gets the left X coordinate
     * 
     * @return the left coordinate.
     */
    public native int getLeft()/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		return elem.getLeft();
    }-*/;

    /**
     * Gets the left X coordinate.
     * 
     * @param local
     *            true to get the local css position instead of page coordinate
     * @return the X cooridinate
     */
    public native int getLeft(boolean local)/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		return elem.getLeft(local);
    }-*/;

    /**
     * Gets the next sibling, skipping text nodes.
     * 
     * @return the next sibling or null
     */
    public native ExtElement next()/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		var obj = elem.next();
		return @com.ati.ext4j.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
    }-*/;

    /**
     * Gets the next sibling, skipping text nodes.
     * 
     * @param selector
     *            Find the next sibling that matches the passed simple selector
     * @return the next sibling or null
     */
    public native Element next(String selector)/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		var obj = elem.next(selector);
		return @com.ati.ext4j.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
    }-*/;

    /**
     * Gets the width of the padding for the specified side.
     * 
     * @param side
     *            the side
     * @return padding
     */
    public native int getPadding(Side side)/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		var sideJS = side.@com.ati.ext4j.client.core.Side::getSide()();
		return elem.getPadding(sideJS);
    }-*/;

    /**
     * Gets the previous sibling, skipping text nodes.
     * 
     * @return the previous sibling or null
     */
    public native ExtElement prev()/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		var obj = elem.prev();
		return @com.ati.ext4j.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
    }-*/;

    /**
     * Gets the previous sibling, skipping text nodes.
     * 
     * @param selector
     *            Find the previous sibling that matches the passed simple
     *            selector
     * @return the previous sibling or null
     */
    public native Element prev(String selector)/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		var obj = elem.prev(selector);
		return @com.ati.ext4j.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
    }-*/;

    // todo test
    /**
     * Returns the current scroll position of the element.
     * 
     * @return array of left and top scroll position
     */
    public native int[] getScroll()/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		var scroll = elem.getScroll();
		return @com.ati.ext4j.client.core.JsoHelper::convertToJavaIntArray(Lcom/google/gwt/core/client/JavaScriptObject;)([scroll.left, scroll.top]);
    }-*/;

    /**
     * Returns the size of the element..
     * 
     * @return element size
     */
    public native Size getSize()/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		var sizeJS = elem.getSize();
		return @com.ati.ext4j.client.core.Size::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(sizeJS);
    }-*/;

    /**
     * Normalizes currentStyle and computedStyle.
     * 
     * @param property
     *            the style property whose value is returned
     * @return the current value of the style property for this element,
     *         "undefined" if the style is not applied to the element
     */
    public native String getStyle(String property)/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		return String(elem.getStyle(property));
    }-*/;

    /**
     * Returns the top Y coordinate.
     * 
     * @return the Y coordinate
     */
    public native int getTop()/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		return elem.getTop();
    }-*/;

    /**
     * Returns the top Y coordinate.
     * 
     * @param local
     *            true to get the local css position instead of page coordinate
     * @return the top Y coordinate
     */
    public native int getTop(boolean local)/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		return elem.getTop(local);
    }-*/;

    /**
     * Returns the value of the "value" attribute
     * 
     * @return the value
     */
    public native String getValue()/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		return elem.getValue();
    }-*/;

    /**
     * Returns the value of the "value" attribute as a number.
     * 
     * @return tried to parse the value as number
     */
    public native float getValueAsNumber()/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		return elem.getValue();
    }-*/;

    /**
     * Returns the width and height of the viewport.
     * 
     * @return the viewport's Size
     */
    public native Size getViewSize()/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		var sizeJS = elem.getViewSize();
		return @com.ati.ext4j.client.core.Size::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(sizeJS);
    }-*/;

    /**
     * Returns the offset width of the element.
     * 
     * @return the elements width
     */
    public native int getWidth()/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		return elem.getWidth();
    }-*/;

    /**
     * Returns the offset width of the element.
     * 
     * @param contentWidth
     *            true to get the width minus borders and padding
     * @return the elemetns width
     */
    public native int getWidth(boolean contentWidth)/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		return elem.getWidth(contentWidth);
    }-*/;

    /**
     * Gets the current X position of the element based on page coordinates.
     * Element must be part of the DOM tree to have page coordinates
     * (display:none or elements not appended return false).
     * 
     * @return the X position of the element
     */
    public native int getX()/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		return elem.getX();
    }-*/;

    /**
     * Gets the current position of the element based on page coordinates.
     * Element must be part of the DOM tree to have page coordinates
     * (display:none or elements not appended return false).
     * 
     * @return the XY position of the element
     */
    public native int[] getXY() /*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		var arrJS = elem.getXY();
		return @com.ati.ext4j.client.core.JsoHelper::convertToJavaIntArray(Lcom/google/gwt/core/client/JavaScriptObject;)(arrJS);
    }-*/;

    /**
     * Gets the current Y position of the element based on page coordinates.
     * Element must be part of the DOM tree to have page coordinates
     * (display:none or elements not appended return false).
     * 
     * @return the Y position of the element
     */
    public native int getY()/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		return elem.getY();
    }-*/;

    /**
     * Checks if the specified CSS class exists on this element's DOM node.
     * 
     * @param className
     *            the CSS class to check for
     * @return true if the class exists, else false
     */
    public native boolean hasClass(String className)/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		return elem.hasCls(className);
    }-*/;

    // todo initDD, initDDProxy, initDDTarget
    /**
     * Inserts this element after the passed element in the DOM.
     * 
     * @param el
     *            the element to insert after
     * @return this
     */
    public native ExtElement insertAfter(Element el)/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		elem.insertAfter(el);
		return this;
    }-*/;

    /**
     * Inserts this element before the passed element in the DOM.
     * 
     * @param el
     *            the element to insert before
     * @return this
     */
    public native ExtElement insertBefore(Element el)/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		elem.insertBefore(el);
		return this;
    }-*/;

    /**
     * Inserts an element as the first child of the this element.
     * 
     * @param el
     *            the element to insert
     * @return this
     */
    public native ExtElement insertFirst(Element el)/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		elem.insertFirst(el);
		return this;
    }-*/;

    /**
     * Creates an element as the first child of the this element.
     * 
     * @param config
     *            DomHelper config to create element
     * @return the new child i
     */
    public native ExtElement insertFirst(DomConfig config)/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		var configJS = config.@com.ati.ext4j.client.core.DomConfig::getJsObject()();
		var el = elem.insertFirst(configJS);
		return @com.ati.ext4j.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(el);
    }-*/;

    /**
     * Inserts an html fragment into this element.
     * 
     * @param html
     *            the html fragment
     * @return the inserted node (or nearest related if more than 1 inserted)
     */
    public native Element insertHtmlBeforeBegin(String html)/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		return elem.insertHtml('beforeBegin', html, true);
    }-*/;

    /**
     * Inserts an html fragment into this element.
     * 
     * @param html
     *            the html fragment
     * @return the inserted node (or nearest related if more than 1 inserted)
     */
    public native Element insertHtmlAfterBegin(String html)/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		return elem.insertHtml('afterBegin', html, true);
    }-*/;

    /**
     * Inserts an html fragment into this element.
     * 
     * @param html
     *            the html fragment
     * @return the inserted node (or nearest related if more than 1 inserted)
     */
    public native Element insertHtmlBeforeEnd(String html)/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		return elem.insertHtml('beforeEnd', html, true);
    }-*/;

    /**
     * Inserts an html fragment into this element.
     * 
     * @param html
     *            the html fragment
     * @return the inserted node (or nearest related if more than 1 inserted)
     */
    public native Element insertHtmlAfterEnd(String html)/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		return elem.insertHtml('afterEnd', html, true);
    }-*/;

    /**
     * Inserts the passed element as a sibling of this element.
     * 
     * @param el
     *            the element to insert
     * @return the inserted element
     */
    public native Element insertSibling(Element el)/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		return elem.insertSibling(el, 'before', true);
    }-*/;

    /**
     * Inserts the passed element as a sibling of this element.
     * 
     * @param el
     *            the element to insert
     * @param before
     *            insert before or after
     * @return the inserted element
     */
    public native ExtElement insertSibling(Element el, boolean before)/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		var where = before ? 'before' : 'after';
		return elem.insertSibling(el, where, true);
    }-*/;

    /**
     * Created the passed DomHelper config as a sibling of this element.
     * 
     * @param config
     *            the DomHelper config
     * @return the inserted element
     */
    public native Element insertSibling(DomConfig config)/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		var configJS = config.@com.ati.ext4j.client.core.DomConfig::getJsObject()();
		return elem.insertSibling(configJS, 'before', true);
    }-*/;

    /**
     * Created the passed DomHelper config as a sibling of this element.
     * 
     * @param config
     *            the DomHelper config
     * @param before
     *            to insert before or after
     * @return the inserted element
     */
    public native ExtElement insertSibling(DomConfig config, boolean before)/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		var configJS = config.@com.ati.ext4j.client.core.DomConfig::getJsObject()();
		var where = before ? 'before' : 'after';
		elem.insertSibling(configJS, where);
		return this;
    }-*/;

    /**
     * Returns true if this element matches the passed simple selector (e.g.
     * div.some-class or span:first-child)
     * 
     * @param selector
     *            the simple selector to test
     * @return true if this element matches the selector, else false
     */
    public native boolean is(String selector)/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		return elem.is(selector);
    }-*/;

    /**
     * Tests various css rules/browsers to determine if this element uses a
     * border box
     * 
     * @return true is element uses border box
     */
    public native boolean isBorderBox()/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		return elem.isBorderBox();
    }-*/;

    /**
     * Returns true if display is not "none".
     * 
     * @return true if display is not "none"
     */
    public native boolean isDisplayed()/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		return elem.isDisplayed();
    }-*/;

    /**
     * Returns true if this element is masked.
     * 
     * @return true if this element is masked
     */
    public native boolean isMasked()/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		return elem.isMasked();
    }-*/;

    /**
     * Returns true if this element is scrollable.
     * 
     * @return true if this element is scrollable
     */
    public native boolean isScrollable()/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		return elem.isScrollable();
    }-*/;

    /**
     * Checks whether the element is currently visible using both visibility and
     * display properties.
     * 
     * @return true if visible
     */
    public native boolean isVisible()/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		return elem.isVisible();
    }-*/;

    /**
     * Checks whether the element is currently visible using both visibility and
     * display properties.
     * 
     * @param deep
     *            true to walk the dom and see if parent elements are hidden
     *            (defaults to false)
     * @return true if visible
     */
    public native boolean isVisible(boolean deep)/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		return elem.isVisible(deep);
    }-*/;

    /**
     * Puts a mask over this element to disable user interaction. This method
     * can only be applied to elements which accept child nodes.
     * 
     * @return the mask element
     */
    public native ExtElement mask()/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		var me = elem.mask();
		return @com.ati.ext4j.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(me);
    }-*/;

    /**
     * Puts a mask over this element to disable user interaction. This method
     * can only be applied to elements which accept child nodes. By default an
     * animated loading icon is added.
     * 
     * @param msg
     *            a message to display in the mask
     * @return the mask element
     */
    public ExtElement mask(String msg) {
        // by default add animated icon
        return mask(msg, "x-mask-loading");
    }

    /**
     * Puts a mask over this element to disable user interaction. This method
     * can only be applied to elements which accept child nodes. By default an
     * animated loading icon is added.
     * 
     * @param msg
     *            a message to display in the mask
     * @param animatedIcon
     *            true to add animated loading icon, false to skip
     * @return the mask element
     */
    public ExtElement mask(String msg, boolean animatedIcon) {
        if (animatedIcon) {
            return mask(msg, "x-mask-loading");
        } else {
            return mask(msg, null);
        }
    }

    /**
     * Puts a mask over this element to disable user interaction. This method
     * can only be applied to elements which accept child nodes.
     * 
     * @param msg
     *            a message to display in the mask
     * @param msgClass
     *            a css class to apply to the msg element
     * @return the mask element
     */
    public native ExtElement mask(String msg, String msgClass) /*-{
		var el = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		var me = el.mask(msg, msgClass);
		return @com.ati.ext4j.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(me);
    }-*/;

    /**
     * Initializes positioning on this element. The element will be positioned
     * relative IF it is not already positioned
     */
    public native void position()/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		elem.position();
    }-*/;

    /**
     * Initializes positioning on this element. The element will be positioned
     * relative IF it is not already positioned
     */
    public native void position(String position)/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		elem.position(position);
    }-*/;

    /**
     * Initializes positioning on this element. The element will be positioned
     * relative IF it is not already positioned
     */
    public native void position(String position, double zIndex)/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		elem.position(position.zIndex);
    }-*/;

    /**
     * Initializes positioning on this element. The element will be positioned
     * relative IF it is not already positioned
     */
    public native void position(String position, double zIndex, double x, double y)/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		elem.position(position.zIndex, x, y);
    }-*/;

    /**
     * Fades the element out while slowly expanding it in all directions. When
     * the effect is completed, the element will be hidden (visibility =
     * 'hidden') but block elements will still take up space in the document.
     */
    public native ExtElement puff()/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		elem.puff();
		return this;
    }-*/;

    /**
     * Fades the element out while slowly expanding it in all directions. When
     * the effect is completed, the element will be hidden (visibility =
     * 'hidden') but block elements will still take up space in the document.
     */
    public native ExtElement puff(FadeOut config)/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		elem.puff(config.@com.ati.ext4j.client.core.JsObject::getJsObj()());
		return this;
    }-*/;

    /**
     * Selects child nodes based on the passed CSS selector (the selector should
     * not contain an id).
     * 
     * @param selector
     *            the CSS selector
     * @return an array of the matched nodes
     */
    public native Element[] query(String selector)/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		var elemsJS = elem.query(selector);
		return elemsJS == null || elemsJS === undefined ? null
				: @com.ati.ext4j.client.core.JsoHelper::toElementArray(Lcom/google/gwt/core/client/JavaScriptObject;)(elemsJS);
    }-*/;

    /**
     * Removes this element's dom reference. Note that event and cache removal
     * is handled at Ext.removeNode
     */
    public native void remove()/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		elem.remove();
    }-*/;

    /**
     * Removes all previous added listeners from this element
     */
    public native void removeAllListeners()/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		elem.removeAllListeners();
    }-*/;

    /**
     * Replaces the passed element with this element.
     * 
     * @param el
     *            the element to replace
     * @return this
     */
    public native ExtElement replace(Element el)/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		elem.replace(el);
		return this;
    }-*/;

    /**
     * Scrolls this element into view within the passed container.
     * 
     * @return this
     */
    public native ExtElement scrollIntoView()/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		elem.scrollIntoView();
		return this;
    }-*/;

    /**
     * Scrolls this element into view within the passed container
     * 
     * @param container
     *            the container element to scroll (defaults to document.body)
     * @param hscroll
     *            false to disable horizontal scroll (defaults to true)
     * @return this
     */
    public native ExtElement scrollIntoView(Element container, boolean hscroll)/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		elem.scrollIntoView(container, hscroll);
		return this;
    }-*/;

    /**
     * Creates a CompositeElement for child nodes based on the passed CSS
     * selector (the selector should not contain an id).
     * 
     * @param selector
     *            the CSS selector
     * @return the CompositeElement
     */
    public native CompositeElement select(String selector)/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		var ceJS = elem.select(selector);
		return ceJS == null || ceJS === undefined ? null
				: @com.ati.ext4j.client.core.CompositeElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(ceJS);
    }-*/;

    /**
     * Creates a CompositeElement for child nodes based on the passed CSS
     * selector (the selector should not contain an id).
     * 
     * @param selector
     *            the CSS selector
     * @param unique
     *            true to create a unique ExtElement for each child (defaults to
     *            false, which creates a single shared flyweight object)
     * @return the CompositeElement
     */
    public native CompositeElement select(String selector, boolean unique)/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		var ceJS = elem.select(selector, unique);
		if (unique) {
			return ceJS == null || ceJS === undefined ? null
					: @com.ati.ext4j.client.core.CompositeElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(ceJS);
		} else {
			return ceJS == null || ceJS === undefined ? null
					: @com.ati.ext4j.client.core.CompositeElementLite::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(ceJS);
		}
    }-*/;

    /**
     * Translates the passed page coordinates into left/top css values for this
     * element
     * 
     * @param x
     *            the page x
     * @param y
     *            the page y
     * @return array of left, top values
     */
    public native int[] translatePoints(int x, int y)/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		var leftTopJS = elem.translatePoints(x, y);
		return @com.ati.ext4j.client.core.JsoHelper::convertToJavaIntArray(Lcom/google/gwt/core/client/JavaScriptObject;)([leftTopJS.left, leftTopJS.top]);
    }-*/;

    /**
     * Return clipping (overflow) to original clipping before clip() was called.
     * 
     * @return this
     */
    public native ExtElement unclip() /*-{
		var el = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		el.unclip();
		return this;
    }-*/;

    /**
     * Removes a previously applied mask. If removeEl is true the mask overlay
     * is destroyed, otherwise it is cached for reuse.
     */
    public native void unmask() /*-{
		var el = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		el.unmask();
    }-*/;

    /**
     * Update the innerHTML of this element, optionally searching for and
     * processing scripts.
     * 
     * @param html
     *            the new HTML
     * @param loadScripts
     *            true to look for and process scripts
     * @param callback
     *            for async script loading you can be notified when the update
     *            completes
     */
    public native void update(String html, boolean loadScripts, Function callback) /*-{
		var el = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		el.update(html, loadScripts, callback == null ? null : function() {
			callback.@com.ati.ext4j.client.core.Function::execute()();
		});
    }-*/;

    /**
     * Update the innerHTML of this element, optionally searching for and
     * processing scripts.
     * 
     * @param html
     *            the new HTML
     * @param loadScripts
     *            true to look for and process scripts
     * @param callback
     *            for async script loading you can be notified when the update
     *            completes
     */
    public native void update(String html) /*-{
		var el = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		el.update(html);
    }-*/;

    /**
     * Walks up the dom looking for a parent node that matches the passed simple
     * selector (e.g. div.some-class or span:first-child). The max depth to
     * search defaults to 10 or document.body. This is a shortcut for
     * findParentNode() that always returns an ExtElement
     * 
     * @param selector
     *            the simple selector to test
     * @return the matching DOM or null if no match was found
     */
    public native ExtElement up(String selector) /*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		var el = elem.up(selector);
		return el == null || el === undefined ? null
				: @com.ati.ext4j.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(el);
    }-*/;

    /**
     * Walks up the dom looking for a parent node that matches the passed simple
     * selector (e.g. div.some-class or span:first-child). This is a shortcut
     * for findParentNode() that always returns an ExtElement
     * 
     * @param selector
     *            the simple selector to test
     * @param container
     *            the container to stop at
     * @return the matching DOM or null if no match was found
     */
    public native ExtElement up(String selector, Element container) /*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		var el = elem.up(selector, container);
		return el == null || el === undefined ? null
				: @com.ati.ext4j.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(el);
    }-*/;

    /**
     * Walks up the dom looking for a parent node that matches the passed simple
     * selector (e.g. div.some-class or span:first-child). This is a shortcut
     * for findParentNode() that always returns an ExtElement
     * 
     * @param selector
     *            the simple selector to test
     * @param maxDepth
     *            The max depth to search (defaults to 10 || document.body)
     * @return the matching DOM or null if no match was found
     */
    public native ExtElement up(String selector, int maxDepth) /*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		var el = elem.up(selector, maxDepth);
		return el == null || el === undefined ? null
				: @com.ati.ext4j.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(el);
    }-*/;

    /**
     * Return the first child of this element.
     * 
     * @return the first child
     */
    public native Element getFirstChild() /*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		return elem.dom.firstChild;
    }-*/;

    /**
     * Return the parent node of this element,
     * 
     * @return the parent node
     */
    public native Element getParentNode() /*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		return elem.dom.parentNode;
    }-*/;

    /**
     * Remove the specified child.
     * 
     * @param child
     *            the child
     */
    public native void removeChild(Element child) /*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		elem.dom.removeChild(child);
    }-*/;

    /**
     * Return the client width of the element.
     * 
     * @return the client width
     */
    public native int getClientWidth() /*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		return elem.dom.clientWidth;
    }-*/;

    /**
     * Set the scroll top position.
     * 
     * @param scrollTop
     *            the scroll top position
     */
    public native void setScrollTop(int scrollTop) /*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		elem.dom.scrollTop = scrollTop;
    }-*/;

    /**
     * More flexible version of {@link #setStyle} for setting style properties.
     * 
     * @param style
     *            a style specification string, e.g. "width:100px"
     * @return this
     */
    public native ExtElement applyStyles(String style) /*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		elem.applyStyles(style);
		return this;
    }-*/;

    /**
     * Wrapper for setting style properties.
     * 
     * @param style
     *            the style property to be set
     * @param value
     *            the value to apply to the given property
     * @return this
     */
    public native ExtElement setStyle(String style, String value)/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		elem.setStyle(style, value);
		return this;
    }-*/;

    public native ExtElement setStyle(StyleConfig style)/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		elem.setStyle(style.@com.ati.ext4j.client.core.JsObject::getJsObj()());
		return this;
    }-*/;

    /**
     * Set the width of this Element.
     * 
     * @return this
     */
    public native ExtElement setWidth(String value)/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		elem.setWidth(value);
		return this;
    }-*/;

    /**
     * Set the width of this Element.
     * 
     * @return this
     */
    public native ExtElement setWidth(String value, boolean animate)/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		elem.setWidth(value, animate);
		return this;
    }-*/;

    /**
     * Set the width of this Element.
     * 
     * @return this
     */
    public native ExtElement setWidth(String value, Animation animation)/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		elem.setWidth(value,
				animation.@com.ati.ext4j.client.core.JsObject::getJsObj()());
		return this;
    }-*/;

    /**
     * Set the width of this Element.
     * 
     * @return this
     */
    public native ExtElement setWidth(double value)/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		elem.setWidth(value);
		return this;
    }-*/;

    /**
     * Set the width of this Element.
     * 
     * @return this
     */
    public native ExtElement setWidth(double value, boolean animate)/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		elem.setWidth(value, animate);
		return this;
    }-*/;

    /**
     * Set the width of this Element.
     * 
     * @return this
     */
    public native ExtElement setWidth(double value, Animation animation)/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		elem.setWidth(value,
				animation.@com.ati.ext4j.client.core.JsObject::getJsObj()());
		return this;
    }-*/;

    /**
     * Set the height of this Element.
     * 
     * @return this
     */
    public native ExtElement setHeight(String value)/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		elem.setHeight(value);
		return this;
    }-*/;

    /**
     * Set the width of this Element.
     * 
     * @return this
     */
    public native ExtElement setHeight(String value, boolean animate)/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		elem.setHeight(value, animate);
		return this;
    }-*/;

    /**
     * Set the Height of this Element.
     * 
     * @return this
     */
    public native ExtElement setHeight(String value, Animation animation)/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		elem.setHeight(value,
				animation.@com.ati.ext4j.client.core.JsObject::getJsObj()());
		return this;
    }-*/;

    /**
     * Set the Height of this Element.
     * 
     * @return this
     */
    public native ExtElement setHeight(double value)/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		elem.setHeight(value);
		return this;
    }-*/;

    /**
     * Set the Height of this Element.
     * 
     * @return this
     */
    public native ExtElement setHeight(double value, boolean animate)/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		elem.setHeight(value, animate);
		return this;
    }-*/;

    /**
     * Set the Height of this Element.
     * 
     * @return this
     */
    public native ExtElement setHeight(double value, Animation animation)/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		elem.setHeight(value,
				animation.@com.ati.ext4j.client.core.JsObject::getJsObj()());
		return this;
    }-*/;

    /**
     * Set the size of this Element.
     * 
     * @return this
     */
    public native ExtElement setSize(double width, double height, Animation animation)/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		elem.setSize(width, height,
				animation.@com.ati.ext4j.client.core.JsObject::getJsObj()());
		return this;
    }-*/;

    /**
     * Set the size of this Element.
     * 
     * @return this
     */
    public native ExtElement setSize(double width, double height)/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		elem.setSize(width, height);
		return this;
    }-*/;

    /**
     * Highlights the Element by setting a color (applies to the
     * background-color by default, but can be changed using the "attr" config
     * option) and then fading back to the original color. If no original color
     * is available, you should provide the "endColor" config option which will
     * be cleared after the animation.
     * 
     * @return this
     */
    public native ExtElement highlight()/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		elem.highlight();
		return this;
    }-*/;

    public native void disableShadow()/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		if (elem.disableShadow) {
			elem.disableShadow();

		}
		//diable isn't working entirely (e.g. for last shown window) so create shadow backup and replace shadow by null
		elem._shadow = el.shadow;
		elem.shadow = null;
    }-*/;

    public native void enableShadow()/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		if (elem.disableShadow) {
			elem.shadow = elem._shadow;
			elem.enableShadow();
		}
    }-*/;

    /**
     * Highlights the Element by setting a color (applies to the
     * background-color by default, but can be changed using the "attr" config
     * option) and then fading back to the original color. If no original color
     * is available, you should provide the "endColor" config option which will
     * be cleared after the animation.
     * 
     * @return this
     */
    public native ExtElement highlight(String color)/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		elem.highlight(color);
		return this;
    }-*/;

    /**
     * Highlights the Element by setting a color (applies to the
     * background-color by default, but can be changed using the "attr" config
     * option) and then fading back to the original color. If no original color
     * is available, you should provide the "endColor" config option which will
     * be cleared after the animation.
     * 
     * @return this
     */
    public native ExtElement highlight(String color, HighLight config)/*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		elem.highlight(color,
				config.@com.ati.ext4j.client.core.JsObject::getJsObj()());
		return this;
    }-*/;

    // Events
    /**
     * Where supported. Fires when an element is activated, for instance,
     * through a mouse click or a keypress.
     */
    public ElementHandlerRegistration addDomActivateHandler(EventHandler handler) {
        return addHandler("DOMActive", handler);
    }

    /**
     * Where supported. Fires when an attribute has been modified.
     */
    public ElementHandlerRegistration addDomAttrModifiedHandler(EventHandler handler) {
        return addHandler("DOMAttrModified", handler);
    }

    /**
     * Where supported. Fires when the character data has been modified.
     */
    public ElementHandlerRegistration addDomCharacterDataModifiedHandler(EventHandler handler) {
        return addHandler("DOMCharacterDataModified", handler);
    }

    /**
     * Where supported. Similar to HTML focus event, but can be applied to any
     * focusable element.
     */
    public ElementHandlerRegistration addDomFocusInHandler(EventHandler handler) {
        return addHandler("DOMFocusIn", handler);
    }

    /**
     * Fires when an object/image is stopped from loading before completely
     * loaded.
     */
    public ElementHandlerRegistration addAbortHandler(EventHandler handler) {
        return addHandler("abort", handler);
    }

    /**
     * Fires when an element loses focus either via the pointing device or by
     * tabbing navigation.
     */
    public ElementHandlerRegistration addBlurHandler(EventHandler handler) {
        return addHandler("blur", handler);
    }

    /**
     * Fires when a control loses the input focus and its value has been
     * modified since gaining focus.
     */
    public ElementHandlerRegistration addChangeHandler(EventHandler handler) {
        return addHandler("change", handler);
    }

    /**
     * Fires when a mouse click is detected within the element.
     */
    public ElementHandlerRegistration addClickHandler(EventHandler handler) {
        return addHandler("click", handler);
    }

    /**
     * Fires when a right click is detected within the element.
     */
    public ElementHandlerRegistration addContextMenuHandler(EventHandler handler) {
        return addHandler("contextmenu", handler);
    }

    /**
     * Fires when a mouse double click is detected within the element.
     */
    public ElementHandlerRegistration addDoubleClickHandler(EventHandler handler) {
        return addHandler("dblclick", handler);
    }

    /**
     * Fires when an object/image/frame cannot be loaded properly.
     */
    public ElementHandlerRegistration addErrorHandler(EventHandler handler) {
        return addHandler("error", handler);
    }

    /**
     * Fires when an element receives focus either via the pointing device or by
     * tab navigation.
     */
    public ElementHandlerRegistration addFocusHandler(EventHandler handler) {
        return addHandler("focus", handler);
    }

    /**
     * Fires when a keydown is detected within the element.
     */
    public ElementHandlerRegistration addKeyDownHandler(EventHandler handler) {
        return addHandler("keydown", handler);
    }

    /**
     * Fires when a keypress is detected within the element.
     */
    public ElementHandlerRegistration addKeyPressHandler(EventHandler handler) {
        return addHandler("keypress", handler);
    }

    /**
     * Fires when a keyup is detected within the element.
     */
    public ElementHandlerRegistration addKeyUpHandler(EventHandler handler) {
        return addHandler("keyup", handler);
    }

    /**
     * Fires when the user agent finishes loading all content within the
     * element. Only supported by window, frames, objects and images.
     */
    public ElementHandlerRegistration addLoadHandler(EventHandler handler) {
        return addHandler("load", handler);
    }

    /**
     * Fires when a mousedown is detected within the element.
     */
    public ElementHandlerRegistration addMouseDownHandler(EventHandler handler) {
        return addHandler("mousedown", handler);
    }

    /**
     * Fires when a mouseenter is detected within the element.
     */
    public ElementHandlerRegistration addMouseEnterHandler(EventHandler handler) {
        return addHandler("mouseenter", handler);
    }

    public ElementHandlerRegistration addMouseLeaveHandler(EventHandler handler) {
        return addHandler("mouseleave", handler);
    }

    public ElementHandlerRegistration addMouseMoveHandler(EventHandler handler) {
        return addHandler("mousemove", handler);
    }

    public ElementHandlerRegistration addMouseOverHandler(EventHandler handler) {
        return addHandler("mouseover", handler);
    }

    public ElementHandlerRegistration addMouseOutHandler(EventHandler handler) {
        return addHandler("mouseout", handler);
    }

    public ElementHandlerRegistration addMouseUpHandler(EventHandler handler) {
        return addHandler("mouseup", handler);
    }

    public ElementHandlerRegistration addResetHandler(EventHandler handler) {
        return addHandler("reset", handler);
    }

    public ElementHandlerRegistration addResizeHandler(EventHandler handler) {
        return addHandler("resize", handler);
    }

    public ElementHandlerRegistration addScrollHandler(EventHandler handler) {
        return addHandler("scroll", handler);
    }

    public ElementHandlerRegistration addSelectHandler(EventHandler handler) {
        return addHandler("select", handler);
    }

    public ElementHandlerRegistration addSubmitHandler(EventHandler handler) {
        return addHandler("submit", handler);
    }

    public ElementHandlerRegistration addUnload(EventHandler handler) {
        return addHandler("unload", handler);
    }

    public native ElementHandlerRegistration addHandler(String event, EventHandler handler)/*-{
		var component = this.@com.ati.ext4j.client.core.ExtElement::getJsObj()();
		var fn = function(event, el) {
			var eventObject = @com.ati.ext4j.client.core.EventObject::new(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
			handler.@com.ati.ext4j.client.events.element.EventHandler::onEvent(Lcom/ati/ext4j/client/core/EventObject;Lcom/google/gwt/dom/client/Element;)(eventObject,el);
		};
		component.addListener(event, fn);
		var toReturn = @com.ati.ext4j.client.events.ElementHandlerRegistration::new(Lcom/ati/ext4j/client/core/ExtElement;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,event,fn);
		return toReturn;

    }-*/;

    private native JavaScriptObject create(Element elem, boolean forceNew)/*-{
		return new $wnd.Ext.Element(elem, forceNew);
    }-*/;

    private static ExtElement instance(JavaScriptObject jsObj) {
        return new ExtElement(jsObj);
    }

    private native ExtElement _addCls(JsArrayString value) /*-{
		var elem = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		elem.addClass(value);
		return this;

    }-*/;

}
