package com.parseData;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)
public class GiveAPI{
	private String status_code;
	private String status_code_description;
	
//	@JsonIgnoreProperties("data")
//	public String data;
	
	//setters
	@JsonProperty("status-code")
	public void setstatus_code(String value){
		this.status_code = value;
	}
	
	@JsonProperty("status-code-description")
	public void setStatus_code_description(String value){
		this.status_code_description = value;
	}
	
	//getters
	public String getStatus_code(){
		return status_code;
	}
	
	public String getStatus_code_description(){
		return status_code_description;
	}
}