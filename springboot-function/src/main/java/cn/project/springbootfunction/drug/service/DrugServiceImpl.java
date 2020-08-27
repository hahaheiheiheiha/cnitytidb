package cn.project.springbootfunction.drug.service;

import cn.project.springbootcurrency.mapper.DrugMapper;
import cn.project.springbootcurrency.pojo.Drug;
import cn.project.springbootcurrency.pojo.Label;
import cn.project.springbootcurrency.pojo.Patient;
import cn.project.springbootcurrency.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
}
