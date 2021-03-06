package com.tr.springboot.report;

import java.util.List;
import java.util.Map;

/**
 * @author rtao
 * @date 2021/3/5 11:39
 */
public class DataList {

    private String latitude;

    private String level;

    private List<Map> mapList;

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public List<Map> getMapList() {
        return mapList;
    }

    public void setMapList(List<Map> mapList) {
        this.mapList = mapList;
    }
}
