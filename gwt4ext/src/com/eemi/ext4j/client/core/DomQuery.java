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

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;

/**
 * Provides high performance selector/xpath processing by compiling queries into
 * reusable functions. New pseudo classes and matchers can be plugged. It works
 * on HTML and XML documents (if a content node is passed in).
 * <p>
 * DomQuery supports most of the <a
 * href="http://www.w3.org/TR/2005/WD-css3-selectors-20051215/">CSS3 selectors
 * spec</a>, along with some custom selectors and basic XPath.
 * </p>
 * <p/>
 * <p>
 * All selectors, attribute filters and pseudos below can be combined infinitely
 * in any order. For example "div.foo:nth-child(odd)[@foo=bar].bar:first" would
 * be a perfectly valid selector. Node filters are processed in the order in
 * which they appear, which allows you to optimize your queries for your
 * document structure.
 * </p>
 * <h4>Element Selectors:</h4>
 * <ul class="list">
 * <li><b>*</b> any element</li>
 * <li><b>E</b> an element with the tag E</li>
 * <li><b>E F</b> All descendent elements of E that have the tag F</li>
 * <li><b>E &gt; F</b> or <b>E/F</b> all direct children elements of E that have
 * the tag F</li>
 * <li><b>E + F</b> all elements with the tag F that are immediately preceded by
 * an element with the tag E</li>
 * <li><b>E ~ F</b> all elements with the tag F that are preceded by a sibling
 * element with the tag E</li>
 * </ul>
 * <h4>Attribute Selectors:</h4>
 * <p>
 * The use of @ and quotes are optional. For example, div[@foo='bar'] is also a
 * valid attribute selector.
 * </p>
 * <ul class="list">
 * <li><b>E[foo]</b> has an attribute "foo"</li>
 * <li><b>E[foo=bar]</b> has an attribute "foo" that equals "bar"</li>
 * <li><b>E[foo^=bar]</b> has an attribute "foo" that starts with "bar"</li>
 * <li><b>E[foo$=bar]</b> has an attribute "foo" that ends with "bar"</li>
 * <li><b>E[foo*=bar]</b> has an attribute "foo" that contains the substring
 * "bar"</li>
 * <li><b>E[foo%=2]</b> has an attribute "foo" that is evenly divisible by 2</li>
 * <li><b>E[foo!=bar]</b> has an attribute "foo" that does not equal "bar"</li>
 * </ul>
 * <h4>Pseudo Classes:</h4>
 * <ul class="list">
 * <li><b>E:first-child</b> E is the first child of its parent</li>
 * <li><b>E:last-child</b> E is the last child of its parent</li>
 * <li><b>E:nth-child(<i>n</i>)</b> E is the <i>n</i>th child of its parent (1
 * based as per the spec)</li>
 * <li><b>E:nth-child(odd)</b> E is an odd child of its parent</li>
 * <li><b>E:nth-child(even)</b> E is an even child of its parent</li>
 * <li><b>E:only-child</b> E is the only child of its parent</li>
 * <li><b>E:checked</b> E is an element that is has a checked attribute that is
 * true (e.g. a radio or checkbox)</li>
 * <li><b>E:first</b> the first E in the resultset</li>
 * <li><b>E:last</b> the last E in the resultset</li>
 * <li><b>E:nth(<i>n</i>)</b> the <i>n</i>th E in the resultset (1 based)</li>
 * <li><b>E:odd</b> shortcut for :nth-child(odd)</li>
 * <li><b>E:even</b> shortcut for :nth-child(even)</li>
 * <li><b>E:contains(foo)</b> E's innerHTML contains the substring "foo"</li>
 * <li><b>E:nodeValue(foo)</b> E contains a textNode with a nodeValue that
 * equals "foo"</li>
 * <li><b>E:not(S)</b> an E element that does not match simple selector S</li>
 * <li><b>E:has(S)</b> an E element that has a descendent that matches simple
 * selector S</li>
 * <li><b>E:next(S)</b> an E element whose next sibling matches simple selector
 * S</li>
 * <li><b>E:prev(S)</b> an E element whose previous sibling matches simple
 * selector S</li>
 * </ul>
 * <h4>CSS Value Selectors:</h4>
 * <ul class="list">
 * <li><b>E{display=none}</b> css value "display" that equals "none"</li>
 * <li><b>E{display^=none}</b> css value "display" that starts with "none"</li>
 * <li><b>E{display$=none}</b> css value "display" that ends with "none"</li>
 * <li><b>E{display*=none}</b> css value "display" that contains the substring
 * "none"</li>
 * <li><b>E{display%=2}</b> css value "display" that is evenly divisible by 2</li>
 * <li><b>E{display!=none}</b> css value "display" that does not equal "none"</li>
 * </ul>
 * <br>
 * <br>
 * 
 */
