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
import java.util.Arrays;
import java.util.List;

import com.ati.ext4j.client.chart.Legend;
import com.ati.ext4j.client.chart.axis.AbstractAxis;
import com.ati.ext4j.client.chart.laf.Gradient;
import com.ati.ext4j.client.chart.saving.ImageExport;
import com.ati.ext4j.client.chart.series.AbstractSerie;
import com.ati.ext4j.client.chart.theme.Theme;
import com.ati.ext4j.client.core.Component;
import com.ati.ext4j.client.core.JsoHelper;
import com.ati.ext4j.client.core.config.XType;
import com.ati.ext4j.client.data.Store;
import com.ati.ext4j.client.draw.Sprite;
import com.ati.ext4j.client.draw.Surface;
import com.ati.ext4j.client.draw.engine.ImageExporter;
import com.ati.ext4j.client.events.Event;
import com.ati.ext4j.client.events.HandlerRegistration;
import com.ati.ext4j.client.events.chart.BeforeRefreshHandler;
import com.ati.ext4j.client.events.chart.ChartEventHandler;
import com.ati.ext4j.client.events.chart.RefreshHandler;
import com.ati.ext4j.client.fx.anim.Animation;
import com.ati.ext4j.client.laf.Color;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.dom.client.Element;

/**
 * Charts provide a flexible way to achieve a wide range of data visualization
 * capablitities. Each Chart gets its data directly from a Store, and
 * automatically updates its display whenever data in the Store changes. In
 * addition, the look and feel of a Chart can be customized using Themes.
 * 
 * @author alainekambi
 * 
 */
public class Chart extends DrawComponent {

    private static JavaScriptObject configPrototype;
    private List<Gradient> gradients = new ArrayList<Gradient>();
    private List<AbstractAxis> axis = new ArrayList<AbstractAxis>();
    private List<AbstractSerie> series = new ArrayList<AbstractSerie>();
    List<AbstractSerie> nativePeers = new ArrayList<AbstractSerie>();
    private Store store;

    private native void init()/*-{
		var c = new $wnd.Ext.chart.Chart({
			store : []
		});
		@com.ati.ext4j.client.ui.Chart::configPrototype = c.initialConfig;
    }-*/;

    protected JavaScriptObject getConfigPrototype() {
        return configPrototype;
    }

    public String getXType() {
        return XType.CHART.getValue();
    }

    /**
     * Create a new Chart NotificationContainer.
     */
    public Chart() {
        // init();
    }

    public static Chart newInstance(final Store store, final List<AbstractAxis> axis) {
        assert store != null;
        assert !axis.isEmpty();

        return new Chart() {
            @Override
            protected void onConfigCreated() {
                this.setStore(store);
                this.setAxes(axis);
            }
        };
    }

    public static Chart create(final Store store, final List<AbstractSerie> series) {
        assert store != null;
        assert !series.isEmpty();
        return new Chart() {
            @Override
            protected void onConfigCreated() {
                this.setStore(store);
                this.setSeries(series);
            }
        };
    }

    public static Chart newInstance(final Store store, final List<AbstractAxis> axis, final List<AbstractSerie> series) {
        assert store != null;
        assert !axis.isEmpty();
        assert !series.isEmpty();
        return new Chart() {
            @Override
            protected void onConfigCreated() {
                this.setStore(store);
                this.setAxes(axis);
                this.setSeries(series);
            }
        };
    }

    public static Chart newInstance(final Store store, final List<AbstractAxis> axis, final List<AbstractSerie> series,
                    final Legend legend) {
        assert store != null;
        assert !axis.isEmpty();
        assert !series.isEmpty();
        return new Chart() {
            @Override
            protected void onConfigCreated() {
                this.setStore(store);
                this.setAxes(axis);
                this.setSeries(series);
                this.setLegend(legend);
            }
        };
    }

    protected Chart(JavaScriptObject jsObj) {
        super(jsObj);
    }

