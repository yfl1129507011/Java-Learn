package com.fenlon.Test2;

public class UserServiceImpl implements UserService{
    @Override
    public void add() {
        System.out.println("增加");
    }

    @Override
    public void edit() {
        System.out.println("修改");
    }

    @Override
    public void delete() {
        System.out.println("删除");
    }

    @Override
    public void query() {
        System.out.println("查询");
    }
}
