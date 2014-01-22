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
package com.eemi.ext4j.client.ui;

import java.util.ArrayList;
import java.util.List;

import com.eemi.ext4j.client.core.Component;
import com.eemi.ext4j.client.core.JsoHelper;
import com.eemi.ext4j.client.core.config.XType;
import com.eemi.ext4j.client.events.HandlerRegistration;
import com.eemi.ext4j.client.events.panel.ToolClickHandler;
import com.eemi.ext4j.client.events.panel.ToolHandler;
import com.eemi.ext4j.client.tip.Tip;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * This class is used to display small visual icons in the header of a panel.
 * There are a set of 25 icons that can be specified by using the type config.
 * The handler config can be used to provide a function that will respond to any
 * click events. In general, this class will not be instantiated directly,
 * rather it will be created by specifying the Ext.panel.Panel.tools
 * configuration on the NotificationContainer itself.
 * 
 */
public class Tool extends Component {

    private static JavaScriptObject configPrototype;

    public static final String CLOSE = "close";
    public static final String MINIMIZE = "minimize";
    public static final String MAXIMIZE = "maximize";
    public static final String RESTORE = "restore";
    public static final String TOGGLE = "toggle";
    public static final String GEAR = "gear";
    public static final String PREV = "prev";
    public static final String NEXT = "next";
    public static final String PIN = "pin";
    public static final String UNPIN = "unpin";
    public static final String RIGHT = "right";
    public static final String LEFT = "left";
    public static final String DOWN = "down";
    public static final String UP = "up";
    public static final String REFRESH = "refresh";
    public static final String PLUS = "plus";
    public static final String MINUS = "minus";
    public static final String SEARCH = "search";
    public static final String SAVE = "save";
    public static final String HELP = "help";
    public static final String PRINT = "print";
    public static final String EXPAND = "expand";
    public static final String COLLAPSE = "collapse";

    protected JavaScriptObject getConfigPrototype() {
        return configPrototype;
    }

    public String getXType() {
        return XType.TOOL.getValue();
    }

    /**
     * Create a new NotificationContainer.
     */
    public Tool() {
        this.setTooltipType("title");
    }

    protected Tool(JavaScriptObject obj) {
        super(obj);
    }

    public Tool(String type) {
        this();
        setType(type);
    }

    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.panel.Tool(config);
    }-*/;

    /**
     * The type of tool to render.
     * 
     * @param value
     *            , the value of tool to render
     */
    public void setType(String value) {
        setAttribute("type", value, true);
    }

    /**
     * Specify as false to allow click event to propagate.
     * 
     * Defaults to: true
     * 
     * @param value
     *            , the value of stopevent
     */
    public void setStopEvent(boolean value) {
        setAttribute("stopEvent", value, true);
    }

    /**
     * The tooltip for the tool
     * 
     * @param value
     *            , the value of tooltip
     */
    public void setTooltip(String value) {
        setAttribute("tooltip", value, true);
    }

    /**
     * The tooltip for the tool
     * 
     * @param value
     *            , the value of tooltip
     */
    public void setTooltipType(String value) {
        setAttribute("tooltipType", value, true);
    }

    /**
     * The tooltip for the tool
     * 
     * @param value
     *            , the value of tooltip
     */
    public void setTooltip(Tip value) {
        setAttribute("tooltip", value.getOrCreateJsObj(), true);
    }

    /**
     * A handler to execute when the tool is clicked.
     * 
     */
    public void setHandler(ToolHandler handler) {
        setAttribute("handler", handler.getJsoPeer(), true);
    }

    /**
     * Fires when a tool is clicked.
     */
    public native HandlerRegistration addToolClickHandler(ToolClickHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(t, e) {
			var tool = @com.eemi.ext4j.client.ui.Tool::new(Lcom/google/gwt/core/client/JavaScriptObject;)(p);
			var event = @com.eemi.ext4j.client.events.panel.ToolClickEvent::new(Lcom/eemi/ext4j/client/ui/Tool;Lcom/google/gwt/core/client/JavaScriptObject;)(tool,e);
			handler.@com.eemi.ext4j.client.events.panel.ToolClickHandler::onToolClick(Lcom/eemi/ext4j/client/events/panel/ToolClickEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.panel.ToolClickEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * Creates a new Tool from the given component
     * 
     * @param component
     *            , the component to cast from
     * @return, a new tool from the component
     * 
     */
    public static Tool cast(Component component) {
        return new Tool(component.getOrCreateJsObj());
    }

    private static List<Tool> fromJsArray(JavaScriptObject peers) {
        List<Tool> toReturn = new ArrayList<Tool>();
        int size = JsoHelper.getArrayLength(peers);
        for (int i = 0; i < size; i++) {
            toReturn.add(new Tool(JsoHelper.getArrayValue(peers, i)));
        }
        return toReturn;
    }

}
