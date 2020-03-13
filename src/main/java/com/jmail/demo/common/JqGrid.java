package com.jmail.demo.common;

import com.github.pagehelper.Page;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JqGrid<T> implements Serializable {

    private Integer page = 1;
    private Integer total = 0;
    private Integer rows = 20;
    private long records = 0;
    private String sidx;
    private String sord = "desc";
    private List<T> dateList = new ArrayList<T>();
    private Map<String, Object> filter = new HashMap<String, Object>();

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public long getRecords() {
        return records;
    }

    public void setRecords(long records) {
        this.records = records;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public List<T> getDateList() {
        return dateList;
    }

    public void setDateList(List<T> dateList) {
        this.dateList = dateList;
    }

    public Map<String, Object> getFilter() {
        return filter;
    }

    public Object getFilter(String key) {
        return filter.get(key);
    }

    public void setFilter(Map<String, Object> filter) {
        this.filter = filter;
    }

    public void setFilter(String key, Object value) {
        this.filter.put(key, value);
    }

    public String getSidx() {
        return sidx;
    }

    public void setSidx(String sidx) {
        this.sidx = sidx;
    }

    public String getSord() {
        return sord;
    }

    public void setSord(String sord) {
        this.sord = sord;
    }


    public Page getPageQuery() {
        Page pageQ = new Page();
        if (page == null || rows == null || rows == 0 || rows == -1) {
            pageQ.setPageNum(1);
            pageQ.setPageSize(10);
            return pageQ;
        } else {
            pageQ.setPageNum(this.page);
            pageQ.setPageSize(this.rows);
            return pageQ;
        }
    }


    public void setPageModel(PageModel pageModel) {
        this.dateList = pageModel.getDatas();//数据
        this.total = pageModel.getTotalPageNum();//总页数
        this.records = pageModel.getTotalCount();//总记录数
        this.page = pageModel.getPageNum();//页码
        this.rows = pageModel.getPageSize();//页大小
    }

    @Override
    public String toString() {
        return "JqGrid{" +
                "page=" + page +
                ", total=" + total +
                ", rows=" + rows +
                ", records=" + records +
                ", sidx='" + sidx + '\'' +
                ", sord='" + sord + '\'' +
                ", dateList=" + dateList +
                ", filter=" + filter +
                '}';
    }
}
