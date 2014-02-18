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
package com.ati.ext4j.client.layout;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * 
 * <p>
 * This is a layout that enables anchoring of contained elements relative to the
 * container's dimensions. If the container is resized, all anchored items are
 * automatically rerendered according to their anchor rules.
 * </p>
 * 
 * <p>
 * CenterLayout does not have any direct config options (other than inherited
 * ones). However, the container using the CenterLayout can supply an
 * anchoring-specific config property of <b>anchorSize</b>. By default,
 * CenterLayout will calculate anchor measurements based on the size of the
 * container itself. However, if anchorSize is specifed, the layout will use it
 * as a virtual container for the purposes of calculating anchor measurements
 * based on it instead, allowing the container to be sized independently of the
 * anchoring logic if necessary.
 * </p>
 * 
 * <p>
 * The items added to an CenterLayout can also supply an anchoring-specific
 * config property of <b>anchor</b> which is a string containing two values: the
 * horizontal anchor value and the vertical anchor value (for example, '100%
 * 50%'). This value is what tells the layout how the item should be anchored to
 * the container. The following types of anchor values are supported:
 * </p>
 * <ul>
 * <li><b>Percentage</b>: Any value between 1 and 100, expressed as a
 * percentage. The first anchor is the percentage width that the item should
 * take up within the container, and the second is the percentage height.
 * Example: '100% 50%' would render an item the complete width of the container
 * and 1/2 its height. If only one anchor value is supplied it is assumed to be
 * the width value and the height will default to auto.</li>
 * <li><b>Offsets</b>: Any positive or negative integer value. The first anchor
 * is the offset from the right edge of the container, and the second is the
 * offset from the bottom edge. Example: '-50 -100' would render an item the
 * complete width of the container minus 50 pixels and the complete height minus
 * 100 pixels. If only one anchor value is supplied it is assumed to be the
 * right offset value and the bottom offset will default to 0.</li>
 * <li><b>Sides</b>: Valid values are 'right' (or 'r') and 'bottom' (or 'b').
 * Either the container must have a fixed size or an anchorSize config value
 * defined at render time in order for these to have any effect.</li>
 * </ul>
 * <p>
 * Anchor values can also be mixed as needed. For example, '-50 75%' would
 * render the width offset from the container right edge by 50 pixels and 75% of
 * the container's height.
 * </p>
 * 
 * @see AnchorLayoutData
 */
public class AnchorLayout extends ContainerLayout {

    private int width = -1;
    private int height = -1;

    public AnchorLayout() {

    }

    protected AnchorLayout(JavaScriptObject obj) {
        super(obj);
    }

    @Override
    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return {
			type : 'anchor'
		};
		this.@com.ati.ext4j.client.layout.ContainerLayout::jsObj = jso;
		return this.@com.ati.ext4j.client.layout.ContainerLayout::jsObj;
    }-*/;

    public native JavaScriptObject getContainerAttributes() /*-{
		if (this.@com.ati.ext4j.client.layout.AnchorLayout::width != -1) {
			return {
				anchorSize : {
					width : this.@com.ati.ext4j.client.layout.AnchorLayout::width,
					height : this.@com.ati.ext4j.client.layout.AnchorLayout::height
				}
			};
		} else {
			return {};
		}
    }-*/;

    @Override
    protected native void create() /*-{
		var jso = {
			type : 'anchor'
		};
		this.@com.ati.ext4j.client.layout.ContainerLayout::jsObj = jso;
    }-*/;

    public static AnchorLayout cast(ContainerLayout layout) {
        return new AnchorLayout(layout.getJsObj());
    }

}
