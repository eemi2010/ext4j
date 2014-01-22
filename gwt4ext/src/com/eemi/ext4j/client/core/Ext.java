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
package com.eemi.ext4j.client.core;

import java.util.Set;

import com.eemi.ext4j.client.core.config.BaseConfig;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.user.client.Element;

/**
 * Ext core utilities and functions.
 * 
 */

public class Ext {

    private Ext() {

    }

    /**
     * The version of the underlying ExtJS Framework
     * 
     * @return, the version of ExtJS
     */
    public static native String getVersion()/*-{
		return $wnd.Ext.version;
    }-*/;

    /**
     * URL to a blank file used by Ext when in secure mode for iframe src and
     * onReady src to prevent the IE insecure content warning (defaults to
     * javascript:false).
     * 
     * @param url
     *            the url
     */
    public static native void setSslSecureUrl(String url)/*-{
		$wnd.Ext.SSL_SECURE_URL = url;
    }-*/;

    /**
     * Indicates whether to use native browser parsing for JSON methods. This
     * option is ignored if the browser does not support native JSON methods.
     * <p>
     * Note: Native JSON methods will not work with objects that have functions.
     * Also, property names must be quoted, otherwise the data will not parse.
     * <p>
     * Defaults to: false*
     */
    public static native void setUseNativeJson(boolean useNativeJson)/*-{
		$wnd.Ext.USE_NATIVE_JSON = useNativeJson;
    }-*/;

    /**
     * Indicates whether to use native browser parsing for JSON methods. This
     * option is ignored if the browser does not support native JSON methods.
     * <p>
     * Note: Native JSON methods will not work with objects that have functions.
     * Also, property names must be quoted, otherwise the data will not parse.
     * <p>
     * Defaults to: false*
     */
    public static native boolean useNativeJson()/*-{
		return $wnd.Ext.USE_NATIVE_JSON;
    }-*/;

    /**
     * True if the Ext.fx.Anim Class is available.
     */
    public static native boolean isFxEnabled()/*-{
		return $wnd.Ext.enableFx;
    }-*/;

    /**
     * The current version of Chrome (0 if the browser is not Chrome).
     */
    public static native double getChromeVersion()/*-{
		return $wnd.Ext.chromeVersion;
    }-*/;

    /**
     * True to automatically uncache orphaned Ext.Elements periodically
     * (defaults to true).
     * 
     * @param enableGarbageCollector
     *            true to enable GC
     */
    public static native void setEnableGarbageCollector(boolean enableGarbageCollector)/*-{
		$wnd.Ext.enableGarbageCollector = enableGarbageCollector;
    }-*/;

    /**
     * Returns is Garbage Collector is enabled.
     * 
     * @return true if GC enabled
     */
    public static native boolean isEnableGarbageCollector()/*-{
		return $wnd.Ext.enableGarbageCollector;
    }-*/;

    /**
     * True to automatically purge event listeners after uncaching an element
     * (defaults to false). Note: this only happens if enableGarbageCollector is
     * true.
     * 
     * @param enableListenerCollection
     *            true to enable listener collection
     */
    public static native void setEnableListenerCollection(boolean enableListenerCollection)/*-{
		$wnd.Ext.enableListenerCollection = enableListenerCollection;
    }-*/;

    /**
     * Retruns true if listener collection is true.
     * 
     * @return true if listener collection is enabled
     */
    public static native boolean isEnableListenerCollection()/*-{
		return $wnd.Ext.enableListenerCollection;
    }-*/;

    /**
     * @return true if bodex box
     */
    public static native boolean isBorderBox()/*-{
		return $wnd.Ext.isBorderBox;
    }-*/;

    /**
     * The current version of Firefox (0 if the browser is not Firefox).
     * 
     * @return
     */
    public static native double getFirefoxVersion()/*-{
		return $wnd.Ext.firefoxVersion;
    }-*/;

    /**
     * The current version of IE (0 if the browser is not Firefox).
     * 
     * @return
     */
    public static native double geIEVersion()/*-{
		return $wnd.Ext.ieVersion;
    }-*/;

    /**
     * True if the detected browser is Chrome.
     * 
     * @return
     */
    public static native boolean isChrome()/*-{
		return $wnd.Ext.isChrome;
    }-*/;

