package com.utils;


import com.entity.EIException;
import org.apache.commons.lang3.StringUtils;

import java.util.Locale;

/**
 * @author HBL
 * @Description SQL过滤
 * @date 2022-11-10 12:24
 **/
public class SQLFilter {

    /**
     * SQL注入过滤
     * @param str  待验证的字符串
     * @return
     */
    public  static String sqlInject(String str){
        if(StringUtils.isBlank(str)){
            return null;
        }

        //去掉' 单引号 " 双引号 ; 分号 \斜杠
        str = StringUtils.replace(str,"'","");
        str = StringUtils.replace(str,"\"","");
        str = StringUtils.replace(str,";","");
        str = StringUtils.replace(str,"\\","");

        //转换成小写
        str = str.toLowerCase();

        //非法字符
        String[] keywords = {"master","truncate","insert","select","delete","update","declare","alter","drop"};

        //判断是否包含非法字符
        for(String keyword : keywords){
            if(str.indexOf(keyword) != -1){
                throw new EIException("包含非法字符");
            }
        }

        return str;
    }
}
