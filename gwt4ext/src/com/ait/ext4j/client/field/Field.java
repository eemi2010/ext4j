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
package com.ait.ext4j.client.field;

import com.ait.ext4j.client.core.DomConfig;
import com.ait.ext4j.client.core.ExtElement;
import com.ait.ext4j.client.data.BaseModel;
import com.ait.ext4j.client.ui.BoxComponent;
import com.ait.ext4j.client.ui.TextField;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.DOM;

/**
 * Base class for form fields that provides default event handling, sizing,
 * value handling and other functionality.
 */
public abstract class Field extends BoxComponent {

    public Field() {

    }

    public Field(JavaScriptObject jsObj) {
        super(jsObj);
    }

    /**
     * Set the location of the error message target globally.
     * 
     * @param msgTarget
     *            supported values are 'qtip' (default) and 'side'
     */
    public static native void setMessageTarget(String msgTarget) /*-{
		$wnd.Ext.form.Field.prototype.msgTarget = msgTarget;
    }-*/;

    protected abstract JavaScriptObject create(JavaScriptObject config);

    /**
     * Apply the behaviors of this component to an existing element. This is
     * used instead of render().
     * 
     * @param id
     *            the ID of the node
     */
    public void applyTo(String id) {
        Element el = DOM.getElementById(id);
        if (el == null) {
            throw new IllegalArgumentException("Element with id : " + id + " not found.");
            // RootPanel.get().add(new HTML("<div id='" + id + "'></div"));
        }
        applyTo(getOrCreateJsObj(), id);
    }

    public void setMsgTarget(String value) {
        this.setAttribute("msgTarget", value, true);
    }

    /**
     * Apply the behaviors of this component to an existing element. This is
     * used instead of render().
     * 
     * @param element
     *            the element
     */
    public native void applyTo(Element element) /*-{
		var field = this.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()();
		field.applyTo(element);
    }-*/;

    private native void applyTo(JavaScriptObject field, String id) /*-{
		field.applyTo(id);
    }-*/;

    /**
     * Clear any invalid styles/messages for this field.
     */
    public native void clearInvalid() /*-{
		var field = this.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()();
		field.clearInvalid();
    }-*/;

    /**
     * Returns the raw data value which may or may not be a valid, defined
     * value.
     * 
     * @return the raw field value
     */
    public native String getRawValue() /*-{
		var field = this.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()();
		return field.getRawValue();
    }-*/;

    /**
     * Return the value of the field as a String.
     * 
     * @return value as String
     */
    public native String getValueAsString() /*-{
		var field = this.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()();
		var value = field.getValue();
		return (value == null || value === undefined) ? '' : value.toString();
    }-*/;

    /**
     * Returns true if this field has been changed since it was originally
     * loaded and is not disabled.
     * 
     * @return true if field changed
     */
    public native boolean isDirty() /*-{
		var field = this.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()();
		return field.isDirty();
    }-*/;

    /**
     * Returns whether two field values are logically equal. Field
     * implementations may override this to provide custom comparison logic
     * appropriate for the particular field's data type.
     * <p>
     */
    public native boolean isEqual(Object value1, Object value2) /*-{
		var field = this.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()();
		return field.isEqual(value1, value2);
    }-*/;

    /**
     * Returns whether this Field is a file upload field; if it returns true,
     * forms will use special techniques for submitting the form via AJAX.
     */
    public native boolean isFileUpload() /*-{
		var field = this.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()();
		return field.isFileUpload();
    }-*/;

    /**
     * Checks whether the value of the field has changed since the last time it
     * was checked.
     * <p>
     * 
     * @return true if field changed
     */
    public native void checkChange() /*-{
		var field = this.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()();
		field.checkChange();
    }-*/;

    /**
     * Checks the isDirty state of the field and if it has changed since the
     * last time it was checked, fires the dirtychange event.
     */
    public native void checkDirty() /*-{
		var field = this.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()();
		field.checkDirty();
    }-*/;

    /**
     * Checks the isDirty state of the field and if it has changed since the
     * last time it was checked, fires the dirtychange event.
     */
    public native JsArrayString getErrors() /*-{
		var field = this.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()();
		return field.getErrors();
    }-*/;

