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

import com.eemi.ext4j.client.core.JsoHelper;

/**
 * 
 */
public class DropTargetConfig extends DragDropConfig {
    /**
     * A named drag drop group to which this object belongs. If a group is
     * specified, then this object will only interact with other drag drop
     * objects in the same group (defaults to undefined).
     * 
     * @param ddGroup
     *            the group name
     */
    public void setdDdGroup(String ddGroup) {
        JsoHelper.setAttribute(jsObj, "ddGroup", ddGroup);
    }

    /**
     * The CSS class returned to the drag source when drop is allowed (defaults
     * to "x-dd-drop-ok").
     * 
     * @param dropAllowed
     *            drop allowed CSS
     */
    public void setDropAllowed(String dropAllowed) {
        JsoHelper.setAttribute(jsObj, "dropAllowed", dropAllowed);
    }

    /**
     * The CSS class returned to the drag source when drop is not allowed
     * (defaults to "x-dd-drop-nodrop").
     * 
     * @param dropNotAllowed
     *            drop not allowed CSS
     */
    public void setDropNotAllowed(String dropNotAllowed) {
        JsoHelper.setAttribute(jsObj, "dropNotAllowed", dropNotAllowed);
    }

    /**
     * The CSS class applied to the drop target element while the drag source is
     * over it (defaults to "").
     * 
     * @param overClass
     *            the over class
     */
    public void setOverClass(String overClass) {
        JsoHelper.setAttribute(jsObj, "overClass", overClass);
    }

}
