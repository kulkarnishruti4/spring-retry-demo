package com.demo.spring_retry_demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import com.demo.spring_retry_demo.entity.RetryEntity;
import com.demo.spring_retry_demo.repository.RetryRepository;

import jakarta.transaction.Transactional;

@Service
public class RetryService {
	
		private RetryRepository repo;
		
		@Retryable(
				value = {Exception.class},
				maxAttempts = 3,
				backoff = @Backoff(delay = 2000)
				)
		@Transactional
		public RetryEntity findById(Long id) {
			
			Optional<RetryEntity> entity = repo.findById(id);
			
			if (entity.isPresent()) {
	            return entity.get();
	        } else {
	            throw new RuntimeException("Entity not found");
	        }
			
		}
		
		@Recover
	    public RetryEntity recover(RuntimeException e, Long id) {
			
	        // Handle the case where retries are exhausted
	        System.out.println("Retries exhausted for id: " + id);
	        
	        return null; // or throw a custom exception
	    }
}
