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
package com.ait.ext4j.client.state;

import com.ait.ext4j.client.core.JsObject;
import com.ait.ext4j.client.events.state.StateChangeHandler;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * Abstract base class for state provider implementations. The provider is
 * responsible for setting values and extracting values to/from the underlying
 * storage source. The storage source can vary and the details should be
 * implemented in a subclass. For example a provider could use a server side
 * database or the browser localstorage where supported.
 * <p>
 * This class provides methods for encoding and decoding typed variables
 * including dates and defines the Provider interface. By default these methods
 * put the value and the type information into a delimited string that can be
 * stored. These should be overridden in a subclass if you want to change the
 * format of the encoded value and subsequent decoding.
 */
public abstract class Provider extends JsObject {

    public Provider() {

    }

    Provider(JavaScriptObject obj) {
        jsObj = obj;
    }

    /**
     * Clears a value from the state.
     * 
     * @param name
     *            the key name
     */
    public native void clear(String name) /*-{
		var provider = this.@com.ait.ext4j.client.core.JsObject::getJsObj()();
		provider.clear(name);
    }-*/;

    /**
     * Returns the current value for a key
     * 
     * @param name
     *            the key name
     * @return the key value as String
     */
    public native String getAsString(String name) /*-{
		var provider = this.@com.ait.ext4j.client.core.JsObject::getJsObj()();
		var val = provider.get(name);
		return val === undefined ? null : val.toString();
    }-*/;

    /**
     * Returns the current value for a key
     * 
     * @param name
     *            the key name
     * @return the key value as String
     */
    public native double getAsNumber(String name) /*-{
		var provider = this.@com.ait.ext4j.client.core.JsObject::getJsObj()();
		var val = provider.get(name);
		return val === undefined ? null : val;
    }-*/;

    /**
     * Returns the current value for a key
     * 
     * @param name
     *            the key name
     * @return the key value as String
     */
    public native boolean getAsBoolean(String name) /*-{
		var provider = this.@com.ait.ext4j.client.core.JsObject::getJsObj()();
		var val = provider.get(name);
		return val === undefined ? null : val;
    }-*/;

    /**
     * Returns the current value for a key
     * 
     * @param name
     *            the key name
     * @return the key value as String
     */
    public native Object get(String name) /*-{
		var provider = this.@com.ait.ext4j.client.core.JsObject::getJsObj()();
		var val = provider.get(name);
		return val === undefined ? null : val;
    }-*/;

    /**
     * Sets the value for a key.
     * 
     * @param name
     *            the key name
     * @param value
     *            the key value
     */
    public native void set(String name, String value) /*-{
		var provider = this.@com.ait.ext4j.client.core.JsObject::getJsObj()();
		provider.set(name, value);
    }-*/;

    /**
     * Sets the value for a key.
     * 
     * @param name
     *            the key name
     * @param value
     *            the key value
     */
    public native void set(String name, double value) /*-{
		var provider = this.@com.ait.ext4j.client.core.JsObject::getJsObj()();
		provider.set(name, value);
    }-*/;

    /**
     * Sets the value for a key.
     * 
     * @param name
     *            the key name
     * @param value
     *            the key value
     */
    public native void set(String name, Object value) /*-{
		var provider = this.@com.ait.ext4j.client.core.JsObject::getJsObj()();
		provider.set(name, value);
    }-*/;

    /**
     * Fires when a state change occurs.
     * 
     * @param handler
     *            , the handler that will handle the event
     */
    public native void addStateChangeHandler(StateChangeHandler handler)/*-{
		var component = this.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()();
		if (component) {
			component
					.addListener(
							'statechange',
							$entry(function(p, k, v) {
								var provider = @com.ait.ext4j.client.state.CookieProvider::new(Lcom/ait/ext4j/client/state/CookieProviderConfig;)(provider);
								handler.@com.ait.ext4j.client.events.state.StateChangeHandler::onEvent(Lcom/ait/ext4j/client/state/Provider;Ljava/lang/String;Ljava/lang/Object;)(providre,k,v);
							}));
		}

    }-*/;

    private static Provider instance(JavaScriptObject obj) {
        return new Provider(obj) {
        };
    }

}
