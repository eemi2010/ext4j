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
package com.ait.ext4j.client.grid;

import com.ait.ext4j.client.core.JsoHelper;
import com.ait.ext4j.client.core.config.BaseConfig;

/**
 * A config object to be used when configuring the scroll monitor to control
 * refreshing of data in an "infinite grid".
 * <p>
 * Configurations of this object allow fine tuning of data caching which can
 * improve performance and usability of the infinite grid.
 * 
 */
public class VerticalScroller extends BaseConfig {

    public VerticalScroller() {
        jsObj = JsoHelper.createObject();
    }

    public VerticalScroller(int trailingBufferZone, int leadingBufferZone) {
        this();
        setTrailingBufferZone(trailingBufferZone);
        setLeadingBufferZone(leadingBufferZone);
    }

    public void setTrailingBufferZone(int value) {
        JsoHelper.setAttribute(jsObj, "trailingBufferZone", value);
    }

    public void setLeadingBufferZone(int value) {
        JsoHelper.setAttribute(jsObj, "leadingBufferZone", value);
    }
}
