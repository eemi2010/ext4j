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
package com.ait.ext4j.client.connection;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * A singleton instance of an Ext.data.Connection. This class is used to
 * communicate with your server side code.
 * 
 */
public class Ajax extends Connection {

    private static Ajax instance;

    private Ajax(JavaScriptObject jsObj) {
        this.jsObj = jsObj;
    }

    public static Ajax get() {
        if (instance == null) {
            instance = new Ajax(getSingleton());

        }
        return instance;
    }

    private static native JavaScriptObject getSingleton() /*-{
		return $wnd.Ext.Ajax;
    }-*/;

}
