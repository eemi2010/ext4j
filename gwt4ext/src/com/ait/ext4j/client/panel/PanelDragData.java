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
package com.ait.ext4j.client.panel;

import com.ait.ext4j.client.dd.DragData;
import com.ait.ext4j.client.ui.ComponentFactory;
import com.ait.ext4j.client.ui.Panel;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * An implementation of DragData that is passed to the drop target when the
 * source is a NotificationContainer.
 * 
 */
public class PanelDragData extends DragData {

    public PanelDragData(JavaScriptObject jsObj) {
        super(jsObj);
    }

    /**
     * The source NotificationContainer.
     * 
     * @return the source NotificationContainer
     */
    public Panel getPanel() {
        JavaScriptObject gridJS = getPropertyAsJavaScriptObject("panel");
        return (Panel) ComponentFactory.getComponent(gridJS);
    }

}