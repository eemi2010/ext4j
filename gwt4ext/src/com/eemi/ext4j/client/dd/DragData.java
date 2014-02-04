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
package com.eemi.ext4j.client.dd;

import com.eemi.ext4j.client.core.JsObject;
import com.eemi.ext4j.client.core.JsoHelper;
import com.eemi.ext4j.client.panel.PanelDragData;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;

/**
 * Base DragData class that is passed to the drop target when the source is
 * draggable.
 */
public class DragData extends JsObject {

    protected DragData(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public int getPropertyAsInt(String property) {
        return JsoHelper.getAttributeAsInt(jsObj, property);
    }

    public boolean getPropertyAsBoolean(String property) {
        return JsoHelper.getAttributeAsBoolean(jsObj, property);
    }

    public String getProperty(String property) {
        return JsoHelper.getAttribute(jsObj, property);
    }

    public JavaScriptObject getPropertyAsJavaScriptObject(String property) {
        return JsoHelper.getAttributeAsJavaScriptObject(jsObj, property);
    }

    public Element getPropertyAsElement(String property) {
        return JsoHelper.getAttributeAsElement(jsObj, property);
    }

    /**
     * Retrun the DragDrop element. ie the Element displayed when the source is
     * being dragged.
     * 
     * @return the element being droppped
     */
    public Element getDDEl() {
        return getPropertyAsElement("ddel");
    }

    @SuppressWarnings("unused")
    private static DragData instance(JavaScriptObject jsObj) {
        if (JsoHelper.getAttributeAsJavaScriptObject(jsObj, "panel") != null) {
            return new PanelDragData(jsObj);
        }
        return new DragData(jsObj);
    }
}
