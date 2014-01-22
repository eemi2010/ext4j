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
package com.eemi.ext4j.client.layout;

import com.eemi.ext4j.client.core.JsoHelper;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * This is a multi-pane, application-oriented UI layout style that supports
 * multiple nested panels, automatic bars between regions and built-in expanding
 * and collapsing of regions.
 * 
 * This class is intended to be extended or created via the
 * <code>setLayout(new BorderLayout()</code> method.
 */
public class BorderLayout extends ContainerLayout {

    public BorderLayout() {
    }

    public BorderLayout(String padding) {
        this();
        setPadding(padding);
    }

    protected BorderLayout(JavaScriptObject obj) {
        jsObj = obj;
    }

    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		var jso = {
			type : 'border'
		};
		this.@com.eemi.ext4j.client.layout.ContainerLayout::jsObj = jso;
		return this.@com.eemi.ext4j.client.layout.ContainerLayout::jsObj;
    }-*/;

    /**
     * Sets the padding to be applied to all child items managed by this layout.
     * 
     * This property can be specified as a string containing space-separated,
     * numeric padding values. The order of the sides associated with each value
     * matches the way CSS processes padding values:
     * <ul>
     * <li>If there is only one value, it applies to all sides.</li>
     * <li>If there are two values, the top and bottom borders are set to the
     * first value and the right and left are set to the second.</li>
     * <li>If there are three values, the top is set to the first value, the
     * left and right are set to the second, and the bottom is set to the third.
     * </li>
     * <li>If there are four values, they apply to the top, right, bottom, and
     * left, respectively.</li>
     * </ul>
     */
    public void setPadding(String padding) {
        JsoHelper.setAttribute(jsObj, "padding", padding);
    }

    public void setPadding(int padding) {
        JsoHelper.setAttribute(jsObj, "padding", padding);
    }

    /**
     * The default weights to assign to regions in the border layout. These
     * values are used when a region does not contain a weight property. This
     * object must have properties for all regions ("north", "south", "east" and
     * "west").
     * 
     * @param weight
     *            , the weight to assign
     */
    public void setRegionWeights(BorderRegionWeight weight) {
        JsoHelper.setAttribute(jsObj, "regionWeights", weight.getJsObj());
    }

    /**
     * 
     * @param value
     */
    public void setSplit(boolean value) {
        JsoHelper.setAttribute(jsObj, "split", value);
    }

    /**
     * 
     * @param value
     */
    public void setSplitterResize(boolean value) {
        JsoHelper.setAttribute(jsObj, "splitterResize", value);
    }

    public static BorderLayout cast(ContainerLayout layout) {
        return new BorderLayout(layout.getJsObj());
    }

    @Override
    protected native void create() /*-{
		var jso = {
			type : 'border'
		};
		this.@com.eemi.ext4j.client.layout.ContainerLayout::jsObj = jso;
    }-*/;

}
