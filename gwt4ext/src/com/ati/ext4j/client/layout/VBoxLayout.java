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
 * A layout that arranges items vertically down a Container. This layout
 * optionally divides available vertical space between child items containing a
 * numeric flex configuration. The flex option is a ratio that distributes
 * height after any items with explicit heights have been accounted for. In the
 * code below, the height is calculated as follows:
 * 
 * The fixed height item is subtracted, leaving us with 300 height The total
 * flex number is counted, in this case, it is 3 The ratio is then calculated,
 * 300 / 3 = 100 The first item has a flex of 2, so it is set to 2 * 100 The
 * other remaining item is set to 1 * 100
 */
public class VBoxLayout extends BoxLayout {

    public VBoxLayout() {

    }

    public VBoxLayout(Pack pack) {
        setPack(pack);
    }

    public VBoxLayout(Pack pack, Align align) {
        this(pack);
        setAlign(align);
    }

    public VBoxLayout(Align align) {
        setAlign(align);
    }

    protected VBoxLayout(JavaScriptObject obj) {
        jsObj = obj;
    }

    @Override
    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return {
			type : 'vbox'
		};
    }-*/;

    @Override
    protected native void create() /*-{
		var jso = {
			type : 'vbox'
		};
		this.@com.ati.ext4j.client.layout.ContainerLayout::jsObj = jso;
    }-*/;

    public static VBoxLayout cast(ContainerLayout layout) {
        return new VBoxLayout(layout.getJsObj());
    }

}
