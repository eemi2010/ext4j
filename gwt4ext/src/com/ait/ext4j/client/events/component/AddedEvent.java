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
package com.ait.ext4j.client.events.component;

import com.ait.ext4j.client.core.Component;
import com.ait.ext4j.client.core.EventObject;
import com.ait.ext4j.client.events.Event;
import com.ait.ext4j.client.ui.Container;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class AddedEvent extends EventObject {

    public static String EVENT_NAME = Event.ADDED;

    private Component source;
    private Container container;
    private int position;

    /**
     * UiBinder implementations
     */
    private static Type<AddedHandler> TYPE = new Type<AddedHandler>(EVENT_NAME, null);

    public static Type<AddedHandler> getType() {
        return TYPE;
    }

    public static Type<AddedHandler> getAssociatedType() {
        return TYPE;
    }

    public AddedEvent(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public AddedEvent(Component source, Container container, int position, JavaScriptObject nativeEvent) {
        super(nativeEvent);
        this.source = source;
        this.container = container;
        this.position = position;
    }

    /**
     * @return the source
     */
    public Component getSource() {
        return source;
    }

    /**
     * @return the container
     */
    public Container getContainer() {
        return container;
    }

    /**
     * @return the position
     */
    public int getPosition() {
        return position;
    }

}
