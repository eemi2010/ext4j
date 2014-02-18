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
package com.ati.ext4j.client.resizer;

import com.ati.ext4j.client.core.Component;
import com.ati.ext4j.client.core.ExtElement;
import com.ati.ext4j.client.core.JsoHelper;
import com.ati.ext4j.client.core.config.BaseConfig;

/**
 * Config Object for a Resizer
 * 
 * @author alainekambi
 * 
 */
public class ResizerConfig extends BaseConfig {

    public ResizerConfig() {
        jsObj = JsoHelper.createObject();
    }

    /**
     * An element, into which the resize operation must be constrained.
     * 
     * @param element
     */
    public void setContrainTo(ExtElement element) {
        JsoHelper.setAttribute(jsObj, "constrainTo", element.getJsObj());
    }

    /**
     * Specify as true to update the target (Element or Component) dynamically
     * during dragging. This is true by default, but the Component class passes
     * false when it is configured as Ext.Component.resizable.
     * <p>
     * If specified as false, a proxy element is displayed during the resize
     * operation, and the target is updated on mouseup.
     * <p>
     * Defaults to: true
     */
    public void setDynamic(boolean value) {
        JsoHelper.setAttribute(jsObj, "dynamic", value);
    }

    /**
     * String consisting of the resize handles to display. Defaults to 's e se'
     * for Elements and fixed position Components. Defaults to 8 point resizing
     * for floating Components (such as Windows). Specify either 'all' or any of
     * 'n s e w ne nw se sw'.
     * <p>
     * Defaults to: "s e se"
     */
    public void setHandles(String value) {
        JsoHelper.setAttribute(jsObj, "handles", value);
    }

    /**
     * Optional. The height to set target to in pixels
     * <p>
     * Defaults to: null
     */
    public void setHeight(double value) {
        JsoHelper.setAttribute(jsObj, "height", value);
    }

    /**
     * The increment to snap the height resize in pixels.
     * <p>
     * Defaults to: 0
     */
    public void setHeightIncrement(double value) {
        JsoHelper.setAttribute(jsObj, "heightIncrement", value);
    }

    /**
     * The maximum height for the element
     * <p>
     * Defaults to: 10000
     */
    public void setMaxHeight(double value) {
        JsoHelper.setAttribute(jsObj, "maxHeight", value);
    }

    /**
     * The maximum width for the element
     * <p>
     * Defaults to: 10000
     */
    public void setMaxWidth(double value) {
        JsoHelper.setAttribute(jsObj, "maxWidth", value);
    }

    /**
     * The minimum height for the element
     * <p>
     * Defaults to: 20
     */
    public void setMinHeight(double value) {
        JsoHelper.setAttribute(jsObj, "minHeight", value);
    }

    /**
     * The minimum width for the element
     * <p>
     * Defaults to: 20
     */
    public void setMinWidth(double value) {
        JsoHelper.setAttribute(jsObj, "minWidth", value);
    }

    /**
     * True to ensure that the resize handles are always visible, false
     * indicates resizing by cursor changes only
     * <p>
     * Defaults to: false
     */
    public void setPinned(boolean value) {
        JsoHelper.setAttribute(jsObj, "pinned", value);
    }

    /**
     * True to preserve the original ratio between height and width during
     * resize
     * <p>
     * Defaults to: false
     */
    public void setPreserveRation(boolean value) {
        JsoHelper.setAttribute(jsObj, "preserveRatio", value);
    }

    /**
     * The Element to resize.
     */
    public void setTarget(ExtElement el) {
        JsoHelper.setAttribute(jsObj, "target", el.getJsObj());
    }

    /**
     * The Element to resize.
     */
    public void setTarget(String elementId) {
        JsoHelper.setAttribute(jsObj, "target", elementId);
    }

    /**
     * The Component to resize.
     */
    public void setTarget(Component el) {
        JsoHelper.setAttribute(jsObj, "target", el.getOrCreateJsObj());
    }

    /**
     * True for transparent handles. This is only applied at config time.
     * <p>
     * Defaults to: false
     */
    public void setTransparent(boolean value) {
        JsoHelper.setAttribute(jsObj, "transparent", value);
    }

    /**
     * Optional. The width to set the target to in pixels
     * <p>
     * Defaults to: null
     */
    public void setWidth(double value) {
        JsoHelper.setAttribute(jsObj, "width", value);
    }

    /**
     * The increment to snap the width resize in pixels.
     * <p>
     * Defaults to: 0
     */
    public void setWidthIncrement(double value) {
        JsoHelper.setAttribute(jsObj, "widthIncrement", value);
    }
}
