package com.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import com.entity.GangweifenleiEntity;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

/**
 * @author HBL
 * @Description
 * 岗位分类
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @date 2022-11-19 10:03
 **/
@TableName("gangweifenlei")
public class GangweifenleiView extends GangweifenleiEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    public GangweifenleiView(){
    }

    public GangweifenleiView(GangweifenleiEntity gangweifenleiEntity){
        try {
            BeanUtils.copyProperties(this, gangweifenleiEntity);
        } catch (IllegalAccessException | InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
