package com.fenlon.dao;

import com.fenlon.pojo.UserData;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<UserData> getUser();

    UserData getUserById(int id);

    int addUser(UserData user);

    int updateUser(UserData user);

    int deleteUser(int id);

    List<UserData> getUserByLimit(Map<String, Integer> map);

    List<UserData> getUserByRowBounds();
}
