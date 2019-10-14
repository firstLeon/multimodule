package com.laoli.redisDemo;

import com.laoli.commons.beans.User;
import com.laoli.redisDemo.dao.UserDao;
import com.laoli.redisDemo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RedisApp.class)
public class redisTest {

    @Autowired
    private UserDao userDao;
    @Autowired
    private UserService userService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void getUsers(){
        List<User> users = userDao.getUsers();
        System.out.println(users);
    }

    @Test
    public void test(){
        System.out.println("hello");
    }

    @Test
    public void testRedis(){
        String value = stringRedisTemplate.opsForValue().get("key1");
        System.out.println(value);
    }


}
