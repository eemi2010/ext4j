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
package com.ait.ext4j.client.core.config;

import com.ait.ext4j.client.core.Component;
import com.ait.ext4j.client.core.JsoHelper;
import com.ait.ext4j.client.ui.ComponentFactory;

public class ToolTipConfig extends BaseConfig {

    public ToolTipConfig() {

    }

    public void setTrackMouse(boolean value) {
        JsoHelper.setAttribute(jsObj, "trackMouse", value);
    }

    public void setTitle(String value) {
        JsoHelper.setAttribute(jsObj, "title", value);
    }

    public void setShowDelay(int value) {
        JsoHelper.setAttribute(jsObj, "showDelay", value);
    }

    public void setStroke(String value) {
        JsoHelper.setAttribute(jsObj, "stroke", value);
    }

    public void setWidth(double value) {
        JsoHelper.setAttribute(jsObj, "width", value);
    }

    public void setHeight(double value) {
        JsoHelper.setAttribute(jsObj, "height", value);
    }

    /**
     * A single item, or an array of child Components to be added to this
     * container
     */
    public void setItems(Component... items) {
        JsoHelper.setAttribute(jsObj, "items", ComponentFactory.fromArray(items));
    }

}
