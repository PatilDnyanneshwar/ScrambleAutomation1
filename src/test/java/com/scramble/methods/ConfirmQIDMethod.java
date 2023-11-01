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

import static com.scramble.api.ConfirmQIDAPI.*;
import static com.scramble.methods.GetQIDMethod.qid;
import static com.scramble.methods.RSASignMethod.*;
import static com.scramble.methods.UserOtpVerifyMethod.zid;
import static com.scramble.methods.UserRegistrationMethod.suid;
import static org.slf4j.LoggerFactory.getLogger;

public class ConfirmQIDMethod {
    private static final Logger logger = getLogger(FileUtils.class);
    String url = null;
    String jsonString;
    DocumentContext jsonContext;
    private Response getConfirmQIDApiResponse;

    @Step
    public Response getConfirmQIDApiResponse() {

        long timeStamp = Long.parseLong(((RandomStringUtils.randomNumeric(13))));

        url = ApiUrls.SCRAMBLE_CONFIRM_QID_API;
        RestAssured.baseURI = url;

        RequestSpecification request = RequestUtils.noAuthRequest();

        request.header("Content-type", "application/json");

        jsonString = FileUtils.getFileContent(CONFIRMQID_REQ_FILEPATH);
        jsonContext = JsonUtils.getJsonContext(jsonString);

        jsonContext.set(CONFIRMQID_REQ_UNIQUEID_JSON_PATH, qid);
        jsonContext.set(CONFIRMQID_REQ_SUID_JSON_PATH, suid);
        jsonContext.set(CONFIRMQID_REQ_ZID_JSON_PATH, zid);
        jsonContext.set(CONFIRMQID_REQ_TIMESTAMP_JSON_PATH, timeStamp);
        jsonContext.set(CONFIRMQID_REQ_CONFIRM_JSON_PATH, "yes");
        jsonContext.set(CONFIRMQID_REQ_SIGNATURE_JSON_PATH, signature2);

        jsonString = jsonContext.jsonString();
        request.body(jsonString);

        getConfirmQIDApiResponse = request.post();
        getConfirmQIDApiResponse.then().log().all();

        return getConfirmQIDApiResponse;
    }

    @Step
    public void verifyConfirmQIDApiResponseStatus() {
        Assert.assertEquals(getConfirmQIDApiResponse.getStatusCode(), 200);
        logger.info("get confirm qid api status code: " + getConfirmQIDApiResponse.getStatusCode());
    }

    @Step
    public void verifyConfirmQIDApiResponseBody() {
        Assert.assertEquals(getConfirmQIDApiResponse.jsonPath().getInt(CONFIRMQID_RES_RESULTCODE_JSON_PATH), 0);
    }
}
