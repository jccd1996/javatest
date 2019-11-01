package com.jccd.javatests.util;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FizzBuzzTest {
    String fizz;
    String buzz;
    String fizzBuzz;
    FizzBuzz fizzBuzzObject;

    @Before
    public void setup (){
        fizz = "Fizz";
        buzz = "Buzz";
        fizzBuzz = "FizzBuzz";
        fizzBuzzObject = new FizzBuzz();
    }

    @Test
    public void return_fizz_when_is_divisible_by_3() {
        assertEquals(fizz,fizzBuzzObject.fizzBuzz(12));
    }

    @Test
    public void return_buzzz_when_is_divisible_by_5() {
        assertEquals(buzz,fizzBuzzObject.fizzBuzz(140));
    }

    @Test
    public void return_fizz_when_is_divisible_by_3_and_5() {
        assertEquals(fizzBuzz,fizzBuzzObject.fizzBuzz(15));
    }

    @Test
    public void return_same_number_when_other_cases_are_not_met() {
        assertEquals("16",fizzBuzzObject.fizzBuzz(16));
    }

}