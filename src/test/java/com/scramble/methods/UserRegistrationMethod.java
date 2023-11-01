package com.scramble.methods;

import com.jayway.jsonpath.DocumentContext;
import com.scramble.constants.ApiUrls;
import com.scramble.utils.FileUtils;
import com.scramble.utils.JsonUtils;
import com.scramble.utils.RandomUtils;
import com.scramble.utils.request.RequestUtils;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import static com.scramble.api.UserRegistrationAPI.*;
import static com.scramble.methods.RSAKeygenMethod.publicKey;

public class UserRegistrationMethod extends GenerateActivationCodeMethod {
    private static final Logger logger = LoggerFactory.getLogger(FileUtils.class);
    String url = null;
    String jsonString;
    DocumentContext jsonContext;
    private Response getUserRegistrationApiResponse;
    public static String suid;
    public static int otp;

    @Step
    public Response getUserRegistrationApiResponse() {

        long timeStamp = Long.parseLong(((RandomStringUtils.randomNumeric(13))));

        url = ApiUrls.SCRAMBLE_USER_REGISTRATION_API;
        RestAssured.baseURI = url;

        RequestSpecification request = RequestUtils.noAuthRequest();

        request.header("Content-type", "application/json");

        jsonString = FileUtils.getFileContent(USERREGISTRATION_REQ_FILEPATH);
        jsonContext = JsonUtils.getJsonContext(jsonString);

        jsonContext.set(USERREGISTRATION_REQ_EMAIL_JSON_PATH, RandomUtils.generateEmailId());
        jsonContext.set(USERREGISTRATION_REQ_MOBILE_JSON_PATH, RandomUtils.generateMobileNumber());
        jsonContext.set(USERREGISTRATION_REQ_ACTIVATIONCODE_JSON_PATH, activationCode);
        jsonContext.set(USERREGISTRATION_REQ_PUBLICKEY_JSON_PATH, publicKey);
        jsonContext.set(USERREGISTRATION_REQ_TIMESTAMP_JSON_PATH, timeStamp);
        jsonContext.set(USERREGISTRATION_REQ_ORGEMAIL_JSON_PATH, email);

        jsonString = jsonContext.jsonString();
        request.body(jsonString);

        getUserRegistrationApiResponse = request.post();
        getUserRegistrationApiResponse.then().log().all();

        suid = getUserRegistrationApiResponse.jsonPath().getString(USERREGISTRATION_RES_SUID_JSON_PATH);
        otp = getUserRegistrationApiResponse.jsonPath().getInt(USERREGISTRATION_RES_OTP_JSON_PATH);

        return getUserRegistrationApiResponse;
    }

    @Step
    public void verifyUserRegistrationApiResponseStatus() {
        Assert.assertEquals(getUserRegistrationApiResponse.getStatusCode(), 200);
        logger.info("get user registration api status code: " + getUserRegistrationApiResponse.getStatusCode());
    }

    @Step
    public void verifyUserRegistrationApiResponseBody() {
        Assert.assertEquals(getUserRegistrationApiResponse.jsonPath().getInt(USERREGISTRATION_RES_RESULTCODE_JSON_PATH), 0);
        Assert.assertNotNull(getUserRegistrationApiResponse.jsonPath().getString(USERREGISTRATION_RES_SUID_JSON_PATH));
        Assert.assertNotNull(getUserRegistrationApiResponse.jsonPath().getString(USERREGISTRATION_RES_ORGNAME_JSON_PATH));
        Assert.assertNotNull(getUserRegistrationApiResponse.jsonPath().getString(USERREGISTRATION_RES_OTP_JSON_PATH));
    }
}
