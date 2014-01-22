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
package com.eemi.ext4j.client.ui;

import com.eemi.ext4j.client.connection.Connection;
import com.eemi.ext4j.client.connection.UrlParam;
import com.eemi.ext4j.client.core.JsObject;
import com.eemi.ext4j.client.core.JsoHelper;
import com.eemi.ext4j.client.data.BaseModel;
import com.eemi.ext4j.client.events.form.SubmitHandler;
import com.eemi.ext4j.client.field.Field;
import com.eemi.ext4j.client.field.FieldBase;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * Provides input field management, validation, submission, and form loading
 * services for the collection of Field instances within a {@link Container}. It
 * is recommended that you use a {@link FormPanel} as the form container, as
 * that has logic to automatically hook up an instance of {@link Form} (plus
 * other conveniences related to field configuration.)
 * 
 */
public class Form extends JsObject {

    public Form(JavaScriptObject jsObj) {
        super(jsObj);
    }

    protected native JavaScriptObject create(JavaScriptObject config)/*-{
		return new $wnd.Ext.form.Basic(config);
    }-*/;

    public static Form instance(JavaScriptObject formJS) {
        return new Form(formJS);
    }

    /**
     * Copies all properties of the passed config to all fields in this form
     * with the passed object if they don't already exist.
     * 
     * @param fieldConfig
     *            the config object
     */

    /**
     * Check whether the dirty state of the entire form has changed since it was
     * last checked, and if so fire the dirtychange event. This is automatically
     * invoked when an individual field's dirty state changes.
     */
    public native void checkDirty() /*-{
		var form = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		form.checkDirty();
    }-*/;

    /**
     * Destroys this object.
     */
    public native void destroy() /*-{
		var form = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		form.destroy();
    }-*/;

    /**
     * Returns true if the form contains any invalid fields. No fields will be
     * marked as invalid as a result of calling this; to trigger marking of
     * fields use isValid instead.
     */
    public native boolean hasInvalidField() /*-{
		var form = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		form.hasInvalidField();
    }-*/;

    /**
     * Returns true if the form contains a file upload field. This is used to
     * determine the method for submitting the form: File uploads are not
     * performed using normal 'Ajax' techniques, that is they are not performed
     * using XMLHttpRequests. Instead a hidden <form> element containing all the
     * fields is created temporarily and submitted with its target set to refer
     * to a dynamically generated, hidden <iframe> which is inserted into the
     * document but removed after the return data has been gathered.
     * <p>
     * The server response is parsed by the browser to create the document for
     * the IFRAME. If the server is using JSON to send the return object, then
     * the Content-Type header must be set to "text/html" in order to tell the
     * browser to insert the text unchanged into the document body.
     * <p>
     * Characters which are significant to an HTML parser must be sent as HTML
     * entities, so encode "<" as "&lt;", "&" as "&amp;" etc.
     * <p>
     * The response text is retrieved from the document, and a fake
     * XMLHttpRequest object is created containing a responseText property in
     * order to conform to the requirements of event handlers and callbacks.
     * <p>
     * Be aware that file upload packets are sent with the content type
     * multipart/form and some server technologies (notably JEE) may require
     * some custom processing in order to retrieve parameter names and parameter
     * values from the packet content.
     */
    public native boolean hasUpLoad() /*-{
		var form = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		form.hasUpLoad();
    }-*/;

    /**
     * Clears all invalid messages in this form.
     */
    public native Form clearInvalid() /*-{
		var form = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		form.clearInvalid();
		return this;
    }-*/;

    /**
     * Find a {@link Field} in this form by id, dataIndex, name or hiddenName.
     * 
     * @param id
     *            the field ID,dataIndex, name or hiddenName to search for
     * @return the field
     */
    public native FieldBase findField(String id)/*-{
		var form = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		var fieldJS = form.findField(id);
		return fieldJS != null ? @com.eemi.ext4j.client.ui.ComponentFactory::getComponent(Lcom/google/gwt/core/client/JavaScriptObject;)(fieldJS)
				: null;
    }-*/;

