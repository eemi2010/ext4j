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
import com.ait.ext4j.client.core.Function;
import com.ait.ext4j.client.core.JsoHelper;
import com.ait.ext4j.client.core.Template;
import com.ait.ext4j.client.core.config.XType;
import com.ait.ext4j.client.events.HandlerRegistration;
import com.ait.ext4j.client.events.button.ClickHandler;
import com.ait.ext4j.client.events.button.GlyphChangeHandler;
import com.ait.ext4j.client.events.button.IconChangeHandler;
import com.ait.ext4j.client.events.button.MenuHideHandler;
import com.ait.ext4j.client.events.button.MenuShowHandler;
import com.ait.ext4j.client.events.button.MenuTriggerOutHandler;
import com.ait.ext4j.client.events.button.MenuTriggerOverHandler;
import com.ait.ext4j.client.events.button.MouseOverHandler;
import com.ait.ext4j.client.events.button.TextChangeHandler;
import com.ait.ext4j.client.events.button.ToggleHandler;
import com.ait.ext4j.client.laf.Alignment;
import com.ait.ext4j.client.laf.ButtonScale;
import com.ait.ext4j.client.tip.Tip;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.Image;

/**
 * A simple class to display different styles of buttons.
 * 
 */
public class Button extends Component {

    private static JavaScriptObject configPrototype;
    protected Menu menu;
    private final Image iconImage = new Image();

    private static int buttonId = 2000;

    private native void init()/*-{
		var c = new $wnd.Ext.Button();
		@com.ait.ext4j.client.ui.Button::configPrototype = c.initialConfig;
    }-*/;

    protected JavaScriptObject getConfigPrototype() {
        return configPrototype;
    }

    /**
     * Create a new Button.
     */
    public Button() {
        // init();
        id = new StringBuilder().append("ext-").append(this.getXType()).append("-").append(++buttonId).toString();
        JsoHelper.setAttribute(config, "id", id);
        // setText("Button");
    }

    /**
     * Create a new Button
     * 
     * @param text
     *            , the button label
     */
    public Button(String text) {
        if (text != null)
            setText(text);
    }

    public Button(String text, ClickHandler handler) {
        this(text);
        addClickHandler(handler);
    }

    protected Button(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public static Button instance(JavaScriptObject jsObj) {
        return new Button(jsObj);
    }

    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.Button(config);
    }-*/;

    /**
     * Returns true if button is disabled.
     * 
     * @return true if disabled
     */
    public boolean isDisabled() {
        return super.isDisabled();
    }

    /**
     * An Ext Button consists of a table that wraps a button element. This
     * method returns the underlying Button element. <br>
     * <b>Note:</b> This method should be called only after the Button has been
     * Rendered.
     * 
     * @return the Button Element
     */
    public native Element getButtonElement() /*-{
		var button = this.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()();
		var but = button.el.child('button:first').dom;
		return but;
    }-*/;

    /**
     * Returns true if the button has a menu and it is visible.
     * 
     * @return true if menu visible
     */
    public native boolean hasVisibleMenu() /*-{
		var button = this.@com.ait.ext4j.client.core.Component::getJsObj()();
		if (button == null)
			return false;
		return button.hasVisibleMenu();
    }-*/;

    /**
     * Sets this button's text.
     * 
     * @param text
     *            the text
     */
    private native void setRenderedText(String text) /*-{
		var button = this.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()();
		button.setText(text);
    }-*/;

    /**
     * Toggle the current state.
     */
    public void toggle() {
        if (!isRendered()) {
            setPressed(!isPressed());
        } else {
            toggleRendered();
        }
    }

    private native void toggleRendered() /*-{
		var button = this.@com.ait.ext4j.client.core.Component::getJsObj()();
		if (button != null)
			button.toggle();
    }-*/;

    /**
     * Toggle the button to the passed state.
     * 
     * @param state
     *            true to toggle pressed
     */
    public void toggle(boolean state) {
        if (!isRendered()) {
            setPressed(state);
        } else {
            toggleRendered(state);
        }
    }

    private native void toggleRendered(boolean state) /*-{
		var button = this.@com.ait.ext4j.client.core.Component::getJsObj()();
		if (button != null)
			button.toggle(state);
    }-*/;

