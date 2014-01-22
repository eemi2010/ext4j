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
package com.eemi.ext4j.client.util;

import java.util.Date;

/**
 * The date parsing and format syntax is a subset of PHP's date() function, and
 * the formats that are supported will provide results equivalent to their PHP
 * versions. Following is the list of all currently supported formats:
 * <p/>
 * <p/>
 * 
 * <pre>
 * <p/>
 * Sample date:
 * 'Wed Jan 10 2007 15:05:01 GMT-0600 (Central Standard Time)'
 * <p/>
 * Format  Description                                                               Example returned values
 * ------  -----------------------------------------------------------------------   -----------------------
 *   d     Day of the month, 2 digits with leading zeros                             01 to 31
 *   D     A short textual representation of the day of the week                     Mon to Sun
 *   j     Day of the month without leading zeros                                    1 to 31
 *   l     A full textual representation of the day of the week                      Sunday to Saturday
 *   N     ISO-8601 numeric representation of the day of the week                    1 (for Monday) through 7 (for Sunday)
 *   S     English ordinal suffix for the day of the month, 2 characters             st, nd, rd or th. Works well with j
 *   w     Numeric representation of the day of the week                             0 (for Sunday) to 6 (for Saturday)
 *   z     The day of the year (starting from 0)                                     0 to 364 (365 in leap years)
 *   W     ISO-8601 week number of year, weeks starting on Monday                    01 to 53
 *   F     A full textual representation of a month, such as January or March        January to December
 *   m     Numeric representation of a month, with leading zeros                     01 to 12
 *   M     A short textual representation of a month                                 Jan to Dec
 *   n     Numeric representation of a month, without leading zeros                  1 to 12
 *   t     Number of days in the given month                                         28 to 31
 *   L     Whether it's a leap year                                                  1 if it is a leap year, 0 otherwise.
 *   o     ISO-8601 year number (identical to (Y), but if the ISO week number (W)    Examples: 1998 or 2004
 *         belongs to the previous or next year, that year is used instead)
 *   Y     A full numeric representation of a year, 4 digits                         Examples: 1999 or 2003
 *   y     A two digit representation of a year                                      Examples: 99 or 03
 *   a     Lowercase Ante meridiem and Post meridiem                                 am or pm
 *   A     Uppercase Ante meridiem and Post meridiem                                 AM or PM
 *   g     12-hour format of an hour without leading zeros                           1 to 12
 *   G     24-hour format of an hour without leading zeros                           0 to 23
 *   h     12-hour format of an hour with leading zeros                              01 to 12
 *   H     24-hour format of an hour with leading zeros                              00 to 23
 *   i     Minutes, with leading zeros                                               00 to 59
 *   s     Seconds, with leading zeros                                               00 to 59
 *   u     Milliseconds, with leading zeros                                          001 to 999
 *   O     Difference to Greenwich time (GMT) in hours and minutes                   Example: +1030
 *   P     Difference to Greenwich time (GMT) with colon between hours and minutes   Example: -08:00
 *   T     Timezone abbreviation of the machine running the code                     Examples: EST, MDT, PDT ...
 *   Z     Timezone offset in seconds (negative if west of UTC, positive if east)    -43200 to 50400
 *   c     ISO 8601 date                                                             2007-04-17T15:19:21+08:00
 *   U     Seconds since the Unix Epoch (January 1 1970 00:00:00 GMT)                1193432466 or -2138434463
 * <p/>
 * </pre>
 * 
 * @author Alain Ekambi
 */
public class DateUtil {

    public static class Interval {
        private String interval;

        private Interval(String direction) {
            this.interval = direction;
        }

        public String getInterval() {
            return interval;
        }
    }

    public static Interval MILLI = new Interval("ms");
    public static Interval SECOND = new Interval("s");
    public static Interval MINUTE = new Interval("mi");
    public static Interval HOUR = new Interval("h");
    public static Interval DAY = new Interval("d");
    public static Interval MONTH = new Interval("mo");
    public static Interval YEAR = new Interval("y");

