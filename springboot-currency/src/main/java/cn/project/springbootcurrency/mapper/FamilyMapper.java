package cn.project.springbootcurrency.mapper;

import cn.project.springbootcurrency.pojo.Family;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FamilyMapper {
    public int insertFamily(Family family);
}
