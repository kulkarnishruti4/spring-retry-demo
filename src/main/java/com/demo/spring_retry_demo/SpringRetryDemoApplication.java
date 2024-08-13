package com.demo.spring_retry_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
//Enable this annotation for enabling retry mechanism
@EnableRetry
public class SpringRetryDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRetryDemoApplication.class, args);
	}

}
