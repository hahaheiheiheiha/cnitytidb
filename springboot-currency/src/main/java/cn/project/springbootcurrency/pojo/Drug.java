package cn.project.springbootcurrency.pojo;

import java.io.Serializable;
import java.util.Date;

public class Drug implements Serializable {
    private int id;
    private int classification;
    private int dosageform;
    private int otc;
    private int state;
    private int invoice;
    private int manufactor;
    private int packing_company;
    private int dose_company;
    private int sell_piece_by_piece;
    private int member_discount;
    private int usage;
    private int consumption;
    private int frequency;
    private int days;
    private int total;
    private int total_company;
    private int minstock;
    private int maxstock;
    private int validity_warning;
    private int drug_c_w;
    private String barcode;
    private String common_name;
    private String pinyincode;
    private String specifications;
    private String approval_number;
    private String coefficient;
    private String company;
    private String dose;
    private String location_number;
    private String drug_description;
    private String remarks;
    private float purchase_price;
    private float retail_price;
    private String sname;
    private Date CreationTime;

    public Date getCreationTime() {
        return CreationTime;
    }

    public void setCreationTime(Date creationTime) {
        CreationTime = creationTime;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClassification() {
        return classification;
    }

    public void setClassification(int classification) {
        this.classification = classification;
    }

    public int getDosageform() {
        return dosageform;
    }

    public void setDosageform(int dosageform) {
        this.dosageform = dosageform;
    }

    public int getOtc() {
        return otc;
    }

    public void setOtc(int otc) {
        this.otc = otc;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getInvoice() {
        return invoice;
    }

    public void setInvoice(int invoice) {
        this.invoice = invoice;
    }

    public int getManufactor() {
        return manufactor;
    }

    public void setManufactor(int manufactor) {
        this.manufactor = manufactor;
    }

    public int getPacking_company() {
        return packing_company;
    }

    public void setPacking_company(int packing_company) {
        this.packing_company = packing_company;
    }

    public int getDose_company() {
        return dose_company;
    }

    public void setDose_company(int dose_company) {
        this.dose_company = dose_company;
    }

    public int getSell_piece_by_piece() {
        return sell_piece_by_piece;
    }

    public void setSell_piece_by_piece(int sell_piece_by_piece) {
        this.sell_piece_by_piece = sell_piece_by_piece;
    }

    public int getMember_discount() {
        return member_discount;
    }

    public void setMember_discount(int member_discount) {
        this.member_discount = member_discount;
    }

    public int getUsage() {
        return usage;
    }

    public void setUsage(int usage) {
        this.usage = usage;
    }

    public int getConsumption() {
        return consumption;
    }

    public void setConsumption(int consumption) {
        this.consumption = consumption;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotal_company() {
        return total_company;
    }

    public void setTotal_company(int total_company) {
        this.total_company = total_company;
    }

    public int getMinstock() {
        return minstock;
    }

    public void setMinstock(int minstock) {
        this.minstock = minstock;
    }

    public int getMaxstock() {
        return maxstock;
    }

    public void setMaxstock(int maxstock) {
        this.maxstock = maxstock;
    }

    public int getValidity_warning() {
        return validity_warning;
    }

    public void setValidity_warning(int validity_warning) {
        this.validity_warning = validity_warning;
    }

    public int getDrug_c_w() {
        return drug_c_w;
    }

    public void setDrug_c_w(int drug_c_w) {
        this.drug_c_w = drug_c_w;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getCommon_name() {
        return common_name;
    }

    public void setCommon_name(String common_name) {
        this.common_name = common_name;
    }

    public String getPinyincode() {
        return pinyincode;
    }

    public void setPinyincode(String pinyincode) {
        this.pinyincode = pinyincode;
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }

    public String getApproval_number() {
        return approval_number;
    }

    public void setApproval_number(String approval_number) {
        this.approval_number = approval_number;
    }

    public String getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(String coefficient) {
        this.coefficient = coefficient;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public String getLocation_number() {
        return location_number;
    }

    public void setLocation_number(String location_number) {
        this.location_number = location_number;
    }

    public String getDrug_description() {
        return drug_description;
    }

    public void setDrug_description(String drug_description) {
        this.drug_description = drug_description;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public float getPurchase_price() {
        return purchase_price;
    }

    public void setPurchase_price(float purchase_price) {
        this.purchase_price = purchase_price;
    }

    public float getRetail_price() {
        return retail_price;
    }

    public void setRetail_price(float retail_price) {
        this.retail_price = retail_price;
    }
}
