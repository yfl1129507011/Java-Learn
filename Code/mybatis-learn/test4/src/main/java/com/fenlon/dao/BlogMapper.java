package com.fenlon.dao;

import com.fenlon.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {

    int add(Blog blog);

    List<Blog> getListIf(Map map);

    List<Blog> getListChoose(Map map);

    int update(Map map);
}
