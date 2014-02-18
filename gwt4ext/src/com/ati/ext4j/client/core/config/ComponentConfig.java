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
package com.ati.ext4j.client.core.config;

import com.ati.ext4j.client.core.JsoHelper;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;

public class ComponentConfig extends BaseConfig {

    protected ComponentConfig() {
        super();
    }

    /**
     * A tag name or DomHelper spec used to create the Element which will
     * encapsulate this Component.
     * 
     * You do not normally need to specify this. For the base classes
     * <code>com.ati.ext4j.client.core.Component</code> and
     * </code>com.ati.ext4j.client.core.Container</code>, this defaults to
     * 'div'. The more complex ext4j4 classes use a more complex DOM structure
     * specified by their own renderTpls.
     * 
     * @param autoEl
     */
    public void setAutoEl(Object autoEl) {
        JsoHelper.setAttribute(jsObj, "autoEl", autoEl);
    }

    /**
     * This config is intended mainly for floating Components which may or may
     * not be shown. Instead of using renderTo in the configuration, and
     * rendering upon construction, this allows a Component to render itself
     * upon first show.
     * 
     * Specify as true to have this Component render to the document body upon
     * first show.
     * 
     * Specify as an element, or the ID of an element to have this Component
     * render to a specific element upon first show.
     * 
     * This defaults to true for the Window class.
     * 
     * @param autoRender
     */
    public void setAutoRender(Object autoRender) {
        JsoHelper.setAttribute(jsObj, "autoRender", autoRender);
    }

    /**
     * true to use overflow:'auto' on the components layout element and show
     * scroll bars automatically when necessary, false to clip any overflowing
     * content (defaults to false).
     * 
     * @param autoScroll
     */
    public void setAutoScroll(boolean autoScroll) {
        JsoHelper.setAttribute(jsObj, "autoScroll", autoScroll);
    }

    /**
     * The base CSS class to apply to this components's element. This will also
     * be prepended to other elements within this component. To add specific
     * styling for sub-classes, use the cls config.
     * 
     * Defaults to: null
     */
    public void setBaseCls(String value) {
        JsoHelper.setAttribute(jsObj, "baseCls", value);
    }

    /**
     * The border to use on this Component. Can be specified as a number (in
     * which case all edges get the same border width) or a CSS string like '5
     * 10 10 10'
     * 
     * Defaults to: null
     */
    public void setBorder(String value) {
        JsoHelper.setAttribute(jsObj, "border", value);
    }

    /**
     * The border to use on this Component. Can be specified as a number (in
     * which case all edges get the same border width) or a CSS string like '5
     * 10 10 10'
     * 
     * Defaults to: null
     */
    public void setBorder(double value) {
        JsoHelper.setAttribute(jsObj, "border", value);
    }

    /**
     * The sizing and positioning of a Component's internal Elements is the
     * responsibility of the Component's layout manager which sizes a
     * Component's internal structure in response to the Component being sized.
     * 
     * Generally, developers will not use this configuration as all provided
     * Components which need their internal elements sizing (Such as input
     * fields) come with their own componentLayout managers.
     * 
     * The default layout manager will be used on instances of the base
     * Ext.Component class which simply sizes the Component's encapsulating
     * element to the height and width specified in the setSize method.
     */
    public void setComponentLayout(Object value) {
        JsoHelper.setAttribute(jsObj, "compomentLayout", value);
    }

    /**
     * <p>
     * Optional. Specify an existing HTML element, or the id of an existing HTML
     * element to use as the content for this component.
     * </p>
     * <p>
     * <b>Description :</b> This config option is used to take an existing HTML
     * element and place it in the layout element of a new component (it simply
     * moves the specified DOM element after the Component is rendered to use as
     * the content.
     * </p>
     * <p>
     * <b> Notes :</b> The specified HTML element is appended to the layout
     * element of the component after any configured HTML has been inserted, and
     * so the document will not contain this element at the time the render
     * event is fired. The specified HTML element used will not participate in
     * any layout scheme that the Component may use. It is just HTML. Layouts
     * operate on child items. Add either the x-hidden or the x-hide-display CSS
     * class to prevent a brief flicker of the content before it is rendered to
     * the panel.
     * </p>
     * 
     * @param value
     */
    public void setContentEl(String value) {
        JsoHelper.setAttribute(jsObj, "contentEl", value);
    }

