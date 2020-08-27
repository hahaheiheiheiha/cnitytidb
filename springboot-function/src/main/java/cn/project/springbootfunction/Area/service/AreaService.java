package cn.project.springbootfunction.Area.service;

import cn.project.springbootcurrency.pojo.Area;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AreaService {
    public List<Area> getAreaListByParent(@Param("parentId") int parentId);
}
