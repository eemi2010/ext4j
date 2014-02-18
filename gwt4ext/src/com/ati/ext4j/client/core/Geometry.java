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
 * This class represents the geometry of an element.
 */
public class Geometry {

    private double height;
    private double width;
    private double x;
    private double y;

    public Geometry() {
    }

    /**
     * Create a new instance.
     * 
     * @param width
     *            element width
     * @param height
     *            element height
     */
    public Geometry(double width, double height, double x, double y) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;

    }

    public static Geometry instance(JavaScriptObject jsObj) {
        return new Geometry(JsoHelper.getAttributeAsFloat(jsObj, "width"), JsoHelper.getAttributeAsFloat(jsObj,
                        "height"), JsoHelper.getAttributeAsFloat(jsObj, "x"), JsoHelper.getAttributeAsFloat(jsObj, "y"));
    }

    /**
     * @return the height
     */
    public double getHeight() {
        return height;
    }

    /**
     * @param height
     *            the height to set
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
     *            the width to set
     */
    public void setWidth(double width) {
        this.width = width;
    }

    /**
     * @return the x
     */
    public double getX() {
        return x;
    }

    /**
     * @param x
     *            the x to set
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public double getY() {
        return y;
    }

    /**
     * @param y
     *            the y to set
     */
    public void setY(double y) {
        this.y = y;
    }

}