    /**
     * Allocates a <code>Date</code> object and initializes it to represent the
     * specified number of milliseconds since the standard base time known as
     * "the epoch", namely January 1, 1970, 00:00:00 GMT.
     * 
     * @param time
     *            the time in milliseconds
     * @return date
     */
    public static Date create(double time) {
        return new Date((long) time);
    }

    /**
     * Returns the number of milliseconds since January 1, 1970, 00:00:00 GMT
     * represented by this Date object.
     * 
     * @param date
     *            the date
     * @return time in milliseconds
     */
    public static double getTime(Date date) {
        return date.getTime();
    }

    /**
     * Formats a date given the supplied format string. You can also use GWT's
     * standard {@link com.google.gwt.i18n.client.DateTimeFormat} class.
     * 
     * @param date
     *            the date
     * @param format
     *            the format string
     * @return the formatted date
     * @see com.google.gwt.i18n.client.DateTimeFormat
     */
    public static native String format(Date date, String format) /*-{
		if (date == null)
			return "";
		else if (format == null)
			return "";

		var millis = @com.eemi.ext4j.client.util.DateUtil::getTime(Ljava/util/Date;)(date);
		return $wnd.Ext.Date.format(new $wnd.Date(millis), format);
    }-*/;

    /**
     * Parses the passed string using the specified format. Note that this
     * function expects dates in normal calendar format, meaning that months are
     * 1-based (1 = January) and not zero-based like in JavaScript dates. Any
     * part of the date format that is not specified will default to the current
     * date value for that part. Time parts can also be specified, but default
     * to 0. Keep in mind that the input date string must precisely match the
     * specified format string or the parse operation will fail.
     * 
     * @param input
     *            the unparsed date as a string
     * @param format
     *            the format string
     * @return the parsed date
     */
    public static native Date parse(String input, String format)/*-{
        var date = $wnd.Ext.Date.parse(input, format);
        return @com.eemi.ext4j.client.util.DateUtil::create(D)(date.getTime());
    }-*/;

    /**
     * Provides a convenient method of performing basic date arithmetic. This
     * method does not modify the Date instance being called - it creates and
     * returns a new Date instance containing the resulting date value.
     * 
     * @param date
     *            the date
     * @param interval
     *            the interval enum
     * @param value
     *            the value to add
     * @return the new Date
     */
    public static native Date add(Date date, Interval interval, int value)/*-{
        var intervalJS = interval.@com.eemi.ext4j.client.util.DateUtil.Interval::getInterval()();
        var millis = @com.eemi.ext4j.client.util.DateUtil::getTime(Ljava/util/Date;)(date);
        var dateJS = new $wnd.Date(millis);
        var newDate = $wnd.Ext.Date.add(dateJs,intervalJS, value);
        return  @com.eemi.ext4j.client.util.DateUtil::create(D)(newDate.getTime());
    }-*/;

    /**
     * Clears any time information from this date.
     * 
     * @param date
     *            the date
     * @return the new date
     */
    public static native Date clearTime(Date date)/*-{
        var millis = @com.eemi.ext4j.client.util.DateUtil::getTime(Ljava/util/Date;)(date);
        var dateJS = new $wnd.Date(millis);
        var newDate = dateJS.clearTime();
        return @com.eemi.ext4j.client.util.DateUtil::create(D)(newDate.getTime());
    }-*/;

    /**
     * Get the numeric day number of the year, adjusted for leap year.
     * 
     * @param date
     *            the date
     * @return 0 through 364 (365 in leap years)
     */
    public static native int getDayOfYear(Date date) /*-{
		var millis = @com.eemi.ext4j.client.util.DateUtil::getTime(Ljava/util/Date;)(date);
		var dateJS = new $wnd.Date(millis);
		return dateJS.getDayOfYear();
    }-*/;

