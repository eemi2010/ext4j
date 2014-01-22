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
package com.eemi.ext4j.client.grid.plugin;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * The CellEditing plugin injects editing at a cell level for a Grid. Only a
 * single cell will be editable at a time. The field that will be used for the
 * editor is defined at the editor. The editor can be a field instance or a
 * field configuration.
 * <p>
 * If an editor is not specified for a particular column then that cell will not
 * be editable and it will be skipped when activated via the mouse or the
 * keyboard.
 * <p>
 * The editor may be shared for each column in the grid, or a different one may
 * be specified for each column. An appropriate field type should be chosen to
 * match the data structure that it will be editing. For example, to edit a
 * date, it would be useful to specify Ext.form.field.Date as the editor.
 * 
 * 
 */
public class CellEditing extends Editing {

    public CellEditing() {
        jsObj = createNativePeer();
    }

    public CellEditing(int clicksToEdit) {
        this();
        setClicksToEdit(clicksToEdit);
    }

    protected CellEditing(JavaScriptObject obj) {
        super(obj);
    }

    /**
     * Starts editing by position (row/column)
     */
    public native void startEditByPosition(int startRow, int startColumn)/*-{
		var peer = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		peer.startEditByPosition({
			row : startRow,
			column : startColumn
		});
    }-*/;

    public static CellEditing cast(Editing editing) {
        return new CellEditing(editing.getJsObj());
    }

    private native JavaScriptObject createNativePeer()/*-{
		return new $wnd.Ext.grid.plugin.CellEditing();
    }-*/;

}
