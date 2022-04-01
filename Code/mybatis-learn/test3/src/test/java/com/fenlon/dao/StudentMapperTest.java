package com.fenlon.dao;

import com.fenlon.pojo.Student;
import com.fenlon.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.List;

public class StudentMapperTest {
    private SqlSession sqlSession;
    private StudentMapper mapper;
    private Logger logger;

    public StudentMapperTest() {
        this.logger = Logger.getLogger(StudentMapperTest.class);
        try {
            this.sqlSession = MyBatisUtils.getSqlSession();
            this.mapper = sqlSession.getMapper(StudentMapper.class);
        } catch (Exception e) {
            this.sqlSession.close();
        }
    }

}
