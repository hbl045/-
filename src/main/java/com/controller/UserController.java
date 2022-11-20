package com.controller;

import java.util.Arrays;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.annotation.IgnoreAuth;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.entity.UserEntity;
import com.service.TokenService;
import com.service.UserService;
import com.utils.MPUtil;
import com.utils.PageUtils;
import com.utils.R;

import org.springframework.web.bind.annotation.*;





/**
 * @author HBL
 * @Description 管理员 - 登陆相关
 * @date 2022-11-10 19:30
 **/
@RequestMapping("users")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;

    /**
     * 注册
     * @param username
     * @param password
     * @param request
     * @return
     */
    @IgnoreAuth
    @PostMapping(value= "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request){
        //获取指定用户的名称 selectOne EntityWrapper 都是MB的方法 数据库列名 加 数字值
        //System.out.println("2、后端调用 username:"+username);
        UserEntity user = userService.selectOne(new EntityWrapper<UserEntity>().eq("username",username));
        //用户和密码判断 不符合返回
        //System.out.println("3、数据库找值"+user.toString());
        if(user==null || !user.getPassword().equals(password)){
            return  R.error("账号或密码不正确");
        }
        //
        //返回result token值，权限值，和后面的页面显示有关
        String token = tokenService.generateToken(user.getId(),username,"users",user.getRole());
        //System.out.println("4、后台 token走到这里");
        return R.ok().put("token",token);
    }

    /**
     * 注册
     */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody UserEntity user) {
        //System.out.println("可以进入到后台操作区");
        if (userService.selectOne(new EntityWrapper<UserEntity>().eq("username", user.getUsername())) != null) {
            return R.error("用户已存在");
        }
        userService.insert(user);
        return R.ok();
    }



    /**
     * 退出
     * @param request
     * @return
     */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request){
        request.getSession().invalidate();
        return R.ok("退出成功");
    }

    /**
     * 密码重置
     * @param username
     * @param request
     * @return
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username,HttpServletRequest request){
        UserEntity user = userService.selectOne(new EntityWrapper<UserEntity>().eq("username",username));
        if(user==null){
            return R.error("账号不存在");
        }
        user.setPassword("123456");
        userService.update(user,null);
        return R.ok("密码已重置为:123456");
    }

    /**
     * 列表  爆红
     * @param params
     * @param user
     * @return
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,UserEntity user){
        EntityWrapper<UserEntity> ew = new EntityWrapper<UserEntity>();
        PageUtils page = userService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.allLike(ew, user), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 列表
     * @param user
     * @return
     */
    @RequestMapping("list")
    public R list(UserEntity user){
        EntityWrapper<UserEntity> ew = new EntityWrapper<UserEntity>();
        ew.allEq(MPUtil.allEQMapPre(user,"user"));
        return R.ok().put("data",userService.selectListView(ew));
    }

    /**
     * 信息
     * @param id
     * @return
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") String id){
        UserEntity user = userService.selectById(id);
        return R.ok().put("data",user);
    }

    /**
     * 获取用户的session用户信息
     * @param request
     * @return
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
        Long id = (Long) request.getSession().getAttribute("userId");
        UserEntity user = userService.selectById(id);
        return R.ok().put("data",user);
    }

    @PostMapping("/save")
    public R save(@RequestBody UserEntity user){
        if(userService.selectOne(new EntityWrapper<UserEntity>().eq("username",user.getUsername()))!=null){
            return R.error("用户已存在");
        }
        userService.insert(user);
        return R.ok();
    }

    /**
     * 修改  ceter姓名 、 密码修改
     * @param user
     * @return
     */
    @RequestMapping("/update")
    public R update(@RequestBody UserEntity user){
        userService.updateById(user);//全部更新
        return R.ok();
    }

    /**
     * 删除
     * @param ids  删除接口
     * @return
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        userService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
















}
