package com.web.mapper;

import com.web.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

   List<User> findUserList();

   int findUserCount();

   String getUserLoginId(String id);

   User getUserByLoginId(String login_id);

   User getUser(String login_id, String password);

   String userRegister(User user);
}
