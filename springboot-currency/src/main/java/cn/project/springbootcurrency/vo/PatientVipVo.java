package cn.project.springbootcurrency.vo;


import java.sql.Date;

public class PatientVipVo {
    private int vipId;
    private Date maxCreatedDate;
    private Date minCreatedDate;
    private String nameOrPhone;
    private int page;
    private int pageSize;

    public int getVipId() {
        return vipId;
    }

    public void setVipId(int vipId) {
        this.vipId = vipId;
    }

    public Date getMaxCreatedDate() {
        return maxCreatedDate;
    }

    public void setMaxCreatedDate(Date maxCreatedDate) {
        this.maxCreatedDate = maxCreatedDate;
    }

    public Date getMinCreatedDate() {
        return minCreatedDate;
    }

    public void setMinCreatedDate(Date minCreatedDate) {
        this.minCreatedDate = minCreatedDate;
    }

    public String getNameOrPhone() {
        return nameOrPhone;
    }

    public void setNameOrPhone(String nameOrPhone) {
        this.nameOrPhone = nameOrPhone;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = (page-1)*page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
