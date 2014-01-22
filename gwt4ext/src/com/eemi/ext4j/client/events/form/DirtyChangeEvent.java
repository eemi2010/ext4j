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
package com.eemi.ext4j.client.events.form;

import com.eemi.ext4j.client.core.EventObject;
import com.eemi.ext4j.client.events.Event;
import com.eemi.ext4j.client.field.FieldBase;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class DirtyChangeEvent extends EventObject {

    public static String EVENT_NAME = Event.DIRTY_CHANGE;

    private FieldBase source;
    private boolean dirty;

    /**
     * UiBinder implementations
     */
    private static Type<DirtyChangeHandler> TYPE = new Type<DirtyChangeHandler>(EVENT_NAME, null);

    public static Type<DirtyChangeHandler> getType() {
        return TYPE;
    }

    public static Type<DirtyChangeHandler> getAssociatedType() {
        return TYPE;
    }

    public DirtyChangeEvent(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public DirtyChangeEvent(FieldBase source, boolean dirty, JavaScriptObject nativeEvent) {
        super(nativeEvent);
        this.source = source;
        this.dirty = dirty;
    }

    /**
     * @return the source
     */
    public FieldBase getSource() {
        return source;
    }

    /**
     * @return the dirty field
     */
    public boolean isDirty() {
        return dirty;
    }

}
