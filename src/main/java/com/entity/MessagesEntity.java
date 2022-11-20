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
 * @Description 留言版
 * 数据库通用操作实体类（普通增删改查）
 * @date 2022-11-20 15:03
 **/
@TableName("messages")
public class MessagesEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


    public MessagesEntity() {

    }

    public MessagesEntity(T t) {
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
     * 内容
     */

    private String content;

    /**
     * 留言人id
     */

    private Long userid;


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
    /**
     * 设置：留言人id
     */
    public void setUserid(Long userid) {
        this.userid = userid;
    }
    /**
     * 获取：留言人id
     */
    public Long getUserid() {
        return userid;
    }

}
