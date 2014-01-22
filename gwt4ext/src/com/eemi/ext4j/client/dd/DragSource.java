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
package com.eemi.ext4j.client.dd;

import com.eemi.ext4j.client.core.Component;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;

public class DragSource extends DDProxy {

    public DragSource(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public DragSource(String id, DragSourceConfig config) {
        super(id, null, config);
    }

    public DragSource(Component component, DragSourceConfig config) {
        super(component, null, config);
    }

    public DragSource(Element el, DragSourceConfig config) {
        super(el, null, config);
    }

    protected native JavaScriptObject create(String id, String sGroup, JavaScriptObject config)/*-{
		return new $wnd.Ext.dd.DragSource(id, config);
    }-*/;

    protected native JavaScriptObject create(Element element, String sGroup, JavaScriptObject config)/*-{
		return new $wnd.Ext.dd.DragSource(element, config);
    }-*/;

    private static DragSource dragSourceInstance(JavaScriptObject jsObj) {
        return new DragSource(jsObj);
    }

    public native StatusProxy getProxy() /*-{
		var ds = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		var proxy = ds.getProxy();
		return @com.eemi.ext4j.client.dd.StatusProxy::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(proxy);
    }-*/;

}
