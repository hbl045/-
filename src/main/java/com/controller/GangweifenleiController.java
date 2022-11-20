package com.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.entity.GangweifenleiEntity;
import com.entity.view.GangweifenleiView;
import com.service.GangweifenleiService;
import com.utils.MPUtil;
import com.utils.PageUtils;
import com.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

/**
 * @author HBL
 * @Description
 * @date 2022-11-19 10:27
 **/
@RestController
@RequestMapping("/gangweifenlei")
public class GangweifenleiController {
    @Autowired
    private GangweifenleiService gangweifenleiService;

    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, GangweifenleiEntity gangweifenlei, HttpServletRequest request){
        EntityWrapper<GangweifenleiEntity> ew = new EntityWrapper<GangweifenleiEntity>();
        PageUtils page = gangweifenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gangweifenlei), params), params));

        return R.ok().put("data", page);
    }

    /**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( GangweifenleiEntity gangweifenlei){
        EntityWrapper<GangweifenleiEntity> ew = new EntityWrapper<GangweifenleiEntity>();
        ew.allEq(MPUtil.allEQMapPre( gangweifenlei, "gangweifenlei"));
        return R.ok().put("data", gangweifenleiService.selectListView(ew));
    }

    /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(GangweifenleiEntity gangweifenlei){
        EntityWrapper< GangweifenleiEntity> ew = new EntityWrapper< GangweifenleiEntity>();
        ew.allEq(MPUtil.allEQMapPre( gangweifenlei, "gangweifenlei"));
        GangweifenleiView gangweifenleiView =  gangweifenleiService.selectView(ew);
        return R.ok("查询岗位分类成功").put("data", gangweifenleiView);
    }


    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") String id){
        GangweifenleiEntity gangweifenlei = gangweifenleiService.selectById(id);
        return R.ok().put("data", gangweifenlei);
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody GangweifenleiEntity gangweifenlei, HttpServletRequest request){
        gangweifenlei.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
        //ValidatorUtils.validateEntity(gangweifenlei);
        gangweifenleiService.insert(gangweifenlei);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody GangweifenleiEntity gangweifenlei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(gangweifenlei);
        gangweifenleiService.updateById(gangweifenlei);//全部更新
        return R.ok();
    }


    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        gangweifenleiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
}
