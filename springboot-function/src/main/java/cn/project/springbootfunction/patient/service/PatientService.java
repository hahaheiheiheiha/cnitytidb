package cn.project.springbootfunction.patient.service;

import cn.project.springbootcurrency.pojo.Patient;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


public interface PatientService {
    public List<Patient> getPatientList(Map map);
    public int getGuaHaoByDate(@Param("status") int status, @Param("type") int type);

}
