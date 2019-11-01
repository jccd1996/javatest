package com.jccd.javatests.util;

import com.jccd.javatests.domain.Divisible;

public class FizzBuzz {

    public  String fizzBuzz(int input) {
        Divisible divisibleNumber = new Divisible(input);
        return divisibleNumber.typeOfDivisibleNumber();
    }
}
