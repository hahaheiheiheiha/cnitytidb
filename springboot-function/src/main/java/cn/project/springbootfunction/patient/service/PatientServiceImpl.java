package cn.project.springbootfunction.patient.service;

import cn.project.springbootcurrency.mapper.PatientMapper;
import cn.project.springbootcurrency.pojo.Patient;
import cn.project.springbootcurrency.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
@Service
public class PatientServiceImpl implements PatientService{
    @Resource
    private PatientMapper patientMapper;
    @Override
    public List<Patient> getPatientList(Map map) {
        return patientMapper.getPatientList(map);
    }

    @Override
    public int getGuaHaoByDate(int status, int type) {
        System.out.println(patientMapper.getGuaHaoByDate(status,type));
        return patientMapper.getGuaHaoByDate(status,type);
    }

    @Override
    public Patient getPatientById(int id) {
        return patientMapper.getPatientById(id);
    }

    @Override
    public Patient getPatientOrderById(int id) {
        return patientMapper.getPatientOrderById(id);
    }

    @Override
    public int addPatient(PatientVO patient) {
        return patientMapper.addPatient(patient);
    }

    @Override
    public int getPatientByIdentity(String identity) {
        return patientMapper.getPatientByIdentity(identity);
    }

    @Override
    public int updatePatientVipByV_Id(int v_id, int id) {
        return patientMapper.updatePatientVipByV_Id(v_id,id);
    }

    @Override
    public List<PatientListVO> getPatientListVoByPatientsVo(PatientsVO patientsVO) {
        return patientMapper.getPatientListVoByPatientsVo(patientsVO);
    }

    @Override
    public List<PatientVipListVo> getPatientVipListVoByPatientVipVo(PatientVipVo patientVipVo) {
        return patientMapper.getPatientVipListVoByPatientVipVo(patientVipVo);
    }

    @Override
    public int countGetPatientList(Map map) {
        return patientMapper.countGetPatientList(map);
    }

    @Override
    public int countGetPatientListVoByPatientsVo(PatientsVO patientsVO) {
        return patientMapper.countGetPatientListVoByPatientsVo(patientsVO);
    }

    @Override
    public int countGetPatientVipListVoByPatientVipVo(PatientVipVo patientVipVo) {
        return patientMapper.countGetPatientVipListVoByPatientVipVo(patientVipVo);
    }


}