public class DomQuery {

    public static class SelectorType {
        private String type;

        private SelectorType(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }
    }

    public static SelectorType SELECT = new SelectorType("select");
    public static SelectorType SIMPLE = new SelectorType("simple");

    /**
     * Compiles a selector/xpath query into a reusable function. The returned
     * function takes one parameter "root" (optional), which is the context node
     * from where the query should start.
     * 
     * @param selector
     *            the selector/xpath query
     * @return the reusable dom query function
     */
    public static DomQueryFunction compile(String selector) {
        return compile(selector, null);
    }

    private static native JavaScriptObject doCompile(String selector, String selectorType) /*-{
		if (selectorType == null) {
			return $wnd.Ext.DomQuery.compile(selector);
		} else {
			return $wnd.Ext.DomQuery.compile(selector, selectorType);
		}

    }-*/;

    /**
     * Compiles a selector/xpath query into a reusable function. The returned
     * function takes one parameter "root" (optional), which is the context node
     * from where the query should start.
     * 
     * @param selector
     *            the selector/xpath query
     * @param type
     *            either {@link #SELECT} (the default) or {@link #SIMPLE} for a
     *            simple selector match
     * @return the reusable dom query function
     */
    public static DomQueryFunction compile(String selector, SelectorType type) {

        String selectorType = type == null ? null : type.getType();
        final JavaScriptObject fn = doCompile(selector, selectorType);

        return new DomQueryFunction() {
            public Element[] query() {
                JavaScriptObject els = doQuery(fn);
                return JsoHelper.toElementArray(els);

            }

            private native JavaScriptObject doQuery(JavaScriptObject fn) /*-{
		return fn();
    }-*/;

            public Element[] query(Element root) {
                JavaScriptObject els = doQuery(fn, root);
                return JsoHelper.toElementArray(els);
            }

            private native JavaScriptObject doQuery(JavaScriptObject fn, Element root) /*-{
		return fn(root);
    }-*/;
        };
    }

    /**
     * Filters an array of elements to only include matches of a simple selector
     * (e.g. div.some-class or span:first-child).
     * 
     * @param els
     *            an array of elements to filter
     * @param selector
     *            the simple selector to test
     * @param nonMatches
     *            if true, it returns the elements that DON'T match the selector
     *            instead of the ones that match
     * @return filtered element array
     */
    public static Element[] filter(Element[] els, String selector, boolean nonMatches) {
        JavaScriptObject jsElements = doFilter(JsoHelper.convertToJavaScriptArray(els), selector, nonMatches);
        return JsoHelper.toElementArray(jsElements);
    }

    private static native JavaScriptObject doFilter(JavaScriptObject els, String selector, boolean nonMatches) /*-{
		return $wnd.Ext.DomQuery.filter(els, selector, nonMatches);
    }-*/;

    /**
     * Returns true if the passed element match the passed simple selector (e.g.
     * div.some-class or span:first-child).
     * 
     * @param id
     *            the element id
     * @param selector
     *            the simple selector to test
     * @return true if matched
     */
    public static native boolean is(String id, String selector)/*-{
		return $wnd.Ext.DomQuery.is(id, selector);
    }-*/;

