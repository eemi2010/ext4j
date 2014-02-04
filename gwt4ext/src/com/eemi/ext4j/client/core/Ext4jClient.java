package com.eemi.ext4j.client.core;

import com.emitrom.pilot.core.formfactor.client.ClientFactory;

/**
 * Ext4j Client class that injects Ext JS resources on demand. This class should
 * be used when implementing multi device/platform applications.Subclass should
 * override the <code>getJsPath()</code> and<code>getCssPath()</code>
 */
public abstract class Ext4jClient implements ClientFactory {

    @Override
    public void createClient() {
        new Ext4jInjector(getCssPath(), getJsPath()).inject(new Function() {

            @Override
            public void execute() {
                createUI();
            }
        });
    }

    /**
     * Return the path to the Ext JS File
     */
    public abstract String getJsPath();

    /**
     * Return the path to the Ext JS CSS File
     */
    public abstract String getCssPath();

    /**
     * Creates the User Interface
     */
    public abstract void createUI();

}
