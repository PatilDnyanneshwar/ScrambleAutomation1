package com.scramble.methods;

import com.jayway.jsonpath.DocumentContext;

import com.scramble.constants.ApiUrls;
import com.scramble.utils.FileUtils;
import com.scramble.utils.JsonUtils;
import com.scramble.utils.request.RequestUtils;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.testng.Assert;

import static com.scramble.api.VerifyQIDAPI.*;
import static com.scramble.methods.GetQIDMethod.qid;
import static com.scramble.methods.RSASignMethod.signature2;
import static com.scramble.methods.UserOtpVerifyMethod.zid;
import static com.scramble.methods.UserRegistrationMethod.suid;
import static org.slf4j.LoggerFactory.getLogger;

public class VerifyQIDMethod {
    private static final Logger logger = getLogger(FileUtils.class);
    String url = null;
    String jsonString;
    DocumentContext jsonContext;
    private Response getVerifyQIDApiResponse;

    @Step
    public Response getVerifyQIDApiResponse() {

        long timeStamp = Long.parseLong(((RandomStringUtils.randomNumeric(13))));

        url = ApiUrls.SCRAMBLE_VERIFY_QID_API;
        RestAssured.baseURI = url;

        RequestSpecification request = RequestUtils.noAuthRequest();

        request.header("Content-type", "application/json");

        jsonString = FileUtils.getFileContent(VERIFYQID_REQ_FILEPATH);
        jsonContext = JsonUtils.getJsonContext(jsonString);

        jsonContext.set(VERIFYQID_REQ_UNIQUEID_JSON_PATH, qid);
        jsonContext.set(VERIFYQID_REQ_SUID_JSON_PATH, suid);
        jsonContext.set(VERIFYQID_REQ_ZID_JSON_PATH, zid);
        jsonContext.set(VERIFYQID_REQ_TIMESTAMP_JSON_PATH, timeStamp);
        jsonContext.set(VERIFYQID_REQ_SIGNATURE_JSON_PATH, signature2);

        jsonString = jsonContext.jsonString();
        request.body(jsonString);

        getVerifyQIDApiResponse = request.post();
        getVerifyQIDApiResponse.then().log().all();

        return getVerifyQIDApiResponse;
    }

    @Step
    public void verifyVerifyQIDApiResponseStatus() {
        Assert.assertEquals(getVerifyQIDApiResponse.getStatusCode(), 200);
        logger.info("get verify qid api status code: " + getVerifyQIDApiResponse.getStatusCode());
    }

    @Step
    public void verifyVerifyQIDApiResponseBody() {
        Assert.assertEquals(getVerifyQIDApiResponse.jsonPath().getInt(VERIFYQID_RES_RESULTCODE_JSON_PATH), 0);
        Assert.assertEquals(getVerifyQIDApiResponse.jsonPath().get(VERIFYQID_RES_ACTION_JSON_PATH), "confirm");
        Assert.assertEquals(getVerifyQIDApiResponse.jsonPath().get(VERIFYQID_RES_MESSAGE_JSON_PATH), "Are you trying to login to organization Demo Corp?");
        Assert.assertEquals(getVerifyQIDApiResponse.jsonPath().get(VERIFYQID_RES_ORGNAME_JSON_PATH), "Demo Corp");
        Assert.assertEquals(JsonPath.from(WebSocketMethod.abc.trim()).get(VERIFYQID_RES_OP_JSON_PATH), "WaitForConfirm");
        System.out.println(JsonPath.from(WebSocketMethod.abc.trim()).get(VERIFYQID_RES_OP_JSON_PATH).toString());
    }
}
