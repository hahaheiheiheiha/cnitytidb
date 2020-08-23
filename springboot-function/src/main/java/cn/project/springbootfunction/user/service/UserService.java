package cn.project.springbootfunction.user.service;

import cn.project.springbootcurrency.pojo.User;

public interface UserService {
    /**
     * 登录
     */
    public User login(User user);
}
