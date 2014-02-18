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
package com.ait.ext4j.client.events.chart;

import com.ait.ext4j.client.core.EventObject;
import com.ait.ext4j.client.events.Event;
import com.ait.ext4j.client.ui.Chart;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.DomEvent.Type;

public class BeforeRefreshEvent extends EventObject {

    public static String EVENT_NAME = Event.BEFORE_REFRESH;

    private Chart chart;

    /**
     * UiBinder implementations
     */
    private static Type<BeforeRefreshHandler> TYPE = new Type<BeforeRefreshHandler>(EVENT_NAME, null);

    public static Type<BeforeRefreshHandler> getType() {
        return TYPE;
    }

    public static Type<BeforeRefreshHandler> getAssociatedType() {
        return TYPE;
    }

    public BeforeRefreshEvent(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public BeforeRefreshEvent(Chart chart, JavaScriptObject nativeEvent) {
        super(nativeEvent);
        this.chart = chart;
    }

    /**
     * @return the chart
     */
    public Chart getChart() {
        return chart;
    }

}
