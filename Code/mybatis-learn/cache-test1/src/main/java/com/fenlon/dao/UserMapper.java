package com.fenlon.dao;

import com.fenlon.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


public interface UserMapper {
    // @Select("select * from user where id = #{id}")
    // 使用注解无法使用二级缓存
    User getOne(@Param("id") int id);
}
