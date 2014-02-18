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
package com.ati.ext4j.client.chart.axis;

import com.ati.ext4j.client.core.JsoHelper;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * Gauge Axis is the axis to be used with a Gauge series. The Gauge axis
 * displays numeric data from an interval defined by the minimum, maximum and
 * step configuration properties. The placement of the numeric data can be
 * changed by altering the margin option that is set to 10 by default.
 * 
 */
public class GaugeAxis extends AbstractAxis {

    public GaugeAxis() {
        jsObj = JsoHelper.createObject();
        this.setType("Gauge");
    }

    protected GaugeAxis(JavaScriptObject jsObj) {
        this.jsObj = jsObj;
    }

    /**
     * The maximum value of the interval to be displayed in the axis. This
     * property is required.
     * 
     * @param value
     */
    public void setMaximum(double value) {
        JsoHelper.setAttribute(jsObj, "maximum", value);
    }

    /**
     * The minimum value of the interval to be displayed in the axis. This
     * property is required.
     * 
     * @param value
     */
    public void setMinimum(double value) {
        JsoHelper.setAttribute(jsObj, "minimum", value);
    }

    /**
     * The number of steps and tick marks to add to the interval.This property
     * is required.
     * 
     * @param value
     */
    public void setSteps(double value) {
        JsoHelper.setAttribute(jsObj, "steps", value);
    }

    /**
     * The offset positioning of the tick marks and labels in pixels.
     * 
     * Defaults to: 10
     * 
     * @param value
     */
    public void setMargin(double value) {
        JsoHelper.setAttribute(jsObj, "margin", value);
    }

    /**
     * The title for the Axis.
     * 
     * @param value
     */
    public void setTitle(String value) {
        JsoHelper.setAttribute(jsObj, "title", value);
    }

    public static GaugeAxis cast(AbstractAxis axis) {
        return new GaugeAxis(axis.getJsObj());
    }

}
