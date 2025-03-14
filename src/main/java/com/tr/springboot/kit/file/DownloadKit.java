package com.tr.springboot.kit.file;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

/**
 * @Author taorun
 * @Date 2025/3/14
 */
public class DownloadKit {

    /**
     * 将字符串内容生成文件下载 —— InputStreamResource 方式
     * @param content 要写入文件的字符串内容
     * @return
     */
    public static ResponseEntity<InputStreamResource> downloadStringContent(String content) {
        // 将字符串转换为字节数组
        byte[] bytes = content.getBytes(StandardCharsets.UTF_8);

        // 创建 ByteArrayInputStream
        ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);

        // 设置响应头
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, String.format("attachment; filename=log%s.txt", System.currentTimeMillis()));

        // 返回响应实体
        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(bytes.length)
                .body(new InputStreamResource(inputStream));
    }

    /**
     * 将字符串内容生成文件下载 —— ByteArrayResource 方式
     * @param content 要写入文件的字符串内容
     * @return
     */
    public static ResponseEntity<ByteArrayResource> downloadStringContent2(String content) {
        // 将字符串转换为字节数组
        byte[] bytes = content.getBytes(StandardCharsets.UTF_8);

        // 创建 ByteArrayResource
        ByteArrayResource resource = new ByteArrayResource(bytes);

        // 设置响应头
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, String.format("attachment; filename=log%s.txt", System.currentTimeMillis()));

        // 返回响应实体
        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(bytes.length)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }

}
