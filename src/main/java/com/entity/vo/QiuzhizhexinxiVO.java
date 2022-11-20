package com.entity.vo;

import java.io.Serializable;

/**
 * @author HBL
 * @Description
 * 求职者信息
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @date 2022-11-19 16:45
 **/
public class QiuzhizhexinxiVO  implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 姓名
     */

    private String xingming;

    /**
     * 性别
     */

    private String xingbie;

    /**
     * 电话
     */

    private String dianhua;

    /**
     * 照片
     */

    private String zhaopian;

    /**
     * 学历
     */

    private String xueli;

    /**
     * 岗位类别
     */

    private String gangweileibie;

    /**
     * 简历
     */

    private String jianli;

    /**
     * 工作经历
     */

    private String gongzuojingli;

    /**
     * 个人基本情况
     */

    private String gerenjibenqingkuang;

    /**
     * 赞
     */

    private Integer thumbsupnum;

    /**
     * 踩
     */

    private Integer crazilynum;


    /**
     * 设置：姓名
     */

    public void setXingming(String xingming) {
        this.xingming = xingming;
    }

    /**
     * 获取：姓名
     */
    public String getXingming() {
        return xingming;
    }


    /**
     * 设置：性别
     */

    public void setXingbie(String xingbie) {
        this.xingbie = xingbie;
    }

    /**
     * 获取：性别
     */
    public String getXingbie() {
        return xingbie;
    }


    /**
     * 设置：电话
     */

    public void setDianhua(String dianhua) {
        this.dianhua = dianhua;
    }

    /**
     * 获取：电话
     */
    public String getDianhua() {
        return dianhua;
    }


    /**
     * 设置：照片
     */

    public void setZhaopian(String zhaopian) {
        this.zhaopian = zhaopian;
    }

    /**
     * 获取：照片
     */
    public String getZhaopian() {
        return zhaopian;
    }


    /**
     * 设置：学历
     */

    public void setXueli(String xueli) {
        this.xueli = xueli;
    }

    /**
     * 获取：学历
     */
    public String getXueli() {
        return xueli;
    }


    /**
     * 设置：岗位类别
     */

    public void setGangweileibie(String gangweileibie) {
        this.gangweileibie = gangweileibie;
    }

    /**
     * 获取：岗位类别
     */
    public String getGangweileibie() {
        return gangweileibie;
    }


    /**
     * 设置：简历
     */

    public void setJianli(String jianli) {
        this.jianli = jianli;
    }

    /**
     * 获取：简历
     */
    public String getJianli() {
        return jianli;
    }


    /**
     * 设置：工作经历
     */

    public void setGongzuojingli(String gongzuojingli) {
        this.gongzuojingli = gongzuojingli;
    }

    /**
     * 获取：工作经历
     */
    public String getGongzuojingli() {
        return gongzuojingli;
    }


    /**
     * 设置：个人基本情况
     */

    public void setGerenjibenqingkuang(String gerenjibenqingkuang) {
        this.gerenjibenqingkuang = gerenjibenqingkuang;
    }

    /**
     * 获取：个人基本情况
     */
    public String getGerenjibenqingkuang() {
        return gerenjibenqingkuang;
    }


    /**
     * 设置：赞
     */

    public void setThumbsupnum(Integer thumbsupnum) {
        this.thumbsupnum = thumbsupnum;
    }

    /**
     * 获取：赞
     */
    public Integer getThumbsupnum() {
        return thumbsupnum;
    }


    /**
     * 设置：踩
     */

    public void setCrazilynum(Integer crazilynum) {
        this.crazilynum = crazilynum;
    }

    /**
     * 获取：踩
     */
    public Integer getCrazilynum() {
        return crazilynum;
    }

}

