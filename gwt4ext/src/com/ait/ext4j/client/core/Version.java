package com.ait.ext4j.client.core;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;

/**
 * A utility class that wrap around a string version number and provide
 * convenient method to perform comparison.
 */
public class Version extends JsObject {

    public Version(String version) {
        jsObj = create(version);
    }

    public Version(double version) {
        jsObj = create(version);
    }

    public Version(JavaScriptObject obj) {
        jsObj = obj;
    }

    /**
     * Returns whether this version equals to the supplied argument
     */
    public native boolean equals(String target)/*-{
		var obj = this.@com.ait.ext4j.client.core.JsObject::getJsObj()();
		return obj.equals(target);
    }-*/;

    /**
     * Returns whether this version equals to the supplied argument
     */
    public native boolean equals(double target)/*-{
		var obj = this.@com.ait.ext4j.client.core.JsObject::getJsObj()();
		return obj.equals(target);
    }-*/;

    /**
     * Returns the build component value
     */
    public native double getBuild()/*-{
		var obj = this.@com.ait.ext4j.client.core.JsObject::getJsObj()();
		return obj.getBuild();
    }-*/;

    /**
     * Returns the major component value
     * 
     * @return
     */
    public native double getMajor()/*-{
		var obj = this.@com.ait.ext4j.client.core.JsObject::getJsObj()();
		return obj.getMajor();
    }-*/;

    public native double getMinor()/*-{
		var obj = this.@com.ait.ext4j.client.core.JsObject::getJsObj()();
		return obj.getMinor();
    }-*/;

    public native double getPath()/*-{
		var obj = this.@com.ait.ext4j.client.core.JsObject::getJsObj()();
		return obj.getPath();
    }-*/;

    public native double getRelease()/*-{
		var obj = this.@com.ait.ext4j.client.core.JsObject::getJsObj()();
		return obj.getRelease();
    }-*/;

    public native double getShortVersion()/*-{
		var obj = this.@com.ait.ext4j.client.core.JsObject::getJsObj()();
		return obj.getShortVersion();
    }-*/;

    public native boolean gt(String target)/*-{
		var obj = this.@com.ait.ext4j.client.core.JsObject::getJsObj()();
		return obj.gt(target);
    }-*/;

    public native boolean gt(double target)/*-{
		var obj = this.@com.ait.ext4j.client.core.JsObject::getJsObj()();
		return obj.gt(target);
    }-*/;

    public native boolean gtEq(String target)/*-{
		var obj = this.@com.ait.ext4j.client.core.JsObject::getJsObj()();
		return obj.gtEq(target);
    }-*/;

    public native boolean gtEq(double target)/*-{
		var obj = this.@com.ait.ext4j.client.core.JsObject::getJsObj()();
		return obj.gtEq(target);
    }-*/;

    public native boolean isGreaterThan(double target)/*-{
		var obj = this.@com.ait.ext4j.client.core.JsObject::getJsObj()();
		return obj.isGreaterThan(target);
    }-*/;

    public native boolean isGreaterThan(String target)/*-{
		var obj = this.@com.ait.ext4j.client.core.JsObject::getJsObj()();
		return obj.isGreaterThan(target);
    }-*/;

    public native boolean isGreaterThanOrEquals(double target)/*-{
		var obj = this.@com.ait.ext4j.client.core.JsObject::getJsObj()();
		return obj.isGreaterThanOrEquals(target);
    }-*/;

    public native boolean isGreaterThanOrEquals(String target)/*-{
		var obj = this.@com.ait.ext4j.client.core.JsObject::getJsObj()();
		return obj.isGreaterThanOrEquals(target);
    }-*/;

    public native boolean isLessThan(double target)/*-{
		var obj = this.@com.ait.ext4j.client.core.JsObject::getJsObj()();
		return obj.isLessThan(target);
    }-*/;

    public native boolean isLessThan(String target)/*-{
		var obj = this.@com.ait.ext4j.client.core.JsObject::getJsObj()();
		return obj.isLessThan(target);
    }-*/;

    public native boolean isLessThanOrEquals(double target)/*-{
		var obj = this.@com.ait.ext4j.client.core.JsObject::getJsObj()();
		return obj.isLessThanOrEquals(target);
    }-*/;

    public native boolean isLessThanOrEquals(String target)/*-{
		var obj = this.@com.ait.ext4j.client.core.JsObject::getJsObj()();
		return obj.isLessThanOrEquals(target);
    }-*/;

    public native boolean lt(String target)/*-{
		var obj = this.@com.ait.ext4j.client.core.JsObject::getJsObj()();
		return obj.lt(target);
    }-*/;

    public native boolean lt(double target)/*-{
		var obj = this.@com.ait.ext4j.client.core.JsObject::getJsObj()();
		return obj.lt(target);
    }-*/;

    public native boolean ltEq(String target)/*-{
		var obj = this.@com.ait.ext4j.client.core.JsObject::getJsObj()();
		return obj.ltEq(target);
    }-*/;

    public native boolean ltEq(double target)/*-{
		var obj = this.@com.ait.ext4j.client.core.JsObject::getJsObj()();
		return obj.ltEq(target);
    }-*/;

    public native boolean match(String target)/*-{
		var obj = this.@com.ait.ext4j.client.core.JsObject::getJsObj()();
		return obj.match(target);
    }-*/;

    public native boolean match(double target)/*-{
		var obj = this.@com.ait.ext4j.client.core.JsObject::getJsObj()();
		return obj.match(target);
    }-*/;

    public native JsArrayString toArray()/*-{
		var obj = this.@com.ait.ext4j.client.core.JsObject::getJsObj()();
		return obj.toArray();
    }-*/;

    private native JavaScriptObject create(String version)/*-{
		return new $wnd.Ext.Version(version);
    }-*/;

    private native JavaScriptObject create(double version)/*-{
		return new $wnd.Ext.Version(version);
    }-*/;

}
