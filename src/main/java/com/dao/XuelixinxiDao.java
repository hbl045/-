package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.XuelixinxiEntity;
import com.entity.view.XuelixinxiView;
import com.entity.vo.XuelixinxiVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author HBL
 * @Description 学历信息Dao层
 * @date 2022-11-19 10:54
 **/
public interface XuelixinxiDao extends BaseMapper<XuelixinxiEntity> {

    List<XuelixinxiVO> selectListVO(@Param("ew") Wrapper<XuelixinxiEntity> wrapper);

    XuelixinxiVO selectVO(@Param("ew") Wrapper<XuelixinxiEntity> wrapper);

    List<XuelixinxiView> selectListView(@Param("ew") Wrapper<XuelixinxiEntity> wrapper);

    List<XuelixinxiView> selectListView(Pagination page, @Param("ew") Wrapper<XuelixinxiEntity> wrapper);

    XuelixinxiView selectView(@Param("ew") Wrapper<XuelixinxiEntity> wrapper);
}
