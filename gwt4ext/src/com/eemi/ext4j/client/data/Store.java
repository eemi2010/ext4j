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
package com.eemi.ext4j.client.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.eemi.ext4j.client.core.Ext;
import com.eemi.ext4j.client.core.Function;
import com.eemi.ext4j.client.core.JsObject;
import com.eemi.ext4j.client.core.JsoHelper;
import com.eemi.ext4j.client.data.handlers.BeforeLoadHandler;
import com.eemi.ext4j.client.data.handlers.BeforePrefetchHandler;
import com.eemi.ext4j.client.data.handlers.ClearHandler;
import com.eemi.ext4j.client.data.handlers.DataAddedHandler;
import com.eemi.ext4j.client.data.handlers.DataChangedHandler;
import com.eemi.ext4j.client.data.handlers.EachCallBack;
import com.eemi.ext4j.client.data.handlers.GroupingHandler;
import com.eemi.ext4j.client.data.handlers.LoadCallback;
import com.eemi.ext4j.client.data.handlers.RemoveHandler;
import com.eemi.ext4j.client.data.handlers.UpdateHandler;
import com.eemi.ext4j.client.data.proxy.ProxyConfig;
import com.eemi.ext4j.client.util.Direction;
import com.eemi.ext4j.client.util.FilterConfig;
import com.eemi.ext4j.client.util.FilterFunction;
import com.eemi.ext4j.client.util.Grouper;
import com.eemi.ext4j.client.util.GrouperConfig;
import com.eemi.ext4j.client.util.Sorter;
import com.eemi.ext4j.client.util.SorterConfig;
import com.emitrom.pilot.core.shared.client.data.Bean;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayString;

/**
 * The Store class encapsulates a client side cache of DataModel objects. Stores
 * load data via a ProxyConfig, and also provide functions for sorting,
 * filtering and querying the model instances contained within it.
 * 
 * @See <a href="http://docs.sencha.com/ext4/2-0/#!/api/Ext.data.Store">Ext.data
 *      .Store</a>
 * 
 */
public class Store extends JsObject {

    protected List<BaseModel> elements = new ArrayList<BaseModel>();
    protected final static String model = "ext4j-model-";
    protected static int modelRegistry = 0;
    protected String modelName;

    protected Store() {
        // create();
    }

    public Store(String modelName, ProxyConfig proxy) {
        create(modelName, proxy);
    }

    /**
     * This constructor allows a Store to be created; it MUST contain at least
     * one element, since the Store's fields will be derived from the first
     * element in the Store.
     * 
     * @param data
     */
    public Store(List<? extends BaseModel> data) {
        assert !data.isEmpty() : "BaseModel list cannot be empty.";
        Set<String> fields = new HashSet<String>(data.get(0).getFields());
        init(data, fields);
    }

    public static Store from(List<? extends Bean> beans) {
        List<BaseModel> models = new ArrayList<BaseModel>();
        for (Bean bean : beans) {
            models.add(BaseModel.from(bean.getJsObj()));
        }
        return new Store(models);
    }

    public static Store from(List<? extends Bean> beans, String... fields) {
        List<BaseModel> models = new ArrayList<BaseModel>();
        for (Bean bean : beans) {
            models.add(BaseModel.from(bean.getJsObj()));
        }
        return new Store(models, fields);
    }

    public Store(List<? extends BaseModel> data, ProxyConfig proxy) {
        assert !data.isEmpty() : "BaseModel list cannot be empty.";
        Set<String> fields = new HashSet<String>(data.get(0).getFields());
        init(data, fields, proxy);
    }

    /**
     * This constructor allows a Store to be created without elements. However,
     * the list of fields must be specified.
     * 
     * @param data
     * @param fields
     */
    public Store(List<? extends BaseModel> data, String... fields) {
        assert fields.length != 0 : "Fields list cannot be empty.";
        init(data, new HashSet<String>(Arrays.asList(fields)));
    }

    public Store(List<? extends BaseModel> data, ProxyConfig proxy, String... fields) {
        assert fields.length != 0 : "Fields list cannot be empty.";
        init(data, new HashSet<String>(Arrays.asList(fields)), proxy);
    }

    public Store(ProxyConfig proxy, String... fields) {
        create(proxy, JsoHelper.convertToJavaScriptArray(fields));
    }

    public Store(ProxyConfig proxy, FieldDefinition... fields) {
        create(proxy, JsoHelper.convertToJavaScriptArray(fields));
    }

