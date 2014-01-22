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
package com.eemi.ext4j.client.data.writer;

import com.eemi.ext4j.client.core.JsObject;
import com.eemi.ext4j.client.core.JsoHelper;
import com.google.gwt.core.client.JavaScriptObject;

public class WriterConfig extends JsObject {

    public WriterConfig() {
        jsObj = JsoHelper.createObject();
    }

    public void setDateFormat(String value) {
        JsoHelper.setAttribute(jsObj, "dateFormat", value);
    }

    public void setNameProperty(String value) {
        JsoHelper.setAttribute(jsObj, "nameProperty", value);
    }

    public void setWriteAllFields(boolean value) {
        JsoHelper.setAttribute(jsObj, "writeAllFields", value);
    }

    public void setWriteRecordId(boolean value) {
        JsoHelper.setAttribute(jsObj, "writeRecordId", value);
    }

    public WriterConfig(JavaScriptObject peer) {
        jsObj = peer;
    }
}
