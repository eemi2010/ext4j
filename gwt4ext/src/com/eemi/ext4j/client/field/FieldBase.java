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
package com.eemi.ext4j.client.field;

import com.eemi.ext4j.client.core.Component;
import com.eemi.ext4j.client.core.ExtElement;
import com.eemi.ext4j.client.core.Template;
import com.eemi.ext4j.client.core.config.XType;
import com.eemi.ext4j.client.events.HandlerRegistration;
import com.eemi.ext4j.client.events.form.ChangeHandler;
import com.eemi.ext4j.client.events.form.DirtyChangeHandler;
import com.eemi.ext4j.client.events.form.SpecialKeyHandler;
import com.eemi.ext4j.client.events.form.ValidityChangeHandler;
import com.eemi.ext4j.client.events.form.WritableChangeHandler;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;

/**
 * Base class for form fields that provides default event handling, rendering,
 * and other common functionality needed by all form field types
 * 
 */
public class FieldBase extends Field {

    private static JavaScriptObject configPrototype;

    protected JavaScriptObject getConfigPrototype() {
        return configPrototype;
    }

    public String getXType() {
        return XType.FIELD.getValue();
    }

    /**
     * Create a new FieldBase.
     */
    protected FieldBase() {
    }

    protected FieldBase(JavaScriptObject obj) {
        super(obj);
    }

    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.form.field.Base(config);
    }-*/;

    /**
     * Creates a new TabBar from the given component
     * 
     * @param component
     *            , the component to cast from
     * @return, a new TabBar from the component
     * 
     */
    public static FieldBase cast(Component component) {
        return new FieldBase(component.getOrCreateJsObj());
    }

    /**
     * 
     * The base CSS class to apply to this component's element. This will also
     * be prepended to elements within this component like
     * NotificationContainer's body will get a class x-panel-body. This means
     * that if you create a subclass of NotificationContainer, and you want it
     * to get all the Panels styling for the element and the body, you leave the
     * baseCls x-panel and use componentCls to add specific styling for this
     * component.
     * <p>
     * Defaults to: Ext.baseCSSPrefix + 'field'
     */
    public void setBaseCls(String value) {
        setAttribute("baseCls", value, true);
    }

    /**
     * 
     Defines a timeout in milliseconds for buffering checkChangeEvents that
     * fire in rapid succession. Defaults to 50 milliseconds.
     * <p>
     * Defaults to: 50
     */
    public void setCheckChangeBuffer(double value) {
        setAttribute("checkChangeBuffer", value, true);
    }

    /**
     * 
     Defines a timeout in milliseconds for buffering checkChangeEvents that
     * fire in rapid succession. Defaults to 50 milliseconds.
     * <p>
     * Defaults to: 50
     */
    public void setCheckChangeEvents(JsArrayString values) {
        setAttribute("checkChangeEvents", values, true);
    }

    /**
     * 
     The CSS class to use when the field value is dirty.
     * <p>
     * Defaults to: Ext.baseCSSPrefix + 'form-dirty'
     */
    public void setDirtyCls(String value) {
        setAttribute("dirtyCls", value, true);
    }

    /**
     * Optional CSS style(s) to be applied to the field input element. Should be
     * a valid argument to Ext.Element.applyStyles. Defaults to undefined. See
     * also the setFieldStyle method for changing the style after
     * initialization.
     */
    public void setFieldStyle(String value) {
        setAttribute("fieldStyle", value, true);
    }

    /**
     * 
     The default CSS class for the field input
     * <p>
     * Defaults to: 'x-form-field'
     */
    public void setFieldCls(String value) {
        setAttribute("fieldCls", value, true);
    }

    /**
     * The CSS class to use when the field receives focus
     * <p>
     * Defaults to: 'x-form-focus'
     */
    public void setFocusCls(String value) {
        setAttribute("focusCls", value, true);
    }

    /**
     * An optional string or XTemplate configuration to insert in the field
     * markup inside the input element (as attributes). If an XTemplate is used,
     * the component's subTpl data serves as the context.
     */
    public void setInputAttrTpl(String value) {
        setAttribute("inputAttrTpl", value, true);
    }

    /**
     * An optional string or XTemplate configuration to insert in the field
     * markup inside the input element (as attributes). If an XTemplate is used,
     * the component's subTpl data serves as the context.
     */
    public void setInputAttrTpl(JsArrayString value) {
        setAttribute("inputAttrTpl", value, true);
    }

    /**
     * An optional string or XTemplate configuration to insert in the field
     * markup inside the input element (as attributes). If an XTemplate is used,
     * the component's subTpl data serves as the context.
     */
    public void setInputAttrTpl(Template value) {
        setAttribute("inputAttrTpl", value.getJsObj(), true);
    }

    /**
     * The id that will be given to the generated input DOM element. Defaults to
     * an automatically generated id. If you configure this manually, you must
     * make sure it is unique in the document.
     */
    public void setInputId(String value) {
        setAttribute("inputId", value, true);
    }

    /**
     * The type attribute for input fields -- e.g. radio, text, password, file.
     * The extended types supported by HTML5 inputs (url, email, etc.) may also
     * be used, though using them will cause older browsers to fall back to
     * 'text'.
     * <p>
     * The type 'password' must be used to render that field type currently --
     * there is no separate Ext component for that. You can use
     * Ext.form.field.File which creates a custom-rendered file upload field,
     * but if you want a plain unstyled file input you can use a Base with
     * inputType:'file'.
     * <p>
     * Defaults to: 'text'
     */
    public void setInputType(String value) {
        setAttribute("inputType", value, true);
    }

    /**
     * The error text to use when marking a field invalid and no message is
     * provided
     * <p>
     * Defaults to: 'The value in this field is invalid'
     */
    public void setInvalidText(String value) {
        setAttribute("invalidText", value, true);
    }

    /**
     * true to mark the field as readOnly in HTML.
     * <p>
     * <b>Note</b>: this only sets the element's readOnly DOM attribute. Setting
     * readOnly=true, for example, will not disable triggering a ComboBox or
     * Date; it gives you the option of forcing the user to choose via the
     * trigger without typing in the text box. To hide the trigger use
     * hideTrigger.
     * <p>
     * Defaults to: false
     */
    public void setReadOnly(boolean value) {
        setAttribute("readOnly", value, true);
    }

    /**
     * The CSS class applied to the component's main element when it is
     * readOnly.
     * 
     * Defaults to: Ext.baseCSSPrefix + 'form-readonly'
     */
    public void setReadOnlyCls(String value) {
        setAttribute("readOnlyCls", value, true);
    }

    /**
     * The tabIndex for this field. Note this only applies to fields that are
     * rendered, not those which are built via applyTo
     */
    public void setTabIndex(int value) {
        setAttribute("tabIndex", value, true);
    }

    /**
     * The input Element for this Field. Only available after the field has been
     * rendered.
     */
    public native ExtElement getInputElement()/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var obj = component.inputElement;
		return @com.eemi.ext4j.client.core.ExtElement::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
    }-*/;

    /**
     * The input Element for this Field. Only available after the field has been
     * rendered.
     * <p>
     * Available since: Ext 4
     */
    public void setValidateOnBlur(boolean value) {
        setAttribute("validateOnBlur", value, true);
    }

    /**
     * Returns the input id for this field. If none was specified via the
     * inputId config, then an id will be automatically generated.
     */
    public native String getInputId()/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		return component.getInputId();
    }-*/;

    /**
     * Returns the raw value of the field, without performing any normalization,
     * conversion, or validation.
     */
    public native String getRawValue()/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		return component.getRawValue();
    }-*/;

    /**
     * Fires when any key related to navigation (arrows, tab, enter, esc, etc.)
     * is pressed. To handle other keys see Ext.util.KeyMap. You can check
     * Ext.EventObject.getKey to determine which key was pressed.
     * 
     * @param handler
     *            , the handler that will handle the event
     */

    public native HandlerRegistration addSpecialKeyHandler(SpecialKeyHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(f, e) {
			var field = @com.eemi.ext4j.client.field.FieldBase::new(Lcom/google/gwt/core/client/JavaScriptObject;)(f);
			var event = @com.eemi.ext4j.client.events.form.SpecialKeyEvent::new(Lcom/eemi/ext4j/client/field/FieldBase;Lcom/google/gwt/core/client/JavaScriptObject;)(field,e);
			handler.@com.eemi.ext4j.client.events.form.SpecialKeyHandler::onSpecialKey(Lcom/eemi/ext4j/client/events/form/SpecialKeyEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.form.SpecialKeyEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * Fires when this field changes its read-only status.
     * 
     * @param handler
     *            , the handler that will handle the event
     */
    public native HandlerRegistration addWritableChangeHandler(WritableChangeHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(f, read, e) {
			var field = @com.eemi.ext4j.client.field.FieldBase::new(Lcom/google/gwt/core/client/JavaScriptObject;)(f);
			var event = @com.eemi.ext4j.client.events.form.WritableChangeEvent::new(Lcom/eemi/ext4j/client/field/FieldBase;ZLcom/google/gwt/core/client/JavaScriptObject;)(field, read, e);
			handler.@com.eemi.ext4j.client.events.form.WritableChangeHandler::onWritableChange(Lcom/eemi/ext4j/client/events/form/WritableChangeEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.form.WritableChangeEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * Fires when the value of a field is changed via the setValue method.
     * 
     * @param handler
     *            , the handler that will handle the event
     */
    public native HandlerRegistration addChangeHandler(ChangeHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(f, newValue, oldValue, e) {
			var nV = '', oV = '';
			if (newValue) {
				nV = newValue.toString();
			}
			if (oldValue) {
				oV = oldValue.toString();
			}
			var field = @com.eemi.ext4j.client.field.FieldBase::new(Lcom/google/gwt/core/client/JavaScriptObject;)(f);
			var event = @com.eemi.ext4j.client.events.form.ChangeEvent::new(Lcom/eemi/ext4j/client/field/FieldBase;Ljava/lang/String;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(field,nV,oV,e);
			handler.@com.eemi.ext4j.client.events.form.ChangeHandler::onChange(Lcom/eemi/ext4j/client/events/form/ChangeEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.form.ChangeEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * Fires when a change in the field's isDirty state is detected.
     * 
     * @param handler
     *            , the handler that will handle the event
     */
    public native HandlerRegistration addDirtyChangeHandler(DirtyChangeHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(f, isDirty, e) {
			var field = @com.eemi.ext4j.client.field.FieldBase::new(Lcom/google/gwt/core/client/JavaScriptObject;)(f);
			var event = @com.eemi.ext4j.client.events.form.DirtyChangeEvent::new(Lcom/eemi/ext4j/client/field/FieldBase;ZLcom/google/gwt/core/client/JavaScriptObject;)(field,isDirty,e);
			handler.@com.eemi.ext4j.client.events.form.DirtyChangeHandler::onDirtyChange(Lcom/eemi/ext4j/client/events/form/DirtyChangeEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.form.DirtyChangeEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * Fires when a change in the field's validity is detected.
     * 
     * @param handler
     *            , the handler that will handle the event
     */
    public native HandlerRegistration addValidityChangeHandler(ValidityChangeHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(f, isValid, e) {
			var field = @com.eemi.ext4j.client.field.FieldBase::new(Lcom/google/gwt/core/client/JavaScriptObject;)(f);
			var event = @com.eemi.ext4j.client.events.form.ValidityChangeEvent::new(Lcom/eemi/ext4j/client/field/FieldBase;ZLcom/google/gwt/core/client/JavaScriptObject;)(field,isValid,e);
			handler.@com.eemi.ext4j.client.events.form.ValidityChangeHandler::onValidityChange(Lcom/eemi/ext4j/client/events/form/ValidityChangeEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.form.ValidityChangeEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

}
