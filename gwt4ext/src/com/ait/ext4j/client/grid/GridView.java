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
package com.ait.ext4j.client.grid;

import com.ait.ext4j.client.core.config.XType;
import com.ait.ext4j.client.ui.DataView;
import com.ait.ext4j.client.ui.TableView;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;

/**
 * The grid View class provides extra Ext.grid.Panel specific functionality to
 * the Ext.view.Table.
 */
public class GridView extends TableView {

    private static JavaScriptObject configPrototype;

    private native void init()/*-{
		var c = new $wnd.Ext.grid.View();
		@com.ait.ext4j.client.grid.GridView::configPrototype = c.initialConfig;
    }-*/;

    protected JavaScriptObject getConfigPrototype() {
        return configPrototype;
    }

    public String getXType() {
        return XType.GRIDVIEW.getValue();
    }

    public GridView() {
    }

    protected GridView(JavaScriptObject obj) {
        super(obj);
    }

    /**
     * Applys the NotificationContainer to an existing element.
     * 
     * @param element
     *            the element
     */
    public GridView(Element element) {
        super(element);
    }

    /**
     * True to stripe the rows.
     * <p>
     * This causes the CSS class x-grid-row-alt to be added to alternate rows of
     * the grid. A default CSS rule is provided which sets a background color,
     * but you can override this with a rule which either overrides the
     * background-color style using the !important modifier, or which uses a CSS
     * selector of higher specificity.
     * <p>
     * Defaults to: true
     */
    public void setStripeRows(boolean value) {
        setAttribute("stripeRows", value, true);
    }

    public static GridView cast(DataView v) {
        return new GridView(v.getOrCreateJsObj());
    }

}
