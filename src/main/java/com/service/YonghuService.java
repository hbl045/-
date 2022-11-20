package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.entity.YonghuEntity;
import com.entity.view.YonghuView;
import com.entity.vo.YonghuVO;
import com.utils.PageUtils;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.Wrapper;
import java.util.List;
import java.util.Map;

/**
 * @author HBL
 * @Description  用户对象 service层
 * @date 2022-11-17 21:29
 **/
public interface YonghuService extends IService<YonghuEntity> {

    PageUtils queryPage(Map<String,Object> param);

    List<YonghuVO> selectListVO(Wrapper<YonghuEntity> wrapper);

    YonghuVO selectVO(@Param("ew")Wrapper<YonghuEntity> wrapper);

    List<YonghuView> selectListView(Wrapper<YonghuEntity> wrapper);

    YonghuView selectView(@Param("ew")Wrapper<YonghuEntity> wrapper);

    PageUtils queryPage(Map<String,Object>params,Wrapper<YonghuEntity>wrapper);
}
