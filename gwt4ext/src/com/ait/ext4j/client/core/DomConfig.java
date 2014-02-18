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
package com.ait.ext4j.client.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * The DOM object spec. Can be configured with specs of children too. If no tag
 * is specified then a div will be automatically generated with the specified
 * attributes.
 * 
 * @see DomHelper#append(String, DomConfig)
 * @see ExtElement#createChild(DomConfig)
 */
public class DomConfig {

    private String tag;
    private String id;
    private String cls;
    private String style;
    private String html;
    @SuppressWarnings("rawtypes")
    private List children;

    @SuppressWarnings("rawtypes")
    private Map otherConfig = new HashMap();

    /**
     * Create a new DomConfig using a "div" tag.
     */
    public DomConfig() {
        this.tag = "div";
    }

    /**
     * Create a new DomConfig.
     * 
     * @param tag
     *            the tag name
     */
    public DomConfig(String tag) {
        this.tag = tag;
    }

    /**
     * Constructor.
     * 
     * @param tag
     *            the element tag name
     * @param id
     *            the element id
     */
    public DomConfig(String tag, String id) {
        this.tag = tag;
        this.id = id;
    }

    /**
     * Constructor.
     * 
     * @param tag
     *            the element tag name
     * @param id
     *            the element id
     * @param cls
     *            the element CSS class name
     */
    public DomConfig(String tag, String id, String cls) {
        this.tag = tag;
        this.id = id;
        this.cls = cls;
    }

    /**
     * Constructor.
     * 
     * @param tag
     *            the element tag name
     * @param id
     *            the element id
     * @param cls
     *            the element CSS class name
     * @param html
     *            the innerHTML for the element.
     */
    public DomConfig(String tag, String id, String cls, String html) {
        this.tag = tag;
        this.id = id;
        this.cls = cls;
        this.html = html;
    }

    /**
     * Set the CSS style.
     * 
     * @param style
     *            the CSS style
     */
    public DomConfig setStyle(String style) {
        this.style = style;
        return this;
    }

    /**
     * Add a child element.
     * 
     * @param child
     *            the child element config
     * @return this
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public DomConfig addChild(DomConfig child) {
        if (html != null) {
            throw new IllegalArgumentException("Dom spec cannot have inner html and child elelents");
        }
        if (children == null)
            children = new ArrayList();
        children.add(child);
        return this;
    }

    @SuppressWarnings("unchecked")
    public void addAttribute(String name, String value) {
        otherConfig.put(name, value);
    }

    public JavaScriptObject getJsObject() {
        JavaScriptObject jsObj = JsoHelper.createObject();
        if (tag != null)
            JsoHelper.setAttribute(jsObj, "tag", tag);
        if (id != null)
            JsoHelper.setAttribute(jsObj, "id", id);
        if (cls != null)
            JsoHelper.setAttribute(jsObj, "cls", cls);
        if (style != null)
            JsoHelper.setAttribute(jsObj, "style", style);
        if (html != null)
            JsoHelper.setAttribute(jsObj, "html", html);

        for (@SuppressWarnings("rawtypes")
        Iterator iterator = otherConfig.keySet().iterator(); iterator.hasNext();) {
            String attribute = (String) iterator.next();
            String value = (String) otherConfig.get(attribute);
            JsoHelper.setAttribute(jsObj, attribute, value);
        }

        if (children != null) {
            JavaScriptObject[] childrenJS = new JavaScriptObject[children.size()];
            int i = 0;
            for (@SuppressWarnings("rawtypes")
            Iterator it = children.iterator(); it.hasNext(); i++) {
                DomConfig config = (DomConfig) it.next();
                childrenJS[i] = config.getJsObject();
            }
            JsoHelper.setAttribute(jsObj, "children", childrenJS);
        }
        return jsObj;
    }
}
