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
package com.eemi.ext4j.client.chart.axis;

import com.eemi.ext4j.client.core.JsoHelper;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsDate;

/**
 * A type of axis whose units are measured in time values. Use this axis for
 * listing dates that you will want to group or dynamically change. If you just
 * want to display dates as categories then use the Category class for axis
 * instead.
 */
public class TimeAxis extends NumericAxis {

    public TimeAxis() {
        jsObj = JsoHelper.createObject();
        this.setType("time");
    }

    protected TimeAxis(JavaScriptObject jsObj) {
        this.jsObj = jsObj;
    }

    public void setGroupBy(String value) {
        JsoHelper.setAttribute(jsObj, "groupBy", value);
    }

    /**
     * ndicates the format the date will be rendered on. For example: 'M d' will
     * render the dates as 'Jan 30', etc. For a list of possible format strings
     * see Date
     * 
     * Defaults to: false
     * 
     * @param value
     */
    public void setDateFormat(boolean value) {
        JsoHelper.setAttribute(jsObj, "dateFormat", value);
    }

    /**
     * Indicates the format the date will be rendered on. For example: 'M d'
     * will render the dates as 'Jan 30', etc. For a list of possible format
     * strings see Date
     * 
     * 
     * @param value
     */
    public void setDateFormat(String value) {
        JsoHelper.setAttribute(jsObj, "dateFormat", value);
    }

    /**
     * the starting date for the time axis.
     * 
     * 
     * @param value
     */
    public void setFromDate(JsDate value) {
        JsoHelper.setAttribute(jsObj, "fromDate", value);
    }

    /**
     * the starting date for the time axis.
     * 
     * 
     * @param value
     */
    public void seToDate(JsDate value) {
        JsoHelper.setAttribute(jsObj, "toDate", value);
    }

    public static TimeAxis cast(AbstractAxis axis) {
        return new TimeAxis(axis.getJsObj());
    }

}
