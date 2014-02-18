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
package com.ati.ext4j.client.data.proxy;

import com.ati.ext4j.client.core.JsoHelper;
import com.ati.ext4j.client.data.BaseModel;

public abstract class ServerProxyConfig extends ProxyConfig {

    public void setUrl(String value) {
        JsoHelper.setAttribute(jsObj, "url", value);
    }

    public void setApi(ProxyApi api) {
        JsoHelper.setAttribute(jsObj, "api", api.getJsObj());
    }

    public void setCacheString(String value) {
        JsoHelper.setAttribute(jsObj, "cacheString", value);
    }

    public void setDirectionParam(String value) {
        JsoHelper.setAttribute(jsObj, "directionParam", value);
    }

    public void setFilterParam(String value) {
        JsoHelper.setAttribute(jsObj, "filterParam", value);
    }

    public void setGroupDirectionParam(String value) {
        JsoHelper.setAttribute(jsObj, "groupDirectionParam", value);
    }

    public void setGroupParam(String value) {
        JsoHelper.setAttribute(jsObj, "groupParam", value);
    }

    public void setIdParam(String value) {
        JsoHelper.setAttribute(jsObj, "idParam", value);
    }

    public void setLimitParam(String value) {
        JsoHelper.setAttribute(jsObj, "limitParam", value);
    }

    public void setModel(String value) {
        JsoHelper.setAttribute(jsObj, "model", value);
    }

    public void setModel(BaseModel value) {
        JsoHelper.setAttribute(jsObj, "model", value.getJsObj());
    }

    public void setSimpleGroupMode(boolean value) {
        JsoHelper.setAttribute(jsObj, "simpleGroupMode", value);
    }

    public void setSimpleSortMode(boolean value) {
        JsoHelper.setAttribute(jsObj, "simpleSortMode", value);
    }

    public void setSortParam(String value) {
        JsoHelper.setAttribute(jsObj, "sortParam", value);
    }

    public void setTimeOut(int value) {
        JsoHelper.setAttribute(jsObj, "timeout", value);
    }

}
