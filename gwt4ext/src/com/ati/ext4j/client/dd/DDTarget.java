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
package com.ati.ext4j.client.dd;

import com.ati.ext4j.client.core.Component;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;

/**
 * 
 * @author Alain Ekambi
 */
public class DDTarget extends DragDrop {

    public DDTarget(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public DDTarget(String id, String sGroup, DragDropConfig config) {
        super(id, sGroup, config);
    }

    public DDTarget(Element element, String sGroup, DragDropConfig config) {
        super(element, sGroup, config);
    }

    public DDTarget(Component component, String sGroup, DragDropConfig config) {
        super(component, sGroup, config);
    }

    protected native JavaScriptObject create(String id, String sGroup, JavaScriptObject config)/*-{
		return new $wnd.Ext.dd.DDTarget(id, sGroup, config);
    }-*/;

    protected native JavaScriptObject create(Element element, String sGroup, JavaScriptObject config)/*-{
		return new $wnd.Ext.dd.DDTarget(element, sGroup, config);
    }-*/;

}
