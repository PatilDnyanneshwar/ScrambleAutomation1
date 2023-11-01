package com.scramble.utils.request;

import com.scramble.constants.Authorization;
import com.scramble.constants.Headers;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class RequestUtils {
    public static RequestSpecification getBasicAuthRequest() {

        String username = Authorization.USERNAME;
        String password = Authorization.PASSWORD;

        RequestSpecification request = RestAssured.given().auth().preemptive().basic(username, password).log().all();

        request.header(Headers.CONTENT_TYPE, Headers.JSON);
        request.header(Headers.ACCEPT, Headers.JSON);

        return request;
    }

    public static RequestSpecification noAuthRequest() {

        RequestSpecification request = RestAssured.given().log().all();

        request.header(Headers.CONTENT_TYPE, Headers.JSON);
        request.header(Headers.ACCEPT, Headers.JSON);

        return request;
    }
}
