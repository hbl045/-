package com.service.impl;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.QiyexinxiDao;
import com.entity.QiyexinxiEntity;
import com.entity.view.QiyexinxiView;
import com.entity.vo.QiyexinxiVO;
import com.service.QiyexinxiService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author HBL
 * @Description
 * @date 2022-11-18 15:00
 **/
@Service("qiyexinxiService")
public class QiyexinxiServiceImpl extends ServiceImpl<QiyexinxiDao, QiyexinxiEntity>implements QiyexinxiService {

    @Override
    public PageUtils queryPage(Map<String,Object> params){
        Page<QiyexinxiEntity> page = this.selectPage(
                new Query<QiyexinxiEntity>(params).getPage(),
                new EntityWrapper<QiyexinxiEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPage(Map<String,Object>params, Wrapper<QiyexinxiEntity> wrapper){
        Page<QiyexinxiView> page = new Query<QiyexinxiView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,wrapper));
        PageUtils pageUtil = new PageUtils(page);
        return pageUtil;
    }

    @Override
    public List<QiyexinxiVO> selectListVO(Wrapper<QiyexinxiEntity> wrapper) {
        return baseMapper.selectListVO(wrapper);
    }

    @Override
    public QiyexinxiVO selectVO(Wrapper<QiyexinxiEntity> wrapper) {
        return baseMapper.selectVO(wrapper);
    }

    @Override
    public List<QiyexinxiView> selectListView(Wrapper<QiyexinxiEntity> wrapper) {
        return baseMapper.selectListView(wrapper);
    }

    @Override
    public QiyexinxiView selectView(Wrapper<QiyexinxiEntity> wrapper) {
        return baseMapper.selectView(wrapper);
    }
}
