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
package com.ati.ext4j.client.ui;

import com.ati.ext4j.client.core.Component;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * A numeric text field that provides automatic keystroke filtering to disallow
 * non-numeric characters, and numeric validation to limit the value to a range
 * of valid numbers. The range of acceptable number values can be controlled by
 * setting the minValue and maxValue configs, and fractional decimals can be
 * disallowed by setting allowDecimals to false.
 * <p>
 * By default, the number field is also rendered with a set of up/down spinner
 * buttons and has up/down arrow key and mouse wheel event listeners attached
 * for incrementing/decrementing the value by the step value. To hide the
 * spinner buttons set hideTrigger:true; to disable the arrow key and mouse
 * wheel handlers set keyNavEnabled:false and mouseWheelEnabled:false. See the
 * example below.
 * 
 */
public class NumberField extends TextField {

    /**
     * Creates a new NumberField.
     */
    public NumberField() {

    }

    public NumberField(JavaScriptObject jsObj) {
        super(jsObj);
    }

    protected native JavaScriptObject create(JavaScriptObject jsObj)/*-{
		return new $wnd.Ext.form.field.Number(jsObj);
    }-*/;

    /**
     * Sets the fields value regardless if the field is rendered or not
     * 
     * @param value
     *            the value to set the field
     */
    public void setValue(final float value) {
        setValueJ(value);
    }

    private native void setValueJ(float value) /*-{
		var field = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		field.setValue(value);
    }-*/;

    /**
     * Sets the fields value.
     * 
     * @param value
     *            the field value
     */
    public void setValue(Number value) {
        if (value == null) {
            setNullValue();
        } else {
            setValue(value.floatValue());
        }
    }

    /**
     * Sets the fields value to null.
     * 
     */
    private native void setNullValue() /*-{
		var field = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		field.setValue(null);
    }-*/;

    /**
     * Validates a value according to the field's validation rules and marks the
     * field as invalid if the validation fails.
     * 
     * @param value
     *            the value to validate
     * @return true if valid
     */
    public boolean validateValue(Number value) {
        return value == null ? validateNullValue() : validateValue(value.floatValue());
    }

    /**
     * Validates a null value according to the field's validation rules and
     * marks the field as invalid if the validation fails.
     * 
     * @return true if valid
     */
    private native boolean validateNullValue() /*-{
		var field = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		return field.validateValue(null);
    }-*/;

    /**
     * Validates a value according to the field's validation rules and marks the
     * field as invalid if the validation fails.
     * 
     * @param value
     *            the value to validate
     * @return true if valid
     */
    public native boolean validateValue(float value) /*-{
		var field = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		return field.validateValue(value);
    }-*/;

    // --- config properties ---
    public String getXType() {
        return "numberfield";
    }

    /**
     * False to disallow decimal values (defaults to true).
     * 
     * @param allowDecimals
     *            false to disallow decimal values
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setAllowDecimals(boolean allowDecimals) throws IllegalStateException {
        setAttribute("allowDecimals", allowDecimals, true);
    }

    /**
     * False to prevent entering a negative sign (defaults to true).
     * 
     * @param allowNegative
     *            false to prevent entering a negative sign
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setAllowNegative(boolean allowNegative) throws IllegalStateException {
        setAttribute("allowNegative", allowNegative, true);
    }

    /**
     * The maximum precision to display after the decimal separator (defaults to
     * 2).
     * 
     * @param decimalPrecision
     *            the decimal precision
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setDecimalPrecision(int decimalPrecision) throws IllegalStateException {
        setAttribute("decimalPrecision", decimalPrecision, true);
    }

    /**
     * This method removes trailing zeros after the last non-zero after the
     * decimal point. This check is done after the precision is calculated
     * (defaults to false).
     * 
     * @param removeTrailZeros
     *            true to remove trailing zeros
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setRemoveTrailingZeros(boolean removeTrailZeros) throws IllegalStateException {
        setAttribute("removeTrailZeros", removeTrailZeros, true);
    }

    /**
     * Character(s) to allow as the decimal separator (defaults to '.').
     * 
     * @param decimalSeparator
     *            decimal separator
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setDecimalSeparator(String decimalSeparator) throws IllegalStateException {
        setAttribute("decimalSeparator", decimalSeparator, true);
    }

    /**
     * Error text to display if the maximum value validation fails (defaults to
     * "The maximum value for this field is {maxValue}").
     * 
     * @param maxText
     *            the max error text
     */
    public void setMaxText(String maxText) {
        setAttribute("maxText", maxText, true, true);
    }

    /**
     * The maximum allowed value (defaults to Number.MAX_VALUE).
     * 
     * @param maxValue
     *            the max value
     */
    public void setMaxValue(int maxValue) {
        setAttribute("maxValue", maxValue, true, true);
    }

    /**
     * Error text to display if the minimum value validation fails (defaults to
     * "The minimum value for this field is {minValue}").
     * 
     * @param minText
     *            the min error text
     */
    public void setMinText(String minText) {
        setAttribute("minText", minText, true, true);
    }

    /**
     * The minimum allowed value (defaults to Number.NEGATIVE_INFINITY).
     * 
     * @param minValue
     *            the min value
     */
    public void setMinValue(int minValue) {
        setAttribute("minValue", minValue, true, true);
    }

    /**
     * Error text to display if the value is not a valid number. For example,
     * this can happen if a valid character like '.' or '-' is left in the field
     * with no number (defaults to
     * "throws IllegalArgumentException {value} is not a valid number").
     * 
     * @param nanText
     *            the Nan text
     */
    public void setNanText(String nanText) {
        setAttribute("nanText", nanText, true, true);
    }

    public static NumberField cast(Component component) {
        return new NumberField(component.getOrCreateJsObj());
    }
}
