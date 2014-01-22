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

/**
 * A type of axis that displays items in categories. This axis is generally used
 * to display categorical information like names of items, month names,
 * quarters, etc. but no quantitative values. For that other type of information
 * Number axis are more suitable.
 * <p>
 * As with other axis you can set the position of the axis and its title.
 * 
 */
public class CategoryAxis extends AbstractAxis {

    public CategoryAxis() {
        jsObj = JsoHelper.createObject();
        this.setType("category");
    }

    protected CategoryAxis(JavaScriptObject obj) {
        jsObj = obj;
    }

    /**
     * Tndicates whether or not to calculate the number of categories (ticks and
     * labels) when there is not enough room to display all labels on the axis.
     * If set to true, the axis will determine the number of categories to plot.
     * If not, all categories will be plotted.
     * 
     * Defaults to: false
     * 
     * @param title
     */
    public void setCalculateCategoryCount(boolean value) {
        JsoHelper.setAttribute(jsObj, "calculateCategoryCount", value);
    }

    /**
     * 
     * Tndicates whether or not to calculate the number of categories (ticks and
     * labels) when there is not enough room to display all labels on the axis.
     * If set to true, the axis will determine the number of categories to plot.
     * If not, all categories will be plotted.
     * 
     * Defaults to: false
     * 
     * @param title
     */

    public boolean calculateCategoryCount() {
        return JsoHelper.getAttributeAsBoolean(jsObj, "calculateCategoryCount");
    }

    /**
     * A list of category names to display along this axis.
     * 
     * Defaults to: null
     */
    public void setCategoryNames(String value) {
        JsoHelper.setAttribute(jsObj, "categoryNames", value);
    }

    /**
     * 
     A list of category names to display along this axis.
     * 
     * Defaults to: null
     */
    public String getCategoryNames() {
        return JsoHelper.getAttribute(jsObj, "categoryNames");
    }

    public static CategoryAxis cast(AbstractAxis axis) {
        return new CategoryAxis(axis.getJsObj());
    }

}
