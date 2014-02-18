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
package com.ait.ext4j.client.core;

/**
 * Determines information about the current platform the application is running
 * on.
 * 
 * @author alainekambi
 * 
 */
public class Is {

    public static final Is INSTANCE = new Is();

    private Is() {

    }

    /**
     * True when the browser is running on an Android device
     * 
     * @return
     */
    public native boolean android()/*-{
		return $wnd.Ext.is.Android;
    }-*/;

    /**
     * True when the browser is running on a Blackberry device
     * 
     * @return
     */
    public native boolean blackBerry()/*-{
		return $wnd.Ext.is.Blackberry;
    }-*/;

    /**
     * True if the browser is running on a desktop machine
     * 
     * @return
     */
    public native boolean desktop()/*-{
		return $wnd.Ext.is.Desktop;
    }-*/;

    /**
     * True when the browser is running on Linux
     * 
     * @return
     */
    public native boolean linux()/*-{
		return $wnd.Ext.is.Linux;
    }-*/;

    /**
     * True when the browser is running on a Mac
     * 
     * @return
     */
    public native boolean mac()/*-{
		return $wnd.Ext.is.Mac;
    }-*/;

    public native boolean phone()/*-{
		return $wnd.Ext.is.Phone;
    }-*/;

    public native boolean standalone()/*-{
		return $wnd.Ext.is.Standalone;
    }-*/;

    public native boolean tablet()/*-{
		return $wnd.Ext.is.Tablet;
    }-*/;

    public native boolean windows()/*-{
		return $wnd.Ext.is.Windows;
    }-*/;

    public native boolean iOS()/*-{
		return $wnd.Ext.is.iOS;
    }-*/;

    public native boolean ipad()/*-{
		return $wnd.Ext.is.iPad;
    }-*/;

    public native boolean iphone()/*-{
		return $wnd.Ext.is.iPhone;
    }-*/;

    public native boolean ipod()/*-{
		return $wnd.Ext.is.iPod;
    }-*/;
}