    public Store(JavaScriptObject obj) {
        super(obj);
    }

    public static Store instance(JavaScriptObject obj) {
        return new Store(obj);
    }

    /**
     * Initializes this Store with the given BaseModel objects and the given
     * fields.
     * 
     * @param data
     * @param fields
     */
    protected void init(List<? extends BaseModel> data, Set<String> fields) {
        modelRegistry++;
        modelName = model + modelRegistry;
        this.elements.addAll(data);

        Ext.defineModel(modelName, fields);
        JavaScriptObject[] storeData = new JavaScriptObject[data.size()];

        for (int i = 0; i < data.size(); i++) {
            storeData[i] = data.get(i).getJsObj();
        }

        create(modelName, JsoHelper.arrayConvert(storeData));
    }

    protected void init(List<? extends BaseModel> data, Set<String> fields, ProxyConfig proxy) {
        modelRegistry++;
        modelName = model + modelRegistry;
        this.elements.addAll(data);

        Ext.defineModel(modelName, fields);
        JavaScriptObject[] storeData = new JavaScriptObject[data.size()];

        for (int i = 0; i < data.size(); i++) {
            storeData[i] = data.get(i).getJsObj();
        }

        create(modelName, JsoHelper.arrayConvert(storeData), proxy);
    }

    public int count() {
        return elements.size();
    }

    private native int _count()/*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		return jso.count();
    }-*/;

    /**
     * Allows the Store to prefetch and cache in a page cache, pages of Records,
     * and to then satisfy loading requirements from this page cache.
     * <p>
     * To use buffered Stores, initiate the process by loading the first page.
     * The number of rows rendered are determined automatically, and the range
     * of pages needed to keep the cache primed for scrolling is requested and
     * cached. Example:
     * 
     * @param value
     */
    public void setBuffered(boolean value) {
        JsoHelper.setAttribute(jsObj, "buffred", value);
    }

    /**
     * True to empty the store when loading another page via loadPage, nextPage
     * or previousPage. Setting to false keeps existing records, allowing large
     * data sets to be loaded one page at a time but rendered all together.
     * 
     * @param value
     */
    public void setClearOnPageLoad(boolean value) {
        JsoHelper.setAttribute(jsObj, "clearOnPageLoad", value);
    }

    /**
     * The default sort direction to use if one is not specified.
     * <p>
     * Defaults to: "ASC"
     */
    public void setDefaultSortDirection(boolean value) {
        JsoHelper.setAttribute(jsObj, "defaultSortDirection", value);
    }

    /**
     * The number of records considered to form a 'page'. This is used to power
     * the built-in paging using the nextPage and previousPage functions when
     * the grid is paged using a PagingScroller Defaults to 25.
     */
    public void setPageSize(int value) {
        JsoHelper.setAttribute(jsObj, "pageSize", value);
    }

    public void setProxyConfig(ProxyConfig proxy) {
        JsoHelper.setAttribute(jsObj, "proxy", proxy.getJsObj());
    }

    /**
     * The number of records considered to form a 'page'. This is used to power
     * the built-in paging using the nextPage and previousPage functions when
     * the grid is paged using a PagingScroller Defaults to 25.
     */
    public void setPurgePageCount(int value) {
        JsoHelper.setAttribute(jsObj, "purgePageCount", value);
    }

    /**
     * True to defer any filtering operation to the server. If false, filtering
     * is done locally on the client.
     * <p>
     * Defaults to: false
     */
    public void setRemoteFilter(boolean value) {
        JsoHelper.setAttribute(jsObj, "remoteFilter", value);
    }

    /**
     * true if the grouping should apply on the server side, false if it is
     * local only. If the grouping is local, it can be applied immediately to
     * the data. If it is remote, then it will simply act as a helper,
     * automatically sending the grouping information to the server.
     * <p>
     * Defaults to: false
     */
    public void setRemoteGroup(boolean value) {
        JsoHelper.setAttribute(jsObj, "remoteGroup", value);
    }

    /**
     * True to defer any sorting operation to the server. If false, sorting is
     * done locally on the client.
     * <p>
     * Defaults to: false
     */
    public void setRemoteSort(boolean value) {
        JsoHelper.setAttribute(jsObj, "remoteSort", value);
    }

    /**
     * For local filtering only, causes sort to be called whenever filter is
     * called, causing the sorters to be reapplied after filtering.
     * <p>
     * Defaults to: true
     */
    public void setSortOnFilter(boolean value) {
        JsoHelper.setAttribute(jsObj, "sortOnFilter", value);
    }

