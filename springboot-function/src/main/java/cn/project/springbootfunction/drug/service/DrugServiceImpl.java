package cn.project.springbootfunction.drug.service;

import cn.project.springbootcurrency.mapper.DrugMapper;
import cn.project.springbootcurrency.pojo.Drug;
import cn.project.springbootcurrency.pojo.Label;
import cn.project.springbootcurrency.pojo.Patient;
import cn.project.springbootcurrency.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class DrugServiceImpl implements DrugService{

    @Resource
    private DrugMapper drugMapper;
    @Override
    public List<Drug> getDrugById(int drug_c_w) {
        return drugMapper.getDrugById(drug_c_w);
    }

    @Override
    public List<Label> getLabelByParentId(int parentId) {
        return drugMapper.getLabelByParentId(parentId);
    }

    @Override
    public List<User> getUser_YiSheng() {
        return drugMapper.getUser_YiSheng();
    }

    @Override
    public List<Drug> getDrugByDrug_c_wAndCommon_nameAndPinyincode(int drug_c_w, String common_name, String pinyincode) {
        return drugMapper.getDrugByDrug_c_wAndCommon_nameAndPinyincode(drug_c_w,common_name,pinyincode);
    }

    @Override
    public int insertPrescription(Patient patient) {
        return drugMapper.insertPrescription(patient);
    }

    @Override
    public int insertPrescription_drug(int type, int drug_id, int prescription_id) {
        return drugMapper.insertPrescription_drug(type,drug_id,prescription_id);
    }

    @Override
    public int updateDrugById(int id) {
        return drugMapper.updateDrugById(id);
    }

    @Override
    public Patient getPatientAndVip(int patientId) {
        return drugMapper.getPatientAndVip(patientId);
    }

    @Override
    public List<Patient> getPatient() {
        return drugMapper.getPatient();
    }

    @Override
    public List<Drug> getDrugDescSalesVolumes() {
        return drugMapper.getDrugDescSalesVolumes();
    }

    @Override
    public List<Drug> getDrugByDrug_c_wAndIdAndCommon_name(int drug_c_w, int id, String common_name) {
        return drugMapper.getDrugByDrug_c_wAndIdAndCommon_name(drug_c_w,id,common_name);
    }

    @Override
    public List<User> getUserById() {
        return drugMapper.getUserById();
    }

    @Override
    public List<Drug> getDrug(int drug_c_w, int state, Date CreationTime1, Date CreationTime2, String common_name, String id, String sname, int page, int pageSize) {
        return drugMapper.getDrug(drug_c_w,state,CreationTime1,CreationTime2,common_name,id,sname,page,pageSize);
    }

    @Override
    public int insertDrug(Drug drug) {
        return drugMapper.insertDrug(drug);
    }

    @Override
    public int updateDrug(Drug drug) {
        return drugMapper.updateDrug(drug);
    }

    @Override
    public int updateDrug_state(int id, int state) {
        return drugMapper.updateDrug_state(id,state);
    }
}
