package com.tr.springboot.kit;


import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Author: TR
 * @Date: 2023/3/9
 */
public class ValidationKit {

    private static final Validator validator;

    static {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    /**
     * 校验对象参数是否合法
     *
     * @param object
     * @param groups
     * @throws IllegalArgumentException
     */
    public static void validateEntity(Object object, Class<?>... groups) throws IllegalArgumentException {
        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(object, groups);
        if (!constraintViolations.isEmpty()) {
            String msg = constraintViolations.stream().map(ConstraintViolation::getMessage).collect(Collectors.joining(" && "));
            throw new IllegalArgumentException(msg);
        }
    }

}
