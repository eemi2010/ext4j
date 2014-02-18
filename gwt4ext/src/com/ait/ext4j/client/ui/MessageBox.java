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

import com.ait.ext4j.client.core.config.MessageBoxConfig;
import com.ait.ext4j.client.events.messagebox.AlertCallback;
import com.ait.ext4j.client.events.messagebox.ConfirmCallback;
import com.ait.ext4j.client.events.messagebox.PromptCallback;

/**
 * Utility class for generating different styles of message boxes.
 * <p>
 * Note that the MessageBox is asynchronous. Unlike a regular JavaScript alert
 * (which will halt browser execution), showing a MessageBox will not cause the
 * code to stop. For this reason, if you have code that should only run after
 * some user feedback from the MessageBox, you must use a callback function.
 */
public class MessageBox {

    public static final String INFO = INFO();
    public static final String WARNING = WARNING();
    public static final String QUESTION = QUESTION();
    public static final String ERROR = ERROR();
    public static final int CANCEL = CANCEL();
    public static final int NO = NO();
    public static final int OKCANCEL = OKCANCEL();
    public static final int OK = OK();
    public static final int YES = YES();
    public static final int YESNO = YESNO();
    public static final int YESNOCANCEL = YESNOCANCEL();

    /**
     * Displays a standard read-only message box with an OK button (comparable
     * to the basic JavaScript Window.alert).
     * 
     * @param message
     *            the message
     */
    public static void alert(String message) {
        alert("", message);
    }

    /**
     * Displays a standard read-only message box with an OK button (comparable
     * to the basic JavaScript Window.alert).
     * 
     * @param title
     *            the title
     * @param message
     *            the message
     */
    public static native void alert(String title, String message) /*-{
		$wnd.Ext.Msg.alert(title, message, $wnd.Ext.emptyFn);
    }-*/;

    public static native void close() /*-{
		$wnd.Ext.Msg.close();
    }-*/;

    /**
     * 
     * Displays a standard read-only message box with an OK button (comparable
     * to the basic JavaScript Window.alert). If a callback function is passed
     * it will be called after the user clicks the button, and the id of the
     * button that was clicked will be passed as the only parameter to the
     * callback (could also be the top-right close button).
     * 
     * @param title
     *            the title
     * @param message
     *            the message
     * @param cb
     *            the callback function
     */
    public static native void alert(String title, String message, AlertCallback cb) /*-{
		$wnd.Ext.MessageBox
				.alert(
						title,
						message,
						function() {
							cb.@com.ait.ext4j.client.events.messagebox.AlertCallback::execute()();
						});
    }-*/;

    /**
     * Displays a confirmation message box with Yes and No buttons (comparable
     * to JavaScript's Window.confirm).
     * 
     * @param title
     *            the title
     * @param message
     *            the message
     */
    public static native void confirm(String title, String message) /*-{
		$wnd.Ext.Msg.confirm(title, message);
    }-*/;

    /**
     * Displays a confirmation message box with Yes and No buttons (comparable
     * to JavaScript's Window.confirm). If a callback function is passed it will
     * be called after the user clicks either button, and the id of the button
     * that was clicked will be passed as the only parameter to the callback
     * (could also be the top-right close button).
     * 
     * @param title
     *            the title
     * @param message
     *            the message
     * @param cb
     *            the callback function
     */
    public static native void confirm(String title, String message, ConfirmCallback cb) /*-{
		$wnd.Ext.Msg
				.confirm(
						title,
						message,
						function(btnID) {
							cb.@com.ait.ext4j.client.events.messagebox.ConfirmCallback::execute(Ljava/lang/String;)(btnID);
						});
    }-*/;

    /**
     * Hides the message box if it is displayed.
     */
    public static native void hide() /*-{
		$wnd.Ext.MessageBox.hide();
    }-*/;

    /**
     * Returns true if the message box is currently displayed.
     * 
     * @return true if visible
     */
    public static native boolean isVisible() /*-{
		return $wnd.Ext.MessageBox.isVisible();
    }-*/;

    /**
     * Displays a message box with OK and Cancel buttons prompting the user to
     * enter some text (comparable to JavaScript's Window.prompt). The prompt
     * can be a single-line or multi-line textbox. If a callback function is
     * passed it will be called after the user clicks either button, and the id
     * of the button that was clicked (could also be the top-right close button)
     * and the text that was entered will be passed as the two parameters to the
     * callback.
     * 
     * @param title
     *            the title
     * @param message
     *            the message
     */
    public static native void prompt(String title, String message) /*-{
		$wnd.Ext.Msg.prompt(title, message);
    }-*/;

