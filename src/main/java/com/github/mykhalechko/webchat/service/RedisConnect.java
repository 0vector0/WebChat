package com.github.mykhalechko.webchat.service;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;

@Component
public class RedisConnect {

    @Resource
    private Environment env;

//    private Jedis jedis = new Jedis(env.getRequiredProperty("redis.url"));
    private Jedis jedis = new Jedis("localhost");

    public Jedis getJedis() {
        return jedis;
    }
}
