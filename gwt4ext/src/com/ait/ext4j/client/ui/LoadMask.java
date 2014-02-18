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
package com.ait.ext4j.client.ui;

import com.ait.ext4j.client.core.Component;
import com.ait.ext4j.client.core.ExtElement;
import com.ait.ext4j.client.core.Function;
import com.ait.ext4j.client.data.Store;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * A modal, floating Component which may be shown above a specified Element, or
 * a specified Component while loading data. When shown, the configured owning
 * Element or Component will be covered with a modality mask, and the LoadMask's
 * msg will be displayed centered, accompanied by a spinner image.
 * 
 * If the store config option is specified, the masking will be automatically
 * shown and then hidden synchronized with the Store's loading process.
 * 
 * Because this is a floating Component, its z-index will be managed by the
 * global ZIndexManager object, and upon show, it will place itsef at the top of
 * the hierarchy.
 * 
 * 
 */
public class LoadMask extends Component {

    private static JavaScriptObject configPrototype;

    protected JavaScriptObject getConfigPrototype() {
        return configPrototype;
    }

    public String getXType() {
        return "loadmask";
    }

    public LoadMask(Component target, String html) {
        setMsg(html);
        setTarget(target);
    }

    public LoadMask(JavaScriptObject jsObj) {
        super(jsObj);
    }

    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.LoadMask(config);
    }-*/;

    /**
     * Applies the tooltip to the specified target. Note that the element with
     * the specified ID must be rendered to the DOM before this call is made.
     * 
     * @param elementID
     *            the target element ID
     */
    public void setTarget(String elementID) {
        setAttribute("target", elementID, true);
        getOrCreateJsObj();
    }

    public void setTarget(final Component component) {
        if (component.isRendered()) {
            setAttribute("target", component.getElement(), true);
            create(config);
        } else {
            component.addListener("render", new Function() {
                public void execute() {
                    setTarget(component);
                }
            });
        }
    }

    /**
     * The base CSS class to apply to this component's element. This will also
     * be prepended to elements within this component like
     * NotificationContainer's body will get a class x-panel-body. This means
     * that if you create a subclass of NotificationContainer, and you want it
     * to get all the Panels styling for the element and the body, you leave the
     * baseCls x-panel and use componentCls to add specific styling for this
     * component.
     * <p>
     * Defaults to: Ext.baseCSSPrefix + 'mask-msg'
     * 
     * @param value
     */
    public void setBaseCls(String value) {
        setAttribute("baseCls", value, true);
    }

    /**
     * The CSS class to apply to the mask element
     * <p>
     * Defaults to: "x-mask"
     */
    public void setMaskCls(String value) {
        setAttribute("maskCls", value, true);
    }

    /**
     * The text to display in a centered loading message box.
     * <p>
     * Defaults to: "Loading..."
     */
    public void setMsg(String value) {
        setAttribute("msg", value, true);
    }

    /**
     * The CSS class to apply to the loading message element.
     * <p>
     * Defaults to: "x-mask-loading"
     */
    public void setMsgCls(String value) {
        setAttribute("msgCls", value, true);
    }

    /**
     * Optional Store to which the mask is bound. The mask is displayed when a
     * load request is issued, and hidden on either load success, or load fail.
     */
    public void setStore(Store value) {
        setAttribute("store", value.getJsObj(), true);
    }

    /**
     * Whether or not to use a loading message class or simply mask the bound
     * element.
     * <p>
     * Defaults to: true
     */
    public void setUseMsg(boolean value) {
        setAttribute("useMsg", value, true);
    }

    /**
     * True to mask the targetEl of the bound Component. By default, the el will
     * be masked.
     * <p>
     * Defaults to: false
     */
    public void setUseTargetEl(boolean value) {
        setAttribute("useTargetEl", value, true);
    }

    /**
     * Changes the data store bound to this LoadMask.
     * 
     * @param store
     */
    public native void bindStore(Store store) /*-{
		var component = this.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()();
		component
				.bindStore(store.@com.ait.ext4j.client.core.JsObject::getJsObj()());
    }-*/;

    /**
     * Hides this Component, setting it to invisible using the configured
     * hideMode.
     */
    public native void hide() /*-{
		var component = this.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()();
		component.hide();
    }-*/;

    /**
     * Hides this Component, setting it to invisible using the configured
     * hideMode.
     * 
     * @param animateTarget
     *            , only valid for floating Components such as Windows or
     *            ToolTips, or regular Components which have been configured
     *            with floating: true.. The target to which the Component should
     *            animate while hiding.
     */
    public native void hide(String animateTarget) /*-{
		var component = this.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()();
		component.hide(animateTarget);
    }-*/;

    /**
     * Hides this Component, setting it to invisible using the configured
     * hideMode.
     * 
     * @param animateTarget
     *            , only valid for floating Components such as Windows or
     *            ToolTips, or regular Components which have been configured
     *            with floating: true.. The target to which the Component should
     *            animate while hiding.
     * @param callback
     *            , A callback function to call after the Component is hidden.
     */
    public native void hide(String animateTarget, Function callback) /*-{
		var component = this.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()();
		component.hide(animateTarget, $entry(function() {
			callback.@com.ait.ext4j.client.core.Function::execute()();
		}));
    }-*/;

    /**
     * Hides this Component, setting it to invisible using the configured
     * hideMode.
     * 
     * @param animateTarget
     *            , only valid for floating Components such as Windows or
     *            ToolTips, or regular Components which have been configured
     *            with floating: true.. The target to which the Component should
     *            animate while hiding.
     */
    public native void hide(ExtElement animateTarget) /*-{
		var component = this.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()();
		component
				.hide(animateTarget.@com.ait.ext4j.client.core.ExtElement::getJsObj()());
    }-*/;

    /**
     * Hides this Component, setting it to invisible using the configured
     * hideMode.
     * 
     * @param animateTarget
     *            , only valid for floating Components such as Windows or
     *            ToolTips, or regular Components which have been configured
     *            with floating: true.. The target to which the Component should
     *            animate while hiding.
     * @param callback
     *            , A callback function to call after the Component is hidden.
     */
    public native void hide(ExtElement animateTarget, Function callback) /*-{
		var component = this.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()();
		component
				.hide(
						animateTarget.@com.ait.ext4j.client.core.ExtElement::getJsObj()(),
						$entry(function() {
							callback.@com.ait.ext4j.client.core.Function::execute()();
						}));
    }-*/;

    /**
     * Hides this Component, setting it to invisible using the configured
     * hideMode.
     * 
     * @param animateTarget
     *            , only valid for floating Components such as Windows or
     *            ToolTips, or regular Components which have been configured
     *            with floating: true.. The target to which the Component should
     *            animate while hiding.
     */
    public native void hide(Component animateTarget) /*-{
		var component = this
				.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()();
		component.hide(animateTarget
				.@com.ait.ext4j.client.core.Component::getOrCreateJsObj());
    }-*/;

    /**
     * Hides this Component, setting it to invisible using the configured
     * hideMode.
     * 
     * @param animateTarget
     *            , only valid for floating Components such as Windows or
     *            ToolTips, or regular Components which have been configured
     *            with floating: true.. The target to which the Component should
     *            animate while hiding.
     * @param callback
     *            , A callback function to call after the Component is hidden.
     */
    public native void hide(Component animateTarget, Function callback) /*-{
		var component = this
				.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()();
		component.hide(animateTarget
				.@com.ait.ext4j.client.core.Component::getOrCreateJsObj(),
				$entry(function() {
					callback.@com.ait.ext4j.client.core.Function::execute()();
				}));
    }-*/;

    /**
     * Shows this Component, rendering it first if autoRender or floating are
     * true.
     */
    public native void show() /*-{
		var component = this.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()();
		component.show();
    }-*/;

    /**
     * Shows this Component
     * 
     * @param animateTarget
     *            , only valid for floating Components such as Windows or
     *            ToolTips, or regular Components which have been configured
     *            with floating: true.. The target to which the Component should
     *            animate while hiding.
     */
    public native void show(String animateTarget) /*-{
		var component = this.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()();
		component.show(animateTarget);
    }-*/;

    /**
     * Shows this Component
     * 
     * @param animateTarget
     *            , only valid for floating Components such as Windows or
     *            ToolTips, or regular Components which have been configured
     *            with floating: true.. The target to which the Component should
     *            animate while hiding.
     * @param callback
     *            , A callback function to call after the Component is hidden.
     */
    public native void show(String animateTarget, Function callback) /*-{
		var component = this.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()();
		component.show(animateTarget, $entry(function() {
			callback.@com.ait.ext4j.client.core.Function::execute()();
		}));
    }-*/;

    /**
     * Showa this Component
     * 
     * @param animateTarget
     *            , only valid for floating Components such as Windows or
     *            ToolTips, or regular Components which have been configured
     *            with floating: true.. The target to which the Component should
     *            animate while hiding.
     */
    public native void show(ExtElement animateTarget) /*-{
		var component = this.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()();
		component
				.show(animateTarget.@com.ait.ext4j.client.core.ExtElement::getJsObj()());
    }-*/;

    /**
     * Shows this Component, setting it to invisible using the configured
     * hideMode.
     * 
     * @param animateTarget
     *            , only valid for floating Components such as Windows or
     *            ToolTips, or regular Components which have been configured
     *            with floating: true.. The target to which the Component should
     *            animate while hiding.
     * @param callback
     *            , A callback function to call after the Component is hidden.
     */
    public native void show(ExtElement animateTarget, Function callback) /*-{
		var component = this.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()();
		component
				.show(
						animateTarget.@com.ait.ext4j.client.core.ExtElement::getJsObj()(),
						$entry(function() {
							callback.@com.ait.ext4j.client.core.Function::execute()();
						}));
    }-*/;

    /**
     * Shows this Component
     * 
     * @param animateTarget
     *            , only valid for floating Components such as Windows or
     *            ToolTips, or regular Components which have been configured
     *            with floating: true.. The target to which the Component should
     *            animate while hiding.
     */
    public native void show(Component animateTarget) /*-{
		var component = this
				.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()();
		component.show(animateTarget
				.@com.ait.ext4j.client.core.Component::getOrCreateJsObj());
    }-*/;

    /**
     * Shows this Component
     * 
     * @param animateTarget
     *            , only valid for floating Components such as Windows or
     *            ToolTips, or regular Components which have been configured
     *            with floating: true.. The target to which the Component should
     *            animate while hiding.
     * @param callback
     *            , A callback function to call after the Component is hidden.
     */
    public native void show(Component animateTarget, Function callback) /*-{
		var component = this
				.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()();
		component.show(animateTarget
				.@com.ait.ext4j.client.core.Component::getOrCreateJsObj(),
				$entry(function() {
					callback.@com.ait.ext4j.client.core.Function::execute()();
				}));
    }-*/;

    public static LoadMask cast(Component component) {
        return new LoadMask(component.getOrCreateJsObj());
    }

}
