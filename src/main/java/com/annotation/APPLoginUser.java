package com.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author HBL
 * @Description
 * @date 2022-11-10 9:58
 **/
//目标对象应用于方法的形参
@Target(ElementType.PARAMETER)
//运行周期在，在运行时候可以被获取
@Retention(RetentionPolicy.RUNTIME)
public @interface APPLoginUser {
}
