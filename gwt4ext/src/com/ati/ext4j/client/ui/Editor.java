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

import java.util.Date;

import com.ati.ext4j.client.core.Component;
import com.ati.ext4j.client.events.HandlerRegistration;
import com.ati.ext4j.client.events.editor.BeforeCompleteHandler;
import com.ati.ext4j.client.events.editor.BeforeStartEditHandler;
import com.ati.ext4j.client.events.editor.CancelEditHandler;
import com.ati.ext4j.client.events.editor.CompleteHandler;
import com.ati.ext4j.client.events.editor.EditorBeforeCompleteHandler;
import com.ati.ext4j.client.events.editor.EditorBeforeStartEditHandler;
import com.ati.ext4j.client.events.editor.SpecialKeyHandler;
import com.ati.ext4j.client.events.editor.StartEditHandler;
import com.ati.ext4j.client.field.Field;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;

/**
 * A base editor field that handles displaying/hiding on demand and has some
 * built-in sizing and event handling logic.
 */
public class Editor extends Container {

    private static JavaScriptObject configPrototype;
    private Field field;

    static {
        // init();
    }

    private static native void init()/*-{
		var c = new $wnd.Ext.Editor();
		@com.ati.ext4j.client.ui.Editor::configPrototype = c.initialConfig;
    }-*/;

    protected JavaScriptObject getConfigPrototype() {
        return configPrototype;
    }

    public String getXType() {
        return "editor";
    }

    public Editor() {
    }

