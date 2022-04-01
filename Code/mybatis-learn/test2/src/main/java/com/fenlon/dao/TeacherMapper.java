package com.fenlon.dao;

import com.fenlon.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TeacherMapper {

    @Select("select * from teacher")
    List<Teacher> getList();

    @Select("select * from teacher where id = #{tid}")
    Teacher getOne(@Param("tid") int id);
}
