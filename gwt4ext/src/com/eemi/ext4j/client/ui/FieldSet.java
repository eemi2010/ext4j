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
package com.eemi.ext4j.client.ui;

import com.eemi.ext4j.client.core.Component;
import com.eemi.ext4j.client.events.form.BeforeCollapseHandler;
import com.eemi.ext4j.client.events.form.BeforeExpandHandler;
import com.eemi.ext4j.client.events.form.CollapseHandler;
import com.eemi.ext4j.client.events.form.ExpandHandler;
import com.eemi.ext4j.client.events.form.FieldSetBeforeCollapseHandler;
import com.eemi.ext4j.client.events.form.FieldSetBeforeExpandHandler;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.shared.HandlerRegistration;

/**
 * A container for grouping sets of fields, rendered as a HTML fieldset element.
 * The title config will be rendered as the fieldset's legend.
 * <p>
 * While FieldSets commonly contain simple groups of fields, they are general
 * Containers and may therefore contain any type of components in their items,
 * including other nested containers. The default layout for the FieldSet's
 * items is 'anchor', but it can be configured to use any other layout type.
 * 
 */
public class FieldSet extends Container {

    private static JavaScriptObject configPrototype;

    private static native void init()/*-{
		var c = new $wnd.Ext.form.FieldSet();
		@com.eemi.ext4j.client.ui.FieldSet::configPrototype = c.initialConfig;
    }-*/;

    protected JavaScriptObject getConfigPrototype() {
        return configPrototype;
    }

    public String getXType() {
        return "fieldset";
    }

    /**
     * Creates a new FieldSet.
     */
    public FieldSet() {

    }

    public FieldSet(String title) {
        setTitle(title);

    }

    public FieldSet(JavaScriptObject jsObj) {
        super(jsObj);
    }

    protected native JavaScriptObject create(JavaScriptObject jsObj) /*-{
		return new $wnd.Ext.form.FieldSet(jsObj);
    }-*/;

    // --- config properties ---

    /**
     * The base CSS class applied to the fieldset (defaults to 'x-fieldset').
     * 
     * @param baseCls
     *            the base CSS class applied to the fieldset (defaults to
     *            'x-fieldset').
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setBaseCls(String baseCls) throws IllegalStateException {
        setAttribute("baseCls", baseCls, true);
    }

    /**
     * The name to assign to the fieldset's checkbox if checkboxToggle = true
     * (defaults to '[checkbox id]-checkbox').
     * 
     * @param checkboxName
     *            the name to assign to the fieldset's checkbox if
     *            checkboxToggle = true (defaults to '[checkbox id]-checkbox').
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setCheckboxName(String checkboxName) throws IllegalStateException {
        setAttribute("checkboxName", checkboxName, true);
    }

    /**
     * True to render a checkbox into the fieldset frame just in front of the
     * legend (defaults to false). The fieldset will be expanded or collapsed
     * when the checkbox is toggled.
     * 
     * @param checkboxToggle
     *            true to render a checkbox into the fieldset frame just in
     *            front of the legend (defaults to false).
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setCheckboxToggle(boolean checkboxToggle) throws IllegalStateException {
        setAttribute("checkboxToggle", checkboxToggle, true);
    }

    /**
     * Set to true to make the fieldset collapsible and have the expand/collapse
     * toggle button automatically rendered into the legend element, false to
     * keep the fieldset statically sized with no collapse button. Another
     * option is to configure checkboxToggle. Use the collapsed config to
     * collapse the fieldset by default.
     * <p>
     * Defaults to: false
     * 
     * @param value
     */
    public void setCallapsible(boolean value) {
        setAttribute("collapsible", value, true);
    }

    /**
     * Set to true to render the fieldset as collapsed by default. If
     * checkboxToggle is specified, the checkbox will also be unchecked by
     * default.
     * <p>
     * Defaults to: false
     */
    public void setCallapsed(boolean value) {
        setAttribute("collapsed", value, true);
    }

    /**
     * Set to true will add a listener to the titleCmp property for the click
     * event which will execute the toggle method. This option is only used when
     * the collapsible property is set to true.
     * <p>
     * Defaults to: true
     */
    public void setToggleOnTitleClick(boolean value) {
        setAttribute("toggleOnTitleClick", value, true);
    }

    /**
     * Collapses the fieldset.
     * 
     * @return this
     */
    public native FieldSet collapse() /*-{
		var container = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		container.collapse();
		return this;
    }-*/;

    /**
     * Expands the fieldset.
     * 
     * @return this
     */
    public native FieldSet expand() /*-{
		var container = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		container.expand();
		return this;
    }-*/;

    /**
     * Sets the title of this fieldset.
     * 
     * @return this
     */
    public native void setTitle(String value) /*-{
		var container = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		container.setTitle(value);
    }-*/;

    /**
     * Toggle the fieldset's collapsed state to the opposite of what it is
     * currently.
     */
    public native void toggle() /*-{
		var container = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		container.toggle();
    }-*/;

