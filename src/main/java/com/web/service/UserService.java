package com.web.service;

import com.web.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import com.web.mapper.UserMapper;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> findUserList() {
        return userMapper.findUserList();
    }

    public int findUserCount() { return  userMapper.findUserCount(); }

    public String getUserLoginId(String id) { return userMapper.getUserLoginId(id); }

    public User getUserByLoginId(String login_id) { return userMapper.getUserByLoginId(login_id); }

    public User getUser(String login_id, String password) { return userMapper.getUser(login_id, password); }

    public String userRegister(User user) { return userMapper.userRegister(user); }

}