    /**
     * Returns true if the passed element match the passed simple selector (e.g.
     * div.some-class or span:first-child).
     * 
     * @param el
     *            the element
     * @param selector
     *            the simple selector to test
     * @return true if matched
     */
    public static native boolean is(Element el, String selector)/*-{
		return $wnd.Ext.DomQuery.is(el, selector);
    }-*/;

    /**
     * Returns true if the passed elements match the passed simple selector
     * (e.g. div.some-class or span:first-child).
     * 
     * @param els
     *            the element array
     * @param selector
     *            the simple selector to test
     * @return true if matched
     */
    public static boolean is(Element[] els, String selector) {
        return doIs(JsoHelper.convertToJavaScriptArray(els), selector);
    }

    private static native boolean doIs(JavaScriptObject els, String selector) /*-{
		return $wnd.Ext.DomQuery.is(els, selector);
    }-*/;

    /**
     * Selects a group of elements.
     * 
     * @param selector
     *            the selector/xpath query (can be a comma separated list of
     *            selectors)
     * @return array of selected elements
     */
    public static Element[] select(String selector) {
        JavaScriptObject jsElements = doSelect(selector);
        return JsoHelper.toElementArray(jsElements);
    }

    private static native JavaScriptObject doSelect(String selector) /*-{
		return $wnd.Ext.DomQuery.select(selector);
    }-*/;

    /**
     * Selects a group of elements.
     * 
     * @param selector
     *            the selector/xpath query (can be a comma separated list of
     *            selectors)
     * @param root
     *            the start of the query (defaults to document)
     * @return array of selected elements
     */
    public static Element[] select(String selector, Element root) {
        JavaScriptObject jsElements = doSelect(selector, root);
        return JsoHelper.toElementArray(jsElements);
    }

    private static native JavaScriptObject doSelect(String selector, Element root) /*-{
		return $wnd.Ext.DomQuery.select(selector, root);
    }-*/;

    /**
     * Selects a single element.
     * 
     * @param selector
     *            the selector/xpath query
     * @return the selected element
     */
    public static native Element selectNode(String selector) /*-{
		return $wnd.Ext.DomQuery.selectNode(selector);
    }-*/;

    /**
     * Selects a single element.
     * 
     * @param selector
     *            the selector/xpath query
     * @param root
     *            the start of the query (defaults to document).
     * @return the selected element
     */
    public static native Element selectNode(String selector, Element root) /*-{
		return $wnd.Ext.DomQuery.selectNode(selector, root);
    }-*/;

    /**
     * Selects the value of a node, parsing integers and floats.
     * 
     * @param selector
     *            the selector/xpath query
     * @return the node value
     */
    public static native float selectNumber(String selector) /*-{
		return $wnd.Ext.DomQuery.selectNumber(selector);
    }-*/;

    /**
     * Selects the value of a node, parsing integers and floats.
     * 
     * @param selector
     *            the selector/xpath query
     * @param root
     *            the start of the query (defaults to document)
     * @return the node value
     */
    public static native float selectNumber(String selector, Element root) /*-{
		return $wnd.Ext.DomQuery.selectNumber(selector, root);
    }-*/;

    /**
     * Selects the value of a node.
     * 
     * @param selector
     *            the selector/xpath query
     * @return the node value
     */
    public static native String selectValue(String selector) /*-{
		return $wnd.Ext.DomQuery.selectValue(selector);
    }-*/;

    /**
     * Selects the value of a node
     * 
     * @param selector
     *            the selector/xpath query
     * @param root
     *            the start of the query (defaults to document)
     * @return the node value
     */
    public static native String selectValue(String selector, Element root) /*-{
		return $wnd.Ext.DomQuery.selectValue(selector, root);
    }-*/;

    /**
     * Selects the value of a node, optionally replacing null with the
     * defaultValue
     * 
     * @param selector
     *            the selector/xpath query
     * @param root
     *            the start of the query (defaults to document)
     * @param defaultValue
     *            value returned if null
     * @return the node value
     */
    public static native String selectValue(String selector, Element root, String defaultValue) /*-{
		return $wnd.Ext.DomQuery.selectValue(selector, root, defaultValue);
    }-*/;

}
