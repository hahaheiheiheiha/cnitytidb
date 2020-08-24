package cn.project.springbootcurrency.mapper;

import cn.project.springbootcurrency.pojo.User;
import cn.project.springbootcurrency.vo.ResponseData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    /**
     * 登录
     */
    public User login(User user);

    public int updateUserPassword(@Param("id") int id,@Param("password") String password);
}
