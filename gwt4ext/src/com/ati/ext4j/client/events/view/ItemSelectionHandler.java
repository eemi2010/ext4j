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
package com.ati.ext4j.client.events.view;

import com.ati.ext4j.client.data.BaseModel;
import com.ati.ext4j.client.selection.RowSelectionModel;

/**
 * Handler interface for item selection on a table panel and it's subclasses
 * 
 * @author alainekambi
 * 
 */
public interface ItemSelectionHandler {
    /**
     * Fired before a record is deselected. If any listener returns false, the
     * deselection is cancelled.
     * 
     * @param rowModel
     * @param record
     *            ,The record
     * @param index
     *            ,The row index
     */
    public boolean onEvent(RowSelectionModel rowModel, BaseModel record, int index);
}
