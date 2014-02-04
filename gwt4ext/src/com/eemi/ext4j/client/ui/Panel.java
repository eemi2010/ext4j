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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.eemi.ext4j.client.core.Component;
import com.eemi.ext4j.client.core.ExtElement;
import com.eemi.ext4j.client.core.JsoHelper;
import com.eemi.ext4j.client.core.Margins;
import com.eemi.ext4j.client.core.Paddings;
import com.eemi.ext4j.client.core.config.Direction;
import com.eemi.ext4j.client.core.config.Position;
import com.eemi.ext4j.client.core.config.XType;
import com.eemi.ext4j.client.events.HandlerRegistration;
import com.eemi.ext4j.client.events.panel.BeforeCloseHandler;
import com.eemi.ext4j.client.events.panel.BeforeCollapseHandler;
import com.eemi.ext4j.client.events.panel.BeforeExpandHandler;
import com.eemi.ext4j.client.events.panel.CollapseHandler;
import com.eemi.ext4j.client.events.panel.FloatHandler;
import com.eemi.ext4j.client.events.panel.IconChangeHandler;
import com.eemi.ext4j.client.events.panel.IconClsChangeHandler;
import com.eemi.ext4j.client.events.panel.PanelBeforeCloseHandler;
import com.eemi.ext4j.client.events.panel.PanelBeforeCollapseHandler;
import com.eemi.ext4j.client.events.panel.PanelBeforeExpandHandler;
import com.eemi.ext4j.client.events.panel.TitleChangeHandler;
import com.eemi.ext4j.client.events.panel.UnFloatHandler;
import com.eemi.ext4j.client.fx.Fx;
import com.eemi.ext4j.client.layout.ContainerLayout;
import com.eemi.ext4j.client.layout.Layout;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Image;

/**
 * Panel is a container that has specific functionality and structural
 * components that make it the perfect building block for application-oriented
 * user interfaces. The Panel contains bottom and top toolbars, along with
 * separate header, footer and body sections. It also provides built-in
 * expandable and collapsible behavior, along with a variety of prebuilt tool
 * buttons that can be wired up to provide other customized behavior. Panels can
 * be easily dropped into any Container or layout, and the layout and rendering
 * pipeline is completely managed by the framework.
 */
public class Panel extends Container {

    private static JavaScriptObject configPrototype;
    private Set<Tool> tools = new HashSet<Tool>();
    private Tool[] toolArray = null;
    private FooterToolBar toolBar;
    private List<Component> dockedItems = new ArrayList<Component>();
    private List<Component> children = new ArrayList<Component>();
    private final Image iconImage = new Image();

    private native void init()/*-{
		var c = new $wnd.Ext.panel.Panel();
		@com.eemi.ext4j.client.ui.Panel::configPrototype = c.initialConfig;
    }-*/;

    protected JavaScriptObject getConfigPrototype() {
        return configPrototype;
    }

    public String getXType() {
        return XType.PANEL.getValue();
    }

    /**
     * Create a new Panel.
     */
    public Panel() {

    }

    public Panel(ContainerLayout layout) {
        setLayout(layout);
    }

    public Panel(Layout layout) {
        setLayout(layout);
    }

    /**
     * Construct a new Panel with the given title.
     * 
     * @param title
     *            the title
     */
    public Panel(String title) {
        setTitle(title);
        setDestroy();
    }

    /**
     * Construct a new Panel with the given title and layout
     * 
     * @param title
     *            the title
     * @param layout
     *            , the layout
     */
    public Panel(String title, ContainerLayout layout) {
        this(title);
        setLayout(layout);
    }

    /**
     * Construct a new Panel with the given title and layout
     * 
     * @param title
     *            the title
     * @param layout
     *            , the layout
     */
    public Panel(String title, Layout layout) {
        this(title);
        setLayout(layout);
    }

    public Panel(JavaScriptObject jsObj) {
        super(jsObj);
    }

    /**
     * Applys the Panel to an existing element.
     * 
     * @param element
     *            the element
     */
    public Panel(Element element) {
        super(element);
    }

