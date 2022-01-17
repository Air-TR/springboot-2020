package com.tr.springboot.util;

import com.alibaba.fastjson.JSON;
import com.tr.springboot.web.entity.Account;

/**
 * @author rtao
 * @date 2022/1/11 11:51
 */
public class JsonUtil {

    public static void main(String[] args) {
        Account account = new Account();
        account.setId(1);
        account.setAge(19);
        account.setName("Taylor");

        String jsonString = toJSONString(account);

        Account account1 = toJavaObject(jsonString, Account.class);
        Account account2 = parseObject(jsonString, Account.class);

        System.out.println(111);
    }

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
    public static <T> T toJavaObject(String jsonString, Class<T> clazz) {
        return JSON.toJavaObject(JSON.parseObject(jsonString), clazz);
    }

    /**
     * json string --> java object
     * @param jsonString
     * @return
     */
    public static <T> T parseObject(String jsonString, Class<T> clazz) {
        return JSON.parseObject(jsonString, clazz);
    }

}
