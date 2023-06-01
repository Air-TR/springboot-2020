package com.tr.springboot.easyexcel.entity;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @Author: TR
 * @Date: 2023/4/4
 *
 * EasyExcel 样式注解大全：https://blog.csdn.net/qq_48922459/article/details/124032490
 */
@Getter
@Setter
@EqualsAndHashCode
public class ExportData {
    @ExcelProperty("标题")
    private String title;
    @ExcelProperty("日期")
    private Date date;
    @ExcelProperty("数字")
    private Double num;
    @ExcelIgnore // 忽略这个字段
    private String ignore;
}
