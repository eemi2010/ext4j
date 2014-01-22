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

import com.google.gwt.core.ext.LinkerContext;
import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.core.ext.UnableToCompleteException;
import com.google.gwt.core.ext.linker.ArtifactSet;
import com.google.gwt.core.ext.linker.CompilationResult;
import com.google.gwt.core.ext.linker.impl.PermutationsUtil;
import com.google.gwt.core.linker.XSLinker;

public class SwfXSLinker extends XSLinker {

    @Override
    public String getDescription() {
        return "Flash (" + super.getDescription() + " with support for injected SWF \"scripts\")";
    }

    /**
     * Generate a selection script. The selection information should previously
     * have been scanned using
     * {@link PermutationsUtil#setupPermutationsMap(ArtifactSet)}.
     */
    @Override
    protected String fillSelectionScriptTemplate(StringBuffer selectionScript, TreeLogger logger,
                    LinkerContext context, ArtifactSet artifacts, CompilationResult result)
                    throws UnableToCompleteException {
        String script = super.fillSelectionScriptTemplate(selectionScript, logger, context, artifacts, result);
        return ScriptInjectionUtils.fixScriptInjector(script);
    }

}
