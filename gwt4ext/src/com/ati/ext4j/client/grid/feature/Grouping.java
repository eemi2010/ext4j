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
package com.ati.ext4j.client.grid.feature;

import com.ati.ext4j.client.core.ExtElement;
import com.ati.ext4j.client.core.JsoHelper;
import com.ati.ext4j.client.core.Template;
import com.ati.ext4j.client.events.Event;
import com.ati.ext4j.client.events.grid.GroupExpandHandler;
import com.ati.ext4j.client.events.grid.GroupInteractionHandler;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * This feature allows to display the grid rows aggregated into groups as
 * specified by the groupers specified on the Store. The group will show the
 * title for the group name and then the appropriate records for the group
 * underneath. The groups can also be expanded and collapsed.
 * 
 */
public class Grouping extends Feature {

    public Grouping() {
        jsObj = createNativePeer();
    }

    /**
     * Text displayed in the grid header menu for grouping by header.
     * <p>
     * Defaults to: "Group by this field"
     * 
     */
    public void setCollapsible(boolean value) {
        JsoHelper.setAttribute(jsObj, "collapsible", value);
    }

    /**
     * Number of pixels to indent per grouping level
     * <p>
     * Defaults to: 17
     * 
     */
    public void setDepthToIndent(int value) {
        JsoHelper.setAttribute(jsObj, "depthToIndent", value);
    }

    /**
     * True to enable the grouping control in the header menu.
     * <p>
     * Defaults to: true
     * 
     */
    public void setEnableGroupingMenu(boolean value) {
        JsoHelper.setAttribute(jsObj, "enableGroupingMenu", value);
    }

    /**
     * True to allow the user to turn off grouping.
     * <p>
     * Defaults to: true
     * 
     */
    public void setEnableNoGroups(boolean value) {
        JsoHelper.setAttribute(jsObj, "enableNoGroups", value);
    }

    /**
     * Text displayed in the grid header menu for grouping by header.
     * <p>
     * Defaults to: "Group by this field"
     * 
     */
    public void setGroupByText(String value) {
        JsoHelper.setAttribute(jsObj, "groupByText", value);
    }

    /**
     * A string Template snippet, an array of strings (optionally followed by an
     * object containing Template methods) to be used to construct a Template,
     * or a Template instance.
     * <p>
     * 
     */
    public void setGroupHeaderTemplate(String value) {
        JsoHelper.setAttribute(jsObj, "groupHeaderTpl", value);
    }

    /**
     * A string Template snippet, an array of strings (optionally followed by an
     * object containing Template methods) to be used to construct a Template,
     * or a Template instance.
     * <p>
     * 
     */
    public void setGroupHeaderTemplate(Template value) {
        JsoHelper.setAttribute(jsObj, "groupHeaderTpl", value.getJsObj());
    }

    /**
     * True to hide the header that is currently grouped.
     * <p>
     * Defaults to: false
     * 
     */
    public void setHideGroupHeader(String value) {
        JsoHelper.setAttribute(jsObj, "hideGroupHeader", value);
    }

    /**
     * Text displayed in the grid header for enabling/disabling grouping.
     * <p>
     * Defaults to: "Show in groups"
     * 
     */
    public void setShowGroupsText(String value) {
        JsoHelper.setAttribute(jsObj, "showGroupsText", value);
    }

    /**
     * True to start all groups collapsed.
     * <p>
     * Defaults to: false
     * 
     */
    public void setStartCollapsed(boolean value) {
        JsoHelper.setAttribute(jsObj, "startCollapsed", value);
    }

    /**
     * Collapse a group
     * 
     * @param groupeName
     */
    public native void collapse(String groupeName)/*-{
		var jso = this.@com.ati.ext4j.client.core.JsObject::jsObj;
		jso.collapse(groupName);
    }-*/;

    /**
     * Collapse a group
     * 
     * @param groupeName
     */
    public native void collapse(String groupeName, boolean focus)/*-{
		var jso = this.@com.ati.ext4j.client.core.JsObject::jsObj;
		jso.collapse(groupName, focus);
    }-*/;

    /**
     * Collapse a group
     * 
     * @param groupeName
     */
    public native void collapse(ExtElement group)/*-{
		var jso = this.@com.ati.ext4j.client.core.JsObject::jsObj;
		jso.collapse(group.@com.ati.ext4j.client.core.JsObject::getJsObj()());
    }-*/;

