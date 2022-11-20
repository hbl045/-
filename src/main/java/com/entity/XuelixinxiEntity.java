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
 * @Description
 * 学历信息
 * 数据库通用操作实体类（普通增删改查）
 * @date 2022-11-19 10:49
 **/
@TableName("xuelixinxi")
public class XuelixinxiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


    public XuelixinxiEntity() {

    }

    public XuelixinxiEntity(T t) {
        try {
            BeanUtils.copyProperties(this, t);
        } catch (IllegalAccessException | InvocationTargetException e) {
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
     * 学历
     */

    private String xueli;


    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
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

}

