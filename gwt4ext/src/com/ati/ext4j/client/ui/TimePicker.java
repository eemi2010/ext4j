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
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsDate;

/**
 * A time picker which provides a list of times from which to choose. This is
 * used by the Ext.form.field.Time class to allow browsing and selection of
 * valid times, but could also be used with other components.
 * <p>
 * By default, all times starting at midnight and incrementing every 15 minutes
 * will be presented. This list of available times can be controlled using the
 * minValue, maxValue, and increment configuration properties. The format of the
 * times presented in the list can be customized with the format config.
 * <p>
 * To handle when the user selects a time from the list, you can subscribe to
 * the selectionchange event.
 * 
 * @author alainekambi
 * 
 */
public class TimePicker extends DataView {

    public TimePicker() {

    }

    protected TimePicker(JavaScriptObject obj) {
        super(obj);
    }

    public String getXType() {
        return XType.TIMEPICKER.getValue();
    }

    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.picker.Time(config);
    }-*/;

    /**
     * The default time format string which can be overriden for localization
     * support. The format must be valid according to Ext.Date.parse.
     * <p>
     * Defaults to 'g:i A', e.g., '3:15 PM'. For 24-hour time format try 'H:i'
     * instead.
     */
    public void setFormat(String value) {
        setAttribute("format", value, true);
    }

    /**
     * The number of minutes between each time value in the list.
     * <p>
     * Defaults to: 15
     */
    public void setIncrement(int value) {
        setAttribute("increment", value, true);
    }

    /**
     * The minimum time to be shown in the list of times. This must be a Date
     * object (only the time fields will be used); no parsing of String values
     * will be done.
     */
    public void setMinValue(JsDate value) {
        setAttribute("minValue", value, true);
    }

    /**
     * The maximum time to be shown in the list of times. This must be a Date
     * object (only the time fields will be used); no parsing of String values
     * will be done.
     */
    public void setMaxValue(JsDate value) {
        setAttribute("maxValue", value, true);
    }

    /**
     * Update the list of available times in the list to be constrained within
     * the minValue and maxValue.
     */
    public native void updateList() /*-{
		var picker = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		picker.updateList();
    }-*/;

    /**
     * Creates a new TimePicker from the given component
     * 
     * @param component
     *            , the component to cast from
     * @return, a new TimePicker from the component
     * 
     */
    public static TimePicker cast(Component component) {
        return new TimePicker(component.getOrCreateJsObj());
    }

}