    /**
     * Displays a message box with OK and Cancel buttons prompting the user to
     * enter some text (comparable to JavaScript's Window.prompt). The prompt
     * can be a single-line or multi-line textbox. If a callback function is
     * passed it will be called after the user clicks either button, and the id
     * of the button that was clicked (could also be the top-right close button)
     * and the text that was entered will be passed as the two parameters to the
     * callback.
     * 
     * @param title
     *            the title
     * @param message
     *            the message
     * @param cb
     *            the prompt callback
     */
    public static native void prompt(String title, String message, PromptCallback cb) /*-{
		$wnd.Ext.Msg
				.prompt(
						title,
						message,
						function(btnID, text) {
							//if no text is entered text is undedined in web mode but raises error in hosted mode typing to
							//coerce to string. Add harmless check for empty string too to keep host mode happy
							if (text === undefined || text == '')
								text = null;
							cb.@com.ait.ext4j.client.events.messagebox.PromptCallback::execute(Ljava/lang/String;Ljava/lang/String;)(btnID, text);
						});
    }-*/;

    /**
     * Displays a message box with OK and Cancel buttons prompting the user to
     * enter some text (comparable to JavaScript's Window.prompt). The prompt
     * can be a single-line or multi-line textbox. If a callback function is
     * passed it will be called after the user clicks either button, and the id
     * of the button that was clicked (could also be the top-right close button)
     * and the text that was entered will be passed as the two parameters to the
     * callback.
     * 
     * @param title
     *            the title
     * @param message
     *            the message
     * @param multiline
     *            true for multiline
     * @param cb
     *            the prompt callback
     */
    public static native void prompt(String title, String message, PromptCallback cb, boolean multiline) /*-{
		$wnd.Ext.Msg
				.prompt(
						title,
						message,
						function(btnID, text) {
							//if no text is entered text is undedined in web mode but raises error in hosted mode typing to
							//coerce to string. Add harmless check for empty string too to keep host mode happy
							if (text === undefined || text == '')
								text = null;
							cb.@com.ait.ext4j.client.events.messagebox.PromptCallback::execute(Ljava/lang/String;Ljava/lang/String;)(btnID, text);
						}, $wnd, multiline);
    }-*/;

    /**
     * Adds the specified icon to the dialog. By default, the class
     * 'ext-mb-icon' is applied for default styling, and the class passed in is
     * expected to supply the background image url. Pass in empty string ('') to
     * clear any existing icon. The following built-in icon classes are
     * supported, but you can also pass in a custom class name:
     * 
     * <pre>
     * 
     * MessageBox.INFO
     * MessageBox.WARNING
     * MessageBox.QUESTION
     * MessageBox.ERROR
     * </pre>
     * 
     * @param iconCls
     *            a CSS classname specifying the icon's background image url, or
     *            empty string to clear the icon
     */
    public static native void setIcon(String iconCls) /*-{
		$wnd.Ext.MessageBox.setIcon(iconCls);
    }-*/;

    /**
     * Updates a progress-style message box's text and progress bar. Only
     * relevant on message boxes initiated via progress or wait, or by calling
     * show with progress: true.
     * 
     * @param value
     */
    public static native void updateProgress(double value) /*-{
		$wnd.Ext.MessageBox.updateProgress(value);
    }-*/;

    /**
     * Updates a progress-style message box's text and progress bar. Only
     * relevant on message boxes initiated via progress or wait, or by calling
     * show with progress: true.
     * 
     * @param value
     * @param progressText
     */
    public static native void updateProgress(double value, String progressText) /*-{
		$wnd.Ext.MessageBox.updateProgress(value, progressText);
    }-*/;

    /**
     * Updates a progress-style message box's text and progress bar. Only
     * relevant on message boxes initiated via progress or wait, or by calling
     * show with progress: true.
     * 
     * @param value
     * @param progressText
     * @param message
     */
    public static native void updateProgress(double value, String progressText, String message) /*-{
		$wnd.Ext.MessageBox.updateProgress(value, progressText, message);
    }-*/;

    /**
     * Displays a new message box, or reinitializes an existing message box,
     * based on the config options passed in.
     * 
     * @param config
     *            the message box config
     */
    public static native void show(MessageBoxConfig config) /*-{
		$wnd.Ext.Msg.show(config.@com.ait.ext4j.client.core.JsObject::jsObj);
    }-*/;

    public static native void setYesButtonText(String value) /*-{
		$wnd.Ext.MessageBox.buttonText.yes = value;
    }-*/;

    public static native void setNoButtonText(String value) /*-{
		$wnd.Ext.MessageBox.buttonText.no = value;
    }-*/;

    public static native void setCancelButtonText(String value) /*-{
		$wnd.Ext.MessageBox.buttonText.cancel = value;
    }-*/;

    public static void show(String title, String message, String icon) {
        MessageBoxConfig config = new MessageBoxConfig();
        config.setTitle(title);
        config.setMessage(message);
        config.setIcon(icon);
        MessageBox.show(config);
    }

    public static void show(String title, String message, String icon, int buttons) {
        MessageBoxConfig config = new MessageBoxConfig();
        config.setTitle(title);
        config.setMessage(message);
        config.setIcon(icon);
        config.setButtons(buttons);
        MessageBox.show(config);
    }

    public static void info(String message) {
        MessageBoxConfig config = new MessageBoxConfig();
        config.setMessage(message);
        config.setIcon(MessageBox.INFO);
        MessageBox.show(config);
    }

