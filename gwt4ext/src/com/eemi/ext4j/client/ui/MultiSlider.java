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
package com.eemi.ext4j.client.ui;

import java.util.List;

import com.eemi.ext4j.client.core.Component;
import com.eemi.ext4j.client.core.config.XType;
import com.eemi.ext4j.client.events.HandlerRegistration;
import com.eemi.ext4j.client.events.slider.BeforeChangeHandler;
import com.eemi.ext4j.client.events.slider.ChangeCompleteHandler;
import com.eemi.ext4j.client.events.slider.ChangeHandler;
import com.eemi.ext4j.client.events.slider.DragEndHandler;
import com.eemi.ext4j.client.events.slider.DragStartHandler;
import com.eemi.ext4j.client.events.slider.SliderBeforeChangeHandler;
import com.eemi.ext4j.client.field.FieldBase;
import com.eemi.ext4j.client.slider.SliderTip;
import com.eemi.ext4j.client.slider.Thumb;
import com.eemi.ext4j.client.slider.TipTextRenderer;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayNumber;

/**
 * Slider which supports vertical or horizontal orientation, keyboard
 * adjustments, configurable snapping, axis clicking and animation. Can be added
 * as an item to any container.
 * <p>
 * Sliders can be created with more than one thumb handle by passing an array of
 * values instead of a single one
 * 
 */
public class MultiSlider extends FieldBase {

    private static JavaScriptObject configPrototype;

    private native void init()/*-{
		var c = new $wnd.Ext.slider.Multi();
		@com.eemi.ext4j.client.ui.MultiSlider::configPrototype = c.initialConfig;
    }-*/;

    public MultiSlider() {
        // init();
    }

    protected MultiSlider(JavaScriptObject obj) {
        super(obj);
    }

    protected JavaScriptObject getConfigPrototype() {
        return configPrototype;
    }

    public String getXType() {
        return XType.MULTI_SLIDER.getValue();
    }

