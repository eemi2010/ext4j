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
package com.eemi.ext4j.client.core;

import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;

/**
 * DOM related helper methods.
 * 
 */
public class DomUtil {

    public static String getID(Widget widget) {
        return getID(widget.getElement());
    }

    public static String getID(Element element) {
        String id = element.getPropertyString("id");
        return id == null || id.equals("") ? null : id;

    }

    public static void setID(Widget widget, String id) {
        setID(widget.getElement(), id);
    }

    public static void setID(Element element, String id) {
        element.setPropertyString("id", id);
    }

}
