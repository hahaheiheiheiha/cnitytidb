package cn.project.springbootcurrency.mapper;

import cn.project.springbootcurrency.pojo.Area;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AreaMapper {
    public List<Area> getAreaListByParent(@Param("parent") int parent);
    public int countGetAreaListByParent(@Param("parent") int parent);
}
