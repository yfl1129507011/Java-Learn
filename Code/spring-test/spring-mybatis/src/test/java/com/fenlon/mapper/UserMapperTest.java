package com.fenlon.mapper;

import com.fenlon.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class UserMapperTest {

    @Test
    public void springMybatis() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper userMapper = context.getBean("userMapper", UserMapper.class);
        List<User> users = userMapper.selectUser();
        for (User user : users) {
            System.out.println(user);
        }

        System.out.println("=====整合mybatis方式二======");
        UserMapper userMapper2 = context.getBean("userMapper2", UserMapper.class);
        List<User> users2 = userMapper2.selectUser();
        for (User user : users2) {
            System.out.println(user);
        }
    }
}
