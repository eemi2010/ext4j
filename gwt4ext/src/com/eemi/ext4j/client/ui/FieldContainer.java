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

import com.eemi.ext4j.client.field.LabelAlign;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;

/**
 * FieldContainer is a derivation of Container that implements the Labelable
 * mixin. This allows it to be configured so that it is rendered with a field
 * label and optional error message around its sub-items. This is useful for
 * arranging a group of fields or other components within a single item in a
 * form, so that it lines up nicely with other fields. A common use is for
 * grouping a set of related fields under a single label in a form.
 * <p>
 * The container's configured items will be layed out within the field body area
 * according to the configured layout type. The default layout is
 * 'autocontainer'.
 * <p>
 * Like regular fields, FieldContainer can inherit its decoration configuration
 * from the fieldDefaults of an enclosing FormPanel. In addition, FieldContainer
 * itself can pass fieldDefaults to any fields it may itself contain.
 * <p>
 * If you are grouping a set of CheckBox or Radio fields in a single labeled
 * container, consider using a Ext.form.CheckboxGroup or Ext.form.RadioGroup
 * instead as they are specialized for handling those types.
 */
public class FieldContainer extends Container {

    private static JavaScriptObject configPrototype;

    private static native void doInit()/*-{
		var c = new $wnd.Ext.form.FieldContainer();
		@com.eemi.ext4j.client.ui.FieldContainer::configPrototype = c.initialConfig;
    }-*/;

    protected JavaScriptObject getConfigPrototype() {
        return configPrototype;
    }

    public String getXType() {
        return "fieldcontainer";
    }

    /**
     * Create a new FieldContainer.
     */
    public FieldContainer() {
    }

    public FieldContainer(JavaScriptObject jsObj) {
        super(jsObj);
    }

    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.form.FieldContainer(config);
    }-*/;

    /**
     * If set to true, the field container will automatically combine and
     * display the validation errors from all the fields it contains as a single
     * error on the container, according to the configured msgTarget. Defaults
     * to false.
     * <p>
     * Defaults to: false
     */
    public void setCombineErrors(boolean value) {
        setAttribute("combineErrors", value, true);
    }

    /**
     * If set to true, and there is no defined fieldLabel, the field container
     * will automatically generate its label by combining the labels of all the
     * fields it contains. Defaults to false.
     * <p>
     * Defaults to: false
     */
    public void setCombineLabels(boolean value) {
        setAttribute("combineLabels", value, true);
    }

    /**
     * The string to use when joining the labels of individual sub-fields, when
     * combineLabels is set to true. Defaults to ', '.
     * <p>
     * Defaults to: ', '
     */
    public void setLabelConnector(String value) {
        setAttribute("labelConnector", value, true);
    }

    /**
     * Takes an Array of invalid Ext.form.field.Field objects and builds a
     * combined list of error messages from them. Defaults to prepending each
     * message by the field name and a colon. This can be overridden to provide
     * custom combined error message handling, for instance changing the format
     * of each message or sorting the array (it is sorted in order of appearance
     * by default).
     */
    public native JsArrayString getCombineErrors() /*-{
		var formPanel = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		formPanel.getCombineErrors();
    }-*/;

    /**
     * Set the fields label. Alias for {@link #setFieldLabel(String)}
     * 
     * @param fieldLabel
     *            the field label
     */
    public void setLabel(String fieldLabel) {
        setFieldLabel(fieldLabel);
    }

    // TODO
    // LabelAttrTpl
    /**
     * Controls the position and alignment of the fieldLabel
     */
    public void setLabelAlign(LabelAlign labelAlign) {
        setAttribute("labelAlign", labelAlign.getValue(), true, true);
    }

    /**
     * Controls the position and alignment of the fieldLabel
     */
    public void setLabelAlign(String labelAlign) {
        setAttribute("labelAlign", labelAlign, true, true);
    }

    /**
     * Set the fields label.
     * 
     * @param fieldLabel
     *            the field label
     */
    public void setFieldLabel(String fieldLabel) {
        setAttribute("fieldLabel", fieldLabel, true, true);
        if (isRendered()) {
            setFieldLabelRendered(fieldLabel, getId());
        }
    }

    /**
     * The field label.
     * 
     * @return the field label
     */
    public String getFieldLabel() {
        return getAttribute("fieldLabel");
    }

    private native void setFieldLabelRendered(String fieldLabel, String fieldId) /*-{
		var field = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var label = $wnd.Ext.DomQuery.select($wnd.String.format(
				'label[for="{0}"]', fieldId));
		if (label) {
			//todo preserve user specified labelSeparator and only update the label text.
			//var separator = typeof field.container.labelSeparator == 'undefined' ? field.labelSeparator : field.container.labelSeparator;
			label[0].childNodes[0].nodeValue = fieldLabel;
		}
    }-*/;

}
