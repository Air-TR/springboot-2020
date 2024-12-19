package com.tr.springboot.demo;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tr.springboot.demo.dto.YanBaoExcelDto;
import com.tr.springboot.kit.DateKit;
import com.tr.springboot.kit.EasyExcelKit;

import java.util.Arrays;
import java.util.List;

/**
 * @Author taorun
 * @Date 2024/12/6
 */
public class EasyExcelDemo {

    public static void main(String[] args) {
        List<YanBaoExcelDto> yanBaoList = EasyExcelKit.readDataListFromExcel("/YB664.xlsx", YanBaoExcelDto.class);
        JSONArray jsonArray = new JSONArray();
        yanBaoList.forEach(e -> {
            e.setEXT_END_DAT(DateKit.addYears(e.getEXT_START_DAT(), 10));
            JSONObject json = new JSONObject();
            json.put("SERIAL_NUMBERS", Arrays.asList(e.getSERIAL_NUMBERS()));
            json.put("STD_START_DAT", DateKit.format(e.getSTD_START_DAT(), DateKit.N_DATE_FORMAT));
            json.put("EXT_START_DAT", DateKit.format(e.getEXT_START_DAT(), DateKit.N_DATE_FORMAT));
            json.put("EXT_END_DAT", DateKit.format(e.getEXT_END_DAT(), DateKit.N_DATE_FORMAT));
            json.put("MATNR", e.getMATNR());
            json.put("LIFNR", e.getLIFNR());
            json.put("NETPR", e.getNETPR());
            json.put("WAERS", e.getWAERS());
            jsonArray.add(json);
        });
        String jsonString = jsonArray.toJSONString();
        System.out.println(jsonString);
    }

}
