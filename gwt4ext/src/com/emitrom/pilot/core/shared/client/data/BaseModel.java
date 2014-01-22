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
package com.emitrom.pilot.core.shared.client.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.emitrom.pilot.core.shared.client.core.JsObject;
import com.emitrom.pilot.core.shared.client.core.JsoHelper;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

/**
 * Base class for all data to be displayed in data driven components
 */

public class BaseModel extends JsObject {

    protected Map<String, Object> map = new HashMap<String, Object>();
    protected boolean allowNestedValues = true;

    public BaseModel() {
        jsObj = JsoHelper.createObject();
    }

    protected BaseModel(JavaScriptObject obj) {
        super(obj);
    }

    @SuppressWarnings("unchecked")
    public <X> X set(String property, X value) {
        map.put(property, value);
        _setNative(property, value);
        return (X) map.get(property);
    }

    public void set(String property, double value) {
        map.put(property, value);
        _setNative(property, value);
    }

    public void set(String property, List<BaseModel> values) {
        map.put(property, values);
        JsArray<JavaScriptObject> rawValues = JsArray.createArray().cast();
        for (BaseModel model : values) {
            rawValues.push(model.getJsObj());
        }
        _setNative(property, rawValues);
    }

    public native String get(String property)/*-{
		var jso = this.@com.emitrom.pilot.core.shared.client.core.JsObject::jsObj;
		if (jso.get) {
			return jso.get(property);
		} else {
			return jso[property];
		}
    }-*/;

    public native double getNumber(String property)/*-{
		var jso = this.@com.emitrom.pilot.core.shared.client.core.JsObject::jsObj;
		if (jso.get) {
			return jso.get(property);
		} else {
			return jso[property];
		}
    }-*/;

    public native boolean getBoolean(String property)/*-{
		var jso = this.@com.emitrom.pilot.core.shared.client.core.JsObject::jsObj;
		if (jso.get) {
			return jso.get(property);
		} else {
			return jso[property];
		}
    }-*/;

    public Set<String> getFields() {
        return map.keySet();
    }

    private native <X> X _setNative(String property, X value)/*-{
		var jso = this.@com.emitrom.pilot.core.shared.client.core.JsObject::jsObj;
		if (jso.set) {
			jso.set(property, value);
		} else {
			jso[property] = value;
		}
    }-*/;

    private native void _setNative(String property, double value)/*-{
		var jso = this.@com.emitrom.pilot.core.shared.client.core.JsObject::jsObj;
		if (jso.set) {
			jso.set(property, value);
		} else {
			jso[property] = value;
		}
    }-*/;

    static JsArray<JavaScriptObject> fromList(List<BaseModel> models) {
        JsArray<JavaScriptObject> values = JsArray.createArray().cast();
        for (BaseModel model : models) {
            values.push(model.getJsObj());
        }
        return values;
    }

    public static List<BaseModel> fromJsArray(JavaScriptObject array) {
        List<BaseModel> toReturn = new ArrayList<BaseModel>();
        int size = JsoHelper.getArrayLength(array);
        for (int i = 0; i < size; i++) {
            JavaScriptObject peer = JsoHelper.getValueFromJavaScriptObjectArray(array, i);
            toReturn.add(new BaseModel(peer));
        }
        return toReturn;
    }

    public static BaseModel from(JavaScriptObject obj) {
        return new BaseModel(obj);
    }

    public void update(JavaScriptObject obj) {
        jsObj = obj;
    }

    @SuppressWarnings("unchecked")
    public <X> X getFromCache(String property) {
        return (X) map.get(property);
    }

    /**
     * Returns the ID of the record or null if not defined.
     * 
     * @return ID of the record
     */
    public native String getId() /*-{
		var record = this.@com.emitrom.pilot.core.shared.client.core.JsObject::getJsObj()();
		var id = record.id;
		return (id == null || id === undefined) ? null : id.toString();
    }-*/;

    protected void notifyPropertyChanged(String name, Object value, Object oldValue) {

    }

    // todo throw exception if field is invalid as opposed to null value for
    // field?
    // throw new Error("JS Error Object");
    /**
     * Return the field value as String.
     * 
     * @param field
     *            the field name
     * @return the field value
     */
    public native String getAsString(String field) /*-{
		var record = this.@com.emitrom.pilot.core.shared.client.core.JsObject::getJsObj()();
		var value;
		if (record.get) {
			value = record.get(field);
		} else {
			value = record[field];
		}

		//todo?
		//if (value === undefined) throw new Error("Invalid field " + field);
		return (value === undefined || value == null || value === '') ? null
				: value.toString();
    }-*/;

