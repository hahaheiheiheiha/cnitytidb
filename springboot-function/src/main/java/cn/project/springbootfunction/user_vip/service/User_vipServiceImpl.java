package cn.project.springbootfunction.user_vip.service;

import cn.project.springbootcurrency.mapper.User_VipMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class User_vipServiceImpl implements User_VipService {
    @Resource
    private User_VipMapper user_vipMapper;
    @Override
    public int getCountUserVipByDate(int type) {
        return user_vipMapper.getCountUserVipByDate(type);
    }
}
