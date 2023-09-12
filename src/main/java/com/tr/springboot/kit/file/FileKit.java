package com.tr.springboot.kit.file;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

/**
 * @Author: TR
 */
@Slf4j
public class FileKit {

    /**
     * 判断文件夹是否存在，不存在创建对应文件夹
     * @param folderPath
     * @return
     */
    public static Boolean checkAndMkdirs(String folderPath) {
        File folder = new File(folderPath);
        if (!folder.exists()) {
            if (folder.mkdirs()) {
                log.info("文件夹已创建成功");
            } else {
                log.error("无法创建文件夹");
                return false;
            }
        } else {
            log.info("文件夹已存在");
        }
        return true;
    }

    /**
     * 写入内容到文件
     * @param filePath
     * @param content
     * @throws IOException
     */
    public static final void writeToFile(String filePath, String content) throws IOException {
        BufferedWriter out = new BufferedWriter(new FileWriter(filePath));
        out.write(content);
        out.close();
    }

    /**
     * 读取文件内容
     * @param filePath
     * @return
     * @throws IOException
     */
    public static final String readFromFile(String filePath) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(filePath));
        StringBuilder stringBuilder = new StringBuilder();
        String str;
        while (Objects.nonNull(str = in.readLine())) {
            stringBuilder.append(str);
        }
        return stringBuilder.toString();
    }

    /**
     * 上传文件
     * @param uploadPath
     * @param file
     */
    public static void upload(String uploadPath, MultipartFile file) {
        try {
            Path filePath = Paths.get(uploadPath, file.getOriginalFilename());
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 下载文件
     * @param filePath
     * @param fileName
     * @param response
     */
    public static void download(String filePath, String fileName, HttpServletResponse response){
        // 源文件
        File file = new File(filePath);
        if (!file.exists()) {
            throw new RuntimeException("下载的文件不存在！");
        }
        OutputStream out = null;
        FileInputStream input = null;
        try {
            out = response.getOutputStream();
            // 设置 ContentType CharacterEncoding Header, 需要在 out.write() 之前设置
            response.setContentType("mutipart/form-data"); // "application/x-download"？
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Content-Disposition", "attachment; filename=" + java.net.URLEncoder.encode(fileName, "UTF-8"));
            response.setHeader("Access-Control-Expose-Headers", "Content-Disposition");
            input = new FileInputStream(file);
            int len;
            byte[] bytes = new byte[1024];
            while ((len = input.read(bytes)) > 0) {
                out.write(bytes,0,len);
            }
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (input != null) {
                    input.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 拷贝文件
     * @param in
     * @param out
     */
    public static void copyFile(File in, File out) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(in);
            fos = new FileOutputStream(out);
            byte[] buf = new byte[1024];
            int i = 0;
            while ((i = fis.read(buf)) != -1) {
                fos.write(buf, 0, i);
            }
        } catch (IOException ie) {
            ie.printStackTrace();
        } finally {
            if (Objects.nonNull(fis)) {
                try {
                    fis.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (Objects.nonNull(fos)) {
                try {
                    fos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}