    @Override
    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.slider.Multi(config);
    }-*/;

    /**
     * 
     Turn on or off animation.
     * <p>
     * Defaults to: true
     */
    public void setAnimate(boolean value) {
        setAttribute("animate", value, true);
    }

    /**
     * Determines whether or not clicking on the Slider axis will change the
     * slider.
     * <p>
     * Defaults to: true
     */
    public void setClickToChange(boolean value) {
        setAttribute("clickToChange", value, true);
    }

    /**
     * 
     * The CSS class to apply to the selected element
     * <p>
     * Defaults to: "x-color-picker-selected"
     */
    public void setConstrainThumbs(boolean value) {
        setAttribute("contstrainThumbs", value, true);
    }

    /**
     * The number of decimal places to which to round the Slider's value.
     * <p>
     * To disable rounding, configure as false.
     * <p>
     * Defaults to: 0
     */
    public void setDecimalPrecision(boolean value) {
        setAttribute("decimalPrecision", value, true);
    }

    /**
     * The number of decimal places to which to round the Slider's value.
     * <p>
     * To disable rounding, configure as false.
     * <p>
     * Defaults to: 0
     */
    public void setDecimalPrecision(int value) {
        setAttribute("decimalPrecision", value, true);
    }

    /**
     * How many units to change the slider when adjusting by drag and drop. Use
     * this option to enable 'snapping'.
     * <p>
     * Defaults to: 0
     */
    public void setIncrement(int value) {
        setAttribute("increment", value, true);
    }

    /**
     * How many units to change the Slider when adjusting with keyboard
     * navigation. If the increment config is larger, it will be used instead.
     * <p>
     * Defaults to: 1
     */
    public void setKeyIncrement(int value) {
        setAttribute("keyIncrement", value, true);
    }

    /**
     * The maximum value for the Slider.
     * <p>
     * Defaults to: 100
     */
    public void setMaxValue(int value) {
        setAttribute("maxValue", value, true);
    }

    /**
     * The minimum value for the Slider.
     * <p>
     * Defaults to: 0
     */
    public void setMinValue(int value) {
        setAttribute("minValue", value, true);
    }

    /**
     * A function used to display custom text for the slider tip.
     */
    public void setTipText(TipTextRenderer renderer) {
        setAttribute("tipText", _getTipText(renderer), true);
    }

    /**
     * True to use an Ext.slider.Tip to display tips for the value. This option
     * may also provide a configuration object for an Ext.slider.Tip.
     * 
     * Defaults to: true
     */
    public void setUseTips(boolean value) {
        setAttribute("useTips", value, true);
    }

    /**
     * True to use an Ext.slider.Tip to display tips for the value. This option
     * may also provide a configuration object for an Ext.slider.Tip.
     * 
     * Defaults to: true
     */
    public void setUseTips(SliderTip value) {
        setAttribute("useTips", value.getOrCreateJsObj(), true);
    }

    /**
     * A value with which to initialize the slider. Setting this will only
     * result in the creation of a single slider thumb; if you want multiple
     * thumbs then use the values config instead.
     * <p>
     * Defaults to minValue.
     */
    public void setValue(double value) {
        setAttribute("value", value, true);
    }

    /**
     * Array of Number values with which to initalize the slider. A separate
     * slider thumb will be created for each value in this array. This will take
     * precedence over the single value config.
     */
    public void setValues(JsArrayNumber values) {
        setAttribute("values", values, true);
    }

    /**
     * Array of Number values with which to initalize the slider. A separate
     * slider thumb will be created for each value in this array. This will take
     * precedence over the single value config.
     */
    public void setValues(double... values) {
        JsArrayNumber peers = JsArray.createArray().cast();
        for (double d : values) {
            peers.push(d);
        }
        setAttribute("values", peers, true);
    }

    /**
     * Orient the Slider vertically rather than horizontally.
     * <p>
     * Defaults to: false
     */
    public void setVertical(boolean values) {
        setAttribute("vertical", values, true);
    }

    /**
     * Set to true to calculate snap points based on increments from zero as
     * opposed to from this Slider's minValue.
     * <p>
     * By Default, valid snap points are calculated starting increments from the
     * minValue
     * <p>
     * Defaults to: false
     */
    public void setZeroBaseSnapping(boolean values) {
        setAttribute("zeroBasedSnapping", values, true);
    }

    /**
     * True while the thumb is in a drag operation
     * <p>
     * Defaults to: false
     */
    public native boolean isDragging()/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		return commponent.draggging;
    }-*/;

    /**
     * Array containing references to each thumb
     * <p>
     * Defaults to: []
     */
    public List<Thumb> getThumbs() {
        return Thumb.fromJsArray(_getThumbs());
    }

    private native JavaScriptObject _getThumbs()/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		return commponent.thumbs;
    }-*/;

    /**
     * Creates a new thumb and adds it to the slider
     */
    public native void addThumb()/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		if (component) {
			components.addThumb();
		}
    }-*/;

    /**
     * Returns an array of values - one for the location of each thumb
     */
    public native JsArrayNumber getValues()/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		if (component) {
			components.getValues();
		}
    }-*/;

    /**
     * Programmatically sets the value of the Slider. Ensures that the value is
     * constrained within the minValue and maxValue.
     */
    public native void setValue(int index, double value)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		if (component) {
			components.setValue(index, value);
		}
    }-*/;

    /**
     * Programmatically sets the value of the Slider. Ensures that the value is
     * constrained within the minValue and maxValue.
     */
    public native void setValue(int index, double value, boolean animate)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		if (component) {
			components.setValue(index, value, animate);
		}
    }-*/;

    /**
     * Fires after a drag operation has started.
     * 
     * @param handler
     *            , the handler that will handle the event
     */
    public native HandlerRegistration addDragStartHandler(DragStartHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(slider, e) {
			var component = @com.eemi.ext4j.client.ui.MultiSlider::new(Lcom/google/gwt/core/client/JavaScriptObject;)(slider);
			var event = @com.eemi.ext4j.client.events.slider.DragStartEvent::new(Lcom/eemi/ext4j/client/ui/MultiSlider;Lcom/google/gwt/core/client/JavaScriptObject;)(component, e);
			handler.@com.eemi.ext4j.client.events.slider.DragStartHandler::onDragStart(Lcom/eemi/ext4j/client/events/slider/DragStartEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.slider.DragStartEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * Fires after a drag operation has ended.
     * 
     * @param handler
     *            , the handler that will handle the event
     */
    public native HandlerRegistration addDragEndHandler(DragEndHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(slider, e) {
			var component = @com.eemi.ext4j.client.ui.MultiSlider::new(Lcom/google/gwt/core/client/JavaScriptObject;)(slider);
			var event = @com.eemi.ext4j.client.events.slider.DragEndEvent::new(Lcom/eemi/ext4j/client/ui/MultiSlider;Lcom/google/gwt/core/client/JavaScriptObject;)(component, e);
			handler.@com.eemi.ext4j.client.events.slider.DragEndHandler::onDragEnd(Lcom/eemi/ext4j/client/events/slider/DragEndEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.slider.DragEndEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * Fires continuously during the drag operation while the mouse is moving.
     * 
     * @param handler
     *            , the handler that will handle the event
     */

    public native HandlerRegistration addDragHandler(com.eemi.ext4j.client.events.slider.DragHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(slider, e) {
			var component = @com.eemi.ext4j.client.ui.MultiSlider::new(Lcom/google/gwt/core/client/JavaScriptObject;)(slider);
			var event = @com.eemi.ext4j.client.events.slider.DragEvent::new(Lcom/eemi/ext4j/client/ui/MultiSlider;Lcom/google/gwt/core/client/JavaScriptObject;)(component, e);
			handler.@com.eemi.ext4j.client.events.slider.DragHandler::onDrag(Lcom/eemi/ext4j/client/events/slider/DragEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.slider.DragEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * Fires when the slider value is changed.
     * 
     * @param handler
     *            , the handler that will handle the event
     */
    public native HandlerRegistration addChangeHandler(ChangeHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(slider, newValue, t, e) {
			var component = @com.eemi.ext4j.client.ui.MultiSlider::new(Lcom/google/gwt/core/client/JavaScriptObject;)(slider);
			var thumb = @com.eemi.ext4j.client.slider.Thumb::new(Lcom/google/gwt/core/client/JavaScriptObject;)(t);
			var event = @com.eemi.ext4j.client.events.slider.ChangeEvent::new(Lcom/eemi/ext4j/client/ui/MultiSlider;DLcom/eemi/ext4j/client/slider/Thumb;Lcom/google/gwt/core/client/JavaScriptObject;)(compolent,thumb,newValue,e);
			handler.@com.eemi.ext4j.client.events.slider.ChangeHandler::onChange(Lcom/eemi/ext4j/client/events/slider/ChangeEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.slider.ChangeEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * Fires when the slider value is changed by the user and any drag
     * operations have completed.
     * 
     * @param handler
     *            , the handler that will handle the event
     */
    public native HandlerRegistration addChangeHandler(ChangeCompleteHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(slider, newValue, t, e) {
			var component = @com.eemi.ext4j.client.ui.MultiSlider::new(Lcom/google/gwt/core/client/JavaScriptObject;)(slider);
			var thumb = @com.eemi.ext4j.client.slider.Thumb::new(Lcom/google/gwt/core/client/JavaScriptObject;)(t);
			var event = @com.eemi.ext4j.client.events.slider.ChangeCompleteEvent::new(Lcom/eemi/ext4j/client/ui/MultiSlider;DLcom/eemi/ext4j/client/slider/Thumb;Lcom/google/gwt/core/client/JavaScriptObject;)(compolent,thumb,newValue,e);
			handler.@com.eemi.ext4j.client.events.slider.ChangeCompleteHandler::onChangeComplete(Lcom/eemi/ext4j/client/events/slider/ChangeCompleteEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.slider.ChangeCompleteEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * Fires before the slider value is changed. By returning false from an
     * event handler, you can cancel the event and prevent the slider from
     * changing.
     * 
     * @param handler
     *            , the handler that will handle the event
     */
    public native void addBeforeChangeHandler(SliderBeforeChangeHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		if (component) {
			component
					.addListener(
							@com.eemi.ext4j.client.events.Event::BEFORE_CHANGE,
							$entry(function(m, newValue, oldValue) {
								var mutil = @com.eemi.ext4j.client.ui.MultiSlider::new(Lcom/google/gwt/core/client/JavaScriptObject;)(m);
								return handler.@com.eemi.ext4j.client.events.slider.SliderBeforeChangeHandler::onEvent(Lcom/eemi/ext4j/client/ui/MultiSlider;DD)(multi, oldValue, newValue);
							}));
		}

    }-*/;

    /**
     * Fires before the slider value is changed.
     * 
     * @param handler
     *            , the handler that will handle the event
     */
    public native HandlerRegistration addBeforeChangeHandler(BeforeChangeHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(slider, oldValue, newValue, e) {
			var component = @com.eemi.ext4j.client.ui.MultiSlider::new(Lcom/google/gwt/core/client/JavaScriptObject;)(slider);
			var event = @com.eemi.ext4j.client.events.slider.BeforeChangeEvent::new(Lcom/eemi/ext4j/client/ui/MultiSlider;DDLcom/google/gwt/core/client/JavaScriptObject;)(component,oldValue,newValue,e);
			handler.@com.eemi.ext4j.client.events.slider.BeforeChangeHandler::onBeforeChange(Lcom/eemi/ext4j/client/events/slider/BeforeChangeEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.slider.BeforeChangeEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;

    }-*/;

    /**
     * Creates a new MultiSlider from the given component
     * 
     * @param component
     *            , the component to cast from
     * @return, a new MultiSlider from the component
     * 
     */
    public static MultiSlider cast(Component component) {
        return new MultiSlider(component.getOrCreateJsObj());
    }

    /**
     * Selects the specified color in the picker
     * 
     * @param value
     */
    private native JavaScriptObject _getTipText(TipTextRenderer renderer)/*-{
		return function(t) {
			var thumb = @com.eemi.ext4j.client.slider.Thumb::new(Lcom/google/gwt/core/client/JavaScriptObject;)(t);
			return renderer.@com.eemi.ext4j.client.slider.TipTextRenderer::getValue(Lcom/eemi/ext4j/client/slider/Thumb;)(thumb);
		};
    }-*/;

}
