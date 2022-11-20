package com.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.ZhaopinxinxiDao;
import com.entity.ZhaopinxinxiEntity;
import com.entity.view.ZhaopinxinxiView;
import com.entity.vo.ZhaopinxinxiVO;
import com.service.ZhaopinxinxiService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author HBL
 * @Description
 * @date 2022-11-19 16:17
 **/
@Service("zhaopinxinxiService")
public class ZhaopinxinxiServiceImpl extends ServiceImpl<ZhaopinxinxiDao, ZhaopinxinxiEntity> implements ZhaopinxinxiService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZhaopinxinxiEntity> page = this.selectPage(
                new Query<ZhaopinxinxiEntity>(params).getPage(),
                new EntityWrapper<ZhaopinxinxiEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<ZhaopinxinxiEntity> wrapper) {
        Page<ZhaopinxinxiView> page =new Query<ZhaopinxinxiView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,wrapper));
        PageUtils pageUtil = new PageUtils(page);
        return pageUtil;
    }

    @Override
    public List<ZhaopinxinxiVO> selectListVO(Wrapper<ZhaopinxinxiEntity> wrapper) {
        return baseMapper.selectListVO(wrapper);
    }

    @Override
    public ZhaopinxinxiVO selectVO(Wrapper<ZhaopinxinxiEntity> wrapper) {
        return baseMapper.selectVO(wrapper);
    }

    @Override
    public List<ZhaopinxinxiView> selectListView(Wrapper<ZhaopinxinxiEntity> wrapper) {
        return baseMapper.selectListView(wrapper);
    }

    @Override
    public ZhaopinxinxiView selectView(Wrapper<ZhaopinxinxiEntity> wrapper) {
        return baseMapper.selectView(wrapper);
    }

}
