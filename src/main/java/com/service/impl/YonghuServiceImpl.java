package com.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.YonghuDao;
import com.entity.YonghuEntity;
import com.entity.view.YonghuView;
import com.entity.vo.YonghuVO;
import com.service.YonghuService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author HBL
 * @Description  用户service层的实现类
 * @date 2022-11-18 9:43
 **/
@Service("yonghuService")
public class YonghuServiceImpl extends ServiceImpl<YonghuDao, YonghuEntity> implements YonghuService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YonghuEntity> page = this.selectPage(
                new Query<YonghuEntity>(params).getPage(),
                new EntityWrapper<YonghuEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPage(Map<String,Object>params, Wrapper<YonghuEntity>wrapper){
        Page<YonghuView> page = new Query<YonghuView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,wrapper));
        PageUtils pageUtil = new PageUtils(page);
        return pageUtil;
    }

    @Override
    public List<YonghuVO> selectListVO(Wrapper<YonghuEntity> wrapper) {
        return baseMapper.selectListVO(wrapper);
    }

    @Override
    public YonghuVO selectVO(Wrapper<YonghuEntity> wrapper) {
        return baseMapper.selectVO(wrapper);
    }

    @Override
    public List<YonghuView> selectListView(Wrapper<YonghuEntity> wrapper) {
        return baseMapper.selectListView(wrapper);
    }

    @Override
    public YonghuView selectView(Wrapper<YonghuEntity> wrapper) {
        return baseMapper.selectView(wrapper);
    }
}
