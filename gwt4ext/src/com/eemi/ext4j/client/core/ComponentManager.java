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
package com.eemi.ext4j.client.core;

import com.google.gwt.dom.client.Element;

/**
 * Component manager.
 * 
 */
public class ComponentManager {

    /**
     * Registers a function that will be called when a specified component is
     * added to ComponentManager.
     * 
     * @param id
     *            the component ID
     * @param fn
     *            the function to execute
     */
    public native void onAvailable(String id, Function fn)/*-{
		$wnd.Ext.ComponentManager.onAvailable(id, function() {
			fn.@com.eemi.ext4j.client.core.Function::execute()();
		});

    }-*/;

    /**
     * Returns a component by id.
     * 
     * @param id
     *            the component ID
     * @return the component or null if not found
     */
    public static native Component getComponent(String id) /*-{
		var comp = $wnd.Ext.ComponentManager.get(id);
		return comp == null || comp === undefined ? null
				: @com.eemi.ext4j.client.ui.ComponentFactory::getComponent(Lcom/google/gwt/core/client/JavaScriptObject;)(comp);
    }-*/;

    /**
     * Returns a component that the passed element represents.
     * 
     * @param element
     *            the element
     * @return the component or null if not found
     */
    public static Component getComponent(Element element) {
        return getComponent(DomUtil.getID(element));
    }

    /**
     * Returns a component that the passed element represents.
     * 
     * @param element
     *            the element
     * @return the component or null if not found
     */
    public static Component getComponent(ExtElement element) {
        return getComponent(element.getDom());
    }
}
