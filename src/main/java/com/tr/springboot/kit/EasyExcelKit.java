package com.tr.springboot.kit;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @Author: TR
 * @Date: 2023/4/3
 */
public class EasyExcelKit {

    /**
     * 导出 Excel
     */
    public static void export(String fileName, String sheetName, Class classType, Collection<?> data, HttpServletResponse response) throws IOException {
        // 设置响应头
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        // 设置防止文件名中文乱码
        response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "utf-8") + ".xlsx");
        // 构建写入到 Excel 中的数据
        EasyExcel.write(response.getOutputStream(), classType).sheet(sheetName).doWrite(data);
    }

    /**
     * 从 Excel 读取数据
     */
    public static <T> List<T> readDataListFromExcel(String filePath, Class classType) {
        return EasyExcel.read(filePath, classType, null).sheet().doReadSync();
    }

    /**
     * 从 Excel 读取数据，传入 sheetName
     */
    public static <T> List<T> readDataListFromExcel(String filePath, Class classType, String sheetName) {
        return EasyExcel.read(filePath, classType, null).sheet(sheetName).doReadSync();
    }

    /**
     * 从 Excel 读取数据，传入 sheetNo
     */
    public static <T> List<T> readDataListFromExcel(String filePath, Class classType, Integer sheetNo) {
        return EasyExcel.read(filePath, classType, null).sheet(sheetNo).doReadSync();
    }

    /**
     * 从 Excel 读取数据
     */
    public static <T> List<T> readExcel(String filePath, Class classType) {
        List<T> list = new ArrayList<>();

        EasyExcel.read(filePath, classType, new AnalysisEventListener<T>() {
            @Override
            public void invoke(T t, AnalysisContext context) {
                // 数据解析到 t 中，t 不为 null
                list.add(t);
            }
            @Override
            public void doAfterAllAnalysed(AnalysisContext context) {
                // 数据解析完成
                System.out.println("数据解析完成");
            }
            // 如果需要，可以重写其他方法，如 doAfterBatchAnalysed
        }).sheet().doRead();

        return list;
    }

    /**
     * 从 Excel 读取数据，传入 sheetName
     */
    public static <T> List<T> readExcel(String filePath, Class classType, String sheetName) {
        List<T> list = new ArrayList<>();

        EasyExcel.read(filePath, classType, new AnalysisEventListener<T>() {
            @Override
            public void invoke(T t, AnalysisContext context) {
                // 数据解析到 t 中，t 不为 null
                list.add(t);
            }
            @Override
            public void doAfterAllAnalysed(AnalysisContext context) {
                // 数据解析完成
                System.out.println("数据解析完成");
            }
            // 如果需要，可以重写其他方法，如 doAfterBatchAnalysed
        }).sheet(sheetName).doRead();

        return list;
    }

    /**
     * 从 Excel 读取数据，传入 sheetNo
     */
    public static <T> List<T> readExcel(String filePath, Class classType, Integer sheetNo) {
        List<T> list = new ArrayList<>();

        EasyExcel.read(filePath, classType, new AnalysisEventListener<T>() {
            @Override
            public void invoke(T t, AnalysisContext context) {
                // 数据解析到 t 中，t 不为 null
                list.add(t);
            }
            @Override
            public void doAfterAllAnalysed(AnalysisContext context) {
                // 数据解析完成
                System.out.println("数据解析完成");
            }
            // 如果需要，可以重写其他方法，如 doAfterBatchAnalysed
        }).sheet(sheetNo).doRead();

        return list;
    }

}