    /**
     * True if the detected browser uses FireFox 10
     * 
     * @return
     */
    public static native boolean isFF10()/*-{
		return $wnd.Ext.isFF10;
    }-*/;

    /**
     * T rue if the detected browser uses FireFox 3.0
     * 
     * @return
     */
    public static native boolean isFF3_0()/*-{
		return $wnd.Ext.isFF3_0;
    }-*/;

    /**
     * T rue if the detected browser uses FireFox 3.5
     * 
     * @return
     */
    public static native boolean isFF3_5()/*-{
		return $wnd.Ext.isFF3_5;
    }-*/;

    /**
     * True if the detected browser uses FireFox 3.5
     * 
     * @return
     */
    public static native boolean isFF3_6()/*-{
		return $wnd.Ext.isFF3_6;
    }-*/;

    /**
     * True if the detected browser uses FireFox 4
     * 
     * @return
     */
    public static native boolean isFF4()/*-{
		return $wnd.Ext.isFF4;
    }-*/;

    /**
     * True if the detected browser uses FireFox 4
     * 
     * @return
     */
    public static native boolean isFF5()/*-{
		return $wnd.Ext.isFF5;
    }-*/;

    /**
     * True if the detected browser uses the Gecko layout engine (e.g. Mozilla,
     * Firefox).
     */
    public static native boolean isGecko()/*-{
		return $wnd.Ext.isGecko;
    }-*/;

    /**
     * True if the detected browser uses a Gecko 5.0+ layout engine (e.g.
     * Firefox 5.x).
     */
    public static native boolean isGecko10()/*-{
		return $wnd.Ext.isGecko10;
    }-*/;

    public static native boolean isGecko3()/*-{
		return $wnd.Ext.isGecko3;
    }-*/;

    public static native boolean isGecko4()/*-{
		return $wnd.Ext.isGecko4;
    }-*/;

    public static native boolean isGecko5()/*-{
		return $wnd.Ext.isGecko5;
    }-*/;

    /**
     * @return true if IE
     */
    public static native boolean isIE()/*-{
		return $wnd.Ext.isIE;
    }-*/;

    public static native boolean isIE10()/*-{
		return $wnd.Ext.isIE10;
    }-*/;

    public static native boolean isIE10m()/*-{
		return $wnd.Ext.isIE10m;
    }-*/;

    public static native boolean isIE10p()/*-{
		return $wnd.Ext.isIE10p;
    }-*/;

    public static native boolean isIE11()/*-{
		return $wnd.Ext.isIE11;
    }-*/;

    public static native boolean isIE11m()/*-{
		return $wnd.Ext.isIE11m;
    }-*/;

    public static native boolean isIE11p()/*-{
		return $wnd.Ext.isIE11p;
    }-*/;

    /**
     * @return true if IE6
     */
    public static native boolean isIE6()/*-{
		return $wnd.Ext.isIE6;
    }-*/;

    /**
     * @return true if IE7
     */
    public static native boolean isIE7()/*-{
		return $wnd.Ext.isIE7;
    }-*/;

    public static native boolean isIE7m()/*-{
		return $wnd.Ext.isIE7m;
    }-*/;

    public static native boolean isIE7p()/*-{
		return $wnd.Ext.isIE7p;
    }-*/;

    public static native boolean isIE8()/*-{
		return $wnd.Ext.isIE8;
    }-*/;

    public static native boolean isIE8m()/*-{
		return $wnd.Ext.isIE8m;
    }-*/;

    public static native boolean isIE8p()/*-{
		return $wnd.Ext.isIE8p;
    }-*/;

    public static native boolean isIE9()/*-{
		return $wnd.Ext.isIE9;
    }-*/;

    public static native boolean isIE9m()/*-{
		return $wnd.Ext.isIE9m;
    }-*/;

    public static native boolean isIE9p()/*-{
		return $wnd.Ext.isIE9p;
    }-*/;

    /**
     * @return true if Linux OS
     */
    public static native boolean isLinux()/*-{
		return $wnd.Ext.isLinux;
    }-*/;

    /**
     * @return true if Mac
     */
    public static native boolean isMac()/*-{
		return $wnd.Ext.isMac;
    }-*/;

    /**
     * @return true if running under Adobe AIR
     */
    public static native boolean isAir()/*-{
		return $wnd.Ext.isAir;
    }-*/;

