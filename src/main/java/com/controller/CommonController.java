package com.controller;

import com.annotation.IgnoreAuth;
import com.baidu.aip.face.AipFace;
import com.service.CommonService;
import com.service.ConfigService;
import com.utils.R;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author HBL
 * @Description
 * @date 2022-11-19 20:37
 **/
@RestController
public class CommonController {
    @Autowired
    private CommonService commonService;

    @Autowired
    private ConfigService configService;

    private static AipFace client = null;

    private static String BAIDU_DITU_AK = null;


    /**
     * 获取table表中的column列表(联动接口)
     * @param
     * @param
     * @return
     */
    @IgnoreAuth
    @RequestMapping("/option/{tableName}/{columnName}")
    public R getOption(@PathVariable("tableName") String tableName, @PathVariable("columnName") String columnName, String level, String parent) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("table", tableName);
        params.put("column", columnName);
        if(StringUtils.isNotBlank(level)) {
            params.put("level", level);
        }
        if(StringUtils.isNotBlank(parent)) {
            params.put("parent", parent);
        }
        List<String> data = commonService.getOption(params);
        return R.ok().put("data", data);
    }

    /**
     * 根据table中的column获取单条记录
     * @param
     * @param
     * @return
     */
    @IgnoreAuth
    @RequestMapping("/follow/{tableName}/{columnName}")
    public R getFollowByOption(@PathVariable("tableName") String tableName, @PathVariable("columnName") String columnName, @RequestParam String columnValue) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("table", tableName);
        params.put("column", columnName);
        params.put("columnValue", columnValue);
        Map<String, Object> result = commonService.getFollowByOption(params);
        return R.ok().put("data", result);
    }

    /**
     * 修改table表的sfsh状态
     * @param
     * @param map
     * @return
     */
    @RequestMapping("/sh/{tableName}")
    public R sh(@PathVariable("tableName") String tableName, @RequestBody Map<String, Object> map) {
        map.put("table", tableName);
        commonService.sh(map);
        return R.ok();
    }

    /**
     * 获取需要提醒的记录数
     * @param tableName
     * @param columnName
     * @param type 1:数字 2:日期
     * @param map
     * @return
     */
    @IgnoreAuth
    @RequestMapping("/remind/{tableName}/{columnName}/{type}")
    public R remindCount(@PathVariable("tableName") String tableName, @PathVariable("columnName") String columnName,
                         @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
        map.put("table", tableName);
        map.put("column", columnName);
        map.put("type", type);

        if(type.equals("2")) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar c = Calendar.getInstance();
            Date remindStartDate = null;
            Date remindEndDate = null;
            if(map.get("remindstart")!=null) {
                Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
                c.setTime(new Date());
                c.add(Calendar.DAY_OF_MONTH,remindStart);
                remindStartDate = c.getTime();
                map.put("remindstart", sdf.format(remindStartDate));
            }
            if(map.get("remindend")!=null) {
                Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
                c.setTime(new Date());
                c.add(Calendar.DAY_OF_MONTH,remindEnd);
                remindEndDate = c.getTime();
                map.put("remindend", sdf.format(remindEndDate));
            }
        }

        int count = commonService.remindCount(map);
        return R.ok().put("count", count);
    }

    /**
     * 单列求和
     */
    @IgnoreAuth
    @RequestMapping("/cal/{tableName}/{columnName}")
    public R cal(@PathVariable("tableName") String tableName, @PathVariable("columnName") String columnName) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("table", tableName);
        params.put("column", columnName);
        Map<String, Object> result = commonService.selectCal(params);
        return R.ok().put("data", result);
    }

    /**
     * 分组统计
     */
    @IgnoreAuth
    @RequestMapping("/group/{tableName}/{columnName}")
    public R group(@PathVariable("tableName") String tableName, @PathVariable("columnName") String columnName) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("table", tableName);
        params.put("column", columnName);
        List<Map<String, Object>> result = commonService.selectGroup(params);
        return R.ok().put("data", result);
    }

    /**
     * （按值统计）
     */
    @IgnoreAuth
    @RequestMapping("/value/{tableName}/{xColumnName}/{yColumnName}")
    public R value(@PathVariable("tableName") String tableName, @PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("table", tableName);
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        List<Map<String, Object>> result = commonService.selectValue(params);
        return R.ok().put("data", result);
    }
}