    /**
     * Fires before this FieldSet is collapsed.
     * 
     * @param handler
     *            , the handler that will handle the event
     */
    public native HandlerRegistration addBeforeCollapseHandler(BeforeCollapseHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(f, e) {
			var fs = @com.eemi.ext4j.client.ui.FieldSet::new(Lcom/google/gwt/core/client/JavaScriptObject;)(t);
			var event = @com.eemi.ext4j.client.events.form.BeforeCollapseEvent::new(Lcom/eemi/ext4j/client/ui/FieldSet;Lcom/google/gwt/core/client/JavaScriptObject;)(fs,e);
			handler.@com.eemi.ext4j.client.events.form.BeforeCollapseHandler::onBeforeCollapse(Lcom/eemi/ext4j/client/events/form/BeforeCollapseEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.form.BeforeCollapseEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * Fires before this FieldSet is collapsed.Return false to prevent the
     * collapse.
     * 
     * @param handler
     *            , the handler that will handle the event
     */
    public native void addBeforeCollapseHandler(FieldSetBeforeCollapseHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		if (component) {
			component
					.addListener(
							@com.eemi.ext4j.client.events.form.BeforeCollapseEvent::EVENT_NAME,
							$entry(function(fs) {
								var fieldSet = @com.eemi.ext4j.client.ui.FieldSet::new(Lcom/google/gwt/core/client/JavaScriptObject;)(fs);
								return handler.@com.eemi.ext4j.client.events.form.FieldSetBeforeCollapseHandler::onEvent(Lcom/eemi/ext4j/client/ui/FieldSet;)(fieldSet);
							}));
		}

    }-*/;

    /**
     * Fires before this FieldSet is expanded.
     * 
     * @param handler
     *            , the handler that will handle the event
     */
    public native HandlerRegistration addBeforeExpandHandler(BeforeExpandHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(f, e) {
			var fs = @com.eemi.ext4j.client.ui.FieldSet::new(Lcom/google/gwt/core/client/JavaScriptObject;)(t);
			var event = @com.eemi.ext4j.client.events.form.BeforeExpandEvent::new(Lcom/eemi/ext4j/client/ui/FieldSet;Lcom/google/gwt/core/client/JavaScriptObject;)(fs,e);
			handler.@com.eemi.ext4j.client.events.form.BeforeExpandHandler::onBeforeExpand(Lcom/eemi/ext4j/client/events/form/BeforeExpandEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.form.BeforeExpandEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * Fires before this FieldSet is expanded.Return false to prevent the
     * collapse.
     * 
     * @param handler
     *            , the handler that will handle the event
     */
    public native void addBeforeExoandHandler(FieldSetBeforeExpandHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		if (component) {
			component
					.addListener(
							@com.eemi.ext4j.client.events.form.BeforeExpandEvent::EVENT_NAME,
							$entry(function(fs) {
								var fieldSet = @com.eemi.ext4j.client.ui.FieldSet::new(Lcom/google/gwt/core/client/JavaScriptObject;)(fs);
								return handler.@com.eemi.ext4j.client.events.form.FieldSetBeforeExpandHandler::onEvent(Lcom/eemi/ext4j/client/ui/FieldSet;)(fieldSet);
							}));
		}

    }-*/;

    /**
     * Fires after this FieldSet has collapsed.
     * 
     * @param handler
     *            , the handler that will handle the event
     */
    public native HandlerRegistration addCollapseHandler(CollapseHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(f, e) {
			var fs = @com.eemi.ext4j.client.ui.FieldSet::new(Lcom/google/gwt/core/client/JavaScriptObject;)(t);
			var event = @com.eemi.ext4j.client.events.form.CollapseEvent::new(Lcom/eemi/ext4j/client/ui/FieldSet;Lcom/google/gwt/core/client/JavaScriptObject;)(fs,e);
			handler.@com.eemi.ext4j.client.events.form.CollapseHandler::onCollapse(Lcom/eemi/ext4j/client/events/form/CollapseEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.form.CollapseEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * Fires after this FieldSet has expanded.
     * 
     * @param handler
     *            , the handler that will handle the event
     */
    public native HandlerRegistration addExpandHandler(ExpandHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(f, e) {
			var fs = @com.eemi.ext4j.client.ui.FieldSet::new(Lcom/google/gwt/core/client/JavaScriptObject;)(t);
			var event = @com.eemi.ext4j.client.events.form.ExpandEvent::new(Lcom/eemi/ext4j/client/ui/FieldSet;Lcom/google/gwt/core/client/JavaScriptObject;)(fs,e);
			handler.@com.eemi.ext4j.client.events.form.ExpandHandler::onExpand(Lcom/eemi/ext4j/client/events/form/ExpandEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.form.ExpandEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    public static FieldSet cast(Component component) {
        return new FieldSet(component.getOrCreateJsObj());
    }

}
