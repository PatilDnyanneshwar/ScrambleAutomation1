package com.scramble.testcases;

import com.scramble.methods.*;
import com.scramble.methods.scimAPI.CreateUserMethod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class DidAPITest {

    private static final Logger logger = LogManager.getLogger(DidAPITest.class);
    CreateUserMethod createUserMethod;
    GenerateActivationCodeMethod generateActivationCodeMethod;
    RSAKeygenMethod rsaKeygenMethod;
    UserRegistrationMethod userRegistrationMethod;
    RSASignMethod rsaSignMethod;
    UserOtpVerifyMethod userOtpVerifyMethod;
    GetQIDMethod getQIDMethod;
    WebSocketMethod webSocketMethod;
    VerifyQIDMethod verifyQIDMethod;
    ConfirmQIDMethod confirmQIDMethod;

    @Test(priority = 1)
    public void verifyCreateUserPostAPI() {
        createUserMethod = new CreateUserMethod();
        logger.info("Service Name : Execute Create User POST API");
        createUserMethod.getCreateUserApiResponse();
        createUserMethod.verifyCreateUserApiResponseStatus();
        createUserMethod.verifyCreateUserApiResponseBody();
    }

    @Test(priority = 2)
    public void verifyGenerateActivationCodePostAPI() {
        generateActivationCodeMethod = new GenerateActivationCodeMethod();
        logger.info("Service Name : Execute Generate Activation Code POST API");
        generateActivationCodeMethod.getGenerateActivationCodeApiResponse();
        generateActivationCodeMethod.verifyGenerateActivationCodeApiResponseStatus();
        generateActivationCodeMethod.verifyGenerateActivationCodeApiResponseBody();
    }

    @Test(priority = 3)
    public void verifyRSAKeygenGetAPI() {
        rsaKeygenMethod = new RSAKeygenMethod();
        logger.info("Service Name : Execute RSA Keygen GET API");
        rsaKeygenMethod.getRSAKeygenApiResponse();
        rsaKeygenMethod.verifyRSAKeygenApiResponseStatus();
        rsaKeygenMethod.verifyRSAKeygenApiResponseBody();
    }

    @Test(priority = 4)
    public void verifyUserRegistrationPostAPI() {
        userRegistrationMethod = new UserRegistrationMethod();
        logger.info("Service Name : Execute User Registration POST API");
        userRegistrationMethod.getUserRegistrationApiResponse();
        userRegistrationMethod.verifyUserRegistrationApiResponseStatus();
        userRegistrationMethod.verifyUserRegistrationApiResponseBody();
    }

    @Test(priority = 5)
    public void verifyRSASignPostAPI() {
        rsaSignMethod = new RSASignMethod();
        logger.info("Service Name : Execute RSA Sign POST API");
        rsaSignMethod.getRSASignApiResponse();
        rsaSignMethod.verifyRSASignApiResponseStatus();
        rsaSignMethod.verifyRSASignApiResponseBody();
    }

    @Test(priority = 6)
    public void verifyUserOtpVerifyPostAPI() {
        userOtpVerifyMethod = new UserOtpVerifyMethod();
        logger.info("Service Name : Execute User OTP Verify POST API");
        userOtpVerifyMethod.getUserOtpVerifyApiResponse();
        userOtpVerifyMethod.verifyUserOtpVerifyApiResponseStatus();
        userOtpVerifyMethod.verifyUserOtpVerifyApiResponseBody();
    }

    @Test(priority = 7)
    public void verifyGetQidByGetAPI() {
        getQIDMethod = new GetQIDMethod();
        logger.info("Service Name : Execute Get QID GET API");
        getQIDMethod.getGetQIDApiResponse();
        getQIDMethod.verifyGetQIDApiResponseStatus();
        getQIDMethod.verifyGetQIDApiResponseBody();
    }

    @Test(priority = 8)
    public void verifyWebSocketConnectionOpen() throws InterruptedException {
        webSocketMethod = new WebSocketMethod();
        logger.info("Service Name : Execute WebSocket Open Connection");
        webSocketMethod.connection();
        webSocketMethod.connect();
//        webSocketMethod.createContext();
//        webSocketMethod.verifyWebSocketAPI();
        Thread.sleep(5000);
    }

    @Test(priority = 9)
    public void verifyRSASign2PostAPI() {
        rsaSignMethod = new RSASignMethod();
        logger.info("Service Name : Execute RSA Sign2 POST API");
        rsaSignMethod.getRSASign2ApiResponse();
        rsaSignMethod.verifyRSASign2ApiResponseStatus();
        rsaSignMethod.verifyRSASign2ApiResponseBody();
    }

    @Test(priority = 10)
    public void verifyQIDPostAPI() {
        verifyQIDMethod = new VerifyQIDMethod();
        logger.info("Service Name : Execute verify QID POST API");
        verifyQIDMethod.getVerifyQIDApiResponse();
        verifyQIDMethod.verifyVerifyQIDApiResponseStatus();
        verifyQIDMethod.verifyVerifyQIDApiResponseBody();
    }

    @Test(priority = 11)
    public void verifyWebSocketWaitForConfirmResponse() {
        webSocketMethod = new WebSocketMethod();
        logger.info("Service Name : Execute WebSocket Wait For Confirm Response");
        webSocketMethod.connection();
        webSocketMethod.message();
//        webSocketMethod.createContext();
//        webSocketMethod.verifyWebSocketAPI1();
    }

    @Test(priority = 12)
    public void verifyConfirmQIDPostAPI() {
        confirmQIDMethod = new ConfirmQIDMethod();
        logger.info("Service Name : Execute confirm QID POST API");
        confirmQIDMethod.getConfirmQIDApiResponse();
        confirmQIDMethod.verifyConfirmQIDApiResponseStatus();
        confirmQIDMethod.verifyConfirmQIDApiResponseBody();
    }

    @Test(priority = 13)
    public void verifyWebSocketSamlResponse() {
        webSocketMethod = new WebSocketMethod();
        logger.info("Service Name : Execute WebSocket Saml Response");
        webSocketMethod.createContext1();
        webSocketMethod.verifyWebSocketAPI2();
    }

    @Test(priority = 14)
    public void verifyWebSocketConnectionClose() throws InterruptedException {
        webSocketMethod = new WebSocketMethod();
        logger.info("Service Name : Execute WebSocket Close Connection");
        webSocketMethod.connection();
        webSocketMethod.close();
    }
}
