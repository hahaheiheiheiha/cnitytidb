package cn.project.springbootfunction.Area.service;

import cn.project.springbootcurrency.mapper.AreaMapper;
import cn.project.springbootcurrency.pojo.Area;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {
    @Resource
    private AreaMapper areaMapper;
    @Override
    public List<Area> getAreaListByParent(int parentId) {
        return areaMapper.getAreaListByParent(parentId);
    }
}
