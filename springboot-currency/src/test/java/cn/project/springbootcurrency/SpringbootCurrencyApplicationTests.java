package cn.project.springbootcurrency;

import cn.project.springbootcurrency.mapper.UserMapper;
import cn.project.springbootcurrency.pojo.User;
import cn.project.springbootcurrency.vo.MyMD5Util;
import cn.project.springbootcurrency.vo.ResponseData;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SpringbootCurrencyApplicationTests {
    @Resource
    UserMapper userMapper;
    @Test
    public void contextLoads() {
        User user=new User();
        user.setName("admin");
        user.setPassword("123456");
        User user2=userMapper.login(user);
        System.out.println(user2);
    }
    @Test
    public void md5(){
        String password = "123456";
        password = MyMD5Util.MD5(password);
        System.out.println(password);
    }
    @Test
    public void md52(){
        String password = "123456";
        String md5 = "e10adc3949ba59abbe56e057f20f883e";
        Boolean flag = MyMD5Util.verify(password,md5);
        System.out.println(flag);

    }

}
