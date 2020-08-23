package cn.project.springbootcurrency.pojo;

import java.io.Serializable;

public class Vip implements Serializable {
    private int id;
    private String name;
    private String loven;
    private float discount;
    private int minintegral;
    private String remarks;
    private int state;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoven() {
        return loven;
    }

    public void setLoven(String loven) {
        this.loven = loven;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public int getMinintegral() {
        return minintegral;
    }

    public void setMinintegral(int minintegral) {
        this.minintegral = minintegral;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
