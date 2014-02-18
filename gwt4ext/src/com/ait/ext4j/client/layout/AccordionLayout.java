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
package com.ait.ext4j.client.layout;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * <p>
 * This is a base class for layouts that contain a single item that
 * automatically expands to fill the layout's container.
 * </p>
 * 
 * <p>
 * FitLayout does not have any direct config options (other than inherited
 * ones). To fit a panel to a container using FitLayout, simply set layout to
 * FitLayout on the container and add a single panel to it. If the container has
 * multiple panels, only the first one will be displayed.
 * </p>
 */
public class AccordionLayout extends ContainerLayout {

    public AccordionLayout() {
    }

    protected AccordionLayout(JavaScriptObject obj) {
        jsObj = obj;
    }

    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return {
			type : 'accordion'
		};
    }-*/;

    @Override
    protected native void create() /*-{
		var jso = {
			type : 'accordion'
		};
		this.@com.ait.ext4j.client.layout.ContainerLayout::jsObj = jso;
    }-*/;

    public static AccordionLayout cast(ContainerLayout layout) {
        return new AccordionLayout(layout.getJsObj());
    }
}
