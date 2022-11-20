package com.service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.TokenEntity;
import com.utils.PageUtils;



/**
 * @author HBL
 * @Description  针对表【token】的数据库操作
 * @date 2022-11-10 10:42
 **/
public interface TokenService extends IService<TokenEntity> {
    PageUtils queryPage(Map<String, Object> params);

    List<TokenEntity> selectListView(Wrapper<TokenEntity> wrapper);

    PageUtils queryPage(Map<String,Object>params,Wrapper<TokenEntity> wrapper);

    String generateToken(Long userid,String username,String tableName,String role);

    TokenEntity getTokenEntity(String token);
}