    /**
     * Return the field value as Object.
     * 
     * @param field
     *            the field name
     * @return the filed value
     */
    public native Object getAsObject(String field) /*-{
		var record = this.@com.emitrom.pilot.core.shared.client.core.JsObject::getJsObj()();
		var value;
		if (record.get) {
			value = record.get(field);
		} else {
			value = record[field];
		}

		return (value === undefined || value == null || value === '') ? null
				: value;
    }-*/;

    /**
     * Return true if specified field has been modified.
     * 
     * @param fieldName
     *            the field name
     * @return true if modified
     */
    public native boolean isModified(String fieldName) /*-{
		var record = this.@com.emitrom.pilot.core.shared.client.core.JsObject::getJsObj()();
		if (record.isModified) {
			return record.isModified(fieldName);
		}
		return false;
    }-*/;

    /**
     * Return true if specified field is null (or undefined)
     * 
     * @param fieldName
     *            the field name
     * @return true if null or undefined
     */
    public native boolean isNull(String fieldName) /*-{
		var record = this.@com.emitrom.pilot.core.shared.client.core.JsObject::getJsObj()();
		var value;
		if (record.get) {
			value = record.get(fieldName);
		} else {
			value = record[fieldName];
		}
		return value === undefined || value == null;
    }-*/;

    /**
     * Return true if the specified field is null(or undefined) or an empty
     * string
     * 
     * @param fieldName
     *            the field name
     * @return true if empty
     */
    public native boolean isEmpty(String fieldName) /*-{
		var record = this.@com.emitrom.pilot.core.shared.client.core.JsObject::getJsObj()();
		var value;
		if (record.get) {
			value = record.get(fieldName);
		} else {
			value = record[fieldName];
		}
		return value === undefined || value == null || value === '';
    }-*/;

    /**
     * Returns the BaseDataModels value as an integer.
     * 
     * @param field
     *            the field name
     * @return the field value
     */
    public native int getAsInteger(String field) /*-{
		var record = this.@com.emitrom.pilot.core.shared.client.core.JsObject::getJsObj()();
		var value;
		if (record.get) {
			value = record.get(field);
		} else {
			value = record[field];
		}
		return (value === undefined || value == null) ? 0 : parseInt(value);
    }-*/;

    /**
     * Returns the BaseDataModels value as a float.
     * 
     * @param field
     *            the field name
     * @return the field value
     */
    public native float getAsFloat(String field) /*-{
		var record = this.@com.emitrom.pilot.core.shared.client.core.JsObject::getJsObj()();
		var value;
		if (record.get) {
			value = record.get(field);
		} else {
			value = record[field];
		}
		return (value === undefined || value == null) ? 0 : parseFloat(value);
    }-*/;

    /**
     * Returns the BaseDataModels value as a double.
     * 
     * @param field
     *            the field name
     * @return the field value
     */
    public native double getAsDouble(String field) /*-{
		var record = this.@com.emitrom.pilot.core.shared.client.core.JsObject::getJsObj()();
		var value;
		if (record.get) {
			value = record.get(field);
		} else {
			value = record[field];
		}
		return (value === undefined || value == null) ? 0 : parseFloat(value);
    }-*/;

    /**
     * Returns the BaseDataModels value as a boolean value. If val is null,
     * undefined, false, -0, +0, NaN, or an empty string (""), this method
     * returns false, otherwise it returns true for all other numbers and
     * strings.
     * 
     * @param field
     *            the field name
     * @return the field value
     */
    public native boolean getAsBoolean(String field) /*-{
		var record = this.@com.emitrom.pilot.core.shared.client.core.JsObject::getJsObj()();
		var value;
		if (record.get) {
			value = record.get(field);
		} else {
			value = record[field];
		}
		return (value === undefined || value == null) ? false : Boolean(value);
    }-*/;

    /**
     * Set the BaseModel's ID.
     * 
     * @param id
     *            the record ID
     */
    public native void setId(String id) /*-{
		var record = this.@com.emitrom.pilot.core.shared.client.core.JsObject::getJsObj()();
		record.id = id;
    }-*/;

}
