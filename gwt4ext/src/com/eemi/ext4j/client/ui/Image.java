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
package com.eemi.ext4j.client.ui;

import com.eemi.ext4j.client.core.Component;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.resources.client.ImageResource;

/**
 * Simple helper class for easily creating image components. This simply renders
 * an image tag to the DOM with the configured src.
 * 
 */
public class Image extends Component {

    private static JavaScriptObject configPrototype;
    private com.google.gwt.user.client.ui.Image imageResource = new com.google.gwt.user.client.ui.Image();

    private native void init()/*-{
		var c = new $wnd.Ext.window.Window();
		@com.eemi.ext4j.client.ui.Image::configPrototype = c.initialConfig;
    }-*/;

    protected JavaScriptObject getConfigPrototype() {
        return configPrototype;
    }

    public String getXType() {
        return "image";
    }

    @Override
    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.Img(config);
    }-*/;

    public Image() {

    }

    public Image(JavaScriptObject peer) {
        super(peer);
    }

    public Image(String src) {
        this();
        setSrc(src);
    }

    public Image(ImageResource r) {
        this();
        imageResource.setResource(r);
        setSrc(imageResource.getUrl());

    }

    public void setSrc(ImageResource resource) {
        imageResource.setResource(resource);
        setSrc(imageResource.getUrl());
    }

    /**
     * Updates the src of the image.
     * 
     * @param value
     */
    public native void setSrc(String value) /*-{
		var image = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		image.setSrc(value);
    }-*/;

    /**
     * The descriptive text for non-visual UI description.
     * 
     * Defaults to: ""
     * 
     * @param value
     */
    public void setAlt(String value) {
        setAttribute("alt", value, true);
    }

    /**
     * Specifies addtional information about the image.
     * <p>
     * Defaults to: ''
     */
    public void setTitle(String value) {
        setAttribute("title", value, true);
    }

    /**
     * Optional CSS classes to add to the img element
     * <p>
     * Defaults to: ''
     */
    public void setImageCls(String value) {
        setAttribute("imgCls", value, true);
    }

    public static Image cast(Component component) {
        return new Image(component.getOrCreateJsObj());
    }

}
