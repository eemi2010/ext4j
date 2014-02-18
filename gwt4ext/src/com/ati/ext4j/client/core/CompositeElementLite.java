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

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Flyweight composite class. Reuses the same Ext.Element for element
 * operations.
 */
public class CompositeElementLite extends CompositeElement {

    public CompositeElementLite(JavaScriptObject jsObj) {
        super(jsObj);
    }

    private static CompositeElementLite instance(JavaScriptObject jsObj) {
        return new CompositeElementLite(jsObj);
    }

    /**
     * Returns a flyweight Element of the dom element object at the specified
     * index.
     * 
     * @param index
     *            the element index
     * @return the element at index
     */
    public native ExtElement item(int index) /*-{
		var cel = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		var el = cel.item(index);
		return el == null ? null
				: @com.ati.ext4j.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(el);
    }-*/;
}