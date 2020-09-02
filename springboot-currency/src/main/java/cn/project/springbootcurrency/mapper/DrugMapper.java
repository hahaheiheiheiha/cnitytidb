package cn.project.springbootcurrency.mapper;

import cn.project.springbootcurrency.pojo.Drug;
import cn.project.springbootcurrency.pojo.Label;
import cn.project.springbootcurrency.pojo.Patient;
import cn.project.springbootcurrency.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Mapper
public interface DrugMapper {
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
    public int insertPrescription_drug(@Param("type") int type,@Param("drug_id") int drug_id,@Param("prescription_id") int prescription_id);
    //保存药品处方的时候增加药品销售数量
    public int updateDrugById(@Param("id") int id);
    /**
     * 查询患者信息和接诊信息
     */
    public Patient getPatientAndVip(@Param("patientId") int patientId);
    /**
     * 查询出患者信息（有个下拉框）
     */
    public List<Patient> getPatient();
    /**
     * 查询药品销售排行
     */
    public List<Drug> getDrugDescSalesVolumes();
    /**
     * 根据药品类型、输入的药品编码和药品名称进行查询
     */
    public List<Drug> getDrugByDrug_c_wAndIdAndCommon_name(@Param("drug_c_w") int drug_c_w,@Param("id") int id,@Param("common_name") String common_name);
    /**
     * 查询出够权限的操作员只能(管理员、医生、护士、专家)
     */
    public List<User> getUserById();
    /**
     * 查询出所有药品信息(条件查询)
     */
    public List<Drug> getDrug(@Param(value = "drug_c_w") int drug_c_w,
                              @Param(value = "state") int state,
                              @Param(value = "CreationTime1") Date CreationTime1,
                              @Param(value = "CreationTime2") Date CreationTime2,
                              @Param(value = "common_name") String common_name,
                              @Param(value = "id") String id,
                              @Param(value = "sname") String sname,
                              @Param(value = "page") int page,
                              @Param(value = "pageSize") int pageSize);
    /**
     * 增加药品
     */
    public int insertDrug(Drug drug);
    /**
     * 修改药品
     */
    public int updateDrug(Drug drug);
    /**
     * 修改药品状态（停用或者启用）
     */
    public int updateDrug_state(@Param(value = "id") int id,@Param(value = "state") int state);
}
