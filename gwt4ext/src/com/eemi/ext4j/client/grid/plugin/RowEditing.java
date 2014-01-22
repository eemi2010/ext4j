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

import com.eemi.ext4j.client.core.JsoHelper;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * The RowEditing plugin injects editing at a row level for a Grid. When editing
 * begins, a small floating dialog will be shown for the appropriate row. Each
 * editable column will show a field for editing. There is a button to save or
 * cancel all changes for the edit.
 * <p>
 * The field that will be used for the editor is defined at the editor. The
 * editor can be a field instance or a field configuration. If an editor is not
 * specified for a particular column then that column won't be editable and the
 * value of the column will be displayed. To provide a custom renderer for
 * non-editable values, use the editRenderer configuration on the column.
 * <p>
 * The editor may be shared for each column in the grid, or a different one may
 * be specified for each column. An appropriate field type should be chosen to
 * match the data structure that it will be editing. For example, to edit a
 * date, it would be useful to specify Ext.form.field.Date as the editor.
 * 
 * @author alainekambi
 * 
 */
public class RowEditing extends Editing {

    public RowEditing() {
        jsObj = createNativePeer();
    }

    public RowEditing(int clicksToEdit) {
        this();
        setClicksToEdit(clicksToEdit);
    }

    /**
     * 
     * True to automatically cancel any pending changes when the row editor
     * begins editing a new row. False to force the user to explicitly cancel
     * the pending changes. Defaults to true.
     */
    public void setAutoCancel(boolean value) {
        JsoHelper.setAttribute(jsObj, "autoCancel", value);
    }

    /**
     * 
     * The number of clicks to move the row editor to a new row while it is
     * visible and actively editing another row. This will default to the same
     * value as clicksToEdit.
     */
    public void setClicksToMoveEditor(int value) {
        JsoHelper.setAttribute(jsObj, "clicksToMoveEditor", value);
    }

    /**
     * True to show a tooltip that summarizes all validation errors present in
     * the row editor. Set to false to prevent the tooltip from showing.
     * Defaults to true.
     */
    public void setErrorSummary(boolean value) {
        JsoHelper.setAttribute(jsObj, "errorSummary", value);
    }

    protected RowEditing(JavaScriptObject obj) {
        super(obj);
    }

    public static RowEditing cast(Editing editing) {
        return new RowEditing(editing.getJsObj());
    }

    private native JavaScriptObject createNativePeer()/*-{
		return new $wnd.Ext.grid.plugin.RowEditing();
    }-*/;

    // TODO startEdit Handler

}
