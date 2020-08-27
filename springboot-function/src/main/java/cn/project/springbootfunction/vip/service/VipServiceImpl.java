package cn.project.springbootfunction.vip.service;

import cn.project.springbootcurrency.mapper.VipMapper;
import cn.project.springbootcurrency.pojo.Vip;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class VipServiceImpl implements VipService {
    @Resource
    private VipMapper vipMapper;

    @Override
    public Vip getVipByP_id(int p_id) {
        return vipMapper.getVipByP_id(p_id);
    }
}
