package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.GangweifenleiEntity;
import com.entity.view.GangweifenleiView;
import com.entity.vo.GangweifenleiVO;
import com.utils.PageUtils;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author HBL
 * @Description
 * @date 2022-11-19 10:06
 **/
public interface GangweifenleiService extends IService<GangweifenleiEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<GangweifenleiVO> selectListVO(Wrapper<GangweifenleiEntity> wrapper);

    GangweifenleiVO selectVO(@Param("ew") Wrapper<GangweifenleiEntity> wrapper);

    List<GangweifenleiView> selectListView(Wrapper<GangweifenleiEntity> wrapper);

    GangweifenleiView selectView(@Param("ew") Wrapper<GangweifenleiEntity> wrapper);

    PageUtils queryPage(Map<String, Object> params,Wrapper<GangweifenleiEntity> wrapper);
}
