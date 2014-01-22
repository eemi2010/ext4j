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

import com.google.gwt.core.client.JavaScriptObject;

/**
 * This class represents the size of an element.
 * 
 * @see ExtElement#getSize()
 */
public class Size {

    private double height;
    private double width;

    public Size() {
    }

    /**
     * Create a new instance.
     * 
     * @param width
     *            element width
     * @param height
     *            element height
     */
    public Size(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public static Size instance(JavaScriptObject jsObj) {
        return new Size(JsoHelper.getAttributeAsFloat(jsObj, "width"), JsoHelper.getAttributeAsFloat(jsObj, "height"));
    }

    /**
     * @return the height
     */
    public double getHeight() {
        return height;
    }

    /**
     * @param height
     *            the height
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * @return the width
     */
    public double getWidth() {
        return width;
    }

    /**
     * @param width
     *            the width
     */
    public void setWidth(double width) {
        this.width = width;
    }
}
