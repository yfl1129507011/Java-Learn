package com.fenlon.dao;

import com.fenlon.pojo.UserData;

import java.util.List;
import java.util.Map;

public interface UserDao {
    List<UserData> getUser();

    UserData getUserById(int id);

    int addUser(UserData user);

    int addUserByMap(Map<String, Object> map);

    int updateUser(UserData user);

    int deleteUser(int id);

    List<UserData> getListByLike(String name);
}