    // --- config properties ---
    public String getXType() {
        return XType.BUTTON.getValue();
    }

    /**
     * True to enable pressed/not pressed toggling (defaults to false).
     * 
     * @param enableToggle
     *            true to enable toggle
     */
    public void setEnableToggle(boolean enableToggle) {
        if (isRendered()) {
            toggle(enableToggle);
        } else {
            setAttribute("enableToggle", enableToggle, true);
        }
    }

    /**
     * @return true if toggle enabled
     */
    public boolean isEnableToggle() {
        return getAttributeAsBoolean("enableToggle");
    }

    /**
     * False to disable visual cues on mouseover, mouseout and mousedown
     * (defaults to true).
     * 
     * @param handleMouseEvents
     *            false to diable visual cues
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setHandleMouseEvents(boolean handleMouseEvents) throws IllegalStateException {
        setAttribute("handleMouseEvents", handleMouseEvents, true);
    }

    /**
     * False to disable visual cues on mouseover, mouseout and mousedown
     * (defaults to true).
     * 
     * @return true if visual cues on mouseover, mouseout and mousedown are
     *         enabled
     */
    public boolean getHandleMouseEvents() {
        return getAttributeAsBoolean("handleMouseEvents");
    }

    /**
     * True to start hidden or hide rendered button (defaults to false).
     * 
     * @param hidden
     *            true for hidden
     */
    public void setHidden(boolean hidden) {
        if (!isRendered()) {
            setAttribute("hidden", hidden, true);
        } else {
            hide();
        }
    }

    public void setIcon(ImageResource imageResource) {
        this.iconImage.setResource(imageResource);
        this.setIcon(this.iconImage.getUrl());
    }

    /**
     * The path to an image to display in the button (the image will be set as
     * the background-image CSS property of the button by default, so if you
     * want a mixed icon/text button, set cls:"x-btn-text-icon")
     * 
     * @param icon
     *            the icon
     */
    public void setIcon(String icon) {
        if (!isRendered()) {
            setAttribute("icon", icon, true);
        } else {
            setIcon0(icon);
        }
        if (getText() == null) {
            addCls("x-btn-icon");
        } else {
            addCls("x-btn-text-icon");
        }
    }

    private native void setIcon0(String icon) /*-{
		var button = this.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()();
		button.setIcon(icon);
    }-*/;

    /**
     * @return the path of the Button icon image
     */
    public String getIcon() {
        return getAttribute("icon");
    }

    /**
     * A css class which sets a background image to be used as the icon for this
     * button (defaults to undefined).
     * 
     * @param iconCls
     *            the icon CSS class
     */
    public void setIconCls(String iconCls) {
        if (isCreated()) {
            if (getCls() == null) {
                addCls(getText() != null ? "x-btn-text-icon" : "x-btn-icon");
            }
            setIconClsCreated(iconCls);
        } else {
            setAttribute("iconCls", iconCls, false);
        }
    }

    private native void setIconClsCreated(String iconCls) /*-{
		var button = this.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()();
		button.setIconClass(iconCls);
    }-*/;

    /**
     * @return the icon CSS class for this Button
     */
    public String getIconCls() {
        return getAttribute("iconCls");
    }

    /**
     * Sets the icon alignment of this button
     * 
     * @param iconAlign
     */
    public void setIconAlign(String iconAlign) {
        setAttribute("iconAlign", iconAlign, true);
    }

    /**
     * Sets the icon alignment of this button
     * 
     * @param iconAlign
     */
    public void setIconAlign(Alignment align) {
        setIconAlign(align.getValue());
    }

    /**
     * @return the icon CSS class for this Button
     */
    public String getIconAlign() {
        return getAttribute("iconAlign");
    }

    /**
     * The minimum width for this button.
     * 
     * @param minWidth
     *            the min width
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setMinWidth(int minWidth) throws IllegalStateException {
        setAttribute("minWidth", minWidth, true);
    }

    /**
     * The minimum width for this button.
     * 
     * @return the Button min width
     */
    public int getMinWidth() {
        return getAttributeAsInt("minWidth");
    }

    /**
     * True to start pressed (only if enableToggle = true).
     * 
     * @param pressed
     *            true for pressed
     */
    public void setPressed(boolean pressed) {
        if (!isRendered()) {
            setAttribute("pressed", pressed, true);
        } else {
            toggle(pressed);
        }
    }

