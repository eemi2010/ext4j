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
package com.eemi.ext4j.client.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.eemi.ext4j.client.core.config.ComponentConfig;
import com.eemi.ext4j.client.core.config.Dock;
import com.eemi.ext4j.client.core.handlers.AbstractHandler;
import com.eemi.ext4j.client.dd.DragDropConfig;
import com.eemi.ext4j.client.events.Event;
import com.eemi.ext4j.client.events.HandlerRegistration;
import com.eemi.ext4j.client.events.component.ActivateHandler;
import com.eemi.ext4j.client.events.component.AfterRenderHandler;
import com.eemi.ext4j.client.events.component.BeforeActivateHandler;
import com.eemi.ext4j.client.events.component.BeforeDeactivateHandler;
import com.eemi.ext4j.client.events.component.BeforeDestroyHandler;
import com.eemi.ext4j.client.events.component.BeforeHideHandler;
import com.eemi.ext4j.client.events.component.BeforeRenderHandler;
import com.eemi.ext4j.client.events.component.BeforeShowHandler;
import com.eemi.ext4j.client.events.component.BeforeStateRestoreHandler;
import com.eemi.ext4j.client.events.component.BeforeStateSaveHandler;
import com.eemi.ext4j.client.events.component.BlurHandler;
import com.eemi.ext4j.client.events.component.DeactivateHandler;
import com.eemi.ext4j.client.events.component.DestroyHandler;
import com.eemi.ext4j.client.events.component.DisableHandler;
import com.eemi.ext4j.client.events.component.EnableHandler;
import com.eemi.ext4j.client.events.component.EventHandler;
import com.eemi.ext4j.client.events.component.FocusHandler;
import com.eemi.ext4j.client.events.component.HideHandler;
import com.eemi.ext4j.client.events.component.LifeCycleHandler;
import com.eemi.ext4j.client.events.component.MoveHandler;
import com.eemi.ext4j.client.events.component.RemovedHandler;
import com.eemi.ext4j.client.events.component.RenderHandler;
import com.eemi.ext4j.client.events.component.ResizeHandler;
import com.eemi.ext4j.client.events.component.ShowHandler;
import com.eemi.ext4j.client.events.component.StateRestoreHandler;
import com.eemi.ext4j.client.events.component.StateSaveHandler;
import com.eemi.ext4j.client.events.component.VisualStateChangeHandler;
import com.eemi.ext4j.client.fx.anim.Animation;
import com.eemi.ext4j.client.grid.plugin.AbstractPlugin;
import com.eemi.ext4j.client.ui.ComponentFactory;
import com.eemi.ext4j.client.ui.Container;
import com.eemi.ext4j.client.ui.LoadMask;
import com.eemi.ext4j.client.ui.MessageBox;
import com.eemi.ext4j.client.util.Region;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayNumber;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * <p>
 * Base class for all Ext components. All subclasses of Component may
 * participate in the automated Ext component lifecycle of creation, rendering
 * and destruction which is provided by the Container class. Components may be
 * added to a Container through the items config option at the time the
 * Container is created, or they may be added dynamically via the add method.
 * </p>
 * 
 * <p>
 * The Component base class has built-in support for basic hide/show and
 * enable/disable behavior.
 * </p>
 */

public abstract class Component extends AbstractComponent implements Observable {

	private static JavaScriptObject configPrototype;
	@SuppressWarnings("rawtypes")
	private Map configListeners = new HashMap();

	protected String id;

	protected JavaScriptObject config;
	private boolean initHidden = false;
	private boolean initDisabled = false;
	private static final String POST_RENDER = "post-render";

	private boolean isElementSet = false;

	protected native JavaScriptObject cloneConfig(JavaScriptObject config)/*-{
		var clone = {};
		var id = "ext4j-" + $wnd.Ext.id();
		var cfg = $wnd.Ext.applyIf(clone, config);
		cfg.id = id; // prevent dup id
		return clone;
	}-*/;

	/**
	 * Create a new Component.
	 */
	public Component() {

		id = "ext4j" + Ext.generateId();
		initConfig();
		if (config == null) {
			config = JsoHelper.createObject();
		}
		JsoHelper.setAttribute(config, "__compJ", this);
		JsoHelper.setAttribute(config, "id", id);
		JsoHelper.setAttribute(config, "xtype", getXType());
		onConfigCreated();
		makeObservable(config);
	}

	/**
	 * Component Constructor. Applies the Component to an existing element.
	 * 
	 * @param element
	 *            the Element to apply the Component to
	 */
	public Component(Element element) {
		id = DomUtil.getID(element);
		if (id == null) {
			id = Ext.generateId();
			DomUtil.setID(element, id);
		}
		config = JsoHelper.createObject();
		setId(id);
		setApplyTo(element);
		getOrCreateJsObj();
	}

	public Component(JavaScriptObject jsObj) {
		id = JsoHelper.getAttribute(jsObj, "id");
		config = jsObj;
		setElement(getElement(jsObj));
	}

	public Component(ComponentConfig config) {
		this(config.getJsObj());
	}

	/**
	 * Creates a Component object reference for an already rendered Component.
	 * 
	 * @param id
	 *            the Component ID
	 */
	public Component(String id) {
		setElement(getElement(getComponentJS(id)));
	}

	// @SuppressWarnings("rawtypes")
	private void doInitComponent() {
		// doClear();
		/**
		 * for (Iterator iterator = configListeners.keySet().iterator();
		 * iterator.hasNext();) { String event = (String) iterator.next(); List
		 * listeners = (List) configListeners.get(event); for (int i = 0; i <
		 * listeners.size(); i++) { JavaScriptObject listener =
		 * (JavaScriptObject) listeners.get(i); addListener(event, listener); }
		 * } configListeners.clear();
		 */

		initComponent();
		addListener("render", new Function() {
			public void execute() {

			}
		});

	}

	/**
	 * This template method is called after the Component has been instantiated
	 * but before it's rendered. Subclasses can override it to provide any
	 * "constructor" type logic thats desired/
	 */
	protected void initComponent() {
		addEvent(POST_RENDER);
	}

	private native void doClear() /*-{
		var config = this.@com.eemi.ext4j.client.core.Component::config;
		config['__compJ'] = null;
	}-*/;

	private native void makeObservable(JavaScriptObject config) /*-{
		if (config.listeners == null || config.listeners === undefined) {
			//config.listeners = new $wnd.Array();
			config.listeners = new Object();
		}
	}-*/;

	public JavaScriptObject getJsObj() {
		JavaScriptObject jsObj = getComponentJS(id);
		return jsObj;
	}

	// create only, dont render
	public JavaScriptObject getOrCreateJsObj() {
		JavaScriptObject jsObj = getComponentJS(id);
		if (jsObj != null) {
			return jsObj;
		} else {
			// create object here
			return create(config);
		}
	}

	protected static native JavaScriptObject getComponentJS(String id)/*-{
		var cmp = $wnd.Ext.ComponentMgr.get(id);
		return (cmp === undefined || cmp == null) ? null : cmp;
	}-*/;

	protected void addListener(String event, JavaScriptObject fn) {
		if (!isCreated()) {
			addConfigListener(event, fn);
		} else {
			addWidgetListener(event, fn);
		}
	}

	protected native void addWidgetListener(String event, JavaScriptObject fn) /*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		component.addListener(event, fn);
	}-*/;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void addConfigListener(String event, JavaScriptObject fn) {
		List listeners = (List) configListeners.get(event);
		if (listeners == null)
			listeners = new ArrayList();
		listeners.add(fn);
		configListeners.put(event, listeners);
	}

	public JavaScriptObject getConfig() {
		return config;
	}

	/**
	 * The HTML fragment or an array of fragments that will make up the template
	 * used by this DataView.
	 * 
	 */
	public void setTpl(String value) {
		setAttribute("tpl", value, true);
	}

	/**
	 * The HTML fragment or an array of fragments that will make up the template
	 * used by this DataView.
	 * 
	 */
	public void setTpl(Template tpl) {
		setAttribute("tpl", tpl.getJsObj(), true);
	}

	/**
	 * This config is intended mainly for non-floating Components which may or
	 * may not be shown. Instead of using renderTo in the configuration, and
	 * rendering upon construction, this allows a Component to render itself
	 * upon first show. If floating is true, the value of this config is omitted
	 * as if it is true.
	 * <p>
	 * Specify as true to have this Component render to the document body upon
	 * first show.
	 * 
	 * @param value
	 */
	public void setAutoRender(boolean value) {
		setAttribute("autoRender", value, true);
	}

	/**
	 * This config is intended mainly for non-floating Components which may or
	 * may not be shown. Instead of using renderTo in the configuration, and
	 * rendering upon construction, this allows a Component to render itself
	 * upon first show. If floating is true, the value of this config is omitted
	 * as if it is true.
	 * <p>
	 * Specify as true to have this Component render to the document body upon
	 * first show.
	 * 
	 * @param value
	 */
	public void setAutoRender(String value) {
		setAttribute("autoRender", value, true);
	}

	/**
	 * This config is intended mainly for non-floating Components which may or
	 * may not be shown. Instead of using renderTo in the configuration, and
	 * rendering upon construction, this allows a Component to render itself
	 * upon first show. If floating is true, the value of this config is omitted
	 * as if it is true.
	 * <p>
	 * Specify as true to have this Component render to the document body upon
	 * first show.
	 * 
	 * @param value
	 */
	public void setAutoRender(Element value) {
		setAttribute("autoRender", value, true);
	}

	/**
	 * This config is intended mainly for non-floating Components which may or
	 * may not be shown. Instead of using renderTo in the configuration, and
	 * rendering upon construction, this allows a Component to render itself
	 * upon first show. If floating is true, the value of this config is omitted
	 * as if it is true.
	 * <p>
	 * Specify as true to have this Component render to the document body upon
	 * first show.
	 * 
	 * @param value
	 */
	public void setAutoRender(ExtElement value) {
		setAttribute("autoRender", value.getJsObj(), true);
	}

	/**
	 * The HTML fragment or an array of fragments that will make up the template
	 * used by this DataView.
	 * 
	 */
	public void setTpl(JsArrayString tpl) {
		setAttribute("tpl", tpl, true);
	}

	protected abstract JavaScriptObject getConfigPrototype();

	private void initConfig() {
		config = cloneConfig(getConfigPrototype());
		JsoHelper.setAttribute(config, "xtype", getXType());
	}

	protected native Element getElement(JavaScriptObject jsObj) /*-{
		//var el = jsObj.el;
		var extEl = jsObj.getEl();
		if (extEl == null || extEl === undefined) {
			return null;
		}
		var el = extEl.dom;
		if (el == null || el === undefined) {
			return null;
			//forms buttons are detached when initially added
			//throw new Error('Widget ' + jsObj + ' has no element property set');
		} else {
			return el.dom || el;
		}
	}-*/;

	protected abstract JavaScriptObject create(JavaScriptObject config);

	public com.google.gwt.user.client.Element getElement() {
		return getElement(true);
	}

	protected void setElement(com.google.gwt.user.client.Element elem) {
		super.setElement(elem);
		isElementSet = true;
	}

	public com.google.gwt.user.client.Element getElement(boolean allowPreRender) {
		if (!isElementSet) {
			JavaScriptObject jsObj = getComponentJS(id);
			if (!isRendered()) {
				if (!allowPreRender) {
					error("This method should only be called after the component has been rendered");
				}

				if (jsObj == null) {
					jsObj = create(config);
				}
				if (getParent() != null && getParent().getElement() != null) {
					render(getParent().getElement());
				} else {
					render(RootPanel.getBodyElement());
				}
			}
			setElement(getElement(jsObj));
		}
		return super.getElement();
	}

	/**
	 * Allow the component to fire these events.
	 * 
	 * @param events
	 *            the events
	 */
	public void addEvents(String... events) {
		for (int i = 0; i < events.length; i++) {
			String event = events[i];
			addEvent(event);
		}
	}

	/**
	 * Allow the component to fire this event.
	 * 
	 * @param event
	 *            the event
	 */
	public native void addEvent(String event) /*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		component.addEvents(event);
	}-*/;

	/**
	 * Fires the specified event.
	 * 
	 * @param event
	 *            the event
	 */
	public native void fireEvent(String event) /*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		component.fireEvent(event);
	}-*/;

	/**
	 * Removes all listeners for this Component.
	 */
	public native void purgeListeners() /*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		component.purgeListeners();
	}-*/;

	/**
	 * Resume firing events.
	 * 
	 * @see #suspendEvents()
	 */
	public native void resumeEvents() /*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		component.resumeEvents();
	}-*/;

	/**
	 * Relays selected events from the specified Observable as if the events
	 * were fired by this.
	 * 
	 * @param observable
	 * @param events
	 */
	public void relayEvents(Component observable, String... events) {
		JsArrayString values = JsArrayString.createArray().cast();
		for (String s : events) {
			values.push(s);
		}
		relayEvents(observable, values);
	}

	/**
	 * Relays selected events from the specified Observable as if the events
	 * were fired by this.
	 * 
	 * @param observable
	 * @param events
	 */
	public native void relayEvents(Component observable, JsArrayString events) /*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		component
				.relayEvents(
						observable.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()(),
						events);
	}-*/;