    /**
     * Returns the fields in this form as a String
     * 
     * @return form field values as String
     */
    public native String getValuesAsString() /*-{
		var form = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		return form.getValues(true);
    }-*/;

    /**
     * Returns the fields in this form as a String
     * 
     * @return form field values as String
     */
    public native String getValuesAsString(boolean dirtyOnly) /*-{
		var form = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		return form.getValues(true, dirtyOnly);
    }-*/;

    /**
     * Returns the fields in this form as a String
     * 
     * @return form field values as String
     */
    public native String getValuesAsString(boolean dirtyOnly, boolean includeEmptyText) /*-{
		var form = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		return form.getValues(true, dirtyOnly, includeEmptyText);
    }-*/;

    /**
     * Returns the fields in this form as a String
     * 
     * @return form field values as String
     */
    public native String getValuesAsString(boolean dirtyOnly, boolean includeEmptyText, boolean useDataValues) /*-{
		var form = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		return form.getValues(true, dirtyOnly, includeEmptyText, useDataValues);
    }-*/;

    /**
     * Returns the fields in this form as a JavaScript Object
     * 
     * @return form field values as JavaScript Object
     */
    public native JavaScriptObject getValues() /*-{
		var form = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		return form.getValues(false);
    }-*/;

    /**
     * Returns the fields in this form as a JavaScript Object
     * 
     * @return form field values as JavaScript Object
     */
    public native JavaScriptObject getValues(boolean dirtyOnly) /*-{
		var form = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		return form.getValues(false, dirtyOnly);
    }-*/;

    /**
     * Returns the fields in this form as a JavaScript Object
     * 
     * @return form field values as JavaScript Object
     */
    public native JavaScriptObject getValues(boolean dirtyOnly, boolean includeEmptyText) /*-{
		var form = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		return form.getValues(false, dirtyOnly, includeEmptyText);
    }-*/;

    /**
     * Returns the fields in this form as a JavaScript Object
     * 
     * @return form field values as JavaScript Object
     */
    public native JavaScriptObject getValues(boolean dirtyOnly, boolean includeEmptyText, boolean useDataValues) /*-{
		var form = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		return form.getValues(falsee, dirtyOnly, includeEmptyText,
				useDataValues);
    }-*/;

    /**
     * Returns true if any fields in this form have changed since their original
     * load.
     * 
     * @return true if dirty
     */
    public native boolean isDirty() /*-{
		var form = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		return form.isDirty();
    }-*/;

    /**
     * Returns true if client-side validation on the form is successful.
     * 
     * @return true if valid
     */
    public native boolean isValid() /*-{
		var form = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		return form.isValid();
    }-*/;

    public void load(String url) {
        JavaScriptObject configJS = JsoHelper.createObject();
        JsoHelper.setAttribute(configJS, "url", url);
        load(configJS);
    }

    public void load(String url, UrlParam[] params, Connection.Method method, String waitMsg) {
        JavaScriptObject configJS = JsoHelper.createObject();
        JsoHelper.setAttribute(configJS, "url", url);
        if (params != null && params.length > 0) {
            JavaScriptObject paramObj = UrlParam.getJsObj(params);
            JsoHelper.setAttribute(configJS, "params", paramObj);
        }

        if (method != null) {
            JsoHelper.setAttribute(configJS, "method", method.getMethod());
        }
        if (waitMsg != null) {
            JsoHelper.setAttribute(jsObj, "waitMsg", waitMsg);
        }
        load(configJS);
    }

    private native void load(JavaScriptObject configJS) /*-{
		var form = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		form.load(configJS);
    }-*/;

    /**
     * Loads a {@link BaseModel} into this form.
     * 
     * @param record
     *            the BaseModel to load
     */
    public native void loadRecord(BaseModel record) /*-{
		var form = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		var recordJS = record.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		form.loadRecord(recordJS);
    }-*/;

