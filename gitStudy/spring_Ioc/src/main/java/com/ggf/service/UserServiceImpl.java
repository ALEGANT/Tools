package com.ggf.service;

import com.ggf.dao.UserDao;

public class UserServiceImpl implements UserService{

    private UserDao userDao;

    @Override
    public String getUser() {
        return userDao.getUser();
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
