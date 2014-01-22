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

/**
 * Creates a Line Chart. A Line Chart is a useful visualization technique to
 * display quantitative information for different categories or other real
 * values (as opposed to the bar chart), that can show some progression (or
 * regression) in the dataset. As with all other series, the Line Series must be
 * appended in the series Chart array configuration. See the Chart documentation
 * for more information.
 * 
 * @author alainekambi
 * 
 */
public class LineSerie extends CartesianSerie {

    public LineSerie() {
        jsObj = JsoHelper.createObject();
        this.setType("line");
    }

    protected LineSerie(JavaScriptObject obj) {
        super(obj);
    }

    public static LineSerie cast(AbstractSerie serie) {
        return new LineSerie(serie.getJsObj());
    }

}
