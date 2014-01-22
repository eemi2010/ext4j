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
package com.eemi.ext4j.client.chart.series;

import com.eemi.ext4j.client.core.JsoHelper;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * Creates a Bar Chart. A Bar Chart is a useful visualization technique to
 * display quantitative information for different categories that can show some
 * progression (or regression) in the dataset. As with all other series, the Bar
 * Series must be appended in the series Chart array configuration. See the
 * Chart documentation for more information.
 * 
 * @author alainekambi
 * 
 */
public class BarSerie extends CartesianSerie {

    public BarSerie() {
        jsObj = JsoHelper.createObject();
        this.setType("bar");
    }

    protected BarSerie(JavaScriptObject obj) {
        jsObj = obj;
    }

    /**
     * Whether to set the visualization as column chart or horizontal bar chart.
     * 
     * Defaults to: false
     * 
     * @param value
     */
    public void setColum(boolean value) {
        JsoHelper.setAttribute(jsObj, "column", value);
    }

    /**
     * The gutter space between groups of bars, as a percentage of the bar width
     * 
     * Defaults to: 38.2
     * 
     * @param value
     */
    public void setGroupGutter(double value) {
        JsoHelper.setAttribute(jsObj, "groupGutter", value);
    }

    /**
     * The gutter space between single bars, as a percentage of the bar width
     * 
     * Defaults to: 38.2
     * 
     * @param value
     */
    public void setGutter(double value) {
        JsoHelper.setAttribute(jsObj, "gutter", value);
    }

    /**
     * Padding between the left/right axes and the bars
     * 
     * Defaults to: 0
     * 
     * @param value
     */
    public void setXPadding(double value) {
        JsoHelper.setAttribute(jsObj, "xPadding", value);
    }

    /**
     * Padding between the top/bottom axes and the bars
     * 
     * Defaults to: 10
     * 
     * @param value
     */
    public void setYPadding(double value) {
        JsoHelper.setAttribute(jsObj, "yPadding", value);
    }

    public static BarSerie cast(AbstractSerie serie) {
        return new BarSerie(serie.getJsObj());
    }

}
