package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.YonghuEntity;
import com.entity.view.YonghuView;
import com.entity.vo.YonghuVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author HBL
 * @Description 用户Dao层
 * @date 2022-11-18 9:51
 **/
public interface YonghuDao extends BaseMapper<YonghuEntity> {

    List<YonghuVO> selectListVO(@Param("ew")Wrapper<YonghuEntity> wrapper);

    YonghuVO selectVO(@Param("ew")Wrapper<YonghuEntity> wrapper);

    List<YonghuView> selectListView(@Param("ew")Wrapper<YonghuEntity> wrapper);

    List<YonghuView> selectListView(Pagination page,@Param("ew") Wrapper<YonghuEntity> wrapper);

    YonghuView selectView(@Param("ew")Wrapper<YonghuEntity> wrapper);


}
