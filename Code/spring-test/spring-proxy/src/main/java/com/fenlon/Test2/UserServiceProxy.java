package com.fenlon.Test2;

public class UserServiceProxy implements UserService{
    private UserServiceImpl userService;

    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Override
    public void add() {
        log("add");
        userService.add();
    }

    @Override
    public void edit() {
        log("edit");
        userService.edit();
    }

    @Override
    public void delete() {
        log("delete");
        userService.delete();
    }

    @Override
    public void query() {
        log("query");
        userService.query();
    }

    private void log(String msg) {
        System.out.println("[Debug]:" + msg);
    }
}
