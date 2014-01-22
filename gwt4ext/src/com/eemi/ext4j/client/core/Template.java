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

import java.util.Arrays;
import java.util.List;

import com.eemi.ext4j.client.data.BaseModel;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayString;

/**
 * Represents an HTML fragment template. Templates can be precompiled for
 * greater performance.
 * <p/>
 * The list of available inbuild functions for use within templates are :
 * 'capitalize', 'date', 'ellipsis', 'htmlDecode', 'htmlEncode', 'lowecase',
 * 'stripTags', 'substr', 'trim', 'undef', 'uppercase', 'usMoney'.
 * 
 */
public class Template extends JsObject {

    private String html;

    /**
     * Create a new Template.
     * 
     * @param html
     *            the HTML fragment
     */
    public Template(String html) {
        jsObj = create(html.replaceAll("'", "\""));
        this.html = html;
    }

    public Template(JavaScriptObject jsObj) {
        super(jsObj);
    }

    /**
     * Create a new Template.
     * 
     * @param htmlfrags
     *            the HTML fragments
     */
    public Template(String... htmlfrags) {
        String htmlfrag = "";
        for (int i = 0; i < htmlfrags.length; i++) {
            htmlfrag += htmlfrags[i];
        }
        html = htmlfrag.replaceAll("'", "\"");
        jsObj = create(html);
    }

    public String getHtml() {
        return html;
    }

    private static Template instance(JavaScriptObject jsObj) {
        return new Template(jsObj);
    }

    private native JavaScriptObject create(String html) /*-{
		return new $wnd.Ext.Template(html);
    }-*/;

    public native JavaScriptObject create(JavaScriptObject htmlfrags) /*-{
		return new $wnd.Ext.Template.apply($wnd.Ext.Template.create, htmlfrags);
    }-*/;

    /**
     * True to disable format functions (defaults to false).
     * 
     * @param disable
     *            true to disable format functions
     */
    public native void setDisableFormats(boolean disable) /*-{
		var template = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		template.disableFormats = disable;
    }-*/;

    /**
     * Returns an HTML fragment of this template with the specified values
     * applied. Use this method when the params are numeric (i.e. {0})
     * 
     * @param values
     *            the param values
     * @return the html fragment
     */
    public String applyTemplate(String... values) {
        return applyTemplate(JsoHelper.convertToJavaScriptArray(values));
    }

    /**
     * Returns an HTML fragment of this template with the specified values
     * applied. Use this method when the params are named (i.e. {foo})
     * 
     * @param values
     *            the param values
     * @return the html fragment
     */
    public String applyTemplate(NameValuePair... values) {
        return applyTemplate(NameValuePair.getJsObj(values));
    }

    public native String applyTemplate(JavaScriptObject values) /*-{
		var template = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		return template.applyTemplate(values);
    }-*/;

    /**
     * Compiles the template into an internal function, eliminating the RegEx
     * overhead.
     */
    public native void compile() /*-{
		var template = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		template.compile();
    }-*/;

    /**
     * Applies the supplied values to the template and appends the new node(s)
     * to the specified el.
     */
    public void append(String id, String... values) {
        JsArrayString arr = JsArray.createArray().cast();
        for (String s : values) {
            arr.push(s);
        }
        append(id, arr);
    }

    private native void append(String id, JsArrayString values) /*-{
		var template = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		template.append(id, values);
    }-*/;

    /**
     * Applies the supplied values to the template and appends the new node(s)
     * to the specified el.
     */
    public void append(ExtElement el, String... values) {
        JsArrayString arr = JsArray.createArray().cast();
        for (String s : values) {
            arr.push(s);
        }
        append(el, arr);
    }

    public void append(NameValuePair... values) {
        append(NameValuePair.getJsObj(values));
    }

    public native void append(JavaScriptObject values) /*-{
		var template = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		template.applyTemplate(values);
    }-*/;

    private native void append(ExtElement el, JsArrayString values) /*-{
		var template = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		template.append(
				el.@com.eemi.ext4j.client.core.JsObject::getJsObj()(),
				values);
    }-*/;

    /**
     * Sets the HTML used as the template and optionally compiles it.
     * 
     * @param html
     * @param compile
     * @return
     */
    public native Template set(String html) /*-{
		var template = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		template.set(html);
		return this;
    }-*/;

    /**
     * Applies the supplied values to the template and inserts the new node(s)
     * before el.
     * 
     * @param element
     * @param value
     * @return
     */
    public ExtElement overwrite(String element, BaseModel value) {
        return overwrite(element, value.getJsObj());
    }

