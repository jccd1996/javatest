package com.jccd.javatests.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class RomanNumeralsTest {

    @Test
    public void convert_one_number_to_roman() {
        assertEquals("LVIII",RomanNumerals.arabicToRoman(58));
    }

    @Test (expected = NullPointerException.class)
    public void convert_negative_number_to_roman() {
        RomanNumerals.arabicToRoman(-85);
    }
}