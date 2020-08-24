package cn.project.springbootfunction.user.service;

import cn.project.springbootcurrency.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserService {
    /**
     * 登录
     */
    public User login(User user);

    public int updateUserPassword(@Param("id") int id, @Param("password") String password);
}
