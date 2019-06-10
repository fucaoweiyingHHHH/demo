package com.djt.ssmdemo.Vo;


import java.util.List;
import java.util.Map;

public class PageVo<T>{
    //当前页码
    private int pageNow;

    //启始索引
    private int start=0;

    //一页显示的记录数
    private int limit;

    //记录数
    private int total;

    //存放记录集
    private List<T> items;

    //查询条件
    private Map<String,Object> queryMap;

    /**
     * <p>
     * SQL 排序 ASC 集合
     * </p>
     */
    private List<String> ascs;
    /**
     * <p>
     * SQL 排序 DESC 集合
     * </p>
     */
    private List<String> descs;



    public int getPageNow() {
        return pageNow;
    }

    public void setPageNow(int pageNow) {
        this.pageNow = pageNow;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public int getStart() {
        if(pageNow>1){
            this.start = (this.pageNow-1)*this.limit;
        }
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public Map<String, Object> getQueryMap() {
        return queryMap;
    }

    public void setQueryMap(Map<String, Object> queryMap) {
        this.queryMap = queryMap;
    }

    public List<String> getAscs() {
        return ascs;
    }

    public void setAscs(List<String> ascs) {
        this.ascs = ascs;
    }

    public List<String> getDescs() {
        return descs;
    }

    public void setDescs(List<String> descs) {
        this.descs = descs;
    }
}
