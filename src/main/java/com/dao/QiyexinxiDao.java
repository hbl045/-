package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.QiyexinxiEntity;
import com.entity.view.QiyexinxiView;
import com.entity.vo.QiyexinxiVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author HBL
 * @Description
 * @date 2022-11-18 15:09
 **/
public interface QiyexinxiDao extends BaseMapper<QiyexinxiEntity> {

    List<QiyexinxiVO> selectListVO(@Param("ew") Wrapper<QiyexinxiEntity> wrapper);

    QiyexinxiVO selectVO(@Param("ew") Wrapper<QiyexinxiEntity> wrapper);

    List<QiyexinxiView> selectListView(@Param("ew") Wrapper<QiyexinxiEntity> wrapper);

    List<QiyexinxiView> selectListView(Pagination page, @Param("ew") Wrapper<QiyexinxiEntity> wrapper);

    QiyexinxiView selectView(@Param("ew") Wrapper<QiyexinxiEntity> wrapper);
}
