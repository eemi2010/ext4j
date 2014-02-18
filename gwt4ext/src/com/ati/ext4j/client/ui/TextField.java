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
import com.ati.ext4j.client.core.RegExp;
import com.ati.ext4j.client.events.form.KeyDownHandler;
import com.ati.ext4j.client.events.form.KeyPressHandler;
import com.ati.ext4j.client.events.form.KeyUpHandler;
import com.ati.ext4j.client.field.FieldBase;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.editor.client.IsEditor;
import com.google.gwt.editor.client.LeafValueEditor;
import com.google.gwt.editor.client.adapters.TakesValueEditor;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasValue;

/**
 * A basic text field. Can be used as a direct replacement for traditional text
 * inputs, or as the base class for more sophisticated input controls (like
 * TextArea and ComboBox). Has support for empty-field placeholder values (see
 * emptyText).
 */
public class TextField extends FieldBase implements HasValue<String>, IsEditor<LeafValueEditor<String>> {

    private LeafValueEditor<String> editor;

    private static JavaScriptObject configPrototype;

    private static native void init()/*-{
		var c = new $wnd.Ext.form.field.Text();
		@com.ati.ext4j.client.ui.TextField::configPrototype = c.initialConfig;
    }-*/;

    protected JavaScriptObject getConfigPrototype() {
        return configPrototype;
    }

    public String getXType() {
        return "textfield";
    }

    /**
     * Create a new TextField.
     */
    public TextField() {
    }

    protected TextField(JavaScriptObject jsObj) {
        super(jsObj);
    }

    protected native JavaScriptObject create(JavaScriptObject jsObj) /*-{
		return new $wnd.Ext.form.field.Text(jsObj);
    }-*/;

    /**
     * Automatically grows the field to accomodate the width of the text up to
     * the maximum field width allowed. This only takes effect if grow = true,
     * and fires the autosize event.
     */
    public native void autoSize() /*-{
		var field = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		field.autoSize();
    }-*/;

    /**
     * Selects text in this field.
     */
    public native void selectText() /*-{
		var field = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		field.selectText();
    }-*/;

    /**
     * Selects text in this field.
     * 
     * @param start
     *            the index where the selection should start
     * @param end
     *            the index where the selection should end
     */
    public native void selectText(int start, int end) /*-{
		var field = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		field.selectText(start, end);
    }-*/;

    /**
     * Validates a value according to the field's validation rules and marks the
     * field as invalid if the validation fails.
     * 
     * @param value
     *            the value to valdiate
     * @return true if valid
     */
    public native boolean validateValue(String value) /*-{
		var field = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		return field.validateValue(value);
    }-*/;

    /**
     * Returns the value of the text field.
     * 
     * @return the text field value
     */
    public String getText() {
        return getValueAsString();
    }

    // --- config properties ---

    /**
     * False to validate that the value length > 0 (defaults to true).
     * 
     * @param allowBlank
     *            false to disallow blank
     */
    public void setAllowBlank(boolean allowBlank) {
        setAttribute("allowBlank", allowBlank, true, true);
    }

    /**
     * Specify false to automatically trim the value before validating the
     * whether the value is blank. Setting this to false automatically sets
     * allowBlank to false.
     * <p>
     * Defaults to: true
     */
    public void setAllowOnlyWhiteSpace(boolean allowBlank) {
        setAttribute("allowOnlyWhiteSpace", allowBlank, true, true);
    }

    /**
     * Error text to display if the allow blank validation fails (defaults to
     * "This field is required").
     * 
     * @param blankText
     *            error message for blank field
     */
    public void setBlankText(String blankText) {
        setAttribute("blankText", blankText, true, true);
    }

