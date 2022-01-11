package com.tr.springboot.util;

import com.alibaba.fastjson.JSON;

/**
 * @author rtao
 * @date 2022/1/11 11:51
 */
public class JsonUtil {

    /**
     * java object --> json string
     * @param object
     * @return
     */
    public static String toJSONString(Object object) {
        return JSON.toJSONString(object);
    }

    /**
     * json string --> java object
     * @param jsonString
     * @return
     */
    public static Object parse(String jsonString) {
        return JSON.parse(jsonString);
    }

    // todo 其他工具类方法用到了补充即可

}
