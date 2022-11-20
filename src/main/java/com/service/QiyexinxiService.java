package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.QiyexinxiEntity;
import com.entity.view.QiyexinxiView;
import com.entity.vo.QiyexinxiVO;
import com.utils.PageUtils;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author HBL
 * @Description
 * @date 2022-11-18 14:55
 **/
public interface QiyexinxiService extends IService<QiyexinxiEntity> {

    PageUtils queryPage(Map<String,Object> params);

    List<QiyexinxiVO> selectListVO(Wrapper<QiyexinxiEntity> wrapper);

    QiyexinxiVO selectVO(@Param("ew")Wrapper<QiyexinxiEntity> wrapper);

    List<QiyexinxiView>selectListView(Wrapper<QiyexinxiEntity>wrapper);

    QiyexinxiView selectView(@Param("ew")Wrapper<QiyexinxiEntity> wrappper);

    PageUtils queryPage(Map<String,Object>params,Wrapper<QiyexinxiEntity>wrapper);
}
