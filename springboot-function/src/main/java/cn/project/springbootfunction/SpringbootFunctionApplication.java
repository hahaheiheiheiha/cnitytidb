package cn.project.springbootfunction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
<<<<<<< HEAD
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages ={"cn.project.springbootfunction","cn.project.springbootcurrency"} )
=======

@SpringBootApplication
>>>>>>> 42fbbac... zhensuo
public class SpringbootFunctionApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootFunctionApplication.class, args);
    }
<<<<<<< HEAD
    /**
     * 1.需要定义一个convert转换消息的对象
     * 2.创建配置信息，加入配置信息：比如是否需要格式化返回的json
     * 3.converter中添加配置信息
     * 4.convert添加到converters当中
     */


=======
>>>>>>> 42fbbac... zhensuo

}
