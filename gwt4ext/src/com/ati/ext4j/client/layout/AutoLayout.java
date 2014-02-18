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
package com.ati.ext4j.client.layout;

import com.ati.ext4j.client.ui.Container;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * The AutoLayout is the default layout manager delegated by {@link Container}
 * to render any child Components when no layout is configured into a Container.
 * AutoLayout provides only a passthrough of any layout calls to any child
 * containers.
 */
public class AutoLayout extends ContainerLayout {

    public AutoLayout() {
    }

    protected AutoLayout(JavaScriptObject obj) {
        jsObj = obj;
    }

    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return {
			type : 'auto'
		};
		z
    }-*/;

    @Override
    protected native void create() /*-{
		var jso = {
			type : 'auto'
		};
		this.@com.ati.ext4j.client.layout.ContainerLayout::jsObj = jso;
    }-*/;

    public static AutoLayout cast(ContainerLayout layout) {
        return new AutoLayout(layout.getJsObj());
    }
}
