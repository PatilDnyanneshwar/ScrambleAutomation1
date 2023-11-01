package com.scramble.api;

public interface VerifyQIDAPI {

    //Verify QID
    String VERIFYQID_REQ_FILEPATH = "//request//verifyQID.json";

    String VERIFYQID_REQ_UNIQUEID_JSON_PATH = "uniqueId";
    String VERIFYQID_REQ_SUID_JSON_PATH = "suid";
    String VERIFYQID_REQ_ZID_JSON_PATH = "zid";
    String VERIFYQID_REQ_TIMESTAMP_JSON_PATH = "timestamp";
    String VERIFYQID_REQ_SIGNATURE_JSON_PATH = "signature";

    String VERIFYQID_RES_ERRORCODE_JSON_PATH = "errorCode";
    String VERIFYQID_RES_RESULTCODE_JSON_PATH = "resultCode";
    String VERIFYQID_RES_ACTION_JSON_PATH = "action";
    String VERIFYQID_RES_MESSAGE_JSON_PATH = "message";
    String VERIFYQID_RES_ORGNAME_JSON_PATH = "orgName";
    String VERIFYQID_RES_OP_JSON_PATH = "op";
}
