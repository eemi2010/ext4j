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
package com.ait.ext4j.client.ui;

import com.ait.ext4j.client.core.Component;
import com.ait.ext4j.client.field.FieldBase;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.editor.client.IsEditor;
import com.google.gwt.editor.client.LeafValueEditor;
import com.google.gwt.editor.client.adapters.TakesValueEditor;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasValue;

/**
 * A basic hidden field for storing hidden values in forms that need to be
 * passed in the form submit.
 * 
 * This creates an actual input element with type="submit" in the DOM. While its
 * label is not rendered by default, it is still a real component and may be
 * sized according to its owner container's layout.
 * 
 * Because of this, in most cases it is more convenient and less problematic to
 * simply pass hidden parameters directly when submitting the form.
 */
public class Hidden extends FieldBase implements HasValue<String>, IsEditor<LeafValueEditor<String>> {

    private static JavaScriptObject configPrototype;
    private LeafValueEditor<String> editor;

    private static native void init()/*-{
		var c = new $wnd.Ext.form.field.Hidden();
		@com.ait.ext4j.client.ui.Hidden::configPrototype = c.initialConfig;
    }-*/;

    protected JavaScriptObject getConfigPrototype() {
        return configPrototype;
    }

    public String getXType() {
        return "hidden";
    }

    /**
     * Create a new hidden field.
     */
    public Hidden() {
    }

    /**
     * Create a new hidden field.
     * 
     * @param name
     *            the field name
     * @param value
     *            the field value
     */
    public Hidden(String name, String value) {
        setName(name);
        setValue(value);
    }

    public Hidden(JavaScriptObject jsObj) {
        super(jsObj);
    }

    protected native JavaScriptObject create(JavaScriptObject jsObj) /*-{
		return new $wnd.Ext.form.field.Hidden(jsObj);
    }-*/;

    private native void _setValue(String value) /*-{
		var field = this.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()();
		field.setValue(value);
    }-*/;

    private native String _getValue() /*-{
		var cb = this.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()();
		var val = cb.getValue();
		if (val === undefined)
			return null;
		return val === '' ? null : val.toString();
    }-*/;

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

    /**
     * Creates a new Hidden from the given component
     * 
     * @param component
     *            , the component to cast from
     * @return, a new Hidden from the component
     * 
     */
    public static Hidden cast(Component component) {
        return new Hidden(component.getOrCreateJsObj());
    }
}
