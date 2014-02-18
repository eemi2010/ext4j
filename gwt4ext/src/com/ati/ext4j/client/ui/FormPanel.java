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

import com.ati.ext4j.client.connection.Connection;
import com.ati.ext4j.client.connection.UrlParam;
import com.ati.ext4j.client.core.Component;
import com.ati.ext4j.client.core.ComponentTraversalCallback;
import com.ati.ext4j.client.core.config.Position;
import com.ati.ext4j.client.data.BaseModel;
import com.ati.ext4j.client.field.Field;
import com.ati.ext4j.client.tip.QuickTips;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * FormPanel provides a standard container for forms. It is essentially a
 * standard {@link NotificationContainer} which automatically creates a
 * BasicForm for managing any Ext.form.field.Field objects that are added as
 * descendants of the panel. It also includes conveniences for configuring and
 * working with the BasicForm and the collection of Fields.
 */
public class FormPanel extends Panel {

    private static JavaScriptObject configPrototype;

    static {
        init();
    }

    private static void init() {
        QuickTips.init();
        Field.setMessageTarget("side");
    }

    private static native void doInit()/*-{
		var c = new $wnd.Ext.form.FormPanel();
		@com.ati.ext4j.client.ui.FormPanel::configPrototype = c.initialConfig;
    }-*/;

    protected JavaScriptObject getConfigPrototype() {
        return configPrototype;
    }

    public String getXType() {
        return "form";
    }

    /**
     * Create a new FormPanel.
     */
    public FormPanel() {
    }

    protected void initComponent() {
        super.initComponent();
        if (!GWT.isScript()) {
            Component[] items = getItems();
            if (items.length == 0) {
                error("FormPanel must contain atleast one field.");
            }
        }
    }

    /**
     * Create a new FormPanel.
     * 
     * @param labelAlign
     *            the label alignment
     */
    public FormPanel(Position labelAlign) {
        setLabelAlign(labelAlign);
    }

