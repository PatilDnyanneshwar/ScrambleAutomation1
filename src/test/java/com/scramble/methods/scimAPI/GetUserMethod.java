package com.scramble.methods.scimAPI;

import com.scramble.constants.ApiUrls;
import com.scramble.constants.Headers;
import com.scramble.constants.Params;
import com.scramble.utils.FileUtils;
import com.scramble.utils.request.RequestUtils;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.slf4j.Logger;
import org.testng.Assert;

import static com.scramble.api.ScimAPI.*;
import static org.slf4j.LoggerFactory.getLogger;

public class GetUserMethod extends CreateUserMethod {
    private static final Logger logger = getLogger(FileUtils.class);
    String url = null;
    private Response getGetUserApiResponse;

    @Step
    public Response getGetUserApiResponse() {

        url = ApiUrls.SCRAMBLE_GET_USER_API + userName;
        RestAssured.baseURI = url;

        RequestSpecification request = RequestUtils.getBasicAuthRequest();

        request.header(Headers.X_ORGANIZATION, "dem");
        request.header("Content-type", "application/json");
        request.queryParams(Params.INCLUDEDEVICES_FORM_PARAM, true);

        getGetUserApiResponse = request.get();
        getGetUserApiResponse.then().log().all();

        return getGetUserApiResponse;
    }

    @Step
    public void verifyGetUserApiResponseStatus() {
        Assert.assertEquals(getGetUserApiResponse.getStatusCode(), 200);
        logger.info("get get user api status code: " + getGetUserApiResponse.getStatusCode());
    }

    @Step
    public void verifyGetUserApiResponseBody() {
        Assert.assertNotNull(getGetUserApiResponse.jsonPath().getString(UPDATEUSER_RES_ID_JSON_PATH));
        Assert.assertNotNull(getGetUserApiResponse.jsonPath().getString(UPDATEUSER_RES_USERNAME_JSON_PATH));
        Assert.assertNotNull(getGetUserApiResponse.jsonPath().getString(UPDATEUSER_RES_EMAILS_VALUE_JSON_PATH.replace("emailIndex", "0")));
    }
}
