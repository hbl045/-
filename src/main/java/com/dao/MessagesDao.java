package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.MessagesEntity;
import com.entity.view.MessagesView;
import com.entity.vo.MessagesVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author HBL
 * @Description 留言版 Dao
 * @date 2022-11-20 15:06
 **/
public interface MessagesDao extends BaseMapper<MessagesEntity> {

    List<MessagesVO> selectListVO(@Param("ew") Wrapper<MessagesEntity> wrapper);

    MessagesVO selectVO(@Param("ew") Wrapper<MessagesEntity> wrapper);

    List<MessagesView> selectListView(@Param("ew") Wrapper<MessagesEntity> wrapper);

    List<MessagesView> selectListView(Pagination page, @Param("ew") Wrapper<MessagesEntity> wrapper);

    MessagesView selectView(@Param("ew") Wrapper<MessagesEntity> wrapper);
}
