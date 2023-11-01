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
import org.testng.Assert;

import static com.scramble.api.UserOtpVerifyAPI.*;
import static com.scramble.methods.RSASignMethod.signature;
import static com.scramble.methods.UserRegistrationMethod.*;
import static org.slf4j.LoggerFactory.getLogger;

public class UserOtpVerifyMethod {
    private static final Logger logger = getLogger(FileUtils.class);
    String url = null;
    String jsonString;
    DocumentContext jsonContext;
    public static String zid;
    private Response getUserOtpVerifyApiResponse;

    @Step
    public Response getUserOtpVerifyApiResponse() {

        long timeStamp = Long.parseLong(((RandomStringUtils.randomNumeric(13))));

        url = ApiUrls.SCRAMBLE_USER_OTP_VERIFY_API;
        RestAssured.baseURI = url;

        RequestSpecification request = RequestUtils.noAuthRequest();

        request.header("Content-type", "application/json");

        jsonString = FileUtils.getFileContent(USEROTPVERIFY_REQ_FILEPATH);
        jsonContext = JsonUtils.getJsonContext(jsonString);

        jsonContext.set(USEROTPVERIFY_REQ_SUID_JSON_PATH, suid);
        jsonContext.set(USEROTPVERIFY_REQ_OTP_JSON_PATH, otp);
        jsonContext.set(USEROTPVERIFY_REQ_SIGNATURE_JSON_PATH, signature);
        jsonContext.set(USEROTPVERIFY_REQ_TIMESTAMP_JSON_PATH, timeStamp);

        jsonString = jsonContext.jsonString();
        request.body(jsonString);

        getUserOtpVerifyApiResponse = request.post();
        getUserOtpVerifyApiResponse.then().log().all();

        zid = getUserOtpVerifyApiResponse.jsonPath().getString(USEROTPVERIFY_RES_ZID_JSON_PATH);

        return getUserOtpVerifyApiResponse;
    }

    @Step
    public void verifyUserOtpVerifyApiResponseStatus() {
        Assert.assertEquals(getUserOtpVerifyApiResponse.getStatusCode(), 200);
        logger.info("get user otp verify api status code: " + getUserOtpVerifyApiResponse.getStatusCode());
    }

    @Step
    public void verifyUserOtpVerifyApiResponseBody() {
        Assert.assertEquals(getUserOtpVerifyApiResponse.jsonPath().getInt(USEROTPVERIFY_RES_RESULTCODE_JSON_PATH), 0);
        Assert.assertNotNull(getUserOtpVerifyApiResponse.jsonPath().getString(USEROTPVERIFY_RES_ZID_JSON_PATH));
//        Assert.assertNotNull(getUserOtpVerifyApiResponse.jsonPath().getString(USEROTPVERIFY_RES_SERVERPUBLICKEY_JSON_PATH));
    }
}
