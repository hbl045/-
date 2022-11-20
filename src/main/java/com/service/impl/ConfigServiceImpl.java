package com.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.ConfigDao;
import com.entity.ConfigEntity;
import com.service.ConfigService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author HBL
 * @Description
 * @date 2022-11-19 20:08
 **/
@Service("configService")
public class ConfigServiceImpl extends ServiceImpl<ConfigDao, ConfigEntity> implements ConfigService {
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ConfigEntity> page = this.selectPage(
                new Query<ConfigEntity>(params).getPage(),
                new EntityWrapper<ConfigEntity>()
        );
        return new PageUtils(page);
    }
}