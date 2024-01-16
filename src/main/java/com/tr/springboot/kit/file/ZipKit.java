package com.tr.springboot.kit.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @Author: TR
 */
public class ZipKit {

    public static void zipFiles(String sourceFilePath, String destinationZipFile) {
        try (FileOutputStream fos = new FileOutputStream(destinationZipFile); // 输出流指向目标ZIP文件路径
             ZipOutputStream zos = new ZipOutputStream(fos);) { // 创建ZIP输出流对象
            File fileToZip = new File(sourceFilePath); // 获取源文件/目录
            if (fileToZip.isDirectory()) { // 判断是否为目录
                addFolderToZip(zos, fileToZip, ""); // 调用添加目录到ZIP的方法
            } else {
                try (FileInputStream fis = new FileInputStream(fileToZip)) { // 读取源文件内容
                    byte[] buffer = new byte[1024];
                    zos.putNextEntry(new ZipEntry(fileToZip.getName())); // 设置ZIP条目
                    int length;
                    while ((length = fis.read(buffer)) > 0) {
                        zos.write(buffer, 0, length); // 将数据写入ZIP文件
                    }
                    zos.closeEntry(); // 结束当前ZIP条目
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void addFolderToZip(ZipOutputStream zos, File folder, String parentFolderName) {
        for (File file : folder.listFiles()) {
            if (file.isDirectory()) {
                addFolderToZip(zos, file, parentFolderName + "/" + file.getName()); // 递归处理子目录
            } else {
                try (FileInputStream fis = new FileInputStream(file)) { // 读取源文件内容
                    byte[] buffer = new byte[1024];
                    zos.putNextEntry(new ZipEntry(parentFolderName + "/" + file.getName())); // 设置ZIP条目
                    int length;
                    while ((length = fis.read(buffer)) > 0) {
                        zos.write(buffer, 0, length); // 将数据写入ZIP文件
                    }
                    zos.closeEntry(); // 结束当前ZIP条目
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
