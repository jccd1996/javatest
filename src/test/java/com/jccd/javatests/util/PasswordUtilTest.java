package com.jccd.javatests.util;

import org.junit.Test;

import static com.jccd.javatests.util.PasswordUtil.SecurityLevel.*;
import static org.junit.Assert.*;

public class PasswordUtilTest {

    @Test
    public void weak_when_has_less_than_8_letters() {
        assertEquals(WEAK, PasswordUtil.assessPassword("1234aa!"));
    }

    @Test
    public void weak_when_has_only__letters() {
        assertEquals(WEAK, PasswordUtil.assessPassword("asdqwerf"));
    }

    @Test
    public void medium_when_has_letters_and_numbers() {
        assertEquals(MEDIUM, PasswordUtil.assessPassword("abcd1234"));
    }

    @Test
    public void strong_when_has_letters_and_numbers() {
        assertEquals(STRONG, PasswordUtil.assessPassword("abcd123!"));
    }
}