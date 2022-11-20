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
 * @date 2022-11-19 9:59
 **/
@TableName("gangweifenlei")
public class GangweifenleiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


    public GangweifenleiEntity() {

    }

    public GangweifenleiEntity(T t) {
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
     * 岗位类别
     */

    private String gangweileibie;


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
}
