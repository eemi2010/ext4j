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
package com.ati.ext4j.client.chart.saving;

import com.ati.ext4j.client.core.JsObject;
import com.ati.ext4j.client.core.JsoHelper;
import com.ati.ext4j.client.draw.engine.ImageExporter;

/**
 * Config option for exporting a chart to an image. It is expected that the user
 * will be prompted with an image download. As such, the following options
 * should be set on the server: <br/>
 * <ul>
 * <li>Content-Disposition: 'attachment, filename="chart.png"'</li>
 * <li>Content-Disposition: 'attachment, filename="chart.png"'</li>
 * <li>Content-Type: 'image/png' or Content-Type: 'image/jpg'
 * <li>
 * </ul>
 * <p>
 * <b>Important</b>: By default, chart data is sent to a server operated by
 * Sencha to do data processing. You may change this default by setting the
 * defaultUrl of {@link ImageExporter}.
 * 
 * @author alainekambi
 * 
 */
public class ImageExport extends JsObject {

    public ImageExport() {
        jsObj = JsoHelper.createObject();
    }

    /**
     * The width of the image
     * 
     * @param value
     */
    public void setWidth(double value) {
        JsoHelper.setAttribute(jsObj, "width", value);
    }

    /**
     * The height of the image
     * 
     * @param value
     */
    public void setHeight(double value) {
        JsoHelper.setAttribute(jsObj, "height", value);
    }

    /**
     * The image type to save as
     * 
     * @param value
     */
    public void setType(String value) {
        JsoHelper.setAttribute(jsObj, "type", value);
    }
}
