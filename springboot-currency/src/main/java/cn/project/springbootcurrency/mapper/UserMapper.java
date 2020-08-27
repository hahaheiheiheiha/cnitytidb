package cn.project.springbootcurrency.mapper;

import cn.project.springbootcurrency.pojo.Register;
import cn.project.springbootcurrency.pojo.User;
import cn.project.springbootcurrency.vo.ResponseData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    /**
     * 登录
     */
    public User login(User user);

    public int updateUserPassword(@Param("id") int id,@Param("password") String password);
    /**
     * 注册
     */
    public int register(Register register);
    /**
     * 修改个人信息
     */
    public int updateUser(User user);
    public int updateRole(User user);
    /**
     * 查询拥有某权限的用户
     */
    public List<User> getUserListByRoleId(@Param("r_id") int roleId);
}