    /**
     * Returns the name attribute of the field. This is used as the parameter
     * name when including the field value in a form submit().
     */
    public native String getName() /*-{
		var field = this.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()();
		return field.getErrors();
    }-*/;

    /**
     * Checks the isDirty state of the field and if it has changed since the
     * last time it was checked, fires the dirtychange event.
     */
    public native BaseModel getModelData() /*-{
		var field = this.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()();
		var obj = field.getModelData();
		return @com.ait.ext4j.client.data.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
    }-*/;

    /**
     * Checks the isDirty state of the field and if it has changed since the
     * last time it was checked, fires the dirtychange event.
     */
    public native JavaScriptObject getSubmitData() /*-{
		var field = this.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()();
		return field.getSubmitData();
    }-*/;

    /**
     * Returns whether or not the field value is currently valid.
     * 
     * @return true if valid
     */
    public native boolean isValid() /*-{
		var field = this.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()();
		return field.isValid();
    }-*/;

    /**
     * Returns whether or not the field value is currently valid.
     * 
     * @param preventMark
     *            true to disable marking the field invalid
     * @return true if valid
     */
    public native boolean isValid(boolean preventMark) /*-{
		var field = this.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()();
		return field.isValid(preventMark);
    }-*/;

    /**
     * Mark this field as invalid.
     * 
     * @param message
     *            the validation message
     */
    public native void markInvalid(String message) /*-{
		var field = this.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()();
		field.markInvalid(message);
    }-*/;

    /**
     * Resets the current field value to the originally loaded value and clears
     * any validation messages.
     */
    public native void reset() /*-{
		var field = this.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()();
		field.reset();
    }-*/;

    /**
     * Sets the underlying DOM field's value directly, bypassing validation. To
     * set the value with validation use {@link #setValue(String)}.
     * 
     * @param value
     *            field value
     */
    public native void setRawValue(String value) /*-{
		var field = this.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()();
		field.setRawValue(value);
    }-*/;

    /**
     * Resets the field's originalValue property so it matches the current
     * value. This is called by Ext.form.Basic.setValues if the form's
     * trackResetOnLoad property is set to true.
     */
    public native void resetOriginalValue() /*-{
		var field = this.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()();
		field.resetOriginalValue();
    }-*/;

    /**
     * Sets a data value into the field and validates it. To set the value
     * directly without validation see {@link #setRawValue(String)}.
     * 
     * @param value
     *            the field value
     */
    private native void setValueRendered(String value) /*-{
		var field = this.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()();
		field.setValue(value);
    }-*/;

    /**
     * Returns whether or not the field value is currently valid by validating
     * the field's current value, and fires the validitychange event if the
     * field's validity has changed since the last validation. Note: disabled
     * fields are always treated as valid.
     * <p>
     * Custom implementations of this method are allowed to have side-effects
     * such as triggering error message display. To validate without
     * side-effects, use isValid.
     * 
     * 
     * @return
     */
    public native boolean validate() /*-{
		var field = this.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()();
		return field.validate();
    }-*/;

    // --- config properties ---

    public String getXType() {
        return "field";
    }

    /**
     * Set to true for a default element spec (defaults to {tag: "input", type:
     * "text", size: "20", autocomplete: "off"})
     * 
     * @param autoCreate
     *            true for a default element spec
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setAutoCreate(boolean autoCreate) throws IllegalStateException {
        setAttribute("autoCreate", autoCreate, true);
    }

    public boolean isAutoCreate() {
        return getAttributeAsBoolean("autoCreate");
    }

    /**
     * A DomHelper config spec to use for field creation.
     * 
     * @param domConfig
     *            a DomHelper config spec to use for field creation
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setAutoCreate(DomConfig domConfig) throws IllegalStateException {
        setAttribute("autoCreate", domConfig.getJsObject(), true);
    }

    /**
     * The CSS class used to provide field clearing (defaults to
     * 'x-form-clear-left')
     * 
     * @param clearCls
     *            the CSS class used to provide the clearing
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setClearCls(String clearCls) throws IllegalStateException {
        setAttribute("clearCls", clearCls, true);
    }

    /**
     * The CSS class used to provide field clearing (defaults to
     * 'x-form-clear-left')
     * 
     * @return the clear Class
     */
    public String getClearCls() {
        return getAttribute("clearCls");
    }

