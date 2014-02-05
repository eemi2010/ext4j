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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.eemi.ext4j.client.core.Component;
import com.eemi.ext4j.client.core.JsoHelper;
import com.eemi.ext4j.client.core.config.XType;
import com.eemi.ext4j.client.data.Store;
import com.eemi.ext4j.client.events.Event;
import com.eemi.ext4j.client.events.HandlerRegistration;
import com.eemi.ext4j.client.events.grid.BeforeActionHandler;
import com.eemi.ext4j.client.events.grid.BeforeCellClickEvent;
import com.eemi.ext4j.client.events.grid.BeforeCellClickHandler;
import com.eemi.ext4j.client.events.grid.BeforeCellContextMenuEvent;
import com.eemi.ext4j.client.events.grid.BeforeCellContextMenuHandler;
import com.eemi.ext4j.client.events.grid.BeforeCellDoubleClickEvent;
import com.eemi.ext4j.client.events.grid.BeforeCellDoubleClickHandler;
import com.eemi.ext4j.client.events.grid.BeforeCellKeyDownEvent;
import com.eemi.ext4j.client.events.grid.BeforeCellKeyDownHandler;
import com.eemi.ext4j.client.events.grid.BeforeCellMouseDownEvent;
import com.eemi.ext4j.client.events.grid.BeforeCellMouseDownHandler;
import com.eemi.ext4j.client.events.grid.BeforeCellMouseUpEvent;
import com.eemi.ext4j.client.events.grid.BeforeCellMouseUpHandler;
import com.eemi.ext4j.client.events.grid.BeforeContainerActionHandler;
import com.eemi.ext4j.client.events.grid.BeforeContainerClickHandler;
import com.eemi.ext4j.client.events.grid.BeforeContainerContextMenuHandler;
import com.eemi.ext4j.client.events.grid.BeforeContainerDoubleClickHandler;
import com.eemi.ext4j.client.events.grid.BeforeContainerKeyDownHandler;
import com.eemi.ext4j.client.events.grid.BeforeContainerMouseDownHandler;
import com.eemi.ext4j.client.events.grid.BeforeContainerMouseOutHandler;
import com.eemi.ext4j.client.events.grid.BeforeContainerMouseOverHandler;
import com.eemi.ext4j.client.events.grid.BeforeContainerMouseUpHandler;
import com.eemi.ext4j.client.events.grid.BeforeDeselectHandler;
import com.eemi.ext4j.client.events.grid.BeforeItemActionHandler;
import com.eemi.ext4j.client.events.grid.BeforeItemClickHandler;
import com.eemi.ext4j.client.events.grid.BeforeItemContextMenuHandler;
import com.eemi.ext4j.client.events.grid.BeforeItemDoubleClickHandler;
import com.eemi.ext4j.client.events.grid.BeforeItemKeyDownHandler;
import com.eemi.ext4j.client.events.grid.BeforeItemMouseDownHandler;
import com.eemi.ext4j.client.events.grid.BeforeItemMouseEnterHandler;
import com.eemi.ext4j.client.events.grid.BeforeItemMouseLeaveHandler;
import com.eemi.ext4j.client.events.grid.BeforeItemMouseUpHandler;
import com.eemi.ext4j.client.events.grid.BeforeSelectHandler;
import com.eemi.ext4j.client.events.grid.BeforeSelectionHandler;
import com.eemi.ext4j.client.events.grid.CellClickHandler;
import com.eemi.ext4j.client.events.grid.CellContextMenuHandler;
import com.eemi.ext4j.client.events.grid.CellDoubleClickHandler;
import com.eemi.ext4j.client.events.grid.CellKeyDownHandler;
import com.eemi.ext4j.client.events.grid.CellMouseDownHandler;
import com.eemi.ext4j.client.events.grid.CellMouseUpHandler;
import com.eemi.ext4j.client.events.grid.ColumnHideHandler;
import com.eemi.ext4j.client.events.grid.ColumnMoveHandler;
import com.eemi.ext4j.client.events.grid.ColumnResizeHandler;
import com.eemi.ext4j.client.events.grid.ColumnShowHandler;
import com.eemi.ext4j.client.events.grid.ColumnsChangedHandler;
import com.eemi.ext4j.client.events.grid.ContainerClickHandler;
import com.eemi.ext4j.client.events.grid.ContainerContextMenuHandler;
import com.eemi.ext4j.client.events.grid.ContainerDoubleClickHandler;
import com.eemi.ext4j.client.events.grid.ContainerKeyDownHandler;
import com.eemi.ext4j.client.events.grid.ContainerMouseDownHandler;
import com.eemi.ext4j.client.events.grid.ContainerMouseOutHandler;
import com.eemi.ext4j.client.events.grid.ContainerMouseOverHandler;
import com.eemi.ext4j.client.events.grid.ContainerMouseUpHandler;
import com.eemi.ext4j.client.events.grid.DeselectHandler;
import com.eemi.ext4j.client.events.grid.FilterChangeHandler;
import com.eemi.ext4j.client.events.grid.GroupChangeHandler;
import com.eemi.ext4j.client.events.grid.HeaderClickHandler;
import com.eemi.ext4j.client.events.grid.HeaderContextMenuHandler;
import com.eemi.ext4j.client.events.grid.HeaderTriggerClickHandler;
import com.eemi.ext4j.client.events.grid.SelectHandler;
import com.eemi.ext4j.client.events.grid.SelectionChangeHandler;
import com.eemi.ext4j.client.events.grid.SortChangeHandler;
import com.eemi.ext4j.client.events.grid.ViewReadyHandler;
import com.eemi.ext4j.client.events.view.ItemClickHandler;
import com.eemi.ext4j.client.events.view.ItemContextMenuHandler;
import com.eemi.ext4j.client.events.view.ItemDoubleClickHandler;
import com.eemi.ext4j.client.events.view.ItemKeyDownHandler;
import com.eemi.ext4j.client.events.view.ItemMouseDownHandler;
import com.eemi.ext4j.client.events.view.ItemMouseEnterHandler;
import com.eemi.ext4j.client.events.view.ItemMouseLeaveHandler;
import com.eemi.ext4j.client.events.view.ItemMouseUpHandler;
import com.eemi.ext4j.client.grid.HeaderContainer;
import com.eemi.ext4j.client.grid.VerticalScroller;
import com.eemi.ext4j.client.grid.ViewConfig;
import com.eemi.ext4j.client.grid.column.GridColumn;
import com.eemi.ext4j.client.grid.feature.Feature;
import com.eemi.ext4j.client.laf.Scroll;
import com.eemi.ext4j.client.selection.SelectionModel;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.dom.client.Element;

/**
 * TablePanel is the basis of both {@link TreePanel} and {@link GridPanel}.
 */
public class TablePanel extends Panel {

    private static JavaScriptObject configPrototype;
    protected Store store;
    protected List<GridColumn> columns = new ArrayList<GridColumn>();

    private native void init()/*-{
		var c = new $wnd.Ext.panel.Table();
		@com.eemi.ext4j.client.ui.Panel::configPrototype = c.initialConfig;
    }-*/;

    protected JavaScriptObject getConfigPrototype() {
        return configPrototype;
    }

    public String getXType() {
        return XType.TABLE.getValue();
    }

    /**
     * Create a new NotificationContainer.
     */
    public TablePanel() {
    }

    protected TablePanel(JavaScriptObject obj) {
        super(obj);
    }

    /**
     * Applys the NotificationContainer to an existing element.
     * 
     * @param element
     *            the element
     */
    public TablePanel(Element element) {
        super(element);
    }

    /**
     * The Store the grid should use as its data source.
     * 
     * @param store
     */
    public void setStore(Store store) {
        this.store = store;
        setAttribute("store", store.getJsObj(), true);
    }

    /**
     * True to allow deselecting a record.
     * 
     * Defaults to: false
     */
    public void setAllowDeselect(boolean value) {
        setAttribute("allowDeselect", value, true);
    }

    /**
     * Adds column line styling
     */
    public void setColumnLines(boolean value) {
        setAttribute("columnLines", value, true);
    }

    public void setMultiSelect(boolean value) {
        setAttribute("multiSelect", value, true);
    }

    /**
     * Add a column this this table internal collection of columns but does not
     * render it. Remember to call <code>renderColumns()</code> to actually add
     * the columns to the underlying grid
     * 
     * @param column
     *            , the column to add
     */
    public void addColumn(GridColumn column) {
        this.columns.add(column);
    }

    /**
     * Render the internal column collection
     */
    public void renderColumns() {
        JsArray<JavaScriptObject> jsos = JsArray.createArray().cast();
        for (GridColumn cols : this.columns) {
            jsos.push(cols.getJsObj());
        }
        setAttribute("columns", jsos, true, true);
    }

