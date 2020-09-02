package cn.project.springbootcurrency.mapper;

import cn.project.springbootcurrency.pojo.Vip;
import cn.project.springbootcurrency.vo.VipPatientListVo;
import cn.project.springbootcurrency.vo.VipPatientVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface VipMapper {
    public Vip getVipByP_id(@Param("p_id") int p_id);
    public List<VipPatientListVo> getVipPatientListVoByVipPatientVo(VipPatientVo vipPatientVo);
    public List<Vip> getVipList(@Param("page") int page,@Param("pageSize") int pageSize);
}
