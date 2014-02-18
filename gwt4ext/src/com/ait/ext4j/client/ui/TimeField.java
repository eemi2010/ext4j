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
package com.ait.ext4j.client.ui;

import java.util.Date;

import com.ait.ext4j.client.core.Component;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * Provides a time input field with a time dropdown and automatic time
 * validation.
 * <p>
 * This field recognizes and uses JavaScript Date objects as its main value type
 * (only the time portion of the date is used; the month/day/year are ignored).
 * In addition, it recognizes string values which are parsed according to the
 * format and/or altFormats configs. These may be reconfigured to use time
 * formats appropriate for the user's locale.
 * <p>
 * The field may be limited to a certain range of times by using the minValue
 * and maxValue configs, and the interval between time options in the dropdown
 * can be changed with the increment config.
 */
public class TimeField extends ComboBox {

    private static JavaScriptObject configPrototype;

    private static native void init()/*-{
		var c = new $wnd.Ext.form.field.Time();
		@com.ait.ext4j.client.ui.TimeField::configPrototype = c.initialConfig;
    }-*/;

    protected JavaScriptObject getConfigPrototype() {
        return configPrototype;
    }

    public String getXType() {
        return "timefield";
    }

    public TimeField() {
    }

    public TimeField(String valueField) {
        this.setValueField(valueField);
    }

    public TimeField(JavaScriptObject jsObj) {
        super(jsObj);
    }

    protected native JavaScriptObject create(JavaScriptObject jsObj) /*-{
		return new $wnd.Ext.form.Time(jsObj);
    }-*/;

    // --- config properties ---

    /**
     * Multiple date formats separated by "|" to try when parsing a user input
     * value and it doesn't match the defined format (defaults to
     * 'm/d/Y|m-d-y|m-d-Y|m/d|m-d|d').
     * 
     * @param altFormats
     *            the alt formats
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setAltFormats(String altFormats) throws IllegalStateException {
        setAttribute("altFormats", altFormats, true);
    }

    /**
     * The default date format string which can be overriden for localization
     * support. The format must be valid according to Date.parseDate (defaults
     * to 'm/d/y').
     * 
     * @param format
     *            the date format string
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setFormat(String format) throws IllegalStateException {
        setAttribute("format", format, true);
    }

    /**
     * The number of minutes between each time value in the list (defaults to
     * 15).
     * 
     * @param increment
     *            the number of minutes between each time value in the list
     *            (defaults to 15).
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setIncrement(int increment) throws IllegalStateException {
        setAttribute("increment", increment, false);
    }

    /**
     * The error text to display when the time in the field is invalid (defaults
     * to '{value} is not a valid time - it must be in the format {format}').
     * 
     * @param invalidtext
     *            the error text to display when the time in the field is
     *            invalid
     */
    public void setInvalidText(String invalidtext) {
        setAttribute("invalidText", invalidtext, true, true);
    }

    /**
     * The error text to display when the time is after maxValue (defaults to
     * 'The time in this field must be equal to or before {0}').
     * 
     * @param maxText
     *            The error text to display when the time is after maxValue
     */
    public void setMaxText(String maxText) {
        setAttribute("maxText", maxText, true, true);
    }

    /**
     * The maximum allowed time.
     * 
     * @param maxValue
     *            the max value
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setMaxValue(Date maxValue) throws IllegalStateException {
        setAttribute("maxValue", maxValue, true);
    }

    /**
     * The maximum allowed time in valid date format.
     * 
     * @param maxValue
     *            The maximum allowed time.
     * 
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setMaxValue(String maxValue) throws IllegalStateException {
        setAttribute("maxValue", maxValue, true);
    }

    /**
     * The error text to display when the date in the cell is before minValue
     * (defaults to 'The time in this field must be equal to or after {0}').
     * 
     * @param minText
     *            The error text to display when the date in the cell is before
     *            minValue
     */
    public void setMinText(String minText) {
        setAttribute("minText", minText, true, true);
    }

    /**
     * The minimum allowed time.
     * 
     * @param minValue
     *            The minimum allowed time.
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setMinValue(Date minValue) throws IllegalStateException {
        setAttribute("minValue", minValue, true);
    }

    /**
     * The minimum allowed time in valid date format.
     * 
     * @param minValue
     *            The minimum allowed time.
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setMinValue(String minValue) throws IllegalStateException {
        setAttribute("minValue", minValue, true);
    }

    public static TimeField cast(Component component) {
        return new TimeField(component.getOrCreateJsObj());
    }
}