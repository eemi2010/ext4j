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
package com.ati.ext4j.client.data.proxy;

import com.ati.ext4j.client.core.JsoHelper;
import com.ati.ext4j.client.data.reader.ReaderConfig;
import com.google.gwt.core.client.JavaScriptObject;

public class AjaxProxyConfig extends ServerProxyConfig {

    public AjaxProxyConfig() {
        jsObj = JsoHelper.createObject();
        this.setType("ajax");

    }

    public AjaxProxyConfig(ReaderConfig reader) {
        this();
        setReader(reader);
    }

    public AjaxProxyConfig(String url) {
        this();
        setUrl(url);
    }

    public AjaxProxyConfig(String url, ReaderConfig reader) {
        this(reader);
        setUrl(url);
    }

    public void setBinary(boolean value) {
        JsoHelper.setAttribute(jsObj, "binary", value);
    }

    public void setHeaders(JavaScriptObject value) {
        JsoHelper.setAttribute(jsObj, "headers", value);
    }

    public void setParamsAsJson(boolean value) {
        JsoHelper.setAttribute(jsObj, "paramsAsJson", value);
    }
}
