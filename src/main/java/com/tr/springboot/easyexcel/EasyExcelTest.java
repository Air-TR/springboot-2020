package com.tr.springboot.easyexcel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.util.ListUtils;
import com.tr.springboot.easyexcel.entity.ExportData;

import java.util.Date;
import java.util.List;

/**
 * @Author: TR
 * @Date: 2023/4/4
 */
public class EasyExcelTest {

    public static void main(String[] args) {
        String fileName = "TestExport_" + System.currentTimeMillis() + ".xlsx";
        EasyExcel.write(fileName, ExportData.class).sheet("导出数据").doWrite(data());
    }

    private static List<ExportData> data() {
        List<ExportData> list = ListUtils.newArrayList();
        for (int i = 0; i < 10; i++) {
            ExportData data = new ExportData();
            data.setTitle("字符串" + i);
            data.setDate(new Date());
            data.setNum(Math.random());
            list.add(data);
        }
        return list;
    }

}
