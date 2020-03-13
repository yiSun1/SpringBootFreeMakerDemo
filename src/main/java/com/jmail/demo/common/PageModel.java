package com.jmail.demo.common;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: winston
 * Date: 12-9-13
 * Time: 下午4:24
 * To change this template use File | Settings | File Templates.
 */
public class PageModel<T> extends ArrayList<T> implements Serializable {

    /**
     * 页面大小
     */
    private int pageSize;
    /**
     * 页码，从1开始
     */
    private int pageNum;
    /**
     * 总页数,不分页的时候值必须为0
     */
    private int totalPageNum;
    /**
     * 总数
     */
    private long totalCount;
//    private List<T> datas;

    public PageModel() {
        super();
    }

    public PageModel(Page pageQuery) {
        this.pageSize = pageQuery.getPageSize();
        this.pageNum = pageQuery.getPageNum();
        this.totalCount = pageQuery.getTotal();
        if (pageQuery.getTotal() == 0) this.totalPageNum = 0;
        else
            this.totalPageNum = (int) Math.floor((pageQuery.getTotal() / this.pageSize));
        super.addAll(pageQuery);
    }

    public PageModel(PageInfo<T> pageInfo) {
        this.pageSize = pageInfo.getPageSize();
        this.pageNum = pageInfo.getPageNum();
        this.totalCount = pageInfo.getTotal();
        this.totalPageNum =pageInfo.getPages();
        super.addAll(pageInfo.getList());
    }


    public long getTotalCount() {
        return this.totalCount;
    }

    public List<T> getDatas() {
        return this;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public int getTotalPageNum() {
        return this.totalPageNum;
    }

    public int getPageNum() {
        return this.pageNum;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        PageModel pageModel = (PageModel) o;

        if (pageNum != pageModel.pageNum) return false;
        if (pageSize != pageModel.pageSize) return false;
        if (totalCount != pageModel.totalCount) return false;
        if (totalPageNum != pageModel.totalPageNum) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + pageSize;
        result = 31 * result + pageNum;
        result = 31 * result + totalPageNum;
        result = 31 * result + (int) (totalCount ^ (totalCount >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "PageModel{" +
                "pageSize=" + pageSize +
                ", pageNum=" + pageNum +
                ", totalPageNum=" + totalPageNum +
                ", totalCount=" + totalCount +
                ",datas=" + super.toString() +
                '}';
    }

}
