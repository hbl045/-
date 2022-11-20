package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.GangweifenleiEntity;
import com.entity.view.GangweifenleiView;
import com.entity.vo.GangweifenleiVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author HBL
 * @Description 岗位分类Dao层
 * @date 2022-11-19 10:24
 **/
public interface GangweifenleiDao extends BaseMapper<GangweifenleiEntity> {

    List<GangweifenleiVO> selectListVO(@Param("ew") Wrapper<GangweifenleiEntity> wrapper);

    GangweifenleiVO selectVO(@Param("ew") Wrapper<GangweifenleiEntity> wrapper);

    List<GangweifenleiView> selectListView(@Param("ew") Wrapper<GangweifenleiEntity> wrapper);

    List<GangweifenleiView> selectListView(Pagination page, @Param("ew") Wrapper<GangweifenleiEntity> wrapper);

    GangweifenleiView selectView(@Param("ew") Wrapper<GangweifenleiEntity> wrapper);
}
