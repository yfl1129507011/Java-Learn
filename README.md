# Java-Learn

# Java开发环境搭建笔记
### 下载Java JDK(Java Development Kit)
- JDK安装包被集成在Java SE中，因此下载Java SE即可
- 官网下载地址：https://www.oracle.com/java/technologies/downloads/
- https://www.oracle.com/java/technologies/javase/javase8u211-later-archive-downloads.html
- 双击下载后的jdk-17_windows-x64_bin.exe的可执行文件，进行安装流程
- 安装成功后，进入安装目录下 D:\Program Files\Java\jdk-17.0.2


### 配置环境变量
- windows键+r，输入`sysdm.cpl` 打开系统属性窗口，选择`高级`->`环境变量`
- 在`系统变量`中添加`JAVA_HOME`变量名，值为Java安装目录：D:\Program Files\Java\jdk-17.0.2
- 在`Path`变量中添加 `％JAVA__HOME%\bin`

### 编译和运行Java例子程序
```java
// Hello.java
public class Hello {
    public static void main(String[] args) {
        System.out.println("hello world!");
    }
}
```
- 编译
```
E:\Learn\Java\Code> javac .\Hello.java
```
- 运行
```
E:\Learn\Java\Code> java Hello
```


## 配置Maven项目管理工具
- 官网下载bin包：https://maven.apache.org/download.cgi  并解压
- 配置环境变量： MAVEN_HOME = D:\Program Files\Maven\apache-maven-3.8.4
- 打开配置文件：D:\Program Files\Maven\apache-maven-3.8.4\conf\settings.xml
```
# 配置阿里镜像
<mirror>
    <id>nexus-aliyun</id>
    <mirrorOf>central</mirrorOf>
    <name>Nexus aliyun</name>
    <url>http://maven.aliyun.com/nexus/content/groups/public</url>
</mirror>

# 配置本地仓库
1. 新建文件D:\Program Files\Maven\apache-maven-3.8.4\maven-repo
2. 在配置文件中添加如下配置信息
<localRepository>D:\Program Files\Maven\apache-maven-3.8.4\maven-repo</localRepository>
```


## 通过IDEA使用Maven创建JavaWeb（Servlet）项目例子
#### 新建一个空的maven项目
- 依次选择 `File`->`New`->`Project` 弹出新建项目窗口
- 选择 `Maven` -> Next -> 填写项目名称和GAV信息 -> Finish
- 打开pom.xml配置文件，添加如下信息：
```
<!-- https://mvnrepository.com/artifact/jakarta.servlet/jakarta.servlet-api -->
<dependency>
    <groupId>jakarta.servlet</groupId>
    <artifactId>jakarta.servlet-api</artifactId>
    <version>5.0.0</version>
    <scope>provided</scope>
</dependency>

<!-- https://mvnrepository.com/artifact/jakarta.servlet.jsp/jakarta.servlet.jsp-api -->
<dependency>
    <groupId>jakarta.servlet.jsp</groupId>
    <artifactId>jakarta.servlet.jsp-api</artifactId>
    <version>3.0.0</version>
    <scope>provided</scope>
</dependency>


<!-- https://mvnrepository.com/artifact/javax.servlet.jsp.jstl/jstl-api -->
<dependency>
    <groupId>javax.servlet.jsp.jstl</groupId>
    <artifactId>jstl-api</artifactId>
    <version>1.2</version>
</dependency>
<!-- https://mvnrepository.com/artifact/taglibs/standard -->
<dependency>
    <groupId>taglibs</groupId>
    <artifactId>standard</artifactId>
    <version>1.1.2</version>
</dependency>
```

#### 打开IDEA项目后，删除src目录，然后新建Maven模块。
- 右键项目名称，`New`->`Module` 弹出新建模块窗口
- 选择 `Maven`, 选中`Create from archetype` -> `maven-archetype-webapp` -> `Next` -> 填写模块信息 -> 选择maven信息 -> `Finish`
- 在模块名下的src/main目录下，新建java和resources目录
- 在java目录下新建com.fenlon.servlet目录，并在新建目录下建立HelloWorld的java类文件，内容如下：
```
package com.fenlon.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.print("hello servlet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

```

