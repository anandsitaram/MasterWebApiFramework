package com.tricentis.common.utils;

import com.tricentis.common.exceptions.FrameworkException;

import java.util.Objects;

public final class StringUtil {
    private StringUtil() {

    }

    public static String toCamelCase(String value) {
        if (Objects.isNull(value)) {
            throw new FrameworkException("Value is null");
        }
        StringBuilder stringBuilder = new StringBuilder(value.length());

        for (String word : value.split(" ")) {
            if (!word.isEmpty()) {
                stringBuilder.append(Character.toUpperCase(word.charAt(0)));
                stringBuilder.append(word.substring(1).toLowerCase());
            }
            if ((stringBuilder.length() != value.length()))
                stringBuilder.append(" ");
        }

        return stringBuilder.toString();
    }
}
