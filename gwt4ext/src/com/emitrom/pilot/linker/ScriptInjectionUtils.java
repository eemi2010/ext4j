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
package com.emitrom.pilot.linker;

import java.util.regex.Pattern;

class ScriptInjectionUtils {

    private static final Pattern languageJavascriptAttribute = Pattern.compile(
                    "language=((?:\\\\?[\"'])?)javascript\1", Pattern.CASE_INSENSITIVE);

    public static String fixScriptInjector(String scriptInjector) {
        if (scriptInjector.indexOf(".swf") >= 0) {
            scriptInjector = languageJavascriptAttribute.matcher(scriptInjector).replaceAll(
                            "type=$1application/x-shockwave-flash$1");
        }
        return scriptInjector;
    }

}
