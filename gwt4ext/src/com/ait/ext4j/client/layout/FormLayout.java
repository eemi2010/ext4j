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
 * This is a layout that will render form Fields, one under the other all
 * stretched to the Container width.
 */
public class FormLayout extends AutoLayout {

    public FormLayout() {
    }

    protected FormLayout(JavaScriptObject obj) {
        jsObj = obj;
    }

    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return {
			type : 'form'
		};
    }-*/;

    @Override
    protected native void create() /*-{
		var jso = {
			type : 'form'
		};
		this.@com.ait.ext4j.client.layout.ContainerLayout::jsObj = jso;
    }-*/;

    public static FormLayout cast(ContainerLayout layout) {
        return new FormLayout(layout.getJsObj());
    }

}