    /**
     * Collapse a group
     * 
     * @param groupeName
     */
    public native void collapse(ExtElement groupe, boolean focus)/*-{
		var jso = this.@com.ati.ext4j.client.core.JsObject::jsObj;
		jso.collapse(group.@com.ati.ext4j.client.core.JsObject::getJsObj()(),
				focus);

    }-*/;

    /**
     * Collapse a group
     * 
     * @param groupeName
     */
    public native void collapseAll()/*-{
		var jso = this.@com.ati.ext4j.client.core.JsObject::jsObj;
		jso.collapseAll();
    }-*/;

    /**
     * Expand a group
     * 
     * @param groupeName
     */
    public native void expand(String groupeName)/*-{
		var jso = this.@com.ati.ext4j.client.core.JsObject::jsObj;
		jso.expand(groupName);
    }-*/;

    /**
     * Expand a group
     * 
     * @param groupeName
     */
    public native void expand(String groupeName, boolean focus)/*-{
		var jso = this.@com.ati.ext4j.client.core.JsObject::jsObj;
		jso.expand(groupName, focus);
    }-*/;

    /**
     * Expand a group
     * 
     * @param groupeName
     */
    public native void expand(ExtElement group)/*-{
		var jso = this.@com.ati.ext4j.client.core.JsObject::jsObj;
		jso.expand(group.@com.ati.ext4j.client.core.JsObject::getJsObj()());
    }-*/;

    /**
     * Expand a group
     * 
     * @param groupeName
     */
    public native void expand(ExtElement groupe, boolean focus)/*-{
		var jso = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		jso.expand(group.@com.ati.ext4j.client.core.JsObject::getJsObj()(),
				focus);

    }-*/;

    /**
     * Expand a group
     * 
     */
    public native void expandAll()/*-{
		var jso = this.@com.ati.ext4j.client.core.JsObject::jsObj;
		jso.collapseAll();
    }-*/;

    /**
     * Returns true if the named group is expanded.
     */
    public native boolean isExpanded(String group)/*-{
		var jso = this.@com.ati.ext4j.client.core.JsObject::jsObj;
		return jso.isExpanded(group);
    }-*/;

    private native JavaScriptObject createNativePeer()/*-{
		return new $wnd.Ext.grid.feature.Grouping();
    }-*/;

    public void addClickHandler(GroupInteractionHandler handler) {
        _addHandler(Event.GROUP_CLICK, handler);
    }

    public void addCollapseHandler(GroupInteractionHandler handler) {
        _addHandler(Event.GROUP_COLLAPSE, handler);
    }

    public void addContextMenuHandler(GroupInteractionHandler handler) {
        _addHandler(Event.GROUP_CONTEXT_MENU, handler);
    }

    public void addDoubleClickHandler(GroupInteractionHandler handler) {
        _addHandler(Event.GROUP_DOUBLE_CLICK, handler);
    }

    public native void addExpandHandler(GroupExpandHandler handler)/*-{
		var component = this.@com.ati.ext4j.client.core.JsObject::jsObj;
		if (component) {
			component
					.addListener(
							@com.ati.ext4j.client.events.Event::GROUP_EXPAND,
							$entry(function(v, node, group) {
								var view = @com.ati.ext4j.client.ui.DataView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(v);
								handler.@com.ati.ext4j.client.events.grid.GroupExpandHandler::onEvent(Lcom/ati/ext4j/client/ui/DataView;Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;)(view,node,group);
							}));
		}

    }-*/;

    private native void _addHandler(String event, GroupInteractionHandler handler)/*-{
		var component = this.@com.ati.ext4j.client.core.JsObject::jsObj;
		if (component) {
			component
					.addListener(
							event,
							$entry(function(v, node, group, e) {
								var view = @com.ati.ext4j.client.ui.DataView::new(Lcom/google/gwt/core/client/JavaScriptObject;)(v);
								var event = @com.ati.ext4j.client.core.EventObject::new(Lcom/google/gwt/core/client/JavaScriptObject;)(e);
								handler.@com.ati.ext4j.client.events.grid.GroupInteractionHandler::onEvent(Lcom/ati/ext4j/client/ui/DataView;Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Lcom/ati/ext4j/client/core/EventObject;)(view,node,group,event);
							}));
		}

    }-*/;
}
