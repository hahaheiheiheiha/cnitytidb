package cn.project.springbootfunction.user.service;

import cn.project.springbootcurrency.mapper.UserMapper;
import cn.project.springbootcurrency.pojo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    /**
     * 登录
     */
    @Override//代表重写父类方法
    public User login(User user){
        return userMapper.login(user);
    }
}
