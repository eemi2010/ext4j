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
package com.eemi.ext4j.client.data.proxy;

import com.eemi.ext4j.client.core.JsoHelper;
import com.eemi.ext4j.client.core.config.BaseConfig;
import com.eemi.ext4j.client.data.BaseModel;
import com.eemi.ext4j.client.data.reader.Reader;
import com.eemi.ext4j.client.data.reader.ReaderConfig;
import com.eemi.ext4j.client.data.writer.Writer;
import com.eemi.ext4j.client.data.writer.WriterConfig;

/**
 * Configuration object for Proxy
 */
public class ProxyConfig extends BaseConfig {

    public ProxyConfig() {
        jsObj = JsoHelper.createObject();
    }

    public void setBatchActions(boolean value) {
        JsoHelper.setAttribute(jsObj, "batchActions", value);
    }

    public void setType(String value) {
        JsoHelper.setAttribute(jsObj, "type", value);
    }

    public void setBatchOrder(String value) {
        JsoHelper.setAttribute(jsObj, "batchOrder", value);
    }

    public void setSuccessProperty(String value) {
        JsoHelper.setAttribute(jsObj, "successProperty", value);
    }

    public void setModel(String value) {
        JsoHelper.setAttribute(jsObj, "model", value);
    }

    public void setModel(BaseModel value) {
        JsoHelper.setAttribute(jsObj, "model", value.getJsObj());
    }

    public void setReader(ReaderConfig value) {
        JsoHelper.setAttribute(jsObj, "reader", value.getJsObj());
    }

    public void setReader(Reader value) {
        JsoHelper.setAttribute(jsObj, "reader", value.getJsObj());
    }

    public void setReader(String value) {
        JsoHelper.setAttribute(jsObj, "reader", value);
    }

    public void setWriter(Writer value) {
        JsoHelper.setAttribute(jsObj, "writer", value.getJsObj());
    }

    public void setWriter(WriterConfig value) {
        JsoHelper.setAttribute(jsObj, "writer", value.getJsObj());
    }

    public void setWriter(String value) {
        JsoHelper.setAttribute(jsObj, "writer", value);
    }

}
