package com.jccd.javatests.domain;

import java.util.TreeMap;

public class RomanNumerals {
    private final static TreeMap<Integer, String> map = new TreeMap<Integer, String>();

    static {
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
    }

    public static String arabicToRoman(int number) {
        if(number < 0){
            throw new NullPointerException();
        } else {
            int l =  map.floorKey(number);
            if ( number == l ) {
                return map.get(number);
            }
            String result = map.get(l) + arabicToRoman(number-l);
            return result;
        }
    }
}
