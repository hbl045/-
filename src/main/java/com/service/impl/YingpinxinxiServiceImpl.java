package com.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.YingpinxinxiDao;
import com.entity.YingpinxinxiEntity;
import com.entity.view.YingpinxinxiView;
import com.entity.vo.YingpinxinxiVO;
import com.service.YingpinxinxiService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author HBL
 * @Description
 * @date 2022-11-19 16:41
 **/
@Service("yingpinxinxiService")
public class YingpinxinxiServiceImpl extends ServiceImpl<YingpinxinxiDao, YingpinxinxiEntity> implements YingpinxinxiService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YingpinxinxiEntity> page = this.selectPage(
                new Query<YingpinxinxiEntity>(params).getPage(),
                new EntityWrapper<YingpinxinxiEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<YingpinxinxiEntity> wrapper) {
        Page<YingpinxinxiView> page =new Query<YingpinxinxiView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,wrapper));
        PageUtils pageUtil = new PageUtils(page);
        return pageUtil;
    }

    @Override
    public List<YingpinxinxiVO> selectListVO(Wrapper<YingpinxinxiEntity> wrapper) {
        return baseMapper.selectListVO(wrapper);
    }

    @Override
    public YingpinxinxiVO selectVO(Wrapper<YingpinxinxiEntity> wrapper) {
        return baseMapper.selectVO(wrapper);
    }

    @Override
    public List<YingpinxinxiView> selectListView(Wrapper<YingpinxinxiEntity> wrapper) {
        return baseMapper.selectListView(wrapper);
    }

    @Override
    public YingpinxinxiView selectView(Wrapper<YingpinxinxiEntity> wrapper) {
        return baseMapper.selectView(wrapper);
    }

}