    // todo2 field must be rendered at this point
    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		var field = this.@com.ati.ext4j.client.ui.Editor::field;
		var fieldJS = field.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var ed = new $wnd.Ext.Editor(fieldJS, config);
		var id = ed.getId();
		this.@com.ati.ext4j.client.core.Component::id = id;
		return ed;
    }-*/;

    /**
     * Create a new Editor.
     * 
     * @param field
     *            the editor field
     */
    public Editor(Field field) {
        this.field = field;
    }

    public Editor(JavaScriptObject jsObj) {
        super(jsObj);
    }

    private native JavaScriptObject create(JavaScriptObject field, JavaScriptObject config) /*-{
		return new $wnd.Ext.Editor(field, config);
    }-*/;

    /**
     * Cancels the editing process and hides the editor without persisting any
     * changes. The field value will be reverted to the original starting value.
     * 
     * @param remainVisible
     *            override the default behavior and keep the editor visible
     *            after cancel (defaults to false)
     */
    public native void cancelEdit(boolean remainVisible) /*-{
		var editor = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		editor.cancelEdit();
    }-*/;

    /**
     * Ends the editing process, persists the changed value to the underlying
     * field, and hides the editor.
     * 
     * @param remainVisible
     *            Override the default behavior and keep the editor visible
     *            after edit (defaults to false)
     */
    public native void completeEdit(boolean remainVisible) /*-{
		var editor = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		editor.completeEdit(true);
    }-*/;

    /**
     * Gets the data value of the editor.
     * 
     * @return the value as String
     */
    public native String getValueAsString() /*-{
		var editor = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var val = editor.getValue();
		return val == null ? null : val.toString();
    }-*/;

    /**
     * Gets the data value of the editor.
     * 
     * @return the editor value
     */
    public native Object getValue()/*-{
		var editor = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var val = editor.getValue();
		var valJ = (val == null || val === undefined || val === '') ? null
				: $wnd.GwtExt.convertToJavaType(val);
		return valJ;
    }-*/;

    /**
     * Realigns the editor to the bound field based on the current alignment
     * config value.
     */
    public native void realign() /*-{
		var editor = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		editor.realign();
    }-*/;

    /**
     * Sets the height and width of this editor.
     * 
     * @param width
     *            the new width
     * @param height
     *            the new height
     */
    public native void setSize(int width, int height) /*-{
		var editor = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		editor.setSize(width, height);
    }-*/;

    /**
     * Sets the data value of the editor.
     * 
     * @param value
     *            the value
     */
    private native void setValueRendered(String value) /*-{
		var editor = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		editor.setValue(value);
    }-*/;

    /**
     * Sets the data value of the editor.
     * 
     * @param value
     *            the value
     */
    public native void setValueRendered(boolean value) /*-{
		var editor = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		editor.setValue(value);
    }-*/;

    /**
     * Sets the data value of the editor.
     * 
     * @param value
     *            the value
     */
    private native void setValueRendered(double value) /*-{
		var editor = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		editor.setValue(value);
    }-*/;

    /**
     * Sets the data value of the editor.
     * 
     * @param value
     *            the value
     */
    public native void setValueRendered(Date value)/*-{
		var millis = @com.ati.ext4j.client.util.DateUtil::getTime(Ljava/util/Date;)(value);
		var dateJS = new $wnd.Date(millis);
		var editor = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		editor.setValue(dateJS);
    }-*/;

    /**
     * Starts the editing process and shows the editor.
     * 
     * @param id
     *            the element ID to edit
     */
    public native void startEdit(String id) /*-{
		var editor = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		editor.startEdit(id);
    }-*/;

    /**
     * Starts the editing process and shows the editor.
     * 
     * @param id
     *            the element ID to edit
     * @param value
     *            A value to initialize the editor with. If a value is not
     *            provided, it defaults to the innerHTML of the element.
     */
    public native void startEdit(String id, String value) /*-{
		var editor = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		editor.startEdit(id, value);
    }-*/;

    /**
     * Starts the editing process and shows the editor.
     * 
     * @param el
     *            the element to edit
     */
    public native void startEdit(Element el) /*-{
		var editor = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		editor.startEdit(el);
    }-*/;

    /**
     * Starts the editing process and shows the editor.
     * 
     * @param el
     *            the element to edit
     * @param value
     *            A value to initialize the editor with. If a value is not
     *            provided, it defaults to the innerHTML of the element.
     */
    public native void startEdit(Element el, String value) /*-{
		var editor = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		editor.startEdit(el, value);
    }-*/;

    // --- config properties ---

    /**
     * The position to align to.
     * 
     * @param anchorPosition
     *            defaults to "c-c"
     */
    public void setAlignment(String anchorPosition) {
        setAttribute("alignment", anchorPosition, true, true);
    }

    /**
     * True for the editor to automatically adopt the size of the underlying
     * field.
     * 
     * @param autosize
     *            true to autosize
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setAutosize(boolean autosize) throws IllegalStateException {
        setAttribute("autosize", autosize, true);
    }

    /**
     * Set to "width" to adopt the width only, or "height" to adopt the height
     * only.
     * 
     * @param autosize
     *            the autosize value
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setAutosize(String autosize) throws IllegalStateException {
        setAttribute("autosize", autosize, true);
    }

    /**
     * True to cancel the edit when the escape key is pressed (defaults to
     * false).
     * 
     * @param cancelOnEsc
     *            cancel on escape
     */
    public void setCancelOnEsc(boolean cancelOnEsc) {
        setAttribute("cancelOnEsc", cancelOnEsc, true, true);
    }

    /**
     * True to complete the edit when the enter key is pressed (defaults to
     * false).
     * 
     * @param completeOnEnter
     *            true to complete on enter
     */
    public void setCompleteOnEnter(boolean completeOnEnter) {
        setAttribute("completeOnEnter", completeOnEnter, true, true);
    }

    /**
     * True to constrain the editor to the viewport.
     * 
     * @param constrain
     *            true to constrain the editor to the viewport
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setConstrain(boolean constrain) throws IllegalStateException {
        setAttribute("constrain", constrain, true);
    }

    // todo2 on rendere pass field to object constructor
    public void setField(Field field) {
        this.field = field;
    }

    /**
     * False to keep the bound element visible while the editor is displayed
     * (defaults to true).
     * 
     * @param hideEl
     *            true to hide element
     */
    public void setHideEl(boolean hideEl) {
        setAttribute("hideEl", hideEl, true, true);
    }

    /**
     * True to skip the the edit completion process (no save, no events fired)
     * if the user completes an edit and the value has not changed (defaults to
     * false). Applies only to string values - edits for other data types will
     * never be ignored.
     * 
     * @param ignoreNoChange
     *            true to ingnore no change
     */
    public void setIgnoreNoChange(boolean ignoreNoChange) {
        setAttribute("ignoreNoChange", ignoreNoChange, true, true);
    }

    /**
     * True to automatically revert the field value and cancel the edit when the
     * user completes an edit and the field validation fails (defaults to true).
     * 
     * @param revertInvalid
     *            true to rever invalid field value
     */
    public void setRevertInvalid(boolean revertInvalid) {
        setAttribute("revertInvalid", revertInvalid, true, true);
    }

    /**
     * "sides" for sides/bottom only, "frame" for 4-way shadow, and "drop" for
     * bottom-right shadow (defaults to "frame")
     * 
     * @param shadow
     *            the shadow setting
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setShadow(boolean shadow) throws IllegalStateException {
        setAttribute("shadow", shadow, true);
    }

    /**
     * "sides" for sides/bottom only, "frame" for 4-way shadow, and "drop" for
     * bottom-right shadow (defaults to "frame")
     * 
     * @param shadow
     *            the shadow setting
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setShadow(String shadow) throws IllegalStateException {
        setAttribute("shadow", shadow, true);
    }

    /**
     * Handle the keydown/keypress events so they don't propagate (defaults to
     * true).
     * 
     * @param swallowKeys
     *            true to swallow keys
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setSwallowKeys(boolean swallowKeys) throws IllegalStateException {
        setAttribute("swallowKeys", swallowKeys, true);
    }

    /**
     * True to update the innerHTML of the bound element when the update
     * completes (defaults to false).
     * 
     * @param updateEl
     *            true to update the element
     */
    public void setUpdateEl(boolean updateEl) {
        setAttribute("updateEl", updateEl, true, true);
    }

    /**
     * The data value of the underlying field (defaults to "").
     * 
     * @param value
     *            the field value
     */
    public void setValue(String value) {
        if (!isRendered()) {
            setAttribute("value", value, true);
        } else {
            setValueRendered(value);
        }
    }

    /**
     * The data value of the underlying field (defaults to "").
     * 
     * @param value
     *            the field value
     */
    public void setValue(Date value) {
        if (!isRendered()) {
            setAttribute("value", value, true);
        } else {
            setValueRendered(value);
        }
    }

    /**
     * The data value of the underlying field (defaults to "").
     * 
     * @param value
     *            the field value
     */
    public void setValue(long value) {
        if (!isRendered()) {
            setAttribute("value", value, true);
        } else {
            setValueRendered(value);
        }
    }

    /**
     * The data value of the underlying field (defaults to "").
     * 
     * @param value
     *            the field value
     */
    public void setValue(double value) {
        if (!isRendered()) {
            setAttribute("value", value, true);
        } else {
            setValueRendered(value);
        }
    }

    /**
     * The data value of the underlying field (defaults to "").
     * 
     * @param value
     *            the field value
     */
    public void setValue(boolean value) {
        if (!isRendered()) {
            setAttribute("value", value, true);
        } else {
            setValueRendered(value);
        }
    }

    /**
     * Fires after a change has been made to the field, but before the change is
     * reflected in the underlying field. Note that if the value has not changed
     * and ignoreNoChange = true, the editing will still end but this event will
     * not fire since no edit actually occurred.
     */
    public native HandlerRegistration addBeforeCompleteHandler(BeforeCompleteHandler handler)/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(editor, value, olValue, e) {
			var cmp = @com.ati.ext4j.client.ui.Editor::new(Lcom/google/gwt/core/client/JavaScriptObject;)(editor);
			var event = @com.ati.ext4j.client.events.editor.BeforeCompleteEvent::new(Lcom/ati/ext4j/client/ui/Editor;Ljava/lang/Object;Ljava/lang/Object;Lcom/google/gwt/core/client/JavaScriptObject;)(cpm,value, oldValue,e)
			handler.@com.ati.ext4j.client.events.editor.BeforeCompleteHandler::onBeforeCompete(Lcom/ati/ext4j/client/events/editor/BeforeCompleteEvent;)(event);
		};
		var eventName = @com.ati.ext4j.client.events.editor.BeforeCompleteEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ati.ext4j.client.events.HandlerRegistration::new(Lcom/ati/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * Fires after a change has been made to the field, but before the change is
     * reflected in the underlying field. Saving the change to the field can be
     * canceled by returning false from the handler of this event.Note that if
     * the value has not changed and ignoreNoChange = true, the editing will
     * still end but this event will not fire since no edit actually occurred.
     */
    public native void addBeforeCompleteHandler(EditorBeforeCompleteHandler handler)/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		compoenent
				.addListener(
						@com.ati.ext4j.client.events.Event::BEFORE_COMPLETE,
						$entry(function(editor, value, olValue) {
							var cmp = @com.ati.ext4j.client.ui.Editor::new(Lcom/google/gwt/core/client/JavaScriptObject;)(editor);
							return handler.@com.ati.ext4j.client.events.editor.EditorBeforeCompleteHandler::onEvent(Lcom/ati/ext4j/client/ui/Editor;Ljava/lang/Object;Ljava/lang/Object;)(cpm,value,OldValue);
						}));

    }-*/;

    /**
     * Fires when editing is initiated, but before the value changes.
     */
    public native HandlerRegistration addBeforeStartEditHandler(BeforeStartEditHandler handler)/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(editor, el, value, e) {
			var cmp = @com.ati.ext4j.client.ui.Editor::new(Lcom/google/gwt/core/client/JavaScriptObject;)(editor);
			var element = @com.ati.ext4j.client.core.ExtElement::new(Lcom/google/gwt/core/client/JavaScriptObject;)(el);
			var event = @com.ati.ext4j.client.events.editor.BeforeStartEditEvent::new(Lcom/ati/ext4j/client/ui/Editor;Lcom/ati/ext4j/client/core/ExtElement;Ljava/lang/Object;Lcom/google/gwt/core/client/JavaScriptObject;)(cpm, element, value, e);
			handler.@com.ati.ext4j.client.events.editor.BeforeStartEditHandler::onBeforeStartEdit(Lcom/ati/ext4j/client/events/editor/BeforeStartEditEvent;)(event);
		};
		var eventName = @com.ati.ext4j.client.events.editor.BeforeStartEditEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ati.ext4j.client.events.HandlerRegistration::new(Lcom/ati/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * Fires when editing is initiated, but before the value changes.Editing can
     * be canceled by returning false from the handler of this event.
     */
    public native void addBeforeStartEditHandler(EditorBeforeStartEditHandler handler)/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		compoenent
				.addListener(
						@com.ati.ext4j.client.events.Event::BEFORE_START_EDIT,
						$entry(function(editor, el, value) {
							var cmp = @com.ati.ext4j.client.ui.Editor::new(Lcom/google/gwt/core/client/JavaScriptObject;)(editor);
							var element = @com.ati.ext4j.client.core.ExtElement::new(Lcom/google/gwt/core/client/JavaScriptObject;)(el);
							handler.@com.ati.ext4j.client.events.editor.EditorBeforeStartEditHandler::onEvent(Lcom/ati/ext4j/client/ui/Editor;Lcom/ati/ext4j/client/core/ExtElement;Ljava/lang/Object;)(cmp,element,value);
						}));
    }-*/;

    /**
     * Fires after editing has been canceled and the editor's value has been
     * reset.
     */
    public native HandlerRegistration addCancelEditHandler(CancelEditHandler handler)/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(editor, value, startValue, e) {
			var cmp = @com.ati.ext4j.client.ui.Editor::new(Lcom/google/gwt/core/client/JavaScriptObject;)(editor);
			var event = @com.ati.ext4j.client.events.editor.CancelEditEvent::new(Lcom/ati/ext4j/client/ui/Editor;Ljava/lang/Object;Ljava/lang/Object;Lcom/google/gwt/core/client/JavaScriptObject;)(cmp, value, startValue, e);
			handler.@com.ati.ext4j.client.events.editor.CancelEditHandler::onCancelEdit(Lcom/ati/ext4j/client/events/editor/CancelEditEvent;)(event);
		};
		var eventName = @com.ati.ext4j.client.events.editor.CancelEditEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ati.ext4j.client.events.HandlerRegistration::new(Lcom/ati/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * Fires after editing is complete and any changed value has been written to
     * the underlying field.
     */
    public native HandlerRegistration addCompleteEditHandler(CompleteHandler handler)/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(editor, value, startValue, e) {
			var cmp = @com.ati.ext4j.client.ui.Editor::new(Lcom/google/gwt/core/client/JavaScriptObject;)(editor);
			var event = @com.ati.ext4j.client.events.editor.CompleteEvent::new(Lcom/ati/ext4j/client/ui/Editor;Ljava/lang/Object;Ljava/lang/Object;Lcom/google/gwt/core/client/JavaScriptObject;)(cmp, value, startValue, e);
			handler.@com.ati.ext4j.client.events.editor.CompleteHandler::onComplete(Lcom/ati/ext4j/client/events/editor/CompleteEvent;)(event);
		};
		var eventName = @com.ati.ext4j.client.events.editor.CompleteEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ati.ext4j.client.events.HandlerRegistration::new(Lcom/ati/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * Fires when any key related to navigation (arrows, tab, enter, esc, etc.)
     * is pressed. You can check Ext.EventObject.getKey to determine which key
     * was pressed.
     */
    public native HandlerRegistration addSpecialKeyHandler(SpecialKeyHandler handler)/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(editor, f, e) {
			var cmp = @com.ati.ext4j.client.ui.Editor::new(Lcom/google/gwt/core/client/JavaScriptObject;)(editor);
			var field = @com.ati.ext4j.client.field.FieldBase::new(Lcom/google/gwt/core/client/JavaScriptObject;)(f);
			var event = @com.ati.ext4j.client.events.editor.SpecialKeyEvent::new(Lcom/ati/ext4j/client/ui/Editor;Lcom/ati/ext4j/client/field/FieldBase;Lcom/google/gwt/core/client/JavaScriptObject;)(cmp,field,e);
			handler.@com.ati.ext4j.client.events.editor.SpecialKeyHandler::onSpecialKey(Lcom/ati/ext4j/client/events/editor/SpecialKeyEvent;)(event);
		};
		var eventName = @com.ati.ext4j.client.events.editor.SpecialKeyEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ati.ext4j.client.events.HandlerRegistration::new(Lcom/ati/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * Fires when this editor is displayed
     */
    public native HandlerRegistration addStartEditHandler(StartEditHandler handler)/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(editor, el, value, e) {
			var cmp = @com.ati.ext4j.client.ui.Editor::new(Lcom/google/gwt/core/client/JavaScriptObject;)(editor);
			var element = @com.ati.ext4j.client.core.ExtElement::new(Lcom/google/gwt/core/client/JavaScriptObject;)(el);
			var event = @com.ati.ext4j.client.events.editor.StartEditEvent::new(Lcom/ati/ext4j/client/ui/Editor;Lcom/ati/ext4j/client/core/ExtElement;Ljava/lang/Object;Lcom/google/gwt/core/client/JavaScriptObject;)(cpm, element, value, e);
			handler.@com.ati.ext4j.client.events.editor.StartEditHandler::onStartEdit(Lcom/ati/ext4j/client/events/editor/StartEditEvent;)(event);
		};
		var eventName = @com.ati.ext4j.client.events.editor.StartEditEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ati.ext4j.client.events.HandlerRegistration::new(Lcom/ati/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    public static Editor cast(Component component) {
        return new Editor(component.getOrCreateJsObj());
    }

}