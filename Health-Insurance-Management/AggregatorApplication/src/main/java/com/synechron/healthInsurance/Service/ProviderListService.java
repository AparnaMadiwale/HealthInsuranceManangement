package com.synechron.healthInsurance.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synechron.healthInsurance.Repository.ProviderListRepository;
import com.synechron.healthInsurance.model.ProviderList;

@Service
public class ProviderListService  {
	
	@Autowired
	private ProviderListRepository repo;
	
	
	public List<ProviderList> getAllProviders(){
		return repo.findAll();
	}
	
	
	public ProviderList createProvider(ProviderList providerList) {
		return repo.save(providerList);
	}

}