    /**
     * If true, any sorters attached to this Store will be run after loading
     * data, before the datachanged event is fired. Defaults to true, igored if
     * remoteSort is true
     * <p>
     * Defaults to: true
     */
    public void setSortOnLad(boolean value) {
        JsoHelper.setAttribute(jsObj, "sortOnLoad", value);
    }

    /**
     * The property in each item that contains the data to sort.
     * <p>
     * Available since: Ext 4.1.3
     */
    public void setSortRoot(boolean value) {
        JsoHelper.setAttribute(jsObj, "sortRoot", value);
    }

    /**
     * Unique identifier for this store. If present, this Store will be
     * registered with the Ext.data.StoreManager, making it easy to reuse
     * elsewhere.
     * <p>
     * Note that when store is instatiated by Controller, the storeId will be
     * overridden by the name of the store.
     */
    public void setStoreId(String value) {
        JsoHelper.setAttribute(jsObj, "storeId", value);
    }

    /**
     * When buffered, the number of extra records to keep cached on the trailing
     * side of scrolling buffer as scrolling proceeds. A larger number means
     * fewer replenishments from the server.
     * <p>
     * Defaults to: 25
     */
    public void setTraillingBufferZode(double value) {
        JsoHelper.setAttribute(jsObj, "traillingBufferZode", value);
    }

    /**
     * Gets the average value in the store.
     * 
     * @param field
     * @param grouped
     * @return
     */
    public native JavaScriptObject average(String field, boolean grouped) /*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		return jso.average(field, grouped);
    }-*/;

    /**
     * Revert to a view of the BaseModel cache with no filtering applied.
     */
    public native void clearFilter() /*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		jso.clearFilter();
    }-*/;

    /**
     * Filters the loaded set of records by a given set of filters.
     * <p>
     * By default, the passed filter(s) are added to the collection of filters
     * being used to filter this Store.
     */
    public native void filter(String property, String value) /*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		jso.filter(property, value);
    }-*/;

    /**
     * Filters the loaded set of records by a given set of filters.
     * <p>
     * By default, the passed filter(s) are added to the collection of filters
     * being used to filter this Store.
     */
    public native void filter() /*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		jso.filter();
    }-*/;

    /**
     * Filters the loaded set of records by a given set of filters.
     * <p>
     * By default, the passed filter(s) are added to the collection of filters
     * being used to filter this Store.
     */
    public void filter(FilterConfig... filterConfigs) {
        _filter(JsoHelper.arrayConvert(filterConfigs));
    }

    private native void _filter(JavaScriptObject filters) /*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		jso.filter(filters);
    }-*/;

    public void sort(String property, Direction direction) {
        _sort(property, direction.getValue());
    }

    private native void _sort(String property, String direction) /*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		jso.sort(property, direction);
    }-*/;

    public native void sort() /*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		jso.sort();
    }-*/;

    public void filter(SorterConfig... sorterConfigs) {
        _sort(JsoHelper.arrayConvert(sorterConfigs));
    }

    private native void _sort(JavaScriptObject sorters) /*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		jso.sort(sorters);
    }-*/;

    /**
     * Filters by a function. The specified function will be called for each
     * Record in this Store. If the function returns true the Record is
     * included, otherwise it is filtered out.
     * <p>
     * When store is filtered, most of the methods for accessing store data will
     * be working only within the set of filtered records. Two notable
     * exceptions are <code>queryBy</code> and <code>getById</code>.
     */
    public native void filterBy(FilterFunction filterFunction) /*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		jso
				.filter($entry(function(item) {
					var model = @com.eemi.ext4j.client.data.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(item);
					return filterFunction.@com.eemi.ext4j.client.util.FilterFunction::onFilter(Lcom/eemi/ext4j/client/data/BaseModel;)(model);
				}));
    }-*/;

    /**
     * Revert to a view of the BaseModel cache with no filtering applied.
     * 
     * @param suppressEvent
     */
    public native void clearFilter(boolean suppressEvent) /*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		jso.clearFilter(suppressEvent);
    }-*/;

    /**
     * Collects unique values for a particular dataIndex from this store.
     * 
     * @param dataIndex
     * @param allowNull
     * @param bypassFilter
     * @return
     */
    public native JsArray<JavaScriptObject> collect(String dataIndex, boolean allowNull, boolean bypassFilter) /*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		return jso.collect(dataIndex, allowNull, bypassFilter);
    }-*/;

