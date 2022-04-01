package com.fenlon.dao;

import com.fenlon.pojo.Blog;
import com.fenlon.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class BlogMapperTest {
    private SqlSession sqlSession;
    private BlogMapper mapper;

    public BlogMapperTest() {
        try {
            this.sqlSession = MyBatisUtils.getSqlSession();
            this.mapper = this.sqlSession.getMapper(BlogMapper.class);
        } catch (Exception e) {
            this.sqlSession.close();
        }
    }

    @Test
    public void addTest() {
        Blog blog = new Blog();
        blog.setTitle("三国演义");
        blog.setAuthor("罗贯中");
        blog.setViews(1330);
        blog.setCreateTime((int) (System.currentTimeMillis()/1000));
        int res = this.mapper.add(blog);
        System.out.println(res);

        blog.setTitle("西游记");
        blog.setAuthor("吴承恩");
        blog.setViews(1501);
        blog.setCreateTime((int) (System.currentTimeMillis()/1000));
        res = this.mapper.add(blog);
        System.out.println(res);

        blog.setTitle("水浒传");
        blog.setAuthor("施耐庵");
        blog.setViews(1296);
        blog.setCreateTime((int) (System.currentTimeMillis()/1000));
        res = this.mapper.add(blog);
        System.out.println(res);

        blog.setTitle("红楼梦");
        blog.setAuthor("曹雪芹");
        blog.setViews(1715);
        blog.setCreateTime((int) (System.currentTimeMillis()/1000));
        res = this.mapper.add(blog);
        System.out.println(res);

        this.sqlSession.commit();
    }

    @Test
    public void dateTest() {
        System.out.println(System.currentTimeMillis()/1000);
    }

    @Test
    public void getListIfTest() {
        HashMap map = new HashMap();
        map.put("title", "三国演义");
        List<Blog> listIf = this.mapper.getListIf(map);
        for (Blog blog : listIf) {
            System.out.println(blog);
        }
    }

    @Test
    public void getListChooseTest() {
        HashMap map = new HashMap();
        //map.put("title", "三国演义");
        map.put("author", "曹雪芹");
        List<Blog> listIf = this.mapper.getListChoose(map);
        for (Blog blog : listIf) {
            System.out.println(blog);
        }
    }

    @Test
    public void updateTest() {
        HashMap map = new HashMap();
        //map.put("title", "三国演义");
        map.put("author", "fenlon");
        map.put("id", 1);
        int res = this.mapper.update(map);
        System.out.println(res);
        this.sqlSession.commit();
    }
}
