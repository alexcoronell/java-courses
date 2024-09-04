package com.platzi.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StringUtilTest {

    @Test
    public void repeat_string_once() {
        Assertions.assertEquals("Hello", StringUtil.repeat("Hello",1));
    }

    @Test
    public void repeat_string_multiple_times() {
        Assertions.assertEquals("HelloHelloHello", StringUtil.repeat("Hello",3));
    }

    @Test
    public void repeat_strings_zero_times(){
        Assertions.assertEquals("", StringUtil.repeat("Hello",0));
    }

    @Test
    public void repeat_strings_negative_times(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            StringUtil.repeat("Hello",-1);
        });
    }

    @Test
    void test_string_is_not_empty(){
        boolean result = StringUtil.isEmpty("MyString");
        Assertions.assertFalse(result);
    }


    @Test
    void test_quote_string_is_empty(){
        boolean result = StringUtil.isEmpty("");
        Assertions.assertTrue(result);
    }

    @Test
    void test_null_is_empty(){
        boolean result = StringUtil.isEmpty(null);
        Assertions.assertTrue(result);
    }

    @Test
    void test_spaces_is_empty(){
        boolean result = StringUtil.isEmpty(" ");
        Assertions.assertTrue(result);
    }

}