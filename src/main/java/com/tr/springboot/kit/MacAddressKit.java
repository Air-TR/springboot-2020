package com.tr.springboot.kit;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.Objects;

/**
 * @Author: TR
 */
public class MacAddressKit {

    /**
     * 获取 PCI Mac地址（有线 mac 地址）
     */
    public static String getPCIMacAddress() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = networkInterfaces.nextElement();
                byte[] hardwareAddress = networkInterface.getHardwareAddress();
                if (hardwareAddress != null && hardwareAddress.length > 0 && networkInterface.getDisplayName().toUpperCase().contains("PCI")) {
                    return getMacAddress(hardwareAddress);
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取已启用 Mac地址
     */
    public static String getUpMacAddress() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = networkInterfaces.nextElement();
                byte[] hardwareAddress = networkInterface.getHardwareAddress();
                if (hardwareAddress != null && hardwareAddress.length > 0 && networkInterface.isUp()) {
                    return getMacAddress(hardwareAddress);
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据 ipAddress 获取 Mac 地址
     */
    public static String getMacAddressByIpAddress() {
        try {
            InetAddress ipAddress = InetAddress.getLocalHost();
            NetworkInterface networkInterface = NetworkInterface.getByInetAddress(ipAddress);
            return Objects.nonNull(networkInterface) ? getMacAddress(networkInterface.getHardwareAddress()) : null;
        } catch (UnknownHostException | SocketException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * byte[] 类型 mac 地址转为 String
     */
    private static String getMacAddress(byte[] hardwareAddress) {
        if (hardwareAddress == null || hardwareAddress.length < 1) {
            return null;
        }
        StringBuilder macAddress = new StringBuilder();
        for (byte b : hardwareAddress) {
            macAddress.append(String.format("%02X-", b));
        }
        if (macAddress.length() > 0) {
            macAddress.deleteCharAt(macAddress.length() - 1);
        }
        return macAddress.toString();
    }

}
