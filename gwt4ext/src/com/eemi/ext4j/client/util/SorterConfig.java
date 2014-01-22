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
package com.eemi.ext4j.client.util;

import com.eemi.ext4j.client.core.JsoHelper;
import com.eemi.ext4j.client.core.config.BaseConfig;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * Represents a single sorter configuration that can be applied to a Store
 */
public class SorterConfig extends BaseConfig {

    public SorterConfig() {
        jsObj = JsoHelper.createObject();
    }

    public SorterConfig(String property, Direction direction) {
        this();
        this.setProperty(property);
        this.setDirection(direction);
    }

    public void setDirection(Direction direction) {
        JsoHelper.setAttribute(getJsObj(), "direction", direction.getValue());
    }

    public native void setSorterFn(SorterFunction fn)/*-{
		var f = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		f.filterFn = $entry(function(item1, item2) {
			var model1 = @com.eemi.ext4j.client.data.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(item1);
			var model2 = @com.eemi.ext4j.client.data.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(item2);
			return fn.@com.eemi.ext4j.client.util.SorterFunction::onSort(Lcom/eemi/ext4j/client/data/BaseModel;Lcom/eemi/ext4j/client/data/BaseModel;)(model1,model2);
		});
    }-*/;

    public void setRoot(String value) {
        JsoHelper.setAttribute(getJsObj(), "root", value);
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

}
