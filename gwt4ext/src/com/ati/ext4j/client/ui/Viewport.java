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

import java.util.ArrayList;
import java.util.List;

import com.ati.ext4j.client.core.Component;
import com.ati.ext4j.client.core.Ext;
import com.ati.ext4j.client.core.config.XType;
import com.ati.ext4j.client.layout.ContainerLayout;
import com.ati.ext4j.client.layout.Layout;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;

/**
 * A specialized container representing the viewable application area (the
 * browser viewport).
 * 
 * <p>
 * The Viewport renders itself to the document body, and automatically sizes
 * itself to the size of the browser viewport and manages window resizing. There
 * may only be one Viewport created in a page.
 * <p>
 * Like any Container, a Viewport will only perform sizing and positioning on
 * its child Components if you configure it with a layout.
 * <p>
 * A Common layout used with Viewports is border layout, but if the required
 * layout is simpler, a different layout should be chosen.
 * <p>
 * For example, to simply make a single child item occupy all available space,
 * use fit layout.
 * <p>
 * To display one "active" item at full size from a choice of several child
 * items, use card layout.
 * <p>
 * Inner layouts are available because all Panels added to the Viewport, either
 * through its items, or the add method of any of its child Panels may
 * themselves have a layout.
 * <p>
 * The Viewport does not provide scrolling, so child Panels within the Viewport
 * should provide for scrolling if needed using the autoScroll config.
 * 
 * <p>
 * * Adding a AcceptsOneWidget interface with an empty setWidget overriden
 * method to fake the operation and allow for a pure GWT Activty And Place
 * implementation.
 * 
 * 
 * You must not add the "viewport" panel to GWT's RootPanel via
 * RootPanel.get().add(..) - this is done automatically for you.
 */

@SuppressWarnings("unchecked")
public class Viewport extends Container implements AcceptsOneWidget {

    private JavaScriptObject jsObj;
    private static Viewport viewPort;
    private Component widget;
    private List<Component> items = new ArrayList<Component>();

    /**
     * Get the viewport with the given layout
     * 
     * @param layout
     *            , the layout the vieport should use
     * @return, the singleton instance of the viewport
     */
    public static Viewport get(Layout layout) {
        return get(layout, 0);
    }

    private static Viewport get(Layout layout, int bodyPadding) {
        if (viewPort == null) {
            viewPort = initViewPort(layout.getValue(), bodyPadding);
        }
        return viewPort;
    }

    /**
     * Get the viewport with the given layout
     * 
     * @param layout
     *            , the layout the vieport should use
     * @return, the singleton instance of the viewport
     */
    public static Viewport get(ContainerLayout layout) {
        return get(layout, 0);
    }

    private static Viewport get(ContainerLayout layout, int bodyPadding) {
        if (viewPort == null) {
            viewPort = initViewPort(layout.getJsObj(), bodyPadding);
        }
        return viewPort;
    }

    /**
     * Get the viewport with the default layout
     * 
     * @return, the singleton instance of the viewport
     */
    public static Viewport get() {
        if (viewPort == null) {
            viewPort = initViewPort(Layout.AUTO.getValue(), 0);
        }
        return viewPort;
    }

    private Viewport() {

    }

    protected Viewport(JavaScriptObject obj) {
        super(obj);
    }

    public String getXType() {
        return XType.VIEWPORT.getValue();
    }

    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.container.Viewport(config);
    }-*/;

    public void setWidget(final Widget w) {
        // Validate
        if (w == widget || w == null) {
            return;
        }

        if (w != null) {
            if (widget != null) {
                widget.hide();
            }

            if (items.indexOf((Component) w) < 0) {
                items.add((Component) w);
                // Physical attach.
                add(w);
            }
            ((Component) w).show();
            // setActiveItem((Container) w);
            // Logical add
            widget = (Component) w;
        }

    }

    @Override
    public void setWidget(IsWidget w) {
        setWidget(asWidgetOrNull(w));
    }

    public native void attach() /*-{
		@com.ati.ext4j.client.ui.Viewport::viewPort.@com.google.gwt.user.client.ui.Widget::onAttach()();
    }-*/;

    /**
     * Calling layout on the viewport has no effect. You must specify the
     * initial layout while calling <br/>
     * <code>
     * Viewport.get(Layout layout)
     * </code>
     */
    @Override
    public void setLayout(ContainerLayout layout) throws IllegalStateException {

    }

    public static Viewport wrap(String componentId) {
        ComponentFactory.ensureXType(XType.VIEWPORT.getValue(), componentId);
        return new Viewport(Ext.getCmp(componentId).getOrCreateJsObj());
    }

    private native static Viewport initViewPort(String l, int padding) /*-{
		var viewport = new $wnd.Ext.container.Viewport({
			layout : l,
			bodyPadding : '100'
		});
		var container = @com.ati.ext4j.client.ui.Viewport::new(Lcom/google/gwt/core/client/JavaScriptObject;)(viewport);
		return container;
    }-*/;

    private native static Viewport initViewPort(JavaScriptObject l, int padding) /*-{
		var viewport = new $wnd.Ext.container.Viewport({
			layout : l,
			bodyPadding : padding
		});
		var container = @com.ati.ext4j.client.ui.Viewport::new(Lcom/google/gwt/core/client/JavaScriptObject;)(viewport);
		return container;
    }-*/;

}
