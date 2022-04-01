package com.fenlon.mapper;

import com.fenlon.pojo.User;
import com.fenlon.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class UserMapperTest {

    /*private SqlSession sqlSession;
    private UserMapper mapper;

    public UserMapperTest() {
        try {
            this.sqlSession = MybatisUtils.getSqlSession();
            this.mapper = sqlSession.getMapper(UserMapper.class);
        } catch (Exception e) {
            this.sqlSession.close();
        }
    }

    @Test
    public void selectUserTest() {
        List<User> users = this.mapper.selectUser();
        for (User user : users) {
            System.out.println(user);
        }
    }*/

    @Test
    public void springMybatis() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-mapper.xml");
        UserMapper userMapper = context.getBean("userMapper", UserMapper.class);
        List<User> users = userMapper.selectUser();
        for (User user : users) {
            System.out.println(user);
        }
    }
}
