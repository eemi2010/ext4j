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
package com.ati.ext4j.client.connection;

import com.ati.ext4j.client.core.NameValuePair;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * This class represents a Request URL parameter.
 * 
 */
public class UrlParam extends NameValuePair {

    public UrlParam(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public UrlParam(String paramName, String paramValue) {
        super(paramName, paramValue);
    }

    public UrlParam(String paramName, boolean paramValue) {
        super(paramName, paramValue);
    }

    public UrlParam(String paramName, float paramValue) {
        super(paramName, paramValue);
    }

    public UrlParam(String paramName, int paramValue) {
        super(paramName, paramValue);
    }

    public static UrlParam instance(String paramName, String paramValue) {
        return new UrlParam(paramName, paramValue);
    }
}
