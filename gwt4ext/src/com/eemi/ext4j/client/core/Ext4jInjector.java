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
package com.eemi.ext4j.client.core;

import com.emitrom.pilot.core.formfactor.client.JsLoadCallback;
import com.emitrom.pilot.core.formfactor.client.ResourceInjector;

/**
 * Utility class to inject Ext4j resources. This class should be used while
 * developing for different devices and form factors. The class will help you
 * inject Ext JS on demand
 * 
 */
public class Ext4jInjector extends ResourceInjector {

    public Ext4jInjector(String extCSSLink, String extJsLink) {
        super(extCSSLink, extJsLink);
    }

    public void inject(final Function handler) {
        this.setJsLoadCallback(new JsLoadCallback() {
            @Override
            public void onJsLoaded() {
                Ext.onReady(handler);
            }
        }).inject();
    }

}
