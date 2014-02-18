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
package com.ait.ext4j.client.util;

/**
 * A class that can be used to start and stop arbitrary tasks.
 * 
 * 
 */
public class TaskManager {

    private TaskManager() {

    }

    /**
     * Destroys this instance, stopping all tasks that are currently running.
     */
    public static native void destroy()/*-{
		$wnd.Ext.util.TaskManager.destroy();
    }-*/;

    /**
     * Destroys this instance, stopping all tasks that are currently running.
     */
    public static native void start(Task task)/*-{
		$wnd.Ext.util.TaskManager
				.start(task.@com.ait.ext4j.client.core.JsObject::getJsObj()());
    }-*/;

    /**
     * Stops an existing running task.
     */
    public static native void stop(Task task)/*-{
		$wnd.Ext.util.TaskManager
				.stop(task.@com.ait.ext4j.client.core.JsObject::getJsObj()());
    }-*/;

    /**
     * Stops all tasks that are currently running.
     */
    public static native void stopAll()/*-{
		$wnd.Ext.util.TaskManager.stopAll();
    }-*/;

}
