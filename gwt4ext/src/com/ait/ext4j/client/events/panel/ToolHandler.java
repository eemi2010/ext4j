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
package com.ait.ext4j.client.events.panel;

import com.ait.ext4j.client.core.EventObject;
import com.ait.ext4j.client.core.ExtElement;
import com.ait.ext4j.client.core.handlers.AbstractHandler;
import com.ait.ext4j.client.ui.PanelHeader;
import com.ait.ext4j.client.ui.Tool;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * A base handler to use for when the tool is clicked.
 * 
 * @author alainekambi
 * 
 */
public abstract class ToolHandler extends AbstractHandler {

    final JavaScriptObject jsoPeer = createPeer(this);

    private static native JavaScriptObject createPeer(ToolHandler listener) /*-{
		return function(e, el, o, t) {
			var eventObject = @com.ait.ext4j.client.core.EventObject::new(Lcom/google/gwt/core/client/JavaScriptObject;)(e);
			var extElement = @com.ait.ext4j.client.core.ExtElement::new(Lcom/google/gwt/core/client/JavaScriptObject;)(el);
			var header = @com.ait.ext4j.client.ui.PanelHeader::new(Lcom/google/gwt/core/client/JavaScriptObject;)(o);
			var tool = @com.ait.ext4j.client.ui.Tool::new(Lcom/google/gwt/core/client/JavaScriptObject;)(o);
			listener.@com.ait.ext4j.client.events.panel.ToolHandler::onClick(Lcom/ait/ext4j/client/core/EventObject;Lcom/ait/ext4j/client/core/ExtElement;Lcom/ait/ext4j/client/ui/PanelHeader;Lcom/ait/ext4j/client/ui/Tool;)(eventObject,extElement,header,tool);
		};
    }-*/;

    // Called from JSNI
    private final void fireOnEvent(EventObject event, ExtElement el, PanelHeader header, Tool tool) {
        UncaughtExceptionHandler handler = GWT.getUncaughtExceptionHandler();
        if (handler != null) {
            fireOnEventAndCatch(event, el, header, tool, handler);
        } else {
            onClick(event, el, header, tool);
        }
    }

    private void fireOnEventAndCatch(EventObject event, ExtElement el, PanelHeader header, Tool tool,
                    UncaughtExceptionHandler handler) {
        try {
            onClick(event, el, header, tool);
        } catch (Throwable e) {
            handler.onUncaughtException(e);
        }
    }

    @Override
    public JavaScriptObject getJsoPeer() {
        return jsoPeer;
    }

    public abstract void onClick(EventObject event, ExtElement el, PanelHeader header, Tool tool);
}
