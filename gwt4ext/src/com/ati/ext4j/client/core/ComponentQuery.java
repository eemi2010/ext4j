package com.ati.ext4j.client.core;

import java.util.List;

import com.ati.ext4j.client.ui.ComponentFactory;
import com.ati.ext4j.client.ui.Container;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * Provides searching of Components within {@link ComponentManager} (globally)
 * or a specific {@link Container} on the document with a similar syntax to a
 * CSS selector. Returns List of matching Components, or empty List.
 */
public class ComponentQuery {

    private ComponentQuery() {

    }

    /**
     * Tests whether the passed Component matches the selector string.
     */
    public static native boolean is(Component component, String selector)/*-{
		return $wnd.Ext.ComponentQuery
				.is(
						component.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()(),
						selector);
    }-*/;

    /**
     * Returns an array of matched Components from within the passed root
     * object.
     * <p>
     * This method filters returned Components in a similar way to how CSS
     * selector based DOM queries work using a textual selector string.
     */
    public static List<Component> query(String selector) {
        return ComponentFactory.fromJsArray(_query(selector));
    }

    /**
     * Returns an array of matched Components from within the passed root
     * object.
     * <p>
     * This method filters returned Components in a similar way to how CSS
     * selector based DOM queries work using a textual selector string.
     */
    public static List<Component> query(String selector, Container root) {
        return ComponentFactory.fromJsArray(_query(selector, root));
    }

    private static native JavaScriptObject _query(String selector)/*-{
		return $wnd.Ext.ComponentQuery.query(selector);
    }-*/;

    private static native JavaScriptObject _query(String selector, Container root)/*-{
		return $wnd.Ext.ComponentQuery
				.query(
						selector,
						root.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()());
    }-*/;

}
