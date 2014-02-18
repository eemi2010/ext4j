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
package com.ati.ext4j.client.selection;

import com.ati.ext4j.client.core.JsoHelper;
import com.ati.ext4j.client.events.CallbackRegistration;
import com.ati.ext4j.client.events.selection.BeforeDeselectHandler;
import com.ati.ext4j.client.events.selection.BeforeSelectHandler;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * Implements row based navigation via keyboard.
 * 
 * Must synchronize across grid sections.
 */
public class RowSelectionModel extends SelectionModel {

    protected RowSelectionModel() {
        jsObj = JsoHelper.createObject();
    }

    public RowSelectionModel(JavaScriptObject obj) {
        jsObj = obj;
    }

    public static RowSelectionModel from(SelectionModel model) {
        return new RowSelectionModel(model.getJsObj());
    }

    /**
     * Selects the record immediately following the currently selected record.
     */
    public native void selectNext()/*-{
		var jso = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		if (jso && jso.selectNext) {
			jso.selectNext();
		}
    }-*/;

    /**
     * Selects the record immediately following the currently selected record.
     */
    public native void selectNext(boolean keepExisting)/*-{
		var jso = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		if (jso && jso.selectNext) {
			jso.selectNext(keepExisting);
		}
    }-*/;

    /**
     * Selects the record immediately following the currently selected record.
     */
    public native void selectNext(boolean keepExisting, boolean supressEvent)/*-{
		var jso = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		if (jso && jso.selectNext) {
			jso.selectNext(keepExisting, supressEvent);
		}
    }-*/;

    /**
     * Selects the record that precedes the currently selected record.
     */
    public native void selectPrevious()/*-{
		var jso = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		if (jso && jso.selectPrevious) {
			jso.selectPrevious();
		}
    }-*/;

    /**
     * Selects the record that precedes the currently selected record.
     */
    public native void selectPrevious(boolean keepExisting)/*-{
		var jso = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		if (jso && jso.selectPrevious) {
			jso.selectPrevious(keepExisting);
		}
    }-*/;

    /**
     * Selects the record that precedes the currently selected record.
     */
    public native void selectPrevious(boolean keepExisting, boolean supressEvent)/*-{
		var jso = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		if (jso && jso.selectPrevious) {
			jso.selectPrevious(keepExisting, supressEvent);
		}
    }-*/;

    /**
     * Fired before a record is deselected. If any listener returns false, the
     * deselection is cancelled.
     */
    public native CallbackRegistration addBeforeDeselectHandler(BeforeDeselectHandler handler)/*-{
		var obj = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		var fn = function(model, record, index, e) {
			var sm = @com.ati.ext4j.client.selection.SelectionModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(model);
			var model = @com.ati.ext4j.client.data.BaseModel::from(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
			var event = @com.ati.ext4j.client.events.selection.BeforeDeselectEvent::new(Lcom/ati/ext4j/client/selection/SelectionModel;Lcom/ati/ext4j/client/data/BaseModel;ILcom/google/gwt/core/client/JavaScriptObject;)(sm,record,index,e);
			return handler.@com.ati.ext4j.client.events.selection.BeforeDeselectHandler::onBeforeDeselect(Lcom/ati/ext4j/client/events/selection/BeforeDeselectEvent;)(event);
		};
		var eventName = @com.ati.ext4j.client.events.selection.BeforeDeselectEvent::EVENT_NAME;
		obj.addListener(eventName, fn);
		var toReturn = @com.ati.ext4j.client.events.CallbackRegistration::new(Lcom/ati/ext4j/client/core/JsObject;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName, fn);
		return toReturn;
    }-*/;

    /**
     * Fired before a record is selected. If any listener returns false, the
     * selection is cancelled.
     */
    public native CallbackRegistration addBeforeSelectHandler(BeforeSelectHandler handler)/*-{
		var obj = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		var fn = function(model, record, index, e) {
			var sm = @com.ati.ext4j.client.selection.SelectionModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(model);
			var model = @com.ati.ext4j.client.data.BaseModel::from(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
			var event = @com.ati.ext4j.client.events.selection.BeforeSelectEvent::new(Lcom/ati/ext4j/client/selection/SelectionModel;Lcom/ati/ext4j/client/data/BaseModel;ILcom/google/gwt/core/client/JavaScriptObject;)(sm,record,index,e);
			return handler.@com.ati.ext4j.client.events.selection.BeforeSelectHandler::onBeforeSelect(Lcom/ati/ext4j/client/events/selection/BeforeSelectEvent;)(event);
		};
		var eventName = @com.ati.ext4j.client.events.selection.BeforeSelectEvent::EVENT_NAME;
		obj.addListener(eventName, fn);
		var toReturn = @com.ati.ext4j.client.events.CallbackRegistration::new(Lcom/ati/ext4j/client/core/JsObject;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName, fn);
		return toReturn;
    }-*/;

}
