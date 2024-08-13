package com.demo.spring_retry_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.spring_retry_demo.entity.RetryEntity;

@Repository
public interface RetryRepository extends JpaRepository<RetryEntity, Long>{
	
	

}
