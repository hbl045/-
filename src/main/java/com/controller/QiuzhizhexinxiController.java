package com.controller;

import com.annotation.IgnoreAuth;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.entity.QiuzhizhexinxiEntity;
import com.entity.view.QiuzhizhexinxiView;
import com.service.QiuzhizhexinxiService;
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
 * @Description 求职者信息
 * 后端接口
 * @date 2022-11-19 16:49
 **/
@RestController
@RequestMapping("/qiuzhizhexinxi")
public class QiuzhizhexinxiController {
    @Autowired
    private QiuzhizhexinxiService qiuzhizhexinxiService;


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, QiuzhizhexinxiEntity qiuzhizhexinxi, HttpServletRequest request){
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("yonghu")) {
            qiuzhizhexinxi.setYonghuming((String)request.getSession().getAttribute("username"));
        }
        EntityWrapper<QiuzhizhexinxiEntity> ew = new EntityWrapper<QiuzhizhexinxiEntity>();
        PageUtils page = qiuzhizhexinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, qiuzhizhexinxi), params), params));

        return R.ok().put("data", page);
    }

    /**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( QiuzhizhexinxiEntity qiuzhizhexinxi){
        EntityWrapper<QiuzhizhexinxiEntity> ew = new EntityWrapper<QiuzhizhexinxiEntity>();
        ew.allEq(MPUtil.allEQMapPre( qiuzhizhexinxi, "qiuzhizhexinxi"));
        return R.ok().put("data", qiuzhizhexinxiService.selectListView(ew));
    }

    /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(QiuzhizhexinxiEntity qiuzhizhexinxi){
        EntityWrapper< QiuzhizhexinxiEntity> ew = new EntityWrapper< QiuzhizhexinxiEntity>();
        ew.allEq(MPUtil.allEQMapPre( qiuzhizhexinxi, "qiuzhizhexinxi"));
        QiuzhizhexinxiView qiuzhizhexinxiView =  qiuzhizhexinxiService.selectView(ew);
        return R.ok("查询求职者信息成功").put("data", qiuzhizhexinxiView);
    }

    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") String id){
        QiuzhizhexinxiEntity qiuzhizhexinxi = qiuzhizhexinxiService.selectById(id);
        return R.ok().put("data", qiuzhizhexinxi);
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody QiuzhizhexinxiEntity qiuzhizhexinxi, HttpServletRequest request){
        qiuzhizhexinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
        //ValidatorUtils.validateEntity(qiuzhizhexinxi);
        qiuzhizhexinxiService.insert(qiuzhizhexinxi);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody QiuzhizhexinxiEntity qiuzhizhexinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(qiuzhizhexinxi);
        qiuzhizhexinxiService.updateById(qiuzhizhexinxi);//全部更新
        return R.ok();
    }


    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        qiuzhizhexinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    /**
     * 前端页接口
     */

    /**
     * 前端列表
     */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,QiuzhizhexinxiEntity qiuzhizhexinxi, HttpServletRequest request){
        EntityWrapper<QiuzhizhexinxiEntity> ew = new EntityWrapper<QiuzhizhexinxiEntity>();
        PageUtils page = qiuzhizhexinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, qiuzhizhexinxi), params), params));
        return R.ok().put("data", page);
    }



    /**
     * 前端详情
     */
    @IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") String id){
        QiuzhizhexinxiEntity qiuzhizhexinxi = qiuzhizhexinxiService.selectById(id);
        return R.ok().put("data", qiuzhizhexinxi);
    }

    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R vote(@PathVariable("id") String id,String type){
        QiuzhizhexinxiEntity qiuzhizhexinxi = qiuzhizhexinxiService.selectById(id);
        if(type.equals("1")) {
            qiuzhizhexinxi.setThumbsupnum(qiuzhizhexinxi.getThumbsupnum()+1);
        } else {
            qiuzhizhexinxi.setCrazilynum(qiuzhizhexinxi.getCrazilynum()+1);
        }
        qiuzhizhexinxiService.updateById(qiuzhizhexinxi);
        return R.ok("投票成功");
    }

    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody QiuzhizhexinxiEntity qiuzhizhexinxi, HttpServletRequest request){
        qiuzhizhexinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
        //ValidatorUtils.validateEntity(qiuzhizhexinxi);
        qiuzhizhexinxiService.insert(qiuzhizhexinxi);
        return R.ok();
    }
}
