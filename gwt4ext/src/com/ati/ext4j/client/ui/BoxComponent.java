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

import com.ati.ext4j.client.core.Box;
import com.ati.ext4j.client.core.Component;
import com.ati.ext4j.client.core.Function;
import com.ati.ext4j.client.core.Size;
import com.ati.ext4j.client.core.config.XType;
import com.ati.ext4j.client.layout.BorderRegion;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.Timer;

/**
 * Base class for any visual {@link Component} that uses a box container.
 * BoxComponent provides automatic box model adjustments for sizing and
 * positioning and will work correctly withnin the Component rendering model.
 * All container classes should subclass BoxComponent so that they will work
 * consistently when nested within other Ext layout containers.
 */
public class BoxComponent extends Component {

    private static JavaScriptObject configPrototype;

    private native void init()/*-{
		var c = new $wnd.Ext.Component();
		@com.ati.ext4j.client.ui.BoxComponent::configPrototype = c.initialConfig;
    }-*/;

    protected JavaScriptObject getConfigPrototype() {
        return configPrototype;
    }

    public String getXType() {
        return XType.BOX.getValue();
    }

    public BoxComponent() {
        init();
    }

    public BoxComponent(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public BoxComponent(Element element) {
        super(element);
    }

    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		config.xtype = 'box';
		return new $wnd.Ext.Component(config);
    }-*/;

