package cn.project.springbootfunction.label.service;

import cn.project.springbootcurrency.pojo.Label;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LabelService {
    public List<Label> getLabelByParentId(@Param("parentId") int parentId);
    public Label getLabelById(@Param("id") int id);
}
