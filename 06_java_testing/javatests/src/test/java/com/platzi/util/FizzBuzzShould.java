package com.platzi.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class FizzBuzzShould {
    FizzBuzz fizzBuzz;

    @BeforeEach
    public void setup(){
        fizzBuzz = new FizzBuzz();
    }

    @Test
    void return_fizz_is_three_multiples(){
        String result = fizzBuzz.fizzBuzz(3);
        String result2 = fizzBuzz.fizzBuzz(6);
        assertThat(result, is("Fizz"));
        assertThat(result2, is("Fizz"));
    }

    @Test
    void return_fizz_is_five_multiples(){
        String result = fizzBuzz.fizzBuzz(5);
        String result2 = fizzBuzz.fizzBuzz(10);
        assertThat(result, is("Buzz"));
        assertThat(result2, is("Buzz"));
    }

    @Test
    void return_fizz_is_five_and_three_multiples(){
        String result = fizzBuzz.fizzBuzz(15);
        String result2 = fizzBuzz.fizzBuzz(30);
        assertThat(result, is("FizzBuzz"));
        assertThat(result2, is("FizzBuzz"));
    }

    @Test
    void return_string_number_if_is_not_a_five_or_three_multiples(){
        String result = fizzBuzz.fizzBuzz(2);
        String result2 = fizzBuzz.fizzBuzz(16);
        assertThat(result, is("2"));
        assertThat(result2, is("16"));
    }
}