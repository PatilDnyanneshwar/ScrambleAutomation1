package com.scramble.api;

public interface GenerateActivationCodeAPI {

    //Generate Activation Code
    String GENERATEACTIVATIONCODE_REQ_FILEPATH = "//request//generateActivationCode.json";

    String GENERATEACTIVATIONCODE_REQ_EMAILS_JSON_PATH = "emails[emailIndex]";
    String GENERATEACTIVATIONCODE_REQ_SENDEMAIL_JSON_PATH = "sendEmail";
    String GENERATEACTIVATIONCODE_REQ_ORGCODE_JSON_PATH = "orgCode";

    String GENERATEACTIVATIONCODE_RES_ERRORCODE_JSON_PATH = "errorCode";
    String GENERATEACTIVATIONCODE_RES_TIMESTAMP_JSON_PATH = "timestamp";
    String GENERATEACTIVATIONCODE_RES_STATUSCODE_JSON_PATH = "statusCode";
    String GENERATEACTIVATIONCODE_RES_RESPONSE_JSON_PATH = "response";
    String GENERATEACTIVATIONCODE_RES_RESPONSE_ORGEMAIL_JSON_PATH = "response[responseIndex].orgEmail";
    String GENERATEACTIVATIONCODE_RES_RESPONSE_ACTIVATIONCODE_JSON_PATH = "response[responseIndex].activationCode";
}
