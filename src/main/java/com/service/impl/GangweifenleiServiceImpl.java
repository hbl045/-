package com.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.GangweifenleiDao;
import com.entity.GangweifenleiEntity;
import com.entity.view.GangweifenleiView;
import com.entity.vo.GangweifenleiVO;
import com.service.GangweifenleiService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author HBL
 * @Description  岗位分类列表的Service层
 * @date 2022-11-19 10:07
 **/
@Service("gangweifenleiService")
public class GangweifenleiServiceImpl extends ServiceImpl<GangweifenleiDao, GangweifenleiEntity> implements GangweifenleiService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GangweifenleiEntity> page = this.selectPage(
                new Query<GangweifenleiEntity>(params).getPage(),
                new EntityWrapper<GangweifenleiEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<GangweifenleiEntity> wrapper) {
        Page<GangweifenleiView> page =new Query<GangweifenleiView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,wrapper));
        PageUtils pageUtil = new PageUtils(page);
        return pageUtil;
    }

    @Override
    public List<GangweifenleiVO> selectListVO(Wrapper<GangweifenleiEntity> wrapper) {
        return baseMapper.selectListVO(wrapper);
    }

    @Override
    public GangweifenleiVO selectVO(Wrapper<GangweifenleiEntity> wrapper) {
        return baseMapper.selectVO(wrapper);
    }

    @Override
    public List<GangweifenleiView> selectListView(Wrapper<GangweifenleiEntity> wrapper) {
        return baseMapper.selectListView(wrapper);
    }

    @Override
    public GangweifenleiView selectView(Wrapper<GangweifenleiEntity> wrapper) {
        return baseMapper.selectView(wrapper);
    }

}
