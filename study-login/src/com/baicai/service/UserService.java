package com.baicai.service;

import com.baicai.dao.UserDao;
import com.baicai.pojo.User;

public class UserService {

    public User login(User user) {
        UserDao userDao = new UserDao();
        return userDao.queryUser(user);
    }
}