    /**
     * An array of column definition objects which define all columns that
     * appear in this grid. Each column definition provides the header text for
     * the column, and a definition of where the data for that column comes
     * from.
     * 
     * @param gridColumns
     */
    public void setColumns(List<GridColumn> gridColumns) {
        this.columns.clear();
        this.columns.addAll(gridColumns);
        JsArray<JavaScriptObject> jsos = JsArray.createArray().cast();
        for (GridColumn cols : gridColumns) {
            jsos.push(cols.getJsObj());
        }
        setAttribute("columns", jsos, true);
    }

    /**
     * An array of column definition objects which define all columns that
     * appear in this grid. Each column definition provides the header text for
     * the column, and a definition of where the data for that column comes
     * from.
     * 
     * @param gridColumns
     */
    public void setColumns(GridColumn... gridColumns) {
        this.columns.clear();
        this.columns.addAll(Arrays.asList(gridColumns));
        JsArray<JavaScriptObject> jsos = JsArray.createArray().cast();
        for (GridColumn cols : gridColumns) {
            jsos.push(cols.getJsObj());
        }
        setAttribute("columns", jsos, true);
    }

    /**
     * UI Binders
     * 
     * @param gridColumns
     */
    public void setGridColumns(List<GridColumn> gridColumns) {
        setColumns(gridColumns);
    }

    /**
     * Get this table grid column collection
     * 
     * @return
     */
    public List<GridColumn> getColumns() {
        JavaScriptObject peers = _getColumns();
        int size = JsoHelper.arrayLength(peers);
        for (int i = 0; i < size; i++) {
            GridColumn col = this.columns.get(i);
            col.update(JsoHelper.getValueFromJavaScriptObjectArray(peers, i));
        }
        return this.columns;
    }

    private JavaScriptObject _getColumns() {
        return getAttributeAsJavaScriptObject("columns");
    }

    /**
     * Defaults to true to enable deferred row rendering.
     * <p>
     * This allows the View to execute a refresh quickly, with the expensive
     * update of the row structure deferred so that layouts with GridPanels
     * appear, and lay out more quickly.
     */
    public void setDeferRowRender(boolean value) {
        setAttribute("deferRowRender", value, true);
    }

    /**
     * True to disable selection model.
     * <p>
     * Defaults to: false
     */
    public void setDisableSelection(boolean value) {
        setAttribute("disableSelection", value, true);
    }

    /**
     * Default text (html tags are accepted) to display in the
     * NotificationContainer body when the Store is empty. When specified, and
     * the Store is empty, the text will be rendered inside a DIV with the CSS
     * class "x-grid-empty".
     */
    public void setEmptyText(String value) {
        setAttribute("emptyText", value, true);
    }

    /**
     * False to disable column hiding within this grid.
     * <p>
     * Defaults to: true
     */
    public void setEnableColumnHide(String value) {
        setAttribute("enableColumnHide", value, true);
    }

    /**
     * False to disable column dragging within this grid.
     * <p>
     * Defaults to: true
     */
    public void setEnableColumnMove(String value) {
        setAttribute("enableColumnMove", value, true);
    }

    /**
     * False to disable column resizing within this grid.
     * <p>
     * Defaults to: true
     */
    public void setEnableColumnResize(String value) {
        setAttribute("enableColumnResize", value, true);
    }

    /**
     * An array of grid Features to be added to this grid.
     */
    public void setFeatures(List<Feature> values) {
        JsArray<JavaScriptObject> jsos = JsArray.createArray().cast();
        for (Feature f : values) {
            jsos.push(f.getJsObj());
        }
        setAttribute("features", jsos, true);
    }

    /**
     * An array of grid Features to be added to this grid.
     */
    public void setFeatures(Feature... values) {
        setFeatures(Arrays.asList(values));
    }

    /**
     * True to force the columns to fit into the available width. Headers are
     * first sized according to configuration, whether that be a specific width,
     * or flex. Then they are all proportionally changed in width so that the
     * entire content width is used. For more accurate control, it is more
     * optimal to specify a flex setting on the columns that are to be stretched
     * & explicit widths on columns that are not.
     */
    public void setForceFit(boolean value) {
        setAttribute("forceFit", value, true);
    }

    /**
     * True to hide column headers.
     * 
     * Defaults to: false
     */
    public void setHideHeaders(boolean value) {
        setAttribute("hideHeaders", value, true);
    }

    /**
     * True to enable locking support for this grid. Alternatively, locking will
     * also be automatically enabled if any of the columns in the column
     * configuration contain the locked config option.
     * <p>
     * Defaults to: true
     */
    public void setEnableLocking(boolean value) {
        setAttribute("enableLocking", value, true);
    }

    /**
     * Adds row line styling
     * 
     * Defaults to: true
     */
    public void setRowLines(String value) {
        setAttribute("rowLines", value, true);
    }

    /**
     * Scrollers configuration.
     * 
     * Defaults to: true
     */
    public void setScroll(boolean value) {
        setAttribute("scroll", value, true);
    }

    /**
     * Scrollers configuration.
     */
    public void setScroll(Scroll scroll) {
        setScroll(scroll.getValue());
    }

    /**
     * Scrollers configuration.
     */
    public void setScroll(String value) {
        setAttribute("scroll", value, true);
    }

    /**
     * True to constrain column dragging so that a column cannot be dragged in
     * or out of it's current group. Only relevant while enableColumnMove is
     * enabled.
     * 
     * Defaults to: false
     */
    public void setSealeadColumns(boolean value) {
        setAttribute("sealedColumns", value, true);
    }

    /**
     * A selection model instance or config object. In latter case the selType
     * config option determines to which type of selection model this config is
     * applied.
     */
    public void setSelectionModel(SelectionModel value) {
        setAttribute("sealedColumns", value.getJsObj(), true);
    }

    /**
     * An xtype of selection model to use. Defaults to 'rowmodel'. This is used
     * to create selection model if just a config object or nothing at all given
     * in selModel config.
     * 
     * Defaults to: "rowmodel"
     */
    public void setSelectionType(String value) {
        setAttribute("selType", value, true);
    }

    /**
     * False to disable column sorting via clicking the header and via the
     * Sorting menu items.
     * 
     * Defaults to: true
     */
    public void setSortableColumns(boolean value) {
        setAttribute("sortableColumns", value, true);
    }

    /**
     * A config object to be used when configuring the scroll monitor to control
     * refreshing of data in an "infinite grid".
     * <p>
     * Configurations of this object allow fine tuning of data caching which can
     * improve performance and usability of the infinite grid.
     */
    public void setVerticalScroller(VerticalScroller scroller) {
        setAttribute("verticalScroller", scroller.getJsObj(), true);
    }

    /**
     * The {@link TableView} used by the grid. Use viewConfig to just supply
     * some config options to view (instead of creating an entire View
     * instance).
     */
    public void setView(DataView value) {
        setAttribute("verticalScroller", value.getOrCreateJsObj(), true);
    }

    /**
     * A config object that will be applied to the grid's UI view. Any of the
     * config options available for {@link TablePanel} can be specified here.
     * This option is ignored if view is specified.
     */
    public void setViewConfig(ViewConfig value) {
        setAttribute("viewConfig", value.getJsObj(), true, true);
    }

    /**
     * Returns the store associated with this NotificationContainer.
     * 
     * @return
     */
    public Store getStore() {
        return this.store;
    }

    private native Store _getStore()/*-{
		var grid = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var obj = grid.getStore();
		var store = @com.eemi.ext4j.client.data.Store::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
		return store;
    }-*/;

    /**
     * Returns the selection model being used and creates it via the
     * configuration if it has not been created already.
     * 
     * @return
     */
    public native SelectionModel getSelectionModel()/*-{
		var grid = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var obj = grid.getSelectionModel();
		if (!obj) {
			return null;
		}
		return @com.eemi.ext4j.client.selection.SelectionModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
    }-*/;

    public native HeaderContainer getHeaderContainer()/*-{
		var grid = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var obj = grid.headerCt;
		return @com.eemi.ext4j.client.grid.HeaderContainer::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
    }-*/;

    /**
     * Gets the view for this panel.
     * 
     * @return
     */
    public native TableView getView()/*-{
		var grid = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var obj = grid.getView();
		return @com.eemi.ext4j.client.ui.TableView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
    }-*/;

    public static TablePanel cast(Component component) {
        return new TablePanel(component.getOrCreateJsObj());
    }

    // Events

    /**
     * 
     Fired before the cell click is processed.
     */

