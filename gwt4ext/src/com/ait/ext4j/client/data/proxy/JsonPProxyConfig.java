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
package com.ait.ext4j.client.data.proxy;

import com.ait.ext4j.client.core.JsoHelper;
import com.ait.ext4j.client.data.reader.ReaderConfig;

/**
 * Configuration object for Proxy
 */
public class JsonPProxyConfig extends ServerProxyConfig {

    public JsonPProxyConfig() {
        jsObj = JsoHelper.createObject();
        this.setType("jsonp");
    }

    public JsonPProxyConfig(ReaderConfig reader) {
        this();
        setReader(reader);
    }

    public JsonPProxyConfig(String url, ReaderConfig reader) {
        this(reader);
        setUrl(url);
    }

    public void setAutoAppendParams(boolean value) {
        JsoHelper.setAttribute(jsObj, "autoAppendParams", value);
    }

    public void setCallbackKey(String value) {
        JsoHelper.setAttribute(jsObj, "callbackKey", value);
    }

    public void setRecordParam(String value) {
        JsoHelper.setAttribute(jsObj, "recordParam", value);
    }

    public void setParamsAsJson(boolean value) {
        JsoHelper.setAttribute(jsObj, "paramsAsJson", value);
    }
}
