package com.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.entity.YingpinxinxiEntity;
import com.entity.view.YingpinxinxiView;
import com.service.YingpinxinxiService;
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
 * @Description 应聘信息
 * 后端接口
 * @date 2022-11-19 16:42
 **/
@RestController
@RequestMapping("/yingpinxinxi")
public class YingpinxinxiController {
    @Autowired
    private YingpinxinxiService yingpinxinxiService;


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, YingpinxinxiEntity yingpinxinxi, HttpServletRequest request){
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("qiyexinxi")) {
            yingpinxinxi.setQiyebianhao((String)request.getSession().getAttribute("username"));
        }
        if(tableName.equals("yonghu")) {
            yingpinxinxi.setYonghuming((String)request.getSession().getAttribute("username"));
        }
        EntityWrapper<YingpinxinxiEntity> ew = new EntityWrapper<YingpinxinxiEntity>();
        PageUtils page = yingpinxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yingpinxinxi), params), params));

        return R.ok().put("data", page);
    }


    /**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YingpinxinxiEntity yingpinxinxi){
        EntityWrapper<YingpinxinxiEntity> ew = new EntityWrapper<YingpinxinxiEntity>();
        ew.allEq(MPUtil.allEQMapPre( yingpinxinxi, "yingpinxinxi"));
        return R.ok().put("data", yingpinxinxiService.selectListView(ew));
    }

    /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YingpinxinxiEntity yingpinxinxi){
        EntityWrapper< YingpinxinxiEntity> ew = new EntityWrapper< YingpinxinxiEntity>();
        ew.allEq(MPUtil.allEQMapPre( yingpinxinxi, "yingpinxinxi"));
        YingpinxinxiView yingpinxinxiView =  yingpinxinxiService.selectView(ew);
        return R.ok("查询应聘信息成功").put("data", yingpinxinxiView);
    }

    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") String id){
        YingpinxinxiEntity yingpinxinxi = yingpinxinxiService.selectById(id);
        return R.ok().put("data", yingpinxinxi);
    }


    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YingpinxinxiEntity yingpinxinxi, HttpServletRequest request){
        yingpinxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
        //ValidatorUtils.validateEntity(yingpinxinxi);
        yingpinxinxiService.insert(yingpinxinxi);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody YingpinxinxiEntity yingpinxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yingpinxinxi);
        yingpinxinxiService.updateById(yingpinxinxi);//全部更新
        return R.ok();
    }


    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yingpinxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
}
