package com.scramble.constants;

import com.scramble.utils.PropertyUtils;

public interface Authorization {

    String USERNAME = PropertyUtils.getProperty("username");
    String PASSWORD = PropertyUtils.getProperty("password");
}
