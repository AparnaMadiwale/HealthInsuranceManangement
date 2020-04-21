package com.synechron.healthInsurance;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.synechron.healthInsurance.Repository.PolicyRepository;
import com.synechron.healthInsurance.model.Policy;
import com.synechron.healthInsurance.service.PolicyService;

@RunWith(SpringRunner.class)
@SpringBootTest
class HealthInsuranceManagementApplicationTests {

	@Autowired
	private PolicyService service;
	
	@MockBean
	private PolicyRepository repo;
	
	@Test
	public void getAllPolicyTest() {
		when(repo.findAll()).thenReturn(Stream
				.of(new Policy(1,"1 cr premium","Max Health Insurance",70000.0,7000,"All day care treatments","2 years","80%")).collect(Collectors.toList()));
		assertEquals(1,service.getAllPolicies().size());
		
	}
	
	@Test
	public void savePolicytest() {
		Policy policy = new Policy(1,"1 cr premium","Max Health Insurance",70000.0,7000,"All day care treatments","2 years","80%");
		when(repo.save(policy)).thenReturn(policy);
		assertEquals(policy,service.savepolicy(policy));
	}
	
}