    /**
     * Applies the supplied values to the template and inserts the new node(s)
     * before el.
     * 
     * @param element
     * @param value
     * @return
     */
    public ExtElement overwrite(String element, List<BaseModel> values) {
        return overwrite(element, BaseModel.fromList(values));
    }

    /**
     * Applies the supplied values to the template and inserts the new node(s)
     * before el.
     * 
     * @param element
     * @param value
     * @return
     */
    public ExtElement overwrite(String element, BaseModel... values) {
        return overwrite(element, Arrays.asList(values));
    }

    /**
     * Applies the supplied values to the template and inserts the new node(s)
     * before el.
     * 
     * @param element
     * @param value
     * @return
     */
    public ExtElement overwrite(ExtElement element, BaseModel value) {
        return overwrite(element, value.getJsObj());
    }

    /**
     * Applies the supplied values to the template and inserts the new node(s)
     * before el.
     * 
     * @param element
     * @param value
     * @return
     */
    public ExtElement overwrite(ExtElement element, List<BaseModel> values) {
        return overwrite(element, BaseModel.fromList(values));
    }

    /**
     * Applies the supplied values to the template and inserts the new node(s)
     * before el.
     * 
     * @param element
     * @param value
     * @return
     */
    public ExtElement overwrite(ExtElement element, BaseModel... values) {
        return overwrite(element, Arrays.asList(values));
    }

    // /////////////

    /**
     * Applies the supplied values to the template and inserts the new node(s)
     * before el.
     * 
     * @param element
     * @param value
     * @return
     */
    public ExtElement insertFirst(String element, BaseModel value) {
        return insertFirst(element, value.getJsObj());
    }

    /**
     * Applies the supplied values to the template and inserts the new node(s)
     * before el.
     * 
     * @param element
     * @param value
     * @return
     */
    public ExtElement insertFirst(String element, List<BaseModel> values) {
        return insertFirst(element, BaseModel.fromList(values));
    }

    /**
     * Applies the supplied values to the template and inserts the new node(s)
     * before el.
     * 
     * @param element
     * @param value
     * @return
     */
    public ExtElement insertFirst(String element, BaseModel... values) {
        return insertFirst(element, Arrays.asList(values));
    }

    /**
     * Applies the supplied values to the template and inserts the new node(s)
     * before el.
     * 
     * @param element
     * @param value
     * @return
     */
    public ExtElement insertFirst(ExtElement element, BaseModel value) {
        return insertFirst(element, value.getJsObj());
    }

    /**
     * Applies the supplied values to the template and inserts the new node(s)
     * before el.
     * 
     * @param element
     * @param value
     * @return
     */
    public ExtElement insertFirst(ExtElement element, List<BaseModel> values) {
        return insertFirst(element, BaseModel.fromList(values));
    }

    /**
     * Applies the supplied values to the template and inserts the new node(s)
     * before el.
     * 
     * @param element
     * @param value
     * @return
     */
    public ExtElement insertFirst(ExtElement element, BaseModel... values) {
        return insertFirst(element, Arrays.asList(values));
    }

    // ////////

    /**
     * Applies the supplied values to the template and inserts the new node(s)
     * before el.
     * 
     * @param element
     * @param value
     * @return
     */
    public ExtElement insertBefore(String element, BaseModel value) {
        return insertBefore(element, value.getJsObj());
    }

    /**
     * Applies the supplied values to the template and inserts the new node(s)
     * before el.
     * 
     * @param element
     * @param value
     * @return
     */
    public ExtElement insertBefore(String element, List<BaseModel> values) {
        return insertBefore(element, BaseModel.fromList(values));
    }

    /**
     * Applies the supplied values to the template and inserts the new node(s)
     * before el.
     * 
     * @param element
     * @param value
     * @return
     */
    public ExtElement insertBefore(String element, BaseModel... values) {
        return insertBefore(element, Arrays.asList(values));
    }

    /**
     * Applies the supplied values to the template and inserts the new node(s)
     * before el.
     * 
     * @param element
     * @param value
     * @return
     */
    public ExtElement insertBefore(ExtElement element, BaseModel value) {
        return insertBefore(element, value.getJsObj());
    }

    /**
     * Applies the supplied values to the template and inserts the new node(s)
     * before el.
     * 
     * @param element
     * @param value
     * @return
     */
    public ExtElement insertBefore(ExtElement element, List<BaseModel> values) {
        return insertBefore(element, BaseModel.fromList(values));
    }

