package com.tr.springboot.kit;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author taorun
 * @date 2023/1/12
 */
public class BeanKit extends BeanUtils {

    /**
     * copyProperties 忽略值为 null 的字段
     */
    public static void copyPropertiesIgnoreNull(Object source, Object target) {
        copyProperties(source, target, getNullPropertyNames(source));
    }

    /**
     * 针对列表操作
     */
    public static <T, K> List<K> copyPropertiesIgnoreNull(List<T> sourceList, Class<K> targetClass) {
        List<K> targetList = null;
        try {
            targetList = new ArrayList<>();
            for (T source : sourceList) {
                K target = targetClass.newInstance();
                copyPropertiesIgnoreNull(source, target);
                targetList.add(target);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return targetList;
    }

    /**
     * 返回实体的所有非 null 字段
     */
    public static String[] getNullPropertyNames (Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        PropertyDescriptor[] pds = src.getPropertyDescriptors();
        Set<String> emptyNames = new HashSet<>();
        for(PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }

}
