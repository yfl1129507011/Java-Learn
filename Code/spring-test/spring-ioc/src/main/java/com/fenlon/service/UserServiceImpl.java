package com.fenlon.service;

import com.fenlon.mapper.UserDao;

public class UserServiceImpl implements UserService{
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void getUser() {
        this.userDao.getUser();
    }
}
