package com.tr.springboot.kit;

import com.alibaba.excel.EasyExcel;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Collection;

/**
 * @Author: TR
 * @Date: 2023/4/3
 */
public class EasyExcelKit {

    public static void export(String fileName, String sheetName, Class classType, Collection<?> data, HttpServletResponse response) throws IOException {
        // 设置响应头
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("UTF-8");
        // 设置防止文件名中文乱码
        response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8") + ".xlsx");
        // 构建写入到 Excel 中的数据
        EasyExcel.write(response.getOutputStream(), classType).sheet(sheetName).doWrite(data);
    }

}