    /**
     * Defaults to: null
     */
    public void setBottom(boolean value) {
        JsoHelper.setAttribute(jsObj, "bottom", value);
    }

    /**
     * Whether or not this component is absolutely centered inside its container
     * 
     * Defaults to: null
     */
    public void setCentered(boolean value) {
        JsoHelper.setAttribute(jsObj, "centered", value);
    }

    /**
     * The CSS class to add to this component's element, in addition to the
     * baseCls
     * 
     * Defaults to: null
     */
    public void setCls(String value) {
        JsoHelper.setAttribute(jsObj, "cls", value);
    }

    /**
     * CSS class to add to this Component. Deprecated, please use cls instead
     */
    @Deprecated
    public void setComponentCls(String value) {
        JsoHelper.setAttribute(jsObj, "componentCls", value);
    }

    /**
     * The initial set of data to apply to the tpl to update the content area of
     * the Component.
     * 
     * Defaults to: null
     */
    public void setData(Object value) {
        JsoHelper.setAttribute(jsObj, "data", value);
    }

    /**
     * Whether or not this component is disabled
     * 
     * Defaults to: null
     */
    public void setDisabled(boolean value) {
        JsoHelper.setAttribute(jsObj, "disabled", value);
    }

    /**
     * The CSS class to add to the component when it is disabled
     */
    public void setDisabledCls(String value) {
        JsoHelper.setAttribute(jsObj, "disabledCls", value);
    }

    /**
     * Configuration options to make this Component draggable
     * 
     * Defaults to: null
     */
    public void setDraggable(boolean value) {
        JsoHelper.setAttribute(jsObj, "draggable", value);
    }

    /**
     * Configuration options to make this Component draggable
     * 
     * Defaults to: null
     */
    public void setDraggable(Object value) {
        JsoHelper.setAttribute(jsObj, "draggable", value);
    }

    /**
     * Specify as true to float the Component outside of the document flow using
     * CSS absolute positioning.
     * 
     * Components such as Windows and Menus are floating by default.
     * 
     * Floating Components that are programatically rendered will register
     * themselves with the global ZIndexManager
     * 
     */
    public void setFloating(boolean value) {
        JsoHelper.setAttribute(jsObj, "floating", value);
    }

    /**
     * Specifies whether the floated component should be automatically focused
     * when it is brought to the front. Defaults to true.
     * 
     * @param value
     */
    public void setFocusOnToFront(boolean value) {
        JsoHelper.setAttribute(jsObj, "focusOnToFront", value);
    }

    /**
     * Specify as true to have the Component inject framing elements within the
     * Component at render time to provide a graphical rounded frame around the
     * Component content.
     * 
     * This is only necessary when running on outdated, or non
     * standard-compliant browsers such as Microsoft's Internet Explorer prior
     * to version 9 which do not support rounded corners natively.
     * 
     * The extra space taken up by this framing is available from the read only
     * property frameSize.
     * 
     * @param value
     */
    public void setFrame(boolean value) {
        JsoHelper.setAttribute(jsObj, "frame", value);
    }

    /**
     * The height of this component in pixels.
     * 
     * Defaults to: null
     */
    public void setHeight(double value) {
        JsoHelper.setAttribute(jsObj, "hidden", value);
    }

    /**
     * True to hide this component
     * 
     * Defaults to: false
     */
    public void setHidden(boolean value) {
        JsoHelper.setAttribute(jsObj, "hidden", value);
    }

    /**
     * A value which specifies how this Component's encapsulating DOM element
     * will be hidden. Values may be
     * 
     * <ul>
     * <li>HideMode.DISPLAY : The Component will be hidden using the display:
     * none style.</li>
     * <li>HideMode.VISIBILITY : The Component will be hidden using the
     * visibility: hidden style.</li>
     * <li>HideMode.OFFSETS : The Component will be hidden by absolutely
     * positioning it out of the visible area of the document. This is useful
     * when a hidden
     * 
     * Component must maintain measurable dimensions.</li>
     * <ul>
     * Hiding using display results in a Component having zero dimensions.
     * Defaults to HideMode.DISPLAY.
     * 
     * 
     */
    public void setHideMode(HideMode hideMode) {
        setHideMode(hideMode.getValue());
    }

