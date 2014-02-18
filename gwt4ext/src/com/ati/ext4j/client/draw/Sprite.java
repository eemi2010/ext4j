/**
 * Ext4j UI Library Copyright 2014, Alain Ekambi, and individual contributors as
 * indicated by the @authors tag. See the copyright.txt in the distribution for
 * a full listing of individual contributors.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.ati.ext4j.client.draw;

import com.ati.ext4j.client.core.JsObject;
import com.ati.ext4j.client.core.JsoHelper;
import com.ati.ext4j.client.core.config.SpriteConfig;
import com.ati.ext4j.client.dd.DragSource;
import com.ati.ext4j.client.laf.Color;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * A Sprite is an object rendered in a Drawing surface.
 */
public class Sprite extends JsObject {

    public Sprite() {
        jsObj = JsoHelper.createObject();
    }

    public Sprite(JavaScriptObject object) {
        super(object);
    }

    /**
     * True to make the sprite draggable.
     * 
     * @param value
     */
    public void setDraggable(boolean value) {
        JsoHelper.setAttribute(jsObj, "draggable", value);
    }

    public void setType(String type) {
        JsoHelper.setAttribute(jsObj, "type", type);
    }

    /**
     * Sets the fill color
     * 
     * @param fill
     *            , the fill color
     */
    public void setFill(String fill) {
        JsoHelper.setAttribute(jsObj, "fill", fill);
    }

    /**
     * Sets the fill color
     * 
     * @param fill
     *            , the fill color
     */
    public void setFill(Color fill) {
        setFill(fill.getValue());
    }

    /**
     * Sets the fill color
     * 
     * @param fill
     *            , the fill color
     */
    public void setFont(String fill) {
        JsoHelper.setAttribute(jsObj, "font", fill);
    }

    /**
     * The group that this sprite belongs to, or an array of groups. Only
     * relevant when added to a Surface.
     * 
     * @param value
     *            , the group value
     */
    public void setGroup(String value) {
        JsoHelper.setAttribute(jsObj, "group", value);
    }

    /**
     * The height of the rect or image sprite.
     * 
     * @param height
     */
    public void setHeight(double height) {
        JsoHelper.setAttribute(jsObj, "height", height);
    }

    /**
     * The opacity of the sprite. A number between 0 and 1.
     * 
     * @param value
     */
    public void setOpacity(double value) {
        JsoHelper.setAttribute(jsObj, "opacity", value);
    }

    /**
     * The path of the path sprite written in SVG-like path syntax.
     * 
     * @param value
     */
    public void setPath(String value) {
        JsoHelper.setAttribute(jsObj, "path", value);
    }

    /**
     * Sprite position along the x-axis.
     * 
     * @param x
     */
    public void setX(double x) {
        JsoHelper.setAttribute(jsObj, "x", x);
    }

    /**
     * Sprite position along the y-axis.
     * 
     * @param y
     */
    public void setY(double y) {
        JsoHelper.setAttribute(jsObj, "y", y);
    }

    /**
     * Sets the x and y position of the component
     * 
     * @param x
     *            , the x position
     * @param y
     *            , the y position
     */
    public void setXY(int x, int y) {
        setX(x);
        setY(y);
    }

    /**
     * Sets the size of this component
     * 
     * @param width
     *            , the width
     * @param height
     *            , the height
     */
    public void setSize(int width, int height) {
        setWidth(width);
        setHeight(height);
    }

    /**
     * The radius of the circle sprite. Or in case of rect sprite, the border
     * radius.
     * 
     * @param value
     */
    public void setRadius(double value) {
        JsoHelper.setAttribute(jsObj, "radius", value);
    }

    /**
     * The radius of the ellipse sprite along x-axis.
     * 
     * @param value
     */
    public void setRadiusX(double value) {
        JsoHelper.setAttribute(jsObj, "radiusX", value);
    }

    /**
     * The radius of the ellipse sprite along y-axis.
     * 
     * @param value
     */
    public void setRadiusY(double value) {
        JsoHelper.setAttribute(jsObj, "radiusY", value);
    }

    /**
     * Path to the image to show in image sprites.
     * 
     * @param value
     */
    public void SetSrc(String value) {
        JsoHelper.setAttribute(jsObj, "src", value);
    }

    /**
     * The stroke color.
     * 
     * @param value
     */
    public void setStroke(String value) {
        JsoHelper.setAttribute(jsObj, "stroke", value);
    }

    /**
     * The stroke color.
     * 
     * @param value
     */
    public void setStroke(Color color) {
        setStroke(color.getValue());
    }

    /**
     * The actual text to render in text sprites.
     * 
     * @param value
     */
    public void setText(String value) {
        JsoHelper.setAttribute(jsObj, "text", value);
    }

    /**
     * The width of the stroke.
     * 
     * @param value
     */
    public void setStrokeWidth(double value) {
        JsoHelper.setAttribute(jsObj, "'stroke-width'", value);
    }

    /**
     * The width of the rect or image sprite.
     * 
     * @param value
     */
    public void setWidth(double value) {
        JsoHelper.setAttribute(jsObj, "width", value);
    }

    /**
     * If this Sprite is configured draggable, this property will contain an
     * instance of Ext.dd.DragSource which handles dragging the Sprite.
     * <p>
     * The developer must provide implementations of the abstract methods of
     * {@link DragSource} in order to supply behaviour for each stage of the
     * drag/drop process. See draggable.
     * 
     * @return
     */
    public native DragSource getDragSource()/*-{
		var jso = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		var dd = jso.dd;
		return @com.ati.ext4j.client.dd.DragSource::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dd);
    }-*/;

    /**
     * Removes the sprite and clears all listeners.
     */
    public native void destroy()/*-{
		var jso = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		if (jso.destroy) {
			jso.destroy();
		}
    }-*/;

    /**
     * Hides the sprite.
     */
    public native void hide()/*-{
		var jso = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		if (jso.hide) {
			jso.hide();
		}
    }-*/;

    /**
     * Hides the sprite.
     * 
     * @param redraw
     *            , Flag to immediately draw the change.
     */
    public native void hide(boolean redraw)/*-{
		var jso = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		if (jso.hide) {
			jso.hide(redraw);
		}
    }-*/;

    /**
     * Redraws the sprite.
     */
    public native Sprite redraw()/*-{
		var jso = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		if (jso.redraw) {
			jso.redraw();
		}
		return this;
    }-*/;

    /**
     * Removes the sprite.
     * 
     * @return True if sprite was successfully removed. False when there was no
     *         surface to remove it from.
     */
    public native boolean remove()/*-{
		var jso = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		if (jso.remove) {
			return jso.remove();
		}
		return false;
    }-*/;

    /**
     * Shows the sprite.
     */
    public native Sprite show()/*-{
		var jso = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		if (jso.show) {
			jso.show();
		}
		return this;
    }-*/;

    /**
     * Shows the sprite.
     */
    public native Sprite show(boolean redraw)/*-{
		var jso = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		if (jso.show) {
			var obj = jso.show(redraw);
		}
		return this;
    }-*/;

    public void setAttributes(SpriteConfig config) {
        setAttributes(config.getJsObj());
    }

    public void setAttributes(SpriteConfig config, boolean update) {
        setAttributes(config.getJsObj(), update);
    }

    private native void setAttributes(JavaScriptObject value)/*-{
		var jso = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		jso.setAttributes(value);
    }-*/;

    private native void setAttributes(JavaScriptObject value, boolean update)/*-{
		var jso = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		jso.setAttributes(value, update);
    }-*/;

}
