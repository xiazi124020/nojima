package com.example.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//@CrossOrigin(origins = "http://localhost:3000") // 允许来自特定域的请求
@CrossOrigin(origins = "*") // 允许来自所有的请求
@RestController
public class ApiController {
    private static final Logger logger = LoggerFactory.getLogger(ApiController.class);

    @GetMapping("/api/hello")
    public String hello() {
        logger.info("This is an information message1.");
        return "Hello from the API!";
    }

    @PostMapping("/api/postData")
    public String postData(@RequestBody String data) {
        return "Received data: " + data;
    }
}
