package com.tricentis.api.util;

import com.tricentis.api.reports.ExtentApiLogger;
import com.tricentis.common.utils.ConfigReader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.internal.RequestSpecificationImpl;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.config.EncoderConfig.encoderConfig;

public class RestUtils {
    private RestUtils() {

    }

    private static RequestSpecification getDefaultRequestSpecification() {
        String baseUri = ConfigReader.getBaseUri();
        return given().baseUri(baseUri).contentType(ContentType.JSON).log().all();
    }

    private static RequestSpecification getRequestSpecification(String baseURI, Map<String, String> headers) {
        return given().baseUri(baseURI).headers(headers);
    }

    public static Response executePostRequest(String baseURI, Map<String, String> headers, Map<String, Object> requestPayload) {
        RequestSpecification requestSpecification = getRequestSpecification(baseURI, headers).body(requestPayload);
        return requestSpecification.post();
    }

    public static Response executePostRequest(String endPoint, Object requestPayloadAsPojo) {
        RequestSpecification requestSpecification = getDefaultRequestSpecification().body(requestPayloadAsPojo);
        Response response = requestSpecification.post(endPoint);
        ExtentApiLogger.logRequest(requestSpecification);
        ExtentApiLogger.logResponse(response);
        return response;
    }

    public static Response executePostRequest(String endPoint, String requestString) {
        RequestSpecification requestSpecification = getDefaultRequestSpecification().body(requestString);
        Response response = requestSpecification.post(endPoint);
        ExtentApiLogger.logRequest(requestSpecification);
        ExtentApiLogger.logResponse(response);
        return response;
    }

    public static Response executePostRequest(String endPoint, Map<String, Object> requestMap) {
        RequestSpecification requestSpecification = getDefaultRequestSpecification().body(requestMap);
        Response response = requestSpecification.post(endPoint);
        ExtentApiLogger.logRequest(requestSpecification);
        ExtentApiLogger.logResponse(response);
        return response;
    }

    public static Response executePutRequest(String endPoint, String requestString) {
        RequestSpecification requestSpecification = getDefaultRequestSpecification().body(requestString);
        Response response = requestSpecification.put(endPoint);
        ExtentApiLogger.logRequest(requestSpecification);
        ExtentApiLogger.logResponse(response);
        return response;
    }

    public static Response executePutRequest(String endPoint, Object requestPayloadAsPojo) {
        RequestSpecification requestSpecification = getDefaultRequestSpecification().body(requestPayloadAsPojo);
        Response response = requestSpecification.put(endPoint);
        ExtentApiLogger.logRequest(requestSpecification);
        ExtentApiLogger.logResponse(response);
        return response;
    }

    public static Response executePutRequest(String endPoint, Map<String, Object> requestMap) {
        RequestSpecification requestSpecification = getDefaultRequestSpecification().body(requestMap);
        Response response = requestSpecification.put(endPoint);
        ExtentApiLogger.logRequest(requestSpecification);
        ExtentApiLogger.logResponse(response);
        return response;
    }

    public static Response executeGetRequest(String endPoint) {
        RequestSpecification requestSpecification = getDefaultRequestSpecification();
        Response response = requestSpecification.get(endPoint);
        ExtentApiLogger.logRequest(requestSpecification);
        ExtentApiLogger.logResponse(response);
        return response;
    }

    public static Response executeGetRequestUsingPathParam(String endPoint, String key, Object value) {
        RequestSpecification requestSpecification = getDefaultRequestSpecification().pathParam(key, value);
        Response response = requestSpecification.get(endPoint + "/{" + key + "}");
        ExtentApiLogger.logRequest(requestSpecification);
        ExtentApiLogger.logResponse(response);
        return response;
    }

    public static Response executeDeleteRequestUsingPathParam(String endPoint, String key, Object value) {
        RequestSpecification requestSpecification = getDefaultRequestSpecification().pathParam(key, value);
        Response response = requestSpecification.delete(endPoint + "/{" + key + "}");
        ExtentApiLogger.logRequest(requestSpecification);
        ExtentApiLogger.logResponse(response);
        return response;
    }


    public static Response executePostRequestUsingMultiParts(String endpoint, Map<String, String> headers,String... keyValues) {
        RequestSpecification requestSpecification = buildMultiParts(keyValues);
        ((RequestSpecificationImpl) requestSpecification).getMultiPartParams().forEach(
                System.out::println);
        Response response=requestSpecification.urlEncodingEnabled(true).config(RestAssured.config().encoderConfig(
                        encoderConfig().encodeContentTypeAs("multipart/form-data", ContentType.TEXT)))
                .headers(headers).post(endpoint);
        ExtentApiLogger.logRequest(requestSpecification);
        ExtentApiLogger.logResponse(response);
        return response;
    }

    private static RequestSpecification buildMultiParts(String... keyValues) {
        if (keyValues.length % 2 != 0) {
            throw new IllegalArgumentException("Invalid number of arguments");
        }
        int numPairs = keyValues.length / 2;
        String baseUri = ConfigReader.getBaseUri();
        RequestSpecification specification =given().baseUri(baseUri).contentType(ContentType.JSON).log().all();
        for (int i = 0; i < numPairs; i++) {
            int index = i * 2;
            String key = keyValues[index];
            String value = keyValues[index + 1];
            specification.multiPart(key, value);
        }

        return specification;
    }

}


