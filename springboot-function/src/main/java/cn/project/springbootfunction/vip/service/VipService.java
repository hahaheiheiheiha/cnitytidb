package cn.project.springbootfunction.vip.service;

import cn.project.springbootcurrency.pojo.Vip;
import cn.project.springbootcurrency.vo.VipPatientListVo;
import cn.project.springbootcurrency.vo.VipPatientVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VipService {
    public Vip getVipByP_id(@Param("p_id") int p_id);
    public List<VipPatientListVo> getVipPatientListVoByVipPatientVo(VipPatientVo vipPatientVo);
    public List<Vip> getVipList(@Param("page") int page,@Param("pageSize") int pageSize);
    public int countGetVipPatientListVoByVipPatientVo(VipPatientVo vipPatientVo);
    public int countGetVipList();
}
