package cn.project.springbootcurrency.vo;

import java.sql.Date;

public class PatientListVO implements java.io.Serializable{
    private int id;
    private String guadandanhao;
    private String name;
    private int age;
    private char sex;
    private String phone;
    private int department_id;
    private int user_id;
    private Date creationtime;
    private float count_price;
    private float real_price;
    private int status_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGuadandanhao() {
        return guadandanhao;
    }

    public void setGuadandanhao(String guadandanhao) {
        this.guadandanhao = guadandanhao;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Date getCreationtime() {
        return creationtime;
    }

    public void setCreationtime(Date creationtime) {
        this.creationtime = creationtime;
    }

    public float getCount_price() {
        return count_price;
    }

    public void setCount_price(float count_price) {
        this.count_price = count_price;
    }

    public float getReal_price() {
        return real_price;
    }

    public void setReal_price(float real_price) {
        this.real_price = real_price;
    }

    public int getStatus_id() {
        return status_id;
    }

    public void setStatus_id(int status_id) {
        this.status_id = status_id;
    }
}