    /**
     * Removes a field from the items collection (does NOT remove its markup).
     * 
     * @param field
     *            the field to remove
     */
    public native void remove(FieldBase field) /*-{
		var form = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		var fieldJS = field.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		form.remove(fieldJS);
    }-*/;

    /**
     * Resets this form.
     */
    public native void reset() /*-{
		var form = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		form.reset();
    }-*/;

    // setValues -- no need for now

    public native void submit() /*-{
		var form = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		form.submit();
    }-*/;

    public void submit(SubmitHandler handler) {
        submit(_getSubmitCallback(handler));
    }

    public void submit(String url, SubmitHandler handler) {
        JavaScriptObject configJS = JsoHelper.createObject();
        JsoHelper.setAttribute(configJS, "url", url);
        JsoHelper.setAttribute(configJS, "success", _getSuccessCallback(handler));
        JsoHelper.setAttribute(configJS, "failure", _getFailureCallback(handler));
        submit(configJS);
    }

    public void submit(String url, UrlParam[] params) {
        JavaScriptObject configJS = JsoHelper.createObject();
        JsoHelper.setAttribute(configJS, "url", url);
        if (params != null && params.length > 0) {
            JavaScriptObject paramObj = UrlParam.getJsObj(params);
            JsoHelper.setAttribute(configJS, "params", paramObj);
        }
        submit(configJS);
    }

    public void submit(String url, UrlParam[] params, SubmitHandler handler) {
        JavaScriptObject configJS = JsoHelper.createObject();
        JsoHelper.setAttribute(configJS, "url", url);
        if (params != null && params.length > 0) {
            JavaScriptObject paramObj = UrlParam.getJsObj(params);
            JsoHelper.setAttribute(configJS, "params", paramObj);
        }
        JsoHelper.setAttribute(configJS, "success", _getSuccessCallback(handler));
        JsoHelper.setAttribute(configJS, "failure", _getFailureCallback(handler));
        submit(configJS);
    }

    public void submit(String url, UrlParam[] params, Connection.Method method, SubmitHandler handler) {
        JavaScriptObject configJS = JsoHelper.createObject();
        JsoHelper.setAttribute(configJS, "url", url);
        if (params != null && params.length > 0) {
            JavaScriptObject paramObj = UrlParam.getJsObj(params);
            JsoHelper.setAttribute(configJS, "params", paramObj);
        }

        if (method != null) {
            JsoHelper.setAttribute(configJS, "method", method.getMethod());
        }
        JsoHelper.setAttribute(configJS, "success", _getSuccessCallback(handler));
        JsoHelper.setAttribute(configJS, "failure", _getFailureCallback(handler));
        submit(configJS);
    }

    public void submit(String url, UrlParam[] params, Connection.Method method, String waitMsg, boolean clientValidation) {
        JavaScriptObject configJS = JsoHelper.createObject();
        JsoHelper.setAttribute(configJS, "url", url);
        if (params != null && params.length > 0) {
            JavaScriptObject paramObj = UrlParam.getJsObj(params);
            JsoHelper.setAttribute(configJS, "params", paramObj);
        }

        if (method != null) {
            JsoHelper.setAttribute(configJS, "method", method.getMethod());
        }
        if (waitMsg != null) {
            JsoHelper.setAttribute(configJS, "waitMsg", waitMsg);
        }
        JsoHelper.setAttribute(configJS, "clientValidation", clientValidation);
        submit(configJS);
    }

