package com.scramble.constants;

import com.scramble.utils.PropertyUtils;

public interface ApiUrls {

    String SCRAMBLE_BASE_URL = PropertyUtils.getProperty("scramble.base.url");
    String SCRAMBLE_APPLICATION_URL = PropertyUtils.getProperty("ApplicationURL");
    String SCRAMBLE_GET_USER_API = SCRAMBLE_APPLICATION_URL + "/scim/v2/users/";
    String SCRAMBLE_CREATE_USER_API = SCRAMBLE_APPLICATION_URL + "/scim/v2/users";
    String SCRAMBLE_UPDATE_USER_API = SCRAMBLE_APPLICATION_URL + "/scim/v2/users/";
    String SCRAMBLE_DELETE_USER_API = SCRAMBLE_APPLICATION_URL + "/scim/v2/users/";
    String SCRAMBLE_GENERATEACTIVATIONCODE_API = PropertyUtils.getProperty("scramble.generateactivationcode.url");
    String SCRAMBLE_RSAKEYGEN_API = PropertyUtils.getProperty("scramble.rsakeygen.url");
    String SCRAMBLE_USER_REGISTRATION_API = SCRAMBLE_APPLICATION_URL + "/user/register";
    String SCRAMBLE_RSASIGN_API = PropertyUtils.getProperty("scramble.rsasign.url");
    String SCRAMBLE_USER_OTP_VERIFY_API = SCRAMBLE_APPLICATION_URL + "/otp/verify";
    String SCRAMBLE_GET_QID_API = SCRAMBLE_APPLICATION_URL + "/login/saml/ZGVtfHxkZW1vZ3Vlc3QuY29t?SAMLRequest=fZFvT8IwEIe%2FStP30P1xAg0jQYmyBCLCxMi7W%2BmgcWtHr0M%2BvmNg1De8vNxdn3t%2BHSKURcXHtdvrpTzUEh05lYVG3jZiWlvNDaBCrqGUyJ3gq%2FF8xoOuxytrnBGmoH9Wbm8AorROGU3Jk7FCttyY5lCgpIQkk5hCX4ow9%2F38TkRCBkGWRZmXQeB7XtQbAAy292EuQfQpSRBrmWh0oF1MAy8IO77f8fzUi3jU42FvQ8mkMVIazsyY7p2rkDN2gC4KC2VWSLXtClMyqBQ7%2BqwwO6XZ2YNtntcun54%2BN%2B%2F%2BcROuCxG%2B1h%2FBwFEy%2FpF4NBrrUtqVtEcl5Nty9ovAyjXkroIS9%2BZLAMoLR2DjubgG96D0Vund7cyyyxDyaZouOouXVdq8QNbSYuvUjNDR8Hwyb%2FOwZJSM56srdMj%2BdEaX6v93j74B";
    String SCRAMBLE_VERIFY_QID_API = SCRAMBLE_APPLICATION_URL + "/verify/did";
    String SCRAMBLE_CONFIRM_QID_API = SCRAMBLE_APPLICATION_URL + "/confirm/qid";
    String SCRAMBLE_WEBSOCKET_REQUEST = PropertyUtils.getProperty("scramble.websocket.url");
}
