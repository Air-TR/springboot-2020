package com.tr.springboot.kit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Objects;

public class NetKit {

    /**
     * 获取公网 ip
     */
    public static String getPublicIp() {
        String publicIP = null;
        if (ipReachable("ifconfig.me")) {
            URL url;
            BufferedReader br = null;
            try {
                url = new URL("https://ifconfig.me/ip");
                br = new BufferedReader(new InputStreamReader(url.openStream()));
                publicIP = br.readLine();
                br.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                if (Objects.nonNull(br)) {
                    try {
                        br.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
        return publicIP;
    }

    /**
     * 获取内网 IP
     */
    public static String getInternalIp() {
        try {
            return getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            return null;
        }
    }

    /**
     * 获取设备名称
     */
    public static String getLocalHostName() {
        try {
            return getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            return "";
        }
    }

    /**
     * 监测传入 ip/域名 是否可抵达
     */
    public static Boolean ipReachable(String ip) {
        try {
            InetAddress inetAddress = InetAddress.getByName(ip);
            return inetAddress.isReachable(3000); // 3000 毫秒
        } catch (UnknownHostException e) {
            System.out.println("无效的IP地址");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 获取本地网卡信息
     * @return
     * @throws UnknownHostException
     */
    public static InetAddress getLocalHost() throws UnknownHostException {
        return InetAddress.getLocalHost();
    }

    /**
     * <p>获取当前服务器所有符合条件的网络地址</p>
     *
     * @return List<InetAddress> 网络地址列表
     * @throws Exception 默认异常
     */
    public static List<InetAddress> getLocalAllInetAddress() throws Exception {
        List<InetAddress> result = new ArrayList<>(4);
        // 遍历所有的网络接口
        for (Enumeration networkInterfaces = NetworkInterface.getNetworkInterfaces(); networkInterfaces.hasMoreElements(); ) {
            NetworkInterface ni = (NetworkInterface) networkInterfaces.nextElement();
            // 在所有的接口下再遍历IP
            for (Enumeration addresses = ni.getInetAddresses(); addresses.hasMoreElements(); ) {
                InetAddress address = (InetAddress) addresses.nextElement();
                //排除LoopbackAddress、SiteLocalAddress、LinkLocalAddress、MulticastAddress类型的IP地址
                if (!address.isLoopbackAddress() /*&& !inetAddr.isSiteLocalAddress()*/
                        && !address.isLinkLocalAddress() && !address.isMulticastAddress()) {
                    result.add(address);
                }
            }
        }
        return result;
    }

    /**
     * 获取所有网卡信息
     *
     * @return list
     * @throws SocketException SocketException
     */
    public static List<InetAddress> getInetAddressList() throws SocketException {
        List<InetAddress> retList = new ArrayList<>();
        Enumeration netInterfaces = NetworkInterface.getNetworkInterfaces();
        while (netInterfaces.hasMoreElements()) {
            NetworkInterface ni = (NetworkInterface) netInterfaces.nextElement();
            Enumeration address = ni.getInetAddresses();
            while (address.hasMoreElements()) {
                InetAddress inetAddress = (InetAddress) address.nextElement();
                String netAdpterName = "未知网卡";
                String netIp = null;
                // 外网IP
                if (!inetAddress.isSiteLocalAddress() && !inetAddress.isLoopbackAddress() && inetAddress.getHostAddress().indexOf(":") == -1) {
                    netAdpterName = "外网-地址";
                    netIp = inetAddress.getHostAddress();
                    // 内网IP
                } else if (inetAddress.isSiteLocalAddress() && !inetAddress.isLoopbackAddress() && inetAddress.getHostAddress().indexOf(":") == -1) {
                    netAdpterName = "内网-地址";
                    netIp = inetAddress.getHostAddress();
                }
                if (netIp == null) continue;
                retList.add(inetAddress);
            }
        }
        return retList;
    }

}
