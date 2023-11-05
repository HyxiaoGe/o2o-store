package com.hyxiao.o2ostore;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@MapperScan("com.hyxiao.o2ostore.mapper")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class O2oStoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(O2oStoreApplication.class, args);
    }

}
