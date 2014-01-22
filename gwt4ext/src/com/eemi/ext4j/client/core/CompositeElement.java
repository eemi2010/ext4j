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
package com.eemi.ext4j.client.core;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Standard composite class that creates an ExtElement for every element in the
 * collection.
 */
public class CompositeElement extends JsObject {

    /**
     * Create a CompositeElement using a native element.
     * 
     * @param jsObj
     *            native object
     */
    public CompositeElement(JavaScriptObject jsObj) {
        super(jsObj);
    }

    private static CompositeElement instance(JavaScriptObject jsObj) {
        return new CompositeElement(jsObj);
    }

    /**
     * Adds elements to this composite.
     * 
     * @param selector
     *            a CSS selector
     * @return this
     */
    public native CompositeElement add(String selector) /*-{
		var ce = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		ce.add(selector);
		return this;
    }-*/;

    /**
     * Adds elements to this composite.
     * 
     * @param element
     *            the elemetn to add
     * @return this
     */
    public native CompositeElement add(ExtElement element) /*-{
		var ce = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		ce.add(element);
		return this;
    }-*/;

    /**
     * Removes all elements.
     */
    public native void clear() /*-{
		var ce = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		ce.clear();
    }-*/;

    /**
     * Returns true if this composite contains the passed element.
     * 
     * @param element
     *            true if containts element
     */
    public native void contains(ExtElement element) /*-{
		var ce = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		var elJS = element.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		return ce.contains(elJS);
    }-*/;

    // todo each, fill, item

    /**
     * Filters this composite to only elements that match the passed selector.
     * 
     * @param selector
     *            a CSS selector
     * @return this
     */
    public native CompositeElement filter(String selector) /*-{
		var ce = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		ce.filter(selector);
		return this;
    }-*/;

    /**
     * Returns the first Element
     * 
     * @return the first element
     */
    public native ExtElement first() /*-{
		var ce = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		var el = ce.first();
		return el == null ? null
				: @com.eemi.ext4j.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(el);
    }-*/;

    /**
     * Returns the number of elements in this composite.
     * 
     * @return the element count
     */
    public native int getCount() /*-{
		var ce = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		return ce.getCount();
    }-*/;

    /**
     * Position of the Element in the CompositeElement list.
     * 
     * @param element
     *            the element
     * @return index of element
     */
    public native int indexOf(ExtElement element) /*-{
		var ce = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		var elJS = element.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		return ce.indexOf(elJS);
    }-*/;

    /**
     * Returns the last Element.
     * 
     * @return the last element
     */
    public native ExtElement last() /*-{
		var ce = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		var el = ce.last();
		return el == null ? null
				: @com.eemi.ext4j.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(el);
    }-*/;

    /**
     * Removes the specified element.
     * 
     * @param index
     *            element to remove
     * @return this
     */
    public native CompositeElement removeElement(int index) /*-{
		var ce = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		ce.removeElement(index);
		return this;
    }-*/;

    /**
     * Removes the specified element.
     * 
     * @param index
     *            element to remove
     * @param removeDom
     *            true to also remove element from the document
     * @return this
     */
    public native CompositeElement removeElement(int index, boolean removeDom) /*-{
		var ce = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		ce.removeElement(index, removeDom);
		return this;
    }-*/;

    /**
     * Removes the specified element.
     * 
     * @param element
     *            the element to remove
     * @return this
     */
    public native CompositeElement removeElement(ExtElement element) /*-{
		var ce = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		var elJS = element.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		ce.removeElement(elJS);
		return this;
    }-*/;

    /**
     * Removes the specified element.
     * 
     * @param element
     *            the element to remove
     * @param removeDom
     *            true to also remove element from the document
     * @return this
     */
    public native CompositeElement removeElement(ExtElement element, boolean removeDom) /*-{
		var ce = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		var elJS = element.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		ce.removeElement(elJS, removeDom);
		return this;
    }-*/;

    /**
     * Replaces the specified element with the passed element.
     * 
     * @param index
     *            the index of the element in this composite to replace
     * @param replacement
     *            the element to replace with
     * @return this
     */
    public native CompositeElement replaceElement(int index, ExtElement replacement) /*-{
		var ce = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		var replacementJS = replacement.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		ce.replaceElement(index, replacementJS);
		return this;
    }-*/;

    /**
     * Replaces the specified element with the passed element.
     * 
     * @param index
     *            the index of the element in this composite to replace
     * @param replacement
     *            the element to replace with
     * @param removeDom
     *            true to remove and replace the element in the document too
     * @return this
     */
    public native CompositeElement replaceElement(int index, ExtElement replacement, boolean removeDom) /*-{
		var ce = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		var replacementJS = replacement.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		ce.replaceElement(index, replacementJS, removeDom);
		return this;
    }-*/;

    /**
     * Replaces the specified element with the passed element.
     * 
     * @param element
     *            the element in this composite to replace
     * @param replacement
     *            the element to replace with
     * @return this
     */
    public native CompositeElement replaceElement(ExtElement element, ExtElement replacement) /*-{
		var ce = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		var elJS = element.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		var replacementJS = replacement.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		ce.replaceElement(elJS, replacementJS);
		return this;
    }-*/;

    /**
     * Replaces the specified element with the passed element.
     * 
     * @param element
     *            the element in this composite to replace
     * @param replacement
     *            the element to replace with
     * @param removeDom
     *            true to remove and replace the element in the document too
     * @return this
     */
    public native CompositeElement replaceElement(ExtElement element, ExtElement replacement, boolean removeDom) /*-{
		var ce = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		var elJS = element.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		var replacementJS = replacement.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		ce.replaceElement(elJS, replacementJS, removeDom);
		return this;
    }-*/;

    public ExtElement asElement() {
        return new ExtElement(getJsObj());
    }

    public native ExtElement item(int index)/*-{
		var el = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		var obj = el.item(index);
		return obj ? @com.eemi.ext4j.client.core.ExtElement::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj)
				: null;
    }-*/;
}
