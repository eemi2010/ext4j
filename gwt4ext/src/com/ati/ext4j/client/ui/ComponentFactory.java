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
package com.ati.ext4j.client.ui;

import java.util.ArrayList;
import java.util.List;

import com.ati.ext4j.client.core.Component;
import com.ati.ext4j.client.core.JsoHelper;
import com.ati.ext4j.client.core.SimpleComponent;
import com.ati.ext4j.client.core.config.XType;
import com.ati.ext4j.client.draw.Sprite;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * Component factory class.
 */
// TODO
// Finish this class
public class ComponentFactory {

    /**
     * Return a Component from the passed native component object.
     * 
     * @param jsObj
     *            native object
     * @return the corresponding Component.
     * @see com.ati.ext4j.client.core.Component
     */
    public static Component getComponent(JavaScriptObject jsObj) {
        Object componentJ = JsoHelper.getAttributeAsObject(jsObj, "__compJ");
        if (componentJ != null) {
            return (Component) componentJ;
        }
        String xtype = getXType(jsObj);

        if (xtype == null) {
            return null;
        }
        if (xtype.equalsIgnoreCase(XType.BOX.getValue())) {
            return new BoxComponent(jsObj);
        } else if (xtype.equalsIgnoreCase(XType.BUTTON.getValue())) {
            return Button.instance(jsObj);
        } else if (xtype.equalsIgnoreCase("datepicker")) {
            return new DatePicker(jsObj);
        }
        // } else if (xtype.equalsIgnoreCase("editor")) {
        // return new Editor(jsObj);
        // } else if (xtype.equalsIgnoreCase("editorgrid")) {
        // return new EditorGridPanel(jsObj);
        // } else if (xtype.equalsIgnoreCase("propertygrid")) {
        // return new PropertyGridPanel(jsObj);
        // } else if (xtype.equalsIgnoreCase("grid")) {
        // return new GridPanel(jsObj);
        // } else if (xtype.equalsIgnoreCase("paging")) {
        // return new PagingToolbar(jsObj);
        // } else if (xtype.equalsIgnoreCase("button")) {
        // return new Button(jsObj);
        // }
        else if (xtype.equalsIgnoreCase("panel")) {
            return new Panel(jsObj);
        }
        // else if (xtype.equalsIgnoreCase("progress")) {
        // return new ProgressBar(jsObj);
        // } else if (xtype.equalsIgnoreCase("splitbutton")) {
        // return new SplitButton(jsObj);
        // } else if (xtype.equalsIgnoreCase("tabpanel")) {
        // return new TabPanel(jsObj);
        // } else if (xtype.equalsIgnoreCase("window")) {
        // return new Window(jsObj);
        // } else if(xtype.equalsIgnoreCase("gwtwidget")) {
        // return new WidgetComponent(jsObj);
        // }
        // //toolbar components - tbitem, tbseparator, tbspacer, tbfill, tbtext,
        // tbsplit?
        // else if (xtype.equalsIgnoreCase("toolbar")) {
        // return new Toolbar(jsObj);
        // } else if (xtype.equalsIgnoreCase("tbbutton")) {
        // return new ToolbarButton(jsObj);
        // }
        // //menu items
        // else if (xtype.equalsIgnoreCase("menu-item")) {
        // return new Item(jsObj);
        // }
        // //form components
        // else if (xtype.equalsIgnoreCase("checkbox")) {
        // return new CheckBox(jsObj);
        // } else if (xtype.equalsIgnoreCase("combo")) {
        // return new ComboBox(jsObj);
        // } else if (xtype.equalsIgnoreCase("label")) {
        // return new Label(jsObj);
        // } else if (xtype.equalsIgnoreCase("datefield")) {
        // return new DateField(jsObj);
        // } else if (xtype.equalsIgnoreCase("fieldset")) {
        // return new FieldSet(jsObj);
        // } else if (xtype.equalsIgnoreCase("form")) {
        // return new FormPanel(jsObj);
        // } else if (xtype.equalsIgnoreCase("hidden")) {
        // return new Hidden(jsObj);
        // } else if (xtype.equalsIgnoreCase("htmleditor")) {
        // return new HtmlEditor(jsObj);
        // } else if (xtype.equalsIgnoreCase("numberfield")) {
        // return new NumberField(jsObj);
        // } else if (xtype.equalsIgnoreCase("radio")) {
        // return new Radio(jsObj);
        // } else if (xtype.equalsIgnoreCase("textarea")) {
        // return new TextArea(jsObj);
        // } else if (xtype.equalsIgnoreCase("textfield")) {
        // return new TextField(jsObj);
        // } else if (xtype.equalsIgnoreCase("timefield")) {
        // return new TimeField(jsObj);
        // } else {
        // throw new IllegalArgumentException("Unrecognized xtype " + xtype);
        // }

        return null;
    }

    private static native String getXType(JavaScriptObject jsObj) /*-{
		var xtype = jsObj.getXType ? jsObj.getXType() : null;
		return xtype === undefined ? null : xtype;
    }-*/;

    public static List<Component> fromJsArray(JavaScriptObject obj) {
        List<Component> toReturn = new ArrayList<Component>();
        int size = JsoHelper.getJavaScriptObjectArraySize(obj);
        for (int i = 0; i < size; i++) {
            SimpleComponent c = SimpleComponent.createComponent(JsoHelper.getElementValueFromJavaScriptObjectArray(obj,
                            i));
            toReturn.add(c);
        }
        return toReturn;
    }

    public static JavaScriptObject fromArray(Component[] components) {
        JavaScriptObject array = JsoHelper.createJavaScriptArray();
        for (int i = 0; i < components.length; i++) {
            JavaScriptObject c = components[i].getOrCreateJsObj();
            JsoHelper.setArrayValue(array, i, c);
        }
        return array;
    }

    public static JavaScriptObject fromArrayOfSprite(Sprite[] components) {
        JavaScriptObject array = JsoHelper.createJavaScriptArray();
        for (int i = 0; i < components.length; i++) {
            JavaScriptObject c = components[i].getJsObj();
            JsoHelper.setArrayValue(array, i, c);
        }
        return array;
    }

    public static Component cast(Component component) {
        return getComponent(component.getOrCreateJsObj());
    }

    static native void ensureXType(String thisXtype, String componentId)/*-{
		var cmp = $wnd.Ext.getCmp(componentId);

		if (!cmp) {
			throw new Error("Ext4j Could not find component with the id :  "
					+ componentId);
		}

		if (cmp.xtype != thisXtype) {
			throw new Error(
					"You are trying to wrap a component with an incompatible xtye : "
							+ cmp.xtype
							+ ". You can only wrap components with the xtype "
							+ thisXtype + " with this component");
		}
    }-*/;

}
