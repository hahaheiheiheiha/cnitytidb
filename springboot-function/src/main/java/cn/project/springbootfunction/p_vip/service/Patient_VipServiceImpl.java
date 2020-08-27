package cn.project.springbootfunction.p_vip.service;

import cn.project.springbootcurrency.mapper.Patient_VipMapper;
import cn.project.springbootcurrency.pojo.Patient_Vip;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class Patient_VipServiceImpl implements Patient_VipService{
    @Resource
    private Patient_VipMapper patient_vipMapper;
    @Override
    public int getCountUserVipByDate(int type) {
        return patient_vipMapper.getCountUserVipByDate(type);
    }

    @Override
    public int addPatientByPatient_id(Patient_Vip patient_vip) {
        return patient_vipMapper.addPatientByPatient_id(patient_vip);
    }
}
