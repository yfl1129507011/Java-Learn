package com.fenlon.dao;

import com.fenlon.pojo.User;
import com.fenlon.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class UserTest {
    private SqlSession sqlSession;
    private UserMapper mapper;

    public UserTest() {
        try {
            this.sqlSession = MyBatisUtils.getSqlSession();
            this.mapper = sqlSession.getMapper(UserMapper.class);
        } catch (Exception e) {
            this.sqlSession.close();
        }
    }


    @Test
    public void getOneTest() {
        User user = this.mapper.getOne(1);
        System.out.println(user);

        /*默认使用一级缓存*/
        User user1 = this.mapper.getOne(1);
        System.out.println(user == user1);
        System.out.println(user1);
    }

    @Test
    public void cache2Test() {
        User user = this.mapper.getOne(3);
        System.out.println(user);
        this.sqlSession.close();

        SqlSession sqlSession1 = MyBatisUtils.getSqlSession();
        UserMapper mapper1 = sqlSession1.getMapper(UserMapper.class);
        User user1 = mapper1.getOne(3);
        System.out.println(user1);
        sqlSession1.close();
    }
}
