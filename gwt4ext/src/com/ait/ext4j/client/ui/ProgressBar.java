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

import com.ait.ext4j.client.core.Component;
import com.ait.ext4j.client.core.config.WaitConfig;
import com.ait.ext4j.client.events.HandlerRegistration;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * An updateable progress bar component. The progress bar supports two different
 * modes: manual and automatic.
 * <p>
 * In manual mode, you are responsible for showing, updating (via
 * updateProgress) and clearing the progress bar as needed from your own code.
 * This method is most appropriate when you want to show progress throughout an
 * operation that has predictable points of interest at which you can update the
 * control.
 * <p>
 * In automatic mode, you simply call wait and let the progress bar run
 * indefinitely, only clearing it once the operation is complete. You can
 * optionally have the progress bar wait for a specific amount of time and then
 * clear itself. Automatic mode is most appropriate for timed operations or
 * asynchronous operations in which you have no need for indicating intermediate
 * progress.
 * 
 * 
 */
public class ProgressBar extends Component {

    private static JavaScriptObject configPrototype;

    private native void init()/*-{
		var c = new $wnd.Ext.ProgressBar();
		@com.ait.ext4j.client.ui.ProgressBar::configPrototype = c.initialConfig;
    }-*/;

    protected JavaScriptObject getConfigPrototype() {
        return configPrototype;
    }

    public String getXType() {
        return "progressbar";
    }

    /**
     * Create a new NotificationContainer.
     */
    public ProgressBar() {
        // init();
    }

    public ProgressBar(JavaScriptObject object) {
        super(object);
        // init();
    }

    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.ProgressBar(config);
    }-*/;

    /**
     * Returns true if the progress bar is currently in a wait operation
     * 
     * @return
     */
    public native boolean isWaiting() /*-{
		var progressBar = this.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()();
		return progressBar.isWaiting();
    }-*/;

    /**
     * Resets the progress bar value to 0 and text to empty string. If hide =
     * true, the progress bar will also be hidden (using the hideMode property
     * internally).
     * 
     * @return
     */
    public native ProgressBar reset() /*-{
		var progressBar = this.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()();
		progressBar.reset();
		return this;
    }-*/;

    /**
     * Resets the progress bar value to 0 and text to empty string. If hide =
     * true, the progress bar will also be hidden (using the hideMode property
     * internally).
     * 
     * @return
     */
    public native ProgressBar reset(boolean hide) /*-{
		var progressBar = this.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()();
		progressBar.reset(hide);
		return this;
    }-*/;

    /**
     * Updates the progress bar text. If specified, textEl will be updated,
     * otherwise the progress bar itself will display the updated text.
     * 
     * @param text
     */
    public native ProgressBar updateText(String text) /*-{
		var progressBar = this.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()();
		progressBar.updateText(text);
		return this;
    }-*/;

    /**
     * Updates the progress bar text. If specified, textEl will be updated,
     * otherwise the progress bar itself will display the updated text.
     */
    public native ProgressBar updateText() /*-{
		var progressBar = this.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()();
		progressBar.updateText();
		return this;
    }-*/;

    /**
     * Updates the progress bar value, and optionally its text. If the text
     * argument is not specified, any existing text value will be unchanged. To
     * blank out existing text, pass ''. Note that even if the progress bar
     * value exceeds 1, it will never automatically reset -- you are responsible
     * for determining when the progress is complete and calling reset to clear
     * and/or hide the control.
     */
    public native ProgressBar updateProgress() /*-{
		var progressBar = this.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()();
		progressBar.updateProgress();
		return this;
    }-*/;

    /**
     * Updates the progress bar value, and optionally its text. If the text
     * argument is not specified, any existing text value will be unchanged. To
     * blank out existing text, pass ''. Note that even if the progress bar
     * value exceeds 1, it will never automatically reset -- you are responsible
     * for determining when the progress is complete and calling reset to clear
     * and/or hide the control.
     */
    public native ProgressBar updateProgress(double value) /*-{
		var progressBar = this.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()();
		progressBar.updateProgress(value);
		return this;
    }-*/;

    /**
     * Updates the progress bar value, and optionally its text. If the text
     * argument is not specified, any existing text value will be unchanged. To
     * blank out existing text, pass ''. Note that even if the progress bar
     * value exceeds 1, it will never automatically reset -- you are responsible
     * for determining when the progress is complete and calling reset to clear
     * and/or hide the control.
     */
    public native ProgressBar updateProgress(double value, String text) /*-{
		var progressBar = this.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()();
		progressBar.updateProgress(value, text);
		return this;
    }-*/;

    /**
     * Updates the progress bar value, and optionally its text. If the text
     * argument is not specified, any existing text value will be unchanged. To
     * blank out existing text, pass ''. Note that even if the progress bar
     * value exceeds 1, it will never automatically reset -- you are responsible
     * for determining when the progress is complete and calling reset to clear
     * and/or hide the control.
     */
    public native ProgressBar updateProgress(double value, String text, boolean animate) /*-{
		var progressBar = this.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()();
		progressBar.updateProgress(value, text, animate);
		return this;
    }-*/;

    /**
     * Initiates an auto-updating progress bar. A duration can be specified, in
     * which case the progress bar will automatically reset after a fixed amount
     * of time and optionally call a callback function if specified. If no
     * duration is passed in, then the progress bar will run indefinitely and
     * must be manually cleared by calling reset.
     */
    public native void run() /*-{
		var progressBar = this.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()();
		progressBar.wait();
    }-*/;

    /**
     * Initiates an auto-updating progress bar. A duration can be specified, in
     * which case the progress bar will automatically reset after a fixed amount
     * of time and optionally call a callback function if specified. If no
     * duration is passed in, then the progress bar will run indefinitely and
     * must be manually cleared by calling reset.
     * 
     * @param config
     */
    public void run(WaitConfig config) {
        run(config.getJsObj());
    }

    /**
     * Fires after each update interval
     * 
     * @param handler
     *            , the handler to be executed when this event occurs
     */
    public native HandlerRegistration addUpdateHandler(com.ait.ext4j.client.events.progressbar.UpdateHandler handler)/*-{
		var component = this.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(p, value, text, e) {
			var pgr = @com.ait.ext4j.client.ui.ProgressBar::new(Lcom/google/gwt/core/client/JavaScriptObject;)(p);
			var event = @com.ait.ext4j.client.events.progressbar.UpdateEvent::new(Lcom/ait/ext4j/client/ui/ProgressBar;DLjava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(pgr,value,text,e);
			handler.@com.ait.ext4j.client.events.progressbar.UpdateHandler::onUpdate(Lcom/ait/ext4j/client/events/progressbar/UpdateEvent;)(event);
		};
		var eventName = @com.ait.ext4j.client.events.progressbar.UpdateEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ait.ext4j.client.events.HandlerRegistration::new(Lcom/ait/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * // * Created a new {@link ProgressBar} from a given component
     */
    public static ProgressBar cast(Component component) {
        return new ProgressBar(component.getOrCreateJsObj());
    }

    private native void run(JavaScriptObject config) /*-{
		var progressBar = this.@com.ait.ext4j.client.core.Component::getOrCreateJsObj()();
		progressBar.wait(config);
    }-*/;

}
