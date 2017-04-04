package com.clsaa.blog.gateway.zuul.util.jackson;

import com.clsaa.blog.gateway.zuul.response.ResultObj;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by eggyer on 2017/3/18.
 */
public class JsonUtil {
    public static final Logger logger = LoggerFactory.getLogger(JsonUtil.class);
    public static String ObjToString(ResultObj resultObj){
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(resultObj);
        } catch (JsonProcessingException e) {
            logger.error(String.valueOf(e.getCause()));
            return null;
        }
    }
}
