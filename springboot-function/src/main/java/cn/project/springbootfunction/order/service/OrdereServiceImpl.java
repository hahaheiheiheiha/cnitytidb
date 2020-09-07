package cn.project.springbootfunction.order.service;

import cn.project.springbootcurrency.mapper.OrderMapper;
import cn.project.springbootcurrency.pojo.Order;
import cn.project.springbootcurrency.vo.OrderListVo;
import cn.project.springbootcurrency.vo.OrderListsVo;
import cn.project.springbootcurrency.vo.OrderVo;
import cn.project.springbootcurrency.vo.OrdersVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrdereServiceImpl implements OrderService {
    @Resource
    private OrderMapper orderMapper;

    @Override
    public String getShouQianByDate(int status, int type) {
        return orderMapper.getShouQianByDate(status,type);
    }

    @Override
    public int addOrderByPatient(Order order) {
        return orderMapper.addOrderByPatient(order);
    }

    @Override
    public List<OrderListVo> getOrderListByOrderVo(OrderVo orderVo) {
        return orderMapper.getOrderListByOrderVo(orderVo);
    }

    @Override
    public List<OrderListsVo> getOrderListsVo(OrdersVo ordersVo) {
        return orderMapper.getOrderListsVo(ordersVo);
    }

    @Override
    public int countGetOrderListByOrderVo(OrderVo orderVo) {
        return orderMapper.countGetOrderListByOrderVo(orderVo);
    }

    @Override
    public int countGetOrderListsVo(OrdersVo ordersVo) {
        return orderMapper.countGetOrderListsVo(ordersVo);
    }


}
