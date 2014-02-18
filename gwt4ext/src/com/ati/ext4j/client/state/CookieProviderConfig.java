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
package com.ati.ext4j.client.state;

import java.util.Date;

import com.ati.ext4j.client.core.JsoHelper;
import com.ati.ext4j.client.core.config.BaseConfig;

/**
 * CookieProvider configuration.
 * 
 */
public class CookieProviderConfig extends BaseConfig {

    /**
     * The path for which the cookie is active (defaults to root '/' which makes
     * it active for all pages in the site).
     * 
     * @param path
     *            the path
     */
    public void setPath(String path) {
        JsoHelper.setAttribute(jsObj, "path", path);
    }

    /**
     * The cookie expiration date (defaults to 7 days from now).
     * 
     * @param days
     *            number of days
     */
    public void setExpires(int days) {
        Date now = new Date();
        long millis = now.getTime() + (1000 * 60 * 60 * 24 * days);
        JsoHelper.setAttribute(jsObj, "expires", millis);
    }

    /**
     * The domain to save the cookie for. Note that you cannot specify a
     * different domain than your page is on, but you can specify a sub-domain,
     * or simply the domain itself like 'extjs.com' to include all sub-domains
     * if you need to access cookies across different sub-domains (defaults to
     * null which uses the same domain the page is running on including the
     * 'www' like 'www.extjs.com')
     * 
     * @param domain
     *            the domain
     */
    public void setDomain(String domain) {
        JsoHelper.setAttribute(jsObj, "domain", domain);
    }

    /**
     * True if the site is using SSL (defaults to false).
     * 
     * @param secure
     *            true if using SSL
     */
    public void setSecure(boolean secure) {
        JsoHelper.setAttribute(jsObj, "secure", secure);
    }
}
