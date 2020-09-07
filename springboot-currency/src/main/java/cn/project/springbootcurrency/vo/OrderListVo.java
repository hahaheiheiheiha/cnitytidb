package cn.project.springbootcurrency.vo;

import java.sql.Date;

public class OrderListVo implements java.io.Serializable{
    private int id;
    private String order_id;
    private String name;
    private int age;
    private char sex;
    private String type;
    private String phone;
    private String department;
    private String uName;
    private Date  creationtime;
    private float real_price;
    private float zhifujine;
    private String state;
    private String zhifufangshi;
    private int count;

    public int getCount() {
        return count;
    }

    public String getZhifufangshi() {
        return zhifufangshi;
    }

    public void setZhifufangshi(String zhifufangshi) {
        this.zhifufangshi = zhifufangshi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public Date getCreationtime() {
        return creationtime;
    }

    public void setCreationtime(Date creationtime) {
        this.creationtime = creationtime;
    }

    public float getReal_price() {
        return real_price;
    }

    public void setReal_price(float real_price) {
        this.real_price = real_price;
    }

    public float getZhifujine() {
        return zhifujine;
    }

    public void setZhifujine(float zhifujine) {
        this.zhifujine = zhifujine;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
