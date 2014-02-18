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

import com.ati.ext4j.client.core.Component;
import com.ati.ext4j.client.core.DomQuery;
import com.ati.ext4j.client.core.EventObject;
import com.ati.ext4j.client.core.ExtElement;
import com.ati.ext4j.client.core.Template;
import com.ati.ext4j.client.core.XTemplate;
import com.ati.ext4j.client.data.BaseModel;
import com.ati.ext4j.client.data.Store;
import com.ati.ext4j.client.events.HandlerRegistration;
import com.ati.ext4j.client.events.form.BeforeDeselectHandler;
import com.ati.ext4j.client.events.form.BeforeSelectHandler;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.dom.client.Element;

/**
 * A combobox control with support for autocomplete, remote-loading, paging and
 * many other features.
 * <p>
 * A ComboBox is like a combination of a traditional HTML text &lt;input&gt;
 * field and a &lt;select&gt; field; the user is able to type freely into the
 * field, and/or pick values from a dropdown selection list. The user can input
 * any value by default, even if it does not appear in the selection list; to
 * prevent free-form values and restrict them to items in the list, set
 * forceSelection to true.
 * <p>
 * The selection list's options are populated from any Ext.data.Store, including
 * remote stores. The data items in the store are mapped to each option's
 * displayed text and backing value via the valueField and displayField
 * configurations, respectively.
 * <p>
 * f your store is not remote, i.e. it depends only on local data and is loaded
 * up front, you should be sure to set the queryMode to 'local', as this will
 * improve responsiveness for the user.
 */
public class ComboBox extends Picker {

    public static Mode REMOTE = new Mode("remote");
    public static Mode LOCAL = new Mode("local");

    public static Trigger ALL = new Trigger("all");
    public static Trigger QUERY = new Trigger("query");

    private String displayField;

    private static JavaScriptObject configPrototype;
    private Store store;

    private static native void init()/*-{
		var c = new $wnd.Ext.form.field.ComboBox();
		@com.ati.ext4j.client.ui.ComboBox::configPrototype = c.initialConfig;
    }-*/;

    protected JavaScriptObject getConfigPrototype() {
        return configPrototype;
    }

    public String getXType() {
        return "combo";
    }

    protected ComboBox() {

    }

    @UiConstructor
    public ComboBox(Store store, String valueField) {
        setValueField(valueField);
        setStore(store);
    }

    public ComboBox(JavaScriptObject jsObj) {
        super(jsObj);
    }

