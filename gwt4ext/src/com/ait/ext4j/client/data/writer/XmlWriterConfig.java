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

public class XmlWriterConfig extends WriterConfig {

    public XmlWriterConfig() {
        jsObj = JsoHelper.createObject();
    }

    public XmlWriterConfig(JavaScriptObject peer) {
        jsObj = peer;
    }

    public void setDefaultDocumentRoot(String value) {
        JsoHelper.setAttribute(jsObj, "defaultDocumentRoot", value);
    }

    public void setDocumentRoot(String value) {
        JsoHelper.setAttribute(jsObj, "documentRoot", value);
    }

    public void setHeader(String value) {
        JsoHelper.setAttribute(jsObj, "header", value);
    }

    public void setRecord(String value) {
        JsoHelper.setAttribute(jsObj, "record", value);
    }

}
