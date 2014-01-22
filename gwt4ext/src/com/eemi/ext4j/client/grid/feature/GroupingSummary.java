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
package com.eemi.ext4j.client.grid.feature;

import com.eemi.ext4j.client.core.JsoHelper;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * This feature adds an aggregate summary row at the bottom of each group that
 * is provided by the {@link Grouping} feature.
 * 
 * @author alainekambi
 * 
 */
public class GroupingSummary extends Grouping {

    public GroupingSummary() {
        jsObj = createNativePeer();
    }

    /**
     * The name of the property which contains the Array of summary objects. It
     * allows to use server-side calculated summaries.
     * 
     */
    public void setRemoteRoot(String value) {
        JsoHelper.setAttribute(jsObj, "remoteRoot", value);
    }

    private native JavaScriptObject createNativePeer()/*-{
		return new $wnd.Ext.grid.feature.GroupingSummary();
    }-*/;

}
