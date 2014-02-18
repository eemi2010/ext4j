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
package com.ati.ext4j.client.grid.plugin;

import com.ati.ext4j.client.core.JsoHelper;
import com.ati.ext4j.client.core.config.Attribute;
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
public class DragDrop extends AbstractViewPlugin {

    public DragDrop() {
        jsObj = createNativePeer();
    }

    public DragDrop(String dragText) {
        this();
        setDragText(dragText);
    }

    /**
     * The text to show while dragging.
     * 
     * @param value
     */
    public void setDragText(String value) {
        JsoHelper.setAttribute(jsObj, Attribute.DRAG_TEXT.getValue(), value);
    }

    /**
     * A named drag drop group to which this object belongs. If a group is
     * specified, then both the DragZones and DropZone used by this plugin will
     * only interact with other drag drop objects in the same group.
     * <p>
     * Defaults to: "GridDD"
     * 
     * @param value
     */
    public void setDragDropGroup(String value) {
        JsoHelper.setAttribute(jsObj, Attribute.DD_GROUP.getValue(), value);
    }

    /**
     * The ddGroup to which the DropZone will belong.
     * <p>
     * This defines which other DragZones the DropZone will interact with.
     * Drag/DropZones only interact with other Drag/DropZones which are members
     * of the same ddGroup.
     * 
     * @param value
     */
    public void setDropGroup(String value) {
        JsoHelper.setAttribute(jsObj, Attribute.DROP_GROUP.getValue(), value);
    }

    /**
     * False to disallow dragging items from the View.
     * <p>
     * Defaults to: true
     */
    public void setEnableDrag(boolean value) {
        JsoHelper.setAttribute(jsObj, Attribute.ENABLE_DRAG.getValue(), value);
    }

    /**
     * False to disallow the View from accepting drop gestures.
     * <p>
     * Defaults to: true
     */
    public void setEnableDrop(boolean value) {
        JsoHelper.setAttribute(jsObj, Attribute.ENABLE_DROP.getValue(), value);
    }

    protected DragDrop(JavaScriptObject obj) {
        super(obj);
    }

    private native JavaScriptObject createNativePeer()/*-{
		return {
			ptype : 'gridviewdragdrop'
		};
    }-*/;

}
