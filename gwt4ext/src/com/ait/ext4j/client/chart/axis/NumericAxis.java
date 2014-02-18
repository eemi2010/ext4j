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
package com.ait.ext4j.client.chart.axis;

import com.ait.ext4j.client.core.JsoHelper;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * An axis to handle numeric values. This axis is used for quantitative data as
 * opposed to the category axis. You can set mininum and maximum values to the
 * axis so that the values are bound to that. If no values are set, then the
 * scale will auto-adjust to the values.
 */
public class NumericAxis extends AbstractAxis {

    public NumericAxis() {
        jsObj = JsoHelper.createObject();
        this.setType("Numeric");
    }

    protected NumericAxis(JavaScriptObject jsObj) {
        this.jsObj = jsObj;
    }

    /**
     * If true, the values of the chart will be rendered only if they belong
     * between minimum and maximum If false, all values of the chart will be
     * rendered, regardless of whether they belong between minimum and maximum
     * or not Default's true if maximum and minimum is specified.
     * 
     * Defaults to: true
     */
    public void setConstrain(boolean value) {
        JsoHelper.setAttribute(jsObj, "constrain", value);
    }

    /**
     * Indicates whether to extend maximum beyond data's maximum to the nearest
     * majorUnit.
     * 
     * Defaults to: false
     */
    public void setAdjustMaximumByMajorUnit(boolean value) {
        JsoHelper.setAttribute(jsObj, "adjustMaximumByMajorUnit", value);
    }

    /**
     * Indicates whether to extend the minimum beyond data's minimum to the
     * nearest majorUnit.
     * 
     * Defaults to: false
     */
    public void setAdjustMinimumByMajorUnit(boolean value) {
        JsoHelper.setAttribute(jsObj, "adjustMinimumByMajorUnit", value);
    }

    /**
     * The number of decimals to round the value to.
     * 
     * Defaults to: 2
     */
    public void setDecimals(int value) {
        JsoHelper.setAttribute(jsObj, "decimals", value);
    }

    /**
     * The maximum value drawn by the axis. If not set explicitly, the axis
     * maximum will be calculated automatically.
     * 
     * @param value
     */
    public void setMinimum(int value) {
        JsoHelper.setAttribute(jsObj, "minimum", value);
    }

    /**
     * The minimum value drawn by the axis. If not set explicitly, the axis
     * minimum will be calculated automatically.
     * 
     * @param value
     */
    public void setMaximum(int value) {
        JsoHelper.setAttribute(jsObj, "maximum", value);
    }

    public static NumericAxis cast(AbstractAxis axis) {
        return new NumericAxis(axis.getJsObj());
    }

}
