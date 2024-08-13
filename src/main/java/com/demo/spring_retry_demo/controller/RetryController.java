package com.demo.spring_retry_demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.spring_retry_demo.service.RetryService;

@RequestMapping("/retry")
@Controller
public class RetryController {
	
	private RetryService service;
	
	@GetMapping("retryMethod")
	public void findById() {
		service.findById(1l);
	}
	

}
