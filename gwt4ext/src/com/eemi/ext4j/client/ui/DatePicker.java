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

import java.util.ArrayList;

import com.eemi.ext4j.client.core.Component;
import com.eemi.ext4j.client.core.config.XType;
import com.eemi.ext4j.client.events.HandlerRegistration;
import com.eemi.ext4j.client.events.datepicker.SelectHandler;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayNumber;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.core.client.JsDate;

/**
 * This class is used by the com.eemi.ext4j.client.form.field.Date field to
 * allow browsing and selection of valid dates in a popup next to the field, but
 * may also be used with other components.
 * <p>
 * Typically you will need to implement a handler function to be notified when
 * the user chooses a date from the picker; you can register the handler using
 * the select event, or by implementing the handler method.
 * 
 * <p>
 * By default the user will be allowed to pick any date; this can be changed by
 * using the minDate, maxDate, disabledDays, disabledDatesRE, and/or
 * disabledDates configs.
 * 
 * All the string values documented below may be overridden by including an Ext
 * locale file in your page.
 * 
 */
public class DatePicker extends Component {

    private static JavaScriptObject configPrototype;

    private native void init()/*-{
		var c = new $wnd.Ext.picker.Date();
		@com.eemi.ext4j.client.ui.DatePicker::configPrototype = c.initialConfig;
    }-*/;

    public DatePicker() {
        // init();
    }

    public DatePicker(JavaScriptObject object) {
        super(object);
    }

    protected JavaScriptObject getConfigPrototype() {
        return configPrototype;
    }

    public String getXType() {
        return XType.DATEPICKER.getValue();
    }

