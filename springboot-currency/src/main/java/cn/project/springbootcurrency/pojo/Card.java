package cn.project.springbootcurrency.pojo;

import java.io.Serializable;
import java.sql.Date;

public class Card implements Serializable {
    private int id;
    private int state;
    private int user_id;
    private float transaction_amount;
    private float total_amount;
    private float balance;
    private int transaction_mode;
    private Date trading_hours;
    private int operator_id;
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

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public float getTransaction_amount() {
        return transaction_amount;
    }

    public void setTransaction_amount(float transaction_amount) {
        this.transaction_amount = transaction_amount;
    }

    public float getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(float total_amount) {
        this.total_amount = total_amount;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public int getTransaction_mode() {
        return transaction_mode;
    }

    public void setTransaction_mode(int transaction_mode) {
        this.transaction_mode = transaction_mode;
    }

    public Date getTrading_hours() {
        return trading_hours;
    }

    public void setTrading_hours(Date trading_hours) {
        this.trading_hours = trading_hours;
    }

    public int getOperator_id() {
        return operator_id;
    }

    public void setOperator_id(int operator_id) {
        this.operator_id = operator_id;
    }
}
