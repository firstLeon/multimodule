package com.laoli.redisDemo.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.*;
import org.springframework.data.redis.connection.RedisConnectionFactory;

import java.lang.reflect.Method;


@Configuration
public class CacheConfig {


    /**
     * 1.org.springframework.data.redis.cache.CacheKeyPrefix:提供了一个用于创建自定义前缀的挂钩，该自定义前缀在Redis中存储的实际密钥之前。
     *
     */






    /**
     * 自定义缓存key生成策略
     * @return
     */
    @Bean
    public KeyGenerator myKeyGenerator(){
        return new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... params) {
                StringBuffer keys=new StringBuffer();
                keys.append(target.getClass().getName());
                keys.append("-");
                keys.append(method.getName());
                return keys.toString();
            }
        };
    }

    /**
     * 将redis缓存管理器注入到容器方式一
     * @param redisConnectionFactory
     * @return
     */
    @Bean
    @Primary //表示默认采用
    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory){
        RedisCacheManager redisCacheManager=RedisCacheManager.builder(redisConnectionFactory).build();
        return  redisCacheManager;
    }

    /**
     * 将redis缓存管理器注入到容器方式二
     * @param redisConnectionFactory
     * @return
     */
    @Bean
    public CacheManager secondCacheManager(RedisConnectionFactory redisConnectionFactory){
        RedisCacheManager redisCacheManager=RedisCacheManager.create(redisConnectionFactory);
        return  redisCacheManager;
    }


    /**
     * 将redis缓存管理器注入到容器方式三
     * @param redisConnectionFactory
     * @return
     */
    @Bean
    public CacheManager thridCacheManager(RedisConnectionFactory redisConnectionFactory){
        RedisCacheWriter redisCacheWriter=RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory);
        RedisCacheManager redisCacheManager=new RedisCacheManager(redisCacheWriter,RedisCacheConfiguration.defaultCacheConfig());
        return  redisCacheManager;
    }

    /**
     * 自定义redis缓存管理器方式一
     * @param redisConnectionFactory
     * @return
     */
    @Bean
    public  CacheManager sdefCacheManager(RedisConnectionFactory redisConnectionFactory){
        RedisCacheConfiguration redisCacheConfiguration=RedisCacheConfiguration.defaultCacheConfig();
        RedisCacheManager redisCacheManager=RedisCacheManager.builder(redisConnectionFactory)
                .cacheDefaults(redisCacheConfiguration)
                .transactionAware()
                .build();
        return  redisCacheManager;
    }


    public CacheManager sdefSecondCacheManager(RedisConnectionFactory redisConnectionFactory){
        RedisCacheConfiguration redisCacheConfiguration=RedisCacheConfiguration.defaultCacheConfig();
        RedisCacheWriter redisCacheWriter=RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory);
        RedisCacheManager redisCacheManager=new RedisCacheManager(redisCacheWriter,redisCacheConfiguration);
        return  redisCacheManager;
    }


}
