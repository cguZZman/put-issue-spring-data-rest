package com.example.demo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import lombok.Data;

@SpringBootApplication
public class PutIssueSpringDataRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(PutIssueSpringDataRestApplication.class, args);
	}
	
}

@Entity @Data 
class Customer {
	@Id @GeneratedValue
	Long id;
	String name;
	@OneToOne(cascade = CascadeType.ALL)
	Info info;
}

@Entity @Data
class Info {
	@Id @GeneratedValue
	Long id;
	String theInfo;
}

@RepositoryRestResource
interface CustomerRepository extends CrudRepository<Customer, Long> {
}
