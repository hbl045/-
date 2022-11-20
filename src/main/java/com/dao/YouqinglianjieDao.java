package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.YouqinglianjieEntity;
import com.entity.view.YouqinglianjieView;
import com.entity.vo.YouqinglianjieVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author HBL
 * @Description  友情链接
 * @date 2022-11-19 11:05
 **/
public interface YouqinglianjieDao extends BaseMapper<YouqinglianjieEntity> {

    List<YouqinglianjieVO> selectListVO(@Param("ew") Wrapper<YouqinglianjieEntity> wrapper);

    YouqinglianjieVO selectVO(@Param("ew") Wrapper<YouqinglianjieEntity> wrapper);

    List<YouqinglianjieView> selectListView(@Param("ew") Wrapper<YouqinglianjieEntity> wrapper);

    List<YouqinglianjieView> selectListView(Pagination page, @Param("ew") Wrapper<YouqinglianjieEntity> wrapper);

    YouqinglianjieView selectView(@Param("ew") Wrapper<YouqinglianjieEntity> wrapper);
}
