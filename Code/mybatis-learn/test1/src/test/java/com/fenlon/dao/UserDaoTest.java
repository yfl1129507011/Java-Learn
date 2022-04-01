package com.fenlon.dao;

import com.fenlon.pojo.UserData;
import com.fenlon.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoTest {
    private SqlSession sqlSession;
    private UserDao mapper;

    public UserDaoTest() {
        try {
            this.sqlSession = MyBatisUtils.getSqlSession();
            this.mapper = sqlSession.getMapper(UserDao.class);
        } catch (Exception e) {
            this.sqlSession.close();
        }
    }

    @Test
    public void getUserTest() {
        List<UserData> user = this.mapper.getUser();
        for (UserData userData : user) {
            System.out.println(userData);
        }
    }

    @Test
    public void getUserByIdTest() {
        UserData userById = this.mapper.getUserById(2);
        System.out.println(userById);
    }

    @Test
    public void addUserTest() {
        int res = this.mapper.addUser(new UserData("曹操", "111111"));
        System.out.println(res);
        this.sqlSession.commit();
    }

    @Test
    public void updateUserTest() {
        UserData userData = new UserData();
        userData.setId(1);
        userData.setName("魏无忌");
        userData.setPassword("111111");
        int res = this.mapper.updateUser(userData);
        System.out.println(res);
        this.sqlSession.commit();
    }

    @Test
    public void deleteUserTest() {
        int res = this.mapper.deleteUser(2);
        System.out.println(res);
        this.sqlSession.commit();
    }

    @Test
    public void addUserByMapTest() {
        Map<String, Object> map = new HashMap<>();
        map.put("name1", "张无忌");
        map.put("psd1", "121212");
        int res = this.mapper.addUserByMap(map);
        System.out.println(res);
        this.sqlSession.commit();
    }

    @Test
    public void getListByLike() {
        List<UserData> list = this.mapper.getListByLike("无");

        for (UserData userData : list) {
            System.out.println(userData);
        }
    }
}
