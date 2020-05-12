package com.synechron.healthInsurance.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AggregatorPlan {
	@JsonProperty("id")
	@JsonAlias("policyId")
	private long policyId;
	
	@JsonProperty("policyName")
	@JsonAlias("policyName")
	private String policyName;
	
	@JsonProperty("insuranceProviderName")
	@JsonAlias("providerName")
	private String  providerName;
	
	@JsonProperty("coverage")
	@JsonAlias("coveragePerClosure")
	private String coverage;
	
	public long getPolicyId() {
		return policyId;
	}
	public void setPolicyId(long policyId) {
		this.policyId = policyId;
	}
	public String getPolicyName() {
		return policyName;
	}
	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}
	public String getProviderName() {
		return providerName;
	}
	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}
	public String getCoverage() {
		return coverage;
	}
	public void setCoverage(String coverage) {
		this.coverage = coverage;
	}
	
	

}
