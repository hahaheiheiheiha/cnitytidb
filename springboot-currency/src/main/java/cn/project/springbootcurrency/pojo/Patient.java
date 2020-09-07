package cn.project.springbootcurrency.pojo;

import java.sql.Date;
import java.util.List;

public class Patient implements java.io.Serializable {
    private int id;
    private int age;
    private int outpatient_id;
    private int status_id;
    private int department_id;
    private int doctor_id;
    private int patients_id;
    private int marital_id;
    private int province;
    private int city;
    private int education_id;
    private int occupation_id;
    private String name;
    private String phone;
    private Date creationtime;
    private Date updatetime;
    private String identity;
    private String cardnumber;
    private Date birth;
    private Date duedate;
    private String nation;
    private String address;
    private String workunit;
    private String remarks;
    private String img;
    private List<Family> familieList;
    private List<Order> orderList;
    private float price;
    private int vip_id;
    private int jiezhenleixing;
    private  String guadandanhao;
    private int jiezhenyishen_id;
    private int guahaoleixing;
    private int zhenliaofei;
    private char sex;
    private int yibaoka;
    private String vname;
    private int balance;
    private int integral;
    private int count;

    public int getCount() {
        return count;
    }

    public String getVname() {
        return vname;
    }

    public void setVname(String vname) {
        this.vname = vname;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getIntegral() {
        return integral;
    }

    public void setIntegral(int integral) {
        this.integral = integral;
    }

    public int getYibaoka() {
        return yibaoka;
    }

    public void setYibaoka(int yibaoka) {
        this.yibaoka = yibaoka;
    }

    public int getJiezhenleixing() {
        return jiezhenleixing;
    }

    public void setJiezhenleixing(int jiezhenleixing) {
        this.jiezhenleixing = jiezhenleixing;
    }

    public String getGuadandanhao() {
        return guadandanhao;
    }

    public void setGuadandanhao(String guadandanhao) {
        this.guadandanhao = guadandanhao;
    }

    public int getJiezhenyishen_id() {
        return jiezhenyishen_id;
    }

    public void setJiezhenyishen_id(int jiezhenyishen_id) {
        this.jiezhenyishen_id = jiezhenyishen_id;
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }



    public int getVip_id() {
        return vip_id;
    }

    public void setVip_id(int vip_id) {
        this.vip_id = vip_id;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public List<Family> getFamilieList() {
        return familieList;
    }

    public void setFamilieList(List<Family> familieList) {
        this.familieList = familieList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getOutpatient_id() {
        return outpatient_id;
    }

    public void setOutpatient_id(int outpatient_id) {
        this.outpatient_id = outpatient_id;
    }

    public int getStatus_id() {
        return status_id;
    }

    public void setStatus_id(int status_id) {
        this.status_id = status_id;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public int getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(int doctor_id) {
        this.doctor_id = doctor_id;
    }

    public int getPatients_id() {
        return patients_id;
    }

    public void setPatients_id(int patients_id) {
        this.patients_id = patients_id;
    }


    public int getMarital_id() {
        return marital_id;
    }

    public void setMarital_id(int marital_id) {
        this.marital_id = marital_id;
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

    public int getEducation_id() {
        return education_id;
    }

    public void setEducation_id(int education_id) {
        this.education_id = education_id;
    }

    public int getOccupation_id() {
        return occupation_id;
    }

    public void setOccupation_id(int occupation_id) {
        this.occupation_id = occupation_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCreationtime() {
        return creationtime;
    }

    public void setCreationtime(Date creationtime) {
        this.creationtime = creationtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(String cardnumber) {
        this.cardnumber = cardnumber;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Date getDuedate() {
        return duedate;
    }

    public void setDuedate(Date duedate) {
        this.duedate = duedate;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWorkunit() {
        return workunit;
    }

    public void setWorkunit(String workunit) {
        this.workunit = workunit;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

}
