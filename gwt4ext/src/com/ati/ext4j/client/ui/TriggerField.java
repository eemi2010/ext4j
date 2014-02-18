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
package com.ati.ext4j.client.ui;

import com.ati.ext4j.client.core.CompositeElement;
import com.ati.ext4j.client.core.EventObject;
import com.ati.ext4j.client.core.ExtElement;
import com.ati.ext4j.client.util.ClickRepeater;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;

/**
 * Provides a convenient wrapper for TextFields that adds a clickable trigger
 * button (looks like a combobox by default). The trigger has no default action,
 * so you mustimplement the trigger click handler by overriding
 * {@link #onTriggerClick(com.gwtext.client.core.EventObject)}. You can create a
 * TriggerField directly, as it renders exactly like a combobox for which you
 * can provide a custom implementation.
 * 
 */
public abstract class TriggerField extends TextField {

    /**
     * Construct a new TriggerField.
     */
    public TriggerField() {
    }

    public TriggerField(JavaScriptObject jsObj) {
        super(jsObj);
    }

    protected void initComponent() {
        super.initComponent();
        setup(this, getJsObj());
    }

    protected native Element getElement(JavaScriptObject jsObj) /*-{
		//for trigger fields, we want the text area as well as the trigger button to be treated as the element
		//unit
		var extEl = jsObj.wrap;
		if (extEl == null || extEl === undefined) {
			return null;
		}
		var el = extEl.dom;
		if (el == null || el === undefined) {
			return null;
		} else {
			return el.dom || el;
		}
    }-*/;

    private native void setup(TriggerField triggerField, JavaScriptObject jsObj) /*-{
		jsObj.onTriggerClick = function(event) {
			var e = @com.ati.ext4j.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
			triggerField.@com.ati.ext4j.client.ui.TriggerField::onTriggerClick(Lcom/ati/ext4j/client/core/EventObject;)(e);
		}
    }-*/;

    protected native JavaScriptObject create(JavaScriptObject jsObj) /*-{
		return new $wnd.Ext.form.TriggerField(jsObj);
    }-*/;

    /**
     * Abstract method that must be implmented for custom trigger field
     * behavior.
     * 
     * @param event
     *            the event object
     */
    protected abstract void onTriggerClick(EventObject event);

    // config properties ---
    public String getXType() {
        return "trigger";
    }

    /**
     * True to hide the trigger element and display only the base text field
     * (defaults to false).
     * 
     * @param hideTrigger
     *            true to hide trigger
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setHideTrigger(boolean hideTrigger) throws IllegalStateException {
        setAttribute("hideTrigger", hideTrigger, true);
    }

    /**
     * A CSS class to apply to the trigger.
     * 
     * @param triggerClass
     *            the trigger CSS class.
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setTriggerCls(String triggerClass) throws IllegalStateException {
        setAttribute("triggerCls", triggerClass, true);
    }

    /**
     * The base CSS class that is always added to the trigger button. The
     * triggerCls will be appended in addition to this class.
     * <p>
     * Defaults to: Ext.baseCSSPrefix + 'form-trigger'
     * 
     * @param triggerClass
     *            the trigger CSS class.
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setTriggerBaseCls(String triggerClass) throws IllegalStateException {
        setAttribute("triggerBaseCls", triggerClass, true);
    }

    /**
     * The CSS class that is added to the text field when component is read-only
     * or not editable.
     * <p>
     * Defaults to: Ext.baseCSSPrefix + 'trigger-noedit'
     * 
     * @param triggerClass
     *            the trigger CSS class.
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setTriggerNoEditCls(String value) throws IllegalStateException {
        setAttribute("triggerNoEditCls", value, true);
    }

    /**
     * The CSS class that is added to the div wrapping the trigger button(s).
     * <p>
     * Defaults to: Ext.baseCSSPrefix + 'form-trigger-wrap'
     * 
     * @param triggerClass
     *            the trigger CSS class.
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setTriggerWrapCls(String value) throws IllegalStateException {
        setAttribute("triggerWrapCls", value, true);
    }

    /**
     * false to prevent the user from typing text directly into the field; the
     * field can only have its value set via an action invoked by the trigger.
     * <p>
     * Defaults to: true
     */
    public void setEditable(boolean value) {
        setAttribute("editable", value, true);
    }

    /**
     * true to attach a{@link ClickRepeater} to the trigger.
     * <p>
     * Defaults to: false
     */
    public void setRepeatTriggerClick(boolean value) {
        setAttribute("repeatTriggerClick", value, true);
    }

    /**
     * A reference to the TD element wrapping the input element. Only set after
     * the field has been rendered.
     */
    public native ExtElement getInputCell() /*-{
		var field = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var obj = field.inputCell;
		return @com.ati.ext4j.client.core.ExtElement::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
    }-*/;

    /**
     * A composite of all the trigger button elements. Only set after the field
     * has been rendered.
     */
    public native CompositeElement getTriggerEl() /*-{
		var field = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var obj = field.triggerEl;
		return @com.ati.ext4j.client.core.CompositeElement::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
    }-*/;

    /**
     * A reference to the TABLE element which encapsulates the input field and
     * all trigger button(s). Only set after the field has been rendered.
     */
    public native ExtElement getTriggerWrap() /*-{
		var field = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var obj = field.triggerWrap;
		return @com.ati.ext4j.client.core.ExtElement::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
    }-*/;

}
