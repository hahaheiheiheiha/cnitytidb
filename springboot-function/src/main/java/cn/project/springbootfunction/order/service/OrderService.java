package cn.project.springbootfunction.order.service;

import org.apache.ibatis.annotations.Param;

public interface OrderService {
    public String getShouQianByDate(@Param("status") int status, @Param("type") int type);
}
