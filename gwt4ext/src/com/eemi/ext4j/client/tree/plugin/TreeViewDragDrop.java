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
package com.eemi.ext4j.client.tree.plugin;

import com.eemi.ext4j.client.core.JsoHelper;
import com.eemi.ext4j.client.core.config.Attribute;
import com.eemi.ext4j.client.grid.plugin.AbstractViewPlugin;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * This plugin provides drag and/or drop functionality for a TreeView.
 */
public class TreeViewDragDrop extends AbstractViewPlugin {

    public TreeViewDragDrop() {
        jsObj = createNativePeer();
    }

    public TreeViewDragDrop(String dragText) {
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
     * True if drops on the tree container (outside of a specific tree node) are
     * allowed.
     * <p>
     * Defaults to: false
     */
    public void setAllowContainerDrop(boolean value) {
        JsoHelper.setAttribute(jsObj, Attribute.ALLOW_CONTAINER_DROPS.getValue(), value);
    }

    /**
     * Allow inserting a dragged node between an expanded parent node and its
     * first child that will become a sibling of the parent when dropped.
     * <p>
     * Defaults to: false
     */
    public void setAllowParentInserts(boolean value) {
        JsoHelper.setAttribute(jsObj, "allowParentInserts", value);
    }

    /**
     * True if the tree should only allow append drops (use for trees which are
     * sorted).
     * <p>
     * Defaults to: false
     */
    public void setAppendOnly(boolean value) {
        JsoHelper.setAttribute(jsObj, "appendOnly", value);
    }

    /**
     * True to register this container with the Scrollmanager for auto scrolling
     * during drag operations. A Ext.dd.ScrollManager configuration may also be
     * passed.
     * <p>
     * Defaults to: false
     */
    public void setContainerScroll(boolean value) {
        JsoHelper.setAttribute(jsObj, "containerScroll", value);
    }

    /**
     * The ddGroup to which the DragZone will belong.
     * <p>
     * This defines which other DropZones the DragZone will interact with.
     * Drag/DropZones only interact with other Drag/DropZones which are members
     * of the same ddGroup.
     */
    public void setDdGroug(String value) {
        JsoHelper.setAttribute(jsObj, "ddGroup", value);
    }

    /**
     * The ddGroup to which the DropZone will belong.
     * <p>
     * This defines which other DragZones the DropZone will interact with.
     * Drag/DropZones only interact with other Drag/DropZones which are members
     * of the same ddGroup.
     */
    public void setDropGroup(String value) {
        JsoHelper.setAttribute(jsObj, "dropGroup", value);
    }

    /**
     * Set to false to disallow dragging items from the View.
     * <p>
     * Defaults to: true
     */
    public void setEnableDrag(boolean value) {
        JsoHelper.setAttribute(jsObj, "enableDrag", value);
    }

    /**
     * Set to false to disallow the View from accepting drop gestures.
     * <p>
     * Defaults to: true
     */
    public void setEnableDrop(boolean value) {
        JsoHelper.setAttribute(jsObj, "enableDrop", value);
    }

    /**
     * The delay in milliseconds to wait before expanding a target tree node
     * while dragging a droppable node over the target.
     * <p>
     * Defaults to: 1000
     */
    public void setExpandDelay(int value) {
        JsoHelper.setAttribute(jsObj, "expandDelay", value);
    }

    /**
     * The color to use when visually highlighting the dragged or dropped node
     * (default value is light blue). The color must be a 6 digit hex value,
     * without a preceding '#'.
     * <p>
     * Defaults to: 'c3daf9'
     */
    public void setNodeHighLightColor(String value) {
        JsoHelper.setAttribute(jsObj, "nodeHighLightColor", value);
    }

    /**
     * Whether or not to highlight any nodes after they are successfully dropped
     * on their target.
     */
    public void setNodeHighLightOnDrop(boolean value) {
        JsoHelper.setAttribute(jsObj, "nodeHighLightOnDrop", value);
    }

    /**
     * Whether or not to highlight any nodes after they are repaired from an
     * unsuccessful drag/drop.
     */
    public void setNodeHighLightOnRepair(boolean value) {
        JsoHelper.setAttribute(jsObj, "nodeHighLightOnRepair", value);
    }

    protected TreeViewDragDrop(JavaScriptObject obj) {
        super(obj);
    }

    private native JavaScriptObject createNativePeer()/*-{
		return {
			ptype : 'treeviewdragdrop'
		};
    }-*/;

}
