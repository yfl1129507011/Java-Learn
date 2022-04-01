package com.fenlon.dao;

import com.fenlon.pojo.UserData;
import com.fenlon.utils.MyBatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class UserMapperTest {
    private SqlSession sqlSession;
    private UserMapper mapper;
    private Logger logger;

    public UserMapperTest() {
        this.logger = Logger.getLogger(UserMapperTest.class);
        try {
            this.sqlSession = MyBatisUtils.getSqlSession();
            this.mapper = sqlSession.getMapper(UserMapper.class);
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
        UserData userById = this.mapper.getUserById(3);
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
    public void log4jTest() {
        logger.info("info");
        logger.debug("debug");
        logger.error("error");
    }

    @Test
    public void getUserByLimitTest() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("startIndex", 0);
        map.put("pageSize", 3);
        List<UserData> result = this.mapper.getUserByLimit(map);
        for (UserData data : result) {
            System.out.println(data);
        }
    }

    @Test
    public void getUserByRowBoundsTest() {
        RowBounds rowBounds = new RowBounds(1, 3);
        List<UserData> list = this.sqlSession.selectList("com.fenlon.dao.UserMapper.getUserByRowBounds", null, rowBounds);
        for (UserData user : list) {
            System.out.println(user);
        }
        this.sqlSession.close();
    }
}
