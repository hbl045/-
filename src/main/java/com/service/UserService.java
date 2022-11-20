package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.UserEntity;
import com.utils.PageUtils;

import java.util.List;
import java.util.Map;

/**
 * @author HBL
 * @Description  系统用户（管理员实体）
 * @date 2022-11-10 19:34
 **/
public interface UserService extends IService<UserEntity> {
    PageUtils queryPage(Map<String, Object> params);

    List<UserEntity> selectListView(Wrapper<UserEntity> wrapper);

    PageUtils queryPage(Map<String, Object>params,Wrapper<UserEntity> wrapper);
}
