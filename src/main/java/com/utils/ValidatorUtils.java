package com.utils;

import com.entity.EIException;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

/**
 * @author HBL
 * @Description hibernate-validator校验工具类
 * @date 2022-11-20 10:44
 **/
public class ValidatorUtils {
    private static Validator validator;

    static {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    /**
     * 校验对象
     * @param object        待校验对象
     * @param groups        待校验的组
     * @throws EIException  校验不通过，则报EIException异常
     */
    public static void validateEntity(Object object, Class<?>... groups)
            throws EIException {
        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(object, groups);
        if (!constraintViolations.isEmpty()) {
            ConstraintViolation<Object> constraint = (ConstraintViolation<Object>)constraintViolations.iterator().next();
            throw new EIException(constraint.getMessage());
        }
    }


}