    public BaseModel getAt(int index) {
        JavaScriptObject obj = _getAt(index);
        BaseModel model = elements.get(index);
        model.update(obj);
        return model;
    }

    private native JavaScriptObject _getAt(int index)/*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		var value = jso.getAt(index);
		return value;
    }-*/;

    /**
     * The Collection that holds this store's local cache of records
     * 
     * @param data
     */
    public void setData(ArrayList<? extends BaseModel> data) {
        JavaScriptObject[] storeData = new JavaScriptObject[data.size()];
        for (int i = 0; i < data.size(); i++) {
            storeData[i] = data.get(i).getJsObj();
        }
        setData(JsoHelper.arrayConvert(storeData));
        elements.clear();
        elements.addAll(data);

    }

    /**
     * 
     * @return, The page that the Store has most recently loaded.
     */
    public native int getCurrentPage()/*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		return jso.currentPage;
    }-*/;

    public native void setCurrentPage(int value)/*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		jso.currentPage = value;
    }-*/;

    /**
     * The default sort direction to use if one is not specified (defaults to
     * SortDirection.ASC)
     * 
     * @param sortDirection
     */
    public void setDefaultSortDirection(SortDirection sortDirection) {
        setDefaultSortDirection(sortDirection.getValue());
    }

    public SortDirection getDefaultSortDirection() {
        return SortDirection.valueOf(_getDefaultSortDirection());
    }

    /**
     * The direction in which sorting should be applied when grouping. Defaults
     * to SortDirection.ASC - the other supported value is SortDirection.DESC
     * 
     * @param direction
     */
    public void setGroupDirection(SortDirection direction) {
        setGroupDir(direction.getValue());
    }

    public SortDirection getGroupDirection() {
        return SortDirection.valueOf(_getGroupDir());
    }

    /**
     * The (optional) field by which to group data in the store. Internally,
     * grouping is very similar to sorting - the groupField and groupDir are
     * injected as the first sorter (see sort). Stores support a single level of
     * grouping, and groups can be fetched via the getGroups method.
     * 
     * @param value
     */
    public void setGroupField(String value) {
        this.addGrouper(new Grouper(value));
    }

    /**
     * The (optional) field by which to group data in the store. Internally,
     * grouping is very similar to sorting - the groupField and groupDir are
     * injected as the first sorter (see sort). Stores support a single level of
     * grouping, and groups can be fetched via the getGroups method.
     * 
     * @param value
     */
    public void setGroupField(String value, Direction direction) {
        this.addGrouper(new Grouper(value, direction));
    }

    public native void addGrouper(Grouper grouper)/*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		jso.groupers
				.add(grouper.@com.eemi.ext4j.client.core.JsObject::getJsObj()());
    }-*/;

    public native String getGroupField()/*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		return jso.groupField;
    }-*/;

    /**
     * Finds the index of the first matching BaseModel in this store by a
     * specific field value.
     * 
     * @param fieldName
     * @param value
     * @param startIndex
     * @return
     */
    public native int findExact(String fieldName, Object value, int startIndex) /*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		return jso.findExact(fieldName, value, startIndex);
    }-*/;

    /**
     * Inserts DataModel instances into the Store at the given index and fires
     * the add event
     */
    public void insert(int index, BaseModel record) {
        this.elements.add(index, record);
        _insertOne(index, record.getJsObj());
    }

    private native void _insertOne(int index, JavaScriptObject record)/*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		jso.insert(index, record);
    }-*/;

    /**
     * Inserts DataModel instances into the Store at the given index and fires
     * the add event
     */
    public void insert(int index, BaseModel... records) {
        insert(index, Arrays.asList(records));
    }

    /**
     * Inserts DataModel instances into the Store at the given index and fires
     * the add event
     */
    public void insert(int index, List<BaseModel> records) {
        this.elements.addAll(index, records);
        JavaScriptObject peers = BaseModel.fromList(records);
        _insert(index, peers);
    }

    private native void _insert(int index, JavaScriptObject record)/*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		jso.insert(index, record);
    }-*/;

    /**
     * fieldName : String The name of the BaseModel field to test. value :
     * String/RegExp Either a string that the field value should begin with, or
     * a RegExp to test against the field. startIndex : Number (optional) The
     * index to start searching at anyMatch : Boolean (optional) True to match
     * any part of the string, not just the beginning caseSensitive : Boolean
     * (optional) True for case sensitive comparison exactMatch : Boolean
     * (optional) True to force exact match (^ and $ characters added to the
     * regex). Defaults to false.
     * 
     * @param <T>
     * @param fieldName
     * @param value
     * @param startIndex
     * @param anyMatch
     * @param caseSensitive
     * @param exactMatch
     * @return
     */
    public native <T extends BaseModel> T findBaseModel(String fieldName, String value, int startIndex,
                    boolean anyMatch, boolean caseSensitive, boolean exactMatch) /*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		return jso.findExact(fieldName, value, startIndex, anyMatch,
				caseSensitive, exactMatch);
    }-*/;

