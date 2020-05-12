package com.synechron.healthInsurance.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="insurance_provider_list")
public class ProviderList implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="provider_name")
	private String providerName;
	
	@Column(name="provider_url",nullable=false)
	private String providerUrl;
	
	@Column(name="response_type")
	private String responseType;
	
	@Column(name ="response_format")
	private String responseFormat;

	public ProviderList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProviderList(int id, String providerName, String providerUrl, String responseType, String responseFormat) {
		super();
		this.id = id;
		this.providerName = providerName;
		this.providerUrl = providerUrl;
		this.responseType = responseType;
		this.responseFormat = responseFormat;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public String getProviderUrl() {
		return providerUrl;
	}

	public void setProviderUrl(String providerUrl) {
		this.providerUrl = providerUrl;
	}

	public String getResponseType() {
		return responseType;
	}

	public void setResponseType(String responseType) {
		this.responseType = responseType;
	}

	public String getResponseFormat() {
		return responseFormat;
	}

	public void setResponseFormat(String responseFormat) {
		this.responseFormat = responseFormat;
	}

	@Override
	public String toString() {
		return "ProviderList [id=" + id + ", providerName=" + providerName + ", providerUrl=" + providerUrl
				+ ", responseType=" + responseType + ", responseFormat=" + responseFormat + "]";
	}
	
	
	

}
