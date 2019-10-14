package com.laoli.redisDemo.serviceImpl;

import com.laoli.commons.beans.User;
import com.laoli.redisDemo.dao.UserDao;
import com.laoli.redisDemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    @Cacheable(cacheNames = "users")
    public List<User> getUsers() {
        return  userDao.getUsers();
    }
}
