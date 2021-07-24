/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package core.utils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyDate {

    private static final int POSITIVE_VALUE = 1;
    private static final int NEGATIVE_VALUE = -1;
    private static final int MATCHER_GROUP_1 = 1;
    private static final int MATCHER_GROUP_2 = 2;
    private static final int MATCHER_GROUP_3 = 3;
    private static final String DATE_SIMPLE_FORMAT = "MM/dd/uuuu";
    private int value;
    private String timeUnit;
    private String time;
    private Calendar calendar;
    private Date parsedDate;

    /**
     * Gets a date from a valid input String. Valid inputs are:
     * Strings -> "TODAY", "TOMORROW", "YESTERDAY"
     * String with format-> {A number}
     *      {"seconds", "minutes", "hours", "days", "weeks", "months", "years"}
     *      {"ago", "from now"}
     * E.g.: "3 hours ago", "1 day from now", "100 minutes from now"
     * String representing a date with format MM/DD/YYYY, year greater or equal to 1900.
     * E.g.: "01/12/2000", "12/31/1990"
     *
     * @param input
     * @return Date
     * @throws Exception
     */
    public Date get(final String input) throws Exception {
        if (validateInput(input)) {
            return calculateDate();
        } else {
            if (isSimpleDate(input)) {
                return parsedDate;
            } else {
                throw new Exception("The input doesn't match a valid entry");
            }
        }
    }

    /**
     * Verify if input date has valid format.
     *
     * @param simpleDate
     * @return boolean
     */
    private boolean isSimpleDate(final String simpleDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_SIMPLE_FORMAT);
        try {
            LocalDate localDate = LocalDate.parse(simpleDate, formatter);
            ZoneId defaultZoneId = ZoneId.systemDefault();
            this.parsedDate = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Validates if  the input matches the valid formats.
     *
     * @param input
     * @return boolean
     */
    public boolean validateInput(final String input) {
        String inputPatternMultiple = "(\\b[2-9]\\b|\\d{2,}) "
                + "(seconds|minutes|hours|days|weeks|months|years) (ago|from now)";
        String inputPatternSingle = "(1) "
                + "(second|minute|hour|day|week|month|year) (ago|from now)";
        Pattern patternMultiple = Pattern.compile(inputPatternMultiple);
        Pattern patternSingle = Pattern.compile(inputPatternSingle);
        Matcher matcherM = patternMultiple.matcher(input);
        Matcher matcherS = patternSingle.matcher(input);
        if (input.matches("TODAY|TOMORROW|YESTERDAY")) {
            this.timeUnit = input;
            return true;
        }
        if (matcherM.matches()) {
            this.value = Integer.valueOf(matcherM.group(POSITIVE_VALUE));
            this.timeUnit = matcherM.group(MATCHER_GROUP_2);
            this.time = matcherM.group(MATCHER_GROUP_3);
            return true;
        }
        if (matcherS.matches()) {
            this.value = Integer.valueOf(matcherS.group(NEGATIVE_VALUE));
            this.timeUnit = matcherS.group(MATCHER_GROUP_2);
            this.time = matcherS.group(MATCHER_GROUP_3);
        }
        return false;
    }

    private Date calculateDate() {
        calendar = Calendar.getInstance();
        if (timeUnit.equals("TOMORROW")) {
            calendar.add(getTimeType(), POSITIVE_VALUE);
        }
        if (timeUnit.equals("YESTERDAY")) {
            calendar.add(getTimeType(), NEGATIVE_VALUE);
        }
        if (time != null && time.equals("ago")) {
            calendar.add(getTimeType(), value * NEGATIVE_VALUE);
        }
        if (time != null && time.equals("from now")) {
            calendar.add(getTimeType(), value);
        }
        return calendar.getTime();
    }

    private int getTimeType() {
        if (timeUnit.matches("TOMORROW|YESTERDAY")) {
            return Calendar.DAY_OF_YEAR;
        }
        if (timeUnit.matches("second|seconds")) {
            return Calendar.SECOND;
        }
        if (timeUnit.matches("minute|minutes")) {
            return Calendar.MINUTE;
        }
        if (timeUnit.matches("hour|hours")) {
            return Calendar.HOUR;
        }
        if (timeUnit.matches("day|days")) {
            return Calendar.DAY_OF_YEAR;
        }
        if (timeUnit.matches("week|weeks")) {
            return Calendar.WEEK_OF_MONTH;
        }
        if (timeUnit.matches("month|months")) {
            return Calendar.MONTH;
        }
        if (timeUnit.matches("year|years")) {
            return Calendar.YEAR;
        }
        return Calendar.DAY_OF_YEAR;
    }
}