    /**
     * Gets the current box measurements of the component's.
     * 
     * @return the box measurements
     */
    public native Box getBox()/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var boxJS = component.getBox();
		return @com.ati.ext4j.client.core.Box::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(boxJS);
    }-*/;

    /**
     * Gets the current box measurements of the component's.
     * 
     * @param local
     *            if true the element's left and top are returned instead of
     *            page XY (defaults to false)
     * @return the box measurements
     */
    public native Box getBox(boolean local)/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var boxJS = component.getBox(local);
		return @com.ati.ext4j.client.core.Box::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(boxJS);
    }-*/;

    /**
     * Gets the current size of the component's underlying element.
     * 
     * @return the components Size
     */
    public native Size getSize()/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var sizeJS = component.getSize();
		return @com.ati.ext4j.client.core.Size::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(sizeJS);
    }-*/;

    /**
     * Sets the page XY position of the component. To set the left and top
     * instead, use setPosition. This method fires the move event.
     * 
     * @param x
     *            the new X position
     * @param y
     *            the new Y opsition
     */
    public native void setPagePosition(int x, int y) /*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		component.setPagePosition(x, y);
    }-*/;

    /**
     * Sets the left and top of the component. To set the page XY position
     * instead, use setPagePosition. This method fires the move event.
     * 
     * @param left
     *            the new left
     * @param top
     *            the new right
     */
    public native void setPosition(int left, int top) /*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		component.setPosition(left, top);
    }-*/;

    /**
     * Sets the width and height of the component. This method fires the resize
     * event.
     * 
     * @param width
     *            the new width
     * @param height
     *            the new height
     */
    public void setSize(int width, int height) {
        if (!isRendered()) {
            setWidth(width);
            setHeight(height);
        } else {
            setSizeRendered(width, height);
        }
    }

    public void setSize(String width, String height) {
        if (!isRendered()) {
            setWidth(width);
            setHeight(height);
        } else {
            if (width.indexOf("px") != -1 && height.indexOf("px") != -1) {
                int intWidth = 0;
                int intHeight = 0;
                width = width.replaceAll("px", "").trim();
                intWidth = Integer.parseInt(width);

                height = height.replaceAll("px", "").trim();
                intHeight = Integer.parseInt(height);
                setSizeRendered(intWidth, intHeight);
            } else {
                setWidth(width);
                setHeight(height);
            }
        }
    }

    private native void setSizeRendered(int width, int height) /*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		component.setSize(width, height);
    }-*/;

    /**
     * Force the component's size to recalculate based on the underlying
     * element's current height and width.
     */
    public native void syncSize()/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		component.syncSize();
    }-*/;

    /**
     * Sets the current box measurements of the component's underlying element.
     * 
     * @param box
     *            the new box measurements
     */
    public native void updateBox(Box box)/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var boxJS = box.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		component.updateBox(boxJS);
    }-*/;

    /**
     * Runs the specified function when the Component is rendered.
     * 
     * @param function
     *            the function to execute on render
     */
    public void doOnRender(Function function) {
        if (!isRendered()) {
            this.addListener("render", function);
            this.addListener(DEBUG_ID_PREFIX, function);
        } else {
            throw new IllegalStateException("The component is already rendered");
        }
    }

    /**
     * Runs the specified function when the Component is rendered.
     * 
     * @param function
     *            the function to execute on render
     * @param delayMillis
     *            a delay in milliseconds
     */
    public void doOnRender(final Function function, final int delayMillis) {
        if (!isRendered()) {
            addListener("render", new Function() {
                public void execute() {
                    new Timer() {
                        public void run() {
                            function.execute();
                        }
                    }.schedule(delayMillis);
                }
            });
        } else {
            throw new IllegalStateException("The component is already rendered");
        }
    }

    // --- config properties ---

    /**
     * True to use height:'auto', false to use fixed height (defaults to false).
     * 
     * <br>
     * <br>
     * <b>Note:</b> This property cannot be changed after the Component has been
     * rendered.
     * 
     * @param autoHeight
     *            true to use auto height
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setAutoHeight(boolean autoHeight) throws IllegalStateException {
        setAttribute("autoHeight", autoHeight, true);
    }

    /**
     * 
     * @return true if using auto height, else false
     */
    public boolean getAutoHeight() {
        return getAttributeAsBoolean("autoHeight");
    }

    /**
     * True to use width:'auto', false to use fixed width (defaults to false).
     * 
     * @param autoWidth
     *            true for auto width
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setAutoWidth(boolean autoWidth) throws IllegalStateException {
        setAttribute("autoWidth", autoWidth, true);
    }

    /**
     * @return true if using auto width, else false
     */
    public boolean getAutoWidth() {
        return getAttributeAsBoolean("autoWidth");
    }

    /**
     * The height of this component in pixels (defaults to auto).
     * 
     * @param height
     *            the component height
     */
    public void setHeight(int height) {
        if (!isRendered()) {
            if (height == -1) {
                setAttribute("height", "auto", true);
            } else {
                setAttribute("height", height, true);
            }
        } else {
            setHeightRendered(height);
        }
    }

    private native void setHeightRendered(int height) /*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		component.setHeight(height);
    }-*/;

    /**
     * Set the height in pixels or auto. Note that setting percentage based
     * heights will lead to unpredictable display behavior. You should use the
     * various layouts like
     * {@link com.ati.ext4j.client.core.CenterLayout.AnchorLayout} to control
     * percentage based rendering of components.
     * 
     * @param height
     *            the component height
     */
    public void setHeight(String height) {
        if (!isRendered()) {
            if (height.indexOf("px") != -1) {
                height = height.replaceAll("px", "").trim();
                setHeight(Integer.parseInt(height));
            } else if (height.trim().equalsIgnoreCase("auto")) {
                setAutoHeight(true);
            } else {
                setAttribute("height", height, true);
            }
        } else {
            if (height.indexOf("px") != -1) {
                height = height.replaceAll("px", "").trim();
                setHeightRendered(Integer.parseInt(height));
            } else {
                super.setHeight(height);
            }
        }
    }

    private native void setWidthRendered(int width) /*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		component.setWidth(width);
    }-*/;

    public void setRegion(BorderRegion region) {
        setRegion(region.getValue());
    }

    private void setRegion(String region) {
        setAttribute("region", region, true);
    }

    public void setSplit(boolean value) {
        setAttribute("split", value, true);
    }

    public void setHtml(String html) {
        setAttribute("html", html, true);
    }

    /**
     * Creates a new BoxComponent from the given component
     * 
     * @param component
     *            , the component to cast from
     * @return, a new BoxComponent from the component
     * 
     */
    public static BoxComponent cast(Component component) {
        return new BoxComponent(component.getOrCreateJsObj());
    }

}
