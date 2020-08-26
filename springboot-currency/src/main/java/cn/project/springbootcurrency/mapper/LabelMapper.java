package cn.project.springbootcurrency.mapper;

import cn.project.springbootcurrency.pojo.Label;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LabelMapper {
    public List<Label> getLabelByParentId(@Param("parentId") int parentId);
}