	/**
	 * Relays selected events from the specified Observable as if the events
	 * were fired by this.
	 * 
	 * @param observable
	 * @param events
	 */
	public void relayEvents(JsObject observable, String... events) {
		JsArrayString values = JsArrayString.createArray().cast();
		for (String s : events) {
			values.push(s);
		}
		relayEvents(observable, values);
	}

	/**
	 * Relays selected events from the specified Observable as if the events
	 * were fired by this.
	 * 
	 * @param observable
	 * @param events
	 */
	public native void relayEvents(JsObject observable, JsArrayString events) /*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		component.relayEvents(
				observable.@com.eemi.ext4j.client.core.JsObject::getJsObj()(),
				events);
	}-*/;

	/**
	 * Suspend the firing of all events.
	 * 
	 * @see #resumeEvents()
	 */
	public native void suspendEvents() /*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		component.suspendEvents();
	}-*/;

	/**
	 * Brings this floating Component to the front of any other visible,
	 * floating Components managed by the same ZIndexManager
	 * 
	 * If this Component is modal, inserts the modal mask just below this
	 * Component in the z-index stack.
	 */
	public native Component toFront() /*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		component.toFront();
		return this;
	}-*/;

	/**
	 * Saves the state of the object to the persistence store.
	 */
	public native void saveState() /*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		component.saveState();
	}-*/;

	/**
	 * Brings this floating Component to the front of any other visible,
	 * floating Components managed by the same ZIndexManager
	 * 
	 * If this Component is modal, inserts the modal mask just below this
	 * Component in the z-index stack.
	 * 
	 * @param preventFocus
	 *            , Specify true to prevent the Component from being focused.
	 */
	public native Component toFront(boolean preventFocus) /*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		component.toFront(preventFocus);
		return this;
	}-*/;

	/**
	 * Sends this Component to the back of (lower z-index than) any other
	 * visible windows
	 * 
	 */
	public native Component toBack() /*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		component.toBack();
		return this;
	}-*/;

	/**
	 * True if this component is disabled.
	 * 
	 * @return true if disabled
	 */
	public boolean isDisabled() {
		if (!isRendered()) {
			return initDisabled;
		} else {
			return isDisabledRendered();
		}
	}

	private native boolean isDisabledRendered() /*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		return component == null ? false : component.disabled;
	}-*/;

	/**
	 * @return true if the component is hidden
	 */
	public boolean isHidden() {
		if (!isRendered()) {
			return initHidden;
		} else {
			return isHiddenRendered();
		}
	}

	private native boolean isHiddenRendered() /*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		return component == null ? false : component.hidden;
	}-*/;

	public native boolean isMaximized() /*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		return component == null ? false : component.maximized;
	}-*/;

	/**
	 * The component's owner Ext.Container (defaults to undefined, and is set
	 * automatically when the component is added to a container). <br>
	 * <b>Note:</b> This method should be called only after the component has
	 * been rendered.
	 * 
	 * @return the owner container
	 */
	public native Container getOwnerContainer() /*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		if (component == null)
			return null;
		var ct = component.ownerCt;
		return ct == null || ct === undefined ? null
				: @com.eemi.ext4j.client.ui.Container::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(ct);
	}-*/;

	/**
	 * @return true if the underlying widget object has been created
	 */
	public boolean isCreated() {
		// JavaScriptObject jsObj = getComponentJS(id);
		return doIsCreated(id);
	}

	private static native boolean doIsCreated(String id)/*-{
		var cmp = $wnd.Ext.ComponentMgr.get(id);
		return cmp == null || cmp === undefined ? false : true;
	}-*/;

	/**
	 * @return true if component has been rendered
	 */
	public native boolean isRendered() /*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getJsObj()();
		return component != null && component.rendered;
	}-*/;

	/**
	 * Adds a CSS class to the component's underlying element.
	 * 
	 * @param cls
	 *            the CSS class
	 */
	public void addCls(String cls) {
		if (!isCreated()) {
			setCls(getCls() == null ? cls : getCls() + " " + cls);
		} else {
			addClsCreated(cls);
		}
	}

	public native void addClsCreated(String cls) /*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		component.addCls(cls);
	}-*/;

	/**
	 * Clone the current component using the original config values passed into
	 * this instance by default.
	 * 
	 * @return the cloned copy of this component
	 */
	public Component cloneComponent() {
		JavaScriptObject clone = doClone(null);
		return ComponentFactory.getComponent(clone);
	}

	/**
	 * Clone the current component using the original config values passed into
	 * this instance by default.
	 * 
	 * @param overrides
	 *            when cloning
	 * @return the cloned copy of this component
	 */
	public Component cloneComponent(Component overrides) {
		JavaScriptObject clone = doClone(overrides.getConfig());
		return ComponentFactory.getComponent(clone);
	}

	private native JavaScriptObject doClone(JavaScriptObject config) /*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		return component.cloneConfig(config);
	}-*/;

	/**
	 * Destroys this component by purging any event listeners, removing the
	 * component's element from the DOM, removing the component from its
	 * {@link Container} (if applicable) and unregistering it from
	 * {@link ComponentManager}. Destruction is generally handled automatically
	 * by the framework and this method should usually not need to be called
	 * directly.
	 */
	public native void destroy() /*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getJsObj()();
		if (component != null)
			component.destroy();
	}-*/;

	/**
	 * Disable this component.
	 */
	public void disable() {
		if (!isRendered()) {
			initDisabled = true;
			setAttribute("disabled", true, true);
			addListener("render", new Function() {
				public void execute() {
					disableRendered();
				}
			});
		} else {
			disableRendered();
		}
	}

	private native void disableRendered() /*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		component.disable();
	}-*/;

	/**
	 * Enable this component.
	 */
	public void enable() {
		if (!isRendered()) {
			setAttribute("disabled", false, true);
			addListener("render", new Function() {
				public void execute() {
					enableRendered();
				}
			});
		} else {
			enableRendered();
		}
	}

	private native void enableRendered() /*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		component.enable();
	}-*/;

