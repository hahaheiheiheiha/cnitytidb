package cn.project.springbootfunction.family.service;

import cn.project.springbootcurrency.mapper.FamilyMapper;
import cn.project.springbootcurrency.pojo.Family;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class FamilyServiceImpl implements FamilyService {
    @Resource
    private FamilyMapper familyMapper;

    @Override
    public int insertFamily(Family family) {
        return familyMapper.insertFamily(family);
    }
}
