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
package com.eemi.ext4j.client.events.panel;

import com.eemi.ext4j.client.core.EventObject;
import com.eemi.ext4j.client.events.Event;
import com.eemi.ext4j.client.ui.Panel;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class TitleChangeEvent extends EventObject {

    public static String EVENT_NAME = Event.TITLE_CHANGE;

    private Panel source;
    private String newTitle;
    private String oldTitle;

    /**
     * UiBinder implementations
     */
    private static Type<TitleChangeHandler> TYPE = new Type<TitleChangeHandler>(EVENT_NAME, null);

    public static Type<TitleChangeHandler> getType() {
        return TYPE;
    }

    public static Type<TitleChangeHandler> getAssociatedType() {
        return TYPE;
    }

    public TitleChangeEvent(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public TitleChangeEvent(Panel source, String newTitle, String oldTitle, JavaScriptObject nativeEvent) {
        super(nativeEvent);
        this.source = source;
        this.newTitle = newTitle;
        this.oldTitle = oldTitle;
    }

    /**
     * @return the source
     */
    public Panel getSource() {
        return source;
    }

    /**
     * @return the new title
     */
    public String getNewTitle() {
        return newTitle;
    }

    /**
     * @return the old title
     */
    public String getOldTitle() {
        return oldTitle;
    }

}
