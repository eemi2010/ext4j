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
package com.ati.ext4j.client.menu;

import com.ati.ext4j.client.core.Component;

/**
 * Provides a common registry of all menus on a page.
 * 
 */
public class MenuManager {

    private MenuManager() {

    }

    public static native void register(Component component)/*-{
		$wnd.Ext.menu.Manager
				.register(component.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()());
    }-*/;

    /**
     * Hides all menus that are currently visible
     * 
     * @return, success True if any active menus were hidden.
     */
    public static native boolean hideAll()/*-{
		return $wnd.Ext.menu.Manager.hideAll();
    }-*/;

}
