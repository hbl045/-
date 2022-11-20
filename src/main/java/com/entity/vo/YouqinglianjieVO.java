package com.entity.vo;

import java.io.Serializable;

/**
 * @author HBL
 * @Description
 * 友情链接
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @date 2022-11-19 11:02
 **/
public class YouqinglianjieVO  implements Serializable {
    private static final long serialVersionUID = 1L;


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