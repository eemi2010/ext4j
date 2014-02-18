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
package com.ait.ext4j.client.connection;

import com.ait.ext4j.client.core.JsoHelper;
import com.ait.ext4j.client.core.NameValuePair;
import com.ait.ext4j.client.core.config.BaseConfig;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * Connection configuration class.
 */
public class ConnectionConfig extends BaseConfig {

    /**
     * Whether this request should abort any pending requests.
     * 
     * @param autoAbort
     *            defaults to false
     */
    public void setAutoAbort(boolean autoAbort) {
        JsoHelper.setAttribute(jsObj, "autoAbort", autoAbort);
    }

    /**
     * Request headers which are added to each request made by this object.
     * 
     * @param defaultHeaders
     *            default headers
     */
    public void setDefaultHeaders(NameValuePair[] defaultHeaders) {
        JavaScriptObject paramObj = NameValuePair.getJsObj(defaultHeaders);
        JsoHelper.setAttribute(jsObj, "defaultHeaders", paramObj);
    }

    /**
     * Properties which are used as extra parameters to each request made by
     * this object.
     * 
     * @param params
     *            request parameters
     */
    public void setExtraParams(UrlParam[] params) {
        JavaScriptObject paramObj = UrlParam.getJsObj(params);
        JsoHelper.setAttribute(jsObj, "extraParams", paramObj);
    }

    /**
     * Sets the method (GET or POST) for the operation.
     * 
     * @param method
     *            the method
     * @see com.ait.ext4j.client.connection.Connection#GET
     * @see com.ait.ext4j.client.connection.Connection#POST
     */
    public void setMethod(Connection.Method method) {
        JsoHelper.setAttribute(jsObj, "method", method.getMethod());
    }

    /**
     * The timeout in milliseconds to be used for requests. (defaults to 30000)
     * 
     * @param timeout
     *            timout
     */
    public void setTimeout(int timeout) {
        JsoHelper.setAttribute(jsObj, "timeout", timeout);
    }

    /**
     * The default URL to be used for requests to the server.
     * 
     * @param url
     *            defaults to undefined
     */
    public void setUrl(String url) {
        JsoHelper.setAttribute(jsObj, "url", url);
    }
}