    protected native JavaScriptObject create(JavaScriptObject jsObj) /*-{
		return new $wnd.Ext.form.field.ComboBox(jsObj);
    }-*/;

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
			//forms buttons are detached when initially added
		} else {
			//There's an inconsistency in Ext where most elements have the property 'el' set to Ext's Element
			//with the exception of Menu->Item, Menu->Separator, Menu->TextItem,  Toolbar.Item and subclasses
			//(Toolbar.Separator, Toolbar.Spacer, Toolbar.TextItem) where the 'el' property is set to
			//the DOM element itself. Therefore retruning 'el' if 'el' is not Ext's Element. See details in issue 39.
			return el.dom || el;
		}
    }-*/;

    /**
     * Clears any text/value currently set in the field
     */
    public native void clearValue() /*-{
		var cb = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		cb.clearValue();
    }-*/;

    /**
     * Hides the dropdown list if it is currently expanded. Fires the 'collapse'
     * event on completion.
     */
    public native void collapse() /*-{
		var cb = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		cb.collapse();
    }-*/;

    /**
     * Execute a query to filter the dropdown list. Fires the beforequery event
     * prior to performing the query allowing the query action to be canceled if
     * needed.
     * 
     * @param query
     */
    public void doQuery(String query) {
        doQuery(query, false, false);
    }

    /**
     * Execute a query to filter the dropdown list. Fires the beforequery event
     * prior to performing the query allowing the query action to be canceled if
     * needed.
     * 
     * @param query
     *            the query to execute
     * @param forceAll
     *            true to force the query to execute even if there are currently
     *            fewer characters in the field than the minimum specified by
     *            the minChars config option. It also clears any filter
     *            previously saved in the current store (defaults to false)
     */
    public native boolean doQuery(String query, boolean forceAll) /*-{
		var cb = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		return cb.doQuery(query, forceAll);
    }-*/;

    /**
     * Execute a query to filter the dropdown list. Fires the beforequery event
     * prior to performing the query allowing the query action to be canceled if
     * needed.
     * 
     * @param query
     *            the query to execute
     * @param forceAll
     *            true to force the query to execute even if there are currently
     *            fewer characters in the field than the minimum specified by
     *            the minChars config option. It also clears any filter
     *            previously saved in the current store (defaults to false)
     * @param rawQuery
     *            , Pass as true if the raw typed value is being used as the
     *            query string. This causes the resulting store load to leave
     *            the raw value undisturbed.(default to false)
     */
    public native boolean doQuery(String query, boolean forceAll, boolean rawQuery) /*-{
		var cb = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		return cb.doQuery(query, forceAll.rawQuery);
    }-*/;

    /**
     * Expands the dropdown list if it is currently hidden. Fires the 'expand'
     * event on completion.
     */
    public native void expand() /*-{
		var cb = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		cb.expand();
    }-*/;

    /**
     * Finds the record by searching for a specific field/value combination.
     * 
     * @param field
     * @param value
     * @return
     */
    public native BaseModel findRecord(String field, String value) /*-{
		var cb = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var obj = cb.findRecord(field, value);
		return @com.ati.ext4j.client.data.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
    }-*/;

    /**
     * Finds the record by searching for a specific field.
     */
    public native BaseModel findRecordByDisplay(String field) /*-{
		var cb = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var obj = cb.findRecordByDisplay(field);
		return @com.ati.ext4j.client.data.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
    }-*/;

    /**
     * Finds the record by searching for a specific value.
     */
    public native BaseModel findRecordByValue(String field) /*-{
		var cb = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var obj = cb.findRecordByValue(field);
		return @com.ati.ext4j.client.data.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
    }-*/;

    /**
     * Finds the record by searching for a specific value.
     */
    public native String getSubmitValue(String field) /*-{
		var cb = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		return cb.getSubmitValue(field);
    }-*/;

    /**
     * Returns true if the dropdown list is expanded, else false.
     * 
     * @return true if dropdown list is expanded
     */
    public native boolean isExpanded() /*-{
		var cb = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		return cb.isExpanded();
    }-*/;

    /**
     * Select an item by model
     * 
     * @param record
     */
    public native void select(BaseModel record) /*-{
		var cb = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		cb.select(record.@com.ati.ext4j.client.data.BaseModel::getJsObj());
    }-*/;

    /**
     * Select an item by key
     * 
     * @param record
     */
    public native void selectByKey(String record) /*-{
		var cb = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		cb.select(record);
    }-*/;

    /**
     * Select an item by value
     * 
     * @param record
     */
    public native void selectByValue(String record) /*-{
		var cb = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		cb.select(record);
    }-*/;

    /**
     * Select an item in the dropdown list by its numeric index in the list.
     * This function does NOT cause the select event to fire. The store must be
     * loaded and the list expanded for this function to work, otherwise use
     * setValue.
     * 
     * @param index
     *            the zero-based index of the list item to select
     * @param scrollIntoView
     *            false to prevent the dropdown list from autoscrolling to
     *            display the selected item if it is not currently in view
     *            (defaults to true)
     */
    public native void select(int index, boolean scrollIntoView) /*-{
		var cb = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		cb.select(index, scrollIntoView);
    }-*/;

    /**
     * Select an item in the dropdown list by its data value. This function does
     * NOT cause the select event to fire. The store must be loaded and the list
     * expanded for this function to work, otherwise use setValue.
     * 
     * @param value
     *            the data value of the item to select
     * @param scrollIntoView
     *            false to prevent the dropdown list from autoscrolling to
     *            display the selected item if it is not currently in view
     *            (defaults to true)
     */
    public native void selectByValue(String value, boolean scrollIntoView) /*-{
		var cb = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		cb.selectByValue(value, scrollIntoView);
    }-*/;

    private native void setEditableRendered(boolean value) /*-{
		var cb = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		cb.setEditable(value);
    }-*/;

    public static class Mode {
        private String mode;

        private Mode(String mode) {
            this.mode = mode;
        }

        public String getMode() {
            return mode;
        }
    }

    public static class Trigger {
        private String trigger;

        private Trigger(String trigger) {
            this.trigger = trigger;
        }

        public String getTrigger() {
            return trigger;
        }
    }

    // --- config properties

    /**
     * The text query to send to the server to return all records for the list
     * with no filtering (defaults to '')
     * 
     * @param allQuery
     *            the all query string
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setAllQuery(String allQuery) throws IllegalStateException {
        setAttribute("allQuery", allQuery, true);
    }

    /**
     * 
     * true to automatically highlight the first result gathered by the data
     * store in the dropdown list when it is opened. A false value would cause
     * nothing in the list to be highlighted automatically, so the user would
     * have to manually highlight an item before pressing the enter or tab key
     * to select it (unless the value of (typeAhead) were true), or use the
     * mouse to select a value.
     * <p>
     * Defaults to: true
     */
    public void setAutoSelect(boolean value) {
        setAttribute("autoSelect", value, true);
    }

    /**
     * 
     The character(s) used to separate the display values of multiple selected
     * items when multiSelect = true.
     * <p>
     * Defaults to: ', '
     */
    public void setDelimiter(String value) {
        setAttribute("delimiter", value, true);
    }

    /**
     * The underlying data field name to bind to this ComboBox (defaults to
     * undefined).
     * 
     * @param displayField
     *            the display field
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setDisplayField(String displayField) throws IllegalStateException {
        setAttribute("displayField", displayField, true);
    }

    /**
     * When queryMode is 'local' only
     * <p>
     * Set to true to have the ComboBox use the typed value as a RegExp source
     * to filter the store to get possible matches.
     * 
     * @param value
     */
    public void setEnableRegEx(boolean value) {
        setAttribute("enableRegEx", value, true);
    }

    /**
     * The content of the field body is defined by this config option.
     */
    public void setFieldSubTpl(XTemplate value) {
        setAttribute("fieldSubTpl", value.getJsObj(), true);
    }

    /**
     * false to not allow the component to resize itself when its data changes
     * (and its grow property is true)
     * <p>
     * Defaults to: true
     */
    public void setGrowToLongestValue(boolean value) {
        setAttribute("growToLongestValue", value, true);
    }

    /**
     * If set to true, allows the combo field to hold more than one value at a
     * time, and allows selecting multiple items from the dropdown list. The
     * combo's text field will show all selected values separated by the
     * delimiter.
     * <p>
     * Defaults to: false
     */
    public void setMultiSelect(boolean value) {
        setAttribute("multiSelect", value, true);
    }

    /**
     * When true, this prevents the combo from re-querying (either locally or
     * remotely) when the current query is the same as the previous query.
     * <p>
     * Defaults to: true
     */
    public void setQueryCaching(boolean value) {
        setAttribute("queryCaching", value, true);
    }

    /**
     * The mode in which the ComboBox uses the configured Store. Acceptable
     * values are remote and local
     */
    public void setQueryMode(Mode value) {
        setAttribute("queryMode", value.getMode(), true);
    }

    /**
     * The mode in which the ComboBox uses the configured Store. Acceptable
     * values are remote and local
     */
    public void setQueryMode(String value) {
        setAttribute("queryMode", value, true);
    }

    /**
     * The id, DOM node or Ext.Element of an existing HTML <select> element to
     * convert into a ComboBox. The target select's options will be used to
     * build the options in the ComboBox dropdown; a configured store will take
     * precedence over this.
     */
    public void setTransform(String value) {
        setAttribute("transform", value, true);
    }

    /**
     * The id, DOM node or Ext.Element of an existing HTML <select> element to
     * convert into a ComboBox. The target select's options will be used to
     * build the options in the ComboBox dropdown; a configured store will take
     * precedence over this.
     */
    public void setTransform(ExtElement value) {
        setAttribute("transform", value.getJsObj(), true);
    }

    /**
     * Whether the Tab key should select the currently highlighted item.
     * <p>
     * Defaults to: true
     */
    public void setSelectOnTab(boolean value) {
        setAttribute("selectOnTab", value, true);
    }

    /**
     * False to prevent the user from typing text directly into the field, just
     * like a traditional select (defaults to true).
     * 
     * @param editable
     *            false to disable editing
     */
    public void setEditable(boolean editable) {
        if (!isCreated()) {
            setAttribute("editable", editable, true);
        } else {
            setEditableRendered(editable);
        }
        if (!editable) {
            // if its not editable, set the fields value to be the underlying
            // Store's value and not the disaply field.
            // if the field is editable, then we cant make this assumtion
            // because hte user might want to have the user
            // any text that is not in the store and have this value submitted.
            // under such circumstances it is expected that
            // the user makes the decision and sets hiddenName if desired
            String name = getName();
            if (name != null) {
                setHiddenName(name);
            }
        }
    }

    /**
     * True to restrict the selected value to one of the values in the list,
     * false to allow the user to set arbitrary text into the field (defaults to
     * false)
     * 
     * @param forceSelection
     *            true to force selection
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setForceSelection(boolean forceSelection) throws IllegalStateException {
        setAttribute("forceSelection", forceSelection, true);
        String name = getName();
        // if its not editable, set the fields value to be the underlying
        // Store's value and not the disaply field.
        // if the field is editable, then we cant make this assumtion because
        // hte user might want to have the user
        // any text that is not in the store and have this value submitted.
        // under such circumstances it is expected that
        // the user makes the decision and sets hiddenName if desired
        if (name != null) {
            setHiddenName(name);
        }
    }

    /**
     * The height in pixels of the dropdown list resize handle if resizable =
     * true (defaults to 8)
     * 
     * @param handleHeight
     *            the handle height
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setHandleHeight(int handleHeight) throws IllegalStateException {
        setAttribute("handleHeight", handleHeight, true);
    }

    /**
     * If specified, a hidden form field with this name is dynamically generated
     * to store the field's data value (defaults to the underlying DOM element's
     * name)
     * 
     * @param hiddenName
     *            the hidden name
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setHiddenName(String hiddenName) throws IllegalStateException {
        setAttribute("hiddenName", hiddenName, true);
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
    public void setTriggerClass(String triggerClass) throws IllegalStateException {
        setAttribute("triggerClass", triggerClass, true);
    }

    /**
     * A CSS selector in any format supported by {@link DomQuery} that will be
     * used to determine what nodes this DataView will be working with.
     * 
     * @param itemSelector
     *            the items selector
     */
    public void setItemSelector(String itemSelector) {
        setAttribute("itemSelector", itemSelector, true);
    }

    /**
     * True to indicate this is a linked combo box.
     * 
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setLinked(boolean linked) throws IllegalStateException {
        if (linked) {
            setAttribute("lastQuery", "", true);
        }
    }

    /**
     * True to prevent the ComboBox from rendering until requested (should
     * always be used when rendering into an Editor, defaults to false).
     * 
     * @param lazyRender
     *            true to lazy render
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setLazyRender(boolean lazyRender) throws IllegalStateException {
        setAttribute("lazyRender", lazyRender, false);
    }

    /**
     * A valid anchor position value.
     * 
     * @param anchorPosition
     *            the anchor position
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setListAlign(String anchorPosition) throws IllegalStateException {
        setAttribute("listAlign", anchorPosition, true);
    }

    /**
     * CSS class to apply to the dropdown list element (defaults to '').
     * 
     * @param listClass
     *            list css class
     */
    public void setListClass(String listClass) {
        setAttribute("listClass", listClass, true, true);
    }

    /**
     * The width in pixels of the dropdown list (defaults to the width of the
     * ComboBox field)
     * 
     * @param listWidth
     *            the list width
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setListWidth(int listWidth) throws IllegalStateException {
        setAttribute("listWidth", listWidth, true);
    }

    /**
     * The text to display in the dropdown list while data is loading. Only
     * applies when mode = 'remote' (defaults to 'Loading...')
     * 
     * @param loadingText
     *            the loading text
     */
    public void setLoadingText(String loadingText) {
        setAttribute("loadingText", loadingText, true, true);
    }

    /**
     * The maximum height in pixels of the dropdown list before scrollbars are
     * shown (defaults to 300).
     * 
     * @param maxHeight
     *            the max height
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setMaxHeight(int maxHeight) throws IllegalStateException {
        setAttribute("maxHeight", maxHeight, true);
    }

    /**
     * The minimum number of characters the user must type before autocomplete
     * and typeahead activate (defaults to 4, does not apply if editable =
     * false)
     * 
     * @param minChars
     *            the min chars before autocomplete
     */
    public void setMinChars(int minChars) {
        setAttribute("minChars", minChars, true, true);
    }

    /**
     * Set the min height.
     * 
     * @param minHeight
     *            the minHeight
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setMinHeight(int minHeight) {
        setAttribute("minHeight", minHeight, true);
    }

    /**
     * Return the min height.
     * 
     * @return the minHeight
     */
    public int getMinHeight() {
        return getAttributeAsInt("minHeight");
    }

    /**
     * The minimum width of the dropdown list in pixels (defaults to 70, will be
     * ignored if listWidth has a higher value).
     * 
     * @param minListWidth
     *            the min list width
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setMinListWidth(int minListWidth) throws IllegalStateException {
        setAttribute("minListWidth", minListWidth, true);
    }

    /**
     * Set to {@link com.ati.ext4j.client.ui.ComboBox#LOCAL} if the ComboBox
     * loads local data. (defaults to
     * {@link com.ati.ext4j.client.ui.ComboBox#REMOTE} which loads from the
     * server)
     * 
     * @param mode
     *            local or remote mode
     */
    public void setMode(ComboBox.Mode mode) {
        setAttribute("mode", mode.getMode(), true, true);
    }

    /**
     * If greater than 0, a paging toolbar is displayed in the footer of the
     * dropdown list and the filter queries will execute with page start and
     * limit parameters. Only applies when mode = 'remote' (defaults to 0).
     * 
     * @param pageSize
     *            the page size
     * @see #setMode(com.ati.ext4j.client.ui.ComboBox.Mode)
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setPageSize(int pageSize) throws IllegalStateException {
        setAttribute("pageSize", pageSize, true);
    }

    /**
     * The length of time in milliseconds to delay between the start of typing
     * and sending the query to filter the dropdown list (defaults to 500 if
     * mode = 'remote' or 10 if mode = 'local')
     * 
     * @param queryDelay
     *            query delay in milliseconds
     * @see #setMode(com.ati.ext4j.client.ui.ComboBox.Mode)
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setQueryDelay(int queryDelay) throws IllegalStateException {
        setAttribute("queryDelay", queryDelay, true);
    }

    /**
     * Name of the query as it will be passed on the querystring (defaults to
     * 'query')
     * 
     * @param queryParam
     *            the query param
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setQueryParam(String queryParam) throws IllegalStateException {
        setAttribute("queryParam", queryParam, true);
    }

    /**
     * True to add a resize handle to the bottom of the dropdown list (defaults
     * to false).
     * 
     * @param resizable
     *            true for resizale
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setResizable(boolean resizable) throws IllegalStateException {
        setAttribute("resizable", resizable, true);
    }

    /**
     * CSS class to apply to the selected item in the dropdown list (defaults to
     * 'x-combo-selected')
     * 
     * @param selectedClass
     *            the selected css class
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setSelectedClass(String selectedClass) throws IllegalStateException {
        setAttribute("selectedClass", selectedClass, true);
    }

    /**
     * True for default effect
     * 
     * @param shadow
     *            true to enable shadow
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setShadow(boolean shadow) throws IllegalStateException {
        setAttribute("shadow", shadow, true);
    }

    /**
     * "sides" for the default effect, "frame" for 4-way shadow, and "drop" for
     * bottom-right.
     * 
     * @param shadow
     *            shadow style
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setShadow(Shadow.Type shadow) throws IllegalStateException {
        setAttribute("shadow", shadow.getType(), true);
    }

    /**
     * The data store to which this combo is bound (defaults to undefined)
     * 
     * @param store
     *            the combobox store
     */
    public void setStore(Store store) {
        this.store = store;
        setAttribute("store", store.getJsObj(), true);
    }

    private native void setStoreRendered(JavaScriptObject storeJS) /*-{
		var cb = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		cb.setStore(storeJS);
    }-*/;

    /**
     * The Store associated with the combobox.
     * 
     * @return the store
     */
    public Store getStore() {
        return store;
    }

    private native JavaScriptObject getStoreNative()/*-{
		var cb = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		return cb.getStore();
    }-*/;

    /**
     * If supplied, a header element is created containing this text and added
     * into the top of the dropdown list (defaults to undefined, with no header
     * element).
     * 
     * @param title
     *            the combobox title
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setTitle(String title) throws IllegalStateException {
        setAttribute("title", title, true);
    }

    /**
     * Set the template to use to render the ComboBox items. Used to customize
     * dispaly of ComboBox items. <br/>
     * <br/>
     * For example the template below uses the fields 'url' and 'text' from the
     * Store's RecordDef. <br/>
     * <br/>
     * setTpl(new Template("&lt;div class=\"x-combo-list-item\">" +
     * "&lt;em>{url}&lt;/em>&lt;strong>{text}&lt;/strong>" +
     * "&lt;div class=\"x-clear\">&lt;/div>&lt;/div>"));
     * 
     * @param template
     *            template to use for rendering items.
     * @see Store
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setTpl(Template template) throws IllegalStateException {
        String html = template.getHtml();
        setTpl(html);
    }

    /**
     * Set the template to use to render the ComboBox items. Used to customize
     * dispaly of ComboBox items. <br/>
     * <br/>
     * For example the template below uses the fields 'url' and 'text' from the
     * Store's RecordDef. <br/>
     * <br/>
     * setTpl(new Template("&lt;div class=\"x-combo-list-item\">" +
     * "&lt;em>{url}&lt;/em>&lt;strong>{text}&lt;/strong>" +
     * "&lt;div class=\"x-clear\">&lt;/div>&lt;/div>"));
     * 
     * @param template
     *            template to use for rendering items.
     * @see Store
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setTpl(String template) throws IllegalStateException {
        if (template.indexOf("<tpl") == -1) {
            template = "<tpl for=\".\">" + template + "</tpl>";
        }
        setAttribute("tpl", template, true);
    }

    /**
     * The action to execute when the trigger field is activated. Use 'all' to
     * run the query specified by the allQuery config option (defaults to
     * 'query').
     * 
     * @param triggerAction
     *            the trigger action
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setTriggerAction(ComboBox.Trigger triggerAction) throws IllegalStateException {
        setAttribute("triggerAction", triggerAction.getTrigger(), true);
    }

    /**
     * True to populate and autoselect the remainder of the text being typed
     * after a configurable delay (typeAheadDelay) if it matches a known value
     * (defaults to false).
     * 
     * @param typeAhead
     *            enable type ahead
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setTypeAhead(boolean typeAhead) throws IllegalStateException {
        setAttribute("typeAhead", typeAhead, true);
    }

    /**
     * The length of time in milliseconds to wait until the typeahead text is
     * displayed if typeAhead = true (defaults to 250)
     * 
     * @param typeAheadDelay
     *            typeahead delay in milliseconds
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setTypeAheadDelay(int typeAheadDelay) throws IllegalStateException {
        setAttribute("typeAheadDelay", typeAheadDelay, true);
    }

    /**
     * The underlying data value name to bind to this CombBox (defaults to
     * undefined). Note: use of a valueField requires the user make a selection
     * in order for a value to be mapped.
     * 
     * @param valueField
     *            the value field
     */
    public void setValueField(String valueField) {
        setAttribute("valueField", valueField, true, true);
    }

    /**
     * When using a name/value combo, if the value passed to setValue is not
     * found in the store, valueNotFoundText will be displayed as the field text
     * if defined (defaults to undefined).
     * 
     * @param valueNotFoundText
     *            text when value not found
     */
    public void setValueNotFoundText(String valueNotFoundText) {
        setAttribute("valueNotFoundText", valueNotFoundText, true, true);
    }

    /**
     * Creates a new ComboBox from the given component
     * 
     * @param component
     *            , the component to cast from
     * @return, a new ComboBox from the component
     * 
     */
    public static ComboBox cast(Component component) {
        return new ComboBox(component.getOrCreateJsObj());
    }

    /**
     * Fires before the deselected item is removed from the collection
     */
    public native HandlerRegistration addBeforeDeselectHandler(BeforeDeselectHandler handler)/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, r, i, e) {
			var combo = @com.ati.ext4j.client.ui.ComboBox::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var model = @com.ati.ext4j.client.data.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(r);
			var event = @com.ati.ext4j.client.events.form.BeforeDeselectEvent::new(Lcom/ati/ext4j/client/ui/ComboBox;Lcom/ati/ext4j/client/data/BaseModel;ILcom/google/gwt/core/client/JavaScriptObject;)(cmp,model,index,e);
			handler.@com.ati.ext4j.client.events.form.BeforeDeselectHandler::onBeforeDeselect(Lcom/ati/ext4j/client/events/form/BeforeDeselectEvent;)(event);
		};
		var eventName = @com.ati.ext4j.client.events.form.BeforeDeselectEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ati.ext4j.client.events.HandlerRegistration::new(Lcom/ati/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * Fires before the selected item is added to the collection
     */
    public native HandlerRegistration addBeforeSelectHandler(BeforeSelectHandler handler)/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, r, i, e) {
			var combo = @com.ati.ext4j.client.ui.ComboBox::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var model = @com.ati.ext4j.client.data.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(r);
			var event = @com.ati.ext4j.client.events.form.BeforeSelectEvent::new(Lcom/ati/ext4j/client/ui/ComboBox;Lcom/ati/ext4j/client/data/BaseModel;ILcom/google/gwt/core/client/JavaScriptObject;)(cmp,model,index,e);
			handler.@com.ati.ext4j.client.events.form.BeforeSelectHandler::onBeforeSelect(Lcom/ati/ext4j/client/events/form/BeforeSelectEvent;)(event);
		};
		var eventName = @com.ati.ext4j.client.events.form.BeforeSelectEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ati.ext4j.client.events.HandlerRegistration::new(Lcom/ati/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * Fires before all queries are processed. Return false to cancel the query
     * or set the queryPlan's cancel property to true.
     */
    public native HandlerRegistration addBeforeQueryHandler(com.ati.ext4j.client.events.form.BeforeQueryHandler handler)/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(queryPlan, e) {
			var event = @com.ati.ext4j.client.events.form.BeforeQueryEvent::new(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(queryPlan, e);
			handler.@com.ati.ext4j.client.events.form.BeforeQueryHandler::onBeforeQuery(Lcom/ati/ext4j/client/events/form/BeforeQueryEvent;)(event);
		};
		var eventName = @com.ati.ext4j.client.events.form.BeforeQueryEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ati.ext4j.client.events.HandlerRegistration::new(Lcom/ati/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * Fires when at least one list item is selected.
     */
    public native HandlerRegistration addSelectHandler(com.ati.ext4j.client.events.form.SelectHandler handler)/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, rec, e) {
			var combo = @com.ati.ext4j.client.ui.ComboBox::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var selection = @com.ati.ext4j.client.data.BaseModel::from(Lcom/google/gwt/core/client/JavaScriptObject;)(rec);
			var event = @com.ati.ext4j.client.events.form.SelectEvent::new(Lcom/ati/ext4j/client/ui/ComboBox;Lcom/ati/ext4j/client/data/BaseModel;Lcom/google/gwt/core/client/JavaScriptObject;)(combo,selection,e);
			handler.@com.ati.ext4j.client.events.form.SelectHandler::onSelect(Lcom/ati/ext4j/client/events/form/SelectEvent;)(event);
		};
		var eventName = @com.ati.ext4j.client.events.form.SelectEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ati.ext4j.client.events.HandlerRegistration::new(Lcom/ati/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    @Override
    protected void onTriggerClick(EventObject event) {

    }

}
