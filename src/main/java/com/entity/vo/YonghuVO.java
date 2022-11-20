package com.entity.vo;

import java.io.Serializable;

/**
 * @author HBL
 * @Description 用户
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @date 2022-11-17 22:29
 **/
public class YonghuVO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 姓名
     */
    private String xingming;

    /**
     * 密码
     */
    private String mima;

    /**
     * 性别
     */
    private String xingbie;

    /**
     * 电话
     */
    private String dianhua;

    /**
     * 邮箱
     */
    private String youxiang;


    /**
     * 获取姓名
     * @return
     */
    public String getXingming() {
        return xingming;
    }

    /**
     * 设置姓名
     * @param xingming
     */
    public void setXingming(String xingming) {
        this.xingming = xingming;
    }

    /**
     * 获取密码
     * @return
     */
    public String getMima() {
        return mima;
    }

    /**
     * 设置密码
     * @param mima
     */
    public void setMima(String mima) {
        this.mima = mima;
    }

    /**
     * 获取性别
     * @return
     */
    public String getXingbie() {
        return xingbie;
    }

    /**
     * 设置性别
     * @param xingbie
     */
    public void setXingbie(String xingbie) {
        this.xingbie = xingbie;
    }

    /**
     * 获取电话
     * @return
     */
    public String getDianhua() {
        return dianhua;
    }

    /**
     * 设置电话
     * @param dianhua
     */
    public void setDianhua(String dianhua) {
        this.dianhua = dianhua;
    }

    /**
     * 获取邮箱
     * @return
     */
    public String getYouxiang() {
        return youxiang;
    }

    /**
     * 设置邮箱
     * @param youxiang
     */
    public void setYouxiang(String youxiang) {
        this.youxiang = youxiang;
    }
}
