package com.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.entity.StoreupEntity;
import com.entity.view.StoreupView;
import com.service.StoreupService;
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
 * 收藏表
 * 后端接口
 * @date 2022-11-19 16:08
 **/
@RestController
@RequestMapping("/storeup")
public class StoreupController {
    @Autowired
    private StoreupService storeupService;


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, StoreupEntity storeup, HttpServletRequest request){
        if(!request.getSession().getAttribute("role").toString().equals("管理员")) {
            storeup.setUserid((Long)request.getSession().getAttribute("userId"));
        }
        EntityWrapper<StoreupEntity> ew = new EntityWrapper<StoreupEntity>();
        PageUtils page = storeupService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, storeup), params), params));

        return R.ok().put("data", page);
    }

    /**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( StoreupEntity storeup){
        EntityWrapper<StoreupEntity> ew = new EntityWrapper<StoreupEntity>();
        ew.allEq(MPUtil.allEQMapPre( storeup, "storeup"));
        return R.ok().put("data", storeupService.selectListView(ew));
    }

    /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(StoreupEntity storeup){
        EntityWrapper< StoreupEntity> ew = new EntityWrapper< StoreupEntity>();
        ew.allEq(MPUtil.allEQMapPre( storeup, "storeup"));
        StoreupView storeupView =  storeupService.selectView(ew);
        return R.ok("查询收藏表成功").put("data", storeupView);
    }

    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        StoreupEntity storeup = storeupService.selectById(id);
        return R.ok().put("data", storeup);
    }


    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody StoreupEntity storeup, HttpServletRequest request){
        storeup.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
        //ValidatorUtils.validateEntity(storeup);
        storeup.setUserid((Long)request.getSession().getAttribute("userId"));
        storeupService.insert(storeup);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody StoreupEntity storeup, HttpServletRequest request){
        //ValidatorUtils.validateEntity(storeup);
        storeupService.updateById(storeup);//全部更新
        return R.ok();
    }


    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        storeupService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    /**
     * 前端接口
     */

    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,StoreupEntity storeup, HttpServletRequest request){
        if(!request.getSession().getAttribute("role").toString().equals("管理员")) {
            storeup.setUserid((Long)request.getSession().getAttribute("userId"));
        }
        EntityWrapper<StoreupEntity> ew = new EntityWrapper<StoreupEntity>();
        PageUtils page = storeupService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, storeup), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        StoreupEntity storeup = storeupService.selectById(id);
        return R.ok().put("data", storeup);
    }

    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody StoreupEntity storeup, HttpServletRequest request){
        storeup.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
        //ValidatorUtils.validateEntity(storeup);
        storeup.setUserid((Long)request.getSession().getAttribute("userId"));
        storeupService.insert(storeup);
        return R.ok();
    }

}
