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
package com.ati.ext4j.client.ui;

import com.ati.ext4j.client.core.Component;
import com.ati.ext4j.client.core.EventObject;
import com.ati.ext4j.client.core.ExtElement;
import com.ati.ext4j.client.events.HandlerRegistration;
import com.ati.ext4j.client.events.form.SpinDownHandler;
import com.ati.ext4j.client.events.form.SpinHandler;
import com.ati.ext4j.client.events.form.SpinUpHandler;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * A field with a pair of up/down spinner buttons. This class is not normally
 * instantiated directly, instead it is subclassed and the onSpinUp and
 * onSpinDown methods are implemented to handle when the buttons are clicked. A
 * good example of this is the Ext.form.field.Number field which uses the
 * spinner to increment and decrement the field's value by its step config
 * value.
 * 
 */
public class Spinner extends TriggerField {

    private static JavaScriptObject configPrototype;

    private static native void init()/*-{
		var c = new $wnd.Ext.form.field.Spinner();
		@com.ati.ext4j.client.ui.Spinner::configPrototype = c.initialConfig;
    }-*/;

    protected JavaScriptObject getConfigPrototype() {
        return configPrototype;
    }

    public String getXType() {
        return "spinner";
    }

    public Spinner() {
    }

    public Spinner(JavaScriptObject jsObj) {
        super(jsObj);
    }

    protected native JavaScriptObject create(JavaScriptObject config)/*-{
		return new $wnd.Ext.form.field.Spinner(config);
    }-*/;

    /**
     * Specifies whether the up and down arrow keys should trigger spinning up
     * and down. Defaults to true.
     * <p>
     * Defaults to: true
     */
    public void setKeyNavEnabled(boolean value) {
        setAttribute("keyNavEnabled", value, true);
    }

    /**
     * Specifies whether the mouse wheel should trigger spinning up and down
     * while the field has focus. Defaults to true.
     * <p>
     * Defaults to: true
     */
    public void setMouseWheelEnabled(boolean value) {
        setAttribute("mouseWheelEnabled", value, true);
    }

    /**
     * Specifies whether the up spinner button is enabled.
     * <p>
     * Defaults to: true
     */
    public native void setSpinUpEnabled(boolean value) /*-{
		var sp = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		sp.setSpinUpEnabled(value);
    }-*/;

    /**
     * Specifies whether the mouse wheel should trigger spinning up and down
     * while the field has focus. Defaults to true.
     * <p>
     * Defaults to: true
     */
    public native void setSpinDownEnabled(boolean value) /*-{
		var sp = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		sp.setSpinDownEnabled(value);
    }-*/;

    @Override
    protected void onTriggerClick(EventObject event) {

    }

    /**
     * The spinner down button element
     */
    public native ExtElement getSpinDownEl() /*-{
		var field = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var obj = field.spinDownEl;
		return @com.ati.ext4j.client.core.ExtElement::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
    }-*/;

    /**
     * The spinner up button element
     */
    public native ExtElement getSpinUpEl() /*-{
		var field = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var obj = field.spinUpEl;
		return @com.ati.ext4j.client.core.ExtElement::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
    }-*/;

    /**
     * Get the total width of the spinner button area.
     */
    public native double getTriggerWidth() /*-{
		var sp = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		return sp.getTriggerWidth();
    }-*/;

    /**
     * Triggers the spinner to step down; fires the spin and spindown events and
     * calls the onSpinDown method. Does nothing if the field is disabled or if
     * spinDownEnabled is false.
     */
    public native void spinDown() /*-{
		var sp = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		sp.spinDown();
    }-*/;

    /**
     * Triggers the spinner to step up; fires the spin and spinup events and
     * calls the onSpinUp method. Does nothing if the field is disabled or if
     * spinUpEnabled is false.
     */
    public native void spinUp() /*-{
		var sp = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		sp.spinUp();
    }-*/;

    /**
     * Fires when the spinner is made to spin up or down.
     */
    public native HandlerRegistration addSpinHandler(SpinHandler handler)/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(sp, direction, e) {
			var spinner = @com.ati.ext4j.client.ui.Spinner::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var event = @com.ati.ext4j.client.events.form.SpinEvent::new(Lcom/ati/ext4j/client/ui/Spinner;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(spinner, direction,e);
			handler.@com.ati.ext4j.client.events.form.SpinHandler::onSpin(Lcom/ati/ext4j/client/events/form/SpinEvent;)(event);
		};
		var eventName = @com.ati.ext4j.client.events.form.SpinEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ati.ext4j.client.events.HandlerRegistration::new(Lcom/ati/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * Fires when the spinner is made to spin down.
     */
    public native HandlerRegistration addSpinDownHandler(SpinDownHandler handler)/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(sp, e) {
			var spinner = @com.ati.ext4j.client.ui.Spinner::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var event = @com.ati.ext4j.client.events.form.SpinDownEvent::new(Lcom/ati/ext4j/client/ui/Spinner;Lcom/google/gwt/core/client/JavaScriptObject;)(spinner,e);
			handler.@com.ati.ext4j.client.events.form.SpinDownHandler::onSpinDown(Lcom/ati/ext4j/client/events/form/SpinDownEvent;)(event);
		};
		var eventName = @com.ati.ext4j.client.events.form.SpinDownEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ati.ext4j.client.events.HandlerRegistration::new(Lcom/ati/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * Fires when the spinner is made to spin up.
     */
    public native HandlerRegistration addSpinUpHandler(SpinUpHandler handler)/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(sp, e) {
			var spinner = @com.ati.ext4j.client.ui.Spinner::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var event = @com.ati.ext4j.client.events.form.SpinUpEvent::new(Lcom/ati/ext4j/client/ui/Spinner;Lcom/google/gwt/core/client/JavaScriptObject;)(spinner,e);
			handler.@com.ati.ext4j.client.events.form.SpinUpHandler::onSpinUp(Lcom/ati/ext4j/client/events/form/SpinUpEvent;)(event);
		};
		var eventName = @com.ati.ext4j.client.events.form.SpinUpEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ati.ext4j.client.events.HandlerRegistration::new(Lcom/ati/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    public static Spinner cast(Component component) {
        return new Spinner(component.getOrCreateJsObj());
    }

}
