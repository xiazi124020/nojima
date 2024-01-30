package com.example.service;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.example.mapper.UserMapper;
import com.example.model.User;

@Service
public class UserService {

	private final UserMapper userMapper;

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	@Autowired
	public UserService(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	public User getUserById(Long id) {
		// cache key
		String cacheKey = "user:" + id;

		// get user info fron cache
		User user = (User)redisTemplate.opsForValue().get(cacheKey);
		if (user == null) {
			user = userMapper.getUserById(id);
			if (user != null) {
				// save user to cache and set expire time
				redisTemplate.opsForValue().set(cacheKey, user, Duration.ofMinutes(30));
			}
		}

		return user;
	}

	public void insertUser(User user) {
		userMapper.insertUser(user);
	}

	public void updateUser(User user) {
		// first update database than update the cache
		userMapper.updateUser(user);
		// update the cache
		String cacheKey = "user:" + user.getId();
		redisTemplate.opsForValue().set(cacheKey, user, Duration.ofMinutes(30));
	}

	public void deleteUser(Long id) {
		userMapper.deleteUser(id);
	}
}
