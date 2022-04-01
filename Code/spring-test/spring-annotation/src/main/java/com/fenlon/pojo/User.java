package com.fenlon.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// 等价于 <bean id="user" class="com.fenlon.pojo.User"/>
@Component
public class User {

    public String name;

    // 相当于 <property name="name" value="fenlon" />
    @Value("fenlon")
    public void setName(String name) {
        this.name = name;
    }
}