    /**
     * True to disable input keystroke filtering (defaults to false).
     * 
     * @param disableKeyFilter
     *            true to disable
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setDisableKeyFilter(boolean disableKeyFilter) throws IllegalStateException {
        setAttribute("disableKeyFilter", disableKeyFilter, true);
    }

    /**
     * The CSS class to apply to an empty field to style the emptyText (defaults
     * to 'x-form-empty-field'). This class is automatically added and removed
     * as needed depending on the current field value.
     * 
     * @param emptyClass
     *            the empty field CSS class
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setEmptyClass(String emptyClass) throws IllegalStateException {
        setAttribute("emptyClass", emptyClass, true);
    }

    /**
     * The default text to display in an empty field (defaults to null).
     * 
     * @param emptyText
     *            the empty field text
     */
    public void setEmptyText(String emptyText) {
        setAttribute("emptyText", emptyText, true, true);
    }

    /**
     * The default text to display in an empty field (defaults to null).
     * 
     * @param emptyText
     *            the empty field text
     */
    public void setEnableKeyEvents(boolean value) {
        setAttribute("enableKeyEvents", value, true);
    }

    /**
     * True to set the maxLength property on the underlying input field.
     * Defaults to false
     * <p>
     */
    public void setEnforceMaxLength(boolean value) {
        setAttribute("enforceMaxLength", value, true);
    }

    /**
     * True if this field should automatically grow and shrink to its content.
     * 
     * @param grow
     *            true to allow grow
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setGrow(boolean grow) throws IllegalStateException {
        setAttribute("grow", grow, true);
    }

    /**
     * A string that will be appended to the field's current value for the
     * purposes of calculating the target field size. Only used when the grow
     * config is true. Defaults to a single capital "W" (the widest character in
     * common fonts) to leave enough space for the next typed character and
     * avoid the field value shifting before the width is adjusted.
     * <p>
     * Defaults to: 'W'
     * 
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setGrowAppend(String value) throws IllegalStateException {
        setAttribute("grow", value, true);
    }

    /**
     * The maximum width to allow when grow = true (defaults to 800).
     * 
     * @param growMax
     *            the max width
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setGrowMax(int growMax) throws IllegalStateException {
        setAttribute("growMax", growMax, true);
    }

    /**
     * The minimum width to allow when grow = true (defaults to 30).
     * 
     * @param growMin
     *            the minimum width
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setGrowMin(int growMin) throws IllegalStateException {
        setAttribute("growMin", growMin, true);
    }

    /**
     * An input mask regular expression that will be used to filter keystrokes
     * that don't match (defaults to null).
     * 
     * <br>
     * <br>
     * <b>Note:</b> This property cannot be changed after the Component has been
     * rendered.
     * 
     * @param maskRe
     *            the mask regular expression
     */
    public void setMaskRe(String maskRe) {
        RegExp reg = new RegExp(maskRe);
        setAttribute("maskRe", reg.getJsObj(), true);
    }

    public void setMaskRe(RegExp reg) {
        setAttribute("maskRe", reg.getJsObj(), true);
    }

    /**
     * A JavaScript RegExp object used to strip unwanted content from the value
     * during input. If stripCharsRe is specified, every character sequence
     * matching stripCharsRe will be removed.
     * 
     * @param maskRe
     *            the mask regular expression
     */

    public void setStripCharsRe(String maskRe) {
        RegExp reg = new RegExp(maskRe);
        setAttribute("stripCharsRe", reg.getJsObj(), true);
    }

    public void setStripCharsRe(RegExp reg) {
        setAttribute("stripCharsRe", reg.getJsObj(), true);
    }

    public void setMaxLength(int maxLength) {
        setAttribute("maxLength", maxLength, true, true);
    }

    /**
     * Error text to display if the maximum length validation fails. (defaults
     * to "The maximum length for this field is {maxLength}")
     * 
     * @param maxLengthText
     *            the max lenght error text
     */
    public void setMaxLengthText(String maxLengthText) {
        setAttribute("maxLengthText", maxLengthText, true, true);
    }

    /**
     * Minimum input field length required (defaults to 0).
     * 
     * @param minLength
     *            the min length
     */
    public void setMinLength(int minLength) {
        setAttribute("minLength", minLength, true, true);
    }

    /**
     * Error text to display if the minimum length validation fails. (defaults
     * to "The minimum length for this field is {minLength}")
     * 
     * @param minLengthText
     *            the min length error text
     */
    public void setMinLengthText(String minLengthText) {
        setAttribute("minLengthText", minLengthText, true, true);
    }

