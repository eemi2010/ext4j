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

import com.eemi.ext4j.client.core.Component;
import com.eemi.ext4j.client.core.config.Position;
import com.eemi.ext4j.client.core.config.XType;
import com.eemi.ext4j.client.tip.Tip;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayNumber;

/**
 * ToolTip is a{@link Tip} implementation that handles the common case of
 * displaying a tooltip when hovering over a certain element or elements on the
 * page. It allows fine-grained control over the tooltip's alignment relative to
 * the target element or mouse, and the timing of when it is automatically shown
 * and hidden.
 * <p>
 * This implementation does not have a built-in method of automatically
 * populating the tooltip's text based on the target element; you must either
 * configure a fixed html value for each ToolTip instance, or implement custom
 * logic (e.g. in a beforeshow event listener) to generate the appropriate
 * tooltip content on the fly. See Ext.tip.QuickTip for a more convenient way of
 * automatically populating and configuring a tooltip based on specific DOM
 * attributes of each target element.
 * 
 */
public class ToolTip extends Tip {

    private static JavaScriptObject configPrototype;

    protected JavaScriptObject getConfigPrototype() {
        return configPrototype;
    }

    public String getXType() {
        return XType.TOOLTIP.getValue();
    }

    /**
     * Create a new NotificationContainer.
     */
    public ToolTip() {

    }

    public ToolTip(JavaScriptObject jsObj) {
        super(jsObj);
    }

    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.tip.ToolTip(config);
    }-*/;

    /**
     * If specified, indicates that the tip should be anchored to a particular
     * side of the target element or mouse pointer ("top", "right", "bottom", or
     * "left"), with an arrow pointing back at the target or mouse pointer. If
     * constrainPosition is enabled, this will be used as a preferred value only
     * and may be flipped as needed.
     */
    public void setAnchor(String value) {
        setAttribute("anchor", value, true);
    }

    public void setAnchor(Position position) {
        setAnchor(position.getValue());
    }

    /**
     * A numeric pixel value used to offset the default position of the anchor
     * arrow. When the anchor position is on the top or bottom of the tooltip,
     * anchorOffset will be used as a horizontal offset. Likewise, when the
     * anchor position is on the left or right side, anchorOffset will be used
     * as a vertical offset.
     * <p>
     * Defaults to: 0
     */
    public void setAnchorOffset(double value) {
        setAttribute("anchorOffset", value, true);
    }

    /**
     * True to anchor the tooltip to the target element, false to anchor it
     * relative to the mouse coordinates. When anchorToTarget is true, use
     * defaultAlign to control tooltip alignment to the target element. When
     * anchorToTarget is false, use anchor instead to control alignment.
     * <p>
     * Defaults to: true
     */
    public void setAnchorToTarget(boolean value) {
        setAttribute("anchorToTarget", value, true);
    }

    /**
     * True to automatically hide the tooltip after the mouse exits the target
     * element or after the dismissDelay has expired if set. If closable = true
     * a close tool button will be rendered into the tooltip header.
     * <p>
     * Defaults to: true
     */
    public void setAutoHide(boolean value) {
        setAttribute("autoHide", value, true);
    }

    /**
     * A DomQuery selector which allows selection of individual elements within
     * the target element to trigger showing and hiding the ToolTip as the mouse
     * moves within the target.
     * <p>
     * When specified, the child element of the target which caused a show event
     * is placed into the triggerElement property before the ToolTip is shown.
     * <p>
     * This may be useful when a Component has regular, repeating elements in
     * it, each of which need a ToolTip which contains information specific to
     * that element.
     * 
     * See the delegate example in class documentation of Ext.tip.ToolTip.
     */
    public void setDelegate(String value) {
        setAttribute("delegate", value, true);
    }

    /**
     * Delay in milliseconds before the tooltip automatically hides. To disable
     * automatic hiding, set dismissDelay = 0.
     * <p>
     * Defaults to: 5000
     */
    public void setDismissDelay(int value) {
        setAttribute("dismissDelay", value, true);
    }

    /**
     * Delay in milliseconds after the mouse exits the target element but before
     * the tooltip actually hides. Set to 0 for the tooltip to hide immediately.
     * <p>
     * Defaults to: 200
     */
    public void setHideDelay(int value) {
        setAttribute("hideDelay", value, true);
    }

    /**
     * An XY offset from the mouse position where the tooltip should be shown.
     * <p>
     * Defaults to: [15, 18]
     */
    public void setMouseOffset(int offsetX, int offsetY) {
        JsArrayNumber values = JsArray.createArray().cast();
        values.push(offsetX);
        values.push(offsetY);
        setAttribute("hideDelay", values, true);
    }

    /**
     * Delay in milliseconds before the tooltip displays after the mouse enters
     * the target element.
     * <p>
     * Defaults to: 500
     */
    public void setShowDelay(int value) {
        setAttribute("showDelay", value, true);
    }

    /**
     * True to have the tooltip follow the mouse as it moves over the target
     * element.
     * <p>
     * Defaults to: false
     */
    public void setTrackMouse(boolean value) {
        setAttribute("trackMouse", value, true);
    }

    public static ToolTip cast(Component component) {
        return new ToolTip(component.getOrCreateJsObj());
    }

}
