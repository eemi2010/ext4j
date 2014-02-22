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
package com.ait.ext4j.client.data;

import java.util.ArrayList;
import java.util.List;

import com.ait.ext4j.client.core.JsoHelper;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.Image;

/**
 * Base class for all data to be displayed in data driven compoment like list,
 * Dataview.
 * 
 */
public class TableItem extends BaseModel {

    public static final String CONTENT = "content";

    protected TableItem() {
        jsObj = JsoHelper.createObject();
    }

    public TableItem(JavaScriptObject obj) {
        super(obj);
    }

    public void setText(String value) {
        JsoHelper.setAttribute(jsObj, "text", value);
    }

    public void setContent(String value) {
        JsoHelper.setAttribute(jsObj, CONTENT, value);
    }

    public String getContent() {
        return JsoHelper.getAttribute(jsObj, CONTENT);
    }

    public void setIcon(String url) {
        JsoHelper.setAttribute(jsObj, "icon", url);
    }

    public void setIcon(Image image) {
        setIcon(image.getUrl());
    }

    public void setIcon(ImageResource image) {
        setIcon(new Image(image).getUrl());
    }

    public native String getText()/*-{
		var jso = this.@com.ait.ext4j.client.core.JsObject::jsObj;
		if (jso.get) {
			return jso.get("text");
		}
		return jso['text'];

    }-*/;

    public void setChild(TableItem children) {
        this.setLeaf(false);
        JsArray<JavaScriptObject> array = JsArray.createArray().cast();
        array.push(children.getJsObj());
        JsoHelper.setAttribute(jsObj, "children", array);
    }

    public void setChildren(List<? extends TableItem> children) {
        this.setLeaf(false);
        JsArray<JavaScriptObject> array = JsArray.createArray().cast();
        for (TableItem model : children) {
            array.push(model.getJsObj());
            JsoHelper.setAttribute(jsObj, "children", array);
        }

    }

    public void setLeaf(boolean value) {
        JsoHelper.setAttribute(jsObj, "leaf", value);
    }

    public native boolean isLeaf()/*-{
		var jso = this.@com.ait.ext4j.client.core.JsObject::jsObj;
		var leaf = jso.get("leaf");
		return leaf ? leaf : false;
    }-*/;

    public void setExpanded(boolean value) {
        JsoHelper.setAttribute(jsObj, "expanded", value);
    }

    public native boolean isExpanded()/*-{
		var jso = this.@com.ait.ext4j.client.core.JsObject::jsObj;
		var expanded = jso.get("expanded");
		return expanded ? expanded : false;
    }-*/;

    public native BaseModel getRaw()/*-{
		var jso = this.@com.ait.ext4j.client.core.JsObject::jsObj;
		var obj = jso.raw;
		if (!obj) {
			return null;
		}
		return @com.ait.ext4j.client.data.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
    }-*/;

    public native BaseModel getData()/*-{
		var jso = this.@com.ait.ext4j.client.core.JsObject::jsObj;
		var obj = jso.data;
		if (!obj) {
			return null;
		}
		return @com.ait.ext4j.client.data.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
    }-*/;

    static List<TableItem> fromArray(JavaScriptObject array) {
        List<TableItem> toReturn = new ArrayList<TableItem>();
        int size = JsoHelper.getArrayLength(array);
        for (int i = 0; i < size; i++) {
            JavaScriptObject peer = JsoHelper.getValueFromJavaScriptObjectArray(array, i);
            toReturn.add(new TableItem(peer));
        }
        return toReturn;
    }

}
