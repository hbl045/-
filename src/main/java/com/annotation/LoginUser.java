package com.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author HBL
 * @Description 登陆用户信息
 * @date 2022-11-10 10:06
 **/
//注解应用于参数中
@Target(ElementType.PARAMETER)
//在运行的时候可以被获取
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginUser {
}
