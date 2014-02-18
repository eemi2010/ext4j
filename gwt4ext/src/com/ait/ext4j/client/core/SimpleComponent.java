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
package com.ait.ext4j.client.core;

import com.ait.ext4j.client.core.config.XType;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * Usually one doesn't need to instantiate the Ext.Component class. There are
 * subclasses which implement specialized use cases, covering most application
 * needs. However it is possible to instantiate a base Component, and it can be
 * rendered to document, or handled by layouts as the child item of a Container
 * 
 * @author alainekambi
 * 
 */
public class SimpleComponent extends Component {

    private static JavaScriptObject configPrototype;

    private native void init()/*-{
		var c = new $wnd.Ext.Component();
		@com.ait.ext4j.client.core.SimpleComponent::configPrototype = c.initialConfig;
    }-*/;

    protected JavaScriptObject getConfigPrototype() {
        return configPrototype;
    }

    public String getXType() {
        return XType.COMPONENT.getValue();
    }

    /**
     * Create a new NotificationContainer.
     */
    public SimpleComponent() {
        init();
        setFlex(1);
    }

    public SimpleComponent(int flex) {
        setFlex(flex);
    }

    protected SimpleComponent(JavaScriptObject obj) {
        super(obj);
    }

    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.Component(config);
    }-*/;

    public static SimpleComponent createComponent(JavaScriptObject peer) {
        return new SimpleComponent(peer);
    }

}
