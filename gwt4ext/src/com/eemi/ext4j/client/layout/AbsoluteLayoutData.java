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
package com.eemi.ext4j.client.layout;

import com.eemi.ext4j.client.core.JsoHelper;
import com.google.gwt.core.client.JavaScriptObject;

public class AbsoluteLayoutData extends LayoutData {

    private int x;
    private int y;

    public AbsoluteLayoutData(int x, int y) {
        this.x = x;
        this.y = y;
        JsoHelper.setAttribute(jsObj, "x", x);
        JsoHelper.setAttribute(jsObj, "y", y);
    }

    public JavaScriptObject getContainerAttributes() {
        JavaScriptObject containerJS = JsoHelper.createObject();
        JsoHelper.setAttribute(containerJS, "x", x);
        JsoHelper.setAttribute(containerJS, "y", y);
        return containerJS;
    }

}