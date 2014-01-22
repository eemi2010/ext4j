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
package com.eemi.ext4j.client.events.button;

import com.eemi.ext4j.client.core.EventObject;
import com.eemi.ext4j.client.events.Event;
import com.eemi.ext4j.client.ui.Button;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class GlyphChangeEvent extends EventObject {

    public static String EVENT_NAME = Event.GLYPH_CHANGE;

    private Button source;
    private String oldGlyph;
    private String newGlyph;

    /**
     * UiBinder implementations
     */
    private static Type<GlyphChangeHandler> TYPE = new Type<GlyphChangeHandler>(EVENT_NAME, null);

    public static Type<GlyphChangeHandler> getType() {
        return TYPE;
    }

    public static Type<GlyphChangeHandler> getAssociatedType() {
        return TYPE;
    }

    public GlyphChangeEvent(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public GlyphChangeEvent(Button source, String oldGlyph, String newGlyph, JavaScriptObject nativeEvent) {
        super(nativeEvent);
        this.source = source;
        this.oldGlyph = oldGlyph;
        this.newGlyph = newGlyph;
    }

    /**
     * @return the source
     */
    public Button getSource() {
        return source;
    }

    /**
     * @return the oldGlyph
     */
    public String getOldGlyph() {
        return oldGlyph;
    }

    /**
     * @return the newGlyph
     */
    public String getNewGlyph() {
        return newGlyph;
    }

}
