package com.synechron.healthInsurance.controller;

import java.util.List;

import java.util.Optional;
import com.synechron.healthInsurance.Exception.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.synechron.healthInsurance.Repository.PolicyRepository;
import com.synechron.healthInsurance.model.Policy;
import com.synechron.healthInsurance.service.PolicyService;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1")
@Log4j
public class PolicyController extends GlobalExceptionHandler{

	public static final Logger logger = LoggerFactory.getLogger(PolicyController.class);

	@Autowired
	private PolicyService service;

	@Autowired
	private PolicyRepository repo;

	@PostMapping("/policy")
	public ResponseEntity<?> createPolicy(@RequestBody Policy newPolicy) {
		logger.info("Creating Policy : {}", newPolicy);

		service.savepolicy(newPolicy);

		return new ResponseEntity<>("Policy Added Successfully", HttpStatus.CREATED);
	}

	@GetMapping("/policy")
	public ResponseEntity<List<Policy>> getAllPolicies() {
		
		List<Policy> policies = service.getAllPolicies();
		
		logger.info("Getting Policies :{}");
		if (policies.isEmpty()) {
			throw new NoSuchElementException("No Policies found");
			
		}else
		return new ResponseEntity<List<Policy>>(policies, HttpStatus.OK);

	}
	
	@GetMapping("/policy/{id}")
	public ResponseEntity<Policy> getPolicyById(@PathVariable("id")long id) throws NoSuchElementException{
	   Policy getCurrentPolicy = service.getPolicyById(id);
		return new ResponseEntity<Policy>(getCurrentPolicy,HttpStatus.OK);
	}

	@PutMapping("/policy/{id}")
	public ResponseEntity<Policy> updatePolicy(@RequestBody Policy policy,@PathVariable("id")long id)  {
		
		Policy updated = service.updatePolicy(policy);
		
		return new ResponseEntity<Policy>(updated, HttpStatus.OK);

	}

	@DeleteMapping("/policy/{id}")
	public ResponseEntity<Void> deletepolicyById(@PathVariable("id") long id) throws NoSuchElementException{
		logger.info("Deleting Policy With id {} ", id);
		
		service.deletePolicyByid(id);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);

	}

}

