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
package com.ati.ext4j.client.core;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Class that represents the Paddings around an element.
 */
public class Paddings {

    private int top;
    private int left;
    private int right;
    private int bottom;

    /**
     * Create a new instance.
     * 
     * @param top
     *            the top padding
     * @param left
     *            the left padding
     * @param right
     *            the right padding
     * @param bottom
     *            the bottom padding
     */
    public Paddings(int top, int left, int right, int bottom) {
        this.top = top;
        this.left = left;
        this.right = right;
        this.bottom = bottom;
    }

    @SuppressWarnings("unused")
    private static Paddings instance(JavaScriptObject jsObj) {
        return new Paddings(JsoHelper.getIntArrayValue(jsObj, 0), JsoHelper.getIntArrayValue(jsObj, 1),
                        JsoHelper.getIntArrayValue(jsObj, 2), JsoHelper.getIntArrayValue(jsObj, 3));
    }

    /**
     * @return the top padding
     */
    public int getTop() {
        return top;
    }

    /**
     * @return the left padding
     */
    public int getLeft() {
        return left;
    }

    /**
     * @return the right padding
     */
    public int getRight() {
        return right;
    }

    /**
     * @return the bottom padding
     */
    public int getBottom() {
        return bottom;
    }

    /**
     * Return the paddings as a CSS style string.
     * 
     * @return padding as style String
     */
    public String getStyleString() {
        return "padding:" + top + "px " + right + "px " + bottom + "px " + left + "px;";
    }
}