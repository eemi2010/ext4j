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
 * Widget attributes.
 */
public enum Attribute {
    ACCELERATE_ON_TAP_HOLD("accelerateOnTapHold"), ACTIVE_ITEM("activeItem"), ALIGN("align"), AUTO_CAPITALIZATION(
                    "autoCapitalize"), AUTO_COMPLETE("autoComplete"), AUTO_CORRECT("autoCorrect"), AUTO_DESTROY(
                    "autoDestrooy"), BADGE_TEXT("badgeText"), BASE_CLS("baseCls"), BORDER("border"), BOTTOM("bottom"), BUFFER_RESIZE(
                    "bufferResize"), BUTTONS("buttons"), CENTER("center"), CENTERED("centered"), CHECKED("checked"), CHILDREN(
                    "children"), CLICK_TO_EDIT("clicksToEdit"), CLEAR_ICON("clearIcon"), CLOSABLE("closable"), CLS(
                    "cls"), COMP_J("__compJ"), COPY("copy"), CORDOVA("cordova"), CYCLE("cycle"), COMPONENT_CLS(
                    "componentCls"), DATA("data"), DATAINDEX("dataIndex"), DEFAULT_TEXT_HEIGHT("defaultTextHeight"), DEFAULT_TYPE(
                    "defaultType"), DD_GROUP("ddGroup"), DROP_GROUP("dropGroup"), ENABLE_DRAG("enableDrag"), ENABLE_DROP(
                    "enableDrop"), PLUGIN_ID("pluginId"), DRAG_TEXT("dragText"), DEFAULTS("defaults"), DEFER_EMPTY_TEXT(
                    "deferEmptyText"), DESTROY_PICKER_ON_HIDE("destroyPickerOnHide"), DIRECTION("direction"), DISABLED(
                    "disabled"), DISABLED_CLS("disabledCls"), DISPLAY_FIELD("displayField"), DOCKED("docked"), DOWN(
                    "down"), DRAGGABLE("draggable"), DROPPABLE("droppable"), EDITOR("editor"), ENTER("enter"), EXIT(
                    "exit"), STRETCH_X("stretchX"), STRETCH_Y("stretchY"), EMPTY_TEXT("emptyText"), ENABLE_TOGGLE(
                    "enableToggle"), FILTER("filter"), FLEX("flex"), FLOATING("floating"), FULL_SCREEN("fullscreen"), GRID_HEADER(
                    "header"), GAUGE("gauge"), HEIGHT("height"), HIDDEN("hidden"), HIDE_BORDERS("hideBorders"), HIDDEN_NAME(
                    "hiddenName"), HIDE_ON_MASK_TAP("hideOnMaskTap"), HTML("html"), ICON("icon"), ICON_CLS("iconCls"), ID(
                    "id"), INCREMENT("increment"), INDICATOR("indicator"), INPUT("input"), INSTRUCTIONS("instructions"), ITEM_TPL(
                    "itemTpl"), ITEMS("items"), LABEL_ALIGN("labelAlign"), LABEL_CLS("labelCls"), LABEL_WIDTH(
                    "labelWidth"), LAYOUT("layout"), LEAF("leaf"), LEFT("left"), LOADING_TEXT("loadingText"), MARGIN(
                    "margin"), MAX_LENGTH("maxLength"), MAX_ROWS("maxRows"), MAX_VALUE("maxValue"), MAX_VALUE_CLS(
                    "maxValueCls"), MASKED("masked"), METHOD("method"), MIN_VALUE("minValue"), MIN_VALUE_CLS(
                    "minValueCls"), MODAL("modal"), MSG("msg"), MULTILINE("multiline"), NAME("name"), OPTIONS("options"), PADDING(
                    "padding"), PICKER("picker"), PHONEGAP("phoneGap"), PLATFORM("platform"), PROMPT("prompt"), PROGRESS(
                    "progress"), RENDER("render"), RECORDS("records"), OVER_MODEL("overModel"), DROP_POSITION(
                    "dropPosition"), DROP_FUNCTION("dropFunction"), RENDERED_CHANGE("renderedchange"), RENDER_TO(
                    "renderTo"), RENDER_TPL("renderTpl"), REQUIRED("required"), REQUIRED_CLS("requiredCls"), RIGHT(
                    "right"), SCROLLABLE("scrollable"), SORTABLE("sortable"), SRC("src"), STEP_VALUE("stepValue"), STYLE(
                    "style"), STYLE_HTML_CLS("styleHtmlCls"), STYLE_HTML_CONTENT("styleHtmlContent"), SUBMIT_DISABLED(
                    "submitDisabled"), TAB_INDEX("tabIndex"), TAG("tag"), TEXT("text"), THUMBS("thumbs"), TITLE("title"), TOP(
                    "top"), TPL("tpl"), TPL_WRITE_MODE("tplWriteMode"), TRANSPARENT("transparent"), TYPE("type"), UI(
                    "ui"), UP("up"), URL("url"), UUID("uuid"), TRIGGER_EVENT("triggerEvent"), VALUE("value"), VALUE_FIELD(
                    "valueField"), VERSION("version"), WIDGET("widget"), WIDTH("width"), X("x"), XTYPE("xtype"), Y("y"), Z_INDEX(
                    "zIndex"), ALLOW_CONTAINER_DROPS("allowContainerDrops");

    private String value;

    private Attribute(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
