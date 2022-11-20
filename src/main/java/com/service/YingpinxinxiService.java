package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.YingpinxinxiEntity;
import com.entity.view.YingpinxinxiView;
import com.entity.vo.YingpinxinxiVO;
import com.utils.PageUtils;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author HBL
 * @Description 应聘信息
 * @date 2022-11-19 16:41
 **/
public interface YingpinxinxiService extends IService<YingpinxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<YingpinxinxiVO> selectListVO(Wrapper<YingpinxinxiEntity> wrapper);

    YingpinxinxiVO selectVO(@Param("ew") Wrapper<YingpinxinxiEntity> wrapper);

    List<YingpinxinxiView> selectListView(Wrapper<YingpinxinxiEntity> wrapper);

    YingpinxinxiView selectView(@Param("ew") Wrapper<YingpinxinxiEntity> wrapper);

    PageUtils queryPage(Map<String, Object> params,Wrapper<YingpinxinxiEntity> wrapper);
}


