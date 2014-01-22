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

import com.eemi.ext4j.client.core.Component;
import com.eemi.ext4j.client.core.Function;
import com.eemi.ext4j.client.core.config.XType;
import com.eemi.ext4j.client.events.HandlerRegistration;
import com.eemi.ext4j.client.events.button.ArrowClickHandler;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * A split button that provides a built-in dropdown arrow that can fire an event
 * separately from the default click event of the button. Typically this would
 * be used to display a dropdown menu that provides additional options to the
 * primary button action, but any custom handler can provide the arrowclick
 * implementation.
 * 
 */
public class SplitButton extends Button {

    private static JavaScriptObject configPrototype;

    private native void init()/*-{
		var c = new $wnd.Ext.button.Split();
		@com.eemi.ext4j.client.ui.SplitButton::configPrototype = c.initialConfig;
    }-*/;

    public SplitButton() {
        init();
    }

    protected SplitButton(JavaScriptObject obj) {
        super(obj);
    }

    public SplitButton(String text) {
        this();
        setText(text);
    }

    protected JavaScriptObject getConfigPrototype() {
        return configPrototype;
    }

    public String getXType() {
        return XType.SPLIT_BUTTON.getValue();
    }

    @Override
    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.button.Split(config);
    }-*/;

    /**
     * Sets this button's arrow click handler.
     * 
     * @param value
     */
    public native void setArrowHandler(Function callBack) /*-{
		var splitButton = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		splitButton.setArrowHandler(function() {
			callBack.@com.eemi.ext4j.client.core.Function::execute()()
		});
    }-*/;

    /**
     * Fires when this button's arrow is clicked.
     */
    public native HandlerRegistration addArrowClickHandler(ArrowClickHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(b, e) {
			var button = @com.eemi.ext4j.client.ui.SplitButton::new(Lcom/google/gwt/core/client/JavaScriptObject;)(b);
			var event = @com.eemi.ext4j.client.events.button.ArrowClickEvent::new(Lcom/eemi/ext4j/client/ui/SplitButton;Lcom/google/gwt/core/client/JavaScriptObject;)(button,e);
			handler.@com.eemi.ext4j.client.events.button.ArrowClickHandler::onArrowClick(Lcom/eemi/ext4j/client/events/button/ArrowClickEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.button.ArrowClickEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * Creates a new SplitButton from the given component
     * 
     * @param component
     *            , the component to cast from
     * @return, a new SplitButton from the component
     * 
     */
    public static SplitButton cast(Component component) {
        return new SplitButton(component.getOrCreateJsObj());
    }

}
