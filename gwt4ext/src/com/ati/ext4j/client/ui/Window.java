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
import com.ati.ext4j.client.core.ExtElement;
import com.ati.ext4j.client.core.Function;
import com.ati.ext4j.client.core.config.XType;
import com.ati.ext4j.client.events.HandlerRegistration;
import com.ati.ext4j.client.events.window.MaximizeHandler;
import com.ati.ext4j.client.events.window.MinimizeHandler;
import com.ati.ext4j.client.events.window.ResizeHandler;
import com.ati.ext4j.client.events.window.RestoreHandler;
import com.ati.ext4j.client.layout.ContainerLayout;
import com.ati.ext4j.client.layout.Layout;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;

/**
 * A specialized panel intended for use as an application window. Windows are
 * floated, resizable, and draggable by default. Windows can be maximized to
 * fill the viewport, restored to their prior size, and can be minimized.
 * <p>
 * Windows can also be linked to a Ext.ZIndexManager or managed by the
 * Ext.WindowManager to provide grouping, activation, to front, to back and
 * other application-specific behavior.
 * <p>
 * By default, Windows will be rendered to document.body. To constrain a Window
 * to another element specify renderTo.
 */
public class Window extends Panel {

    private static JavaScriptObject configPrototype;

    private native void init()/*-{
		var c = new $wnd.Ext.window.Window();
		@com.ati.ext4j.client.ui.Panel::configPrototype = c.initialConfig;
    }-*/;

    protected JavaScriptObject getConfigPrototype() {
        return configPrototype;
    }

    public String getXType() {
        return XType.WINDOW.getValue();
    }

    /**
     * Create a new Window.
     */
    public Window() {
        // init();
    }

    public Window(ContainerLayout layout) {
        setLayout(layout);
    }

    public Window(Layout layout) {
        setLayout(layout);
    }

    /**
     * Construct a new Window with the given title.
     * 
     * @param title
     *            the title
     */
    public Window(String title) {
        setTitle(title);
    }

    /**
     * Construct a new Window with the given title and layout
     * 
     * @param title
     *            the title
     * @param layout
     *            the layout
     */
    public Window(String title, ContainerLayout layout) {
        this(title);
        setLayout(layout);
    }

    /**
     * Construct a new Window with the given title and layout
     * 
     * @param title
     *            the title
     * @param layout
     *            the layout
     */
    public Window(String title, Layout layout) {
        this(title);
        setLayout(layout);
    }

    protected Window(JavaScriptObject jsObj) {
        super(jsObj);
    }

