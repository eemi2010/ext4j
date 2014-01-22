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
package com.eemi.ext4j.client.core.config;

import com.eemi.ext4j.client.core.JsoHelper;
import com.eemi.ext4j.client.core.NameValuePair;
import com.eemi.ext4j.client.events.messagebox.ConfirmCallback;
import com.eemi.ext4j.client.events.messagebox.PromptCallback;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * {@link com.eemi.ext4j.client.ui.MessageBox} configuration class.
 * 
 * @see com.eemi.ext4j.client.ui.MessageBox#show(MessageBoxConfig)
 */
public class MessageBoxConfig extends BaseConfig {

    /**
     * The title text.
     * 
     * @param title
     *            the title
     */
    public void setTitle(String title) {
        JsoHelper.setAttribute(jsObj, "title", title);
    }

    /**
     * False to hide the top-right close button (defaults to true). Note that
     * progress and wait dialogs will ignore this property and always hide the
     * close button as they can only be closed programmatically.
     * 
     * @param closable
     *            true for closable
     */
    public void setClosable(boolean closable) {
        JsoHelper.setAttribute(jsObj, "closable", closable);
    }

    /**
     * A custom CSS class to apply to the message box element.
     * 
     * @param cls
     *            the css class
     */
    public void setCls(String cls) {
        JsoHelper.setAttribute(jsObj, "cls", cls);
    }

    /**
     * The default height in pixels of the message box's multiline textarea if
     * displayed (defaults to 75).
     * 
     * @param defaultTextHeight
     *            the default text height
     */
    public void setDefaultTextHeight(int defaultTextHeight) {
        JsoHelper.setAttribute(jsObj, "defaultTextHeight", defaultTextHeight);
    }

    /**
     * True to prompt the user to enter single-line text (defaults to false).
     * 
     * @param prompt
     *            true to prompt
     */
    public void setPrompt(boolean prompt) {
        JsoHelper.setAttribute(jsObj, "prompt", prompt);
    }

    /**
     * True to prompt the user to enter multi-line text (defaults to false).
     * 
     * @param multiline
     *            true for multiline prompt
     */
    public void setMultiline(boolean multiline) {
        JsoHelper.setAttribute(jsObj, "multiline", multiline);
    }

    /**
     * True to display a progress bar (defaults to false)
     * 
     * @param progress
     *            true for progress bar
     */
    public void setProgress(boolean progress) {
        JsoHelper.setAttribute(jsObj, "progress", progress);
    }

    public void setWait(boolean progress) {
        JsoHelper.setAttribute(jsObj, "wait", progress);
    }

    public void setProgressText(String progress) {
        JsoHelper.setAttribute(jsObj, "progressText", progress);
    }

    /**
     * he string value to set into the active textbox element if displayed.
     * 
     * @param value
     *            the value text
     */
    public void setValue(String value) {
        JsoHelper.setAttribute(jsObj, "value", value);
    }

    /**
     * The button to display.
     * 
     * @param buttons
     *            the buttons
     */
    public void setButtons(int buttons) {
        JsoHelper.setAttribute(jsObj, "buttons", buttons);
    }

    /**
     * False to not show any buttons.
     * 
     * @param buttons
     *            display buttons
     */
    public void setButtons(boolean buttons) {
        JsoHelper.setAttribute(jsObj, "buttons", buttons);
    }

    /**
     * A callback function to execute after closing the dialog. The arguments to
     * the function will be btn (the name of the button that was clicked, if
     * applicable, e.g. "ok"), and text (the value of the active text field, if
     * applicable). Progress and wait dialogs will ignore this option since they
     * do not respond to user actions and can only be closed programmatically,
     * so any required function should be called by the same code after it
     * closes the dialog.
     * 
     * @param cb
     *            the callback
     */
    public native void setCallback(PromptCallback cb)/*-{
		var config = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		config['fn'] = function(btnID, text) {
			if (btnID === undefined)
				btnID = null;
			if (text === undefined || text == '')
				text = null;
			cb.@com.eemi.ext4j.client.events.messagebox.PromptCallback::execute(Ljava/lang/String;Ljava/lang/String;)(btnID, text);
		};
    }-*/;

    /**
     * name = button id, value = button label Name has to be one of 'ok, cancel,
     * yes, no, and value is the label to be displayed
     * 
     * @param buttons
     *            the name value pairs for the buttons
     */
    public void setButtons(NameValuePair[] buttons) {
        JavaScriptObject config = NameValuePair.getJsObj(buttons);
        JsoHelper.setAttribute(jsObj, "buttons", config);
    }

    /**
     * The string that will replace the existing message box body text (defaults
     * to the XHTML-compliant non-breaking space character ' ')
     * 
     * @param msg
     *            the message
     */
    public void setMessage(String msg) {
        JsoHelper.setAttribute(jsObj, "msg", msg);
    }

    /**
     * A CSS class that provides a background image to be used as an icon for
     * the dialog (e.g., Ext.MessageBox.WARNING or 'custom-class', defaults to
     * '').
     * 
     * @param iconCls
     *            the icon CSS class
     */
    public void setIcon(String iconCls) {
        JsoHelper.setAttribute(jsObj, "icon", iconCls);
    }

    /**
     * False to allow user interaction with the page while the message box is
     * displayed (defaults to true).
     * 
     * @param modal
     *            false for non modal
     */
    public void setModal(boolean modal) {
        JsoHelper.setAttribute(jsObj, "modal", modal);
    }

    /**
     * The width of the dialog in pixels.
     * 
     * @param width
     *            the dialog width
     */
    public void setWidth(int width) {
        JsoHelper.setAttribute(jsObj, "width", width);
    }

    public native void setCallback(ConfirmCallback callback)/*-{
		var jso = this.@com.eemi.ext4j.client.core.config.BaseConfig::getJsObj()();
		jso.fn = function(btn) {
			callback.@com.eemi.ext4j.client.events.messagebox.ConfirmCallback::execute(Ljava/lang/String;)(btn);
		}
    }-*/;

    public native void setWaitInterval(int value)/*-{
		var jso = this.@com.eemi.ext4j.client.core.config.BaseConfig::getJsObj()();
		jso.waitConfig = {
			interval : value
		};
    }-*/;

    public native void setButtonText(ButtonText value)/*-{
		var jso = this.@com.eemi.ext4j.client.core.config.BaseConfig::getJsObj()();
		jso.buttonText = value.@com.eemi.ext4j.client.core.config.ButtonText::getJsObj()();
    }-*/;

}
