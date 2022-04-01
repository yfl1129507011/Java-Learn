package com.fenlon.service;

public class UserServiceImpl implements UserService{
    @Override
    public void add() {
        System.out.println("add");
    }

    @Override
    public void edit() {
        System.out.println("edit");
    }

    @Override
    public void delete() {
        System.out.println("delete");
    }

    @Override
    public void select() {
        System.out.println("select");
    }
}
