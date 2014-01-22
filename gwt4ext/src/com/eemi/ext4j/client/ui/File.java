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

import com.eemi.ext4j.client.core.Component;
import com.eemi.ext4j.client.core.EventObject;
import com.eemi.ext4j.client.core.ExtElement;
import com.eemi.ext4j.client.events.HandlerRegistration;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * A display-only text field which is not validated and not submitted. This is
 * useful for when you want to display a value from a form's loaded data but do
 * not want to allow the user to edit or submit that value. The value can be
 * optionally HTML encoded if it contains HTML markup that you do not want to be
 * rendered.
 * <p>
 * If you have more complex content, or need to include components within the
 * displayed content, also consider using a Ext.form.FieldContainer instead.
 */
public class File extends TriggerField {

    private static JavaScriptObject configPrototype;

    private static native void init()/*-{
		var c = new $wnd.Ext.form.field.File();
		@com.eemi.ext4j.client.ui.File::configPrototype = c.initialConfig;
    }-*/;

    protected JavaScriptObject getConfigPrototype() {
        return configPrototype;
    }

    public String getXType() {
        return "fileuploadfield";
    }

    /**
     * Create a new File.
     */
    public File() {
    }

    protected File(JavaScriptObject jsObj) {
        super(jsObj);
    }

    protected native JavaScriptObject create(JavaScriptObject jsObj) /*-{
		return new $wnd.Ext.form.field.File(jsObj);
    }-*/;

    // --- config properties ---

    public void setButtonConfig(Button value) {
        setAttribute("buttonConfig", value.getOrCreateJsObj(), true, true);
    }

    /**
     * The number of pixels of space reserved between the button and the text
     * field. Note that this only applies if buttonOnly = false.
     * <p>
     * Defaults to: 3
     */
    public void setButtonMargin(double value) {
        setAttribute("buttonMargin", value, true);
    }

    /**
     * True to display the file upload field as a button with no visible text
     * field. If true, all inherited Text members will still be available.
     * <p>
     * Defaults to: false
     */
    public void setButtonOnly(boolean value) {
        setAttribute("buttonOnly", value, true);
    }

    /**
     * The button text to display on the upload button. Note that if you supply
     * a value for buttonConfig, the buttonConfig.text value will be used
     * instead if available.
     * <p>
     * Defaults to: 'Browse...'
     */
    public void setButtonText(String value) {
        setAttribute("buttonText", value, true);
    }

    /**
     * True to escape HTML in text when rendering it.
     * <p>
     * Defaults to: false
     */
    public void setSubmitValue(boolean value) {
        setAttribute("submitValue", value, true, true);
    }

    /**
     * An extra CSS class to be applied to the body content element in addition
     * to baseBodyCls.
     * <p>
     * Defaults to: 'x-form-file-wrap'
     */
    public void setFieldBoyCls(String value) {
        setAttribute("fieldBodyCls", value, true, true);
    }

    /**
     * Unlike with other form fields, the readOnly config defaults to true in
     * File field.
     * <p>
     * Defaults to: true
     */
    public void setReadOnly(boolean value) {
        setAttribute("readOnly", value, true, true);
    }

    /**
     * A reference to the trigger Button component created for this upload
     * field. Only populated after this component is rendered.
     */
    public native ExtElement getFileInputEl() /*-{
		var field = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var el = field.fileInputEl;
		return @com.eemi.ext4j.client.core.ExtElement::new(Lcom/google/gwt/core/client/JavaScriptObject;)(el);
    }-*/;

    /**
     * A reference to the trigger Button component created for this upload
     * field. Only populated after this component is rendered.
     */
    public native Button getButton() /*-{
		var field = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var el = field.button;
		return @com.eemi.ext4j.client.ui.Button::new(Lcom/google/gwt/core/client/JavaScriptObject;)(el);
    }-*/;

    /**
     * A reference to the trigger Button component created for this upload
     * field. Only populated after this component is rendered.
     */
    public native ExtElement getButtonEl() /*-{
		var field = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var el = field.buttonEl;
		return @com.eemi.ext4j.client.core.ExtElement::new(Lcom/google/gwt/core/client/JavaScriptObject;)(el);
    }-*/;

    /**
     * True to clear the selected file value when the form this field belongs to
     * is submitted to the server..
     * <p>
     * Defaults to: true
     */
    public void setClearOnSubmit(boolean value) {
        setAttribute("clearOnSubmit", value, true, true);
    }

    /**
     * Creates a new File from the given component
     * 
     * @param component
     *            , the component to cast from
     * @return, a new File from the component
     * 
     */
    public static File cast(Component component) {
        return new File(component.getOrCreateJsObj());
    }

    @Override
    protected void onTriggerClick(EventObject event) {

    }

    /**
     * Fires when the underlying file input field's value has changed from the
     * user selecting a new file from the system file selection dialog.
     */
    public native HandlerRegistration addFileChangeHandler(
                    com.eemi.ext4j.client.events.form.FileChangeHandler handler)/*-{
		var component = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(f, value, e) {
			var file = @com.eemi.ext4j.client.ui.File::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);

			var event = @com.eemi.ext4j.client.events.form.FileChangeEvent::new(Lcom/eemi/ext4j/client/ui/File;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(file,value,e);
			handler.@com.eemi.ext4j.client.events.form.FileChangeHandler::onFileChange(Lcom/eemi/ext4j/client/events/form/FileChangeEvent;)(event);
		};
		var eventName = @com.eemi.ext4j.client.events.form.FileChangeEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.eemi.ext4j.client.events.HandlerRegistration::new(Lcom/eemi/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

}
