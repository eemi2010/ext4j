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

import java.util.List;

import com.ati.ext4j.client.core.Component;
import com.ati.ext4j.client.core.ExtElement;
import com.ati.ext4j.client.core.Template;
import com.ati.ext4j.client.core.config.XType;
import com.ati.ext4j.client.data.BaseModel;
import com.ati.ext4j.client.data.Store;
import com.ati.ext4j.client.events.Event;
import com.ati.ext4j.client.events.HandlerRegistration;
import com.ati.ext4j.client.events.grid.BeforeContainerActionHandler;
import com.ati.ext4j.client.events.grid.BeforeContainerClickHandler;
import com.ati.ext4j.client.events.grid.BeforeContainerContextMenuHandler;
import com.ati.ext4j.client.events.grid.BeforeContainerDoubleClickHandler;
import com.ati.ext4j.client.events.grid.BeforeContainerKeyDownHandler;
import com.ati.ext4j.client.events.grid.BeforeContainerMouseDownHandler;
import com.ati.ext4j.client.events.grid.BeforeContainerMouseOutHandler;
import com.ati.ext4j.client.events.grid.BeforeContainerMouseOverHandler;
import com.ati.ext4j.client.events.grid.BeforeContainerMouseUpHandler;
import com.ati.ext4j.client.events.grid.BeforeDeselectHandler;
import com.ati.ext4j.client.events.grid.BeforeItemActionHandler;
import com.ati.ext4j.client.events.grid.BeforeItemClickHandler;
import com.ati.ext4j.client.events.grid.BeforeItemContextMenuHandler;
import com.ati.ext4j.client.events.grid.BeforeItemDoubleClickHandler;
import com.ati.ext4j.client.events.grid.BeforeItemKeyDownHandler;
import com.ati.ext4j.client.events.grid.BeforeItemMouseDownHandler;
import com.ati.ext4j.client.events.grid.BeforeItemMouseEnterHandler;
import com.ati.ext4j.client.events.grid.BeforeItemMouseLeaveHandler;
import com.ati.ext4j.client.events.grid.BeforeItemMouseUpHandler;
import com.ati.ext4j.client.events.grid.BeforeSelectHandler;
import com.ati.ext4j.client.events.grid.BeforeSelectionHandler;
import com.ati.ext4j.client.events.grid.ContainerClickHandler;
import com.ati.ext4j.client.events.grid.ContainerContextMenuHandler;
import com.ati.ext4j.client.events.grid.ContainerDoubleClickHandler;
import com.ati.ext4j.client.events.grid.ContainerKeyDownHandler;
import com.ati.ext4j.client.events.grid.ContainerMouseDownHandler;
import com.ati.ext4j.client.events.grid.ContainerMouseOutHandler;
import com.ati.ext4j.client.events.grid.ContainerMouseOverHandler;
import com.ati.ext4j.client.events.grid.ContainerMouseUpHandler;
import com.ati.ext4j.client.events.grid.DeselectHandler;
import com.ati.ext4j.client.events.grid.SelectHandler;
import com.ati.ext4j.client.events.grid.SelectionChangeHandler;
import com.ati.ext4j.client.events.view.FocusChangeHandler;
import com.ati.ext4j.client.events.view.HighlightItemHandler;
import com.ati.ext4j.client.events.view.ItemClickHandler;
import com.ati.ext4j.client.events.view.ItemContextMenuHandler;
import com.ati.ext4j.client.events.view.ItemDoubleClickHandler;
import com.ati.ext4j.client.events.view.ItemKeyDownHandler;
import com.ati.ext4j.client.events.view.ItemMouseDownHandler;
import com.ati.ext4j.client.events.view.ItemMouseEnterHandler;
import com.ati.ext4j.client.events.view.ItemMouseLeaveHandler;
import com.ati.ext4j.client.events.view.ItemMouseUpHandler;
import com.ati.ext4j.client.events.view.UnHighlightItemHandler;
import com.ati.ext4j.client.selection.SelectionModel;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.dom.client.Element;

/**
 * A mechanism for displaying data using custom layout templates and formatting.
 * 
 * The View uses an Ext.XTemplate as its internal templating mechanism, and is
 * bound to an Ext.data.Store so that as the data in the store changes the view
 * is automatically updated to reflect the changes. The view also provides
 * built-in behavior for many common events that can occur for its contained
 * items including click, doubleclick, mouseover, mouseout, etc. as well as a
 * built-in selection model. In order to use these features, an itemSelector
 * config must be provided for the View to determine what nodes it will be
 * working with.
 */
public class DataView extends Component {

    private static JavaScriptObject configPrototype;
    private Store store;

    private native void init()/*-{
		var c = new $wnd.Ext.view.View();
		@com.ati.ext4j.client.ui.DataView::configPrototype = c.initialConfig;
    }-*/;

    protected JavaScriptObject getConfigPrototype() {
        return configPrototype;
    }

    public String getXType() {
        return XType.DATAVIEW.getValue();
    }

    protected DataView() {

    }

    /**
     * Create a new View.
     */
    public DataView(Store store, String itemSelector, String template) {
        setStore(store);
        setItemSelector(itemSelector);
        setTpl(template);
    }

    /**
     * Create a new View.
     */
    public DataView(Store store, String itemSelector, Template template) {
        setStore(store);
        setItemSelector(itemSelector);
        setTpl(template);
    }

    /**
     * Create a new View.
     */
    public DataView(Store store, String itemSelector, JsArrayString template) {
        setStore(store);
        setItemSelector(itemSelector);
        setTpl(template);
    }

