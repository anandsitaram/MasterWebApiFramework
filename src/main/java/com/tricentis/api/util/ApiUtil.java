package com.tricentis.api.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public final class ApiUtil {

    private ApiUtil() {

    }

    public static String readRequestFromFile(String filePath) {
        try {
            return new String((Files.readAllBytes(Paths.get(filePath))));
        } catch (IOException e) {
            throw new RuntimeException("Problem reading the file");
        }
    }

    public static void saveResponseToFile(String filePath, String response) {
        try {
            Files.write(Paths.get(filePath), response.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Problem in writing to the file");
        }
    }
}
