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

/**
 * Base Class for HBoxLayout and VBoxLayout Classes. Generally it should not
 * need to be used directly.
 * 
 */
public abstract class BoxLayout extends ContainerLayout {

    /**
     * Specifies the direction in which child components are laid out. Defaults
     * to 'normal', which means they are laid out in the order they are added.
     * You can use the 'reverse' option to have them laid out in reverse.
     * 
     * @param direction
     *            , the direction of the layout
     */
    public void setDirection(String direction) {
        JsoHelper.setAttribute(this.getJsObj(), "direction", direction);
    }

    /**
     * Specifies the vertical alignment of child components. Defaults to
     * 'start'. Acceptable values are:
     * <ul>
     * <li>center: Aligned to the center of the container</li>
     * <li>end: Aligned to the bottom of the container</li>
     * <li>justify: Justified with both top and bottom of the container</li>
     * <li>start: Aligned to the top of the container.</li>
     * </ul>
     * 
     * @param pack
     *            , the horizontal alignment of the child component
     */
    public void setPack(Pack pack) {
        setPack(pack.getValue());
    }

    private void setPack(String pack) {
        JsoHelper.setAttribute(this.getJsObj(), "pack", pack);
    }

    /**
     * This configuration option is to be applied to child items of the
     * container managed by this layout. Each child item with a flex property
     * will be flexed (horizontally in hbox, vertically in vbox) according to
     * each item's relative flex value compared to the sum of all items with a
     * flex value specified. Any child items that have either a flex = 0 or flex
     * = undefined will not be 'flexed' (the initial size will not be changed).
     * 
     * @param value
     */
    public void setFlex(int value) {
        JsoHelper.setAttribute(this.getJsObj(), "flex", value);
    }

    /**
     * Sets the padding to be applied to all child items managed by this layout.
     * 
     * This property must be specified as a string containing space-separated,
     * numeric padding values. The order of the sides associated with each value
     * matches the way CSS processes padding values:
     * 
     * *
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
    public void setPadding(String value) {
        JsoHelper.setAttribute(this.getJsObj(), "padding", value);
    }

}
