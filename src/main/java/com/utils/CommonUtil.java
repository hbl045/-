package com.utils;

import java.util.Random;

/**
 * @author HBL
 * @Description
 * @date 2022-11-10 15:32
 **/
public class CommonUtil {

    /**
     * 随机字符串
     * @param num
     * @return
     */
    public static String getRandomString(Integer num){
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<num;i++){
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return  sb.toString();
    }
}