    /**
     * True if the Button is pressed.
     * 
     * @return true if start Button pressed (only if enableToggle = true)
     * @see #toggle(boolean)
     */
    public boolean isPressed() {
        return getAttributeAsBoolean("pressed");
    }

    /**
     * Set a DOM tabIndex for this button.
     * 
     * @param tabIndex
     *            the tab index
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setTabIndex(int tabIndex) throws IllegalStateException {
        setAttribute("tabIndex", tabIndex, true);
    }

    /**
     * @return the tab index, 0 if undefined
     */
    public int getTabIndex() {
        return getAttributeAsInt("tabIndex");
    }

    /**
     * A {@link Template} with which to create the Button's main element. This
     * Template must contain numeric substitution parameter 0 if it is to
     * display the text property. Changing the template could require code
     * modifications if required elements (e.g. a button) aren't present.
     * 
     * The defaut tempalte is
     * 
     * <pre>
     * <code>
     * 
     * &lt;table border="0" cellpadding="0" cellspacing="0" class="x-btn-wrap"&gt;&lt;tbody&gt;&lt;tr&gt;
     *   &lt;td class="x-btn-left"&gt;&lt;i&gt;&#160;&lt;/i&gt;&lt;/td&gt;&lt;td class="x-btn-center"&gt;&lt;em unselectable="on"&gt;&lt;button class="x-btn-text" type="{1}"&gt;{0}&lt;/button&gt;&lt;/em&gt;&lt;/td&gt;&lt;td class="x-btn-right"&gt;&lt;i&gt;&#160;&lt;/i&gt;&lt;/td&gt;
     * &lt;/tr&gt;&lt;/tbody&gt;&lt;/table&gt;
     * </code>
     * </pre>
     * 
     * @param template
     *            the button template
     */
    public void setTemplate(Template template) {
        setAttribute("tpl", template.getJsObj(), true);
    }

    /**
     * The button text.
     * 
     * @param text
     *            the buttons text
     */
    public void setText(String text) {
        if (isRendered()) {
            setRenderedText(text);
        } else {
            setAttribute("text", text, true);
        }
    }

    /**
     * @return the Button's text
     */
    public String getText() {
        if (isRendered()) {
            this.addListener("", new Function() {

                @Override
                public void execute() {
                    // TODO Auto-generated method stub

                }
            });
            return getRenderedText();

        } else {
            return getAttribute("text");
        }
    }

    /**
     * The group this toggle button is a member of (only 1 per group can be
     * pressed, only applies if enableToggle = true).
     * 
     * @param toggleGroup
     *            the button's toggle group
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setToggleGroup(String toggleGroup) throws IllegalStateException {
        setAttribute("toggleGroup", toggleGroup, true);
        setEnableToggle(true);
    }

    /**
     * @return the Button's toggle group
     */
    public String getToggleGroup() {
        return getAttribute("toggleGroup");
    }

    /**
     * The button's type, corresponding to the DOM input element type attribute.
     * Either "submit," "reset" or "button" (default).
     * 
     * @param type
     *            the button type
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setType(String type) throws IllegalStateException {
        setAttribute("type", type, true);
    }

    /**
     * The button's type, corresponding to the DOM input element type attribute.
     * Either "submit," "reset" or "button" (default).
     * 
     * @return the Button type
     */
    public String getType() {
        return getAttribute("type");
    }

    /**
     * Assign a button menu.
     * 
     * @param menu
     *            the button menu
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setMenu(Menu menu) throws IllegalStateException {
        this.menu = menu;
        setAttribute("menu", menu.getOrCreateJsObj(), true);
    }

    public void setMenu(Panel menu) throws IllegalStateException {
        // this.menu = menu;
        setAttribute("menu", menu.getOrCreateJsObj(), true);
    }

    /**
     * 
     * Get the menu assigned to this button
     * 
     * @return, the menu assigned to this button
     */
    public Menu getMenu() {
        return this.menu;
    }

    /**
     * The position to align the menu to. Defaults to tl-bl?
     * 
     * @param position
     *            , the menu's anchor position
     */
    public void setMenuAlign(Alignment position) {
        setMenuAlign(position.getValue());
    }

