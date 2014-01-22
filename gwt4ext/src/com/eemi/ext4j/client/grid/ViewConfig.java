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
package com.eemi.ext4j.client.grid;

import java.util.Arrays;
import java.util.List;

import com.eemi.ext4j.client.core.JsoHelper;
import com.eemi.ext4j.client.core.config.BaseConfig;
import com.eemi.ext4j.client.grid.plugin.AbstractPlugin;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public class ViewConfig extends BaseConfig {

    public ViewConfig() {
        jsObj = JsoHelper.createObject();
    }

    /**
     * An array of grid plugins to be added to this grid.
     */
    public void setPlugins(AbstractPlugin... values) {
        setPlugins(Arrays.asList(values));
    }

    /**
     * An array of grid plugins to be added to this grid.
     */
    private void setPlugins(List<AbstractPlugin> values) {
        JsArray<JavaScriptObject> jsos = JsArray.createArray().cast();
        for (AbstractPlugin f : values) {
            jsos.push(f.getJsObj());
        }
        this.set("plugins", jsos);
    }

}
