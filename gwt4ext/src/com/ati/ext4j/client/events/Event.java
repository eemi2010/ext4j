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
package com.ati.ext4j.client.events;

/**
 * Contains event constants
 * 
 */
public class Event {

    private Event() {

    }

    public static final String ACTIVATE = "activate";
    public static final String NODE_DRAG_OVER = "nodedragover";
    public static final String ARROW_CLICK = "arrowclick";
    public static final String ADDED = "added";
    public static final String CHANGE = "change";
    public static final String AFTER_RENDER = "afterrender";
    public static final String BEFORE_ACTIVATE = "beforeactivate";
    public static final String BEFORE_DEACTIVATE = "beforedeactivate";
    public static final String BEFORE_COMPLETE = "beforecomplete";
    public static final String BEFORE_START_EDIT = "beforestartedit";
    public static final String BEFORE_CELL_CLICK = "beforecellclick";
    public static final String BEFORE_CELL_CONTEXTMENU = "beforecellcontextmenu";
    public static final String BEFORE_CELL_DOUBLE_CLICK = "beforecelldblclick";
    public static final String BEFORE_CELL_KEY_DOWN = "beforecellkeydown";
    public static final String BEFORE_CELL_MOUSE_DOWN = "beforecellmousedown";
    public static final String BEFORE_CELL_MOUSE_UP = "beforecellmouseup";
    public static final String CELL_CLICK = "cellclick";
    public static final String CELL_CONTEXT_MENU = "cellcontextmenu";
    public static final String CELL_DOUBLE_CLICK = "celldblclick";
    public static final String CELL_KEY_DOWN = "cellkeydown";
    public static final String CELL_MOUSE_DOWN = "cellmousedown";
    public static final String CELL_MOUSE_UP = "cellmouseup";
    public static final String CANCEL_EDIT = "canceledit";
    public static final String EDIT = "edit";
    public static final String BEFORE_DESTROY = "beforedestroy";
    public static final String BEFORE_HIDE = "beforehide";
    public static final String BEFORE_REFRESH = "beforerefresh";
    public static final String BEFORE_RENDER = "beforerender";
    public static final String BEFORE_SHOW = "beforeshow";
    public static final String BEFORE_STATE_SAVE = "beforestatesave";
    public static final String BEFORE_STATE_RESTORE = "beforestaterestore";
    public static final String BLUR = "blur";
    public static final String START_EDIT = "startedit";
    public static final String BOX_READY = "boxready";
    public static final String CLICK = "click";
    public static final String FAILURE = "failure";
    public static final String SUCCESS = "success";
    public static final String DOUBLE_CLICK = "dblclick";
    public static final String DEACTIVATE = "deactivate";
    public static final String DESTROY = "destroy";
    public static final String DISABLE = "disable";
    public static final String ENABLE = "enable";
    public static final String FOCUS = "focus";
    public static final String HIDE = "hide";
    public static final String HEADER_CLICK = "headerclick";
    public static final String HEADER_TRIGGER_CLICK = "headertriggerclick";
    public static final String HEADER_CONTEXT_MENU = "headercontextmenu";
    public static final String MOVE = "move";
    public static final String MENU_HIDE = "menuhide";
    public static final String MENU_SHOW = "menushow";
    public static final String MENU_TRIGGER_OVER = "menutrigerover";
    public static final String MENU_TRIGGER_OUT = "menutrigerout";
    public static final String MOUSE_OUT = "mouseout";
    public static final String MOUSE_OVER = "mouseover";
    public static final String MOUSE_DOWN = "mousedown";
    public static final String MOUSE_ENTER = "mouseenter";
    public static final String MOUSE_LEAVE = "mouseleave";
    public static final String MOUSE_MOVE = "mousemove";
    public static final String MOUSE_UP = "mouseup";
    public static final String TOGGLE = "toggle";
    public static final String REMOVED = "removed";
    public static final String RENDER = "render";
    public static final String RESIZE = "resize";
    public static final String SHOW = "show";
    public static final String STATE_RESTORE = "staterestore";
    public static final String STATE_SAVE = "statesave";
    public static final String ADD = "add";
    public static final String AFTER_LAYOUT = "afterlayout";
    public static final String BEFORE_ADD = "beforeadd";
    public static final String BEFORE_REMOVE = "beforeremove";
    public static final String REMOVE = "remove";
    public static final String REFRESH = "refresh";
    public static final String RECONFIGURE = "reconfigure";
    public static final String BEFORE_RECONFIGURE = "beforereconfigure";
    public static final String BEFORE_CLOSE = "beforeclose";
    public static final String BEFORE_COLLAPSE = "beforecollapse";
    public static final String BEFORE_EXPAND = "beforeexpand";
    public static final String CLOSE = "close";
    public static final String COLLAPSE = "collapse";
    public static final String COMPLETE = "complete";
    public static final String EXCEPTION = "exception";
    public static final String OPERATION_COMPLETE = "operationcomplete";
    public static final String EXPAND = "expand";
    public static final String ICON_CHANGE = "iconchange";
    public static final String ICON_CLS_CHANGE = "iconclschange";
    public static final String TITLE_CHANGE = "titlechange";
    public static final String TEXT_CHANGE = "textchange";
    public static final String BEFORE_CHECK_CHANGE = "beforecheckchange";
    public static final String CHECK_CHANGE = "checkchange";
    public static final String SELECT = "select";
    public static final String BEFORE_DESELECT = "beforedeselect";
    public static final String BEFORE_SELECT = "beforeselect";
    public static final String BEFORE_EDIT = "beforeedit";
    public static final String ITEM_CLICK = "itemclick";
    public static final String ITEM_DOUBLE_CLICK = "itemdblclick";
    public static final String ITEM_CONTEXT_MENU = "itemcontextmenu";
    public static final String ITEM_MOUSE_DOWN = "itemmousedown";
    public static final String ITEM_MOUSE_ENTER = "itemmouseenter";
    public static final String ITEM_MOUSE_LEAVE = "itemmouseleave";
    public static final String ITEM_MOUSE_UP = "itemmouseup";
    public static final String VALIDATE_EDIT = "validateedit";
    public static final String SELECTION_CHANGE = "selectionchange";
    public static final String SORT_CHANGE = "sortchange";
    public static final String GROUP_CLICK = "groupclick";
    public static final String GLYPH_CHANGE = "glyphchange";
    public static final String GROUP_COLLAPSE = "groupcollapse";
    public static final String GROUP_CONTEXT_MENU = "groupcontextmenu";
    public static final String GROUP_DOUBLE_CLICK = "groupdblclick";
    public static final String GROUP_EXPAND = "groupexpand";
    public static final String BEFORE_DROP = "beforedrop";
    public static final String DROP = "drop";
    public static final String BEFORE_TAB_CHANGE = "beforetabchange";
    public static final String TAB_CHANGE = "tabchange";
    public static final String SPECIAL_KEY = "specialkey";
    public static final String WRITEABLE_CHANGE = "writeablechange";
    public static final String DRAG_START = "dragstart";
    public static final String DRAG_END = "dragend";
    public static final String DRAG = "drag";
    public static final String CHANGE_COMPLETE = "changecomplete";
    public static final String BEFORE_CHANGE = "beforechange";
    public static final String MAXIMIZE = "maximize";
    public static final String MINIMIZE = "minimize";
    public static final String RESTORE = "restore";
    public static final String ITEM_ADD = "itemadd";
    public static final String ITEM_REMOVE = "itemremove";
    public static final String ITEM_UPDATE = "itemupdate";
    public static final String VIEW_READY = "viewready";
    public static final String BEFORE_CONTAINER_CLICK = "beforecontainerclick";
    public static final String BEFORE_CONTAINER_CONTEXT_MENU = "beforecontainercontextmenu";
    public static final String BEFORE_CONTAINER_DOUBLE_CLICK = "beforecontainerdblclick";
    public static final String BEFORE_CONTAINER_KEY_DOWN = "beforecontainerkeydown";
    public static final String BEFORE_CONTAINER_MOUSE_DOWN = "beforecontainermousedown";
    public static final String BEFORE_CONTAINER_MOUSE_OUT = "beforecontainermouseout";
    public static final String BEFORE_CONTAINER_MOUSE_OVER = "beforecontainermouseover";
    public static final String BEFORE_CONTAINER_MOUSE_UP = "beforecontainermouseup";
    public static final String BEFORE_ITEM_CLICK = "beforeitemclick";
    public static final String BEFORE_ITEM_CONTEXT_MENU = "beforeitemcontextmenu";
    public static final String BEFORE_ITEM_DOUBLE_CLICK = "beforeitemdblclick";
    public static final String BEFORE_ITEM_KEY_DOWN = "beforeitemkeydown";
    public static final String BEFORE_ITEM_MOUSE_DOWN = "beforeitemmousedown";
    public static final String BEFORE_ITEM_MOUSE_ENTER = "beforeitemmouseenter";
    public static final String BEFORE_ITEM_MOUSE_LEAVE = "beforeitemmouseleave";
    public static final String BEFORE_ITEM_MOUSE_UP = "beforeitemmouseup";
    public static final String CONTAINER_CLICK = "containerclick";
    public static final String CONTAINER_CONTEXT_MENU = "containercontextmenu";
    public static final String CONTEXT_MENU = "contextmenu";
    public static final String CONTAINER_DOUBLE_CLICK = "containerdblclick";
    public static final String CONTAINER_KEY_DOWN = "containerkeydown";
    public static final String CONTAINER_MOUSE_OUT = "containermouseout";
    public static final String CONTAINER_MOUSE_DOWN = "containermousedonw";
    public static final String CONTAINER_MOUSE_OVER = "containermouseover";
    public static final String CONTAINER_MOUSE_UP = "containermouseup";
    public static final String DESELECT = "deselect";
    public static final String FILTER_CHANGE = "filerchange";
    public static final String GROUP_CHANGE = "groupchange";
    public static final String FOCUS_CHANGE = "focuschange";
    public static final String HIGHLIGHT_ITEM = "highlightitem";
    public static final String ITEM_KEY_DOWM = "itemkeydown";
    public static final String UNHIGHLIGHT_ITEM = "unhighlichtitem";
    public static final String RESIZE_DRAG = "resizedrag";
    public static final String BEFORE_RESIZE = "beforeresize";
    public static final String AFTER_ITEM_COLLAPSE = "afteritemcollapse";
    public static final String AFTER_ITEM_EXPAND = "afteritemexpand";
    public static final String BEFORE_ITEM_APPEND = "beforeitemappend";
    public static final String BEFORE_ITEM_COLLAPSE = "beforeitemcollapse";
    public static final String BEFORE_ITEM_EXPAND = "beforeitemexpand";
    public static final String BEFORE_ITEM_INSERT = "beforeiteminsert";
    public static final String BEFORE_ITEM_REMOVE = "beforeitemremove";
    public static final String BEFORE_ITEM_MOVE = "beforeitemmove";
    public static final String BEFORE_LOAD = "beforeload";
    public static final String ITEM_APPEND = "itemappend";
    public static final String ITEM_COLLAPSE = "itemcollapse";
    public static final String ITEM_EXPAND = "itemexpand";
    public static final String ITEM_INSERT = "iteminsert";
    public static final String ITEM_MOVE = "itemmove";
    public static final String LOAD = "load";
    public static final String UPDATE = "update";
    public static final String ACTION_COMPLETE = "actioncomplete";
    public static final String ACTION_FAILED = "actionfailed";
    public static final String BEFORE_ACTION = "beforeaction";
    public static final String DIRTY_CHANGE = "dirtychange";
    public static final String VALIDITY_CHANGE = "validitychange";
    public static final String AUTO_SIZE = "autosize";
    public static final String KEY_DOWN = "keydown";
    public static final String KEY_UP = "keyup";
    public static final String KEY_PRESS = "keypress";
    public static final String BEFORE_QUERY = "beforequery";
    public static final String SPIN = "spin";
    public static final String SPIN_DOWN = "spindow";
    public static final String SPIN_UP = "spinup";
    public static final String FLOAT = "flaot";
    public static final String UNFLOAT = "unflaot";
    public static final String COLUMN_HIDE = "columnhide";
    public static final String COLUMN_SHOW = "columnshow";
    public static final String COLUMN_MOVE = "columnmove";
    public static final String COLUMN_RESIZE = "columnresize";
    public static final String COLUMNS_CHANGED = "columnschanged";

}
