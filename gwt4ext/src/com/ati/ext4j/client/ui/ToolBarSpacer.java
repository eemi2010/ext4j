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
package com.ati.ext4j.client.ui;

import com.ati.ext4j.client.core.Component;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * A simple element that adds extra horizontal space between items in a toolbar.
 * By default a 2px wide space is added via CSS specification
 * 
 */
public class ToolBarSpacer extends Component {

    private static JavaScriptObject configPrototype;

    private native void init()/*-{
		var c = new $wnd.Ext.toolbar.Spacer();
		@com.ati.ext4j.client.ui.ToolBarSpacer::configPrototype = c.initialConfig;
    }-*/;

    protected JavaScriptObject getConfigPrototype() {
        return configPrototype;
    }

    public ToolBarSpacer() {
        init();
        setFlex(1);
    }

    public ToolBarSpacer(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public ToolBarSpacer(int flex) {
        this();
        setFlex(flex);
    }

    public String getXType() {
        return "tbspacer";
    }

    @Override
    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.toolbar.Spacer(config);
    }-*/;

    public static ToolBarSpacer cast(Component component) {
        return new ToolBarSpacer(component.getOrCreateJsObj());
    }

}