    /**
     * @return true if Opera
     */
    public static native boolean isOpera()/*-{
		return $wnd.Ext.isOpera;
    }-*/;

    public static native boolean isOpera10_5()/*-{
		return $wnd.Ext.isOpera10_5;
    }-*/;

    /**
     * @return true when the document is fully initialized and ready for action
     */
    public static native boolean isReady()/*-{
		return $wnd.Ext.isReady;
    }-*/;

    /**
     * @return true if Safari
     */
    public static native boolean isSafari()/*-{
		return $wnd.Ext.isSafari;
    }-*/;

    /**
     * @return true if Safari 2
     */
    public static native boolean isSafari2()/*-{
		return $wnd.Ext.isSafari2;
    }-*/;

    /**
     * @return true if Safari 3
     */
    public static native boolean isSafari3()/*-{
		return $wnd.Ext.isSafari3;
    }-*/;

    public static native boolean isSafari4()/*-{
		return $wnd.Ext.isSafari4;
    }-*/;

    public static native boolean isSafari5()/*-{
		return $wnd.Ext.isSafari5;
    }-*/;

    public static native boolean isSafari5_0()/*-{
		return $wnd.Ext.isSafari5_0;
    }-*/;

    /**
     * @return true if the page is running over SSL
     */
    public static native boolean isSecure()/*-{
		return $wnd.Ext.isSecure;
    }-*/;

    /**
     * @return true if the browser is in strict mode
     */
    public static native boolean isStrict()/*-{
		return $wnd.Ext.isStrict;
    }-*/;

    /**
     * @return true if Windows OS
     */
    public static native boolean isWindows()/*-{
		return $wnd.Ext.isWindows;
    }-*/;

    public static native boolean isWebKit()/*-{
		return $wnd.Ext.isWebKit;
    }-*/;

    /**
     * By default, Ext intelligently decides whether floating elements should be
     * shimmed. If you are using flash, you may want to set this to true.
     * 
     * @param useShims
     *            true to use shims
     */
    public static native void setUseShims(boolean useShims)/*-{
		$wnd.Ext.useShims = useShims;
    }-*/;

    /**
     * @return true if use shims.
     */
    public static native boolean isUseShims()/*-{
		return $wnd.Ext.useShims;
    }-*/;

    /**
     * Escapes the passed string for use in a regular expression.
     * 
     * @param str
     *            the String to escape
     * @return escaped String
     */
    public static native String escapeRe(String str)/*-{
		return $wnd.Ext.escapeRe(str);
    }-*/;

    // made package protected. Users don't need to call this anymore since it is
    // handled internally on
    // applicaiotn startup.
    native static void setBlankImageUrl(String url) /*-{
		$wnd.Ext.BLANK_IMAGE_URL = url;
    }-*/;

    /**
     * Method to retrieve Element objects. Uses simple caching to consistently
     * return the same object. Automatically fixes if an object was recreated
     * with the same id via AJAX or DOM.
     * 
     * @param id
     *            element ID
     * @return the element
     */
    public static native ExtElement get(String id) /*-{
		var el = $wnd.Ext.get(id);
		return el == null || el === undefined ? null
				: @com.eemi.ext4j.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(el);
    }-*/;

    /**
     * Method to retrieve Element objects. Uses simple caching to consistently
     * return the same object. Automatically fixes if an object was recreated
     * with the same id via AJAX or DOM.
     * 
     * @param element
     *            the element
     * @return the element
     */
    public static native ExtElement get(Element element) /*-{
		var el = $wnd.Ext.get(element);
		return el == null ? null
				: @com.eemi.ext4j.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(el);
    }-*/;

    /**
     * Generates unique ids.
     * 
     * @return
     */
    public static native String id() /*-{
		return $wnd.Ext.id();
    }-*/;

    /**
     * Generates unique ids.
     * 
     * @return
     */
    public static native String id(ExtElement element) /*-{
		return $wnd.Ext
				.id(element.@com.eemi.ext4j.client.core.JsObject::getJsObj()());
    }-*/;

    /**
     * Generates unique ids.
     * 
     * @return
     */
    public static native String id(ExtElement element, String prefix) /*-{
		return $wnd.Ext.id(
				element.@com.eemi.ext4j.client.core.JsObject::getJsObj()(),
				prefix);
    }-*/;

