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
package com.ati.ext4j.client.chart.series;

import com.ati.ext4j.client.core.JsoHelper;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * Creates a Column Chart. Much of the methods are inherited from Bar. A Column
 * Chart is a useful visualization technique to display quantitative information
 * for different categories that can show some progression (or regression) in
 * the data set. As with all other series, the Column Series must be appended in
 * the series Chart array configuration. See the Chart documentation for more
 * information.
 * 
 * @author alainekambi
 * 
 */
public class GaugeSerie extends BarSerie {

    public GaugeSerie() {
        jsObj = JsoHelper.createObject();
        this.setType("Gauge");
    }

    protected GaugeSerie(JavaScriptObject obj) {
        jsObj = obj;
    }

    /**
     * The store record field name to be used for the pie angles. The values
     * bound to this field name must be positive real numbers.
     * 
     * Defaults to: false
     * 
     * @param value
     */
    public void setAngleField(String value) {
        JsoHelper.setAttribute(jsObj, "angleField", value);
    }

    /**
     * Use the entire disk or just a fraction of it for the gauge. Default's
     * false.
     * 
     * Defaults to: false
     * 
     * @param value
     */
    public void setDonut(boolean value) {
        JsoHelper.setAttribute(jsObj, "donut", value);
    }

    /**
     * Use the entire disk or just a fraction of it for the gauge.
     * 
     * @param value
     */
    public void setDonut(double value) {
        JsoHelper.setAttribute(jsObj, "donut", value);
    }

    /**
     * The duration for the pie slice highlight effect.
     * 
     * Defaults to: 150
     * 
     * @param value
     */
    public void setHighlightDuration(double value) {
        JsoHelper.setAttribute(jsObj, "highlightDuration", value);
    }

    /**
     * Use the Gauge Series as an area series or add a needle to it. Default's
     * false.
     * 
     * Defaults to: false
     * 
     * @param value
     */
    public void setNeedle(boolean value) {
        JsoHelper.setAttribute(jsObj, "needle", value);
    }

    public static GaugeSerie cast(AbstractSerie serie) {
        return new GaugeSerie(serie.getJsObj());
    }

}
