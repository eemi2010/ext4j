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
package com.ait.ext4j.client.dd;

import com.ait.ext4j.client.core.Component;
import com.ait.ext4j.client.core.EventObject;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;

/**
 * 
 */
public class DropTarget extends DDTarget {

    static {
        init();
    }

    private static native void init() /*-{

		$wnd.Ext.dd.DropTarget.prototype.notifyDrop = function(source, e, data) {
			var ddJ = this.ddJ;
			if (ddJ != null) {
				var eJ = @com.ait.ext4j.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(e);
				var sourceJ = @com.ait.ext4j.client.dd.DragSource::dragSourceInstance(Lcom/google/gwt/core/client/JavaScriptObject;)(source);
				var dataJ = data == null || data == undefined ? null
						: @com.ait.ext4j.client.dd.DragData::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(data);
				return ddJ.@com.ait.ext4j.client.dd.DropTarget::notifyDrop(Lcom/ait/ext4j/client/dd/DragSource;Lcom/ait/ext4j/client/core/EventObject;Lcom/ait/ext4j/client/dd/DragData;)(sourceJ, eJ, dataJ);

			}
		}

		$wnd.Ext.dd.DropTarget.prototype.notifyEnter = function(source, e, data) {
			var ddJ = this.ddJ;
			if (ddJ != null) {
				var eJ = @com.ait.ext4j.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(e);
				var sourceJ = @com.ait.ext4j.client.dd.DragSource::dragSourceInstance(Lcom/google/gwt/core/client/JavaScriptObject;)(source);
				var dataJ = data == null || data == undefined ? null
						: @com.ait.ext4j.client.dd.DragData::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(data);
				return ddJ.@com.ait.ext4j.client.dd.DropTarget::notifyEnter(Lcom/ait/ext4j/client/dd/DragSource;Lcom/ait/ext4j/client/core/EventObject;Lcom/ait/ext4j/client/dd/DragData;)(sourceJ, eJ, dataJ);
			}
		}

		$wnd.Ext.dd.DropTarget.prototype.notifyOut = function(source, e, data) {
			var ddJ = this.ddJ;
			if (ddJ != null) {
				var eJ = @com.ait.ext4j.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(e);
				var sourceJ = @com.ait.ext4j.client.dd.DragSource::dragSourceInstance(Lcom/google/gwt/core/client/JavaScriptObject;)(source);
				var dataJ = data == null || data == undefined ? null
						: @com.ait.ext4j.client.dd.DragData::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(data);
				ddJ.@com.ait.ext4j.client.dd.DropTarget::notifyOut(Lcom/ait/ext4j/client/dd/DragSource;Lcom/ait/ext4j/client/core/EventObject;Lcom/ait/ext4j/client/dd/DragData;)(sourceJ, eJ, dataJ);
			}
		}

		$wnd.Ext.dd.DropTarget.prototype.notifyOver = function(source, e, data) {
			var ddJ = this.ddJ;
			if (ddJ != null) {
				var eJ = @com.ait.ext4j.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(e);
				var sourceJ = @com.ait.ext4j.client.dd.DragSource::dragSourceInstance(Lcom/google/gwt/core/client/JavaScriptObject;)(source);
				var dataJ = data == null || data == undefined ? null
						: @com.ait.ext4j.client.dd.DragData::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(data);
				return ddJ.@com.ait.ext4j.client.dd.DropTarget::notifyOver(Lcom/ait/ext4j/client/dd/DragSource;Lcom/ait/ext4j/client/core/EventObject;Lcom/ait/ext4j/client/dd/DragData;)(sourceJ, eJ, dataJ);
			}
		}

    }-*/;

    public DropTarget(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public DropTarget(String id, DropTargetConfig config) {
        super(id, null, config);
    }

    public DropTarget(Element element, DropTargetConfig config) {
        super(element, null, config);
    }

    public DropTarget(Component component, DropTargetConfig config) {
        super(component, null, config);
    }

    protected native JavaScriptObject create(String id, String sGroup, JavaScriptObject config)/*-{
		return new $wnd.Ext.dd.DropTarget(id, config);
    }-*/;

    protected native JavaScriptObject create(Element element, String sGroup, JavaScriptObject config)/*-{
		return new $wnd.Ext.dd.DropTarget(element, config);
    }-*/;

    /**
     * The function {@link DragSource} calls once to notify this drop target
     * that the dragged item has been dropped on it. This method has no default
     * implementation and returns false, so you must provide an implementation
     * that does something to process the drop event and returns true so that
     * the drag source's repair action does not run.
     * 
     * @param source
     *            the drag source
     * @param e
     *            the event object
     * @param data
     *            an object containing arbitrary data supplied by the drag
     *            source
     * @return true if the drop was valid, else false
     */
    public boolean notifyDrop(DragSource source, EventObject e, DragData data) {
        return false;
    }

    /**
     * The function a {@link DragSource} calls once to notify this drop target
     * that the source is now over the target. This default implementation adds
     * the CSS class specified by overClass (if any) to the drop element and
     * returns the dropAllowed config value. This method should be overridden if
     * drop validation is required.
     * 
     * @param source
     *            The drag source that was dragged over this drop target
     * @param e
     *            The event
     * @param data
     *            An object containing arbitrary data supplied by the drag
     *            source
     * @return The CSS class that communicates the drop status back to the
     *         source so that the underlying {@link StatusProxy} can be updated
     */
    public String notifyEnter(DragSource source, EventObject e, DragData data) {
        return "x-dd-drop-ok";
    }

    /**
     * The function a Ext.dd.DragSource calls once to notify this drop target
     * that the source has been dragged out of the target without dropping. This
     * default implementation simply removes the CSS class specified by
     * overClass (if any) from the drop element.
     * 
     * @param source
     * @param e
     * @param data
     */
    public void notifyOut(DragSource source, EventObject e, DragData data) {
    }

    public String notifyOver(DragSource source, EventObject e, DragData data) {
        return "x-dd-drop-ok";
    }
}
