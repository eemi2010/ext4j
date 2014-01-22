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
package com.eemi.ext4j.client.data;

import java.util.Arrays;
import java.util.List;

import com.eemi.ext4j.client.core.JsoHelper;
import com.google.gwt.core.client.JavaScriptObject;

public class DataModel {

    private static List<FieldDefinition> fieldDifinition;
    private static String modelName;

    public static void define(String modelName, FieldDefinition... fields) {
        define(modelName, Arrays.asList(fields));
    }

    public static void define(String name, List<FieldDefinition> fields) {
        modelName = name;
        fieldDifinition = fields;
        if (fieldDifinition.isEmpty()) {
            throw new IllegalStateException("You must specify some field definition for this model");
        }
        JavaScriptObject array = JsoHelper.createJavaScriptArray();
        for (int i = 0; i < fieldDifinition.size(); i++) {
            JsoHelper.setArrayValue(array, i, fieldDifinition.get(i).getJsObj());
        }
        _define(modelName, array);
    }

    private static native void _define(String modelName, JavaScriptObject fieldDef)/*-{
		$wnd.Ext.define(modelName, {
			extend : 'Ext.data.Model',
			fields : fieldDef
		});
    }-*/;

}
