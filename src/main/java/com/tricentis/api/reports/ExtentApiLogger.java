package com.tricentis.api.reports;

import com.tricentis.common.reports.ExtentLogger;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;

public final class ExtentApiLogger extends ExtentLogger {
    private ExtentApiLogger() {

    }

    public static void logRequest(RequestSpecification requestSpecification) {

        QueryableRequestSpecification queryableRequestSpecification = SpecificationQuerier.query(requestSpecification);
        info("Endpoint is " + queryableRequestSpecification.getURI());
        info("Method is " + queryableRequestSpecification.getMethod());
        info("Headers are");
        logHeaders(queryableRequestSpecification.getHeaders().asList());
        if (!queryableRequestSpecification.getMethod().equals(Method.GET.name()) &&
                !queryableRequestSpecification.getMethod().equals(Method.DELETE.name())) {
            info("Request body is ");
            logJson(queryableRequestSpecification.getBody());
        } else {
            info("No Request body as it is " + queryableRequestSpecification.getMethod() + " Request");
        }

    }

    public static void logResponse(Response response) {
        info("Response status is " + response.getStatusCode());
        info("Response Headers are ");
        logHeaders(response.getHeaders().asList());
        info("Response body is ");
        logJson(response.getBody().prettyPrint());
    }

}