    /**
     * The CSS class to apply to a required field, i.e. a field where allowBlank
     * is false.
     * <p>
     * Defaults to: 'x-form-required-field'
     */
    public void setRequireCls(String value) {
        setAttribute("requireCls", value, true, true);
    }

    /**
     * An initial value for the 'size' attribute on the text input element. This
     * is only used if the field has no configured width and is not given a
     * width by its container's layout. Defaults to 20.
     * <p>
     * Defaults to: 20
     */
    public void setSize(double value) {
        setAttribute("size", value, true);
    }

    /**
     * Set true if field is a password field.
     * 
     * @param password
     *            true if passowrd field
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setPassword(boolean password) throws IllegalStateException {
        if (password)
            setInputType("password");
    }

    /**
     * A Regular Expressionto be tested against the field value during
     * validation (defaults to null). If available, this regex will be evaluated
     * only after the basic validators all return true, and will be passed the
     * current field value. If the test fails, the field will be marked invalid
     * using regexText.
     * 
     * 
     * @param regex
     *            the regular expression
     */
    public void setRegex(String regex) {
        setRegex(isCreated() ? getJsObj() : config, regex);
    }

    private native void setRegex(JavaScriptObject config, String regex) /*-{
		var config = this.@com.ati.ext4j.client.core.Component::config;
		config['regex'] = new $wnd.RegExp(regex);
    }-*/;

    /**
     * The error text to display if regex is used and the test fails during
     * validation (defaults to "").
     * 
     * <br>
     * <br>
     * <b>Note:</b> This property cannot be changed after the Component has been
     * rendered.
     * 
     * @param regexText
     *            the regexp text
     */
    public void setRegexText(String regexText) {
        setAttribute("regexText", regexText, true, true);
    }

    /**
     * True to automatically select any existing field text when the field
     * receives input focus (defaults to false).
     * 
     * @param selectOnFocus
     *            true to select text on focus
     * @throws IllegalStateException
     *             this property cannot be changed after the Component has been
     *             rendered
     */
    public void setSelectOnFocus(boolean selectOnFocus) throws IllegalStateException {
        setAttribute("selectOnFocus", selectOnFocus, true);
    }

    /**
     * A validation type name as defined in {@link VTypes} (defaults to null).
     * 
     * @param vtype
     *            the validation type
     */
    public void setVtype(VTypes vtype) {
        setVtype(vtype.getVType());
    }

    /**
     * A validation type name as defined in {@link VTypes} (defaults to null).
     * 
     * @param vtype
     *            the validation type
     */
    public void setVtype(String vtype) {
        setAttribute("vtype", vtype, true);
    }

    /**
     * The validation type text if the validation specified by
     * {@link #setVtype(VTypes)} fails.
     * 
     * @param vtypeText
     *            the vtype
     */
    public void setVtypeText(String vtypeText) {
        setAttribute("vtypeText", vtypeText, true);
    }

    /**
     * This method return the position of the caret as a int array. Two values
     * are provided: start of highlight and end of highlight. If there is
     * nothing highlighted, the two values are the same.
     * 
     * @return the position of the caret: start and end position
     */
    public int[] getCaretPosition() {
        int retval[] = new int[2];
        JavaScriptObject jsob = getCaretPositionJs();
        retval[0] = JsoHelper.getAttributeAsInt(jsob, "start");
        retval[1] = JsoHelper.getAttributeAsInt(jsob, "end");

        return retval;
    }

