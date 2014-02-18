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

import com.ati.ext4j.client.core.Component;
import com.ati.ext4j.client.core.JsoHelper;
import com.ati.ext4j.client.field.Field;
import com.ati.ext4j.client.field.FieldBase;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * Provides a lightweight HTML Editor component.
 * <p/>
 * Note: The focus/blur and validation marking functionality inherited from
 * {@link Field} is NOT supported by this editor. <br/>
 * <br/>
 * An Editor is a sensitive component that can't be used in all spots standard
 * fields can be used. Putting an Editor within any element that has display set
 * to 'none' can cause problems in Safari and Firefox. <br/>
 * <br/>
 * <p/>
 * There can only be one HtmlEditor on a page at a time.
 * 
 */

// TODO finish events
public class HtmlEditor extends FieldBase {

    private static JavaScriptObject configPrototype;

    private static native void init()/*-{
		var c = new $wnd.Ext.form.field.HtmlEditor();
		@com.ati.ext4j.client.ui.HtmlEditor::configPrototype = c.initialConfig;
    }-*/;

    protected JavaScriptObject getConfigPrototype() {
        return configPrototype;
    }

    public String getXType() {
        return "htmleditor";
    }

    public HtmlEditor(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public HtmlEditor() {
    }

    protected native JavaScriptObject create(JavaScriptObject jsObj) /*-{
		return new $wnd.Ext.form.field.HtmlEditor(jsObj);
    }-*/;

    /**
     * Executes a Midas editor command directly on the editor document. For
     * visual commands, you should use relayCmd instead. This should only be
     * called after the editor is initialized.
     * 
     * @param cmd
     *            the Midas command
     * @param value
     *            the value to pass to the command
     */
    public native void execCmd(String cmd, String value) /*-{
		var he = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		he.execCmd(cmd, value);
    }-*/;

    /**
     * Returns the editor's toolbar. This is only available after the editor has
     * been rendered.
     * 
     * @return toolbar
     */
    public ToolBar getToolbar() {
        return new ToolBar(getToolbar(getOrCreateJsObj()));
    }

    private native JavaScriptObject getToolbar(JavaScriptObject he) /*-{
		return he.getToolbar();
    }-*/;

    /**
     * Inserts the passed text at the current cursor position. Note: the editor
     * must be initialized and activated to insert text.
     * 
     * @param text
     *            the text to insert
     */
    public native void insertAtCursor(String text) /*-{
		var he = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		he.insertAtCursor(text);
    }-*/;

    /**
     * Executes a Midas editor command on the editor document and performs
     * necessary focus and toolbar updates. This should only be called after the
     * editor is initialized.
     * 
     * @param cmd
     *            the Midas command
     * @param value
     *            the value to pass to the command
     */
    public native void relayCmd(String cmd, String value) /*-{
		var he = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		he.relayCmd(cmd, value);
    }-*/;

    /**
     * Toggles the editor between standard and source edit mode.
     * 
     * @param sourceEdit
     *            true for source edit, false for standard
     */
    public native void toggleSourceEdit(boolean sourceEdit) /*-{
		var he = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		he.toggleSourceEdit(sourceEdit);
    }-*/;

    // --- config properties ---

    /**
     * The default text for the create link prompt.
     * 
     * @param createLinkText
     *            link text
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setCreateLinkText(String createLinkText) throws IllegalStateException {
        setAttribute("createLinkText", createLinkText, true);
    }

    /**
     * The default value for the create link prompt (defaults to http:/ /).
     * 
     * @param defaultLinkValue
     *            link value
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setDefaultLinkValue(String defaultLinkValue) throws IllegalStateException {
        setAttribute("defaultLinkValue", defaultLinkValue, true);
    }

    /**
     * Enable the left, center, right alignment buttons (defaults to true).
     * 
     * @param enableAlignments
     *            true to enable alignments
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setEnableAlignments(boolean enableAlignments) throws IllegalStateException {
        setAttribute("enableAlignments", enableAlignments, true);
    }

    /**
     * Enable the fore/highlight color buttons (defaults to true).
     * 
     * @param enableColors
     *            true to enable colors
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setEnableColors(boolean enableColors) throws IllegalStateException {
        setAttribute("enableColors", enableColors, true);
    }

    /**
     * Enable font selection. Not available in Safari. (defaults to true).
     * 
     * @param enableFont
     *            true to enable fonr selection
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setEnableFont(boolean enableFont) throws IllegalStateException {
        setAttribute("enableFont", enableFont, true);
    }

    /**
     * Enable the increase/decrease font size buttons (defaults to true).
     * 
     * @param enableFontSize
     *            true to enable font size buttons
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setEnableFontSize(boolean enableFontSize) throws IllegalStateException {
        setAttribute("enableFontSize", enableFontSize, true);
    }

    /**
     * Enable the create link button. Not available in Safari. (defaults to
     * true).
     * 
     * @param enableLinks
     *            true to enable links
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setEnableLinks(boolean enableLinks) throws IllegalStateException {
        setAttribute("enableLinks", enableLinks, true);
    }

    /**
     * Enable the bullet and numbered list buttons. Not available in Safari.
     * (defaults to true).
     * 
     * @param enableLists
     *            true to enable lists
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setEnableLists(boolean enableLists) throws IllegalStateException {
        setAttribute("enableLists", enableLists, true);
    }

    /**
     * Enable the switch to source edit button. Not available in Safari.
     * (defaults to true)
     * 
     * @param enableSourceEdit
     *            true to enable source edit
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setEnableSourceEdit(boolean enableSourceEdit) throws IllegalStateException {
        setAttribute("enableSourceEdit", enableSourceEdit, true);
    }

    /**
     * An array of available font families.
     * 
     * @param fontFamilies
     *            the font families
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setFontFamilies(String... fontFamilies) throws IllegalStateException {
        setAttribute("fontFamilies", JsoHelper.convertToJavaScriptArray(fontFamilies), true);
    }

    /**
     * Set the height of the HtmlEditor.
     * 
     * @param height
     *            the field height
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setHeight(int height) throws IllegalStateException {
        setAttribute("height", height, true);
    }

    public native void setValue(String value) /*-{
		var field = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		field.setValue(value);
    }-*/;

    public native String getValue() /*-{
		var cb = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var val = cb.getValue();
		if (val === undefined)
			return null;
		return val === '' ? null : val.toString();
    }-*/;

    public static HtmlEditor cast(Component component) {
        return new HtmlEditor(component.getOrCreateJsObj());
    }

    // /TODO Finish me
}
