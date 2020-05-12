package com.synechron.healthInsurance.Controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.synechron.healthInsurance.Service.ProviderListService;
import com.synechron.healthInsurance.model.AggregatorPlan;
import com.synechron.healthInsurance.model.ProviderList;

@RestController
@RequestMapping("/api/v1")
public class ProviderListController {

	@Autowired
	private ProviderListService service;

	private static RestTemplate restTemplate;

	private static final Logger lo = LoggerFactory.logger(ProviderListController.class);

	@GetMapping("/providerList")
	public List<AggregatorPlan> getAllProviderList() throws Exception {

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		restTemplate = new RestTemplate();

		String url = null;

		List<Object> finalresp = new ArrayList<>();
		List<Object> finalList = new ArrayList<>();

		List<AggregatorPlan> commonEntity = new ArrayList<AggregatorPlan>();

		AggregatorPlan aggPlan = null;

		for (ProviderList list : service.getAllProviders()) {
			url = list.getProviderUrl();

			lo.info("===========URLS==============" + list.getProviderUrl());

			ObjectMapper mapper = new ObjectMapper();

			String outputJson = "";
			lo.info("ENTIYYYY ::::::::: " + entity.toString());

			ResponseEntity<Object> respEntity = restTemplate.exchange(url, HttpMethod.GET, entity, Object.class);

			if (respEntity != null) {
				lo.info("respEntity.getBody ====" + respEntity.getBody());
			}

			finalresp = (List<Object>) respEntity.getBody();

			if (finalresp.size() > 0) {

				// finalList.addAll(finalresp);

				for (Object object : finalresp) {

					try {
						outputJson = mapper.writeValueAsString(object);
						lo.info("outputJson :: " + outputJson);
						aggPlan = mapper.readValue(outputJson, AggregatorPlan.class);

						lo.info("Policy Id is :: " + aggPlan.getPolicyId());
						lo.info("common data from mapper.read :: " + aggPlan);

						if (aggPlan != null) {
							commonEntity.add(aggPlan);
						}

					} catch (Exception e) {

					}

				}

			}
		}
		return commonEntity;

	}

	@PostMapping("/providerList")
	public ProviderList createProvider(@RequestBody ProviderList providerList) {
		return service.createProvider(providerList);
	}

}
