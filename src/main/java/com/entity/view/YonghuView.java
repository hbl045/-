package com.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import com.entity.YonghuEntity;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

/**
 * @author HBL
 * @Description 用户
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @date 2022-11-17 22:38
 **/
@TableName("yonghu")
public class YonghuView  extends YonghuEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    public YonghuView(){
    }

    public YonghuView(YonghuEntity yonghuEntity){
        try {
            BeanUtils.copyProperties(this, yonghuEntity);
        } catch (IllegalAccessException | InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
