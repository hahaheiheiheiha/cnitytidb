package cn.project.springbootcurrency.mapper;

import cn.project.springbootcurrency.pojo.Patient_Vip;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface Patient_VipMapper {
    public int getCountUserVipByDate(@Param("type")int type);
    public int addPatientByPatient_id(Patient_Vip patient_vip);
}
