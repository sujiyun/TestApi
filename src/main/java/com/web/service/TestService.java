package com.web.service;

import com.web.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @Autowired
    static TestMapper testMapper;

    public static String getTime() {
        return testMapper.getTime();
    }
}
