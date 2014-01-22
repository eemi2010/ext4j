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

import com.eemi.ext4j.client.core.RegExp;

/**
 * Basic pre-created validation types. Overridable validation definitions. The
 * validations provided are basic and intended to be easily customizable and
 * extended.
 * 
 * @see com.eemi.ext4j.client.ui.TextField#setVtype(VTypes)
 */
public class VTypes {

    private String vType;

    private VTypes(String vType) {
        this.vType = vType;
    }

    public String getVType() {
        return vType;
    }

    /**
     * The function used to validate alpha values
     */
    public static VTypes ALPHA = new VTypes("alpha");

    /**
     * The function used to validate alphanumeric values.
     */
    public static VTypes ALPHANUM = new VTypes("alphanum");

    /**
     * The function used to validate email addresses.
     */
    public static VTypes EMAIL = new VTypes("email");

    /**
     * The function used to validate URLs.
     */
    public static VTypes URL = new VTypes("url");

    /**
     * The error text to display when the alpha validation function returns
     * false.
     * 
     * @param alphaText
     *            error message
     */
    public static native void setAlphaText(String alphaText)/*-{
		$wnd.Ext.form.field.VTypes.alphaText = alphaText;
    }-*/;

    /**
     * The keystroke filter mask to be applied on alpha input.
     * 
     * @param alphaMask
     *            the alpha mask
     */
    public static native void setAlphaMask(RegExp alphaMask)/*-{
		var re = alphaMask.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		$wnd.Ext.form.field.VTypes.alphaMask = re;
    }-*/;

    /**
     * The error text to display when the alphanumeric validation function
     * returns false.
     * 
     * @param alphanumText
     *            the error message
     */
    public static native void setAlphanumText(String alphanumText)/*-{
		$wnd.Ext.form.field.VTypes.alphanumText = alphanumText;
    }-*/;

    /**
     * The keystroke filter mask to be applied on alphanumeric input.
     * 
     * @param alphanumMask
     *            the alpha num mask
     */
    public static native void setAlphanumMask(RegExp alphanumMask)/*-{
		var re = alphanumMask.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		$wnd.Ext.form.field.VTypes.alphanumMask = re;
    }-*/;

    /**
     * The error text to display when the email validation function returns
     * false.
     * 
     * @param emailText
     *            the error message
     */
    public static native void setEmailText(String emailText)/*-{
		$wnd.Ext.form.field.VTypes.emailText = emailText;
    }-*/;

    /**
     * The keystroke filter mask to be applied on email input.
     * 
     * @param emailMask
     *            the email mask
     */
    public static native void setEmailMask(RegExp emailMask)/*-{
		var re = emailMask.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		$wnd.Ext.form.field.VTypes.emailMask = re;
    }-*/;

    /**
     * The error text to display when the url validation function returns false.
     * 
     * @param urlText
     *            the error message
     */
    public static native void setUrlText(String urlText)/*-{
		$wnd.Ext.form.field.VTypes.urlText = urlText;
    }-*/;

}