    /**
     * Convenience function for getting the first model instance in the store
     */
    public native BaseModel first(boolean grouped) /*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		var obj = jso.first(grouped);
		return @com.eemi.ext4j.client.data.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
    }-*/;

    /**
     * Convenience function for getting the first model instance in the store
     */
    public native BaseModel first() /*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		var obj = jso.first();
		return @com.eemi.ext4j.client.data.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
    }-*/;

    /**
     * Convenience function for getting the last model instance in the store
     */
    public native BaseModel last() /*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		var obj = jso.last();
		return @com.eemi.ext4j.client.data.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
    }-*/;

    /**
     * Convenience function for getting the last model instance in the store
     */
    public native BaseModel last(boolean grouped) /*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		var obj = jso.last(grouped);
		return @com.eemi.ext4j.client.data.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
    }-*/;

    /**
     * Get the BaseModel with the specified id.
     * 
     * @param <T>
     * @param id
     * @return
     */
    public native <T extends BaseModel> T getById(String id) /*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		return jso.getById(id);
    }-*/;

    /**
     * Returns the string to group on for a given model instance. The default
     * implementation of this method returns the model's groupField, but this
     * can be overridden to group by an arbitrary string.
     * 
     * @param instance
     * @return
     */
    public native String getGroupString(BaseModel instance) /*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		return jso.getGroupString(instance);
    }-*/;

    /**
     * Returns an array containing the result of applying grouping to the
     * records in this store. See groupField, groupDir and getGroupString.
     * 
     * @param groupName
     * @return
     */
    public native JsArray<JavaScriptObject> getGroups(String groupName) /*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		return jso.getGroups(groupName);
    }-*/;

    /**
     * Returns a range of BaseModels between specified indices.
     * 
     * @param <T>
     * @param startIndex
     * @param endIndex
     * @return
     */
    public native <T extends BaseModel> T getRange(int startIndex, int endIndex) /*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		return jso.getRange(startIndex, endIndex);
    }-*/;

    /**
     * Group data in the store
     * 
     * @param groupers
     * @param direction
     */
    public native void group(String groupers, String direction) /*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		jso.group(groupers, direction);
    }-*/;

    /**
     * Group data in the store
     * 
     * @param groupers
     * @param direction
     */
    public native void group(JsArray<JavaScriptObject> groupers, String direction) /*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		jso.group(groupers, direction);
    }-*/;

    /**
     * Get the index within the cache of the passed BaseModel.
     * 
     * @param model
     * @return
     */
    public int indexOf(BaseModel model) {
        return elements.indexOf(model);
    }

    /**
     * Get the index within the cache of the BaseModel with the passed id.
     * 
     * @param id
     * @return
     */
    public native int indexOfId(String id) /*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		return jso.indexOfId(id);
    }-*/;

    /**
     * Get the index within the entire dataset. From 0 to the totalCount.
     * 
     * @param model
     * @return
     */
    public native int indexOfTotal(BaseModel model) /*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		return jso.indexOfTotal(model);
    }-*/;

    /**
     * Flag denoting that this object is sortable. Always true.
     * 
     * @return
     */
    public native boolean isSortable()/*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		return jso.isSortable;
    }-*/;

    /**
     * True if the Store has already been destroyed. If this is true, the
     * reference to Store should be deleted as it will not function correctly
     * any more.
     * 
     * @return
     */
    public native boolean isDestroyed()/*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		return jso.isDestroyed;
    }-*/;

    /**
     * Appends an event handler to this object.
     * 
     * @param callback
     */
    public native void addListener(String eventName, Function callback)/*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		jso.addListener(eventName, function() {
			callback.@com.eemi.ext4j.client.core.Function::execute()();
		});
    }-*/;

    /**
     * Clear any groupers in the store
     */
    public native void clearGrouping()/*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		jso.clearGrouping();
    }-*/;

    /**
     * Removes all listeners for this object.
     */
    public native void clearListeners()/*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		jso.clearListeners();
    }-*/;

