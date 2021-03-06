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
package com.ait.ext4j.client.chart.laf;

import com.ait.ext4j.client.chart.ChartTooltipRenderer;
import com.ait.ext4j.client.core.JsoHelper;
import com.ait.ext4j.client.core.config.ToolTipConfig;

public class ChartTooltip extends ToolTipConfig {

    public ChartTooltip() {
        jsObj = JsoHelper.createObject();
    }

    public native void setRenderer(ChartTooltipRenderer renderer)/*-{
		var jso = this.@com.ait.ext4j.client.core.config.BaseConfig::getJsObj()();
		jso.renderer = function(storeItem, item) {
			var toolTip = @com.ait.ext4j.client.ui.ToolTip::new(Lcom/google/gwt/core/client/JavaScriptObject;)(this);
			var model = @com.ait.ext4j.client.data.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(storeItem);
			renderer.@com.ait.ext4j.client.chart.ChartTooltipRenderer::onRender(Lcom/ait/ext4j/client/ui/ToolTip;Lcom/ait/ext4j/client/data/BaseModel;Lcom/google/gwt/core/client/JavaScriptObject;)(toolTip,model,item);
		};

    }-*/;

}
