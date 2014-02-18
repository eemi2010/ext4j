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
package com.ati.ext4j.client.layout;

import java.util.List;

import com.ati.ext4j.client.core.Component;
import com.ati.ext4j.client.core.ExtElement;
import com.ati.ext4j.client.core.JsoHelper;
import com.ati.ext4j.client.fx.AnimConfig;
import com.ati.ext4j.client.ui.ComponentFactory;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * Every layout is composed of one or more Ext.Container elements internally,
 * and ContainerLayout provides the basic foundation for all other layout
 * classes in Ext4j. It is a non-visual class that simply provides the base
 * logic required for a Container to function as a layout.
 */
public class ContainerLayout {

    protected JavaScriptObject configJS = JsoHelper.createObject();
    protected JavaScriptObject jsObj;
    private String spacing;

    public JavaScriptObject getJsObj() {
        if (jsObj == null) {
            jsObj = create(configJS);
        }

        return jsObj;
    }

    public ContainerLayout() {
        create();
    }

    public ContainerLayout(JavaScriptObject obj) {
        jsObj = obj;
    }

    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return {};
    }-*/;

    public JavaScriptObject getContainerAttributes() {
        return null;
    }

    public String getSpacing() {
        return spacing;
    }

    public void setSpacing(String spacing) {
        this.spacing = spacing;
    }

    /**
     * An optional extra CSS class that will be added to the container. This can
     * be useful for adding customized styles to the container or any of its
     * children using standard CSS rules. See Ext.Component.ctCls also.
     * 
     * @param itemCls
     */
    public void setItemCls(String itemCls) {
        JsoHelper.setAttribute(this.getJsObj(), "itemCls", itemCls);
    }

    public void setPadding(String value) {
        JsoHelper.setAttribute(this.getJsObj(), "padding", value);
    }

    public void setMargin(String value) {
        JsoHelper.setAttribute(this.getJsObj(), "margin", value);
    }

    public void setAlign(String value) {
        JsoHelper.setAttribute(this.getJsObj(), "align", value);
    }

    /**
     * Specifies the horizontal alignment of child components. Defaults to
     * 'center'. Acceptable values are:
     * <ul>
     * <li>center : Aligned to the center of the container</li>
     * <li>end: Aligned to the right of the container</li>
     * <li>start : Aligned to the left of the container</li>
     * <li>strech Components are streched horizontally to fill the container</li>
     * </ul>
     * 
     * @param align
     *            , the horizontal alignment of the child component
     */
    public void setAlign(Align align) {
        setAlign(align.getValue());
    }

    /**
     * Specifies the vertical alignment of child components. Defaults to
     * 'start'. Acceptable values are:
     * <ul>
     * <li>center: Aligned to the center of the container</li>
     * <li>end: Aligned to the bottom of the container</li>
     * <li>justify: Justified with both top and bottom of the container</li>
     * <li>start: Aligned to the top of the container.</li>
     * </ul>
     * 
     * @param pack
     *            , the horizontal alignment of the child component
     */
    public void setPack(Pack pack) {
        setPack(pack.getValue());
    }

    private void setPack(String pack) {
        JsoHelper.setAttribute(this.getJsObj(), "pack", pack);
    }

    /**
     * One of the following value :
     * <ul>
     * <li>0 if the layout should ignore overflow.</li>
     * <li>1 if the layout should be rerun if scrollbars are needed.</li>
     * <li>2 if the layout should also correct padding when overflowed.</li>
     * </ul>
     * 
     */
    public void setManageOverflow(boolean value) {
        JsoHelper.setAttribute(this.getJsObj(), "manageOverFlow", value);
    }

    /**
     * Set to true to leave space for a vertical scrollbar (if the OS shows
     * space-consuming scrollbars) regardless of whether a scrollbar is needed.
     * 
     * This is useful if content height changes during application usage, but
     * you do not want the calculated width of child items to change when a
     * scrollbar appears or disappears. The scrollbar will appear in the
     * reserved space, and the calculated width of child Components will not
     * change.
     * 
     */
    public void setReserveScrollbar(boolean value) {
        JsoHelper.setAttribute(this.getJsObj(), "reserveScrollbar", value);
    }

    public void setAnimate(boolean value) {
        JsoHelper.setAttribute(this.getJsObj(), "animate", value);
    }

    public void setPadding(double value) {
        JsoHelper.setAttribute(this.getJsObj(), "padding", value);
    }

    public void setAnimate(AnimConfig value) {
        JsoHelper.setAttribute(this.getJsObj(), "animate", value.getJsObj());
    }

    /**
     * Returns the element into which extra functional DOM elements can be
     * inserted. Defaults to the owner Component's encapsulating element.
     * 
     * May be overridden in Component layout managers which implement a
     * component render target which must only contain child components.
     * 
     * @return
     */
    public native ExtElement getElementTarget() /*-{
		var layout = this.@com.ati.ext4j.client.layout.ContainerLayout::jsObj;
		var obj = layout.getElementTarget();
		return @com.ati.ext4j.client.core.ExtElement::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
    }-*/;

    /**
     * Returns the owner component's resize element.
     * 
     * @return
     */
    public native ExtElement getTarget() /*-{
		var layout = this.@com.ati.ext4j.client.layout.ContainerLayout::jsObj;
		var obj = layout.getTarget();
		return @com.ati.ext4j.client.core.ExtElement::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
    }-*/;

    /**
     * Returns the element into which rendering must take place. Defaults to the
     * owner Container's target element.
     * 
     * May be overridden in layout managers which implement an inner element.
     * 
     * @return
     */
    public native ExtElement getRenderTarget() /*-{
		var layout = this.@com.ati.ext4j.client.layout.ContainerLayout::jsObj;
		var obj = layout.getRenderTarget();
		return @com.ati.ext4j.client.core.ExtElement::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
    }-*/;

    /**
     * Returns an array of child components either for a render phase (Performed
     * in the beforeLayout method of the layout's base class), or the layout
     * phase (onLayout).
     * 
     * @return
     */
    public List<Component> getLayoutItems() {
        return ComponentFactory.fromJsArray(_getLayoutItems());
    }

    private native JavaScriptObject _getLayoutItems() /*-{
		var layout = this.@com.ati.ext4j.client.layout.ContainerLayout::jsObj;
		layout.getLayoutItems();
    }-*/;

    public void update(JavaScriptObject obj) {
        jsObj = obj;
    }

    protected native void create() /*-{
		var jso = {};
		this.@com.ati.ext4j.client.layout.ContainerLayout::jsObj = jso;
    }-*/;

}
