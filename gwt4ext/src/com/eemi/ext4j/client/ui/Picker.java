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
package com.eemi.ext4j.client.ui;

import com.eemi.ext4j.client.events.HandlerRegistration;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayNumber;

/**
 * An abstract class for fields that have a single trigger which opens a
 * "picker" popup below the field, e.g. a combobox menu list or a date picker.
 * It provides a base implementation for toggling the picker's visibility when
 * the trigger is clicked, as well as keyboard navigation and some basic events.
 * Sizing and alignment of the picker can be controlled via the matchFieldWidth
 * and pickerAlign/pickerOffset config properties respectively.
 * 
 * <p>
 * You would not normally use this class directly, but instead use it as the
 * parent class for a specific picker field implementation. Subclasses must
 * implement the createPicker method to create a picker component appropriate
 * for the field.
 * 
 * 
 */
public abstract class Picker extends TriggerField {

    public Picker() {
    }

    public Picker(JavaScriptObject jsObj) {
        super(jsObj);
    }

    /**
     * 
     * Whether the picker dropdown's width should be explicitly set to match the
     * width of the field. Defaults to true.
     * <p>
     * Defaults to: true
     */
    public void setMatchFieldWidth(boolean value) {
        setAttribute("matchFieldWidth", value, true);
    }

    /**
     * 
     A class to be added to the field's bodyEl element when the picker is
     * opened.
     * <p>
     * Defaults to: 'x-pickerfield-open'
     */
    public void setOpenCls(String value) {
        setAttribute("openCls", value, true);
    }

    /**
     * 
     The alignment position with which to align the picker. Defaults to
     * "tl-bl?"
     * <p>
     * Defaults to: 'tl-bl?'
     */
    public void setPickerAlign(String value) {
        setAttribute("pickerAlign", value, true);
    }

    /**
     * 
     An offset [x,y] to use in addition to the pickerAlign when positioning
     * the picker. Defaults to undefined.
     */
    public void setPickerOffset(int offsetX, int offsetY) {
        JsArrayNumber value = JsArrayNumber.createArray().cast();
        value.push(offsetX);
        value.push(offsetY);
        setAttribute("pickerOffset", value, true);
    }

    /**
     * 
     An offset [x,y] to use in addition to the pickerAlign when positioning
     * the picker. Defaults to undefined.
     */
    public void setPickerOffset(int offset) {
        setPickerOffset(offset, offset);
    }

    /**
     * Fires when the field's picker is collapsed.
     */
    public native HandlerRegistration addCollapseHandler(
                    com.eemi.ext4j.client.events.form.PickerCollapseHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(p, e) {
			var picker = @com.eemi.ext4j.client.ui.Picker::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);

			var event = @com.eemi.ext4j.client.events.form.PickerCollapseEvent::new(Lcom/eemi/ext4j/client/ui/Picker;Lcom/google/gwt/core/client/JavaScriptObject;)(picker,e);
			handler.@com.eemi.ext4j.client.events.form.PickerCollapseHandler::onPickerCollapse(Lcom/eemi/ext4j/client/events/form/PickerCollapseEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.form.PickerCollapseEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * Fires when the field's picker is expanded.
     */
    public native HandlerRegistration addExpandHandler(com.eemi.ext4j.client.events.form.PickerExpandHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(p, e) {
			var picker = @com.eemi.ext4j.client.ui.Picker::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);

			var event = @com.eemi.ext4j.client.events.form.PickerExpandEvent::new(Lcom/eemi/ext4j/client/ui/Picker;Lcom/google/gwt/core/client/JavaScriptObject;)(picker,e);
			handler.@com.eemi.ext4j.client.events.form.PickerExpandHandler::onPickerExpand(Lcom/eemi/ext4j/client/events/form/PickerExpandEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.form.PickerExpandEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * Fires when a value is selected via the picker.
     */
    public native HandlerRegistration addFieldSelectHandler(
                    com.eemi.ext4j.client.events.form.FieldSelectHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(p, value, e) {
			var picker = @com.eemi.ext4j.client.ui.Picker::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);

			var event = @com.eemi.ext4j.client.events.form.FieldSelectEvent::new(Lcom/eemi/ext4j/client/field/FieldBase;Ljava/lang/Object;Lcom/google/gwt/core/client/JavaScriptObject;)(picker,value,e);
			handler.@com.eemi.ext4j.client.events.form.FieldSelectHandler::onFieldSelect(Lcom/eemi/ext4j/client/events/form/FieldSelectEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.form.FieldSelectEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;
}
