package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

/**
 * @author HBL
 * @Description  企业信息
 * 数据库通用操作实体类（普通增删改查）
 * @date 2022-11-18 11:22
 **/
@TableName("qiyexinxi")
public class QiyexinxiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    public QiyexinxiEntity(){

    }

    public QiyexinxiEntity(T t) {
        try {
            BeanUtils.copyProperties(this, t);
        } catch (IllegalAccessException | InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     *  主键 id
     */
    @TableId
    private Long id;

    /**
     * 企业编号
     */
    private String qiyebianhao;

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


    @JsonFormat(locale="zh",timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat
    private Date addtime;

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 设置：企业编号
     * @return
     */
    public String getQiyebianhao() {
        return qiyebianhao;
    }

    /**
     * 获取：企业编号
     * @param qiyebianhao
     */
    public void setQiyebianhao(String qiyebianhao) {
        this.qiyebianhao = qiyebianhao;
    }

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
     * 获取：联系方式
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