    /**
     * Calls the specified function for each of the BaseModels in the cache.
     * Returning false aborts and exits the iteration.
     * 
     * @param callback
     */
    public native void each(EachCallBack callback)/*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		jso
				.each(function(record) {
					var model = @com.eemi.ext4j.client.data.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
					callback.@com.eemi.ext4j.client.data.handlers.EachCallBack::onEach(Lcom/eemi/ext4j/client/data/BaseModel;)(model);
				});
    }-*/;

    /**
     * Gets the number of cached records.
     */
    public native int getCount()/*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		return jso.getCount();
    }-*/;

    /**
     * Returns the string to group on for a given model instance. The default
     * implementation of this method returns the model's groupField, but this
     * can be overridden to group by an arbitrary string.
     * 
     * @param handler
     * @return
     */

    public native String addGroupingHandler(GroupingHandler handler)/*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		jso.getGroupString = function(record) {
			var model = @com.eemi.ext4j.client.data.BaseModel::new(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
			return handler.@com.eemi.ext4j.client.data.handlers.GroupingHandler::forEach(Lcom/eemi/ext4j/client/data/BaseModel;)(model);
		};
    }-*/;

    /**
     * Returns the total number of DataModel instances that the ProxyConfig
     * indicates exist. This will usually differ from getCount when using paging
     * - getCount returns the number of records loaded into the Store at the
     * moment, getTotalCount returns the number of records that could be loaded
     * into the Store if the Store contained all data
     */
    public native int getTotalCount()/*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		return jso.getTotalCount();
    }-*/;

    /**
     * Determines the page from a record index
     * 
     * @param index
     * @return
     */
    public native int getPageFromRecordlIndex(int index)/*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		return jso.getPageFromRecordIndex();
    }-*/;

    /**
     * Checks to see if this object has any listeners for a specified event
     * 
     * @param index
     * @return
     */
    public native boolean hasListener(int index)/*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		return jso.hasListener();
    }-*/;

    /**
     * Loads the next 'page' in the current data set
     */
    public native void nextPage()/*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		jso.nextPage();
    }-*/;

    public native void nextPage(Object options)/*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		jso.nextPage(options);
    }-*/;

    /**
     * Loads the next 'page' in the current data set
     */
    public native void previousPage()/*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		jso.previousPage();
    }-*/;

    public native void previousPage(Object options)/*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		jso.previousPage(options);
    }-*/;

    /**
     * The collection of sorters currently applied to this Store
     */
    public void setSorters(ArrayList<String> sorters) {
        JsArrayString values = JsArrayString.createArray().cast();
        for (String s : sorters) {
            values.push(s);
        }
        _setSorters(values);
    }

    /**
     * The collection of sorters currently applied to this Store
     */
    public void setSorters(Sorter... sorters) {
        _setSorters(JsoHelper.convertToJavaScriptArray(sorters));
    }

    /**
     * The collection of sorters currently applied to this Store
     */
    public void setSorters(SorterConfig... sorters) {
        _setSorters(JsoHelper.convertToJavaScriptArray(sorters));
    }

    /**
     * The collection of groupers currently applied to this Store
     */
    public void setGroupers(Grouper... groupers) {
        _setSorters(JsoHelper.convertToJavaScriptArray(groupers));
    }

    /**
     * The collection of groupers currently applied to this Store
     */
    public void setGroupers(GrouperConfig... groupers) {
        _setSorters(JsoHelper.convertToJavaScriptArray(groupers));
    }

    /**
     * The collection of sorters currently applied to this Store
     * 
     * @param value
     */
    public void setSorters(String... sorters) {
        JsArrayString values = JsArrayString.createArray().cast();
        for (String s : sorters) {
            values.push(s);
        }
        _setSorters(values);
    }

    /**
     * Adds DataModel instance to the Store.
     * 
     * @param value
     */
    public void add(BaseModel... values) {
        add(Arrays.asList(values));
        for (BaseModel m : values) {
            elements.add(m);
        }
    }

    public void add(List<? extends BaseModel> data) {
        JavaScriptObject[] storeData = new JavaScriptObject[data.size()];
        for (int i = 0; i < data.size(); i++) {
            storeData[i] = data.get(i).getJsObj();
        }
        add(JsoHelper.arrayConvert(storeData));

    }

    /**
     * Removes the given record from the Store, firing the 'remove' event for
     * each instance that is removed, plus a single 'datachanged' event after
     * removal.
     * 
     * @param value
     */
    public void remove(BaseModel value) {
        remove(value.getJsObj());
    }

