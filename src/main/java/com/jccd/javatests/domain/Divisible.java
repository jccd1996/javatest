package com.jccd.javatests.domain;

import com.jccd.javatests.util.TypesOfDivisible;

public class Divisible implements TypesOfDivisible {

    String fizz = "Fizz";
    String buzz = "Buzz";
    String fizzBuzz = "FizzBuzz";
    int input;

    public Divisible(int input) {
        this.input = input;
    }

    @Override
    public String typeOfDivisibleNumber() {
        if (input % 3 == 0 && input % 5 == 0) {
            return fizzBuzz;
        } else if (input % 3 == 0) {
            return fizz;
        } else if (input % 5 == 0) {
            return buzz;
        } else {
            return Integer.toString(input);
        }
    }
}
