package com.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import com.entity.StoreupEntity;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

/**
 * @author HBL
 * @Description
 * 收藏表
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @date 2022-11-19 16:04
 **/
@TableName("storeup")
public class StoreupView  extends StoreupEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    public StoreupView(){
    }

    public StoreupView(StoreupEntity storeupEntity){
        try {
            BeanUtils.copyProperties(this, storeupEntity);
        } catch (IllegalAccessException | InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
