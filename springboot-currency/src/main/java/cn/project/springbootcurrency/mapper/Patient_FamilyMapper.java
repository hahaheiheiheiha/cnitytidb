package cn.project.springbootcurrency.mapper;

import cn.project.springbootcurrency.pojo.P_F;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Patient_FamilyMapper {
    public int addNewPF(P_F p_f);
}
