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
package com.ati.ext4j.client.core;

import com.ati.ext4j.client.core.handlers.WindowResizeHandler;

/**
 * Registers event handlers that want to receive a normalized EventObject
 * instead of the standard browser event and provides several useful events
 * directly.
 * <p>
 * See {@link EventObject} for more details on normalized event objects.
 * 
 */
public class ExtEventManager {

    private ExtEventManager() {

    }

    /**
     * Adds a listener to be notified when the browser window is resized and
     * provides resize event buffering (100 milliseconds), passes new viewport
     * width and height to handlers.
     * 
     * @param handler
     *            , The handler function the window resize event invokes.
     */
    public static native void addWindowResizeHandler(WindowResizeHandler handler)/*-{
		$wnd.Ext.EventManager
				.onWindowResize(function(w, h) {
					var event = @com.ati.ext4j.client.events.WindowResizeEvent::new(II)(w,h);
					handler.@com.ati.ext4j.client.core.handlers.WindowResizeHandler::onWindowResize(Lcom/ati/ext4j/client/events/WindowResizeEvent;)(event);
				});
    }-*/;

}
