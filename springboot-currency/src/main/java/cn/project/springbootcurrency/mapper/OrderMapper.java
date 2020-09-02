package cn.project.springbootcurrency.mapper;

import cn.project.springbootcurrency.pojo.Order;
import cn.project.springbootcurrency.vo.OrderListVo;
import cn.project.springbootcurrency.vo.OrderListsVo;
import cn.project.springbootcurrency.vo.OrderVo;
import cn.project.springbootcurrency.vo.OrdersVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderMapper {
    public String getShouQianByDate(@Param("status") int status, @Param("type") int type);
    public int addOrderByPatient(Order order);
    public List<OrderListVo> getOrderListByOrderVo(OrderVo orderVo);
    public List<OrderListsVo> getOrderListsVo(OrdersVo ordersVo);
}
