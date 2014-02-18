/**
 * Ext4j UI Library Copyright 2014, Alain Ekambi, and individual contributors as
 * indicated by the @authors tag. See the copyright.txt in the distribution for
 * a full listing of individual contributors.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.ati.ext4j.client.util;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.HeadElement;
import com.google.gwt.dom.client.LinkElement;

/**
 * Utility class for manipulating CSS rules.<br/>
 * It's important to note that Internet Explorer has a limitation of 31 styles. <br/>
 * http://support.microsoft.com/kb/262161
 * 
 */
public class CSS {

    private static HeadElement head;

    private CSS() {

    }

    /**
     * Very simple dynamic creation of stylesheets from a text blob of rules.
     * The text will wrapped in a style tag and appended to the HEAD of the
     * document.
     * 
     * @param cssText
     *            the text containing the css rules
     * @param id
     *            an id to add to the stylesheet for later removal
     */
    public static native void createStyleSheet(String cssText, String id)/*-{
		$wnd.Ext.util.CSS.createStyleSheet(cssText, id);
    }-*/;

    /**
     * /** Injects the css url code into a
     * {@code <link rel="stylesheet" href="...." />} element in the document
     * header.
     * 
     * @param href
     *            , url of the href to inject
     */
    public static void injectStyleSheet(String href) {
        HeadElement head = getHead();
        LinkElement element = createLinkElement();
        element.setHref(href);
        head.appendChild(element);
    }

    /**
     * Gets an an individual CSS rule by selector(s).
     * 
     * @param selector
     *            the CSS selector or an array of selectors to try. The first
     *            selector that is found is returned
     * @param refreshCache
     *            true to refresh the internal cache if you have recently
     *            updated any rules or added styles dynamically
     * @return the CSS rule or null if one is not found
     */
    public static native CSSRule getRule(String selector, boolean refreshCache)/*-{
		var rule = $wnd.Ext.util.CSS.getRule(selector, refreshCache);
		if (rule == null || rule === undefined) {
			return null;
		} else {
			return @com.ati.ext4j.client.util.CSSRule::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(rule);
		}
    }-*/;

    // todo getRules

    /**
     * Refresh the rule cache if you have dynamically added stylesheets.
     */
    public static native void refreshCache()/*-{
		$wnd.Ext.util.CSS.refreshCache();
    }-*/;

    /**
     * Removes a style or link tag by id
     * 
     * @param id
     *            stylesheet id
     */
    public static native void removeStyleSheet(String id)/*-{
		$wnd.Ext.util.CSS.removeStyleSheet(id);
    }-*/;

    /**
     * Dynamically swaps an existing stylesheet reference for a new one.
     * 
     * @param id
     *            the id of an existing link tag to remove
     * @param url
     *            the href of the new stylesheet to include
     */
    public static native void swapStyleSheet(String id, String url)/*-{
		$wnd.Ext.util.CSS.swapStyleSheet(id, url);
    }-*/;

    /**
     * Updates a rule property.
     * 
     * @param selector
     *            the seelctor. Stops immediately once one is found.
     * @param property
     *            the css property
     * @param value
     *            the new value for the property
     */
    public static native void updateRule(String selector, String property, String value)/*-{
		$wnd.Ext.util.CSS.updateRule(selector, property, value);
    }-*/;

    private static HeadElement getHead() {
        if (head == null) {
            Element element = Document.get().getElementsByTagName("head").getItem(0);
            assert element != null : "HTML Head element required";
            head = HeadElement.as(element);
        }
        return head;
    }

    private static LinkElement createLinkElement() {
        LinkElement link = Document.get().createLinkElement();
        link.setRel("stylesheet");
        link.setType("text/css");
        return link;

    }
}
