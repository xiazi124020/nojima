package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private RedisTemplate redisTemplate;
	
	@Test
	void set() {
		ValueOperations ops = redisTemplate.opsForValue();
		ops.set("age", 41);
	}

	@Test
	void get() {
		ValueOperations ops = redisTemplate.opsForValue();
		Object age = ops.get("age");
		System.out.println(age);
	}

}
