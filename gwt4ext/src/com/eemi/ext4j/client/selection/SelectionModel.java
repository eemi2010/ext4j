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
package com.eemi.ext4j.client.selection;

import java.util.List;

import com.eemi.ext4j.client.core.JsoHelper;
import com.eemi.ext4j.client.core.ObservableJso;
import com.eemi.ext4j.client.data.BaseModel;
import com.eemi.ext4j.client.data.NodeInterface;
import com.eemi.ext4j.client.data.Store;
import com.eemi.ext4j.client.events.CallbackRegistration;
import com.eemi.ext4j.client.events.selection.DeselectHandler;
import com.eemi.ext4j.client.events.selection.FocusChangeHandler;
import com.eemi.ext4j.client.events.selection.SelectHandler;
import com.eemi.ext4j.client.events.selection.SelectionChangeHandler;
import com.eemi.ext4j.client.util.MixedCollection;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * Tracks what records are currently selected in a databound component.
 */
public class SelectionModel extends ObservableJso {

    protected SelectionModel() {
        jsObj = JsoHelper.createObject();
    }

    protected SelectionModel(JavaScriptObject obj) {
        this.jsObj = obj;
    }

    /**
     * A {@link MixedCollection} that maintains all of the currently selected
     * records.
     * 
     * @return
     */
    public native MixedCollection getSelected()/*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::jsObj;
		var obj = jso.selected;
		return @com.eemi.ext4j.client.util.MixedCollection::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
    }-*/;

    /**
     * Gets the current position
     */
    public native CellPosition getCurrentPosition()/*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		if (!jso.getCurrentPosition) {
			return null;
		}
		var obj = jso.getCurrentPosition();
		return @com.eemi.ext4j.client.selection.CellPosition::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
    }-*/;

    /**
     * Binds a store to this instance.
     * 
     * @param store
     *            , The store to bind . When no store given (or when null or
     *            undefined passed), unbinds the existing store.
     */
    public native void bindStore(Store store)/*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::jsObj;
		jso.bindStore(store.@com.eemi.ext4j.client.core.JsObject::getJsObj()());
    }-*/;

    /**
     * Binds a store to this instance.
     * 
     * @param store
     *            , The store to bind . When no store given (or when null or
     *            undefined passed), unbinds the existing store.
     * @param initial
     *            , True to not remove listeners from existing store.(Default to
     *            false)
     */
    public native void bindStore(Store store, boolean initial)/*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::jsObj;
		jso.bindStore(store.@com.eemi.ext4j.client.core.JsObject::getJsObj()(),
				initial);
    }-*/;

    /**
     * Deselects all records in the view.
     */
    public native void deselectAll()/*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::jsObj;
		jso.deselectAll();
    }-*/;

    /**
     * Deselects all records in the view.
     */
    public native void deselectAll(boolean suppressEvent)/*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::jsObj;
		jso.deselectAll(suppressEvent);
    }-*/;

    /**
     * Deselects all records in the view.
     */
    public native void deselect(List<BaseModel> elements)/*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::jsObj;
		var peers = @com.eemi.ext4j.client.data.BaseModel::fromList(Ljava/util/List;)(elements);
		jso.deselect(peers);
    }-*/;

    /**
     * Deselects all records in the view.
     */
    public native void deselect(List<BaseModel> elements, boolean suppressEvent)/*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::jsObj;
		var peers = @com.eemi.ext4j.client.data.BaseModel::fromList(Ljava/util/List;)(elements);
		jso.deselect(peers, suppressEvent);
    }-*/;

    /**
     * Deselects all records in the view.
     */
    public native void deselect(int records)/*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::jsObj;
		jso.deselect(records);
    }-*/;

    /**
     * Deselects all records in the view.
     */
    public native void deselect(int records, boolean suppressEvent)/*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::jsObj;
		jso.deselect(records, suppressEvent);
    }-*/;

    /**
     * Returns the count of selected records.
     */
    public native int getCount()/*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::jsObj;
		return jso.getCount();
    }-*/;

    /**
     * Returns an array of the currently selected records.
     */
    public native List<BaseModel> getSelection()/*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::jsObj;
		var obj = jso.getSelection();
		return @com.eemi.ext4j.client.data.BaseModel::fromJsArray(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
    }-*/;

    /**
     * Returns the current selectionMode.
     * 
     * @return The selectionMode: 'SINGLE', 'MULTI' or 'SIMPLE'.
     */
    public native String getSelectionMode()/*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::jsObj;
		return jso.getSelectionMode();
    }-*/;

    /**
     * Gets the current store instance.
     */
    public native Store getStore()/*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::jsObj;
		var obj = jso.getStore();
		return @com.eemi.ext4j.client.data.Store::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
    }-*/;

    /**
     * Returns true if there are any a selected records.
     */
    public native boolean hasSelection()/*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::jsObj;
		return jso.hasSelection();
    }-*/;