    private native JavaScriptObject getCaretPositionJs() /*-{
		var field = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var el = $doc.getElementById(field.getId());
		var result = {
			start : 0,
			end : 0
		};

		// IE Support
		if ($doc.selection) {
			el.focus();
			if (el.type === 'text') // textbox
			{
				var range = $doc.selection.createRange();
				var r2 = range.duplicate();
				result.start = 0 - r2.moveStart('character', -100000);
				result.end = result.start + range.text.length;
			} else // textarea
			{
				if (el.value.charCodeAt(el.value.length - 1) < 14) {
					el.value = el.value.replace(/\034/g, '')
							+ String.fromCharCode(28);
				}
				var oRng = $doc.selection.createRange();
				var oRng2 = oRng.duplicate();
				oRng2.moveToElementText(el);
				oRng2.setEndPoint('StartToEnd', oRng);
				result.end = el.value.length - oRng2.text.length;
				oRng2.setEndPoint('StartToStart', oRng);
				result.start = el.value.length - oRng2.text.length;

			}
		}
		// Firefox support
		else if (el.selectionStart || el.selectionStart == '0') {
			result.start = el.selectionStart;
			result.end = el.selectionEnd;
		}
		return result;
    }-*/;

    /**
     * This method sets the caret position
     * 
     * @param caretPos
     *            the caret position
     */
    public native void setCaretPosition(int caretStart, int numToSelect) /*-{
		var field = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var el = $doc.getElementById(field.getId());

		if ($doc.selection) // IE
		{
			var range = $doc.selection.createRange();
			if (el.type == 'text') // textbox
			{
				range.moveStart('character', -el.value.length);
				range.moveEnd('character', -el.value.length);
				range.moveStart('character', caretStart);
				range.moveEnd('character', numToSelect);
				range.select();
			} else // textarea
			{
				var sel = el.createTextRange();
				sel.collapse(true);
				sel.moveStart("character", caretStart);
				sel.moveEnd("character", numToSelect);
				sel.select();
			}
		} else if (el.selectionStart || el.selectionStart == '0') // Firefox
		{
			el.setSelectionRange(caretStart, caretStart + numToSelect);
		}

    }-*/;

    public native void insertAtCaret(String text) /*-{
		var field = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var el = $doc.getElementById(field.getId());

		if ($doc.selection) {
			el.focus();
			var orig = el.value.replace(/\r\n/g, "\n");
			var range = $doc.selection.createRange();

			if (range.parentElement() != el) {
				return false;
			}

			range.text = text;
			var actual, tmp;

			actual = tmp = el.value.replace(/\r\n/g, "\n");

			for ( var diff = 0; diff < orig.length; diff++) {
				if (orig.charAt(diff) != actual.charAt(diff))
					break;
			}

			var macthTxt;
			if ((text == "\\") || (text == "(") || (text == ")")
					|| (text == "*") || (text == "?") || (text == "+")
					|| (text == ".") || (text == "[") || (text == "]")) {
				macthTxt = "\\" + text;
			} else {
				macthTxt = text;
			}
			for ( var index = 0, start = 0; tmp.match(macthTxt)
					&& (tmp = tmp.replace(macthTxt, "")) && index <= diff; index = start
					+ text.length) {
				start = actual.indexOf(text, index);
			}
		} else if (el.selectionStart) {
			var start = el.selectionStart;
			var end = el.selectionEnd;

			el.value = el.value.substr(0, start) + text
					+ el.value.substr(end, el.value.length);
		}

		if (start != null) {
			var textend = start + text.length;
			this.@com.ati.ext4j.client.ui.TextField::setCaretPosition(II)(textend,textend);
		} else {
			el.value += text;
		}
    }-*/;

    /**
     * Creates a new TextField from the given component
     * 
     * @param component
     *            , the component to cast from
     * @return, a new TextField from the component
     * 
     */
    public static TextField cast(Component component) {
        return new TextField(component.getOrCreateJsObj());
    }

    private native void _setValue(String value) /*-{
		var field = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		field.setValue(value);
    }-*/;

    private native String _getValue() /*-{
		var cb = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var val = cb.getValue();
		if (!val)
			return null;
		return val === '' ? null : val.toString();
    }-*/;

    @Override
    public HandlerRegistration addValueChangeHandler(ValueChangeHandler<String> handler) {
        return null;
    }

    @Override
    public LeafValueEditor<String> asEditor() {
        if (editor == null) {
            editor = TakesValueEditor.of(this);
        }
        return editor;
    }

    @Override
    public String getValue() {
        return _getValue();
    }

    @Override
    public void setValue(String value) {
        _setValue(value);
    }