    /**
     * Attempts to destroy the objects by removing all event listeners, removing
     * them from the DOM (if applicable) and calling their destroy functions (if
     * available).
     * 
     * @param element
     *            the element to destroy
     */
    public static native void destroy(ExtElement element) /*-{
		var el = element.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		$wnd.Ext.destroy(el);
    }-*/;

    /**
     * Attempts to destroy the component passed to it by removing all event
     * listeners, removing them from the DOM (if applicable) and calling their
     * destroy functions (if available).
     * 
     * @param component
     *            the component to destroy
     */
    public static native void destroy(Component component) /*-{
		var comp = component.@com.eemi.ext4j.client.core.Component::getJsObj()();
		$wnd.Ext.destroy(comp);
    }-*/;

    /**
     * Returns the current HTML document object as an {@link ExtElement}.
     * 
     * @return the document
     */
    public static native ExtElement getDoc() /*-{
		var el = $wnd.Ext.getDoc();
		return el == null ? null
				: @com.eemi.ext4j.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(el);
    }-*/;

    /**
     * Returns the current orientation of the mobile device
     */
    public static native String getOrientation()/*-{
		return $wnd.Ext.getOrientation();
    }-*/;

    /**
     * Returns the size of the browser scrollbars. This can differ depending on
     * operating system settings, such as the theme or font size.
     */
    public static native Size getScrollbarSize()/*-{
		var obj = $wnd.Ext.getScrollbarSize();
		return @com.eemi.ext4j.client.core.Size::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
    }-*/;

    /**
     * Returns the size of the browser scrollbars. This can differ depending on
     * operating system settings, such as the theme or font size.
     */
    public static native Size getScrollbarSize(boolean force)/*-{
		var obj = $wnd.Ext.getScrollbarSize(force);
		return @com.eemi.ext4j.client.core.Size::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
    }-*/;

    /**
     * Returns the current document body as an{@link ExtElement}.
     * 
     * @return the document body
     */
    public static native ExtElement getBody() /*-{
		var el = $wnd.Ext.getBody();
		return el == null ? null
				: @com.eemi.ext4j.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(el);
    }-*/;

    /**
     * Returns a component by id. Shorthand for
     * {@link ComponentManager#getComponent(String)}.
     * 
     * @param id
     *            the component ID
     * @return the Component
     */
    public static Component getCmp(String id) {
        return ComponentManager.getComponent(id);
    }

    /**
     * Returns a component that the passed element represents. Shorthand for
     * {@link ComponentManager#getComponent(Element)}.
     * 
     * @param element
     *            the component's element
     * @return the Component
     */
    public static Component getCmp(Element element) {
        return ComponentManager.getComponent(element);
    }

    /**
     * Returns a component that the passed element represents. Shorthand for
     * {@link ComponentManager#getComponent(ExtElement)}.
     * 
     * @param element
     *            the component's element
     * @return the Component
     */
    public static Component getCmp(ExtElement element) {
        return ComponentManager.getComponent(element);
    }

    /**
     * Gets the globally shared flyweight ExtElement, with the passed node as
     * the active element. Do not store a reference to this element - the dom
     * node can be overwritten by other code.
     * 
     * @param id
     *            the element ID
     * @return the ExtElement
     */
    public static native ExtElement fly(String id) /*-{
		var el = $wnd.Ext.fly(id);
		return el == null ? null
				: @com.eemi.ext4j.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(el);
    }-*/;

    /**
     * Gets the globally shared flyweight ExtElement, with the passed node as
     * the active element. Do not store a reference to this element - the dom
     * node can be overwritten by other code.
     * 
     * @param id
     *            the element ID
     * @param named
     *            allows for creation of named reusable flyweights to prevent
     *            conflicts (e.g. internally Ext uses "_internal")
     * @return the ExtElement
     */
    public static native ExtElement fly(String id, String named) /*-{
		var el = $wnd.Ext.fly(id, named);
		return el == null ? null
				: @com.eemi.ext4j.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(el);
    }-*/;

    /**
     * Gets the globally shared flyweight ExtElement, with the passed node as
     * the active element. Do not store a reference to this element - the dom
     * node can be overwritten by other code.
     * 
     * @param element
     *            the element
     * @return the ExtElement
     */
    public static native ExtElement fly(Element element) /*-{
		var el = $wnd.Ext.fly(element);
		return el == null ? null
				: @com.eemi.ext4j.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(el);
    }-*/;