    /**
     * Returns true if there are any a selected records.
     */
    public native boolean isFocused(BaseModel model)/*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::jsObj;
		return jso
				.isFocused(model.@com.eemi.ext4j.client.core.JsObject::getJsObj()());
    }-*/;

    /**
     * Returns true if the selections are locked.
     */
    public native boolean isLocked()/*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::jsObj;
		return jso.isLocked();
    }-*/;

    /**
     * Returns true if the specified row is selected.
     */
    public native boolean isSelected(BaseModel model)/*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::jsObj;
		return jso
				.isSelected(model.@com.eemi.ext4j.client.core.JsObject::getJsObj()());
    }-*/;

    /**
     * Returns true if the specified row is selected.
     */
    public native boolean isSelected(int row)/*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::jsObj;
		return jso.isSelected(row);
    }-*/;

    /**
     * Selects a record instance by record instance or index.
     * 
     * @param records
     */
    public void select(NodeInterface... records) {
        for (NodeInterface node : records) {
            _select(node);
        }
    }

    /**
     * Selects a record instance by record instance or index.
     * 
     * @param records
     */
    public void select(boolean keepExisting, NodeInterface... records) {
        for (NodeInterface node : records) {
            _select(node, keepExisting);
        }
    }

    /**
     * Selects a record instance by record instance or index.
     * 
     * @param records
     */
    public void select(boolean keepExisting, boolean suppressEvent, NodeInterface... records) {
        for (NodeInterface node : records) {
            _select(node, keepExisting, suppressEvent);
        }
    }

    /**
     * Selects a record instance by record instance or index.
     * 
     * @param records
     */
    public void select(List<NodeInterface> records) {
        for (NodeInterface node : records) {
            _select(node);
        }
    }

    /**
     * Selects a record instance by record instance or index.
     * 
     * @param records
     */
    public void select(List<NodeInterface> records, boolean keepExisiting) {
        for (NodeInterface node : records) {
            _select(node, keepExisiting);
        }
    }

    /**
     * Selects a record instance by record instance or index.
     * 
     * @param records
     */
    public void select(List<NodeInterface> records, boolean keepExisiting, boolean suppressEvent) {
        for (NodeInterface node : records) {
            _select(node, keepExisiting, suppressEvent);
        }
    }

    /**
     * Selects a record instance by record instance or index.
     * 
     * @param records
     */
    public native void select(int row)/*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::jsObj;
		if (jso) {
			jso.select(row);
		}
    }-*/;

    /**
     * Selects a record instance by record instance or index.
     * 
     * @param records
     */
    public native void select(int row, boolean keepExisting)/*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::jsObj;
		if (jso) {
			jso.select(row, keepExisting);
		}
    }-*/;

    /**
     * Selects a record instance by record instance or index.
     * 
     * @param records
     */
    public native void select(int row, boolean keepExisting, boolean suppressEvent)/*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::jsObj;
		if (jso) {
			jso.select(row, keepExisting, suppressEvent);
		}
    }-*/;

    /**
     * Selects all records in the view.
     */
    public native void selectAll()/*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::jsObj;
		if (jso) {
			jso.selectAll();
		}
    }-*/;

    /**
     * Selects all records in the view.
     */
    public native void selectAll(boolean suppressEvent)/*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::jsObj;
		if (jso) {
			jso.selectAll(suppressEvent);
		}
    }-*/;

    /**
     * Selects a range of rows if the selection model is not locked. All rows in
     * between startRow and endRow are also selected..
     */
    public native void selectRange(int startRow, int endRow)/*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::jsObj;
		if (jso) {
			jso.selectRange(startRow, endRow);
		}
    }-*/;

    /**
     * Selects a range of rows if the selection model is not locked. All rows in
     * between startRow and endRow are also selected..
     */
    public native void selectRange(int startRow, int endRow, boolean keepExisting)/*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::jsObj;
		if (jso) {
			jso.selectRange(startRow, endRow, keepExisting);
		}
    }-*/;

    /**
     * Sets a record as the last focused record. This does NOT mean that the
     * record has been selected.
     */
    public native void setLastFocused(BaseModel record)/*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::jsObj;
		if (jso) {
			jso
					.setLastFocused(record.@com.eemi.ext4j.client.core.JsObject::jsObj);
		}
    }-*/;

    /**
     * Locks the current selection and disables any changes from happening to
     * the selection.
     */
    public native void setLocked(boolean locked)/*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::jsObj;
		if (jso) {
			jso.setLocked(locked);
		}
    }-*/;

