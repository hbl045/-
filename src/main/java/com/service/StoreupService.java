package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.StoreupEntity;
import com.entity.view.StoreupView;
import com.entity.vo.StoreupVO;
import com.utils.PageUtils;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author HBL
 * @Description 收藏表
 * @date 2022-11-19 16:07
 **/
public interface StoreupService extends IService<StoreupEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<StoreupVO> selectListVO(Wrapper<StoreupEntity> wrapper);

    StoreupVO selectVO(@Param("ew") Wrapper<StoreupEntity> wrapper);

    List<StoreupView> selectListView(Wrapper<StoreupEntity> wrapper);

    StoreupView selectView(@Param("ew") Wrapper<StoreupEntity> wrapper);

    PageUtils queryPage(Map<String, Object> params,Wrapper<StoreupEntity> wrapper);
}