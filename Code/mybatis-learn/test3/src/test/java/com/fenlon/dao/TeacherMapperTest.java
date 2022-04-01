package com.fenlon.dao;

import com.fenlon.pojo.Teacher;
import com.fenlon.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.List;

public class TeacherMapperTest {
    private SqlSession sqlSession;
    private TeacherMapper mapper;
    private Logger logger;

    public TeacherMapperTest() {
        this.logger = Logger.getLogger(TeacherMapperTest.class);
        try {
            this.sqlSession = MyBatisUtils.getSqlSession();
            this.mapper = (TeacherMapper) sqlSession.getMapper(TeacherMapper.class);
        } catch (Exception e) {
            this.sqlSession.close();
        }
    }

    @Test
    public void getOneTest() {
        Teacher one = this.mapper.getOne(1);
        System.out.println(one);
    }

    @Test
    public void getOneTest2() {
        Teacher one = this.mapper.getOne2(1);
        System.out.println(one);
    }
}
