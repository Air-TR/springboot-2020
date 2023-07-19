package com.tr.springboot;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * 用 Java 代码，生成 Java 类，并编译执行，返回结果
 *
 * @Author: TR
 * @Date: 2023/7/19
 */
public class JavaCodeExecutor {

    private static String className = "Test20230719001";

    public static void main(String[] args) {
        StringBuilder javaCode = new StringBuilder()
                .append("import java.util.ArrayList;")
                .append("import java.util.List;")
                .append("public class ").append(className).append(" {")
                .append("    public static void main(String[] args) {")
                .append("        List list = new ArrayList();")
                .append("        list.add(1);")
                .append("        list.add(\"a\");")
                .append("        System.out.println(list.get(0));")
                .append("        System.out.println(list.get(1));")
                .append("   }")
                .append("}");
        compileAndRunJavaCode(javaCode.toString());
    }

    public static String compileAndRunJavaCode(String javaCode) {
        StringBuilder output = new StringBuilder();
        try {
            // 使用 Java 代码创建一个临时文件
            String fileName = className + ".java";
            ProcessBuilder processBuilder = new ProcessBuilder("javac", fileName);
            processBuilder.redirectErrorStream(true);
            Process compileProcess = processBuilder.start();
            // 将 Java 代码写入临时文件
            writeToFile(javaCode.toString(), fileName);
            // 等待编译过程完成
            int compileExitCode = compileProcess.waitFor();
            String line;
            if (compileExitCode == 0) {
                // 编译成功，运行编译代码，打印运行信息
                Process runProcess = Runtime.getRuntime().exec("java " + className);
                BufferedReader reader = new BufferedReader(new InputStreamReader(runProcess.getInputStream(), "GBK"));
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                    output.append(line).append("\n");
                }
                BufferedReader errorReader = new BufferedReader(new InputStreamReader(runProcess.getErrorStream(), "GBK"));
                while ((line = errorReader.readLine()) != null) {
                    System.out.println(line);
                    output.append(line).append("\n");
                }
            } else {
                // 编译失败，打印错误信息
                BufferedReader reader = new BufferedReader(new InputStreamReader(compileProcess.getInputStream(), "GBK"));
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                    output.append(line).append("\n");
                }
                BufferedReader errorReader = new BufferedReader(new InputStreamReader(compileProcess.getErrorStream(), "GBK"));
                while ((line = errorReader.readLine()) != null) {
                    System.out.println(line);
                    output.append(line).append("\n");
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 删除创建的文件
            try {
                Files.deleteIfExists(Paths.get(className + ".java"));
                Files.deleteIfExists(Paths.get(className + ".class"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        // 返回执行结果
        return output.toString();
    }

    public static void writeToFile(String content, String fileName) throws IOException {
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write(content);
        }
    }

}
