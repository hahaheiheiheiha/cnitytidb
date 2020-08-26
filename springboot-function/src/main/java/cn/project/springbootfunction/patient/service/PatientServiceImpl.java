package cn.project.springbootfunction.patient.service;

import cn.project.springbootcurrency.mapper.PatientMapper;
import cn.project.springbootcurrency.pojo.Patient;
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


}
