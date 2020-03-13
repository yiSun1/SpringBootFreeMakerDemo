package com.jmail.demo.common;

import com.github.pagehelper.Page;

import java.io.Serializable;


public class UiGrid<T> implements Serializable {
    /**
     * 第几页
     */
    private Integer page;

    /**
     * 每页最大行数
     */
    private Integer pageSize;

    /**
     * 排序字段
     */
    private String sidx;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getSidx() {
        return sidx;
    }

    public void setSidx(String sidx) {
        this.sidx = sidx;
    }

    public Page getPageQuery() {
        Page pageQ=new Page();
        if(page==null || pageSize==null || pageSize==0 || pageSize==-1){
            pageQ.setPageNum(1);
            pageQ.setPageSize(10);
            return pageQ;
        }else {
            pageQ.setPageNum(this.page);
            pageQ.setPageSize(this.pageSize);
            return pageQ;
        }
    }
}