    public void setMenuAlign(String anchorPosition) {
        setAttribute("menuAlign", anchorPosition, true, true);
    }

    /**
     * The CSS class to add to a button when it's menu is active.
     * 
     * Defaults to: "menu-active"
     * 
     * @param value
     *            , the value of the menuActiveCls value
     */
    public void setMenuActiveCls(String value) {
        setAttribute("menuActiveCls", value, true, true);

    }

    /**
     * The CSS class to add to a button when it is in the over (hovered) state.
     * 
     * Defaults to: "over"
     * 
     * @param value
     *            , the value of the overCls value
     */
    public void setOverCls(String value) {
        setAttribute("overCls", value, true, true);
    }

    /**
     * If used in a {@link ToolBar}, the text to be used if this item is shown
     * in the overflow menu.
     * 
     * @param value
     *            , the value of the overflowText property
     */
    public void setOverflowText(String value) {
        setAttribute("overflowText", value, true, true);
    }

    /**
     * The CSS class to add to a button when it is in the pressed state.
     * 
     * Defaults to: "pressed"
     * 
     * @param value
     *            , the value of the pressedCls property
     */
    public void setPressedCls(String value) {
        setAttribute("pressedCls", value, true, true);
    }

    /**
     * True to prevent the default action when the clickEvent is processed.
     * 
     * Defaults to: true
     * 
     * @param value
     *            , the value of the preventDefault property
     */
    public void setPreventDefault(boolean value) {
        setAttribute("preventDefault", value, true, true);
    }

    /**
     * True to repeat fire the click event while the mouse is down.
     * 
     * Defaults to: false
     * 
     * @param value
     *            , the value of the repeat property
     */
    public void setRepeat(boolean value) {
        setAttribute("repeat", value, true, true);
    }

    /**
     * The text alignment for this button (center, left, right).
     * 
     * Defaults to: "center"
     * 
     * @param value
     *            , the value of the textAlign property
     */
    public void setTextAlign(Alignment align) {
        _setTextAlign(align.getValue());
    }

    private void _setTextAlign(String value) {
        setAttribute("textAlign", value, true, true);
    }

    /**
     * The type of tooltip to use. Either 'qtip' for QuickTips or 'title' for
     * title attribute.
     * 
     * Defaults to: "qtip"
     * 
     * @param value
     *            , the value of the tooltipType property
     */
    public void setTooltipType(String value) {
        setAttribute("tooltipType", value, true, true);
    }

    /**
     * The side of the Button box to render the arrow if the button has an
     * associated menu. Two values are allowed:
     * <ul>
     * <li>right</li>
     * <li>bottom</li>
     * </ul>
     * 
     * @param anchorPosition
     *            the element's anchor position
     */
    public void setArrowAlign(Alignment position) {
        _setArrowAlign(position.getValue());
    }

    private void _setArrowAlign(String anchorPosition) {
        setAttribute("arrowAlign", anchorPosition, true, true);
    }

    /**
     * The className used for the inner arrow element if the button has a menu.
     * 
     * Defaults to: "arrow"
     * 
     * @param value
     *            , the value of the arrowCls value
     */
    public void setArrowCls(String value) {
        setAttribute("arrowCls", value, true, true);
    }

    /**
     * False to not allow a pressed Button to be depressed. Only valid when
     * enableToggle is true.
     * <p>
     * Defaults to: true
     */
    public void setAllowDepress(boolean value) {
        setAttribute("allowDepress", value, true, true);
    }

    /**
     * Whether or not to destroy any associated menu when this button is
     * destroyed. The menu will be destroyed unless this is explicitly set to
     * false.
     */
    public void setDestroyMenu(boolean value) {
        setAttribute("destroyMenu", value, true, true);
    }

    /**
     * True to force an attached menu with no items to be shown when clicking
     * this button. By default, the menu will not show if it is empty.
     * <p>
     * Defaults to: false
     * 
     * @param value
     */
    public void setShowEmptyMenu(boolean value) {
        setAttribute("showEmptyMenu", value, true, true);
    }