    @Override
    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		config.menu = {};
		return new $wnd.Ext.picker.Date(config);
    }-*/;

    /**
     * The text to display for the aria title
     * <p>
     * Defaults to: "Date Picker: {0}"
     * 
     */
    public void setAriaTitle(String value) {
        setAttribute("ariaTitle", value, true);
    }

    /**
     * The date format to display for the current value in the ariaTitle
     * <p>
     * Defaults to: "F d, Y"
     * 
     */
    public void setAriaTitleDateFormat(String value) {
        setAttribute("ariaTitleDateFormat", value, true);
    }

    /**
     * An array of textual day names which can be overriden for localization
     * support (defaults to Ext.Date.dayNames)
     */
    public void setDayNames(JsArrayString value) {
        setAttribute("dayNames", value, true);
    }

    /**
     * True to disable animations when showing the month picker.
     * <p>
     * Defaults to: false
     */
    public void setDisableAnim(boolean value) {
        setAttribute("disableAnim", value, true);
    }

    /**
     * The class to apply to disabled cells.
     * <p>
     * Defaults to: "x-datepicker-disabled"
     */
    public void setDisabledCellCls(String value) {
        setAttribute("disabledCellCls", value, true);
    }

    /**
     * An array of 'dates' to disable, as strings. These strings will be used to
     * build a dynamic regular expression so they are very powerful
     * 
     * <p>
     * Some examples : <br/>
     * <ul>
     * <li>['03/08/2003', '09/16/2003'] would disable those exact dates</li>
     * <li>['03/08', '09/16'] would disable those days for every year</li>
     * <li>['03/08'] would only match the beginning (useful if you are using
     * short years)</li>
     * <li>['03/../2006'] would disable every day in March 2006</li>
     * <li>['03'] would disable every day in every March</li>
     * </ul>
     */
    public void setDisabledDates(JsArrayString value) {
        setAttribute("disabledDates", value, true);
    }

    /**
     * The tooltip text to display when the date falls on a disabled date.
     * <p>
     * Defaults to: "Disabled"
     */
    public void setDisabledDatesText(String value) {
        setAttribute("disabledDatesText", value, true);
    }

    /**
     * The tooltip text to display when the date falls on a disabled date.
     * <p>
     * Defaults to: "Disabled"
     */
    public void setDisabledDays(JsArrayNumber values) {
        setAttribute("disabledDays", values, true);
    }

    /**
     * The tooltip to display when the date falls on a disabled day.
     * <p>
     * Defaults to: "Disabled"
     */
    public void setDisabledDaysText(String value) {
        setAttribute("disabledDaysText", value, true);
    }

    /**
     * True to automatically focus the picker on show.
     * <p>
     * Defaults to: false
     */
    public void setFocusOnShow(String value) {
        setAttribute("focusOnShow", value, true);
    }

    /**
     * The default date format string which can be overriden for localization
     * support. The format must be valid according to Ext.Date.parse (defaults
     * to Ext.Date.defaultFormat).
     */
    public void setFormat(String value) {
        setAttribute("format", value, true);
    }

    /**
     * Specifies optional custom key event handlers for the Ext.util.KeyNav
     * attached to this date picker. Must conform to the config format
     * recognized by the Ext.util.KeyNav constructor. Handlers specified in this
     * object will replace default handlers of the same name.
     */
    public void setKeyNavConfig(JavaScriptObject value) {
        setAttribute("keyNavConfig", value, true);
    }

    /**
     * The format for displaying a date in a longer format.
     * <p>
     * Defaults to: "F d, Y"
     */
    public void setLongDayFormat(String value) {
        setAttribute("longDayFormat", value, true);
    }

    /**
     * Maximum allowable date (JavaScript date object)
     * <p>
     * Defaults to: null
     */
    public void setMaxDate(JsDate value) {
        setAttribute("maxDate", value, true);
    }

    /**
     * The error text to display if the maxDate validation fails.
     * <p>
     * Defaults to: "This date is after the maximum date"
     */
    public void setMaxText(String value) {
        setAttribute("maxText", value, true);
    }

    /**
     * Minimum allowable date (JavaScript date object)
     * <p>
     * Defaults to: null
     */
    public void setMinDate(JsDate value) {
        setAttribute("minDate", value, true);
    }

    /**
     * The error text to display if the minDate validation fails.
     * <p>
     * Defaults to: "This date is before the minimum date"
     */
    public void setMinText(String value) {
        setAttribute("minText", value, true);
    }

    /**
     * An array of textual month names which can be overriden for localization
     * support (defaults to Ext.Date.monthNames)
     */
    public void setMonthNames(JsArrayString value) {
        setAttribute("monthNames", value, true);
    }

    /**
     * The date format for the header month
     * <p>
     * Defaults to: "F Y"
     */
    public void setMonthYearFormat(String value) {
        setAttribute("monthYearFormat", value, true);
    }

    /**
     * The header month selector tooltip
     * <p>
     * Defaults to: "Choose a month (Control+Up/Down to move years)"
     */
    public void setMonthYearText(String value) {
        setAttribute("monthYearText", value, true);
    }

    /**
     * The next month navigation button tooltip
     * <p>
     * Defaults to: "Next Month (Control+Right)"
     */
    public void setNextText(String value) {
        setAttribute("nextText", value, true);
    }

    /**
     * The previous month navigation button tooltip
     * <p>
     * Defaults to: "Previous Month (Control+Left)"
     */
    public void setPrevText(String value) {
        setAttribute("prevText", value, true);
    }

    /**
     * The class to apply to the selected cell.
     * <p>
     * Defaults to: "x-datepicker-selected"
     */
    public void setSelectedCls(String value) {
        setAttribute("selectedCls", value, true);
    }

    /**
     * False to hide the footer area containing the Today button and disable the
     * keyboard handler for spacebar that selects the current date.
     * <p>
     * Defaults to: true
     */
    public void setShowToday(boolean value) {
        setAttribute("showToday", value, true);
    }

    /**
     * Day index at which the week should begin, 0-based.
     * <p>
     * Defaults to 0 (Sunday).
     */
    public void setStartDay(int value) {
        setAttribute("startDay", value, true);
    }

    /**
     * The text to display on the button that selects the current date
     * <p>
     * Defaults to: "Today"
     */
    public void setTodayText(String value) {
        setAttribute("todayText", value, true);
    }

    /**
     * A string used to format the message for displaying in a tooltip over the
     * button that selects the current date. The {0} token in string is replaced
     * by today's date.
     * <p>
     * Defaults to: "{0} (Spacebar)"
     */
    public void setTodayTip(String value) {
        setAttribute("todayTip", value, true);
    }

    /**
     * Show the next year.
     */
    public native DatePicker showNextYear() /*-{
		var datePicker = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		datePicker.showNextYear();
		return this;
    }-*/;

    /**
     * Show the previous year.
     */
    public native DatePicker showPrevYear() /*-{
		var datePicker = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		datePicker.showPrevYear();
		return this;
    }-*/;

    /**
     * Show the month picker
     */
    public native DatePicker showMonthPicker() /*-{
		var datePicker = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		datePicker.showMonthPicker();
		return this;
    }-*/;

    /**
     * Show the month picker
     */
    public native DatePicker showMonthPicker(boolean animate) /*-{
		var datePicker = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		datePicker.showMonthPicker(animate);
		return this;
    }-*/;

    /**
     * An arraylist of textual day names which can be overriden for localization
     * support (defaults to Ext.Date.dayNames)
     * 
     * @param values
     */
    public void setDayNames(ArrayList<String> values) {
        JsArrayString strings = JsArray.createArray().cast();
        for (String s : values) {
            strings.push(s);
        }
        setAttribute("dayNames", strings, true);
    }

    /**
     * Creates a new DatePicker from the given component
     * 
     * @param component
     *            , the component to cast from
     * @return, a new DatePicker from the component
     * 
     */
    public static DatePicker cast(Component component) {
        return new DatePicker(component.getOrCreateJsObj());
    }

    /**
     * Fires when a date is selected
     * 
     * @param handler
     *            , the handler that will handle the event
     */

    public native HandlerRegistration addSelectHandler(SelectHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(cmp, date, e) {
			var datePicker = @com.eemi.ext4j.client.ui.DatePicker::new(Lcom/google/gwt/core/client/JavaScriptObject;)(cmp);
			var event = @com.eemi.ext4j.client.events.datepicker.SelectEvent::new(Lcom/eemi/ext4j/client/ui/DatePicker;Lcom/google/gwt/core/client/JsDate;Lcom/google/gwt/core/client/JavaScriptObject;)(datePicker, date, e);
			handler.@com.eemi.ext4j.client.events.datepicker.SelectHandler::onSelect(Lcom/eemi/ext4j/client/events/datepicker/SelectEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.datepicker.SelectEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

}