    /**
     * Applies the supplied values to the template and inserts the new node(s)
     * before el.
     * 
     * @param element
     * @param value
     * @return
     */
    public ExtElement insertBefore(ExtElement element, BaseModel... values) {
        return insertBefore(element, Arrays.asList(values));
    }

    // -------------------------------------

    /**
     * Applies the supplied values to the template and inserts the new node(s)
     * after el.
     * 
     * @param element
     * @param value
     * @return
     */
    public ExtElement insertAfter(String element, BaseModel value) {
        return insertAfter(element, value.getJsObj());
    }

    /**
     * Applies the supplied values to the template and inserts the new node(s)
     * after el.
     * 
     * @param element
     * @param value
     * @return
     */
    public ExtElement insertAfter(String element, List<BaseModel> values) {
        return insertAfter(element, BaseModel.fromList(values));
    }

    /**
     * Applies the supplied values to the template and inserts the new node(s)
     * after el.
     * 
     * @param element
     * @param value
     * @return
     */
    public ExtElement insertAfter(String element, BaseModel... values) {
        return insertAfter(element, Arrays.asList(values));
    }

    /**
     * Applies the supplied values to the template and inserts the new node(s)
     * after el.
     * 
     * @param element
     * @param value
     * @return
     */
    public ExtElement insertAfter(ExtElement element, BaseModel value) {
        return insertAfter(element, value.getJsObj());
    }

    /**
     * Applies the supplied values to the template and inserts the new node(s)
     * after el.
     * 
     * @param element
     * @param value
     * @return
     */
    public ExtElement insertAfter(ExtElement element, List<BaseModel> values) {
        return insertAfter(element, BaseModel.fromList(values));
    }

    /**
     * Applies the supplied values to the template and inserts the new node(s)
     * after el.
     * 
     * @param element
     * @param value
     * @return
     */
    public ExtElement insertAfter(ExtElement element, BaseModel... values) {
        return insertAfter(element, Arrays.asList(values));
    }

    /**
     * Sets the HTML used as the template and optionally compiles it.
     * 
     * @param html
     * @param compile
     * @return
     */
    public native Template set(String html, boolean compile) /*-{
		var template = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		template.set(html, compile);
		return this;
    }-*/;

    private native ExtElement insertBefore(ExtElement el, JavaScriptObject value) /*-{
		var template = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		var obj = template.insertBefore(
				el.@com.eemi.ext4j.client.core.JsObject::getJsObj()(),
				value, true);

		return @com.eemi.ext4j.client.core.ExtElement::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
    }-*/;

    private native ExtElement insertBefore(String el, JavaScriptObject value) /*-{
		var template = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		var obj = template.insertBefore(el, value, true);

		return @com.eemi.ext4j.client.core.ExtElement::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
    }-*/;

    private native ExtElement insertAfter(ExtElement el, JavaScriptObject value) /*-{
		var template = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		var obj = template.insertAfter(
				el.@com.eemi.ext4j.client.core.JsObject::getJsObj()(),
				value, true);

		return @com.eemi.ext4j.client.core.ExtElement::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
    }-*/;

    private native ExtElement insertAfter(String el, JavaScriptObject value) /*-{
		var template = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		var obj = template.insertAfter(el, value, true);

		return @com.eemi.ext4j.client.core.ExtElement::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
    }-*/;

    private native ExtElement insertFirst(ExtElement el, JavaScriptObject value) /*-{
		var template = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		var obj = template.insertAfter(
				el.@com.eemi.ext4j.client.core.JsObject::getJsObj()(),
				value, true);

		return @com.eemi.ext4j.client.core.ExtElement::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
    }-*/;

    private native ExtElement insertFirst(String el, JavaScriptObject value) /*-{
		var template = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		var obj = template.insertAfter(el, value, true);

		return @com.eemi.ext4j.client.core.ExtElement::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
    }-*/;

    private native ExtElement overwrite(ExtElement el, JavaScriptObject value) /*-{
		var template = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		var obj = template.overwrite(
				el.@com.eemi.ext4j.client.core.JsObject::getJsObj()(),
				value, true);

		return @com.eemi.ext4j.client.core.ExtElement::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
    }-*/;

    private native ExtElement overwrite(String el, JavaScriptObject value) /*-{
		var template = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		var obj = template.overwrite(el, value, true);

		return @com.eemi.ext4j.client.core.ExtElement::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
    }-*/;

}