    /**
     * If this property is a number, it is interpreted as follows:
     * 
     * 0: Neither width nor height depend on content. This is equivalent to
     * false. 1: Width depends on content (shrink wraps), but height does not.
     * 2: Height depends on content (shrink wraps), but width does not. The
     * default. 3: Both width and height depend on content (shrink wrap). This
     * is equivalent to true. In CSS terms, shrink-wrap width is analogous to an
     * inline-block element as opposed to a block-level element. Some container
     * layouts always shrink-wrap their children, effectively ignoring this
     * property (e.g., Ext.layout.container.HBox, Ext.layout.container.VBox,
     * Ext.layout.component.Dock).
     * 
     * Defaults to: 3
     * 
     * @param value
     */
    public void setShrinkWrap(boolean value) {
        setAttribute("shrinkWrap", value, true, true);
    }

    /**
     * If this property is a number, it is interpreted as follows:
     * 
     * 0: Neither width nor height depend on content. This is equivalent to
     * false. 1: Width depends on content (shrink wraps), but height does not.
     * 2: Height depends on content (shrink wraps), but width does not. The
     * default. 3: Both width and height depend on content (shrink wrap). This
     * is equivalent to true. In CSS terms, shrink-wrap width is analogous to an
     * inline-block element as opposed to a block-level element. Some container
     * layouts always shrink-wrap their children, effectively ignoring this
     * property (e.g., Ext.layout.container.HBox, Ext.layout.container.VBox,
     * Ext.layout.component.Dock).
     * 
     * Defaults to: 3
     * 
     * @param value
     */
    public void setShrinkWrap(Double value) {
        setAttribute("shrinkWrap", value.toString(), true, true);
    }

    /**
     * 
     * A numeric unicode character code to use as the icon for this button. The
     * default font-family for glyphs can be set globally using
     * Ext.setGlyphFontFamily(). Alternatively, this config option accepts a
     * string with the charCode and font-family separated by the @ symbol. For
     * example '65@My Font Family'.
     */
    public void setGlyph(String value) {
        setAttribute("glyph", value, true, true);
    }

    /**
     * 
     * A numeric unicode character code to use as the icon for this button. The
     * default font-family for glyphs can be set globally using
     * Ext.setGlyphFontFamily(). Alternatively, this config option accepts a
     * string with the charCode and font-family separated by the @ symbol. For
     * example '65@My Font Family'.
     */
    public void setGlyph(Double value) {
        setAttribute("glyph", value.toString(), true, true);
    }

    /**
     * The base CSS class to add to all buttons.
     * 
     * Defaults to: "x-btn"
     * 
     * @param value
     *            , the value of the baseCls value
     */
    public void setBaseCls(String value) {
        setAttribute("baseCls", value, true, true);
    }

    /**
     * The DOM event that will fire the handler of the button. This can be any
     * valid event name (dblclick, contextmenu).
     * 
     * Defaults to: "click"
     * 
     * @param value
     *            , the value of the clickEvent value
     */
    public void setClickEvent(String value) {
        setAttribute("clickEvent", value, true, true);
    }

    /**
     * A CSS class string to apply to the button's main element.
     * 
     * @param value
     *            , the value of the cls value
     */
    public void setCls(String value) {
        setAttribute("cls", value, true, true);
    }

    /**
     * The CSS class to add to a button when it is in the focussed state.
     * 
     * Defaults to: "focus"
     * 
     * @param value
     *            , the value of the focusCls value
     */
    public void setFocusCls(String value) {
        setAttribute("focusCls", value, true, true);
    }

    /**
     * The URL to open when the button is clicked. Specifying this config causes
     * the Button to be rendered with an anchor (An <a> element) as its active
     * element, referencing the specified URL.
     * 
     * This is better than specifying a click handler of <br/>
     * <code>
     * Window.Location.assign("http:://www.nttdata.com");
     * </code> <br/>
     * because the UI will provide meaningful hints to the user as to what to
     * expect upon clicking the button, and will also allow the user to open in
     * a new tab or window, bookmark or drag the URL, or directly save the URL
     * stream to disk.
     * 
     * {@see setHrefTarget}
     * 
     * @param value
     *            , the value of the href value
     */
    public void setHref(String value) {
        setAttribute("href", value, true, true);

    }