    /**
     * Gets the globally shared flyweight ExtElement, with the passed node as
     * the active element. Do not store a reference to this element - the dom
     * node can be overwritten by other code.
     * 
     * @param element
     *            the element
     * @param named
     *            allows for creation of named reusable flyweights to prevent
     *            conflicts (e.g. internally Ext uses "_internal")
     * @return the ExtElement
     */
    public static native ExtElement fly(Element element, String named) /*-{
		var el = $wnd.Ext.fly(element, named);
		return el == null ? null
				: @com.eemi.ext4j.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(el);
    }-*/;

    /**
     * Generates unique ids.
     * 
     * @return a unique ID
     */
    public static native String generateId()/*-{
		return $wnd.Ext.id();
    }-*/;

    /**
     * Generates unique ids.
     * 
     * @param prefix
     *            Id prefix (defaults "ext-gen")
     * @return a unique ID
     */
    public static native String generateId(String prefix)/*-{
		return $wnd.Ext.id(null, prefix);
    }-*/;

    /**
     * Fires when the document is ready (before onload and before images are
     * loaded). Can alternatively use the GWT entry point mechanism.
     * 
     * @param cb
     *            callback to execute
     */
    public static native void onReady(Function cb) /*-{
		$wnd.Ext.onReady(function() {
			cb.@com.eemi.ext4j.client.core.Function::execute()();
		});
    }-*/;

    /**
     * Shorthand for the Ext.util.Observable.addListener method of the
     * globalEvents Observable instance.
     * 
     * @param event
     * @param cb
     */
    public static native void on(String event, Function cb) /*-{
		$wnd.Ext.on(event, $entry(function() {
			cb.@com.eemi.ext4j.client.core.Function::execute()();
		}));
    }-*/;

    /**
     * Utility method to kick up Javascript debugger. Userful during development
     * / troubleshooting where it is desired to step through Javascript code.
     */
    public static native void debugger()/*-{
		debugger;
    }-*/;

    /**
     * Return true if Firebug is enabled.
     * 
     * @return true if firebug is enabled
     */
    public static native boolean isFirebug() /*-{
		if ($wnd.Ext.isGecko && window.console) {
			var fb = window.console.firebug;
			if (fb == null || fb === undefined) {
				return false;
			} else {
				return fb;
			}
		} else {
			return false;
		}
    }-*/;

    public static native void regModel()/*-{
		$wnd.Ext.regModel("NTT DATA", {
			fields : [ "Ext4j" ]
		});
    }-*/;

    public static void defineModel(String name, Set<String> fields) {
        JsArray<ModelFieldDefinition> fieldsDefinition = JsArray.createArray().cast();
        for (String s : fields) {
            fieldsDefinition.push(ModelFieldDefinition.create(s));
        }
        createModel(name, fieldsDefinition);

    }

    public static native double now()/*-{
		return Date.now();
    }-*/;

    public static native void initToolTip()/*-{
		$wnd.Ext.tip.QuickTipManager.init();
    }-*/;

    /**
     * Stops layouts from happening in the whole framework.
     */
    public static native void suspendLayouts()/*-{
		$wnd.Ext.suspendLayouts();
    }-*/;

    /**
     * Resumes layout activity in the whole framework.
     */
    public static native void resumeLayouts()/*-{
		$wnd.Ext.resumeLayouts();
    }-*/;

    /**
     * Resumes layout activity in the whole framework.
     */
    public static native void resumeLayouts(boolean flush)/*-{
		$wnd.Ext.resumeLayouts(flush);
    }-*/;

    /**
     * Get the informations about the current platform the application is
     * running on.
     * 
     * @return
     */
    public static Is is() {
        return Is.INSTANCE;
    }

    /**
     * Hides all menus that are currently visible
     * 
     * @return , success True if any active menus were hidden.
     */
    public static native boolean hideAllMenus()/*-{
		return $wnd.Ext.menu.Manager.hideAll();
    }-*/;

    /**
     * Returns a random integer between the specified range (inclusive)
     */
    public static native int randomInt(int from, int to)/*-{
		return $wnd.Ext.Number.randomInt(from, to);
    }-*/;