    /**
     * Applys the Chart to an existing element.
     * 
     * @param element
     *            the element
     */
    public Chart(Element element) {
        super(element);
    }

    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.chart.Chart(config);
    }-*/;

    private void setTheme(String value) {
        setAttribute("theme", value, true);
    }

    public void setTheme(Theme theme) {
        setTheme(theme.getValue());
    }

    /**
     * Array of Axis instances
     * 
     * @param axes
     */
    public void setAxes(List<AbstractAxis> axis) {
        this.axis = axis;
        JsArray<JavaScriptObject> jsos = JsArray.createArray().cast();
        for (AbstractAxis axe : axis) {
            jsos.push(axe.getJsObj());
        }
        setAttribute("axes", jsos, true);

    }

    /**
     * Array of Axis instances
     * 
     * @param axes
     */
    public void setAxes(AbstractAxis... axes) {
        this.axis = Arrays.asList(axes);
        JsArray<JavaScriptObject> jsos = JsArray.createArray().cast();
        for (AbstractAxis axe : axes) {
            jsos.push(axe.getJsObj());
        }
        setAttribute("axes", jsos, true);
    }

    /**
     * Get the axis of this chart
     * 
     * @return
     */
    public List<AbstractAxis> getAxis() {
        return _getAxisPeers();
    }

    private List<AbstractAxis> _getAxisPeers() {
        List<AbstractAxis> toReturn = new ArrayList<AbstractAxis>();
        JavaScriptObject nativePeers = _getAxis();
        if (nativePeers != null) {
            int size = JsoHelper.getArrayLength(nativePeers);
            for (int i = 0; i < size; i++) {
                AbstractAxis serie = AbstractAxis.create(JsoHelper.getValueFromJavaScriptObjectArray(nativePeers, i));
                toReturn.add(serie);
            }
        }
        return toReturn;
    }

    private native JavaScriptObject _getAxis()/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		if (component) {
			return component.axis.items;
		}
		return null;
    }-*/;

    /**
     * Array of Series instances
     * 
     * @param series
     */
    public void setSeries(List<AbstractSerie> series) {
        JsArray<JavaScriptObject> jsos = JsArray.createArray().cast();
        for (AbstractSerie serie : series) {
            jsos.push(serie.getJsObj());
        }
        setAttribute("series", jsos, true);
    }

    /**
     * Array of Series instances
     * 
     * @param series
     */
    public void setSeries(AbstractSerie... series) {
        JsArray<JavaScriptObject> jsos = JsArray.createArray().cast();
        for (AbstractSerie serie : series) {
            jsos.push(serie.getJsObj());
        }
        setAttribute("series", jsos, true);
    }

    /**
     * Get the series of this chart
     * 
     * @return
     */
    public List<AbstractSerie> getSeries() {
        this.nativePeers = _getSeriesNativePeers();
        return this.nativePeers;
    }

    private List<AbstractSerie> _getSeriesNativePeers() {
        List<AbstractSerie> toReturn = new ArrayList<AbstractSerie>();
        JavaScriptObject nativePeers = _getSeries();
        if (nativePeers != null) {
            int size = JsoHelper.getArrayLength(nativePeers);
            for (int i = 0; i < size; i++) {
                AbstractSerie serie = AbstractSerie.create(JsoHelper.getValueFromJavaScriptObjectArray(nativePeers, i));
                toReturn.add(serie);
            }
        }
        return toReturn;
    }

    private native JavaScriptObject _getSeries()/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		if (component) {
			return component.series.items;
		}
		return null;
    }-*/;

    /**
     * The store that supplies data to this chart.
     * 
     * @param store
     */
    public void setStore(Store store) {
        setAttribute("store", store.getJsObj(), true);
    }

    /**
     * Sets the legend of this chart
     * 
     * @param legend
     */
    public void setLegend(Legend legend) {
        setAttribute("legend", legend.getJsObj(), true);
    }

    /**
     * True for the default legend display Defaults to false.
     * 
     */
    public void setLegend(boolean legend) {
        setAttribute("legend", legend, true);
    }

    public void setShadow(boolean value) {
        setAttribute("shadow", value, true);
    }

    /**
     * True for the default animation (easing: 'ease' and duration: 500) or a
     * standard animation config object to be used for default chart animations.
     * Defaults to false.
     * 
     * Defaults to: false
     * 
     * @param value
     */
    public void setAnimate(boolean value) {
        setAttribute("animate", value, true, true);
    }

    /**
     * True for the default animation (easing: 'ease' and duration: 500) or a
     * standard animation config object to be used for default chart animations.
     * Defaults to false.
     * 
     * Defaults to: false
     * 
     * @param value
     */
    public void setAnimate(Animation value) {
        setAttribute("animate", value.getJsObj(), true, true);
    }

    /**
     * the amount of inset padding in pixels for the chart. Defaults to 10.
     * 
     * Defaults to: 10
     * 
     * @param value
     */
    public void setInsetPadding(int value) {
        setAttribute("insetPadding", value, true, true);
    }

    /**
     * Saves the chart as SVG
     * 
     * @return, svg string representing the surface
     */
    public native String saveAsSvg()/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		return component.save({
			type : 'image/svg+xml'
		});
    }-*/;

    /**
     * Saves the chart as PNG.
     * <p>
     * <b>Important</b>: By default, chart data is sent to a server operated by
     * Sencha to do data processing. You may change this default by setting the
     * defaultUrl of {@link ImageExporter}.
     * 
     * @return, chart representation as PNG
     */
    public native boolean saveAsPng()/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		return component.save({
			type : 'image/png'
		});
    }-*/;

    /**
     * Saves the chart as PNG.
     * 
     * @param serverUrl
     *            , the url where the post data will be send
     * @return, chart representation as PNG
     */
    public native boolean saveAsPng(String serverUrl)/*-{
		$wnd.Ext.draw.engine.ImageExporter.defaultUrl = serverUrl;
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		return component.save({
			type : 'image/png'
		});
    }-*/;

    /**
     * Saves the chart as JPEG.
     * <p>
     * <b>Important</b>: By default, chart data is sent to a server operated by
     * Sencha to do data processing. You may change this default by setting the
     * defaultUrl of {@link ImageExporter}.
     * 
     * @return, chart representation as JPEG
     */
    public native boolean saveAsJpg()/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		return component.save({
			type : 'image/jpeg'
		});
    }-*/;

    /**
     * Saves the chart as PNG.
     * 
     * @param serverUrl
     *            , the url where the post data will be send
     * @return, chart representation as PNG
     */
    public native boolean saveAsJpg(String serverUrl)/*-{
		$wnd.Ext.draw.engine.ImageExporter.defaultUrl = serverUrl;
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		return component.save({
			type : 'image/jpeg'
		});
    }-*/;

    /**
     * Save the chart as image
     * 
     * @param export
     *            , the export option
     */
    public boolean save(ImageExport export) {
        return _save(export.getJsObj());
    }

    /**
     * Save the chart as image
     * 
     * @param export
     *            , the export option
     * @param serverUrl
     *            , the url where the post data will be send
     */
    public boolean save(ImageExport export, String serverUrl) {
        return _save(export.getJsObj(), serverUrl);
    }

    /**
     * The chart background. This can be a gradient object, image, or color.
     * Defaults to false for no background
     * 
     * @param value
     */
    public void setBackGroundFill(String value) {
        setAttribute("background", createFill(value), true);
    }

    /**
     * The chart background. This can be a gradient object, image, or color.
     * Defaults to false for no background
     * 
     * @param color
     */
    public void setBackGroundFill(Color color) {
        setBackGroundFill(color.asRgbString());
    }

    /**
     * Sets the background image
     * 
     * @param value
     */
    public void setBackGroundImage(String value) {
        setAttribute("background", createImage(value), true);
    }

    /**
     * Define a set of gradients that can be used as fill property in sprites.
     * 
     * @param values
     */
    public void setGradients(Gradient... values) {
        this.gradients = Arrays.asList(values);
        JsArray<JavaScriptObject> gradients = JsArray.createArray().cast();
        for (Gradient g : values) {
            gradients.push(g.getJsObj());
        }
        setAttribute("gradients", gradients, true, true);
    }

    /**
     * Define a set of gradients that can be used as fill property in sprites.
     * 
     * @param values
     */
    public void setGradients(List<Gradient> values) {
        this.gradients = values;
        JsArray<JavaScriptObject> gradients = JsArray.createArray().cast();
        for (Gradient g : values) {
            gradients.push(g.getJsObj());
        }
        setAttribute("gradients", gradients, true, true);
    }

    /**
     * 
     /** Add a new gradient to this chart. The added gradient is not yet on
     * the chart .
     * <p>
     * For that <code>drawGradients()</code> must be called
     * 
     * @param gradient
     *            , the gradient to add
     */

    public void addGradient(Gradient gradient) {
        this.gradients.add(gradient);
    }

    /**
     * draw the gradients of this chart.
     * 
     */
    public void drawGradients() {
        JsArray<JavaScriptObject> jsos = JsArray.createArray().cast();
        for (Gradient g : this.gradients) {
            jsos.push(g.getJsObj());
        }
        setAttribute("gradients", jsos, true, true);
    }

    /**
     * Creates a new chart from the given component
     * 
     * @param component
     *            , the component to cast from
     * @return, a new chart from the component
     * 
     */
    public static Chart cast(Component component) {
        return new Chart(component.getOrCreateJsObj());
    }

    /**
     * Listen to before a refresh to the chart data is called. If the
     * beforerefresh handler returns false the refresh action will be cancelled.
     * 
     * @param handler
     *            , the handler that will handle the event
     */
    public void addBeforeRefreshHandler(ChartEventHandler handler) {
        _addHandler(Event.BEFORE_REFRESH, handler);
    }

    /**
     * Listen to after the chart data has been refreshed.
     * 
     * @param handler
     *            , the handler that will handle the event
     */
    public void addRefreshHandler(ChartEventHandler handler) {
        _addHandler(Event.REFRESH, handler);
    }

    /**
     * Sets the title text for the panel.
     * 
     * @param title
     *            the title
     */
    public native void createSurface() /*-{
		var draw = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		draw.createSurface();
    }-*/;

    public native Surface getSurface()/*-{
		var draw = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var surface = draw.surface;
		return @com.ati.ext4j.client.draw.Surface::new(Lcom/google/gwt/core/client/JavaScriptObject;)(surface);
    }-*/;

    public Sprite add(Sprite sprite) {
        return getSurface().add(sprite);
    }

    public void setViewBox(boolean value) {
        setAttribute("viewBox", value, true);
    }

    /**
     * Refresh the display of this chart
     */
    public native void refresh() /*-{
		var chart = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		chart.refresh();
    }-*/;

    /**
     * A single item, or an array of child Components to be added to this
     * container
     */
    public void setItems(Sprite... items) {
        setAttribute("items", ComponentFactory.fromArrayOfSprite(items), true);
    }

    /**
     * Fires before a refresh to the chart data is called.
     */
    public native HandlerRegistration addBeforeReshHandler(BeforeRefreshHandler handler)/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, e) {
			var chart = @com.ati.ext4j.client.ui.Chart::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var event = @com.ati.ext4j.client.events.chart.BeforeRefreshEvent::new(Lcom/ati/ext4j/client/ui/Chart;Lcom/google/gwt/core/client/JavaScriptObject;)(chart, event);
			handler.@com.ati.ext4j.client.events.chart.BeforeRefreshHandler::onBeforeRefresh(Lcom/ati/ext4j/client/events/chart/BeforeRefreshEvent;)(event);
		};
		var eventName = @com.ati.ext4j.client.events.chart.BeforeRefreshEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ati.ext4j.client.events.HandlerRegistration::new(Lcom/ati/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    /**
     * Fires before a refresh to the chart data is called.
     */
    public native HandlerRegistration addReshHandler(RefreshHandler handler)/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		var fn = function(c, e) {
			var chart = @com.ati.ext4j.client.ui.Chart::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
			var event = @com.ati.ext4j.client.events.chart.RefreshEvent::new(Lcom/ati/ext4j/client/ui/Chart;Lcom/google/gwt/core/client/JavaScriptObject;)(chart, event);
			handler.@com.ati.ext4j.client.events.chart.RefreshHandler::onRefresh(Lcom/ati/ext4j/client/events/chart/RefreshEvent;)(event);
		};
		var eventName = @com.ati.ext4j.client.events.chart.RefreshEvent::EVENT_NAME;
		component.addListener(eventName, fn);
		var toReturn = @com.ati.ext4j.client.events.HandlerRegistration::new(Lcom/ati/ext4j/client/core/Component;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(this,eventName,fn);
		return toReturn;
    }-*/;

    private native JavaScriptObject createFill(String value)/*-{
		return {
			fill : value
		};
    }-*/;

    private native JavaScriptObject createImage(String value)/*-{
		return {
			image : value
		};
    }-*/;

    private native boolean _save(JavaScriptObject config)/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		return component.save(config);
    }-*/;

    private native boolean _save(JavaScriptObject config, String serverUrl)/*-{
		$wnd.Ext.draw.engine.ImageExporter.defaultUrl = serverUrl;
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		return component.save(config);
    }-*/;

    private native void _addHandler(String event, ChartEventHandler handler)/*-{
		var component = this.@com.ati.ext4j.client.core.Component::getOrCreateJsObj()();
		if (component) {
			component
					.addListener(
							event,
							$entry(function(c) {
								var chart = @com.ati.ext4j.client.ui.Chart::new(Lcom/google/gwt/core/client/JavaScriptObject;)(c);
								return handler.@com.ati.ext4j.client.events.chart.ChartEventHandler::onEvent(Lcom/ati/ext4j/client/ui/Chart;)(chart);
							}));
		}

    }-*/;

}
