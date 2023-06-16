package com.tr.springboot.kit;

import java.util.UUID;

/**
 * @Author: TR
 * @Date: 2023/3/9
 */
public class UuidKit {

    public static String createUuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

}
