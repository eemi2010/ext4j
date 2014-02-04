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

import java.util.Date;

import com.eemi.ext4j.client.core.Component;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;

/**
 * Provides a date input field with a {@link DatePicker} dropdown and automatic
 * date validation.
 * <p>
 * This field recognizes and uses the JavaScript Date object as its main value
 * type. In addition, it recognizes string values which are parsed according to
 * the format and/or altFormats configs. These may be reconfigured to use date
 * formats appropriate for the user's locale.
 * <p>
 * The field may be limited to a certain range of dates by using the minValue,
 * maxValue, disabledDays, and disabledDates config parameters. These
 * configurations will be used both in the field's validation, and in the date
 * picker dropdown by preventing invalid dates from being selected.
 */
public class DateField extends TextField {

    /**
     * Construct a new DateField.
     */
    public DateField() {
    }

    public String getXType() {
        return "datefield";
    }

    /**
     * Construct a new DateField.
     * 
     * @param label
     *            the field label value
     * @param format
     *            the date format value
     */
    public DateField(String label, String format) {
        setFieldLabel(label);
        setFormat(format);
    }

    public DateField(JavaScriptObject jsObj) {
        super(jsObj);
    }

    protected native JavaScriptObject create(JavaScriptObject jsObj) /*-{
		return new $wnd.Ext.form.field.Date(jsObj);
    }-*/;

    /**
     * Returns the current date value of the date field.
     * 
     * @return the date value
     */
    public Date getValueAsDate() {
        double date = getTime(getOrCreateJsObj());
        return date == -1 ? null : new Date((long) date);
    }

    protected native Element getElement(JavaScriptObject jsObj) /*-{
		//for trigger fields, we want the text area as well as the trigger button to be treated as the element
		//unit
		var extEl = jsObj.wrap;
		if (extEl == null || extEl === undefined) {
			return null;
		}
		var el = extEl.dom;
		if (el == null || el === undefined) {
			return null;
			//forms buttons are detached when initially added
		} else {
			//There's an inconsistency in Ext where most elements have the property 'el' set to Ext's Element
			//with the exception of Menu->Item, Menu->Separator, Menu->TextItem,  Toolbar.Item and subclasses
			//(Toolbar.Separator, Toolbar.Spacer, Toolbar.TextItem) where the 'el' property is set to
			//the DOM element itself. Therefore retruning 'el' if 'el' is not Ext's Element. See details in issue 39.
			return el.dom || el;
		}
    }-*/;

    /**
     * Sets the value of the date field.
     * 
     * @param date
     *            the date value
     */
    public void setValue(Date date) {
        long time = date.getTime();
        setTime(getOrCreateJsObj(), time);
    }

    private native void setTime(JavaScriptObject df, double time)/*-{
		df.setValue(new $wnd.Date(time));
    }-*/;

    private native double getTime(JavaScriptObject df)/*-{
		//ext 1.1rc1 returns empty string.
		var val = df.getValue();
		return (val == '' || val == null || val === undefined) ? -1 : df
				.getValue().getTime();
    }-*/;

    /**
     * 
     Multiple date formats separated by "|" to try when parsing a user input
     * value and it does not match the defined format.
     * <p>
     * Defaults to:
     * "m/d/Y|n/j/Y|n/j/y|m/j/y|n/d/y|m/j/Y|n/d/Y|m-d-y|m-d-Y|m/d|m-d|md|mdy|mdY|d|Y-m-d|n-j|n/j"
     */
    public void setAltFormats(String altFormats) {
        setAttribute("altFormats", altFormats, true, true);
    }

    /**
     * An array of "dates" to disable, as strings. These strings will be used to
     * build a dynamic regular expression so they are very powerful. Some
     * examples:
     * 
     * @param disabledDates
     */
    public void setDisabledDates(String... disabledDates) {
        setAttribute("disabledDates", disabledDates, true, true);
    }

    /**
     * The tooltip text to display when the date falls on a disabled date.
     * Defaults to : 'Disabled'
     */
    public void setDisabledDatesText(String disabledDatesText) {
        setAttribute("disabledDatesText", disabledDatesText, true, true);
    }

    /**
     * 
     An array of days to disable, 0 based.
     */
    public void setDisabledDays(int... disabledDays) {
        setAttribute("disabledDays", disabledDays, true, true);
    }

    /**
     * 
     The tooltip to display when the date falls on a disabled day.
     * <p>
     * Defaults to: "Disabled"
     */
    public void setDisabledDaysText(String disabledDaysText) {
        setAttribute("disabledDaysText", disabledDaysText, true, true);
    }

    public void setFormat(String format) {
        setAttribute("format", format, true, true);
    }

    public void setInvalidText(String invalidText) {
        setAttribute("invalidText", invalidText, true, true);
    }

    public void setMinValue(String minValue) throws IllegalArgumentException {
        setAttribute("minValue", minValue, true);
    }

    public void setMinValue(Date minValue) throws IllegalArgumentException {
        setAttribute("minValue", minValue, true);
    }

    public void setMinText(String minText) {
        setAttribute("minText", minText, true, true);
    }

    public void setMaxValue(String maxValue) throws IllegalArgumentException {
        setAttribute("maxValue", maxValue, true);
    }

    public void setMaxValue(Date maxValue) throws IllegalArgumentException {
        setAttribute("maxValue", maxValue, true);
    }

    public void setMaxText(String maxText) {
        setAttribute("maxText", maxText, true, true);
    }

    public void setShowToday(boolean value) {
        setAttribute("showToday", value, true, true);
    }

    public void setStartDay(int value) {
        setAttribute("startDay", value, true, true);
    }

    public void setSubmitFormat(String value) {
        setAttribute("submitFormat", value, true, true);
    }

    public void setTriggerCls(String value) {
        setAttribute("triggerCls", value, true, true);
    }

    public void setUseStrict(boolean value) {
        setAttribute("useStrict", value, true, true);
    }

    /**
     * Creates a new DateField from the given component
     * 
     * @param component
     *            , the component to cast from
     * @return, a new DateField from the component
     * 
     */
    public static DateField cast(Component component) {
        return new DateField(component.getOrCreateJsObj());
    }

}
