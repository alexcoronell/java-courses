package com.platzi.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class RomanNumeralsShould {
  private static RomanNumerals romanNumerals;

  @BeforeEach
  void setup(){
      romanNumerals = new RomanNumerals();
  }

  @Test
  void should_return_I_when_number_is_1(){
      String result = romanNumerals.arabicToRoman(1);

      assertThat(result, is("I"));
  }

    @Test
    void should_return_II_when_number_is_2(){
        String result = romanNumerals.arabicToRoman(2);

        assertThat(result, is("II"));
    }

    @Test
    void should_return_III_when_number_is_3(){
        String result = romanNumerals.arabicToRoman(3);

        assertThat(result, is("III"));
    }

    @Test
    void should_return_V_when_number_is_5(){
        String result = romanNumerals.arabicToRoman(5);

        assertThat(result, is("V"));
    }

    @Test
    void should_return_VI_when_number_is_6(){
        String result = romanNumerals.arabicToRoman(6);

        assertThat(result, is("VI"));
    }

    @Test
    void should_return_VII_when_number_is_7(){
        String result = romanNumerals.arabicToRoman(7);

        assertThat(result, is("VII"));
    }

    @Test
    void should_return_VIII_when_number_is_8(){
        String result = romanNumerals.arabicToRoman(8);

        assertThat(result, is("VIII"));
    }

    @Test
    void should_return_X_when_number_is_10(){
        String result = romanNumerals.arabicToRoman(10);

        assertThat(result, is("X"));
    }

    @Test
    void should_return_XI_when_number_is_11(){
        String result = romanNumerals.arabicToRoman(11);

        assertThat(result, is("XI"));
    }

    @Test
    void should_return_XIII_when_number_is_13(){
        String result = romanNumerals.arabicToRoman(13);

        assertThat(result, is("XIII"));
    }

}