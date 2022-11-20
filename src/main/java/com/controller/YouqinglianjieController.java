package com.controller;

import com.annotation.IgnoreAuth;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.entity.YouqinglianjieEntity;
import com.entity.view.YouqinglianjieView;
import com.service.YouqinglianjieService;
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
 * @Description 友情链接 后端接口
 * @date 2022-11-19 11:09
 **/
@RestController
@RequestMapping("/youqinglianjie")
public class YouqinglianjieController {
    @Autowired
    private YouqinglianjieService youqinglianjieService;


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, YouqinglianjieEntity youqinglianjie, HttpServletRequest request){
        EntityWrapper<YouqinglianjieEntity> ew = new EntityWrapper<YouqinglianjieEntity>();
        PageUtils page = youqinglianjieService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, youqinglianjie), params), params));

        return R.ok().put("data", page);
    }

    /**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YouqinglianjieEntity youqinglianjie){
        EntityWrapper<YouqinglianjieEntity> ew = new EntityWrapper<YouqinglianjieEntity>();
        ew.allEq(MPUtil.allEQMapPre( youqinglianjie, "youqinglianjie"));
        return R.ok().put("data", youqinglianjieService.selectListView(ew));
    }

    /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YouqinglianjieEntity youqinglianjie){
        EntityWrapper< YouqinglianjieEntity> ew = new EntityWrapper< YouqinglianjieEntity>();
        ew.allEq(MPUtil.allEQMapPre( youqinglianjie, "youqinglianjie"));
        YouqinglianjieView youqinglianjieView =  youqinglianjieService.selectView(ew);
        return R.ok("查询友情链接成功").put("data", youqinglianjieView);
    }

    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") String id){
        YouqinglianjieEntity youqinglianjie = youqinglianjieService.selectById(id);
        return R.ok().put("data", youqinglianjie);
    }


    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YouqinglianjieEntity youqinglianjie, HttpServletRequest request){
        youqinglianjie.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
        //ValidatorUtils.validateEntity(youqinglianjie);
        youqinglianjieService.insert(youqinglianjie);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody YouqinglianjieEntity youqinglianjie, HttpServletRequest request){
        //ValidatorUtils.validateEntity(youqinglianjie);
        youqinglianjieService.updateById(youqinglianjie);//全部更新
        return R.ok();
    }


    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        youqinglianjieService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    /**
     * 前端页面接口
     */


    /**
     * 前端列表
     */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YouqinglianjieEntity youqinglianjie, HttpServletRequest request){
        EntityWrapper<YouqinglianjieEntity> ew = new EntityWrapper<YouqinglianjieEntity>();
        PageUtils page = youqinglianjieService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, youqinglianjie), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 前端详情
     */
    @IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") String id){
        YouqinglianjieEntity youqinglianjie = youqinglianjieService.selectById(id);
        return R.ok().put("data", youqinglianjie);
    }

    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YouqinglianjieEntity youqinglianjie, HttpServletRequest request){
        youqinglianjie.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
        //ValidatorUtils.validateEntity(youqinglianjie);
        youqinglianjieService.insert(youqinglianjie);
        return R.ok();
    }
}
