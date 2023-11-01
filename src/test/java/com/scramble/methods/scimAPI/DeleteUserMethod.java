package com.scramble.methods.scimAPI;

import com.scramble.constants.ApiUrls;
import com.scramble.constants.Headers;
import com.scramble.utils.FileUtils;
import com.scramble.utils.request.RequestUtils;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.slf4j.Logger;
import org.testng.Assert;

import static org.slf4j.LoggerFactory.getLogger;

public class DeleteUserMethod extends CreateUserMethod {
    private static final Logger logger = getLogger(FileUtils.class);
    String url = null;
    private Response getDeleteUserApiResponse;

    @Step
    public Response getDeleteUserApiResponse() {

        url = ApiUrls.SCRAMBLE_DELETE_USER_API + userName;
        RestAssured.baseURI = url;

        RequestSpecification request = RequestUtils.getBasicAuthRequest();

        request.header(Headers.X_ORGANIZATION, "dem");
        request.header("Content-type", "application/json");

        getDeleteUserApiResponse = request.delete();
        getDeleteUserApiResponse.then().log().all();

        return getDeleteUserApiResponse;
    }

    @Step
    public void verifyDeleteUserApiResponseStatus() {
        Assert.assertEquals(getDeleteUserApiResponse.getStatusCode(), 204);
        logger.info("get delete user api status code: " + getDeleteUserApiResponse.getStatusCode());
    }
}