    /**
     * Returns a random integer between the specified range (inclusive)
     * 
     * Checks whether or not the passed number is within a desired range. If the
     * number is already within the range it is returned, otherwise the min or
     * max value is returned depending on which side of the range is exceeded.
     * Note that this method returns the constrained value but does not change
     * the current number.
     */
    public static native double constrain(double number, double min, double max)/*-{
		return $wnd.Ext.Number.randomInt(number, min, max);
    }-*/;

    /**
     * 
     Snaps the passed number between stopping points based upon a passed
     * increment value.
     */
    public static native double snap(double value, double increment, double minValue, double maxValue)/*-{
		return $wnd.Ext.Number.snap(value, increment, minValue, maxValue);
    }-*/;

    /**
     * 
     * Snaps the passed number between stopping points based upon a passed
     * increment value.
     */
    public static native double snapInRange(double value, double increment, double minValue, double maxValue)/*-{
		return $wnd.Ext.Number.snap(value, increment, minValue, maxValue);
    }-*/;

    /**
     * 
     * Snaps the passed number between stopping points based upon a passed
     * increment value.
     */
    public static native double snapInRange(double value, double increment, double minValue)/*-{
		return $wnd.Ext.Number.snap(value, increment, minValue);
    }-*/;

    /**
     * 
     * Snaps the passed number between stopping points based upon a passed
     * increment value.
     */
    public static native double snapInRange(double value, double increment)/*-{
		return $wnd.Ext.Number.snap(value, increment);
    }-*/;

    /**
     * Copies all the properties of config to the specified object. Note that if
     * recursive merging and cloning without referencing the original objects /
     * arrays is needed, use Ext.merge instead.
     */
    public static native void apply(Component component, BaseConfig config)/*-{
		var c = component.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var conf = config.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		$wnd.Ext.apply(c, conf);
    }-*/;

    /**
     * Copies all the properties of config to object if they don't already
     * exist.
     */
    public static native void applyIf(Component component, BaseConfig config)/*-{
		var c = component.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var conf = config.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		$wnd.Ext.applyIf(c, conf);
    }-*/;

    /**
     * Copies all the properties of config to the specified object. Note that if
     * recursive merging and cloning without referencing the original objects /
     * arrays is needed, use Ext.merge instead.
     */
    public static native void apply(JsObject src, JsObject target)/*-{
		var s = src.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		var t = config.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		$wnd.Ext.apply(s, t);
    }-*/;

    /**
     * Copies all the properties of config to object if they don't already
     * exist.
     */
    public static native void applyIf(JsObject src, JsObject target)/*-{
		var s = src.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		var t = config.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		$wnd.Ext.applyIf(s, t);
    }-*/;

    /**
     * Formats a number using fixed-point notation
     */
    public static native double toFixed(double value, double precision)/*-{
		return $wnd.Ext.Number.toFixed(value, precision);
    }-*/;

    /**
     * Clone simple variables including array, {}-like objects, DOM nodes and
     * Date without keeping the old reference. A reference for the object itself
     * is returned if it's not a direct decendant of Object.
     * 
     * @param el
     * @return
     */
    public static native ExtElement cloneNode(ExtElement el)/*-{
		var node = $wnd.Ext
				.clone(el.@com.eemi.ext4j.client.core.JsObject::getJsObj()());
		return @com.eemi.ext4j.client.core.ExtElement::new(Lcom/google/gwt/core/client/JavaScriptObject;)(node);
    }-*/;

    public static native JavaScriptObject clone(JavaScriptObject el)/*-{
		return $wnd.Ext.clone(el);
    }-*/;

    /**
     * Creates a CompositeElement for child nodes based on the passed CSS
     * selector (the selector should not contain an id).
     * 
     * @param selector
     *            the CSS selector
     * @return the CompositeElement
     */
    public static native CompositeElement select(String selector)/*-{
		var ceJS = $wnd.Ext.select(selector);
		return ceJS == null || ceJS === undefined ? null
				: @com.eemi.ext4j.client.core.CompositeElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(ceJS);
    }-*/;

    private static native void createModel(String name, JsArray<ModelFieldDefinition> f)/*-{
		$wnd.Ext.define(name, {
			extend : 'Ext.data.Model',
			fields : f
		});
    }-*/;

}
