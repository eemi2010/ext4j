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

import com.ati.ext4j.client.core.Component;
import com.ati.ext4j.client.field.FieldBase;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.editor.client.IsEditor;
import com.google.gwt.editor.client.LeafValueEditor;
import com.google.gwt.editor.client.adapters.TakesValueEditor;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasValue;

/**
 * A display-only text field which is not validated and not submitted. This is
 * useful for when you want to display a value from a form's loaded data but do
 * not want to allow the user to edit or submit that value. The value can be
 * optionally HTML encoded if it contains HTML markup that you do not want to be
 * rendered.
 * <p>
 * If you have more complex content, or need to include components within the
 * displayed content, also consider using a Ext.form.FieldContainer instead.
 */
public class Display extends FieldBase implements HasValue<String>, IsEditor<LeafValueEditor<String>> {

    private LeafValueEditor<String> editor;

    private static JavaScriptObject configPrototype;

    private static native void init()/*-{
		var c = new $wnd.Ext.form.field.Display();
		@com.ati.ext4j.client.ui.Display::configPrototype = c.initialConfig;
    }-*/;

    protected JavaScriptObject getConfigPrototype() {
        return configPrototype;
    }

    public String getXType() {
        return "dislay";
    }

    /**
     * Create a new Display.
     */
    public Display() {
    }

    protected Display(JavaScriptObject jsObj) {
        super(jsObj);
    }

    protected native JavaScriptObject create(JavaScriptObject jsObj) /*-{
		return new $wnd.Ext.form.field.Display(jsObj);
    }-*/;

    /**
     * Automatically grows the field to accomodate the width of the text up to
     * the maximum field width allowed. This only takes effect if grow = true,
     * and fires the autosize event.
     */
    public native void autoSize() /*-{
		var field = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		field.autoSize();
    }-*/;

    // --- config properties ---

    /**
     * The default CSS class for the field.
     * <p>
     * Defaults to: "x-form-display-field"
     */
    public void setFielsCls(String value) {
        setAttribute("fieldCls", value, true, true);
    }

    /**
     * True to escape HTML in text when rendering it.
     * <p>
     * Defaults to: false
     */
    public void setHtmlEncode(boolean value) {
        setAttribute("htmlEncode", value, true, true);
    }

    /**
     * True to escape HTML in text when rendering it.
     * <p>
     * Defaults to: false
     */
    public void setSubmitValue(boolean value) {
        setAttribute("submitValue", value, true, true);
    }

    /**
     * Creates a new Display from the given component
     * 
     * @param component
     *            , the component to cast from
     * @return, a new Display from the component
     * 
     */
    public static Display cast(Component component) {
        return new Display(component.getOrCreateJsObj());
    }

    @Override
    public HandlerRegistration addValueChangeHandler(ValueChangeHandler<String> handler) {
        return null;
    }

    @Override
    public LeafValueEditor<String> asEditor() {
        if (editor == null) {
            editor = TakesValueEditor.of(this);
        }
        return editor;
    }

    @Override
    public String getValue() {
        return _getValue();
    }

    @Override
    public void setValue(String value) {
        _setValue(value);
    }

    @Override
    public void setValue(String value, boolean fireEvents) {
        _setValue(value);
    }

    private native void _setValue(String value) /*-{
		var cb = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		cb.setValue(value);
    }-*/;

    private native String _getValue() /*-{
		var cb = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var val = cb.getValue();
		if (val === undefined)
			return null;
		return val === '' ? null : val.toString();
    }-*/;

}