- 配置模块的web配置文件，模块名/src/webapp/WEB-INF/web.xml，内容如下：
```
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="https://jakarta.ee/xml/ns/jakartaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="https://jakarta.ee/xml/ns/jakartaee
                      https://jakarta.ee/xml/ns/jakartaee/web-app_5_0.xsd"
         version="5.0"
         metadata-complete="true">
  <display-name>Archetype Created Web Application</display-name>
  <servlet>
    <servlet-name>hello</servlet-name>
    <servlet-class>com.fenlon.servlet.HelloServlet</servlet-class>
  </servlet>
  <servlet-mapping>
    <servlet-name>hello</servlet-name>
    <url-pattern>/h</url-pattern>
  </servlet-mapping>
</web-app>

```

#### 给IDEA配置tomcat启动信息，打开Run/Debug Configurations窗口，新建tomcat配置文件，并填写配置信息



# MyBatis学习笔记
### 官方文档
- https://mybatis.org/mybatis-3/zh/getting-started.html


### 搭建Mybatis开发环境
**1. 搭建数据库例子**
```
create database `mybatis`;

use `mybatis`;

CREATE TABLE `user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL DEFAULT '' COMMENT '用户名',
  `password` varchar(32) NOT NULL DEFAULT '' COMMENT '密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

insert into `user` (`name`, `password`) values 
('张三', '123456'),
('李四', '123456'),
('王五', '123456')
```

**2. 使用IDEA新建一个空的maven项目`mybatis-learn`**
    a. 删除src目录
    b. 新建一个模块`test1`


**3. 导入maven依赖**
```
<dependencies>
    <!--mysql驱动依赖-->
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>8.0.28</version>
    </dependency>
    <dependency>
        <groupId>org.mybatis</groupId>
        <artifactId>mybatis</artifactId>
        <version>3.5.2</version>
    </dependency>
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.11</version>
        <scope>test</scope>
    </dependency>
</dependencies>
```

**4. 创建配置文件**
```
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <environments default="development">
        <environment id="development">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <property name="driver" value="com.mysql.cj.jdbc.Driver"/>
                <property name="url" value="jdbc:mysql://10.168.1.169:3306/mybatis?useSSL=true&amp;useUnicode=true&amp;characterEncoding=UTF-8"/>
                <property name="username" value="root"/>
                <property name="password" value="123456"/>
            </dataSource>
        </environment>
    </environments>
