package cn.project.springbootcurrency.mapper;

import cn.project.springbootcurrency.pojo.Vip;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface VipMapper {
    public Vip getVipByP_id(@Param("p_id") int p_id);
}
