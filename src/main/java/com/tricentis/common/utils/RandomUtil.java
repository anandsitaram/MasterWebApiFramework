package com.tricentis.common.utils;

import com.tricentis.common.exceptions.FrameworkException;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

public final class RandomUtil {
    private RandomUtil() {

    }


    private static final char[] LETTERS = "abcdefghijkmnopqrstuvwxyz".toCharArray();
    private static final char[] NUMBERS = "0123456789".toCharArray();

    private static String getRandom(int size, char[] chars) {

        StringBuilder stringBuilder = new StringBuilder();
        Random random;
        try {
            random = SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException e) {
            throw new FrameworkException("Error occurred while generating the random Number");
        }

        for (int i = 0; i < size; i++) {

            char c = chars[random.nextInt(chars.length)];
            stringBuilder.append(c);

        }
        return stringBuilder.toString();
    }

    public static String getRandomString(int length) {

        return getRandom(length, LETTERS);

    }

    public static Long getRandomNumber(int length) {

        return Long.valueOf(getRandom(length, NUMBERS));

    }

}
