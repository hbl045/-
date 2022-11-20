package com.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import com.entity.ZhaopinxinxiEntity;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

/**
 * @author HBL
 * @Description
 * 招聘信息
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @date 2022-11-19 16:12
 **/
@TableName("zhaopinxinxi")
public class ZhaopinxinxiView  extends ZhaopinxinxiEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    public ZhaopinxinxiView(){
    }

    public ZhaopinxinxiView(ZhaopinxinxiEntity zhaopinxinxiEntity){
        try {
            BeanUtils.copyProperties(this, zhaopinxinxiEntity);
        } catch (IllegalAccessException | InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}