    public native HandlerRegistration addBeforeCellClickHandler(BeforeCellClickHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(t, td, cellIndex, rec, tr, rowIndex, e) {
			var cmp = @com.eemi.ext4j.client.ui.TableView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(t);
			var record = @com.eemi.ext4j.client.data.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rec);
			var event = @com.eemi.ext4j.client.events.grid.BeforeCellClickEvent::new(Lcom/eemi/ext4j/client/ui/TableView;Lcom/google/gwt/dom/client/Element;ILcom/eemi/ext4j/client/data/BaseModel;Lcom/google/gwt/dom/client/Element;ILcom/google/gwt/core/client/JavaScriptObject;)(cpm,tr, cellIndex, record, tr, rowIndex,e);
			handler.@com.eemi.ext4j.client.events.grid.BeforeCellClickHandler::onBeforeCellClick(Lcom/eemi/ext4j/client/events/grid/BeforeCellClickEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.grid.BeforeCellClickEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * Fired before the cell click is processed. Return false to cancel the
     * default action.
     */
    public void addBeforeCellClickHandler(BeforeActionHandler handler) {
        _addBeforeActionHandlerHandler(BeforeCellClickEvent.EVENT_NAME, handler);
    }

    /**
     * 
     * Fired before the cell right click is processed.
     */

    public native HandlerRegistration addBeforeCellContextMenuHandler(BeforeCellContextMenuHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(t, td, cellIndex, rec, tr, rowIndex, e) {
			var cmp = @com.eemi.ext4j.client.ui.TableView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(t);
			var record = @com.eemi.ext4j.client.data.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rec);
			var event = @com.eemi.ext4j.client.events.grid.BeforeCellContextMenuEvent::new(Lcom/eemi/ext4j/client/ui/TableView;Lcom/google/gwt/dom/client/Element;ILcom/eemi/ext4j/client/data/BaseModel;Lcom/google/gwt/dom/client/Element;ILcom/google/gwt/core/client/JavaScriptObject;)(cpm,tr, cellIndex, record, tr, rowIndex,e);
			handler.@com.eemi.ext4j.client.events.grid.BeforeCellContextMenuHandler::onBeforeCellContextMenu(Lcom/eemi/ext4j/client/events/grid/BeforeCellContextMenuEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.grid.BeforeCellContextMenuEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * Fired before the cell right click is processed. Return false to cancel
     * the default action.
     */
    public void addBeforeCellContextMenuHandler(BeforeActionHandler handler) {
        _addBeforeActionHandlerHandler(BeforeCellContextMenuEvent.EVENT_NAME, handler);
    }

    /**
     * 
     * Fired before the cell double click is processed.
     */

    public native HandlerRegistration addBeforeCellDoubleClickHandler(BeforeCellDoubleClickHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(t, td, cellIndex, rec, tr, rowIndex, e) {
			var cmp = @com.eemi.ext4j.client.ui.TableView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(t);
			var record = @com.eemi.ext4j.client.data.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rec);
			var event = @com.eemi.ext4j.client.events.grid.BeforeCellDoubleClickEvent::new(Lcom/eemi/ext4j/client/ui/TableView;Lcom/google/gwt/dom/client/Element;ILcom/eemi/ext4j/client/data/BaseModel;Lcom/google/gwt/dom/client/Element;ILcom/google/gwt/core/client/JavaScriptObject;)(cpm,tr, cellIndex, record, tr, rowIndex,e);
			handler.@com.eemi.ext4j.client.events.grid.BeforeCellDoubleClickHandler::onBeforeCellDoubleClick(Lcom/eemi/ext4j/client/events/grid/BeforeCellDoubleClickEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.grid.BeforeCellDoubleClickEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * Fired before the cell double click is processed. Return false to cancel
     * the default action. right click is processed. Return false to cancel the
     * default action.
     */
    public void addBeforeCellDoubleClickHandler(BeforeActionHandler handler) {
        _addBeforeActionHandlerHandler(BeforeCellDoubleClickEvent.EVENT_NAME, handler);
    }

    /**
     * Fired before the cell key down is processed.
     */

    public native HandlerRegistration addBeforeCellKeyDownHandler(BeforeCellKeyDownHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(t, td, cellIndex, rec, tr, rowIndex, e) {
			var cmp = @com.eemi.ext4j.client.ui.TableView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(t);
			var record = @com.eemi.ext4j.client.data.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rec);
			var event = @com.eemi.ext4j.client.events.grid.BeforeCellKeyDownEvent::new(Lcom/eemi/ext4j/client/ui/TableView;Lcom/google/gwt/dom/client/Element;ILcom/eemi/ext4j/client/data/BaseModel;Lcom/google/gwt/dom/client/Element;ILcom/google/gwt/core/client/JavaScriptObject;)(cpm,tr, cellIndex, record, tr, rowIndex,e);
			handler.@com.eemi.ext4j.client.events.grid.BeforeCellKeyDownHandler::onBeforeCellKeyDown(Lcom/eemi/ext4j/client/events/grid/BeforeCellKeyDownEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.grid.BeforeCellKeyDownEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * Fired before the cell key down is processed. Return false to cancel the
     * default action. right click is processed. Return false to cancel the
     * default action.
     */
    public void addBeforeCellKeyDownHandler(BeforeActionHandler handler) {
        _addBeforeActionHandlerHandler(BeforeCellKeyDownEvent.EVENT_NAME, handler);
    }

    /**
     * Fired before the cell mouse down is processed.
     */

    public native HandlerRegistration addBeforeCellMouseDownHandler(BeforeCellMouseDownHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(t, td, cellIndex, rec, tr, rowIndex, e) {
			var cmp = @com.eemi.ext4j.client.ui.TableView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(t);
			var record = @com.eemi.ext4j.client.data.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rec);
			var event = @com.eemi.ext4j.client.events.grid.BeforeCellMouseDownEvent::new(Lcom/eemi/ext4j/client/ui/TableView;Lcom/google/gwt/dom/client/Element;ILcom/eemi/ext4j/client/data/BaseModel;Lcom/google/gwt/dom/client/Element;ILcom/google/gwt/core/client/JavaScriptObject;)(cpm,tr, cellIndex, record, tr, rowIndex,e);
			handler.@com.eemi.ext4j.client.events.grid.BeforeCellMouseDownHandler::onBeforeCellMouseDown(Lcom/eemi/ext4j/client/events/grid/BeforeCellMouseDownEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.grid.BeforeCellMouseDownEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * Fired before the cell mouse down is processed. Return false to cancel the
     * default action. right click is processed. Return false to cancel the
     * default action.
     */
    public void addBeforeCellMouseDownHandler(BeforeActionHandler handler) {
        _addBeforeActionHandlerHandler(BeforeCellMouseDownEvent.EVENT_NAME, handler);
    }

    /**
     * Fired before the cell mouse up is processed.
     */

    public native HandlerRegistration addBeforeCellMouseUpHandler(BeforeCellMouseUpHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(t, td, cellIndex, rec, tr, rowIndex, e) {
			var cmp = @com.eemi.ext4j.client.ui.TableView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(t);
			var record = @com.eemi.ext4j.client.data.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rec);
			var event = @com.eemi.ext4j.client.events.grid.BeforeCellMouseUpEvent::new(Lcom/eemi/ext4j/client/ui/TableView;Lcom/google/gwt/dom/client/Element;ILcom/eemi/ext4j/client/data/BaseModel;Lcom/google/gwt/dom/client/Element;ILcom/google/gwt/core/client/JavaScriptObject;)(cpm,tr, cellIndex, record, tr, rowIndex,e);
			handler.@com.eemi.ext4j.client.events.grid.BeforeCellMouseUpHandler::onBeforeCellMouseUp(Lcom/eemi/ext4j/client/events/grid/BeforeCellMouseUpEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.grid.BeforeCellMouseUpEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * Fired before the cell mouse up is processed. Return false to cancel the
     * default action. right click is processed. Return false to cancel the
     * default action.
     */
    public void addBeforeCellMouseUpHandler(BeforeActionHandler handler) {
        _addBeforeActionHandlerHandler(BeforeCellMouseUpEvent.EVENT_NAME, handler);
    }

    /**
     * Fires before the click event on the container is processed.
     */
    public native HandlerRegistration addBeforeContainerClickHandler(BeforeContainerClickHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(v, e) {
			var view = @com.eemi.ext4j.client.ui.DataView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(v);
			var event = @com.eemi.ext4j.client.events.grid.BeforeContainerClickEvent::new(Lcom/eemi/ext4j/client/ui/DataView;Lcom/google/gwt/core/client/JavaScriptObject;)(view,e)
			handler.@com.eemi.ext4j.client.events.grid.BeforeContainerClickHandler::onBeforeContainerClick(Lcom/eemi/ext4j/client/events/grid/BeforeContainerClickEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.grid.BeforeContainerClickEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
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
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(v, e) {
			var view = @com.eemi.ext4j.client.ui.DataView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(v);
			var event = @com.eemi.ext4j.client.events.grid.BeforeContainerContextMenuEvent::new(Lcom/eemi/ext4j/client/ui/DataView;Lcom/google/gwt/core/client/JavaScriptObject;)(view,e)
			handler.@com.eemi.ext4j.client.events.grid.BeforeContainerContextMenuHandler::onBeforeContainerContextMenu(Lcom/eemi/ext4j/client/events/grid/BeforeContainerContextMenuEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.grid.BeforeContainerContextMenuEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
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
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(v, e) {
			var view = @com.eemi.ext4j.client.ui.DataView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(v);
			var event = @com.eemi.ext4j.client.events.grid.BeforeContainerDoubleClickEvent::new(Lcom/eemi/ext4j/client/ui/DataView;Lcom/google/gwt/core/client/JavaScriptObject;)(view,e)
			handler.@com.eemi.ext4j.client.events.grid.BeforeContainerDoubleClickHandler::onBeforeContainerDoubleClick(Lcom/eemi/ext4j/client/events/grid/BeforeContainerDoubleClickEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.grid.BeforeContainerDoubleClickEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
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
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(v, e) {
			var view = @com.eemi.ext4j.client.ui.DataView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(v);
			var event = @com.eemi.ext4j.client.events.grid.BeforeContainerKeyDownEvent::new(Lcom/eemi/ext4j/client/ui/DataView;Lcom/google/gwt/core/client/JavaScriptObject;)(view,e)
			handler.@com.eemi.ext4j.client.events.grid.BeforeContainerKeyDownHandler::onBeforeContainerKeyDown(Lcom/eemi/ext4j/client/events/grid/BeforeContainerKeyDownEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.grid.BeforeContainerKeyDownEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
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
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(v, e) {
			var view = @com.eemi.ext4j.client.ui.DataView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(v);
			var event = @com.eemi.ext4j.client.events.grid.BeforeContainerMouseDownEvent::new(Lcom/eemi/ext4j/client/ui/DataView;Lcom/google/gwt/core/client/JavaScriptObject;)(view,e)
			handler.@com.eemi.ext4j.client.events.grid.BeforeContainerMouseDownHandler::onBeforeContainerMouseDown(Lcom/eemi/ext4j/client/events/grid/BeforeContainerMouseDownEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.grid.BeforeContainerMouseDownEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
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
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(v, e) {
			var view = @com.eemi.ext4j.client.ui.DataView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(v);
			var event = @com.eemi.ext4j.client.events.grid.BeforeContainerMouseOutEvent::new(Lcom/eemi/ext4j/client/ui/DataView;Lcom/google/gwt/core/client/JavaScriptObject;)(view,e)
			handler.@com.eemi.ext4j.client.events.grid.BeforeContainerMouseOutHandler::onBeforeContainerMouseOut(Lcom/eemi/ext4j/client/events/grid/BeforeContainerMouseOutEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.grid.BeforeContainerMouseOutEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
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
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(v, e) {
			var view = @com.eemi.ext4j.client.ui.DataView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(v);
			var event = @com.eemi.ext4j.client.events.grid.BeforeContainerMouseOverEvent::new(Lcom/eemi/ext4j/client/ui/DataView;Lcom/google/gwt/core/client/JavaScriptObject;)(view,e)
			handler.@com.eemi.ext4j.client.events.grid.BeforeContainerMouseOverHandler::onBeforeContainerMouseOver(Lcom/eemi/ext4j/client/events/grid/BeforeContainerMouseOverEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.grid.BeforeContainerMouseOverEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
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
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(v, e) {
			var view = @com.eemi.ext4j.client.ui.DataView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(v);
			var event = @com.eemi.ext4j.client.events.grid.BeforeContainerMouseUpEvent::new(Lcom/eemi/ext4j/client/ui/DataView;Lcom/google/gwt/core/client/JavaScriptObject;)(view,e)
			handler.@com.eemi.ext4j.client.events.grid.BeforeContainerMouseUpHandler::onBeforeContainerMouseUp(Lcom/eemi/ext4j/client/events/grid/BeforeContainerMouseUpEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.grid.BeforeContainerMouseUpEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
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
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(sm, rec, index, e) {
			var rowModel = @com.eemi.ext4j.client.selection.RowSelectionModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(sm);
			var model = @com.eemi.ext4j.client.data.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rec);
			var event = @com.eemi.ext4j.client.events.grid.BeforeDeselectEvent::new(Lcom/eemi/ext4j/client/selection/RowSelectionModel;Lcom/eemi/ext4j/client/data/BaseModel;ILcom/google/gwt/core/client/JavaScriptObject;)(rowModel, model, index, e);
			handler.@com.eemi.ext4j.client.events.grid.BeforeDeselectHandler::onBeforeDeselect(Lcom/eemi/ext4j/client/events/grid/BeforeDeselectEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.grid.BeforeDeselectEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
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
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(v, rec, item, index, e) {
			var view = @com.eemi.ext4j.client.ui.DataView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(v);
			var model = @com.eemi.ext4j.client.data.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rec);
			var event = @com.eemi.ext4j.client.events.grid.BeforeItemClickEvent::new(Lcom/eemi/ext4j/client/ui/DataView;Lcom/eemi/ext4j/client/data/BaseModel;Lcom/google/gwt/dom/client/Element;ILcom/google/gwt/core/client/JavaScriptObject;)(view,model,item,index,e);
			handler.@com.eemi.ext4j.client.events.grid.BeforeItemClickHandler::onBeforeItemClick(Lcom/eemi/ext4j/client/events/grid/BeforeItemClickEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.grid.BeforeItemClickEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
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
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(v, rec, item, index, e) {
			var view = @com.eemi.ext4j.client.ui.DataView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(v);
			var model = @com.eemi.ext4j.client.data.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rec);
			var event = @com.eemi.ext4j.client.events.grid.BeforeItemContextMenuEvent::new(Lcom/eemi/ext4j/client/ui/DataView;Lcom/eemi/ext4j/client/data/BaseModel;Lcom/google/gwt/dom/client/Element;ILcom/google/gwt/core/client/JavaScriptObject;)(view,model,item,index,e);
			handler.@com.eemi.ext4j.client.events.grid.BeforeItemContextMenuHandler::onBeforeItemContextMenu(Lcom/eemi/ext4j/client/events/grid/BeforeItemContextMenuEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.grid.BeforeItemContextMenuEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
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
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(v, rec, item, index, e) {
			var view = @com.eemi.ext4j.client.ui.DataView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(v);
			var model = @com.eemi.ext4j.client.data.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rec);
			var event = @com.eemi.ext4j.client.events.grid.BeforeItemDoubleClickEvent::new(Lcom/eemi/ext4j/client/ui/DataView;Lcom/eemi/ext4j/client/data/BaseModel;Lcom/google/gwt/dom/client/Element;ILcom/google/gwt/core/client/JavaScriptObject;)(view,model,item,index,e);
			handler.@com.eemi.ext4j.client.events.grid.BeforeItemDoubleClickHandler::onBeforeItemDoubleClick(Lcom/eemi/ext4j/client/events/grid/BeforeItemDoubleClickEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.grid.BeforeItemDoubleClickEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
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
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(v, rec, item, index, e) {
			var view = @com.eemi.ext4j.client.ui.DataView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(v);
			var model = @com.eemi.ext4j.client.data.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rec);
			var event = @com.eemi.ext4j.client.events.grid.BeforeItemKeyDownEvent::new(Lcom/eemi/ext4j/client/ui/DataView;Lcom/eemi/ext4j/client/data/BaseModel;Lcom/google/gwt/dom/client/Element;ILcom/google/gwt/core/client/JavaScriptObject;)(view,model,item,index,e);
			handler.@com.eemi.ext4j.client.events.grid.BeforeItemKeyDownHandler::onBeforeItemKeyDown(Lcom/eemi/ext4j/client/events/grid/BeforeItemKeyDownEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.grid.BeforeItemKeyDownEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
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
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(v, rec, item, index, e) {
			var view = @com.eemi.ext4j.client.ui.DataView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(v);
			var model = @com.eemi.ext4j.client.data.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rec);
			var event = @com.eemi.ext4j.client.events.grid.BeforeItemMouseDownEvent::new(Lcom/eemi/ext4j/client/ui/DataView;Lcom/eemi/ext4j/client/data/BaseModel;Lcom/google/gwt/dom/client/Element;ILcom/google/gwt/core/client/JavaScriptObject;)(view,model,item,index,e);
			handler.@com.eemi.ext4j.client.events.grid.BeforeItemMouseDownHandler::onBeforeItemMouseDown(Lcom/eemi/ext4j/client/events/grid/BeforeItemMouseDownEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.grid.BeforeItemMouseDownEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
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
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(v, rec, item, index, e) {
			var view = @com.eemi.ext4j.client.ui.DataView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(v);
			var model = @com.eemi.ext4j.client.data.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rec);
			var event = @com.eemi.ext4j.client.events.grid.BeforeItemMouseEnterEvent::new(Lcom/eemi/ext4j/client/ui/DataView;Lcom/eemi/ext4j/client/data/BaseModel;Lcom/google/gwt/dom/client/Element;ILcom/google/gwt/core/client/JavaScriptObject;)(view,model,item,index,e);
			handler.@com.eemi.ext4j.client.events.grid.BeforeItemMouseEnterHandler::onBeforeItemMouseEnter(Lcom/eemi/ext4j/client/events/grid/BeforeItemMouseEnterEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.grid.BeforeItemMouseEnterEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
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
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(v, rec, item, index, e) {
			var view = @com.eemi.ext4j.client.ui.DataView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(v);
			var model = @com.eemi.ext4j.client.data.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rec);
			var event = @com.eemi.ext4j.client.events.grid.BeforeItemMouseLeaveEvent::new(Lcom/eemi/ext4j/client/ui/DataView;Lcom/eemi/ext4j/client/data/BaseModel;Lcom/google/gwt/dom/client/Element;ILcom/google/gwt/core/client/JavaScriptObject;)(view,model,item,index,e);
			handler.@com.eemi.ext4j.client.events.grid.BeforeItemMouseLeaveHandler::onBeforeItemMouseLeave(Lcom/eemi/ext4j/client/events/grid/BeforeItemMouseLeaveEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.grid.BeforeItemMouseLeaveEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
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
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(v, rec, item, index, e) {
			var view = @com.eemi.ext4j.client.ui.DataView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(v);
			var model = @com.eemi.ext4j.client.data.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rec);
			var event = @com.eemi.ext4j.client.events.grid.BeforeItemMouseUpEvent::new(Lcom/eemi/ext4j/client/ui/DataView;Lcom/eemi/ext4j/client/data/BaseModel;Lcom/google/gwt/dom/client/Element;ILcom/google/gwt/core/client/JavaScriptObject;)(view,model,item,index,e);
			handler.@com.eemi.ext4j.client.events.grid.BeforeItemMouseUpHandler::onBeforeItemMouseUp(Lcom/eemi/ext4j/client/events/grid/BeforeItemMouseUpEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.grid.BeforeItemMouseUpEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
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
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(sm, rec, index, e) {
			var rowModel = @com.eemi.ext4j.client.selection.RowSelectionModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(sm);
			var model = @com.eemi.ext4j.client.data.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rec);
			var event = @com.eemi.ext4j.client.events.grid.BeforeSelectEvent::new(Lcom/eemi/ext4j/client/selection/RowSelectionModel;Lcom/eemi/ext4j/client/data/BaseModel;ILcom/google/gwt/core/client/JavaScriptObject;)(rowModel, model, index, e);
			handler.@com.eemi.ext4j.client.events.grid.BeforeSelectHandler::onBeforeSelect(Lcom/eemi/ext4j/client/events/grid/BeforeSelectEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.grid.BeforeSelectEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * Fired before a record is selected. If any listener returns false, the
     * selection is cancelled.
     */
    public void addBeforeSelectHandler(BeforeSelectionHandler handler) {
        _addBeforeSelectionHandler(Event.BEFORE_SELECT, handler);
    }

    public native HandlerRegistration addCellClickHandler(CellClickHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(t, td, cellIndex, rec, tr, rowIndex, e) {
			var cmp = @com.eemi.ext4j.client.ui.TableView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(t);
			var record = @com.eemi.ext4j.client.data.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rec);
			var event = @com.eemi.ext4j.client.events.grid.CellClickEvent::new(Lcom/eemi/ext4j/client/ui/TableView;Lcom/google/gwt/dom/client/Element;ILcom/eemi/ext4j/client/data/BaseModel;Lcom/google/gwt/dom/client/Element;ILcom/google/gwt/core/client/JavaScriptObject;)(cpm,tr, cellIndex, record, tr, rowIndex,e);
			handler.@com.eemi.ext4j.client.events.grid.CellClickHandler::onCellClick(Lcom/eemi/ext4j/client/events/grid/CellClickEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.grid.CellClickEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    public native HandlerRegistration addCellContextMenuHandler(CellContextMenuHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(t, td, cellIndex, rec, tr, rowIndex, e) {
			var cmp = @com.eemi.ext4j.client.ui.TableView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(t);
			var record = @com.eemi.ext4j.client.data.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rec);
			var event = @com.eemi.ext4j.client.events.grid.CellContextMenuEvent::new(Lcom/eemi/ext4j/client/ui/TableView;Lcom/google/gwt/dom/client/Element;ILcom/eemi/ext4j/client/data/BaseModel;Lcom/google/gwt/dom/client/Element;ILcom/google/gwt/core/client/JavaScriptObject;)(cpm,tr, cellIndex, record, tr, rowIndex,e);
			handler.@com.eemi.ext4j.client.events.grid.CellContextMenuHandler::onCellContextMenu(Lcom/eemi/ext4j/client/events/grid/CellContextMenuEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.grid.CellContextMenuEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    public native HandlerRegistration addCellDoubleClickHandler(CellDoubleClickHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(t, td, cellIndex, rec, tr, rowIndex, e) {
			var cmp = @com.eemi.ext4j.client.ui.TableView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(t);
			var record = @com.eemi.ext4j.client.data.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rec);
			var event = @com.eemi.ext4j.client.events.grid.CellDoubleClickEvent::new(Lcom/eemi/ext4j/client/ui/TableView;Lcom/google/gwt/dom/client/Element;ILcom/eemi/ext4j/client/data/BaseModel;Lcom/google/gwt/dom/client/Element;ILcom/google/gwt/core/client/JavaScriptObject;)(cpm,tr, cellIndex, record, tr, rowIndex,e);
			handler.@com.eemi.ext4j.client.events.grid.CellDoubleClickHandler::onCellDoubleClick(Lcom/eemi/ext4j/client/events/grid/CellDoubleClickEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.grid.CellDoubleClickEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    public native HandlerRegistration addCellKeyDownHandler(CellKeyDownHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(t, td, cellIndex, rec, tr, rowIndex, e) {
			var cmp = @com.eemi.ext4j.client.ui.TableView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(t);
			var record = @com.eemi.ext4j.client.data.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rec);
			var event = @com.eemi.ext4j.client.events.grid.CellKeyDownEvent::new(Lcom/eemi/ext4j/client/ui/TableView;Lcom/google/gwt/dom/client/Element;ILcom/eemi/ext4j/client/data/BaseModel;Lcom/google/gwt/dom/client/Element;ILcom/google/gwt/core/client/JavaScriptObject;)(cpm,tr, cellIndex, record, tr, rowIndex,e);
			handler.@com.eemi.ext4j.client.events.grid.CellKeyDownHandler::onCellKeyDown(Lcom/eemi/ext4j/client/events/grid/CellKeyDownEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.grid.CellKeyDownEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    public native HandlerRegistration addCellMouseUpHandler(CellMouseUpHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(t, td, cellIndex, rec, tr, rowIndex, e) {
			var cmp = @com.eemi.ext4j.client.ui.TableView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(t);
			var record = @com.eemi.ext4j.client.data.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rec);
			var event = @com.eemi.ext4j.client.events.grid.CellMouseUpEvent::new(Lcom/eemi/ext4j/client/ui/TableView;Lcom/google/gwt/dom/client/Element;ILcom/eemi/ext4j/client/data/BaseModel;Lcom/google/gwt/dom/client/Element;ILcom/google/gwt/core/client/JavaScriptObject;)(cpm,tr, cellIndex, record, tr, rowIndex,e);
			handler.@com.eemi.ext4j.client.events.grid.CellMouseUpHandler::onCellMouseUp(Lcom/eemi/ext4j/client/events/grid/CellMouseUpEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.grid.CellMouseUpEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    public native HandlerRegistration addCellMouseDownHandler(CellMouseDownHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(t, td, cellIndex, rec, tr, rowIndex, e) {
			var cmp = @com.eemi.ext4j.client.ui.TableView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(t);
			var record = @com.eemi.ext4j.client.data.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rec);
			var event = @com.eemi.ext4j.client.events.grid.CellMouseDownEvent::new(Lcom/eemi/ext4j/client/ui/TableView;Lcom/google/gwt/dom/client/Element;ILcom/eemi/ext4j/client/data/BaseModel;Lcom/google/gwt/dom/client/Element;ILcom/google/gwt/core/client/JavaScriptObject;)(cpm,tr, cellIndex, record, tr, rowIndex,e);
			handler.@com.eemi.ext4j.client.events.grid.CellMouseDownHandler::onCellMouseDown(Lcom/eemi/ext4j/client/events/grid/CellMouseDownEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.grid.CellMouseDownEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    public native HandlerRegistration addColumnHideHandler(ColumnHideHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(ct, c, e) {
			var headerCt = @com.eemi.ext4j.client.grid.HeaderContainer::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ct);
			var col = @com.eemi.ext4j.client.grid.column.GridColumn::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var event = @com.eemi.ext4j.client.events.grid.ColumnHideEvent::new(Lcom/eemi/ext4j/client/grid/HeaderContainer;Lcom/eemi/ext4j/client/grid/column/GridColumn;Lcom/google/gwt/core/client/JavaScriptObject;)(headerCt,col,e);
			handler.@com.eemi.ext4j.client.events.grid.ColumnHideHandler::onColumnHide(Lcom/eemi/ext4j/client/events/grid/ColumnHideEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.grid.ColumnHideEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    public native HandlerRegistration addColumnMoveHandler(ColumnMoveHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(ct, c, fromIndex, toIndex, e) {
			var headerCt = @com.eemi.ext4j.client.grid.HeaderContainer::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ct);
			var col = @com.eemi.ext4j.client.grid.column.GridColumn::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var event = @com.eemi.ext4j.client.events.grid.ColumnMoveEvent::new(Lcom/eemi/ext4j/client/grid/HeaderContainer;Lcom/eemi/ext4j/client/grid/column/GridColumn;IILcom/google/gwt/core/client/JavaScriptObject;)(headerCt,col,fromIndex, toIndex,e);
			handler.@com.eemi.ext4j.client.events.grid.ColumnMoveHandler::onColumnMove(Lcom/eemi/ext4j/client/events/grid/ColumnMoveEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.grid.ColumnMoveEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    public native HandlerRegistration addColumnResizeHandler(ColumnResizeHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(ct, c, width, e) {
			var headerCt = @com.eemi.ext4j.client.grid.HeaderContainer::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ct);
			var col = @com.eemi.ext4j.client.grid.column.GridColumn::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var event = @com.eemi.ext4j.client.events.grid.ColumnResizeEvent::new(Lcom/eemi/ext4j/client/grid/HeaderContainer;Lcom/eemi/ext4j/client/grid/column/GridColumn;DLcom/google/gwt/core/client/JavaScriptObject;)(headerCt,col,width,e);
			handler.@com.eemi.ext4j.client.events.grid.ColumnResizeHandler::onColumnResize(Lcom/eemi/ext4j/client/events/grid/ColumnResizeEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.grid.ColumnResizeEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    public native HandlerRegistration addColumnsChangedHandler(ColumnsChangedHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(ct, e) {
			var headerCt = @com.eemi.ext4j.client.grid.HeaderContainer::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ct);
			var event = @com.eemi.ext4j.client.events.grid.ColumnsChangedEvent::new(Lcom/eemi/ext4j/client/grid/HeaderContainer;Lcom/google/gwt/core/client/JavaScriptObject;)(headerCt,e);
			handler.@com.eemi.ext4j.client.events.grid.ColumnsChangedHandler::onColumnsChanged(Lcom/eemi/ext4j/client/events/grid/ColumnsChangedEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.grid.ColumnsChangedEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    public native HandlerRegistration addColumnShowHandler(ColumnShowHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(ct, c, e) {
			var headerCt = @com.eemi.ext4j.client.grid.HeaderContainer::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ct);
			var col = @com.eemi.ext4j.client.grid.column.GridColumn::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var event = @com.eemi.ext4j.client.events.grid.ColumnShowEvent::new(Lcom/eemi/ext4j/client/grid/HeaderContainer;Lcom/eemi/ext4j/client/grid/column/GridColumn;Lcom/google/gwt/core/client/JavaScriptObject;)(headerCt,col,e);
			handler.@com.eemi.ext4j.client.events.grid.ColumnShowHandler::onColumnShow(Lcom/eemi/ext4j/client/events/grid/ColumnShowEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.grid.ColumnShowEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * Fires when the container is clicked.
     */
    public native HandlerRegistration addContainerClickHandler(ContainerClickHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(v, e) {
			var view = @com.eemi.ext4j.client.ui.DataView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(v);
			var event = @com.eemi.ext4j.client.events.grid.ContainerClickEvent::new(Lcom/eemi/ext4j/client/ui/DataView;Lcom/google/gwt/core/client/JavaScriptObject;)(view,e)
			handler.@com.eemi.ext4j.client.events.grid.ContainerClickHandler::onContainerClick(Lcom/eemi/ext4j/client/events/grid/ContainerClickEvent;)(event);

		};
		var eventName = @com.eemi.ext4j.client.events.grid.ContainerClickEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * Fires when the container is right clicked.
     */
    public native HandlerRegistration addContainerContextMenuHandler(ContainerContextMenuHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(v, e) {
			var view = @com.eemi.ext4j.client.ui.DataView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(v);
			var event = @com.eemi.ext4j.client.events.grid.ContainerContextMenuEvent::new(Lcom/eemi/ext4j/client/ui/DataView;Lcom/google/gwt/core/client/JavaScriptObject;)(view,e)
			handler.@com.eemi.ext4j.client.events.grid.ContainerContextMenuHandler::onContainerContextMenu(Lcom/eemi/ext4j/client/events/grid/ContainerContextMenuEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.grid.ContainerContextMenuEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * Fires when the container is double clicked.
     */
    public native HandlerRegistration addContainerDoubleClickHandler(ContainerDoubleClickHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(v, e) {
			var view = @com.eemi.ext4j.client.ui.DataView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(v);
			var event = @com.eemi.ext4j.client.events.grid.ContainerDoubleClickEvent::new(Lcom/eemi/ext4j/client/ui/DataView;Lcom/google/gwt/core/client/JavaScriptObject;)(view,e)
			handler.@com.eemi.ext4j.client.events.grid.ContainerDoubleClickHandler::onContainerDoubleClick(Lcom/eemi/ext4j/client/events/grid/ContainerDoubleClickEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.grid.ContainerDoubleClickEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * Fires when a key is pressed while the container is focused, and no item
     * is currently selected.
     */
    public native HandlerRegistration addContainerKeyDownHandler(ContainerKeyDownHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(v, e) {
			var view = @com.eemi.ext4j.client.ui.DataView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(v);
			var event = @com.eemi.ext4j.client.events.grid.ContainerKeyDownEvent::new(Lcom/eemi/ext4j/client/ui/DataView;Lcom/google/gwt/core/client/JavaScriptObject;)(view,e)
			handler.@com.eemi.ext4j.client.events.grid.ContainerKeyDownHandler::onContainerKeyDown(Lcom/eemi/ext4j/client/events/grid/ContainerKeyDownEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.grid.ContainerKeyDownEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    public native HandlerRegistration addContainerMouseDownHandler(ContainerMouseDownHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(v, e) {
			var view = @com.eemi.ext4j.client.ui.DataView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(v);
			var event = @com.eemi.ext4j.client.events.grid.ContainerMouseDownEvent::new(Lcom/eemi/ext4j/client/ui/DataView;Lcom/google/gwt/core/client/JavaScriptObject;)(view,e)
			handler.@com.eemi.ext4j.client.events.grid.ContainerMouseDownHandler::onContainerMouseDown(Lcom/eemi/ext4j/client/events/grid/ContainerMouseDownEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.grid.ContainerMouseDownEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    public native HandlerRegistration addContainerMouseOutHandler(ContainerMouseOutHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(v, e) {
			var view = @com.eemi.ext4j.client.ui.DataView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(v);
			var event = @com.eemi.ext4j.client.events.grid.ContainerMouseOutEvent::new(Lcom/eemi/ext4j/client/ui/DataView;Lcom/google/gwt/core/client/JavaScriptObject;)(view,e)
			handler.@com.eemi.ext4j.client.events.grid.ContainerMouseOutHandler::onContainerMouseOut(Lcom/eemi/ext4j/client/events/grid/ContainerMouseOutEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.grid.ContainerMouseOutEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    public native HandlerRegistration addContainerMouseOverHandler(ContainerMouseOverHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(v, e) {
			var view = @com.eemi.ext4j.client.ui.DataView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(v);
			var event = @com.eemi.ext4j.client.events.grid.ContainerMouseOverEvent::new(Lcom/eemi/ext4j/client/ui/DataView;Lcom/google/gwt/core/client/JavaScriptObject;)(view,e)
			handler.@com.eemi.ext4j.client.events.grid.ContainerMouseOverHandler::onContainerMouseOver(Lcom/eemi/ext4j/client/events/grid/ContainerMouseOverEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.grid.ContainerMouseOverEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    public native HandlerRegistration addContainerMouseUpHandler(ContainerMouseUpHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(v, e) {
			var view = @com.eemi.ext4j.client.ui.DataView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(v);
			var event = @com.eemi.ext4j.client.events.grid.ContainerMouseUpEvent::new(Lcom/eemi/ext4j/client/ui/DataView;Lcom/google/gwt/core/client/JavaScriptObject;)(view,e)
			handler.@com.eemi.ext4j.client.events.grid.ContainerMouseUpHandler::onContainerMouseUp(Lcom/eemi/ext4j/client/events/grid/ContainerMouseUpEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.grid.ContainerMouseUpEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * Fired when a record is deselected.
     */
    public native HandlerRegistration addDeselectHandler(DeselectHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(sm, rec, index, e) {
			var rowModel = @com.eemi.ext4j.client.selection.RowSelectionModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(sm);
			var model = @com.eemi.ext4j.client.data.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rec);
			var event = @com.eemi.ext4j.client.events.grid.DeselectEvent::new(Lcom/eemi/ext4j/client/selection/RowSelectionModel;Lcom/eemi/ext4j/client/data/BaseModel;ILcom/google/gwt/core/client/JavaScriptObject;)(rowModel, model, index, e);
			handler.@com.eemi.ext4j.client.events.grid.DeselectHandler::onDeselect(Lcom/eemi/ext4j/client/events/grid/DeselectEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.grid.DeselectEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    public native HandlerRegistration addFilterChangeHandler(FilterChangeHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(st, f, e) {
			var store = @com.eemi.ext4j.client.data.Store::new(Lcom/google/gwt/core/client/JavaScriptObject;)(st);
			var filters = @com.eemi.ext4j.client.util.Filter::fromJsArray(Lcom/google/gwt/core/client/JavaScriptObject;)(f);
			var event = @com.eemi.ext4j.client.events.grid.FilterChangeEvent::new(Lcom/eemi/ext4j/client/data/Store;Ljava/util/List;Lcom/google/gwt/core/client/JavaScriptObject;)(store,filters,e);
			handler.@com.eemi.ext4j.client.events.grid.FilterChangeHandler::onFilterChange(Lcom/eemi/ext4j/client/events/grid/FilterChangeEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.grid.FilterChangeEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    public native HandlerRegistration addGroupChangeHandler(GroupChangeHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(st, f, e) {
			var store = @com.eemi.ext4j.client.data.Store::new(Lcom/google/gwt/core/client/JavaScriptObject;)(st);
			var groupers = @com.eemi.ext4j.client.util.Grouper::fromJsArray(Lcom/google/gwt/core/client/JavaScriptObject;)(f);
			var event = @com.eemi.ext4j.client.events.grid.GroupChangeEvent::new(Lcom/eemi/ext4j/client/data/Store;Ljava/util/List;Lcom/google/gwt/core/client/JavaScriptObject;)(store,filters,e);
			handler.@com.eemi.ext4j.client.events.grid.GroupChangeHandler::onGroupChange(Lcom/eemi/ext4j/client/events/grid/GroupChangeEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.grid.GroupChangeEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * Fired when a record is selected.
     */
    public native HandlerRegistration addSelectHandler(SelectHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(sm, rec, index, e) {
			var rowModel = @com.eemi.ext4j.client.selection.RowSelectionModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(sm);
			var model = @com.eemi.ext4j.client.data.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rec);
			var event = @com.eemi.ext4j.client.events.grid.SelectEvent::new(Lcom/eemi/ext4j/client/selection/RowSelectionModel;Lcom/eemi/ext4j/client/data/BaseModel;ILcom/google/gwt/core/client/JavaScriptObject;)(rowModel, model, index, e);
			handler.@com.eemi.ext4j.client.events.grid.SelectHandler::onSelect(Lcom/eemi/ext4j/client/events/grid/SelectEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.grid.SelectEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    public native HandlerRegistration addSelectionChangeHandler(SelectionChangeHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(sm, rec, e) {
			var rowModel = @com.eemi.ext4j.client.selection.RowSelectionModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(sm);
			var model = @com.eemi.ext4j.client.data.BaseModel::fromJsArray(Lcom/google/gwt/core/client/JavaScriptObject;)(rec);
			var event = @com.eemi.ext4j.client.events.grid.SelectionChangeEvent::new(Lcom/eemi/ext4j/client/selection/RowSelectionModel;Ljava/util/List;Lcom/google/gwt/core/client/JavaScriptObject;)(rowModel,model,e);
			handler.@com.eemi.ext4j.client.events.grid.SelectionChangeHandler::onSelectionChange(Lcom/eemi/ext4j/client/events/grid/SelectionChangeEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.grid.SelectionChangeEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    private native void _addBeforeActionHandlerHandler(String event, BeforeActionHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		component
				.addListener(
						event,
						$entry(function(t, td, cellIndex, rec, tr, rowIndex, e) {
							var cmp = @com.eemi.ext4j.client.ui.TableView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(t);
							var record = @com.eemi.ext4j.client.data.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rec);
							var event = @com.eemi.ext4j.client.core.EventObject::new(Lcom/google/gwt/core/client/JavaScriptObject;)(e);
							return handler.@com.eemi.ext4j.client.events.grid.BeforeActionHandler::onAction(Lcom/eemi/ext4j/client/ui/TableView;Lcom/google/gwt/dom/client/Element;ILcom/eemi/ext4j/client/data/BaseModel;Lcom/google/gwt/dom/client/Element;ILcom/eemi/ext4j/client/core/EventObject;)(cpm,tr, cellIndex, record, tr, rowIndex,event);
						}));
    }-*/;

    public native HandlerRegistration addHeaderClickHandler(HeaderClickHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(ct, col, e, t) {
			var headerCt = @com.eemi.ext4j.client.grid.HeaderContainer::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ct);
			var column = @com.eemi.ext4j.client.grid.column.GridColumn::new(Lcom/google/gwt/core/client/JavaScriptObject;)(col);
			var event = @com.eemi.ext4j.client.events.grid.HeaderClickEvent::new(Lcom/eemi/ext4j/client/grid/HeaderContainer;Lcom/eemi/ext4j/client/grid/column/GridColumn;Lcom/google/gwt/dom/client/Element;Lcom/google/gwt/core/client/JavaScriptObject;)(headerCt, column, t, e);
			handler.@com.eemi.ext4j.client.events.grid.HeaderClickHandler::onHeaderClick(Lcom/eemi/ext4j/client/events/grid/HeaderClickEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.grid.HeaderClickEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    public native HandlerRegistration addHeaderContextMenuHandler(HeaderContextMenuHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(ct, col, e, t) {
			var headerCt = @com.eemi.ext4j.client.grid.HeaderContainer::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ct);
			var column = @com.eemi.ext4j.client.grid.column.GridColumn::new(Lcom/google/gwt/core/client/JavaScriptObject;)(col);
			var event = @com.eemi.ext4j.client.events.grid.HeaderContextMenuEvent::new(Lcom/eemi/ext4j/client/grid/HeaderContainer;Lcom/eemi/ext4j/client/grid/column/GridColumn;Lcom/google/gwt/dom/client/Element;Lcom/google/gwt/core/client/JavaScriptObject;)(headerCt, column, t, e);
			handler.@com.eemi.ext4j.client.events.grid.HeaderContextMenuHandler::onHeaderContextMenu(Lcom/eemi/ext4j/client/events/grid/HeaderContextMenuEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.grid.HeaderContextMenuEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    public native HandlerRegistration addHeaderTriggerClickHandler(HeaderTriggerClickHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(ct, col, e, t) {
			var headerCt = @com.eemi.ext4j.client.grid.HeaderContainer::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ct);
			var column = @com.eemi.ext4j.client.grid.column.GridColumn::new(Lcom/google/gwt/core/client/JavaScriptObject;)(col);
			var event = @com.eemi.ext4j.client.events.grid.HeaderTriggerClickEvent::new(Lcom/eemi/ext4j/client/grid/HeaderContainer;Lcom/eemi/ext4j/client/grid/column/GridColumn;Lcom/google/gwt/dom/client/Element;Lcom/google/gwt/core/client/JavaScriptObject;)(headerCt, column, t, e);
			handler.@com.eemi.ext4j.client.events.grid.HeaderTriggerClickHandler::onHeaderTriggerClick(Lcom/eemi/ext4j/client/events/grid/HeaderTriggerClickEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.grid.HeaderTriggerClickEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    public native HandlerRegistration addItemClickHandler(ItemClickHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(v, rec, item, index, e) {
			var view = @com.eemi.ext4j.client.ui.TableView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(v);
			var model = @com.eemi.ext4j.client.data.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rec);
			var event = @com.eemi.ext4j.client.events.view.ItemClickEvent::new(Lcom/eemi/ext4j/client/ui/TableView;Lcom/eemi/ext4j/client/data/BaseModel;Lcom/google/gwt/dom/client/Element;ILcom/google/gwt/core/client/JavaScriptObject;)(view,model,item,index,e);
			handler.@com.eemi.ext4j.client.events.view.ItemClickHandler::onItemClick(Lcom/eemi/ext4j/client/events/view/ItemClickEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.view.ItemClickEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    public native HandlerRegistration addItemContextMenuHandler(ItemContextMenuHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(v, rec, item, index, e) {
			var view = @com.eemi.ext4j.client.ui.TableView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(v);
			var model = @com.eemi.ext4j.client.data.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rec);
			var event = @com.eemi.ext4j.client.events.view.ItemContextMenuEvent::new(Lcom/eemi/ext4j/client/ui/TableView;Lcom/eemi/ext4j/client/data/BaseModel;Lcom/google/gwt/dom/client/Element;ILcom/google/gwt/core/client/JavaScriptObject;)(view,model,item,index,e);
			handler.@com.eemi.ext4j.client.events.view.ItemContextMenuHandler::onItemContextMenu(Lcom/eemi/ext4j/client/events/view/ItemContextMenuEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.view.ItemContextMenuEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    public native HandlerRegistration addItemDoubleClickHandler(ItemDoubleClickHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(v, rec, item, index, e) {
			var view = @com.eemi.ext4j.client.ui.TableView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(v);
			var model = @com.eemi.ext4j.client.data.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rec);
			var event = @com.eemi.ext4j.client.events.view.ItemDoubleClickEvent::new(Lcom/eemi/ext4j/client/ui/TableView;Lcom/eemi/ext4j/client/data/BaseModel;Lcom/google/gwt/dom/client/Element;ILcom/google/gwt/core/client/JavaScriptObject;)(view,model,item,index,e);
			handler.@com.eemi.ext4j.client.events.view.ItemDoubleClickHandler::onItemDoubleClick(Lcom/eemi/ext4j/client/events/view/ItemDoubleClickEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.view.ItemDoubleClickEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    public native HandlerRegistration addItemKeyDownHandler(ItemKeyDownHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(v, rec, item, index, e) {
			var view = @com.eemi.ext4j.client.ui.TableView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(v);
			var model = @com.eemi.ext4j.client.data.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rec);
			var event = @com.eemi.ext4j.client.events.view.ItemKeyDownEvent::new(Lcom/eemi/ext4j/client/ui/TableView;Lcom/eemi/ext4j/client/data/BaseModel;Lcom/google/gwt/dom/client/Element;ILcom/google/gwt/core/client/JavaScriptObject;)(view,model,item,index,e);
			handler.@com.eemi.ext4j.client.events.view.ItemKeyDownHandler::onItemKeyDown(Lcom/eemi/ext4j/client/events/view/ItemKeyDownEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.view.ItemKeyDownEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    public native HandlerRegistration addItemMouseDownHandler(ItemMouseDownHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(v, rec, item, index, e) {
			var view = @com.eemi.ext4j.client.ui.TableView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(v);
			var model = @com.eemi.ext4j.client.data.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rec);
			var event = @com.eemi.ext4j.client.events.view.ItemMouseDownEvent::new(Lcom/eemi/ext4j/client/ui/TableView;Lcom/eemi/ext4j/client/data/BaseModel;Lcom/google/gwt/dom/client/Element;ILcom/google/gwt/core/client/JavaScriptObject;)(view,model,item,index,e);
			handler.@com.eemi.ext4j.client.events.view.ItemMouseDownHandler::onItemMouseDown(Lcom/eemi/ext4j/client/events/view/ItemMouseDownEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.view.ItemMouseDownEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    public native HandlerRegistration addItemMouseEnterHandler(ItemMouseEnterHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(v, rec, item, index, e) {
			var view = @com.eemi.ext4j.client.ui.TableView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(v);
			var model = @com.eemi.ext4j.client.data.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rec);
			var event = @com.eemi.ext4j.client.events.view.ItemMouseEnterEvent::new(Lcom/eemi/ext4j/client/ui/TableView;Lcom/eemi/ext4j/client/data/BaseModel;Lcom/google/gwt/dom/client/Element;ILcom/google/gwt/core/client/JavaScriptObject;)(view,model,item,index,e);
			handler.@com.eemi.ext4j.client.events.view.ItemMouseEnterHandler::onItemMouseEnter(Lcom/eemi/ext4j/client/events/view/ItemMouseEnterEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.view.ItemMouseEnterEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    public native HandlerRegistration addItemMouseLeaveHandler(ItemMouseLeaveHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(v, rec, item, index, e) {
			var view = @com.eemi.ext4j.client.ui.TableView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(v);
			var model = @com.eemi.ext4j.client.data.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rec);
			var event = @com.eemi.ext4j.client.events.view.ItemMouseLeaveEvent::new(Lcom/eemi/ext4j/client/ui/TableView;Lcom/eemi/ext4j/client/data/BaseModel;Lcom/google/gwt/dom/client/Element;ILcom/google/gwt/core/client/JavaScriptObject;)(view,model,item,index,e);
			handler.@com.eemi.ext4j.client.events.view.ItemMouseLeaveHandler::onItemMouseLeave(Lcom/eemi/ext4j/client/events/view/ItemMouseLeaveEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.view.ItemMouseLeaveEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    public native HandlerRegistration addItemMouseUpHandler(ItemMouseUpHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(v, rec, item, index, e) {
			var view = @com.eemi.ext4j.client.ui.TableView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(v);
			var model = @com.eemi.ext4j.client.data.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rec);
			var event = @com.eemi.ext4j.client.events.view.ItemMouseUpEvent::new(Lcom/eemi/ext4j/client/ui/TableView;Lcom/eemi/ext4j/client/data/BaseModel;Lcom/google/gwt/dom/client/Element;ILcom/google/gwt/core/client/JavaScriptObject;)(view,model,item,index,e);
			handler.@com.eemi.ext4j.client.events.view.ItemMouseUpHandler::onItemMouseUp(Lcom/eemi/ext4j/client/events/view/ItemMouseUpEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.view.ItemMouseUpEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    public native HandlerRegistration addSortChangeHandler(SortChangeHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(ct, c, direction, e) {
			var headerCt = @com.eemi.ext4j.client.grid.HeaderContainer::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ct);
			var col = @com.eemi.ext4j.client.grid.column.GridColumn::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var event = @com.eemi.ext4j.client.events.grid.SortChangeEvent::new(Lcom/eemi/ext4j/client/grid/HeaderContainer;Lcom/eemi/ext4j/client/grid/column/GridColumn;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(headerCt,col,direction,e);
			handler.@com.eemi.ext4j.client.events.grid.SortChangeHandler::onSortChange(Lcom/eemi/ext4j/client/events/grid/SortChangeEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.grid.SortChangeEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    public native HandlerRegistration addViewReadyHandler(ViewReadyHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(p, e) {
			var panel = @com.eemi.ext4j.client.ui.TablePanel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(p);
			var event = @com.eemi.ext4j.client.events.grid.ViewReadyEvent::new(Lcom/eemi/ext4j/client/ui/TablePanel;Lcom/google/gwt/core/client/JavaScriptObject;)(panel,e);
			handler.@com.eemi.ext4j.client.events.grid.ViewReadyHandler::onViewReady(Lcom/eemi/ext4j/client/events/grid/ViewReadyEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.grid.ViewReadyEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    private native void _addBeforeContainerActionHandlerHandler(String event, BeforeContainerActionHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		component
				.addListener(
						event,
						$entry(function(v, e) {
							var cmp = @com.eemi.ext4j.client.ui.DataView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(v);
							var event = @com.eemi.ext4j.client.core.EventObject::new(Lcom/google/gwt/core/client/JavaScriptObject;)(e);
							return handler.@com.eemi.ext4j.client.events.grid.BeforeContainerActionHandler::onAction(Lcom/eemi/ext4j/client/ui/DataView;Lcom/eemi/ext4j/client/core/EventObject;)(cmp,event);
						}));
    }-*/;

    private native void _addBeforeSelectionHandler(String event, BeforeSelectionHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		component
				.addListener(
						event,
						$entry(function(rm, rec, index) {
							var rowModel = @com.eemi.ext4j.client.selection.RowSelectionModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rm);
							var model = @com.eemi.ext4j.client.data.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rec);
							return handler.@com.eemi.ext4j.client.events.grid.BeforeSelectionHandler::onAction(Lcom/eemi/ext4j/client/selection/RowSelectionModel;Lcom/eemi/ext4j/client/data/BaseModel;I)(rowModel,record,index);
						}));
    }-*/;

    private native void _addBeforeItemActionHandler(String event, BeforeItemActionHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		component
				.addListener(
						event,
						$entry(function(v, rec, item, index, e) {
							var cmp = @com.eemi.ext4j.client.ui.DataView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(v);
							var model = @com.eemi.ext4j.client.data.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rec);
							var event = @com.eemi.ext4j.client.core.EventObject::new(Lcom/google/gwt/core/client/JavaScriptObject;)(e);
							return handler.@com.eemi.ext4j.client.events.grid.BeforeItemActionHandler::onAction(Lcom/eemi/ext4j/client/ui/DataView;Lcom/eemi/ext4j/client/data/BaseModel;Lcom/google/gwt/dom/client/Element;ILcom/eemi/ext4j/client/core/EventObject;)(cmp,model,item,index, event);
						}));
    }-*/;

}
