package com.tr.springboot.util;

import com.alibaba.fastjson.JSON;

/**
 * Json 工具类
 *
 * @author TR
 * @date 2021/11/11 上午11:17
 */
public class JsonUtils {

    public static String objectToJsonString(Object object) {
        return JSON.toJSONString(object);
    }

    public static Object jsonStringToObject(String jsonString, Class c) {
        return JSON.parseObject(jsonString, c);
    }

}
