package com.tr.springboot.kit.windows;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Objects;

/**
 * 磁盘工具类
 *
 * @Author: TR
 * @Date: 2023/8/11
 */
public class DiskKit {

    /**
     * 获取系统第一个磁盘序列号
     */
    public static String getFirstDiskId() {
        try {
            // 执行 diskpart 命令
            Process process = Runtime.getRuntime().exec("diskpart");
            // 执行 list disk 命令
            process.getOutputStream().write("list disk\n".getBytes());
            // 执行 select disk 0 命令
            process.getOutputStream().write("select disk 0\n".getBytes());
            // 执行 detail disk 命令
            process.getOutputStream().write("detail disk\n".getBytes());
            process.getOutputStream().write("exit\n".getBytes());
            // 获取命令输出流
            process.getOutputStream().flush();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream(), Charset.forName("GBK")));
            String line;
            // 继续获取命令输出
            while ((line = reader.readLine()) != null) {
                if (line.contains("磁盘 ID:") || line.contains("Disk ID:")) {
                    return line.split(":")[1].trim();
                }
            }
            // 等待命令执行完毕
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取 windows 系统第一个分区盘序列号
     */
    public static String getFirstPartitionDiskId() {
        try {
            File[] roots = File.listRoots();
            if (Objects.nonNull(roots) && roots.length > 0) {
                FileStore store = Files.getFileStore(roots[0].toPath());
                return store.getAttribute("volume:vsn").toString();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取 windows 系统所有分区盘序列号
     */
    public static HashMap getAllPartitionDiskIds() {
        HashMap map = new HashMap();
        File[] roots = File.listRoots();
        for (File root : roots) {
            String driveLetter = root.getAbsolutePath().substring(0, 1);
            try {
                FileStore store = Files.getFileStore(root.toPath());
                map.put(driveLetter, store.getAttribute("volume:vsn"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return map;
    }

}
