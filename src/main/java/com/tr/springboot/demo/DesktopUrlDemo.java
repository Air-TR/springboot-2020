package com.tr.springboot.demo;

import java.awt.Desktop;
import java.net.URL;

/**
 * @Author: TR
 */
public class DesktopUrlDemo {

    public static void main(String[] args) throws Exception {
        Desktop desktop = Desktop.getDesktop();
        // 要打开的 URL
        String urlStr = "https://www.baidu.com";
        // 创建 URL 对象
        URL url = new URL(urlStr);
        // 调用 open() 方法打开 URL
        desktop.browse(url.toURI());
    }

}
