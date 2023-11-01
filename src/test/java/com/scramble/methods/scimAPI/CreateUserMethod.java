package com.scramble.methods.scimAPI;

import com.jayway.jsonpath.DocumentContext;
import com.scramble.constants.ApiUrls;
import com.scramble.constants.Headers;
import com.scramble.utils.FileUtils;
import com.scramble.utils.JsonUtils;
import com.scramble.utils.RandomUtils;
import com.scramble.utils.request.RequestUtils;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.slf4j.Logger;
import org.testng.Assert;

import static com.scramble.api.ScimAPI.*;
import static org.slf4j.LoggerFactory.getLogger;

public class CreateUserMethod {
    private static final Logger logger = getLogger(FileUtils.class);
    String url = null;
    String jsonString;
    DocumentContext jsonContext;
    private Response getCreateUserApiResponse;
    public static String userName;
    public static String email;

    @Step
    public Response getCreateUserApiResponse() {

        url = ApiUrls.SCRAMBLE_CREATE_USER_API;
        RestAssured.baseURI = url;

        RequestSpecification request = RequestUtils.getBasicAuthRequest();

        request.header(Headers.X_ORGANIZATION, "dem");
        request.header("Content-type", "application/json");

        jsonString = FileUtils.getFileContent(CREATEUSER_REQ_FILEPATH);
        jsonContext = JsonUtils.getJsonContext(jsonString);

        jsonContext.set(CREATEUSER_REQ_USERNAME_JSON_PATH, RandomUtils.generateUsername());
        jsonContext.set(CREATEUSER_REQ_NAME_FAMILYNAME_JSON_PATH, RandomUtils.generateLastName());
        jsonContext.set(CREATEUSER_REQ_NAME_GIVENNAME_JSON_PATH, RandomUtils.generateFirstName());
        jsonContext.set(CREATEUSER_REQ_EMAILS_PRIMARY_JSON_PATH.replace("emailIndex", "0"), true);
        jsonContext.set(CREATEUSER_REQ_EMAILS_VALUE_JSON_PATH.replace("emailIndex", "0"), RandomUtils.generateOrgEmailId());
        jsonContext.set(CREATEUSER_REQ_LDAPID_JSON_PATH, RandomUtils.generateLdapId());
        jsonContext.set(CREATEUSER_REQ_WINDOWSID_JSON_PATH, RandomUtils.generateWindowsId());

        jsonString = jsonContext.jsonString();
        request.body(jsonString);

        getCreateUserApiResponse = request.post();
        getCreateUserApiResponse.then().log().all();

        userName = getCreateUserApiResponse.jsonPath().getString(CREATEUSER_RES_USERNAME_JSON_PATH);
        email = getCreateUserApiResponse.jsonPath().getString(CREATEUSER_RES_EMAILS_VALUE_JSON_PATH.replace("emailIndex", "0"));

        return getCreateUserApiResponse;
    }

    @Step
    public void verifyCreateUserApiResponseStatus() {
        Assert.assertEquals(getCreateUserApiResponse.getStatusCode(), 201);
        logger.info("get create user api status code: " + getCreateUserApiResponse.getStatusCode());
    }

    @Step
    public void verifyCreateUserApiResponseBody() {
        Assert.assertNotNull(getCreateUserApiResponse.jsonPath().getString(CREATEUSER_RES_ID_JSON_PATH));
        Assert.assertNotNull(getCreateUserApiResponse.jsonPath().getString(CREATEUSER_RES_USERNAME_JSON_PATH));
        Assert.assertNotNull(getCreateUserApiResponse.jsonPath().getString(CREATEUSER_RES_EMAILS_VALUE_JSON_PATH.replace("emailIndex", "0")));
    }
}
