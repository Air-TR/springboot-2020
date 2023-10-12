package com.tr.springboot.kit.windows;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Author: TR
 */
public class SystemKit {

    /**
     * 获取系统用户名
     */
    public static String getSystemUsername() {
        return System.getProperty("user.name");
    }

    /**
     * 获取设备名称（Windows 计算机名）
     */
    public static String getDeviceName() {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            return null;
        }
    }

}
