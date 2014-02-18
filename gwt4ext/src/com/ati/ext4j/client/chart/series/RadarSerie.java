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
package com.ati.ext4j.client.chart.series;

import com.ati.ext4j.client.core.JsoHelper;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;

/**
 * Creates a Radar Chart. A Radar Chart is a useful visualization technique for
 * comparing different quantitative values for a constrained number of
 * categories.
 * <p>
 * As with all other series, the Radar series must be appended in the series
 * Chart array configuration. See the Chart documentation for more information.
 * 
 * @author alainekambi
 * 
 */
public class RadarSerie extends AbstractSerie {

    public RadarSerie() {
        jsObj = JsoHelper.createObject();
        this.setType("Radar");
    }

    protected RadarSerie(JavaScriptObject obj) {
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

    public static RadarSerie cast(AbstractSerie serie) {
        return new RadarSerie(serie.getJsObj());
    }

}
