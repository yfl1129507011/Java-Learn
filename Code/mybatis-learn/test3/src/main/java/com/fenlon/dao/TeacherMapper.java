package com.fenlon.dao;

import com.fenlon.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TeacherMapper {

    Teacher getOne(@Param("tid") int id);

    Teacher getOne2(@Param("tid") int id);
}
