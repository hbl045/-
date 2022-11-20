package com.annotation;

import java.lang.annotation.*;

/**
 * @author HBL
 * @Description 忽略Token验证
 * @date 2022-11-10 10:02
 **/

//应用于方法
@Target(ElementType.METHOD)
//表示该注解，在运行时可以被获取到
@Retention(RetentionPolicy.RUNTIME)
//表示该注解标记的元素可以被Javadoc或类似的工具文档化
@Documented
public @interface IgnoreAuth {
}
