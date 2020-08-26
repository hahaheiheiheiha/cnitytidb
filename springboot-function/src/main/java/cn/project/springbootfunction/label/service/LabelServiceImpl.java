package cn.project.springbootfunction.label.service;

import cn.project.springbootcurrency.mapper.LabelMapper;
import cn.project.springbootcurrency.pojo.Label;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LabelServiceImpl implements LabelService{
    @Resource
    private LabelMapper labelMapper;

    @Override
    public List<Label> getLabelByParentId(int parentId) {
        return labelMapper.getLabelByParentId(parentId);
    }
}
