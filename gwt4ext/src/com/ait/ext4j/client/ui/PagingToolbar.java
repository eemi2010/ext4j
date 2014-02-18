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
import com.ait.ext4j.client.core.JsoHelper;
import com.ait.ext4j.client.data.Store;
import com.ait.ext4j.client.events.HandlerRegistration;
import com.ait.ext4j.client.events.toolbar.BeforeChangeHandler;
import com.ait.ext4j.client.events.toolbar.ChangeHandler;
import com.ait.ext4j.client.events.toolbar.PagingToolbarBeforeChangeHandler;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * As the number of records increases, the time required for the browser to
 * render them increases. Paging is used to reduce the amount of data exchanged
 * with the client. Note: if there are more records/rows than can be viewed in
 * the available screen area, vertical scrollbars will be added.
 * <p>
 * Paging is typically handled on the server side (see exception below). The
 * client sends parameters to the server side, which the server needs to
 * interpret and then respond with the appropriate data.
 * <p>
 * Ext.toolbar.Paging is a specialized toolbar that is bound to a Ext.data.Store
 * and provides automatic paging control. This Component loads blocks of data
 * into the store by passing parameters used for paging criteria.
 */
public class PagingToolbar extends ToolBar {

    private Store store;
    private static JavaScriptObject configPrototype;

    public String getXType() {
        return "pagingtoolbar";
    }

    /**
     * Create a new PagingToolbar.
     */
    public PagingToolbar() {
    }

    /**
     * Create a new PagingToolbar.
     * 
     * @param store
     *            the underlying Store
     */
    public PagingToolbar(Store store) {
        this.store = store;
        setStore(store);
    }

    public PagingToolbar(JavaScriptObject jsObj) {
        super(jsObj);
    }