    /**
     * Removes the given record from the Store, firing the 'remove' event for
     * each instance that is removed, plus a single 'datachanged' event after
     * removal.
     * 
     * @param data
     */
    public void remove(List<? extends BaseModel> data) {
        JavaScriptObject[] storeData = new JavaScriptObject[data.size()];
        for (int i = 0; i < data.size(); i++) {
            storeData[i] = data.get(i).getJsObj();
        }
        remove(JsoHelper.arrayConvert(storeData));

    }

    public void removeAll() {
        elements.clear();
        _removeAll();
    }

    private native void _removeAll()/*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		jso.removeAll();
    }-*/;

    public void removeAt(int index) {
        elements.remove(index);
        _removeAt(index);
    }

    private native void _removeAt(int index)/*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		jso.removeAt(index);
    }-*/;

    public native void resumeEvents()/*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		jso.resumentEvents();
    }-*/;

    public void removeAll(boolean silent) {
        elements.clear();
        _removeAll(silent);
    }

    private native void _removeAll(boolean silent)/*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		jso.removeAll(silent);
    }-*/;

    public void setFields(String value) {
        JsoHelper.setAttribute(jsObj, "fields", value);
    }

    /**
     * Loads an array of data straight into the Store
     * 
     * @param data
     *            , Array of data to load
     * @param append
     *            , True to add the records to the existing records in the
     *            store, false to remove the old ones first
     */
    public void loadData(ArrayList<? extends BaseModel> data, boolean append) {
        JavaScriptObject[] storeData = new JavaScriptObject[data.size()];
        for (int i = 0; i < data.size(); i++) {
            storeData[i] = data.get(i).getJsObj();
        }
        if (append) {
            elements.clear();
        }
        elements.addAll(data);
        loadData(JsoHelper.arrayConvert(storeData), append);
    }

    public void loadData(ArrayList<? extends BaseModel> data) {
        JavaScriptObject[] storeData = new JavaScriptObject[data.size()];
        for (int i = 0; i < data.size(); i++) {
            storeData[i] = data.get(i).getJsObj();
        }
        elements.addAll(data);
        loadData(JsoHelper.arrayConvert(storeData), false);

    }

    /**
     * Loads a given 'page' of data by setting the start and limit values
     * appropriately. Internally this just causes a normal load operation,
     * passing in calculated 'start' and 'limit' params
     * 
     * @param page
     * @param options
     */
    public native void loadPage(int page, Object options)/*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		jso.loadPage(page, options);
    }-*/;

    /**
     * Loads a given 'page' of data by setting the start and limit values
     * appropriately. Internally this just causes a normal load operation,
     * passing in calculated 'start' and 'limit' params
     * 
     * @param page
     */
    public native void loadPage(int page)/*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		jso.loadPage(page);
    }-*/;

    public native void load(int startParam, int limitParam)/*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		jso.load({
			params : {
				start : startParam,
				limit : limitParam
			}
		});
    }-*/;

    public void load(int limit) {
        load(0, limit);
    }

    public native void load(LoadCallback handler)/*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		jso
				.load($entry(function(recs, op, success) {
					var data = @com.eemi.ext4j.client.data.BaseModel::fromJsArray(Lcom/google/gwt/core/client/JavaScriptObject;)(recs);
					var operation = @com.eemi.ext4j.client.data.Operation::new(Lcom/google/gwt/core/client/JavaScriptObject;)(op);
					handler.@com.eemi.ext4j.client.data.handlers.LoadCallback::onLoad(Ljava/util/List;Lcom/eemi/ext4j/client/data/Operation;Z)(data,operation,success);
				}));
    }-*/;

    public native void addDataAddedHandler(DataAddedHandler handler)/*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		jso
				.addListener(
						"add",
						function(store, data) {
							var s = @com.eemi.ext4j.client.data.Store::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(store);
							handler.@com.eemi.ext4j.client.data.handlers.DataAddedHandler::onAdd(Lcom/eemi/ext4j/client/data/Store;Lcom/google/gwt/core/client/JavaScriptObject;)(s, data);
						});
    }-*/;

    public native void addBeforeLoadHandler(BeforeLoadHandler handler)/*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		jso
				.addListener(
						"beforeload",
						function(store) {
							var s = @com.eemi.ext4j.client.data.Store::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(store);
							handler.@com.eemi.ext4j.client.data.handlers.BeforeLoadHandler::onBeforeLoad(Lcom/eemi/ext4j/client/data/Store;)(s);
						});
    }-*/;

