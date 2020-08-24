package cn.project.springbootcurrency.pojo;

import java.io.Serializable;
import java.sql.Date;

public class Family implements Serializable {
    private int id;
    private String name;
    private int age;
    private char sex;
    private Date birth;
    private String phone;
    private int family_relations;
    private Date createDate;
    private int createdBy;

    public int getFamily_relations() {
        return family_relations;
    }

    public void setFamily_relations(int family_relations) {
        this.family_relations = family_relations;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

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

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
