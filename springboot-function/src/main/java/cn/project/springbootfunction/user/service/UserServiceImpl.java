package cn.project.springbootfunction.user.service;

import cn.project.springbootcurrency.mapper.UserMapper;
import cn.project.springbootcurrency.pojo.Register;
import cn.project.springbootcurrency.pojo.User;
import org.apache.ibatis.annotations.Param;
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

    @Override
    public int updateUserPassword(int id, String password) {
        return userMapper.updateUserPassword(id,password);
    }

    @Override
    public int register(Register register) {
        return userMapper.register(register);
    }
    /**
     * 查看个人信息
     */
    @Override
    public User getUserById(@Param("id") int id){
        return userMapper.getUserById(id);
    }
    @Override
    public String getRole_NameByUser_Id(@Param("userId") int userId){
        return userMapper.getRole_NameByUser_Id(userId);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public int updateRole(User user) {
        return userMapper.updateRole(user);
    }
}