    private void setHideMode(String value) {
        JsoHelper.setAttribute(jsObj, "hideMode", value);
    }

    /**
     * The unique id of this component instance (defaults to an auto-assigned
     * id).
     * 
     * It should not be necessary to use this configuration except for singleton
     * objects in your application. Components created with an id may be
     * accessed globally using Ext.getCmp.
     * 
     * Instead of using assigned ids, use the itemId config, and ComponentQuery
     * which provides selector-based searching for Sencha Components analogous
     * to DOM querying. The Container class contains shortcut methods to query
     * its descendant Components by selector.
     * 
     * Note that this id will also be used as the element id for the containing
     * HTML element that is rendered to the page for this component. This allows
     * you to write id-based CSS rules to style the specific instance of this
     * component uniquely, and also to select sub-elements using this
     * component's id as the parent.
     * 
     * Note: to avoid complications imposed by a unique id also see itemId.
     * 
     * Note: to access the container of a Component see ownerCt. Defaults to:
     * null
     */
    public void setId(String value) {
        JsoHelper.setAttribute(jsObj, "id", value);
    }

    /**
     * An itemId can be used as an alternative way to get a reference to a
     * component when no object reference is available. Instead of using an id
     * with Ext.getCmp, use itemId with Container.getComponent which will
     * retrieve itemId's or id's. Since itemId's are an index to the container's
     * internal MixedCollection, the itemId is scoped locally to the container
     * -- avoiding potential conflicts with Ext.ComponentManager which requires
     * a unique id.
     */
    public void setItemId(String value) {
        JsoHelper.setAttribute(jsObj, "itemId", value);
    }

    /**
     * Only valid when a sibling element of a Splitter within a VBox or HBox
     * layout.
     * 
     * Specifies that if an immediate sibling Splitter is moved, the Component
     * on the other side is resized, and this Component maintains its configured
     * flex value.
     */
    public void setMaintainFlex(boolean value) {
        JsoHelper.setAttribute(jsObj, "maintainFlex", value);
    }

    /**
     * The margin to use on this Component. Can be specified as a number (in
     * which case all edges get the same margin) or a CSS string like '5 10 10
     * 10'
     * 
     * Defaults to: null
     */
    public void setMargin(String value) {
        JsoHelper.setAttribute(jsObj, "margin", value);
    }

    /**
     * The margin to use on this Component. Can be specified as a number (in
     * which case all edges get the same margin) or a CSS string like '5 10 10
     * 10'
     * 
     * Defaults to: null
     */
    public void setMargin(double value) {
        JsoHelper.setAttribute(jsObj, "margin", value);
    }

    /**
     * The maximum value in pixels which this Component will set its height to.
     * <p>
     * <b>Warning</b> This will override any size management applied by layout
     * managers.
     */
    public void setMaxHeight(double value) {
        JsoHelper.setAttribute(jsObj, "maxHeight", value);
    }

    /**
     * The maximum value in pixels which this Component will set its width to.
     * <p>
     * <b>Warning</b> This will override any size management applied by layout
     * managers.
     */
    public void setMaxWidth(double value) {
        JsoHelper.setAttribute(jsObj, "maxWidth", value);
    }

    /**
     * The minimum value in pixels which this Component will set its height to.
     * <p>
     * <b>Warning</b> This will override any size management applied by layout
     * managers.
     */
    public void setMinHeight(double value) {
        JsoHelper.setAttribute(jsObj, "padding", value);
    }

    /**
     * The minimum value in pixels which this Component will set its width to.
     * <p>
     * <b>Warning</b> This will override any size management applied by layout
     * managers.
     */
    public void setMinWidth(double value) {
        JsoHelper.setAttribute(jsObj, "minWidth", value);
    }

