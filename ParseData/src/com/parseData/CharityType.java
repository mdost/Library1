package com.parseData;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)
public class CharityType{
	private String type;
	private GiveAPI error;

	@JsonProperty("type")
	public void setType(String type){
		this.type = type;
	}
	
	public void setError(GiveAPI value){
		this.error= value;
	}
	
	public GiveAPI getError(){
		return error;
	}
	
	public String getType(){
		return type;
	}
}