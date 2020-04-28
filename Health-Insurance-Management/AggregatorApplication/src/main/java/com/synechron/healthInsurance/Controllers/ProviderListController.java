package com.synechron.healthInsurance.Controllers;

import java.util.Arrays;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.synechron.healthInsurance.Service.ProviderListService;
import com.synechron.healthInsurance.model.ProviderList;

@RestController
@RequestMapping("api/v1")
public class ProviderListController {
	@Autowired
	private ProviderListService service;
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	private static final Logger lo = LoggerFactory.logger(ProviderListController.class);
	
	@GetMapping("/providerList")
	public JSONArray getAllProviderList() {
		
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		restTemplate = new RestTemplate();
		
		String url = null;
		JSONArray array = null;
		
		for(ProviderList urls : service.getAllProviders()) {
			lo.info("===========URLS=============="+urls.getProviderUrl());
			
			url = urls.getProviderUrl();
			array = restTemplate.exchange(url, HttpMethod.GET,entity,JSONArray.class).getBody();
		}
		return array;
	
		
	}
	
	@PostMapping("/providerList")
	public ProviderList createProvider(@RequestBody ProviderList providerList) {
		return service.createProvider(providerList);
	}

}
