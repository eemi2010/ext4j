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
package com.eemi.ext4j.client.chart.series;

import com.eemi.ext4j.client.core.JsoHelper;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;

/**
 * Common base class for series implementations which plot values using x/y
 * coordinates.
 * 
 * @author alainekambi
 * 
 */
public class CartesianSerie extends AbstractSerie {

    public CartesianSerie() {
        jsObj = JsoHelper.createObject();
        this.setType("Cartesian");
    }

    protected CartesianSerie(JavaScriptObject obj) {
        jsObj = obj;
    }

    /**
     * The field used to access the x axis value from the items from the data
     * source.
     * 
     * Defaults to: null
     * 
     * @param value
     */
    public void setXField(String value) {
        JsoHelper.setAttribute(jsObj, "xField", value);
    }

    public void setXField(String... fields) {
        JsArrayString array = JsArrayString.createArray().cast();
        for (String string : fields) {
            array.push(string);
        }
        JsoHelper.setAttribute(jsObj, "xField", array);
    }

    /**
     * The field used to access the y-axis value from the items from the data
     * source.
     * 
     * Defaults to: null
     * 
     * @param value
     */
    public void setYField(String value) {
        JsoHelper.setAttribute(jsObj, "yField", value);
    }

    public void setYField(String... fields) {
        JsArrayString array = JsArrayString.createArray().cast();
        for (String string : fields) {
            array.push(string);
        }
        JsoHelper.setAttribute(jsObj, "yField", array);
    }

    public static CartesianSerie cast(AbstractSerie serie) {
        return new CartesianSerie(serie.getJsObj());
    }

}
