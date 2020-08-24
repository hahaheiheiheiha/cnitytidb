package cn.project.springbootcurrency.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface User_VipMapper {
    public int getCountUserVipByDate(@Param("type")int type);
}