    public static void info(String message, int buttons) {
        MessageBoxConfig config = new MessageBoxConfig();
        config.setMessage(message);
        config.setIcon(MessageBox.INFO);
        config.setButtons(buttons);
        MessageBox.show(config);
    }

    public static void info(String title, String message) {
        MessageBoxConfig config = new MessageBoxConfig();
        config.setMessage(message);
        config.setTitle(title);
        config.setClosable(true);
        config.setIcon(MessageBox.INFO);
        MessageBox.show(config);
    }

    public static void info(String title, String message, int buttons) {
        MessageBoxConfig config = new MessageBoxConfig();
        config.setMessage(message);
        config.setTitle(title);
        config.setButtons(buttons);
        config.setIcon(MessageBox.INFO);
        MessageBox.show(config);
    }

    public static void warn(String message) {
        MessageBoxConfig config = new MessageBoxConfig();
        config.setMessage(message);
        config.setIcon(MessageBox.WARNING);
        MessageBox.show(config);
    }

    public static void warn(String message, int buttons) {
        MessageBoxConfig config = new MessageBoxConfig();
        config.setMessage(message);
        config.setIcon(MessageBox.WARNING);
        config.setButtons(buttons);
        MessageBox.show(config);
    }

    public static void warn(String title, String message) {
        MessageBoxConfig config = new MessageBoxConfig();
        config.setMessage(message);
        config.setTitle(title);
        config.setIcon(MessageBox.WARNING);
        MessageBox.show(config);
    }

    public static void warn(String title, String message, int buttons) {
        MessageBoxConfig config = new MessageBoxConfig();
        config.setMessage(message);
        config.setTitle(title);
        config.setButtons(buttons);
        config.setIcon(MessageBox.WARNING);
        MessageBox.show(config);
    }

    public static void error(String message) {
        MessageBoxConfig config = new MessageBoxConfig();
        config.setMessage(message);
        config.setIcon(MessageBox.ERROR);
        config.setClosable(true);
        MessageBox.show(config);
    }

    public static void error(String message, int buttons) {
        MessageBoxConfig config = new MessageBoxConfig();
        config.setMessage(message);
        config.setIcon(MessageBox.ERROR);
        config.setButtons(buttons);
        MessageBox.show(config);
    }

    public static void error(String title, String message) {
        MessageBoxConfig config = new MessageBoxConfig();
        config.setMessage(message);
        config.setTitle(title);
        config.setIcon(MessageBox.ERROR);
        MessageBox.show(config);
    }

    public static void error(String title, String message, int buttons) {
        MessageBoxConfig config = new MessageBoxConfig();
        config.setMessage(message);
        config.setTitle(title);
        config.setButtons(buttons);
        config.setIcon(MessageBox.ERROR);
        MessageBox.show(config);
    }

    public static void question(String message) {
        MessageBoxConfig config = new MessageBoxConfig();
        config.setMessage(message);
        config.setIcon(MessageBox.QUESTION);
        MessageBox.show(config);
    }

    public static void question(String message, int buttons) {
        MessageBoxConfig config = new MessageBoxConfig();
        config.setMessage(message);
        config.setIcon(MessageBox.QUESTION);
        config.setButtons(buttons);
        MessageBox.show(config);
    }

    public static void question(String title, String message) {
        MessageBoxConfig config = new MessageBoxConfig();
        config.setMessage(message);
        config.setTitle(title);
        config.setIcon(MessageBox.QUESTION);
        MessageBox.show(config);
    }

    public static void question(String title, String message, int buttons) {
        MessageBoxConfig config = new MessageBoxConfig();
        config.setMessage(message);
        config.setTitle(title);
        config.setButtons(buttons);
        config.setIcon(MessageBox.QUESTION);
        MessageBox.show(config);
    }

    private static native int CANCEL()/*-{
		return $wnd.Ext.Msg.CANCEL;
    }-*/;

    private static native String ERROR()/*-{
		return $wnd.Ext.Msg.ERROR;
    }-*/;

    private static native String INFO()/*-{
		return $wnd.Ext.Msg.INFO;
    }-*/;

    private static native int NO()/*-{
		return $wnd.Ext.Msg.NO;
    }-*/;

    private static native int OK()/*-{
		return $wnd.Ext.Msg.OK;
    }-*/;

    private static native int OKCANCEL()/*-{
		return $wnd.Ext.Msg.OKCANCEL;
    }-*/;

    private static native int YES()/*-{
		return $wnd.Ext.Msg.YES;
    }-*/;

    private static native int YESNO()/*-{
		return $wnd.Ext.Msg.YESNO;
    }-*/;

    private static native int YESNOCANCEL()/*-{
		return $wnd.Ext.Msg.YESNOCANCEL;
    }-*/;

    private static native String WARNING()/*-{
		return $wnd.Ext.Msg.WARNING;
    }-*/;

    private static native String QUESTION()/*-{
		return $wnd.Ext.Msg.QUESTION;
    }-*/;

}