    public native void addBeforePrefetch(BeforePrefetchHandler handler)/*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		jso
				.addListener(
						"beforeprefetch",
						function(store) {
							var s = @com.eemi.ext4j.client.data.Store::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(store);
							handler.@com.eemi.ext4j.client.data.handlers.BeforePrefetchHandler::onBeforePrefetch(Lcom/eemi/ext4j/client/data/Store;)(s);
						});
    }-*/;

    public native void addClearHandler(ClearHandler handler)/*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		jso
				.addListener(
						"clear",
						function(store) {
							var s = @com.eemi.ext4j.client.data.Store::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(store);
							handler.@com.eemi.ext4j.client.data.handlers.ClearHandler::onClear(Lcom/eemi/ext4j/client/data/Store;)(s);
						});
    }-*/;

    public native void addDataChangedHandler(DataChangedHandler handler)/*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		jso
				.addListener(
						"datachanged",
						function(store) {
							var s = @com.eemi.ext4j.client.data.Store::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(store);
							handler.@com.eemi.ext4j.client.data.handlers.DataChangedHandler::onDataChanged(Lcom/eemi/ext4j/client/data/Store;)(s);
						});
    }-*/;

    public native void addRemoveHandler(RemoveHandler handler)/*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		jso
				.addListener(
						"remove",
						function(store) {
							var s = @com.eemi.ext4j.client.data.Store::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(store);
							handler.@com.eemi.ext4j.client.data.handlers.RemoveHandler::onRemove(Lcom/eemi/ext4j/client/data/Store;)(s);
						});
    }-*/;

    public native void addUpdateHandler(UpdateHandler handler)/*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		jso
				.addListener(
						"update",
						function(store) {
							var s = @com.eemi.ext4j.client.data.Store::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(store);
							handler.@com.eemi.ext4j.client.data.handlers.UpdateHandler::onUpdate(Lcom/eemi/ext4j/client/data/Store;)(s);
						});
    }-*/;

    public void loadData(JavaScriptObject data) {
        loadData(data, false);
    }

    public void loadData(Object[] data) {
        loadData(JsoHelper.convertToJavaScriptArray(data));
    }

    public native void loadData(JavaScriptObject values, boolean append)/*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		jso.loadData(values, append);
    }-*/;

    // Private methods

    private native void _setSorters(JavaScriptObject values)/*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		jso.sorters = values;
    }-*/;

    private native void _setGroupers(JavaScriptObject values)/*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		jso.groupers = values;
    }-*/;

    private native void setData(JavaScriptObject value)/*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		jso.data = value;
    }-*/;

    private native void setDefaultSortDirection(String value)/*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		jso.defaultSortDirection = value;
    }-*/;

    private native String _getDefaultSortDirection()/*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		return jso.defaultSortDirection;
    }-*/;

    private native void setGroupDir(String value)/*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		jso.groupDir = value;
    }-*/;

    private native String _getGroupDir()/*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		return jso.groupDir;
    }-*/;

    private native void add(JavaScriptObject value)/*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		jso.add(value);
    }-*/;

    private native void remove(JavaScriptObject value)/*-{
		var jso = this.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		jso.remove(value);
    }-*/;

    private native void create(String modelName, JavaScriptObject values)/*-{
		this.@com.eemi.ext4j.client.core.JsObject::jsObj = new $wnd.Ext.data.Store(
				{
					model : modelName,
					data : values
				});
    }-*/;

    private native void create(String modelName, JavaScriptObject values, ProxyConfig storeProxyConfig)/*-{
		var peer = storeProxyConfig.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		this.@com.eemi.ext4j.client.core.JsObject::jsObj = new $wnd.Ext.data.Store(
				{
					model : modelName,
					data : values,
					proxy : peer
				});
    }-*/;

    private native void create(String modelName, ProxyConfig storeProxyConfig)/*-{
		var peer = storeProxyConfig.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		this.@com.eemi.ext4j.client.core.JsObject::jsObj = new $wnd.Ext.data.Store(
				{
					model : modelName,
					proxy : peer
				});
    }-*/;

    private native void create(ProxyConfig storeProxyConfig, JavaScriptObject fieldsValue)/*-{
		var peer = storeProxyConfig.@com.eemi.ext4j.client.core.JsObject::getJsObj()();
		this.@com.eemi.ext4j.client.core.JsObject::jsObj = new $wnd.Ext.data.Store(
				{
					fields : fieldsValue,
					proxy : peer
				});
    }-*/;

}
