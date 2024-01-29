package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import com.example.config.CorsConfig;

@SpringBootApplication
@Import(CorsConfig.class)
@ComponentScan(basePackages = {"com.example.demo", "com.example.controller", "com.example.service"})
@MapperScan("com.example.mapper")
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
