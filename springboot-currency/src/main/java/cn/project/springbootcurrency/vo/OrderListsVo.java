package cn.project.springbootcurrency.vo;

import java.util.List;

public class OrderListsVo implements java.io.Serializable{
    private float countPrice;
    private float ySPrice;
    private float yHPrice;
    private float sJPrice;
    private float yiBao;
    private float huiYuan;
    private float xianJing;
    private float zhiFuBao;
    private float weiXin;
    private float yHK;
    private List<OrderListSsVo> orderListSsVoList;
    private int count;

    public int getCount() {
        return count;
    }

    public List<OrderListSsVo> getOrderListSsVoList() {
        return orderListSsVoList;
    }

    public void setOrderListSsVoList(List<OrderListSsVo> orderListSsVoList) {
        this.orderListSsVoList = orderListSsVoList;
    }

    public float getCountPrice() {
        return countPrice;
    }

    public void setCountPrice(float countPrice) {
        this.countPrice = countPrice;
    }

    public float getySPrice() {
        return ySPrice;
    }

    public void setySPrice(float ySPrice) {
        this.ySPrice = ySPrice;
    }

    public float getyHPrice() {
        return yHPrice;
    }

    public void setyHPrice(float yHPrice) {
        this.yHPrice = yHPrice;
    }

    public float getsJPrice() {
        return sJPrice;
    }

    public void setsJPrice(float sJPrice) {
        this.sJPrice = sJPrice;
    }

    public float getYiBao() {
        return yiBao;
    }

    public void setYiBao(float yiBao) {
        this.yiBao = yiBao;
    }

    public float getHuiYuan() {
        return huiYuan;
    }

    public void setHuiYuan(float huiYuan) {
        this.huiYuan = huiYuan;
    }

    public float getXianJing() {
        return xianJing;
    }

    public void setXianJing(float xianJing) {
        this.xianJing = xianJing;
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