    /**
     * The target attribute to use for the underlying anchor. Only used if the
     * href property is specified.
     * 
     * Defaults to: "_blank"
     * 
     * @param value
     *            , the value of the hrefTarget value
     */
    public void setHrefTarget(String value) {
        setAttribute("hrefTarget", value, true, true);

    }

    /**
     * Method to change the scale of the button
     * 
     * @param value
     */
    public void setScale(ButtonScale scale) {
        setScale(scale.getValue());
    }

    public void setScale(String value) {
        if (!isRendered()) {
            setAttribute("scale", value, true);
        } else {
            setScaleRendered(value);
        }
    }

    /**
     * The tooltip for the button - can be a string to be used as innerHTML
     * (html tags are accepted) or QuickTips config object.
     * 
     * @param value
     */
    public native void setTooltip(String value) /*-{
		var button = this.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()();
		button.setTooltip(value);
    }-*/;

    /**
     * Sets the tooltip for this Button.
     * 
     * @param value
     *            , the tip value
     */
    public native void setTooltip(Tip tip) /*-{
		var button = this.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()();
		button
				.setTooltip(tip.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()());
    }-*/;

    /**
     * Shows this button's menu (if it has one)
     * 
     */
    public native void showMenu() /*-{
		var button = this.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()();
		button.showMenu();
    }-*/;

    /**
     * Creates a new Button from the given component
     * 
     * @param component
     *            , the component to cast from
     * @return, a new button from the component
     * 
     */
    public static Button cast(Component component) {
        return new Button(component.getOrCreateJsObj());
    }

    /**
     * Gets the text of this button.
     * 
     * @return the button text, null if not set
     */
    private native String getRenderedText() /*-{
		var button = this.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()();
		var text = button.getText();
		return text === undefined ? null : text;
    }-*/;

    private native void setScaleRendered(String value) /*-{
		var button = this.@com.ait.ext4j.client.core.Component::getJsObj()();
		button.setScale(value);
    }-*/;

    // Events

    public native HandlerRegistration addClickHandler(ClickHandler handler)/*-{
		var component = this.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(b, e) {
			var button = @com.ait.ext4j.client.ui.Button::new(Lcom/google/gwt/core/client/JavaScriptObject;)(b);
			var clickEvent = @com.ait.ext4j.client.events.button.ClickEvent::new(Lcom/ait/ext4j/client/ui/Button;Lcom/google/gwt/core/client/JavaScriptObject;)(button,e);
			handler.@com.ait.ext4j.client.events.button.ClickHandler::onClick(Lcom/ait/ext4j/client/events/button/ClickEvent;)(clickEvent);
		};
		var eventName = @com.ait.ext4j.client.events.button.ClickEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.ext4j.client.events.HandlerRegistration::new(Lcom/ait/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;

    }-*/;

    /**
     * Fired when the button's icon is changed by the setIcon or setIconCls
     * methods.
     * 
     * @param handler
     * @return
     */
    public native HandlerRegistration addIconChangeHandler(IconChangeHandler handler)/*-{
		var component = this.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(b, oldIcon, newIcon, e) {
			var button = @com.ait.ext4j.client.ui.Button::new(Lcom/google/gwt/core/client/JavaScriptObject;)(b);
			var event = @com.ait.ext4j.client.events.button.IconChangeEvent::new(Lcom/ait/ext4j/client/ui/Button;Ljava/lang/String;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(button,oldIcon,newIcon, e);
			handler.@com.ait.ext4j.client.events.button.IconChangeHandler::onIconChange(Lcom/ait/ext4j/client/events/button/IconChangeEvent;)(event);
		};
		var eventName = @com.ait.ext4j.client.events.button.IconChangeEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.ext4j.client.events.HandlerRegistration::new(Lcom/ait/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;

    }-*/;

    /**
     * Fired when the button's glyph is changed by the setGlyph method.
     */
    public native HandlerRegistration addGlyphChangeHandler(GlyphChangeHandler handler)/*-{
		var component = this.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(b, oldG, newG, e) {
			var button = @com.ait.ext4j.client.ui.Button::new(Lcom/google/gwt/core/client/JavaScriptObject;)(b);
			var event = @com.ait.ext4j.client.events.button.GlyphChangeEvent::new(Lcom/ait/ext4j/client/ui/Button;Ljava/lang/String;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(button,oldG,newG, e);
			handler.@com.ait.ext4j.client.events.button.GlyphChangeHandler::onGlyphChange(Lcom/ait/ext4j/client/events/button/GlyphChangeEvent;)(event);
		};
		var eventName = @com.ait.ext4j.client.events.button.GlyphChangeEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.ext4j.client.events.HandlerRegistration::new(Lcom/ait/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;

    }-*/;

