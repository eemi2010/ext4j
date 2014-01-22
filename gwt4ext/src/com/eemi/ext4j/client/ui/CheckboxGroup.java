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

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayInteger;

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
public class CheckboxGroup extends FieldContainer {

    private static JavaScriptObject configPrototype;

    private static native void doInit()/*-{
		var c = new $wnd.Ext.form.CheckboxGroup();
		@com.eemi.ext4j.client.ui.CheckboxGroup::configPrototype = c.initialConfig;
    }-*/;

    protected JavaScriptObject getConfigPrototype() {
        return configPrototype;
    }

    public String getXType() {
        return "checkboxgroup";
    }

    /**
     * Create a new FieldContainer.
     */
    public CheckboxGroup() {
    }

    public CheckboxGroup(JavaScriptObject jsObj) {
        super(jsObj);
    }

    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.form.CheckboxGroup(config);
    }-*/;

    /**
     * False to validate that at least one item in the group is checked. If no
     * items are selected at validation time, blankText will be used as the
     * error text.
     * <p>
     * Defaults to: true
     */
    public void setAllowBlank(boolean value) {
        setAttribute("allowBlank", value, true);
    }

    /**
     * If set to true, and there is no defined fieldLabel, the field container
     * will automatically generate its label by combining the labels of all the
     * fields it contains. Defaults to false.
     * <p>
     * Defaults to: false
     */
    public void setBlankText(String value) {
        setAttribute("blankText", value, true);
    }

    /**
     * Specifies the number of columns to use when displaying grouped
     * checkbox/radio controls using automatic layout.
     */
    public void setColumns(String value) {
        setAttribute("columns", value, true);
    }

    /**
     * Specifies the number of columns to use when displaying grouped
     * checkbox/radio controls using automatic layout.
     */
    public void setColumns(int value) {
        setAttribute("columns", value, true);
    }

    /**
     * Set the field's HTML name attribute.
     * 
     * @param name
     *            the fields name
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setName(String name) throws IllegalStateException {
        setAttribute("name", name, true);
    }

    /**
     * Specifies the number of columns to use when displaying grouped
     * checkbox/radio controls using automatic layout.
     */
    public void setColumnsCount(int value) {
        setColumns(value);
    }

    /**
     * Specifies the number of columns to use when displaying grouped
     * checkbox/radio controls using automatic layout.
     */
    public void setColumns(JsArrayInteger value) {
        setAttribute("columns", value, true);
    }

    /**
     * An extra CSS class to be applied to the body content element in addition
     * to baseBodyCls.
     * <p>
     * Defaults to: 'x-form-checkboxgroup-body'
     */
    public void setFieldBodyCls(String value) {
        setAttribute("fieldBodyCls", value, true);
    }

    /**
     * True to distribute contained controls across columns, completely filling
     * each column top to bottom before starting on the next column. The number
     * of controls in each column will be automatically calculated to keep
     * columns as even as possible. The default value is false, so that controls
     * will be added to columns one at a time, completely filling each row left
     * to right before starting on the next row.
     * <p>
     * Defaults to: false
     */
    public void setVertical(boolean value) {
        setAttribute("vertical", value, true);
    }

}
