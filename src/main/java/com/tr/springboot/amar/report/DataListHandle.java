package com.tr.springboot.amar.report;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author rtao
 * @date 2021/3/4 11:46
 */
public class DataListHandle {

    // 关联关系：
    private final static String FIRST_LEVEL_MAIN_KEY = "custId";
    private final static String SECOND_LEVEL_MAIN_KEY = "projectId";
    private final static String SECOND_LEVEL_INNER_KEY = "crdtId";

    public static void main(String[] args) {
        List<DataList> dataLists = new ArrayList<>();
        DataList custDataList = createCustDataList();
        DataList projectDataList = createProjectDataList();
        DataList businessDataList = createBusinessDataList();
        dataLists.add(custDataList);
        dataLists.add(projectDataList);
        dataLists.add(businessDataList);
//        dataLists.forEach(dataList -> {
//            System.out.println(dataList.getLatitude() + ", " + dataList.getMapList());
//        });
        long startTime = System.currentTimeMillis();
        List<Map> resultList = handleListMap(dataLists);
        long endTime = System.currentTimeMillis();
//        System.out.println("输出集：");
//        if (resultList != null) {
//            resultList.forEach(map -> System.out.println(map.toString()));
//        }
        System.out.println("执行时间：" + (endTime - startTime) + " ms");
    }

    static List<Map> handleListMap(List<DataList> dataLists) {

        // 筛选所有维度交集的客户id
        List<List<String>> custIdLists = new ArrayList<>();
        for (int i = 0; i < dataLists.size(); i++) {
            List<String> custIdList = new ArrayList<>();
            dataLists.get(i).getMapList().forEach(map -> {
                custIdList.add(map.get("custId").toString());
            });
            custIdLists.add(custIdList);
        }
        List<String> retainList = retainList(custIdLists);
        System.out.println("所有维度交集客户id：");
        System.out.println(retainList);

        // 根据所有维度交集的客户id，清洗结果集
        List<DataList> washDataList = new ArrayList<>();
        if (retainList != null && !retainList.isEmpty()) {
            for (int i = 0; i < dataLists.size(); i++) {
                DataList dataList = new DataList();
                dataList.setLatitude(dataLists.get(i).getLatitude());
                List<Map> mapList = new ArrayList<>();
                dataLists.get(i).getMapList().forEach(map -> {
                    retainList.forEach(custId -> {
                        if (custId.equals(map.get("custId"))) {
                            mapList.add(map);
                            return;
                        }
                    });
                });
                dataList.setMapList(mapList);
                washDataList.add(dataList);
            }
            System.out.println("清洗结果集：");
            washDataList.forEach(list -> {
                list.getMapList().forEach(System.out::println);
                System.out.println("-----------");
            });
        }

        // 对清洗结果集，再把各维度按照层级划分不同的集合
        List<DataList> firstLevelList = new ArrayList<>();
        List<DataList> secondLevelList = new ArrayList<>();
        List<DataList> thirdLevelList = new ArrayList<>();
        washDataList.forEach(dataList -> {
            switch(dataList.getLatitude()){
                case "cust" :
                    firstLevelList.add(dataList);
                    break; //可选
                case "project" :
                case "crdt" :
                    secondLevelList.add(dataList);
                    break; //可选
                default : //可选
                    thirdLevelList.add(dataList);
            }
        });

        System.out.println("第一层级：");
        firstLevelList.forEach(dataList -> {
            System.out.println(dataList.getLatitude() + ", " + dataList.getMapList());
        });
        System.out.println("第二层级：");
        secondLevelList.forEach(dataList -> {
            System.out.println(dataList.getLatitude() + ", " + dataList.getMapList());
        });
        System.out.println("第三层级：");
        thirdLevelList.forEach(dataList -> {
            System.out.println(dataList.getLatitude() + ", " + dataList.getMapList());
        });

        /**
         * 一二级数据合并(暂不考虑不存在情况)
         *     后期考虑剔除已合并的数据，减少遍历次数
         */
        List<Map> firAndSecMapList = new ArrayList<>();
        firstLevelList.get(0).getMapList().forEach(firMapData -> {
            // 假设第二级仅存在一个维度(这里即第二级只有项目维度)
            secondLevelList.get(0).getMapList().forEach(secMapData -> {
                if (secMapData.get(FIRST_LEVEL_MAIN_KEY).equals(firMapData.get(FIRST_LEVEL_MAIN_KEY))) {
                    HashMap<String, Object> map = new HashMap<>();
                    map.putAll(firMapData);
                    map.putAll(secMapData);
                    firAndSecMapList.add(map);
                }
            });
        });
        System.out.println("一二级别合并结果：");
        firAndSecMapList.forEach(System.out::println);

        /**
         * 一二级合并后的数据与第三级合并
         */
        List<Map> allLevelList = new ArrayList<>();
        firAndSecMapList.forEach(firAndSecMap -> {
            thirdLevelList.get(0).getMapList().forEach(thirdMapData -> {
                if (thirdMapData.get(SECOND_LEVEL_MAIN_KEY).equals(firAndSecMap.get(SECOND_LEVEL_MAIN_KEY))) {
                    HashMap<String, Object> map = new HashMap<>();
                    map.putAll(firAndSecMap);
                    map.putAll(thirdMapData);
                    allLevelList.add(map);
                }
            });
        });
        System.out.println("所有级别合并结果：");
        allLevelList.forEach(System.out::println);

        return allLevelList;
    }

