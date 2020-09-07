package cn.project.springbootcurrency.vo;

import java.sql.Date;

public class OrderListSsVo implements java.io.Serializable {
    private int id;
    private String order_state;
    private String order_type;
    private String order_id;
    private String name;
    private String department;
    private String uName;
    private float count_price;
    private float discount;
    private float real_price;
    private float medical_insurance;
    private float zhifujine;

    private Date date_of_charge;
    private String toll_collector;
    private float xianJin;
    private float vipPrice;
    private float zhiFuBao;
    private float weiXin;
    private float yHK;
    private int count;

    public int getCount() {
        return count;
    }

    public float getZhifujine() {
        return zhifujine;
    }

    public void setZhifujine(float zhifujine) {
        this.zhifujine = zhifujine;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrder_state() {
        return order_state;
    }

    public void setOrder_state(String order_state) {
        this.order_state = order_state;
    }

    public String getOrder_type() {
        return order_type;
    }

    public void setOrder_type(String order_type) {
        this.order_type = order_type;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public float getCount_price() {
        return count_price;
    }

    public void setCount_price(float count_price) {
        this.count_price = count_price;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public float getReal_price() {
        return real_price;
    }

    public void setReal_price(float real_price) {
        this.real_price = real_price;
    }

    public float getMedical_insurance() {
        return medical_insurance;
    }

    public void setMedical_insurance(float medical_insurance) {
        this.medical_insurance = medical_insurance;
    }

    public Date getDate_of_charge() {
        return date_of_charge;
    }

    public void setDate_of_charge(Date date_of_charge) {
        this.date_of_charge = date_of_charge;
    }

    public String getToll_collector() {
        return toll_collector;
    }

    public void setToll_collector(String toll_collector) {
        this.toll_collector = toll_collector;
    }

    public float getXianJin() {
        return xianJin;
    }

    public void setXianJin(float xianJin) {
        this.xianJin = xianJin;
    }

    public float getVipPrice() {
        return vipPrice;
    }

    public void setVipPrice(float vipPrice) {
        this.vipPrice = vipPrice;
    }

    public float getZhiFuBao() {
        return zhiFuBao;
    }

    public void setZhiFuBao(float zhiFuBao) {
        this.zhiFuBao = zhiFuBao;
    }

    public float getWeiXin() {
        return weiXin;
    }

    public void setWeiXin(float weiXin) {
        this.weiXin = weiXin;
    }

    public float getyHK() {
        return yHK;
    }

    public void setyHK(float yHK) {
        this.yHK = yHK;
    }
}
