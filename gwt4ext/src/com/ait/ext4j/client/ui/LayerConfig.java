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
package com.ait.ext4j.client.ui;

import com.ait.ext4j.client.core.DomConfig;
import com.ait.ext4j.client.core.JsoHelper;
import com.ait.ext4j.client.core.config.BaseConfig;

/**
 * Configuration class for a Layer.
 * 
 */
public class LayerConfig extends BaseConfig {

    /**
     * CSS class to add to the element.
     * 
     * @param cls
     *            the CSS class
     */
    public void setCls(String cls) {
        JsoHelper.setAttribute(jsObj, "cls", cls);
    }

    /**
     * False to disable constrain to viewport (defaults to true)
     * 
     * @param constrain
     *            true to constrain
     */
    public void setConstrain(boolean constrain) {
        JsoHelper.setAttribute(jsObj, "constrain", constrain);
    }

    /**
     * {@link com.gwtext.client.core.DomHelper} object config to create element
     * with (defaults to {tag: "div", cls: "x-layer"}).
     * 
     * @param domConfig
     *            the dom config
     */
    public void setDomConfig(DomConfig domConfig) {
        JsoHelper.setAttribute(jsObj, "dh", domConfig.getJsObject());
    }

    /**
     * True to create a shadow element with default class "x-layer-shadow".
     * False turns off the shadow.
     * 
     * @param shadow
     *            true to create shadow
     */
    public void setShadow(boolean shadow) {
        JsoHelper.setAttribute(jsObj, "shadow", shadow);
    }

    /**
     * Pass a string with a shadow CSS class name.
     * 
     * @param shadowCls
     *            shadow class
     */
    public void setShadowCls(String shadowCls) {
        JsoHelper.setAttribute(jsObj, "shadow", shadowCls);
    }

    /**
     * Number of pixels to offset the shadow (defaults to 3).
     * 
     * @param shadowOffest
     *            offset in pixels
     */
    public void setShadowOffest(int shadowOffest) {
        JsoHelper.setAttribute(jsObj, "shadowOffest", shadowOffest);
    }

    /**
     * False to disable the iframe shim in browsers which need one (defaults to
     * true).
     * 
     * @param shim
     *            false to disable shim
     */
    public void setShim(boolean shim) {
        JsoHelper.setAttribute(jsObj, "shim", shim);
    }

    /**
     * Starting z-index (defaults to 11000).
     * 
     * @param zindex
     *            the z-index
     */
    public void setZindex(int zindex) {
        JsoHelper.setAttribute(jsObj, "zindex", zindex);
    }
}
