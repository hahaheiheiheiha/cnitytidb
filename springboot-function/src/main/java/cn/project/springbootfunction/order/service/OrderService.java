package cn.project.springbootfunction.order.service;

import cn.project.springbootcurrency.pojo.Order;
import org.apache.ibatis.annotations.Param;

public interface OrderService {
    public String getShouQianByDate(@Param("status") int status, @Param("type") int type);
    public int addOrderByPatient(Order order);
}
