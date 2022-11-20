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
 * @Description  用户实体类，数据库通用操作实体类（普通增删改查）
 * @date 2022-11-17 21:30
 **/
@TableName("yonghu")
public class YonghuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    public YonghuEntity(){

    }

    public YonghuEntity(T t){
        try{
            BeanUtils.copyProperties(this, t);
        }catch (IllegalAccessException | InvocationTargetException e){
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * 主键id
     */
    @TableId
    private Long id;

    /**
     * 用户名
     */
    private String yonghuming;

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

    @JsonFormat(locale="zh",timezone="GMT+8",pattern="yyyy-MM-dd HH:mm:ss")
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
     * 获取：用户名
     * @return
     */
    public String getYonghuming() {
        return yonghuming;
    }

    /**
     * 设置：用户名
     * @param yonghuming
     */
    public void setYonghuming(String yonghuming) {
        this.yonghuming = yonghuming;
    }

    /**
     * 获取：姓名
     * @return
     */
    public String getXingming() {
        return xingming;
    }

    /**
     * 设置：姓名
     * @param xingming
     */
    public void setXingming(String xingming) {
        this.xingming = xingming;
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
     * 获取：性别
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
