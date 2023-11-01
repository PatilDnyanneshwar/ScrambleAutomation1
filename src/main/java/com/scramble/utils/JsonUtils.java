package com.scramble.utils;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.spi.json.JacksonJsonNodeJsonProvider;
import com.jayway.jsonpath.spi.mapper.JacksonMappingProvider;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JsonUtils {

    private static final Logger logger = LogManager.getLogger(JsonUtils.class);

    public static DocumentContext getJsonContext(String request) {
        if (StringUtils.isEmpty(request)) {
            logger.info("Empty request payload");
        }
        Configuration configuration = Configuration.builder().jsonProvider(new JacksonJsonNodeJsonProvider())
                .mappingProvider(new JacksonMappingProvider()).build();

        return JsonPath.using(configuration).parse(request);
    }
}
