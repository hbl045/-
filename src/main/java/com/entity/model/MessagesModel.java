package com.entity.model;

import java.io.Serializable;

/**
 * @author HBL
 * @Description
 * 留言板
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @date 2022-11-20 15:05
 **/
public class MessagesModel  implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 留言人id
     */

    private Long userid;


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
