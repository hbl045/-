package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.ZhaopinxinxiEntity;
import com.entity.view.ZhaopinxinxiView;
import com.entity.vo.ZhaopinxinxiVO;
import com.utils.PageUtils;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author HBL
 * @Description 招聘信息
 * @date 2022-11-19 16:16
 **/
public interface ZhaopinxinxiService extends IService<ZhaopinxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<ZhaopinxinxiVO> selectListVO(Wrapper<ZhaopinxinxiEntity> wrapper);

    ZhaopinxinxiVO selectVO(@Param("ew") Wrapper<ZhaopinxinxiEntity> wrapper);

    List<ZhaopinxinxiView> selectListView(Wrapper<ZhaopinxinxiEntity> wrapper);

    ZhaopinxinxiView selectView(@Param("ew") Wrapper<ZhaopinxinxiEntity> wrapper);

    PageUtils queryPage(Map<String, Object> params,Wrapper<ZhaopinxinxiEntity> wrapper);
}