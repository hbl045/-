package com.controller;

import com.annotation.IgnoreAuth;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.entity.NewsEntity;
import com.entity.view.NewsView;
import com.service.NewsService;
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
 * 新闻资讯
 * 后端接口
 * @date 2022-11-19 16:00
 **/
@RestController
@RequestMapping("/news")
public class NewsController {
    @Autowired
    private NewsService newsService;


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, NewsEntity news, HttpServletRequest request){
        EntityWrapper<NewsEntity> ew = new EntityWrapper<NewsEntity>();
        PageUtils page = newsService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, news), params), params));

        return R.ok().put("data", page);
    }

    /**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( NewsEntity news){
        EntityWrapper<NewsEntity> ew = new EntityWrapper<NewsEntity>();
        ew.allEq(MPUtil.allEQMapPre( news, "news"));
        return R.ok().put("data", newsService.selectListView(ew));
    }

    /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(NewsEntity news){
        EntityWrapper< NewsEntity> ew = new EntityWrapper< NewsEntity>();
        ew.allEq(MPUtil.allEQMapPre( news, "news"));
        NewsView newsView =  newsService.selectView(ew);
        return R.ok("查询新闻资讯成功").put("data", newsView);
    }

    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") String id){
        NewsEntity news = newsService.selectById(id);
        return R.ok().put("data", news);
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody NewsEntity news, HttpServletRequest request){
        news.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
        //ValidatorUtils.validateEntity(news);
        newsService.insert(news);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody NewsEntity news, HttpServletRequest request){
        //ValidatorUtils.validateEntity(news);
        newsService.updateById(news);//全部更新
        return R.ok();
    }


    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        newsService.deleteBatchIds(Arrays.asList(ids));
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
    public R list(@RequestParam Map<String, Object> params,NewsEntity news, HttpServletRequest request){
        EntityWrapper<NewsEntity> ew = new EntityWrapper<NewsEntity>();
        PageUtils page = newsService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, news), params), params));
        return R.ok().put("data", page);
    }


    /**
     * 前端详情
     */
    @IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") String id){
        NewsEntity news = newsService.selectById(id);
        return R.ok().put("data", news);
    }

    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody NewsEntity news, HttpServletRequest request){
        news.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
        //ValidatorUtils.validateEntity(news);
        newsService.insert(news);
        return R.ok();
    }
}
