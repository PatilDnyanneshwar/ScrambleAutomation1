package com.scramble.api;

public interface RSASignAPI {

    //RSA Sign Generate
    String RSASIGN_REQ_FILEPATH = "//request//rsaSign.json";

    String RSASIGN_REQ_PAYLOAD_JSON_PATH = "payload";
    String RSASIGN_REQ_PRIVATEKEY_JSON_PATH = "privateKey";

    String RSASIGN_RES_SIGNATURE_JSON_PATH = "signature";
    String RSASIGN_RES_SIGNATURE2_JSON_PATH = "signature";
}
