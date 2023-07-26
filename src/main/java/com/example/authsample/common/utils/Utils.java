package com.example.authsample.common.utils;

import org.apache.commons.lang3.RandomStringUtils;

public class Utils {


    public static String replaceSpecialCharacter(String value) {
        return value.replaceAll("[^a-zA-Z0-9 ]", "");
    }

    public static String generateRandomValue(int lenght) {
        return RandomStringUtils.randomAlphabetic(lenght);
    }
}
