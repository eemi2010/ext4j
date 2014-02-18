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
package com.ati.ext4j.client.grid.column;

import com.ati.ext4j.client.core.JsoHelper;
import com.ati.ext4j.client.core.config.XType;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * A Column definition class which renders a numeric data field according to a
 * format string.
 * 
 * @author alainekambi
 * 
 */
public class NumberGridColumn extends GridColumn {

    public NumberGridColumn() {
        setXType(XType.NUMBER_COLUM.getValue());
    }

    public NumberGridColumn(String title) {
        this();
        setHeader(title);
    }

    public NumberGridColumn(String title, String dataIndex) {
        this(title);
        setDataIndex(dataIndex);
    }

    protected NumberGridColumn(JavaScriptObject obj) {
        super(obj);
    }

    /**
     * A formatting string as used by Ext.Date.format to format a Date for this
     * Column.
     * <p>
     * Defaults to the default date from Ext.Date.defaultFormat which itself my
     * be overridden in a locale file.
     */
    public void setFormat(String text) {
        JsoHelper.setAttribute(getJsObj(), "format", text);
    }

    public static NumberGridColumn cast(GridColumn obj) {
        return new NumberGridColumn(obj.getJsObj());
    }

}
