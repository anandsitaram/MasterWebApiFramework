package com.tricentis.common.utils;

import java.util.Base64;

public final class EncryptUtil {
    private EncryptUtil() {

    }

    public static String getEncryptedValue(String value) {
        return Base64.getEncoder().encodeToString(value.getBytes());
    }

    public static String getDecryptedValue(String encryptedValue) {
        return new String(Base64.getDecoder().decode(encryptedValue.getBytes()));
    }
}
