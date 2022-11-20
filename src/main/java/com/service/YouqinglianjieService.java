package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.YouqinglianjieEntity;
import com.entity.view.YouqinglianjieView;
import com.entity.vo.YouqinglianjieVO;
import com.utils.PageUtils;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author HBL
 * @Description 友情链接Service层
 * @date 2022-11-19 11:07
 **/
public interface YouqinglianjieService extends IService<YouqinglianjieEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<YouqinglianjieVO> selectListVO(Wrapper<YouqinglianjieEntity> wrapper);

    YouqinglianjieVO selectVO(@Param("ew") Wrapper<YouqinglianjieEntity> wrapper);

    List<YouqinglianjieView> selectListView(Wrapper<YouqinglianjieEntity> wrapper);

    YouqinglianjieView selectView(@Param("ew") Wrapper<YouqinglianjieEntity> wrapper);

    PageUtils queryPage(Map<String, Object> params,Wrapper<YouqinglianjieEntity> wrapper);
}
