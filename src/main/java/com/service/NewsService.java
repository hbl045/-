package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.NewsEntity;
import com.entity.view.NewsView;
import com.entity.vo.NewsVO;
import com.utils.PageUtils;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author HBL
 * @Description 新闻资讯
 * @date 2022-11-19 15:59
 **/
public interface NewsService extends IService<NewsEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<NewsVO> selectListVO(Wrapper<NewsEntity> wrapper);

    NewsVO selectVO(@Param("ew") Wrapper<NewsEntity> wrapper);

    List<NewsView> selectListView(Wrapper<NewsEntity> wrapper);

    NewsView selectView(@Param("ew") Wrapper<NewsEntity> wrapper);

    PageUtils queryPage(Map<String, Object> params,Wrapper<NewsEntity> wrapper);
}