    public FormPanel(JavaScriptObject jsObj) {
        super(jsObj);
    }

    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.form.FormPanel(config);
    }-*/;

    /**
     * Starts monitoring of the valid state of this form. Usually this is done
     * by passing the config option "monitorValid"
     */
    public native void startMonitoring() /*-{
		var formPanel = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		formPanel.startMonitoring();
    }-*/;

    /**
     * Stops monitoring of the valid state of this form.
     */
    public native void stopMonitoring() /*-{
		var formPanel = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		formPanel.stopMonitoring();
    }-*/;

    /**
     * Provides access to the Form which this NotificationContainer contains.
     * Note that this method must be called only after the FormPanel has been
     * rendered. <b>Returns null if called before the FormPanel has been
     * rendered.</b>. If you need to add a listener to he form prior to the
     * FormPanel being rendered, call
     * {@link #addFormListener(com.ati.ext4j.client.ui.form.event.FormListener)}
     * instead.
     * 
     * @return the underlying Form, or null if FormPanel not rendered
     */
    public native Form getForm() /*-{
		var formPanel = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var formJS = formPanel.getForm();
		return @com.ati.ext4j.client.ui.Form::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(formJS);
    }-*/;

    public void load(String url) {
        if (getForm() != null) {
            getForm().load(url);
        }

    }

    public void load(String url, UrlParam[] params, Connection.Method method, String waitMsg) {
        if (getForm() != null) {
            getForm().load(url, params, method, waitMsg);
        }

    }

    /**
     * Loads a {@link BaseModel} into this form.
     * 
     * @param record
     *            the BaseModel to load
     */
    public void loadRecord(BaseModel record) {
        if (getForm() != null) {
            getForm().loadRecord(record);
        }
    }

    /**
     * Convenience function for fetching the current value of each field in the
     * form. This is the same as calling
     * <code>this.getForm().getValuesAsString()</code>.
     * 
     * @return
     */
    public String getValuesAsString() {
        if (getForm() != null) {
            return getForm().getValuesAsString();
        }
        return null;
    }

    /**
     * Convenience function for fetching the current value of each field in the
     * form. This is the same as calling
     * <code>this.getForm().getValuesAsString(boolean dirtyOnly)</code>.
     * 
     * @return
     */
    public String getValuesAsString(boolean dirtyOnly) {
        if (getForm() != null) {
            return getForm().getValuesAsString(dirtyOnly);
        }
        return null;
    }

    /**
     * Convenience function for fetching the current value of each field in the
     * form. This is the same as calling
     * <code>this.getForm().getValuesAsString(boolean dirtyOnly, boolean includeEmptyText)</code>
     * .
     * 
     * @return
     */
    public String getValuesAsString(boolean dirtyOnly, boolean includeEmptyText) {
        if (getForm() != null) {
            return getForm().getValuesAsString(dirtyOnly, includeEmptyText);
        }
        return null;
    }

    /**
     * Convenience function for fetching the current value of each field in the
     * form. This is the same as calling
     * <code>this.getForm().getValuesAsString(boolean dirtyOnly, boolean includeEmptyText, boolean useDataValues)</code>
     * .
     * 
     * @return
     */
    public String getValuesAsString(boolean dirtyOnly, boolean includeEmptyText, boolean useDataValues) {
        if (getForm() != null) {
            return getForm().getValuesAsString(dirtyOnly, includeEmptyText, useDataValues);
        }
        return null;
    }

    /**
     * Convenience function for fetching the current value of each field in the
     * form. This is the same as calling
     * <code>this.getForm().getValues(boolean dirtyOnly, boolean includeEmptyText, boolean useDataValues)</code>
     * .
     * 
     * @return
     */
    public JavaScriptObject getValues(boolean dirtyOnly, boolean includeEmptyText, boolean useDataValues) {
        if (getForm() != null) {
            return getForm().getValues(dirtyOnly, includeEmptyText, useDataValues);
        }
        return null;
    }

    /**
     * Convenience function for fetching the current value of each field in the
     * form. This is the same as calling
     * <code>this.getForm().getValues(boolean dirtyOnly, boolean includeEmptyText)</code>
     * .
     * 
     * @return
     */
    public JavaScriptObject getValues(boolean dirtyOnly, boolean includeEmptyText) {
        if (getForm() != null) {
            return getForm().getValues(dirtyOnly, includeEmptyText);
        }
        return null;
    }

    /**
     * Convenience function for fetching the current value of each field in the
     * form. This is the same as calling
     * <code>this.getForm().getValues(boolean dirtyOnly)</code> .
     * 
     * @return
     */
    public JavaScriptObject getValues(boolean dirtyOnly) {
        if (getForm() != null) {
            return getForm().getValues(dirtyOnly);
        }
        return null;
    }

    /**
     * Convenience function for fetching the current value of each field in the
     * form. This is the same as calling <code>this.getForm().getValues()</code>
     * .
     * 
     * @return
     */
    public JavaScriptObject getValues() {
        if (getForm() != null) {
            return getForm().getValues();
        }
        return null;
    }

    /**
     * Return all fields added to the FormPanel.
     * 
     * @return the fields
     */
    public Field[] getFields() {
        Component[] components = findBy(new ComponentTraversalCallback() {
            public boolean execute(Component component) {
                return (component instanceof Field);
            }
        });

        Field[] fields = new Field[components.length];
        for (int i = 0; i < components.length; i++) {
            fields[i] = (Field) components[i];
        }
        return fields;
    }

    // -- config properties ---

    // http://extjs.com/forum/showthread.php?t=4814&highlight=doAction
    // acts like hidden form fields
    /**
     * Parameters to pass with all requests. This effectively acts like Form
     * hidden fields.
     * 
     * @param params
     *            the base params
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setBaseParams(UrlParam[] params) throws IllegalStateException {
        JavaScriptObject paramObj = UrlParam.getJsObj(params);
        setAttribute("baseParams", paramObj, true);
    }

    /**
     * Valid values are "left," "center" and "right" (defaults to "center").
     * 
     * @param buttonAlign
     *            form button position
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setButtonAlign(Position buttonAlign) throws IllegalStateException {
        setAttribute("buttonAlign", buttonAlign.getValue(), true);
    }

    /**
     * Set true if this form is a file upload.
     * 
     * 
     * @param fileUpload
     *            true if file upload
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setFileUpload(boolean fileUpload) throws IllegalStateException {
        setAttribute("fileUpload", fileUpload, true);
    }

    // http://extjs.com/forum/archive/index.php/t-7316.html
    /**
     * Set to true to hide all field labels.
     * 
     * @param hideLabels
     *            true to hide field labels
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setHideLabels(boolean hideLabels) throws IllegalStateException {
        setAttribute("hideLabels", hideLabels, true);
    }

    /**
     * A CSS class to apply to the x-form-item of fields. This property cascades
     * to child containers.
     * 
     * @param itemCls
     *            CSS class
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setItemCls(String itemCls) throws IllegalStateException {
        setAttribute("itemCls", itemCls, true);
    }

    /**
     * Valid values are "left," "top" and "right" (defaults to "left"). This
     * property cascades to child containers if not set.
     * 
     * @param labelAlign
     *            label alignment
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setLabelAlign(Position labelAlign) throws IllegalStateException {
        setAttribute("labelAlign", labelAlign.getValue(), true);
    }

    /**
     * The width of labels. This property cascades to child containers.
     * 
     * @param labelWidth
     *            the label width
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setLabelWidth(int labelWidth) throws IllegalStateException {
        setAttribute("labelWidth", labelWidth, true);
    }

    /**
     * The request method to use (GET or POST) for form actions if one isn't
     * supplied in the action options.
     * 
     * @param method
     *            the request method
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setMethod(Connection.Method method) throws IllegalStateException {
        setAttribute("method", method.getMethod(), true);
    }

    /**
     * Minimum width of all buttons in pixels (defaults to 75).
     * 
     * @param minButtonWidth
     *            min button width
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setMinButtonWidth(int minButtonWidth) throws IllegalStateException {
        setAttribute("minButtonWidth", minButtonWidth, true);
    }

    /**
     * The milliseconds to poll valid state, ignored if monitorValid is not true
     * (defaults to 200).
     * 
     * @param monitorPoll
     *            the monitor poll in milliseconds
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setMonitorPoll(int monitorPoll) throws IllegalStateException {
        setAttribute("monitorPoll", monitorPoll, true);
    }

    // http://extjs.com/forum/showthread.php?t=5108&highlight=formBind
    /**
     * If true the form monitors its valid state client-side and fires a looping
     * event with that state. This is required to bind buttons to the valid
     * state using the config value formBind:true on the button.
     * 
     * @param monitorValid
     *            true to enable monitoring
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setMonitorValid(boolean monitorValid) throws IllegalStateException {
        setAttribute("monitorValid", monitorValid, true);
    }

    /**
     * Timeout for form actions in seconds (default is 30 seconds).
     * 
     * @param timeout
     *            timeout in seconds
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setTimeout(int timeout) throws IllegalStateException {
        setAttribute("timeout", timeout, true);
    }

    /**
     * If set to true, form.reset() resets to the last loaded or setValues()
     * data instead of when the form was first created.
     * 
     * @param trackResetOnLoad
     *            true to track reset on load
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setTrackResetOnLoad(boolean trackResetOnLoad) throws IllegalStateException {
        setAttribute("trackResetOnLoad", trackResetOnLoad, true);
    }

    /**
     * The URL to use for form actions if one isn't supplied in the action
     * options.
     * 
     * @param url
     *            the url
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setUrl(String url) throws IllegalStateException {
        setAttribute("url", url, true);
    }

    /**
     * By default wait messages are displayed with
     * {@link com.ati.ext4j.client.ui.MessageBox#wait(long)}. You can target a
     * specific element by passing its id.
     * 
     * @param waitMsgTarget
     *            ID of the Element to mask
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setWaitMsgTarget(String waitMsgTarget) throws IllegalStateException {
        setAttribute("waitMsgTarget", waitMsgTarget, true);
    }

    /**
     * By default wait messages are displayed with
     * {@link com.ati.ext4j.client.ui.MessageBox#wait(long)}. You can mask the
     * form itself by passing in true.
     * 
     * @param waitMsgTarget
     *            true to mask the form
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setWaitMsgTarget(boolean waitMsgTarget) throws IllegalStateException {
        setAttribute("waitMsgTarget", waitMsgTarget, true);
    }

    public static FormPanel cast(Component component) {
        return new FormPanel(component.getOrCreateJsObj());
    }

}
