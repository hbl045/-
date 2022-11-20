package com.controller;

import com.annotation.IgnoreAuth;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.entity.QiyexinxiEntity;
import com.entity.YonghuEntity;
import com.entity.view.YonghuView;
import com.service.TokenService;
import com.service.YonghuService;
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
 * @Description 用户登陆，后端接口
 * @date 2022-11-17 21:23
 **/
@RestController
@RequestMapping("/yonghu")
public class YonghuController {

    @Autowired
    private YonghuService yonghuService;

    @Autowired
    private TokenService tokenService;

    /**
     * 用户账号登陆
     * @param username
     * @param password
     * @param captcha
     * @param request
     * @return
     */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request){
        YonghuEntity user = yonghuService.selectOne(new EntityWrapper<YonghuEntity>().eq("yonghuming",username));
        if(user==null || !user.getMima().equals(password)){
            return R.error("账号或密码不正确");
        }
        String token = tokenService.generateToken(user.getId(),username,"yonghu","用户");
        return R.ok().put("token",token);
    }

    /**
     * 注册用户账号
     * @param yonghu
     * @return
     */
    @IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody YonghuEntity yonghu){
        YonghuEntity user = yonghuService.selectOne(new EntityWrapper<YonghuEntity>().eq("yonghuming",yonghu.getYonghuming()));
        if(user!=null){
            return R.error("注册用户已存在");
        }
        yonghu.setId(new Date().getTime());
        yonghuService.insert(yonghu);
        return R.ok();
    }

    /**
     * 退出
     * @param request
     * @return
     */
    @RequestMapping("/logout")
    public R logout(HttpServletRequest request){
        request.getSession().invalidate();
        return R.ok("退出成功");
    }

    /**
     * 获取用户的session用户信息
     * @param request
     * @return
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
        Long id = (Long)request.getSession().getAttribute("userId");
        YonghuEntity user = yonghuService.selectById(id);
        return R.ok().put("data",user);
    }


    /**
     * 密码重置
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
        YonghuEntity user = yonghuService.selectOne(new EntityWrapper<YonghuEntity>().eq("yonghuming", username));
        if(user==null) {
            return R.error("账号不存在");
        }
        user.setMima("123456");
        yonghuService.updateById(user);
        return R.ok("密码已重置为：123456");
    }



    /**
     * 后端列表  只有管理员可以看 用户的列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, YonghuEntity yonghu, HttpServletRequest request){
        EntityWrapper<YonghuEntity> ew = new EntityWrapper<YonghuEntity>();
        PageUtils page = yonghuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yonghu), params), params));

        return R.ok().put("data", page);
    }



    /**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YonghuEntity yonghu){
        EntityWrapper<YonghuEntity> ew = new EntityWrapper<YonghuEntity>();
        ew.allEq(MPUtil.allEQMapPre( yonghu, "yonghu"));
        return R.ok().put("data", yonghuService.selectListView(ew));
    }

    /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YonghuEntity yonghu){
        EntityWrapper< YonghuEntity> ew = new EntityWrapper< YonghuEntity>();
        ew.allEq(MPUtil.allEQMapPre( yonghu, "yonghu"));
        YonghuView yonghuView =  yonghuService.selectView(ew);
        return R.ok("查询用户成功").put("data", yonghuView);
    }


    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") String id){
        YonghuEntity yonghu = yonghuService.selectById(id);
        return R.ok().put("data", yonghu);
    }






    /**
     * 后端保存  实现新增用户
     */
    @RequestMapping("/save")
    public R save(@RequestBody YonghuEntity yonghu, HttpServletRequest request){
        yonghu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
        //ValidatorUtils.validateEntity(yonghu);
        YonghuEntity user = yonghuService.selectOne(new EntityWrapper<YonghuEntity>().eq("yonghuming", yonghu.getYonghuming()));
        if(user!=null) {
            return R.error("用户已存在");
        }
        yonghu.setId(new Date().getTime());
        yonghuService.insert(yonghu);
        return R.ok();
    }





    /**
     * 修改 实现修改按钮
     */
    @RequestMapping("/update")
    public R update(@RequestBody YonghuEntity yonghu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yonghu);
        yonghuService.updateById(yonghu);//全部更新
        return R.ok();
    }


    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yonghuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }




}