    /**
     * If this button has a menu, this event fires when it is hidden
     */
    public native HandlerRegistration addMenuHideHandler(MenuHideHandler handler)/*-{
		var component = this.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(b, m, e) {
			var button = @com.ait.ext4j.client.ui.Button::new(Lcom/google/gwt/core/client/JavaScriptObject;)(b);
			var menu = @com.ait.ext4j.client.ui.Menu::new(Lcom/google/gwt/core/client/JavaScriptObject;)(m);
			var event = @com.ait.ext4j.client.events.button.MenuHideEvent::new(Lcom/ait/ext4j/client/ui/Button;Lcom/ait/ext4j/client/ui/Menu;Lcom/google/gwt/core/client/JavaScriptObject;)(button,menu,e);
			handler.@com.ait.ext4j.client.events.button.MenuHideHandler::onMenuHide(Lcom/ait/ext4j/client/events/button/MenuHideEvent;)(event);
		};
		var eventName = @com.ait.ext4j.client.events.button.MenuHideEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.ext4j.client.events.HandlerRegistration::new(Lcom/ait/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * If this button has a menu, this event fires when it is shown
     */
    public native HandlerRegistration addMenuShowHandler(MenuShowHandler handler)/*-{
		var component = this.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(b, m, e) {
			var button = @com.ait.ext4j.client.ui.Button::new(Lcom/google/gwt/core/client/JavaScriptObject;)(b);
			var menu = @com.ait.ext4j.client.ui.Menu::new(Lcom/google/gwt/core/client/JavaScriptObject;)(m);
			var event = @com.ait.ext4j.client.events.button.MenuShowEvent::new(Lcom/ait/ext4j/client/ui/Button;Lcom/ait/ext4j/client/ui/Menu;Lcom/google/gwt/core/client/JavaScriptObject;)(button,menu,e);
			handler.@com.ait.ext4j.client.events.button.MenuShowHandler::onMenuShow(Lcom/ait/ext4j/client/events/button/MenuShowEvent;)(event);
		};
		var eventName = @com.ait.ext4j.client.events.button.MenuShowEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.ext4j.client.events.HandlerRegistration::new(Lcom/ait/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * If this button has a menu, this event fires when the mouse leaves the
     * menu triggering element
     */
    public native HandlerRegistration addMenuTriggerOutHandler(MenuTriggerOutHandler handler)/*-{
		var component = this.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(b, m, e) {
			var button = @com.ait.ext4j.client.ui.Button::new(Lcom/google/gwt/core/client/JavaScriptObject;)(b);
			var menu = @com.ait.ext4j.client.ui.Menu::new(Lcom/google/gwt/core/client/JavaScriptObject;)(m);
			var event = @com.ait.ext4j.client.events.button.MenuTriggerOutEvent::new(Lcom/ait/ext4j/client/ui/Button;Lcom/ait/ext4j/client/ui/Menu;Lcom/google/gwt/core/client/JavaScriptObject;)(button,menu,e);
			handler.@com.ait.ext4j.client.events.button.MenuTriggerOutHandler::onMenuTriggerOut(Lcom/ait/ext4j/client/events/button/MenuTriggerOutEvent;)(event);
		};
		var eventName = @com.ait.ext4j.client.events.button.MenuTriggerOutEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.ext4j.client.events.HandlerRegistration::new(Lcom/ait/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * If this button has a menu, this event fires when the mouse enters the
     * menu triggering element
     */
    public native HandlerRegistration addMenuTriggerOverHandler(MenuTriggerOverHandler handler)/*-{
		var component = this.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(b, m, e) {
			var button = @com.ait.ext4j.client.ui.Button::new(Lcom/google/gwt/core/client/JavaScriptObject;)(b);
			var menu = @com.ait.ext4j.client.ui.Menu::new(Lcom/google/gwt/core/client/JavaScriptObject;)(m);
			var event = @com.ait.ext4j.client.events.button.MenuTriggerOverEvent::new(Lcom/ait/ext4j/client/ui/Button;Lcom/ait/ext4j/client/ui/Menu;Lcom/google/gwt/core/client/JavaScriptObject;)(button,menu,e);
			handler.@com.ait.ext4j.client.events.button.MenuTriggerOverHandler::onMenuTriggerOver(Lcom/ait/ext4j/client/events/button/MenuTriggerOverEvent;)(event);
		};
		var eventName = @com.ait.ext4j.client.events.button.MenuTriggerOverEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.ext4j.client.events.HandlerRegistration::new(Lcom/ait/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * Fires when the mouse exits the button
     */
    public native HandlerRegistration addMouseOutHandler(MouseOutHandler handler)/*-{
		var component = this.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(b, e) {
			var button = @com.ait.ext4j.client.ui.Button::new(Lcom/google/gwt/core/client/JavaScriptObject;)(b);
			var event = @com.ait.ext4j.client.events.button.MouseOutEvent::new(Lcom/ait/ext4j/client/ui/Button;Lcom/google/gwt/core/client/JavaScriptObject;)(button,e);
			handler.@com.ait.ext4j.client.events.button.MouseOutHandler::onMouseOut(Lcom/ait/ext4j/client/events/button/MouseOutEvent;)(event);
		};
		var eventName = @com.ait.ext4j.client.events.button.MouseOutEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.ext4j.client.events.HandlerRegistration::new(Lcom/ait/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;

    }-*/;

