package cn.project.springbootcurrency.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderMapper {
    public String getShouQianByDate(@Param("status") int status, @Param("type") int type);
}
