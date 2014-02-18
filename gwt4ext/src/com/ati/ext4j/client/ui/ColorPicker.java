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
package com.ati.ext4j.client.ui;

import com.ati.ext4j.client.core.Component;
import com.ati.ext4j.client.core.config.XType;
import com.ati.ext4j.client.events.HandlerRegistration;
import com.ati.ext4j.client.events.colorpicker.SelectHandler;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;

/**
 * A specialized SplitButton that contains a menu of CheckItem elements. The
 * button automatically cycles through each menu item on click, raising the
 * button's change event (or calling the button's changeHandler function, if
 * supplied) for the active menu item. Clicking on the arrow section of the
 * button displays the dropdown menu just like a normal SplitButton
 * 
 */
public class ColorPicker extends Component {

    private static JavaScriptObject configPrototype;

    private native void init()/*-{
		var c = new $wnd.Ext.picker.Color();
		@com.ati.ext4j.client.ui.ColorPicker::configPrototype = c.initialConfig;
    }-*/;

    public ColorPicker() {
        // init();
    }

    protected ColorPicker(JavaScriptObject obj) {
        super(obj);
    }

    protected JavaScriptObject getConfigPrototype() {
        return configPrototype;
    }

    public String getXType() {
        return XType.COLOR_PICKER.getValue();
    }

    @Override
    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.picker.Color(config);
    }-*/;

    /**
     * 
     * If set to true then reselecting a color that is already selected fires
     * the select event
     * <p>
     * Defaults to: false
     */
    public void setAllowReselect(boolean value) {
        setAttribute("allowReselect", value, true);
    }

    /**
     * 
     * The DOM event that will cause a color to be selected. This can be any
     * valid event name (dblclick, contextmenu).
     * <p>
     * Defaults to: "click"
     */
    public void setClickEvent(String value) {
        setAttribute("clickEvent", value, true);
    }

    /**
     * 
     * The CSS class to apply to the selected element
     * <p>
     * Defaults to: "x-color-picker-selected"
     */
    public void setSelectedCls(String value) {
        setAttribute("selectedCls", value, true);
    }

    /**
     * The initial color to highlight (should be a valid 6-digit color hex code
     * without the # symbol). Note that the hex codes are case-sensitive.
     * <p>
     * Defaults to: null
     */
    public void setValue(String value) {
        setAttribute("value", value, true);
    }

    /**
     * An array of 6-digit color hex code strings (without the # symbol). This
     * array can contain any number of colors, and each hex code should be
     * unique. The width of the picker is controlled via CSS by adjusting the
     * width property of the 'x-color-picker' class (or assigning a custom
     * class), so you can balance the number of colors with the width setting
     * until the box is symmetrical.
     */
    public native JsArrayString getColors()/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		if (component) {
			return components.colors;
		}
    }-*/;

    /**
     * An array of 6-digit color hex code strings (without the # symbol). This
     * array can contain any number of colors, and each hex code should be
     * unique. The width of the picker is controlled via CSS by adjusting the
     * width property of the 'x-color-picker' class (or assigning a custom
     * class), so you can balance the number of colors with the width setting
     * until the box is symmetrical.
     */
    public native void setColors(JsArrayString values)/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		if (component) {
			components.colors = values;
		}
    }-*/;

    /**
     * Selects the specified color in the picker
     * 
     * @param value
     */
    public native void select(String value)/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		if (component) {
			components.select(value);
		}
    }-*/;

    /**
     * Selects the specified color in the picker (fires the select event)
     * 
     * @param value
     * @param suppressEvent
     */
    public native void select(String value, boolean suppressEvent)/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		if (component) {
			components.select(value, supressEvent);
		}
    }-*/;

    /**
     * Fires when a color is selected
     * 
     * @param handler
     *            , the handler that will handle the event
     */
    public native HandlerRegistration addSelectHandler(SelectHandler handler)/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(cmp, color, e) {
			var picker = @com.ati.ext4j.client.ui.ColorPicker::new(Lcom/google/gwt/core/client/JavaScriptObject;)(cmp);
			var event = @com.ati.ext4j.client.events.colorpicker.SelectEvent::new(Lcom/ati/ext4j/client/ui/ColorPicker;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(picker,color,e);
			handler.@com.ati.ext4j.client.events.colorpicker.SelectHandler::onSelect(Lcom/ati/ext4j/client/events/colorpicker/SelectEvent;)(event);
		};
		var eventName = @com.ati.ext4j.client.events.colorpicker.SelectEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ati.ext4j.client.events.HandlerRegistration::new(Lcom/ati/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * Creates a new ColorPicker from the given component
     * 
     * @param component
     *            , the component to cast from
     * @return, a new ColorPicker from the component
     * 
     */
    public static ColorPicker cast(Component component) {
        return new ColorPicker(component.getOrCreateJsObj());
    }

}
