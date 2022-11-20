package com.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import com.entity.QiyexinxiEntity;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

/**
 * @author HBL
 * @Description
 * @date 2022-11-18 14:46
 **/
@TableName("qiyexinxi")
public class QiyexinxiView extends QiyexinxiEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    public QiyexinxiView(){
    }

    public QiyexinxiView(QiyexinxiEntity qiyexinxiEntity){
        try{
            BeanUtils.copyProperties(this,qiyexinxiEntity);
        }catch(IllegalAccessException | InvocationTargetException e){
            //TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
