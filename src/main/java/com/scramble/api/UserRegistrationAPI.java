package com.scramble.api;

public interface UserRegistrationAPI {

    //User Registration
    String USERREGISTRATION_REQ_FILEPATH = "//request//userRegistration.json";

    String USERREGISTRATION_REQ_EMAIL_JSON_PATH = "email";
    String USERREGISTRATION_REQ_MOBILE_JSON_PATH = "mobile";
    String USERREGISTRATION_REQ_ACTIVATIONCODE_JSON_PATH = "activationCode";
    String USERREGISTRATION_REQ_PUBLICKEY_JSON_PATH = "publicKey";
    String USERREGISTRATION_REQ_TIMESTAMP_JSON_PATH = "timestamp";
    String USERREGISTRATION_REQ_ORGEMAIL_JSON_PATH = "orgEmail";

    String USERREGISTRATION_RES_ERRORCODE_JSON_PATH = "errorCode";
    String USERREGISTRATION_RES_TIMESTAMP_JSON_PATH = "timestamp";
    String USERREGISTRATION_RES_RESULTCODE_JSON_PATH = "resultCode";
    String USERREGISTRATION_RES_SUID_JSON_PATH = "suid";
    String USERREGISTRATION_RES_ORGCODE_JSON_PATH = "orgCode";
    String USERREGISTRATION_RES_ORGNAME_JSON_PATH = "orgName";
    String USERREGISTRATION_RES_OTPEXP_JSON_PATH = "otpExp";
    String USERREGISTRATION_RES_OTP_JSON_PATH = "otp";
}