    /**
     * Fired when a row is focused
     */
    public native CallbackRegistration addFocusChangeHandler(FocusChangeHandler handler)/*-{
		var obj = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		var fn = function(model, os, ns, e) {
			var sm = @com.eemi.ext4j.client.selection.SelectionModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(model);
			var oldSelected = @com.eemi.ext4j.client.data.TableItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(os);
			var newSelected = @com.eemi.ext4j.client.data.TableItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ns);

			var event = @com.eemi.ext4j.client.events.selection.FocusChangeEvent::new(Lcom/eemi/ext4j/client/selection/SelectionModel;Lcom/eemi/ext4j/client/data/TableItem;Lcom/eemi/ext4j/client/data/TableItem;Lcom/google/gwt/core/client/JavaScriptObject;)(sm, oldFocused, newFocused);
			handler.@com.eemi.ext4j.client.events.selection.FocusChangeHandler::onFocusChange(Lcom/eemi/ext4j/client/events/selection/FocusChangeEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.selection.FocusChangeEvent::EVENT_NAME;
		obj.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.CallbackRegistration::new(Lcom/eemi/ext4j/client/core/JsObject;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName, fn);
		return toReturn;
    }-*/;

    /**
     * Fired after a selection change has occurred
     */
    public native CallbackRegistration addSelectionChangeHandler(SelectionChangeHandler handler)/*-{
		var obj = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		var fn = function(model, selection, e) {
			var sm = @com.eemi.ext4j.client.selection.SelectionModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(model);
			var items = @com.eemi.ext4j.client.data.TableItem::fromArray(Lcom/google/gwt/core/client/JavaScriptObject;)(selection);

			var event = @com.eemi.ext4j.client.events.selection.SelectionChangeEvent::new(Lcom/eemi/ext4j/client/selection/SelectionModel;Ljava/util/List;Lcom/google/gwt/core/client/JavaScriptObject;)(sm,item,e);
			handler.@com.eemi.ext4j.client.events.selection.SelectionChangeHandler::onSelectionChange(Lcom/eemi/ext4j/client/events/selection/SelectionChangeEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.selection.SelectionChangeEvent::EVENT_NAME;
		obj.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.CallbackRegistration::new(Lcom/eemi/ext4j/client/core/JsObject;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName, fn);
		return toReturn;
    }-*/;

    /**
     * Fired after a record is selected
     */
    public native CallbackRegistration addSelectHandler(SelectHandler handler)/*-{
		var obj = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		var fn = function(model, record, row, column, e) {
			var sm = @com.eemi.ext4j.client.selection.SelectionModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(model);
			var model = @com.eemi.ext4j.client.data.BaseModel::from(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
			var event = @com.eemi.ext4j.client.events.selection.SelectEvent::new(Lcom/eemi/ext4j/client/selection/SelectionModel;Lcom/eemi/ext4j/client/data/BaseModel;IILcom/google/gwt/core/client/JavaScriptObject;)(sm,model,row,column,e);
			handler.@com.eemi.ext4j.client.events.selection.SelectHandler::onSelect(Lcom/eemi/ext4j/client/events/selection/SelectEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.selection.SelectEvent::EVENT_NAME;
		obj.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.CallbackRegistration::new(Lcom/eemi/ext4j/client/core/JsObject;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName, fn);
		return toReturn;
    }-*/;

    /**
     * Fired after a record is deselected
     */
    public native CallbackRegistration addDeselectHandler(DeselectHandler handler)/*-{
		var obj = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		var fn = function(model, record, row, column, e) {
			var sm = @com.eemi.ext4j.client.selection.SelectionModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(model);
			var model = @com.eemi.ext4j.client.data.BaseModel::from(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
			var event = @com.eemi.ext4j.client.events.selection.DeselectEvent::new(Lcom/eemi/ext4j/client/selection/SelectionModel;Lcom/eemi/ext4j/client/data/BaseModel;IILcom/google/gwt/core/client/JavaScriptObject;)(sm,model,row,column,e);
			handler.@com.eemi.ext4j.client.events.selection.DeselectHandler::onDeselect(Lcom/eemi/ext4j/client/events/selection/DeselectEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.selection.DeselectEvent::EVENT_NAME;
		obj.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.CallbackRegistration::new(Lcom/eemi/ext4j/client/core/JsObject;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName, fn);
		return toReturn;
    }-*/;

    private native void _select(NodeInterface record)/*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::jsObj;
		var obj = record.@com.eemi.ext4j.client.core.JsObject::jsObj;
		if (jso && obj) {
			jso.select(obj);
		}
    }-*/;

    private native void _select(NodeInterface record, boolean keepExisting)/*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::jsObj;
		var obj = record.@com.eemi.ext4j.client.core.JsObject::jsObj;
		if (jso && obj) {
			jso.select(obj, keepExisting);
		}
    }-*/;

    private native void _select(NodeInterface record, boolean keepExisting, boolean suppressEvent)/*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::jsObj;
		var obj = record.@com.eemi.ext4j.client.core.JsObject::jsObj;
		if (jso && obj) {
			jso.select(obj, keepExisting, suppressEvent);
		}
    }-*/;

}
