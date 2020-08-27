package cn.project.springbootcurrency.vo;

import java.sql.Date;

public class PatientVO implements java.io.Serializable{
    private String name;
    private String cardnumber;
    private int age;
    private char sex;
    private String phone;
    private Date birth;
    private int province;
    private int city;
    private String address;
    private String remarks;
    private String guadandanhao;
    private int department_id;
    private int jiezhenleixing;
    private int jiezhenyishen_id;
    private int doctor_id;
    private int guahaoleixing;
    private int zhenliaofei;
    private String identity;
    private int id ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(String cardnumber) {
        this.cardnumber = cardnumber;
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

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public int getProvince() {
        return province;
    }

    public void setProvince(int province) {
        this.province = province;
    }

    public int getCity() {
        return city;
    }

    public void setCity(int city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getGuadandanhao() {
        return guadandanhao;
    }

    public void setGuadandanhao(String guadandanhao) {
        this.guadandanhao = guadandanhao;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public int getJiezhenleixing() {
        return jiezhenleixing;
    }

    public void setJiezhenleixing(int jiezhenleixing) {
        this.jiezhenleixing = jiezhenleixing;
    }

    public int getJiezhenyishen_id() {
        return jiezhenyishen_id;
    }

    public void setJiezhenyishen_id(int jiezhenyishen_id) {
        this.jiezhenyishen_id = jiezhenyishen_id;
    }

    public int getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(int doctor_id) {
        this.doctor_id = doctor_id;
    }

    public int getGuahaoleixing() {
        return guahaoleixing;
    }

    public void setGuahaoleixing(int guahaoleixing) {
        this.guahaoleixing = guahaoleixing;
    }

    public int getZhenliaofei() {
        return zhenliaofei;
    }

    public void setZhenliaofei(int zhenliaofei) {
        this.zhenliaofei = zhenliaofei;
    }
}
