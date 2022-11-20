package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.XuelixinxiEntity;
import com.entity.view.XuelixinxiView;
import com.entity.vo.XuelixinxiVO;
import com.utils.PageUtils;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author HBL
 * @Description 学历信息 Service层
 * @date 2022-11-19 10:52
 **/
public interface XuelixinxiService extends IService<XuelixinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<XuelixinxiVO> selectListVO(Wrapper<XuelixinxiEntity> wrapper);

    XuelixinxiVO selectVO(@Param("ew") Wrapper<XuelixinxiEntity> wrapper);

    List<XuelixinxiView> selectListView(Wrapper<XuelixinxiEntity> wrapper);

    XuelixinxiView selectView(@Param("ew") Wrapper<XuelixinxiEntity> wrapper);

    PageUtils queryPage(Map<String, Object> params,Wrapper<XuelixinxiEntity> wrapper);
}