    @Override
    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		config.displayInfo = true;
		config.pageSize = 10;
		var toReturn = new $wnd.Ext.toolbar.Paging(config);
		return toReturn;
    }-*/;

    public native void updateInfo() /*-{
		var pagingToolbar = this.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()();
		pagingToolbar.updateInfo();
    }-*/;

    // --- config properties ---

    /**
     * The paging status message to display (defaults to
     * "Displaying {start} - {end} of {total}").
     * 
     * @param displayMsg
     *            the display message
     */
    public void setDisplayMsg(String displayMsg) {
        setAttribute("displayMsg", displayMsg, true, true);
    }

    /**
     * The paging status message to display (defaults to
     * "Displaying {start} - {end} of {total}").
     * 
     * @return the display message
     */
    public String getDisplayMsg() {
        return getAttribute("displayMsg");
    }

    /**
     * The message to display when no records are found (defaults to
     * "No data to display").
     * 
     * @param emptyMsg
     *            the empty message
     */
    public void setEmptyMsg(String emptyMsg) {
        setAttribute("emptyMsg", emptyMsg, true, true);
    }

    /**
     * @return the message dispalyed when no records are found
     */
    public String getEmptyMsg() {
        return getAttribute("emptyMsg");
    }

    /**
     * The number of records to display per page (defaults to 20).
     * 
     * @param pageSize
     *            the page size
     */
    public void setPageSize(int pageSize) {
        setAttribute("pageSize", pageSize, true);
    }

    /**
     * True to display the displayMsg (defaults to false).
     * 
     * @param displayInfo
     *            the display message
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setDisplayInfo(boolean displayInfo) throws IllegalStateException {
        setAttribute("displayInfo", displayInfo, true, true);
    }

    /**
     * True to display the displayMsg.
     * 
     * @return true to display the info
     */
    public boolean getDisplayInfo() {
        return getAttributeAsBoolean("displayInfo");
    }

    /**
     * Set the Store for the PagingToolbar.
     * 
     * @param store
     *            the store
     */
    public void setStore(Store store) {
        setAttribute("store", store.getJsObj(), true);
    }

    /**
     * Return the Store of the PagingToolbar.
     * 
     * @return the store
     */
    public Store getStore() {
        return store;
    }

    /**
     * The before page paging text tooltip (defaults to "First Page")
     * 
     * @param beforePageText
     *            the before page tooltip
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setBeforePageText(String beforePageText) throws IllegalStateException {
        setAttribute("beforePageText", beforePageText, true);
    }

    /**
     * The before page paging text tooltip (defaults to "First Page")
     * 
     * @return the before text tooltip
     */
    public String getBeforePageText() {
        return JsoHelper.getAttribute(config, "beforePageText");
    }

    /**
     * The after page paging text tooltip (defaults to "of %0")
     * 
     * @param afterPageText
     *            the before page tooltip
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setAfterPageText(String afterPageText) throws IllegalStateException {
        setAttribute("afterPageText", afterPageText, true);
    }

    /**
     * The after page paging text tooltip (defaults to "of %0")
     * 
     * @return the after page tooltip
     */
    public String getAfterPageText() {
        return getAttribute("afterPageText");
    }

    /**
     * The first page paging text tooltip (defaults to "First Page")
     * 
     * @param firstText
     *            the first page tooltip
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setFirstText(String firstText) throws IllegalStateException {
        setAttribute("firstText", firstText, true);
    }

    /**
     * The width in pixels of the input field used to display and change the
     * current page number.
     * <p>
     * Defaults to: 30
     */
    public void setInputItemWidth(int value) {
        setAttribute("inputItemWidth", value, true);
    }

    /**
     * The first page paging text tooltip (defaults to "First Page")
     * 
     * @return the after page tooltip
     */
    public String getFirstText() {
        return getAttribute("firstText");
    }

    /**
     * The previous page paging text tooltip (defaults to "Previous Page")
     * 
     * @param prevText
     *            the first page tooltip
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setPrevText(String prevText) throws IllegalStateException {
        setAttribute("prevText", prevText, true);
    }

    /**
     * The previous page paging text tooltip (defaults to "Previous Page")
     * 
     * @return the previous page tooltip
     */
    public String getPrevText() {
        return getAttribute("prevText");
    }

    /**
     * The next page paging text tooltip (defaults to "Next Page")
     * 
     * @param nextText
     *            the first page tooltip
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setNextText(String nextText) throws IllegalStateException {
        setAttribute("nextText", nextText, true);
    }

    /**
     * The next page paging text tooltip (defaults to "Next Page")
     * 
     * @return the next page tooltip
     */
    public String getNextText() {
        return getAttribute("nextText");
    }

    /**
     * The last page paging text tooltip (defaults to "Last Page")
     * 
     * @param lastText
     *            the first page tooltip
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setLastText(String lastText) throws IllegalStateException {
        setAttribute("lastText", lastText, true);
    }

    /**
     * The last page paging text tooltip (defaults to "Last Page")
     * 
     * @return the after page tooltip
     */
    public String getLastText() {
        return getAttribute("lastText");
    }

    /**
     * The refrest page paging text tooltip (defaults to "Refresh")
     * 
     * @param refreshText
     *            the first page tooltip
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setRefreshText(String refreshText) {
        setAttribute("refreshText", refreshText, true);
    }

    /**
     * The refresh page paging text tooltip (defaults to "Refresh")
     * 
     * @return the after page tooltip
     */
    public String getRefreshText() {
        return getAttribute("refreshText");
    }

    /**
     * Parameter names during data load.
     * 
     * @param start
     *            defaults to "start"
     * @param limit
     *            defaults to "limit"
     */
    public void setPagingParamNames(String start, String limit) {
        JavaScriptObject params = JsoHelper.createObject();
        JsoHelper.setAttribute(params, "start", start);
        JsoHelper.setAttribute(params, "limit", limit);
        setAttribute("paramNames", params, true);
    }

    /**
     * Refresh the current page, has the same effect as clicking the 'refresh'
     * button.
     */
    public native void doRefresh()/*-{
		var component = this.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()();
		if (component) {
			component.doRefresh();
		}
    }-*/;

    /**
     * Move to the first page, has the same effect as clicking the 'first'
     * button.
     */
    public native void moveFirst()/*-{
		var component = this.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()();
		if (component) {
			component.moveFirst();
		}
    }-*/;

    /**
     * Move to the last page, has the same effect as clicking the 'last' button.
     */
    public native void moveLast()/*-{
		var component = this.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()();
		if (component) {
			component.moveLast();
		}
    }-*/;

    /**
     * Move to the next page, has the same effect as clicking the 'next' button.
     */
    public native void moveNext()/*-{
		var component = this.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()();
		if (component) {
			component.moveNext();
		}
    }-*/;

    /**
     * Move to the previous page, has the same effect as clicking the 'previous'
     * button.
     */
    public native void movePrevious()/*-{
		var component = this.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()();
		if (component) {
			component.movePrevious();
		}
    }-*/;

    /**
     * 
     * Fires after the active page has been changed.
     * 
     * Fires just before the active page is changed. Return false to prevent the
     * active page from being changed.
     * 
     * @param handler
     *            , the handler that will handle this event
     */
    public native HandlerRegistration addChangeHandler(ChangeHandler handler)/*-{
		var component = this.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(t, d, e) {
			var pt = @com.ait.ext4j.client.ui.PagingToolbar::new(Lcom/google/gwt/core/client/JavaScriptObject;)(p);
			var data = @com.ait.ext4j.client.toolbar.PageData::new(Lcom/google/gwt/core/client/JavaScriptObject;)(d);
			var event = @com.ait.ext4j.client.events.toolbar.ChangeEvent::new(Lcom/ait/ext4j/client/ui/PagingToolbar;Lcom/ait/ext4j/client/toolbar/PageData;Lcom/google/gwt/core/client/JavaScriptObject;)(pt,data,e);
			handler.@com.ait.ext4j.client.events.toolbar.ChangeHandler::onChange(Lcom/ait/ext4j/client/events/toolbar/ChangeEvent;)(event);
		};
		var eventName = @com.ait.ext4j.client.events.toolbar.ChangeEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.ext4j.client.events.HandlerRegistration::new(Lcom/ait/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * Fires just before the active page is changed. Return false to prevent the
     * active page from being changed.
     * 
     * @param handler
     *            , the handler that will handle this event
     */
    public native void addBeforechangeHandler(PagingToolbarBeforeChangeHandler handler)/*-{
		var component = this.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()();
		if (component) {
			component
					.addListener(
							@com.ait.ext4j.client.events.Event::BEFORE_CHANGE,
							$entry(function(p, page) {
								var pt = @com.ait.ext4j.client.ui.PagingToolbar::new(Lcom/google/gwt/core/client/JavaScriptObject;)(p);
								handler.@com.ait.ext4j.client.events.toolbar.PagingToolbarBeforeChangeHandler::onEvent(Lcom/ait/ext4j/client/ui/PagingToolbar;I)(pt,index);
							}));
		}

    }-*/;

    /**
     * Fires just before the active page is changed.
     */
    public native HandlerRegistration addBeforeChangeHandler(BeforeChangeHandler handler)/*-{
		var component = this.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(t, page, e) {
			var pt = @com.ait.ext4j.client.ui.PagingToolbar::new(Lcom/google/gwt/core/client/JavaScriptObject;)(p);
			var event = @com.ait.ext4j.client.events.toolbar.BeforeChangeEvent::new(Lcom/ait/ext4j/client/ui/PagingToolbar;DLcom/google/gwt/core/client/JavaScriptObject;)(pt,page,e);
			handler.@com.ait.ext4j.client.events.toolbar.BeforeChangeHandler::onBeforeChange(Lcom/ait/ext4j/client/events/toolbar/BeforeChangeEvent;)(event);
		};
		var eventName = @com.ait.ext4j.client.events.toolbar.BeforeChangeEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.ext4j.client.events.HandlerRegistration::new(Lcom/ait/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    public static PagingToolbar cast(Component component) {
        return new PagingToolbar(component.getOrCreateJsObj());
    }

}
