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

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;

/**
 * Base abstract Widget class.
 */
public abstract class BaseExtWidget extends Widget {

    protected JavaScriptObject jsObj;

    protected BaseExtWidget() {
    }

    protected BaseExtWidget(JavaScriptObject jsObj) {
        this.jsObj = jsObj;
        setElement(getElement(this.jsObj));
    }

    public JavaScriptObject getJsObj() {
        return jsObj;
    }

    public void setJsObj(JavaScriptObject jsObj) {
        this.jsObj = jsObj;
    }

    public ExtElement getEl() {
        if (jsObj == null || getElement() == null) {
            return null;
        } else {
            return new ExtElement(getElement());
        }
    }

    // jsObj is JS object representing the UI Widget
    // jsObj.el is the ExtElement of the Widget
    // jsObj.el.dom is the DOM Element of the widget
    protected native Element getElement(JavaScriptObject jsObj) /*-{
		//var el = jsObj.el;
		var el = jsObj.getEl().dom;
		if (el == null || el === undefined) {
			return null;
			//forms buttons are detached when initially added
			//throw new Error('Widget ' + jsObj + ' has no element property set');
		} else {
			//There's an inconsistency in Ext where most elements have the property 'el' set to Ext's Element
			//with the exception of Menu->Item, Menu->Separator, Menu->TextItem,  Toolbar.Item and subclasses
			//(Toolbar.Separator, Toolbar.Spacer, Toolbar.TextItem) where the 'el' property is set to
			//the DOM element itself. Therefore retruning 'el' if 'el' is not Ext's Element. See details in issue 39.
			return el.dom || el;
		}
    }-*/;

    protected void onLoad() {
        if (getElement() == null) {
            setElement(getElement(jsObj));
        }
    }

    protected void onAttach() {
        super.onAttach();
    }

    /*
     * protected void onAttach() { super.onAttach(); Widget parent =
     * getParent(); if(!isRendered()) { render(parent.getElement()); }
     * 
     * }
     */
    /*
     * public Element getElement() { if (super.getElement() == null) {
     * if(!isRendered()) { render(parent.getElement()); }
     * setElement(getElement(jsObj)); } return super.getElement(); }
     */

    public int getOffsetHeight() {
        return getElement().getPropertyInt("offsetHeight");
    }

    public int getOffsetWidth() {
        return getElement().getPropertyInt("offsetWidth");
    }

    public String getTitle() {
        return getElement().getPropertyString("title");
    }

    public boolean isVisible() {
        return isVisible(getElement());
    }

    public native void purgeListeners() /*-{
		var widget = this.@com.eemi.ext4j.client.core.Component::getJsObj()();
		widget.purgeListeners();
    }-*/;

    public void setHeight(String height) {
        // This exists to deal with an inconsistency in IE's implementation
        // where
        // it won't accept negative numbers in length measurements
        assert extractLengthValue(height.trim().toLowerCase()) >= 0 : "CSS heights should not be negative";
        getElement().getStyle().setProperty("height", height);
    }

    private native double extractLengthValue(String s) /*-{
		if (s == "auto" || s == "inherit" || s == "") {
			return 0;
		} else {
			return parseFloat(s);
		}
    }-*/;

    public void setTitle(String title) {
        if (title == null || title.length() == 0) {
            getElement().removeAttribute("title");
        } else {
            getElement().setAttribute("title", title);
        }
    }

    public void setVisible(boolean visible) {
        setVisible(getElement(), visible);
    }

    public void setWidth(String width) {
        // This exists to deal with an inconsistency in IE's implementation
        // where
        // it won't accept negative numbers in length measurements
        assert extractLengthValue(width.trim().toLowerCase()) >= 0 : "CSS widths should not be negative";
        getElement().getStyle().setProperty("width", width);
    }

    public boolean equals(Object obj) {
        if (obj instanceof BaseExtWidget) {
            return getElement().equals(((BaseExtWidget) obj).getElement());
        } else {
            return false;
        }
    }

    public int hashCode() {
        return getElement().hashCode();
    }

    public String toString() {
        return "element";
        /*
         * if (getElement() == null) { return "(null handle)"; } return
         * DOM.toString(getElement());
         */
    }
}
