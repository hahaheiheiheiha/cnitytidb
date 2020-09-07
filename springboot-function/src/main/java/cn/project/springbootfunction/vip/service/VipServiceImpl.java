package cn.project.springbootfunction.vip.service;

import cn.project.springbootcurrency.mapper.VipMapper;
import cn.project.springbootcurrency.pojo.Vip;
import cn.project.springbootcurrency.vo.VipPatientListVo;
import cn.project.springbootcurrency.vo.VipPatientVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class VipServiceImpl implements VipService {
    @Resource
    private VipMapper vipMapper;

    @Override
    public Vip getVipByP_id(int p_id) {
        return vipMapper.getVipByP_id(p_id);
    }

    @Override
    public List<VipPatientListVo> getVipPatientListVoByVipPatientVo(VipPatientVo vipPatientVo) {
        return vipMapper.getVipPatientListVoByVipPatientVo(vipPatientVo);
    }

    @Override
    public List<Vip> getVipList(int page, int pageSize) {
        return vipMapper.getVipList(page,pageSize);
    }

    @Override
    public int countGetVipPatientListVoByVipPatientVo(VipPatientVo vipPatientVo) {
        return vipMapper.countGetVipPatientListVoByVipPatientVo(vipPatientVo);
    }

    @Override
    public int countGetVipList() {
        return vipMapper.countGetVipList();
    }
}
