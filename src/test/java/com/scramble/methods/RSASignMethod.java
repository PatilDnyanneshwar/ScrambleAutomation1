package com.scramble.methods;

import com.jayway.jsonpath.DocumentContext;
import com.scramble.constants.ApiUrls;
import com.scramble.utils.FileUtils;
import com.scramble.utils.JsonUtils;
import com.scramble.utils.request.RequestUtils;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import static com.scramble.api.RSASignAPI.*;
import static com.scramble.methods.GetQIDMethod.qid;
import static com.scramble.methods.RSAKeygenMethod.privateKey;
import static com.scramble.methods.UserOtpVerifyMethod.zid;
import static com.scramble.methods.UserRegistrationMethod.otp;
import static com.scramble.methods.UserRegistrationMethod.suid;

public class RSASignMethod {
    private static final Logger logger = LoggerFactory.getLogger(FileUtils.class);
    String url = null;
    String jsonString;
    DocumentContext jsonContext;
    public static String signature;
    public static String signature2;
    private Response getRSASignApiResponse;
    private Response getRSASign2ApiResponse;

    @Step
    public Response getRSASignApiResponse() {

        url = ApiUrls.SCRAMBLE_RSASIGN_API;
        RestAssured.baseURI = url;

        RequestSpecification request = RequestUtils.noAuthRequest();

        request.header("Content-type", "application/json");

        jsonString = FileUtils.getFileContent(RSASIGN_REQ_FILEPATH);
        jsonContext = JsonUtils.getJsonContext(jsonString);

        String payload = suid + "||" + otp;

        jsonContext.set(RSASIGN_REQ_PAYLOAD_JSON_PATH, payload);
        jsonContext.set(RSASIGN_REQ_PRIVATEKEY_JSON_PATH, privateKey);

        jsonString = jsonContext.jsonString();
        request.body(jsonString);

        getRSASignApiResponse = request.post();
        getRSASignApiResponse.then().log().all();

        signature = getRSASignApiResponse.jsonPath().getString(RSASIGN_RES_SIGNATURE_JSON_PATH);

        return getRSASignApiResponse;
    }

    @Step
    public void verifyRSASignApiResponseStatus() {
        Assert.assertEquals(getRSASignApiResponse.getStatusCode(), 200);
        logger.info("get rsa keygen api status code: " + getRSASignApiResponse.getStatusCode());
    }

    @Step
    public void verifyRSASignApiResponseBody() {
        Assert.assertNotNull(getRSASignApiResponse.jsonPath().getString(RSASIGN_RES_SIGNATURE_JSON_PATH));
    }

    @Step
    public Response getRSASign2ApiResponse() {

        url = ApiUrls.SCRAMBLE_RSASIGN_API;
        RestAssured.baseURI = url;

        RequestSpecification request = RequestUtils.noAuthRequest();

        request.header("Content-type", "application/json");

        jsonString = FileUtils.getFileContent(RSASIGN_REQ_FILEPATH);
        jsonContext = JsonUtils.getJsonContext(jsonString);

        String payload = suid + "||" + zid + "||" + qid;

        jsonContext.set(RSASIGN_REQ_PAYLOAD_JSON_PATH, payload);
        jsonContext.set(RSASIGN_REQ_PRIVATEKEY_JSON_PATH, privateKey);

        jsonString = jsonContext.jsonString();
        request.body(jsonString);

        getRSASign2ApiResponse = request.post();
        getRSASign2ApiResponse.then().log().all();

        signature2 = getRSASign2ApiResponse.jsonPath().getString(RSASIGN_RES_SIGNATURE_JSON_PATH);

        return getRSASign2ApiResponse;
    }

    @Step
    public void verifyRSASign2ApiResponseStatus() {
        Assert.assertEquals(getRSASign2ApiResponse.getStatusCode(), 200);
        logger.info("get rsa keygen api status code: " + getRSASign2ApiResponse.getStatusCode());
    }

    @Step
    public void verifyRSASign2ApiResponseBody() {
        Assert.assertNotNull(getRSASign2ApiResponse.jsonPath().getString(RSASIGN_RES_SIGNATURE2_JSON_PATH));
    }
}
