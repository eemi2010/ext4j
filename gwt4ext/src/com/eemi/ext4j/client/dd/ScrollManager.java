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
package com.eemi.ext4j.client.dd;

import com.google.gwt.user.client.Element;

/**
 * Provides automatic scrolling of overflow regions in the page during drag
 * operations.
 * 
 */
public class ScrollManager {

    /**
     * Manually trigger a cache refresh.
     */
    public static native void refreshCache()/*-{
		$wnd.Ext.dd.ScrollManager.refreshCache();
    }-*/;

    /**
     * Registers a new overflow element to auto scroll.
     * 
     * @param elementID
     *            the element ID
     */
    public static native void register(String elementID)/*-{
		$wnd.Ext.dd.ScrollManager.register(elementID);
    }-*/;

    /**
     * Registers a new overflow element to auto scroll.
     * 
     * @param element
     *            the element
     */
    public static native void register(Element element)/*-{
		$wnd.Ext.dd.ScrollManager.register(element);
    }-*/;

    /**
     * Unregisters an overflow element so it are no longer scrolled.
     * 
     * @param elementID
     *            the lement ID
     */
    public static native void unregister(String elementID)/*-{
		$wnd.Ext.dd.ScrollManager.unregister(elementID);
    }-*/;

    /**
     * Unregisters an overflow element so it are no longer scrolled.
     * 
     * @param element
     *            the element
     */
    public static native void unregister(Element element)/*-{
		$wnd.Ext.dd.ScrollManager.unregister(element);
    }-*/;

}
