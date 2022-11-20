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
 * @Description 友情连接 数据库通用操作实体类（普通增删改查）
 * @date 2022-11-19 11:01
 **/
@TableName("youqinglianjie")
public class YouqinglianjieEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


    public YouqinglianjieEntity() {

    }

    public YouqinglianjieEntity(T t) {
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
     * 网站名称
     */

    private String wangzhanmingcheng;

    /**
     * logo
     */

    private String logo;

    /**
     * 网址
     */

    private String wangzhi;

    /**
     * 网站介绍
     */

    private String wangzhanjieshao;


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
     * 设置：网站名称
     */
    public void setWangzhanmingcheng(String wangzhanmingcheng) {
        this.wangzhanmingcheng = wangzhanmingcheng;
    }
    /**
     * 获取：网站名称
     */
    public String getWangzhanmingcheng() {
        return wangzhanmingcheng;
    }
    /**
     * 设置：logo
     */
    public void setLogo(String logo) {
        this.logo = logo;
    }
    /**
     * 获取：logo
     */
    public String getLogo() {
        return logo;
    }
    /**
     * 设置：网址
     */
    public void setWangzhi(String wangzhi) {
        this.wangzhi = wangzhi;
    }
    /**
     * 获取：网址
     */
    public String getWangzhi() {
        return wangzhi;
    }
    /**
     * 设置：网站介绍
     */
    public void setWangzhanjieshao(String wangzhanjieshao) {
        this.wangzhanjieshao = wangzhanjieshao;
    }
    /**
     * 获取：网站介绍
     */
    public String getWangzhanjieshao() {
        return wangzhanjieshao;
    }

}
