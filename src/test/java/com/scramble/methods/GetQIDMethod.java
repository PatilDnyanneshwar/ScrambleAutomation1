package com.scramble.methods;

import com.scramble.constants.ApiUrls;
import com.scramble.constants.Params;
import com.scramble.utils.FileUtils;
import com.scramble.utils.request.RequestUtils;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import static com.scramble.api.GetQIDAPI.GETQID_RES_DID_JSON_PATH;
import static com.scramble.api.GetQIDAPI.GETQID_RES_QID_JSON_PATH;

public class GetQIDMethod {
    private static final Logger logger = LoggerFactory.getLogger(FileUtils.class);
    String url = null;
    public static String qid;
    private Response getGetQIDApiResponse;

    @Step
    public Response getGetQIDApiResponse() {

        url = ApiUrls.SCRAMBLE_GET_QID_API;
        RestAssured.baseURI = url;

        RequestSpecification request = RequestUtils.noAuthRequest();

        request.queryParams(Params.SAML_REQUEST_PARAM, "fZLd[%E2%80%A6]d1u4S8YJSfE2WFgouRb1v%2B8Z%2FZR4BGuNTc6jUw%3D%3D");
        request.queryParams(Params.FORMAT_PARAM, "json");

        getGetQIDApiResponse = request.get();
        getGetQIDApiResponse.then().log().all();

        qid = getGetQIDApiResponse.jsonPath().getString(GETQID_RES_QID_JSON_PATH);

        return getGetQIDApiResponse;
    }

    @Step
    public void verifyGetQIDApiResponseStatus() {
        Assert.assertEquals(getGetQIDApiResponse.getStatusCode(), 200);
        logger.info("get get qid api status code: " + getGetQIDApiResponse.getStatusCode());
    }

    @Step
    public void verifyGetQIDApiResponseBody() {
        Assert.assertNotNull(getGetQIDApiResponse.jsonPath().getString(GETQID_RES_QID_JSON_PATH));
        Assert.assertNotNull(getGetQIDApiResponse.jsonPath().getString(GETQID_RES_DID_JSON_PATH));
    }
}
