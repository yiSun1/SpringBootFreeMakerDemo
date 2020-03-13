package com.jmail.demo.common;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UidateGrid<T> implements Serializable {
    private int page;//页数
    private long total = 0; //总记录数
    private int pageSize;//一页大小
    private int totalPage;//总页数
    private String sidx;//排序字段
    private String sord = "desc";//排序方式
    private List<T> data = new ArrayList<T>();//查询结果
    private String code;
    private String msg="";

    public UidateGrid(){

    }


    public Integer getPage() {
        return page;
    }

    public UidateGrid<T> setPage(Integer page) {
        this.page = page;
        return this;
    }

    public long getTotal() {
        return total;
    }

    public UidateGrid<T> setTotal(long total) {
        this.total = total;
        return this;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public UidateGrid<T> setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public UidateGrid<T> setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
        return this;
    }

    public String getSidx() {
        return sidx;
    }

    public UidateGrid<T> setSidx(String sidx) {
        this.sidx = sidx;
        return this;
    }

    public String getSord() {
        return sord;
    }

    public UidateGrid<T> setSord(String sord) {
        this.sord = sord;
        return this;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public UidateGrid<T> setCode(String code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public UidateGrid<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public UidateGrid<T> setPageModel(PageModel pageModel) {
        this.data = pageModel.getDatas();
        this.totalPage= pageModel.getTotalPageNum();
        this.total = pageModel.getTotalCount();
        this.page=pageModel.getPageNum();
        this.pageSize=pageModel.getPageSize();
        return this;
    }

}
