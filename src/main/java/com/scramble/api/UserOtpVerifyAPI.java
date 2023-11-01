package com.scramble.api;

public interface UserOtpVerifyAPI {

    //User OTP Verify
    String USEROTPVERIFY_REQ_FILEPATH = "//request//userOtpVerify.json";

    String USEROTPVERIFY_REQ_SUID_JSON_PATH = "suid";
    String USEROTPVERIFY_REQ_OTP_JSON_PATH = "otp";
    String USEROTPVERIFY_REQ_SIGNATURE_JSON_PATH = "signature";
    String USEROTPVERIFY_REQ_DEVICENAME_JSON_PATH = "deviceName";
    String USEROTPVERIFY_REQ_TIMESTAMP_JSON_PATH = "timestamp";

    String USEROTPVERIFY_RES_ERRORCODE_JSON_PATH = "errorCode";
    String USEROTPVERIFY_RES_TIMESTAMP_JSON_PATH = "timestamp";
    String USEROTPVERIFY_RES_RESULTCODE_JSON_PATH = "resultCode";
    String USEROTPVERIFY_RES_ZID_JSON_PATH = "zid";
    String USEROTPVERIFY_RES_SERVERPUBLICKEY_JSON_PATH = "serverPublicKey";
}
