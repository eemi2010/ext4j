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

import com.eemi.ext4j.client.core.config.XType;
import com.eemi.ext4j.client.draw.Sprite;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;

/**
 * This class encapsulates a drawn text item as rendered by the Ext.draw package
 * within a Component which can be then used anywhere in an ExtJS application
 * just like any other Component.
 * 
 */
public class Text extends DrawComponent {

    private static JavaScriptObject configPrototype;

    private native void init()/*-{
		var c = new $wnd.Ext.draw.Text({
			enginePriority : [ "Svg", "Vml" ]
		});
		@com.eemi.ext4j.client.ui.DrawComponent::configPrototype = c.initialConfig;
    }-*/;

    protected JavaScriptObject getConfigPrototype() {
        return configPrototype;
    }

    public String getXType() {
        return XType.TEXT.getValue();
    }

    /**
     * Create a new NotificationContainer.
     */
    public Text() {
        init();
        createSurface();
    }

    protected Text(JavaScriptObject jsObj) {
        super(jsObj);
    }

    /**
     * Applys the NotificationContainer to an existing element.
     * 
     * @param element
     *            the element
     */
    public Text(Element element) {
        super(element);
    }

    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		config.enginePriority = [ "Svg", "Vml" ];
		return new $wnd.Ext.draw.Text(config);
    }-*/;

    /**
     * Updates this item's text.
     * 
     * @param value
     */
    public native void setText(String value)/*-{
		var text = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		text.setText(value);
    }-*/;

    public Sprite add(Sprite sprite) {
        return getSurface().add(sprite);
    }

    /**
     * The angle by which to initially rotate the text clockwise. Defaults to
     * zero.
     */
    public void setDegress(double value) {
        setAttribute("degrees", value, true);
    }

    /**
     * A CSS selector string which matches a style rule in the document
     * stylesheet from which the text's font properties are read.
     * <p>
     * Drawn text is not styled by CSS, but by properties set during its
     * construction, so these styles must be programatically read from a
     * stylesheet rule found via a selector at construction time.
     */
    public void setStyleSelector(String value) {
        setAttribute("styleSelector", value, true);
    }

    /**
     * Sets the clockwise rotation angle relative to the horizontal axis.
     * 
     * @param value
     *            ,The clockwise angle (in degrees) from the horizontal axis by
     *            which the text should be rotated.
     */
    public native void setAngle(double value)/*-{
		var text = this.@com.eemi.ext4j.client.core.Component::getOrCreateJsObj()();
		text.setAngle(value);
    }-*/;

}
