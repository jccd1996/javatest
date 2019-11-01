package com.jccd.javatests.util;

public class StringUtil {

    public static String repeat(String str, int times) {

        if (times < 0) {
            throw new IllegalArgumentException("negative times not allowed");
        }

        String result = "";
        for (int i = 0; i < times; i++) {
            result += str;
        }
        return result;
    }

    public static boolean isEmpty(String str) {
        if (str == null) {
            throw new NullPointerException();
        } else {
            return str.isEmpty() || str.trim().isEmpty();
        }
    }
}