    /**
     * Applys the NotificationContainer to an existing element.
     * 
     * @param element
     *            the element
     */
    public Window(Element element) {
        super(element);
    }

    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.window.Window(config);
    }-*/;

    /**
     * shows the window
     */
    public native void show() /*-{
		var window = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		window.show();
    }-*/;

    /**
     * Fits the window within its current container and automatically replaces
     * the 'maximize' tool button with the 'restore' tool button
     * 
     * @return
     */
    public native Window maximize() /*-{
		var window = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		window.maximize();
		return this;
    }-*/;

    /**
     * Placeholder method for minimizing the window. By default, this method
     * simply fires the minimize event since the behavior of minimizing a window
     * is application-specific. To implement custom minimize behavior, either
     * the minimize event can be handled or this method can be overridden
     * 
     * @return
     */
    public native Window minimize() /*-{
		var window = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		window.minimize();
		return this;
    }-*/;

    /**
     * Restores a maximized window back to its original size and position prior
     * to being maximized and also replaces the 'restore' tool button with the
     * 'maximize' tool button
     * 
     * @return
     */
    public native Window restore() /*-{
		var window = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		window.restore();
		return this;
    }-*/;

    /**
     * A shortcut method for toggling between maximize and restore based on the
     * current maximized state of the window.
     * 
     * @return
     */
    public native Window toggleMaximize() /*-{
		var window = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		window.toggleMaximize();
		return this;
    }-*/;

    /**
     * True to make the window modal and mask everything behind it when
     * displayed, false to display it without restricting access to other UI
     * elements.
     * <p>
     * Defaults to: false
     * 
     * @param value
     */
    public void setModal(boolean value) {
        setAttribute("modal", value, true);
    }

    /**
     * True to constrain the window header within its containing element
     * (allowing the window body to fall outside of its containing element) or
     * false to allow the header to fall outside its containing element.
     * Optionally the entire window can be constrained using constrain.
     * <p>
     * Defaults to: false
     */
    public void setConstrainHeader(boolean value) {
        setAttribute("constrainHeader", value, true);
    }

    /**
     * Specifies a Component to receive focus when this Window is focused.
     */
    public void setDefaultFocus(String value) {
        setAttribute("defaultFocus", value, true);
    }

    /**
     * Specifies a Component to receive focus when this Window is focused.
     */
    public void setDefaultFocus(int value) {
        setAttribute("defaultFocus", value, true);
    }

    /**
     * Specifies a Component to receive focus when this Window is focused.
     */
    public void setDefaultFocus(Component value) {
        setAttribute("defaultFocus", value.getOrCreateJsObj(), true);
    }

    /**
     * True to always expand the window when it is displayed, false to keep it
     * in its current state (which may be collapsed) when displayed.
     * <p>
     * Defaults to: true
     */
    public void setExpandOnShow(boolean value) {
        setAttribute("expandOnShow", value, true);
    }

    /**
     * id of the component from which the window should animate while opening.
     * <p>
     * Defaults to: null
     */
    public void setAnimateTarget(String target) {
        setAttribute("animateTarget", target, true);
    }

    /**
     * Element from which the window should animate while opening.
     * <p>
     * Defaults to: null
     */
    public void setAnimateTarget(ExtElement target) {
        setAttribute("animateTarget", target.getJsObj(), true, true);
    }

    /**
     * Component from which the window should animate while opening.
     * <p>
     * Defaults to: null
     */
    public void setAnimateTarget(Component component) {
        setAnimateTarget(component.getEl());
    }

    /**
     * True to display the 'maximize' tool button and allow the user to maximize
     * the window, false to hide the button and disallow maximizing the window.
     * Note that when a window is maximized, the tool button will automatically
     * change to a 'restore' button with the appropriate behavior already
     * built-in that will restore the window to its previous size.
     * <p>
     * Defaults to: false
     */
    public void setMaximizable(boolean value) {
        setAttribute("maximizable", value, true);
    }

    /**
     * True to initially display the window in a maximized state.
     * <p>
     * Defaults to: false
     */
    public void setMaximized(boolean value) {
        setAttribute("maximized", value, true);
    }

    /**
     * True to display the 'minimize' tool button and allow the user to minimize
     * the window, false to hide the button and disallow minimizing the window.
     * Note that this button provides no implementation -- the behavior of
     * minimizing a window is implementation-specific, so the minimize event
     * must be handled and a custom minimize behavior implemented for this
     * option to be useful.
     * <p>
     * Defaults to: false
     */
    public void setMinimizable(boolean value) {
        setAttribute("minimizable", value, true);
    }

    /**
     * Allows override of the built-in processing for the escape key. Default
     * action is to close the Window (performing whatever action is specified in
     * closeAction. To prevent the Window closing when the escape key is
     * pressed, specify this as Ext.emptyFn.
     */
    public void setOnEsc(Function fn) {
        setAttribute("onEsc", createEscFunction(fn), true);
    }

    /**
     * True to render the window body with a transparent background so that it
     * will blend into the framing elements, false to add a lighter background
     * color to visually highlight the body element and separate it more
     * distinctly from the surrounding frame.
     * <p>
     * Defaults to: false
     */
    public void setPlain(boolean value) {
        setAttribute("plain", value, true);
    }

    /**
     * Fires after the window has been maximized.
     */
    public native HandlerRegistration addMaximizeHandler(MaximizeHandler handler)/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(w, e) {
			var win = @com.ati.ext4j.client.ui.Window::new(Lcom/google/gwt/core/client/JavaScriptObject;)(w);
			var event = @com.ati.ext4j.client.events.window.MaximizeEvent::new(Lcom/ati/ext4j/client/ui/Window;Lcom/google/gwt/core/client/JavaScriptObject;)(win,e);
			handler.@com.ati.ext4j.client.events.window.MaximizeHandler::onMaximize(Lcom/ati/ext4j/client/events/window/MaximizeEvent;)(event);
		};
		var eventName = @com.ati.ext4j.client.events.window.MaximizeEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ati.ext4j.client.events.HandlerRegistration::new(Lcom/ati/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;

    }-*/;

    /**
     * Fires after the window has been minimized.
     */
    public native HandlerRegistration addMinimizeHandler(MinimizeHandler handler)/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(w, e) {
			var win = @com.ati.ext4j.client.ui.Window::new(Lcom/google/gwt/core/client/JavaScriptObject;)(w);
			var event = @com.ati.ext4j.client.events.window.MinimizeEvent::new(Lcom/ati/ext4j/client/ui/Window;Lcom/google/gwt/core/client/JavaScriptObject;)(win,e);
			handler.@com.ati.ext4j.client.events.window.MinimizeHandler::onMinimize(Lcom/ati/ext4j/client/events/window/MinimizeEvent;)(event);
		};
		var eventName = @com.ati.ext4j.client.events.window.MinimizeEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ati.ext4j.client.events.HandlerRegistration::new(Lcom/ati/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * Fires after the window has been restored to its original size after being
     * maximized.
     */
    public native HandlerRegistration addRestoreHandler(RestoreHandler handler)/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(w, e) {
			var win = @com.ati.ext4j.client.ui.Window::new(Lcom/google/gwt/core/client/JavaScriptObject;)(w);
			var event = @com.ati.ext4j.client.events.window.RestoreEvent::new(Lcom/ati/ext4j/client/ui/Window;Lcom/google/gwt/core/client/JavaScriptObject;)(win,e);
			handler.@com.ati.ext4j.client.events.window.RestoreHandler::onRestore(Lcom/ati/ext4j/client/events/window/RestoreEvent;)(event);
		};
		var eventName = @com.ati.ext4j.client.events.window.RestoreEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ati.ext4j.client.events.HandlerRegistration::new(Lcom/ati/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * Fires after the window has been resized.
     */
    public native HandlerRegistration addResizeHandler(ResizeHandler handler)/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, w, h, e) {
			var win = @com.ati.ext4j.client.ui.Window::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var event = @com.ati.ext4j.client.events.window.ResizeEvent::new(Lcom/ati/ext4j/client/ui/Window;DDLcom/google/gwt/core/client/JavaScriptObject;)(c,w, h, e);
			handler.@com.ati.ext4j.client.events.window.ResizeHandler::onResize(Lcom/ati/ext4j/client/events/window/ResizeEvent;)(event);
		};
		var eventName = @com.ati.ext4j.client.events.window.ResizeEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ati.ext4j.client.events.HandlerRegistration::new(Lcom/ati/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    public static Window cast(Component component) {
        return new Window(component.getOrCreateJsObj());
    }

    private native JavaScriptObject createEscFunction(Function fn)/*-{
		return function() {
			fn.@com.ati.ext4j.client.core.Function::execute()();
		};
    }-*/;

}
