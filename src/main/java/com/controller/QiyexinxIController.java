package com.controller;

import com.annotation.IgnoreAuth;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.entity.QiyexinxiEntity;
import com.entity.view.QiyexinxiView;
import com.service.QiyexinxiService;
import com.service.TokenService;
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
 * @Description 企业信息用户
 * @date 2022-11-18 11:20
 **/
@RestController
@RequestMapping("/qiyexinxi")
public class QiyexinxIController {
    @Autowired
    private QiyexinxiService qiyexinxiService;

    @Autowired
    private TokenService tokenService;

    /**
     * 企业账号登录
     */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        QiyexinxiEntity user = qiyexinxiService.selectOne(new EntityWrapper<QiyexinxiEntity>().eq("qiyebianhao", username));
        if(user==null || !user.getMima().equals(password)) {
            return R.error("账号或密码不正确");
        }
        String token = tokenService.generateToken(user.getId(),username, "qiyexinxi", "企业信息");
        return R.ok().put("token", token);
    }

    /**
     * 注册企业账号
     */
    @IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody QiyexinxiEntity qiyexinxi){
        //ValidatorUtils.validateEntity(qiyexinxi);
        QiyexinxiEntity user = qiyexinxiService.selectOne(new EntityWrapper<QiyexinxiEntity>().eq("qiyebianhao", qiyexinxi.getQiyebianhao()));
        if(user!=null) {
            return R.error("注册用户已存在");
        }
        qiyexinxi.setId(new Date().getTime());
        qiyexinxiService.insert(qiyexinxi);
        return R.ok();
    }

    /**
     * 退出
     */
    @RequestMapping("/logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }

    /**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
        Long id = (Long)request.getSession().getAttribute("userId");
        QiyexinxiEntity user = qiyexinxiService.selectById(id);
        return R.ok().put("data", user);
    }

    /**
     * 密码重置
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
        QiyexinxiEntity user = qiyexinxiService.selectOne(new EntityWrapper<QiyexinxiEntity>().eq("qiyebianhao", username));
        if(user==null) {
            return R.error("账号不存在");
        }
        user.setMima("123456");
        qiyexinxiService.updateById(user);
        return R.ok("密码已重置为：123456");
    }

    /**
     * 后端列表  企业信息列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, QiyexinxiEntity qiyexinxi, HttpServletRequest request){
        EntityWrapper<QiyexinxiEntity> ew = new EntityWrapper<QiyexinxiEntity>();
        PageUtils page = qiyexinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, qiyexinxi), params), params));

        return R.ok().put("data", page);
    }

    /**
     * 列表 详情
     */
    @RequestMapping("/lists")
    public R list( QiyexinxiEntity qiyexinxi){
        EntityWrapper<QiyexinxiEntity> ew = new EntityWrapper<QiyexinxiEntity>();
        ew.allEq(MPUtil.allEQMapPre( qiyexinxi, "qiyexinxi"));
        return R.ok().put("data", qiyexinxiService.selectListView(ew));
    }

    /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(QiyexinxiEntity qiyexinxi){
        EntityWrapper< QiyexinxiEntity> ew = new EntityWrapper< QiyexinxiEntity>();
        ew.allEq(MPUtil.allEQMapPre( qiyexinxi, "qiyexinxi"));
        QiyexinxiView qiyexinxiView =  qiyexinxiService.selectView(ew);
        return R.ok("查询企业信息成功").put("data", qiyexinxiView);
    }

    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") String id){
        QiyexinxiEntity qiyexinxi = qiyexinxiService.selectById(id);
        return R.ok().put("data", qiyexinxi);
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody QiyexinxiEntity qiyexinxi, HttpServletRequest request){
        qiyexinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
        //ValidatorUtils.validateEntity(qiyexinxi);
        QiyexinxiEntity user = qiyexinxiService.selectOne(new EntityWrapper<QiyexinxiEntity>().eq("qiyebianhao", qiyexinxi.getQiyebianhao()));
        if(user!=null) {
            return R.error("用户已存在");
        }
        qiyexinxi.setId(new Date().getTime());
        qiyexinxiService.insert(qiyexinxi);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody QiyexinxiEntity qiyexinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(qiyexinxi);
        qiyexinxiService.updateById(qiyexinxi);//全部更新
        return R.ok();
    }


    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        qiyexinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
}
