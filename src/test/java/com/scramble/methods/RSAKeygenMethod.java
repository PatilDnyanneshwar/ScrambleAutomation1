package com.scramble.methods;

import com.scramble.constants.ApiUrls;
import com.scramble.utils.FileUtils;
import com.scramble.utils.request.RequestUtils;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import static com.scramble.api.RSAKeygenAPI.RSAKEYGEN_RES_PRIVATE_JSON_PATH;
import static com.scramble.api.RSAKeygenAPI.RSAKEYGEN_RES_PUBLIC_JSON_PATH;

public class RSAKeygenMethod {
    private static final Logger logger = LoggerFactory.getLogger(FileUtils.class);
    String url = null;
    public static String publicKey;
    public static String privateKey;
//    public static String privateKeyy;
//    public static String publicKeyy;

    private Response getRSAKeygenApiResponse;

    @Step
    public Response getRSAKeygenApiResponse() {

        url = ApiUrls.SCRAMBLE_RSAKEYGEN_API;
        RestAssured.baseURI = url;

        RequestSpecification request = RequestUtils.noAuthRequest();

        getRSAKeygenApiResponse = request.get();
        getRSAKeygenApiResponse.then().log().all();

        privateKey = getRSAKeygenApiResponse.jsonPath().getString(RSAKEYGEN_RES_PRIVATE_JSON_PATH);
        publicKey = getRSAKeygenApiResponse.jsonPath().getString(RSAKEYGEN_RES_PUBLIC_JSON_PATH);

//        privateKeyy = privateKey.replaceAll("-----BEGIN RSA PRIVATE KEY-----", "-----BEGIN PRIVATE KEY-----")
//                .replaceAll("-----END RSA PRIVATE KEY-----", "-----END PRIVATE KEY-----")
//                .replaceAll("\n", "");

//        publicKeyy = publicKey.replaceAll("-----BEGIN PUBLIC KEY-----", "")
//                .replaceAll("-----BEGIN PUBLIC KEY-----", "")
//                .replaceAll("\n", "");

//        System.out.println(privateKeyy);
//        System.out.println(publicKeyy);

        return getRSAKeygenApiResponse;
    }

    @Step
    public void verifyRSAKeygenApiResponseStatus() {
        Assert.assertEquals(getRSAKeygenApiResponse.getStatusCode(), 200);
        logger.info("get rsa keygen api status code: " + getRSAKeygenApiResponse.getStatusCode());
    }

    @Step
    public void verifyRSAKeygenApiResponseBody() {
        Assert.assertNotNull(getRSAKeygenApiResponse.jsonPath().getString(RSAKEYGEN_RES_PRIVATE_JSON_PATH));
        Assert.assertNotNull(getRSAKeygenApiResponse.jsonPath().getString(RSAKEYGEN_RES_PUBLIC_JSON_PATH));
    }
}
