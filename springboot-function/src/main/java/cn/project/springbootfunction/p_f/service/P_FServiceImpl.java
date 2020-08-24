package cn.project.springbootfunction.p_f.service;

import cn.project.springbootcurrency.mapper.Patient_FamilyMapper;
import cn.project.springbootcurrency.pojo.P_F;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class P_FServiceImpl implements P_FService {
    @Resource
    private Patient_FamilyMapper p_fMapper;
    @Override
    public int addNewPF(P_F p_f) {
        return p_fMapper.addNewPF(p_f);
    }
}