    public void submit(String url, UrlParam[] params, Connection.Method method, String waitMsg,
                    boolean clientValidation, SubmitHandler handler) {
        JavaScriptObject configJS = JsoHelper.createObject();
        JsoHelper.setAttribute(configJS, "url", url);
        if (params != null && params.length > 0) {
            JavaScriptObject paramObj = UrlParam.getJsObj(params);
            JsoHelper.setAttribute(configJS, "params", paramObj);
        }

        if (method != null) {
            JsoHelper.setAttribute(configJS, "method", method.getMethod());
        }
        if (waitMsg != null) {
            JsoHelper.setAttribute(configJS, "waitMsg", waitMsg);
        }
        JsoHelper.setAttribute(configJS, "success", _getSuccessCallback(handler));
        JsoHelper.setAttribute(configJS, "failure", _getFailureCallback(handler));
        JsoHelper.setAttribute(configJS, "clientValidation", clientValidation);
        submit(configJS);
    }

    /**
     * Submit the form using the specified configuration.
     * 
     * @param configJS
     *            form submit config
     */
    private native void submit(JavaScriptObject configJS) /*-{
		var form = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		form.submit(configJS);
    }-*/;

    /**
     * Persists the values in this Form into the passed BaseModel object.
     * 
     * @param record
     *            the record to edit
     */
    public native Form updateRecord(BaseModel record) /*-{
		var form = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		var recordJS = record.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		form.updateRecord(recordJS);
		return this;
    }-*/;

    /**
     * Returns the last {@link BaseModel} instance that was loaded via
     * <code>loadRecord</code>
     */
    public native BaseModel getRecord() /*-{
		var form = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		var obj = form.getRecord();
		return @com.eemi.ext4j.client.data.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
    }-*/;

    private native JavaScriptObject _getSubmitCallback(SubmitHandler handler)/*-{
		return {
			success : function(f, a) {
				var form = @com.eemi.ext4j.client.ui.Form::new(Lcom/google/gwt/core/client/JavaScriptObject;)(f);
				var action = @com.eemi.ext4j.client.form.Action::new(Lcom/google/gwt/core/client/JavaScriptObject;)(a);
				handler.@com.eemi.ext4j.client.events.form.SubmitHandler::onSuccess(Lcom/eemi/ext4j/client/ui/Form;Lcom/eemi/ext4j/client/form/Action;)(form,action);
			},
			failure : function(f, a) {
				var form = @com.eemi.ext4j.client.ui.Form::new(Lcom/google/gwt/core/client/JavaScriptObject;)(f);
				var action = @com.eemi.ext4j.client.form.Action::new(Lcom/google/gwt/core/client/JavaScriptObject;)(a);
				handler.@com.eemi.ext4j.client.events.form.SubmitHandler::onFailure(Lcom/eemi/ext4j/client/ui/Form;Lcom/eemi/ext4j/client/form/Action;)(form,action);
			}
		};
    }-*/;

    private native JavaScriptObject _getSuccessCallback(SubmitHandler handler)/*-{
		return {
			success : function(f, a) {
				var form = @com.eemi.ext4j.client.ui.Form::new(Lcom/google/gwt/core/client/JavaScriptObject;)(f);
				var action = @com.eemi.ext4j.client.form.Action::new(Lcom/google/gwt/core/client/JavaScriptObject;)(a);
				handler.@com.eemi.ext4j.client.events.form.SubmitHandler::onSuccess(Lcom/eemi/ext4j/client/ui/Form;Lcom/eemi/ext4j/client/form/Action;)(form,action);
			}
		};
    }-*/;

    private native JavaScriptObject _getFailureCallback(SubmitHandler handler)/*-{
		return {

			failure : function(f, a) {
				var form = @com.eemi.ext4j.client.ui.Form::new(Lcom/google/gwt/core/client/JavaScriptObject;)(f);
				var action = @com.eemi.ext4j.client.form.Action::new(Lcom/google/gwt/core/client/JavaScriptObject;)(a);
				handler.@com.eemi.ext4j.client.events.form.SubmitHandler::onFailure(Lcom/eemi/ext4j/client/ui/Form;Lcom/eemi/ext4j/client/form/Action;)(form,action);
			}
		};
    }-*/;

}
