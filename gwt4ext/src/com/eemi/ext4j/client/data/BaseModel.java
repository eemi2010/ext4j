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
package com.eemi.ext4j.client.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.eemi.ext4j.client.core.JsObject;
import com.eemi.ext4j.client.core.JsoHelper;
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

    public BaseModel(JavaScriptObject obj) {
        super(obj);
    }

    @SuppressWarnings("unchecked")
    public <X> X set(String property, X value) {
        map.put(property, value);
        _setNative(property, value);
        return (X) map.get(property);
    }

    public <X> void set(String property, String value) {
        map.put(property, value);
        _setNative(property, value);
    }

    public void set(String property, Date value) {
        map.put(property, value);
        _setDateNative(property, value);
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
		var jso = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		if (jso.get) {
			return jso.get(property);
		} else {
			return jso[property];
		}
    }-*/;

    public native double getAsNumber(String property)/*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		if (jso.get) {
			return jso.get(property);
		} else {
			return jso[property];
		}
    }-*/;

    public void set(BaseModel model) {
        set(model.getJsObj());
    }

    public native void set(JavaScriptObject value)/*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		if (jso.set) {
			jso.set(value);
		}
    }-*/;

    public native boolean getBoolean(String property)/*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		if (jso.get) {
			return jso.get(property);
		} else {
			return jso[property];
		}
    }-*/;

    public Set<String> getFields() {
        Set<String> props = new HashSet<String>();
        for (String s : getProperties()) {
            props.add(s);
        }
        if (!props.isEmpty()) {
            return props;
        }
        return map.keySet();
    }

    private native <X> X _setNative(String property, X value)/*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		if (jso.set) {
			jso.set(property, value);
		} else {
			jso[property] = value;
		}
    }-*/;

    private native void _setNative(String property, double value)/*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		if (jso.set) {
			jso.set(property, value);
		} else {
			jso[property] = value;
		}
    }-*/;

    public static JsArray<JavaScriptObject> fromList(List<BaseModel> models) {
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

    // ////////////////

    /**
     * Returns the ID of the record or null if not defined.
     * 
     * @return ID of the record
     */
    public native String getId() /*-{
		var record = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		var id = record.id;
		return (id == null || id === undefined) ? null : id.toString();
    }-*/;

    /**
     * The BaseModels modified state.
     * 
     * @return true if this record has been modified
     */
    public native boolean isDirty() /*-{
		var record = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		return record.dirty;
    }-*/;

    /**
     * Begin an edit. While in edit mode, no events are relayed to the
     * containing store.
     */
    public native void beginEdit() /*-{
		var record = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		if (record.beginEdit) {
			record.beginEdit();
		}
    }-*/;

    /**
     * Cancels all changes made in the current edit operation.
     */
    public native void cancelEdit() /*-{
		var record = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		if (record.cancelEdit) {
			record.cancelEdit();
		}
    }-*/;

    /**
     * Creates a copy of this record.
     * 
     * @return copy of this BaseModel
     */
    public native BaseModel copy() /*-{
		var record = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		var record2 = record.copy();
		return @com.eemi.ext4j.client.data.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(record2);
    }-*/;

    /**
     * Creates a copy of this record.
     * 
     * @param id
     *            a new record id if you don't want to use this record's id
     * @return copy of this BaseModel
     */
    public native BaseModel copy(String id) /*-{
		var record = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		var record2 = record.copy(id);
		return @com.eemi.ext4j.client.data.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(record2);
    }-*/;

    /**
     * Usually called by the Store which owns the BaseModel. Commits all changes
     * made to the BaseModel since either creation, or the last commit
     * operation. Developers should subscribe to
     * {@link com.eemi.ext4j.client.data.event.StoreListener#onUpdate(Store, BaseModel, com.eemi.ext4j.client.data.BaseModel.Operation)}
     * event to have their code notified of commit operations.
     */
    public native void commit() /*-{
		var record = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		if (record.commit) {
			record.commit();
		}
    }-*/;

    /**
     * Usually called by the Store which owns the BaseModel. Commits all changes
     * made to the BaseModel since either creation, or the last commit
     * operation. Developers should subscribe to
     * {@link com.eemi.ext4j.client.data.event.StoreListener#onUpdate(Store, BaseModel, com.eemi.ext4j.client.data.BaseModel.Operation)}
     * event to have their code notified of commit operations.
     * 
     * @param silent
     *            true to skip notification of the owning store of the change
     *            (defaults to false)
     */
    public native void commit(boolean silent) /*-{
		var record = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		if (record.commit) {
			record.commit(silent);
		}

    }-*/;

    /**
     * End an edit. If any data was modified, the containing store is notified.
     */
    public native void endEdit() /*-{
		var record = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		if (record.endEdit) {
			record.endEdit();
		}
    }-*/;

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
		var record = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
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
		var record = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
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
		var record = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
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
		var record = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
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
		var record = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		var value;
		if (record.get) {
			value = record.get(fieldName);
		} else {
			value = record[fieldName];
		}
		return value === undefined || value == null || value === '';
    }-*/;

    /**
     * Returns the BaseModels value as an integer.
     * 
     * @param field
     *            the field name
     * @return the field value
     */
    public native int getAsInteger(String field) /*-{
		var record = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		var value;
		if (record.get) {
			value = record.get(field);
		} else {
			value = record[field];
		}
		return (value === undefined || value == null) ? 0 : parseInt(value);
    }-*/;

    /**
     * Returns the BaseModels value as a float.
     * 
     * @param field
     *            the field name
     * @return the field value
     */
    public native float getAsFloat(String field) /*-{
		var record = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		var value;
		if (record.get) {
			value = record.get(field);
		} else {
			value = record[field];
		}
		return (value === undefined || value == null) ? 0 : parseFloat(value);
    }-*/;

    /**
     * Returns the BaseModels value as a double.
     * 
     * @param field
     *            the field name
     * @return the field value
     */
    public native double getAsDouble(String field) /*-{
		var record = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		var value;
		if (record.get) {
			value = record.get(field);
		} else {
			value = record[field];
		}
		return (value === undefined || value == null) ? 0 : parseFloat(value);
    }-*/;

    /**
     * Returns the BaseModels value as a boolean value. If val is null,
     * undefined, false, -0, +0, NaN, or an empty string (""), this method
     * returns false, otherwise it returns true for all other numbers and
     * strings.
     * 
     * @param field
     *            the field name
     * @return the field value
     */
    public native boolean getAsBoolean(String field) /*-{
		var record = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
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
		var record = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		record.id = id;
    }-*/;

    /**
     * Return the fields value as a Date.
     * 
     * @param field
     *            the field name
     * @return the field value
     */
    public native Date getAsDate(String field) /*-{
        var record = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
        var value;
        if (record.get) {
            value = record.get(field);
        } else {
            value = record[field];
        }
        if(val == null || val === undefined || val == '') {
            return null;
        } else {
            return @com.eemi.ext4j.client.util.DateUtil::create(D)(val.getTime());
        }
    }-*/;

    /**
     * Sets the fields value.
     * 
     * @param field
     *            the field name
     * @param value
     *            the field value
     */
    private native void _setDateNative(String field, Date value) /*-{
		var record = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		if (value == null) {
			if (record.set) {
				record.set(field, null);
			} else {
				record[field] = null;
			}
		} else {
			var millis = @com.eemi.ext4j.client.util.DateUtil::getTime(Ljava/util/Date;)(value);
			if (record.set) {
				record.set(field, new $wnd.Date(millis));
			} else {
				record[field] = new $wnd.Date(millis);
			}
		}
    }-*/;

    /**
     * Return the names of the fields that are modified in this record.
     * 
     * @return modified field names. Returns an empty array if no fields are
     *         modified.
     */
    public String[] getModifiedFields() {
        JavaScriptObject nativeArray = getModifiedFields(jsObj);
        return JsoHelper.convertToJavaStringArray(nativeArray);
    }

    private native JavaScriptObject getFields(JavaScriptObject record)/*-{
		var fields = @com.eemi.ext4j.client.core.JsoHelper::createJavaScriptArray()();
		var items = record.fields.items
		var cnt = items.length;
		for ( var i = 0; i < cnt; ++i) {
			fields.push(items[i].name);
		}

		return fields;
    }-*/;

    private native JavaScriptObject getModifiedFields(JavaScriptObject record)/*-{
		if (record.modified === undefined)
			return null;
		var fields = @com.eemi.ext4j.client.core.JsoHelper::createJavaScriptArray()();
		for ( var key in record.modified) {
			fields.push(key);
		}
		return fields;
    }-*/;

    // see
    // http://extjs.com/forum/showthread.php?t=2834&highlight=validateedit&page=2
    // for use
    /**
     * Usually called by the Store which owns the BaseModel. Rejects all changes
     * made to the BaseModel since either creation, or the last commit
     * operation. Modified fields are reverted to their original values.
     * Developers should subscribe to the
     * {@link com.eemi.ext4j.client.data.event.StoreListener#onUpdate(Store, BaseModel, com.eemi.ext4j.client.data.BaseModel.Operation)}
     * event to have their code notified of reject operations.
     */
    public native void reject() /*-{
		var record = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		if (record.reject) {
			record.reject();
		}
    }-*/;

    /**
     * Usually called by the Store which owns the BaseModel. Rejects all changes
     * made to the BaseModel since either creation, or the last commit
     * operation. Modified fields are reverted to their original values.
     * Developers should subscribe to the
     * {@link com.eemi.ext4j.client.data.event.StoreListener#onUpdate(Store, BaseModel, com.eemi.ext4j.client.data.BaseModel.Operation)}
     * event to have their code notified of reject operations.
     * 
     * @param silent
     *            true to skip notification of the owning store of the change
     *            (defaults to false)
     */
    public native void reject(boolean silent) /*-{
		var record = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		if (record.reject) {
			record.reject(silent);
		}
    }-*/;

    public native JavaScriptObject getRawData()/*-{
		var record = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		var val = record.data;
		return val === undefined ? null : val;
    }-*/;

    protected void notifyPropertyChanged(String name, Object value, Object oldValue) {

    }

}
