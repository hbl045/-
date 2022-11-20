package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.QiuzhizhexinxiEntity;
import com.entity.view.QiuzhizhexinxiView;
import com.entity.vo.QiuzhizhexinxiVO;
import com.utils.PageUtils;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author HBL
 * @Description 求职者信息
 * @date 2022-11-19 16:48
 **/
public interface QiuzhizhexinxiService extends IService<QiuzhizhexinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<QiuzhizhexinxiVO> selectListVO(Wrapper<QiuzhizhexinxiEntity> wrapper);

    QiuzhizhexinxiVO selectVO(@Param("ew") Wrapper<QiuzhizhexinxiEntity> wrapper);

    List<QiuzhizhexinxiView> selectListView(Wrapper<QiuzhizhexinxiEntity> wrapper);

    QiuzhizhexinxiView selectView(@Param("ew") Wrapper<QiuzhizhexinxiEntity> wrapper);

    PageUtils queryPage(Map<String, Object> params,Wrapper<QiuzhizhexinxiEntity> wrapper);
}