    public static List<String> retainList(List<List<String>> elementLists) {
        Optional<List<String>> result = elementLists.parallelStream()
                .filter(elementList -> elementList != null && ((List) elementList).size() != 0)
                .reduce((a, b) -> {
                    a.retainAll(b);
                    return a;
                });
        return result.orElse(new ArrayList<>());
    }

    static DataList createCustDataList() {
        List<Map> custList = new ArrayList<>();

        HashMap<String, Object> map1 = new HashMap<>();
        map1.put("custId", "001");
        map1.put("name","Cust001");
        map1.put("age",21);
        map1.put("height",171);

        HashMap<String, Object> map2 = new HashMap<>();
        map2.put("custId", "002");
        map2.put("name","Cust002");
        map2.put("age",22);
        map2.put("height",172);

        HashMap<String, Object> map3 = new HashMap<>();
        map3.put("custId", "003");
        map3.put("name","Cust003");
        map3.put("age",23);
        map3.put("height",173);

        HashMap<String, Object> map4 = new HashMap<>();
        map4.put("custId", "004");
        map4.put("name","Cust004");
        map4.put("age",24);
        map4.put("height",174);

        HashMap<String, Object> map5 = new HashMap<>();
        map5.put("custId", "005");
        map5.put("name","Cust005");
        map5.put("age",25);
        map5.put("height",175);

        custList.add(map1);
        custList.add(map2);
        custList.add(map3);
        custList.add(map4);
        custList.add(map5);

        DataList dataList = new DataList();
        dataList.setLatitude("cust");
//        dataList.setLevel(FIRST_LEVEL);
        dataList.setMapList(custList);

        return dataList;
    }

    static DataList createProjectDataList() {
        List<Map> projectList = new ArrayList<>();

        HashMap<String, Object> map1 = new HashMap<>();
        map1.put("projectId", "001");
        map1.put("projectName", "ProjectA");
        map1.put("total", 12000);
        map1.put("address", "上海");
        map1.put("custId", "001");

        HashMap<String, Object> map2 = new HashMap<>();
        map2.put("projectId", "002");
        map2.put("projectName", "ProjectB");
        map2.put("total", 10000);
        map2.put("address", "苏州");
        map2.put("custId", "002");

        HashMap<String, Object> map3 = new HashMap<>();
        map3.put("projectId", "003");
        map3.put("projectName", "ProjectC");
        map3.put("total", 18000);
        map3.put("address", "北京");
        map3.put("custId", "008");

        HashMap<String, Object> map4 = new HashMap<>();
        map4.put("projectId", "004");
        map4.put("projectName", "ProjectD");
        map4.put("total", 20000);
        map4.put("address", "杭州");
        map4.put("custId", "005");

        HashMap<String, Object> map5 = new HashMap<>();
        map5.put("projectId", "005");
        map5.put("projectName", "ProjectE");
        map5.put("total", 15000);
        map5.put("address", "深圳");
        map5.put("custId", "009");

        HashMap<String, Object> map6 = new HashMap<>();
        map6.put("projectId", "006");
        map6.put("projectName", "ProjectF");
        map6.put("total", 21000);
        map6.put("address", "厦门");
        map6.put("custId", "001");

        projectList.add(map1);
        projectList.add(map2);
        projectList.add(map3);
        projectList.add(map4);
        projectList.add(map5);
        projectList.add(map6);

        DataList dataList = new DataList();
        dataList.setLatitude("project");
//        dataList.setLevel(SECOND_LEVEL);
        dataList.setMapList(projectList);

        return dataList;
    }

    static DataList createBusinessDataList() {
        List<Map> businessList = new ArrayList<>();

        HashMap<String, Object> map1 = new HashMap<>();
        map1.put("businessId", "001");
        map1.put("businessName", "石油");
        map1.put("custId", "008");
        map1.put("projectId", "003");

        HashMap<String, Object> map2 = new HashMap<>();
        map2.put("businessId", "002");
        map2.put("businessName", "科技");
        map2.put("custId", "001");
        map2.put("projectId", "006");

        HashMap<String, Object> map3 = new HashMap<>();
        map3.put("businessId", "003");
        map3.put("businessName", "医药");
        map3.put("custId", "003");

        HashMap<String, Object> map4 = new HashMap<>();
        map4.put("businessId", "004");
        map4.put("businessName", "金融");
        map4.put("custId", "005");
        map4.put("projectId", "004");

        HashMap<String, Object> map5 = new HashMap<>();
        map5.put("businessId", "005");
        map5.put("businessName", "航天");
        map5.put("custId", "005");
        map5.put("projectId", "001");

        businessList.add(map1);
        businessList.add(map2);
        businessList.add(map3);
        businessList.add(map4);
        businessList.add(map5);

        DataList dataList = new DataList();
        dataList.setLatitude("business");
//        dataList.setLevel(THIRD_LEVEL);
        dataList.setMapList(businessList);

        return dataList;
    }

}
