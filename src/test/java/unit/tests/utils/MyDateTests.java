/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package unit.tests.utils;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.MyDate;

import java.util.Calendar;

public class MyDateTests {

    @Test
    public void validateInputshouldReturnExpectedBoolean() {
        MyDate myDate = new MyDate();
        Assert.assertTrue(myDate.validateInput("3 days ago"));
        Assert.assertTrue(myDate.validateInput("10 months ago"));
        Assert.assertTrue(myDate.validateInput("3 years from now"));
        Assert.assertTrue(myDate.validateInput("500 seconds ago"));
        Assert.assertTrue(myDate.validateInput("1000 hours from now"));
        Assert.assertFalse(myDate.validateInput("0 months from now"));
        Assert.assertFalse(myDate.validateInput("1 hours from now"));
        Assert.assertFalse(myDate.validateInput("2 hour ago"));
    }

    @Test
    public void getTodayShouldReturnTheCorrectDate() throws Exception {
        MyDate myDate = new MyDate();
        Calendar c;
        c = Calendar.getInstance();
        Assert.assertEquals(c.getTime().toString(), myDate.get("TODAY").toString());
    }

    @Test
    public void getTomorrowShouldReturnTheCorrectDate() throws Exception {
        MyDate myDate = new MyDate();
        Calendar c;
        c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_YEAR, 1);
        Assert.assertEquals(c.getTime().toString(), myDate.get("TOMORROW").toString());
    }

    @Test
    public void getYesterdayShouldReturnTheCorrectDate() throws Exception {
        MyDate myDate = new MyDate();
        Calendar c;
        c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_YEAR, -1);
        Assert.assertEquals(c.getTime().toString(), myDate.get("YESTERDAY").toString());
    }

    @Test
    public void get10yearsAgoShouldReturnTheCorrectDate() throws Exception {
        MyDate myDate = new MyDate();
        Calendar c;
        c = Calendar.getInstance();
        c.add(Calendar.YEAR, -10);
        Assert.assertEquals(c.getTime().toString(), myDate.get("10 years ago").toString());
    }

    @Test
    public void get100SecondsAgoShouldReturnTheCorrectDate() throws Exception {
        MyDate myDate = new MyDate();
        Calendar c;
        c = Calendar.getInstance();
        c.add(Calendar.SECOND, -100);
        Assert.assertEquals(c.getTime().toString(), myDate.get("100 seconds ago").toString());
    }

    @Test
    public void get5yearsFromNowShouldReturnTheCorrectDate() throws Exception {
        MyDate myDate = new MyDate();
        Calendar c;
        c = Calendar.getInstance();
        c.add(Calendar.YEAR, 5);
        System.out.println(c.getTime().toString());
        Assert.assertEquals(c.getTime().toString(), myDate.get("5 years from now").toString());
    }

    @Test(expectedExceptions = Exception.class)
    public void get0weekFromNowShouldReturnException() throws Exception {
        MyDate myDate = new MyDate();
        Calendar c;
        c = Calendar.getInstance();
        c.add(Calendar.WEEK_OF_MONTH, 0);
        Assert.assertEquals(c.getTime().toString(), myDate.get("0 weeks from now").toString());
    }

    @Test(expectedExceptions = Exception.class)
    public void getNegativeDayFromNowShouldReturnException() throws Exception {
        MyDate myDate = new MyDate();
        Calendar c;
        c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_YEAR, -2);
        Assert.assertEquals(c.getTime().toString(), myDate.get("-2 days from now").toString());
    }

    @Test(expectedExceptions = Exception.class)
    public void get0monthsAgoShouldReturnException() throws Exception {
        MyDate myDate = new MyDate();
        Calendar c;
        c = Calendar.getInstance();
        c.add(Calendar.MONTH, 0);
        Assert.assertEquals(c.getTime().toString(), myDate.get("0 months ago").toString());
    }

    @Test(expectedExceptions = Exception.class)
    public void get10yearFromNowShouldReturnException() throws Exception {
        MyDate myDate = new MyDate();
        Calendar c;
        c = Calendar.getInstance();
        c.add(Calendar.YEAR, 10);
        Assert.assertEquals(c.getTime().toString(), myDate.get("10 year from now").toString());
    }

    @Test
    public void get_02_02_2000_ShouldReturnTheCorrectDate() throws Exception {
        MyDate myDate = new MyDate();
        Calendar c;
        c = Calendar.getInstance();
        //Calendar month index starts at 0
        c.set(2000, 01, 02, 0, 0, 0);
        String actual = myDate.get("02/02/2000").toString();
        String expected = c.getTime().toString().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void get_12_31_1800_ShouldReturnTheCorrectDate() throws Exception {
        MyDate myDate = new MyDate();
        Calendar c;
        c = Calendar.getInstance();
        //Calendar month index starts at 0
        c.set(1900, 11, 31, 0, 0, 0);
        String actual = myDate.get("12/31/1900").toString();
        String expected = c.getTime().toString().trim();
        Assert.assertEquals(actual, expected);
    }

    @Test(expectedExceptions = Exception.class)
    public void get_invalid_2000_02_01_ShouldThrowException() throws Exception {
        MyDate myDate = new MyDate();
        Calendar c;
        c = Calendar.getInstance();
        String actual = myDate.get("2000/02/01").toString();
    }

    @Test(expectedExceptions = Exception.class)
    public void get_invalid_13_01_2022_ShouldThrowException() throws Exception {
        MyDate myDate = new MyDate();
        Calendar c;
        c = Calendar.getInstance();
        String actual = myDate.get("13/01/2022").toString();
    }
}
