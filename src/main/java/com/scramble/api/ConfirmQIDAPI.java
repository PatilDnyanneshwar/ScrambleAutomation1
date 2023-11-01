package com.scramble.api;

public interface ConfirmQIDAPI {

    //Confirm QID
    String CONFIRMQID_REQ_FILEPATH = "//request//confirmQID.json";

    String CONFIRMQID_REQ_UNIQUEID_JSON_PATH = "uniqueId";
    String CONFIRMQID_REQ_SUID_JSON_PATH = "suid";
    String CONFIRMQID_REQ_ZID_JSON_PATH = "zid";
    String CONFIRMQID_REQ_TIMESTAMP_JSON_PATH = "timestamp";
    String CONFIRMQID_REQ_CONFIRM_JSON_PATH = "confirm";
    String CONFIRMQID_REQ_SIGNATURE_JSON_PATH = "signature";

    String CONFIRMQID_RES_ERRORCODE_JSON_PATH = "errorCode";
    String CONFIRMQID_RES_RESULTCODE_JSON_PATH = "resultCode";
}
