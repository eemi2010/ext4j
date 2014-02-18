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
package com.ait.ext4j.client.chart.axis;

import java.util.ArrayList;

import com.ait.ext4j.client.chart.laf.GridConfig;
import com.ait.ext4j.client.chart.laf.Label;
import com.ait.ext4j.client.core.JsObject;
import com.ait.ext4j.client.core.JsoHelper;
import com.ait.ext4j.client.core.config.Position;
import com.ait.ext4j.client.core.config.SpriteConfig;
import com.ait.ext4j.client.draw.Sprite;
import com.ait.ext4j.client.laf.Color;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;

/**
 * Base class for all axis classes.
 * 
 */
public abstract class AbstractAxis extends JsObject {

    public AbstractAxis() {

    }

    public AbstractAxis(JavaScriptObject obj) {
        super(obj);
    }

    /**
     * The title for the Axis
     * 
     * @param title
     */
    public void setTitle(String title) {
        JsoHelper.setAttribute(jsObj, "title", title);
    }

    /**
     * he size of the dash marker. Default's 3.
     * 
     * Defaults to: 3
     * 
     * @param title
     */
    public void setDashSize(int title) {
        JsoHelper.setAttribute(jsObj, "dashSize", title);
    }

    /**
     * The grid configuration enables you to set a background grid for an axis.
     * If set to true on a vertical axis, vertical lines will be drawn. If set
     * to true on a horizontal axis, horizontal lines will be drawn. If both are
     * set, a proper grid with horizontal and vertical lines will be drawn.
     * <p>
     * You can set specific options for the grid configuration for odd and/or
     * even lines/rows. Since the rows being drawn are rectangle sprites, you
     * can set to an odd or even property all styles that apply to
     * Ext.draw.Sprite. For more information on all the style properties you can
     * set please take a look at Ext.draw.Sprite. Some useful style properties
     * are opacity, fill, stroke, stroke-width, etc.
     * <p>
     * The possible values for a grid option are then true, false, or an object
     * with { odd, even } properties where each property contains a sprite style
     * descriptor object that is defined in {@link Sprite}.
     * 
     * @param value
     */
    public void setGrid(boolean value) {
        JsoHelper.setAttribute(jsObj, "grid", value);
    }

    /**
     * The grid configuration enables you to set a background grid for an axis.
     * If set to true on a vertical axis, vertical lines will be drawn. If set
     * to true on a horizontal axis, horizontal lines will be drawn. If both are
     * set, a proper grid with horizontal and vertical lines will be drawn.
     * <p>
     * You can set specific options for the grid configuration for odd and/or
     * even lines/rows. Since the rows being drawn are rectangle sprites, you
     * can set to an odd or even property all styles that apply to
     * Ext.draw.Sprite. For more information on all the style properties you can
     * set please take a look at Ext.draw.Sprite. Some useful style properties
     * are opacity, fill, stroke, stroke-width, etc.
     * <p>
     * The possible values for a grid option are then true, false, or an object
     * with { odd, even } properties where each property contains a sprite style
     * descriptor object that is defined in {@link Sprite}.
     * 
     * @param value
     */
    public void setGrid(GridConfig value) {
        JsoHelper.setAttribute(jsObj, "grid", value.getJsObj());
    }

    /**
     * The grid configuration enables you to set a background grid for an axis.
     * If set to true on a vertical axis, vertical lines will be drawn. If set
     * to true on a horizontal axis, horizontal lines will be drawn. If both are
     * set, a proper grid with horizontal and vertical lines will be drawn.
     * <p>
     * You can set specific options for the grid configuration for odd and/or
     * even lines/rows. Since the rows being drawn are rectangle sprites, you
     * can set to an odd or even property all styles that apply to
     * Ext.draw.Sprite. For more information on all the style properties you can
     * set please take a look at Ext.draw.Sprite. Some useful style properties
     * are opacity, fill, stroke, stroke-width, etc.
     * <p>
     * The possible values for a grid option are then true, false, or an object
     * with { odd, even } properties where each property contains a sprite style
     * descriptor object that is defined in {@link Sprite}.
     * 
     * @param addStroke
     */
    public void setGrid(String oddStroke) {
        SpriteConfig odd = new SpriteConfig();
        odd.setFill(oddStroke);
        setGrid(new GridConfig(odd));
    }

