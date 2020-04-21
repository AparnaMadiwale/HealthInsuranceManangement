package com.synechron.healthInsurance.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.Data;

@Entity
@Data
@Table(name = "policy")
public class Policy {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "policy_name")
	private String policyName;
	
	@Column(name ="insurance_provider_name")
	private String insuranceProviderName;
	

	private double sum;
	
	@Column(name="total_premium")
	private int totalPremium;
	
	@Column(name ="features")
	private String features;
	
	private String coverage;
	
	private String claim;
	
	

	public Policy(long id, String policyName, String insuranceProviderName, double sum, int totalPremium,
			String features, String coverage, String claim) {
		super();
		this.id = id;
		this.policyName = policyName;
		this.insuranceProviderName = insuranceProviderName;
		this.sum = sum;
		this.totalPremium = totalPremium;
		this.features = features;
		this.coverage = coverage;
		this.claim = claim;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPolicyName() {
		return policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	public String getInsuranceProviderName() {
		return insuranceProviderName;
	}

	public void setInsuranceProviderName(String insuranceProviderName) {
		this.insuranceProviderName = insuranceProviderName;
	}

	public double getSum() {
		return sum;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}

	public int getTotalPremium() {
		return totalPremium;
	}

	public void setTotalPremium(int totalPremium) {
		this.totalPremium = totalPremium;
	}

	public String getFeatures() {
		return features;
	}

	public void setFeatures(String features) {
		this.features = features;
	}

	public String getCoverage() {
		return coverage;
	}

	public void setCoverage(String coverage) {
		this.coverage = coverage;
	}

	public String getClaim() {
		return claim;
	}

	public void setClaim(String claim) {
		this.claim = claim;
	}

	@Override
	public String toString() {
		return "Policy [id=" + id + ", policyName=" + policyName + ", insuranceProviderName=" + insuranceProviderName
				+ ", sum=" + sum + ", totalPremium=" + totalPremium + ", features=" + features + ", coverage="
				+ coverage + ", claim=" + claim + "]";
	}

	
	
	
	

}
