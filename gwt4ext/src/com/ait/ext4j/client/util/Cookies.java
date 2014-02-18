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
package com.ait.ext4j.client.util;

/**
 * Utility class for setting/reading values from browser cookies. Values can be
 * written using the set method. Values can be read using the get method. A
 * cookie can be invalidated on the client machine using the clear method.
 * 
 * @author alainekambi
 * 
 */
public class Cookies {

    private Cookies() {

    }

    /**
     * Removes a cookie with the provided name from the browser if found by
     * setting its expiration date to sometime in the past.
     * 
     * @param name
     *            , The name of the cookie to remove
     */
    public static native void clear(String name)/*-{
		$wnd.Ext.util.Cookies.clear(name);
    }-*/;

    /**
     * Removes a cookie with the provided name from the browser if found by
     * setting its expiration date to sometime in the past.
     * 
     * @param name
     *            , The name of the cookie to remove
     * @param path
     *            , The path for the cookie. This must be included if you
     *            included a path while setting the cookie.
     */
    public static native void clear(String name, String path)/*-{
		$wnd.Ext.util.Cookies.clear(name, path);
    }-*/;

    /**
     * Returns the cookie value for the specified name; null if the cookie name
     * does not exist.
     * 
     * @param name
     * @return
     */
    public static native String get(String name)/*-{
		$wnd.Ext.util.Cookies.get(name);
    }-*/;

    /**
     * Creates a cookie with the specified name and value. Additional settings
     * for the cookie may be optionally specified (for example: expiration,
     * access restriction, SSL).
     */
    public static native String set(String name, String value)/*-{
		$wnd.Ext.util.Cookies.set(name, value);
    }-*/;

    /**
     * Creates a cookie with the specified name and value. Additional settings
     * for the cookie may be optionally specified (for example: expiration,
     * access restriction, SSL).
     */
    public static native String set(String name, String value, String path)/*-{
		$wnd.Ext.util.Cookies.set(name, value, path);
    }-*/;

    /**
     * Creates a cookie with the specified name and value. Additional settings
     * for the cookie may be optionally specified (for example: expiration,
     * access restriction, SSL).
     */
    public static native String set(String name, String value, String path, String domain)/*-{
		$wnd.Ext.util.Cookies.set(name, value, path, domain);
    }-*/;

    /**
     * Creates a cookie with the specified name and value. Additional settings
     * for the cookie may be optionally specified (for example: expiration,
     * access restriction, SSL).
     */
    public static native String set(String name, String value, String path, String domain, boolean secure)/*-{
		$wnd.Ext.util.Cookies.set(name, value, path, domain, secure);
    }-*/;

}
