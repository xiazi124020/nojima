package com.example.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class CacheService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public void addToCache(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public Object getFromCache(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public boolean removeFromCache(String key) {
        return redisTemplate.delete(key);
    }
}
