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
package com.eemi.ext4j.client.connection;

import com.eemi.ext4j.client.core.JsObject;
import com.eemi.ext4j.client.core.JsoHelper;
import com.eemi.ext4j.client.core.NameValuePair;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * This class represents a HTTP Request.
 * 
 * @see com.eemi.ext4j.client.connection.Connection#request(RequestParam)
 */
public class RequestParam extends JsObject {

    public RequestParam() {
        jsObj = JsoHelper.createObject();
    }

    /**
     * The URL of the request.
     * 
     * @param url
     *            the rul
     */
    public void setUrl(String url) {
        JsoHelper.setAttribute(jsObj, "url", url);
    }

    /**
     * The request parameters.
     * 
     * @param params
     *            the request parameters
     */
    public void setParams(UrlParam... params) {
        JavaScriptObject paramObj = UrlParam.getJsObj(params);
        JsoHelper.setAttribute(jsObj, "params", paramObj);
    }

    /**
     * The request method (GET or POST).
     * 
     * @param method
     *            the request method
     */
    public void setMethod(Connection.Method method) {
        JsoHelper.setAttribute(jsObj, "method", method.getMethod());
    }

    /**
     * The ID of the form that you want to use. The request parameters will
     * include the Form's field names and values.
     * 
     * @param formId
     *            the form ID
     */
    public void setForm(String formId) {
        JsoHelper.setAttribute(jsObj, "form", formId);
    }

    /**
     * Does the form do a file upload.
     * 
     * @param isUpload
     *            true if file upload
     */
    public void setIsUpload(boolean isUpload) {
        JsoHelper.setAttribute(jsObj, "isUpload", isUpload);
    }

    /**
     * The headers to pass with the request.
     * 
     * @param defaultHeaders
     *            the headers
     */
    public void setHeaders(NameValuePair... defaultHeaders) {
        JavaScriptObject paramObj = NameValuePair.getJsObj(defaultHeaders);
        JsoHelper.setAttribute(jsObj, "headers", paramObj);
    }

    public void setTimeOut(int value) {
        JsoHelper.setAttribute(jsObj, "timeout", value);
    }

    public native void setRequestHandler(RequestHandler callback)/*-{
		var obj = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		obj.success = $entry(function(r) {
			var response = @com.eemi.ext4j.client.connection.Response::new(Lcom/google/gwt/core/client/JavaScriptObject;)(r);
			callback.@com.eemi.ext4j.client.connection.RequestHandler::onSuccess(Lcom/eemi/ext4j/client/connection/Response;)(response);
		});
		obj.failure = $entry(function(r) {
			var response = @com.eemi.ext4j.client.connection.Response::new(Lcom/google/gwt/core/client/JavaScriptObject;)(r);
			callback.@com.eemi.ext4j.client.connection.RequestHandler::onError(Lcom/eemi/ext4j/client/connection/Response;)(response);
		});
    }-*/;

    public native void setRequestCallback(RequestCallback callback)/*-{
		var obj = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		obj.callback = $entry(function(o, success, r) {
			var response = @com.eemi.ext4j.client.connection.Response::new(Lcom/google/gwt/core/client/JavaScriptObject;)(r);
			callback.@com.eemi.ext4j.client.connection.RequestCallback::onCallback(Lcom/google/gwt/core/client/JavaScriptObject;ZLcom/eemi/ext4j/client/connection/Response;)(o,success,response);
		});

    }-*/;

    public void setDisableCaching(boolean value) {
        JsoHelper.setAttribute(jsObj, "disableCaching", value);
    }

    public void setBinary(boolean value) {
        JsoHelper.setAttribute(jsObj, "binary", value);
    }

    public void setXmlData(Object value) {
        JsoHelper.setAttribute(jsObj, "xmlData", value);
    }

    public void setJsonData(Object value) {
        JsoHelper.setAttribute(jsObj, "jsonData", value);
    }

    public void setJsonData(String value) {
        JsoHelper.setAttribute(jsObj, "jsonData", value);
    }

}
