package com.web.controller;

import com.web.domain.User;
import com.web.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping(value="/user", method = RequestMethod.GET)
public class UserController {

    final Logger L = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserService userService;

    @GetMapping(value = {"", "/list"})
    public List<User> getUserList(@RequestParam(value = "agent", required = false) String agent, @RequestParam(value = "svcid", required = false) String svcid) throws Exception {

        if ("".equals(agent)) return null;
        else if ("".equals(svcid)) return null;

        return userService.findUserList();
    }

    @GetMapping(value = {"/list2"})
    public ResponseEntity getUserList2() throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        result.put("data", userService.findUserList());
        result.put("errcode", "100");

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = {"/cnt"})
    public ResponseEntity getUserCount() throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        result.put("data", userService.findUserCount());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping(value = {"/info"})
    @ResponseBody
    public String getUserLoginId(@RequestBody String id) throws Exception {
        return userService.getUserLoginId(id);
    }

    @PostMapping(value = {"/register"})
    public ResponseEntity userRegister(@RequestBody User user) throws Exception {
        User user2 =  userService.getUserByLoginId(user.getLogin_id());

        HashMap<String, Object> result = new HashMap<>();

        if(user2 != null) {
            result.put("errcode", "200");
            result.put("errmsg", "아이디 중복");
        } else {
            String id = "U" + System.currentTimeMillis() * 1000 + (new Random()).nextInt(999);
            user.setId(id);

            userService.userRegister(user);

            result.put("errcode", "100");
            result.put("errmsg", "");
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping(value = {"/login"})
    public ResponseEntity login(@RequestBody User user) {
        User user2 = userService.getUser(user.getLogin_id(), user.getPassword());

        HashMap<String, Object> result = new HashMap<>();
        if(user2 == null) {
            result.put("errcode", "200");
            result.put("errmsg", "등록되지 않은 회원");
        } else {
            result.put("errcode", "100");
            result.put("errmsg", "");
            result.put("user_id", user2.getId());
            result.put("user_loginId", user2.getLogin_id());
            result.put("user_name", user2.getName());
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}

