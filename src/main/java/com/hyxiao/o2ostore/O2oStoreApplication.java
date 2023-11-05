package com.hyxiao.o2ostore;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hyxiao.o2ostore.mapper")
public class O2oStoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(O2oStoreApplication.class, args);
    }

}
