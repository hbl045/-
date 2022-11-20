package com.utils;

import cn.hutool.core.util.PageUtil;
import com.baomidou.mybatisplus.plugins.Page;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author HBL
 * @Description 分页工具类
 * @date 2022-11-10 10:44
 **/
public class PageUtils implements Serializable {
    private static final long serialVersionUID = 1L;
    //总记录数
    private  long total;
    //每页记录数
    private int pageSize;
    //总页数
    private long totalPage;
    //当前页数
    private int currPage;
    //列表数据
    private List<?> list;

    /**
     * 分页
     * @param pageSize    每页记录数
     * @param totalCount  总记录数
     * @param currPage    当前页数
     * @param list        列表数据
     */
    public PageUtils( int pageSize, int totalCount, int currPage, List<?> list) {
        this.total = totalCount;
        this.pageSize = pageSize;
        this.totalPage = (int)Math.ceil((double)totalPage/pageSize);
        this.currPage = currPage;
        this.list = list;
    }

    /**
     * 分页
     * @param page
     */
    public PageUtils(Page<?> page){
        this.list = page.getRecords();
        this.total = page.getTotal();
        this.pageSize = page.getSize();
        this.currPage = page.getCurrent();
        this.totalPage = page.getPages();
    }


    public PageUtils(Map<String,Object> params){
        Page page = new Query(params).getPage();
        new PageUtils(page);
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(long totalPage) {
        this.totalPage = totalPage;
    }

    public int getCurrPage() {
        return currPage;
    }

    public void setCurrPage(int currPage) {
        this.currPage = currPage;
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }
}