</configuration>
```

**5. 编写mybatis工具类**
```
package com.fenlon.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtils {
    private static SqlSessionFactory sqlSessionFactory;
    static {
        try {
            String resource = "mybatis-config.xml";
            InputStream resourceAsStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSession getSqlSession() {
        return sqlSessionFactory.openSession();
    }
}

```

**6. 编写实体类**
```
package com.fenlon.pojo;

public class UserData {
    private int id;
    private String name;
    private String password;

    public UserData() {
    }

    public UserData(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

```

**7. 编写Dao接口**
```
package com.fenlon.dao;

import com.fenlon.pojo.UserData;

import java.util.List;

public interface UserDao {
    List<UserData> getUser();
}

```

**8. 编写sql映射配置文件UserMapper.xml， 用于实现Dao接口**
```
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<!--namespace的值要和Dao中接口的包名一致-->
<mapper namespace="com.fenlon.dao.UserDao">
    <!--
        id对应namespace的方法名
        resultType表示sql语句执行的返回值
    -->
    <select id="getUser" resultType="com.fenlon.pojo.UserData">
        select * from mybatis.user
    </select>
</mapper>
```

9. 测试
```
package com.fenlon.dao;

import com.fenlon.pojo.UserData;
import com.fenlon.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {
    @Test
    public void test() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        try {
            UserDao mapper = sqlSession.getMapper(UserDao.class);
            List<UserData> user = mapper.getUser();
            for (UserData userData : user) {
                System.out.println(userData);
            }
        } catch (Exception e) {
            sqlSession.close();
        }
    }
}

```

10. 问题解决
    a. 问题1：org.apache.ibatis.binding.BindingException: Type interface com.fenlon.dao.UserDao is not known to the MapperRegistry
```
# 解决方式 在mybatis-config.xml配置文件中加入如下配置
<!--每一个mapper.xml都需要在配置文件中注册-->
<mappers>
    <mapper resource="com/fenlon/dao/UserMapper.xml"/>
</mappers>
```
    b. 问题2：The error may exist in com/fenlon/dao/UserMapper.xml
```
# 刷新maven
<!--maven静态资源过滤-->
<build>
    <resources>
        <resource>
            <directory>src/main/java</directory>
            <includes>
                <include>**/*.xml</include>
            </includes>
            <filtering>true</filtering>
        </resource>
    </resources>
</build>
```

### mybatis增删改查实例
```
# UserDao.java

package com.fenlon.dao;

import com.fenlon.pojo.UserData;

import java.util.List;

public interface UserDao {
    List<UserData> getUser();

    UserData getUserById(int id);

    int addUser(UserData user);

    int updateUser(UserData user);

    int deleteUser(int id);
}

# UserMapper.xml

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.fenlon.dao.UserDao">
    <select id="getUser" resultType="com.fenlon.pojo.UserData">
        select * from mybatis.user
    </select>
    <select id="getUserById" parameterType="int" resultType="com.fenlon.pojo.UserData">
        select * from mybatis.user where id = #{id};
    </select>

    <insert id="addUser" parameterType="com.fenlon.pojo.UserData">
        insert into mybatis.user (name, password) values (#{name}, #{password})
    </insert>

    <update id="updateUser" parameterType="com.fenlon.pojo.UserData">
        update mybatis.user set name = #{name}, password = #{password} where id = #{id}
    </update>

    <delete id="deleteUser" parameterType="int">
        delete from mybatis.user where id = #{id}
    </delete>
</mapper>

# UserDaoTest.java

package com.fenlon.dao;

import com.fenlon.pojo.UserData;
import com.fenlon.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {
    private SqlSession sqlSession;
    private UserDao mapper;

    public UserDaoTest() {
        try {
            this.sqlSession = MyBatisUtils.getSqlSession();
            this.mapper = sqlSession.getMapper(UserDao.class);
        } catch (Exception e) {
            this.sqlSession.close();
        }
    }

    @Test
    public void getUserTest() {
        List<UserData> user = this.mapper.getUser();
        for (UserData userData : user) {
            System.out.println(userData);
        }
    }

    @Test
    public void getUserByIdTest() {
        UserData userById = this.mapper.getUserById(2);
        System.out.println(userById);
    }

    @Test
    public void addUserTest() {
        int res = this.mapper.addUser(new UserData("曹操", "111111"));
        System.out.println(res);
        this.sqlSession.commit();
    }

    @Test
    public void updateUserTest() {
        UserData userData = new UserData();
        userData.setId(1);
        userData.setName("魏无忌");
        userData.setPassword("111111");
        int res = this.mapper.updateUser(userData);
        System.out.println(res);
        this.sqlSession.commit();
    }

    @Test
    public void deleteUserTest() {
        int res = this.mapper.deleteUser(2);
        System.out.println(res);
        this.sqlSession.commit();
    }
}

```


# Spring简介
### 简介
- 2002年首次推出Spring框架的雏形：interface21框架

### 官网
- https://spring.io/projects/spring-framework#overview

### 官方下载地址
- https://repo.spring.io/ui/native/release/org/springframework/spring/

### GitHub
- https://github.com/spring-projects/spring-framework

### maven仓库
- https://mvnrepository.com/
```
# spring-webmvc
<!-- https://mvnrepository.com/artifact/org.springframework/spring-webmvc -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-webmvc</artifactId>
    <version>5.2.19.RELEASE</version>
</dependency>

# spring-jdbc
<!-- https://mvnrepository.com/artifact/org.springframework/spring-webmvc -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-jdbc</artifactId>
    <version>5.2.19.RELEASE</version>
</dependency>

```

### 特点
- Spring是一个开源的免费框架（容器）
- Spring是一个轻量级的、非入侵式的框架
- 支持控制反转（IOC）、面向切面编程（AOP）
- 支持事务处理，对框架整合支持


### 编写一个spring实例
> Spring 文档：https://docs.spring.io/spring-framework/docs/5.3.2/reference/html/core.html#spring-core

1. 设置bean配置文件
```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
   http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="hello" class="com.fenlon.pojo.Hello">
        <property name="str" value="Spring"/>
    </bean>
</beans>
```

2. 编写类文件
```
package com.fenlon.pojo;

public class Hello {
    private String str;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return "Hello{" +
                "str='" + str + '\'' +
                '}';
    }
}

```

3. 执行测试用例
```
import com.fenlon.pojo.Hello;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Hello hello = (Hello) context.getBean("hello");
        System.out.println(hello.toString());
    }
}

```

### Spring注解开发
##### 准备工作
1. 导入spring-aop包
2. 导入context约束，增加注解的支持
```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
            http://www.springframework.org/schema/beans/spring-beans.xsd
            http://www.springframework.org/schema/context
            https://www.springframework.org/schema/context/spring-context.xsd">

    <!--指定要扫描的包, 这个包下的注解就会生效-->
    <context:component-scan base-package="com.fenlon"/>
    <!--开启注解配置-->
    <context:annotation-config/>



</beans>
```
