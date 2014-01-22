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
package com.eemi.ext4j.client.grid.column;

import com.eemi.ext4j.client.core.JsoHelper;
import com.eemi.ext4j.client.core.config.XType;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * A Column definition class which renders boolean data fields
 * 
 * @author alainekambi
 * 
 */
public class BooleanGridColumn extends GridColumn {

    public BooleanGridColumn() {
        setXType(XType.BOOLEAN_COLUM.getValue());
    }

    protected BooleanGridColumn(JavaScriptObject obj) {
        super(obj);
    }

    /**
     * The string returned by the renderer when the column value is falsey (but
     * not undefined).
     * <p>
     * Defaults to: "false"
     */
    public void setFalseText(String text) {
        JsoHelper.setAttribute(getJsObj(), "falseText", text);
    }

    /**
     * The string returned by the renderer when the column value is not falsey.
     * <p>
     * Defaults to: "true"
     */
    public void setTrueText(String text) {
        JsoHelper.setAttribute(getJsObj(), "trueText", text);
    }

    /**
     * The string returned by the renderer when the column value is undefined.
     * <p>
     * Defaults to: "&#160;"
     */
    public void setUndefinedText(String text) {
        JsoHelper.setAttribute(getJsObj(), "undefinedText", text);
    }

    public static BooleanGridColumn cast(GridColumn obj) {
        return new BooleanGridColumn(obj.getJsObj());
    }

}
