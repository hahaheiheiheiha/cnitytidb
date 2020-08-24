package cn.project.springbootfunction.order.service;

import cn.project.springbootcurrency.mapper.OrderMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OrdereServiceImpl implements OrderService {
    @Resource
    private OrderMapper orderMapper;

    @Override
    public String getShouQianByDate(int status, int type) {
        return orderMapper.getShouQianByDate(status,type);
    }
}