    /**
     * A CSS class to apply to the field's underlying element.
     * 
     * @param cls
     *            the CSS class
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setCls(String cls) throws IllegalStateException {
        super.setCls(cls);
    }

    /**
     * CSS class to apply to the field's underlying element
     * 
     * @return the CSS class
     */
    public String getCls() {
        return getAttribute("cls");
    }

    /**
     * True to disable the field (defaults to false).
     * 
     * @param disabled
     *            true to disable
     */
    public void setDisabled(boolean disabled) {
        if (!isRendered()) {
            setAttribute("disabled", disabled, true, true);
        } else {
            super.setDisabled(disabled);
        }
    }

    /**
     * The default CSS class for the field (defaults to "x-form-field").
     * 
     * @param fieldClass
     *            the fields class
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setFieldClass(String fieldClass) throws IllegalStateException {
        setAttribute("fieldClass", fieldClass, true);
    }

    /**
     * The CSS class to use when the field receives focus (defaults to
     * "x-form-focus").
     * 
     * @param focusClass
     *            CSS class on focus
     */
    public void setFocusClass(String focusClass) {
        setAttribute("focusClass", focusClass, true, true);
    }

    /**
     * Specifies whether this field should be validated immediately whenever a
     * change in its value is detected. If the validation results in a change in
     * the field's validity, a validitychange event will be fired. This allows
     * the field to show feedback about the validity of its contents immediately
     * as the user is typing.
     * 
     * @param value
     */
    public void setValidateOnChange(boolean value) {
        setAttribute("validateOnChange", value, true, true);
    }

    /**
     * The CSS class to use when the field receives focus (defaults to
     * "x-form-focus").
     * 
     * @return the focus class
     */
    public String getFocusClass() {
        return getAttribute("focusClass");
    }

    /**
     * Set the fields label. Alias for {@link #setFieldLabel(String)}
     * 
     * @param fieldLabel
     *            the field label
     */
    public void setLabel(String fieldLabel) {
        setFieldLabel(fieldLabel);
    }

    // TODO
    // LabelAttrTpl
    /**
     * Controls the position and alignment of the fieldLabel
     */
    public void setLabelAlign(LabelAlign labelAlign) {
        setAttribute("labelAlign", labelAlign.getValue(), true, true);
    }

    /**
     * Controls the position and alignment of the fieldLabel
     */
    public void setLabelAlign(String labelAlign) {
        setAttribute("labelAlign", labelAlign, true, true);
    }

    /**
     * Set the fields label.
     * 
     * @param fieldLabel
     *            the field label
     */
    public void setFieldLabel(String fieldLabel) {
        setAttribute("fieldLabel", fieldLabel, true, true);
        if (isRendered()) {
            setFieldLabelRendered(fieldLabel, getId());
        }
    }

    /**
     * The field label.
     * 
     * @return the field label
     */
    public String getFieldLabel() {
        return getAttribute("fieldLabel");
    }

    private native void setFieldLabelRendered(String fieldLabel, String fieldId) /*-{
		var field = this.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()();
		var label = $wnd.Ext.DomQuery.select($wnd.String.format(
				'label[for="{0}"]', fieldId));
		if (label) {
			//todo preserve user specified labelSeparator and only update the label text.
			//var separator = typeof field.container.labelSeparator == 'undefined' ? field.labelSeparator : field.container.labelSeparator;
			label[0].childNodes[0].nodeValue = fieldLabel;
		}
    }-*/;

    public void hide() {
        super.hide();
        if (!isRendered() && !this.isHidden()) {
            Scheduler.get().scheduleDeferred(new ScheduledCommand() {
                @Override
                public void execute() {
                    hide();
                }
            });
        } else if (isRendered()) {
            ExtElement elem = getEl().up(".x-form-item");
            if (elem != null)
                elem.setDisplayed(false);
        }
    }

