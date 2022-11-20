package com.entity.model;

import java.io.Serializable;

/**
 * @author HBL
 * @Description
 * @date 2022-11-18 14:49
 **/
public class QiyexinxiModel implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 密码
     */
    private String mima;

    /**
     * 企业名称
     */
    private String qiyemingcheng;

    /**
     * 负责人
     */
    private String fuzeren;

    /**
     * 联系电话
     */
    private String lianxidianhua;

    /**
     * 企业邮箱
     */
    private String qiyeyouxiang;

    /**
     * 企业介绍
     */
    private String qiyejieshao;

    /**
     * 获取：密码
     * @return
     */
    public String getMima() {
        return mima;
    }

    /**
     * 设置：密码
     * @param mima
     */
    public void setMima(String mima) {
        this.mima = mima;
    }

    /**
     * 获取：企业名称
     * @return
     */
    public String getQiyemingcheng() {
        return qiyemingcheng;
    }

    /**
     * 设置：企业名称
     * @param qiyemingcheng
     */
    public void setQiyemingcheng(String qiyemingcheng) {
        this.qiyemingcheng = qiyemingcheng;
    }

    /**
     * 获取：负责人
     * @return
     */
    public String getFuzeren() {
        return fuzeren;
    }

    /**
     * 设置：负责人
     * @param fuzeren
     */
    public void setFuzeren(String fuzeren) {
        this.fuzeren = fuzeren;
    }

    /**
     * 获取：联系电话
     * @return
     */
    public String getLianxidianhua() {
        return lianxidianhua;
    }

    /**
     * 设置：联系电话
     * @param lianxidianhua
     */
    public void setLianxidianhua(String lianxidianhua) {
        this.lianxidianhua = lianxidianhua;
    }

    /**
     * 获取：企业邮箱
     * @return
     */
    public String getQiyeyouxiang() {
        return qiyeyouxiang;
    }

    /**
     * 设置：企业邮箱
     * @param qiyeyouxiang
     */
    public void setQiyeyouxiang(String qiyeyouxiang) {
        this.qiyeyouxiang = qiyeyouxiang;
    }

    /**
     * 获取：企业介绍
     * @return
     */
    public String getQiyejieshao() {
        return qiyejieshao;
    }

    /**
     * 设置：企业介绍
     * @param qiyejieshao
     */
    public void setQiyejieshao(String qiyejieshao) {
        this.qiyejieshao = qiyejieshao;
    }
}
