package com.easy.ebbinghausservice.model.response;

import java.util.List;

/**
 * Paginate response body.
 *
 * @author Easy
 */
public class Paginate<T> {
    private int current;
    private int pageSize;
    private long total;
    private List<T> list;

    protected Paginate(int current, int pageSize, long total, List<T> list) {
        // jpa的offset从0开始
        this.current = (current + 1);
        this.pageSize = pageSize;
        this.total = total;
        this.list = list;
    }

    public static <T> Paginate<T> build(int current, int pageSize, long total, List<T> list) {
        return new Paginate<>(current, pageSize, total, list);
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
