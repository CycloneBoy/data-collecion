package com.cycloneboy.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@ComponentScan(basePackages = "com.cycloneboy")
public class DataCollecionApplication {

	@RequestMapping("/hello123")
	public String hello(){
		return "hello world!";
	}

	@RequestMapping("/h123")
	public String home(){
		return "this is home !";
	}

	public static void main(String[] args) {
		SpringApplication.run(DataCollecionApplication.class, args);
	}
}
