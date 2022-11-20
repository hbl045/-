package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.ZhaopinxinxiEntity;
import com.entity.view.ZhaopinxinxiView;
import com.entity.vo.ZhaopinxinxiVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author HBL
 * @Description 招聘信息
 * @date 2022-11-19 16:14
 **/
public interface ZhaopinxinxiDao extends BaseMapper<ZhaopinxinxiEntity> {

    List<ZhaopinxinxiVO> selectListVO(@Param("ew") Wrapper<ZhaopinxinxiEntity> wrapper);

    ZhaopinxinxiVO selectVO(@Param("ew") Wrapper<ZhaopinxinxiEntity> wrapper);

    List<ZhaopinxinxiView> selectListView(@Param("ew") Wrapper<ZhaopinxinxiEntity> wrapper);

    List<ZhaopinxinxiView> selectListView(Pagination page, @Param("ew") Wrapper<ZhaopinxinxiEntity> wrapper);

    ZhaopinxinxiView selectView(@Param("ew") Wrapper<ZhaopinxinxiEntity> wrapper);
}
