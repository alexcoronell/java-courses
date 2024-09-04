package com.platzi.util;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.*;

class DateUtilLeapYearShould {

    /*
    All years divisible by 400 are leap years (1600, 2000, 2400)
    All years divisible by 100 but not by 400 are NOT leat years (1700, 1800, 1900)
    All years divisible by 4 but not by 100 are leap years (1996, 2004, 2008(
    All years not divisible by 4 are NOT leap years (2017m 2018, 2019)
     */

    @Test
    void return_true_when_year_is_divisible_by_400() {
        assertThat(DateUtilLeapYear.isLeapYear(1600), is(true));
        assertThat(DateUtilLeapYear.isLeapYear(2000), is(true));
        assertThat(DateUtilLeapYear.isLeapYear(2400), is(true));
    }

    @Test
    void return_false_when_year_is_divisible_by_100_but_not_400(){
        assertThat(DateUtilLeapYear.isLeapYear(1700), is(false));
        assertThat(DateUtilLeapYear.isLeapYear(1800), is(false));
        assertThat(DateUtilLeapYear.isLeapYear(1900), is(false));
    }

    @Test
    void return_true_when_year_is_divisible_by_4_but_not_100(){
        assertThat(DateUtilLeapYear.isLeapYear(1996), is(true));
        assertThat(DateUtilLeapYear.isLeapYear(2004), is(true));
        assertThat(DateUtilLeapYear.isLeapYear(2008), is(true));
    }

    @Test
    void return_false_when_year_is_not_divisible_by_4(){
        assertThat(DateUtilLeapYear.isLeapYear(1996), is(true));
        assertThat(DateUtilLeapYear.isLeapYear(2004), is(true));
        assertThat(DateUtilLeapYear.isLeapYear(2008), is(true));
    }
}