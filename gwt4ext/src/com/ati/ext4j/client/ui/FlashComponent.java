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
package com.ati.ext4j.client.ui;

import com.ati.ext4j.client.core.Component;
import com.ati.ext4j.client.core.ExtElement;
import com.ati.ext4j.client.core.config.XType;
import com.ati.ext4j.client.events.HandlerRegistration;
import com.ati.ext4j.client.events.flash.FailureHandler;
import com.ati.ext4j.client.events.flash.SuccessHandler;
import com.ati.ext4j.client.laf.Color;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * A simple Component for displaying an Adobe Flash SWF movie. The movie will be
 * sized and can participate in layout like any other Component.
 * 
 * <p>
 * This component requires the third-party SWFObject library version 2.2 or
 * above. It is not included within the ExtJS distribution, so you will have to
 * include it into your page manually in order to use this component. The
 * SWFObject library can be downloaded from the SWFObject project page and then
 * simply import it into the head of your HTML document:
 * 
 * {@code
 * <script type="text/javascript" src="path/to/local/swfobject.js"></script>
 * }
 * 
 * 
 * 
 */
public class FlashComponent extends Component {

    private static JavaScriptObject configPrototype;

    private native void init()/*-{
		var c = new $wnd.Ext.flash.FlashComponent();
		@com.ati.ext4j.client.ui.FlashComponent::configPrototype = c.initialConfig;
    }-*/;

    protected JavaScriptObject getConfigPrototype() {
        return configPrototype;
    }

    public String getXType() {
        return XType.FLASH.getValue();
    }

    public FlashComponent(String url) {
        setUrl(url);
    }

    protected FlashComponent(JavaScriptObject obj) {
        super(obj);
    }

    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.flash.FlashComponent(config);
    }-*/;

    /**
     * The URL of the SWF file to include. This is required
     * 
     * @param url
     */
    public void setUrl(String url) {
        setAttribute("url", url, true);
    }

    /**
     * Adobe provides a tool called Express Install that offers users an easy
     * way to upgrade their Flash player. If you wish to make use of this, you
     * should set the static EXPRESS_INSTALL_URL property to the location of
     * your Express Install SWF file.
     */
    public static native void setExpressInstallUrl(String value)/*-{
		$wnd.Ext.flash.Component.EXPRESS_INSTALL_URL = value;
    }-*/;

    /**
     * The background color of the SWF movie.
     * 
     * Defaults to: "#ffffff"
     * 
     * @param value
     */
    public void setBackgroundColor(String value) {
        setAttribute("backgroundColor", value, true);
    }

    /**
     * The background color of the SWF movie.
     * 
     * Defaults to: "#ffffff"
     * 
     * @param color
     */
    public void setBackgroundColor(Color color) {
        setBackgroundColor(color.getValue());
    }

    /**
     * True to prompt the user to install flash if not installed. Note that this
     * uses Ext.FlashComponent.EXPRESS_INSTALL_URL, which should be set to the
     * local resource.
     * 
     * Defaults to: false
     * 
     * @param value
     */
    public void setExpressInstall(boolean value) {
        setAttribute("expressInstall", value, true);
    }

    /**
     * Indicates the version the flash content was published for.
     * 
     * Defaults to: "9.0.115"
     * 
     * @param value
     */
    public void setFlashVersion(String value) {
        setAttribute("flashVersion", value, true);
    }

    /**
     * The width of the embedded SWF movie inside the component.
     * 
     * Defaults to "100%" so that the movie matches the height of the component.
     * 
     * 
     * @param value
     */
    public void setSwfWidth(String value) {
        setAttribute("swfWidth", value, true);
    }

    /**
     * The width of the embedded SWF movie inside the component.
     * 
     * Defaults to "100%" so that the movie matches the height of the component.
     * 
     * 
     * @param value
     */
    public void setSwfWidth(double value) {
        setAttribute("swfWidth", value, true);
    }

    /**
     * The height of the embedded SWF movie inside the component.
     * 
     * Defaults to "100%" so that the movie matches the height of the component.
     * 
     * 
     * @param value
     */
    public void setSwfHeight(String value) {
        setAttribute("swfHeight", value, true);
    }

    /**
     * The height of the embedded SWF movie inside the component.
     * 
     * Defaults to "100%" so that the movie matches the height of the component.
     * 
     * 
     * @param value
     */
    public void setSwfHeight(double value) {
        setAttribute("swfHeight", value, true);
    }

    /**
     * The wmode of the flash object. This can be used to control layering. Set
     * to 'transparent' to ignore the backgroundColor and make the background of
     * the Flash movie transparent.
     * 
     * Defaults to: "opaque"
     * 
     * 
     * @param value
     */
    public void setWmode(double value) {
        setAttribute("wMode", value, true);
    }

    /**
     * A reference to the object or embed element into which the SWF file is
     * loaded. Only populated after the component is rendered and the SWF has
     * been successfully embedded.
     * 
     * @return
     */
    public native ExtElement getSwf()/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var obj = component.swf;
		return @com.ati.ext4j.client.core.ExtElement::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
    }-*/;

    /**
     * Retrieves the id of the SWF object/embed element.
     * 
     * @return
     */
    public native ExtElement getSwfId()/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		return component.getSwfId();
    }-*/;

    /**
     * Listen when the Flash movie embedding fails
     * 
     * @param handler
     *            , the handler that will handle the event
     */

    public native HandlerRegistration addFailureHandler(FailureHandler handler)/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(cmp, e) {
			var component = @com.ati.ext4j.client.ui.FlashComponent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(cmp);
			var event = @com.ati.ext4j.client.events.flash.FailureEvent::new(Lcom/ati/ext4j/client/ui/FlashComponent;Lcom/google/gwt/core/client/JavaScriptObject;)(component,e);
			handler.@com.ati.ext4j.client.events.flash.FailureHandler::onFailure(Lcom/ati/ext4j/client/events/flash/FailureEvent;)(event);
		};
		var eventName = @com.ati.ext4j.client.events.flash.FailureEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ati.ext4j.client.events.HandlerRegistration::new(Lcom/ati/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;

    }-*/;

    /**
     * Listen when the Flash movie has been successfully embedded
     * 
     * @param handler
     *            , the handler that will handle the event
     */

    public native HandlerRegistration addSuccessHandler(SuccessHandler handler)/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(cmp, e) {
			var component = @com.ati.ext4j.client.ui.FlashComponent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(cmp);
			var event = @com.ati.ext4j.client.events.flash.SuccessEvent::new(Lcom/ati/ext4j/client/ui/FlashComponent;Lcom/google/gwt/core/client/JavaScriptObject;)(component,e);
			handler.@com.ati.ext4j.client.events.flash.SuccessHandler::onSuccess(Lcom/ati/ext4j/client/events/flash/SuccessEvent;)(event);
		};
		var eventName = @com.ati.ext4j.client.events.flash.SuccessEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ati.ext4j.client.events.HandlerRegistration::new(Lcom/ati/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;

    }-*/;

    public static FlashComponent cast(Component component) {
        return new FlashComponent(component.getOrCreateJsObj());
    }

    // TODO Flashvars, FlashParams,FlashAttributes

}