    protected DataView(JavaScriptObject jsObj) {
        super(jsObj);
    }

    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.view.View(config);
    }-*/;

    /**
     * <b>This is a required setting</b>. A simple CSS selector (e.g.
     * div.some-class or span:first-child) that will be used to determine what
     * nodes this DataView will be working with. The itemSelector is used to map
     * DOM nodes to records. As such, there should only be one root level
     * element that matches the selector for each record.
     * 
     * @param value
     */
    public void setItemSelector(String value) {
        setAttribute("itemSelector", value, true);
    }

    /**
     * The {@link Store} to bind this DataView to.
     * 
     * @param store
     */
    public void setStore(Store store) {
        this.store = store;
        setAttribute("store", store.getJsObj(), true);
    }

    /**
     * Set this to true to ignore refresh events on the bound store. This is
     * useful if you wish to provide custom transition animations via a plugin
     * <p>
     * Defaults to: false
     */
    public void setBlockRefresh(boolean value) {
        setAttribute("blockRefresh", value, true);
    }

    /**
     * True to defer emptyText being applied until the store's first load.
     * <p>
     * Defaults to: true
     */
    public void setDeferEmptyText(boolean value) {
        setAttribute("deferEmptyText", value, true);
    }

    /**
     * Defaults to true to defer the initial refresh of the view.
     * <p>
     * This allows the View to execute its render and initial layout more
     * quickly because the process will not be encumbered by the expensive
     * update of the view structure.
     * <p>
     * <b>Important</b>: Be aware that this will mean that the View's item
     * elements will not be available immediately upon render, so selection may
     * not take place at render time. To access a View's item elements as soon
     * as possible, use the viewready event. Or set deferInitialrefresh to
     * false, but this will be at the cost of slower rendering.
     * <p>
     * Defaults to: true
     */
    public void setDeferInitialRefresh(boolean value) {
        setAttribute("deferInitialRefresh", value, true);
    }

    /**
     * True to disable selection within the DataView. This configuration will
     * lock the selection model that the DataView uses.
     */
    public void setDisableSelection(boolean value) {
        setAttribute("disableSelection", value, true);
    }

    /**
     * The text to display in the view when there is no data to display. Note
     * that when using local data the emptyText will not be displayed unless you
     * set the deferEmptyText option to false.
     * <p>
     * Defaults to: ""
     */
    public void setEmptyText(String value) {
        setAttribute("emptyText", value, true);
    }

    /**
     * Specifies the class to be assigned to each element in the view when used
     * in conjunction with the itemTpl configuration.
     * <p>
     * Defaults to: "x-dataview-item"
     */
    public void setItemCls(String value) {
        setAttribute("itemCls", value, true);
    }

    /**
     * The inner portion of the item template to be rendered. Follows an
     * XTemplate structure and will be placed inside of a tpl.
     * 
     */
    public void setItemTpl(String value) {
        setAttribute("itemTpl", value, true);
    }

    /**
     * The inner portion of the item template to be rendered. Follows an
     * XTemplate structure and will be placed inside of a tpl.
     * 
     */
    public void setItemTpl(Template tpl) {
        setAttribute("itemTpl", tpl.getJsObj(), true);
    }

    /**
     * The inner portion of the item template to be rendered. Follows an
     * XTemplate structure and will be placed inside of a tpl.
     * 
     */
    public void setItemTpl(JsArrayString tpl) {
        setAttribute("itemTpl", tpl, true);
    }

    /**
     * False to disable a load mask from displaying while the view is loading.
     * This can also be a Ext.LoadMask configuration object.
     * <p>
     * Defaults to: true
     * 
     */
    public void setLoadMask(boolean value) {
        setAttribute("loadMask", value, true);
    }

    /**
     * False to disable a load mask from displaying while the view is loading.
     * This can also be a Ext.LoadMask configuration object.
     * <p>
     * Defaults to: true
     * 
     */
    public void setLoadMask(LoadMask value) {
        setAttribute("loadMask", value.getOrCreateJsObj(), true);
    }

    /**
     * The CSS class to apply to the loading message element. Defaults to
     * Ext.LoadMask.prototype.msgCls "x-mask-loading".
     * 
     */
    public void setLoadingCls(String value) {
        setAttribute("loadingCls", value, true);
    }

    /**
     * If specified, gives an explicit height for the data view when it is
     * showing the loadingText, if that is specified. This is useful to prevent
     * the view's height from collapsing to zero when the loading mask is
     * applied and there are no other contents in the data view.
     * 
     */
    public void setLoadingHeight(double value) {
        setAttribute("loadingHeight", value, true);
    }

    /**
     * A string to display during data load operations. If specified, this text
     * will be displayed in a loading div and the view's contents will be
     * cleared while loading, otherwise the view's contents will continue to
     * display normally until the new data is loaded and the contents are
     * replaced.
     * <p>
     * Defaults to: "Loading..."
     * 
     */
    public void setLoadingText(String value) {
        setAttribute("loadingText", value, true);
    }

    /**
     * A CSS class to apply to each item in the view on mouseover. Setting this
     * will automatically set trackOver to true.
     * 
     */
    public void setOverItemCls(String value) {
        setAttribute("overItemCls", value, true);
    }

    /**
     * True to preserve scroll position across refresh operations.
     * <p>
     * Defaults to: false
     * 
     */
    public void setPreserveScrollOnRefresh(boolean value) {
        setAttribute("preserveScrollOnRefresh", value, true);
    }

    /**
     * A CSS class to apply to each selected item in the view.
     * <p>
     * Defaults to: "x-item-selected"
     * 
     */
    public void setSelectedItemCls(String value) {
        setAttribute("selectedItemCls", value, true);
    }

    /**
     * When true the overItemCls will be applied to rows when hovered over. This
     * in return will also cause highlightitem and unhighlightitem events to be
     * fired.
     * <p>
     * Enabled automatically when the overItemCls config is set.
     * <p>
     * Defaults to: false
     * 
     */
    public void setTrackOver(boolean value) {
        setAttribute("trackOver", value, true);
    }

    /**
     * Changes the data store bound to this view and refreshes it.
     * 
     * @param store
     *            ,The store to bind to this view
     */
    public native void bindStore(Store store) /*-{
		var view = this.@com.ati.ext4j.client.core.Component::getJsObj()();
		view
				.bindStore(store.@com.ati.ext4j.client.core.JsObject::getJsObj()());
    }-*/;

    /**
     * Deselects a record instance by record instance or index.
     */
    public native void deselect(int records) /*-{
		var view = this.@com.ati.ext4j.client.core.Component::getJsObj()();
		view.deselect(records);
    }-*/;

    /**
     * Deselects a record instance by record instance or index.
     */
    public native void deselect(int records, boolean supressEvent) /*-{
		var view = this.@com.ati.ext4j.client.core.Component::getJsObj()();
		view.deselect(records, supressEvent);
    }-*/;

    /**
     * Deselects a record instance by record instance or index.
     */
    public native void deselect(List<BaseModel> records) /*-{
		var peers = @com.ati.ext4j.client.data.BaseModel::fromList(Ljava/util/List;)(peers);
		var view = this.@com.ati.ext4j.client.core.Component::getJsObj()();
		view.deselect(peers);
    }-*/;

    /**
     * Deselects a record instance by record instance or index.
     */
    public native void deselect(List<BaseModel> records, boolean supressEvent) /*-{
		var peers = @com.ati.ext4j.client.data.BaseModel::fromList(Ljava/util/List;)(peers);
		var view = this.@com.ati.ext4j.client.core.Component::getJsObj()();
		view.deselect(peers, supressEvent);
    }-*/;

    /**
     * Gets a record from a node
     */
    public native BaseModel getRecord(ExtElement node) /*-{
		var view = this.@com.ati.ext4j.client.core.Component::getJsObj()();
		var obj = view
				.getRecord(node.@com.ati.ext4j.client.core.JsObject::getJsObj()());
		return @com.ati.ext4j.client.data.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
    }-*/;

    /**
     * Gets a record from a node
     */
    public native BaseModel getRecord(JavaScriptObject node) /*-{
		var view = this.@com.ati.ext4j.client.core.Component::getJsObj()();
		var obj = view
				.getRecord(node.@com.ati.ext4j.client.core.JsObject::getJsObj()());
		return @com.ati.ext4j.client.data.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
    }-*/;

    /**
     * Gets the selection model for this view.
     */
    public native SelectionModel getSelectionModel() /*-{
		var view = this.@com.ati.ext4j.client.core.Component::getJsObj()();
		var obj = view.getSelectionModel();
		return @com.ati.ext4j.client.selection.SelectionModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
    }-*/;

    /**
     * Returns the store associated with this View.
     * 
     * @return
     */
    public Store getStore() {
        return this.store;
    }

    /**
     * Finds the index of the passed node.
     */
    public native int indexOf(JavaScriptObject node) /*-{
		var view = this.@com.ati.ext4j.client.core.Component::getJsObj()();
		return view.indexOf(node);
    }-*/;

    /**
     * Finds the index of the passed node.
     */
    public native int indexOf(String node) /*-{
		var view = this.@com.ati.ext4j.client.core.Component::getJsObj()();
		return view.indexOf(node);
    }-*/;

    /**
     * Finds the index of the passed node.
     */
    public native int indexOf(int node) /*-{
		var view = this.@com.ati.ext4j.client.core.Component::getJsObj()();
		return view.indexOf(node);
    }-*/;

    /**
     * Finds the index of the passed node.
     */
    public native int indexOf(BaseModel node) /*-{
		var view = this.@com.ati.ext4j.client.core.Component::getJsObj()();
		return view
				.indexOf(node.@com.ati.ext4j.client.core.JsObject::getJsObj()());
    }-*/;

    /**
     * Returns true if the passed node is selected, else false.
     */
    public native boolean isSelected(JavaScriptObject node) /*-{
		var view = this.@com.ati.ext4j.client.core.Component::getJsObj()();
		return view.isSelected(node);
    }-*/;

    /**
     * Returns true if the passed node is selected, else false.
     */
    public native boolean isSelected(int node) /*-{
		var view = this.@com.ati.ext4j.client.core.Component::getJsObj()();
		return view.isSelected(node);
    }-*/;

    /**
     * Returns true if the passed node is selected, else false.
     */
    public native boolean isSelected(BaseModel node) /*-{
		var view = this.@com.ati.ext4j.client.core.Component::getJsObj()();
		return view
				.isSelected(node.@com.ati.ext4j.client.core.JsObject::getJsObj()());
    }-*/;

    /**
     * Refreshes the view by reloading the data from the store and re-rendering
     * the template.
     */
    public native void refresh() /*-{
		var view = this.@com.ati.ext4j.client.core.Component::getJsObj()();
		view.refresh();
    }-*/;

    /**
     * Refreshes an individual node's data from the store.
     */
    public native void refreshNode(int index) /*-{
		var view = this.@com.ati.ext4j.client.core.Component::getJsObj()();
		view.refreshNode(index);
    }-*/;

    /**
     * Un-highlights the currently highlighted item, if any.
     */
    public native void clearHighlight() /*-{
		var view = this.@com.ati.ext4j.client.core.Component::getJsObj()();
		view.clearHighlight();
    }-*/;

    /**
     * Un-highlights the currently highlighted item, if any.
     */
    public native void highlightItem(Element element) /*-{
		var view = this.@com.ati.ext4j.client.core.Component::getJsObj()();
		view.highlightItem(element);
    }-*/;

    /**
     * Fires before the click event on the container is processed.
     */
    public native HandlerRegistration addBeforeContainerClickHandler(BeforeContainerClickHandler handler)/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(v, e) {
			var view = @com.ati.ext4j.client.ui.DataView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(v);
			var event = @com.ati.ext4j.client.events.grid.BeforeContainerClickEvent::new(Lcom/ati/ext4j/client/ui/DataView;Lcom/google/gwt/core/client/JavaScriptObject;)(view,e)
			handler.@com.ati.ext4j.client.events.grid.BeforeContainerClickHandler::onBeforeContainerClick(Lcom/ati/ext4j/client/events/grid/BeforeContainerClickEvent;)(event);
		};
		var eventName = @com.ati.ext4j.client.events.grid.BeforeContainerClickEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ati.ext4j.client.events.HandlerRegistration::new(Lcom/ati/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * Fires before the click event on the container is processed. Returns false
     * to cancel the default action.
     */
    public void addBeforeContainerClickHandler(BeforeContainerActionHandler handler) {
        _addBeforeContainerActionHandlerHandler(Event.BEFORE_CONTAINER_CLICK, handler);
    }

    /**
     * Fires before the contextmenu event on the container is processed.
     */
    public native HandlerRegistration addBeforeContainerContextMenuHandler(BeforeContainerContextMenuHandler handler)/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(v, e) {
			var view = @com.ati.ext4j.client.ui.DataView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(v);
			var event = @com.ati.ext4j.client.events.grid.BeforeContainerContextMenuEvent::new(Lcom/ati/ext4j/client/ui/DataView;Lcom/google/gwt/core/client/JavaScriptObject;)(view,e)
			handler.@com.ati.ext4j.client.events.grid.BeforeContainerContextMenuHandler::onBeforeContainerContextMenu(Lcom/ati/ext4j/client/events/grid/BeforeContainerContextMenuEvent;)(event);
		};
		var eventName = @com.ati.ext4j.client.events.grid.BeforeContainerContextMenuEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ati.ext4j.client.events.HandlerRegistration::new(Lcom/ati/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * Fires before the contextmenu event on the container is processed. Returns
     * false to cancel the default action.
     */
    public void addBeforeContainerContextMenuHandler(BeforeContainerActionHandler handler) {
        _addBeforeContainerActionHandlerHandler(Event.BEFORE_CONTAINER_CONTEXT_MENU, handler);
    }

    /**
     * Fires before the double click event on the container is processed.
     */
    public native HandlerRegistration addBeforeContainerDoubleClickHandler(BeforeContainerDoubleClickHandler handler)/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(v, e) {
			var view = @com.ati.ext4j.client.ui.DataView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(v);
			var event = @com.ati.ext4j.client.events.grid.BeforeContainerDoubleClickEvent::new(Lcom/ati/ext4j/client/ui/DataView;Lcom/google/gwt/core/client/JavaScriptObject;)(view,e)
			handler.@com.ati.ext4j.client.events.grid.BeforeContainerDoubleClickHandler::onBeforeContainerDoubleClick(Lcom/ati/ext4j/client/events/grid/BeforeContainerDoubleClickEvent;)(event);
		};
		var eventName = @com.ati.ext4j.client.events.grid.BeforeContainerDoubleClickEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ati.ext4j.client.events.HandlerRegistration::new(Lcom/ati/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * Fires before the double click event on the container is processed.
     * Returns false to cancel the default action.
     */
    public void addBeforeContainerDoubleClickHandler(BeforeContainerActionHandler handler) {
        _addBeforeContainerActionHandlerHandler(Event.BEFORE_CONTAINER_DOUBLE_CLICK, handler);
    }

    /**
     * Fires before the key down event on the container is processed.
     */
    public native HandlerRegistration addBeforeContainerKeyDownHandler(BeforeContainerKeyDownHandler handler)/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(v, e) {
			var view = @com.ati.ext4j.client.ui.DataView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(v);
			var event = @com.ati.ext4j.client.events.grid.BeforeContainerKeyDownEvent::new(Lcom/ati/ext4j/client/ui/DataView;Lcom/google/gwt/core/client/JavaScriptObject;)(view,e)
			handler.@com.ati.ext4j.client.events.grid.BeforeContainerKeyDownHandler::onBeforeContainerKeyDown(Lcom/ati/ext4j/client/events/grid/BeforeContainerKeyDownEvent;)(event);
		};
		var eventName = @com.ati.ext4j.client.events.grid.BeforeContainerKeyDownEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ati.ext4j.client.events.HandlerRegistration::new(Lcom/ati/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * Fires before the key down event on the container is processed. Returns
     * false to cancel the default action.
     */
    public void addBeforeContainerKeyDownHandler(BeforeContainerActionHandler handler) {
        _addBeforeContainerActionHandlerHandler(Event.BEFORE_CONTAINER_KEY_DOWN, handler);
    }

    /**
     * Fires before the mouse down event on the container is processed.
     */
    public native HandlerRegistration addBeforeContainerMouseDownHandler(BeforeContainerMouseDownHandler handler)/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(v, e) {
			var view = @com.ati.ext4j.client.ui.DataView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(v);
			var event = @com.ati.ext4j.client.events.grid.BeforeContainerMouseDownEvent::new(Lcom/ati/ext4j/client/ui/DataView;Lcom/google/gwt/core/client/JavaScriptObject;)(view,e)
			handler.@com.ati.ext4j.client.events.grid.BeforeContainerMouseDownHandler::onBeforeContainerMouseDown(Lcom/ati/ext4j/client/events/grid/BeforeContainerMouseDownEvent;)(event);
		};
		var eventName = @com.ati.ext4j.client.events.grid.BeforeContainerMouseDownEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ati.ext4j.client.events.HandlerRegistration::new(Lcom/ati/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * Fires before the mouse down event on the container is processed. Returns
     * false to cancel the default action.
     */
    public void addBeforeContainerMouseDownHandler(BeforeContainerActionHandler handler) {
        _addBeforeContainerActionHandlerHandler(Event.BEFORE_CONTAINER_MOUSE_DOWN, handler);
    }

    /**
     * Fires before the mouse out event on the container is processed.
     */
    public native HandlerRegistration addBeforeContainerMouseOutHandler(BeforeContainerMouseOutHandler handler)/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(v, e) {
			var view = @com.ati.ext4j.client.ui.DataView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(v);
			var event = @com.ati.ext4j.client.events.grid.BeforeContainerMouseOutEvent::new(Lcom/ati/ext4j/client/ui/DataView;Lcom/google/gwt/core/client/JavaScriptObject;)(view,e)
			handler.@com.ati.ext4j.client.events.grid.BeforeContainerMouseOutHandler::onBeforeContainerMouseOut(Lcom/ati/ext4j/client/events/grid/BeforeContainerMouseOutEvent;)(event);
		};
		var eventName = @com.ati.ext4j.client.events.grid.BeforeContainerMouseOutEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ati.ext4j.client.events.HandlerRegistration::new(Lcom/ati/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * Fires before the mouse out event on the container is processed. Returns
     * false to cancel the default action.
     */
    public void addBeforeContainerMouseOutHandler(BeforeContainerActionHandler handler) {
        _addBeforeContainerActionHandlerHandler(Event.BEFORE_CONTAINER_MOUSE_OUT, handler);
    }

    /**
     * Fires before the mouse over event on the container is processed.
     */
    public native HandlerRegistration addBeforeContainerMouseOverHandler(BeforeContainerMouseOverHandler handler)/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(v, e) {
			var view = @com.ati.ext4j.client.ui.DataView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(v);
			var event = @com.ati.ext4j.client.events.grid.BeforeContainerMouseOverEvent::new(Lcom/ati/ext4j/client/ui/DataView;Lcom/google/gwt/core/client/JavaScriptObject;)(view,e)
			handler.@com.ati.ext4j.client.events.grid.BeforeContainerMouseOverHandler::onBeforeContainerMouseOver(Lcom/ati/ext4j/client/events/grid/BeforeContainerMouseOverEvent;)(event);
		};
		var eventName = @com.ati.ext4j.client.events.grid.BeforeContainerMouseOverEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ati.ext4j.client.events.HandlerRegistration::new(Lcom/ati/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * Fires before the mouse over event on the container is processed. Returns
     * false to cancel the default action.
     */
    public void addBeforeContainerMouseOverHandler(BeforeContainerActionHandler handler) {
        _addBeforeContainerActionHandlerHandler(Event.BEFORE_CONTAINER_MOUSE_OVER, handler);
    }

    /**
     * Fires before the mouse up event on the container is processed.
     */
    public native HandlerRegistration addBeforeContainerMouseUpHandler(BeforeContainerMouseUpHandler handler)/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(v, e) {
			var view = @com.ati.ext4j.client.ui.DataView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(v);
			var event = @com.ati.ext4j.client.events.grid.BeforeContainerMouseUpEvent::new(Lcom/ati/ext4j/client/ui/DataView;Lcom/google/gwt/core/client/JavaScriptObject;)(view,e)
			handler.@com.ati.ext4j.client.events.grid.BeforeContainerMouseUpHandler::onBeforeContainerMouseUp(Lcom/ati/ext4j/client/events/grid/BeforeContainerMouseUpEvent;)(event);
		};
		var eventName = @com.ati.ext4j.client.events.grid.BeforeContainerMouseUpEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ati.ext4j.client.events.HandlerRegistration::new(Lcom/ati/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * Fires before the mouse up event on the container is processed. Returns
     * false to cancel the default action.
     */
    public void addBeforeContainerMouseUpHandler(BeforeContainerActionHandler handler) {
        _addBeforeContainerActionHandlerHandler(Event.BEFORE_CONTAINER_MOUSE_UP, handler);
    }

    /**
     * Fired before a record is deselected.
     */
    public native HandlerRegistration addBeforeDeselectHandler(BeforeDeselectHandler handler)/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(sm, rec, index, e) {
			var rowModel = @com.ati.ext4j.client.selection.RowSelectionModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(sm);
			var model = @com.ati.ext4j.client.data.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rec);
			var event = @com.ati.ext4j.client.events.grid.BeforeDeselectEvent::new(Lcom/ati/ext4j/client/selection/RowSelectionModel;Lcom/ati/ext4j/client/data/BaseModel;ILcom/google/gwt/core/client/JavaScriptObject;)(rowModel, model, index, e);
			handler.@com.ati.ext4j.client.events.grid.BeforeDeselectHandler::onBeforeDeselect(Lcom/ati/ext4j/client/events/grid/BeforeDeselectEvent;)(event);
		};
		var eventName = @com.ati.ext4j.client.events.grid.BeforeDeselectEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ati.ext4j.client.events.HandlerRegistration::new(Lcom/ati/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * Fired before a record is deselected. If any listener returns false, the
     * deselection is cancelled.
     */
    public void addBeforeDeselectHandler(BeforeSelectionHandler handler) {
        _addBeforeSelectionHandler(Event.BEFORE_DESELECT, handler);
    }

    /**
     * Fires before the click event on an item is processed.
     */
    public native HandlerRegistration addBeforeItemClickHandler(BeforeItemClickHandler handler)/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(v, rec, item, index, e) {
			var view = @com.ati.ext4j.client.ui.DataView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(v);
			var model = @com.ati.ext4j.client.data.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rec);
			var event = @com.ati.ext4j.client.events.grid.BeforeItemClickEvent::new(Lcom/ati/ext4j/client/ui/DataView;Lcom/ati/ext4j/client/data/BaseModel;Lcom/google/gwt/dom/client/Element;ILcom/google/gwt/core/client/JavaScriptObject;)(view,model,item,index,e);
			handler.@com.ati.ext4j.client.events.grid.BeforeItemClickHandler::onBeforeItemClick(Lcom/ati/ext4j/client/events/grid/BeforeItemClickEvent;)(event);
		};
		var eventName = @com.ati.ext4j.client.events.grid.BeforeItemClickEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ati.ext4j.client.events.HandlerRegistration::new(Lcom/ati/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * Fires before the click event on an item is processed. Returns false to
     * cancel the default action.
     */
    public void addBeforeItemClickHandler(BeforeItemActionHandler handler) {
        _addBeforeItemActionHandler(Event.BEFORE_ITEM_CLICK, handler);
    }

    /**
     * Fires before the contextmenu event on an item is processed.
     */
    public native HandlerRegistration addBeforeItemContextMenuHandler(BeforeItemContextMenuHandler handler)/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(v, rec, item, index, e) {
			var view = @com.ati.ext4j.client.ui.DataView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(v);
			var model = @com.ati.ext4j.client.data.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rec);
			var event = @com.ati.ext4j.client.events.grid.BeforeItemContextMenuEvent::new(Lcom/ati/ext4j/client/ui/DataView;Lcom/ati/ext4j/client/data/BaseModel;Lcom/google/gwt/dom/client/Element;ILcom/google/gwt/core/client/JavaScriptObject;)(view,model,item,index,e);
			handler.@com.ati.ext4j.client.events.grid.BeforeItemContextMenuHandler::onBeforeItemContextMenu(Lcom/ati/ext4j/client/events/grid/BeforeItemContextMenuEvent;)(event);
		};
		var eventName = @com.ati.ext4j.client.events.grid.BeforeItemContextMenuEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ati.ext4j.client.events.HandlerRegistration::new(Lcom/ati/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * Fires before the contextmenu event on an item is processed. Returns false
     * to cancel the default action.
     */
    public void addBeforeItemContextMenuHandler(BeforeItemActionHandler handler) {
        _addBeforeItemActionHandler(Event.BEFORE_ITEM_CONTEXT_MENU, handler);
    }

    /**
     * Fires before the double click event on an item is processed.
     */
    public native HandlerRegistration addBeforeItemDoubleClickHandler(BeforeItemDoubleClickHandler handler)/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(v, rec, item, index, e) {
			var view = @com.ati.ext4j.client.ui.DataView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(v);
			var model = @com.ati.ext4j.client.data.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rec);
			var event = @com.ati.ext4j.client.events.grid.BeforeItemDoubleClickEvent::new(Lcom/ati/ext4j/client/ui/DataView;Lcom/ati/ext4j/client/data/BaseModel;Lcom/google/gwt/dom/client/Element;ILcom/google/gwt/core/client/JavaScriptObject;)(view,model,item,index,e);
			handler.@com.ati.ext4j.client.events.grid.BeforeItemDoubleClickHandler::onBeforeItemDoubleClick(Lcom/ati/ext4j/client/events/grid/BeforeItemDoubleClickEvent;)(event);
		};
		var eventName = @com.ati.ext4j.client.events.grid.BeforeItemDoubleClickEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ati.ext4j.client.events.HandlerRegistration::new(Lcom/ati/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * Fires before the double click event on an item is processed. Returns
     * false to cancel the default action.
     */
    public void addBeforeItemDoubleClickHandler(BeforeItemActionHandler handler) {
        _addBeforeItemActionHandler(Event.BEFORE_ITEM_DOUBLE_CLICK, handler);
    }

    /**
     * Fires before the key down event on an item is processed.
     */
    public native HandlerRegistration addBeforeItemKeyDownHandler(BeforeItemKeyDownHandler handler)/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(v, rec, item, index, e) {
			var view = @com.ati.ext4j.client.ui.DataView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(v);
			var model = @com.ati.ext4j.client.data.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rec);
			var event = @com.ati.ext4j.client.events.grid.BeforeItemKeyDownEvent::new(Lcom/ati/ext4j/client/ui/DataView;Lcom/ati/ext4j/client/data/BaseModel;Lcom/google/gwt/dom/client/Element;ILcom/google/gwt/core/client/JavaScriptObject;)(view,model,item,index,e);
			handler.@com.ati.ext4j.client.events.grid.BeforeItemKeyDownHandler::onBeforeItemKeyDown(Lcom/ati/ext4j/client/events/grid/BeforeItemKeyDownEvent;)(event);
		};
		var eventName = @com.ati.ext4j.client.events.grid.BeforeItemKeyDownEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ati.ext4j.client.events.HandlerRegistration::new(Lcom/ati/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * Fires before the key down event on an item is processed. Returns false to
     * cancel the default action.
     */
    public void addBeforeItemKeyDownHandler(BeforeItemActionHandler handler) {
        _addBeforeItemActionHandler(Event.BEFORE_ITEM_KEY_DOWN, handler);
    }

    /**
     * Fires before the mouse down event on an item is processed.
     */
    public native HandlerRegistration addBeforeItemMouseDownHandler(BeforeItemMouseDownHandler handler)/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(v, rec, item, index, e) {
			var view = @com.ati.ext4j.client.ui.DataView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(v);
			var model = @com.ati.ext4j.client.data.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rec);
			var event = @com.ati.ext4j.client.events.grid.BeforeItemMouseDownEvent::new(Lcom/ati/ext4j/client/ui/DataView;Lcom/ati/ext4j/client/data/BaseModel;Lcom/google/gwt/dom/client/Element;ILcom/google/gwt/core/client/JavaScriptObject;)(view,model,item,index,e);
			handler.@com.ati.ext4j.client.events.grid.BeforeItemMouseDownHandler::onBeforeItemMouseDown(Lcom/ati/ext4j/client/events/grid/BeforeItemMouseDownEvent;)(event);
		};
		var eventName = @com.ati.ext4j.client.events.grid.BeforeItemMouseDownEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ati.ext4j.client.events.HandlerRegistration::new(Lcom/ati/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * Fires before the mouse down event on an item is processed. Returns false
     * to cancel the default action.
     */
    public void addBeforeItemMouseDownHandler(BeforeItemActionHandler handler) {
        _addBeforeItemActionHandler(Event.BEFORE_ITEM_MOUSE_DOWN, handler);
    }

    /**
     * Fires before the mouse enter event on an item is processed.
     */
    public native HandlerRegistration addBeforeItemMouseEnterHandler(BeforeItemMouseEnterHandler handler)/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(v, rec, item, index, e) {
			var view = @com.ati.ext4j.client.ui.DataView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(v);
			var model = @com.ati.ext4j.client.data.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rec);
			var event = @com.ati.ext4j.client.events.grid.BeforeItemMouseEnterEvent::new(Lcom/ati/ext4j/client/ui/DataView;Lcom/ati/ext4j/client/data/BaseModel;Lcom/google/gwt/dom/client/Element;ILcom/google/gwt/core/client/JavaScriptObject;)(view,model,item,index,e);
			handler.@com.ati.ext4j.client.events.grid.BeforeItemMouseEnterHandler::onBeforeItemMouseEnter(Lcom/ati/ext4j/client/events/grid/BeforeItemMouseEnterEvent;)(event);
		};
		var eventName = @com.ati.ext4j.client.events.grid.BeforeItemMouseEnterEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ati.ext4j.client.events.HandlerRegistration::new(Lcom/ati/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * Fires before the mouse enter event on an item is processed. Returns false
     * to cancel the default action.
     */
    public void addBeforeItemMouseEnterHandler(BeforeItemActionHandler handler) {
        _addBeforeItemActionHandler(Event.BEFORE_ITEM_MOUSE_ENTER, handler);
    }

    /**
     * Fires before the mouse leave event on an item is processed.
     */
    public native HandlerRegistration addBeforeItemMouseLeaveHandler(BeforeItemMouseLeaveHandler handler)/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(v, rec, item, index, e) {
			var view = @com.ati.ext4j.client.ui.DataView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(v);
			var model = @com.ati.ext4j.client.data.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rec);
			var event = @com.ati.ext4j.client.events.grid.BeforeItemMouseLeaveEvent::new(Lcom/ati/ext4j/client/ui/DataView;Lcom/ati/ext4j/client/data/BaseModel;Lcom/google/gwt/dom/client/Element;ILcom/google/gwt/core/client/JavaScriptObject;)(view,model,item,index,e);
			handler.@com.ati.ext4j.client.events.grid.BeforeItemMouseLeaveHandler::onBeforeItemMouseLeave(Lcom/ati/ext4j/client/events/grid/BeforeItemMouseLeaveEvent;)(event);
		};
		var eventName = @com.ati.ext4j.client.events.grid.BeforeItemMouseLeaveEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ati.ext4j.client.events.HandlerRegistration::new(Lcom/ati/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * Fires before the mouse leave event on an item is processed. Returns false
     * to cancel the default action.
     */
    public void addBeforeItemMouseLeaveHandler(BeforeItemActionHandler handler) {
        _addBeforeItemActionHandler(Event.BEFORE_ITEM_MOUSE_LEAVE, handler);
    }

    /**
     * Fires before the mouse up event on an item is processed.
     */
    public native HandlerRegistration addBeforeItemMouseUpHandler(BeforeItemMouseUpHandler handler)/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(v, rec, item, index, e) {
			var view = @com.ati.ext4j.client.ui.DataView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(v);
			var model = @com.ati.ext4j.client.data.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rec);
			var event = @com.ati.ext4j.client.events.grid.BeforeItemMouseUpEvent::new(Lcom/ati/ext4j/client/ui/DataView;Lcom/ati/ext4j/client/data/BaseModel;Lcom/google/gwt/dom/client/Element;ILcom/google/gwt/core/client/JavaScriptObject;)(view,model,item,index,e);
			handler.@com.ati.ext4j.client.events.grid.BeforeItemMouseUpHandler::onBeforeItemMouseUp(Lcom/ati/ext4j/client/events/grid/BeforeItemMouseUpEvent;)(event);
		};
		var eventName = @com.ati.ext4j.client.events.grid.BeforeItemMouseUpEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ati.ext4j.client.events.HandlerRegistration::new(Lcom/ati/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * Fires before the mouse up event on an item is processed. Returns false to
     * cancel the default action.
     */
    public void addBeforeItemMouseUpHandler(BeforeItemActionHandler handler) {
        _addBeforeItemActionHandler(Event.BEFORE_ITEM_MOUSE_UP, handler);
    }

    /**
     * Fired before a record is selected.
     */
    public native HandlerRegistration addBeforeSelectHandler(BeforeSelectHandler handler)/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(sm, rec, index, e) {
			var rowModel = @com.ati.ext4j.client.selection.RowSelectionModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(sm);
			var model = @com.ati.ext4j.client.data.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rec);
			var event = @com.ati.ext4j.client.events.grid.BeforeSelectEvent::new(Lcom/ati/ext4j/client/selection/RowSelectionModel;Lcom/ati/ext4j/client/data/BaseModel;ILcom/google/gwt/core/client/JavaScriptObject;)(rowModel, model, index, e);
			handler.@com.ati.ext4j.client.events.grid.BeforeSelectHandler::onBeforeSelect(Lcom/ati/ext4j/client/events/grid/BeforeSelectEvent;)(event);
		};
		var eventName = @com.ati.ext4j.client.events.grid.BeforeSelectEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ati.ext4j.client.events.HandlerRegistration::new(Lcom/ati/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * Fired before a record is selected. If any listener returns false, the
     * selection is cancelled.
     */
    public void addBeforeSelectHandler(BeforeSelectionHandler handler) {
        _addBeforeSelectionHandler(Event.BEFORE_SELECT, handler);
    }

    /**
     * Fires when the container is clicked.
     */
    public native HandlerRegistration addContainerClickHandler(ContainerClickHandler handler)/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(v, e) {
			var view = @com.ati.ext4j.client.ui.DataView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(v);
			var event = @com.ati.ext4j.client.events.grid.ContainerClickEvent::new(Lcom/ati/ext4j/client/ui/DataView;Lcom/google/gwt/core/client/JavaScriptObject;)(view,e)
			handler.@com.ati.ext4j.client.events.grid.ContainerClickHandler::onContainerClick(Lcom/ati/ext4j/client/events/grid/ContainerClickEvent;)(event);

		};
		var eventName = @com.ati.ext4j.client.events.grid.ContainerClickEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ati.ext4j.client.events.HandlerRegistration::new(Lcom/ati/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * Fires when the container is right clicked.
     */
    public native HandlerRegistration addContainerContextMenuHandler(ContainerContextMenuHandler handler)/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(v, e) {
			var view = @com.ati.ext4j.client.ui.DataView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(v);
			var event = @com.ati.ext4j.client.events.grid.ContainerContextMenuEvent::new(Lcom/ati/ext4j/client/ui/DataView;Lcom/google/gwt/core/client/JavaScriptObject;)(view,e)
			handler.@com.ati.ext4j.client.events.grid.ContainerContextMenuHandler::onContainerContextMenu(Lcom/ati/ext4j/client/events/grid/ContainerContextMenuEvent;)(event);
		};
		var eventName = @com.ati.ext4j.client.events.grid.ContainerContextMenuEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ati.ext4j.client.events.HandlerRegistration::new(Lcom/ati/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * Fires when the container is double clicked.
     */
    public native HandlerRegistration addContainerDoubleClickHandler(ContainerDoubleClickHandler handler)/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(v, e) {
			var view = @com.ati.ext4j.client.ui.DataView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(v);
			var event = @com.ati.ext4j.client.events.grid.ContainerDoubleClickEvent::new(Lcom/ati/ext4j/client/ui/DataView;Lcom/google/gwt/core/client/JavaScriptObject;)(view,e)
			handler.@com.ati.ext4j.client.events.grid.ContainerDoubleClickHandler::onContainerDoubleClick(Lcom/ati/ext4j/client/events/grid/ContainerDoubleClickEvent;)(event);
		};
		var eventName = @com.ati.ext4j.client.events.grid.ContainerDoubleClickEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ati.ext4j.client.events.HandlerRegistration::new(Lcom/ati/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * Fires when a key is pressed while the container is focused, and no item
     * is currently selected.
     */
    public native HandlerRegistration addContainerKeyDownHandler(ContainerKeyDownHandler handler)/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(v, e) {
			var view = @com.ati.ext4j.client.ui.DataView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(v);
			var event = @com.ati.ext4j.client.events.grid.ContainerKeyDownEvent::new(Lcom/ati/ext4j/client/ui/DataView;Lcom/google/gwt/core/client/JavaScriptObject;)(view,e)
			handler.@com.ati.ext4j.client.events.grid.ContainerKeyDownHandler::onContainerKeyDown(Lcom/ati/ext4j/client/events/grid/ContainerKeyDownEvent;)(event);
		};
		var eventName = @com.ati.ext4j.client.events.grid.ContainerKeyDownEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ati.ext4j.client.events.HandlerRegistration::new(Lcom/ati/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    public native HandlerRegistration addContainerMouseDownHandler(ContainerMouseDownHandler handler)/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(v, e) {
			var view = @com.ati.ext4j.client.ui.DataView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(v);
			var event = @com.ati.ext4j.client.events.grid.ContainerMouseDownEvent::new(Lcom/ati/ext4j/client/ui/DataView;Lcom/google/gwt/core/client/JavaScriptObject;)(view,e)
			handler.@com.ati.ext4j.client.events.grid.ContainerMouseDownHandler::onContainerMouseDown(Lcom/ati/ext4j/client/events/grid/ContainerMouseDownEvent;)(event);
		};
		var eventName = @com.ati.ext4j.client.events.grid.ContainerMouseDownEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ati.ext4j.client.events.HandlerRegistration::new(Lcom/ati/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    public native HandlerRegistration addContainerMouseOutHandler(ContainerMouseOutHandler handler)/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(v, e) {
			var view = @com.ati.ext4j.client.ui.DataView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(v);
			var event = @com.ati.ext4j.client.events.grid.ContainerMouseOutEvent::new(Lcom/ati/ext4j/client/ui/DataView;Lcom/google/gwt/core/client/JavaScriptObject;)(view,e)
			handler.@com.ati.ext4j.client.events.grid.ContainerMouseOutHandler::onContainerMouseOut(Lcom/ati/ext4j/client/events/grid/ContainerMouseOutEvent;)(event);
		};
		var eventName = @com.ati.ext4j.client.events.grid.ContainerMouseOutEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ati.ext4j.client.events.HandlerRegistration::new(Lcom/ati/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    public native HandlerRegistration addContainerMouseOverHandler(ContainerMouseOverHandler handler)/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(v, e) {
			var view = @com.ati.ext4j.client.ui.DataView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(v);
			var event = @com.ati.ext4j.client.events.grid.ContainerMouseOverEvent::new(Lcom/ati/ext4j/client/ui/DataView;Lcom/google/gwt/core/client/JavaScriptObject;)(view,e)
			handler.@com.ati.ext4j.client.events.grid.ContainerMouseOverHandler::onContainerMouseOver(Lcom/ati/ext4j/client/events/grid/ContainerMouseOverEvent;)(event);
		};
		var eventName = @com.ati.ext4j.client.events.grid.ContainerMouseOverEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ati.ext4j.client.events.HandlerRegistration::new(Lcom/ati/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    public native HandlerRegistration addContainerMouseUpHandler(ContainerMouseUpHandler handler)/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(v, e) {
			var view = @com.ati.ext4j.client.ui.DataView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(v);
			var event = @com.ati.ext4j.client.events.grid.ContainerMouseUpEvent::new(Lcom/ati/ext4j/client/ui/DataView;Lcom/google/gwt/core/client/JavaScriptObject;)(view,e)
			handler.@com.ati.ext4j.client.events.grid.ContainerMouseUpHandler::onContainerMouseUp(Lcom/ati/ext4j/client/events/grid/ContainerMouseUpEvent;)(event);
		};
		var eventName = @com.ati.ext4j.client.events.grid.ContainerMouseUpEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ati.ext4j.client.events.HandlerRegistration::new(Lcom/ati/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * Fired when a record is deselected.
     */
    public native HandlerRegistration addDeselectHandler(DeselectHandler handler)/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(sm, rec, index, e) {
			var rowModel = @com.ati.ext4j.client.selection.RowSelectionModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(sm);
			var model = @com.ati.ext4j.client.data.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rec);
			var event = @com.ati.ext4j.client.events.grid.DeselectEvent::new(Lcom/ati/ext4j/client/selection/RowSelectionModel;Lcom/ati/ext4j/client/data/BaseModel;ILcom/google/gwt/core/client/JavaScriptObject;)(rowModel, model, index, e);
			handler.@com.ati.ext4j.client.events.grid.DeselectHandler::onDeselect(Lcom/ati/ext4j/client/events/grid/DeselectEvent;)(event);
		};
		var eventName = @com.ati.ext4j.client.events.grid.DeselectEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ati.ext4j.client.events.HandlerRegistration::new(Lcom/ati/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    public native HandlerRegistration addItemClickHandler(ItemClickHandler handler)/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(v, rec, item, index, e) {
			var view = @com.ati.ext4j.client.ui.TableView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(v);
			var model = @com.ati.ext4j.client.data.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rec);
			var event = @com.ati.ext4j.client.events.view.ItemClickEvent::new(Lcom/ati/ext4j/client/ui/TableView;Lcom/ati/ext4j/client/data/BaseModel;Lcom/google/gwt/dom/client/Element;ILcom/google/gwt/core/client/JavaScriptObject;)(view,model,item,index,e);
			handler.@com.ati.ext4j.client.events.view.ItemClickHandler::onItemClick(Lcom/ati/ext4j/client/events/view/ItemClickEvent;)(event);
		};
		var eventName = @com.ati.ext4j.client.events.view.ItemClickEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ati.ext4j.client.events.HandlerRegistration::new(Lcom/ati/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    public native HandlerRegistration addItemContextMenuHandler(ItemContextMenuHandler handler)/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(v, rec, item, index, e) {
			var view = @com.ati.ext4j.client.ui.TableView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(v);
			var model = @com.ati.ext4j.client.data.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rec);
			var event = @com.ati.ext4j.client.events.view.ItemContextMenuEvent::new(Lcom/ati/ext4j/client/ui/TableView;Lcom/ati/ext4j/client/data/BaseModel;Lcom/google/gwt/dom/client/Element;ILcom/google/gwt/core/client/JavaScriptObject;)(view,model,item,index,e);
			handler.@com.ati.ext4j.client.events.view.ItemContextMenuHandler::onItemContextMenu(Lcom/ati/ext4j/client/events/view/ItemContextMenuEvent;)(event);
		};
		var eventName = @com.ati.ext4j.client.events.view.ItemContextMenuEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ati.ext4j.client.events.HandlerRegistration::new(Lcom/ati/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    public native HandlerRegistration addItemDoubleClickHandler(ItemDoubleClickHandler handler)/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(v, rec, item, index, e) {
			var view = @com.ati.ext4j.client.ui.TableView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(v);
			var model = @com.ati.ext4j.client.data.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rec);
			var event = @com.ati.ext4j.client.events.view.ItemDoubleClickEvent::new(Lcom/ati/ext4j/client/ui/TableView;Lcom/ati/ext4j/client/data/BaseModel;Lcom/google/gwt/dom/client/Element;ILcom/google/gwt/core/client/JavaScriptObject;)(view,model,item,index,e);
			handler.@com.ati.ext4j.client.events.view.ItemDoubleClickHandler::onItemDoubleClick(Lcom/ati/ext4j/client/events/view/ItemDoubleClickEvent;)(event);
		};
		var eventName = @com.ati.ext4j.client.events.view.ItemDoubleClickEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ati.ext4j.client.events.HandlerRegistration::new(Lcom/ati/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    public native HandlerRegistration addItemKeyDownHandler(ItemKeyDownHandler handler)/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(v, rec, item, index, e) {
			var view = @com.ati.ext4j.client.ui.TableView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(v);
			var model = @com.ati.ext4j.client.data.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rec);
			var event = @com.ati.ext4j.client.events.view.ItemKeyDownEvent::new(Lcom/ati/ext4j/client/ui/TableView;Lcom/ati/ext4j/client/data/BaseModel;Lcom/google/gwt/dom/client/Element;ILcom/google/gwt/core/client/JavaScriptObject;)(view,model,item,index,e);
			handler.@com.ati.ext4j.client.events.view.ItemKeyDownHandler::onItemKeyDown(Lcom/ati/ext4j/client/events/view/ItemKeyDownEvent;)(event);
		};
		var eventName = @com.ati.ext4j.client.events.view.ItemKeyDownEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ati.ext4j.client.events.HandlerRegistration::new(Lcom/ati/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    public native HandlerRegistration addItemMouseDownHandler(ItemMouseDownHandler handler)/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(v, rec, item, index, e) {
			var view = @com.ati.ext4j.client.ui.TableView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(v);
			var model = @com.ati.ext4j.client.data.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rec);
			var event = @com.ati.ext4j.client.events.view.ItemMouseDownEvent::new(Lcom/ati/ext4j/client/ui/TableView;Lcom/ati/ext4j/client/data/BaseModel;Lcom/google/gwt/dom/client/Element;ILcom/google/gwt/core/client/JavaScriptObject;)(view,model,item,index,e);
			handler.@com.ati.ext4j.client.events.view.ItemMouseDownHandler::onItemMouseDown(Lcom/ati/ext4j/client/events/view/ItemMouseDownEvent;)(event);
		};
		var eventName = @com.ati.ext4j.client.events.view.ItemMouseDownEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ati.ext4j.client.events.HandlerRegistration::new(Lcom/ati/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    public native HandlerRegistration addItemMouseEnterHandler(ItemMouseEnterHandler handler)/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(v, rec, item, index, e) {
			var view = @com.ati.ext4j.client.ui.TableView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(v);
			var model = @com.ati.ext4j.client.data.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rec);
			var event = @com.ati.ext4j.client.events.view.ItemMouseEnterEvent::new(Lcom/ati/ext4j/client/ui/TableView;Lcom/ati/ext4j/client/data/BaseModel;Lcom/google/gwt/dom/client/Element;ILcom/google/gwt/core/client/JavaScriptObject;)(view,model,item,index,e);
			handler.@com.ati.ext4j.client.events.view.ItemMouseEnterHandler::onItemMouseEnter(Lcom/ati/ext4j/client/events/view/ItemMouseEnterEvent;)(event);
		};
		var eventName = @com.ati.ext4j.client.events.view.ItemMouseEnterEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ati.ext4j.client.events.HandlerRegistration::new(Lcom/ati/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    public native HandlerRegistration addItemMouseLeaveHandler(ItemMouseLeaveHandler handler)/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(v, rec, item, index, e) {
			var view = @com.ati.ext4j.client.ui.TableView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(v);
			var model = @com.ati.ext4j.client.data.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rec);
			var event = @com.ati.ext4j.client.events.view.ItemMouseLeaveEvent::new(Lcom/ati/ext4j/client/ui/TableView;Lcom/ati/ext4j/client/data/BaseModel;Lcom/google/gwt/dom/client/Element;ILcom/google/gwt/core/client/JavaScriptObject;)(view,model,item,index,e);
			handler.@com.ati.ext4j.client.events.view.ItemMouseLeaveHandler::onItemMouseLeave(Lcom/ati/ext4j/client/events/view/ItemMouseLeaveEvent;)(event);
		};
		var eventName = @com.ati.ext4j.client.events.view.ItemMouseLeaveEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ati.ext4j.client.events.HandlerRegistration::new(Lcom/ati/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    public native HandlerRegistration addItemMouseUpHandler(ItemMouseUpHandler handler)/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(v, rec, item, index, e) {
			var view = @com.ati.ext4j.client.ui.TableView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(v);
			var model = @com.ati.ext4j.client.data.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rec);
			var event = @com.ati.ext4j.client.events.view.ItemMouseUpEvent::new(Lcom/ati/ext4j/client/ui/TableView;Lcom/ati/ext4j/client/data/BaseModel;Lcom/google/gwt/dom/client/Element;ILcom/google/gwt/core/client/JavaScriptObject;)(view,model,item,index,e);
			handler.@com.ati.ext4j.client.events.view.ItemMouseUpHandler::onItemMouseUp(Lcom/ati/ext4j/client/events/view/ItemMouseUpEvent;)(event);
		};
		var eventName = @com.ati.ext4j.client.events.view.ItemMouseUpEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ati.ext4j.client.events.HandlerRegistration::new(Lcom/ati/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * Fired when a record is selected.
     */
    public native HandlerRegistration addSelectHandler(SelectHandler handler)/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(sm, rec, index, e) {
			var rowModel = @com.ati.ext4j.client.selection.RowSelectionModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(sm);
			var model = @com.ati.ext4j.client.data.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rec);
			var event = @com.ati.ext4j.client.events.grid.SelectEvent::new(Lcom/ati/ext4j/client/selection/RowSelectionModel;Lcom/ati/ext4j/client/data/BaseModel;ILcom/google/gwt/core/client/JavaScriptObject;)(rowModel, model, index, e);
			handler.@com.ati.ext4j.client.events.grid.SelectHandler::onSelect(Lcom/ati/ext4j/client/events/grid/SelectEvent;)(event);
		};
		var eventName = @com.ati.ext4j.client.events.grid.SelectEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ati.ext4j.client.events.HandlerRegistration::new(Lcom/ati/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    public native HandlerRegistration addSelectionChangeHandler(SelectionChangeHandler handler)/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(sm, rec, e) {
			var rowModel = @com.ati.ext4j.client.selection.RowSelectionModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(sm);
			var model = @com.ati.ext4j.client.data.BaseModel::fromJsArray(Lcom/google/gwt/core/client/JavaScriptObject;)(rec);
			var event = @com.ati.ext4j.client.events.grid.SelectionChangeEvent::new(Lcom/ati/ext4j/client/selection/RowSelectionModel;Ljava/util/List;Lcom/google/gwt/core/client/JavaScriptObject;)(rowModel,model,e);
			handler.@com.ati.ext4j.client.events.grid.SelectionChangeHandler::onSelectionChange(Lcom/ati/ext4j/client/events/grid/SelectionChangeEvent;)(event);
		};
		var eventName = @com.ati.ext4j.client.events.grid.SelectionChangeEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ati.ext4j.client.events.HandlerRegistration::new(Lcom/ati/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    public native HandlerRegistration addFocusChangeHandler(FocusChangeHandler handler)/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(sm, o, n, e) {
			var sm = @com.ati.ext4j.client.selection.SelectionModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(sm);
			var oldFocused = @com.ati.ext4j.client.data.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(oldFocused);
			var newFocused = @com.ati.ext4j.client.data.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(n);
			var event = @com.ati.ext4j.client.events.view.FocusChangeEvent::new(Lcom/ati/ext4j/client/selection/SelectionModel;Lcom/ati/ext4j/client/data/BaseModel;Lcom/ati/ext4j/client/data/BaseModel;Lcom/google/gwt/core/client/JavaScriptObject;)(sm,oldFocused,newFocused,e);
			handler.@com.ati.ext4j.client.events.view.FocusChangeHandler::onFocusChange(Lcom/ati/ext4j/client/events/view/FocusChangeEvent;)(event);
		};
		var eventName = @com.ati.ext4j.client.events.view.FocusChangeEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ati.ext4j.client.events.HandlerRegistration::new(Lcom/ati/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    public native HandlerRegistration addHighlightItemHandler(HighlightItemHandler handler)/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(v, el, e) {
			var view = @com.ati.ext4j.client.ui.DataView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(v);
			var element = @com.ati.ext4j.client.core.ExtElement::new(Lcom/google/gwt/core/client/JavaScriptObject;)(el);
			var event = @com.ati.ext4j.client.events.view.HighlightItemEvent::new(Lcom/ati/ext4j/client/ui/DataView;Lcom/ati/ext4j/client/core/ExtElement;Lcom/google/gwt/core/client/JavaScriptObject;)(view,element,e);
			handler.@com.ati.ext4j.client.events.view.HighlightItemHandler::onHighligthItem(Lcom/ati/ext4j/client/events/view/HighlightItemEvent;)(event);
		};
		var eventName = @com.ati.ext4j.client.events.view.HighlightItemEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ati.ext4j.client.events.HandlerRegistration::new(Lcom/ati/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    public native HandlerRegistration addUnHighlightItemHandler(UnHighlightItemHandler handler)/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(v, el, e) {
			var view = @com.ati.ext4j.client.ui.DataView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(v);
			var element = @com.ati.ext4j.client.core.ExtElement::new(Lcom/google/gwt/core/client/JavaScriptObject;)(el);
			var event = @com.ati.ext4j.client.events.view.UnHighlightItemEvent::new(Lcom/ati/ext4j/client/ui/DataView;Lcom/ati/ext4j/client/core/ExtElement;Lcom/google/gwt/core/client/JavaScriptObject;)(view,element,e);
			handler.@com.ati.ext4j.client.events.view.UnHighlightItemHandler::onUnHighligthItem(Lcom/ati/ext4j/client/events/view/UnHighlightItemEvent;)(event);
		};
		var eventName = @com.ati.ext4j.client.events.view.UnHighlightItemEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ati.ext4j.client.events.HandlerRegistration::new(Lcom/ati/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * Creates a new DataView from the given component
     * 
     * @param component
     *            , the component to cast from
     * @return, a new DataView from the component
     * 
     */
    public static DataView cast(Component component) {
        return new DataView(component.getOrCreateJsObj());
    }

    private native void _addBeforeContainerActionHandlerHandler(String event, BeforeContainerActionHandler handler)/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		component
				.addListener(
						event,
						$entry(function(v, e) {
							var cmp = @com.ati.ext4j.client.ui.DataView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(v);
							var event = @com.ati.ext4j.client.core.EventObject::new(Lcom/google/gwt/core/client/JavaScriptObject;)(e);
							return handler.@com.ati.ext4j.client.events.grid.BeforeContainerActionHandler::onAction(Lcom/ati/ext4j/client/ui/DataView;Lcom/ati/ext4j/client/core/EventObject;)(cmp,event);
						}));
    }-*/;

    private native void _addBeforeSelectionHandler(String event, BeforeSelectionHandler handler)/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		component
				.addListener(
						event,
						$entry(function(rm, rec, index) {
							var rowModel = @com.ati.ext4j.client.selection.RowSelectionModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rm);
							var model = @com.ati.ext4j.client.data.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rec);
							return handler.@com.ati.ext4j.client.events.grid.BeforeSelectionHandler::onAction(Lcom/ati/ext4j/client/selection/RowSelectionModel;Lcom/ati/ext4j/client/data/BaseModel;I)(rowModel,record,index);
						}));
    }-*/;

    private native void _addBeforeItemActionHandler(String event, BeforeItemActionHandler handler)/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		component
				.addListener(
						event,
						$entry(function(v, rec, item, index, e) {
							var cmp = @com.ati.ext4j.client.ui.DataView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(v);
							var model = @com.ati.ext4j.client.data.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rec);
							var event = @com.ati.ext4j.client.core.EventObject::new(Lcom/google/gwt/core/client/JavaScriptObject;)(e);
							return handler.@com.ati.ext4j.client.events.grid.BeforeItemActionHandler::onAction(Lcom/ati/ext4j/client/ui/DataView;Lcom/ati/ext4j/client/data/BaseModel;Lcom/google/gwt/dom/client/Element;ILcom/ati/ext4j/client/core/EventObject;)(cmp,model,item,index, event);
						}));
    }-*/;
}
