package com.scramble.api;

public interface ScimAPI {

    //Create User
    String CREATEUSER_REQ_FILEPATH = "//request//createUser.json";

    String CREATEUSER_REQ_USERNAME_JSON_PATH = "userName";
    String CREATEUSER_REQ_NAME_JSON_PATH = "name";
    String CREATEUSER_REQ_NAME_FAMILYNAME_JSON_PATH = "name.familyName";
    String CREATEUSER_REQ_NAME_GIVENNAME_JSON_PATH = "name.givenName";
    String CREATEUSER_REQ_EMAILS_JSON_PATH = "emails";
    String CREATEUSER_REQ_EMAILS_PRIMARY_JSON_PATH = "emails[emailIndex].primary";
    String CREATEUSER_REQ_EMAILS_VALUE_JSON_PATH = "emails[emailIndex].value";
    String CREATEUSER_REQ_EMAILS_TYPE_JSON_PATH = "emails[emailIndex].type";
    String CREATEUSER_REQ_LDAPID_JSON_PATH = "ldapId";
    String CREATEUSER_REQ_WINDOWSID_JSON_PATH = "windowsId";
    String CREATEUSER_REQ_ROLES_JSON_PATH = "roles";
    String CREATEUSER_REQ_ACTIVE_JSON_PATH = "active";
    String CREATEUSER_REQ_SCRAMBLEOPS_JSON_PATH = "scrambleOps";
    String CREATEUSER_REQ_SCRAMBLEOPS_SENDACTIVATION_JSON_PATH = "scrambleOps.sendActivation";

    String CREATEUSER_RES_ID_JSON_PATH = "id";
    String CREATEUSER_RES_USERNAME_JSON_PATH = "userName";
    String CREATEUSER_RES_EMAILS_VALUE_JSON_PATH = "emails[emailIndex].value";
    String CREATEUSER_RES_ACTIVE_JSON_PATH = "active";
    String CREATEUSER_RES_META_RESOURCETYPE_JSON_PATH = "meta.resourceType";

    //Update User
    String UPDATEUSER_REQ_FILEPATH = "//request//updateUser.json";

    String UPDATEUSER_REQ_USERNAME_JSON_PATH = "userName";
    String UPDATEUSER_REQ_NAME_JSON_PATH = "name";
    String UPDATEUSER_REQ_NAME_FAMILYNAME_JSON_PATH = "name.familyName";
    String UPDATEUSER_REQ_NAME_GIVENNAME_JSON_PATH = "name.givenName";
    String UPDATEUSER_REQ_NAME_PREFERREDFIRSTNAME_JSON_PATH = "name.preferredFirstName";
    String UPDATEUSER_REQ_NAME_PREFERREDLASTNAME_JSON_PATH = "name.preferredLastName";
    String UPDATEUSER_REQ_EMAILS_JSON_PATH = "emails";
    String UPDATEUSER_REQ_EMAILS_PRIMARY_JSON_PATH = "emails[emailIndex].primary";
    String UPDATEUSER_REQ_EMAILS_VALUE_JSON_PATH = "emails[emailIndex].value";
    String UPDATEUSER_REQ_EMAILS_TYPE_JSON_PATH = "emails[emailIndex].type";
    String UPDATEUSER_REQ_LDAPID_JSON_PATH = "ldapId";
    String UPDATEUSER_REQ_WINDOWSID_JSON_PATH = "windowsId";
    String UPDATEUSER_REQ_ENABLEDESKTOPAPP_JSON_PATH = "enableDesktopApp";
    String UPDATEUSER_REQ_FAVCOLOR_JSON_PATH = "favColor";
    String UPDATEUSER_REQ_ROLES_JSON_PATH = "roles";
    String UPDATEUSER_REQ_SCRAMBLEOPS_JSON_PATH = "scrambleOps";
    String UPDATEUSER_REQ_SCRAMBLEOPS_SENDACTIVATION_JSON_PATH = "scrambleOps.sendActivation";

    String UPDATEUSER_RES_ID_JSON_PATH = "id";
    String UPDATEUSER_RES_USERNAME_JSON_PATH = "userName";
    String UPDATEUSER_RES_EMAILS_VALUE_JSON_PATH = "emails[emailIndex].value";
    String UPDATEUSER_RES_ACTIVE_JSON_PATH = "active";
    String UPDATEUSER_RES_META_RESOURCETYPE_JSON_PATH = "meta.resourceType";

    //Delete User
    String DELETEUSER_REQ_FILEPATH = "//request//updateUser.json";
}
