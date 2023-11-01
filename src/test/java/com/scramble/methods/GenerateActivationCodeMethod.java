package com.scramble.methods;

import com.jayway.jsonpath.DocumentContext;
import com.scramble.constants.ApiUrls;
import com.scramble.methods.scimAPI.CreateUserMethod;
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

import static com.scramble.api.GenerateActivationCodeAPI.*;

public class GenerateActivationCodeMethod extends CreateUserMethod {
    private static final Logger logger = LoggerFactory.getLogger(FileUtils.class);
    String url = null;
    String jsonString;
    DocumentContext jsonContext;
    public static String activationCode;
    private Response getGenerateActivationCodeApiResponse;

    @Step
    public Response getGenerateActivationCodeApiResponse() {

        url = ApiUrls.SCRAMBLE_GENERATEACTIVATIONCODE_API;
        RestAssured.baseURI = url;

        RequestSpecification request = RequestUtils.noAuthRequest();

        request.header("Content-type", "application/json");
        request.header("Authorization", "Basic c2NyYW1ibGVhZG1pbjpuUGR1S1hpNml3elF1ZkVMZjNWdFdZJG1sTDc1ZzU1eHNFejZ3VDFpV1R4VCQ5WUY=");

        jsonString = FileUtils.getFileContent(GENERATEACTIVATIONCODE_REQ_FILEPATH);
        jsonContext = JsonUtils.getJsonContext(jsonString);

        jsonContext.set(GENERATEACTIVATIONCODE_REQ_EMAILS_JSON_PATH.replace("emailIndex", "0"), email);

        jsonString = jsonContext.jsonString();
        request.body(jsonString);

        getGenerateActivationCodeApiResponse = request.post();
        getGenerateActivationCodeApiResponse.then().log().all();

        activationCode = getGenerateActivationCodeApiResponse.jsonPath().getString(GENERATEACTIVATIONCODE_RES_RESPONSE_ACTIVATIONCODE_JSON_PATH.replace("responseIndex", "0"));

        return getGenerateActivationCodeApiResponse;
    }

    @Step
    public void verifyGenerateActivationCodeApiResponseStatus() {
        Assert.assertEquals(getGenerateActivationCodeApiResponse.getStatusCode(), 200);
        logger.info("get generate activation code api status code: " + getGenerateActivationCodeApiResponse.getStatusCode());
    }

    @Step
    public void verifyGenerateActivationCodeApiResponseBody() {
        Assert.assertNotNull(getGenerateActivationCodeApiResponse.jsonPath().getString(GENERATEACTIVATIONCODE_RES_RESPONSE_ACTIVATIONCODE_JSON_PATH.replace("responseIndex", "0")));
    }
}
