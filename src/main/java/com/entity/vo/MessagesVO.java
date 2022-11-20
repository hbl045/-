package com.entity.vo;

import java.io.Serializable;

/**
 * @author HBL
 * @Description
 * 留言板
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @date 2022-11-20 15:04
 **/
public class MessagesVO  implements Serializable {
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
