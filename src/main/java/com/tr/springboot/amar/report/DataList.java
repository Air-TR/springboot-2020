package com.tr.springboot.amar.report;

import java.util.List;
import java.util.Map;

/**
 * @author rtao
 * @date 2021/3/5 11:39
 */
public class DataList {

    private String latitude;

    private List<Map> mapList;

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public List<Map> getMapList() {
        return mapList;
    }

    public void setMapList(List<Map> mapList) {
        this.mapList = mapList;
    }
}
