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

package com.eemi.ext4j.client.ui;

import com.eemi.ext4j.client.core.ExtElement;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;

/**
 * An extended {@link ExtElement} object that supports a shadow and shim,
 * constrain to viewport and automatic maintaining of shadow/shim positions.
 * 
 */
public class Layer extends ExtElement {

    /**
     * Create a new Layer.
     * 
     * @param config
     *            the layer config
     */
    public Layer(LayerConfig config) {
        this(config, null);
    }

    /**
     * Create a new Layer.
     * 
     * @param config
     *            the layer config
     * @param existingEl
     *            an existing element
     */
    public Layer(LayerConfig config, Element existingEl) {
        jsObj = create(config.getJsObj(), existingEl);
    }

    public Layer(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public static Layer instance(JavaScriptObject jsObj) {
        return new Layer(jsObj);
    }

    private static native JavaScriptObject create(JavaScriptObject config, Element existingEl) /*-{
		return new $wnd.Ext.Layer(config, existingEl);
    }-*/;

    /**
     * Sets the z-index of this layer and adjusts any shadow and shim z-indexes.
     * The layer z-index is automatically incremented by two more than the value
     * passed in so that it always shows above any shadow or shim (the shadow
     * element, if any, will be assigned z-index + 1, and the shim element, if
     * any, will be assigned the unmodified z-index).
     * 
     * @param zindex
     *            the z index
     */
    public native void setZIndex(int zindex) /*-{
		var layer = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		layer.setZIndex(zindex);
    }-*/;
}
