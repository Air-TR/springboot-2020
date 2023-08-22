package com.tr.springboot.kit.file;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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
public class FileKit {

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
