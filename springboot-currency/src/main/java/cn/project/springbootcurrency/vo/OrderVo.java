package cn.project.springbootcurrency.vo;

import java.sql.Date;

public class OrderVo {
    private int order_state;
    private int order_type;
    private Date maxCreateDate;
    private Date minCreateDate;
    private String nameOrOrder_id;
    private int page;
    private int pageSize;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = (page-1)*this.pageSize;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getOrder_state() {
        return order_state;
    }

    public void setOrder_state(int order_state) {
        this.order_state = order_state;
    }

    public int getOrder_type() {
        return order_type;
    }

    public void setOrder_type(int order_type) {
        this.order_type = order_type;
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
}
