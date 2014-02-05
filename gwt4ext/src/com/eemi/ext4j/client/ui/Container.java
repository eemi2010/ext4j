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
import java.util.Iterator;

import com.eemi.ext4j.client.core.Component;
import com.eemi.ext4j.client.core.ComponentTraversalCallback;
import com.eemi.ext4j.client.core.DefaultsHandler;
import com.eemi.ext4j.client.core.DomUtil;
import com.eemi.ext4j.client.core.Ext;
import com.eemi.ext4j.client.core.ExtElement;
import com.eemi.ext4j.client.core.JsoHelper;
import com.eemi.ext4j.client.core.Paddings;
import com.eemi.ext4j.client.core.WidgetComponent;
import com.eemi.ext4j.client.core.config.XType;
import com.eemi.ext4j.client.events.Event;
import com.eemi.ext4j.client.events.HandlerRegistration;
import com.eemi.ext4j.client.events.container.AddHandler;
import com.eemi.ext4j.client.events.container.AfterLayoutHandler;
import com.eemi.ext4j.client.events.container.BeforeAddHandler;
import com.eemi.ext4j.client.events.container.BeforeRemoveHandler;
import com.eemi.ext4j.client.events.container.ContainerBeforeRemoveHandler;
import com.eemi.ext4j.client.events.container.ContainerContentChangeHandler;
import com.eemi.ext4j.client.layout.AbsoluteLayout;
import com.eemi.ext4j.client.layout.AccordionLayout;
import com.eemi.ext4j.client.layout.AnchorLayout;
import com.eemi.ext4j.client.layout.AutoLayout;
import com.eemi.ext4j.client.layout.BorderLayout;
import com.eemi.ext4j.client.layout.BorderRegion;
import com.eemi.ext4j.client.layout.CardLayout;
import com.eemi.ext4j.client.layout.ColumnLayout;
import com.eemi.ext4j.client.layout.ContainerLayout;
import com.eemi.ext4j.client.layout.FitLayout;
import com.eemi.ext4j.client.layout.FormLayout;
import com.eemi.ext4j.client.layout.HBoxLayout;
import com.eemi.ext4j.client.layout.Layout;
import com.eemi.ext4j.client.layout.LayoutData;
import com.eemi.ext4j.client.layout.TableLayout;
import com.eemi.ext4j.client.layout.VBoxLayout;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;

/**
 * Base class for any {@link Component} that can contain other components.
 * Containers handle the basic behavior of containing items, namely adding,
 * inserting and removing items.
 */
public class Container extends Component implements HasWidgets {

    private static JavaScriptObject configPrototype;
    private String activeItemID;
    private ContainerLayout layout;
    private DefaultsHandler defaultsHandler;

    private native void init()/*-{
		var c = new $wnd.Ext.container.Container();
		@com.eemi.ext4j.client.ui.Container::configPrototype = c.initialConfig;
    }-*/;

    protected JavaScriptObject getConfigPrototype() {
        return configPrototype;
    }

    public String getXType() {
        return XType.CONTAINER.getValue();
    }

    public Container() {
        init();
    }

    public Container(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public Container(Element element) {
        super(element);
    }

    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.container.Container(config);
    }-*/;

    private static Container instance(JavaScriptObject jsObj) {
        return new Container(jsObj);
    }

    public void setDefaults(DefaultsHandler defaultsHandler) {
        this.defaultsHandler = defaultsHandler;
    }

    public void setBaseCls(String value) {
        setAttribute("baseCls", value, true);
    }

    public void setBodyStyle(String value) {
        setAttribute("bodyStyle", value, true);
    }

    /**
     * Set the paddings for the PortletColumn.
     * 
     * @param top
     *            the rop padding
     * @param left
     *            the left padding
     * @param right
     *            the right padding
     * @param bottom
     *            the botton padding
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setPaddings(int top, int left, int right, int bottom) throws IllegalStateException {
        Paddings paddings = new Paddings(top, left, right, bottom);
        String style = paddings.getStyleString();
        String bodyStyle = getBodyStyle();
        if (bodyStyle == null) {
            setStyle(style);
        } else {
            setStyle(bodyStyle + style);
        }
    }

    /**
     * Add a widget to the Container.
     * 
     * @param widget
     *            the widget to add
     */
    @Override
    public void add(Widget widget) {
        if (widget instanceof Component) {
            add((Component) widget);
        } else {
            String id = DomUtil.getID(widget);
            if (id == null) {
                id = Ext.generateId();
                DomUtil.setID(widget, id);
            }
            JavaScriptObject compJS = getComponentJS(id);
            WidgetComponent component = null;
            if (compJS != null) {
                component = new WidgetComponent(compJS);
                component.setVisible(true);
            } else {
                component = new WidgetComponent(widget);
            }
            add(component);
        }

    }

