package com.tr.springboot.kit.http;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @Author: TR
 * @Date: 2023/8/18
 */
public class HttpKit {

    public static void main(String[] args) {
        httpRequest("GET", "http://192.168.0.159:8082/licenseApply/test");
    }

    public static void httpRequest(String requestType, String apiUrl) {
        try {
            // 创建 URL 对象
            URL url = new URL(apiUrl);
            // 打开连接
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            // 设置请求方法：GET、POST、PUT、DELETE
            connection.setRequestMethod(requestType);
            // 发送请求
            int responseCode = connection.getResponseCode();
            // 检查响应码
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // 读取响应内容
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                StringBuilder response = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();
                // 处理响应内容
                System.out.println(response);
            } else {
                // 处理错误情况
                System.out.println("请求失败，响应码：" + responseCode);
            }
            // 关闭连接
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
