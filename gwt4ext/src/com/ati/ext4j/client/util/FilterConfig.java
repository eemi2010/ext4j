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
package com.ati.ext4j.client.util;

import com.ati.ext4j.client.core.JsoHelper;
import com.ati.ext4j.client.core.config.BaseConfig;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * Represents a single grouper that can be applied to a Store
 */
public class FilterConfig extends BaseConfig {

    public FilterConfig() {
        jsObj = JsoHelper.createObject();
    }

    public void setAnyMatch(boolean value) {
        JsoHelper.setAttribute(getJsObj(), "anyMatch", value);
    }

    public void setCaseSensitive(boolean value) {
        JsoHelper.setAttribute(getJsObj(), "caseSensitive", value);
    }

    public void setExactMatch(boolean value) {
        JsoHelper.setAttribute(getJsObj(), "exactMatch", value);
    }

    public native void setFilterFn(FilterFunction fn)/*-{
		var f = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		f.filterFn = $entry(function(item) {
			var model = @com.ati.ext4j.client.data.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(item);
			return fn.@com.ati.ext4j.client.util.FilterFunction::onFilter(Lcom/ati/ext4j/client/data/BaseModel;)(model);
		});
    }-*/;

    public void setId(String value) {
        JsoHelper.setAttribute(getJsObj(), "id", value);
    }

    public void setRoot(String value) {
        JsoHelper.setAttribute(getJsObj(), "root", value);
    }

    public void setOperator(String value) {
        JsoHelper.setAttribute(getJsObj(), "operator", value);
    }

    public void setProperty(String value) {
        JsoHelper.setAttribute(getJsObj(), "property", value);
    }

    public void setValue(String value) {
        JsoHelper.setAttribute(getJsObj(), "value", value);
    }

    public void setValue(JavaScriptObject value) {
        JsoHelper.setAttribute(getJsObj(), "value", value);
    }

    private native JavaScriptObject create(String prop, String v)/*-{
		return new $wnd.Ext.util.Filter({
			property : prop,
			value : v
		});
    }-*/;

}
