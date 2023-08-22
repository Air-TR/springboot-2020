package com.tr.springboot.kit;

import java.io.File;
import java.io.IOException;
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
     * 获取 windows 系统第一个磁盘序列号
     */
    public static String getFirstDiskSerial() {
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
     * 获取 windows 系统所有磁盘序列号
     */
    public static HashMap getAllDiskSerials() {
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
