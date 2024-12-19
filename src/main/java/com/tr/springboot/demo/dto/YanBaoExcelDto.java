package com.tr.springboot.demo.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @Author taorun
 * @Date 2024/12/6
 */
@Data
public class YanBaoExcelDto {

    @ExcelProperty(value ="sys_sn")
    private String SERIAL_NUMBERS = "";
    @ExcelProperty(value ="标准质保开始日期")
    private Date STD_START_DAT;
    @ExcelProperty(value ="延保开始日期")
    private Date EXT_START_DAT;
    @ExcelProperty(value ="延保结束日期")
    private Date EXT_END_DAT;
    @ExcelProperty(value ="物料号")
    private String MATNR = "";
    @ExcelProperty(value ="供应商")
    private String LIFNR = "";

    @ExcelProperty(value ="含税单价")
    private String NETPR = "";
    @ExcelProperty(value ="货币码")
    private String WAERS = "";

}