    /**
     * The grid configuration enables you to set a background grid for an axis.
     * If set to true on a vertical axis, vertical lines will be drawn. If set
     * to true on a horizontal axis, horizontal lines will be drawn. If both are
     * set, a proper grid with horizontal and vertical lines will be drawn.
     * <p>
     * You can set specific options for the grid configuration for odd and/or
     * even lines/rows. Since the rows being drawn are rectangle sprites, you
     * can set to an odd or even property all styles that apply to
     * Ext.draw.Sprite. For more information on all the style properties you can
     * set please take a look at Ext.draw.Sprite. Some useful style properties
     * are opacity, fill, stroke, stroke-width, etc.
     * <p>
     * The possible values for a grid option are then true, false, or an object
     * with { odd, even } properties where each property contains a sprite style
     * descriptor object that is defined in {@link Sprite}.
     * 
     * @param oddStroke
     * @param evenStroke
     */
    public void setGrid(String oddStroke, String evenStroke) {
        SpriteConfig odd = new SpriteConfig();
        odd.setFill(oddStroke);

        SpriteConfig even = new SpriteConfig();
        even.setFill(evenStroke);
        setGrid(new GridConfig(odd, even));
    }

    public void setGrid(Color oddStroke, Color eventStroke) {
        setGrid(oddStroke.getValue(), eventStroke.getValue());
    }

    /**
     * 
     * @param value
     */
    public void setAxis(String value) {
        JsoHelper.setAttribute(jsObj, "axis", value);
    }

    /**
     * If minimum and maximum are specified it forces the number of major ticks
     * to the specified value. If a number of major ticks is forced, it wont
     * search for pretty numbers at the ticks
     * 
     * @param value
     */
    public void setMajorTickSteps(double value) {
        JsoHelper.setAttribute(jsObj, "majorTickSteps", value);
    }

    /**
     * The number of small ticks between two major ticks. Default is zero.
     * 
     * @param value
     */
    public void setMinorTickSteps(double value) {
        JsoHelper.setAttribute(jsObj, "minorTickSteps", value);
    }

    /**
     * Offset axis position. Default's 0.
     * 
     * Defaults to: 0
     * 
     * @param value
     */
    public void setLength(double value) {
        JsoHelper.setAttribute(jsObj, "length", value);
    }

    protected void setType(String type) {
        JsoHelper.setAttribute(jsObj, "type", type);
    }

    /**
     * Where to set the axis. Available options are left, bottom, right, top.
     * Default's bottom.
     * 
     * Defaults to: "bottom"
     * 
     * @param position
     */
    public void setPosition(Position position) {
        setPosition(position.getValue());
    }

    /**
     * The fields of model to bind to this axis.
     * 
     * For example if you have a data set of lap times per car, each having the
     * fields: 'carName', 'avgSpeed', 'maxSpeed'. Then you might want to show
     * the data on chart with ['carName'] on Name axis and ['avgSpeed',
     * 'maxSpeed'] on Speed axis.
     * 
     * @param fields
     */
    public void setFields(ArrayList<String> fields) {
        JsArrayString array = JsArrayString.createArray().cast();
        for (String string : fields) {
            array.push(string);
        }
        JsoHelper.setAttribute(jsObj, "fields", array);
    }

    /**
     * The fields of model to bind to this axis.
     * 
     * For example if you have a data set of lap times per car, each having the
     * fields: 'carName', 'avgSpeed', 'maxSpeed'. Then you might want to show
     * the data on chart with ['carName'] on Name axis and ['avgSpeed',
     * 'maxSpeed'] on Speed axis.
     * 
     * @param fields
     */
    public void setFields(String... fields) {
        JsArrayString array = JsArrayString.createArray().cast();
        for (String string : fields) {
            array.push(string);
        }
        JsoHelper.setAttribute(jsObj, "fields", array);
    }

    /**
     * The config for chart label.
     * 
     * @param label
     */
    public void setLabel(Label label) {
        JsoHelper.setAttribute(jsObj, "label", label.getJsObj());
    }

    /**
     * Offset axis width. Default's 0.
     * 
     * Defaults to: 0
     * 
     * @param label
     */
    public void setWidth(double value) {
        JsoHelper.setAttribute(jsObj, "width", value);
    }

    public void setPosition(String value) {
        JsoHelper.setAttribute(jsObj, "position", value);
    }

    public static AbstractAxis create(JavaScriptObject obj) {
        return new AbstractAxis(obj) {
        };
    }
}
