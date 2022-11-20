package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.QiuzhizhexinxiEntity;
import com.entity.view.QiuzhizhexinxiView;
import com.entity.vo.QiuzhizhexinxiVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author HBL
 * @Description 求职者信息
 * @date 2022-11-19 16:47
 **/
public interface QiuzhizhexinxiDao extends BaseMapper<QiuzhizhexinxiEntity> {

    List<QiuzhizhexinxiVO> selectListVO(@Param("ew") Wrapper<QiuzhizhexinxiEntity> wrapper);

    QiuzhizhexinxiVO selectVO(@Param("ew") Wrapper<QiuzhizhexinxiEntity> wrapper);

    List<QiuzhizhexinxiView> selectListView(@Param("ew") Wrapper<QiuzhizhexinxiEntity> wrapper);

    List<QiuzhizhexinxiView> selectListView(Pagination page, @Param("ew") Wrapper<QiuzhizhexinxiEntity> wrapper);

    QiuzhizhexinxiView selectView(@Param("ew") Wrapper<QiuzhizhexinxiEntity> wrapper);
}
