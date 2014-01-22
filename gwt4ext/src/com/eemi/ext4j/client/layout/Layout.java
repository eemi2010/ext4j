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
package com.eemi.ext4j.client.layout;

public enum Layout {

    CARD("card"), FIT("fit"), HBOX("hbox"), VBOX("vbox"), ACCORDION("accordion"), ABSOLUTE("absolute"), ANCHOR("anchor"), BOX(
                    "box"), BORDER("border"), COLUMN("column"), TABLE("table"), AUTO("auto"), FORM("form");

    private String value;

    private Layout(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Layout fromValue(String layout) {
        if (layout.equalsIgnoreCase(Layout.CARD.getValue())) {
            return Layout.CARD;
        } else if (layout.equalsIgnoreCase(Layout.ABSOLUTE.getValue())) {
            return Layout.ABSOLUTE;
        } else if (layout.equalsIgnoreCase(Layout.ACCORDION.getValue())) {
            return Layout.ACCORDION;
        } else if (layout.equalsIgnoreCase(Layout.ANCHOR.getValue())) {
            return Layout.ANCHOR;
        } else if (layout.equalsIgnoreCase(Layout.AUTO.getValue())) {
            return Layout.AUTO;
        } else if (layout.equalsIgnoreCase(Layout.BORDER.getValue())) {
            return Layout.BORDER;
        } else if (layout.equalsIgnoreCase(Layout.CARD.getValue())) {
            return Layout.CARD;
        } else if (layout.equalsIgnoreCase(Layout.COLUMN.getValue())) {
            return Layout.COLUMN;
        } else if (layout.equalsIgnoreCase(Layout.FIT.getValue())) {
            return Layout.FIT;
        } else if (layout.equalsIgnoreCase(Layout.FORM.getValue())) {
            return Layout.FORM;
        } else if (layout.equalsIgnoreCase(Layout.HBOX.getValue())) {
            return Layout.HBOX;
        } else if (layout.equalsIgnoreCase(Layout.TABLE.getValue())) {
            return Layout.TABLE;
        } else if (layout.equalsIgnoreCase(Layout.VBOX.getValue())) {
            return Layout.VBOX;
        }
        return Layout.AUTO;
    }
}
