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
package com.eemi.ext4j.client.tip;

import com.eemi.ext4j.client.core.Component;
import com.eemi.ext4j.client.core.ExtElement;
import com.eemi.ext4j.client.core.config.Attribute;
import com.eemi.ext4j.client.core.config.XType;
import com.eemi.ext4j.client.ui.Panel;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * This is the base class for .ToolTip that provides the basic layout and
 * positioning that all tip-based classes require. This class can be used
 * directly for simple, statically-positioned tips that are displayed
 * programmatically, or it can be extended to provide custom tip
 * implementations.
 * 
 * @author alainekambi
 * 
 */
public class Tip extends Panel {

    private static JavaScriptObject configPrototype;

    protected JavaScriptObject getConfigPrototype() {
        return configPrototype;
    }

    public String getXType() {
        return XType.TIP.getValue();
    }

    public Tip() {

    }

    protected Tip(JavaScriptObject obj) {
        super(obj);
    }

    /**
     * True to render a close tool button into the tooltip header.
     * <p>
     * Defaults to: false
     */
    public void setClosable(boolean value) {
        setAttribute(Attribute.CLOSABLE.getValue(), value, true);

    }

    /**
     * The action to take when the close header tool is clicked
     * <p>
     * Defaults to: "hide"
     */
    public void setCloseAction(String value) {
        setAttribute("closeAction", value, true);
    }

    /**
     * If true, then the tooltip will be automatically constrained to stay
     * within the browser viewport.
     * <p>
     * Defaults to: true
     */
    public void setConstraintPosition(boolean value) {
        setAttribute("constraintPosition", value, true);
    }

    /**
     * Experimental. The default Ext.Element.alignTo anchor position value for
     * this tip relative to its element of origin.
     * <p>
     * Defaults to: "tl-bl?"
     */
    public void setDefaultAlign(String value) {
        setAttribute("constraintPosition", value, true);
    }

    /**
     * True or "sides" for the default effect, "frame" for 4-way shadow, and
     * "drop" for bottom-right shadow.
     * <p>
     * Defaults to: "sides"
     */
    public void setShadow(String value) {
        setAttribute("shadow", value, true);
    }

    /**
     * True the default effect.
     */
    public void setShadow(boolean value) {
        setAttribute("shadow", value, true);
    }

    /**
     * Experimental. Shows this tip at a position relative to another element
     * using a standard Ext.Element.alignTo anchor position value.
     * 
     * @param el
     */
    public native void showBy(String el)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		if (component) {
			component.showBy(el);
		}

    }-*/;

    /**
     * Experimental. Shows this tip at a position relative to another element
     * using a standard Ext.Element.alignTo anchor position value.
     * 
     * @param el
     */
    public native void showBy(ExtElement el)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		if (component) {
			component
					.showBy(el.@com.eemi.ext4j.client.core.JsObject::getJsObj()());
		}

    }-*/;

    public void showBy(Component component) {
        showBy(component.getEl());
    }

    /**
     * Applies the tooltip to the specified target. Note that the element with
     * the specified ID must be rendered to the DOM before this call is made.
     * 
     * @param elementID
     *            the target element ID
     */
    public void setTarget(String elementID) {
        setAttribute("target", elementID, true);
        getOrCreateJsObj();
    }

    public void setTarget(final Component component) {
        setAttribute("target", component.getId(), true);
    }

    /**
     * Creates a new Tip from the given component
     * 
     * @param component
     *            , the component to cast from
     * @return, a new Tip from the component
     * 
     */
    public static Tip cast(Component component) {
        return new Tip(component.getOrCreateJsObj());
    }

}
