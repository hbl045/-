package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.entity.ConfigEntity;
import com.utils.PageUtils;

import java.util.Map;

/**
 * @author HBL
 * @Description
 * @date 2022-11-19 20:07
 **/
public interface ConfigService extends IService<ConfigEntity> {
    PageUtils queryPage(Map<String, Object> params);
}
