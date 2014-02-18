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
package com.ati.ext4j.client.fx;

import com.ati.ext4j.client.core.Function;
import com.ati.ext4j.client.core.JsoHelper;
import com.ati.ext4j.client.core.config.BaseConfig;
import com.ati.ext4j.client.fx.easing.Easing;

/**
 * {@link com.ati.ext4j.client.fx.Fx} configuration options.
 */
public class FxConfig extends BaseConfig {

    /**
     * Construct a new instance.
     */
    public FxConfig() {
    }

    /**
     * Construct a new instance.
     * 
     * @param duration
     *            the length of time (in seconds) that the effect should last
     */
    public FxConfig(int duration) {
        JsoHelper.setAttribute(jsObj, "duration", duration);
    }

    /**
     * A css class to apply after the effect.
     * 
     * @param afterCls
     *            the CSS class
     */
    public void setAfterCls(String afterCls) {
        JsoHelper.setAttribute(jsObj, "afterCls", afterCls);
    }

    /**
     * A style specification string, e.g. "width:100px" that will be applied to
     * the Element after the effect finishes.
     * 
     * @param afterStyle
     *            css style
     */
    public void setAfterStyle(String afterStyle) {
        JsoHelper.setAttribute(jsObj, "afterStyle", afterStyle);
    }

    /**
     * A style specification that will be applied to the Element after the
     * effect finishes.
     * 
     * @param afterStyle
     *            css styles
     */
    public void setAfterStyle(BaseConfig afterStyle) {
        JsoHelper.setAttribute(jsObj, "afterStyle", afterStyle.getJsObj());
    }

    /**
     * A style specification function which returns such a specification that
     * will be applied to the Element after the effect finishes.
     * 
     * @param fn
     *            the style specification function
     */
    public native void setAfterStyle(Function fn) /*-{
		var config = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		config['afterStyle'] = function() {
			fn.@com.ati.ext4j.client.core.Function::execute()();
		};
    }-*/;

    /**
     * Whether to allow subsequently-queued effects to run at the same time as
     * the current effect, or to ensure that they run in sequence.
     * 
     * @param concurrent
     *            true for concurrent
     */
    public void setConcurrent(boolean concurrent) {
        JsoHelper.setAttribute(jsObj, "concurrent", concurrent);
    }

    /**
     * A function called when the effect is finished.
     * 
     * @param callback
     *            the callback function
     */
    public native void setCallback(Function callback) /*-{
		var config = this.@com.ati.ext4j.client.core.JsObject::getJsObj()();
		config['callback'] = function() {
			callback.@com.ati.ext4j.client.core.Function::execute()();
		};
    }-*/;

    /**
     * The end opacity after the effect completed.
     * 
     * @param endOpacity
     *            the end opacity (0 - 1)
     */
    public void setEndOpacity(float endOpacity) {
        JsoHelper.setAttribute(jsObj, "endOpacity", endOpacity);
    }

    /**
     * The length of time (in seconds) that the effect should last.
     * 
     * @param duration
     *            the duration in seconds
     */
    public void setDuration(float duration) {
        JsoHelper.setAttribute(jsObj, "duration", duration);
    }

    /**
     * An Easing value for the effect.
     * 
     * @param easing
     *            easing method
     */
    public void setEasing(Easing easing) {
        JsoHelper.setAttribute(jsObj, "easing", easing.getValue());
    }

    /**
     * Whether the Element should be removed from the DOM and destroyed after
     * the effect finishes.
     * 
     * @param remove
     *            true to remove
     */
    public void setRemove(boolean remove) {
        JsoHelper.setAttribute(jsObj, "remove", remove);
    }

    /**
     * Whether subsequent effects should be stopped and removed after the
     * current effect finishes.
     * 
     * @param stopFx
     *            true to stop subsequent effects
     */
    public void setStopFx(boolean stopFx) {
        JsoHelper.setAttribute(jsObj, "stopFx", stopFx);
    }

    /**
     * Whether to use the display CSS property instead of visibility when hiding
     * Elements (only applies to effects that end with the element being
     * visually hidden, ignored otherwise)
     * 
     * @param useDisplay
     *            true to use display
     */
    public void setUseDisplay(boolean useDisplay) {
        JsoHelper.setAttribute(jsObj, "useDisplay", useDisplay);
    }
}
