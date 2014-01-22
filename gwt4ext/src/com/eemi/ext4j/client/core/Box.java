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
package com.eemi.ext4j.client.core;

import com.eemi.ext4j.client.core.config.AnimationConfig;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * This class represents an Element's Box.
 * 
 * @see com.eemi.ext4j.client.coreExtElement#setBox(Box)
 * @see com.eemi.ext4j.client.coreExtElement#setBox(Box, boolean, boolean)
 * @see com.eemi.ext4j.client.coreExtElement#setBox(Box, boolean,
 *      AnimationConfig)
 */
public class Box extends JsObject {

    private int x;
    private int y;
    private int width;
    private int height;

    /**
     * Constructor
     * 
     * @param x
     *            x-position
     * @param y
     *            y-position
     * @param width
     *            the box width
     * @param height
     *            the box height
     */
    public Box(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        jsObj = JsoHelper.createObject();
        JsoHelper.setAttribute(jsObj, "x", x);
        JsoHelper.setAttribute(jsObj, "y", y);
        JsoHelper.setAttribute(jsObj, "width", width);
        JsoHelper.setAttribute(jsObj, "height", height);
    }

    @SuppressWarnings("unused")
    private static Box instance(JavaScriptObject jsObj) {
        return new Box(JsoHelper.getAttributeAsInt(jsObj, "x"), JsoHelper.getAttributeAsInt(jsObj, "y"),
                        JsoHelper.getAttributeAsInt(jsObj, "width"), JsoHelper.getAttributeAsInt(jsObj, "height"));
    }

    /**
     * Get the x position value.
     * 
     * @return the x value
     */
    public int getX() {
        return x;
    }

    /**
     * Get the y position value.
     * 
     * @return the y position
     */
    public int getY() {
        return y;
    }

    /**
     * Get the box width.
     * 
     * @return the box width
     */
    public int getWidth() {
        return width;
    }

    /**
     * Get the box height.
     * 
     * @return the box height
     */
    public int getHeight() {
        return height;
    }
}
