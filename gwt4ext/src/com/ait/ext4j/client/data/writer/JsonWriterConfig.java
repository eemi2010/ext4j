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
package com.ait.ext4j.client.data.writer;

import com.ait.ext4j.client.core.JsoHelper;
import com.google.gwt.core.client.JavaScriptObject;

public class JsonWriterConfig extends WriterConfig {

    public JsonWriterConfig() {
        jsObj = JsoHelper.createObject();
    }

    public void setAllowSingle(boolean value) {
        JsoHelper.setAttribute(jsObj, "allowSingle", value);
    }

    public void setEncode(boolean value) {
        JsoHelper.setAttribute(jsObj, "encode", value);
    }

    public void setExpandData(boolean value) {
        JsoHelper.setAttribute(jsObj, "expandData", value);
    }

    public void setRoot(String value) {
        JsoHelper.setAttribute(jsObj, "root", value);
    }

    public JsonWriterConfig(JavaScriptObject peer) {
        jsObj = peer;
    }
}
