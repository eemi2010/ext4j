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
package com.ait.ext4j.client.core.config;

/**
 * Class to enumerate all the Ext4j xtype fields.
 */
public enum XType {
    BOX("box"), BUTTON("button"), BUTTON_GROUP("buttongroup"), CHART("chart"), COMPONENT("component"), CONTAINER(
                    "container"), CYCLE("cycle"), COLOR_PICKER("colorpicker"), DRAW("draw"), HEADER("header"), HEADER_CONTAINER(
                    "headercontainer"), SPLIT_BUTTON("splitbutton"), TIP("tip"), TEXT("text"), TOOLBAR("toolbar"), TOOLBAR_FILL(
                    "tbfill"), TOOLBAR_SEPARATOR("tbseparator"), TOOLTIP("tooltip"), TOOL("tool"), FIELD("field"), FLASH(
                    "flash"), MENU("menu"), COLOR_MENU("colormenu"), DATE_MENU("datemenu"), MENU_ITEM("menuitem"), MENU_CHECK_ITEM(
                    "menucheckitem"), MENU_SEPARATOR("menuseparator"), PANEL("panel"), TABLE("tablepanel"), GRIDVIEW(
                    "gridview"), VIEWPORT("viewport"), GRID_PANEL("gridpanel"), PROPERTY_GRID("propertygrid"), ACTION_COLUMN(
                    "actioncolumn"), BOOLEAN_COLUM("booleancolumn"), TEMPLATE_COLUMN("templatecolumn"), NUMBER_COLUM(
                    "numbercolumn"), DATE_COLUMN("datecolumn"), DATEPICKER("datepicker"), ROW_NUMEBERER_COLUMN(
                    "rownumberer"), TEXTFIELD("textfield"), TIMEPICKER("timepicker"), TABPANEL("tabpanel"), TAB_BAR(
                    "tabbar"), CHECK_COLUMN("checkcolumn"), CHECK_BOX("checkbox"), TAB("tab"), MULTI_SLIDER(
                    "multislider"), SLIDER("slider"), WINDOW("window"), VIEW("view"), DATAVIEW("dataview"), GMAP_PANEL(
                    "gmappanel"), TABLE_VIEW("tableview"), TREE_PANEL("treepanel"), TREE_VIEW("treeview");
    private String value;

    private XType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
