package cn.project.springbootfunction.drug.service;

import cn.project.springbootcurrency.pojo.Drug;
import cn.project.springbootcurrency.pojo.Label;
import cn.project.springbootcurrency.pojo.Patient;
import cn.project.springbootcurrency.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DrugService {
    /**
     * 查询所有某药品下的药品
     */
    public List<Drug> getDrugById(@Param("drug_c_w") int drug_c_w);
    /**
     * 查询所有科室和药品所有分类
     */
    public List<Label> getLabelByParentId(@Param("parentId") int parentId);
    /**
     * 查询所有医生
     */
    public List<User> getUser_YiSheng();
    /**
     * 根据药品分类和输入的药品中文或拼音进行查询
     */
    public List<Drug> getDrugByDrug_c_wAndCommon_nameAndPinyincode(@Param("drug_c_w") int drug_c_w,
                                                                   @Param("common_name") String common_name,
                                                                   @Param("pinyincode") String pinyincode);
    /**
     * 保存增加处方
     */
    public int insertPrescription(Patient patient);
    public int insertPrescription_drug(int type,int drug_id,int prescription_id);
}
