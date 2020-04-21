package com.synechron.healthInsurance.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synechron.healthInsurance.Exception.NoSuchElementException;
import com.synechron.healthInsurance.Repository.PolicyRepository;
import com.synechron.healthInsurance.model.Policy;

@Service
public class PolicyService {
	
	@Autowired
	private PolicyRepository repo;
	
	public Policy savepolicy(Policy newPolicy) {
		
		return repo.save(newPolicy);
		
	}
	
	public List<Policy> getAllPolicies(){
		return repo.findAll();
	}
	
	
	public Policy getPolicyById(Long id) throws NoSuchElementException{
		Policy policy = null;
		Optional<Policy> newpolicy = repo.findById(id);		
		if(newpolicy.isPresent()) {
			policy = newpolicy.get();
		}else {
			throw new NoSuchElementException("No Policy is available with id:"+id);
		}
		return policy;
	}
	
	
	
	public Policy updatePolicy(Policy policy) {
		
			return repo.save(policy);
	}
	
	
	public void deletePolicyByid(Long id) throws NoSuchElementException{
		Policy policy = null;
		Optional<Policy> newPolicy =  repo.findById(id);
		if(newPolicy.isPresent()) {
			policy = newPolicy.get();
			
		}else {
			throw new NoSuchElementException("No Policy is available "+id);
		}
	    
		 
		 
	}

}