    /**
     * Get the number of days in the current month, adjusted for leap year.
     * 
     * @param date
     *            the date
     * @return the number of days in the month
     */
    public static native int getDaysInMonth(Date date) /*-{
		var millis = @com.eemi.ext4j.client.util.DateUtil::getTime(Ljava/util/Date;)(date);
		var dateJS = new $wnd.Date(millis);
		return dateJS.getDaysInMonth();
    }-*/;

    /**
     * Get the first date of this date's month
     * 
     * @param date
     *            the date
     * @return the new date
     */
    public static native Date getFirstDateOfMonth(Date date) /*-{
        var millis = @com.eemi.ext4j.client.util.DateUtil::getTime(Ljava/util/Date;)(date);
        var dateJS = new $wnd.Date(millis);
        var newDate = dateJS.getFirstDateOfMonth();
        return @com.eemi.ext4j.client.util.DateUtil::create(D)(newDate.getTime());
    }-*/;

    /**
     * Get the first day of the current month, adjusted for leap year. The
     * returned value is the numeric day index within the week (0-6).
     * 
     * @param date
     *            the date
     * @return the day number (0-6)
     */
    public static native int getFirstDayOfMonth(Date date) /*-{
		var millis = @com.eemi.ext4j.client.util.DateUtil::getTime(Ljava/util/Date;)(date);
		var dateJS = new $wnd.Date(millis);
		return dateJS.getFirstDayOfMonth();
    }-*/;

    /**
     * Get the offset from GMT of the current date.
     * 
     * @param date
     *            the date
     * @return the 4-character offset string prefixed with + or - (e.g. '-0600')
     */
    public static native String getGMTOffset(Date date) /*-{
		var millis = @com.eemi.ext4j.client.util.DateUtil::getTime(Ljava/util/Date;)(date);
		var dateJS = new $wnd.Date(millis);
		return dateJS.getGMTOffset();
    }-*/;

    /**
     * Get the last date of this date's month.
     * 
     * @param date
     *            the date
     * @return the new date
     */
    public static native Date getLastDateOfMonth(Date date) /*-{
        var millis = @com.eemi.ext4j.client.util.DateUtil::getTime(Ljava/util/Date;)(date);
        var dateJS = new $wnd.Date(millis);
        var newDate = dateJS.getLastDateOfMonth();
        return @com.eemi.ext4j.client.util.DateUtil::create(D)(newDate.getTime());
    }-*/;

    /**
     * Get the last day of the current month, adjusted for leap year. The
     * returned value is the numeric day index within the week (0-6).
     * 
     * @param date
     *            the date
     * @return the day number (0-6)
     */
    public static native int getLastDayOfMonth(Date date) /*-{
		var millis = @com.eemi.ext4j.client.util.DateUtil::getTime(Ljava/util/Date;)(date);
		var dateJS = new $wnd.Date(millis);
		return dateJS.getLastDayOfMonth();
    }-*/;

    /**
     * Get the timezone abbreviation of the current date.
     * 
     * @param date
     *            the date
     * @return the abbreviated timezone name (e.g. 'CST')
     */
    public static native String getTimezone(Date date) /*-{
		var millis = @com.eemi.ext4j.client.util.DateUtil::getTime(Ljava/util/Date;)(date);
		var dateJS = new $wnd.Date(millis);
		return dateJS.getTimezone();
    }-*/;

    /**
     * Get the string representation of the numeric week number of the year.
     * 
     * @param date
     *            the date
     * @return 0 through 52
     */
    public static native int getWeekOfYear(Date date) /*-{
		var millis = @com.eemi.ext4j.client.util.DateUtil::getTime(Ljava/util/Date;)(date);
		var dateJS = new $wnd.Date(millis);
		return dateJS.getWeekOfYear();
    }-*/;

    /**
     * Whether or not the current date is in a leap year.
     * 
     * @param date
     *            the date
     * @return true if date is in a leap year
     */
    public static native boolean isLeapYear(Date date) /*-{
		var millis = @com.eemi.ext4j.client.util.DateUtil::getTime(Ljava/util/Date;)(date);
		var dateJS = new $wnd.Date(millis);
		return dateJS.isLeapYear();
    }-*/;

}
