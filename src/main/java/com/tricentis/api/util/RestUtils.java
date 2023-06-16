package com.tricentis.api.util;

import com.tricentis.common.reports.ExtentLogger;
import com.tricentis.common.utils.ConfigReader;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class RestUtils {
    private RestUtils(){

    }

    private static RequestSpecification getDefaultRequestSpecification() {
        String baseUri= ConfigReader.getBaseUri();
        return given().baseUri(baseUri).contentType(ContentType.JSON).log().all();
    }

    private static  RequestSpecification getRequestSpecification(String baseURI, Map<String,String> headers) {
        return given().baseUri(baseURI).headers(headers);
    }

    public static Response executePostRequest(String baseURI, Map<String,String>headers, Map<String, Object> requestPayload) {
        RequestSpecification requestSpecification=getRequestSpecification(baseURI,headers).body(requestPayload);
        Response response =  requestSpecification.post();
        return response;
    }

    public static Response executePostRequest(String endPoint,Object requestPayloadAsPojo) {
        RequestSpecification requestSpecification =getDefaultRequestSpecification().body(requestPayloadAsPojo);
        Response response =  requestSpecification.post(endPoint);
        ExtentLogger.logRequest(requestSpecification);
        ExtentLogger.logResponse(response);
        return response;
    }

    public static Response executePostRequest(String endPoint,String requestString) {
        RequestSpecification requestSpecification =getDefaultRequestSpecification().body(requestString);
        Response response =  requestSpecification.post(endPoint);
        ExtentLogger.logRequest(requestSpecification);
        ExtentLogger.logResponse(response);
        return response;
    }

    public static Response executePostRequest(String endPoint,Map<String,Object> requestMap) {
        RequestSpecification requestSpecification =getDefaultRequestSpecification().body(requestMap);
        Response response =  requestSpecification.post(endPoint);
        ExtentLogger.logRequest(requestSpecification);
        ExtentLogger.logResponse(response);
        return response;
    }

    public static Response executePutRequest(String endPoint,String requestString) {
        RequestSpecification requestSpecification =getDefaultRequestSpecification().body(requestString);
        Response response =  requestSpecification.put(endPoint);
        ExtentLogger.logRequest(requestSpecification);
        ExtentLogger.logResponse(response);
        return response;
    }

    public static Response executePutRequest(String endPoint,Object requestPayloadAsPojo) {
        RequestSpecification requestSpecification =getDefaultRequestSpecification().body(requestPayloadAsPojo);
        Response response =  requestSpecification.put(endPoint);
        ExtentLogger.logRequest(requestSpecification);
        ExtentLogger.logResponse(response);
        return response;
    }

    public static Response executePutRequest(String endPoint,Map<String,Object> requestMap) {
        RequestSpecification requestSpecification =getDefaultRequestSpecification().body(requestMap);
        Response response =  requestSpecification.put(endPoint);
        ExtentLogger.logRequest(requestSpecification);
        ExtentLogger.logResponse(response);
        return response;
    }

    public static Response executeGetRequest(String endPoint) {
        RequestSpecification requestSpecification =getDefaultRequestSpecification();
        Response response =  requestSpecification.get(endPoint);
        ExtentLogger.logRequest(requestSpecification);
        ExtentLogger.logResponse(response);
        return response;
    }
    public static Response executeGetRequestUsingPathParam(String endPoint,String key,Object value) {
        RequestSpecification requestSpecification =getDefaultRequestSpecification().pathParam(key,value);
        Response response =  requestSpecification.get(endPoint+"/{"+key+"}");
        ExtentLogger.logRequest(requestSpecification);
        ExtentLogger.logResponse(response);
        return response;
    }
    public static Response executeDeleteRequestUsingPathParam(String endPoint,String key,Object value) {
        RequestSpecification requestSpecification =getDefaultRequestSpecification().pathParam(key,value);
        Response response =  requestSpecification.delete(endPoint+"/{"+key+"}");
        ExtentLogger.logRequest(requestSpecification);
        ExtentLogger.logResponse(response);
        return response;
    }





}


