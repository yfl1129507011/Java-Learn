package com.fenlon.dao;

import com.fenlon.pojo.Student;
import com.fenlon.pojo.UserData;
import com.fenlon.utils.MyBatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
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

    @Test
    public void getListTest() {
        List<Student> list = this.mapper.getList();
        for (Student student : list) {
            System.out.println(student);
        }
    }

    @Test
    public void getList2Test() {
        List<Student> list = this.mapper.getList2();
        for (Student student : list) {
            System.out.println(student);
        }
    }
}
