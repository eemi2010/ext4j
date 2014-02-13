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

import com.eemi.ext4j.client.core.Component;
import com.eemi.ext4j.client.util.Format;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * A label class for Forms.
 * 
 */
public class Label extends BoxComponent {
    /**
     * Create a new Label
     */
    public Label() {
    }

    /**
     * Create a new label.
     * 
     * @param label
     *            the label as text
     */
    public Label(String label) {
        setText(label);
    }

    public Label(JavaScriptObject jsObj) {
        super(jsObj);
    }

    protected native JavaScriptObject create(JavaScriptObject jsObj) /*-{
		return new $wnd.Ext.form.Label(jsObj);
    }-*/;

    public String getXType() {
        return "label";
    }

    /**
     * Set the label as text.
     * 
     * @param text
     *            the label text
     */
    public void setText(String text) {
        if (!isRendered()) {
            setAttribute("text", text, true);
        } else {
            getElement().setPropertyString("innerHTML", Format.htmlEncode(text));
        }
    }

    /**
     * Return the label text.
     * 
     * @return the text
     */
    public String getText() {
        return getAttribute("text");
    }

    /**
     * Set the label as html.
     * 
     * @param html
     *            the html
     */
    public void setHtml(String html) {
        if (!isRendered()) {
            setAttribute("html", html, true);
        } else {
            getElement().setPropertyString("innerHtml", html);
        }
    }

    /**
     * Return the html.
     * 
     * @return the html
     */
    public String getHtml() {
        return getAttribute("html");
    }

    public static Label cast(Component component) {
        return new Label(component.getOrCreateJsObj());
    }
}
