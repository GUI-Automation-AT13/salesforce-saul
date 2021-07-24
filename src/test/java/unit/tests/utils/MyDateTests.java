/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package unit.tests.utils;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import core.utils.MyDate;
import java.util.Calendar;

public class MyDateTests {

    @Test(dataProvider = "validInputData")
    public void validateInputshouldReturnTrue(String input) {
        MyDate myDate = new MyDate();
        Assert.assertTrue(myDate.validateInput(input));
    }

    @Test(dataProvider = "invalidInputData")
    public void validateInputshouldReturnFalse(String input) {
        MyDate myDate = new MyDate();
        Assert.assertFalse(myDate.validateInput(input));
    }

    @DataProvider(name = "validInputData")
    public static Object[][] validInputData() {
        return new Object[][]{
                {"3 days ago"},
                {"10 months ago"},
                {"3 years from now"},
                {"500 seconds ago"},
                {"1000 hours from now"}
        };
    }

    @DataProvider(name = "invalidInputData")
    public static Object[][] invalidInputData() {
        return new Object[][]{
                {"0 months from now"},
                {"1 hours from now"},
                {"2 hour ago"}
        };
    }

    @Test
    public void getTodayShouldReturnTheCorrectDate() throws Exception {
        MyDate myDate = new MyDate();
        Calendar calendar;
        calendar = Calendar.getInstance();
        Assert.assertEquals(calendar.getTime().toString(), myDate.get("TODAY").toString());
    }

    @Test
    public void getTomorrowShouldReturnTheCorrectDate() throws Exception {
        MyDate myDate = new MyDate();
        Calendar calendar;
        calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        Assert.assertEquals(calendar.getTime().toString(), myDate.get("TOMORROW").toString());
    }

