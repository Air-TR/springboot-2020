package com.tr.springboot.kit.util;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Linux 服务器远程连接工具类
 *
 * @author: rtao
 * @date: 2020/11/20 9:13
 **/
public class LinuxRemoteConnectUtil {

    public static void main(String[] args) {
        StringBuilder path = new StringBuilder("/home/datas/YSDISA/RiskSignal");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String todayString = "/" + dateFormat.format(new Date());
        path = path.append(todayString).append(todayString + ".OK");

        String hostName = "192.168.61.103";
        int port = 22;
        String username = "apprun";
        String password = "amar_s0ft";
        Connection ss = getConnect(hostName, username, password, port);

        if (fileExist(path.toString(), ss)) {
            path.replace(path.length()-3, path.length(), ".json");
            String jsonString = readFile(path.toString(), ss, "UTF-8");
            JSONArray jsonArray = JSON.parseArray(jsonString);
            System.out.println(jsonArray);
        }
    }

    /**
     * 获取远程连接
     * @author: rtao
     * @date: 2020/11/19 13:58
     **/
    public static Connection getConnect(String hostName, String username, String password, int port) {
        Connection conn = new Connection(hostName, port);
        try {
            // 连接到主机
            conn.connect();
            // 使用用户名和密码校验
            boolean isconn = conn.authenticateWithPassword(username, password);
            if (!isconn) {
                System.out.println("用户名称或者是密码不正确");
            } else {
                System.out.println("服务器连接成功.");
                return conn;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 判断远程服务器指定路径文件是否存在
     * @author: rtao
     * @date: 2020/11/19 13:59
     **/
    public static boolean fileExist(String path, Connection conn) {
        if (conn != null) {
            Session ss = null;
            try {
                ss = conn.openSession();
                ss.execCommand("ls -l ".concat(path));
                InputStream is = new StreamGobbler(ss.getStdout());
                BufferedReader brs = new BufferedReader(new InputStreamReader(is));
                String line = "";
                while (true) {
                    String lineInfo = brs.readLine();
                    ;
                    if (lineInfo != null) {
                        line = line + lineInfo;
                    } else {
                        break;
                    }
                }
                brs.close();
                if (line != null && line.length() > 0 && line.startsWith("-")) {
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                // 连接的Session和Connection对象都需要关闭
                if (ss != null) {
                    ss.close();
                }
            }
        }
        return false;
    }

    /**
     * 读取远程服务器文件内容
     * @author: rtao
     * @date: 2020/11/19 13:59
     **/
    public static String readFile(String path, Connection conn, String charsetName) {
        if (conn != null) {
            Session ss = null;
            StringBuffer stringBuffer = new StringBuffer();
            try {
                ss = conn.openSession();
                ss.execCommand("tail -100 ".concat(path));
                InputStream is = new StreamGobbler(ss.getStdout());
                BufferedReader brs = new BufferedReader(new InputStreamReader(is, charsetName));
                while (true) {
                    String line = brs.readLine();
                    if (line == null) {
                        break;
                    } else {
                        stringBuffer.append(line);
                    }
                }
                brs.close();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                // 连接的Session和Connection对象都需要关闭
                if (ss != null) {
                    ss.close();
                }
                if (conn != null) {
                    conn.close();
                }
                return stringBuffer.toString();
            }
        }
        return "";
    }

}
