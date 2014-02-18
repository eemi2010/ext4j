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
package com.ati.ext4j.client.connection;

/**
 * The ConnectionListener interface.
 * 
 * @see Connection
 */
public interface ConnectionListener {

    /**
     * Fires before a network request is made to retrieve a data object.
     * 
     * @param conn
     *            the Collection
     * @return false to abort the request
     */
    boolean doBeforeRequest(Connection conn);

    /**
     * Fires if the request was successfully completed.
     * 
     * @param conn
     *            the Connection
     * @param responseText
     *            the response text
     */
    void onRequestComplete(Connection conn, String responseText);

    /**
     * Fires if an error HTTP status was returned from the server.
     * 
     * @param conn
     *            the Connection
     * @param httpStatus
     *            the http status code
     * @param responseText
     *            the response text
     */
    void onRequestException(Connection conn, int httpStatus, String responseText);
}