    public void show() {
        super.show();
        if (!isRendered()) {
            Scheduler.get().scheduleDeferred(new ScheduledCommand() {
                @Override
                public void execute() {
                    show();
                }
            });
        } else {
            ExtElement elem = getEl().up(".x-form-item");
            if (elem != null)
                elem.setDisplayed(true);
        }
    }

    /**
     * True to completely hide the label element (defaults to false).
     * 
     * @param hideLabel
     *            true to completely hide the label element (defaults to false)
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setHideLabel(boolean hideLabel) throws IllegalStateException {
        setAttribute("hideLabel", hideLabel, true);
    }

    public boolean isHideLabel() {
        return getAttributeAsBoolean("hideLabel");
    }

    /**
     * The type attribute for input fields -- e.g. radio, text, password
     * (defaults to "text").
     * 
     * @param inputType
     *            the input type
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setInputType(String inputType) throws IllegalStateException {
        setAttribute("inputType", inputType, true);
    }

    /**
     * The type attribute for input fields -- e.g. radio, text, password
     * (defaults to "text").
     * 
     * @return the input type
     */
    public String getInputType() {
        if (isRendered()) {
            return getElement().getPropertyString("type");
        } else {
            String inputType = getAttribute("inputType");
            if (inputType == null)
                inputType = "text";
            return inputType;
        }
    }

    /**
     * The CSS class to use when marking a field invalid (defaults to
     * "x-form-invalid").
     * 
     * @param invalidClass
     *            CSS class when field is invalid
     */
    public void setInvalidClass(String invalidClass) {
        setAttribute("invalidClass", invalidClass, true, true);
    }

    /**
     * The CSS class to use when marking a field invalid (defaults to
     * "x-form-invalid").
     * 
     * @return the invalid CSS class
     */
    public String getInvalidClass() {
        return getAttribute("invalidClass");
    }

    /**
     * The error text to use when marking a field invalid and no message is
     * provided (defaults to "The value in this field is invalid"). This error
     * message is displayed when the used specified validator returns false.
     * 
     * @param invalidText
     *            invalid text on error
     * @see TextField#setValidator(Validator)
     */
    public void setInvalidText(String invalidText) {
        setAttribute("invalidText", invalidText, true, true);
    }

    /**
     * The error text to use when marking a field invalid and no message is
     * provided (defaults to "The value in this field is invalid"). This error
     * message is displayed when the used specified validator returns false.
     * 
     * @return the invalid text
     */
    public String getInvalidText() {
        return getAttribute("invalidText");
    }

    /**
     * Set the CSS style of the fields label. For example 'display:none'.
     * 
     * @param labelStyle
     *            the CSS style for the fields label
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setLabelStyle(String labelStyle) throws IllegalStateException {
        setAttribute("labelStyle", labelStyle, true);
    }

    /**
     * The CSS style of the fields label.
     * 
     * @return the label style
     */
    public String getLabelStyle() {
        return getAttribute("labelStyle");
    }

    /**
     * The seprator between the fields label and the field. Can use ' ' or
     * '&amp;nbsp;'
     * 
     * @param labelSeparator
     *            the label separator
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setLabelSeparator(String labelSeparator) throws IllegalStateException {
        setAttribute("labelSeparator", labelSeparator, true);
    }

    /**
     * The seprator between the fields label and the field.
     * 
     * @return the label separator
     */
    public String getLabelSeparator() {
        return getAttribute("labelSeparator");
    }

    // todo enum
    /**
     * The effect used when displaying a validation message under the field
     * (defaults to 'normal'). Other possible values are "slide" and
     * "slideRight"
     * 
     * @param msgFx
     *            validation message style
     */
    public void setMsgFx(String msgFx) {
        setAttribute("msgFx", msgFx, true, true);
    }