    /**
     * This method will clean the panel
     */
    private native void setDestroy()/*-{
	    this.@com.eemi.ext4j.client.core.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('beforedestroy',
		    function() {
    			if (this.header) {
        			$wnd.Ext.destroy(this.header);
    			}
		    }
        );
	}-*/;

    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.panel.Panel(config);
    }-*/;

    private static Panel instance(JavaScriptObject jsObj) {
        return new Panel(jsObj);
    }

    protected static Panel panelInstance(JavaScriptObject jsObj) {
        return new Panel(jsObj);
    }

    private native void addButtonPreCreate(JavaScriptObject componentJS) /*-{
		var config = this.@com.eemi.ext4j.client.core.Component::config;

		if (!config.buttons) {
			config.buttons = @com.eemi.ext4j.client.core.JsoHelper::createJavaScriptArray()();
		}
		config.buttons.push(componentJS);
    }-*/;

    private native void addButtonPostCreate(JavaScriptObject componentJS) /*-{
		var panel = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		panel.addButton(componentJS);
    }-*/;

    /**
     * Collapses the panel body so that it becomes hidden. Fires the
     * beforecollapse event which will cancel the collapse action if it returns
     * false.
     */
    public void collapse() {
        if (!isRendered()) {
            setCollapsed(true);
        } else {
            collapseRendered();
        }
    }

    private native void collapseRendered() /*-{
		var panel = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		panel.collapse();
    }-*/;

    /**
     * Collapses the panel body so that the body becomes hidden. Docked
     * Components parallel to the border towards which the collapse takes place
     * will remain visible. Fires the beforecollapse event which will cancel the
     * collapse action if it returns false.
     * 
     * @param dir
     */
    public void collapse(Direction dir) {
        collapse(dir.getValue());
    }

    /**
     * Collapses the panel body so that the body becomes hidden. Docked
     * Components parallel to the border towards which the collapse takes place
     * will remain visible. Fires the beforecollapse event which will cancel the
     * collapse action if it returns false.
     * 
     * @param dir
     */
    public void collapse(Direction dir, boolean animate) {
        collapse(dir.getValue(), animate);
    }

    private native void collapse(String direction) /*-{
		var panel = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		panel.collapse(direction);
    }-*/;

    private native void collapse(String direction, boolean animate) /*-{
		var panel = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		panel.collapse(direction, animate);
    }-*/;

    /**
     * Collapses the panel body so that it becomes hidden. Fires the
     * beforecollapse event which will cancel the collapse action if it returns
     * false.
     * 
     * @param animate
     *            True to animate the transition, else false (defaults to the
     *            value of the animCollapse panel config)
     */
    public void collapse(boolean animate) {
        if (!isRendered()) {
            setCollapsed(true);
        } else {
            collapseRendered(animate);
        }
    }

    /**
     * Set padding on all sides.
     * 
     * @param padding
     *            the padding value in pixels
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setPaddings(int padding) throws IllegalStateException {
        setPaddings(padding, padding, padding, padding);
    }

    /**
     * Set paddings to Panel.
     * 
     * @param top
     *            the top padding
     * @param left
     *            left padding
     * @param right
     *            right padding
     * @param bottom
     *            bottom padding
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setPaddings(int top, int left, int right, int bottom) throws IllegalStateException {
        Paddings paddings = new Paddings(top, left, right, bottom);
        String style = paddings.getStyleString();
        String bodyStyle = getBodyStyle();
        if (bodyStyle == null) {
            setBodyStyle(style);
        } else {
            setBodyStyle(bodyStyle + style);
        }
    }

    /**
     * Set padding on all sides.
     * 
     * @param margin
     *            the padding value in pixels
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setMargins(int margin) throws IllegalStateException {
        setMargins(margin, margin, margin, margin);
    }

    /**
     * Set paddings to Panel.
     * 
     * @param top
     *            the top padding
     * @param left
     *            left padding
     * @param right
     *            right padding
     * @param bottom
     *            bottom padding
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setMargins(int top, int left, int right, int bottom) throws IllegalStateException {
        Margins margins = new Margins(top, left, right, bottom);
        String style = margins.getStyleString();
        String bodyStyle = getBodyStyle();
        if (bodyStyle == null) {
            setBodyStyle(style);
        } else {
            setBodyStyle(style + bodyStyle);
        }
    }

    private native void collapseRendered(boolean animate) /*-{
		var panel = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		panel.collapse(animate);
    }-*/;

    /**
     * Expands the panel body so that it becomes visible. Fires the beforeexpand
     * event which will cancel the expand action if it returns false.
     */
    public void expand() {
        if (!isRendered()) {
            setCollapsed(false);
        } else {
            expandRendered();
        }
    }

    private native void expandRendered() /*-{
		var panel = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		panel.expand();
    }-*/;

    /**
     * Expands the panel body so that it becomes visible. Fires the beforeexpand
     * event which will cancel the expand action if it returns false.
     * 
     * @param animate
     *            True to animate the transition, else false (defaults to the
     *            value of the animCollapse panel config)
     */
    public void expand(boolean animate) {
        if (!isRendered()) {
            setCollapsed(false);
        } else {
            expandRendered(animate);
        }
    }

    private native void expandRendered(boolean animate) /*-{
		var panel = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		panel.expand(animate);
    }-*/;

    /**
     * The Panel's body Element which may be used to contain HTML content. The
     * content may be specified in the html config, or it may be loaded using
     * the autoLoad config, or through the Panel's Updater. <br>
     * If this is used to load visible HTML elements in either way, then the
     * Panel may not be used as a Layout for hosting nested Panels. <br>
     * If this Panel is intended to be used as the host of a Layout (See layout
     * then the body Element must not be loaded or changed - it is under the
     * control of the Panel's Layout.
     * 
     * @return the body element
     */
    public native ExtElement getBody() /*-{
		var panel = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var el = panel.body;
		return el == null || el === undefined ? null
				: @com.eemi.ext4j.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(el);
    }-*/;

    /**
     * The Panel's footer Element. This Element is used to house the Panel's
     * buttons.
     * 
     * @return the footer element
     */
    public native ExtElement getFooter() /*-{
		var panel = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var el = panel.footer;
		return el == null || el === undefined ? null
				: @com.eemi.ext4j.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(el);
    }-*/;

    /**
     * The Panel's header Element. This Element is used to house the title and
     * tools
     * 
     * @return the header element
     */
    private native ExtElement _getHeader() /*-{
		var panel = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var el = panel.header;
		return el == null || el === undefined ? null
				: @com.eemi.ext4j.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(el);
    }-*/;

    /**
     * Gets the Header for this panel.
     * 
     * @return the header element
     */
    public native PanelHeader getHeader() /*-{
		var panel = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var el = panel.getHeader();
		return el == null || el === undefined ? null
				: @com.eemi.ext4j.client.ui.PanelHeader::new(Lcom/google/gwt/core/client/JavaScriptObject;)(el);
    }-*/;

    /**
     * The wrapper element for the body of the Panel.
     * 
     * @return the wrapper element for the body of the Panel
     */
    public native ExtElement getBodyWrap() /*-{
		var panel = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var el = panel.bwrap;
		return el == null || el === undefined ? null
				: @com.eemi.ext4j.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(el);
    }-*/;

    /**
     * Returns the height in pixels of the framing elements of this panel
     * (including any top and bottom bars and header and footer elements, but
     * not including the body height). To retrieve the body height see
     * {@link #getInnerHeight()}.
     * 
     * @return the frame hieght
     */
    public native int getFrameHeight() /*-{
		var panel = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		return panel.getFrameHeight();
    }-*/;

    /**
     * Returns the width in pixels of the framing elements of this panel (not
     * including the body width). To retrieve the body width see
     * {@link #getInnerWidth()}.
     * 
     * @return the frame width
     */
    public native int getFrameWidth() /*-{
		var panel = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		return panel.getFrameWidth();
    }-*/;

    /**
     * Returns the height in pixels of the body element (not including the
     * height of any framing elements). For the frame height see
     * {@link #getFrameHeight()} .
     * 
     * @return the inner height
     */
    public native int getInnerHeight() /*-{
		var panel = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		return panel.getInnerHeight();
    }-*/;

    /**
     * Returns the width in pixels of the body element (not including the width
     * of any framing elements). For the frame width see
     * {@link #getFrameWidth()} .
     * 
     * @return the inner width
     */
    public native int getInnerWidth() /*-{
		var panel = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		return panel.getInnerWidth();
    }-*/;

    private native void load(JavaScriptObject params)/*-{
		var panel = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		panel.load(params);
    }-*/;

    /**
     * Sets the CSS class that provides the icon image for this panel. This
     * method will replace any existing icon class if one has already been set.
     * 
     * @param cls
     *            the icon class
     */
    private native void setIconClsRendered(String cls) /*-{
		var panel = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		panel.setIconClass(cls);
    }-*/;

    /**
     * Sets the title text for the panel.
     * 
     * @param title
     *            the title
     */
    private native void setTitleRendered(String title) /*-{
		var panel = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		panel.setTitle(title);
    }-*/;

    /**
     * Sets the title text for the panel and optioanlly the icon class.
     * 
     * @param title
     *            the title
     * @param iconCls
     *            A CSS class that provides the icon image for this panel
     */
    public void setTitle(String title, String iconCls) {
        if (title == null || title.equals("")) {
            title = " ";
        }
        if (!isRendered()) {
            setTitle(title);
            setIconCls(iconCls);
        } else {
            setTitleRendered(title, iconCls);
        }
    }

    private native void setTitleRendered(String title, String iconCls) /*-{
		var panel = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		panel.setTitle(title);
    }-*/;

    /**
     * Shortcut for performing an expand or collapse based on the current state
     * of the panel.
     */
    public native void toggleCollapse() /*-{
		var panel = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		panel.toggleCollapse();
    }-*/;

    /**
     * Shortcut for performing an expand or collapse based on the current state
     * of the panel.
     * 
     * @param animate
     *            true to animate
     */
    public native void toggleCollapse(boolean animate) /*-{
		var panel = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		panel.toggleCollapse(animate);
    }-*/;

    // --- config properties

    /**
     * True to animate the transition when the panel is collapsed, false to skip
     * the animation.
     * 
     * @param animCollapse
     *            Defaults to true if the {@link Fx} class is available,
     *            otherwise false
     */
    public void setAnimCollapse(boolean animCollapse) {
        setAttribute("animCollapse", animCollapse, true);
    }

    /**
     * True to animate the transition when the panel is collapsed, false to skip
     * the animation.
     * 
     * @return true to animate the transition when the panel is collapsed, false
     *         to skip the animation
     */
    public boolean isAnimCollapse() {
        return JsoHelper.getAttributeAsBoolean(config, "animCollapse");
    }

    /**
     * True to use overflow:'auto' on the panel's body element and show scroll
     * bars automatically when necessary, false to clip any overflowing content.
     * 
     * @param autoScroll
     *            Defaults to false
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setAutoScroll(boolean autoScroll) throws IllegalStateException {
        setAttribute("autoScroll", autoScroll, true);
    }

    /**
     * True to use overflow:'auto' on the panel's body element and show scroll
     * bars automatically when necessary, false to clip any overflowing content.
     * 
     * @return true to autoscroll
     */
    public boolean isAutoScroll() {
        return JsoHelper.getAttributeAsBoolean(config, "autoScroll");
    }

    /**
     * The base CSS class to apply to this panel's element.
     * 
     * @param baseCls
     *            Defaults to 'x-panel'
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setBaseCls(String baseCls) throws IllegalStateException {
        setAttribute("baseCls", baseCls, true);
    }

    /**
     * The base CSS class to apply to this panel's element.
     * 
     * @return the base CSS class to apply to this panel's element. Defaults to
     *         'x-panel'
     */
    public String getBaseCls() {
        return JsoHelper.getAttribute(config, "baseCls");
    }

    /**
     * True to display an interior border on the body element of the panel,
     * false to hide it. This only applies when border == true. If border ==
     * true and bodyBorder == false, the border will display as a 1px wide inset
     * border, giving the entire body element an inset appearance.
     * 
     * @param bodyBorder
     *            Defaults to true
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setBodyBorder(boolean bodyBorder) throws IllegalStateException {
        setAttribute("bodyBorder", bodyBorder, true);
    }

    /**
     * @return true to display an interior border on the body element of the
     *         panel, false to hide it.
     */
    public boolean isBodyBorder() {
        return JsoHelper.getAttributeAsBoolean(config, "bodyBorder");
    }

    /**
     * True to display the borders of the panel's body element, false to hide
     * them. By default, the border is a 2px wide inset border, but this can be
     * further altered by setting bodyBorder to false.
     * 
     * @param border
     *            Defaults to true
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setBorder(boolean border) throws IllegalStateException {
        setAttribute("border", border, true);
    }

    /**
     * True to display the borders of the panel's body element, false to hide
     * them. By default, the border is a 2px wide inset border, but this can be
     * further altered by setting bodyBorder to false.
     * 
     * @return true to display the borders of the panel's body element, false to
     *         hide them.
     */
    public boolean isBorder() {
        return JsoHelper.getAttributeAsBoolean(config, "border");
    }

    /**
     * Custom CSS styles to be applied to the body element in the format
     * expected by {@link ExtElement#applyStyles(String)}
     * 
     * @param bodyStyle
     *            Defaults to null
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setBodyStyle(String bodyStyle) throws IllegalStateException {
        setAttribute("bodyStyle", bodyStyle, true, true);
    }

    /**
     * A shortcut for setting a padding style on the body element. The value can
     * either be a number to be applied to all sides, or a normal css string
     * describing padding. Defaults to undefined.
     */
    public void setBodyPadding(String value) {
        setAttribute("bodyPadding", value, true);
    }

    /**
     * A CSS class, space-delimited string of classes, or array of classes to be
     * applied to the panel's body element
     */
    public void setBodyCls(String value) {
        setAttribute("bodyCls", value, true);
    }

    /**
     * A CSS class, space-delimited string of classes, or array of classes to be
     * applied to the panel's body element
     */
    public void setBodyCls(JsArrayString value) {
        setAttribute("bodyCls", value, true);
    }

    /**
     * Whether the Panel is closable. This is applicable when a Panel is added
     * to a TabPanel.
     * 
     * @param closable
     *            true if closable
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setClosable(boolean closable) throws IllegalStateException {
        setAttribute("closable", closable, true);
    }

    /**
     * Whether the Panel is closable. This is applicable when a Panel is added
     * to a TabPanel.
     * 
     * @return true if the Panel is closable
     */
    public boolean isClosable() {
        return JsoHelper.getAttributeAsBoolean(config, "closable");
    }

    /**
     * True to make sure the collapse/expand toggle button always renders first
     * (to the left of) any other tools in the panel's title bar, false to
     * render it last.
     * 
     * @param collapseFirst
     *            Defaults to true
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setCollapseFirst(boolean collapseFirst) throws IllegalStateException {
        setAttribute("collapseFirst", collapseFirst, true);
    }

    /**
     * The direction to collapse the Panel when the toggle button is clicked.
     * <p>
     * Defaults to the headerPosition
     * <p>
     * Important: This config is ignored for collapsible Panels which are direct
     * child items of a border layout.
     * <p>
     * Specify as 'top', 'bottom', 'left' or 'right'.
     */
    public void setCollapseDirection(String value) {
        setAttribute("collapseDirection", value, true);
    }

    /**
     * May be "left", "right" or "center".
     * 
     * The alignment of the title text within the available space between the
     * icon and the tools.
     * 
     * Defaults to: "left"
     * 
     * @param value
     */
    public void setTitleAlign(Position value) {
        setAttribute("titleAlign", value.getValue(), true);
    }

    /**
     * May be "left", "right" or "center".
     * 
     * The alignment of the title text within the available space between the
     * icon and the tools.
     * 
     * Defaults to: "left"
     * 
     * @param value
     */
    public void setTitleAlign(String value) {
        setAttribute("titleAlign", value, true);
    }

    /**
     * true to allow expanding and collapsing the panel (when collapsible =
     * true) by clicking anywhere in the header bar, false) to allow it only by
     * clicking to tool button).
     * 
     * Defaults to: false
     * 
     * @param value
     */
    public void setTitleCollapse(boolean value) {
        setAttribute("titleCollapse", value, true);
    }

    /**
     * <b>Important</b>: this config is only effective for collapsible Panels
     * which are direct child items of a border layout.
     * <p>
     * When not a direct child item of a border layout, then the Panel's header
     * remains visible, and the body is collapsed to zero dimensions. If the
     * Panel has no header, then a new header (orientated correctly depending on
     * the collapseDirection) will be inserted to show a the title and a re-
     * expand tool.
     * <p>
     * When a child item of a border layout, this config has three possible
     * values:
     * <ul>
     * <li>undefined - When collapsed, a placeholder Header is injected into the
     * layout to represent the Panel and to provide a UI with a Tool to allow
     * the user to re-expand the Panel.</li>
     * <li>"header" - The Panel collapses to leave its header visible as when
     * not inside a border layout.</li>
     * <li>"mini" - The Panel collapses without a visible header.</li>
     * </ul>
     * 
     * @param value
     */
    public void setCollapseMode(String value) {
        setAttribute("collapseMode", value, true);
    }

    /**
     * True to make sure the collapse/expand toggle button always renders first
     * (to the left of) any other tools in the panel's title bar, false to
     * render it last.
     * 
     * @return true to make sure the collapse/expand toggle button always
     *         renders first
     */
    public boolean getCollapseFirst() {
        return JsoHelper.getAttributeAsBoolean(config, "collapseFirst");
    }

    /**
     * True if panel collapsed, false if expanded
     * 
     * @param collapsed
     *            Defaults to false
     */
    public void setCollapsed(boolean collapsed) {
        if (!isRendered()) {
            setAttribute("collapsed", collapsed, true);
        } else {
            if (collapsed) {
                collapse();
            } else {
                expand();
            }
        }
    }

    /**
     * True if panel collapsed, false if expanded.
     * 
     * @return true to render the panel expanded, false to render it collapsed
     */
    public boolean isCollapsed() {
        if (!isRendered()) {
            return getAttributeAsBoolean("collapsed");
        } else {
            return JsoHelper.getAttributeAsBoolean(getJsObj(), "collapsed");
        }
    }

    /**
     * A CSS class to add to the panel's element after it has been collapsed.
     * 
     * @param collapsedCls
     *            Defaults to 'x-panel-collapsed'
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setCollapsedCls(String collapsedCls) throws IllegalStateException {
        setAttribute("collapsedCls", collapsedCls, true);
    }

    /**
     * A CSS class to add to the panel's element after it has been collapsed.
     * 
     * @return the CSS class to add to the panel's element after it has been
     *         collapsed.
     */
    public String getCollapsedCls() {
        return JsoHelper.getAttribute(config, "collapsedCls");
    }

    /**
     * True to make the panel collapsible and have the expand/collapse toggle
     * button automatically rendered into the header tool button area, false to
     * keep the panel statically sized with no button.
     * 
     * @param collapsible
     *            Defaults to false
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setCollapsible(boolean collapsible) throws IllegalStateException {
        setAttribute("collapsible", collapsible, true);
    }

    /**
     * True to make the panel collapsible and have the expand/collapse toggle
     * button automatically rendered into the header tool button area, false to
     * keep the panel statically sized with no button.
     * 
     * @return true to make the panel collapsible and have the expand/collapse
     *         toggle button automatically rendered into the header tool button
     *         area, false to keep the panel statically sized with no button
     */
    public boolean isCollapsible() {
        return JsoHelper.getAttributeAsBoolean(config, "collapsible");
    }

    /**
     * The id of an existing HTML node to use as the panel's body content
     * 
     * @param contentEl
     *            Defaults to null
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setContentEl(Element contentEl) throws IllegalStateException {
        setAttribute("contentEl", new ExtElement(contentEl).getJsObj(), true);
    }

    public void setContentEl(ExtElement contentEl) throws IllegalStateException {
        setAttribute("contentEl", contentEl.getJsObj(), true, true);
    }

    /**
     * True to apply a frame to the panel.
     * 
     * @param frame
     *            Defaults to false
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setFrame(boolean frame) throws IllegalStateException {
        setAttribute("frame", frame, true);
    }

    /**
     * Pass as false to prevent a Header from being created and shown.
     */
    public void setFrameHeader(boolean value) {
        setAttribute("frameHeader", value, true);
    }

    /**
     * @return true to render the panel with custom rounded borders
     */
    public boolean isFrame() {
        return JsoHelper.getAttributeAsBoolean(config, "frame");
    }

    /**
     * True to create the header element explicitly, false to skip creating it.
     * By default, when header is not specified, if a title is set the header
     * will be created automatically, otherwise it will not. If a title is set
     * but header is explicitly set to false, the header will not be rendered.
     * 
     * @param header
     *            true to create header
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setHeader(boolean header) throws IllegalStateException {
        setAttribute("header", header, false);
    }

    /**
     * True to create the header element explicitly, false to skip creating it.
     * By default, when header is not specified, if a title is set the header
     * will be created automatically, otherwise it will not. If a title is set
     * but header is explicitly set to false, the header will not be rendered.
     * 
     * @return true to create header
     */
    public boolean isHeader() {
        return JsoHelper.getAttributeAsBoolean(config, "header");
    }

    /**
     * Specify as 'top', 'bottom', 'left' or 'right'.
     * 
     * Defaults to: "top"
     * 
     * @param header
     */
    public void setHeaderPosition(Position position) {
        setAttribute("headerPosition", position.getValue(), true);
    }

    /**
     * True to display the panel title in the header, false to hide it
     * 
     * <br>
     * <br>
     * <b>Note:</b> This property cannot be changed after the Component has been
     * rendered.
     * 
     * @param headerAsText
     *            Defaults to true
     */
    public void setHeaderAsText(boolean headerAsText) {
        setAttribute("headerAsText", headerAsText, true, true);
    }

    /**
     * @return true to display the panel title in the header, false to hide it
     */
    public boolean isHeaderAsText() {
        return JsoHelper.getAttributeAsBoolean(config, "headerAsText");
    }

    /**
     * True to hide the expand/collapse toggle button when collapsible = true,
     * false to display it.
     * 
     * @param hideCollapseTool
     *            Defaults to false
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setHideCollapseTool(boolean hideCollapseTool) throws IllegalStateException {
        setAttribute("hideCollapseTool", hideCollapseTool, true);
    }

    /**
     * True to hide the expand/collapse toggle button when collapsible = true,
     * false to display it.
     * 
     * @return true to hide the expand/collapse toggle button when collapsible =
     *         true, false to display it.
     */
    public boolean isHideCollapseTool() {
        return JsoHelper.getAttributeAsBoolean(config, "hideCollapseTool");
    }

    /**
     * An HTML fragment, or a DomHelper specification to use as the panel's body
     * content.
     * 
     * @param html
     *            Defaults to ""
     */
    public void setHtml(String html) {
        if (isRendered()) {
            getBody().update(html);
        } else {
            setAttribute("html", html, true);
        }
    }

    /**
     * An HTML fragment, or a DomHelper specification to use as the panel's body
     * content.
     * 
     * @return the HTML fragment, or a DomHelper specification to use as the
     *         panel's body content.
     */
    public String getHtml() {
        if (isRendered()) {
            return getBody().getDom().toString();
        } else {
            return JsoHelper.getAttribute(config, "html");
        }
    }

    /**
     * A CSS class that will provide a background image to be used as the panel
     * header icon
     * 
     * @param iconCls
     *            Defaults to ""
     */
    public void setIconCls(String iconCls) {
        if (!isRendered()) {
            setAttribute("iconCls", iconCls, true);
        } else {
            setIconClsRendered(iconCls);
        }
    }

    /**
     * @return the CSS class that will provide a background image to be used as
     *         the panel header icon
     */
    public String getIconCls() {
        return getAttribute("iconCls");
    }

    /**
     * True to mask the panel when it is disabled, false to not mask it. Either
     * way, the panel will always tell its contained elements to disable
     * themselves when it is disabled, but masking the panel can provide an
     * additional visual cue that the panel is disabled.
     * 
     * @param maskDisabled
     *            Defaults to true
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setMaskDisabled(boolean maskDisabled) throws IllegalStateException {
        setAttribute("maskDisabled", maskDisabled, true);
    }

    /**
     * @return true to mask the panel when it is disabled, false to not mask it.
     */
    public boolean isMaskDisabled() {
        return JsoHelper.getAttributeAsBoolean(config, "maskDisabled");
    }

    /**
     * Minimum width in pixels of all buttons in this panel.
     * 
     * @param minButtonWidth
     *            Defaults to 75
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setMinButtonWidth(int minButtonWidth) throws IllegalStateException {
        setAttribute("minButtonWidth", minButtonWidth, true);
    }

    /**
     * Minimum width in pixels of all buttons in this panel.
     * 
     * @return the minimum width in pixels of all buttons in this panel.
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public int getMinButtonWidth() throws IllegalStateException {
        return getAttributeAsInt("minButtonWidth");
    }

    // todo add string option for custom shadows
    /**
     * True to display a shadow behind the panel, false to display no shadow
     * (defaults to 'sides'). Note that this option only applies when floating =
     * true.
     * 
     * @param shadow
     *            true to display shadow
     */
    public void setShadow(boolean shadow) {
        setAttribute("shadow", shadow, true, true);
    }

    /**
     * True to display a shadow behind the panel, false to display no shadow
     * (defaults to 'sides').
     * 
     * @return true to display a shadow behind the panel, false to display no
     *         shadow (defaults to 'sides').
     */
    public boolean isShadow() {
        return getAttributeAsBoolean("shadow");
    }

    /**
     * The number of pixels to offset the shadow if displayed. Note that this
     * option only applies when floating = true.
     * 
     * @param shadowOffset
     *            Defaults to 4
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setShadowOffset(int shadowOffset) throws IllegalStateException {
        setAttribute("shadowOffset", shadowOffset, true);
    }

    /**
     * The number of pixels to offset the shadow if displayed. Note that this
     * option only applies when floating = true.
     * 
     * @return the number of pixels to offset the shadow if displayed. Note that
     *         this option only applies when floating = true.
     */
    public int getShadowOffset() {
        return getAttributeAsInt("shadowOffset");
    }

    /**
     * False to disable the iframe shim in browsers which need one. Note that
     * this option only applies when floating = true.
     * 
     * @param shim
     *            Defaults to true
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setShim(boolean shim) throws IllegalStateException {
        setAttribute("shim", shim, true);
    }

    /**
     * False to disable the iframe shim in browsers which need one. Note that
     * this option only applies when floating = true.
     * 
     * @return false to disable the iframe shim in browsers which need one.
     */
    public boolean isShim() {
        return getAttributeAsBoolean("shim");
    }

    /**
     * Set the tab CSS Class. This method is only applicable it the PAnel is
     * being added to a TabPanel. This CSS class is applied to the &lt;li&gt;
     * elements of the tab in the tabpanel.
     * 
     * @param tabCls
     *            the tabCls
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setTabCls(String tabCls) {
        setAttribute("tabCls", tabCls, true);
    }

    /**
     * Return the tab CSS Class.
     * 
     * @return the tabCls
     */
    public String getTabCls() {
        return getAttribute("tabCls");
    }

    /**
     * The title text to display in the panel header. When a title is specified
     * the header element will automatically be created and displayed unless
     * header is explicitly set to false. If you don't want to specify a title
     * at config time, but you may want one later, you must either specify a
     * non-empty title (a blank space " " will do) or call setHeader(true) so
     * that the container element will get created.
     * 
     * @param title
     *            Defaults to ""
     */
    public void setTitle(String title) {
        if (title == null || title.equals("")) {
            title = " ";
        }
        if (!isRendered()) {
            setAttribute("title", title, true);
        } else {
            setTitleRendered(title);
        }

    }

    /**
     * The title text to display in the panel header.
     * 
     * @return the title text to display in the panel header.
     */
    public String getTitle() {
        return getAttribute("title");
    }

    public void addDocked(Component component) {
        addDockedRendered(component.getOrCreateJsObj());
    }

    private native void addDockedRendered(JavaScriptObject component) /*-{
		var panel = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		panel.addDocked(component);
    }-*/;

    public void setTopBar(ToolBar component) {
        setAttribute("tbar", component.getOrCreateJsObj(), true);
    }

    public void setBottomBar(ToolBar component) {
        setAttribute("bbar", component.getOrCreateJsObj(), true);
    }

    /**
     * A single item, or an array of child Components to be added to this
     * container
     */
    public void setDockedItems(Component... items) {
        setAttribute("dockedItems", ComponentFactory.fromArray(items), true);
    }

    /**
     * Return the docked items of this panel
     * 
     * @return
     */
    public List<Component> getDockesItems() {
        return this.dockedItems;
    }

    /**
     * An array of {@link Tool} instances to be added to the header tool area.
     * The tools are stored as child components of the header container. The
     * toggle tool is automatically created if collapsible is set to true.
     * <p>
     * Note that, apart from the toggle tool which is provided when a panel is
     * collapsible, these tools only provide the visual button. Any required
     * functionality must be provided by adding handlers that implement the
     * necessary behavior.
     */
    public void setTools(Tool... items) {
        for (Tool t : items) {
            tools.add(t);
        }
        setAttribute("tools", ComponentFactory.fromArray(items), true);
    }

    /**
     * Add a tool to the internal set of tools.
     * 
     * @param tool
     *            , the tool to add
     */
    public void addTool(Tool tool) {
        this.tools.add(tool);
    }

    /**
     * Update this panel with the internal set of tools
     */
    public void drawTools() {
        int i = 0;
        toolArray = new Tool[tools.size()];
        Iterator<Tool> it = tools.iterator();
        while (it.hasNext()) {
            Tool t = it.next();
            toolArray[i++] = t;
        }
        setTools(toolArray);

    }

    /**
     * Get the tools added to this panel. This method only return the tools
     * added via <code>setTools()</code> or <code>addTool()</code>
     * 
     * @return the tools added to this panel
     */
    public Set<Tool> getTools() {
        return tools;
    }

    public void addButtons(Button... buttons) {
        toolBar = new FooterToolBar();
        for (Button component : buttons) {
            toolBar.add(component);
        }
        addDocked(toolBar);
    }

    public FooterToolBar getFooterToolBar() {
        return this.toolBar;
    }

    public void setCloseAction(String constrain) {
        setAttribute("closeAction", constrain, true);
    }

    public void setButtons(Button... buttons) {
        JsArray<JavaScriptObject> peers = JsArray.createArray().cast();
        for (Button b : buttons) {
            peers.push(b.getOrCreateJsObj());
        }
        setAttribute("buttons", peers, true);
    }

    /**
     * The alignment of any buttons added to this panel. Valid values are
     * 'right', 'left' and 'center' (defaults to 'right' for buttons/fbar,
     * 'left' for other toolbar types).
     * 
     * <p>
     * NOTE: The prefered way to specify toolbars is to use the dockedItems
     * config. Instead of buttonAlign you would add the layout: { pack: 'start'
     * | 'center' | 'end' } option to the dockedItem config.
     * 
     * @param align
     */
    public void setButtonAlign(String align) {
        setAttribute("buttonAlign", align, true);
    }

    /**
     * Closes the Panel. By default, this method, removes it from the DOM,
     * destroys the Panel object and all its descendant Components. The
     * beforeclose event is fired before the close happens and will cancel the
     * close action if it returns false.
     * 
     * Note: This method is also affected by the closeAction setting. For more
     * explicit control use destroy and hide methods.
     */
    public native void close() /*-{
		var panel = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		panel.close();
    }-*/;

    /**
     * Returns the current collapsed state of the panel.
     */
    public native String getCollapseDirection() /*-{
		var panel = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		return panel.getCollapsed();
    }-*/;

    /**
     * Set the icon for the panel's header.It will fire the iconchange event
     * after completion.
     * 
     * @param icon
     *            , the new icon path
     */
    public native void setIcon(String icon) /*-{
		var panel = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		panel.setIcon(icon);
    }-*/;

    public void setIcon(ImageResource imageResource) {
        this.iconImage.setResource(imageResource);
        this.setIcon(this.iconImage.getUrl());
    }

    /**
     * Add a Component to the Container.
     * 
     * @param component
     *            the component to add
     */
    @Override
    public void add(Component component) {
        if (component instanceof ToolBar) {
            this.addDocked((ToolBar) component);
        } else {
            super.add(component);
        }
    }

    public static Panel cast(Component component) {
        return new Panel(component.getOrCreateJsObj());
    }

    public static Panel cast(JavaScriptObject peer) {
        return new Panel(peer);
    }

    /**
     * Fires before the user closes the panel. Return false from any listener to
     * stop the close event being fired
     * 
     * @param handler
     *            , the handler that will handle the event
     * @return. false to stop the close event to be fired
     */
    public native void addBeforeCloseHandler(PanelBeforeCloseHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		if (component) {
			component
					.addListener(
							@com.eemi.ext4j.client.events.Event::BEFORE_CLOSE,
							$entry(function(p) {
								var panel = @com.eemi.ext4j.client.ui.Panel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(p);
								return handler.@com.eemi.ext4j.client.events.panel.PanelBeforeCloseHandler::onEvent(Lcom/eemi/ext4j/client/ui/Panel;)(panel);
							}));
		}

    }-*/;

    public native HandlerRegistration addBeforeCloseHandler(BeforeCloseHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(p, e) {
			var panel = @com.eemi.ext4j.client.ui.Panel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(p);
			var event = @com.eemi.ext4j.client.events.panel.BeforeCloseEvent::new(Lcom/eemi/ext4j/client/ui/Panel;Lcom/google/gwt/core/client/JavaScriptObject;)(panel,e);
			handler.@com.eemi.ext4j.client.events.panel.BeforeCloseHandler::onBeforeClose(Lcom/eemi/ext4j/client/events/panel/BeforeCloseEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.panel.BeforeCloseEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * Fires before this panel is collapsed. Return false to prevent the
     * collapse.
     * 
     * @param handler
     *            , the handler that will handle the event
     * @return. false to stop the close event to be fired
     */
    public native void addBeforeCollapseHandler(PanelBeforeCollapseHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		if (component) {
			component
					.addListener(
							@com.eemi.ext4j.client.events.Event::BEFORE_COLLAPSE,
							$entry(function(p, direction, animate) {
								var panel = @com.eemi.ext4j.client.ui.Panel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(p);
								return handler.@com.eemi.ext4j.client.events.panel.PanelBeforeCollapseHandler::onEvent(Lcom/eemi/ext4j/client/ui/Panel;Ljava/lang/String;Z)(panel,direction, animate);
							}));
		}

    }-*/;

    public native HandlerRegistration addBeforeCollapseHandler(BeforeCollapseHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(p, direction, animate, e) {
			var panel = @com.eemi.ext4j.client.ui.Panel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(p);
			var event = @com.eemi.ext4j.client.events.panel.BeforeCollapseEvent::new(Lcom/eemi/ext4j/client/ui/Panel;Ljava/lang/String;ZLcom/google/gwt/core/client/JavaScriptObject;)(panel,direction,animate,e);
			handler.@com.eemi.ext4j.client.events.panel.BeforeCollapseHandler::onBeforeCollapse(Lcom/eemi/ext4j/client/events/panel/BeforeCollapseEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.panel.BeforeCollapseEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * Fires before this panel is expanded. Return false to prevent the expand.
     * 
     * @param handler
     *            , the handler that will handle the event
     * @return. false to stop the expand event to be fired
     */
    public native void addBeforeExpandHandler(PanelBeforeExpandHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		if (component) {
			component
					.addListener(
							@com.eemi.ext4j.client.events.Event::BEFORE_EXPAND,
							$entry(function(p, animate) {
								var panel = @com.eemi.ext4j.client.ui.Panel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(p);
								return handler.@com.eemi.ext4j.client.events.panel.PanelBeforeExpandHandler::onEvent(Lcom/eemi/ext4j/client/ui/Panel;Z)(panel,animate);
							}));
		}

    }-*/;

    public native HandlerRegistration addBeforeExpandHandler(BeforeExpandHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(p, animate, e) {
			var panel = @com.eemi.ext4j.client.ui.Panel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(p);
			var event = @com.eemi.ext4j.client.events.panel.BeforeExpandEvent::new(Lcom/eemi/ext4j/client/ui/Panel;ZLcom/google/gwt/core/client/JavaScriptObject;)(panel,animate,e);
			handler.@com.eemi.ext4j.client.events.panel.BeforeExpandHandler::onBeforeExpand(Lcom/eemi/ext4j/client/events/panel/BeforeExpandEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.panel.BeforeExpandEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * Fires when the user closes the panel.
     * 
     * @param handler
     *            , the handler that will handle the event
     */

    public native HandlerRegistration addCloseHandler(com.eemi.ext4j.client.events.panel.CloseHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(p, e) {
			var panel = @com.eemi.ext4j.client.ui.Panel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(p);
			var event = @com.eemi.ext4j.client.events.panel.CloseEvent::new(Lcom/eemi/ext4j/client/ui/Panel;Lcom/google/gwt/core/client/JavaScriptObject;)(panel,e);
			handler.@com.eemi.ext4j.client.events.panel.CloseHandler::onClose(Lcom/eemi/ext4j/client/events/panel/CloseEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.panel.CloseEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * Fires after this Panel has collapsed.
     * 
     * @param handler
     *            , the handler that will handle the event
     */

    public native HandlerRegistration addCollapseHandler(CollapseHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(p, e) {
			var panel = @com.eemi.ext4j.client.ui.Panel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(p);
			var event = @com.eemi.ext4j.client.events.panel.CollapseEvent::new(Lcom/eemi/ext4j/client/ui/Panel;Lcom/google/gwt/core/client/JavaScriptObject;)(panel,e);
			handler.@com.eemi.ext4j.client.events.panel.CollapseHandler::onCollapse(Lcom/eemi/ext4j/client/events/panel/CollapseEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.panel.CollapseEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * Fires after this Panel has expanded.
     * 
     * @param handler
     *            , the handler that will handle the event
     */
    public native HandlerRegistration addExpandHandler(com.eemi.ext4j.client.events.panel.ExpandHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(p, e) {
			var panel = @com.eemi.ext4j.client.ui.Panel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(p);
			var event = @com.eemi.ext4j.client.events.panel.ExpandEvent::new(Lcom/eemi/ext4j/client/ui/Panel;Lcom/google/gwt/core/client/JavaScriptObject;)(panel,e);
			handler.@com.eemi.ext4j.client.events.panel.ExpandHandler::onExpand(Lcom/eemi/ext4j/client/events/panel/ExpandEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.panel.ExpandEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * Fires after a collapsed Panel has been "floated" by clicking on its
     * header. Only applicable when the Panel is an item in a Border Layout.
     * 
     * @param handler
     *            , the handler that will handle the event
     */
    public native HandlerRegistration addFloatHandler(FloatHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(e) {
			var event = @com.eemi.ext4j.client.events.panel.FloatEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
			handler.@com.eemi.ext4j.client.events.panel.FloatHandler::onFloat(Lcom/eemi/ext4j/client/events/panel/FloatEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.panel.FloatEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * Fires after the Panel icon has been set or changed.
     * 
     * @param handler
     *            , the handler that will handle the event
     */

    public native HandlerRegistration addIconChangeHandler(IconChangeHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(p, newIcon, oldIcon, e) {
			var panel = @com.eemi.ext4j.client.ui.Panel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(p);
			var event = @com.eemi.ext4j.client.events.panel.IconChangeEvent::new(Lcom/eemi/ext4j/client/ui/Panel;Ljava/lang/String;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(panel, newIcon, oldIcon, e);
			handler.@com.eemi.ext4j.client.events.panel.IconChangeHandler::onIconChange(Lcom/eemi/ext4j/client/events/panel/IconChangeEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.panel.IconChangeEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * Fires after the Panel iconCls has been set or changed.
     * 
     * @param handler
     *            , the handler that will handle the event
     */

    public native HandlerRegistration addIconClsChangeHandler(IconClsChangeHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(p, newIconCls, oldIconCls, e) {
			var panel = @com.eemi.ext4j.client.ui.Panel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(p);
			var event = @com.eemi.ext4j.client.events.panel.IconClsChangeEvent::new(Lcom/eemi/ext4j/client/ui/Panel;Ljava/lang/String;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(panel, newIconCls, oldIconCls, e);
			handler.@com.eemi.ext4j.client.events.panel.IconClsChangeHandler::onIconClsChange(Lcom/eemi/ext4j/client/events/panel/IconClsChangeEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.panel.IconClsChangeEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * Fires after the Panel title has been set or changed.
     * 
     * @param handler
     *            , the handler that will handle the event
     */

    public native HandlerRegistration addTitleChangeHandler(TitleChangeHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(p, newTitle, oldTitle, e) {
			var panel = @com.eemi.ext4j.client.ui.Panel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(p);
			var event = @com.eemi.ext4j.client.events.panel.TitleChangeEvent::new(Lcom/eemi/ext4j/client/ui/Panel;Ljava/lang/String;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(panel, newTitle, oldTitle,e);
			handler.@com.eemi.ext4j.client.events.panel.TitleChangeHandler::onTitleChange(Lcom/eemi/ext4j/client/events/panel/TitleChangeEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.panel.TitleChangeEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * Fires after a "floated" Panel has returned to its collapsed state as a
     * result of the mouse leaving the Panel. Only applicable when the Panel is
     * an item in a Border Layout.
     * 
     * @param handler
     *            , the handler that will handle the event
     */
    public native HandlerRegistration addUnFloatHandler(UnFloatHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(e) {
			var event = @com.eemi.ext4j.client.events.panel.UnFloatEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
			handler.@com.eemi.ext4j.client.events.panel.UnFloatHandler::onUnFloat(Lcom/eemi/ext4j/client/events/panel/UnFloatEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.panel.UnFloatEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

}