    /**
     * Custom CSS styles to be applied to the body element in the format
     * expected by {@link ExtElement#applyStyles(String)}
     * 
     * @return the custom CSS styles to be applied to the body element
     */
    public String getBodyStyle() {
        return JsoHelper.getAttribute(config, "bodyStyle");
    }

    public void add(IsWidget isWidget) {
        add(isWidget.asWidget());
    }

    /**
     * Add a Component to the Container.
     * 
     * @param component
     *            the component to add
     */
    public void add(Component component) {
        JavaScriptObject componentJS = component.isCreated() ? component.getOrCreateJsObj() : component.getConfig();
        if (layout != null && layout.getSpacing() != null) {
            Panel panel = new Panel();
            panel.setBaseCls("x-plain");
            panel.setBorder(false);
            panel.setBodyStyle(layout.getSpacing());
            panel.add(component);
            componentJS = panel.getConfig();

        }
        if (isCreated()) {
            addPostCreate(componentJS);

        } else {
            addPreCreate(componentJS);
        }
    }

    /**
     * Add a Component to the Container.
     * 
     * @param component
     *            the component to add
     * @param layoutData
     *            the layout to use when adding the component
     */
    public void add(Component component, LayoutData layoutData) {
        if (defaultsHandler != null) {
            defaultsHandler.apply(component);
        }
        JavaScriptObject componentJS = component.isCreated() ? component.getOrCreateJsObj() : component.getConfig();
        // JavaScriptObject componentJS = component.getJsObj();
        JsoHelper.apply(layoutData.getJsObj(), componentJS);
        if (layout != null && layout.getSpacing() != null) {
            Panel panel = new Panel();
            panel.setBaseCls("x-plain");
            panel.setBorder(false);
            panel.setBodyStyle(layout.getSpacing());
            panel.add(component);
            add(panel.getConfig());
        } else {
            add(componentJS);
        }
    }

    private void add(JavaScriptObject componentJS) {
        if (isCreated()) {
            addPostCreate(componentJS);
        } else {
            addPreCreate(componentJS);
        }
    }

    private native void addPreCreate(JavaScriptObject componentJS) /*-{
		var config = this.@com.eemi.ext4j.client.core.Component::config;
		if (!config.items) {
			config.items = @com.eemi.ext4j.client.core.JsoHelper::createJavaScriptArray()();
		}
		config.items.push(componentJS);
    }-*/;

    private native void addPostCreate(JavaScriptObject componentJS) /*-{
		var container = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		container.add(componentJS);
    }-*/;

    /**
     * Find a component under this container at any level by id.
     * 
     * @param id
     *            the component ID
     * @return the component
     */
    public native Component findByID(String id) /*-{
		var container = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var comp = container.findById(id);
		return comp == null || comp === undefined ? null
				: @com.eemi.ext4j.client.ui.ComponentFactory::getComponent(Lcom/google/gwt/core/client/JavaScriptObject;)(comp);
    }-*/;

    /**
     * Find a component under this container at any level by xtype.
     * 
     * @param xtype
     *            the components xtype
     * @return an array of components
     */
    public native Component[] findByType(String xtype) /*-{
		var container = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var comps = container.findByType(xtype);
		return comps == null || comps === undefined ? null
				: @com.eemi.ext4j.client.core.JsoHelper::convertToJavaComponentArray(Lcom/google/gwt/core/client/JavaScriptObject;)(comps);
    }-*/;

    /**
     * Gets a direct child Component by id.
     * 
     * @param id
     *            the component ID
     * @return the component
     */
    public native Component getComponent(String id) /*-{
		var container = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var comp = container.getComponent(id);
		return comp == null || comp === undefined ? null
				: @com.eemi.ext4j.client.ui.ComponentFactory::getComponent(Lcom/google/gwt/core/client/JavaScriptObject;)(comp);
    }-*/;