    /**
     * Fires when the mouse hovers over the button
     */
    public native HandlerRegistration addMouseOverHandler(MouseOverHandler handler)/*-{
		var component = this.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(b, e) {
			var button = @com.ait.ext4j.client.ui.Button::new(Lcom/google/gwt/core/client/JavaScriptObject;)(b);
			var event = @com.ait.ext4j.client.events.button.MouseOverEvent::new(Lcom/ait/ext4j/client/ui/Button;Lcom/google/gwt/core/client/JavaScriptObject;)(button,e);
			handler.@com.ait.ext4j.client.events.button.MouseOverHandler::onMouseOver(Lcom/google/gwt/event/dom/client/MouseOverEvent;)(event);
		};
		var eventName = @com.ait.ext4j.client.events.button.MouseOverEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.ext4j.client.events.HandlerRegistration::new(Lcom/ait/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * Fired when the button's text is changed by the setText method.
     */
    public native HandlerRegistration addTextChangeHandler(TextChangeHandler handler)/*-{
		var component = this.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(b, ot, nt, e) {
			var button = @com.ait.ext4j.client.ui.Button::new(Lcom/google/gwt/core/client/JavaScriptObject;)(b);
			var event = @com.ait.ext4j.client.events.button.TextChangeEvent::new(Lcom/ait/ext4j/client/ui/Button;Ljava/lang/String;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(button,ot,nt,e);
			handler.@com.ait.ext4j.client.events.button.TextChangeHandler::onTextChange(Lcom/ait/ext4j/client/events/button/TextChangeEvent;)(event);
		};
		var eventName = @com.ait.ext4j.client.events.button.TextChangeEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.ext4j.client.events.HandlerRegistration::new(Lcom/ait/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * Fires when the 'pressed' state of this button changes (only if
     * enableToggle = true)
     */
    public native HandlerRegistration addToggleHandler(ToggleHandler handler)/*-{
		var component = this.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(b, pressed, e) {
			var button = @com.ait.ext4j.client.ui.Button::new(Lcom/google/gwt/core/client/JavaScriptObject;)(b);
			var event = @com.ait.ext4j.client.events.button.ToggleEvent::new(Lcom/ait/ext4j/client/ui/Button;ZLcom/google/gwt/core/client/JavaScriptObject;)(button,pressed, e);
			handler.@com.ait.ext4j.client.events.button.ToggleHandler::onToggle(Lcom/ait/ext4j/client/events/button/ToggleEvent;)(event);
		};
		var eventName = @com.ait.ext4j.client.events.button.ToggleEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.ext4j.client.events.HandlerRegistration::new(Lcom/ait/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

}
