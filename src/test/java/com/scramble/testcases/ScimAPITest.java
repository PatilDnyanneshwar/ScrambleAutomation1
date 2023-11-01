package com.scramble.testcases;

import com.scramble.methods.scimAPI.CreateUserMethod;
import com.scramble.methods.scimAPI.DeleteUserMethod;
import com.scramble.methods.scimAPI.GetUserMethod;
import com.scramble.methods.scimAPI.UpdateUserMethod;
import com.scramble.utils.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class ScimAPITest {
    private static final Logger logger = LoggerFactory.getLogger(FileUtils.class);
    CreateUserMethod createUserMethod;
    UpdateUserMethod updateUserMethod;
    DeleteUserMethod deleteUserMethod;
    GetUserMethod getUserMethod;

    @Test(priority = 1)
    public void verifyCreateUserPostAPI() {
        createUserMethod = new CreateUserMethod();
        logger.info("Service Name : Execute Create User POST API");
        createUserMethod.getCreateUserApiResponse();
        createUserMethod.verifyCreateUserApiResponseStatus();
        createUserMethod.verifyCreateUserApiResponseBody();
    }

    @Test(priority = 2)
    public void verifyGetUserGetAPI() {
        getUserMethod = new GetUserMethod();
        logger.info("Service Name : Execute Get User GET API");
        getUserMethod.getGetUserApiResponse();
        getUserMethod.verifyGetUserApiResponseStatus();
        getUserMethod.verifyGetUserApiResponseBody();
    }

    @Test(priority = 3)
    public void verifyUpdateUserPutAPI() {
        updateUserMethod = new UpdateUserMethod();
        logger.info("Service Name : Execute Update User PUT API");
        updateUserMethod.getUpdateUserApiResponse();
        updateUserMethod.verifyUpdateUserApiResponseStatus();
        updateUserMethod.verifyUpdateUserApiResponseBody();
    }

    @Test(priority = 4)
    public void verifyDeleteUserDeleteAPI() {
        deleteUserMethod = new DeleteUserMethod();
        logger.info("Service Name : Execute Delete User DELETE API");
        deleteUserMethod.getDeleteUserApiResponse();
        deleteUserMethod.verifyDeleteUserApiResponseStatus();
    }
}
