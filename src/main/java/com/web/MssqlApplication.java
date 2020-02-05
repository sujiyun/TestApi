package com.web;

import com.web.mapper.TestMapper;
import com.web.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MssqlApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(MssqlApplication.class, args);
    }

    @Autowired
    TestMapper testMapper;

    @Autowired
    UserMapper userMapper;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("현재시간:" + testMapper.getTime());
        //System.out.println("User:" + userMapper.findUserList().toString());
    }

}
