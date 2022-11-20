package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.YingpinxinxiEntity;
import com.entity.view.YingpinxinxiView;
import com.entity.vo.YingpinxinxiVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author HBL
 * @Description 应聘信息
 * @date 2022-11-19 16:39
 **/
public interface YingpinxinxiDao extends BaseMapper<YingpinxinxiEntity> {

    List<YingpinxinxiVO> selectListVO(@Param("ew") Wrapper<YingpinxinxiEntity> wrapper);

    YingpinxinxiVO selectVO(@Param("ew") Wrapper<YingpinxinxiEntity> wrapper);

    List<YingpinxinxiView> selectListView(@Param("ew") Wrapper<YingpinxinxiEntity> wrapper);

    List<YingpinxinxiView> selectListView(Pagination page, @Param("ew") Wrapper<YingpinxinxiEntity> wrapper);

    YingpinxinxiView selectView(@Param("ew") Wrapper<YingpinxinxiEntity> wrapper);
}
