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
package com.eemi.ext4j.client.ui;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Multiline text field. Can be used as a direct replacement for traditional
 * textarea fields, plus adds support for auto-sizing.
 * 
 */
public class TextArea extends TextField {

    private static JavaScriptObject configPrototype;

    static {
        init();
    }

    private static native void init()/*-{
		var c = new $wnd.Ext.form.field.TextArea();
		@com.eemi.ext4j.client.ui.TextArea::configPrototype = c.initialConfig;
    }-*/;

    protected JavaScriptObject getConfigPrototype() {
        return configPrototype;
    }

    public String getXType() {
        return "textarea";
    }

    /**
     * Constructs a new TextArea.
     */
    public TextArea() {
    }

    public TextArea(JavaScriptObject jsObj) {
        super(jsObj);
    }

    protected native JavaScriptObject create(JavaScriptObject jsObj) /*-{
		return new $wnd.Ext.form.field.TextArea(jsObj);
    }-*/;

    // --- config properties ---

    /**
     * An initial value for the 'cols' attribute on the textarea element. This
     * is only used if the component has no configured width and is not given a
     * width by its container's layout.
     * <p>
     * Defaults to: 20
     */
    public void setCols(int value) {
        setAttribute("cols", value, true);
    }

    /**
     * An initial value for the 'rows' attribute on the textarea element. This
     * is only used if the component has no configured height and is not given a
     * height by its container's layout. Defaults to 4.
     */
    public void setRows(int value) {
        setAttribute("rows", value, true);
    }

    /**
     * The maximum height to allow when grow = true (defaults to 1000).
     * 
     * @param growMax
     *            the max height
     */
    public void setGrowMax(int growMax) {
        super.setGrowMax(growMax);
    }

    /**
     * The minimum height to allow when grow = true (defaults to 60).
     * 
     * @param growMin
     *            the min height
     */
    public void setGrowMin(int growMin) {
        super.setGrowMin(growMin);
    }

    /**
     * True to prevent scrollbars from appearing regardless of how much text is
     * in the field (equivalent to setting overflow: hidden, defaults to false).
     * 
     * @param preventScrollbars
     *            true to prevent scrollbars
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setPreventScrollbars(boolean preventScrollbars) throws IllegalStateException {
        setAttribute("preventScrollbars", preventScrollbars, true);
    }

    /**
     * Set the enterIsSpecial. By default the ENTER key is not treated as a
     * special key. Set to true to override this setting.
     * 
     * @param enterIsSpecial
     *            the enterIsSpecial
     * @see {@link com.gwtext.client.widgets.form.event.FieldListener#onSpecialKey(Field, com.gwtext.client.core.EventObject)}
     */
    public void setEnterIsSpecial(boolean enterIsSpecial) {
        setAttribute("enterIsSpecial", enterIsSpecial, true, true);
    }

    /**
     * Return the enterIsSpecial.
     * 
     * @return the enterIsSpecial
     */
    public boolean getEnterIsSpecial() {
        return getAttributeAsBoolean("enterIsSpecial");
    }

}
