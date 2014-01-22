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
package com.eemi.ext4j.client.layout;

import com.eemi.ext4j.client.core.Component;
import com.eemi.ext4j.client.core.JsoHelper;
import com.eemi.ext4j.client.core.SimpleComponent;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * <p>
 * This layout contains multiple panels, each fit to the container, where only a
 * single panel can be visible at any given time. This layout style is most
 * commonly used for wizards, tab implementations, etc.
 * </p>
 * <p/>
 * <p>
 * The CardLayout's focal method is setActiveItem. Since only one panel is
 * displayed at a time, the only way to move from one panel to the next is by
 * calling setActiveItem, passing the id or index of the next panel to display.
 * The layout itself does not provide a mechanism for handling this navigation,
 * so that functionality must be provided by the developer.
 * </p>
 */
public class CardLayout extends FitLayout {

    /**
     * Contruct a new CardLayout
     */
    public CardLayout() {
    }

    /**
     * Construct a new CardLayout.
     * 
     * @param deferredRender
     *            true to render each contained item at the time it becomes
     *            active, false to render all contained items as soon as the
     *            layout is rendered (defaults to false).
     */
    public CardLayout(boolean deferredRender) {
        setDeferredRender(deferredRender);
    }

    protected CardLayout(JavaScriptObject obj) {
        jsObj = obj;
    }

    /**
     * True to render each contained item at the time it becomes active, false
     * to render all contained items as soon as the layout is rendered (defaults
     * to false). If there is a significant amount of content or a lot of heavy
     * controls being rendered into panels that are not displayed by default,
     * setting this to true might improve performance.
     * 
     * @param deferredRender
     *            true to render each contained item at the time it becomes
     *            active
     */
    public void setDeferredRender(boolean deferredRender) {
        JsoHelper.setAttribute(configJS, "deferredRender", deferredRender);
    }

    /**
     * Sets the active (visible) item in the layout.
     * 
     * @param index
     *            the item index
     */
    public native void setActiveItem(int index) /*-{
		var layout = this.@com.eemi.ext4j.client.layout.ContainerLayout::getJsObj()();
		if (layout.setActiveItem) {
			layout.setActiveItem(index);
		}
    }-*/;

    /**
     * Sets the active (visible) item in the layout.
     * 
     * @param itemID
     *            the item ID
     */
    public native void setActiveItem(String itemID) /*-{
		var layout = this.@com.eemi.ext4j.client.layout.ContainerLayout::getJsObj()();
		if (layout.setActiveItem) {
			layout.setActiveItem(itemID);
		}
    }-*/;

    /**
     * Sets the active (visible) item in the layout.
     * 
     * @param comp
     *            the component to set active
     */
    public native void setActiveItem(Component comp) /*-{
		var layout = this.@com.eemi.ext4j.client.layout.ContainerLayout::getJsObj()();
		if (layout.setActiveItem) {
			layout
					.setActiveItem(comp.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()());
		}
    }-*/;

    /**
     * Return the active (visible) component in the layout.
     * 
     * @return
     */
    public native SimpleComponent getActiveItem() /*-{
		var layout = this.@com.eemi.ext4j.client.layout.ContainerLayout::getJsObj()();
		if (obj.getActiveItem) {
			var obj = layout.getActiveItem();
			if (!obj) {
				return null;
			}
			return @com.eemi.ext4j.client.core.SimpleComponent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
		}
		return null;

    }-*/;

    /**
     * Return the active (visible) component in the layout to the next card
     * 
     * @return
     */
    public native SimpleComponent getNext() /*-{
		var layout = this.@com.eemi.ext4j.client.layout.ContainerLayout::getJsObj()();
		if (obj.getNext) {
			var obj = layout.getNext();
			if (!obj) {
				return null;
			}
			return @com.eemi.ext4j.client.core.SimpleComponent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
		}
		return null;
    }-*/;

    /**
     * Return the active (visible) component in the layout to the previous card
     * 
     * @return
     */
    public native SimpleComponent getPrev() /*-{
		var layout = this.@com.eemi.ext4j.client.layout.ContainerLayout::getJsObj()();
		if (obj.getPrev) {
			var obj = layout.getPrev();
			if (!obj) {
				return null;
			}
			return @com.eemi.ext4j.client.core.SimpleComponent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
		}
		return null;
    }-*/;

    /**
     * Sets the active (visible) component in the layout to the next card
     * 
     * @return
     */
    public native SimpleComponent next() /*-{
		var layout = this.@com.eemi.ext4j.client.layout.ContainerLayout::getJsObj()();
		if (obj.next) {
			var obj = layout.next();
			if (!obj) {
				return null;
			}
			return @com.eemi.ext4j.client.core.SimpleComponent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
		}
		return null;
    }-*/;

    /**
     * Sets the active (visible) component in the layout to the previous card
     * 
     * @return
     */
    public native SimpleComponent prev() /*-{
		var layout = this.@com.eemi.ext4j.client.layout.ContainerLayout::getJsObj()();
		if (obj.prev) {
			var obj = layout.prev();
			if (!obj) {
				return null;
			}
			return @com.eemi.ext4j.client.core.SimpleComponent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
		}
		return null;
    }-*/;

    @Override
    protected native void create() /*-{
		var jso = {
			type : 'card'
		};
		this.@com.eemi.ext4j.client.layout.ContainerLayout::jsObj = jso;
    }-*/;

    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return {
			type : 'card'
		};
    }-*/;

    public static CardLayout cast(ContainerLayout layout) {
        return new CardLayout(layout.getJsObj());
    }

}
