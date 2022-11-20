package com.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.entity.XuelixinxiEntity;
import com.entity.view.XuelixinxiView;
import com.service.XuelixinxiService;
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
 * @Description 学历信息列表后端接口
 * @date 2022-11-19 10:56
 **/
@RestController
@RequestMapping("/xuelixinxi")
public class XuelixinxiController {
    @Autowired
    private XuelixinxiService xuelixinxiService;


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, XuelixinxiEntity xuelixinxi, HttpServletRequest request){
        EntityWrapper<XuelixinxiEntity> ew = new EntityWrapper<XuelixinxiEntity>();
        PageUtils page = xuelixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xuelixinxi), params), params));

        return R.ok().put("data", page);
    }

    /**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XuelixinxiEntity xuelixinxi){
        EntityWrapper<XuelixinxiEntity> ew = new EntityWrapper<XuelixinxiEntity>();
        ew.allEq(MPUtil.allEQMapPre( xuelixinxi, "xuelixinxi"));
        return R.ok().put("data", xuelixinxiService.selectListView(ew));
    }

    /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XuelixinxiEntity xuelixinxi){
        EntityWrapper< XuelixinxiEntity> ew = new EntityWrapper< XuelixinxiEntity>();
        ew.allEq(MPUtil.allEQMapPre( xuelixinxi, "xuelixinxi"));
        XuelixinxiView xuelixinxiView =  xuelixinxiService.selectView(ew);
        return R.ok("查询学历信息成功").put("data", xuelixinxiView);
    }

    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") String id){
        XuelixinxiEntity xuelixinxi = xuelixinxiService.selectById(id);
        return R.ok().put("data", xuelixinxi);
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XuelixinxiEntity xuelixinxi, HttpServletRequest request){
        xuelixinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
        //ValidatorUtils.validateEntity(xuelixinxi);
        xuelixinxiService.insert(xuelixinxi);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody XuelixinxiEntity xuelixinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xuelixinxi);
        xuelixinxiService.updateById(xuelixinxi);//全部更新
        return R.ok();
    }


    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        xuelixinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
}
