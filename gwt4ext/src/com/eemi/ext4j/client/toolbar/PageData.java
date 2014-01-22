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
package com.eemi.ext4j.client.toolbar;

import com.eemi.ext4j.client.core.JsObject;
import com.eemi.ext4j.client.core.JsoHelper;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * 
 */
public class PageData extends JsObject {

    PageData(JavaScriptObject obj) {
        jsObj = obj;
    }

    /**
     * The total number of records in the dataset as returned by the server
     */
    public int getTotal() {
        return JsoHelper.getAttributeAsInt(jsObj, "total");
    }

    /**
     * The current page number
     */
    public int getCurrentPage() {
        return JsoHelper.getAttributeAsInt(jsObj, "currentPage");
    }

    /**
     * The total number of pages (calculated from the total number of records in
     * the dataset as returned by the server and the current pageSize)
     */
    public int getPageCount() {
        return JsoHelper.getAttributeAsInt(jsObj, "pageCount");
    }

    /**
     * The ending record index for the current page
     */
    public int getToRecord() {
        return JsoHelper.getAttributeAsInt(jsObj, "toRecord");
    }

    /**
     * The starting record index for the current page
     */
    public int getFromRecord() {
        return JsoHelper.getAttributeAsInt(jsObj, "fromRecord");
    }

}