    /**
     * Gets a direct child Component by by index.
     * 
     * @param index
     *            the component index
     * @return the component
     */
    public native Component getComponent(int index) /*-{
		var container = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var comp = container.getComponent(index);
		return comp == null || comp === undefined ? null
				: @com.eemi.ext4j.client.ui.ComponentFactory::getComponent(Lcom/google/gwt/core/client/JavaScriptObject;)(comp);
    }-*/;

    /**
     * Inserts a Component into this Container at a specified index. Fires the
     * beforeadd event before inserting, then fires the add event after the
     * Component has been inserted.
     * 
     * @param index
     *            the index to insert the component at
     * @param component
     *            the component to insert
     */
    public void insert(int index, Component component) {
        JavaScriptObject componentJS = component.isCreated() ? component.getOrCreateJsObj() : component.getConfig();
        doInsert(index, componentJS);
    }

    private native void doInsert(int index, JavaScriptObject component) /*-{
		var container = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		container.insert(index, component);
    }-*/;

    /**
     * Removes a component from this container. Fires the beforeremove event
     * before removing, then fires the remove event after the component has been
     * removed.
     * 
     * @param id
     *            the id of the Component to remove
     */
    public native void remove(String id) /*-{
		var container = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		container.remove(id);
    }-*/;

    public boolean remove(Widget w) {
        String id = DomUtil.getID(w);
        if (getComponent(id) != null) {
            remove(id);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Remove all child elements destroying them.
     */
    public void clear() {
        removeAll(true);
    }

    /**
     * The collection of components in this container. Alias for
     * {@link #getComponents()}
     * 
     * @return child components
     */
    public Component[] getItems() {
        return getComponents();
    }

    public void setRegion(BorderRegion region) {
        setRegion(region.getValue());
    }

    public void setRegion(String region) {
        setAttribute("region", region, true);
    }

    public void setSplit(boolean value) {
        setAttribute("split", value, true);
    }

    /**
     * The collection of components in this container.
     * 
     * @return child components
     */
    public native Component[] getComponents()/*-{
		var container = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var items = container.items;
		if (items === undefined || items == null) {
			items = null;
		} else {
			//FormPanel doesn't use MixedCollection
			items = container.items.items || container.items;
		}
		return @com.eemi.ext4j.client.core.JsoHelper::convertToJavaComponentArray(Lcom/google/gwt/core/client/JavaScriptObject;)(items);
    }-*/;

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public Iterator iterator() {
        ArrayList list = new ArrayList();
        Component[] items = getComponents();
        for (int i = 0; i < items.length; i++) {
            Component item = items[i];
            list.add(item);
        }
        return list.iterator();
    }

    /**
     * Removes a component from this container. Fires the beforeremove event
     * before removing, then fires the remove event after the component has been
     * removed.
     * 
     * @param component
     *            the id of the Component to remove
     * @param autoDestroy
     *            true to automatically invoke the Component's destroy method
     */
    public native void remove(Component component, boolean autoDestroy) /*-{
		var container = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var componentJS = component.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		container.remove(componentJS, autoDestroy);
    }-*/;

    /**
     * Removes a component from this container. Fires the beforeremove event
     * before removing, then fires the remove event after the component has been
     * removed.
     * 
     * @param id
     *            the id of the Component to remove
     * @param autoDestroy
     *            true to automatically invoke the Component's destroy method
     */
    public native void remove(String id, boolean autoDestroy) /*-{
		var container = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		container.remove(id, autoDestroy);
    }-*/;

    /**
     * Removes all child components without destroying them.
     */
    public native void removeAll() /*-{
		var container = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		if (container.items) {
			var cs = container.items.items;
			var len = cs.length;
			for ( var i = 0; i < len; i++) {
				cs[0].hide();
				container.remove(cs[0], false);
			}
		}
    }-*/;

    /**
     * Removes all components from this container. Fires the beforeremove event
     * before removing, then fires the remove event after the component has been
     * removed.
     * 
     * @param autoDestroy
     *            true to automatically invoke the component's destroy
     */
    public native void removeAll(boolean autoDestroy) /*-{
		var container = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		if (container.items) {
			var cs = container.items.items;
			var len = cs.length
			for ( var i = 0; i < len; i++) {
				if (!autoDestroy)
					cs[0].hide();
				container.remove(cs[0], autoDestroy);
			}
		}
    }-*/;

    /**
     * Force this container's layout to be recalculated. A call to this function
     * is required after adding a new component to an already rendered
     * container. If you are not dynamically adding and removing components
     * after render, this function will generally not need to be called.
     */
    public native void doLayout() /*-{
		var container = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		container.doLayout();
    }-*/;

    /**
     * Force this container's layout to be recalculated. A call to this function
     * is required after adding a new component to an already rendered
     * container. If you are not dynamically adding and removing components
     * after render, this function will generally not need to be called.
     * 
     * @param shallow
     *            True to only calculate the layout of this component, and let
     *            child components auto calculate layouts as required
     */
    public native void doLayout(boolean shallow) /*-{
		var container = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		container.doLayout(shallow);
    }-*/;

    /**
     * Find a component under this container at any level by a custom function.
     * If the passed function returns true, the component will be included in
     * the results.
     * 
     * @param cb
     *            the find function
     * @return an array of Components
     */
    public native Component[] findBy(ComponentTraversalCallback cb)/*-{
		var container = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var containerJ = this;
		var comps = container
				.findBy(function(comp) {
					var compJ = @com.eemi.ext4j.client.ui.ComponentFactory::getComponent(Lcom/google/gwt/core/client/JavaScriptObject;)(comp);
					return cb.@com.eemi.ext4j.client.core.ComponentTraversalCallback::execute(Lcom/eemi/ext4j/client/core/Component;)(compJ);
				});
		return @com.eemi.ext4j.client.core.JsoHelper::convertToJavaComponentArray(Lcom/google/gwt/core/client/JavaScriptObject;)(comps);
    }-*/;

    // --- config properties ---

    /**
     * A string component id or the numeric index of the component that should
     * be initially activated within the container's layout on render. For
     * example, activeItem: 'item-1' or activeItem: 0 (index 0 = the first item
     * in the container's collection). activeItem only applies to layout styles
     * that can display items one at a time (like
     * {@link com.eemi.ext4j.client.core.layout.AccordionLayout} ,
     * {@link com.eemi.ext4j.client.core.layout.CardLayout} and
     * {@link com.eemi.ext4j.client.core.layout.FitLayout} ).
     * 
     * @param activeItem
     *            the active Item ID
     */
    public void setActiveItemID(String activeItem) {
        // need local variable as bean introspectors will error out when
        // underlting
        // activeItem attribute can
        // either be string or int
        activeItemID = activeItem;
        if (isRendered() && layout instanceof CardLayout) {
            ((CardLayout) layout).setActiveItem(activeItem);
        } else {
            setAttribute("activeItem", activeItem, true);
        }
    }

    /**
     * @return the active Item ID
     */
    public String getActiveItemID() {
        return activeItemID;
    }

    /**
     * A string component id or the numeric index of the component that should
     * be initially activated within the container's layout on render. For
     * example, activeItem: 'item-1' or activeItem: 0 (index 0 = the first item
     * in the container's collection). activeItem only applies to layout styles
     * that can display items one at a time (like
     * {@link com.eemi.ext4j.client.core.layout.AccordionLayout} ,
     * {@link com.eemi.ext4j.client.core.layout.CardLayout} and
     * {@link com.eemi.ext4j.client.layout.FitLayout} ).
     * 
     * 
     * @param activeItem
     *            the active Item ID
     */
    public void setActiveItem(int activeItem) {
        layout = getLayout();
        if (isRendered() && layout instanceof CardLayout) {
            ((CardLayout) layout).setActiveItem(activeItem);
        } else {
            setAttribute("activeItem", activeItem, true);
        }
    }

    /**
     * A string component id or the numeric index of the component that should
     * be initially activated within the container's layout on render. For
     * example, activeItem: 'item-1' or activeItem: 0 (index 0 = the first item
     * in the container's collection). activeItem only applies to layout styles
     * that can display items one at a time (like
     * {@link com.eemi.ext4j.client.core.layout.AccordionLayout} ,
     * {@link com.eemi.ext4j.client.core.layout.CardLayout} and
     * {@link com.eemi.ext4j.client.layout.FitLayout} ).
     * 
     * 
     * @param activeItem
     *            the active Item ID
     */
    public void setActiveItem(String activeItem) {
        layout = getLayout();
        if (isRendered() && layout instanceof CardLayout) {
            ((CardLayout) layout).setActiveItem(activeItem);
        } else {
            setAttribute("activeItem", activeItem, true);
        }
    }

    /**
     * A string component id or the numeric index of the component that should
     * be initially activated within the container's layout on render. For
     * example, activeItem: 'item-1' or activeItem: 0 (index 0 = the first item
     * in the container's collection). activeItem only applies to layout styles
     * that can display items one at a time (like
     * {@link com.eemi.ext4j.client.core.layout.AccordionLayout} ,
     * {@link com.eemi.ext4j.client.core.layout.CardLayout} and
     * {@link com.eemi.ext4j.client.layout.FitLayout} ).
     * 
     * 
     * @param activeItem
     *            the active Item ID
     */
    public void setActiveItem(Component activeItem) {
        layout = getLayout();
        if (isRendered() && layout instanceof CardLayout) {
            ((CardLayout) layout).setActiveItem(activeItem);
        } else {
            setAttribute("activeItem", activeItem.getOrCreateJsObj(), true);
        }
    }

    /**
     * Return the Active Item index.
     * 
     * @return the active item index
     */
    public int getActiveItem() {
        return JsoHelper.getAttributeAsInt(config, "activeItem");
    }

    public void setMinSize(int value) {
        setAttribute("minSize", value, true);
    }

    public void setMaxSize(int value) {
        setAttribute("maxSize", value, true);
    }

    /**
     * If true the container will automatically destroy any contained component
     * that is removed from it, else destruction must be handled manually
     * (defaults to true).
     * 
     * @param autoDestroy
     *            true to autodestroy
     */
    public void setAutoDestroy(boolean autoDestroy) {
        setAttribute("autoDestroy", autoDestroy, true);
    }

    /**
     * @return true if Component is configured to auto destroy contained
     *         components on destruction
     */
    public boolean getAutoDestroy() {
        return getAttributeAsBoolean("autoDestroy");
    }

    /**
     * When set to true (100 milliseconds), the layout assigned for this
     * container will buffer the frequency it calculates and does a re-layout of
     * components. This is useful for heavy containers or containers with a
     * large amount of sub components that frequent calls to layout are
     * expensive.
     * 
     * @param bufferResize
     *            true to buffer resize
     */
    public void setBufferResize(boolean bufferResize) {
        setAttribute("bufferResize", bufferResize, true);
    }

    /**
     * @return true if buffer resize is enabled
     */
    public boolean getBufferResize() {
        return getAttributeAsBoolean("bufferResize");
    }

    /**
     * True to hide the borders of each contained component, false to defer to
     * the component's existing border settings (defaults to false).
     * 
     * @param hideBorders
     *            true to hide borders
     */
    public void setHideBorders(boolean hideBorders) {
        setAttribute("hideBorders", hideBorders, true);
    }

    /**
     * True to hide the borders of each contained component, false to defer to
     * the component's existing border settings (defaults to false).
     * 
     * @return true if hide borders
     */
    public boolean getHideBorders() {
        return getAttributeAsBoolean("hideBorders");
    }

    /**
     * The layout type to be used in this container. If not specified, a default
     * ContainerLayout will be created and used.
     * 
     * @param layout
     *            the layout to use
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setLayout(ContainerLayout layout) throws IllegalStateException {
        this.layout = layout;
        if (layout.getSpacing() != null && this instanceof Panel) {
            ((Panel) this).setBorder(false);
        }
        setAttribute("layout", layout.getJsObj(), true);
        if (layout.getContainerAttributes() != null) {
            JsoHelper.apply(layout.getContainerAttributes(), isCreated() ? getJsObj() : config);
        }
    }

    /**
     * The layout type to be used in this container. If not specified, a default
     * ContainerLayout will be created and used.
     * 
     * @param layout
     *            the layout to use
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setLayout(Layout layout) throws IllegalStateException {
        if (layout == Layout.ABSOLUTE) {
            setLayout(new AbsoluteLayout());
        } else if (layout == Layout.ACCORDION) {
            setLayout(new AccordionLayout());
        } else if (layout == Layout.ANCHOR) {
            setLayout(new AnchorLayout());
        } else if (layout == Layout.AUTO) {
            setLayout(new AutoLayout());
        } else if (layout == Layout.BORDER) {
            setLayout(new BorderLayout());
        } else if (layout == Layout.HBOX) {
            setLayout(new HBoxLayout());
        } else if (layout == Layout.CARD) {
            setLayout(new CardLayout());
        } else if (layout == Layout.COLUMN) {
            setLayout(new ColumnLayout());
        } else if (layout == Layout.FIT) {
            setLayout(new FitLayout());
        } else if (layout == Layout.FORM) {
            setLayout(new FormLayout());
        } else if (layout == Layout.VBOX) {
            setLayout(new VBoxLayout());
        } else if (layout == Layout.TABLE) {
            setLayout(new TableLayout());
        }
    }

    /**
     * The layout type to be used in this container. If not specified, a default
     * ContainerLayout will be created and used.
     * 
     * @param layout
     *            the layout to use
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setLayout(String layout) throws IllegalStateException {
        setLayout(Layout.fromValue(layout));
    }

    public ContainerLayout getLayout() {
        if (this.layout != null) {
            this.layout.update(_getLayout());
        } else {
            this.layout = new ContainerLayout(_getLayout());
        }
        return layout;
    }

    private native JavaScriptObject _getLayout()/*-{
		var container = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		return container.getLayout();
    }-*/;

    public void setFullScreen(boolean fullScreen) {
        setAttribute("fullscreen", fullScreen, true);
    }

    public void setBodyPadding(int value) {
        setAttribute("bodyPadding", value, true, true);
    }

    public void setPadding(int value) {
        setAttribute("padding", value, true);
    }

    /**
     * A single item, or an array of child Components to be added to this
     * container
     */
    public void setItems(Component... items) {
        setAttribute("items", ComponentFactory.fromArray(items), true);
    }

    /**
     * A single item, or an array of child Components to be added to this
     * container
     */
    public void add(Component... items) {
        for (Component c : items) {
            this.add(c);
        }
    }

    // Event handlers

    /**
     * Fires after any {@link Component} is added or inserted into the
     * container.
     * <p>
     * This event bubbles: 'add' will also be fired when Component is added to
     * any of the child containers or their childern or ...
     */
    public native HandlerRegistration addAddHandler(AddHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(ct, cmp, index, e) {
			var container = @com.eemi.ext4j.client.ui.Container::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ct);
			var component = @com.eemi.ext4j.client.core.SimpleComponent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(cmp);
			var event = @com.eemi.ext4j.client.events.container.AddEvent::new(Lcom/eemi/ext4j/client/core/Component;Lcom/eemi/ext4j/client/ui/Container;ILcom/google/gwt/core/client/JavaScriptObject;)(container, component, index,e);
			handler.@com.eemi.ext4j.client.events.container.AddHandler::onAdd(Lcom/eemi/ext4j/client/events/container/AddEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.container.AddEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;

    }-*/;

    /**
     * Fires when the components in this container are arranged by the
     * associated layout manager.
     * 
     * @param handler
     *            , the handler that will handle the event
     */
    public native HandlerRegistration addAfterLayoutHandler(AfterLayoutHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(ct, l, e) {
			var container = @com.eemi.ext4j.client.ui.Container::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ct);
			var layout = @com.eemi.ext4j.client.layout.ContainerLayout::new(Lcom/google/gwt/core/client/JavaScriptObject;)(l);
			var event = @com.eemi.ext4j.client.events.container.AfterLayoutEvent::new(Lcom/eemi/ext4j/client/ui/Container;Lcom/eemi/ext4j/client/layout/ContainerLayout;Lcom/google/gwt/core/client/JavaScriptObject;)(container, layout, e);
			handler.@com.eemi.ext4j.client.events.container.AfterLayoutHandler::onAfterLayout(Lcom/eemi/ext4j/client/events/container/AfterLayoutEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.container.AfterLayoutEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;

    }-*/;

    /**
     * Fires before any {@link Component} is added or inserted into the
     * container.
     * 
     * @param handler
     *            , the handler that will handle the event
     */
    public void addBeforeAddHandler(ContainerContentChangeHandler handler) {
        _addChildrenChangeHandler(Event.BEFORE_ADD, handler);
    }

    public native HandlerRegistration addBeforeAddHandler(BeforeAddHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(ct, cmp, index, e) {
			var container = @com.eemi.ext4j.client.ui.Container::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ct);
			var component = @com.eemi.ext4j.client.core.SimpleComponent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(cmp);
			var event = @com.eemi.ext4j.client.events.container.BeforeAddEvent::new(Lcom/eemi/ext4j/client/core/Component;Lcom/eemi/ext4j/client/ui/Container;ILcom/google/gwt/core/client/JavaScriptObject;)(container, component, index,e);
			handler.@com.eemi.ext4j.client.events.container.BeforeAddHandler::onBeforeAdd(Lcom/eemi/ext4j/client/events/container/BeforeAddEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.container.BeforeAddEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;

    }-*/;

    /**
     * Fires before any Ext.Component is removed from the container. A handler
     * can return false to cancel the remove.
     * 
     * @param handler
     *            , the handler that will handle the event
     */
    public native void addBeforeRemoveHandler(ContainerBeforeRemoveHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		if (component) {
			component
					.addListener(
							@com.eemi.ext4j.client.events.Event::BEFORE_REMOVE,
							$entry(function(ct, c) {
								var comp = @com.eemi.ext4j.client.core.SimpleComponent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
								var container = @com.eemi.ext4j.client.ui.Container::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ct);
								return handler.@com.eemi.ext4j.client.events.container.ContainerBeforeRemoveHandler::onEvent(Lcom/eemi/ext4j/client/ui/Container;Lcom/eemi/ext4j/client/core/Component;)(container,comp);
							}));
		}
    }-*/;

    public native HandlerRegistration addBeforeRemoveHandler(BeforeRemoveHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(ct, cmp, e) {
			var container = @com.eemi.ext4j.client.ui.Container::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ct);
			var component = @com.eemi.ext4j.client.core.SimpleComponent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(cmp);
			var event = @com.eemi.ext4j.client.events.container.BeforeRemoveEvent::new(Lcom/eemi/ext4j/client/core/Component;Lcom/eemi/ext4j/client/ui/Container;Lcom/google/gwt/core/client/JavaScriptObject;)(container,component,e);
			handler.@com.eemi.ext4j.client.events.container.BeforeRemoveHandler::onBeforeRemove(Lcom/eemi/ext4j/client/events/container/BeforeRemoveEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.container.BeforeRemoveEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;

    }-*/;

    public static Container cast(Component component) {
        return new Container(component.getOrCreateJsObj());
    }

    /**
     * Fires before any Ext.Component is removed from the container. A handler
     * can return false to cancel the remove.
     * 
     * @param handler
     *            , the handler that will handle the event
     */
    public native HandlerRegistration addRemoveHandler(com.eemi.ext4j.client.events.container.RemoveHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(ct, cmp, e) {
			var container = @com.eemi.ext4j.client.ui.Container::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ct);
			var component = @com.eemi.ext4j.client.core.SimpleComponent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(cmp);
			var event = @com.eemi.ext4j.client.events.container.RemoveEvent::new(Lcom/eemi/ext4j/client/core/Component;Lcom/eemi/ext4j/client/ui/Container;Lcom/google/gwt/core/client/JavaScriptObject;)(container,component,e);
			handler.@com.eemi.ext4j.client.events.container.RemoveHandler::onRemove(Lcom/eemi/ext4j/client/events/container/RemoveEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.container.RemoveEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;

    }-*/;

    private native void _addChildrenChangeHandler(String event, ContainerContentChangeHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		if (component) {
			component
					.addListener(
							event,
							$entry(function(ct, c, index) {
								var comp = @com.eemi.ext4j.client.core.SimpleComponent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
								var container = @com.eemi.ext4j.client.ui.Container::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ct);
								handler.@com.eemi.ext4j.client.events.container.ContainerContentChangeHandler::onEvent(Lcom/eemi/ext4j/client/ui/Container;Lcom/eemi/ext4j/client/core/Component;I)(container,comp,index);
							}));
		}

    }-*/;

}
