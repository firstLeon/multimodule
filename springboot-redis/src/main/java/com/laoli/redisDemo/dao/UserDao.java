package com.laoli.redisDemo.dao;

import com.laoli.commons.beans.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {

    List<User> getUsers();
}
