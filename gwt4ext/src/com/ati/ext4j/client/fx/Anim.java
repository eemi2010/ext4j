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

import com.ati.ext4j.client.core.Component;
import com.ati.ext4j.client.core.Function;
import com.ati.ext4j.client.core.JsObject;
import com.ati.ext4j.client.core.JsoHelper;
import com.ati.ext4j.client.fx.easing.Easing;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * This class manages animation for a specific target. The animation allows
 * animation of various properties on the target, such as size, position, color
 * and others.
 * <p>
 * This animation is not create until you call the <code>run</code> method.
 * 
 */
public class Anim extends JsObject {

    protected JavaScriptObject config;
    private Component target;
    private AnimConfig to;

    public Anim() {
        config = JsoHelper.createObject();
    }

    public Anim(Component target) {
        this();
        setTarget(target);
    }

    public Anim(String target) {
        this();
        setTarget(target);
    }

    /**
     * An object containing property/value pairs for the end of the animation.
     */
    public void setTo(AnimConfig value) {
        this.to = value;
        JsoHelper.setAttribute(config, "to", value.getJsObj());
    }

    /**
     * Used in conjunction with iterations to reverse the animation each time an
     * iteration completes.
     * <p>
     * Defaults to: false
     */
    public void setAlternate(boolean value) {
        JsoHelper.setAttribute(config, "alternate", value);
    }

    /**
     * 
     A function to be run after the animation has completed.
     */
    public native void setCallback(Function callback)/*-{
		var c = this.@com.ati.ext4j.client.fx.Anim::config;
		c.callback = function() {
			callback.@com.ati.ext4j.client.core.Function::execute()();
		};
    }-*/;

    /**
     * Time to delay before starting the animation.
     * <p>
     * Defaults to: 0
     */
    public void setDelay(double value) {
        JsoHelper.setAttribute(config, "delay", value);
    }

    /**
     * Time in milliseconds for a single animation to last. If the iterations
     * property is specified, then each animate will take the same duration for
     * each iteration.
     * <p>
     * Defaults to: 250
     */
    public void setDuration(double value) {
        JsoHelper.setAttribute(config, "duration", value);
    }

    /**
     * Currently only for Component Animation: Only set a component's outer
     * element size bypassing layouts. Set to true to do full layouts for every
     * frame of the animation.
     * <p>
     * Defaults to: false
     */
    public void setDynamic(boolean value) {
        JsoHelper.setAttribute(config, "dynamic", value);
    }

    /**
     * This describes how the intermediate values used during a transition will
     * be calculated. It allows for a transition to change speed over its
     * duration.
     */
    public void setEasing(Easing value) {
        JsoHelper.setAttribute(config, "dynamic", value.getValue());
    }

    /**
     * An object containing property/value pairs for the beginning of the
     * animation. If not specified, the current state of the Ext.fx.target will
     * be used.
     */
    public void setFrom(AnimConfig value) {
        JsoHelper.setAttribute(config, "from", value.getJsObj());
    }

    /**
     * Number of times to execute the animation.
     * <p>
     * Defaults to: 1
     */
    public void setIterations(double value) {
        JsoHelper.setAttribute(config, "iterations", value);
    }

    /**
     * Animation keyframes follow the CSS3 Animation configuration pattern.
     * 'from' is always considered '0%' and 'to' is considered '100%'. Every
     * keyframe declaration must have a keyframe rule for 0% and 100%, possibly
     * defined using "from" or "to". A keyframe declaration without these
     * keyframe selectors is invalid and will not be available for animation.
     * The keyframe declaration for a keyframe rule consists of properties and
     * values. Properties that are unable to be animated are ignored in these
     * rules, with the exception of 'easing' which can be changed at each
     * keyframe.
     */
    public void setKeyFrames(AnimConfig value) {
        JsoHelper.setAttribute(config, "keyframes", value.getJsObj());
    }

    /**
     * Run the animation from the end to the beginning Defaults to false.
     * <p>
     * Defaults to: false
     */
    public void setReverse(boolean value) {
        JsoHelper.setAttribute(config, "reverse", value);
    }

    public double getCurrentIteration() {
        if (jsObj == null) {
            throw new IllegalStateException("Can not get currentIteration. Did you can run() on this Anim Config ? ");

        }
        return JsoHelper.getAttributeAsFloat(jsObj, "currentIteration");
    }

    public boolean isAnimation() {
        if (jsObj == null) {
            throw new IllegalStateException("Can not get currentIteration. Did you can run() on this Anim Config ? ");

        }
        return JsoHelper.getAttributeAsBoolean(jsObj, "isAnimation");
    }

    public boolean isPaused() {
        if (jsObj == null) {
            throw new IllegalStateException("Can not get currentIteration. Did you can run() on this Anim Config ? ");

        }
        return JsoHelper.getAttributeAsBoolean(jsObj, "paused");
    }

    public boolean isRunning() {
        if (jsObj == null) {
            throw new IllegalStateException("Can not get currentIteration. Did you can run() on this Anim Config ? ");

        }
        return JsoHelper.getAttributeAsBoolean(jsObj, "running");
    }

    /**
     * true to remove the target when the animation is complete, using the
     * appropriate removal method for the target. For example, a component will
     * be destroyed, elements will be removed.
     */
    public void setRemove(boolean value) {
        JsoHelper.setAttribute(config, "remove", value);
    }

    /**
     * The element to apply the animation to.
     */
    public void setTarget(String elementId) {
        JsoHelper.setAttribute(config, "target", elementId);
    }

    /**
     * The element to apply the animation to.
     */
    public void setTarget(Component target) {
        this.target = target;
        JsoHelper.setAttribute(config, "target", target.getOrCreateJsObj());
    }

    /**
     * runs the animation
     */
    public void run() {
        if (to == null) {
            throw new IllegalStateException(
                            "Can no run animation. Did you forget to call setTo(AnimConfig config) on this Anim instance  ? ");
        }
        if (target == null) {
            throw new IllegalStateException(
                            "Can no run animation. Did you forget to call setTarget(Component target) on this Anim instance  ? ");
        }
        jsObj = createPeer(config);
    }

    private native JavaScriptObject createPeer(JavaScriptObject config)/*-{
		return new $wnd.Ext.fx.Anim(config);
    }-*/;

}
