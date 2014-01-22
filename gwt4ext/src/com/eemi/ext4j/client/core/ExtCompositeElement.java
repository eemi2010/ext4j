package com.eemi.ext4j.client.core;

import com.eemi.ext4j.client.fx.Anim;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * This class encapsulates a collection of DOM elements, providing methods to
 * filter members, or to perform collective actions upon the whole set.
 * <p>
 * Although they are not listed, this class supports all of the methods of
 * {@link ExtElement} and {@link Anim}. The methods from these classes will be
 * performed on all the elements in this collection.
 * 
 */
public class ExtCompositeElement extends JsObject {

    protected ExtCompositeElement(JavaScriptObject peer) {
        jsObj = peer;
    }

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