    /**
     * Specifies the padding for this component. The padding can be a single
     * numeric value to apply to all sides or it can be a CSS style
     * specification for each style, for example: '10 5 3 10'.
     * 
     * @param value
     */
    public void setPadding(double value) {
        JsoHelper.setAttribute(jsObj, "padding", value);
    }

    /**
     * Specifies the padding for this component. The padding can be a single
     * numeric value to apply to all sides or it can be a CSS style
     * specification for each style, for example: '10 5 3 10'.
     * 
     * @param value
     */
    public void setPadding(String value) {
        JsoHelper.setAttribute(jsObj, "padding", value);
    }

    /**
     * An object or array of objects that will provide custom functionality for
     * this component. The only requirement for a valid plugin is that it
     * contain an init method that accepts a reference of type Ext.Component.
     * When a component is created, if any plugins are available, the component
     * will call the init method on each plugin, passing a reference to itself.
     * Each plugin can then call methods or respond to events on the component
     * as needed to provide its functionality.
     */
    public void setPlugins(Object value) {
        JsoHelper.setAttribute(jsObj, "plugins", value);
    }

    /**
     * An object containing properties specifying DomQuery selectors which
     * identify child elements created by the render process.
     * 
     * After the Component's internal structure is rendered according to the
     * renderTpl, this object is iterated through, and the found Elements are
     * added as properties to the Component using the renderSelector property
     * name.
     * 
     * @param value
     */
    public void setRenderSelectors(Object value) {
        JsoHelper.setAttribute(jsObj, "rendereSelectors", value);
    }

    /**
     * Specify the id of the element, a DOM element or an existing Element that
     * this component will be rendered into.
     * <p>
     * Notes : Do not use this option if the Component is to be a child item of
     * a Container. It is the responsibility of the Container's layout manager
     * to render and manage its child items. When using this config, a call to
     * render() is not required.
     * </p>
     * 
     * @see render also.
     * 
     * @param value
     */
    public void renderTo(Object value) {
        JsoHelper.setAttribute(jsObj, "renderTo", value);
    }

    /**
     * An XTemplate used to create the internal structure inside this
     * Component's encapsulating Element. You do not normally need to specify
     * this. For the base classes Ext.Component and Ext.Container, this defaults
     * to null which means that they will be initially rendered with no internal
     * structure; they render their Element empty. The more specialized ExtJS
     * and Touch classes which use a more complex DOM structure, provide their
     * own template definitions. This is intended to allow the developer to
     * create application-specific utility Components with customized internal
     * structure.
     */
    public void setRenderTpl(Object value) {
        JsoHelper.setAttribute(jsObj, "renderTpl", value);
    }

    /**
     * An XTemplate used to create the internal structure inside this
     * Component's encapsulating Element. You do not normally need to specify
     * this. For the base classes Ext.Component and Ext.Container, this defaults
     * to null which means that they will be initially rendered with no internal
     * structure; they render their Element empty. The more specialized ExtJS
     * and Touch classes which use a more complex DOM structure, provide their
     * own template definitions. This is intended to allow the developer to
     * create application-specific utility Components with customized internal
     * structure.
     */
    public void setRenderTpl(JavaScriptObject value) {
        JsoHelper.setAttribute(jsObj, "renderTpl", value);
    }

    /**
     * Defaults to: null
     */
    public void setRerizable(Object value) {
        JsoHelper.setAttribute(jsObj, "right", value);
    }

    /**
     * Specify as true to apply a Resizer to this Component after rendering.
     */
    public void setResizable(boolean value) {
        JsoHelper.setAttribute(jsObj, "resizable", value);
    }

    /**
     * A valid Ext.resizer.Resizer handles config string (defaults to 'all').
     * Only applies when resizable = true.
     */
    public void setResizeHandles(String value) {
        JsoHelper.setAttribute(jsObj, "resizeHandles", value);
    }

    /**
     * A buffer to be applied if many state events are fired within a short
     * period. Defaults to 100.
     */
    public void setSaveBuffer(double value) {
        JsoHelper.setAttribute(jsObj, "saveBuffer", value);
    }

