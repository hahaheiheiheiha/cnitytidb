package cn.project.springbootcurrency.mapper;

import cn.project.springbootcurrency.pojo.Patient;
import cn.project.springbootcurrency.vo.PatientListVO;
import cn.project.springbootcurrency.vo.PatientVO;
import cn.project.springbootcurrency.vo.PatientsVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
@Mapper
public interface PatientMapper {
    public List<Patient> getPatientList(Map map);
    public int getGuaHaoByDate(@Param("status") int status,@Param("type") int type);
    public Patient getPatientById(@Param("id") int id);
    public Patient getPatientOrderById(@Param("id") int id);
    public int addPatient(PatientVO patient);

    /**
     * 查询数据库中是否有该公民
     * @param identity
     * @return
     */
    public int getPatientByIdentity(@Param("identity") String identity);

    public int updatePatientVipByV_Id(@Param("v_id")int v_id,@Param("id") int id);

    public List<PatientListVO> getPatientListVoByPatientsVo(PatientsVO patientsVO);
}
