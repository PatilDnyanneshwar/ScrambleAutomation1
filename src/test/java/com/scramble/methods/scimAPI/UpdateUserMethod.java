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
import org.testng.Assert;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.scramble.api.ScimAPI.*;

public class UpdateUserMethod extends CreateUserMethod {
    private static final Logger logger = LogManager.getLogger(FileUtils.class);
    String url = null;
    String jsonString;
    DocumentContext jsonContext;
    private Response getUpdateUserApiResponse;

    @Step
    public Response getUpdateUserApiResponse() {

        url = ApiUrls.SCRAMBLE_UPDATE_USER_API + userName;
        RestAssured.baseURI = url;

        RequestSpecification request = RequestUtils.getBasicAuthRequest();

        request.header(Headers.X_ORGANIZATION, "dem");
        request.header("Content-type", "application/json");

        jsonString = FileUtils.getFileContent(UPDATEUSER_REQ_FILEPATH);
        jsonContext = JsonUtils.getJsonContext(jsonString);

        jsonContext.set(UPDATEUSER_REQ_USERNAME_JSON_PATH, userName);
        jsonContext.set(UPDATEUSER_REQ_NAME_FAMILYNAME_JSON_PATH, RandomUtils.generateFirstName());
        jsonContext.set(UPDATEUSER_REQ_NAME_GIVENNAME_JSON_PATH, RandomUtils.generateLastName());
        jsonContext.set(UPDATEUSER_REQ_NAME_PREFERREDFIRSTNAME_JSON_PATH, RandomUtils.generateFirstName());
        jsonContext.set(UPDATEUSER_REQ_NAME_PREFERREDLASTNAME_JSON_PATH, RandomUtils.generateLastName());
        jsonContext.set(UPDATEUSER_REQ_EMAILS_PRIMARY_JSON_PATH.replace("emailIndex", "0"), true);
        jsonContext.set(UPDATEUSER_REQ_EMAILS_VALUE_JSON_PATH.replace("emailIndex", "0"), email);
        jsonContext.set(UPDATEUSER_REQ_LDAPID_JSON_PATH, RandomUtils.generateLdapId());
        jsonContext.set(UPDATEUSER_REQ_WINDOWSID_JSON_PATH, RandomUtils.generateWindowsId());

        jsonString = jsonContext.jsonString();
        request.body(jsonString);
        getUpdateUserApiResponse = request.put();
        getUpdateUserApiResponse.then().log().all();

        return getUpdateUserApiResponse;
    }

    @Step
    public void verifyUpdateUserApiResponseStatus() {
        Assert.assertEquals(getUpdateUserApiResponse.getStatusCode(), 200);
        logger.info("get update user api status code: " + getUpdateUserApiResponse.getStatusCode());
    }

    @Step
    public void verifyUpdateUserApiResponseBody() {
        Assert.assertNotNull(getUpdateUserApiResponse.jsonPath().getString(UPDATEUSER_RES_ID_JSON_PATH));
        Assert.assertNotNull(getUpdateUserApiResponse.jsonPath().getString(UPDATEUSER_RES_USERNAME_JSON_PATH));
        Assert.assertNotNull(getUpdateUserApiResponse.jsonPath().getString(UPDATEUSER_RES_EMAILS_VALUE_JSON_PATH.replace("emailIndex", "0")));
    }
}