    /**
     * Specifies whether the floating component should be given a shadow. Set to
     * true to automatically create an Ext.Shadow, or a string indicating the
     * shadow's display Ext.Shadow.mode. Set to false to disable the shadow.
     * (Defaults to 'sides'.)
     */
    public void setShadow(boolean value) {
        JsoHelper.setAttribute(jsObj, "shadow", value);
    }

    /**
     * Specifies whether the floating component should be given a shadow. Set to
     * true to automatically create a Shadow Object, or a ShadowMode indicating
     * the shadow's display ShadowMode. Set to false to disable the shadow.
     * (Defaults to 'ShadowMode.SIDES'.)
     */
    public void setShadow(ShadowMode mode) {
        setShadow(mode.getValue());
    }

    private void setShadow(String value) {
        JsoHelper.setAttribute(jsObj, "shadow", value);
    }

    /**
     * The unique id for this object to use for state management purposes.
     * 
     * ComponentConfig.setStateful() for an explanation of saving and restoring
     * state.
     * 
     * @param value
     */
    public void setStateId(String value) {
        JsoHelper.setAttribute(jsObj, "stateId", value);
    }

    /**
     * A flag which causes the object to attempt to restore the state of
     * internal properties from a saved state on startup. The object must have a
     * stateId for state to be managed. Auto-generated ids are not guaranteed to
     * be stable across page loads and cannot be relied upon to save and restore
     * the same state for a object.
     * 
     * For state saving to work, the state manager's provider must have been set
     * to an implementation of StateProvider which overrides the set and get
     * methods to save and recall name/value pairs. A built-in implementation,
     * CookieProvider is available.
     */
    public void setStateFul(boolean value) {
        JsoHelper.setAttribute(jsObj, "stateful", value);
    }

    /**
     * Optional CSS styles that will be rendered into an inline style attribute
     * when the Component is rendered
     * 
     * Defaults to: null
     */
    public void setStyle(String value) {
        JsoHelper.setAttribute(jsObj, "style", value);
    }

    /**
     * The class that is added to the content target when you set
     * styleHtmlContent to true.
     */
    public void setStyleHtmlCls(String value) {
        JsoHelper.setAttribute(jsObj, "styleHtmlCls", value);
    }

    /**
     * True to automatically style the html inside the content target of this
     * component (body for panels).
     * 
     * Defaults to: null
     */
    public void setStyleHtmlContent(boolean value) {
        JsoHelper.setAttribute(jsObj, "styleHtmlContent", value);
    }

    /**
     * Defaults to: null
     */
    public void setTop(double value) {
        JsoHelper.setAttribute(jsObj, "top", value);
    }

    /**
     * Defaults to: null
     */
    public void setTop(boolean value) {
        JsoHelper.setAttribute(jsObj, "top", value);
    }

    /**
     * An Ext.Template, Ext.XTemplate or an array of strings to form an
     * Ext.XTemplate. Used in conjunction with the data and tplWriteMode
     * configurations.
     * 
     * Defaults to: null
     */
    public void setTpl(JsArrayString value) {
        JsoHelper.setAttribute(jsObj, "tpl", value);
    }

    /**
     * An Ext.Template, Ext.XTemplate or an array of strings to form an
     * Ext.XTemplate. Used in conjunction with the data and tplWriteMode
     * configurations.
     * 
     * Defaults to: null
     */
    public void setTpl(String value) {
        JsoHelper.setAttribute(jsObj, "tpl", value);
    }

    /**
     * The Ext.(X)Template method to use when updating the content area of the
     * Component.
     * 
     * Defaults to 'overwrite' (see Ext.XTemplate.overwrite).
     */
    public void setTplWriteMode(String value) {
        JsoHelper.setAttribute(jsObj, "tplWriteMode", value);
    }

    /**
     * The width of this component in pixels.
     * 
     * Defaults to: null
     */
    public void setWidth(double value) {
        JsoHelper.setAttribute(jsObj, "width", value);
    }

    /**
     * The z-index to give this Component when it is rendered
     * 
     * Defaults to: null
     */
    public void setZindex(double value) {
        JsoHelper.setAttribute(jsObj, "zIndex", value);
    }

    public void setRenderTo(JavaScriptObject value) {
        JsoHelper.setAttribute(jsObj, "renderTo", value);
    }

}
