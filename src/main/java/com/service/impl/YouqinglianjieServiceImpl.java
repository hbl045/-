package com.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.YouqinglianjieDao;
import com.entity.YouqinglianjieEntity;
import com.entity.view.YouqinglianjieView;
import com.entity.vo.YouqinglianjieVO;
import com.service.YouqinglianjieService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author HBL
 * @Description
 * @date 2022-11-19 11:08
 **/
@Service("youqinglianjieService")
public class YouqinglianjieServiceImpl extends ServiceImpl<YouqinglianjieDao, YouqinglianjieEntity> implements YouqinglianjieService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YouqinglianjieEntity> page = this.selectPage(
                new Query<YouqinglianjieEntity>(params).getPage(),
                new EntityWrapper<YouqinglianjieEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<YouqinglianjieEntity> wrapper) {
        Page<YouqinglianjieView> page =new Query<YouqinglianjieView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,wrapper));
        PageUtils pageUtil = new PageUtils(page);
        return pageUtil;
    }

    @Override
    public List<YouqinglianjieVO> selectListVO(Wrapper<YouqinglianjieEntity> wrapper) {
        return baseMapper.selectListVO(wrapper);
    }

    @Override
    public YouqinglianjieVO selectVO(Wrapper<YouqinglianjieEntity> wrapper) {
        return baseMapper.selectVO(wrapper);
    }

    @Override
    public List<YouqinglianjieView> selectListView(Wrapper<YouqinglianjieEntity> wrapper) {
        return baseMapper.selectListView(wrapper);
    }

    @Override
    public YouqinglianjieView selectView(Wrapper<YouqinglianjieEntity> wrapper) {
        return baseMapper.selectView(wrapper);
    }

}
