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
 * Single checkbox field.
 */
public class CheckBox extends FieldBase implements HasValue<Boolean>, IsEditor<LeafValueEditor<Boolean>> {

    private LeafValueEditor<Boolean> editor;

    private static JavaScriptObject configPrototype;

    static {
        init();
    }

    private static native void init()/*-{
		var c = new $wnd.Ext.form.field.Checkbox();
		@com.ait.ext4j.client.ui.CheckBox::configPrototype = c.initialConfig;
    }-*/;

    protected JavaScriptObject getConfigPrototype() {
        return configPrototype;
    }

    public String getXType() {
        return "checkbox";
    }

    public CheckBox(JavaScriptObject jsObj) {
        super(jsObj);
    }

    /**
     * Creates a new CheckBox field.
     */
    public CheckBox() {
    }

    /**
     * Creates a new CheckBox field.
     * 
     * @param boxLabel
     *            the box label
     */
    public CheckBox(String boxLabel) {
        if (boxLabel != null)
            setBoxLabel(boxLabel);
    }

    /**
     * Creates a new CheckBox field.
     * 
     * @param boxLabel
     *            the box label
     * @param name
     *            the field name
     */
    public CheckBox(String boxLabel, String name) {
        setBoxLabel(boxLabel);
        setName(name);
    }

    protected native JavaScriptObject create(JavaScriptObject config)/*-{
		return new $wnd.Ext.form.field.Checkbox(config);
    }-*/;

    /**
     * Returns the checked state of the checkbox.
     * 
     * @return true if checked, else false
     */
    public Boolean getValue() {
        return isChecked();
    }

    public boolean isChecked() {
        return getAttributeAsBoolean("checked");
    }

    /**
     * Sets the checked state of the checkbox.
     * 
     * @param checked
     *            true to chec the checkbox, false to uncheck it
     */
    public native void setValue(boolean checked) /*-{
		var cb = this.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()();
		cb.setValue(checked);
    }-*/;

    // --- config properties ---

    /**
     * The text that appears beside the checkbox.
     * 
     * @param boxLabel
     *            the box label
     */
    public void setBoxLabel(String boxLabel) {
        setAttribute("boxLabel", boxLabel, true, true);
        setLabelSeparator("&nbsp;");
        if (isRendered()) {
            setFieldLabelRendered(boxLabel, getId());
        }
    }

    /**
     * The box label.
     * 
     * @return the box label
     */
    public String getBoxLabel() {
        return getAttribute("boxLabel");
    }

    private native void setFieldLabelRendered(String fieldLabel, String fieldId) /*-{
		var field = this.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()();
		var label = $wnd.Ext.DomQuery.select($wnd.String.format(
				'label[for="{0}"]', fieldId));
		if (label) {
			//todo preserve user specified labelSeparator and only update the label text.
			//var separator = typeof field.container.labelSeparator == 'undefined' ? field.labelSeparator : field.container.labelSeparator;
			label[0].childNodes[0].nodeValue = fieldLabel;
		}
    }-*/;

    /**
     * True if the the checkbox should render already checked (defaults to
     * false).
     * 
     * @param checked
     *            true to render checked
     */
    public void setChecked(boolean checked) {
        if (!isRendered()) {
            setAttribute("checked", checked, true);
        } else {
            setValue(checked);
        }
    }

    /**
     * The value that should go into the generated input element's value
     * attribute.
     * 
     * @param inputValue
     *            fields input value
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setInputValue(String inputValue) throws IllegalStateException {
        setAttribute("inputValue", inputValue, true);
    }

    /**
     * Creates a new CheckBox from the given component
     * 
     * @param component
     *            , the component to cast from
     * @return, a new CheckBox from the component
     * 
     */
    public static CheckBox cast(Component component) {
        return new CheckBox(component.getOrCreateJsObj());
    }

    @Override
    public HandlerRegistration addValueChangeHandler(ValueChangeHandler<Boolean> handler) {
        return null;
    }

    @Override
    public LeafValueEditor<Boolean> asEditor() {
        if (editor == null) {
            editor = TakesValueEditor.of(this);
        }
        return editor;
    }

    @Override
    public void setValue(Boolean value) {
        setChecked(value);
    }

    @Override
    public void setValue(Boolean value, boolean fireEvents) {
        setChecked(value);
    }
}
