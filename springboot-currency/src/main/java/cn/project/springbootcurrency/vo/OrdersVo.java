package cn.project.springbootcurrency.vo;

import java.sql.Date;

public class OrdersVo {
    private int state;
    private Date maxCreateDate;
    private Date minCreateDate;
    private String nameOrOrder_id;
    private int page;
    private int pageSize;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Date getMaxCreateDate() {
        return maxCreateDate;
    }

    public void setMaxCreateDate(Date maxCreateDate) {
        this.maxCreateDate = maxCreateDate;
    }

    public Date getMinCreateDate() {
        return minCreateDate;
    }

    public void setMinCreateDate(Date minCreateDate) {
        this.minCreateDate = minCreateDate;
    }

    public String getNameOrOrder_id() {
        return nameOrOrder_id;
    }

    public void setNameOrOrder_id(String nameOrOrder_id) {
        this.nameOrOrder_id = nameOrOrder_id;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = (page-1)*pageSize;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