    @Test
    public void getYesterdayShouldReturnTheCorrectDate() throws Exception {
        MyDate myDate = new MyDate();
        Calendar calendar;
        calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, -1);
        Assert.assertEquals(calendar.getTime().toString(), myDate.get("YESTERDAY").toString());
    }

    @Test
    public void get100SecondsAgoShouldReturnTheCorrectDate() throws Exception {
        MyDate myDate = new MyDate();
        Calendar calendar;
        calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, -100);
        Assert.assertEquals(calendar.getTime().toString(), myDate.get("100 seconds ago").toString());
    }

    @Test
    public void get100SecondsFromNowShouldReturnTheCorrectDate() throws Exception {
        MyDate myDate = new MyDate();
        Calendar calendar;
        calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, 100);
        Assert.assertEquals(calendar.getTime().toString(), myDate.get("100 seconds from now").toString());
    }

    @Test
    public void get10MinutesAgoShouldReturnTheCorrectDate() throws Exception {
        MyDate myDate = new MyDate();
        Calendar calendar;
        calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, -100);
        Assert.assertEquals(calendar.getTime().toString(), myDate.get("100 minutes ago").toString());
    }

    @Test
    public void get10MinutesFromNowShouldReturnTheCorrectDate() throws Exception {
        MyDate myDate = new MyDate();
        Calendar calendar;
        calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, 100);
        Assert.assertEquals(calendar.getTime().toString(), myDate.get("100 minutes from now").toString());
    }

    @Test
    public void get5hoursAgoShouldReturnTheCorrectDate() throws Exception {
        MyDate myDate = new MyDate();
        Calendar calendar;
        calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR, -5);
        Assert.assertEquals(calendar.getTime().toString(), myDate.get("5 hours ago").toString());
    }


    @Test
    public void get5HoursFromNowShouldReturnTheCorrectDate() throws Exception {
        MyDate myDate = new MyDate();
        Calendar calendar;
        calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR, 5);
        Assert.assertEquals(calendar.getTime().toString(), myDate.get("5 hours from now").toString());
    }

    @Test
    public void get5DaysAgoShouldReturnTheCorrectDate() throws Exception {
        MyDate myDate = new MyDate();
        Calendar calendar;
        calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, -5);
        Assert.assertEquals(calendar.getTime().toString(), myDate.get("5 days ago").toString());
    }

    @Test
    public void get5DaysFromNowShouldReturnTheCorrectDate() throws Exception {
        MyDate myDate = new MyDate();
        Calendar calendar;
        calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 5);
        Assert.assertEquals(calendar.getTime().toString(), myDate.get("5 days from now").toString());
    }

    @Test
    public void get5weekAgoShouldReturnTheCorrectDate() throws Exception {
        MyDate myDate = new MyDate();
        Calendar calendar;
        calendar = Calendar.getInstance();
        calendar.add(Calendar.WEEK_OF_MONTH, -5);
        Assert.assertEquals(calendar.getTime().toString(), myDate.get("5 weeks ago").toString());
    }

    @Test
    public void get5weekFromNowShouldReturnTheCorrectDate() throws Exception {
        MyDate myDate = new MyDate();
        Calendar calendar;
        calendar = Calendar.getInstance();
        calendar.add(Calendar.WEEK_OF_MONTH, 5);
        Assert.assertEquals(calendar.getTime().toString(), myDate.get("5 weeks from now").toString());
    }

    @Test
    public void get5monthsAgoShouldReturnTheCorrectDate() throws Exception {
        MyDate myDate = new MyDate();
        Calendar calendar;
        calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -5);
        Assert.assertEquals(calendar.getTime().toString(), myDate.get("5 months ago").toString());
    }

    @Test
    public void get5monthsFromNowShouldReturnTheCorrectDate() throws Exception {
        MyDate myDate = new MyDate();
        Calendar calendar;
        calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 5);
        Assert.assertEquals(calendar.getTime().toString(), myDate.get("5 months from now").toString());
    }

    @Test
    public void get5yearsAgoShouldReturnTheCorrectDate() throws Exception {
        MyDate myDate = new MyDate();
        Calendar calendar;
        calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, -5);
        Assert.assertEquals(calendar.getTime().toString(), myDate.get("5 years ago").toString());
    }

    @Test
    public void get5yearsFromNowShouldReturnTheCorrectDate() throws Exception {
        MyDate myDate = new MyDate();
        Calendar calendar;
        calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, 5);
        System.out.println(calendar.getTime().toString());
        Assert.assertEquals(calendar.getTime().toString(), myDate.get("5 years from now").toString());
    }

    @DataProvider(name = "invalidGetData")
    public static Object[][] invalidGetData() {
        return new Object[][]{
                {"any text"},
                {"-2 seconds ago"},
                {"-2 seconds from now"},
                {"0 seconds ago"},
                {"0 seconds from now"},
                {"1 seconds ago"},
                {"1 seconds from now"},
                {"2 second ago"},
                {"2 second from now"},
                {"2 SECONDS AGO"},
                {"2 SECONDS FROM NOW"},

                {"-2 minutes ago"},
                {"-2 minutes from now"},
                {"0 minutes ago"},
                {"0 minutes from now"},
                {"1 minutes ago"},
                {"1 minutes from now"},
                {"2 minute ago"},
                {"2 minute from now"},
                {"2 MINUTES AGO"},
                {"2 MINUTES FROM NOW"},

                {"-2 hours ago"},
                {"-2 hours from now"},
                {"0 hours ago"},
                {"0 hours from now"},
                {"1 hours ago"},
                {"1 hours from now"},
                {"2 hour ago"},
                {"2 hour from now"},
                {"2 HOURS AGO"},
                {"2 HOURS FROM NOW"},

                {"-2 days ago"},
                {"-2 days from now"},
                {"0 days ago"},
                {"0 days from now"},
                {"1 days ago"},
                {"1 days from now"},
                {"2 day ago"},
                {"2 day from now"},
                {"2 DAYS AGO"},
                {"2 DAYs FROM NOW"},

                {"-2 weeks ago"},
                {"-2 weeks from now"},
                {"0 weeks ago"},
                {"0 weeks from now"},
                {"1 weeks ago"},
                {"1 weeks from now"},
                {"2 week ago"},
                {"2 week from now"},
                {"2 WEEKS AGO"},
                {"2 WEEKS FROM NOW"},

                {"-2 months ago"},
                {"-2 months from now"},
                {"0 months ago"},
                {"0 months from now"},
                {"1 months ago"},
                {"1 months from now"},
                {"2 month ago"},
                {"2 month from now"},
                {"2 MONTHS AGO"},
                {"2 MONTHS FROM NOW"},

                {"-2 years ago"},
                {"-2 years from now"},
                {"0 years ago"},
                {"0 years from now"},
                {"1 years ago"},
                {"1 years from now"},
                {"2 year ago"},
                {"2 year from now"},
                {"2 YEARS AGO"},
                {"2 YEARS FROM NOW"},
        };
    }

    @Test(dataProvider = "invalidGetData", expectedExceptions = Exception.class)
    public void getShouldReturnAnException(String input) throws Exception {
        MyDate myDate = new MyDate();
        myDate.get(input);
    }

    @Test
    public void get_02_02_2000_ShouldReturnTheCorrectDate() throws Exception {
        MyDate myDate = new MyDate();
        Calendar calendar;
        calendar = Calendar.getInstance();
        //Calendar month index starts at 0
        calendar.set(2000, 01, 02, 0, 0, 0);
        String actual = myDate.get("02/02/2000").toString();
        String expected = calendar.getTime().toString().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void get_12_31_1800_ShouldReturnTheCorrectDate() throws Exception {
        MyDate myDate = new MyDate();
        Calendar calendar;
        calendar = Calendar.getInstance();
        //Calendar month index starts at 0
        calendar.set(1900, 11, 31, 0, 0, 0);
        String actual = myDate.get("12/31/1900").toString();
        String expected = calendar.getTime().toString().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test(expectedExceptions = Exception.class)
    public void get_invalid_2000_02_01_ShouldThrowException() throws Exception {
        MyDate myDate = new MyDate();
        Calendar calendar;
        calendar = Calendar.getInstance();
        String actual = myDate.get("2000/02/01").toString();
    }

    @Test(expectedExceptions = Exception.class)
    public void get_invalid_13_01_2022_ShouldThrowException() throws Exception {
        MyDate myDate = new MyDate();
        Calendar calendar;
        calendar = Calendar.getInstance();
        String actual = myDate.get("13/01/2022").toString();
    }
}
