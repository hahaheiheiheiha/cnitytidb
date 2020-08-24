package cn.project.springbootcurrency.mapper;

import cn.project.springbootcurrency.pojo.Patient;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
@Mapper
public interface PatientMapper {
    public List<Patient> getPatientList(Map map);
    public int getGuaHaoByDate(@Param("status") int status,@Param("type") int type);

}
