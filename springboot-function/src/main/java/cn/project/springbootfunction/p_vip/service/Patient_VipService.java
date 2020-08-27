package cn.project.springbootfunction.p_vip.service;

import cn.project.springbootcurrency.pojo.Patient_Vip;
import org.apache.ibatis.annotations.Param;

public interface Patient_VipService {
    public int getCountUserVipByDate(int type);
    public int addPatientByPatient_id(Patient_Vip patient_vip);
}
