package com.controller;

import com.annotation.IgnoreAuth;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.entity.ZhaopinxinxiEntity;
import com.entity.view.ZhaopinxinxiView;
import com.service.ZhaopinxinxiService;
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
 * 招聘信息
 * 后端接口
 * @date 2022-11-19 16:17
 **/
@RestController
@RequestMapping("/zhaopinxinxi")
public class ZhaopinxinxiController {
    @Autowired
    private ZhaopinxinxiService zhaopinxinxiService;


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, ZhaopinxinxiEntity zhaopinxinxi, HttpServletRequest request){
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("qiyexinxi")) {
            zhaopinxinxi.setQiyebianhao((String)request.getSession().getAttribute("username"));
        }
        EntityWrapper<ZhaopinxinxiEntity> ew = new EntityWrapper<ZhaopinxinxiEntity>();
        PageUtils page = zhaopinxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhaopinxinxi), params), params));

        return R.ok().put("data", page);
    }


    /**
     * 后端列表 详细
     */
    @RequestMapping("/lists")
    public R list( ZhaopinxinxiEntity zhaopinxinxi){
        EntityWrapper<ZhaopinxinxiEntity> ew = new EntityWrapper<ZhaopinxinxiEntity>();
        ew.allEq(MPUtil.allEQMapPre( zhaopinxinxi, "zhaopinxinxi"));
        return R.ok().put("data", zhaopinxinxiService.selectListView(ew));
    }

    /**
     * 后端列表 查询
     */
    @RequestMapping("/query")
    public R query(ZhaopinxinxiEntity zhaopinxinxi){
        EntityWrapper< ZhaopinxinxiEntity> ew = new EntityWrapper< ZhaopinxinxiEntity>();
        ew.allEq(MPUtil.allEQMapPre( zhaopinxinxi, "zhaopinxinxi"));
        ZhaopinxinxiView zhaopinxinxiView =  zhaopinxinxiService.selectView(ew);
        return R.ok("查询招聘信息成功").put("data", zhaopinxinxiView);
    }

    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") String id){
        ZhaopinxinxiEntity zhaopinxinxi = zhaopinxinxiService.selectById(id);
        return R.ok().put("data", zhaopinxinxi);
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZhaopinxinxiEntity zhaopinxinxi, HttpServletRequest request){
        zhaopinxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
        //ValidatorUtils.validateEntity(zhaopinxinxi);
        zhaopinxinxiService.insert(zhaopinxinxi);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ZhaopinxinxiEntity zhaopinxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zhaopinxinxi);
        zhaopinxinxiService.updateById(zhaopinxinxi);//全部更新
        return R.ok();
    }


    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zhaopinxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 前端列表  前端list
     */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZhaopinxinxiEntity zhaopinxinxi, HttpServletRequest request){
        EntityWrapper<ZhaopinxinxiEntity> ew = new EntityWrapper<ZhaopinxinxiEntity>();
        PageUtils page = zhaopinxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhaopinxinxi), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 前端详情
     */
    @IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") String id){
        ZhaopinxinxiEntity zhaopinxinxi = zhaopinxinxiService.selectById(id);
        return R.ok().put("data", zhaopinxinxi);
    }

    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R vote(@PathVariable("id") String id,String type){
        ZhaopinxinxiEntity zhaopinxinxi = zhaopinxinxiService.selectById(id);
        if(type.equals("1")) {
            zhaopinxinxi.setThumbsupnum(zhaopinxinxi.getThumbsupnum()+1);
        } else {
            zhaopinxinxi.setCrazilynum(zhaopinxinxi.getCrazilynum()+1);
        }
        zhaopinxinxiService.updateById(zhaopinxinxi);
        return R.ok("投票成功");
    }

    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZhaopinxinxiEntity zhaopinxinxi, HttpServletRequest request){
        zhaopinxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
        //ValidatorUtils.validateEntity(zhaopinxinxi);
        zhaopinxinxiService.insert(zhaopinxinxi);
        return R.ok();
    }
}
