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
package com.ati.ext4j.client.form;

import com.ati.ext4j.client.core.JsObject;
import com.ati.ext4j.client.core.JsoHelper;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * Instances of this class are only created by a Form when the Form needs to
 * perform an action such as submit or load. The Configuration options listed
 * for this class are set through the Form's action methods: submit, load and
 * doAction
 * <p>
 * The instance of Action which performed the action is passed to the success
 * and failure callbacks of the Form's action methods (submit, load and
 * doAction), and to the actioncomplete and actionfailed event handlers.
 * 
 * 
 */
public class Action extends JsObject {

    public static final String CLIENT_INVALID = CLIENT_INVALID();
    public static final String CONNECT_FAILURE = CONNECT_FAILURE();
    public static final String LOAD_FAILURE = LOAD_FAILURE();
    public static final String SERVER_INVALID = SERVER_INVALID();

    Action(JavaScriptObject obj) {
        jsObj = obj;
    }

    /**
     * The type of failure detected will be one of these: CLIENT_INVALID,
     * SERVER_INVALID, CONNECT_FAILURE, or LOAD_FAILURE.
     */
    public String getFailureType() {
        return JsoHelper.getAttribute(jsObj, "failureType");
    }

    /**
     * 
     * The raw XMLHttpRequest object used to perform the action.
     */
    public JavaScriptObject getResponse() {
        return JsoHelper.getAttributeAsJavaScriptObject(jsObj, "response");
    }

    /**
     * 
     * The decoded response object containing a boolean success property and
     * other, action-specific properties.
     */
    public JavaScriptObject getResult() {
        return JsoHelper.getAttributeAsJavaScriptObject(jsObj, "result");
    }

    /**
     * 
     The type of action this Action instance performs. Currently only "submit"
     * and "load" are supported.
     */
    public String getType() {
        return JsoHelper.getAttribute(jsObj, "type");
    }

    private static native String CLIENT_INVALID()/*-{
		return $wnd.Ext.form.action.Action.CLIENT_INVALID;
    }-*/;

    private static native String CONNECT_FAILURE()/*-{
		return $wnd.Ext.form.action.Action.CONNECT_FAILURE;
    }-*/;

    private static native String LOAD_FAILURE()/*-{
		return $wnd.Ext.form.action.Action.LOAD_FAILURE;
    }-*/;

    private static native String SERVER_INVALID()/*-{
		return $wnd.Ext.form.action.Action.SERVER_INVALID;
    }-*/;

}
