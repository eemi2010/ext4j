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
package com.eemi.ext4j.client.core;

import java.util.Random;

import com.eemi.ext4j.client.ui.BoxComponent;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * Adapter between GWT {@link com.google.gwt.user.client.ui.Widget}'s and
 * {@link Component}'s.
 * 
 */
public class WidgetComponent extends BoxComponent {

    public static final String hiddenDivID = "_ext4j_hidden";
    private Widget w;
    private String componentId;

    private native void init()/*-{
		var widget = this.@com.eemi.ext4j.client.core.WidgetComponent::w;
		var divID = this.@com.eemi.ext4j.client.core.WidgetComponent::componentId;
		$wnd.Ext
				.define(
						'Ext.ux.WidgetComponent',
						{
							extend : 'Ext.Component',
							xtype : 'widgetComponent',
							widget : null,
							constructor : function(config) {
								var me = this;
								me.callParent(config);
							},
							listeners : {
								render : function(component) {

								},
								afterRender : function(component) {
									//var widget = @com.eemi.ext4j.client.core.WidgetComponent::get()();
									//alert(this.widget);
									//a GWT widget must be attached to a GWT NotificationContainer for its events to fire.
									var attached = widget.@com.google.gwt.user.client.ui.Widget::isAttached()();
									var rp;
									if (!attached) {
										rp = @com.google.gwt.user.client.ui.RootPanel::get(Ljava/lang/String;)(divID);
										if (rp) {
											rp.@com.google.gwt.user.client.ui.HasWidgets::add(Lcom/google/gwt/user/client/ui/Widget;)(widget);
										}

									}
									var widgetEl = widget.@com.google.gwt.user.client.ui.UIObject::getElement()();
									this.el = $wnd.Ext.get(widgetEl);
									this.el.setVisible(true);
									//this.ownerCt.getEl().insertBefore(widgetEl);

									//container.dom.insertBefore(widgetEl, position);
									//delete this.widget;
								}
							}
						});
    }-*/;

    public WidgetComponent(Widget widget) {
        this.componentId = hiddenDivID + "_" + generateId();
        this.w = widget;
        init();
        createHiddenDiv();
        setId(DomUtil.getID(widget));
        addListener("beforedestroy", new Function() {
            public void execute() {
                Widget widget = (Widget) JsoHelper.getAttributeAsObject(config, "widget");
                if (DOM.getParent(widget.getElement()) != null) {
                    widget.removeFromParent();
                }
            }
        });

    }

    private void createHiddenDiv() {
        ExtElement hiddenDiv = Ext.get(this.componentId);
        if (hiddenDiv == null) {
            DomConfig domConfig = new DomConfig("div", this.componentId, null);
            domConfig.setStyle("display:none;");
            DomHelper.append(RootPanel.getBodyElement(), domConfig);
        }
    }

    public WidgetComponent(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public void setWidget(Widget widget) {
        // Window.alert("????");
        // JsoHelper.setAttribute(config, "widget", widget);
        // push(widget);
    }

    public native void _setWidget(Widget w)/*-{
		var jso = this.@com.eemi.ext4j.client.core.WidgetComponent::getOrCreateJsObj()();
		var id = jso.id;
    }-*/;

    public native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.ux.WidgetComponent(config);
    }-*/;

    public String getXType() {
        return "widgetComponent";
    }

    /**
     * Generate and randon id
     * 
     * @return the string
     */
    private static String generateId() {
        Random random = new Random();
        return Long.toString(Math.abs(random.nextLong()), 10);
    }
}
