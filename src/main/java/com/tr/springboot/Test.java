package com.tr.springboot;

import java.util.HashSet;
import java.util.Set;

/**
 * 通用测试类
 *
 * @author TR
 * @version 1.0
 * @date 8/17/2020 4:53 PM
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {
//        byte a = 1;
//        byte b = 2;
//        a += b;

        Set<String> set = new HashSet<>();
        set.add("AAA");
        set.add("BBB");
        set.add("CCC");
        System.out.println(set.iterator().next());

//        String s = "";
//        System.out.println(s);

//        Set<String> assessmentSet = new HashSet<>();
//        assessmentSet.add("P1");
//        assessmentSet.add("P2");
//        assessmentSet.add("P3");
//        StringBuilder allAssessment = new StringBuilder();
//        assessmentSet.forEach(assessment -> allAssessment.append(assessment).append(','));
//        System.out.println(allAssessment);
//        String objectName = allAssessment.substring(0, allAssessment.length() - 1);
//        System.out.println(objectName);


//        int a = 1;
//        int b = 2;
//        int c = 3;
//        int d = 1;
//        System.out.println(a == b || a == c);

//        String s1 = "通话";
//        String s2 = "重地";
//        System.out.println(s1.hashCode());
//        System.out.println(s2.hashCode());
    }

}
