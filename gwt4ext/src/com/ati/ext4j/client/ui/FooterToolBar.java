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
package com.ati.ext4j.client.ui;

import com.ati.ext4j.client.core.Component;
import com.ati.ext4j.client.core.SimpleComponent;
import com.ati.ext4j.client.core.config.Dock;
import com.google.gwt.core.client.JavaScriptObject;

public class FooterToolBar extends ToolBar {

    protected FooterToolBar() {
        super();
        setDocked(Dock.BOTTOM);
        this.add(new SimpleComponent());
    }

    protected FooterToolBar(JavaScriptObject obj) {
        super(obj);
    }

    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		config.ui = 'footer';
		config.weight = -1;
		return new $wnd.Ext.toolbar.Toolbar(config);
    }-*/;

    /**
     * Creates a new FooterToolBar from the given component
     * 
     * @param component
     *            , the component to cast from
     * @return, a new FooterToolBar from the component
     * 
     */
    public static FooterToolBar cast(Component component) {
        return new FooterToolBar(component.getOrCreateJsObj());
    }
}