    @Override
    public void setValue(String value, boolean fireEvents) {
        _setValue(value);
    }

    /**
     * Fires when the autoSize function is triggered and the field is resized
     * according to the grow/growMin/growMax configs as a result. This event
     * provides a hook for the developer to apply additional logic at runtime to
     * resize the field if needed.
     * 
     * @param handler
     *            , the handler that will handle the event
     */
    public native HandlerRegistration addAutoSizeHandler(com.ati.ext4j.client.events.form.AutoSizeHandler handler)/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(t, width, e) {
			var tf = @com.ati.ext4j.client.ui.TextField::new(Lcom/google/gwt/core/client/JavaScriptObject;)(t);
			var event = @com.ati.ext4j.client.events.form.AutoSizeEvent::new(Lcom/ati/ext4j/client/ui/TextField;DLcom/google/gwt/core/client/JavaScriptObject;)(tf,width,e);
			handler.@com.ati.ext4j.client.events.form.AutoSizeHandler::onAutoSize(Lcom/ati/ext4j/client/events/form/AutoSizeEvent;)(event);
		};
		var eventName = @com.ati.ext4j.client.events.form.AutoSizeEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ati.ext4j.client.events.HandlerRegistration::new(Lcom/ati/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * Keyup input field event. This event only fires if enableKeyEvents is set
     * to true.
     * 
     * @param handler
     *            , the handler that will handle the event
     */
    public native HandlerRegistration AddKeyUpHandler(KeyUpHandler handler)/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(t, e) {
			var tf = @com.ati.ext4j.client.ui.TextField::new(Lcom/google/gwt/core/client/JavaScriptObject;)(t);
			var event = @com.ati.ext4j.client.events.form.KeyUpEvent::new(Lcom/ati/ext4j/client/ui/TextField;Lcom/google/gwt/core/client/JavaScriptObject;)(tf,e);
			handler.@com.ati.ext4j.client.events.form.KeyUpHandler::onKeyUp(Lcom/ati/ext4j/client/events/form/KeyUpEvent;)(event);
		};
		var eventName = @com.ati.ext4j.client.events.form.KeyUpEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ati.ext4j.client.events.HandlerRegistration::new(Lcom/ati/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * Keypress input field event. This event only fires if enableKeyEvents is
     * set to true.
     * 
     * @param handler
     *            , the handler that will handle the event
     */
    public native HandlerRegistration AddKeyPressHandler(KeyPressHandler handler)/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(t, e) {
			var tf = @com.ati.ext4j.client.ui.TextField::new(Lcom/google/gwt/core/client/JavaScriptObject;)(t);
			var event = @com.ati.ext4j.client.events.form.KeyPressEvent::new(Lcom/ati/ext4j/client/ui/TextField;Lcom/google/gwt/core/client/JavaScriptObject;)(tf,e);
			handler.@com.ati.ext4j.client.events.form.KeyPressHandler::onKeyPress(Lcom/ati/ext4j/client/events/form/KeyPressEvent;)(event);
		};
		var eventName = @com.ati.ext4j.client.events.form.KeyPressEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ati.ext4j.client.events.HandlerRegistration::new(Lcom/ati/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * Keydown input field event. This event only fires if enableKeyEvents is
     * set to true.
     * 
     * @param handler
     *            , the handler that will handle the event
     */
    public native HandlerRegistration AddKeyDownHandler(KeyDownHandler handler)/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(t, e) {
			var tf = @com.ati.ext4j.client.ui.TextField::new(Lcom/google/gwt/core/client/JavaScriptObject;)(t);
			var event = @com.ati.ext4j.client.events.form.KeyDownEvent::new(Lcom/ati/ext4j/client/ui/TextField;Lcom/google/gwt/core/client/JavaScriptObject;)(tf,e);
			handler.@com.ati.ext4j.client.events.form.KeyDownHandler::onKeyDown(Lcom/ati/ext4j/client/events/form/KeyDownEvent;)(event);
		};
		var eventName = @com.ati.ext4j.client.events.form.KeyDownEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ati.ext4j.client.events.HandlerRegistration::new(Lcom/ati/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

}
