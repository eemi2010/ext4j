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
package com.ati.ext4j.client.grid.column;

import java.util.List;

import com.ati.ext4j.client.core.Component;
import com.ati.ext4j.client.core.JsoHelper;
import com.ati.ext4j.client.core.config.BaseConfig;
import com.ati.ext4j.client.core.config.XType;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public class GridColumn extends BaseConfig {

    public GridColumn() {
        jsObj = JsoHelper.createObject();
        setFlex(1);
    }

    protected GridColumn(JavaScriptObject obj) {
        jsObj = obj;
    }

    public GridColumn(String text, String dataIndex) {
        this();
        setHeader(text);
        setDataIndex(dataIndex);
    }

    public GridColumn(String text, String dataIndex, GridColumnRenderer renderer) {
        this();
        setHeader(text);
        setDataIndex(dataIndex);
        setRenderer(renderer);
    }

    public void setHeader(String text) {
        JsoHelper.setAttribute(getJsObj(), "header", text);
    }

    public void setFilterable(boolean value) {
        JsoHelper.setAttribute(getJsObj(), "filterable", value);
    }

    public void setLocked(boolean value) {
        JsoHelper.setAttribute(getJsObj(), "locked", value);
    }

    public void setFilter(Filter value) {
        JsoHelper.setAttribute(getJsObj(), "filter", value.getJsObj());
    }

    public void setFilter(boolean value) {
        JsoHelper.setAttribute(getJsObj(), "filter", value);
    }

    public void setText(String text) {
        JsoHelper.setAttribute(getJsObj(), "text", text);
    }

    public void setXType(String value) {
        JsoHelper.setAttribute(getJsObj(), "xtype", value);
    }

    public void setDataIndex(String text) {
        JsoHelper.setAttribute(getJsObj(), "dataIndex", text);
    }

    public void setSortable(boolean value) {
        JsoHelper.setAttribute(getJsObj(), "sortable", value);
    }

    public void setHideable(boolean value) {
        JsoHelper.setAttribute(getJsObj(), "hideable", value);
    }

    public void setEditor(String value) {
        JsoHelper.setAttribute(getJsObj(), "editor", value);
    }

    public void setEditor(XType value) {
        JsoHelper.setAttribute(getJsObj(), "editor", value.getValue());
    }

    public void setEditor(GridColumnEditor value) {
        JsoHelper.setAttribute(getJsObj(), "editor", value.getJsObj());
    }

    public void setEditor(Component editor) {
        JsoHelper.setAttribute(getJsObj(), "editor", editor.getOrCreateJsObj());
    }

    public void setFlex(int value) {
        JsoHelper.setAttribute(getJsObj(), "flex", value);
    }

    public void setSummaryType(int value) {
        JsoHelper.setAttribute(getJsObj(), "summaryType", value);
    }

    public double getWidth() {
        return JsoHelper.getAttributeAsFloat(jsObj, "width");
    }

    public void setWidth(double value) {
        JsoHelper.setAttribute(getJsObj(), "width", value);
    }

    public void setHeight(double value) {
        JsoHelper.setAttribute(getJsObj(), "height", value);
    }

    public void setRenderer(String value) {
        JsoHelper.setAttribute(getJsObj(), "renderer", value);
    }

    public void setRenderer(JavaScriptObject renderer) {
        JsoHelper.setAttribute(getJsObj(), "renderer", renderer);
    }

    public void setRenderer(GridColumnRenderer renderer) {
        JsoHelper.setAttribute(getJsObj(), "renderer", createRenderer(renderer));
    }

    public void setSummaryRenderer(GridColumnSummaryRenderer renderer) {
        JsoHelper.setAttribute(getJsObj(), "summaryRenderer", createSummaryRenderer(renderer));
    }

    public void setSummaryRenderer(String renderer) {
        JsoHelper.setAttribute(getJsObj(), "summaryRenderer", renderer);
    }

    public void setSummaryRenderer(JavaScriptObject renderer) {
        JsoHelper.setAttribute(getJsObj(), "summaryRenderer", renderer);
    }

    public void setDisabled(String value) {
        JsoHelper.setAttribute(getJsObj(), "disabled", value);
    }

    /**
     * Text to display in this column's menu item if no text was specified as a
     * header.
     */
    public void setMenuText(String value) {
        JsoHelper.setAttribute(getJsObj(), "menuText", value);
    }

    public static JavaScriptObject fromList(List<GridColumn> cols) {
        JsArray<JavaScriptObject> obj = JsArray.createArray().cast();
        for (GridColumn c : cols) {
            obj.push(c.getJsObj());
        }
        return obj;
    }

    public static GridColumn from(JavaScriptObject obj) {
        return new GridColumn(obj);
    }

    public void update(JavaScriptObject obj) {
        this.jsObj = obj;
    }

    private native JavaScriptObject createRenderer(GridColumnRenderer renderer)/*-{
		return function(value, metaData, rec, rowIndex, colIndex, store, view) {
			var valueToProcess = value;
			var type = typeof value;
			if (type == 'number') {
				valueToProcess = @java.lang.Double::toString(D)(value);
			}
			var cellMetaData = @com.ati.ext4j.client.grid.column.CellMetaData::new(Lcom/google/gwt/core/client/JavaScriptObject;)(metaData);
			var model = @com.ati.ext4j.client.data.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rec);
			var s = @com.ati.ext4j.client.data.Store::new(Lcom/google/gwt/core/client/JavaScriptObject;)(store);
			var dataView = @com.ati.ext4j.client.ui.DataView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(view);
			return renderer.@com.ati.ext4j.client.grid.column.GridColumnRenderer::onRender(Ljava/lang/String;Lcom/ati/ext4j/client/grid/column/CellMetaData;Lcom/ati/ext4j/client/data/BaseModel;IILcom/ati/ext4j/client/data/Store;Lcom/ati/ext4j/client/ui/DataView;)(valueToProcess,cellMetaData,model,rowIndex,colIndex,s,dataView);
		};
    }-*/;

    private native JavaScriptObject createSummaryRenderer(GridColumnSummaryRenderer renderer)/*-{
		return function(value, data, field) {
			var valueToProcess = value;
			var type = typeof value;
			if (type == 'number') {
				valueToProcess = @java.lang.Double::toString(D)(value);
			}
			return renderer.@com.ati.ext4j.client.grid.column.GridColumnSummaryRenderer::onRender(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;)(valueToProcess, data, field);
		};
    }-*/;

}
