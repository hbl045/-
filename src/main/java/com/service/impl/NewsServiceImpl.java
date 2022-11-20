package com.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.NewsDao;
import com.entity.NewsEntity;
import com.entity.view.NewsView;
import com.entity.vo.NewsVO;
import com.service.NewsService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author HBL
 * @Description
 * @date 2022-11-19 16:00
 **/
@Service("newsService")
public class NewsServiceImpl extends ServiceImpl<NewsDao, NewsEntity> implements NewsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<NewsEntity> page = this.selectPage(
                new Query<NewsEntity>(params).getPage(),
                new EntityWrapper<NewsEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<NewsEntity> wrapper) {
        Page<NewsView> page =new Query<NewsView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,wrapper));
        PageUtils pageUtil = new PageUtils(page);
        return pageUtil;
    }

    @Override
    public List<NewsVO> selectListVO(Wrapper<NewsEntity> wrapper) {
        return baseMapper.selectListVO(wrapper);
    }

    @Override
    public NewsVO selectVO(Wrapper<NewsEntity> wrapper) {
        return baseMapper.selectVO(wrapper);
    }

    @Override
    public List<NewsView> selectListView(Wrapper<NewsEntity> wrapper) {
        return baseMapper.selectListView(wrapper);
    }

    @Override
    public NewsView selectView(Wrapper<NewsEntity> wrapper) {
        return baseMapper.selectView(wrapper);
    }

}
