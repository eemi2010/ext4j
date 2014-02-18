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
package com.ait.ext4j.client.data;

import com.ait.ext4j.client.core.JsoHelper;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * Date field class. Following is the list of all currently supported formats:
 * <p/>
 * 
 * <pre>
 * <p/>
 * Sample date:
 * 'Wed Jan 10 2007 15:05:01 GMT-0600 (Central Standard Time)'
 * <p/>
 * Format  Output      Description
 * ------  ----------  --------------------------------------------------------------
 *   d      10         Day of the month, 2 digits with leading zeros
 *   D      Wed        A textual representation of a day, three letters
 *   j      10         Day of the month without leading zeros
 *   l      Wednesday  A full textual representation of the day of the week
 *   S      th         English ordinal day of month suffix, 2 chars (use with j)
 *   w      3          Numeric representation of the day of the week
 *   z      9          The julian date, or day of the year (0-365)
 *   W      01         ISO-8601 2-digit week number of year, weeks starting on Monday (00-52)
 *   F      January    A full textual representation of the month
 *   m      01         Numeric representation of a month, with leading zeros
 *   M      Jan        Month name abbreviation, three letters
 *   n      1          Numeric representation of a month, without leading zeros
 *   t      31         Number of days in the given month
 *   L      0          Whether it's a leap year (1 if it is a leap year, else 0)
 *   Y      2007       A full numeric representation of a year, 4 digits
 *   y      07         A two digit representation of a year
 *   a      pm         Lowercase Ante meridiem and Post meridiem
 *   A      PM         Uppercase Ante meridiem and Post meridiem
 *   g      3          12-hour format of an hour without leading zeros
 *   G      15         24-hour format of an hour without leading zeros
 *   h      03         12-hour format of an hour with leading zeros
 *   H      15         24-hour format of an hour with leading zeros
 *   i      05         Minutes with leading zeros
 *   s      01         Seconds, with leading zeros
 *   O      -0600      Difference to Greenwich time (GMT) in hours
 *   T      CST        Timezone setting of the machine running the code
 *   Z      -21600     Timezone offset in seconds (negative if west of UTC, positive if east)
 * </pre>
 * 
 *  
 */
public class DateFieldDefinition extends FieldDefinition {

    /**
     * Uses default date parsing via new Date(dataVal);
     * 
     * @param name
     *            field name
     */
    public DateFieldDefinition(String name) {
        this(name, null, null);
    }

    /**
     * Create a new DateFieldDefinition using the specified name and date format.
     * 
     * @param name
     *            the field name
     * @param dateFormat
     *            the date format
     */
    public DateFieldDefinition(String name, String dateFormat) {
        this(name, null, dateFormat);
    }

    /**
     * Create a new DateFieldDefinition using the specified name and date format.
     * 
     * @param name
     *            the field name
     * @param mapping
     *            the field mapping. Depending on the Reader used, mapping could
     *            be the array index position or an XPath expression when
     *            reading from XML
     * @param dateFormat
     *            the date format
     */
    public DateFieldDefinition(String name, String mapping, String dateFormat) {
        jsObj = create(name, mapping, dateFormat);
    }

    /**
     * Create a new DateFieldDefinition using the specified name and date format.
     * 
     * @param name
     *            the field name
     * @param mapping
     *            the field mapping, position based of local arrays
     * @param dateFormat
     *            the date format
     */
    public DateFieldDefinition(String name, int mapping, String dateFormat) {
        this(name, String.valueOf(mapping), dateFormat);
    }

    private static JavaScriptObject create(String name, String mapping, String dateFormat) {
        JavaScriptObject jsObj = JsoHelper.createObject();
        JsoHelper.setAttribute(jsObj, "name", name);
        JsoHelper.setAttribute(jsObj, "type", "date");
        if (mapping != null)
            JsoHelper.setAttribute(jsObj, "mapping", mapping);
        if (dateFormat != null)
            JsoHelper.setAttribute(jsObj, "dateFormat", dateFormat);
        return jsObj;
    }
}
