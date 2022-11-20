package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

/**
 * @author HBL
 * @Description token表
 * @date 2022-11-10 10:15
 **/

//mybatis-plus 指定数据库和JavaBean进行映射
@TableName("token")
public class TokenEntity implements Serializable {
    //设置序列化id
    private static final long serialVersionUID = 1L;

    //主键确定
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 用户id
     */
    private Long userid;

    /**
     * 用户名
     */
    private String username;

    /**
     * 表名
     */
    private String tablename;

    /**
     * 角色
     */
    private String role;

    /**
     * token
     */
    private String token;

    /**
     * 过期时间
     */
    private Date expiratedtime;

    /**
     * 添加时间
     */
    private Date addtime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTablename() {
        return tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getExpiratedtime() {
        return expiratedtime;
    }

    public void setExpiratedtime(Date expiratedtime) {
        this.expiratedtime = expiratedtime;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public TokenEntity(Long userid, String username, String tablename, String role, String token, Date expiratedtime) {
        super();
        this.userid = userid;
        this.username = username;
        this.tablename = tablename;
        this.role = role;
        this.token = token;
        this.expiratedtime = expiratedtime;
    }

    public TokenEntity() {
    }
}
