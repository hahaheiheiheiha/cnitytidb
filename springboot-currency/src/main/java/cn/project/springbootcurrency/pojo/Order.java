package cn.project.springbootcurrency.pojo;

import java.io.Serializable;
import java.sql.Date;

public class Order implements Serializable {
    private int id;
    private int order_state;
    private int order_type;
    private int name_id;
    private int department;
    private int doctor_id;
    private String order_id;
    private String toll_collector;
    private float count_price;
    private float discount;
    private float real_price;
    private float medical_insurance;

    private Date date_of_charge;
    private int zhifufangshi;
    private float labelMapper;
    private float zhifujine;

    public float getZhifujine() {
        return zhifujine;
    }

    public void setZhifujine(float zhifujine) {
        this.zhifujine = zhifujine;
    }

    public float getLabelMapper() {
        return labelMapper;
    }

    public void setLabelMapper(float labelMapper) {
        this.labelMapper = labelMapper;
    }

    public int getZhifufangshi() {
        return zhifufangshi;
    }

    public void setZhifufangshi(int zhifufangshi) {
        this.zhifufangshi = zhifufangshi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getName_id() {
        return name_id;
    }

    public void setName_id(int name_id) {
        this.name_id = name_id;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public int getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(int doctor_id) {
        this.doctor_id = doctor_id;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getToll_collector() {
        return toll_collector;
    }

    public void setToll_collector(String toll_collector) {
        this.toll_collector = toll_collector;
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
        if(medical_insurance<=6000){
            this.medical_insurance = (float)(medical_insurance*0.6);
        }else{
            this.medical_insurance = (float)(medical_insurance*0.8);
        }

    }



    public Date getDate_of_charge() {
        return date_of_charge;
    }

    public void setDate_of_charge(Date date_of_charge) {
        this.date_of_charge = date_of_charge;
    }
}