	/**
	 * Find a container above this component at any level by a custom function.
	 * If the passed function returns true, the container will be returned.
	 * 
	 * @param cb
	 *            the ContainerTraversalCallback
	 * @return the Container or null if none found
	 */
	public native Container findParentBy(ContainerTraversalCallback cb)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var componentJ = this;
		var container = component
				.findParentBy(function(container) {
					var containerJ = @com.eemi.ext4j.client.ui.ComponentFactory::getComponent(Lcom/google/gwt/core/client/JavaScriptObject;)(container);
					return cb.@com.eemi.ext4j.client.core.ContainerTraversalCallback::execute(Lcom/eemi/ext4j/client/ui/Container;)(containerJ);
				});
		return container == null || container === undefined ? null
				: @com.eemi.ext4j.client.ui.ComponentFactory::getComponent(Lcom/google/gwt/core/client/JavaScriptObject;)(container);
	}-*/;

	/**
	 * Find a container above this component at any level by xtype.
	 * 
	 * @param xtype
	 *            the container xtype
	 * @return the container or null if not found
	 */
	public native Container findParentByType(String xtype) /*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var container = component.findParentByType(xtype);
		return container == null || container === undefined ? null
				: @com.eemi.ext4j.client.ui.ComponentFactory::getComponent(Lcom/google/gwt/core/client/JavaScriptObject;)(container);
	}-*/;

	/**
	 * Try to focus this component.
	 */
	public void focus() {
		if (!isRendered()) {
			addListener("render", new Function() {
				public void execute() {
					Scheduler.get().scheduleDeferred(new ScheduledCommand() {
						@Override
						public void execute() {
							focusRendered();
						}
					});
				}
			});
		} else {
			focusRendered();
		}
	}

	private native void focusRendered() /*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getJsObj()();
		if (component != null)
			component.focus();
	}-*/;

	/**
	 * Try to focus this component.
	 * 
	 * @param selectText
	 *            True to also select the text in this component (if applicable)
	 */
	public native void focus(boolean selectText) /*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getJsObj()();
		if (component != null)
			component.focus(selectText);
	}-*/;

	/**
	 * Try to focus this component.
	 * 
	 * @param selectText
	 *            True to also select the text in this component (if applicable)
	 * @param delay
	 *            delay the focus this number of milliseconds
	 */
	public native void focus(boolean selectText, int delay) /*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getJsObj()();
		if (component != null)
			component.focus(selectText, delay);
	}-*/;

	/**
	 * Try to focus this component.
	 * 
	 * @param selectText
	 *            True to also select the text in this component (if applicable)
	 * @param defaultDelay
	 *            true for 10 milliseconds delay
	 */
	public native void focus(boolean selectText, boolean defaultDelay) /*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getJsObj()();
		if (component != null)
			component.focus(selectText, defaultDelay);
	}-*/;

	public native ExtElement getEl() /*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var el = component.getEl();
		if (el == null || el === undefined) {
			return null;
		} else {
			return @com.eemi.ext4j.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(el);
		}
	}-*/;

	/**
	 * Returns the item id of this component.
	 * 
	 * @return the item ID
	 */
	public native String getItemId() /*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		return component.getItemId();
	}-*/;

	/**
	 * The default Ext.Element#getAlignToXY anchor position value for this menu
	 * relative to its element of origin. Used in conjunction with showBy.
	 * <p>
	 * Defaults to: "tl-bl?"
	 */
	public void setDefaultAlign(String value) {
		setAttribute("defaultAlign", value, true);
	}

	/**
	 * Aligns this element with another element relative to the specified anchor
	 * points. If the other element is the document it aligns it to the
	 * viewport.
	 * 
	 * @param element
	 */
	public native Component alignTo(String element)/*-{
		var elem = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		elem.alignTo(element);
		return this;
	}-*/;

	/**
	 * Aligns this element with another element relative to the specified anchor
	 * points. If the other element is the document it aligns it to the
	 * viewport.
	 * 
	 * @param element
	 */
	public native Component alignTo(String element, String position)/*-{
		var elem = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		elem.alignTo(element, position);
		return this;
	}-*/;

	/**
	 * Aligns this element with another element relative to the specified anchor
	 * points. If the other element is the document it aligns it to the
	 * viewport.
	 * 
	 * @param element
	 */

	public Component alignTo(String element, String position, double[] offsets) {
		JsArrayNumber numbers = JsArray.createArray().cast();
		for (double d : offsets) {
			numbers.push(d);
		}
		return _alignTo(element, position, numbers);
	}

	private native Component _alignTo(String element, String position,
			JsArrayNumber offsets)/*-{
		var elem = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		elem.alignTo(element, position, offsets);
		return this;
	}-*/;

	/**
	 * Aligns this element with another element relative to the specified anchor
	 * points. If the other element is the document it aligns it to the
	 * viewport.
	 * 
	 * @param element
	 */

	public Component alignTo(String element, String position, double[] offsets,
			boolean animate) {
		JsArrayNumber numbers = JsArray.createArray().cast();
		for (double d : offsets) {
			numbers.push(d);
		}
		return _alignTo(element, position, numbers, animate);
	}

	private native Component _alignTo(String element, String position,
			JsArrayNumber offsets, boolean animate)/*-{
		var elem = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		elem.alignTo(element, position, offsets, animate);
		return this;
	}-*/;

	/**
	 * Aligns this element with another element relative to the specified anchor
	 * points. If the other element is the document it aligns it to the
	 * viewport.
	 * 
	 * @param element
	 */
	public native Component alignTo(ExtElement element)/*-{
		var elem = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		elem
				.alignTo(element.@com.eemi.ext4j.client.core.JsObject::getJsObj()());
		return this;
	}-*/;

	/**
	 * Aligns this element with another element relative to the specified anchor
	 * points. If the other element is the document it aligns it to the
	 * viewport.
	 * 
	 * @param element
	 */
	public native Component alignTo(ExtElement element, String position)/*-{
		var elem = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		elem.alignTo(
				element.@com.eemi.ext4j.client.core.JsObject::getJsObj()(),
				position);
		return this;
	}-*/;

	/**
	 * Aligns this element with another element relative to the specified anchor
	 * points. If the other element is the document it aligns it to the
	 * viewport.
	 * 
	 * @param element
	 */

	public Component alignTo(ExtElement element, String position,
			double[] offsets) {
		JsArrayNumber numbers = JsArray.createArray().cast();
		for (double d : offsets) {
			numbers.push(d);
		}
		return _alignTo(element, position, numbers);
	}

	private native Component _alignTo(ExtElement element, String position,
			JsArrayNumber offsets)/*-{
		var elem = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		elem.alignTo(
				element.@com.eemi.ext4j.client.core.JsObject::getJsObj()(),
				position, offsets);
		return this;
	}-*/;

	/**
	 * Aligns this element with another element relative to the specified anchor
	 * points. If the other element is the document it aligns it to the
	 * viewport.
	 * 
	 * @param element
	 */

	public Component alignTo(ExtElement element, String position,
			double[] offsets, boolean animate) {
		JsArrayNumber numbers = JsArray.createArray().cast();
		for (double d : offsets) {
			numbers.push(d);
		}
		return _alignTo(element, position, numbers, animate);
	}

	public Component alignTo(ExtElement element, String position,
			double offsetX, double offsetY) {
		JsArrayNumber numbers = JsArray.createArray().cast();
		numbers.push(offsetX);
		numbers.push(offsetY);
		return _alignTo(element, position, numbers);
	}

	public Component alignTo(ExtElement element, String position, double offset) {
		return alignTo(element, position, offset, offset);
	}

	private native Component _alignTo(ExtElement element, String position,
			JsArrayNumber offsets, boolean animate)/*-{
		var elem = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		elem.alignTo(
				element.@com.eemi.ext4j.client.core.JsObject::getJsObj()(),
				position, offsets, animate);
		return this;
	}-*/;

	/**
	 * Aligns this element with another element relative to the specified anchor
	 * points. If the other element is the document it aligns it to the
	 * viewport.
	 * 
	 * @param element
	 */
	public native Component anchorTo(String element)/*-{
		var elem = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		elem.anchorTo(element);
		return this;
	}-*/;

	/**
	 * Aligns this element with another element relative to the specified anchor
	 * points. If the other element is the document it aligns it to the
	 * viewport.
	 * 
	 * @param element
	 */
	public native Component anchorTo(String element, String position)/*-{
		var elem = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		elem.anchorTo(element, position);
		return this;
	}-*/;

	/**
	 * Aligns this element with another element relative to the specified anchor
	 * points. If the other element is the document it aligns it to the
	 * viewport.
	 * 
	 * @param element
	 */

	public Component anchorTo(String element, String position, double[] offsets) {
		JsArrayNumber numbers = JsArray.createArray().cast();
		for (double d : offsets) {
			numbers.push(d);
		}
		return _anchorTo(element, position, numbers);
	}

	private native Component _anchorTo(String element, String position,
			JsArrayNumber offsets)/*-{
		var elem = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		elem.anchorTo(element, position, offsets);
		return this;
	}-*/;

	/**
	 * Aligns this element with another element relative to the specified anchor
	 * points. If the other element is the document it aligns it to the
	 * viewport.
	 * 
	 * @param element
	 */

	public Component anchorTo(String element, String position,
			double[] offsets, boolean animate) {
		JsArrayNumber numbers = JsArray.createArray().cast();
		for (double d : offsets) {
			numbers.push(d);
		}
		return _anchorTo(element, position, numbers, animate);
	}

	private native Component _anchorTo(String element, String position,
			JsArrayNumber offsets, boolean animate)/*-{
		var elem = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		elem.anchorTo(element, position, offsets, animate);
		return this;
	}-*/;

	/**
	 * Aligns this element with another element relative to the specified anchor
	 * points. If the other element is the document it aligns it to the
	 * viewport.
	 * 
	 * @param element
	 */
	public native Component anchorTo(ExtElement element)/*-{
		var elem = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		elem
				.anchorTo(element.@com.eemi.ext4j.client.core.JsObject::getJsObj()());
		return this;
	}-*/;

	/**
	 * Aligns this element with another element relative to the specified anchor
	 * points. If the other element is the document it aligns it to the
	 * viewport.
	 * 
	 * @param element
	 */
	public native Component anchorTo(ExtElement element, String position)/*-{
		var elem = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		elem.anchorTo(
				element.@com.eemi.ext4j.client.core.JsObject::getJsObj()(),
				position);
		return this;
	}-*/;

	/**
	 * Aligns this element with another element relative to the specified anchor
	 * points. If the other element is the document it aligns it to the
	 * viewport.
	 * 
	 * @param element
	 */

	public Component anchorTo(ExtElement element, String position,
			double[] offsets) {
		JsArrayNumber numbers = JsArray.createArray().cast();
		for (double d : offsets) {
			numbers.push(d);
		}
		return _anchorTo(element, position, numbers);
	}

	public Component anchorTo(ExtElement element, String position,
			double offsetX, double offsetY) {
		JsArrayNumber numbers = JsArray.createArray().cast();
		numbers.push(offsetX);
		numbers.push(offsetY);
		return _anchorTo(element, position, numbers);
	}

	public Component anchorTo(ExtElement element, String position, double offset) {
		return anchorTo(element, position, offset, offset);
	}

	private native Component _anchorTo(ExtElement element, String position,
			JsArrayNumber offsets)/*-{
		var elem = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		elem.anchorTo(
				element.@com.eemi.ext4j.client.core.JsObject::getJsObj()(),
				position, offsets);
		return this;
	}-*/;

	/**
	 * Aligns this element with another element relative to the specified anchor
	 * points. If the other element is the document it aligns it to the
	 * viewport.
	 * 
	 * @param element
	 */

	public Component anchorTo(ExtElement element, String position,
			double[] offsets, boolean animate) {
		JsArrayNumber numbers = JsArray.createArray().cast();
		for (double d : offsets) {
			numbers.push(d);
		}
		return _anchorTo(element, position, numbers, animate);
	}

	public Component anchorTo(ExtElement element, String position,
			double offsetX, double offsetY, boolean animate) {
		JsArrayNumber numbers = JsArray.createArray().cast();
		numbers.push(offsetX);
		numbers.push(offsetY);
		return _anchorTo(element, position, numbers, animate);
	}

	public Component anchorTo(ExtElement element, String position,
			double offset, boolean animate) {
		return anchorTo(element, position, offset, offset, animate);
	}

	private native Component _anchorTo(ExtElement element, String position,
			JsArrayNumber offsets, boolean animate)/*-{
		var elem = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		elem.anchorTo(
				element.@com.eemi.ext4j.client.core.JsObject::getJsObj()(),
				position, offsets, animate);
		return this;
	}-*/;

	/**
	 * Gets the xtype for this component as registered with ComponentManager.
	 * For a list of all available xtypes, see the Component javadocs.
	 * <p/>
	 * 
	 * <pre>
	 * <code>
	 * <p/>
	 * TextField field = new TextField();
	 * field.getXType() returns "textfield"
	 * </code>
	 * </pre>
	 * 
	 * @return the xtype
	 */
	public String getXType() {
		return "";
	}

	/**
	 * Returns this component's xtype hierarchy as a slash-delimited string. For
	 * a list of all available xtypes, see the Component class javadocs.
	 * <p/>
	 * 
	 * <pre>
	 * <code>
	 * <p/>
	 * TextField field = new TextField();
	 * field.getXTypes() returns "component/box/field/textfield"
	 * </code>
	 * </pre>
	 * 
	 * @return the xtype hierarchy string
	 */
	public native String getXTypes() /*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		return component.getXTypes();
	}-*/;

	/**
	 * Hide this component.
	 */
	public void hide() {
		if (!isRendered()) {
			initHidden = true;
			addListener("render", new Function() {
				public void execute() {
					hideRendered();
				}
			});
		} else {
			hideRendered();
		}
	}

	private native void hideRendered() /*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		component.hide();
	}-*/;

	public native void hide(String animateTarget) /*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		component.hide(animateTarget);
	}-*/;

	public native void hide(ExtElement animateTarget) /*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		component.hide(animateTarget
				.@com.eemi.ext4j.client.core.JsObject::getJsObj());
	}-*/;

	public native void hide(Component animateTarget) /*-{
		var component = this
				.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		component.hide(animateTarget
				.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj());
	}-*/;

	/**
	 * Returns true if this component is visible.
	 * 
	 * @return true if visible
	 */
	public native boolean isVisible() /*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getJsObj()();
		return component == null ? false : component.isVisible();
	}-*/;

	/**
	 * Tests whether or not this component is of a specific xtype. This can test
	 * whether this component is descended from the xtype (default) or whether
	 * it is directly of the xtype specified (shallow = true). For a list of all
	 * available xtypes, see the {@link Component} header. Example usage:
	 * <p/>
	 * 
	 * <pre>
	 * <code>
	 * <p/>
	 * <p/>
	 * TextField t = new TextField();
	 * boolean isText = t.isXType('textfield');        // true
	 * boolean isBoxSubclass = t.isXType('box');       // true, descended from BoxComponent
	 * boolean  isBoxInstance = t.isXType('box', true); // false, not a direct BoxComponent instance
	 * <p/>
	 * </code>
	 * </pre>
	 * 
	 * @param xtype
	 *            the xtype to check for this component
	 * @return true if is style
	 */
	public native boolean isXType(String xtype) /*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		return component.isXType(xtype);
	}-*/;

	/**
	 * Tests whether or not this component is of a specific xtype. This can test
	 * whether this component is descended from the xtype (default) or whether
	 * it is directly of the xtype specified (shallow = true). For a list of all
	 * available xtypes, see the {@link Component} header. Example usage:
	 * <p/>
	 * 
	 * <pre>
	 * <code>
	 * <p/>
	 * <p/>
	 * TextField t = new TextField();
	 * boolean isText = t.isXType('textfield');        // true
	 * boolean isBoxSubclass = t.isXType('box');       // true, descended from BoxComponent
	 * boolean  isBoxInstance = t.isXType('box', true); // false, not a direct BoxComponent instance
	 * <p/>
	 * </code>
	 * </pre>
	 * 
	 * @param xtype
	 *            the xtype to check for this component
	 * @param shallow
	 *            false to check whether this component is descended from the
	 *            xtype (this is the default), or true to check whether this
	 *            component is directly of the specified xtype.
	 * @return true if is style
	 */
	public native boolean isXType(String xtype, boolean shallow)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		return component.isXType(xtype, shallow);
	}-*/;

	/**
	 * 
	 * @return
	 */
	public native double getLocalX()/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		return component.getLocalX();
	}-*/;

	public native double getLocalY()/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		return component.getLocalY();
	}-*/;

	public native ComponentPosition getLocalXY()/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var obj = component.getLocalXY();
		return @com.eemi.ext4j.client.core.ComponentPosition::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
	}-*/;

	/**
	 * Returns the offsets of this element from the passed element. The element
	 * must both be part of the DOM tree and not have display:none to have page
	 * coordinates.
	 */
	public native ComponentPosition getOffsetsTo(String element)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var obj = component.getOffsetsTo(element);
		return @com.eemi.ext4j.client.core.ComponentPosition::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
	}-*/;

	/**
	 * Returns the offsets of this element from the passed element. The element
	 * must both be part of the DOM tree and not have display:none to have page
	 * coordinates.
	 */
	public native ComponentPosition getOffsetsTo(Element element)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var obj = component.getOffsetsTo(element);
		return @com.eemi.ext4j.client.core.ComponentPosition::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
	}-*/;

	/**
	 * Returns the offsets of this element from the passed element. The element
	 * must both be part of the DOM tree and not have display:none to have page
	 * coordinates.
	 */
	public ComponentPosition getOffsetsTo(Widget widget) {
		return this.getOffsetsTo(widget.getElement());
	}

	/**
	 * Removes a CSS class from the component's underlying element.
	 * 
	 * @param cls
	 *            the CSS class to remove
	 */
	public native void removeCls(String cls) /*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		component.removeCls(cls);
	}-*/;

	/**
	 * Convenience function for setting disabled/enabled by boolean.
	 * 
	 * @param disabled
	 *            true to disable
	 */
	public void setDisabled(boolean disabled) {
		if (disabled) {
			disable();
		} else {
			enable();
		}
	}

	/**
	 * Convenience function to hide or show this component by boolean.
	 * 
	 * @param visible
	 *            True to show, false to hide
	 */
	public void setVisible(boolean visible) {
		if (visible) {
			show();
		} else {
			hide();
		}
	}

	public void setAnchor(String value) {
		setAttribute("anchor", value, true);
	}

	public void setFormBind(boolean value) {
		setAttribute("formBind", value, true);
	}

	/**
	 * If this is a lazy rendering component, render it to its container
	 * element.
	 * 
	 * @param id
	 *            the element id
	 */
	public native void render(String id) /*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		component.render(id);
	}-*/;

	/**
	 * Sets the left and top of the component. To set the page XY position
	 * instead, use setPagePosition. This method fires the move event.
	 */
	public native void setPosition(double left, double top) /*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		component.setPosition(left, top);
	}-*/;

	/**
	 * Sets the left and top of the component. To set the page XY position
	 * instead, use setPagePosition. This method fires the move event.
	 */
	public native void setPosition(double left, double top, boolean animate) /*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		component.setPosition(left, top, animate);
	}-*/;

	/**
	 * Sets the left and top of the component. To set the page XY position
	 * instead, use setPagePosition. This method fires the move event.
	 */
	public native void setPosition(double left, double right,
			Animation animation) /*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		component
				.setPosition(
						left,
						right,
						animation.@com.eemi.ext4j.client.fx.anim.Animation::getJsObj()());
	}-*/;

	/**
	 * Sets the page XY position of the component. To set the left and top
	 * instead, use setPosition. This method fires the move event.
	 */
	public native void setPagePosition(double left, double right) /*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		component.setPagePosition(left, right);
	}-*/;

	/**
	 * Sets the page XY position of the component. To set the left and top
	 * instead, use setPosition. This method fires the move event.
	 */
	public native void setPagePosition(double left, double right,
			boolean animate) /*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		component.setPagePosition(left, right, animate);
	}-*/;

	/**
	 * Sets the page XY position of the component. To set the left and top
	 * instead, use setPosition. This method fires the move event.
	 */
	public native void setPagePosition(double left, double right,
			Animation animation) /*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		component
				.setPagePosition(
						left,
						right,
						animation.@com.eemi.ext4j.client.fx.anim.Animation::getJsObj()());
	}-*/;

	/**
	 * Gets the current XY position of the component's underlying element.
	 */
	public native ComponentPosition getPosition()/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var obj = component.getPosition();
		return @com.eemi.ext4j.client.core.ComponentPosition::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
	}-*/;

	/**
	 * Gets the current XY position of the component's underlying element. If
	 * true the element's left and top are returned instead of page XY.
	 */
	public native ComponentPosition getPosition(boolean local)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var obj = component.getPosition(local);
		return @com.eemi.ext4j.client.core.ComponentPosition::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
	}-*/;

	/**
	 * If this is a lazy rendering component, render it to its container
	 * element.
	 * 
	 * @param id
	 *            the element id
	 * @param position
	 *            the element ID within the container <b>before</b> which this
	 *            component will be inserted (defaults to appending to the end
	 *            of the container)
	 */
	public native void render(String id, String position) /*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		component.render(id, position);
	}-*/;

	/**
	 * If this is a lazy rendering component, render it to its container
	 * element.
	 * 
	 * @param id
	 *            the element id
	 * @param position
	 *            the DOM node index within the container <b>before</b> which
	 *            this component will be inserted (defaults to appending to the
	 *            end of the container)
	 */
	public native void render(String id, int position) /*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		component.render(id, position);
	}-*/;

	/**
	 * If this is a lazy rendering component, render it to its container
	 * element.
	 * 
	 * @param element
	 *            the element
	 */
	public native void render(Element element) /*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		component.render(element);
	}-*/;

	/**
	 * If this is a lazy rendering component, render it to its container
	 * element.
	 * 
	 * @param element
	 *            the element
	 * @param position
	 *            the element ID within the container <b>before</b> which this
	 *            component will be inserted (defaults to appending to the end
	 *            of the container)
	 */
	public native void render(Element element, String position) /*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		component.render(element);
	}-*/;

	/**
	 * If this is a lazy rendering component, render it to its container
	 * element.
	 * 
	 * @param element
	 *            the element
	 * @param position
	 *            the DOM node index within the container <b>before</b> which
	 *            this component will be inserted (defaults to appending to the
	 *            end of the container)
	 */
	public native void render(Element element, int position) /*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		component.render(element);
	}-*/;

	/**
	 * Show this component.
	 */
	public void show() {
		if (!isRendered()) {
			addListener("render", new Function() {
				public void execute() {
					showRendered();
				}
			});
		} else {
			showRendered();
		}
	}

	private native void showRendered() /*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		component.show();
	}-*/;

	public native void show(String animateTarget) /*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		component.show(animateTarget);
	}-*/;

	public native void show(ExtElement animateTarget) /*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		component.show(animateTarget
				.@com.eemi.ext4j.client.core.JsObject::getJsObj());
	}-*/;

	public native void show(Component animateTarget) /*-{
		var component = this
				.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		component.show(animateTarget
				.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj());
	}-*/;

	public native void showAt(double x, double y) /*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		component.showAt(x, y);
	}-*/;

	public native void showAt(double x, double y, boolean animate) /*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		component.showAt(x, y, animate);
	}-*/;

	public native void showAt(double x, double y, Animation animation) /*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		component.showAt(x, y, animation
				.@com.eemi.ext4j.client.core.JsObject::getJsObj());
	}-*/;

	public native void showAt(JavaScriptObject value) /*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		component.showAt(value);
	}-*/;

	public void showAt(Position position) {
		this.showAt(position.getX(), position.getY());
	}

	public void showAt(Position position, boolean animate) {
		this.showAt(position.getX(), position.getY(), animate);
	}

	public void showAt(Position position, Animation animation) {
		this.showAt(position.getX(), position.getY(), animation);
	}

	/**
	 * Add a raw event listener.
	 * 
	 * @param event
	 *            the event name
	 * @param fn
	 *            the function to execute
	 */
	public native void addListener(String event, Function fn)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		component.addListener(event, function() {
			fn.@com.eemi.ext4j.client.core.Function::execute()();
		});
	}-*/;

	/**
	 * he supplied default state gathering method for the AbstractComponent
	 * class.
	 * 
	 * This method returns dimension settings such as flex, anchor, width and
	 * height along with collapsed state.
	 * 
	 * Subclasses which implement more complex state should call the
	 * superclass's implementation, and apply their state to the result if this
	 * basic state is to be saved.
	 * 
	 * Note that Component state will only be saved if the Component has a
	 * stateId and there as a StateProvider configured for the document.
	 */
	public native JavaScriptObject getState()/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		return component.getState();
	}-*/;

	protected void check() throws IllegalStateException {
		if (isRendered()) {
			if (GWT.isScript()) {
				MessageBox
						.alert("Error",
								"Cannot change configuration property after the component has been rendered");
				throw new IllegalStateException(
						"Cannot change configuration property after the component has been rendered");
			}
		}
	}

	// --------------------- config properties --------------------------

	// public abstract String getXType();

	/**
	 * The id of the node, a DOM node or an existing Element corresponding to a
	 * DIV that is already present in the document that specifies some
	 * structural markup for this component. When applyTo is used, constituent
	 * parts of the component can also be specified by id or CSS class name
	 * within the main element, and the component being created may attempt to
	 * create its subcomponents from that markup if applicable. Using this
	 * config, a call to render() is not required. If applyTo is specified, any
	 * value passed for renderTo will be ignored and the target element's parent
	 * node will automatically be used as the component's container.
	 * 
	 * @param element
	 *            the ID of existing DIV
	 * @throws IllegalStateException
	 *             this property cannot be changed after the Component has been
	 *             rendered
	 */
	public void setApplyTo(Element element) throws IllegalStateException {
		setAttribute("applyTo", element, false);
	}

	/**
	 * @return the Element this component was applied to
	 */
	public Element getApplyTo() {
		return JsoHelper.getAttributeAsElement(config, "applyTo");
	}

	/**
	 * A tag name to create an element with. This is intended to create
	 * shorthand utility components. It should not be used for higher level
	 * components which already create their own elements.
	 * 
	 * @param autoEl
	 *            the tag name
	 */
	public void setAutoEl(String autoEl) {
		setAttribute("autoEl", autoEl, true);
	}

	/**
	 * A DomConfig specification to create an element with. This is intended to
	 * create shorthand utility components. It should not be used for higher
	 * level components which already create their own elements.
	 * 
	 * @param domConfig
	 *            the DomConfig specification
	 */
	public void setAutoEl(DomConfig domConfig) {
		setAttribute("autoEl", domConfig.getJsObject(), true);
	}

	/**
	 * true to automatically show the component upon creation. This config
	 * option may only be used for floating components or components that use
	 * autoRender.
	 * <p>
	 * Defaults to: false
	 */
	public void setAutoShow(boolean autoShow) throws IllegalStateException {
		setAttribute("autoShow", autoShow, true);
	}

	/**
	 * This config is intended mainly for non-floating Components which may or
	 * may not be shown. Instead of using renderTo in the configuration, and
	 * rendering upon construction, this allows a Component to render itself
	 * upon first show. If floating is true, the value of this config is omitted
	 * as if it is true.
	 * <p>
	 * Specify as true to have this Component render to the document body upon
	 * first show.
	 * <p>
	 * Specify as an element, or the ID of an element to have this Component
	 * render to a specific element upon first show.
	 * <p>
	 * Defaults to: false
	 */
	public void autoRender(boolean autoShow) throws IllegalStateException {
		setAttribute("autoRender", autoShow, true);
	}

	/**
	 * This config is intended mainly for non-floating Components which may or
	 * may not be shown. Instead of using renderTo in the configuration, and
	 * rendering upon construction, this allows a Component to render itself
	 * upon first show. If floating is true, the value of this config is omitted
	 * as if it is true.
	 * <p>
	 * Specify as true to have this Component render to the document body upon
	 * first show.
	 * <p>
	 * Specify as an element, or the ID of an element to have this Component
	 * render to a specific element upon first show.
	 * <p>
	 * Defaults to: false
	 */
	public void autoRender(String autoShow) throws IllegalStateException {
		setAttribute("autoRender", autoShow, true);
	}

	/**
	 * This config is intended mainly for non-floating Components which may or
	 * may not be shown. Instead of using renderTo in the configuration, and
	 * rendering upon construction, this allows a Component to render itself
	 * upon first show. If floating is true, the value of this config is omitted
	 * as if it is true.
	 * <p>
	 * Specify as true to have this Component render to the document body upon
	 * first show.
	 * <p>
	 * Specify as an element, or the ID of an element to have this Component
	 * render to a specific element upon first show.
	 * <p>
	 * Defaults to: false
	 */
	public void autoRender(ExtElement autoShow) throws IllegalStateException {
		setAttribute("autoRender", autoShow.getJsObj(), true);
	}

	/**
	 * The base CSS class to apply to this component's element. This will also
	 * be prepended to elements within this component like Panel's body will get
	 * a class x-panel-body. This means that if you create a subclass of Panel,
	 * and you want it to get all the Panels styling for the element and the
	 * body, you leave the baseCls x-panel and use componentCls to add specific
	 * styling for this component.
	 * 
	 * Defaults to: 'x-component'
	 */
	public void setBaseCls(String value) {
		setAttribute("baseCls", value, true);
	}

	/**
	 * @return true if auto show
	 */
	public boolean getAutoShow() {
		return getAttributeAsBoolean("autoShow");
	}

	/**
	 * An optional extra CSS class that will be added to this component's
	 * Element (defaults to ''). This can be useful for adding customized styles
	 * to the component or any of its children using standard CSS rules.
	 * 
	 * @param cls
	 *            the CSS class
	 */
	public void setCls(String cls) {
		if (isCreated()) {
			addCls(cls);
		} else {
			setAttribute("cls", cls, false);
		}
	}

	/**
	 * @return the extra CSS applied to the components Element
	 */
	public String getCls() {
		return getAttribute("cls");
	}

	/**
	 * An optional extra CSS class that will be added to this component's
	 * container (defaults to ''). This can be useful for adding customized
	 * styles to the container or any of its children using standard CSS rules.
	 * 
	 * @param ctCls
	 *            the container CSS class
	 * @throws IllegalStateException
	 *             this property cannot be changed after the Component has been
	 *             rendered
	 */
	public void setCtCls(String ctCls) throws IllegalStateException {
		setAttribute("ctCls", ctCls, true);
	}

	/**
	 * @return the extra CSS class applied to the components container.
	 */
	public String getCtCls() {
		return getAttribute("ctCls");
	}

	/**
	 * Defines the column width inside column layout.
	 * <p>
	 * Can be specified as a number or as a percentage.
	 */
	public void setColumnWidth(String value) throws IllegalStateException {
		setAttribute("columnWidth", value, true);
	}

	/**
	 * Defines the column width inside column layout.
	 * <p>
	 * Can be specified as a number or as a percentage.
	 */
	public void setColumnWidth(double value) throws IllegalStateException {
		setAttribute("columnWidth", value, true);
	}

	/**
	 * Defines the column width inside column layout.
	 */
	public void setComponentColumnWidth(double value)
			throws IllegalStateException {
		setAttribute("columnWidth", value, true);
	}

	/**
	 * True to constrain the window within its containing element, false to
	 * allow it to fall outside of its containing element. By default the window
	 * will be rendered to document.body. To render and constrain the window
	 * within another element specify renderTo. Optionally the header only can
	 * be constrained using constrainHeader.
	 * <p>
	 * Defaults to: false
	 */
	public void setConstrain(boolean value) {
		setAttribute("constrain", value, true);
	}

	/**
	 * An element which is used to constrain the window.
	 */
	public void setConstrainTo(ExtElement el) {
		setAttribute("constrainTo", el.getJsObj(), true);
	}

	/**
	 * A region which is used to constrain the window.
	 */
	public void setConstrainTo(Region el) {
		setAttribute("constrainTo", el.getJsObj(), true);
	}

	/**
	 * A region which is used to constrain the window.
	 */
	public void setConstraintInsets(String value) {
		setAttribute("constraintInsets", value, true);
	}

	/**
	 * 
	 * CSS Class to be added to a components root level element to give
	 * distinction to it via styling.
	 */
	public void setComponentCls(String value) throws IllegalStateException {
		setAttribute("componentCls", value, true);
	}

	/**
	 * CSS class added to the component when it is disabled (defaults to
	 * "x-item-disabled").
	 * 
	 * @param disabledClass
	 *            the disabled CSS class
	 */
	public void setDisabledClass(String disabledClass) {
		setAttribute("disabledClass", disabledClass, true);
	}

	/**
	 * @return the CSS class used when the component is disabled
	 */
	public String getDisabledClass() {
		return getAttribute("disabledClass");
	}

	/**
	 * Sets the underlying Element for the component.
	 * 
	 * @param el
	 *            the element
	 * @throws IllegalStateException
	 *             this property cannot be changed after the Component has been
	 *             rendered
	 */
	public void setEl(Element el) throws IllegalStateException {
		setAttribute("el", new ExtElement(el).getJsObj(), false);
	}

	public void setEl(String elementID) throws IllegalStateException {
		setAttribute("el", elementID, false);
	}

	/**
	 * How this component should hidden. Supported values are "visibility" (css
	 * visibility), "offsets" (negative offset position) and "display" (css
	 * display) - defaults to "display".
	 * 
	 * @param hideMode
	 *            the hide mode
	 */
	public void setHideMode(String hideMode) {
		setAttribute("hideMode", hideMode, true);
	}

	/**
	 * How this component should hidden. Supported values are "visibility" (css
	 * visibility), "offsets" (negative offset position) and "display" (css
	 * display) - defaults to "display".
	 * 
	 * @return the hide mode
	 */
	public String getHideMode() {
		return getAttribute("hideMode");
	}

	/**
	 * True to hide and show the component's container when hide/show is called
	 * on the component, false to hide and show the component itself (defaults
	 * to false). For example, this can be used as a shortcut for a hide button
	 * on a window by setting hide:true on the button when adding it to its
	 * parent container.
	 * 
	 * @param hideParent
	 *            true to hide and show the component's container when hide/show
	 *            is called on the component
	 * @throws IllegalStateException
	 *             this property cannot be changed after the Component has been
	 *             rendered
	 */
	public void setHideParent(boolean hideParent) throws IllegalStateException {
		setAttribute("hideParent", hideParent, true);
	}

	/**
	 * @return true if hideParent enabled
	 */
	public boolean getHideParent() {
		return getAttributeAsBoolean("hideParent");
	}

	/**
	 * The unique id of this component (defaults to an auto-assigned id).
	 * <p/>
	 * <br>
	 * <b>Note:</b> ID's cannot be changed after the component has been
	 * rendered.
	 * 
	 * @param id
	 *            the components ID
	 * @throws IllegalStateException
	 *             this property cannot be changed after the Component has been
	 *             rendered
	 */
	public final void setId(String id) throws IllegalStateException {
		setAttribute("id", id, false);
		this.id = id;
	}

	/**
	 * @return the ID of the Component
	 */
	public String getId() {
		return id;
	}

	/**
	 * The id of the node, a DOM node or an existing Element that will be the
	 * container to render this component into. Using this config, a call to
	 * render() is not required.
	 * 
	 * @param elem
	 *            the container element
	 * @throws IllegalStateException
	 *             this property cannot be changed after the Component has been
	 *             rendered
	 */
	public void setRenderTo(Element elem) throws IllegalStateException {
		setAttribute("renderTo", elem, true, true);
	}

	public void setRenderTo(ExtElement elem) throws IllegalStateException {
		setAttribute("renderTo", elem.getJsObj(), true, true);
	}

	/**
	 * The id of the node, a DOM node or an existing Element that will be the
	 * container to render this component into. Using this config, a call to
	 * render() is not required.
	 * 
	 * @param elemID
	 *            the container element
	 * @throws IllegalStateException
	 *             this property cannot be changed after the Component has been
	 *             rendered
	 */
	public void setRenderToID(String elemID) throws IllegalStateException {
		setAttribute("renderTo", elemID, false);
	}

	/**
	 * @return the element the Component is rendered to
	 */
	public Element getRenderTo() {
		return JsoHelper.getAttributeAsElement(config, "renderTo");
	}

	/**
	 * An array of events that, when fired, should trigger this component to
	 * save its state (defaults to none). These can be any types of events
	 * supported by this component, including browser or custom events (e.g.,
	 * ['click', 'customerchange']).
	 * 
	 * @param stateEvents
	 *            an array of state events
	 * @throws IllegalStateException
	 *             this property cannot be changed after the Component has been
	 *             rendered
	 */
	public void setStateEvents(String[] stateEvents)
			throws IllegalStateException {
		setAttribute("stateEvents", stateEvents, true);
	}

	/**
	 * An array of events that, when fired, should trigger this component to
	 * save its state (defaults to none). These can be any types of events
	 * supported by this component, including browser or custom events (e.g.,
	 * ['click', 'customerchange']).
	 * 
	 * @return an array of state events
	 */
	public String[] getStateEvents() {
		return JsoHelper.getAttributeAsStringArray(config, "stateEvents");
	}

	/**
	 * The unique id for this component to use for state management purposes
	 * (defaults to the component id).
	 * 
	 * @param stateId
	 *            the state ID
	 * @throws IllegalStateException
	 *             this property cannot be changed after the Component has been
	 *             rendered
	 */
	public void setStateId(String stateId) throws IllegalStateException {
		setAttribute("stateId", stateId, true);
	}

	/**
	 * A flag which causes the object to attempt to restore the state of
	 * internal properties from a saved state on startup. The object must have a
	 * stateId for state to be managed.
	 * 
	 * @param value
	 * @throws IllegalStateException
	 */
	public void setStateful(boolean value) throws IllegalStateException {
		setAttribute("stateful", value, true);
	}

	/**
	 * The unique id for this component to use for state management purposes
	 * (defaults to the component id).
	 * 
	 * @return the state ID
	 */
	public String getStateId() {
		return getAttribute("stateId");
	}

	/**
	 * A custom style specification to be applied to this component's Element.
	 * 
	 * @param style
	 *            the CSS style specification
	 * @throws IllegalStateException
	 *             this property cannot be changed after the Component has been
	 *             rendered
	 */
	public void setStyle(String style) throws IllegalStateException {
		if (!isRendered()) {
			setAttribute("style", style, true);
		} else {
			Ext.get(getId()).applyStyles(style);
		}
	}

	public void setWeight(int value) {
		this.setAttribute("weight", value, true);
	}

	/**
	 * Just calls setCls(cls). It is recommended that this method not be used,
	 * to avoid confusion.
	 * 
	 * @param cls
	 *            the CSS class
	 * @see com.eemi.ext4j.client.core.Component#setCls(String)
	 */
	public void setStyleName(String cls) {
		setCls(cls);
	}

	/**
	 * Just calls addCls(cls). It is recommended that this method not be used,
	 * to avoid confusion.
	 * 
	 * @param cls
	 *            the CSS class
	 * @see com.eemi.ext4j.client.core.Component#addCls(String)
	 */
	public void addStyleName(String cls) {
		addCls(cls);
	}

	/**
	 * Just calls removeCls(cls). It is recommended that this method not be
	 * used, to avoid confusion.
	 * 
	 * @param cls
	 *            the CSS class
	 * @see com.eemi.ext4j.client.core.Component#removeCls(String)
	 */
	public void removeStyleName(String cls) {
		removeCls(cls);
	}

	public int getOffsetHeight() {
		return DOM.getElementPropertyInt(getElement(false), "offsetHeight");
	}

	public int getOffsetWidth() {
		return DOM.getElementPropertyInt(getElement(false), "offsetWidth");
	}

	public String getTitle() {
		return DOM.getElementProperty(getElement(false), "title");
	}

	public void setHeight(String height) {
		if (!isRendered()) {
			if (height.indexOf("px") != -1) {
				height = height.replaceAll("px", "").trim();
				setHeight(Integer.parseInt(height));
			} else if (height.trim().equalsIgnoreCase("auto")) {
				setAutoWidth(true);
			} else {
				setAttribute("width", height, true);
			}
		} else {
			if (height.indexOf("px") != -1) {
				height = height.replaceAll("px", "").trim();
				setHeightRendered(Integer.parseInt(height));
			} else {
				super.setHeight(height);
			}
		}
	}

	public native LoadMask setLoading(String message) /*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var obj = component.setLoading(message);
		return @com.eemi.ext4j.client.ui.LoadMask::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
	}-*/;

	public void setTitle(final String title) {
		if (isRendered()) {
			if (title == null || title.length() == 0) {
				DOM.removeElementAttribute(getElement(), "title");
			} else {
				DOM.setElementAttribute(getElement(), "title", title);
			}
		} else {
			addListener("render", new Function() {
				public void execute() {
					setTitle(title);
				}
			});
		}
	}

	protected String getAttribute(String attribute) {
		if (isCreated()) {
			return JsoHelper.getAttribute(getJsObj(), attribute);
		} else {
			return JsoHelper.getAttribute(config, attribute);
		}
	}

	protected JavaScriptObject getAttributeAsJavaScriptObject(String attribute) {
		if (isCreated()) {
			return JsoHelper.getAttributeAsJavaScriptObject(getJsObj(),
					attribute);
		} else {
			return JsoHelper.getAttributeAsJavaScriptObject(config, attribute);
		}
	}

	protected int getAttributeAsInt(String attribute) {
		if (isCreated()) {
			return JsoHelper.getAttributeAsInt(getJsObj(), attribute);
		} else {
			return JsoHelper.getAttributeAsInt(config, attribute);
		}
	}

	protected float getAttributeAsFloat(String attribute) {
		if (isCreated()) {
			return JsoHelper.getAttributeAsFloat(getJsObj(), attribute);
		} else {
			return JsoHelper.getAttributeAsFloat(config, attribute);
		}
	}

	protected boolean getAttributeAsBoolean(String attribute) {
		if (isRendered()) {
			return JsoHelper.getAttributeAsBoolean(getJsObj(), attribute);
		} else {
			return JsoHelper.getAttributeAsBoolean(config, attribute);
		}
	}

	private void error(String attribute, String value, boolean allowPostCreate)
			throws IllegalStateException {
		if (allowPostCreate) {
			error("Cannot change configuration property '" + attribute
					+ "' after the component has been rendered.");
		} else {
			error("Cannot change configuration property '" + attribute
					+ "' after the component has been created.");
		}
	}

	protected void error(String message) throws IllegalStateException {
		if (!GWT.isScript()) {
			MessageBox.alert("Error", message);
			throw new IllegalStateException(message);
		}
	}

	protected void setAttribute(String attribute, String value,
			boolean allowPostCreate) {
		setAttribute(attribute, value, allowPostCreate, false);
	}

	protected void setAttribute(String attribute, String value,
			boolean allowPostCreate, boolean allowPostRendered) {
		if (!isCreated()) {
			JsoHelper.setAttribute(config, attribute, value);
		} else if (!isRendered() && allowPostCreate || allowPostRendered) {
			JsoHelper.setAttribute(getJsObj(), attribute, value);
		} else {
			error(attribute, value, allowPostCreate);
		}
	}

	@SuppressWarnings("rawtypes")
	protected void setAttribute(String attribute, Map value,
			boolean allowPostCreate) {
		setAttribute(attribute, value, allowPostCreate, false);
	}

	@SuppressWarnings("rawtypes")
	protected void setAttribute(String attribute, Map value,
			boolean allowPostCreate, boolean allowPostRendered) {
		if (!isCreated()) {
			JsoHelper.setAttribute(config, attribute, value);
		} else if (!isRendered() && allowPostCreate || allowPostRendered) {
			JsoHelper.setAttribute(getJsObj(), attribute, value);
		} else {
			error(attribute, value.toString(), allowPostCreate);
		}
	}

	protected void setAttribute(String attribute, int[] value,
			boolean allowPostCreate) {
		setAttribute(attribute, value, allowPostCreate, false);
	}

	protected void setAttribute(String attribute, int[] value,
			boolean allowPostCreate, boolean allowPostRender) {
		if (!isCreated()) {
			JsoHelper.setAttribute(config, attribute, value);
		} else if (!isRendered() && allowPostCreate || allowPostRender) {
			JsoHelper.setAttribute(getJsObj(), attribute, value);
		} else {
			error(attribute, value.toString(), allowPostCreate);
		}
	}

	protected void setAttribute(String attribute, long value,
			boolean allowPostCreate) {
		if (!isCreated()) {
			JsoHelper.setAttribute(config, attribute, value);
		} else if (!isRendered() && allowPostCreate) {
			JsoHelper.setAttribute(getJsObj(), attribute, value);
		} else {
			error(attribute, String.valueOf(value), allowPostCreate);
		}
	}

	protected void setAttribute(String attribute, double value,
			boolean allowPostCreate) {
		if (!isCreated()) {
			JsoHelper.setAttribute(config, attribute, value);
		} else if (!isRendered() && allowPostCreate) {
			JsoHelper.setAttribute(getJsObj(), attribute, value);
		} else {
			error(attribute, String.valueOf(value), allowPostCreate);
		}
	}

	protected void setAttribute(String attribute, int value,
			boolean allowPostCreate) {
		setAttribute(attribute, value, allowPostCreate, false);
	}

	protected void setAttribute(String attribute, int value,
			boolean allowPostCreate, boolean allowPostRender) {
		if (!isCreated()) {
			JsoHelper.setAttribute(config, attribute, value);
		} else if (!isRendered() && allowPostCreate || allowPostRender) {
			JsoHelper.setAttribute(getJsObj(), attribute, value);
		} else {
			error(attribute, String.valueOf(value), allowPostCreate);
		}
	}

	protected void setAttribute(String attribute, Date value,
			boolean allowPostCreate) {
		if (!isCreated()) {
			JsoHelper.setAttribute(config, attribute, value);
		} else if (!isRendered() && allowPostCreate) {
			JsoHelper.setAttribute(getJsObj(), attribute, value);
		} else {
			error(attribute, String.valueOf(value), allowPostCreate);
		}
	}

	protected void setAttribute(String attribute, JavaScriptObject value,
			boolean allowPostCreate) {
		setAttribute(attribute, value, allowPostCreate, false);
	}

	protected void setAttribute(String attribute, JavaScriptObject value,
			boolean allowPostCreate, boolean allowPostRender) {
		if (!isCreated()) {
			JsoHelper.setAttribute(config, attribute, value);
		} else if (!isRendered() && allowPostCreate || allowPostRender) {
			JsoHelper.setAttribute(getJsObj(), attribute, value);
		} else {
			error(attribute, String.valueOf(value), allowPostCreate);
		}
	}

	protected void setAttribute(String attribute, String[] value,
			boolean allowPostCreate) {
		setAttribute(attribute, value, allowPostCreate, false);
	}

	protected void setAttribute(String attribute, String[] value,
			boolean allowPostCreate, boolean allowPostRender) {
		if (!isCreated()) {
			JsoHelper.setAttribute(config, attribute, value);
		} else if (!isRendered() && allowPostCreate || allowPostRender) {
			JsoHelper.setAttribute(getJsObj(), attribute, value);
		} else {
			error(attribute, String.valueOf(value), allowPostCreate);
		}
	}

	protected void setAttribute(String attribute, boolean value,
			boolean allowPostCreate) {
		setAttribute(attribute, value, allowPostCreate, false);
	}

	protected void setAttribute(String attribute, boolean value,
			boolean allowPostCreate, boolean allowPostRendered) {
		if (!isCreated()) {
			JsoHelper.setAttribute(config, attribute, value);
		} else if (!isRendered() && allowPostCreate || allowPostRendered) {
			JsoHelper.setAttribute(getJsObj(), attribute, value);
		} else {
			error(attribute, String.valueOf(value), allowPostCreate);
		}
	}

	protected void setAttribute(String attribute, Element value,
			boolean allowPostCreate) {
		setAttribute(attribute, value, allowPostCreate, false);
	}

	protected void setAttribute(String attribute, Element value,
			boolean allowPostCreate, boolean allowPostRendered) {
		if (!isCreated()) {
			JsoHelper.setAttribute(config, attribute, value);
		} else if (!isRendered() && allowPostCreate || allowPostRendered) {
			JsoHelper.setAttribute(getJsObj(), attribute, value);
		} else {
			error(attribute, String.valueOf(value), allowPostCreate);
		}
	}

	public static Component createComponent(JavaScriptObject obj) {
		return new SimpleComponent(obj);
	}

	// public void setWidth(String width) {
	// // This exists to deal with an inconsistency in IE's implementation
	// // where
	// // it won't accept negative numbers in length measurements
	// assert extractLengthValue(width.trim().toLowerCase()) >= 0 :
	// "CSS widths should not be negative";
	// DOM.setStyleAttribute(getElement(false), "width", width);
	// }

	public String toString() {
		if (!isRendered()) {
			return "<<Lazy Component>>::" + getXType() + ", ID:" + getId();
		} else {
			return super.toString();
		}
	}

	public static native String getConfigAsString(JavaScriptObject jsObj) /*-{
		var props = '{';
		for ( var k in jsObj) {
			props += '\n[' + k + '=>' + jsObj[k] + ']';
		}
		return props + '}';
	}-*/;

	public boolean equals(Object obj) {
		if (obj instanceof Component) {
			if (obj == this) {
				return true;
			} else {
				Component other = (Component) obj;
				if (other.getId().equals(getId())) {
					return true;
				}
			}
			return false;
		} else {
			return false;
		}
	}

	/**
	 * The component X coordinate.
	 * 
	 * @param x
	 *            , the x coordinate
	 */
	public void setX(double x) {
		if (!isRendered()) {
			setAttribute("x", x, true);
		} else {
			setXRendered(x);
		}
	}

	public native void clearListeners() /*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		component.clearListeners();
	}-*/;

	private native void setXRendered(double x) /*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		component.setX(x);
	}-*/;

	/**
	 * The component y coordinate.
	 * 
	 * @param y
	 *            , the y coordinate
	 */
	public void setY(double y) {
		if (!isRendered()) {
			setAttribute("y", y, true);
		} else {
			setYRendered(y);
		}
	}

	/**
	 * Sets the x and y position of the component
	 * 
	 * @param x
	 *            , the x position
	 * @param y
	 *            , the y position
	 */
	public void setXY(double x, double y) {
		setX(x);
		setY(y);
	}

	public int hashCode() {
		return getId().hashCode();
	}

	/**
	 * Update the content area of a component.
	 */
	public final native void update()/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		component.update();
	}-*/;

	/**
	 * Update the content area of a component.
	 * 
	 * @param loadScript
	 *            , Only legitimate when using the html configuration.
	 * 
	 *            Defaults to: false
	 */
	public final native void update(boolean loadScript)/*-{
		var comp = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		comp.update(loadScript);
	}-*/;

	/**
	 * Update the content area of a component.
	 * 
	 * @param loadScript
	 *            , Only legitimate when using the html configuration.
	 * @param callback
	 *            ,Only legitimate when using the html configuration. Callback
	 *            to execute when scripts have finished loading
	 */
	public final native void update(boolean loadScript, Function callback)/*-{
		var comp = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		comp.update(loadScript, function() {
			callback.@com.eemi.ext4j.client.core.Function::execute()();
		});
	}-*/;

	/**
	 * Update the content area of a component.
	 * 
	 * @param value
	 *            , content to update this component with
	 */
	public final native void update(String value)/*-{
		var comp = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		comp.update(value);
	}-*/;

	public final native void update(String value, boolean loadScript)/*-{
		var comp = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		comp.update(value, loadScript);
	}-*/;

	public final native void update(String value, boolean loadScript,
			Function callback)/*-{
		var comp = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		comp.update(value, loadScript, function() {
			callback.@com.eemi.ext4j.client.core.Function::execute()();
		});
	}-*/;

	public final native void update(Object data)/*-{
		this.update(data);
	}-*/;

	public final native void update(Object data, boolean loadScript)/*-{
		var comp = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		comp.update(data, loadScript);
	}-*/;

	public final native void update(Object data, boolean loadScript,
			Function callback)/*-{
		var comp = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		comp.update(data, loadScript, function() {
			callback.@com.eemi.ext4j.client.core.Function::execute()();
		});
	}-*/;

	/**
	 * Set the width in pixels or auto. Note that setting percentage based
	 * widths will lead to unpredictable display behavior. You should use the
	 * various layouts like
	 * {@link com.eemi.ext4j.client.core.CenterLayout.AnchorLayout} to control
	 * percentage based rendering of components.
	 * 
	 * @param width
	 *            the component height
	 */
	public void setWidth(String width) {
		if (!isRendered()) {
			if (width.indexOf("px") != -1) {
				width = width.replaceAll("px", "").trim();
				setWidth(Integer.parseInt(width));
			} else if (width.trim().equalsIgnoreCase("auto")) {
				setAutoWidth(true);
			} else {
				setAttribute("width", width, true);
			}
		} else {
			if (width.indexOf("px") != -1) {
				width = width.replaceAll("px", "").trim();
				setWidthRendered(Integer.parseInt(width));
			} else {
				super.setWidth(width);
			}
		}
	}

	/**
	 * The component width.
	 * 
	 * @return the component width, -1 for auto
	 */
	public final native double getWidth()/*-{
		var comp = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		return comp.getWidth();
	}-*/;

	/**
	 * The component height.
	 * 
	 * @return the component width, -1 for auto
	 */
	public final native double getHeight()/*-{
		var comp = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		return comp.getHeight();
	}-*/;

	/**
	 * True to enable dragging of this Panel (defaults to false).
	 * 
	 * @param draggable
	 *            true to enable dragging of this panel
	 */
	public void setDraggable(boolean draggable) {
		setAttribute("draggable", draggable, true, true);
	}

	/**
	 * Sets the draggable property of this panrl
	 * 
	 * @param config
	 *            , the dragging config of this panel
	 * @throws IllegalStateException
	 *             this property cannot be changed after the Component has been
	 *             rendered
	 */
	public void setDraggable(DragDropConfig config) {
		setAttribute("draggable", config.getJsObj(), true);
	}

	/**
	 * True to float the panel (absolute position it with automatic shimming and
	 * shadow), false to display it inline where it is rendered. Note that by
	 * default, setting floating to true will cause the panel to display at
	 * negative offsets so that it is hidden -- because the panel is absolute
	 * positioned, the position must be set explicitly after render (e.g.,
	 * myPanel.setPosition(100,100);). Also, when floating a panel you should
	 * always assign a fixed width, otherwise it will be auto width and will
	 * expand to fill to the right edge of the viewport.
	 * 
	 * @param floating
	 *            Defaults to false
	 * @throws IllegalStateException
	 *             this property cannot be changed after the Component has been
	 *             rendered
	 */
	public void setFloating(boolean floating) throws IllegalStateException {
		setAttribute("floating", floating, true, true);
	}

	public void setAriaRole(String value) {
		setAttribute("ariaRole", value, true, true);
	}

	/**
	 * Important: This config is only effective for collapsible Panels which are
	 * direct child items of a border layout.
	 * 
	 * <p>
	 * true to allow clicking a collapsed Panel's placeholder to display the
	 * Panel floated above the layout, false to force the user to fully expand a
	 * collapsed region by clicking the expand button to see it again.
	 * <p>
	 * Defaults to: true
	 * 
	 * @param value
	 */
	public void setFloatable(boolean value) {
		setAttribute("floatable", value, true);
	}

	/**
	 * True to float the panel (absolute position it with automatic shimming and
	 * shadow), false to display it inline where it is rendered. Note that by
	 * default, setting floating to true will cause the panel to display at
	 * negative offsets so that it is hidden -- because the panel is absolute
	 * positioned, the position must be set explicitly after render (e.g.,
	 * myPanel.setPosition(100,100);). Also, when floating a panel you should
	 * always assign a fixed width, otherwise it will be auto width and will
	 * expand to fill to the right edge of the viewport.
	 * 
	 * @return true to float panel, false to display it inline where it is
	 *         rendered
	 */
	public boolean getFloating() {
		return JsoHelper.getAttributeAsBoolean(config, "floating");
	}

	/**
	 * The component width. (defaults to auto)
	 * 
	 * @param width
	 *            the width, -1 for auto
	 */
	public void setWidth(double width) {
		if (!isRendered()) {
			if (width == -1) {
				setAttribute("width", "auto", true);
			} else {
				setAttribute("width", width, true);
			}
		} else {
			setWidthRendered(width);
		}
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

	public void setComponentWidth(int width) {
		setWidth(width);
	}

	public void setComponentHeight(int height) {
		setHeight(height);
	}

	public void setComponentSize(int width, int height) {
		setSize(width, height);
	}

	private native void setWidthRendered(double width) /*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		component.setWidth(width);
	}-*/;

	/**
	 * True to use width:'auto', false to use fixed width (defaults to false).
	 * 
	 * @param autoWidth
	 *            true for auto width
	 * @throws IllegalStateException
	 *             this property cannot be changed after the Component has been
	 *             rendered
	 */
	public void setAutoWidth(boolean autoWidth) throws IllegalStateException {
		setAttribute("autoWidth", autoWidth, true);
	}

	/**
	 * The height of this component in pixels (defaults to auto).
	 * 
	 * @param height
	 *            the component height
	 */
	public void setHeight(double height) {
		if (!isRendered()) {
			if (height == -1) {
				setAttribute("height", "auto", true);
			} else {
				setAttribute("height", height, true);
			}
		} else {
			setHeightRendered(height);
		}

	}

	public void setRowSpan(int value) {
		setAttribute("rowspan", value, true);
	}

	public void setColSpan(int value) {
		setAttribute("colspan", value, true);
	}

	/**
	 * Sets the UI for the component. This will remove any existing UIs on the
	 * component. It will also loop through any uiCls set on the component and
	 * rename them so they include the new UI
	 * 
	 * @param ui
	 *            , the new ui for the component
	 */
	public native void setUI(String ui) /*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		component.setUI(ui);
	}-*/;

	/**
	 * true to use overflow:'auto' on the components layout element and show
	 * scroll bars automatically when necessary, false to clip any overflowing
	 * content. This should not be combined with overflowX or overflowY.
	 * 
	 * Defaults to: false
	 * 
	 * @param value
	 */
	public native void setAutoScroll(boolean value) /*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		component.setAutoScroll(value);
	}-*/;

	/**
	 * sets the flex value
	 * 
	 * @param flex
	 *            , the new flex value
	 */
	public void setFlex(double flex) {
		setAttribute("flex", flex, true);
	}

	/**
	 * Specify as true to apply a Resizer to this Component after rendering.
	 * 
	 * @param value
	 */
	public void setResizable(boolean value) {
		setAttribute("resizable", value, true, true);
	}

	/**
	 * Specifies the margin for this component. The margin can be a single
	 * numeric value to apply to all sides or it can be a CSS style
	 * specification for each style, for example: '10 5 3 10'.
	 * 
	 * @param value
	 */
	public void setMargin(int value) {
		setAttribute("margin", value, true);
	}

	/**
	 * Specifies the margin for this component. The margin can be a single
	 * numeric value to apply to all sides or it can be a CSS style
	 * specification for each style, for example: '10 5 3 10'.
	 * 
	 * @param value
	 */
	public void setMargin(String value) {
		setAttribute("margin", value, true);
	}

	/**
	 * Only valid when a sibling element of a Splitter within a VBox or HBox
	 * layout.
	 * 
	 * Specifies that if an immediate sibling Splitter is moved, the Component
	 * on the other side is resized, and this Component maintains its configured
	 * flex value.
	 * 
	 * Defaults to: false
	 * 
	 * @param value
	 */
	public void setMaintainFlex(boolean value) {
		setAttribute("maintainFlex", value, true);
	}

	/**
	 * An array of plugin to be added to this component.
	 */
	public void setPlugins(AbstractPlugin... values) {
		setPlugins(Arrays.asList(values));
	}

	/**
	 * An array of plugin to be added to this component.
	 */
	public void setPlugins(List<AbstractPlugin> values) {
		JsArray<JavaScriptObject> jsos = JsArray.createArray().cast();
		for (AbstractPlugin p : values) {
			jsos.push(p.getJsObj());
		}
		setAttribute("plugins", jsos, true);
	}

	/**
	 * The minimum value in pixels which this Component will set its width to.
	 * <p>
	 * Warning: This will override any size management applied by layout
	 * managers.
	 * 
	 * @param value
	 */
	public void setMinWidth(double value) {
		setAttribute("minWidth", value, true);
	}

	/**
	 * The minimum value in pixels which this Component will set its height to.
	 * <p>
	 * Warning: This will override any size management applied by layout
	 * managers.
	 * 
	 * @param value
	 */
	public void setMinHeight(double value) {
		setAttribute("minHeight", value, true);
	}

	/**
	 * The minimum values which this component will sets its width and height to
	 * 
	 * @param minWidth
	 * @param minHeight
	 */
	public void setMinSize(double minWidth, double minHeight) {
		setMinWidth(minWidth);
		setMinHeight(minHeight);
	}

	/**
	 * The maximun value in pixels which this Component will set its width to.
	 * <p>
	 * Warning: This will override any size management applied by layout
	 * managers.
	 * 
	 * @param value
	 */
	public void setMaxWidth(double value) {
		setAttribute("maxWidth", value, true);
	}

	/**
	 * The maximun value in pixels which this Component will set its height to.
	 * <p>
	 * Warning: This will override any size management applied by layout
	 * managers.
	 * 
	 * @param value
	 */
	public void setMaxHeight(double value) {
		setAttribute("maxHeight", value, true);
	}

	/**
	 * The minimum values which this component will sets its width and height to
	 * 
	 * @param minWidth
	 * @param minHeight
	 */
	public void setMaxSize(double maxWidth, double maxHeight) {
		setMaxWidth(maxWidth);
		setMaxHeight(maxHeight);
	}

	public static native void disableShadow(ExtElement el)/*-{
		var element = el.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		if (element.disableShadow) {
			element.disableShadow();

		}
		//diable isn't working entirely (e.g. for last shown window) so create shadow backup and replace shadow by null
		element._shadow = el.shadow;
		element.shadow = null;

	}-*/;

	public static native void enableShadow(ExtElement el)/*-{
		var element = el.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		if (element.disableShadow) {
			element.shadow = el._shadow;
			element.enableShadow();
		}

	}-*/;

	// Eventhandlers

	/**
	 * Listen to before a Component has been visually activated. Returning false
	 * from an event listener can prevent the activate from occurring.
	 * 
	 * @param handler
	 *            , the handler to use
	 */
	public void addBeforeActivateHandler(LifeCycleHandler handler) {
		_addActivationHandler(Event.BEFORE_ACTIVATE, handler);
	}

	/**
	 * Listen to before a Component has been visually deactivated. Returning
	 * false from an event listener can prevent the deactivate from occurring.
	 * 
	 * @param handler
	 *            , the handler to use
	 */
	public void addBeforeDeactivateHandler(LifeCycleHandler handler) {
		_addActivationHandler(Event.BEFORE_DEACTIVATE, handler);
	}

	/**
	 * Listen to before the component is destroyed. Return false from an event
	 * handler to stop the destroy.
	 * 
	 * @param handler
	 *            , the handler to use
	 */
	public void addBeforeDestroyHandler(LifeCycleHandler handler) {
		_addActivationHandler(Event.BEFORE_DESTROY, handler);
	}

	/**
	 * Listen before the component is hidden when calling the hide method.
	 * Return false from an event handler to stop the hide.
	 * 
	 * @param handler
	 *            , the handler to use
	 */
	public void addBeforeHideHandler(LifeCycleHandler handler) {
		_addActivationHandler(Event.BEFORE_HIDE, handler);
	}

	/**
	 * Listen to before the component is rendered. Return false from an event
	 * handler to stop the render.
	 * 
	 * @param handler
	 *            , the handler to use
	 */
	public void addBeforeRenderHandler(LifeCycleHandler handler) {
		_addActivationHandler(Event.BEFORE_RENDER, handler);
	}

	/**
	 * Listen to before the component is shown when calling the show method.
	 * Return false from an event handler to stop the show.
	 * 
	 * @param handler
	 *            , the handler to use
	 */
	public void addBeforeShowHandler(LifeCycleHandler handler) {
		_addActivationHandler(Event.BEFORE_SHOW, handler);
	}

	/**
	 * Specifies the border size for this component. The border can be a single
	 * numeric value to apply to all sides or it can be a CSS style
	 * specification for each style, for example: '10 5 3 10' (top, right,
	 * bottom, left).
	 * 
	 * @param value
	 */
	public void setBorder(String value) {
		setAttribute("border", value, true);
	}

	/**
	 * Specifies the border size for this component. The border can be a single
	 * numeric value to apply to all sides or it can be a CSS style
	 * specification for each style, for example: '10 5 3 10' (top, right,
	 * bottom, left).
	 * 
	 * @param value
	 */
	public void setBorder(double value) {
		setAttribute("border", value, true);
	}

	/**
	 * Specifies the border size for this component. The border can be a single
	 * numeric value to apply to all sides or it can be a CSS style
	 * specification for each style, for example: '10 5 3 10' (top, right,
	 * bottom, left).
	 * 
	 * @param value
	 */
	public void setBorder(boolean value) {
		setAttribute("border", value, true);
	}

	public void setDocked(Dock dock) {
		setDocked(dock.getValue());
	}

	public void setDocked(String dock) {
		setDockedRendered(dock);
	}

	public native void addEventHandler(String event, EventHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		if (component) {
			component
					.addListener(
							event,
							$entry(function(c) {
								var comp = @com.eemi.ext4j.client.core.SimpleComponent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
								handler.@com.eemi.ext4j.client.events.component.EventHandler::onEvent(Lcom/eemi/ext4j/client/core/Component;)(comp);
							}));
		}

	}-*/;

	protected void addListener(String event, AbstractHandler handler) {
		this.addWidgetListener(event, handler.getJsoPeer());
	}

	/**
	 * Template method that is called after the Component's config has been
	 * created. Subclasses can extend this method to add properties that can
	 * only be set on the config prototype of the component
	 */
	protected void onConfigCreated() {

	}

	/**
	 * Clone the current component using the original config values passed into
	 * this instance by default.
	 * 
	 * @return The cloned copy of this component
	 */
	public native JavaScriptObject cloneConfig()/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		return component.cloneConfig();
	}-*/;

	private native void _addActivationHandler(String event,
			LifeCycleHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		if (component) {
			component
					.addListener(
							event,
							$entry(function(c) {
								var comp = @com.eemi.ext4j.client.core.SimpleComponent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
								return handler.@com.eemi.ext4j.client.events.component.LifeCycleHandler::onEvent(Lcom/eemi/ext4j/client/core/Component;)(comp);
							}));
		}

	}-*/;

	private native void _addVisualStateChangeHandler(String event,
			VisualStateChangeHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		if (component) {
			component
					.addListener(
							event,
							$entry(function(c, e) {
								var comp = @com.eemi.ext4j.client.core.SimpleComponent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
								var eventObject = @com.eemi.ext4j.client.core.EventObject::new(Lcom/google/gwt/core/client/JavaScriptObject;)(e);
								handler.@com.eemi.ext4j.client.events.component.VisualStateChangeHandler::onEvent(Lcom/eemi/ext4j/client/core/Component;Lcom/eemi/ext4j/client/core/EventObject;)(comp,eventObject);
							}));
		}

	}-*/;

	private native void setHeightRendered(double height) /*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		component.setHeight(height);
	}-*/;

	private native void setDockedRendered(String dock) /*-{
		var c = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		c.setDocked(dock, true);
	}-*/;

	private native void setYRendered(double x) /*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		component.setY(x);
	}-*/;

	private native double extractLengthValue(String s) /*-{
		if (s == "auto" || s == "inherit" || s == "") {
			return 0;
		} else {
			return parseFloat(s);
		}
	}-*/;

	// Events Handlers

	/**
	 * Fires after a Component has been visually activated.
	 * <p>
	 * Note This event is only fired if this Component is a child of a
	 * Ext.container.Container that uses Ext.layout.container.Card as it's
	 * layout or this Component is a floating Component.
	 */
	public native HandlerRegistration addActivateHandler(ActivateHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, e) {
			var component = @com.eemi.ext4j.client.core.Component::createComponent(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var activateEvent = @com.eemi.ext4j.client.events.component.ActivateEvent::new(Lcom/eemi/ext4j/client/core/Component;Lcom/google/gwt/core/client/JavaScriptObject;)(component,e)
			handler.@com.eemi.ext4j.client.events.component.ActivateHandler::onActivate(Lcom/eemi/ext4j/client/events/component/ActivateEvent;)(activateEvent);
		};
		var eventName = @com.eemi.ext4j.client.events.component.ActivateEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;

	}-*/;

	/**
	 * Fires after a Component had been added to a Container.
	 */
	public native HandlerRegistration addAddedHandler(
			com.eemi.ext4j.client.events.component.AddedHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, cont, pos, e) {
			var component = @com.eemi.ext4j.client.core.Component::createComponent(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var container = @com.eemi.ext4j.client.ui.Container::new(Lcom/google/gwt/core/client/JavaScriptObject;)(cont);
			var event = @com.eemi.ext4j.client.events.component.AddedEvent::new(Lcom/eemi/ext4j/client/core/Component;Lcom/eemi/ext4j/client/ui/Container;ILcom/google/gwt/core/client/JavaScriptObject;)(component,container,pos,event);
			handler.@com.eemi.ext4j.client.events.component.AddedHandler::onAdded(Lcom/eemi/ext4j/client/events/component/AddedEvent;)(addedEvent);
		};
		var eventName = @com.eemi.ext4j.client.events.component.AddedEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;

	}-*/;

	/**
	 * Fires after the component rendering is finished.
	 * <p>
	 * The afterrender event is fired after this Component has been rendered,
	 * been postprocessed by any afterRender method defined for the Component.
	 */
	public native HandlerRegistration addAfterRenderHandler(
			AfterRenderHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, e) {
			var component = @com.eemi.ext4j.client.core.Component::createComponent(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var event = @com.eemi.ext4j.client.events.component.AfterRenderEvent::new(Lcom/eemi/ext4j/client/core/Component;Lcom/google/gwt/core/client/JavaScriptObject;)(component,e);
			handler.@com.eemi.ext4j.client.events.component.AfterRenderHandler::onAfterRender(Lcom/eemi/ext4j/client/events/component/AfterRenderEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.component.AfterRenderEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	/**
	 * Fires before a Component has been visually activated.
	 * <p>
	 * Note This event is only fired if this Component is a child of a
	 * Ext.container.Container that uses Ext.layout.container.Card as it's
	 * layout.
	 */
	public native HandlerRegistration addBeforeActivateHandler(
			BeforeActivateHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, e) {
			var component = @com.eemi.ext4j.client.core.Component::createComponent(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var event = @com.eemi.ext4j.client.events.component.BeforeActivateEvent::new(Lcom/eemi/ext4j/client/core/Component;Lcom/google/gwt/core/client/JavaScriptObject;)(component,e);
			handler.@com.eemi.ext4j.client.events.component.BeforeActivateHandler::onBeforeActivate(Lcom/eemi/ext4j/client/events/component/BeforeActivateEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.component.BeforeActivateEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	/**
	 * Fires before a Component has been visually deactivated.
	 * <p>
	 * Note This event is only fired if this Component is a child of a
	 * Ext.container.Container that uses Ext.layout.container.Card as it's
	 * layout.
	 */
	public native HandlerRegistration addBeforeDeactivateHandler(
			BeforeDeactivateHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, e) {
			var component = @com.eemi.ext4j.client.core.Component::createComponent(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var event = @com.eemi.ext4j.client.events.component.BeforeDeactivateEvent::new(Lcom/eemi/ext4j/client/core/Component;Lcom/google/gwt/core/client/JavaScriptObject;)(component,e);
			handler.@com.eemi.ext4j.client.events.component.BeforeDeactivateHandler::onBeforeDeactivate(Lcom/eemi/ext4j/client/events/component/BeforeDeactivateEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.component.BeforeDeactivateEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	/**
	 * Fires before the component is destroyed.
	 */
	public native HandlerRegistration addBeforeDestroyHandler(
			BeforeDestroyHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, e) {
			var component = @com.eemi.ext4j.client.core.Component::createComponent(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var event = @com.eemi.ext4j.client.events.component.BeforeDestroyEvent::new(Lcom/eemi/ext4j/client/core/Component;Lcom/google/gwt/core/client/JavaScriptObject;)(component,e);
			handler.@com.eemi.ext4j.client.events.component.BeforeDestroyHandler::onBeforeDestroy(Lcom/eemi/ext4j/client/events/component/BeforeDestroyEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.component.BeforeDestroyEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	/**
	 * Fires before the component is hidden when calling the hide method.
	 */
	public native HandlerRegistration addBeforeHideHandler(
			BeforeHideHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, e) {
			var component = @com.eemi.ext4j.client.core.Component::createComponent(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var event = @com.eemi.ext4j.client.events.component.BeforeHideEvent::new(Lcom/eemi/ext4j/client/core/Component;Lcom/google/gwt/core/client/JavaScriptObject;)(component,e);
			handler.@com.eemi.ext4j.client.events.component.BeforeHideHandler::onBeforeHide(Lcom/eemi/ext4j/client/events/component/BeforeHideEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.component.BeforeHideEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	/**
	 * Fires before the component is rendered.
	 */
	public native HandlerRegistration addBeforeRenderHandler(
			BeforeRenderHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, e) {
			var component = @com.eemi.ext4j.client.core.Component::createComponent(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var event = @com.eemi.ext4j.client.events.component.BeforeRenderEvent::new(Lcom/eemi/ext4j/client/core/Component;Lcom/google/gwt/core/client/JavaScriptObject;)(component,e);
			handler.@com.eemi.ext4j.client.events.component.BeforeRenderHandler::onBeforeRender(Lcom/eemi/ext4j/client/events/component/BeforeRenderEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.component.BeforeRenderEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	/**
	 * Fires before the component is shown when calling the show method.
	 */
	public native HandlerRegistration addBeforeShowHandler(
			BeforeShowHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, e) {
			var component = @com.eemi.ext4j.client.core.Component::createComponent(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var event = @com.eemi.ext4j.client.events.component.BeforeShowEvent::new(Lcom/eemi/ext4j/client/core/Component;Lcom/google/gwt/core/client/JavaScriptObject;)(component,e);
			handler.@com.eemi.ext4j.client.events.component.BeforeShowHandler::onBeforeShow(Lcom/eemi/ext4j/client/events/component/BeforeShowEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.component.BeforeShowEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	/**
	 * Fires before the state of the object is restored.
	 */
	public native HandlerRegistration addBeforeStateRestoreHandler(
			BeforeStateRestoreHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, st, e) {
			var component = @com.eemi.ext4j.client.core.Component::createComponent(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var state = @com.eemi.ext4j.client.core.State::new(Lcom/google/gwt/core/client/JavaScriptObject;)(st);
			var event = @com.eemi.ext4j.client.events.component.BeforeStateRestoreEvent::new(Lcom/eemi/ext4j/client/core/Component;Lcom/eemi/ext4j/client/core/State;Lcom/google/gwt/core/client/JavaScriptObject;)(event,state,e);
			handler.@com.eemi.ext4j.client.events.component.BeforeStateRestoreHandler::onBeforeStateRestore(Lcom/eemi/ext4j/client/events/component/BeforeStateRestoreEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.component.BeforeStateRestoreEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	/**
	 * Fires before the state of the object is saved.
	 */
	public native HandlerRegistration addBeforeStateSaveHandler(
			BeforeStateSaveHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, st, e) {
			var component = @com.eemi.ext4j.client.core.Component::createComponent(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var state = @com.eemi.ext4j.client.core.State::new(Lcom/google/gwt/core/client/JavaScriptObject;)(st);
			var event = @com.eemi.ext4j.client.events.component.BeforeStateSaveEvent::new(Lcom/eemi/ext4j/client/core/Component;Lcom/eemi/ext4j/client/core/State;Lcom/google/gwt/core/client/JavaScriptObject;)(event,state,e);
			handler.@com.eemi.ext4j.client.events.component.BeforeStateSaveHandler::onBeforeStateSave(Lcom/eemi/ext4j/client/events/component/BeforeStateSaveEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.component.BeforeStateSaveEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	/**
	 * Fires when this Component loses focus.
	 */
	public native HandlerRegistration addBlurHandler(BlurHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, e) {
			var component = @com.eemi.ext4j.client.core.Component::createComponent(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var event = @com.eemi.ext4j.client.events.component.BlurEvent::new(Lcom/eemi/ext4j/client/core/Component;Lcom/google/gwt/core/client/JavaScriptObject;)(component,e);
			handler.@com.eemi.ext4j.client.events.component.BlurHandler::onBlur(Lcom/eemi/ext4j/client/events/component/BlurEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.component.BlurEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	/**
	 * Fires one time - after the component has been laid out for the first time
	 * at its initial size.
	 */
	public native HandlerRegistration addBoxReadyHandler(
			com.eemi.ext4j.client.events.component.BoxReadyHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, w, h, e) {
			var component = @com.eemi.ext4j.client.core.Component::createComponent(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var event = @com.eemi.ext4j.client.events.component.BoxReadyEvent::new(Lcom/eemi/ext4j/client/core/Component;DDLcom/google/gwt/core/client/JavaScriptObject;)(component,h,w,e);
			handler.@com.eemi.ext4j.client.events.component.BoxReadyHandler::onBoxReady(Lcom/eemi/ext4j/client/events/component/BoxReadyEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.component.BoxReadyEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	/**
	 * Fires after a Component has been visually deactivated.
	 * <p>
	 * Note This event is only fired if this Component is a child of a
	 * Ext.container.Container that uses Ext.layout.container.Card as it's
	 * layout or this Component is a floating Component.
	 */
	public native HandlerRegistration addDeactivateHandler(
			DeactivateHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, e) {
			var component = @com.eemi.ext4j.client.core.Component::createComponent(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var event = @com.eemi.ext4j.client.events.component.DeactivateEvent::new(Lcom/eemi/ext4j/client/core/Component;Lcom/google/gwt/core/client/JavaScriptObject;)(component,e)
			handler.@com.eemi.ext4j.client.events.component.DeactivateHandler::onDeactivate(Lcom/eemi/ext4j/client/events/component/DeactivateEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.component.DeactivateEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;

	}-*/;

	/**
	 * Fires after the component is destroyed.
	 */
	public native HandlerRegistration addDestroyHandler(DestroyHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, e) {
			var component = @com.eemi.ext4j.client.core.Component::createComponent(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var event = @com.eemi.ext4j.client.events.component.DestroyEvent::new(Lcom/eemi/ext4j/client/core/Component;Lcom/google/gwt/core/client/JavaScriptObject;)(component,e)
			handler.@com.eemi.ext4j.client.events.component.DestroyHandler::onDestroy(Lcom/eemi/ext4j/client/events/component/DestroyEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.component.DestroyEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;

	}-*/;

	/**
	 * Fires after the component is disabled.
	 */
	public native HandlerRegistration addDisableHandler(DisableHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, e) {
			var component = @com.eemi.ext4j.client.core.Component::createComponent(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var event = @com.eemi.ext4j.client.events.component.DisableEvent::new(Lcom/eemi/ext4j/client/core/Component;Lcom/google/gwt/core/client/JavaScriptObject;)(component,e)
			handler.@com.eemi.ext4j.client.events.component.DisableHandler::onDisable(Lcom/eemi/ext4j/client/events/component/DisableEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.component.DisableEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;

	}-*/;

	/**
	 * Fires after the component is enabled.
	 */
	public native HandlerRegistration addEnableHandler(EnableHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, e) {
			var component = @com.eemi.ext4j.client.core.Component::createComponent(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var event = @com.eemi.ext4j.client.events.component.EnableEvent::new(Lcom/eemi/ext4j/client/core/Component;Lcom/google/gwt/core/client/JavaScriptObject;)(component,e)
			handler.@com.eemi.ext4j.client.events.component.EnableHandler::onEnable(Lcom/eemi/ext4j/client/events/component/EnableEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.component.EnableEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;

	}-*/;

	/**
	 * Fires when this Component receives focus.
	 */
	public native HandlerRegistration addFocusHandler(FocusHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, e) {
			var component = @com.eemi.ext4j.client.core.Component::createComponent(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var event = @com.eemi.ext4j.client.events.component.FocusEvent::new(Lcom/eemi/ext4j/client/core/Component;Lcom/google/gwt/core/client/JavaScriptObject;)(component,e)
			handler.@com.eemi.ext4j.client.events.component.FocusHandler::onFocus(Lcom/eemi/ext4j/client/events/component/FocusEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.component.FocusEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;

	}-*/;

	/**
	 * Fires after the component is hidden. Fires after the component is hidden
	 * when calling the hide method.
	 */
	public native HandlerRegistration addHideHandler(HideHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, e) {
			var component = @com.eemi.ext4j.client.core.Component::createComponent(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var event = @com.eemi.ext4j.client.events.component.HideEvent::new(Lcom/eemi/ext4j/client/core/Component;Lcom/google/gwt/core/client/JavaScriptObject;)(component,e)
			handler.@com.eemi.ext4j.client.events.component.HideHandler::onHide(Lcom/eemi/ext4j/client/events/component/HideEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.component.HideEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;

	}-*/;

	/**
	 * Fires after the component is moved.
	 */
	public native HandlerRegistration addMoveHandler(MoveHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, x, y, e) {
			var component = @com.eemi.ext4j.client.core.Component::createComponent(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var event = @com.eemi.ext4j.client.events.component.MoveEvent::new(Lcom/eemi/ext4j/client/core/Component;DDLcom/google/gwt/core/client/JavaScriptObject;)(component,x,y,e);
			handler.@com.eemi.ext4j.client.events.component.MoveHandler::onMove(Lcom/eemi/ext4j/client/events/component/MoveEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.component.MoveEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;

	}-*/;

	/**
	 * Fires after the component is removed from a container.
	 */
	public native HandlerRegistration addRemovedHandler(RemovedHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, ct, e) {
			var component = @com.eemi.ext4j.client.core.Component::createComponent(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var container = @com.eemi.ext4j.client.ui.Container::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ct);
			var event = @com.eemi.ext4j.client.events.component.RemovedEvent::new(Lcom/eemi/ext4j/client/core/Component;Lcom/eemi/ext4j/client/ui/Container;Lcom/google/gwt/core/client/JavaScriptObject;)(compoent,container,e);
			handler.@com.eemi.ext4j.client.events.component.RemovedHandler::onRemoved(Lcom/eemi/ext4j/client/events/component/RemovedEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.component.RemovedEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	/**
	 * Fires after the component markup is rendered.
	 */
	public native HandlerRegistration addRenderHandler(RenderHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, e) {
			var component = @com.eemi.ext4j.client.core.Component::createComponent(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var event = @com.eemi.ext4j.client.events.component.RenderEvent::new(Lcom/eemi/ext4j/client/core/Component;Lcom/google/gwt/core/client/JavaScriptObject;)(component,e);
			handler.@com.eemi.ext4j.client.events.component.RenderHandler::onRender(Lcom/eemi/ext4j/client/events/component/RenderEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.component.RenderEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	/**
	 * Fires after the component is shown when calling the show method.
	 */
	public native HandlerRegistration addShowHandler(ShowHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, e) {
			var component = @com.eemi.ext4j.client.core.Component::createComponent(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var event = @com.eemi.ext4j.client.events.component.ShowEvent::new(Lcom/eemi/ext4j/client/core/Component;Lcom/google/gwt/core/client/JavaScriptObject;)(component,e);
			handler.@com.eemi.ext4j.client.events.component.ShowHandler::onShow(Lcom/eemi/ext4j/client/events/component/ShowEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.component.ShowEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	/**
	 * Fires after the component is resized. Note that this does not fire when
	 * the component is first laid out at its initial size. To hook that point
	 * in the life cycle, use the boxready event.
	 */
	public native HandlerRegistration addResizeHandler(ResizeHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, w, h, ow, oh, e) {
			var component = @com.eemi.ext4j.client.core.Component::createComponent(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var event = @com.eemi.ext4j.client.events.component.ResizeEvent::new(Lcom/eemi/ext4j/client/core/Component;DDDDLcom/google/gwt/core/client/JavaScriptObject;)(component,w,h,ow,oh,e);
			handler.@com.eemi.ext4j.client.events.component.ResizeHandler::onResize(Lcom/eemi/ext4j/client/events/component/ResizeEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.component.ResizeEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	/**
	 * Fires after the state of the object is restored.
	 */
	public native HandlerRegistration addStateRestoreHandler(
			StateRestoreHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, st, e) {
			var component = @com.eemi.ext4j.client.core.Component::createComponent(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var state = @com.eemi.ext4j.client.core.State::new(Lcom/google/gwt/core/client/JavaScriptObject;)(st);
			var event = @com.eemi.ext4j.client.events.component.StateRestoreEvent::new(Lcom/eemi/ext4j/client/core/Component;Lcom/eemi/ext4j/client/core/State;Lcom/google/gwt/core/client/JavaScriptObject;)(event,state,e);
			handler.@com.eemi.ext4j.client.events.component.StateRestoreHandler::onStateRestore(Lcom/eemi/ext4j/client/events/component/StateRestoreEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.component.StateRestoreEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

	/**
	 * Fires after the state of the object is saved to the configured state
	 * provider.
	 */
	public native HandlerRegistration addStateSaveHandler(
			StateSaveHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, st, e) {
			var component = @com.eemi.ext4j.client.core.Component::createComponent(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var state = @com.eemi.ext4j.client.core.State::new(Lcom/google/gwt/core/client/JavaScriptObject;)(st);
			var event = @com.eemi.ext4j.client.events.component.StateSaveEvent::new(Lcom/eemi/ext4j/client/core/Component;Lcom/eemi/ext4j/client/core/State;Lcom/google/gwt/core/client/JavaScriptObject;)(event,state,e);
			handler.@com.eemi.ext4j.client.events.component.StateSaveHandler::onStateSave(Lcom/eemi/ext4j/client/events/component/StateSaveEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.component.StateSaveEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
	}-*/;

}
