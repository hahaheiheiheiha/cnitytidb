package cn.project.springbootfunction.patient.service;

import cn.project.springbootcurrency.pojo.Patient;
import cn.project.springbootcurrency.vo.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


public interface PatientService {
    public List<Patient> getPatientList(Map map);
    public int getGuaHaoByDate(@Param("status") int status, @Param("type") int type);
    public Patient getPatientById(@Param("id") int id);
    public Patient getPatientOrderById(@Param("id") int id);
    public int addPatient(PatientVO patient);
    public int getPatientByIdentity(String identity);
    public int updatePatientVipByV_Id(@Param("v_id")int v_id,@Param("id") int id);
    public List<PatientListVO> getPatientListVoByPatientsVo(PatientsVO patientsVO);
    public List<PatientVipListVo> getPatientVipListVoByPatientVipVo(PatientVipVo patientVipVo);
    public int countGetPatientList(Map map);

    public int countGetPatientListVoByPatientsVo(PatientsVO patientsVO);

    public int countGetPatientVipListVoByPatientVipVo(PatientVipVo patientVipVo);
}