    /**
     * The location where error text should display. Should be one of the
     * following values (defaults to 'qtip') :
     * 
     * <pre>
     * Value         Description
     * -----------   ----------------------------------------------------------------------
     * qtip          Display a quick tip when the user hovers over the field
     * title         Display a default browser title attribute popup
     * under         Add a block div beneath the field containing the error text
     * side          Add an error icon to the right of the field with a popup on hover
     * [element id]  Add the error text directly to the innerHTML of the specified element
     * </pre>
     * 
     * @param msgTarget
     *            the error message target
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setFieldMsgTarget(String msgTarget) throws IllegalStateException {
        setAttribute("msgTarget", msgTarget, true);
    }

    /**
     * Set the field's HTML name attribute.
     * 
     * @param name
     *            the fields name
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setName(String name) throws IllegalStateException {
        setAttribute("name", name, true);
    }

    /**
     * Setting this to false will prevent the field from being submitted even
     * when it is not disabled.
     * <p>
     * Defaults to: true
     */
    public void setSubmitValue(boolean value) {
        setAttribute("submitValue", value, true);
    }

    /**
     * True to mark the field as readOnly in HTML (defaults to false) -- Note:
     * this only sets the element's readOnly DOM attribute.
     * 
     * @param readOnly
     *            true to mark field read only
     */
    public void setReadOnly(boolean readOnly) {
        if (!isRendered()) {
            setAttribute("readOnly", readOnly, true);
        } else {
            getElement().setPropertyBoolean("readOnly", readOnly);
        }
    }

    /**
     * True if read only.
     * 
     * @return true if read only.
     */
    public boolean isReadOnly() {
        if (!isRendered()) {
            return getAttributeAsBoolean("readOnly");
        } else {
            return getElement().getPropertyBoolean("readOnly");
        }
    }

    /**
     * The tabIndex for this field. Note this only applies to fields that are
     * rendered, not those which are built via applyTo.
     * 
     * @param tabIndex
     *            the fields tab index
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setTabIndex(int tabIndex) throws IllegalStateException {
        setAttribute("tabIndex", tabIndex, true);
    }

    /**
     * The tabIndex for this field.
     * 
     * @return the tab index
     */
    public int getTabindex() {
        return getAttributeAsInt("tabindex");
    }

    /**
     * Whether the field should validate when it loses focus (defaults to true).
     * 
     * @param validateOnBlur
     *            true to validate on blur
     */
    public void setValidateOnBlur(boolean validateOnBlur) {
        setAttribute("validateOnBlur", validateOnBlur, true, true);
    }

    /**
     * Whether the field should validate when it loses focus (defaults to true).
     * 
     * @return true if validate on blur
     */
    public boolean isValidateOnBlur() {
        return getAttributeAsBoolean("validateOnBlur");
    }

    /**
     * The length of time in milliseconds after user input begins until
     * validation is initiated (defaults to 250).
     * 
     * @param validationDelay
     *            the validation delay in milliseconds
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setValidationDelay(int validationDelay) throws IllegalStateException {
        setAttribute("validationDelay", validationDelay, true);
    }

    /**
     * The length of time in milliseconds after user input begins until
     * validation is initiated (defaults to 250).
     * 
     * @return the validation delay
     */
    public int getValidationDelay() {
        return getAttributeAsInt("validationDelay");
    }

    /**
     * Set to false to disable automatic validation.
     * 
     * @param validationEvent
     *            false to disable automatic validation
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setValidationEvent(boolean validationEvent) throws IllegalStateException {
        setAttribute("validationEvent", validationEvent, true);
    }

    /**
     * Display one or more error messages associated with this field, using
     * msgTarget to determine how to display the messages and applying
     * invalidCls to the field's UI element.
     * <p>
     * <b>Note</b>: this method does not cause the Field's validate or isValid
     * methods to return false if the value does pass validation. So simply
     * marking a Field as invalid will not prevent submission of forms submitted
     * with the Ext.form.action.Submit.clientValidation option set.
     */
    public void markInvalid(String... values) {
        JsArrayString peers = JsArray.createArray().cast();
        for (String s : values) {
            peers.push(s);
        }
        _markInvalid(peers);
    }

    /**
     * The event that should initiate field validation. (defaults to "keyup")..
     * 
     * @param validationEvent
     *            event to initiate validation
     */
    public void setValidationEvent(String validationEvent) {
        setAttribute("validationEvent", validationEvent, true, true);
    }

    private native void _markInvalid(JsArrayString value) /*-{
		var component = this.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()();
		component.markInvalid(value);
    }-*/;

}
