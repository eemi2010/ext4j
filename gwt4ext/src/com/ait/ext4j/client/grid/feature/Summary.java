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
package com.ait.ext4j.client.grid.feature;

import com.ait.ext4j.client.core.JsoHelper;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * This feature is used to place a summary row at the bottom of the grid. If
 * using a grouping, see {@link GroupingSummary}.
 * 
 * @author alainekambi
 * 
 */
public class Summary extends Feature {

    public Summary() {
        jsObj = createNativePeer();
    }

    /**
     * True to show the summary row.
     * <p>
     * Defaults to: true
     * 
     */
    public void setShowSummaryRow(String value) {
        JsoHelper.setAttribute(jsObj, "showSummaryRow", value);
    }

    /**
     * Toggle whether or not to show the summary row.
     * 
     */
    public native void toggleSummaryRow(boolean visible)/*-{
		var jso = this.@com.ait.ext4j.client.core.JsObject::jsObj;
		jso.toggleSummaryRow(visible);
    }-*/;

    private native JavaScriptObject createNativePeer()/*-{
		return new $wnd.Ext.grid.feature.Summary();
    }-*/;

}
