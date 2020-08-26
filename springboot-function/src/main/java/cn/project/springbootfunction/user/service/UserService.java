package cn.project.springbootfunction.user.service;

import cn.project.springbootcurrency.pojo.Register;
import cn.project.springbootcurrency.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserService {
    /**
     * 登录
     */
    public User login(User user);

    public int updateUserPassword(@Param("id") int id, @Param("password") String password);
    /**
     * 注册
     */
    public int register(Register register);
    /**
     * 查看个人信息
     */
    public User getUserById(@Param("id") int id);
    public String getRole_NameByUser_Id(@Param("userId") int userId);
    /**
     * 修改个人信息
     */
    public int updateUser(User user);
    public int updateRole(User user);
}
