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
package com.ait.ext4j.client.slider;

import java.util.ArrayList;
import java.util.List;

import com.ait.ext4j.client.core.JsObject;
import com.ait.ext4j.client.core.JsoHelper;
import com.google.gwt.core.client.JavaScriptObject;

public class Thumb extends JsObject {

    protected Thumb(JavaScriptObject obj) {
        jsObj = obj;
    }

    public native double getValue()/*-{
		var jso = this.@com.ait.ext4j.client.core.JsObject::getJsObj()();
		return jso.value;
    }-*/;

    public native double getDragStartValue()/*-{
		var jso = this.@com.ait.ext4j.client.core.JsObject::getJsObj()();
		return jso.dragStartValue;
    }-*/;

    public native boolean isConstrain()/*-{
		var jso = this.@com.ait.ext4j.client.core.JsObject::getJsObj()();
		return jso.constrain;
    }-*/;

    public native int getIndex()/*-{
		var jso = this.@com.ait.ext4j.client.core.JsObject::getJsObj()();
		return jso.index;
    }-*/;

    public static List<Thumb> fromJsArray(JavaScriptObject obj) {
        List<Thumb> toReturn = new ArrayList<Thumb>();
        int size = JsoHelper.getArrayLength(obj);
        for (int i = 0; i < size; i++) {
            toReturn.add(new Thumb(JsoHelper.getValueFromJavaScriptObjectArray(obj, i)));
        }
        return toReturn;
    }

}
