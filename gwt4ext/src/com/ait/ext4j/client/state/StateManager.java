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
package com.ait.ext4j.client.state;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * This is the global state manager. By default all components that are
 * "state aware" check this class for state information if you don't pass them a
 * custom state provider. In order for this class to be useful, it must be
 * initialized with a provider when your application initializes.
 * 
 */
public class StateManager {

    private StateManager() {

    }

    /**
     * Configures the default state provider for your application.
     * 
     * @param provider
     *            the provider
     */
    public static void setProvider(Provider provider) {
        setProvider(provider.getJsObj());
    }

    private static native void setProvider(JavaScriptObject jsObj) /*-{
		$wnd.Ext.state.Manager.setProvider(jsObj);
    }-*/;

    public static native JavaScriptObject get(String key)/*-{
		var obj = $wnd.Ext.state.Manager.get(key);
		$wnd.console.log("trying to get state for key : " + key);
		$wnd.console.log(obj);
		return obj;
    }-*/;

}
