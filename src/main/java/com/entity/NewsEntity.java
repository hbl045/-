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
 * 新闻资讯 管理系统
 * 数据库通用操作实体类（普通增删改查）
 * @date 2022-11-19 15:54
 **/
@TableName("news")
public class NewsEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


    public NewsEntity() {

    }

    public NewsEntity(T t) {
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
     * 标题
     */

    private String title;

    /**
     * 图片
     */

    private String picture;

    /**
     * 内容
     */

    private String content;


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
     * 设置：标题
     */
    public void setTitle(String title) {
        this.title = title;
    }
    /**
     * 获取：标题
     */
    public String getTitle() {
        return title;
    }
    /**
     * 设置：图片
     */
    public void setPicture(String picture) {
        this.picture = picture;
    }
    /**
     * 获取：图片
     */
    public String getPicture() {
        return picture;
    }
    /**
     * 设置：内容
     */
    public void setContent(String content) {
        this.content = content;
    }
    /**
     * 获取：内容
     */
    public String getContent() {
        return content;
    }

}