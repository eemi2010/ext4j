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
package com.eemi.ext4j.client.events.menu;

import com.eemi.ext4j.client.ui.MenuCheckItem;

/**
 * Handler interface for check events of a menu check item
 * 
 * @author alainekambi
 * 
 */
public interface BeforeItemCheckChangeHandler {
    /**
     * Fires before a change event. Return false to cancel.
     * 
     * @param item
     *            , the menu item that fired the event
     * 
     * @param checked
     *            , the checked state of this menu item
     */
    public boolean onEvent(MenuCheckItem item, boolean checked);
}
