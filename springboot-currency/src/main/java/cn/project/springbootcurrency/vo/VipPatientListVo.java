package cn.project.springbootcurrency.vo;

import java.sql.Date;

public class VipPatientListVo {
    private int id;
    private String cardnumber;
    private String vipName;
    private String vipLoven;
    private String phone;
    private float consumption;
    private float balance;
    private float stored_value;
    private Date creationDate;
    private Date expire;
    private int integral;
    private String name;
    private int count;

    public int getCount() {
        return count;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(String cardnumber) {
        this.cardnumber = cardnumber;
    }

    public String getVipName() {
        return vipName;
    }

    public void setVipName(String vipName) {
        this.vipName = vipName;
    }

    public String getVipLoven() {
        return vipLoven;
    }

    public void setVipLoven(String vipLoven) {
        this.vipLoven = vipLoven;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public float getConsumption() {
        return consumption;
    }

    public void setConsumption(float consumption) {
        this.consumption = consumption;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public float getStored_value() {
        return stored_value;
    }

    public void setStored_value(float stored_value) {
        this.stored_value = stored_value;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getExpire() {
        return expire;
    }

    public void setExpire(Date expire) {
        this.expire = expire;
    }

    public int getIntegral() {
        return integral;
    }

    public void setIntegral(int integral) {
        this.integral = integral;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
