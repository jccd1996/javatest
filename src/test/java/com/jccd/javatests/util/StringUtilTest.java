package com.jccd.javatests.util;


import org.junit.Assert;
import org.junit.Test;

public class StringUtilTest {

    @Test
    public void repeat_string_once() { Assert.assertEquals("hola",StringUtil.repeat("hola", 1)); }

    @Test
    public void repeat_string_multiple_times(){
        Assert.assertEquals("holaholahola",StringUtil.repeat("hola", 3));
    }

    @Test
    public void repeat_string_zero_times(){
        Assert.assertEquals("",StringUtil.repeat("hola", 0));
    }

    @Test (expected = IllegalArgumentException.class )
    public void repeat_string_negative_times(){ StringUtil.repeat("hola", -1 ); }

    @Test (expected = NullPointerException.class)
    public void verify_is_str_null(){
        StringUtil.isEmpty(null);
    }

    @Test
    public void verify_is_str_empty(){
        Assert.assertTrue(StringUtil.isEmpty(""));
    }

    @Test
    public void verify_is_str_empty_with_spaces(){
        Assert.assertTrue(StringUtil.isEmpty(" "));
    }

    @Test
    public void verify_if_str_had_characters(){
        Assert.assertFalse(StringUtil.isEmpty("test"));
    }

}
