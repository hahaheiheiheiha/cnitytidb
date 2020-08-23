package cn.project.springbootcurrency;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"cn.project.springbootcurrency.mapper"})//注解指定包里面所有接口作为Mapper
public class SpringbootCurrencyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootCurrencyApplication.class, args);
    }

}
